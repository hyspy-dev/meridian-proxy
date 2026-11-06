package meridian.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import meridian.internal.auth.LauncherSessionMinter;
import meridian.internal.core.ProxyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A single-player world played through the proxy.
 *
 * <p>The Hytale client starts a world's local server with the java it was given as {@code
 * --java-exec}. The Meridian launcher gives it a small script instead, which runs this:
 *
 * <pre>
 * java -jar meridian-proxy.jar --singleplayer-wrap --real-java &lt;the game's java&gt; -- &lt;what the client asked for&gt;
 * </pre>
 *
 * where the client's command is {@code <jvm flags> -jar HytaleServer.jar <server args>}. The
 * server args carry {@code --bind localhost:<port>} - the port the client will connect to. We
 * take that port ourselves, move the server to a free one, start it with the real java and every
 * flag the client chose, and stand between the two like any other proxy.
 *
 * <p>The client reads the server's output to follow the boot and waits for {@code >> Singleplayer
 * Ready <<} before connecting, so everything the server prints is passed on - except that line,
 * held back until we are listening, and the server's own "listening" lines, which name the moved
 * port. The server's stdin and stderr are the client's. When the server exits, so do we, with its
 * code; the server already exits with the client ({@code --client-pid}).
 *
 * <p>With the launcher's proxy running, this process does no proxying itself: it asks that proxy
 * ({@link SingleplayerControl}, found through the environment) to listen on the client's port
 * and relay to the moved server, and the world plays in the window already open. Without one it
 * stands in front of the server itself.
 */
public final class SingleplayerWrap {

    private static final Logger log = LoggerFactory.getLogger(SingleplayerWrap.class);

    /** How long a world may take to boot before we connect the client anyway. */
    private static final long BOOT_TIMEOUT_MIN = 10;

    private SingleplayerWrap() {
    }

    public static boolean requested(String[] args) {
        return Arrays.asList(args).contains("--singleplayer-wrap");
    }

    /** The parts of the client's command, and what we change in it. */
    record Plan(String realJava, List<String> jvmFlags, String serverJar, List<String> serverArgs,
                int clientPort) {

        /** The server's command with its port moved to {@code serverPort}. */
        List<String> serverCommand(int serverPort) {
            List<String> cmd = new ArrayList<>();
            cmd.add(realJava);
            cmd.addAll(jvmFlags);
            cmd.add("-jar");
            cmd.add(serverJar);
            boolean bound = false;
            for (int i = 0; i < serverArgs.size(); i++) {
                String a = serverArgs.get(i);
                if (a.equals("--bind") && i + 1 < serverArgs.size()) {
                    cmd.add("--bind");
                    cmd.add("127.0.0.1:" + serverPort);
                    bound = true;
                    i++;
                } else if (a.startsWith("--bind=")) {
                    cmd.add("--bind=127.0.0.1:" + serverPort);
                    bound = true;
                } else {
                    cmd.add(a);
                }
            }
            if (!bound) {
                cmd.add("--bind");
                cmd.add("127.0.0.1:" + serverPort);
            }
            return cmd;
        }
    }

