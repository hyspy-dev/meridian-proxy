package meridian.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Where single-player worlds join the multiplex proxy the launcher started.
 *
 * <p>The game starts a world's server through the launcher's {@code --java-exec} script, which
 * runs {@link SingleplayerWrap} - a separate process, the game's child, with no way to the
 * launcher's stdin pipe. It reaches us here instead: a TCP port on the loopback address only,
 * whose number the launcher chose and passed to both of us, and a secret it passed the same way.
 *
 * <p>One line per message:
 *
 * <pre>
 * HELLO &lt;secret&gt;                                                   -> OK | ERR
 * OPEN &lt;client port&gt; &lt;server port&gt; &lt;player&gt; &lt;server session&gt; &lt;server identity&gt;  -> OK | ERR
 * </pre>
 *
 * {@code OK} to {@code OPEN} means we are listening on the client's port. The tokens are the ones
 * the game handed its server, so towards the game we are exactly the server it started ({@code -}
 * for one it did not give). The connection stays open while the world runs; when it closes - the
 * server stopped, or the wrapper died - the routes opened on it go.
 */
final class SingleplayerControl {

    private static final Logger log = LoggerFactory.getLogger(SingleplayerControl.class);

    /** The environment variable the launcher passes the secret in, to us and to the game. */
    static final String ENV_SECRET = "MERIDIAN_SP_SECRET";
    /** The environment variable the game's script finds us at, {@code 127.0.0.1:<port>}. */
    static final String ENV_ADDRESS = "MERIDIAN_SP_CONTROL";

    /** What the multiplex does for us. */
    interface Routes {
        boolean open(int clientPort, int serverPort, String player, String serverSession, String serverIdentity);

        void close(int clientPort);
    }

    private final int port;
    private final byte[] secret;
    private final Routes routes;

    SingleplayerControl(int port, String secret, Routes routes) {
        this.port = port;
        this.secret = secret.getBytes(StandardCharsets.UTF_8);
        this.routes = routes;
    }

    /** Listens in the background; a failure to bind is logged, and single-player is then off. */
    void start() {
        Thread t = new Thread(this::serve, "SingleplayerControl");
        t.setDaemon(true);
        t.start();
    }

    private void serve() {
        try (ServerSocket server = new ServerSocket(port, 8, InetAddress.getLoopbackAddress())) {
            log.info("Single-player worlds join on 127.0.0.1:{}", port);
            while (true) {
                Socket s = server.accept();
                Thread.ofVirtual().name("SingleplayerWorld").start(() -> handle(s));
            }
        } catch (Exception e) {
            log.warn("Single-player control port {} unavailable - worlds will not reach this proxy: {}",
                    port, e.toString());
        }
    }

    private void handle(Socket s) {
        List<Integer> opened = new ArrayList<>();
        try (s; BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true, StandardCharsets.UTF_8)) {
            String hello = in.readLine();
            if (hello == null || !hello.startsWith("HELLO ")
                    || !MessageDigest.isEqual(secret, hello.substring(6).trim().getBytes(StandardCharsets.UTF_8))) {
                out.println("ERR who are you");
                return;
            }
            out.println("OK");
            String line;
            while ((line = in.readLine()) != null) {
                String[] p = line.trim().split("\\s+");
                if (p.length == 6 && p[0].equals("OPEN")) {
                    int clientPort = Integer.parseInt(p[1]);
                    int serverPort = Integer.parseInt(p[2]);
                    boolean ok = routes.open(clientPort, serverPort, dash(p[3]), dash(p[4]), dash(p[5]));
                    if (ok) {
                        opened.add(clientPort);
                    }
                    out.println(ok ? "OK" : "ERR could not listen on " + clientPort);
                } else {
                    out.println("ERR unknown");
                }
            }
        } catch (Exception e) {
            log.info("Single-player world connection ended: {}", e.toString());
        } finally {
            for (int clientPort : opened) {
                routes.close(clientPort);
            }
        }
    }

    private static String dash(String v) {
        return v.equals("-") ? null : v;
    }
}
