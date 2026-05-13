package meridian.proxy.core;

/**
 * Session lifecycle phase, advanced by {@code PhaseTracker} as well-known
 * trigger packets pass through the pipeline. Modules can read the current
 * phase via {@link ProxySession#phase()} to gate behaviour by lifecycle stage.
 *
 * Transitions are monotonically ordered but applied permissively: if a
 * trigger packet is missed or skipped, later triggers still advance the phase.
 */
public enum SessionPhase {
    /** Initial state — TLS done, auth handshake in progress. */
    PRE_AUTH,
    /** S2C Pkt 14 ConnectAccept observed — auth handshake complete. */
    AUTH_COMPLETE,
    /** S2C Pkt 22 WorldLoadFinished observed — setup payload + world load done. */
    WORLD_LOADED,
    /** S2C Pkt 104 JoinWorld observed — server has placed the client in-world. */
    JOINING,
    /** C2S Pkt 105 ClientReady observed — gameplay active. */
    PLAYING
}
