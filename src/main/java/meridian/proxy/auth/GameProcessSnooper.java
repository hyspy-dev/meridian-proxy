package meridian.proxy.auth;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Psapi;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.ptr.IntByReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Locates a running Hytale game process and extracts {@code HYTALE_SESSION_TOKEN}
 * and {@code HYTALE_IDENTITY_TOKEN} from its environment block.
 *
 * <p>Same-user access — no admin, no anti-cheat bypass. Backend per OS:
 * <ul>
 *   <li>Windows: PEB walking via {@code NtQueryInformationProcess} + {@code ReadProcessMemory}</li>
 *   <li>Linux: read {@code /proc/<pid>/environ}</li>
 *   <li>macOS: not yet implemented — needs {@code sysctl(KERN_PROCARGS2)} via libc</li>
 * </ul>
 */
public final class GameProcessSnooper {
    private static final Logger log = LoggerFactory.getLogger(GameProcessSnooper.class);

    public record GameCreds(String sessionToken, String identityToken, UUID profileUuid) {}

    private GameProcessSnooper() {}

    /** Returns the first running process whose env contains both Hytale token vars. */
    public static Optional<GameCreds> findRunningGameSession() {
        String os = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
        if (os.contains("win")) return WindowsBackend.find();
        if (os.contains("linux")) return LinuxBackend.find();
        if (os.contains("mac") || os.contains("darwin")) {
            throw new UnsupportedOperationException(
                    "macOS support is pending — needs sysctl(KERN_PROCARGS2) via JNA libc binding. "
                            + "PRs welcome.");
        }
        throw new UnsupportedOperationException("Unsupported OS: " + os);
    }

    /** Builds GameCreds from a raw env map and a token-source identifier (for logs). */
    private static Optional<GameCreds> credsFromEnv(Map<String, String> env, String source) {
        String session = env.get("HYTALE_SESSION_TOKEN");
        String identity = env.get("HYTALE_IDENTITY_TOKEN");
        if (session == null || session.isEmpty() || identity == null || identity.isEmpty()) {
            return Optional.empty();
        }
        UUID uuid = null;
        for (String k : List.of("HYTALE_PROFILE_ID", "HYTALE_PROFILE_UUID", "HYTALE_PLAYER_UUID")) {
            String v = env.get(k);
            if (v != null && !v.isEmpty()) {
                try { uuid = UUID.fromString(v); break; } catch (Exception ignored) {}
            }
        }
        log.info("Found live game session via {} (sessionLen={}, identityLen={}, profile={})",
                source, session.length(), identity.length(), uuid);
        return Optional.of(new GameCreds(session, identity, uuid));
    }

    // ============================================================
    // Windows backend — PEB walking via JNA
    // ============================================================

    private static final class WindowsBackend {
        private static final int PROCESS_QUERY_INFORMATION = 0x0400;
        private static final int PROCESS_VM_READ = 0x0010;
        // Win10/11 x64 offsets in the undocumented PEB / RTL_USER_PROCESS_PARAMETERS structures.
        private static final long PEB_PROCESS_PARAMETERS_OFFSET = 0x20;
        private static final long RTL_USER_PARAMS_ENV_PTR_OFFSET = 0x80;
        private static final long RTL_USER_PARAMS_ENV_SIZE_OFFSET = 0x3F0;
        private static final int ENV_BLOCK_MAX_BYTES = 1024 * 1024;
        private static final int ENV_BLOCK_FALLBACK_BYTES = 64 * 1024;

        public interface NtDll extends Library {
            NtDll INSTANCE = Native.load("ntdll", NtDll.class);
            int NtQueryInformationProcess(HANDLE handle, int infoClass,
                                          PROCESS_BASIC_INFORMATION pbi, int piSize,
                                          IntByReference returnLength);
        }

        @Structure.FieldOrder({"Reserved1", "PebBaseAddress", "Reserved2_0", "Reserved2_1",
                               "UniqueProcessId", "Reserved3"})
        public static class PROCESS_BASIC_INFORMATION extends Structure {
            public Pointer Reserved1;
            public Pointer PebBaseAddress;
            public Pointer Reserved2_0;
            public Pointer Reserved2_1;
            public Pointer UniqueProcessId;
            public Pointer Reserved3;
        }

        static Optional<GameCreds> find() {
            int[] pids = enumProcesses();
            if (pids.length == 0) {
                log.warn("EnumProcesses returned no PIDs");
                return Optional.empty();
            }
            int selfPid = Kernel32.INSTANCE.GetCurrentProcessId();
            int scanned = 0, opened = 0;
            for (int pid : pids) {
                if (pid == 0 || pid == 4 || pid == selfPid) continue;
                scanned++;
                try {
                    Map<String, String> env = readProcessEnvironment(pid);
                    if (env == null) continue;
                    opened++;
                    Optional<GameCreds> creds = credsFromEnv(env, "Windows pid=" + pid);
                    if (creds.isPresent()) return creds;
                } catch (Throwable ignored) {
                    // Access denied / process exited — skip.
                }
            }
            log.info("No Hytale game process found (scanned {} PIDs, read env from {})", scanned, opened);
            return Optional.empty();
        }

