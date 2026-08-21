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


public class AddOrUpdateTriggerVolumeDisplay implements Packet, ToClientPacket {
    public static final int PACKET_ID = 471;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 81920119;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String volumeId = "";
    @Nonnull public TriggerVolumeDisplayEntry entry = new TriggerVolumeDisplayEntry();

    public AddOrUpdateTriggerVolumeDisplay() {
    }

    public AddOrUpdateTriggerVolumeDisplay(@Nonnull String volumeId, @Nonnull TriggerVolumeDisplayEntry entry) {
        this.volumeId = volumeId;
        this.entry = entry;
    }

    public AddOrUpdateTriggerVolumeDisplay(@Nonnull AddOrUpdateTriggerVolumeDisplay other) {
        this.volumeId = other.volumeId;
        this.entry = other.entry;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AddOrUpdateTriggerVolumeDisplay", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AddOrUpdateTriggerVolumeDisplay", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getVolumeId(MemorySegment mem) {
        return getVolumeId(mem, 0);
    }
    
    public static String getVolumeId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("VolumeId", mem, offset + getValidatedOffset(mem, offset, 0, 8, "VolumeId"), 4096000);
    }
    
    public static TriggerVolumeDisplayEntry getEntry(MemorySegment mem) {
        return getEntry(mem, 0);
    }
    
    public static TriggerVolumeDisplayEntry getEntry(MemorySegment mem, int offset) {
        return TriggerVolumeDisplayEntry.toObject(mem, offset + getValidatedOffset(mem, offset, 4, 8, "Entry"));
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
    
    public static AddOrUpdateTriggerVolumeDisplay toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AddOrUpdateTriggerVolumeDisplay toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AddOrUpdateTriggerVolumeDisplay and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AddOrUpdateTriggerVolumeDisplay toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 0, varPos, "VolumeId");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("VolumeId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        TriggerVolumeDisplayEntry v1;
        requireSlot(mem, offset + 4, varPos, "Entry");
        {
            v1 = TriggerVolumeDisplayEntry.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new AddOrUpdateTriggerVolumeDisplay(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 8;
        mem.set(PacketIO.PROTO_INT, offset + 0, varOffset - offset - 8);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.volumeId, 4096000);
        mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 8);
        varOffset += this.entry.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 8;
        size += PacketIO.stringSize(volumeId);
    size += entry.computeSize();

        return size;
    }

    public AddOrUpdateTriggerVolumeDisplay clone() {
        AddOrUpdateTriggerVolumeDisplay copy = new AddOrUpdateTriggerVolumeDisplay();
        copy.volumeId = this.volumeId;
        copy.entry = this.entry.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AddOrUpdateTriggerVolumeDisplay other)) return false;
        return java.util.Objects.equals(this.volumeId, other.volumeId) && java.util.Objects.equals(this.entry, other.entry);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(volumeId, entry);
    }

}