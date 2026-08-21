// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import java.util.HashMap;

public class EntityStatsUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public java.util.Map<Integer, EntityStatUpdate[]> entityStatUpdates = new java.util.HashMap<>();

    public EntityStatsUpdate() {
    }

    public EntityStatsUpdate(@Nonnull java.util.Map<Integer, EntityStatUpdate[]> entityStatUpdates) {
        this.entityStatUpdates = entityStatUpdates;
    }

    public EntityStatsUpdate(@Nonnull EntityStatsUpdate other) {
        this.entityStatUpdates = other.entityStatUpdates;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EntityStatsUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityStatsUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.Map<Integer, EntityStatUpdate[]> getEntityStatUpdates(MemorySegment mem) {
        return getEntityStatUpdates(mem, 0);
    }
    
    public static java.util.Map<Integer, EntityStatUpdate[]> getEntityStatUpdates(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("EntityStatUpdates");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("EntityStatUpdates", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityStatUpdates", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, EntityStatUpdate[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 21 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 21, (int) mem.byteSize());
                off += valueVarLen;
                var value = new EntityStatUpdate[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = EntityStatUpdate.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("EntityStatUpdates", key);
            }
        }
        return data;
    }
    
    
    
    
    
    public static EntityStatsUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EntityStatsUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EntityStatsUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EntityStatsUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<Integer, EntityStatUpdate[]> v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("EntityStatUpdates");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("EntityStatUpdates", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityStatUpdates", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v0 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 21 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 21, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new EntityStatUpdate[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = EntityStatUpdate.toObject(mem, off, walkCursor);
                        off = walkCursor.position;
                    }
                if (v0.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("EntityStatUpdates", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new EntityStatsUpdate(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (this.entityStatUpdates.size() > 4096000) throw ProtocolException.dictionaryTooLarge("EntityStatUpdates", entityStatUpdates.size(), 4096000);
        varOffset += VarInt.set(mem, varOffset, this.entityStatUpdates.size());
        for (var e : this.entityStatUpdates.entrySet()) {
            mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
            varOffset += 4;
            varOffset += VarInt.set(mem, varOffset, e.getValue().length);
            for (var arrItem : e.getValue()) {
                varOffset += arrItem.serialize(mem, varOffset);
            }
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 0;
        int entityStatUpdatesSize = 0;
for (var kvp : entityStatUpdates.entrySet()) entityStatUpdatesSize += 4 + VarInt.size(kvp.getValue().length) + java.util.Arrays.stream(kvp.getValue()).mapToInt(inner -> inner.computeSize()).sum();
size += VarInt.size(entityStatUpdates.size()) + entityStatUpdatesSize;

        return size;
    }

    public EntityStatsUpdate clone() {
        EntityStatsUpdate copy = new EntityStatsUpdate();
        {
            java.util.Map<Integer, EntityStatUpdate[]> m = new java.util.HashMap<>();
            for (var e : this.entityStatUpdates.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(EntityStatUpdate[]::new)); }
            copy.entityStatUpdates = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityStatsUpdate other)) return false;
        return java.util.Objects.equals(this.entityStatUpdates, other.entityStatUpdates);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(entityStatUpdates);
    }

}