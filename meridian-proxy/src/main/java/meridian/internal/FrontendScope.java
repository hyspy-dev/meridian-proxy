package meridian.internal;

import io.netty.incubator.codec.quic.QuicChannel;

/**
 * The connection-lifecycle hooks a {@link ProxyFrontendHandler} (and its
 * {@link meridian.internal.handler.RouteGuard}) needs from whatever owns the QUIC listener it
 * runs under. {@link ConnectionScope} implements it for a single-target connection;
 * {@link MultiplexRoute} implements it for one port of the multiplex proxy, so the same
 * frontend/referral logic is reused whether the proxy serves one server or a whole range.
 */
public interface FrontendScope {

    /** A client QUIC connection became active on this listener. */
    void onClientConnected(QuicChannel ch);

    /** A client QUIC connection dropped. */
    void onClientClosed(QuicChannel ch);

    /** The address a followed referral tells the client to reconnect to (the proxy itself). */
    String selfHost();

    /** The local UDP port this listener is bound to (used to rewrite a referral's hostTo). */
    int localPort();

    /** Arm a server referral: the next client connection targets {@code host:port}. */
    void beginRedirect(String host, int port);
}
