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


public class Modifier {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 6;

    @Nonnull public ModifierTarget target = ModifierTarget.Min;
    @Nonnull public CalculationType calculationType = CalculationType.Additive;
    public float amount;

    public Modifier() {
    }

    public Modifier(@Nonnull ModifierTarget target, @Nonnull CalculationType calculationType, float amount) {
        this.target = target;
        this.calculationType = calculationType;
        this.amount = amount;
    }

    public Modifier(@Nonnull Modifier other) {
        this.target = other.target;
        this.calculationType = other.calculationType;
        this.amount = other.amount;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Modifier", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Modifier", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ModifierTarget getTarget(MemorySegment mem) {
        return getTarget(mem, 0);
    }
    
    public static ModifierTarget getTarget(MemorySegment mem, int offset) {
        return ModifierTarget.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static CalculationType getCalculationType(MemorySegment mem) {
        return getCalculationType(mem, 0);
    }
    
    public static CalculationType getCalculationType(MemorySegment mem, int offset) {
        return CalculationType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static float getAmount(MemorySegment mem) {
        return getAmount(mem, 0);
    }
    
    public static float getAmount(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Amount");
    }
    
    
    
    
    
    public static Modifier toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Modifier toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Modifier and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Modifier toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new Modifier(
            ModifierTarget.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            CalculationType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Amount")
        );
        if (cursor != null) cursor.position = offset + 6;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.target.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.calculationType.getValue());
        PacketIO.requireFinite(this.amount, "Amount"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.amount);
        
        
    
       return 6;
    }
    public int computeSize() {
        return 6;
    }

    public Modifier clone() {
        Modifier copy = new Modifier();
        copy.target = this.target;
        copy.calculationType = this.calculationType;
        copy.amount = this.amount;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Modifier other)) return false;
        return java.util.Objects.equals(this.target, other.target) && java.util.Objects.equals(this.calculationType, other.calculationType) && this.amount == other.amount;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(target, calculationType, amount);
    }

}