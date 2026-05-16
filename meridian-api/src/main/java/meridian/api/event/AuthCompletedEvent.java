package meridian.api.event;

import meridian.api.session.ProxySession;

/** Fired once the proxy-side auth handshake for a session has completed. */
public record AuthCompletedEvent(ProxySession session) implements ProxyEvent {
}
