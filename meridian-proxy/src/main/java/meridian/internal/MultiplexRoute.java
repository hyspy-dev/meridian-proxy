package meridian.internal;

import io.netty.incubator.codec.quic.QuicChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * One port of the {@link MultiplexProxy}: a fixed local UDP port that relays to a fixed real
 * server. Implements {@link FrontendScope} so it can reuse {@link ProxyFrontendHandler} and
 * the referral logic, but — unlike {@link ConnectionScope} — a client drop does NOT tear
 * anything down: the port stays bound for the whole multiplex session (other players/servers
 * keep their ports), and a reconnect just re-enters.
 */
public final class MultiplexRoute implements FrontendScope {

    private static final Logger log = LoggerFactory.getLogger(MultiplexRoute.class);

    private final int localPort;
    /** The server this port was assigned to — stable, used to pick the {@code host_port} module folder. */
    private final String originalHost;
    private final int originalPort;
    /** Backend target for the next client connection — repointed by {@link #beginRedirect}. */
    private volatile String currentRemoteHost;
    private volatile int currentRemotePort;
    private final Set<QuicChannel> liveClients = ConcurrentHashMap.newKeySet();

    public MultiplexRoute(int localPort, String remoteHost, int remotePort) {
        this.localPort = localPort;
        this.originalHost = remoteHost;
        this.originalPort = remotePort;
        this.currentRemoteHost = remoteHost;
        this.currentRemotePort = remotePort;
    }

    public String originalHost() { return originalHost; }
    public int originalPort() { return originalPort; }
    public String currentRemoteHost() { return currentRemoteHost; }
    public int currentRemotePort() { return currentRemotePort; }

    @Override
    public void onClientConnected(QuicChannel ch) {
        liveClients.add(ch);
        log.info("multiplex :{} client connected → {}:{} ({} live)",
                localPort, currentRemoteHost, currentRemotePort, liveClients.size());
    }

    @Override
    public void onClientClosed(QuicChannel ch) {
        liveClients.remove(ch);
        log.info("multiplex :{} client closed ({} live)", localPort, liveClients.size());
        // Keep the port bound — the multiplex serves the whole range for the session.
    }

    @Override
    public String selfHost() {
        return "127.0.0.1";
    }

    @Override
    public int localPort() {
        return localPort;
    }

    @Override
    public void beginRedirect(String host, int port) {
        this.currentRemoteHost = host;
        this.currentRemotePort = port;
        log.info("multiplex :{} referral → next backend {}:{}", localPort, host, port);
    }
}
