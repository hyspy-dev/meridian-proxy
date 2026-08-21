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
import java.util.UUID;

public class PredictionUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 16;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 16;
    public static final int MAX_SIZE = 16;

    @Nonnull public java.util.UUID predictionId = new java.util.UUID(0L, 0L);

    public PredictionUpdate() {
    }

    public PredictionUpdate(@Nonnull java.util.UUID predictionId) {
        this.predictionId = predictionId;
    }

    public PredictionUpdate(@Nonnull PredictionUpdate other) {
        this.predictionId = other.predictionId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PredictionUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 16;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PredictionUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.UUID getPredictionId(MemorySegment mem) {
        return getPredictionId(mem, 0);
    }
    
    public static java.util.UUID getPredictionId(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 0);
    }
    
    
    
    
    
    public static PredictionUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PredictionUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PredictionUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PredictionUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new PredictionUpdate(
            PacketIO.readUUID(mem, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 16;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.writeUUID(mem, offset + 0, this.predictionId);
        
        
    
       return 16;
    }
    @Override
    public int computeSize() {
        return 16;
    }

    public PredictionUpdate clone() {
        PredictionUpdate copy = new PredictionUpdate();
        copy.predictionId = this.predictionId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PredictionUpdate other)) return false;
        return java.util.Objects.equals(this.predictionId, other.predictionId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(predictionId);
    }

}