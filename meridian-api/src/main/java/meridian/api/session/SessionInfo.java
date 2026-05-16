package meridian.api.session;

import java.util.UUID;

/**
 * Module-safe session identity — never carries auth tokens.
 *
 * <p>Skeleton for Phase 1. {@code ProxySession.info()} and the population of
 * these fields from the auth handshake arrive in Phase 2, replacing the
 * internal {@code authState()} accessor.
 */
public record SessionInfo(UUID uuid, String username, String fingerprint) {
}
