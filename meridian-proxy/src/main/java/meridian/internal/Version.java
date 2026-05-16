package meridian.internal;

import java.io.InputStream;
import java.util.Properties;

/**
 * Build-time version metadata. Populated by Maven resource filtering from
 * {@code git describe --tags}, so the displayed version always tracks the
 * latest git tag (e.g. "v1.0.0" exactly on a tag, "v1.0.0-3-gabc1234-dirty"
 * in between).
 */
public final class Version {
    public static final String VERSION;
    public static final String RELEASES_URL;

    /** Community Discord — a fixed project URL, not build-dependent. */
    public static final String DISCORD_URL = "https://discord.gg/kApV2z2Qmw";

    static {
        String v = "dev";
        String url = "https://github.com/hyspy-dev/meridian-proxy/releases";
        try (InputStream in = Version.class.getResourceAsStream("/version.properties")) {
            if (in != null) {
                Properties p = new Properties();
                p.load(in);
                String raw = p.getProperty("version", "").trim();
                // Guard against unsubstituted placeholders when running unbuilt sources from an IDE.
                if (!raw.isEmpty() && !raw.startsWith("${")) {
                    v = raw;
                }
                String rawUrl = p.getProperty("releasesUrl", "").trim();
                if (!rawUrl.isEmpty() && !rawUrl.startsWith("${")) {
                    url = rawUrl;
                }
            }
        } catch (Exception ignored) {
        }
        VERSION = v;
        RELEASES_URL = url;
    }

    private Version() {
    }
}
