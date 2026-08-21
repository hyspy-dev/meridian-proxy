package meridian.internal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Works around AWT's blank window on non-reparenting X11 window managers.
 *
 * <p>Under dwm, i3, xmonad, awesome and friends, AWT mis-handles the frame: it is mapped
 * at the right size and never shows a single component. The cure is
 * {@code _JAVA_AWT_WM_NONREPARENTING=1}, which AWT reads from the environment as the
 * toolkit starts — too early for the process to set on itself, and a Java process cannot
 * change its own environment anyway. So the only way to apply it from inside the jar is
 * to hand the environment to a fresh JVM and step aside.
 *
 * <p>This must run before anything touches AWT, and it deliberately does nothing unless
 * the window manager is one that actually has the problem: the flag makes AWT ignore
 * frame decorations, which would misplace windows under an ordinary reparenting WM.
 * Anything unexpected — no {@code xprop}, an unknown WM, a command line it cannot
 * reconstruct — leaves startup exactly as it was.
 */
final class X11Relaunch {

    /** Window managers that do not reparent, so AWT needs telling. */
    private static final Set<String> NON_REPARENTING = Set.of(
            "dwm", "i3", "xmonad", "awesome", "bspwm", "herbstluftwm", "spectrwm",
            "qtile", "ratpoison", "cwm", "notion", "wmii", "2bwm", "monsterwm",
            "frankenwm", "katriawm", "dk", "sowm");

    private static final String FLAG = "_JAVA_AWT_WM_NONREPARENTING";

    private X11Relaunch() {
    }

    /**
     * Re-executes this JVM with the workaround set, and never returns if it does.
     * Returns normally when the workaround is unnecessary or cannot be applied.
     */
    static void applyIfNeeded() {
        try {
            if (!shouldConsider()) return;
            String wm = detectWindowManager();
            if (wm == null) {
                // No xprop, or a window manager that does not announce itself. Cannot tell
                // which kind it is, so say what to do if the window does turn up blank.
                System.out.println("[X11Relaunch] Could not identify the window manager. If the window comes"
                        + " up blank, it does not reparent — relaunch with " + FLAG + "=1 set.");
                return;
            }
            if (!NON_REPARENTING.contains(wm.toLowerCase(Locale.ROOT))) return;

            List<String> command = currentCommand();
            if (command == null) {
                System.out.println("[X11Relaunch] " + wm + " does not reparent, but this JVM's command line"
                        + " could not be read — start it with " + FLAG + "=1 to avoid a blank window.");
                return;
            }

            System.out.println("[X11Relaunch] " + wm + " does not reparent; restarting with "
                    + FLAG + "=1 so the window renders.");
            ProcessBuilder pb = new ProcessBuilder(command).inheritIO();
            pb.environment().put(FLAG, "1");
            Process child = pb.start();
            System.exit(child.waitFor());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Throwable ignored) {
            // Any failure here must not stop the proxy from starting normally.
        }
    }

    private static boolean shouldConsider() {
        String os = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
        boolean x11 = os.contains("linux") || os.contains("bsd")
                || os.contains("aix") || os.contains("sunos") || os.contains("unix");
        if (!x11) return false;
        // No X display, or the user (or a previous pass) already set it.
        if (System.getenv("DISPLAY") == null || System.getenv(FLAG) != null) return false;

        String cmdLine = System.getProperty("sun.java.command", "");
        // Headless runs have no window to fix, and under the Hytale launcher the parent
        // process owns this one — restarting it out from under the launcher is not ours to do.
        return !cmdLine.contains("--no-gui") && !cmdLine.contains("--backup-dir");
    }

    /**
     * The running window manager's name via EWMH, or null if it cannot be read.
     *
     * <p>Falls back to looking for a known window manager among the running processes:
     * {@code xprop} lives in x11-utils, which a minimal tiling-WM install may not have,
     * and that is exactly the setup this whole class exists for.
     */
    private static String detectWindowManager() throws Exception {
        String check = xprop("-root", "_NET_SUPPORTING_WM_CHECK");
        if (check == null) return findWindowManagerProcess();
        int hash = check.indexOf("0x");
        if (hash < 0) return null;
        String windowId = check.substring(hash).trim().split("\\s+")[0];

        String name = xprop("-id", windowId, "_NET_WM_NAME");
        if (name == null) return findWindowManagerProcess();
        int firstQuote = name.indexOf('"');
        int lastQuote = name.lastIndexOf('"');
        if (firstQuote < 0 || lastQuote <= firstQuote) return null;
        return name.substring(firstQuote + 1, lastQuote);
    }

    /**
     * Scans {@code /proc} for a process whose name is one of the window managers this
     * cares about. Only consulted when EWMH could not answer, since a matching process
     * is weaker evidence than the window manager naming itself.
     */
    private static String findWindowManagerProcess() {
        Path proc = Path.of("/proc");
        if (!Files.isDirectory(proc)) return null;
        try (var pids = Files.list(proc)) {
            return pids.map(dir -> {
                        try {
                            if (!Character.isDigit(dir.getFileName().toString().charAt(0))) return null;
                            return Files.readString(dir.resolve("comm")).trim().toLowerCase(Locale.ROOT);
                        } catch (Exception e) {
                            return null;   // the process exited, or is not ours to read
                        }
                    })
                    .filter(name -> name != null && NON_REPARENTING.contains(name))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    /** Runs {@code xprop} with a hard timeout; null if it is absent or fails. */
    private static String xprop(String... args) throws Exception {
        List<String> command = new ArrayList<>();
        command.add("xprop");
        command.addAll(List.of(args));
        Process p;
        try {
            p = new ProcessBuilder(command)
                    .redirectErrorStream(true)
                    .redirectOutput(ProcessBuilder.Redirect.PIPE)
                    .start();
        } catch (IOException notInstalled) {
            return null;
        }
        String out;
        try (var in = p.getInputStream()) {
            out = new String(in.readAllBytes());
        }
        if (!p.waitFor(2, TimeUnit.SECONDS)) {
            p.destroyForcibly();
            return null;
        }
        return p.exitValue() == 0 ? out : null;
    }

    /** This JVM's own command line, or null when the platform will not report it. */
    private static List<String> currentCommand() {
        var info = ProcessHandle.current().info();
        Optional<String> exe = info.command();
        Optional<String[]> args = info.arguments();
        if (exe.isEmpty() || args.isEmpty()) return null;
        List<String> command = new ArrayList<>();
        command.add(exe.get());
        command.addAll(List.of(args.get()));
        return command;
    }
}
