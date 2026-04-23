package meridian.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * Per-connection auth state. Two independent token sets:
 *   back  — proxy → real server (pkt 12), bound to proxyClientCertFp,
 *           REST bearer HYTALE_SESSION_TOKEN.
 *   front — proxy → client (pkt 11/13), bound to proxyServerCertFp,
 *           REST bearer HYTALE_SERVER_SESSION_TOKEN.
 */
public class HytaleAuthState {
    private static final Logger log = LoggerFactory.getLogger(HytaleAuthState.class);

    public final String proxyServerCertFp;
    public final String proxyClientCertFp;
    public final String proxyServerIdentityToken;
    public final HytaleSessionApi clientApi;
    public final HytaleSessionApi serverApi;

    private volatile String clientIdentityToken;
    private volatile byte[] lastServerPasswordChallenge;

    private volatile CompletableFuture<String> backAccessTokenFut;
    private volatile CompletableFuture<String> backServerGrantFut;
    private volatile CompletableFuture<String> frontAuthGrantFut;
    private volatile CompletableFuture<String> frontServerAccessTokenFut;

    public HytaleAuthState(String proxyServerCertFp,
                           String proxyClientCertFp,
                           String proxyServerIdentityToken,
                           HytaleSessionApi clientApi,
                           HytaleSessionApi serverApi) {
        this.proxyServerCertFp = proxyServerCertFp;
        this.proxyClientCertFp = proxyClientCertFp;
        this.proxyServerIdentityToken = proxyServerIdentityToken;
        this.clientApi = clientApi;
        this.serverApi = serverApi;
    }

    public synchronized void setClientIdentityToken(String t) {
        if (clientIdentityToken == null && t != null) {
            clientIdentityToken = t;
            log.info("captured clientIdentityToken (len={})", t.length());
        }
    }

    public void setLastServerPasswordChallenge(byte[] c) {
        this.lastServerPasswordChallenge = c;
    }

    public byte[] getLastServerPasswordChallenge() {
        return lastServerPasswordChallenge;
    }

    /** BACK: consume pkt 11 from real server, exchange via CLIENT bearer. Futures
     *  are reassigned each call so token rotation is supported. */
    public synchronized void onBackAuthGrantReceived(String realAuthGrant, String realServerIdentityToken) {
        log.info("back: requesting backAccessToken (fp={}) + backServerGrant (hasServerIdentity={})",
                proxyClientCertFp, realServerIdentityToken != null);
        backAccessTokenFut = clientApi.fetchAccessToken(realAuthGrant, proxyClientCertFp);
        backServerGrantFut = realServerIdentityToken == null
                ? CompletableFuture.completedFuture(null)
                : clientApi.fetchServerGrant(realServerIdentityToken);
    }

    public CompletableFuture<String> backAccessToken() { return backAccessTokenFut; }
    public CompletableFuture<String> backServerGrant() { return backServerGrantFut; }

    /** FRONT: fetch frontAuthGrant via SERVER bearer (requires clientIdentityToken captured). */
    public synchronized CompletableFuture<String> ensureFrontAuthGrant() {
        if (clientIdentityToken == null) {
            throw new IllegalStateException("clientIdentityToken not captured yet");
        }
        log.info("front: requesting frontAuthGrant");
        frontAuthGrantFut = serverApi.fetchServerGrant(clientIdentityToken);
        return frontAuthGrantFut;
    }

    /** FRONT: exchange client's serverAuthorizationGrant for frontServerAccessToken. */
    public synchronized CompletableFuture<String> exchangeClientServerGrant(String clientServerGrant) {
        log.info("front: exchanging serverGrant for frontServerAccessToken (fp={})", proxyServerCertFp);
        frontServerAccessTokenFut = serverApi.fetchAccessToken(clientServerGrant, proxyServerCertFp);
        return frontServerAccessTokenFut;
    }

}
