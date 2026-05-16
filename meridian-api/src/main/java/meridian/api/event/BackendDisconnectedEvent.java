package meridian.api.event;

import meridian.api.session.ProxySession;

/** Fired when the upstream (server-side) connection for a session drops. */
public record BackendDisconnectedEvent(ProxySession session) implements ProxyEvent {
}
