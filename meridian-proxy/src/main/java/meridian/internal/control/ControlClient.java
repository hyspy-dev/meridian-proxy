package meridian.internal.control;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import meridian.internal.core.ProxyConfig;

/**
 * The command line for {@link ControlServer}: {@code java -jar meridian-proxy.jar --cmd "<command>"
 * [--cmd "<command>" ...] [--for <seconds>] [--port <port>]}.
 *
 * <p>Finds the running proxy by the files it leaves in {@code <jar dir>/control/} (the newest one
 * whose process is alive, or the one for {@code --port}), sends the commands in order on one
 * connection, and prints every answer line as it comes. It stays until each command has had its
 * last answer, or {@code --for} seconds have passed - which is how a {@code watch} is ended. Exits
 * 1 when any answer was an error.
 */
public final class ControlClient {

    private ControlClient() {
    }

    /** Whether the command line asks for this rather than a proxy. */
    public static boolean requested(String[] args) {
        for (String a : args) {
            if (a.equals("--cmd")) {
                return true;
            }
        }
        return false;
    }

    public static int run(String[] args) {
        List<String> commands = new ArrayList<>();
        Integer port = null;
        double forSeconds = -1;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--cmd" -> commands.add(args[++i]);
                case "--port" -> port = Integer.parseInt(args[++i]);
                case "--for" -> forSeconds = Double.parseDouble(args[++i]);
                default -> {
                    // other proxy flags are not ours; ignore
                }
            }
        }
        JsonObject where;
        try {
            where = find(port);
        } catch (IOException e) {
            System.err.println("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
            return 2;
        }
        if (where == null) {
            System.err.println("{\"error\":\"no running proxy found in " + controlDir().toString().replace('\\', '/')
                    + (port != null ? " on port " + port : "") + "\"}");
            return 2;
        }
        int p = where.get("port").getAsInt();
        String token = where.get("token").getAsString();
        boolean anyError = false;
        try (Socket s = new Socket(InetAddress.getLoopbackAddress(), p);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true, StandardCharsets.UTF_8)) {
            out.println("HELLO " + token);
            String hello = in.readLine();
            if (hello == null || !hello.contains("\"hello\"")) {
                System.out.println(hello);
                return 1;
            }
            for (String c : commands) {
                out.println(c);
            }
            Set<Integer> open = new HashSet<>();
            for (int i = 1; i <= commands.size(); i++) {
                open.add(i);
            }
            long deadline = forSeconds < 0 ? Long.MAX_VALUE : System.currentTimeMillis() + (long) (forSeconds * 1000);
            // Lines are read whole on a thread of their own; waiting here with a timeout instead
            // of on the socket keeps a long line from being cut where the timeout fell.
            java.util.concurrent.BlockingQueue<String> lines = new java.util.concurrent.LinkedBlockingQueue<>();
            String eof = new String("eof");
            Thread reader = new Thread(() -> {
                try {
                    String l;
                    while ((l = in.readLine()) != null) {
                        lines.add(l);
                    }
                } catch (IOException ignored) {
                    // closed under us at the end
                }
                lines.add(eof);
            }, "ControlClientReader");
            reader.setDaemon(true);
            reader.start();
            while (!open.isEmpty() && System.currentTimeMillis() < deadline) {
                String line;
                try {
                    line = lines.poll(200, java.util.concurrent.TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    break;
                }
                if (line == null) {
                    continue;
                }
                if (line == eof) {
                    break;
                }
                System.out.println(line);
                System.out.flush();
                try {
                    JsonObject o = JsonParser.parseString(line).getAsJsonObject();
                    if (o.has("error")) {
                        anyError = true;
                    }
                    if (o.has("cmd") && o.has("end") && o.get("end").getAsBoolean()) {
                        open.remove(o.get("cmd").getAsInt());
                    }
                } catch (RuntimeException notJson) {
                    // printed as it came
                }
            }
        } catch (IOException e) {
            System.err.println("{\"error\":\"" + e.toString().replace("\"", "'") + "\"}");
            return 2;
        }
        return anyError ? 1 : 0;
    }

    private static Path controlDir() {
        return ProxyConfig.jarDir().resolve("control");
    }

    /** The control file to use: {@code port}'s, or the newest one whose proxy is still running. */
    private static JsonObject find(Integer port) throws IOException {
        Path dir = controlDir();
        if (!Files.isDirectory(dir)) {
            return null;
        }
        JsonObject best = null;
        long bestTime = Long.MIN_VALUE;
        try (Stream<Path> files = Files.list(dir)) {
            for (Path f : files.filter(x -> x.toString().endsWith(".json")).toList()) {
                JsonObject o;
                try {
                    o = JsonParser.parseString(Files.readString(f, StandardCharsets.UTF_8)).getAsJsonObject();
                } catch (RuntimeException | IOException bad) {
                    continue;
                }
                long pid = o.has("pid") ? o.get("pid").getAsLong() : -1;
                if (ProcessHandle.of(pid).map(ProcessHandle::isAlive).orElse(false) == Boolean.FALSE) {
                    Files.deleteIfExists(f);             // left behind by a proxy that did not exit cleanly
                    continue;
                }
                if (port != null) {
                    if (o.get("port").getAsInt() == port) {
                        return o;
                    }
                    continue;
                }
                long t = Files.getLastModifiedTime(f).toMillis();
                if (t > bestTime) {
                    bestTime = t;
                    best = o;
                }
            }
        }
        return best;
    }
}
