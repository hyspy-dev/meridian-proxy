// Auto-generated - do not edit
package meridian.protocol.packets.player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import org.joml.*;

public class PointToolCreate implements Packet, ToServerPacket {
    public static final int PACKET_ID = 510;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 26;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 26;
    public static final int MAX_SIZE = 16384031;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public Vector3fc position = PacketIO.ZERO_VECTOR3;
    @Nonnull public Vector3fc rotation = PacketIO.ZERO_VECTOR3;
    @Nullable public String name;
    @Nonnull public PointShapeType shape = PointShapeType.Block;

    public PointToolCreate() {
    }

    public PointToolCreate(@Nonnull Vector3fc position, @Nonnull Vector3fc rotation, @Nullable String name, @Nonnull PointShapeType shape) {
        this.position = position;
        this.rotation = rotation;
        this.name = name;
        this.shape = shape;
    }

    public PointToolCreate(@Nonnull PointToolCreate other) {
        this.position = other.position;
        this.rotation = other.rotation;
        this.name = other.name;
        this.shape = other.shape;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PointToolCreate", offset, (int) mem.byteSize());
        long needed = (long) offset + 26;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PointToolCreate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static Vector3fc getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    public static Vector3fc getPosition(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Position");
    }
    
    public static Vector3fc getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    public static Vector3fc getRotation(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "Rotation");
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + 26, 4096000): null;
    }
    
    public static PointShapeType getShape(MemorySegment mem) {
        return getShape(mem, 0);
    }
    
    public static PointShapeType getShape(MemorySegment mem, int offset) {
        return PointShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 25));
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static PointToolCreate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PointToolCreate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PointToolCreate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PointToolCreate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 26;
        var varPos = 0;
        String v2 = null;
        if (hasName(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new PointToolCreate(
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Position"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "Rotation"),
            v2,
            PointShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 25))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.name != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.position, "Position"); PacketIO.writeVector3f(mem, offset + 1, this.position);
        PacketIO.requireFinite(this.rotation, "Rotation"); PacketIO.writeVector3f(mem, offset + 13, this.rotation);
        mem.set(PacketIO.PROTO_BYTE, offset + 25, (byte) this.shape.getValue());
        var varOffset = offset + 26;
        if (this.name != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 26;
        if (name != null) size += PacketIO.stringSize(name);

        return size;
    }

    public PointToolCreate clone() {
        PointToolCreate copy = new PointToolCreate();
        copy.position = this.position;
        copy.rotation = this.rotation;
        copy.name = this.name;
        copy.shape = this.shape;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PointToolCreate other)) return false;
        return java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.rotation, other.rotation) && java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.shape, other.shape);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(position, rotation, name, shape);
    }

}