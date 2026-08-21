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


public class TriggerVolumeToolSetCooldown implements Packet, ToServerPacket {
    public static final int PACKET_ID = 501;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 16384010;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String volumeId = "";
    public float cooldown;
    public byte cooldownMode;

    public TriggerVolumeToolSetCooldown() {
    }

    public TriggerVolumeToolSetCooldown(@Nonnull String volumeId, float cooldown, byte cooldownMode) {
        this.volumeId = volumeId;
        this.cooldown = cooldown;
        this.cooldownMode = cooldownMode;
    }

    public TriggerVolumeToolSetCooldown(@Nonnull TriggerVolumeToolSetCooldown other) {
        this.volumeId = other.volumeId;
        this.cooldown = other.cooldown;
        this.cooldownMode = other.cooldownMode;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("TriggerVolumeToolSetCooldown", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("TriggerVolumeToolSetCooldown", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getVolumeId(MemorySegment mem) {
        return getVolumeId(mem, 0);
    }
    
    public static String getVolumeId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("VolumeId", mem, offset + 5, 4096000);
    }
    
    public static float getCooldown(MemorySegment mem) {
        return getCooldown(mem, 0);
    }
    
    public static float getCooldown(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Cooldown");
    }
    
    public static byte getCooldownMode(MemorySegment mem) {
        return getCooldownMode(mem, 0);
    }
    
    public static byte getCooldownMode(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 4);
    }
    
    
    
    
    
    public static TriggerVolumeToolSetCooldown toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static TriggerVolumeToolSetCooldown toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one TriggerVolumeToolSetCooldown and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static TriggerVolumeToolSetCooldown toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("VolumeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new TriggerVolumeToolSetCooldown(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "Cooldown"),
            mem.get(PacketIO.PROTO_BYTE, offset + 4)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.cooldown, "Cooldown"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.cooldown);
        mem.set(PacketIO.PROTO_BYTE, offset + 4, this.cooldownMode);
        var varOffset = offset + 5;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.volumeId, 4096000);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        size += PacketIO.stringSize(volumeId);

        return size;
    }

    public TriggerVolumeToolSetCooldown clone() {
        TriggerVolumeToolSetCooldown copy = new TriggerVolumeToolSetCooldown();
        copy.volumeId = this.volumeId;
        copy.cooldown = this.cooldown;
        copy.cooldownMode = this.cooldownMode;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TriggerVolumeToolSetCooldown other)) return false;
        return java.util.Objects.equals(this.volumeId, other.volumeId) && this.cooldown == other.cooldown && this.cooldownMode == other.cooldownMode;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(volumeId, cooldown, cooldownMode);
    }

}