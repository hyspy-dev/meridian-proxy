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


public class EntityEffectsUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public EntityEffectUpdate[] entityEffectUpdates = new EntityEffectUpdate[0];

    public EntityEffectsUpdate() {
    }

    public EntityEffectsUpdate(@Nonnull EntityEffectUpdate[] entityEffectUpdates) {
        this.entityEffectUpdates = entityEffectUpdates;
    }

    public EntityEffectsUpdate(@Nonnull EntityEffectsUpdate other) {
        this.entityEffectUpdates = other.entityEffectUpdates;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EntityEffectsUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityEffectsUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static EntityEffectUpdate[] getEntityEffectUpdates(MemorySegment mem) {
        return getEntityEffectUpdates(mem, 0);
    }
    
    public static EntityEffectUpdate[] getEntityEffectUpdates(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("EntityEffectUpdates");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("EntityEffectUpdates", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 11 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityEffectUpdates", (int) java.lang.Math.min(off + lenOffset + (long) len * 11, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new EntityEffectUpdate[len];
        for (var i = 0; i < len; i++) {
            data[i] = EntityEffectUpdate.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    
    
    
    
    public static EntityEffectsUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EntityEffectsUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EntityEffectsUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EntityEffectsUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        EntityEffectUpdate[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("EntityEffectUpdates");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("EntityEffectUpdates", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 11 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityEffectUpdates", (int) java.lang.Math.min(off + lenOffset + (long) len * 11, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new EntityEffectUpdate[len];
            for (var i = 0; i < len; i++) {
                v0[i] = EntityEffectUpdate.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new EntityEffectsUpdate(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (entityEffectUpdates.length > 4096000) throw ProtocolException.arrayTooLong("EntityEffectUpdates", entityEffectUpdates.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.entityEffectUpdates.length);
        
        var entityEffectUpdatesValueOffset = 0;
        for (var i = 0; i < this.entityEffectUpdates.length; i++) {
            entityEffectUpdatesValueOffset += this.entityEffectUpdates[i].serialize(mem, varOffset + entityEffectUpdatesValueOffset);
        }
        varOffset += entityEffectUpdatesValueOffset;
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 0;
        int entityEffectUpdatesSize = 0;
for (var elem : entityEffectUpdates) entityEffectUpdatesSize += elem.computeSize();
size += VarInt.size(entityEffectUpdates.length) + entityEffectUpdatesSize;

        return size;
    }

    public EntityEffectsUpdate clone() {
        EntityEffectsUpdate copy = new EntityEffectsUpdate();
        copy.entityEffectUpdates = java.util.Arrays.stream(this.entityEffectUpdates).map(e -> e.clone()).toArray(EntityEffectUpdate[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityEffectsUpdate other)) return false;
        return java.util.Arrays.equals(this.entityEffectUpdates, other.entityEffectUpdates);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(entityEffectUpdates);
        return result;
    }

}