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


public class CombatTextUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 16384009;

    public float hitAngleDeg;
    @Nonnull public String text = "";

    public CombatTextUpdate() {
    }

    public CombatTextUpdate(float hitAngleDeg, @Nonnull String text) {
        this.hitAngleDeg = hitAngleDeg;
        this.text = text;
    }

    public CombatTextUpdate(@Nonnull CombatTextUpdate other) {
        this.hitAngleDeg = other.hitAngleDeg;
        this.text = other.text;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CombatTextUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CombatTextUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getHitAngleDeg(MemorySegment mem) {
        return getHitAngleDeg(mem, 0);
    }
    
    public static float getHitAngleDeg(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "HitAngleDeg");
    }
    
    public static String getText(MemorySegment mem) {
        return getText(mem, 0);
    }
    
    public static String getText(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Text", mem, offset + 4, 4096000);
    }
    
    
    
    
    
    public static CombatTextUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CombatTextUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CombatTextUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CombatTextUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 4;
        var varPos = 0;
        String v1;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Text", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new CombatTextUpdate(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "HitAngleDeg"),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.hitAngleDeg, "HitAngleDeg"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.hitAngleDeg);
        var varOffset = offset + 4;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.text, 4096000);
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 4;
        size += PacketIO.stringSize(text);

        return size;
    }

    public CombatTextUpdate clone() {
        CombatTextUpdate copy = new CombatTextUpdate();
        copy.hitAngleDeg = this.hitAngleDeg;
        copy.text = this.text;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CombatTextUpdate other)) return false;
        return this.hitAngleDeg == other.hitAngleDeg && java.util.Objects.equals(this.text, other.text);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(hitAngleDeg, text);
    }

}