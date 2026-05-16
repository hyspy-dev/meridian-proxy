package meridian.api.event;

import meridian.api.session.ProxySession;
import meridian.api.session.SessionPhase;

/**
 * Fired when a session advances to a new lifecycle phase.
 *
 * @param from    the previous phase
 * @param to      the new phase
 * @param session the session that transitioned
 */
public record PhaseChangedEvent(SessionPhase from, SessionPhase to, ProxySession session)
        implements ProxyEvent {
}
