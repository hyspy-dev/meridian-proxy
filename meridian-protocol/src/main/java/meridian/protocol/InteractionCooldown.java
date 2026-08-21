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


public class InteractionCooldown {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 7;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 15;
    public static final int MAX_SIZE = 32768025;

    @Nullable public String cooldownId;
    public float cooldown;
    public boolean clickBypass;
    @Nullable public float[] chargeTimes;
    public boolean skipCooldownReset;
    public boolean interruptRecharge;

    public InteractionCooldown() {
    }

    public InteractionCooldown(@Nullable String cooldownId, float cooldown, boolean clickBypass, @Nullable float[] chargeTimes, boolean skipCooldownReset, boolean interruptRecharge) {
        this.cooldownId = cooldownId;
        this.cooldown = cooldown;
        this.clickBypass = clickBypass;
        this.chargeTimes = chargeTimes;
        this.skipCooldownReset = skipCooldownReset;
        this.interruptRecharge = interruptRecharge;
    }

    public InteractionCooldown(@Nonnull InteractionCooldown other) {
        this.cooldownId = other.cooldownId;
        this.cooldown = other.cooldown;
        this.clickBypass = other.clickBypass;
        this.chargeTimes = other.chargeTimes;
        this.skipCooldownReset = other.skipCooldownReset;
        this.interruptRecharge = other.interruptRecharge;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InteractionCooldown", offset, (int) mem.byteSize());
        long needed = (long) offset + 15;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InteractionCooldown", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getCooldownId(MemorySegment mem) {
        return getCooldownId(mem, 0);
    }
    
    @Nullable
    public static String getCooldownId(MemorySegment mem, int offset) {
        return hasCooldownId(mem, offset) ? PacketIO.readVarString("CooldownId", mem, offset + getValidatedOffset(mem, offset, 7, 15, "CooldownId"), 4096000): null;
    }
    
    public static float getCooldown(MemorySegment mem) {
        return getCooldown(mem, 0);
    }
    
    public static float getCooldown(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Cooldown");
    }
    
    public static boolean getClickBypass(MemorySegment mem) {
        return getClickBypass(mem, 0);
    }
    
    public static boolean getClickBypass(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 5);
    }
    
    @Nullable
    public static float[] getChargeTimes(MemorySegment mem) {
        return getChargeTimes(mem, 0);
    }
    
    @Nullable
    public static float[] getChargeTimes(MemorySegment mem, int offset) {
        if (!hasChargeTimes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 11, 15, "ChargeTimes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ChargeTimes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ChargeTimes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChargeTimes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new float[len];
        MemorySegment.copy(mem, PacketIO.PROTO_FLOAT, off, data, 0, len);
        return data;
    }
    
    public static boolean getSkipCooldownReset(MemorySegment mem) {
        return getSkipCooldownReset(mem, 0);
    }
    
    public static boolean getSkipCooldownReset(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x01) != 0;
    }
    
    public static boolean getInterruptRecharge(MemorySegment mem) {
        return getInterruptRecharge(mem, 0);
    }
    
    public static boolean getInterruptRecharge(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x02) != 0;
    }
    
    public static boolean hasCooldownId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasChargeTimes(MemorySegment mem, int offset) {
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
    
    public static InteractionCooldown toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InteractionCooldown toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InteractionCooldown and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InteractionCooldown toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 15;
        var varPos = 0;
        String v0 = null;
        if (hasCooldownId(mem, offset)) {
            requireSlot(mem, offset + 7, varPos, "CooldownId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("CooldownId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 7, -1, "CooldownId");
        }
        
        float[] v3 = null;
        if (hasChargeTimes(mem, offset)) {
            requireSlot(mem, offset + 11, varPos, "ChargeTimes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ChargeTimes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ChargeTimes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChargeTimes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new float[len];
            MemorySegment.copy(mem, PacketIO.PROTO_FLOAT, off, v3, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 11, -1, "ChargeTimes");
        }
        var result = new InteractionCooldown(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Cooldown"),
            mem.get(PacketIO.PROTO_BOOL, offset + 5),
            v3,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x02) != 0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.cooldownId != null) nullBits |= 0x01;
        if (this.chargeTimes != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.cooldown, "Cooldown"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.cooldown);
        mem.set(PacketIO.PROTO_BOOL, offset + 5, this.clickBypass);
        byte boolBits0_0 = 0;
        if (this.skipCooldownReset) boolBits0_0 |= 0x01;
        if (this.interruptRecharge) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 6 + 0, boolBits0_0);
        var varOffset = offset + 15;
        if (this.cooldownId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 7, varOffset - offset - 15);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.cooldownId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 7, -1);
        }
        if (this.chargeTimes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 11, varOffset - offset - 15);
            if (chargeTimes.length > 4096000) throw ProtocolException.arrayTooLong("ChargeTimes", chargeTimes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.chargeTimes.length);
            
            MemorySegment.copy(this.chargeTimes, 0, mem, PacketIO.PROTO_FLOAT, varOffset, this.chargeTimes.length);
            varOffset += this.chargeTimes.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 11, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 15;
        if (cooldownId != null) size += PacketIO.stringSize(cooldownId);
    if (chargeTimes != null) size += VarInt.size(chargeTimes.length) + chargeTimes.length * 4;

        return size;
    }

    public InteractionCooldown clone() {
        InteractionCooldown copy = new InteractionCooldown();
        copy.cooldownId = this.cooldownId;
        copy.cooldown = this.cooldown;
        copy.clickBypass = this.clickBypass;
        copy.chargeTimes = this.chargeTimes != null ? java.util.Arrays.copyOf(this.chargeTimes, this.chargeTimes.length) : null;
        copy.skipCooldownReset = this.skipCooldownReset;
        copy.interruptRecharge = this.interruptRecharge;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InteractionCooldown other)) return false;
        return java.util.Objects.equals(this.cooldownId, other.cooldownId) && this.cooldown == other.cooldown && this.clickBypass == other.clickBypass && java.util.Arrays.equals(this.chargeTimes, other.chargeTimes) && this.skipCooldownReset == other.skipCooldownReset && this.interruptRecharge == other.interruptRecharge;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(cooldownId);
        result = 31 * result + Float.hashCode(cooldown);
        result = 31 * result + Boolean.hashCode(clickBypass);
        result = 31 * result + java.util.Arrays.hashCode(chargeTimes);
        result = 31 * result + Boolean.hashCode(skipCooldownReset);
        result = 31 * result + Boolean.hashCode(interruptRecharge);
        return result;
    }

}