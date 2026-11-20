package meridian.internal;

import io.netty.channel.Channel;
import meridian.internal.module.ModuleManager;

/**
 * The client side of a connection - what stands where the game connects. A {@link ConnectionScope}
 * is one connection's life whatever its client side is: the server's module set loaded and shown,
 * the window told, a disconnect, the teardown. Only this part differs:
 *
 * <ul>
 *   <li>{@link GameFront} - a local port the game connects to; the proxy sits between them;</li>
 *   <li>{@link HeadlessConnection} - no game: the proxy plays the client itself.</li>
 * </ul>
 */
interface Front {

    /**
     * Starts the client side, with the scope's modules loaded; returns once it is up.
     *
     * @return the channel whose closing ends the connection
     */
    Channel start(ConnectionScope scope, ModuleManager modules) throws Exception;

    /** Closes what it opened - from any thread, quickly; {@link #release} follows on the scope's thread. */
    void close();

    /** Frees what is left once closed (event loops), on the scope's own thread. */
    default void release() {
    }

    /** How the window says it is connected: after "Connected to host:port". */
    String how();
}
