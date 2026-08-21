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


public class BuilderToolGMaskPresetLoadResponse implements Packet, ToServerPacket {
    public static final int PACKET_ID = 431;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 16384006;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String maskData;

    public BuilderToolGMaskPresetLoadResponse() {
    }

    public BuilderToolGMaskPresetLoadResponse(@Nullable String maskData) {
        this.maskData = maskData;
    }

    public BuilderToolGMaskPresetLoadResponse(@Nonnull BuilderToolGMaskPresetLoadResponse other) {
        this.maskData = other.maskData;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolGMaskPresetLoadResponse", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolGMaskPresetLoadResponse", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getMaskData(MemorySegment mem) {
        return getMaskData(mem, 0);
    }
    
    @Nullable
    public static String getMaskData(MemorySegment mem, int offset) {
        return hasMaskData(mem, offset) ? PacketIO.readVarString("MaskData", mem, offset + 1, 4096000): null;
    }
    
    public static boolean hasMaskData(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static BuilderToolGMaskPresetLoadResponse toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolGMaskPresetLoadResponse toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolGMaskPresetLoadResponse and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolGMaskPresetLoadResponse toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        String v0 = null;
        if (hasMaskData(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("MaskData", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new BuilderToolGMaskPresetLoadResponse(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.maskData != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.maskData != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.maskData, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (maskData != null) size += PacketIO.stringSize(maskData);

        return size;
    }

    public BuilderToolGMaskPresetLoadResponse clone() {
        BuilderToolGMaskPresetLoadResponse copy = new BuilderToolGMaskPresetLoadResponse();
        copy.maskData = this.maskData;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolGMaskPresetLoadResponse other)) return false;
        return java.util.Objects.equals(this.maskData, other.maskData);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(maskData);
    }

}