        private static int[] enumProcesses() {
            int[] buffer = new int[2048];
            IntByReference returned = new IntByReference();
            if (!Psapi.INSTANCE.EnumProcesses(buffer, buffer.length * 4, returned)) {
                return new int[0];
            }
            int count = returned.getValue() / 4;
            int[] result = new int[count];
            System.arraycopy(buffer, 0, result, 0, count);
            return result;
        }

        private static Map<String, String> readProcessEnvironment(int pid) {
            HANDLE h = Kernel32.INSTANCE.OpenProcess(PROCESS_QUERY_INFORMATION | PROCESS_VM_READ, false, pid);
            if (h == null) return null;
            try {
                PROCESS_BASIC_INFORMATION pbi = new PROCESS_BASIC_INFORMATION();
                IntByReference returnLength = new IntByReference();
                int status = NtDll.INSTANCE.NtQueryInformationProcess(h, 0, pbi, pbi.size(), returnLength);
                if (status != 0) return null;
                pbi.read();

                Pointer peb = pbi.PebBaseAddress;
                if (peb == null) return null;
                long pebAddr = Pointer.nativeValue(peb);

                long procParamsAddr = readPointer(h, pebAddr + PEB_PROCESS_PARAMETERS_OFFSET);
                if (procParamsAddr == 0) return null;

                long envAddr = readPointer(h, procParamsAddr + RTL_USER_PARAMS_ENV_PTR_OFFSET);
                if (envAddr == 0) return null;

                long envSize = readPointer(h, procParamsAddr + RTL_USER_PARAMS_ENV_SIZE_OFFSET);
                if (envSize <= 0 || envSize > ENV_BLOCK_MAX_BYTES) {
                    envSize = ENV_BLOCK_FALLBACK_BYTES;
                }

                byte[] envBytes = readMemory(h, envAddr, (int) envSize);
                if (envBytes == null) return null;
                return parseUtf16LeEnvBlock(envBytes);
            } finally {
                Kernel32.INSTANCE.CloseHandle(h);
            }
        }

        private static long readPointer(HANDLE h, long address) {
            byte[] buf = readMemory(h, address, 8);
            if (buf == null) return 0;
            return ByteBuffer.wrap(buf).order(ByteOrder.LITTLE_ENDIAN).getLong();
        }

        private static byte[] readMemory(HANDLE h, long address, int length) {
            Memory mem = new Memory(length);
            IntByReference bytesRead = new IntByReference();
            if (!Kernel32.INSTANCE.ReadProcessMemory(h, new Pointer(address), mem, length, bytesRead)) {
                return null;
            }
            int n = bytesRead.getValue();
            if (n <= 0) return null;
            return mem.getByteArray(0, n);
        }

        /** UTF-16LE, KEY=VALUE\0...\0\0. */
        private static Map<String, String> parseUtf16LeEnvBlock(byte[] block) {
            Map<String, String> env = new HashMap<>();
            ByteBuffer buf = ByteBuffer.wrap(block).order(ByteOrder.LITTLE_ENDIAN);
            StringBuilder sb = new StringBuilder();
            while (buf.remaining() >= 2) {
                char c = buf.getChar();
                if (c == 0) {
                    if (sb.isEmpty()) break;
                    addEntry(env, sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(c);
                }
            }
            return env;
        }
    }

    // ============================================================
    // Linux backend — /proc/<pid>/environ
    // ============================================================

    private static final class LinuxBackend {
        static Optional<GameCreds> find() {
            File proc = new File("/proc");
            File[] pidDirs = proc.listFiles((dir, name) -> name.chars().allMatch(Character::isDigit));
            if (pidDirs == null) {
                log.warn("/proc not readable — not a Linux system?");
                return Optional.empty();
            }
            int scanned = 0, read = 0;
            for (File pidDir : pidDirs) {
                scanned++;
                File environ = new File(pidDir, "environ");
                if (!environ.canRead()) continue;
                try {
                    byte[] data = Files.readAllBytes(environ.toPath());
                    read++;
                    Map<String, String> env = parseNullSeparatedEnvBlock(data);
                    Optional<GameCreds> creds = credsFromEnv(env, "Linux pid=" + pidDir.getName());
                    if (creds.isPresent()) return creds;
                } catch (IOException ignored) {
                    // Process exited or restricted — skip.
                }
            }
            log.info("No Hytale game process found (scanned {} PIDs, read environ from {})", scanned, read);
            return Optional.empty();
        }

        /** Linux env block: KEY=VALUE\0KEY=VALUE\0..., bytes are UTF-8 (typically). */
        private static Map<String, String> parseNullSeparatedEnvBlock(byte[] block) {
            Map<String, String> env = new HashMap<>();
            int start = 0;
            for (int i = 0; i < block.length; i++) {
                if (block[i] == 0) {
                    if (i > start) addEntry(env, new String(block, start, i - start, StandardCharsets.UTF_8));
                    start = i + 1;
                }
            }
            return env;
        }
    }

    // ============================================================
    // Shared helpers
    // ============================================================

    private static void addEntry(Map<String, String> env, String entry) {
        int eq = entry.indexOf('=');
        if (eq > 0) env.put(entry.substring(0, eq), entry.substring(eq + 1));
    }
}
