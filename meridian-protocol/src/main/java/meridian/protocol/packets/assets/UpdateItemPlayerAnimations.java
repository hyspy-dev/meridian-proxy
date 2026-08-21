// Auto-generated - do not edit
package meridian.protocol.packets.assets;

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
import meridian.protocol.ItemPlayerAnimations;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateItemPlayerAnimations implements Packet, ToClientPacket {
    public static final int PACKET_ID = 52;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public UpdateType type = UpdateType.Init;
    @Nullable public java.util.Map<String, ItemPlayerAnimations> itemPlayerAnimations;

    public UpdateItemPlayerAnimations() {
    }

    public UpdateItemPlayerAnimations(@Nonnull UpdateType type, @Nullable java.util.Map<String, ItemPlayerAnimations> itemPlayerAnimations) {
        this.type = type;
        this.itemPlayerAnimations = itemPlayerAnimations;
    }

    public UpdateItemPlayerAnimations(@Nonnull UpdateItemPlayerAnimations other) {
        this.type = other.type;
        this.itemPlayerAnimations = other.itemPlayerAnimations;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateItemPlayerAnimations", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateItemPlayerAnimations", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static java.util.Map<String, ItemPlayerAnimations> getItemPlayerAnimations(MemorySegment mem) {
        return getItemPlayerAnimations(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, ItemPlayerAnimations> getItemPlayerAnimations(MemorySegment mem, int offset) {
        if (!hasItemPlayerAnimations(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 2;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ItemPlayerAnimations");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ItemPlayerAnimations", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 104 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemPlayerAnimations", (int) java.lang.Math.min(off + (long) len * 104, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, ItemPlayerAnimations> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = ItemPlayerAnimations.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ItemPlayerAnimations", key);
            }
        }
        return data;
    }
    
    public static boolean hasItemPlayerAnimations(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateItemPlayerAnimations toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateItemPlayerAnimations toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateItemPlayerAnimations and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateItemPlayerAnimations toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<String, ItemPlayerAnimations> v1 = null;
        if (hasItemPlayerAnimations(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ItemPlayerAnimations");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ItemPlayerAnimations", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 104 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemPlayerAnimations", (int) java.lang.Math.min(off + (long) len * 104, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = ItemPlayerAnimations.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ItemPlayerAnimations", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateItemPlayerAnimations(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.itemPlayerAnimations != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        var varOffset = offset + 2;
        if (this.itemPlayerAnimations != null) {
            
            if (this.itemPlayerAnimations.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ItemPlayerAnimations", itemPlayerAnimations.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.itemPlayerAnimations.size());
            for (var e : this.itemPlayerAnimations.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        if (itemPlayerAnimations != null) {
        int itemPlayerAnimationsSize = 0;
for (var kvp : itemPlayerAnimations.entrySet()) itemPlayerAnimationsSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(itemPlayerAnimations.size()) + itemPlayerAnimationsSize;
    }

        return size;
    }

    public UpdateItemPlayerAnimations clone() {
        UpdateItemPlayerAnimations copy = new UpdateItemPlayerAnimations();
        copy.type = this.type;
        if (this.itemPlayerAnimations != null) {
            java.util.Map<String, ItemPlayerAnimations> m = new java.util.HashMap<>();
            for (var e : this.itemPlayerAnimations.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.itemPlayerAnimations = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateItemPlayerAnimations other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.itemPlayerAnimations, other.itemPlayerAnimations);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, itemPlayerAnimations);
    }

}