package meridian.protocol.io;

import com.github.luben.zstd.Zstd;
import meridian.protocol.Packet;
import meridian.protocol.PacketRegistry;
import meridian.protocol.ProtocolSettings;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import org.joml.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * Utility class for reading and writing protocol data.
 */
public final class PacketIO {
    private PacketIO() {}

    /**
     * Header size for framed packets (4 bytes for packet ID).
     */
    public static final int FRAME_HEADER_SIZE = 4;
    /**
     * Packet header size, 4 bytes for id, 4 bytes for length
     */
    public static final int PACKET_HEADER_SIZE = FRAME_HEADER_SIZE + 4;

    public static final Charset UTF8 = StandardCharsets.UTF_8;
    public static final Charset ASCII = StandardCharsets.US_ASCII;

    // Note: Byte order for protocol data is little-endian. It's pointless for the one byte types but done for consistency.
    public static final ValueLayout.OfBoolean PROTO_BOOL = ValueLayout.JAVA_BOOLEAN.withOrder(ByteOrder.LITTLE_ENDIAN);
    public static final ValueLayout.OfByte PROTO_BYTE = ValueLayout.JAVA_BYTE.withOrder(ByteOrder.LITTLE_ENDIAN);
    public static final ValueLayout.OfShort PROTO_SHORT = ValueLayout.JAVA_SHORT_UNALIGNED.withOrder(ByteOrder.LITTLE_ENDIAN);
    public static final ValueLayout.OfInt PROTO_INT = ValueLayout.JAVA_INT_UNALIGNED.withOrder(ByteOrder.LITTLE_ENDIAN);
    public static final ValueLayout.OfLong PROTO_LONG = ValueLayout.JAVA_LONG_UNALIGNED.withOrder(ByteOrder.LITTLE_ENDIAN);
    public static final ValueLayout.OfFloat PROTO_FLOAT = ValueLayout.JAVA_FLOAT_UNALIGNED.withOrder(ByteOrder.LITTLE_ENDIAN);
    public static final ValueLayout.OfDouble PROTO_DOUBLE = ValueLayout.JAVA_DOUBLE_UNALIGNED.withOrder(ByteOrder.LITTLE_ENDIAN);

    public static final ValueLayout.OfLong UUID_LONG = ValueLayout.JAVA_LONG_UNALIGNED.withOrder(ByteOrder.BIG_ENDIAN);

    // === Shared immutable JOML constants (typed as *fc interfaces to prevent mutation) ===

    public static final Vector2fc ZERO_VECTOR2 = new Vector2f();
    public static final Vector3fc ZERO_VECTOR3 = new Vector3f();
    public static final Vector4fc ZERO_VECTOR4 = new Vector4f();
    public static final Quaternionfc ZERO_QUATERNION = new Quaternionf(0, 0, 0, 0);
    public static final Matrix4fc ZERO_MATRIX = new Matrix4f().zero();

    // === Fixed-length reading ===

    @Nonnull
    public static byte[] readBytes(@Nonnull ByteBuf buf, int offset, int length) {
        byte[] bytes = new byte[length];
        buf.getBytes(offset, bytes);
        return bytes;
    }



    // === Fixed-length string reading ===

    @Nonnull
    public static String readFixedAsciiString(@Nonnull ByteBuf buf, int offset, int length) {
        byte[] bytes = new byte[length];
        buf.getBytes(offset, bytes);
        // Find null terminator
        int end = 0;
        while (end < length && bytes[end] != 0) end++;
        return new String(bytes, 0, end, StandardCharsets.US_ASCII);
    }

    @Nonnull
    public static String readFixedString(@Nonnull ByteBuf buf, int offset, int length) {
        byte[] bytes = new byte[length];
        buf.getBytes(offset, bytes);
        // Find null terminator
        int end = 0;
        while (end < length && bytes[end] != 0) end++;
        return new String(bytes, 0, end, StandardCharsets.UTF_8);
    }

    @Nonnull
    public static String readFixedAsciiString(@Nonnull MemorySegment mem, int offset, int length) {
        byte[] bytes = new byte[length];
        MemorySegment.copy(mem, PROTO_BYTE, offset, bytes, 0, length);
        // Find null terminator
        int end = 0;
        while (end < length && bytes[end] != 0) end++;
        return new String(bytes, 0, end, StandardCharsets.US_ASCII);
    }

    @Nonnull
    public static String readFixedString(@Nonnull MemorySegment mem, int offset, int length) {
        byte[] bytes = new byte[length];
        MemorySegment.copy(mem, PROTO_BYTE, offset, bytes, 0, length);
        // Find null terminator
        int end = 0;
        while (end < length && bytes[end] != 0) end++;
        return new String(bytes, 0, end, StandardCharsets.UTF_8);
    }

    // === Variable-length string reading ===

    @Nonnull
    public static String readVarString(@Nonnull ByteBuf buf, int offset) {
        return readVarString(buf, offset, StandardCharsets.UTF_8);
    }

    @Nonnull
    public static String readVarString(@Nonnull ByteBuf buf, int offset, Charset charset) {
        int len = VarInt.peek(buf, offset);
        int varIntLen = VarInt.length(buf, offset);
        byte[] bytes = new byte[len];
        buf.getBytes(offset + varIntLen, bytes);
        return new String(bytes, charset);
    }

    /**
     * Reads bytes from the buffer, validates they are ASCII (0-127), and returns the decoded string.
     * Combines validation and reading in a single pass over the bytes.
     * @throws ProtocolException if any byte is outside the ASCII range
     */
    @Nonnull
    public static String readValidatedAsciiString(@Nonnull ByteBuf buf, int offset, int length, @Nonnull String fieldName) {
        byte[] bytes = new byte[length];
        buf.getBytes(offset, bytes);
        for (int i = 0; i < length; i++) {
            if ((bytes[i] & 0xFF) > 127) {
                throw ProtocolException.invalidAsciiString(fieldName);
            }
        }
        return new String(bytes, StandardCharsets.US_ASCII);
    }

