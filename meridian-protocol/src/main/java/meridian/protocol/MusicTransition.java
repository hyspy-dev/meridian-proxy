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


public class MusicTransition {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 25;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 49;
    public static final int MAX_SIZE = 98304097;

    @Nullable public String id;
    @Nullable public int[] fromContainerIndices;
    @Nullable public int[] toContainerIndices;
    @Nullable public MusicSync exitAt;
    @Nonnull public DestinationAlign align = DestinationAlign.EntryMarker;
    @Nullable public String alignMarkerName;
    public float fadeOutDuration;
    @Nonnull public FadeCurve fadeOutCurve = FadeCurve.Linear;
    public float fadeOutDelay;
    public float fadeInDuration;
    @Nonnull public FadeCurve fadeInCurve = FadeCurve.Linear;
    public boolean playPostExit;
    @Nullable public String postEvent;
    public int priority;
    public int specificity;

    public MusicTransition() {
    }

    public MusicTransition(@Nullable String id, @Nullable int[] fromContainerIndices, @Nullable int[] toContainerIndices, @Nullable MusicSync exitAt, @Nonnull DestinationAlign align, @Nullable String alignMarkerName, float fadeOutDuration, @Nonnull FadeCurve fadeOutCurve, float fadeOutDelay, float fadeInDuration, @Nonnull FadeCurve fadeInCurve, boolean playPostExit, @Nullable String postEvent, int priority, int specificity) {
        this.id = id;
        this.fromContainerIndices = fromContainerIndices;
        this.toContainerIndices = toContainerIndices;
        this.exitAt = exitAt;
        this.align = align;
        this.alignMarkerName = alignMarkerName;
        this.fadeOutDuration = fadeOutDuration;
        this.fadeOutCurve = fadeOutCurve;
        this.fadeOutDelay = fadeOutDelay;
        this.fadeInDuration = fadeInDuration;
        this.fadeInCurve = fadeInCurve;
        this.playPostExit = playPostExit;
        this.postEvent = postEvent;
        this.priority = priority;
        this.specificity = specificity;
    }

    public MusicTransition(@Nonnull MusicTransition other) {
        this.id = other.id;
        this.fromContainerIndices = other.fromContainerIndices;
        this.toContainerIndices = other.toContainerIndices;
        this.exitAt = other.exitAt;
        this.align = other.align;
        this.alignMarkerName = other.alignMarkerName;
        this.fadeOutDuration = other.fadeOutDuration;
        this.fadeOutCurve = other.fadeOutCurve;
        this.fadeOutDelay = other.fadeOutDelay;
        this.fadeInDuration = other.fadeInDuration;
        this.fadeInCurve = other.fadeInCurve;
        this.playPostExit = other.playPostExit;
        this.postEvent = other.postEvent;
        this.priority = other.priority;
        this.specificity = other.specificity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MusicTransition", offset, (int) mem.byteSize());
        long needed = (long) offset + 49;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MusicTransition", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 25, 49, "Id"), 4096000): null;
    }
    
    @Nullable
    public static int[] getFromContainerIndices(MemorySegment mem) {
        return getFromContainerIndices(mem, 0);
    }
    
    @Nullable
    public static int[] getFromContainerIndices(MemorySegment mem, int offset) {
        if (!hasFromContainerIndices(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 29, 49, "FromContainerIndices");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FromContainerIndices");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("FromContainerIndices", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FromContainerIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static int[] getToContainerIndices(MemorySegment mem) {
        return getToContainerIndices(mem, 0);
    }
    
    @Nullable
    public static int[] getToContainerIndices(MemorySegment mem, int offset) {
        if (!hasToContainerIndices(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 33, 49, "ToContainerIndices");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ToContainerIndices");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ToContainerIndices", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ToContainerIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static MusicSync getExitAt(MemorySegment mem) {
        return getExitAt(mem, 0);
    }
    
    @Nullable
    public static MusicSync getExitAt(MemorySegment mem, int offset) {
        return hasExitAt(mem, offset) ? MusicSync.toObject(mem, offset + getValidatedOffset(mem, offset, 37, 49, "ExitAt")): null;
    }
    
    public static DestinationAlign getAlign(MemorySegment mem) {
        return getAlign(mem, 0);
    }
    
    public static DestinationAlign getAlign(MemorySegment mem, int offset) {
        return DestinationAlign.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static String getAlignMarkerName(MemorySegment mem) {
        return getAlignMarkerName(mem, 0);
    }
    
    @Nullable
    public static String getAlignMarkerName(MemorySegment mem, int offset) {
        return hasAlignMarkerName(mem, offset) ? PacketIO.readVarString("AlignMarkerName", mem, offset + getValidatedOffset(mem, offset, 41, 49, "AlignMarkerName"), 4096000): null;
    }
    
    public static float getFadeOutDuration(MemorySegment mem) {
        return getFadeOutDuration(mem, 0);
    }
    
    public static float getFadeOutDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "FadeOutDuration");
    }
    
    public static FadeCurve getFadeOutCurve(MemorySegment mem) {
        return getFadeOutCurve(mem, 0);
    }
    
    public static FadeCurve getFadeOutCurve(MemorySegment mem, int offset) {
        return FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 6));
    }
    
