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


public class StingerBinding {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 10;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 18;
    public static final int MAX_SIZE = 32768046;

    @Nullable public String musicEvent;
    public int stingerIndex;
    @Nullable public MusicSync playAt;
    public float minRepeatIntervalSeconds;
    @Nonnull public StingerShortLead shortLead = StingerShortLead.DropPickup;

    public StingerBinding() {
    }

    public StingerBinding(@Nullable String musicEvent, int stingerIndex, @Nullable MusicSync playAt, float minRepeatIntervalSeconds, @Nonnull StingerShortLead shortLead) {
        this.musicEvent = musicEvent;
        this.stingerIndex = stingerIndex;
        this.playAt = playAt;
        this.minRepeatIntervalSeconds = minRepeatIntervalSeconds;
        this.shortLead = shortLead;
    }

    public StingerBinding(@Nonnull StingerBinding other) {
        this.musicEvent = other.musicEvent;
        this.stingerIndex = other.stingerIndex;
        this.playAt = other.playAt;
        this.minRepeatIntervalSeconds = other.minRepeatIntervalSeconds;
        this.shortLead = other.shortLead;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("StingerBinding", offset, (int) mem.byteSize());
        long needed = (long) offset + 18;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("StingerBinding", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getMusicEvent(MemorySegment mem) {
        return getMusicEvent(mem, 0);
    }
    
    @Nullable
    public static String getMusicEvent(MemorySegment mem, int offset) {
        return hasMusicEvent(mem, offset) ? PacketIO.readVarString("MusicEvent", mem, offset + getValidatedOffset(mem, offset, 10, 18, "MusicEvent"), 4096000): null;
    }
    
    public static int getStingerIndex(MemorySegment mem) {
        return getStingerIndex(mem, 0);
    }
    
    public static int getStingerIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static MusicSync getPlayAt(MemorySegment mem) {
        return getPlayAt(mem, 0);
    }
    
    @Nullable
    public static MusicSync getPlayAt(MemorySegment mem, int offset) {
        return hasPlayAt(mem, offset) ? MusicSync.toObject(mem, offset + getValidatedOffset(mem, offset, 14, 18, "PlayAt")): null;
    }
    
    public static float getMinRepeatIntervalSeconds(MemorySegment mem) {
        return getMinRepeatIntervalSeconds(mem, 0);
    }
    
    public static float getMinRepeatIntervalSeconds(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "MinRepeatIntervalSeconds");
    }
    
    public static StingerShortLead getShortLead(MemorySegment mem) {
        return getShortLead(mem, 0);
    }
    
    public static StingerShortLead getShortLead(MemorySegment mem, int offset) {
        return StingerShortLead.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 9));
    }
    
    public static boolean hasMusicEvent(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPlayAt(MemorySegment mem, int offset) {
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
    
    public static StingerBinding toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static StingerBinding toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one StingerBinding and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static StingerBinding toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 18;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasMusicEvent(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "MusicEvent");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("MusicEvent", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 10, -1, "MusicEvent");
        }
        
        MusicSync v2 = null;
        if (hasPlayAt(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "PlayAt");
            v2 = MusicSync.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 14, -1, "PlayAt");
        }
        var result = new StingerBinding(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v2,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "MinRepeatIntervalSeconds"),
            StingerShortLead.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 9))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.musicEvent != null) nullBits |= 0x01;
        if (this.playAt != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.stingerIndex);
        PacketIO.requireFinite(this.minRepeatIntervalSeconds, "MinRepeatIntervalSeconds"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.minRepeatIntervalSeconds);
        mem.set(PacketIO.PROTO_BYTE, offset + 9, (byte) this.shortLead.getValue());
        var varOffset = offset + 18;
        if (this.musicEvent != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 18);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.musicEvent, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.playAt != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 18);
            varOffset += this.playAt.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 18;
        if (musicEvent != null) size += PacketIO.stringSize(musicEvent);
    if (playAt != null) size += playAt.computeSize();

        return size;
    }

    public StingerBinding clone() {
        StingerBinding copy = new StingerBinding();
        copy.musicEvent = this.musicEvent;
        copy.stingerIndex = this.stingerIndex;
        copy.playAt = this.playAt != null ? this.playAt.clone() : null;
        copy.minRepeatIntervalSeconds = this.minRepeatIntervalSeconds;
        copy.shortLead = this.shortLead;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StingerBinding other)) return false;
        return java.util.Objects.equals(this.musicEvent, other.musicEvent) && this.stingerIndex == other.stingerIndex && java.util.Objects.equals(this.playAt, other.playAt) && this.minRepeatIntervalSeconds == other.minRepeatIntervalSeconds && java.util.Objects.equals(this.shortLead, other.shortLead);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(musicEvent, stingerIndex, playAt, minRepeatIntervalSeconds, shortLead);
    }

}