    @Nonnull
    public static String readVarString(String fieldName, @Nonnull MemorySegment mem, int offset, int minLength, int maxLength) {
        return readVarString(fieldName, mem, offset, minLength, maxLength, VarInt.getWithLength(mem, offset));
    }

    /** The packed parameter is the VarInt.getWithLength result for offset, so a caller that already decoded the prefix does not decode it twice. */
    @Nonnull
    public static String readVarString(String fieldName, @Nonnull MemorySegment mem, int offset, int minLength, int maxLength, long packed) {
        int len = (int) packed;
        if (len == -1) throw ProtocolException.invalidVarInt(fieldName);
        if (len > maxLength) throw ProtocolException.stringTooLong(fieldName, len, maxLength);
        if (len < minLength) throw ProtocolException.stringTooShort(fieldName, len, minLength);
        int varIntLen = (int) (packed >>> 32);
        if (offset + len + varIntLen > mem.byteSize()) throw ProtocolException.bufferTooSmall(fieldName, len + varIntLen, (int) (mem.byteSize() - offset));
        byte[] bytes = new byte[len];
        MemorySegment.copy(mem, PROTO_BYTE, offset + varIntLen, bytes, 0, len);
        if (!isWellFormedUtf8(bytes)) throw ProtocolException.malformedString(fieldName);
        return new String(bytes, UTF8);
    }

    /**
     * Table 3-7 of the Unicode standard. Decoding substitutes U+FFFD rather than rejecting, and Java and
     * .NET disagree on how many it substitutes for one ill-formed sequence, so neither the decoded length
     * nor a re-encoded length is a portable test. Both decode walks have to accept exactly the same bytes,
     * or one end rejects a payload the other end accepted.
     */
    public static boolean isWellFormedUtf8(@Nonnull byte[] bytes) {
        int i = 0;
        while (i < bytes.length) {
            int b0 = bytes[i] & 0xFF;
            int lower, upper, trail;
            if (b0 < 0x80) {
                i++;
                continue;
            }
            if (b0 < 0xC2 || b0 > 0xF4) return false;
            if (b0 < 0xE0) {
                lower = 0x80;
                upper = 0xBF;
                trail = 1;
            } else if (b0 < 0xF0) {
                lower = b0 == 0xE0 ? 0xA0 : 0x80;
                upper = b0 == 0xED ? 0x9F : 0xBF;
                trail = 2;
            } else {
                lower = b0 == 0xF0 ? 0x90 : 0x80;
                upper = b0 == 0xF4 ? 0x8F : 0xBF;
                trail = 3;
            }
            if (i + trail >= bytes.length) return false;
            int b1 = bytes[i + 1] & 0xFF;
            if (b1 < lower || b1 > upper) return false;
            for (int k = 2; k <= trail; k++) {
                int bk = bytes[i + k] & 0xFF;
                if (bk < 0x80 || bk > 0xBF) return false;
            }
            i += trail + 1;
        }
        return true;
    }

    @Nonnull
    public static String readVarString(String fieldName, @Nonnull MemorySegment mem, int offset, int maxLength) {
        return readVarString(fieldName, mem, offset, 0, maxLength);
    }

    /**
     * Reads a length-prefixed ASCII string from a MemorySegment, validating every byte is in
     * the ASCII range (0-127). Mirrors {@link #readValidatedAsciiString(ByteBuf, int, int, String)}
     * so FFM-emitted readers reject non-ASCII payloads instead of silently replacing bytes with
     * {@code ?} via {@link java.nio.charset.StandardCharsets#US_ASCII}.
     */
    @Nonnull
    public static String readValidatedAsciiString(String fieldName, @Nonnull MemorySegment mem, int offset, int minLength, int maxLength) {
        return readValidatedAsciiString(fieldName, mem, offset, minLength, maxLength, VarInt.getWithLength(mem, offset));
    }

    /** The packed parameter is the VarInt.getWithLength result for offset, so a caller that already decoded the prefix does not decode it twice. */
    @Nonnull
    public static String readValidatedAsciiString(String fieldName, @Nonnull MemorySegment mem, int offset, int minLength, int maxLength, long packed) {
        int len = (int) packed;
        if (len == -1) throw ProtocolException.invalidVarInt(fieldName);
        if (len > maxLength) throw ProtocolException.stringTooLong(fieldName, len, maxLength);
        if (len < minLength) throw ProtocolException.stringTooShort(fieldName, len, minLength);
        int varIntLen = (int) (packed >>> 32);
        if (offset + len + varIntLen > mem.byteSize()) throw ProtocolException.bufferTooSmall(fieldName, len + varIntLen, (int) (mem.byteSize() - offset));
        byte[] bytes = new byte[len];
        MemorySegment.copy(mem, PROTO_BYTE, offset + varIntLen, bytes, 0, len);
        for (int i = 0; i < len; i++) {
            if ((bytes[i] & 0xFF) > 127) {
                throw ProtocolException.invalidAsciiString(fieldName);
            }
        }
        return new String(bytes, StandardCharsets.US_ASCII);
    }

    @Nonnull
    public static String readValidatedAsciiString(String fieldName, @Nonnull MemorySegment mem, int offset, int maxLength) {
        return readValidatedAsciiString(fieldName, mem, offset, 0, maxLength);
    }

    // === Finite validation ===

    /**
     * Returns {@code value} if it is finite (not NaN and not infinite), otherwise throws a {@link ProtocolException}.
     * Apply to any {@code float} field that must carry only valid finite wire values.
     */
    public static float requireFinite(float value, @Nonnull String fieldName) {
        if (!Float.isFinite(value)) {
            throw ProtocolException.valueNotFinite(fieldName, value);
        }
        return value;
    }

