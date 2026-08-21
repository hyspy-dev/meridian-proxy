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


public class AssetEditorFetchAutoCompleteDataReply implements Packet, ToClientPacket {
    public static final int PACKET_ID = 332;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int token;
    @Nullable public String[] results;

    public AssetEditorFetchAutoCompleteDataReply() {
    }

    public AssetEditorFetchAutoCompleteDataReply(int token, @Nullable String[] results) {
        this.token = token;
        this.results = results;
    }

    public AssetEditorFetchAutoCompleteDataReply(@Nonnull AssetEditorFetchAutoCompleteDataReply other) {
        this.token = other.token;
        this.results = other.results;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorFetchAutoCompleteDataReply", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorFetchAutoCompleteDataReply", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getToken(MemorySegment mem) {
        return getToken(mem, 0);
    }
    
    public static int getToken(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String[] getResults(MemorySegment mem) {
        return getResults(mem, 0);
    }
    
    @Nullable
    public static String[] getResults(MemorySegment mem, int offset) {
        if (!hasResults(mem, offset)) return null;
        var off = offset + 5;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Results");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Results", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Results", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Results", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasResults(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorFetchAutoCompleteDataReply toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorFetchAutoCompleteDataReply toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorFetchAutoCompleteDataReply and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorFetchAutoCompleteDataReply toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        String[] v1 = null;
        if (hasResults(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Results");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Results", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Results", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v1[i] = PacketIO.readVarString("Results", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        }
        var result = new AssetEditorFetchAutoCompleteDataReply(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.results != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.token);
        var varOffset = offset + 5;
        if (this.results != null) {
            
            if (results.length > 4096000) throw ProtocolException.arrayTooLong("Results", results.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.results.length);
            
            var resultsValueOffset = 0;
            for (var i = 0; i < this.results.length; i++) {
                resultsValueOffset += PacketIO.writeVarString(mem, varOffset + resultsValueOffset, this.results[i], 4096000);
            }
            varOffset += resultsValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (results != null) {
        int resultsSize = 0;
for (var elem : results) resultsSize += PacketIO.stringSize(elem);
size += VarInt.size(results.length) + resultsSize;
    }

        return size;
    }

    public AssetEditorFetchAutoCompleteDataReply clone() {
        AssetEditorFetchAutoCompleteDataReply copy = new AssetEditorFetchAutoCompleteDataReply();
        copy.token = this.token;
        copy.results = this.results != null ? java.util.Arrays.copyOf(this.results, this.results.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorFetchAutoCompleteDataReply other)) return false;
        return this.token == other.token && java.util.Arrays.equals(this.results, other.results);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(token);
        result = 31 * result + java.util.Arrays.hashCode(results);
        return result;
    }

}