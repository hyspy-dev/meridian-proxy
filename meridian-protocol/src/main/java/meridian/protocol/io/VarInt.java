package meridian.protocol.io;

import io.netty.buffer.ByteBuf;

import javax.annotation.Nonnull;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteOrder;

/**
 * Static helpers for VarInt encoding/decoding.
 */
public final class VarInt {

    private static final ValueLayout.OfShort BE_SHORT = ValueLayout.JAVA_SHORT_UNALIGNED.withOrder(ByteOrder.BIG_ENDIAN);
    private static final ValueLayout.OfInt BE_INT = ValueLayout.JAVA_INT_UNALIGNED.withOrder(ByteOrder.BIG_ENDIAN);

    private VarInt() {}

    /**
     * Write a varint to the buffer.
     *
     * @throws IllegalArgumentException if value is negative
     */
    public static void write(@Nonnull ByteBuf buf, int value) {
        if (value < 0) {
            throw new IllegalArgumentException("VarInt cannot encode negative values: " + value);
        }
        if ((value & ~0x7F) == 0) {
            buf.writeByte(value);
        } else if ((value & (0xFFFFFFFF << 14)) == 0) {
            buf.writeShort(((value & 0x7F) | 0x80) << 8 | (value >>> 7));
        } else if ((value & (0xFFFFFFFF << 21)) == 0) {
            buf.writeMedium(((value & 0x7F) | 0x80) << 16 | (((value >>> 7) & 0x7F) | 0x80) << 8 | (value >>> 14));
        } else if ((value & (0xFFFFFFFF << 28)) == 0) {
            buf.writeInt(((value & 0x7F) | 0x80) << 24 | (((value >>> 7) & 0x7F) | 0x80) << 16 | (((value >>> 14) & 0x7F) | 0x80) << 8 | (value >>> 21));
        } else {
            buf.writeInt(((value & 0x7F) | 0x80) << 24 | (((value >>> 7) & 0x7F) | 0x80) << 16 | (((value >>> 14) & 0x7F) | 0x80) << 8 | (((value >>> 21) & 0x7F) | 0x80));
            buf.writeByte(value >>> 28);
        }
    }

    /**
     * Read a varint from the buffer, advancing the reader index.
     *
     * @throws ProtocolException if the varint encoding exceeds 5 bytes
     */
    public static int read(@Nonnull ByteBuf buf) {
        int b = buf.readByte();
        int value = b & 0x7F;
        if ((b & 0x80) == 0) return value;
        b = buf.readByte();
        value |= (b & 0x7F) << 7;
        if ((b & 0x80) == 0) return value;
        b = buf.readByte();
        value |= (b & 0x7F) << 14;
        if ((b & 0x80) == 0) return value;
        b = buf.readByte();
        value |= (b & 0x7F) << 21;
        if ((b & 0x80) == 0) return value;
        b = buf.readByte();
        value |= (b & 0x7F) << 28;
        if ((b & 0x80) == 0) return value;
        throw new ProtocolException("VarInt exceeds maximum length (5 bytes)");
    }

    /**
     * Peek varint at absolute index without moving reader.
     *
     * @return the varint value, or -1 if invalid/incomplete
     */
    public static int peek(@Nonnull ByteBuf buf, int index) {
        final int limit = buf.writerIndex();
        if (index >= limit) return -1;
        int b = buf.getByte(index);
        int value = b & 0x7F;
        if ((b & 0x80) == 0) return value;
        if (index + 1 >= limit) return -1;
        b = buf.getByte(index + 1);
        value |= (b & 0x7F) << 7;
        if ((b & 0x80) == 0) return value;
        if (index + 2 >= limit) return -1;
        b = buf.getByte(index + 2);
        value |= (b & 0x7F) << 14;
        if ((b & 0x80) == 0) return value;
        if (index + 3 >= limit) return -1;
        b = buf.getByte(index + 3);
        value |= (b & 0x7F) << 21;
        if ((b & 0x80) == 0) return value;
        if (index + 4 >= limit) return -1;
        b = buf.getByte(index + 4);
        value |= (b & 0x7F) << 28;
        if ((b & 0x80) == 0) return value;

        return -1;
    }