    /** Returns {@code value} if it is finite, otherwise throws. See {@link #requireFinite(float, String)}. */
    public static double requireFinite(double value, @Nonnull String fieldName) {
        if (!Double.isFinite(value)) {
            throw ProtocolException.valueNotFinite(fieldName, value);
        }
        return value;
    }

    // The float-backed composites (Vector2/3/4, Quaternion, Matrix4x4) are serialized via the hand-written
    // natives above rather than as decomposed fields, so the finite-by-default check is applied here, once
    // per type: every IEEE-754 component must be finite. isFinite is the no-throw form used by the structural
    // validator; requireFinite throws (via ProtocolException) and is used on the read and write paths. The
    // generated code calls these uniformly for any float-backed field — overload resolution picks the type.

    /** True if {@code value} is finite. No-throw counterpart of {@link #requireFinite(float, String)}, used by the structural validator. */
    public static boolean isFinite(float value) {
        return Float.isFinite(value);
    }

    /** True if {@code value} is finite. No-throw counterpart of {@link #requireFinite(double, String)}, used by the structural validator. */
    public static boolean isFinite(double value) {
        return Double.isFinite(value);
    }

    /** True if every component of {@code v} is finite. */
    public static boolean isFinite(@Nonnull Vector2fc v) {
        return Float.isFinite(v.x()) && Float.isFinite(v.y());
    }

    /** True if every component of {@code v} is finite. */
    public static boolean isFinite(@Nonnull Vector3fc v) {
        return Float.isFinite(v.x()) && Float.isFinite(v.y()) && Float.isFinite(v.z());
    }

    /** True if every component of {@code v} is finite. */
    public static boolean isFinite(@Nonnull Vector4fc v) {
        return Float.isFinite(v.x()) && Float.isFinite(v.y()) && Float.isFinite(v.z()) && Float.isFinite(v.w());
    }

    /** True if every component of {@code q} is finite. */
    public static boolean isFinite(@Nonnull Quaternionfc q) {
        return Float.isFinite(q.x()) && Float.isFinite(q.y()) && Float.isFinite(q.z()) && Float.isFinite(q.w());
    }

    /** True if every one of the 16 components of {@code m} is finite. */
    public static boolean isFinite(@Nonnull Matrix4fc m) {
        return Float.isFinite(m.m00()) && Float.isFinite(m.m01()) && Float.isFinite(m.m02()) && Float.isFinite(m.m03())
            && Float.isFinite(m.m10()) && Float.isFinite(m.m11()) && Float.isFinite(m.m12()) && Float.isFinite(m.m13())
            && Float.isFinite(m.m20()) && Float.isFinite(m.m21()) && Float.isFinite(m.m22()) && Float.isFinite(m.m23())
            && Float.isFinite(m.m30()) && Float.isFinite(m.m31()) && Float.isFinite(m.m32()) && Float.isFinite(m.m33());
    }

    /** Returns {@code v} if every component is finite, otherwise throws. Composite counterpart of {@link #requireFinite(float, String)}. */
    @Nonnull
    public static Vector2fc requireFinite(@Nonnull Vector2fc v, @Nonnull String fieldName) {
        if (!isFinite(v)) {
            throw ProtocolException.valueNotFinite(fieldName, v);
        }
        return v;
    }

    /** Returns {@code v} if every component is finite, otherwise throws. Composite counterpart of {@link #requireFinite(float, String)}. */
    @Nonnull
    public static Vector3fc requireFinite(@Nonnull Vector3fc v, @Nonnull String fieldName) {
        if (!isFinite(v)) {
            throw ProtocolException.valueNotFinite(fieldName, v);
        }
        return v;
    }

    /** Returns {@code v} if every component is finite, otherwise throws. Composite counterpart of {@link #requireFinite(float, String)}. */
    @Nonnull
    public static Vector4fc requireFinite(@Nonnull Vector4fc v, @Nonnull String fieldName) {
        if (!isFinite(v)) {
            throw ProtocolException.valueNotFinite(fieldName, v);
        }
        return v;
    }

    /** Returns {@code q} if every component is finite, otherwise throws. Composite counterpart of {@link #requireFinite(float, String)}. */
    @Nonnull
    public static Quaternionfc requireFinite(@Nonnull Quaternionfc q, @Nonnull String fieldName) {
        if (!isFinite(q)) {
            throw ProtocolException.valueNotFinite(fieldName, q);
        }
        return q;
    }

    /** Returns {@code m} if every component is finite, otherwise throws. Composite counterpart of {@link #requireFinite(float, String)}. */
    @Nonnull
    public static Matrix4fc requireFinite(@Nonnull Matrix4fc m, @Nonnull String fieldName) {
        if (!isFinite(m)) {
            throw ProtocolException.valueNotFinite(fieldName, m);
        }
        return m;
    }

    // === String size calculation ===

