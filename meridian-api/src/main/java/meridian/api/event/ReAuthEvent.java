package meridian.api.event;

import meridian.api.session.ProxySession;

/**
 * Fired when session tokens are rotated within a live session (re-auth).
 * This is not a new session — the same {@link ProxySession} continues.
 */
public record ReAuthEvent(ProxySession session) implements ProxyEvent {
}
