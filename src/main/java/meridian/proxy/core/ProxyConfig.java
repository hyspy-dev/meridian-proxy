package meridian.proxy.core;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Encapsulates all configuration parameters for the Hytale Proxy.
 */
public record ProxyConfig(
        String remoteHost,
        int remotePort,
        int localPort,
        String clientToken,
        String serverToken,
        String identityToken,
        boolean showGui,
        boolean autoWrap,
        boolean standalone,
        String backendJarPath,
        String[] originalArgs
) {
    public static final String BACKEND_JAR = "_HytaleServer.jar";
    public static final String READY_SIGNAL = ">> Singleplayer Ready <<";
    /** Default local bind port for standalone mode. Matches Hytale's stock server port so
     *  the user can type just "localhost" or "127.0.0.1" in Hytale's Direct Connect UI. */
    public static final int STANDALONE_LOCAL_PORT = 5520;

    /**
     * Prints the "magic" progress bars to stdout for launcher compatibility.
     */
    public static void printLauncherProgress() {
        try {
            for (int i = 1; i <= 100; i++) {
                System.out.println("-=|Setup|" + i + ".0");
                if (i % 20 == 0) Thread.sleep(5);
            }
            for (int i = 1; i <= 100; i++) {
                System.out.println("-=|Starting|" + i + ".0");
                if (i % 20 == 0) Thread.sleep(5);
            }
            System.out.flush();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static ProxyConfig fromArgs(String[] args) {
        String remoteHost = "127.0.0.1";
        int remotePort = 5520;
        int localPort = 5521;
        boolean showGui = true;

        System.out.println("[ProxyConfig] Incoming arguments: " + String.join(" ", args));

        String bindArg = findArg(args, "--bind");
        if (bindArg != null) {
            localPort = parsePort(bindArg);
        }

        // --remote takes priority; otherwise try to derive from world name/DisplayName
        String remoteArg = findArg(args, "--remote");
        if (remoteArg != null) {
            String[] parts = parseHostPort(remoteArg);
            remoteHost = parts[0];
            if (parts[1] != null) {
                try {
                    remotePort = Integer.parseInt(parts[1]);
                } catch (NumberFormatException ignored) {}
            }
        } else {
            String worldName = extractWorldName(findArg(args, "--backup-dir"));
            if (worldName != null && worldName.startsWith("~")) {
                String address = worldName.substring(1).replace("_", ":");
                String[] worldParts = parseHostPort(address);
                remoteHost = worldParts[0];
                if (worldParts[1] != null) {
                    try {
                        remotePort = Integer.parseInt(worldParts[1]);
                    } catch (NumberFormatException ignored) {}
                }
                System.out.println("[ProxyConfig] Remote connection requested via world name: " + remoteHost + ":" + remotePort);
            }
        }

        // GUI and other flags check
        for (String arg : args) {
            if (arg.equals("--no-gui")) {
                showGui = false;
            }
        }

        // Token resolution: CLI args take priority over env vars
        String clientToken = firstNonEmpty(
                findArg(args, "--session-token"),
                System.getenv("HYTALE_SESSION_TOKEN"));
        String serverToken = firstNonEmpty(
                findArg(args, "--server-session-token"),
                System.getenv("HYTALE_SERVER_SESSION_TOKEN"));
        String identityToken = firstNonEmpty(
                findArg(args, "--server-identity-token"),
                System.getenv("HYTALE_SERVER_IDENTITY_TOKEN"));

        // Singleplayer auto-wrap detection: resolve path relative to Proxy installation, not CWD
        File backendJar = new File(BACKEND_JAR);
        if (!backendJar.exists()) {
            try {
                File jarFile = new File(ProxyConfig.class.getProtectionDomain().getCodeSource().getLocation().toURI());
                backendJar = new File(jarFile.getParentFile(), BACKEND_JAR);
            } catch (Exception ignored) {}
        }
        boolean autoWrap = remoteHost.equals("127.0.0.1") && backendJar.exists();

        // Standalone (GUI) mode = no auth tokens supplied and not invoked by the launcher.
        // --remote / --bind are optional connection overrides and must NOT disable the GUI;
        // only --backup-dir is a genuine launcher signal. With no tokens and no --backup-dir
        // the proxy shows the GUI and waits for Connect.
        boolean hasAnyToken = clientToken != null || serverToken != null || identityToken != null;
        boolean launchedByLauncher = findArg(args, "--backup-dir") != null;
        boolean standalone = !hasAnyToken && !launchedByLauncher;

        return new ProxyConfig(remoteHost, remotePort, localPort, clientToken, serverToken, identityToken, showGui, autoWrap, standalone, backendJar.getAbsolutePath(), args);
    }

    /** Build a config for a GUI-driven standalone session, using session tokens
     *  freshly derived from the running Hytale game process. */
    public static ProxyConfig forStandaloneConnect(String remoteHost, int remotePort, int localPort,
                                                    String clientToken, String serverToken, String identityToken) {
        return new ProxyConfig(remoteHost, remotePort, localPort,
                clientToken, serverToken, identityToken,
                true, false, false, null, new String[0]);
    }

    /** Returns a copy with the server-scope tokens replaced — used when they were
     *  derived via /game-session/child rather than supplied directly. */
    public ProxyConfig withServerTokens(String serverToken, String identityToken) {
        return new ProxyConfig(remoteHost, remotePort, localPort,
                clientToken, serverToken, identityToken,
                showGui, autoWrap, standalone, backendJarPath, originalArgs);
    }

    /** Returns the value of {@code key} (as {@code key value} or {@code key=value}) or null. */
    public static String findArg(String[] args, String key) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(key) && i < args.length - 1)
                return args[i + 1];
            if (args[i].startsWith(key + "="))
                return args[i].substring((key + "=").length());
        }
        return null;
    }

    private static int parsePort(String bind) {
        try {
            String[] parts = bind.split(":");
            if (parts.length == 2)
                return Integer.parseInt(parts[1]);
        } catch (Exception ignored) {}
        return -1;
    }

    private static String[] parseHostPort(String hostPort) {
        String[] result = new String[2];
        int colonIndex = hostPort.lastIndexOf(':');
        if (colonIndex > 0) {
            result[0] = hostPort.substring(0, colonIndex);
            result[1] = hostPort.substring(colonIndex + 1);
        } else {
            result[0] = hostPort;
            result[1] = null;
        }
        return result;
    }

    private static String extractWorldName(String backupDirPath) {
        // Source 1: Check universe/worlds/default/config.json in CWD
        File cwdConfig = new File("universe/worlds/default/config.json");
        if (cwdConfig.exists()) {
            String name = readDisplayName(cwdConfig);
            if (name != null) return name;
        }

        // Source 2: If we have backup-dir, check its parent
        if (backupDirPath != null && !backupDirPath.isEmpty()) {
            String cleanPath = backupDirPath.trim().replace("\"", "");
            File saveRoot = new File(cleanPath).getParentFile();
            if (saveRoot != null) {
                File backupConfig = new File(saveRoot, "universe/worlds/default/config.json");
                if (backupConfig.exists()) {
                    String name = readDisplayName(backupConfig);
                    if (name != null) return name;
                }
                // Fallback to name of the folder containing 'Backups'
                return saveRoot.getName();
            }
        }

        // Source 3: Fallback to current folder name
        try {
            return new File(".").getCanonicalFile().getName();
        } catch (Exception e) {
            return null;
        }
    }

    private static String readDisplayName(File file) {
        try {
            String content = Files.readString(file.toPath());
            // Permissive regex for DisplayName
            Matcher m = Pattern.compile("(?i)\"DisplayName\"\\s*:\\s*\"([^\"]+)\"").matcher(content);
            if (m.find()) {
                String name = m.group(1).trim();
                System.out.println("[ProxyConfig] Found DisplayName in config: '" + name + "'");
                return name;
            }
        } catch (Exception e) {
            System.err.println("[ProxyConfig] Error reading " + file.getName() + ": " + e.getMessage());
        }
        return null;
    }

    private static String firstNonEmpty(String... values) {
        for (String v : values) {
            if (v != null && !v.isEmpty())
                return v;
        }
        return null;
    }
}
