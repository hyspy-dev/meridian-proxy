package meridian.proxy;

import io.netty.buffer.ByteBuf;

public final class HytaleVarInt {
    private HytaleVarInt() {}

    public static int read(ByteBuf buf) {
        int result = 0;
        int shift = 0;
        for (int i = 0; i < 5; i++) {
            if (!buf.isReadable()) throw new IllegalStateException("VarInt truncated");
            byte b = buf.readByte();
            result |= (b & 0x7F) << shift;
            if ((b & 0x80) == 0) return result;
            shift += 7;
        }
        throw new IllegalArgumentException("VarInt too big");
    }

    public static void write(ByteBuf buf, int value) {
        while (true) {
            int b = value & 0x7F;
            value >>>= 7;
            if (value == 0) { buf.writeByte(b); return; }
            buf.writeByte(b | 0x80);
        }
    }
}
