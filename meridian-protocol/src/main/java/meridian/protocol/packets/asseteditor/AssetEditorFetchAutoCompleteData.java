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


public class AssetEditorFetchAutoCompleteData implements Packet, ToServerPacket {
    public static final int PACKET_ID = 331;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 32768023;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int token;
    @Nullable public String dataset;
    @Nullable public String query;

    public AssetEditorFetchAutoCompleteData() {
    }

    public AssetEditorFetchAutoCompleteData(int token, @Nullable String dataset, @Nullable String query) {
        this.token = token;
        this.dataset = dataset;
        this.query = query;
    }

    public AssetEditorFetchAutoCompleteData(@Nonnull AssetEditorFetchAutoCompleteData other) {
        this.token = other.token;
        this.dataset = other.dataset;
        this.query = other.query;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorFetchAutoCompleteData", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorFetchAutoCompleteData", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getToken(MemorySegment mem) {
        return getToken(mem, 0);
    }
    
    public static int getToken(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getDataset(MemorySegment mem) {
        return getDataset(mem, 0);
    }
    
    @Nullable
    public static String getDataset(MemorySegment mem, int offset) {
        return hasDataset(mem, offset) ? PacketIO.readVarString("Dataset", mem, offset + getValidatedOffset(mem, offset, 5, 13, "Dataset"), 4096000): null;
    }
    
    @Nullable
    public static String getQuery(MemorySegment mem) {
        return getQuery(mem, 0);
    }
    
    @Nullable
    public static String getQuery(MemorySegment mem, int offset) {
        return hasQuery(mem, offset) ? PacketIO.readVarString("Query", mem, offset + getValidatedOffset(mem, offset, 9, 13, "Query"), 4096000): null;
    }
    
    public static boolean hasDataset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasQuery(MemorySegment mem, int offset) {
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
    
    public static AssetEditorFetchAutoCompleteData toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorFetchAutoCompleteData toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorFetchAutoCompleteData and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorFetchAutoCompleteData toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        String v1 = null;
        if (hasDataset(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Dataset");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Dataset", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "Dataset");
        }
        
        String v2 = null;
        if (hasQuery(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Query");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Query", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "Query");
        }
        var result = new AssetEditorFetchAutoCompleteData(
            mem.get(PacketIO.PROTO_INT, offset + 1),
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
        if (this.dataset != null) nullBits |= 0x01;
        if (this.query != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        var varOffset = offset + 13;
        if (this.dataset != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.dataset, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.query != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.query, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (dataset != null) size += PacketIO.stringSize(dataset);
    if (query != null) size += PacketIO.stringSize(query);

        return size;
    }

    public AssetEditorFetchAutoCompleteData clone() {
        AssetEditorFetchAutoCompleteData copy = new AssetEditorFetchAutoCompleteData();
        copy.token = this.token;
        copy.dataset = this.dataset;
        copy.query = this.query;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorFetchAutoCompleteData other)) return false;
        return this.token == other.token && java.util.Objects.equals(this.dataset, other.dataset) && java.util.Objects.equals(this.query, other.query);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(token, dataset, query);
    }

}