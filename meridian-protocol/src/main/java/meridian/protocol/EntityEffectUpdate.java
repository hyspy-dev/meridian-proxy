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


public class EntityEffectUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 11;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 11;
    public static final int MAX_SIZE = 16384016;

    @Nonnull public EffectOp type = EffectOp.Add;
    public int id;
    public float remainingTime;
    public boolean infinite;
    public boolean debuff;
    @Nullable public String statusEffectIcon;

    public EntityEffectUpdate() {
    }

    public EntityEffectUpdate(@Nonnull EffectOp type, int id, float remainingTime, boolean infinite, boolean debuff, @Nullable String statusEffectIcon) {
        this.type = type;
        this.id = id;
        this.remainingTime = remainingTime;
        this.infinite = infinite;
        this.debuff = debuff;
        this.statusEffectIcon = statusEffectIcon;
    }

    public EntityEffectUpdate(@Nonnull EntityEffectUpdate other) {
        this.type = other.type;
        this.id = other.id;
        this.remainingTime = other.remainingTime;
        this.infinite = other.infinite;
        this.debuff = other.debuff;
        this.statusEffectIcon = other.statusEffectIcon;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EntityEffectUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 11;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityEffectUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static EffectOp getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static EffectOp getType(MemorySegment mem, int offset) {
        return EffectOp.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static int getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static int getId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    public static float getRemainingTime(MemorySegment mem) {
        return getRemainingTime(mem, 0);
    }
    
    public static float getRemainingTime(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "RemainingTime");
    }
    
    public static boolean getInfinite(MemorySegment mem) {
        return getInfinite(mem, 0);
    }
    
    public static boolean getInfinite(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x01) != 0;
    }
    
    public static boolean getDebuff(MemorySegment mem) {
        return getDebuff(mem, 0);
    }
    
    public static boolean getDebuff(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x02) != 0;
    }
    
    @Nullable
    public static String getStatusEffectIcon(MemorySegment mem) {
        return getStatusEffectIcon(mem, 0);
    }
    
    @Nullable
    public static String getStatusEffectIcon(MemorySegment mem, int offset) {
        return hasStatusEffectIcon(mem, offset) ? PacketIO.readVarString("StatusEffectIcon", mem, offset + 11, 4096000): null;
    }
    
    public static boolean hasStatusEffectIcon(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static EntityEffectUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EntityEffectUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EntityEffectUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EntityEffectUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 11;
        var varPos = 0;
        String v5 = null;
        if (hasStatusEffectIcon(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("StatusEffectIcon", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new EntityEffectUpdate(
            EffectOp.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "RemainingTime"),
            (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 10) & 0x02) != 0,
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.statusEffectIcon != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 2, this.id);
        PacketIO.requireFinite(this.remainingTime, "RemainingTime"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.remainingTime);
        byte boolBits0_0 = 0;
        if (this.infinite) boolBits0_0 |= 0x01;
        if (this.debuff) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 10 + 0, boolBits0_0);
        var varOffset = offset + 11;
        if (this.statusEffectIcon != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.statusEffectIcon, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 11;
        if (statusEffectIcon != null) size += PacketIO.stringSize(statusEffectIcon);

        return size;
    }

    public EntityEffectUpdate clone() {
        EntityEffectUpdate copy = new EntityEffectUpdate();
        copy.type = this.type;
        copy.id = this.id;
        copy.remainingTime = this.remainingTime;
        copy.infinite = this.infinite;
        copy.debuff = this.debuff;
        copy.statusEffectIcon = this.statusEffectIcon;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityEffectUpdate other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.id == other.id && this.remainingTime == other.remainingTime && this.infinite == other.infinite && this.debuff == other.debuff && java.util.Objects.equals(this.statusEffectIcon, other.statusEffectIcon);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, id, remainingTime, infinite, debuff, statusEffectIcon);
    }

}