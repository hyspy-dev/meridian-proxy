package meridian.internal.core;

import meridian.api.packet.Direction;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/** Wire format: {@code [payloadLen:i32le][packetId:i32le][payload]}. Payload excludes the 8-byte header. */
public final class PacketFrame {
    private final int packetId;
    private final ByteBuf payload;
    private final Direction direction;

    public PacketFrame(int packetId, ByteBuf payload, Direction direction) {
        this.packetId = packetId;
        this.payload = payload;
        this.direction = direction;
    }

    public int packetId() { return packetId; }
    public ByteBuf payload() { return payload; }
    public Direction direction() { return direction; }

    /** Rebuild a freshly-allocated framed buffer; caller releases. */
    public ByteBuf reframe() {
        int len = payload.readableBytes();
        ByteBuf out = Unpooled.buffer(8 + len);
        out.writeIntLE(len);
        out.writeIntLE(packetId);
        out.writeBytes(payload, payload.readerIndex(), len);
        return out;
    }
}
