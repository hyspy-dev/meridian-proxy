// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

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
import meridian.protocol.CraftingRecipe;
import java.util.HashMap;

public class UpdateKnownRecipes implements Packet, ToClientPacket {
    public static final int PACKET_ID = 228;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public java.util.Map<String, CraftingRecipe> known;

    public UpdateKnownRecipes() {
    }

    public UpdateKnownRecipes(@Nullable java.util.Map<String, CraftingRecipe> known) {
        this.known = known;
    }

    public UpdateKnownRecipes(@Nonnull UpdateKnownRecipes other) {
        this.known = other.known;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateKnownRecipes", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateKnownRecipes", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static java.util.Map<String, CraftingRecipe> getKnown(MemorySegment mem) {
        return getKnown(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, CraftingRecipe> getKnown(MemorySegment mem, int offset) {
        if (!hasKnown(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Known");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Known", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 31 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Known", (int) java.lang.Math.min(off + (long) len * 31, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, CraftingRecipe> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = CraftingRecipe.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Known", key);
            }
        }
        return data;
    }
    
    public static boolean hasKnown(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateKnownRecipes toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateKnownRecipes toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateKnownRecipes and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateKnownRecipes toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<String, CraftingRecipe> v0 = null;
        if (hasKnown(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Known");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Known", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 31 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Known", (int) java.lang.Math.min(off + (long) len * 31, Integer.MAX_VALUE), (int) mem.byteSize());
            v0 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = CraftingRecipe.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v0.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Known", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateKnownRecipes(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.known != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.known != null) {
            
            if (this.known.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Known", known.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.known.size());
            for (var e : this.known.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (known != null) {
        int knownSize = 0;
for (var kvp : known.entrySet()) knownSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(known.size()) + knownSize;
    }

        return size;
    }

    public UpdateKnownRecipes clone() {
        UpdateKnownRecipes copy = new UpdateKnownRecipes();
        if (this.known != null) {
            java.util.Map<String, CraftingRecipe> m = new java.util.HashMap<>();
            for (var e : this.known.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.known = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateKnownRecipes other)) return false;
        return java.util.Objects.equals(this.known, other.known);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(known);
    }

}