    /**
     * Reads {@code --real-java <path> -- <jvm flags> -jar <server jar> <server args>}.
     *
     * @throws IllegalArgumentException when a part is missing
     */
    static Plan parse(String[] args) {
        String realJava = null;
        int dash = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--real-java") && i + 1 < args.length) {
                realJava = args[++i];
            } else if (args[i].equals("--")) {
                dash = i;
                break;
            }
        }
        if (realJava == null || dash < 0) {
            throw new IllegalArgumentException("expected --real-java <java> -- <client command>");
        }
        List<String> rest = Arrays.asList(args).subList(dash + 1, args.length);
        int jar = rest.indexOf("-jar");
        if (jar < 0 || jar + 1 >= rest.size()) {
            throw new IllegalArgumentException("no -jar <server jar> in " + rest);
        }
        List<String> serverArgs = rest.subList(jar + 2, rest.size());
        int port = -1;
        for (int i = 0; i < serverArgs.size(); i++) {
            String a = serverArgs.get(i);
            String bind = a.equals("--bind") && i + 1 < serverArgs.size() ? serverArgs.get(i + 1)
                    : a.startsWith("--bind=") ? a.substring("--bind=".length()) : null;
            if (bind != null) {
                port = Integer.parseInt(bind.substring(bind.lastIndexOf(':') + 1).trim());
            }
        }
        if (port <= 0) {
            throw new IllegalArgumentException("no --bind <host:port> in the server args " + serverArgs);
        }
        return new Plan(realJava, List.copyOf(rest.subList(0, jar)), rest.get(jar + 1),
                List.copyOf(serverArgs), port);
    }

    /** Whether a line of the server's output is passed on to the client. */
    static boolean passOn(String line) {
        return !line.contains(ProxyConfig.READY_SIGNAL)
                && !line.startsWith("Listening on /")
                && !line.startsWith("-=|Enabled|");
    }

    public static void run(String[] args, boolean showGui) throws Exception {
        Plan plan = parse(args);
        int serverPort = freeUdpPort();
        List<String> cmd = plan.serverCommand(serverPort);
        log.info("Single-player world through the proxy: client port {} -> server port {}",
                plan.clientPort(), serverPort);
        log.info("Server command: {}", String.join(" ", cmd));

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        Process server = pb.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (server.isAlive()) {
                server.destroy();
            }
        }, "SingleplayerServerStop"));

        CountDownLatch ready = new CountDownLatch(1);
        Thread pump = new Thread(() -> {
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(server.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.contains(ProxyConfig.READY_SIGNAL)) {
                        log.info("Server is ready.");
                        ready.countDown();
                    } else if (passOn(line)) {
                        System.out.println(line);
                    }
                }
            } catch (Exception e) {
                log.warn("Reading the server's output failed: {}", e.toString());
            } finally {
                ready.countDown();
            }
        }, "SingleplayerServerOutput");
        pump.setDaemon(true);
        pump.start();

        // The server ends the session: when it goes, we go, with its exit code.
        Thread watch = new Thread(() -> {
            try {
                int code = server.waitFor();
                log.info("Server exited ({}); closing the proxy.", code);
                System.out.flush();
                Runtime.getRuntime().halt(code);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }, "SingleplayerServerWatch");
        watch.setDaemon(true);
        watch.start();

        if (!ready.await(BOOT_TIMEOUT_MIN, TimeUnit.MINUTES)) {
            log.warn("No ready signal from the server in {} min - listening anyway.", BOOT_TIMEOUT_MIN);
        }
        if (!server.isAlive()) {
            return;     // the watcher is on its way out with the server's code
        }

        String control = System.getenv(SingleplayerControl.ENV_ADDRESS);
        String secret = System.getenv(SingleplayerControl.ENV_SECRET);
        if (control != null && secret != null) {
            try {
                joinRunningProxy(control, secret, plan.clientPort(), serverPort);
                server.waitFor();   // the watcher exits with its code; the route goes with our socket
                return;
            } catch (Exception e) {
                log.warn("Could not hand the world to the launcher's proxy ({}) - standing in front of it here.",
                        e.toString());
            }
        }

        ProxyConfig config = ProxyConfig.forSingleplayer(plan.clientPort(), serverPort, args, showGui);
        if (config.clientToken() != null && (config.serverToken() == null || config.identityToken() == null)) {
            log.info("Server tokens not in the environment - deriving them from the player session");
            LauncherSessionMinter.ServerTokens t = new LauncherSessionMinter().deriveServerTokens(config.clientToken());
            config = config.withServerTokens(t.sessionToken(), t.identityToken());
        }
        // Prints the ready line itself once it listens; the client connects then.
        new ConnectionScope(config, false).run();

        // The client left. The server shuts its world down on its own; give it the time to save.
        if (!server.waitFor(2, TimeUnit.MINUTES)) {
            log.warn("Server still running after the client left - stopping it.");
            server.destroy();
            server.waitFor(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Hands the world to the proxy the launcher runs: it listens on the client's port and relays to
     * the server's, with the tokens the game gave its server. Only then is the client told the
     * server is ready. The socket stays open for as long as this process lives - closing it is how
     * the proxy learns the world is over.
     */
    private static void joinRunningProxy(String control, String secret, int clientPort, int serverPort)
            throws Exception {
        int colon = control.lastIndexOf(':');
        java.net.Socket s = new java.net.Socket(java.net.InetAddress.getLoopbackAddress(),
                Integer.parseInt(control.substring(colon + 1).trim()));
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
        java.io.PrintWriter out = new java.io.PrintWriter(s.getOutputStream(), true, StandardCharsets.UTF_8);
        out.println("HELLO " + secret);
        String hello = in.readLine();
        if (!"OK".equals(hello)) {
            throw new IllegalStateException("the launcher's proxy refused us: " + hello);
        }
        out.println("OPEN " + clientPort + " " + serverPort
                + " " + orDash(System.getenv("HYTALE_SESSION_TOKEN"))
                + " " + orDash(System.getenv("HYTALE_SERVER_SESSION_TOKEN"))
                + " " + orDash(System.getenv("HYTALE_SERVER_IDENTITY_TOKEN")));
        String opened = in.readLine();
        if (!"OK".equals(opened)) {
            throw new IllegalStateException("the launcher's proxy could not take the world: " + opened);
        }
        log.info("World handed to the launcher's proxy on :{}.", clientPort);
        System.out.println(ProxyConfig.READY_SIGNAL);
        System.out.flush();
        // Kept referenced (and open) until the process ends.
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                s.close();
            } catch (Exception ignored) {
            }
        }, "SingleplayerControlClose"));
    }

    private static String orDash(String v) {
        return v == null || v.isBlank() ? "-" : v;
    }

    /** A UDP port nobody holds right now, on the loopback address the server will bind. */
    static int freeUdpPort() throws Exception {
        try (DatagramSocket s = new DatagramSocket(0, InetAddress.getLoopbackAddress())) {
            return s.getLocalPort();
        }
    }
}
