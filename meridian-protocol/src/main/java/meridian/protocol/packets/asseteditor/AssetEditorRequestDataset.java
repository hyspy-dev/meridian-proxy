// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

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


public class AssetEditorRequestDataset implements Packet, ToServerPacket {
    public static final int PACKET_ID = 333;
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

    @Nullable public String name;

    public AssetEditorRequestDataset() {
    }

    public AssetEditorRequestDataset(@Nullable String name) {
        this.name = name;
    }

    public AssetEditorRequestDataset(@Nonnull AssetEditorRequestDataset other) {
        this.name = other.name;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorRequestDataset", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorRequestDataset", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + 1, 4096000): null;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorRequestDataset toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorRequestDataset toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorRequestDataset and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorRequestDataset toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        String v0 = null;
        if (hasName(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new AssetEditorRequestDataset(
            v0
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
        
        
        var varOffset = offset + 1;
        if (this.name != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (name != null) size += PacketIO.stringSize(name);

        return size;
    }

    public AssetEditorRequestDataset clone() {
        AssetEditorRequestDataset copy = new AssetEditorRequestDataset();
        copy.name = this.name;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorRequestDataset other)) return false;
        return java.util.Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name);
    }

}