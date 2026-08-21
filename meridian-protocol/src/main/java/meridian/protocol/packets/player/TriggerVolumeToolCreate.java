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

public class TriggerVolumeToolCreate implements Packet, ToServerPacket {
    public static final int PACKET_ID = 480;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 38;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 38;
    public static final int MAX_SIZE = 16384043;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public TriggerVolumeShapeType shapeType = TriggerVolumeShapeType.Box;
    @Nonnull public Vector3fc position = PacketIO.ZERO_VECTOR3;
    @Nonnull public Vector3fc param1 = PacketIO.ZERO_VECTOR3;
    @Nonnull public Vector3fc param2 = PacketIO.ZERO_VECTOR3;
    @Nullable public String name;

    public TriggerVolumeToolCreate() {
    }

    public TriggerVolumeToolCreate(@Nonnull TriggerVolumeShapeType shapeType, @Nonnull Vector3fc position, @Nonnull Vector3fc param1, @Nonnull Vector3fc param2, @Nullable String name) {
        this.shapeType = shapeType;
        this.position = position;
        this.param1 = param1;
        this.param2 = param2;
        this.name = name;
    }

    public TriggerVolumeToolCreate(@Nonnull TriggerVolumeToolCreate other) {
        this.shapeType = other.shapeType;
        this.position = other.position;
        this.param1 = other.param1;
        this.param2 = other.param2;
        this.name = other.name;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TriggerVolumeToolCreate", offset, (int) mem.byteSize());
        long needed = (long) offset + 38;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TriggerVolumeToolCreate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static TriggerVolumeShapeType getShapeType(MemorySegment mem) {
        return getShapeType(mem, 0);
    }
    
    public static TriggerVolumeShapeType getShapeType(MemorySegment mem, int offset) {
        return TriggerVolumeShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static Vector3fc getPosition(MemorySegment mem) {
        return getPosition(mem, 0);
    }
    
    public static Vector3fc getPosition(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 2), "Position");
    }
    
    public static Vector3fc getParam1(MemorySegment mem) {
        return getParam1(mem, 0);
    }
    
    public static Vector3fc getParam1(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 14), "Param1");
    }
    
    public static Vector3fc getParam2(MemorySegment mem) {
        return getParam2(mem, 0);
    }
    
    public static Vector3fc getParam2(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 26), "Param2");
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + 38, 4096000): null;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static TriggerVolumeToolCreate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TriggerVolumeToolCreate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TriggerVolumeToolCreate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TriggerVolumeToolCreate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 38;
        var varPos = 0;
        String v4 = null;
        if (hasName(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new TriggerVolumeToolCreate(
            TriggerVolumeShapeType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 2), "Position"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 14), "Param1"),
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 26), "Param2"),
            v4
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
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.shapeType.getValue());
        PacketIO.requireFinite(this.position, "Position"); PacketIO.writeVector3f(mem, offset + 2, this.position);
        PacketIO.requireFinite(this.param1, "Param1"); PacketIO.writeVector3f(mem, offset + 14, this.param1);
        PacketIO.requireFinite(this.param2, "Param2"); PacketIO.writeVector3f(mem, offset + 26, this.param2);
        var varOffset = offset + 38;
        if (this.name != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 38;
        if (name != null) size += PacketIO.stringSize(name);

        return size;
    }

    public TriggerVolumeToolCreate clone() {
        TriggerVolumeToolCreate copy = new TriggerVolumeToolCreate();
        copy.shapeType = this.shapeType;
        copy.position = this.position;
        copy.param1 = this.param1;
        copy.param2 = this.param2;
        copy.name = this.name;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TriggerVolumeToolCreate other)) return false;
        return java.util.Objects.equals(this.shapeType, other.shapeType) && java.util.Objects.equals(this.position, other.position) && java.util.Objects.equals(this.param1, other.param1) && java.util.Objects.equals(this.param2, other.param2) && java.util.Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(shapeType, position, param1, param2, name);
    }

}