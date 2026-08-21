package meridian.internal;

import meridian.protocol.ProtocolSettings;

/**
 * The QUIC ALPN tokens both proxy legs advertise.
 *
 * <p>Mirrors the server's {@code QUICTransport} / {@code QuicheListener}: the token is
 * {@code "hytale/" + PROTOCOL_VERSION}, and the previous version is offered alongside it
 * so a one-version-old peer still connects. The server rejects any connection whose
 * negotiated version is below its own with {@code ClientOutdated}, so these must track
 * {@code meridian-protocol} — deriving them from {@link ProtocolSettings} means a
 * protocol sync carries them along instead of leaving a stale literal behind.
 */
public final class HytaleAlpn {

    public static final String CURRENT = "hytale/" + ProtocolSettings.PROTOCOL_VERSION;
    public static final String PREVIOUS = "hytale/" + (ProtocolSettings.PROTOCOL_VERSION - 1);

    private HytaleAlpn() {
    }
}
