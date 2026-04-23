package meridian.proxy.core;

import meridian.proxy.HytaleAuthState;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Per-stream-pair context shared by C2S and S2C handlers. */
public class ProxySession {
    private static final Logger log = LoggerFactory.getLogger(ProxySession.class);

    private final HytaleAuthState authState;
    private volatile Channel clientChannel;
    private volatile Channel serverChannel;
    private final Map<Class<?>, Object> attachments = new ConcurrentHashMap<>();

    public ProxySession(HytaleAuthState authState) {
        this.authState = authState;
    }

    public void setClientChannel(Channel ch) { this.clientChannel = ch; }
    public void setServerChannel(Channel ch) { this.serverChannel = ch; }
    public HytaleAuthState authState() { return authState; }
    
    /** Internal access for pipeline assembly / emergency close. Normal handlers should not use these. */
    Channel clientChannelRaw() { return clientChannel; }
    Channel serverChannelRaw() { return serverChannel; }

    /** Closes both client and server channels asynchronously. */
    public void disconnect() {
        if (clientChannel != null && clientChannel.isActive()) {
            clientChannel.eventLoop().execute(clientChannel::close);
        }
        if (serverChannel != null && serverChannel.isActive()) {
            serverChannel.eventLoop().execute(serverChannel::close);
        }
    }

    public void flushS2CBuffering() {
        if (serverChannel != null && serverChannel.isActive()) {
            serverChannel.eventLoop().execute(() -> {
                serverChannel.pipeline().fireUserEventTriggered(new PacketForwarder.FlushBufferingEvent());
            });
        }
    }

    public void sendToClient(int pktId, int bodySize, PacketForwarder.PacketSerializer serializer) {
        Channel ch = clientChannel;
        if (ch == null || !ch.isActive()) {
            log.warn("sendToClient(pkt {}) failed — client channel not available", pktId);
            return;
        }
        ByteBuf framed = PacketForwarder.serializeFramed(pktId, bodySize, serializer);
        ch.eventLoop().execute(() -> ch.writeAndFlush(framed));
    }

    public void sendToServer(int pktId, int bodySize, PacketForwarder.PacketSerializer serializer) {
        Channel ch = serverChannel;
        if (ch == null || !ch.isActive()) {
            log.warn("sendToServer(pkt {}) failed — server channel not available", pktId);
            return;
        }
        ByteBuf framed = PacketForwarder.serializeFramed(pktId, bodySize, serializer);
        ch.eventLoop().execute(() -> ch.writeAndFlush(framed));
    }

    /** Pre-framed [len|id|payload] write to client. */
    public void sendRawToClient(ByteBuf framed) {
        Channel ch = clientChannel;
        if (ch == null || !ch.isActive()) {
            log.warn("sendRawToClient failed — client channel not available");
            if (framed.refCnt() > 0) framed.release();
            return;
        }
        ch.eventLoop().execute(() -> ch.writeAndFlush(framed));
    }

    /** Pre-framed [len|id|payload] write to server. */
    public void sendRawToServer(ByteBuf framed) {
        Channel ch = serverChannel;
        if (ch == null || !ch.isActive()) {
            log.warn("sendRawToServer failed — server channel not available");
            if (framed.refCnt() > 0) framed.release();
            return;
        }
        ch.eventLoop().execute(() -> ch.writeAndFlush(framed));
    }

    @SuppressWarnings("unchecked")
    public <T> T getAttachment(Class<T> type) {
        return (T) attachments.get(type);
    }

    public <T> void setAttachment(Class<T> type, T value) {
        attachments.put(type, value);
    }
}
