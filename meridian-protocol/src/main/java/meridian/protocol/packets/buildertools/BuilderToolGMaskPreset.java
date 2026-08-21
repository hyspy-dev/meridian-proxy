// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

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


public class BuilderToolGMaskPreset implements Packet, ToClientPacket {
    public static final int PACKET_ID = 430;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 10;
    public static final int MAX_SIZE = 32768020;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public boolean isSave;
    @Nullable public String name;
    @Nullable public String maskData;

    public BuilderToolGMaskPreset() {
    }

    public BuilderToolGMaskPreset(boolean isSave, @Nullable String name, @Nullable String maskData) {
        this.isSave = isSave;
        this.name = name;
        this.maskData = maskData;
    }

    public BuilderToolGMaskPreset(@Nonnull BuilderToolGMaskPreset other) {
        this.isSave = other.isSave;
        this.name = other.name;
        this.maskData = other.maskData;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolGMaskPreset", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolGMaskPreset", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getIsSave(MemorySegment mem) {
        return getIsSave(mem, 0);
    }
    
    public static boolean getIsSave(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 2, 10, "Name"), 4096000): null;
    }
    
    @Nullable
    public static String getMaskData(MemorySegment mem) {
        return getMaskData(mem, 0);
    }
    
    @Nullable
    public static String getMaskData(MemorySegment mem, int offset) {
        return hasMaskData(mem, offset) ? PacketIO.readVarString("MaskData", mem, offset + getValidatedOffset(mem, offset, 6, 10, "MaskData"), 4096000): null;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasMaskData(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static BuilderToolGMaskPreset toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolGMaskPreset toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolGMaskPreset and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolGMaskPreset toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 10;
        var varPos = 0;
        String v1 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 2, -1, "Name");
        }
        
        String v2 = null;
        if (hasMaskData(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "MaskData");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("MaskData", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 6, -1, "MaskData");
        }
        var result = new BuilderToolGMaskPreset(
            mem.get(PacketIO.PROTO_BOOL, offset + 1),
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.name != null) nullBits |= 0x01;
        if (this.maskData != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.isSave);
        var varOffset = offset + 10;
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 10);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.maskData != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 10);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.maskData, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 10;
        if (name != null) size += PacketIO.stringSize(name);
    if (maskData != null) size += PacketIO.stringSize(maskData);

        return size;
    }

    public BuilderToolGMaskPreset clone() {
        BuilderToolGMaskPreset copy = new BuilderToolGMaskPreset();
        copy.isSave = this.isSave;
        copy.name = this.name;
        copy.maskData = this.maskData;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolGMaskPreset other)) return false;
        return this.isSave == other.isSave && java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.maskData, other.maskData);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(isSave, name, maskData);
    }

}