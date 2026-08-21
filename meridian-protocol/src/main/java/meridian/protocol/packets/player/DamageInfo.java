// Auto-generated - do not edit
package meridian.protocol.packets.player;

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
import meridian.protocol.DamageCause;
import meridian.protocol.Vector3d;

public class DamageInfo implements Packet, ToClientPacket {
    public static final int PACKET_ID = 112;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 29;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 29;
    public static final int MAX_SIZE = 32768048;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public Vector3d damageSourcePosition;
    public float damageAmount;
    @Nullable public DamageCause damageCause;

    public DamageInfo() {
    }

    public DamageInfo(@Nullable Vector3d damageSourcePosition, float damageAmount, @Nullable DamageCause damageCause) {
        this.damageSourcePosition = damageSourcePosition;
        this.damageAmount = damageAmount;
        this.damageCause = damageCause;
    }

    public DamageInfo(@Nonnull DamageInfo other) {
        this.damageSourcePosition = other.damageSourcePosition;
        this.damageAmount = other.damageAmount;
        this.damageCause = other.damageCause;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DamageInfo", offset, (int) mem.byteSize());
        long needed = (long) offset + 29;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DamageInfo", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Vector3d getDamageSourcePosition(MemorySegment mem) {
        return getDamageSourcePosition(mem, 0);
    }
    
    @Nullable
    public static Vector3d getDamageSourcePosition(MemorySegment mem, int offset) {
        return hasDamageSourcePosition(mem, offset) ? Vector3d.toObject(mem, offset + 1): null;
    }
    
    public static float getDamageAmount(MemorySegment mem) {
        return getDamageAmount(mem, 0);
    }
    
    public static float getDamageAmount(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "DamageAmount");
    }
    
    @Nullable
    public static DamageCause getDamageCause(MemorySegment mem) {
        return getDamageCause(mem, 0);
    }
    
    @Nullable
    public static DamageCause getDamageCause(MemorySegment mem, int offset) {
        return hasDamageCause(mem, offset) ? DamageCause.toObject(mem, offset + 29): null;
    }
    
    public static boolean hasDamageSourcePosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasDamageCause(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static DamageInfo toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DamageInfo toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DamageInfo and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DamageInfo toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 29;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        DamageCause v2 = null;
        if (hasDamageCause(mem, offset)) {
            v2 = DamageCause.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new DamageInfo(
            hasDamageSourcePosition(mem, offset) ? Vector3d.toObject(mem, offset + 1) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "DamageAmount"),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.damageSourcePosition != null) nullBits |= 0x01;
        if (this.damageCause != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.damageSourcePosition != null) {
            this.damageSourcePosition.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 24).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.damageAmount, "DamageAmount"); mem.set(PacketIO.PROTO_FLOAT, offset + 25, this.damageAmount);
        var varOffset = offset + 29;
        if (this.damageCause != null) {
            
            varOffset += this.damageCause.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 29;
        if (damageCause != null) size += damageCause.computeSize();

        return size;
    }

    public DamageInfo clone() {
        DamageInfo copy = new DamageInfo();
        copy.damageSourcePosition = this.damageSourcePosition != null ? this.damageSourcePosition.clone() : null;
        copy.damageAmount = this.damageAmount;
        copy.damageCause = this.damageCause != null ? this.damageCause.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DamageInfo other)) return false;
        return java.util.Objects.equals(this.damageSourcePosition, other.damageSourcePosition) && this.damageAmount == other.damageAmount && java.util.Objects.equals(this.damageCause, other.damageCause);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(damageSourcePosition, damageAmount, damageCause);
    }

}