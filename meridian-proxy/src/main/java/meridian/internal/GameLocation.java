package meridian.internal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import meridian.internal.core.ProxyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Where the game this proxy serves is installed, as far as the process knows - handed to modules
 * as a fact ({@code ModuleContext.gameDirectory()} / {@code gameUserDirectory()}). The proxy reads
 * no game file itself; core does, and looks for an installation on its own when this is empty.
 *
 * <p>Known from:
 * <ul>
 *   <li>{@code --game-dir} / {@code --user-dir} - the launcher names the build it started;</li>
 *   <li>the proxy's own jar sitting in a build's {@code Server/} folder - run in place of the
 *       game's server;</li>
 *   <li>the single-player wrap - the game's server jar it was asked to run.</li>
 * </ul>
 */
public final class GameLocation {
    private static final Logger log = LoggerFactory.getLogger(GameLocation.class);

    private static volatile Path gameDirectory;
    private static volatile Path userDirectory;

    private GameLocation() {
    }

    /** The build's game folder ({@code package/game/latest}), if known. */
    public static Optional<Path> gameDirectory() {
        return Optional.ofNullable(gameDirectory);
    }

    /** The game's {@code UserData} folder, if known. */
    public static Optional<Path> userDirectory() {
        return Optional.ofNullable(userDirectory);
    }

    /** Reads {@code --game-dir} / {@code --user-dir}, or the folder the proxy jar sits in. */
    static void fromArgs(String[] args) {
        String game = ProxyConfig.findArg(args, "--game-dir");
        String user = ProxyConfig.findArg(args, "--user-dir");
        if (game != null) {
            setGameDirectory(Path.of(game.trim()), "--game-dir");
        } else {
            ownServerFolder().ifPresent(d -> setGameDirectory(d, "the proxy's own folder"));
        }
        if (user != null) {
            Path u = Path.of(user.trim());
            if (Files.isDirectory(u)) {
                userDirectory = u.toAbsolutePath().normalize();
                log.info("Game user folder: {}", userDirectory);
            } else {
                log.warn("--user-dir {} is not a folder - ignored", u);
            }
        }
    }

    /** The build whose server jar is {@code serverJar} ({@code <game>/Server/HytaleServer.jar}). */
    static void fromServerJar(String serverJar) {
        if (serverJar == null || gameDirectory != null) {
            return;
        }
        Path jar = Path.of(serverJar).toAbsolutePath();
        Path server = jar.getParent();
        if (server != null && server.getParent() != null) {
            setGameDirectory(server.getParent(), "the single-player server");
        }
    }

    private static void setGameDirectory(Path dir, String from) {
        Path d = dir.toAbsolutePath().normalize();
        if (!Files.isRegularFile(d.resolve("Assets.zip"))) {
            log.warn("Game folder from {} has no Assets.zip: {} - ignored", from, d);
            return;
        }
        gameDirectory = d;
        log.info("Game folder (from {}): {}", from, d);
    }

    /** The build folder when this jar sits in its {@code Server/} - run in place of the game's server. */
    private static Optional<Path> ownServerFolder() {
        try {
            Path jar = Path.of(GameLocation.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            Path folder = jar.getParent();
            if (folder != null && folder.getFileName() != null
                    && folder.getFileName().toString().equals("Server") && folder.getParent() != null
                    && Files.isRegularFile(folder.getParent().resolve("Assets.zip"))) {
                return Optional.of(folder.getParent());
            }
        } catch (Exception ignored) {
            // not run from a jar on disk
        }
        return Optional.empty();
    }
}
