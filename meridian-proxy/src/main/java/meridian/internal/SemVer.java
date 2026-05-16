package meridian.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tolerant semantic version parser/comparator.
 *
 * Designed to handle git-describe output like:
 *   "v1.0.0"                       -> 1.0.0
 *   "v1.0.0-3-gabc1234"            -> 1.0.0 (pre-release info ignored for ordering)
 *   "v1.0.0-3-gabc1234-dirty"      -> 1.0.0
 *   "1.0.0-SNAPSHOT"               -> 1.0.0
 *
 * Only MAJOR.MINOR.PATCH is used for comparison. Missing components default to 0.
 * This is intentionally lax — strict semver pre-release ordering is more complex
 * than needed for a "is this core new enough?" gate.
 */
public final class SemVer implements Comparable<SemVer> {
    private static final Pattern VERSION_PATTERN =
            Pattern.compile("v?(\\d+)(?:\\.(\\d+))?(?:\\.(\\d+))?");

    public final int major;
    public final int minor;
    public final int patch;
    private final String raw;

    private SemVer(int major, int minor, int patch, String raw) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.raw = raw;
    }

    /**
     * Parses a version string. Returns {@code null} if no numeric version
     * components can be extracted (e.g. for "dev" or a bare commit hash).
     */
    public static SemVer parse(String s) {
        if (s == null) return null;
        Matcher m = VERSION_PATTERN.matcher(s.trim());
        if (!m.find()) return null;
        int major = Integer.parseInt(m.group(1));
        int minor = m.group(2) != null ? Integer.parseInt(m.group(2)) : 0;
        int patch = m.group(3) != null ? Integer.parseInt(m.group(3)) : 0;
        return new SemVer(major, minor, patch, s);
    }

    @Override
    public int compareTo(SemVer other) {
        int c = Integer.compare(this.major, other.major);
        if (c != 0) return c;
        c = Integer.compare(this.minor, other.minor);
        if (c != 0) return c;
        return Integer.compare(this.patch, other.patch);
    }

    /**
     * Checks whether {@code current} satisfies the optional {@code min} and {@code max} bounds.
     * Bounds may be {@code null} to indicate "no lower / upper bound".
     * Unparseable bound strings are treated as absent (with a side effect: caller logs).
     */
    public static boolean inRange(SemVer current, String min, String max) {
        if (current == null) return true; // "dev" / unparseable core always passes — fail-open for local dev
        if (min != null && !min.isEmpty()) {
            SemVer lo = parse(min);
            if (lo != null && current.compareTo(lo) < 0) return false;
        }
        if (max != null && !max.isEmpty()) {
            SemVer hi = parse(max);
            if (hi != null && current.compareTo(hi) > 0) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return raw;
    }
}