    /**
     * Compute the number of UTF-8 bytes needed to encode a string.
     * This avoids actually encoding the string just to get its byte count.
     */
    public static int utf8ByteLength(@Nonnull String s) {
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 0x80) {
                len++;
            } else if (c < 0x800) {
                len += 2;
            } else if (Character.isHighSurrogate(c)) {
                len += 4;
                i++; // Skip the low surrogate
            } else {
                len += 3;
            }
        }
        return len;
    }

    /**
     * Compute the total wire size of a VarInt-prefixed UTF-8 string.
     * This is VarInt.size(byteLength) + byteLength, computed without double-encoding.
     */
    public static int stringSize(@Nonnull String s) {
        int len = utf8ByteLength(s);
        return VarInt.size(len) + len;
    }

    // === Fixed-length writing ===

    public static void writeFixedAsciiString(@Nonnull ByteBuf buf, @Nullable String value, int length) {
        if (value != null) {
            byte[] bytes = value.getBytes(StandardCharsets.US_ASCII);
            if (bytes.length > length) {
                throw new ProtocolException("Fixed ASCII string exceeds length: " + bytes.length + " > " + length);
            }
            buf.writeBytes(bytes);
            buf.writeZero(length - bytes.length);
        } else {
            buf.writeZero(length);
        }
    }

    public static void writeFixedString(@Nonnull ByteBuf buf, @Nullable String value, int length) {
        if (value != null) {
            byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
            if (bytes.length > length) {
                throw new ProtocolException("Fixed UTF-8 string exceeds length: " + bytes.length + " > " + length);
            }
            buf.writeBytes(bytes);
            buf.writeZero(length - bytes.length);
        } else {
            buf.writeZero(length);
        }
    }

    public static void writeVarString(@Nonnull ByteBuf buf, @Nonnull String value, int maxLength) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        if (bytes.length > maxLength) {
            throw new ProtocolException("String exceeds max bytes: " + bytes.length + " > " + maxLength);
        }
        VarInt.write(buf, bytes.length);
        buf.writeBytes(bytes);
    }

    public static void writeVarAsciiString(@Nonnull ByteBuf buf, @Nonnull String value, int maxLength) {
        byte[] bytes = value.getBytes(StandardCharsets.US_ASCII);
        if (bytes.length > maxLength) {
            throw new ProtocolException("String exceeds max bytes: " + bytes.length + " > " + maxLength);
        }
        VarInt.write(buf, bytes.length);
        buf.writeBytes(bytes);
    }

    public static int writeVarString(@Nonnull MemorySegment mem, int offset, @Nonnull String value, int maxLength) {
        byte[] bytes = value.getBytes(PacketIO.UTF8);
        if (bytes.length > maxLength) {
            throw new ProtocolException("String exceeds max bytes: " + bytes.length + " > " + maxLength);
        }
        var len = VarInt.set(mem, offset, bytes.length);
        MemorySegment.copy(bytes, 0, mem, ValueLayout.JAVA_BYTE, offset + len, bytes.length);
        return len + bytes.length;
    }

    public static int writeVarAsciiString(@Nonnull MemorySegment mem, int offset, @Nonnull String value, int maxLength) {
        byte[] bytes = value.getBytes(PacketIO.ASCII);
        if (bytes.length > maxLength) {
            throw new ProtocolException("String exceeds max bytes: " + bytes.length + " > " + maxLength);
        }
        var len = VarInt.set(mem, offset, bytes.length);
        MemorySegment.copy(bytes, 0, mem, ValueLayout.JAVA_BYTE, offset + len, bytes.length);
        return len + bytes.length;
    }

    // === JOML vector/matrix reading (little-endian) ===




    @Nonnull
    public static Vector2f readVector2f(@Nonnull MemorySegment mem, int offset) {
        return new Vector2f(mem.get(PROTO_FLOAT, offset), mem.get(PROTO_FLOAT, offset + 4));
    }

    @Nonnull
    public static Vector3f readVector3f(@Nonnull MemorySegment mem, int offset) {
        return new Vector3f(mem.get(PROTO_FLOAT, offset), mem.get(PROTO_FLOAT, offset + 4), mem.get(PROTO_FLOAT, offset + 8));
    }

    @Nonnull
    public static Vector4f readVector4f(@Nonnull MemorySegment mem, int offset) {
        return new Vector4f(mem.get(PROTO_FLOAT, offset), mem.get(PROTO_FLOAT, offset + 4), mem.get(PROTO_FLOAT, offset + 8), mem.get(PROTO_FLOAT, offset + 12));
    }

    @Nonnull
    public static Quaternionf readQuaternionf(@Nonnull MemorySegment mem, int offset) {
        return new Quaternionf(mem.get(PROTO_FLOAT, offset), mem.get(PROTO_FLOAT, offset + 4), mem.get(PROTO_FLOAT, offset + 8), mem.get(PROTO_FLOAT, offset + 12));
    }

    // === JOML vector/matrix writing (little-endian) ===




    public static void writeVector2f(@Nonnull MemorySegment mem, int offset, @Nonnull Vector2fc v) {
        mem.set(PROTO_FLOAT, offset, v.x());
        mem.set(PROTO_FLOAT, offset + 4, v.y());
    }

    public static void writeVector3f(@Nonnull MemorySegment mem, int offset, @Nonnull Vector3fc v) {
        mem.set(PROTO_FLOAT, offset, v.x());
        mem.set(PROTO_FLOAT, offset + 4, v.y());
        mem.set(PROTO_FLOAT, offset + 8, v.z());
    }

    public static void writeVector4f(@Nonnull MemorySegment mem, int offset, @Nonnull Vector4fc v) {
        mem.set(PROTO_FLOAT, offset, v.x());
        mem.set(PROTO_FLOAT, offset + 4, v.y());
        mem.set(PROTO_FLOAT, offset + 8, v.z());
        mem.set(PROTO_FLOAT, offset + 12, v.w());
    }

    public static void writeQuaternionf(@Nonnull MemorySegment mem, int offset, @Nonnull Quaternionfc q) {
        mem.set(PROTO_FLOAT, offset, q.x());
        mem.set(PROTO_FLOAT, offset + 4, q.y());
        mem.set(PROTO_FLOAT, offset + 8, q.z());
        mem.set(PROTO_FLOAT, offset + 12, q.w());
    }

    public static void writeFixedAsciiString(@Nonnull MemorySegment mem, int offset, @Nullable String value, int length) {
        if (value != null) {
            byte[] bytes = value.getBytes(StandardCharsets.US_ASCII);
            if (bytes.length > length) {
                throw new ProtocolException("Fixed ASCII string exceeds length: " + bytes.length + " > " + length);
            }
            MemorySegment.copy(bytes, 0, mem, PROTO_BYTE, offset, bytes.length);
            mem.asSlice(offset + bytes.length, length - bytes.length).fill((byte) 0);
        } else {
            mem.asSlice(offset, length).fill((byte) 0);
        }
    }

    public static void writeFixedString(@Nonnull MemorySegment mem, int offset, @Nullable String value, int length) {
        if (value != null) {
            byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
            if (bytes.length > length) {
                throw new ProtocolException("Fixed UTF-8 string exceeds length: " + bytes.length + " > " + length);
            }
            MemorySegment.copy(bytes, 0, mem, PROTO_BYTE, offset, bytes.length);
            mem.asSlice(offset + bytes.length, length - bytes.length).fill((byte) 0);
        } else {
            mem.asSlice(offset, length).fill((byte) 0);
        }
    }

    // === UUID (RFC 4122 big-endian format) ===

    @Nonnull
    public static UUID readUUID(@Nonnull ByteBuf buf, int offset) {
        long mostSig = buf.getLong(offset);
        long leastSig = buf.getLong(offset + 8);
        return new UUID(mostSig, leastSig);
    }

    public static void writeUUID(@Nonnull ByteBuf buf, @Nonnull UUID value) {
        buf.writeLong(value.getMostSignificantBits());
        buf.writeLong(value.getLeastSignificantBits());
    }

    @Nonnull
    public static UUID readUUID(@Nonnull MemorySegment mem, int offset) {
        long mostSig = mem.get(UUID_LONG, offset);
        long leastSig = mem.get(UUID_LONG, offset + 8);
        return new UUID(mostSig, leastSig);
    }

    public static void writeUUID(@Nonnull MemorySegment mem, int offset, @Nonnull UUID value) {
        mem.set(UUID_LONG, offset, value.getMostSignificantBits());
        mem.set(UUID_LONG, offset + 8, value.getLeastSignificantBits());
    }

    // === Half-float conversion ===

    public static float halfToFloat(short half) {
        int h = half & 0xFFFF;
        int sign = (h >>> 15) & 0x1;
        int exp = (h >>> 10) & 0x1F;
        int mant = h & 0x3FF;

        if (exp == 0) {
            if (mant == 0) return sign == 0 ? 0.0f : -0.0f;
            // Denormalized
            exp = 1;
            while ((mant & 0x400) == 0) {
                mant <<= 1;
                exp--;
            }
            mant &= 0x3FF;
        } else if (exp == 31) {
            return mant == 0 ? (sign == 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY) : Float.NaN;
        }

        int floatBits = (sign << 31) | ((exp + 112) << 23) | (mant << 13);
        return Float.intBitsToFloat(floatBits);
    }

    public static short floatToHalf(float f) {
        int bits = Float.floatToRawIntBits(f);
        int sign = (bits >>> 16) & 0x8000;
        int val = (bits & 0x7FFFFFFF) + 0x1000;

        if (val >= 0x47800000) {
            if ((bits & 0x7FFFFFFF) >= 0x47800000) {
                if (val < 0x7F800000) return (short) (sign | 0x7C00);
                return (short) (sign | 0x7C00 | ((bits & 0x007FFFFF) >>> 13));
            }
            return (short) (sign | 0x7BFF);
        }
        if (val >= 0x38800000) return (short) (sign | ((val - 0x38000000) >>> 13));
        if (val < 0x33000000) return (short) sign;
        val = (bits & 0x7FFFFFFF) >>> 23;
        return (short) (sign | (((bits & 0x7FFFFF) | 0x800000) + (0x800000 >>> (val - 102))) >>> (126 - val));
    }

    // === Zstd Compression ===

    /**
     * Zstd compression level (1-22, default 3). Higher = better compression but slower.
     */
    private static final int COMPRESSION_LEVEL = Integer.getInteger("hytale.protocol.compressionLevel", Zstd.defaultCompressionLevel());

    /**
     * Compress data from source ByteBuf to destination ByteBuf.
     * Automatically handles direct vs heap buffers - uses zero-copy for direct buffers,
     * falls back to byte[] API for heap buffers.
     *
     * @return compressed size
     */
    private static int compressToBuffer(@Nonnull ByteBuf src, @Nonnull ByteBuf dst, int dstOffset, int maxDstSize) {
        // Use direct ByteBuffer API if both buffers are direct
        if (src.isDirect() && dst.isDirect()) {
            return Zstd.compress(dst.nioBuffer(dstOffset, maxDstSize), src.nioBuffer(), COMPRESSION_LEVEL);
        }

        // Fall back to byte[] API for heap buffers
        int srcSize = src.readableBytes();
        byte[] srcBytes = new byte[srcSize];
        src.getBytes(src.readerIndex(), srcBytes);
        byte[] compressed = Zstd.compress(srcBytes, COMPRESSION_LEVEL);
        dst.setBytes(dstOffset, compressed);
        return compressed.length;
    }

    /**
     * Decompress data from source ByteBuf.
     * Automatically handles direct vs heap buffers.
     *
     * @return new ByteBuf containing decompressed data (caller must release)
     */
    @Nonnull
    private static ByteBuf decompressFromBuffer(@Nonnull ByteBufAllocator allocator, @Nonnull ByteBuf src, int srcOffset, int srcLength, int maxDecompressedSize) {
        // Compressed size should always be <= decompressed size
        if (srcLength > maxDecompressedSize) {
            throw new ProtocolException("Compressed size " + srcLength + " exceeds max decompressed size " + maxDecompressedSize);
        }

        // Direct buffer path - use ByteBuffer APIs
        if (src.isDirect()) {
            var srcNio = src.nioBuffer(srcOffset, srcLength);

            long decompressedSize = Zstd.getFrameContentSize(srcNio);
            if (decompressedSize < 0) {
                throw new ProtocolException("Invalid Zstd frame or unknown content size");
            }
            if (decompressedSize > maxDecompressedSize) {
                throw new ProtocolException("Decompressed size " + decompressedSize + " exceeds maximum " + maxDecompressedSize);
            }

            var dst = allocator.directBuffer((int) decompressedSize);
            try {
                var dstNio = dst.nioBuffer(0, (int) decompressedSize);

                int result = Zstd.decompress(dstNio, srcNio);
                if (Zstd.isError(result)) {
                    throw new ProtocolException("Zstd decompression failed: " + Zstd.getErrorName(result));
                }
                dst.writerIndex(result);
                return dst;
            } catch (Exception e) {
                dst.release();
                throw e;
            }
        }

        // Heap buffer path - use byte[] APIs (getFrameContentSize(ByteBuffer) requires direct)
        byte[] srcBytes = new byte[srcLength];
        src.getBytes(srcOffset, srcBytes);

        long decompressedSize = Zstd.getFrameContentSize(srcBytes);
        if (decompressedSize < 0) {
            throw new ProtocolException("Invalid Zstd frame or unknown content size");
        }
        if (decompressedSize > maxDecompressedSize) {
            throw new ProtocolException("Decompressed size " + decompressedSize + " exceeds maximum " + maxDecompressedSize);
        }

        byte[] decompressed = Zstd.decompress(srcBytes, (int) decompressedSize);
        return Unpooled.wrappedBuffer(decompressed);
    }

    private static MemorySegment decompressFromBuffer(@Nonnull MemorySegment decompressionContext, @Nonnull Arena arena, @Nonnull MemorySegment src, int srcOffset, int srcLength, int maxDecompressedSize) {
        // Compressed size should always be <= decompressed size
        if (srcLength > maxDecompressedSize) {
            throw new ProtocolException("Compressed size " + srcLength + " exceeds max decompressed size " + maxDecompressedSize);
        }

        var srcBuf = src.asSlice(srcOffset, srcLength);

        var decompressedSize = ZstdNative.getFrameContentSize(srcBuf, srcLength);
        if (decompressedSize < 0) {
            throw new ProtocolException("Invalid Zstd frame or unknown content size");
        }
        if (decompressedSize > maxDecompressedSize) {
            throw new ProtocolException("Decompressed size " + decompressedSize + " exceeds maximum " + maxDecompressedSize);
        }

        var dst = arena.allocate((int) decompressedSize);
        var result = ZstdNative.decompressDCtx(decompressionContext, dst, dst.byteSize(), srcBuf, srcLength);
        if (ZstdNative.isError(result)) {
            throw new ProtocolException("Decompression failed with error code: " + ZstdNative.getErrorName(result));
        }
        return dst;
    }

    // === Framed Packet I/O ===

    /**
     * Write a packet with framing, using an explicit packet class for registry lookup.
     * This is needed for CachedPacket where the actual class differs from the registered type.
     * Wire format: [4-byte payload length] [4-byte packet ID] [payload]
     *
     * @param packet        the packet to write
     * @param packetClass   the class to use for registry lookup
     * @param out           the ByteBuf to write to
     * @param allocator     the buffer allocator to use for temporary buffers
     * @param statsRecorder the recorder for capturing packet statistics
     */
    public static void writeFramedPacket(@Nonnull Packet packet, @Nonnull Class<? extends Packet> packetClass, @Nonnull ByteBuf out, @Nonnull ByteBufAllocator allocator, @Nonnull PacketStatsRecorder statsRecorder) {
        var id = PacketRegistry.getId(packetClass);
        if (id == null) {
            throw new ProtocolException("Unknown packet type: " + packetClass.getName());
        }
        var info = PacketRegistry.getToClientPacketById(id);
        writeFramedPacketWithInfo(packet, info, out, allocator, statsRecorder);
    }

    public static void writeFramedPacketWithInfo(@Nonnull Packet packet, @Nonnull PacketRegistry.PacketInfo info, @Nonnull ByteBuf out, @Nonnull ByteBufAllocator allocator, @Nonnull PacketStatsRecorder statsRecorder) {
        int lengthIndex = out.writerIndex();
        out.writeIntLE(0);
        out.writeIntLE(info.id());

        if (info.compressed()) {
            writeCompressed(packet, info, info.id(), out, allocator, statsRecorder, lengthIndex);
        } else {
            writeUncompressed(packet, info, info.id(), out, statsRecorder, lengthIndex);
        }
    }

    private static void writeCompressed(@Nonnull Packet packet, @Nonnull PacketRegistry.PacketInfo info, int id, @Nonnull ByteBuf out, @Nonnull ByteBufAllocator allocator, @Nonnull PacketStatsRecorder statsRecorder, int lengthIndex) {
        int serializedSize = packet.computeSize();
        if (serializedSize > info.maxSize()) {
            throw new ProtocolException("Packet " + info.name() + " serialized to " + serializedSize + " bytes, exceeds max size " + info.maxSize());
        }

        if (serializedSize == 0) {
            out.setIntLE(lengthIndex, 0);
            statsRecorder.recordSend(id, 0, 0);
            return;
        }

        // Serialize to temporary buffer (needed because we may compress)
        var payloadBuf = allocator.buffer(serializedSize);
        try {
            serializeInto(packet, payloadBuf, serializedSize);

            int compressBound = (int) Zstd.compressBound(serializedSize);
            out.ensureWritable(compressBound);

            int compressedSize = compressToBuffer(payloadBuf, out, out.writerIndex(), compressBound);
            if (Zstd.isError(compressedSize)) {
                throw new ProtocolException("Zstd compression failed: " + Zstd.getErrorName(compressedSize));
            }
            if (compressedSize > ProtocolSettings.MAX_PACKET_SIZE) {
                throw new ProtocolException("Packet " + info.name() + " compressed payload size " + compressedSize + " exceeds protocol maximum");
            }

            out.writerIndex(out.writerIndex() + compressedSize);
            out.setIntLE(lengthIndex, compressedSize);
            statsRecorder.recordSend(id, serializedSize, compressedSize);
        } finally {
            payloadBuf.release();
        }
    }

    private static void writeUncompressed(@Nonnull Packet packet, @Nonnull PacketRegistry.PacketInfo info, int id, @Nonnull ByteBuf out, @Nonnull PacketStatsRecorder statsRecorder, int lengthIndex) {
        // computeSize is exact, so the size limits are checked before anything is written rather than by
        // rewinding afterwards.
        int serializedSize = packet.computeSize();
        if (serializedSize > info.maxSize()) {
            out.writerIndex(lengthIndex);
            throw new ProtocolException("Packet " + info.name() + " serialized to " + serializedSize + " bytes, exceeds max size " + info.maxSize());
        }
        if (serializedSize > ProtocolSettings.MAX_PACKET_SIZE) {
            out.writerIndex(lengthIndex);
            throw new ProtocolException("Packet " + info.name() + " payload size " + serializedSize + " exceeds protocol maximum");
        }

        int written = serializeInto(packet, out, serializedSize);
        out.setIntLE(lengthIndex, written);
        statsRecorder.recordSend(id, written, 0);
    }

    /**
     * Serializes a packet onto the end of a buffer with the FFM writer and advances the writer index.
     *
     * @param size the exact encoded size from {@link Packet#computeSize()}, already known to the caller
     * @return the number of bytes written
     */
    private static int serializeInto(@Nonnull Packet packet, @Nonnull ByteBuf out, int size) {
        if (size == 0) return 0;

        out.ensureWritable(size);
        int index = out.writerIndex();

        int written;
        if (out.hasArray()) {
            written = packet.serialize(MemorySegment.ofArray(out.array()).asSlice(out.arrayOffset() + index, size), 0);
        } else if (out.isDirect() && out.nioBufferCount() == 1) {
            written = packet.serialize(MemorySegment.ofBuffer(out.nioBuffer(index, size)), 0);
        } else {
            var scratch = new byte[size];
            written = packet.serialize(MemorySegment.ofArray(scratch), 0);
            out.setBytes(index, scratch, 0, written);
        }

        out.writerIndex(index + written);
        return written;
    }

    /**
     * Read a framed packet from a ByteBuf.
     * The buffer should be positioned at the packet ID (after the length prefix has been consumed).
     * Handles decompression based on packet definition.
     * Wire format: [4-byte payload length] [4-byte packet ID] [payload]
     *
     * @param in            the ByteBuf positioned at packet ID
     * @param payloadLength the payload length (not including packet ID)
     * @param allocator     the buffer allocator to use for decompression buffers
     * @param statsRecorder the recorder for capturing packet statistics
     * @return the deserialized packet, or null if packet ID is unknown
     */
    @Nonnull
    public static Packet readFramedPacket(@Nonnull ByteBuf in, int payloadLength, @Nonnull ByteBufAllocator allocator, @Nonnull PacketStatsRecorder statsRecorder) {
        int packetId = in.readIntLE();
        var info = PacketRegistry.getToServerPacketById(packetId);
        if (info == null) {
            in.skipBytes(payloadLength);
            throw new ProtocolException("Unknown packet ID: " + packetId);
        }

        return readFramedPacketWithInfo(in, payloadLength, allocator, info, statsRecorder);
    }

    /**
     * Read a framed packet with pre-validated PacketInfo (packet ID and size already validated).
     * Used by PacketDecoder for fail-fast validation - packet ID is validated before waiting for payload.
     *
     * @param in            the ByteBuf positioned at payload start (after packet ID)
     * @param payloadLength the payload length (already validated against info.maxSize())
     * @param allocator     the buffer allocator to use for decompression buffers
     * @param info          the pre-validated packet info
     * @param statsRecorder the recorder for capturing packet statistics
     * @return the deserialized packet
     */
    @Nonnull
    public static Packet readFramedPacketWithInfo(@Nonnull ByteBuf in, int payloadLength, @Nonnull ByteBufAllocator allocator, @Nonnull PacketRegistry.PacketInfo info, @Nonnull PacketStatsRecorder statsRecorder) {
        ByteBuf payload;
        int uncompressedSize;
        int compressedSize = 0;

        if (info.compressed() && payloadLength > 0) {
            try {
                payload = decompressFromBuffer(allocator, in, in.readerIndex(), payloadLength, info.maxSize());
            } catch (ProtocolException e) {
                in.skipBytes(payloadLength);
                throw e;
            }
            in.skipBytes(payloadLength);
            uncompressedSize = payload.readableBytes();
            compressedSize = payloadLength;
        } else if (payloadLength > 0) {
            payload = in.readRetainedSlice(payloadLength);
            uncompressedSize = payloadLength;
        } else {
            payload = Unpooled.EMPTY_BUFFER;
            uncompressedSize = 0;
        }

        try {
            var packet = info.toObject().deserialize(asSegment(payload, uncompressedSize), 0);
            statsRecorder.recordReceive(info.id(), uncompressedSize, compressedSize);
            return packet;
        } finally {
            if (payloadLength > 0) {
                payload.release();
            }
        }
    }

    /**
     * Views the readable bytes of a buffer as a MemorySegment so the FFM readers can decode it.
     * <p>
     * The segment borrows the buffer's memory and must not outlive it. PacketDecoder installs a
     * ByteToMessageDecoder, whose default cumulator consolidates input into one component, so the
     * copying branch is a safety net rather than the expected path.
     */
    @Nonnull
    private static MemorySegment asSegment(@Nonnull ByteBuf buf, int length) {
        if (length == 0) return MemorySegment.ofArray(EMPTY_PAYLOAD);

        int index = buf.readerIndex();
        if (buf.hasArray()) return MemorySegment.ofArray(buf.array()).asSlice(buf.arrayOffset() + index, length);
        if (buf.isDirect() && buf.nioBufferCount() == 1) return MemorySegment.ofBuffer(buf.nioBuffer(index, length));

        var bytes = new byte[length];
        buf.getBytes(index, bytes);
        return MemorySegment.ofArray(bytes);
    }

    private static final byte[] EMPTY_PAYLOAD = new byte[0];

    public static int writeFramedPacket(@Nonnull MemorySegment compressionContext, @Nonnull Packet packet, @Nonnull PacketRegistry.PacketInfo packetInfo, @Nonnull MemorySegment out, int offset, int packetSize, @Nonnull PacketStatsRecorder statsRecorder) {
        out.set(PROTO_INT, offset + 4, packetInfo.id());
        var dataStart = offset + PACKET_HEADER_SIZE;
        if (packetInfo.compressed()) {
            try (var arena = Arena.ofConfined()) {
                var compressionTarget = out.asSlice(dataStart);
                var src = arena.allocate(packetSize);
                packet.serialize(src, 0);

                if (packetSize > packetInfo.maxSize()) {
                    throw new ProtocolException("Packet " + packetInfo.name() + " serialized to " + packetSize + " bytes, exceeds max size " + packetInfo.maxSize());
                }

                var result = ZstdNative.compressCCtx(compressionContext, compressionTarget, compressionTarget.byteSize(), src, src.byteSize(), COMPRESSION_LEVEL);
                if (ZstdNative.isError(result)) {
                    throw new ProtocolException("Zstd compression failed: " + ZstdNative.getErrorName(result));
                }

                if (result > ProtocolSettings.MAX_PACKET_SIZE) {
                    throw new ProtocolException("Packet " + packetInfo.name() + " compressed payload size " + result + " exceeds protocol maximum");
                }

                out.set(PROTO_INT, offset, (int) result);
                statsRecorder.recordSend(packetInfo.id(), packetSize, (int) result);
                return (int) (result + PACKET_HEADER_SIZE);
            }
        } else {
            var size = packet.serialize(out, dataStart);

            if (size > packetInfo.maxSize()) {
                throw new ProtocolException("Packet " + packetInfo.name() + " serialized to " + size + " bytes, exceeds max size " + packetInfo.maxSize());
            }
            if (size > ProtocolSettings.MAX_PACKET_SIZE) {
                throw new ProtocolException("Packet " + packetInfo.name() + " payload size " + size + " exceeds protocol maximum");
            }

            out.set(PROTO_INT, offset, size);
            statsRecorder.recordSend(packetInfo.id(), size, 0);
            return size + PACKET_HEADER_SIZE;
        }
    }

    @Nonnull
    public static Packet readFramedPacket(@Nonnull MemorySegment decompressionContext, @Nonnull MemorySegment in, int payloadLength, @Nonnull PacketStatsRecorder statsRecorder) {
        int packetId = in.get(PacketIO.PROTO_INT, 0);
        var info = PacketRegistry.getToServerPacketById(packetId);
        if (info == null) {
            throw new ProtocolException("Unknown packet ID: " + packetId);
        }
        if (payloadLength > info.maxSize()) {
            throw new ProtocolException("Packet " + info.name() + " payload size " + payloadLength + " exceeds max size " + info.maxSize());
        }

        return readFramedPacketWithInfo(decompressionContext, in, (int) PacketIO.PROTO_INT.byteSize(), payloadLength, info, statsRecorder);
    }

    @Nonnull
    public static Packet readFramedPacketWithInfo(@Nonnull MemorySegment decompressionContext, @Nonnull MemorySegment in, int offset, int payloadLength, @Nonnull PacketRegistry.PacketInfo info, @Nonnull PacketStatsRecorder statsRecorder) {
        int uncompressedSize;
        int compressedSize = 0;

        MemorySegment payload;
        Arena arena = null;

        if (info.compressed() && payloadLength > 0) {
            arena = Arena.ofConfined();
            try {
                payload = decompressFromBuffer(decompressionContext, arena, in, offset, payloadLength, info.maxSize());
            } catch (Throwable e) {
                arena.close();
                throw e;
            }
            uncompressedSize = (int) payload.byteSize();
            compressedSize = payloadLength;
            offset = 0;
        } else {
            // Slice to exactly [offset, offset + payloadLength) so generated readers bound against
            // the frame, not the backing buffer. QuicheChannel reuses a 100 KB packetBuffer across
            // frames, so a malformed packet that tries to read past its declared payload would
            // otherwise consume stale bytes left over from a previous frame on the same stream.
            //
            // Cost of the slice (see PacketDeserializationBenchmark.framed*_memSeg): +40 B/op
            // when the slice escapes the caller (e.g. Connect's deserialize is too large to fully
            // inline) and zero when it doesn't (DataPacket's deserialize inlines and the slice is
            // scalar-replaced). Wall time stays within JMH noise. The correctness guarantee is
            // worth the bounded allocation; threading payloadLength through every emitted reader
            // would avoid it but adds surface area across the entire FFM emitter.
            payload = in.asSlice(offset, payloadLength);
            offset = 0;
            uncompressedSize = payloadLength;
        }

        try {
            var packet = info.toObject().deserialize(payload, offset);
            statsRecorder.recordReceive(info.id(), uncompressedSize, compressedSize);
            return packet;
        } finally {
            if (arena != null) {
                arena.close();
            }
        }
    }
}
