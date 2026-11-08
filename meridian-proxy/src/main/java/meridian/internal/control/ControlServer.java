package meridian.internal.control;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import meridian.api.packet.Direction;
import meridian.internal.Version;
import meridian.internal.core.ProxyConfig;
import meridian.internal.core.ProxySessionImpl;
import meridian.protocol.Packet;
import meridian.protocol.PacketRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The proxy's command channel: a TCP port on the loopback address, with a token, for anything
 * outside the game that has something to say to the running proxy - a single-player world joining
 * (see {@code SingleplayerWrap}), or a person or a script looking at and sending packets on a live
 * connection ({@link ControlClient} is the command line for it).
 *
 * <p>The port is the number the proxy's own UDP listener has (multiplex: the launcher's base port),
 * so nothing new needs remembering; TCP and UDP of one number do not collide. Where it ended up and
 * the token are written to {@code <jar dir>/control/<port>.json} for local tools, and the launcher
 * may pass the token in {@value #ENV_TOKEN}. The first line of a connection is {@code HELLO <token>};
 * nothing else is answered before it.
 *
 * <p>After that, one command a line; every answer is a JSON line carrying the number of the command
 * it answers ({@code "cmd"}, counting from 1), and the last one for a command says {@code "end":true}.
 * {@code watch} has no last answer - it streams until the connection closes or {@code stop}.
 */
public final class ControlServer {

    private static final Logger log = LoggerFactory.getLogger(ControlServer.class);

    /** The token, when the one who started us chose it (the launcher does, for its game's scripts). */
    public static final String ENV_TOKEN = "MERIDIAN_CONTROL_TOKEN";
    /** Where a single-player world's wrapper finds us, {@code 127.0.0.1:<port>}. */
    public static final String ENV_ADDRESS = "MERIDIAN_CONTROL";

    /** What the multiplex proxy does for a single-player world (see {@code SingleplayerWrap}). */
    public interface WorldRoutes {
        boolean open(int clientPort, int serverPort, String player, String serverSession, String serverIdentity);

        void close(int clientPort);
    }

    private static volatile WorldRoutes worldRoutes;
    /** Headless connections opened over the channel, by connection number. */
    private static final Map<Integer, meridian.internal.HeadlessConnection> HEADLESS = new ConcurrentHashMap<>();
    private static final ScheduledExecutorService TIMERS = Executors.newSingleThreadScheduledExecutor(r -> {
        Thread t = new Thread(r, "ControlTimers");
        t.setDaemon(true);
        return t;
    });

    private final int wantedPort;
    private final byte[] token;
    private final String mode;
    private volatile int port = -1;
    private volatile Path file;

    private ControlServer(int wantedPort, String token, String mode) {
        this.wantedPort = wantedPort;
        this.token = token.getBytes(StandardCharsets.UTF_8);
        this.mode = mode;
    }

    /** Lets the multiplex proxy take single-player worlds; until then {@code open} is refused. */
    public static void setWorldRoutes(WorldRoutes routes) {
        worldRoutes = routes;
    }

    /**
     * Starts the channel in the background on {@code wantedPort}, or on a free port when that one
     * is taken. The token comes from {@value #ENV_TOKEN}, else is made up here.
     */
    public static ControlServer start(int wantedPort, String mode) {
        String t = System.getenv(ENV_TOKEN);
        if (t == null || t.isBlank()) {
            t = System.getenv("MERIDIAN_SP_SECRET");     // what the launcher before 1.0.9 passes
        }
        if (t == null || t.isBlank()) {
            byte[] b = new byte[24];
            new SecureRandom().nextBytes(b);
            t = HexFormat.of().formatHex(b);
        }
        ControlServer server = new ControlServer(wantedPort, t.trim(), mode);
        Thread th = new Thread(server::serve, "ControlServer");
        th.setDaemon(true);
        th.start();
        return server;
    }

    private void serve() {
        ServerSocket server;
        try {
            server = new ServerSocket(wantedPort, 16, InetAddress.getLoopbackAddress());
        } catch (IOException taken) {
            try {
                server = new ServerSocket(0, 16, InetAddress.getLoopbackAddress());
                log.warn("Control port {} is taken ({}); using {} instead.", wantedPort, taken.getMessage(),
                        server.getLocalPort());
            } catch (IOException e) {
                log.warn("Control channel unavailable: {}", e.toString());
                return;
            }
        }
        port = server.getLocalPort();
        writeFile();
        log.info("Control channel on 127.0.0.1:{} (token in {})", port, file);
        try (ServerSocket s = server) {
            while (true) {
                Socket c = s.accept();
                Thread.ofVirtual().name("ControlConnection").start(() -> new Connection(c).run());
            }
        } catch (IOException e) {
            log.warn("Control channel stopped: {}", e.toString());
        }
    }

    /** {@code <jar dir>/control/<port>.json}: where we are, the token, whose process. Removed on exit. */
    private void writeFile() {
        try {
            Path dir = ProxyConfig.jarDir().resolve("control");
            Files.createDirectories(dir);
            Path f = dir.resolve(port + ".json");
            JsonObject o = new JsonObject();
            o.addProperty("port", port);
            o.addProperty("token", new String(token, StandardCharsets.UTF_8));
            o.addProperty("pid", ProcessHandle.current().pid());
            o.addProperty("mode", mode);
            o.addProperty("version", Version.VERSION);
            o.addProperty("started", java.time.Instant.now().toString());
            Files.writeString(f, o.toString(), StandardCharsets.UTF_8);
            file = f;
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    Files.deleteIfExists(f);
                } catch (IOException ignored) {
                }
            }, "ControlFileCleanup"));
        } catch (IOException e) {
            log.warn("Could not write the control file: {}", e.toString());
        }
    }

    // ------------------------------------------------------------------
    // One client of the channel
    // ------------------------------------------------------------------

    private final class Connection {
        private final Socket socket;
        private PrintWriter out;
        private final AtomicBoolean open = new AtomicBoolean(true);
        /**
         * Answers waiting to be written. Taps answer from the game's own threads, which must never
         * wait on a slow reader, so they only queue; one writer drains. A reader too slow to keep
         * up loses lines rather than the game stalling - and is told how many.
         */
        private final java.util.concurrent.BlockingQueue<String> pending =
                new java.util.concurrent.LinkedBlockingQueue<>(20_000);
        private final java.util.concurrent.atomic.AtomicLong lost = new java.util.concurrent.atomic.AtomicLong();
        private int nextCmd = 1;
        /** Taps this connection put up, by command number - taken down with it. */
        private final Map<Integer, PacketTap.Listener> taps = new ConcurrentHashMap<>();
        /** Single-player worlds opened over this connection - closed with it. */
        private final List<Integer> worlds = new ArrayList<>();

        Connection(Socket socket) {
            this.socket = socket;
        }

        void run() {
            Thread writer = null;
            // Not closed by itself: closing a socket's stream closes the socket, and the last
            // answers still have to go out through it (see finally).
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                out = new PrintWriter(socket.getOutputStream(), true, StandardCharsets.UTF_8);
                writer = Thread.ofVirtual().name("ControlWriter").start(this::drain);
                String hello = in.readLine();
                if (hello == null || !hello.startsWith("HELLO ")
                        || !MessageDigest.isEqual(token, hello.substring(6).trim().getBytes(StandardCharsets.UTF_8))) {
                    JsonObject no = new JsonObject();
                    no.addProperty("error", "who are you");
                    send(no);
                    return;
                }
                JsonObject ok = new JsonObject();
                ok.addProperty("hello", "ok");
                ok.addProperty("version", Version.VERSION);
                send(ok);
                String line;
                while ((line = in.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty() || line.startsWith("#")) {
                        continue;
                    }
                    int cmd = nextCmd++;
                    try {
                        dispatch(cmd, line);
                    } catch (RuntimeException e) {
                        error(cmd, e.getClass().getSimpleName() + ": " + e.getMessage());
                    }
                }
            } catch (IOException e) {
                // the other end went away; same as a close
            } finally {
                open.set(false);
                taps.values().forEach(PacketTap::remove);
                taps.clear();
                pending.offer("");                      // wakes the writer so it can finish
                if (writer != null) {
                    try {
                        writer.join(2000);              // the last answers go out before the close
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                try {
                    socket.close();
                } catch (IOException ignored) {
                }
                WorldRoutes routes = worldRoutes;
                if (routes != null) {
                    for (int clientPort : worlds) {
                        routes.close(clientPort);
                    }
                }
            }
        }

        private void send(JsonObject o) {
            if (!pending.offer(o.toString())) {
                lost.incrementAndGet();
            }
        }

        /** Writes queued answers until the connection is done and the queue empty. */
        private void drain() {
            try {
                while (open.get() || !pending.isEmpty()) {
                    String line = pending.poll(1, TimeUnit.SECONDS);
                    if (line == null || line.isEmpty()) {
                        continue;
                    }
                    long dropped = lost.getAndSet(0);
                    if (dropped > 0) {
                        out.println("{\"lost\":" + dropped + "}");
                    }
                    out.println(line);
                }
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }

        private JsonObject reply(int cmd) {
            JsonObject o = new JsonObject();
            o.addProperty("cmd", cmd);
            return o;
        }

        private void end(JsonObject o) {
            o.addProperty("end", true);
            send(o);
        }

        private void error(int cmd, String message) {
            JsonObject o = reply(cmd);
            o.addProperty("error", message);
            end(o);
        }

        private void dispatch(int cmd, String line) {
            String json = null;
            int brace = line.indexOf('{');
            String head = brace < 0 ? line : line.substring(0, brace);
            if (brace >= 0) {
                json = line.substring(brace);
            }
            String[] p = head.trim().split("\\s+");
            switch (p[0].toLowerCase(Locale.ROOT)) {
                case "help" -> {
                    if (p.length > 1) {
                        help(cmd, p[1]);
                    } else {
                        help(cmd);
                    }
                }
                case "sessions" -> sessions(cmd);
                case "packets" -> packets(cmd, p.length > 1 ? p[1] : null);
                case "send" -> send(cmd, p, json);
                case "watch" -> watch(cmd, p);
                case "expect" -> expect(cmd, p, json);
                case "stop" -> stop(cmd, p);
                case "open" -> openWorld(cmd, p);
                case "headless" -> headless(cmd, p);
                default -> moduleCommand(cmd, p, json);
            }
        }

        // -------------------------------------------------------------- commands

        /** {@code <name> <conn> <args...>}: a command a module of that connection's runtime offers. */
        private void moduleCommand(int cmd, String[] p, String json) {
            LiveConnections.Live live = p.length > 1 ? LiveConnections.pick(p[1]) : null;
            meridian.internal.module.CommandRegistry registry = live == null ? null : live.commands;
            meridian.internal.module.CommandRegistry.Entry entry = registry == null ? null : registry.get(p[0]);
            if (entry == null) {
                error(cmd, "unknown command '" + p[0] + "'" + (live == null ? "" : " for connection " + live.id)
                        + " - try help, or help <conn> for its modules' commands");
                return;
            }
            java.util.List<String> args = java.util.List.of(p).subList(2, p.length);
            java.util.concurrent.CompletableFuture<?> future;
            try {
                future = entry.command().run(args, json);
            } catch (Exception e) {
                error(cmd, entry.name() + ": " + e);
                return;
            }
            if (future == null) {
                future = java.util.concurrent.CompletableFuture.completedFuture(null);
            }
            future.whenComplete((result, err) -> {
                JsonObject o = reply(cmd);
                if (err != null) {
                    Throwable cause = err instanceof java.util.concurrent.CompletionException && err.getCause() != null
                            ? err.getCause() : err;
                    o.addProperty("error", entry.name() + ": " + cause.getMessage());
                } else if (result != null) {
                    o.add("result", PacketJson.GSON.toJsonTree(result));
                }
                end(o);
            });
        }

        private void help(int cmd, String conn) {
            LiveConnections.Live live = LiveConnections.pick(conn);
            JsonObject o = reply(cmd);
            JsonArray a = new JsonArray();
            if (live != null && live.commands != null) {
                for (meridian.internal.module.CommandRegistry.Entry e : live.commands.all()) {
                    a.add(e.name() + " " + live.id + " " + e.usage() + "   (" + e.module() + ")");
                }
            }
            o.add("commands", a);
            end(o);
        }

        private void help(int cmd) {
            JsonObject o = reply(cmd);
            JsonArray a = new JsonArray();
            a.add("sessions                                   - live game connections, numbered");
            a.add("packets [part-of-name]                     - packet names, ids, channels, directions");
            a.add("send <conn|-> <c2s|s2c> <Packet> [json]    - send a packet on a connection (- = the only one)");
            a.add("watch [conn|*] [c2s|s2c|both] [A,B|*] [full] - stream packets as they pass; full = uncut");
            a.add("expect <conn|-> <c2s|s2c> <Packet> [secs] [json] - wait for the next packet that has these fields");
            a.add("stop <cmd>                                 - end a watch or an expect of this connection");
            a.add("open <clientPort> <serverPort> <player> <serverSession> <serverIdentity> - a single-player world");
            a.add("headless connect <host:port> [name] [insecure | auth <session> <identity>] - join a server with no game");
            a.add("headless close <conn>                      - leave it");
            a.add("headless list                              - the headless connections");
            a.add("help <conn>                                - commands the modules of a connection offer");
            a.add("<command> <conn> <args...> [json]          - one of those"); 
            o.add("commands", a);
            end(o);
        }

        private void sessions(int cmd) {
            JsonObject o = reply(cmd);
            JsonArray a = new JsonArray();
            for (LiveConnections.Live live : LiveConnections.all()) {
                a.add(live.describe());
            }
            o.add("sessions", a);
            end(o);
        }

        private void packets(int cmd, String filter) {
            JsonObject o = reply(cmd);
            JsonArray a = new JsonArray();
            PacketJson.catalog(filter).forEach(a::add);
            o.add("packets", a);
            end(o);
        }

        private void send(int cmd, String[] p, String json) {
            if (p.length < 4) {
                error(cmd, "send <conn|-> <c2s|s2c> <Packet> [json]");
                return;
            }
            LiveConnections.Live live = LiveConnections.pick(p[1]);
            if (live == null) {
                error(cmd, "no such connection '" + p[1] + "' - see sessions");
                return;
            }
            Boolean toServer = toServer(p[2]);
            if (toServer == null) {
                error(cmd, "direction is c2s or s2c, not '" + p[2] + "'");
                return;
            }
            PacketRegistry.PacketInfo info = PacketJson.find(p[3], toServer);
            if (info == null) {
                error(cmd, "no " + p[2] + " packet '" + p[3] + "' - see packets");
                return;
            }
            Packet packet = PacketJson.fromJson(info, json);
            ProxySessionImpl session = live.sessionFor(info.channel());
            if (session == null) {
                error(cmd, "connection " + live.id + " has no stream yet");
                return;
            }
            if (toServer) {
                session.sendToServer(packet);
            } else {
                session.sendToClient(packet);
            }
            JsonObject o = reply(cmd);
            o.addProperty("sent", info.name());
            o.addProperty("conn", live.id);
            o.add("packet", PacketJson.toShortTree(packet));
            end(o);
        }

        private void watch(int cmd, String[] p) {
            String conn = p.length > 1 ? p[1] : "*";
            Direction only = p.length > 2 ? direction(p[2]) : null;
            Set<String> names = p.length > 3 ? names(p[3]) : null;
            boolean full = p.length > 4 && p[4].equalsIgnoreCase("full");
            Integer connId = conn.equals("*") || conn.equals("-") ? null : Integer.valueOf(conn);
            PacketTap.Listener l = (session, dir, id, packet, outcome) -> {
                if (only != null && dir != only) {
                    return;
                }
                LiveConnections.Live live = LiveConnections.of(session);
                if (connId != null && (live == null || live.id != connId)) {
                    return;
                }
                String name = nameOf(dir, id, packet);
                if (names != null && !names.contains(name.toLowerCase(Locale.ROOT))) {
                    return;
                }
                send(event(cmd, live, session, dir, id, name, packet, outcome, full));
            };
            taps.put(cmd, l);
            PacketTap.add(l);
            JsonObject o = reply(cmd);
            o.addProperty("watching", true);
            send(o);
        }

        private void expect(int cmd, String[] p, String json) {
            if (p.length < 4) {
                error(cmd, "expect <conn|-> <c2s|s2c> <Packet> [secs] [json]");
                return;
            }
            LiveConnections.Live live = LiveConnections.pick(p[1]);
            if (live == null) {
                error(cmd, "no such connection '" + p[1] + "' - see sessions");
                return;
            }
            Direction dir = direction(p[2]);
            if (dir == null) {
                error(cmd, "direction is c2s or s2c, not '" + p[2] + "'");
                return;
            }
            PacketRegistry.PacketInfo info = PacketJson.find(p[3], dir == Direction.C2S);
            if (info == null) {
                error(cmd, "no " + p[2] + " packet '" + p[3] + "' - see packets");
                return;
            }
            double secs = p.length > 4 ? Double.parseDouble(p[4]) : 5;
            JsonObject want = json == null ? null : JsonParser.parseString(json).getAsJsonObject();
            AtomicBoolean done = new AtomicBoolean();
            PacketTap.Listener[] self = new PacketTap.Listener[1];
            self[0] = (session, d, id, packet, outcome) -> {
                if (d != dir || id != info.id() || packet == null || done.get()) {
                    return;
                }
                LiveConnections.Live from = LiveConnections.of(session);
                if (from == null || from.id != live.id) {
                    return;
                }
                if (want != null && !contains(PacketJson.toTree(packet), want)) {
                    return;
                }
                if (done.compareAndSet(false, true)) {
                    PacketTap.remove(self[0]);
                    taps.remove(cmd);
                    JsonObject o = event(cmd, live, session, d, id, info.name(), packet, outcome, true);
                    end(o);
                }
            };
            taps.put(cmd, self[0]);
            PacketTap.add(self[0]);
            JsonObject armed = reply(cmd);
            armed.addProperty("expecting", info.name());
            send(armed);
            TIMERS.schedule(() -> {
                if (done.compareAndSet(false, true)) {
                    PacketTap.remove(self[0]);
                    taps.remove(cmd);
                    JsonObject o = reply(cmd);
                    o.addProperty("timeout", info.name());
                    o.addProperty("error", "no " + info.name() + " in " + secs + " s");
                    end(o);
                }
            }, (long) (secs * 1000), TimeUnit.MILLISECONDS);
        }

        private void stop(int cmd, String[] p) {
            if (p.length < 2) {
                error(cmd, "stop <cmd>");
                return;
            }
            int target = Integer.parseInt(p[1]);
            PacketTap.Listener l = taps.remove(target);
            JsonObject o = reply(cmd);
            if (l == null) {
                o.addProperty("error", "command " + target + " is not watching");
            } else {
                PacketTap.remove(l);
                o.addProperty("stopped", target);
            }
            end(o);
        }

        private void openWorld(int cmd, String[] p) {
            WorldRoutes routes = worldRoutes;
            if (routes == null) {
                error(cmd, "this proxy takes no single-player worlds");
                return;
            }
            if (p.length != 6) {
                error(cmd, "open <clientPort> <serverPort> <player> <serverSession> <serverIdentity> (- for none)");
                return;
            }
            int clientPort = Integer.parseInt(p[1]);
            boolean ok = routes.open(clientPort, Integer.parseInt(p[2]), dash(p[3]), dash(p[4]), dash(p[5]));
            if (ok) {
                worlds.add(clientPort);
            }
            JsonObject o = reply(cmd);
            o.addProperty("ok", ok);
            if (!ok) {
                o.addProperty("error", "could not listen on " + clientPort);
            }
            end(o);
        }

        private void headless(int cmd, String[] p) {
            String sub = p.length > 1 ? p[1].toLowerCase(Locale.ROOT) : "list";
            switch (sub) {
                case "connect" -> {
                    if (p.length < 3) {
                        error(cmd, "headless connect <host:port> [name] [insecure]");
                        return;
                    }
                    String target = p[2];
                    int colon = target.lastIndexOf(':');
                    String host = colon < 0 ? target : target.substring(0, colon);
                    int port = colon < 0 ? 5520 : Integer.parseInt(target.substring(colon + 1));
                    String name = p.length > 3 ? p[3] : "MeridianBot";
                    String mode = p.length > 4 ? p[4].toLowerCase(Locale.ROOT) : "insecure";
                    meridian.internal.HeadlessConnection.Auth auth;
                    String session = null;
                    String identity = null;
                    if (mode.equals("insecure")) {
                        auth = meridian.internal.HeadlessConnection.Auth.INSECURE;
                    } else if (mode.equals("auth") && p.length > 6) {
                        // The player's own game session; the name on the server is the profile's.
                        auth = meridian.internal.HeadlessConnection.Auth.AUTHENTICATED;
                        session = p[5];
                        identity = p[6];
                    } else {
                        error(cmd, "headless connect <host:port> <name> insecure | auth <sessionToken> <identityToken>");
                        return;
                    }
                    meridian.internal.HeadlessConnection.connect(host, port, name, auth, session, identity,
                            gone -> HEADLESS.remove(gone.id())).whenComplete((hc, err) -> {
                                JsonObject o = reply(cmd);
                                if (err != null) {
                                    o.addProperty("error", "could not connect: " + err);
                                } else {
                                    HEADLESS.put(hc.id(), hc);
                                    o.addProperty("conn", hc.id());
                                    o.addProperty("headless", hc.describe());
                                }
                                end(o);
                            });
                }
                case "close" -> {
                    meridian.internal.HeadlessConnection hc = p.length > 2 ? HEADLESS.get(Integer.parseInt(p[2])) : null;
                    if (hc == null) {
                        error(cmd, "no headless connection '" + (p.length > 2 ? p[2] : "") + "'");
                        return;
                    }
                    hc.close();
                    JsonObject o = reply(cmd);
                    o.addProperty("closed", hc.id());
                    end(o);
                }
                case "list" -> {
                    JsonObject o = reply(cmd);
                    JsonArray a = new JsonArray();
                    HEADLESS.forEach((id, hc) -> {
                        JsonObject h = new JsonObject();
                        h.addProperty("conn", id);
                        h.addProperty("headless", hc.describe());
                        a.add(h);
                    });
                    o.add("headless", a);
                    end(o);
                }
                default -> error(cmd, "headless connect|close|list");
            }
        }

        // -------------------------------------------------------------- helpers

        private JsonObject event(int cmd, LiveConnections.Live live, ProxySessionImpl session, Direction dir,
                                 int id, String name, Packet packet, PacketTap.Outcome outcome, boolean full) {
            JsonObject o = reply(cmd);
            o.addProperty("t", LocalTime.now().toString());
            if (live != null) {
                o.addProperty("conn", live.id);
                o.addProperty("stream", live.streams.indexOf(session));
            }
            o.addProperty("dir", dir == Direction.C2S ? "c2s" : "s2c");
            o.addProperty("id", id);
            o.addProperty("name", name);
            o.addProperty("outcome", outcome.name().toLowerCase(Locale.ROOT));
            if (packet != null) {
                o.add("packet", full ? PacketJson.toTree(packet) : PacketJson.toShortTree(packet));
            }
            return o;
        }
    }

    // ------------------------------------------------------------------

    private static String nameOf(Direction dir, int id, Packet packet) {
        if (packet != null) {
            return packet.getClass().getSimpleName();
        }
        PacketRegistry.PacketInfo info = dir == Direction.C2S
                ? PacketRegistry.getToServerPacketById(id) : PacketRegistry.getToClientPacketById(id);
        return info != null ? info.name() : "#" + id;
    }

    private static Set<String> names(String list) {
        if (list == null || list.equals("*")) {
            return null;
        }
        Set<String> out = ConcurrentHashMap.newKeySet();
        for (String n : list.split(",")) {
            if (!n.isBlank()) {
                out.add(n.trim().toLowerCase(Locale.ROOT));
            }
        }
        return out;
    }

    private static Boolean toServer(String dir) {
        return switch (dir.toLowerCase(Locale.ROOT)) {
            case "c2s", "server", "up" -> Boolean.TRUE;
            case "s2c", "client", "down" -> Boolean.FALSE;
            default -> null;
        };
    }

    private static Direction direction(String dir) {
        return switch (dir.toLowerCase(Locale.ROOT)) {
            case "c2s", "server", "up" -> Direction.C2S;
            case "s2c", "client", "down" -> Direction.S2C;
            case "both", "*", "-" -> null;
            default -> throw new IllegalArgumentException("direction is c2s, s2c or both, not '" + dir + "'");
        };
    }

    /** Whether {@code have} has every field of {@code want}, recursively; numbers compare by value. */
    static boolean contains(JsonElement have, JsonElement want) {
        if (want == null || want.isJsonNull()) {
            return have == null || have.isJsonNull();
        }
        if (have == null || have.isJsonNull()) {
            return false;
        }
        if (want.isJsonObject()) {
            if (!have.isJsonObject()) {
                return false;
            }
            for (Map.Entry<String, JsonElement> e : want.getAsJsonObject().entrySet()) {
                if (!contains(have.getAsJsonObject().get(e.getKey()), e.getValue())) {
                    return false;
                }
            }
            return true;
        }
        if (want.isJsonArray()) {
            return have.equals(want);
        }
        JsonPrimitive w = want.getAsJsonPrimitive();
        if (!have.isJsonPrimitive()) {
            return false;
        }
        JsonPrimitive h = have.getAsJsonPrimitive();
        if (w.isNumber() && h.isNumber()) {
            return w.getAsDouble() == h.getAsDouble();
        }
        return w.getAsString().equalsIgnoreCase(h.getAsString());
    }

    private static String dash(String v) {
        return v.equals("-") ? null : v;
    }
}