    /**
     * Get varint byte length at index.
     *
     * @return the byte length, or -1 if invalid
     */
    public static int length(@Nonnull ByteBuf buf, int index) {
        final int limit = buf.writerIndex();
        if (index >= limit) return -1;
        if ((buf.getByte(index) & 0x80) == 0) return 1;
        if (index + 1 >= limit) return -1;
        if ((buf.getByte(index + 1) & 0x80) == 0) return 2;
        if (index + 2 >= limit) return -1;
        if ((buf.getByte(index + 2) & 0x80) == 0) return 3;
        if (index + 3 >= limit) return -1;
        if ((buf.getByte(index + 3) & 0x80) == 0) return 4;
        if (index + 4 >= limit) return -1;
        if ((buf.getByte(index + 4) & 0x80) == 0) return 5;
        return -1;
    }

    public static int length(@Nonnull MemorySegment mem, int offset) {
        long packed = getWithLength(mem, offset);
        return packed == -1L ? -1 : (int) (packed >>> 32);
    }

    public static int set(@Nonnull MemorySegment mem, int offset, int value) {
        if (value < 0) {
            throw new IllegalArgumentException("VarInt cannot encode negative values: " + value);
        }
        if ((value & ~0x7F) == 0) {
            mem.set(PacketIO.PROTO_BYTE, offset, (byte) value);
            return 1;
        } else if ((value & (0xFFFFFFFF << 14)) == 0) {
            mem.set(BE_SHORT, offset, (short) (((value & 0x7F) | 0x80) << 8 | (value >>> 7)));
            return 2;
        } else if ((value & (0xFFFFFFFF << 21)) == 0) {
            mem.set(BE_SHORT, offset, (short) (((value & 0x7F) | 0x80) << 8 | (((value >>> 7) & 0x7F) | 0x80)));
            mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) (value >>> 14));
            return 3;
        } else if ((value & (0xFFFFFFFF << 28)) == 0) {
            mem.set(BE_INT, offset, ((value & 0x7F) | 0x80) << 24 | (((value >>> 7) & 0x7F) | 0x80) << 16 | (((value >>> 14) & 0x7F) | 0x80) << 8 | (value >>> 21));
            return 4;
        } else {
            mem.set(BE_INT, offset, ((value & 0x7F) | 0x80) << 24 | (((value >>> 7) & 0x7F) | 0x80) << 16 | (((value >>> 14) & 0x7F) | 0x80) << 8 | (((value >>> 21) & 0x7F) | 0x80));
            mem.set(PacketIO.PROTO_BYTE, offset + 4, (byte) (value >>> 28));
            return 5;
        }
    }

    public static int get(@Nonnull MemorySegment mem, int offset) {
        long packed = getWithLength(mem, offset);
        return packed == -1L ? -1 : (int) packed;
    }

    /**
     * Read a varint value and its encoded byte length in a single pass.
     * Returns a packed long: lower 32 bits = varint value, bits 32-34 = byte length (1-5).
     * Returns -1L if the varint is invalid or incomplete.
     * <p>
     * Extract with: {@code int value = (int) packed;} and {@code int length = (int) (packed >>> 32);}
     */
    public static long getWithLength(@Nonnull MemorySegment mem, int offset) {
        final int limit = (int) mem.byteSize();
        if (offset >= limit) return -1L;
        int b = mem.get(PacketIO.PROTO_BYTE, offset);
        int value = b & 0x7F;
        if ((b & 0x80) == 0) return (1L << 32) | value;
        if (offset + 1 >= limit) return -1L;
        b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        value |= (b & 0x7F) << 7;
        if ((b & 0x80) == 0) return b == 0 ? -1L : (2L << 32) | value;
        if (offset + 2 >= limit) return -1L;
        b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        value |= (b & 0x7F) << 14;
        if ((b & 0x80) == 0) return b == 0 ? -1L : (3L << 32) | value;
        if (offset + 3 >= limit) return -1L;
        b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        value |= (b & 0x7F) << 21;
        if ((b & 0x80) == 0) return b == 0 ? -1L : (4L << 32) | value;
        if (offset + 4 >= limit) return -1L;
        b = mem.get(PacketIO.PROTO_BYTE, offset + 4);
        value |= (b & 0x07) << 28;
        // Only bits 28-31 of an int survive here, so a terminator above 7 would decode to a truncated alias.
        if ((b & 0x80) == 0) return b >= 1 && b <= 7 ? (5L << 32) | value : -1L;

        return -1L;
    }

    /**
     * Compute the number of bytes required to encode a varint value.
     */
    public static int size(int value) {
        if ((value & (0xFFFFFFFF << 7)) == 0) return 1;
        if ((value & (0xFFFFFFFF << 14)) == 0) return 2;
        if ((value & (0xFFFFFFFF << 21)) == 0) return 3;
        if ((value & (0xFFFFFFFF << 28)) == 0) return 4;
        return 5;
    }
}