    public static float getFadeOutDelay(MemorySegment mem) {
        return getFadeOutDelay(mem, 0);
    }
    
    public static float getFadeOutDelay(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 7), "FadeOutDelay");
    }
    
    public static float getFadeInDuration(MemorySegment mem) {
        return getFadeInDuration(mem, 0);
    }
    
    public static float getFadeInDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 11), "FadeInDuration");
    }
    
    public static FadeCurve getFadeInCurve(MemorySegment mem) {
        return getFadeInCurve(mem, 0);
    }
    
    public static FadeCurve getFadeInCurve(MemorySegment mem, int offset) {
        return FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 15));
    }
    
    public static boolean getPlayPostExit(MemorySegment mem) {
        return getPlayPostExit(mem, 0);
    }
    
    public static boolean getPlayPostExit(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 16);
    }
    
    @Nullable
    public static String getPostEvent(MemorySegment mem) {
        return getPostEvent(mem, 0);
    }
    
    @Nullable
    public static String getPostEvent(MemorySegment mem, int offset) {
        return hasPostEvent(mem, offset) ? PacketIO.readVarString("PostEvent", mem, offset + getValidatedOffset(mem, offset, 45, 49, "PostEvent"), 4096000): null;
    }
    
    public static int getPriority(MemorySegment mem) {
        return getPriority(mem, 0);
    }
    
    public static int getPriority(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 17);
    }
    
    public static int getSpecificity(MemorySegment mem) {
        return getSpecificity(mem, 0);
    }
    
    public static int getSpecificity(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 21);
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasFromContainerIndices(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasToContainerIndices(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasExitAt(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasAlignMarkerName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasPostEvent(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
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
    
    public static MusicTransition toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MusicTransition toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MusicTransition and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MusicTransition toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 49;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 25, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 25, -1, "Id");
        }
        
        int[] v1 = null;
        if (hasFromContainerIndices(mem, offset)) {
            requireSlot(mem, offset + 29, varPos, "FromContainerIndices");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FromContainerIndices");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FromContainerIndices", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FromContainerIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v1, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 29, -1, "FromContainerIndices");
        }
        
        int[] v2 = null;
        if (hasToContainerIndices(mem, offset)) {
            requireSlot(mem, offset + 33, varPos, "ToContainerIndices");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ToContainerIndices");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ToContainerIndices", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ToContainerIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v2, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 33, -1, "ToContainerIndices");
        }
        
        MusicSync v3 = null;
        if (hasExitAt(mem, offset)) {
            requireSlot(mem, offset + 37, varPos, "ExitAt");
            v3 = MusicSync.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 37, -1, "ExitAt");
        }
        
        String v5 = null;
        if (hasAlignMarkerName(mem, offset)) {
            requireSlot(mem, offset + 41, varPos, "AlignMarkerName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("AlignMarkerName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 41, -1, "AlignMarkerName");
        }
        
        String v12 = null;
        if (hasPostEvent(mem, offset)) {
            requireSlot(mem, offset + 45, varPos, "PostEvent");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v12 = PacketIO.readVarString("PostEvent", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 45, -1, "PostEvent");
        }
        var result = new MusicTransition(
            v0,
            v1,
            v2,
            v3,
            DestinationAlign.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v5,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "FadeOutDuration"),
            FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 6)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 7), "FadeOutDelay"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 11), "FadeInDuration"),
            FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 15)),
            mem.get(PacketIO.PROTO_BOOL, offset + 16),
            v12,
            mem.get(PacketIO.PROTO_INT, offset + 17),
            mem.get(PacketIO.PROTO_INT, offset + 21)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.fromContainerIndices != null) nullBits |= 0x02;
        if (this.toContainerIndices != null) nullBits |= 0x04;
        if (this.exitAt != null) nullBits |= 0x08;
        if (this.alignMarkerName != null) nullBits |= 0x10;
        if (this.postEvent != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.align.getValue());
        PacketIO.requireFinite(this.fadeOutDuration, "FadeOutDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.fadeOutDuration);
        mem.set(PacketIO.PROTO_BYTE, offset + 6, (byte) this.fadeOutCurve.getValue());
        PacketIO.requireFinite(this.fadeOutDelay, "FadeOutDelay"); mem.set(PacketIO.PROTO_FLOAT, offset + 7, this.fadeOutDelay);
        PacketIO.requireFinite(this.fadeInDuration, "FadeInDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 11, this.fadeInDuration);
        mem.set(PacketIO.PROTO_BYTE, offset + 15, (byte) this.fadeInCurve.getValue());
        mem.set(PacketIO.PROTO_BOOL, offset + 16, this.playPostExit);
        mem.set(PacketIO.PROTO_INT, offset + 17, this.priority);
        mem.set(PacketIO.PROTO_INT, offset + 21, this.specificity);
        var varOffset = offset + 49;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 25, varOffset - offset - 49);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 25, -1);
        }
        if (this.fromContainerIndices != null) {
            mem.set(PacketIO.PROTO_INT, offset + 29, varOffset - offset - 49);
            if (fromContainerIndices.length > 4096000) throw ProtocolException.arrayTooLong("FromContainerIndices", fromContainerIndices.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.fromContainerIndices.length);
            
            MemorySegment.copy(this.fromContainerIndices, 0, mem, PacketIO.PROTO_INT, varOffset, this.fromContainerIndices.length);
            varOffset += this.fromContainerIndices.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 29, -1);
        }
        if (this.toContainerIndices != null) {
            mem.set(PacketIO.PROTO_INT, offset + 33, varOffset - offset - 49);
            if (toContainerIndices.length > 4096000) throw ProtocolException.arrayTooLong("ToContainerIndices", toContainerIndices.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.toContainerIndices.length);
            
            MemorySegment.copy(this.toContainerIndices, 0, mem, PacketIO.PROTO_INT, varOffset, this.toContainerIndices.length);
            varOffset += this.toContainerIndices.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 33, -1);
        }
        if (this.exitAt != null) {
            mem.set(PacketIO.PROTO_INT, offset + 37, varOffset - offset - 49);
            varOffset += this.exitAt.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 37, -1);
        }
        if (this.alignMarkerName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 41, varOffset - offset - 49);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.alignMarkerName, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 41, -1);
        }
        if (this.postEvent != null) {
            mem.set(PacketIO.PROTO_INT, offset + 45, varOffset - offset - 49);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.postEvent, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 45, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 49;
        if (id != null) size += PacketIO.stringSize(id);
    if (fromContainerIndices != null) size += VarInt.size(fromContainerIndices.length) + fromContainerIndices.length * 4;
    if (toContainerIndices != null) size += VarInt.size(toContainerIndices.length) + toContainerIndices.length * 4;
    if (exitAt != null) size += exitAt.computeSize();
    if (alignMarkerName != null) size += PacketIO.stringSize(alignMarkerName);
    if (postEvent != null) size += PacketIO.stringSize(postEvent);

        return size;
    }

    public MusicTransition clone() {
        MusicTransition copy = new MusicTransition();
        copy.id = this.id;
        copy.fromContainerIndices = this.fromContainerIndices != null ? java.util.Arrays.copyOf(this.fromContainerIndices, this.fromContainerIndices.length) : null;
        copy.toContainerIndices = this.toContainerIndices != null ? java.util.Arrays.copyOf(this.toContainerIndices, this.toContainerIndices.length) : null;
        copy.exitAt = this.exitAt != null ? this.exitAt.clone() : null;
        copy.align = this.align;
        copy.alignMarkerName = this.alignMarkerName;
        copy.fadeOutDuration = this.fadeOutDuration;
        copy.fadeOutCurve = this.fadeOutCurve;
        copy.fadeOutDelay = this.fadeOutDelay;
        copy.fadeInDuration = this.fadeInDuration;
        copy.fadeInCurve = this.fadeInCurve;
        copy.playPostExit = this.playPostExit;
        copy.postEvent = this.postEvent;
        copy.priority = this.priority;
        copy.specificity = this.specificity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MusicTransition other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Arrays.equals(this.fromContainerIndices, other.fromContainerIndices) && java.util.Arrays.equals(this.toContainerIndices, other.toContainerIndices) && java.util.Objects.equals(this.exitAt, other.exitAt) && java.util.Objects.equals(this.align, other.align) && java.util.Objects.equals(this.alignMarkerName, other.alignMarkerName) && this.fadeOutDuration == other.fadeOutDuration && java.util.Objects.equals(this.fadeOutCurve, other.fadeOutCurve) && this.fadeOutDelay == other.fadeOutDelay && this.fadeInDuration == other.fadeInDuration && java.util.Objects.equals(this.fadeInCurve, other.fadeInCurve) && this.playPostExit == other.playPostExit && java.util.Objects.equals(this.postEvent, other.postEvent) && this.priority == other.priority && this.specificity == other.specificity;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Arrays.hashCode(fromContainerIndices);
        result = 31 * result + java.util.Arrays.hashCode(toContainerIndices);
        result = 31 * result + java.util.Objects.hashCode(exitAt);
        result = 31 * result + java.util.Objects.hashCode(align);
        result = 31 * result + java.util.Objects.hashCode(alignMarkerName);
        result = 31 * result + Float.hashCode(fadeOutDuration);
        result = 31 * result + java.util.Objects.hashCode(fadeOutCurve);
        result = 31 * result + Float.hashCode(fadeOutDelay);
        result = 31 * result + Float.hashCode(fadeInDuration);
        result = 31 * result + java.util.Objects.hashCode(fadeInCurve);
        result = 31 * result + Boolean.hashCode(playPostExit);
        result = 31 * result + java.util.Objects.hashCode(postEvent);
        result = 31 * result + Integer.hashCode(priority);
        result = 31 * result + Integer.hashCode(specificity);
        return result;
    }

}