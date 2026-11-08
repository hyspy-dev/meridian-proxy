package meridian.internal.control;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import meridian.internal.core.ProxySessionImpl;
import meridian.protocol.NetworkChannel;

/**
 * Every game connection the proxy is carrying right now, numbered, for the control channel.
 *
 * <p>A connection is one client's QUIC connection and the server leg behind it; it carries several
 * streams, each with its own {@link ProxySessionImpl}. Packets go out on the stream of their
 * channel - the Default one for nearly everything - so each stream's session is filed under the
 * channel its packets were seen on.
 */
public final class LiveConnections {

    /** One carried connection. */
    public static final class Live {
        final int id;
        final String target;
        final int localPort;
        final Instant since = Instant.now();
        /** The session of each stream, by the channel its packets travel on. */
        final Map<NetworkChannel, ProxySessionImpl> byChannel = new ConcurrentHashMap<>();
        /** Every stream's session, in the order they were linked; the first is the Default stream. */
        final List<ProxySessionImpl> streams = new java.util.concurrent.CopyOnWriteArrayList<>();
        /** The commands this connection's module runtime offers, once it is known. */
        volatile meridian.internal.module.CommandRegistry commands;

        /** Gives the connection its module runtime's commands. */
        public void commands(meridian.internal.module.CommandRegistry registry) {
            this.commands = registry;
        }

        Live(int id, String target, int localPort) {
            this.id = id;
            this.target = target;
            this.localPort = localPort;
        }

        public int id() {
            return id;
        }

        /** The session to send a packet of {@code channel} on: that channel's stream, else the first. */
        public ProxySessionImpl sessionFor(NetworkChannel channel) {
            ProxySessionImpl s = channel == null ? null : byChannel.get(channel);
            if (s != null) {
                return s;
            }
            s = byChannel.get(NetworkChannel.Default);
            return s != null ? s : (streams.isEmpty() ? null : streams.get(0));
        }

        JsonObject describe() {
            JsonObject o = new JsonObject();
            o.addProperty("id", id);
            o.addProperty("target", target);
            o.addProperty("localPort", localPort);
            o.addProperty("since", since.toString());
            o.addProperty("streams", streams.size());
            ProxySessionImpl first = sessionFor(NetworkChannel.Default);
            if (first != null) {
                o.addProperty("phase", first.phase().name());
                if (first.headless() != null) {
                    o.addProperty("headless", true);
                    o.addProperty("player", first.headless().username());
                    o.addProperty("uuid", first.headless().uuid().toString());
                    return o;
                }
                String identity = first.authState().clientIdentityToken();
                JsonObject claims = claims(identity);
                if (claims != null) {
                    if (claims.has("username")) {
                        o.add("player", claims.get("username"));
                    }
                    if (claims.has("sub")) {
                        o.add("uuid", claims.get("sub"));
                    }
                }
            }
            return o;
        }
    }

    private static final AtomicInteger NEXT = new AtomicInteger(1);
    private static final Map<Integer, Live> BY_ID = new ConcurrentHashMap<>();
    private static final Map<ProxySessionImpl, Live> BY_SESSION = new ConcurrentHashMap<>();

    private LiveConnections() {
    }

    /** A client connected through {@code localPort} to {@code target}; returns its record. */
    public static Live opened(String target, int localPort) {
        Live live = new Live(NEXT.getAndIncrement(), target, localPort);
        BY_ID.put(live.id, live);
        return live;
    }

    /** A stream of {@code live} was linked; its session is now known. */
    public static void streamLinked(Live live, ProxySessionImpl session) {
        if (live == null || session == null) {
            return;
        }
        live.streams.add(session);
        BY_SESSION.put(session, live);
    }

    /** A packet of {@code channel} was seen on {@code session}'s stream. */
    static void sawChannel(ProxySessionImpl session, NetworkChannel channel) {
        Live live = BY_SESSION.get(session);
        if (live != null && channel != null) {
            live.byChannel.putIfAbsent(channel, session);
        }
    }

    /** The connection is gone. */
    public static void closed(Live live) {
        if (live == null) {
            return;
        }
        BY_ID.remove(live.id);
        for (ProxySessionImpl s : live.streams) {
            BY_SESSION.remove(s);
        }
    }

    /** The connection a stream belongs to, or {@code null}. */
    static Live of(ProxySessionImpl session) {
        return session == null ? null : BY_SESSION.get(session);
    }

    /** The connection numbered {@code id}, or {@code null}. */
    static Live get(int id) {
        return BY_ID.get(id);
    }

    /** The connection named on a command line: its number, or the only one when there is one. */
    static Live pick(String id) {
        if (id == null || id.isBlank() || id.equals("-")) {
            return BY_ID.size() == 1 ? BY_ID.values().iterator().next() : null;
        }
        try {
            return BY_ID.get(Integer.parseInt(id.trim()));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    static List<Live> all() {
        List<Live> out = new ArrayList<>(BY_ID.values());
        out.sort((a, b) -> Integer.compare(a.id, b.id));
        return out;
    }

    /** The claims of a JWT, unverified - only to show whose connection it is. */
    private static JsonObject claims(String jwt) {
        if (jwt == null) {
            return null;
        }
        String[] parts = jwt.split("\\.");
        if (parts.length < 2) {
            return null;
        }
        try {
            String json = new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);
            return JsonParser.parseString(json).getAsJsonObject();
        } catch (RuntimeException e) {
            return null;
        }
    }
}
