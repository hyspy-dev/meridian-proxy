package meridian.proxy.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Manages the lifecycle of the actual Hytale server subprocess.
 * Handles stdout/stderr redirection and synchronization with the proxy.
 */
public class LauncherBridge {
    private static final Logger log = LoggerFactory.getLogger(LauncherBridge.class);

    private final ProxyConfig config;
    private final CountDownLatch readyLatch = new CountDownLatch(1);

    public LauncherBridge(ProxyConfig config) {
        this.config = config;
    }

    /**
     * Launches the backend server and blocks until it signals readiness.
     * @throws Exception if launch fails.
     */
    public void launchAndWait() throws Exception {
        log.info("Preparing to launch backend: {}", config.backendJarPath());

        List<String> cmd = new ArrayList<>();
        cmd.add("java");
        cmd.add("-jar");
        cmd.add(config.backendJarPath());

        // Map arguments
        String[] args = config.originalArgs();
        int targetPort = config.remotePort();
        boolean bindSet = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--bind")) {
                cmd.add("--bind");
                cmd.add("127.0.0.1:" + targetPort);
                bindSet = true;
                i++;
            } else if (args[i].startsWith("--bind=")) {
                cmd.add("--bind=127.0.0.1:" + targetPort);
                bindSet = true;
            } else {
                cmd.add(args[i]);
            }
        }
        if (!bindSet) {
            cmd.add("--bind");
            cmd.add("127.0.0.1:" + targetPort);
        }

        log.info("Command: {}", String.join(" ", cmd));
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);
        
        Process p = pb.start();
        
        // Ensure subprocess is killed when we exit
        Runtime.getRuntime().addShutdownHook(new Thread(p::destroy));

        // Start log gobbler & synchronization thread
        Thread gobbler = new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(ProxyConfig.READY_SIGNAL)) {
                        log.info("Backend signaled READY!");
                        readyLatch.countDown();
                    } else if (!line.startsWith("Listening on /") && !line.startsWith("-=|Enabled|")) {
                        System.out.println(line); // Forward to stdout for launcher/user visibility
                    }
                }
            } catch (Exception e) {
                log.error("Error reading backend output", e);
                readyLatch.countDown(); // Prevent hang on IO error
            }
        }, "BackendLogGobbler");
        gobbler.setDaemon(true);
        gobbler.start();

        log.info("Waiting for signal: '{}'", ProxyConfig.READY_SIGNAL);
        if (!readyLatch.await(60, TimeUnit.SECONDS)) {
            log.warn("Timeout waiting for backend signal. Proceeding anyway...");
        } else {
            log.info("Backend is fully initialized.");
        }
    }
}
