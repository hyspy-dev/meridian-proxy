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


public class HorizontalMusicContainer extends MusicContainer {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 74;
    public static final int VARIABLE_FIELD_COUNT = 7;
    public static final int VARIABLE_BLOCK_START = 102;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public MusicTransitionType defaultPhaseTransitionType = MusicTransitionType.Crossfade;
    public float defaultPhaseTransitionDuration;
    @Nullable public int[] children;
    public int audioStateIndex;
    @Nullable public int[] phaseValueIndices;

    public HorizontalMusicContainer() {
    }

    public HorizontalMusicContainer(float volume, int loopCount, float weight, @Nullable Rangef silenceAfter, @Nullable Rangef exitSilence, float fadeInDuration, float fadeOutDuration, @Nonnull MusicTransitionType transitionType, float transitionDuration, @Nullable MusicSync exitAt, @Nullable DestinationAlign align, @Nullable String alignMarkerName, boolean playToCompletion, float resumeMemoryDuration, @Nullable String nameTranslationKey, int audioCategoryIndex, @Nullable TempoSettings tempo, @Nullable StateBinding[] stateBindings, @Nullable StingerBinding[] stingers, @Nonnull MusicTransitionType defaultPhaseTransitionType, float defaultPhaseTransitionDuration, @Nullable int[] children, int audioStateIndex, @Nullable int[] phaseValueIndices) {
        this.volume = volume;
        this.loopCount = loopCount;
        this.weight = weight;
        this.silenceAfter = silenceAfter;
        this.exitSilence = exitSilence;
        this.fadeInDuration = fadeInDuration;
        this.fadeOutDuration = fadeOutDuration;
        this.transitionType = transitionType;
        this.transitionDuration = transitionDuration;
        this.exitAt = exitAt;
        this.align = align;
        this.alignMarkerName = alignMarkerName;
        this.playToCompletion = playToCompletion;
        this.resumeMemoryDuration = resumeMemoryDuration;
        this.nameTranslationKey = nameTranslationKey;
        this.audioCategoryIndex = audioCategoryIndex;
        this.tempo = tempo;
        this.stateBindings = stateBindings;
        this.stingers = stingers;
        this.defaultPhaseTransitionType = defaultPhaseTransitionType;
        this.defaultPhaseTransitionDuration = defaultPhaseTransitionDuration;
        this.children = children;
        this.audioStateIndex = audioStateIndex;
        this.phaseValueIndices = phaseValueIndices;
    }

    public HorizontalMusicContainer(@Nonnull HorizontalMusicContainer other) {
        this.volume = other.volume;
        this.loopCount = other.loopCount;
        this.weight = other.weight;
        this.silenceAfter = other.silenceAfter;
        this.exitSilence = other.exitSilence;
        this.fadeInDuration = other.fadeInDuration;
        this.fadeOutDuration = other.fadeOutDuration;
        this.transitionType = other.transitionType;
        this.transitionDuration = other.transitionDuration;
        this.exitAt = other.exitAt;
        this.align = other.align;
        this.alignMarkerName = other.alignMarkerName;
        this.playToCompletion = other.playToCompletion;
        this.resumeMemoryDuration = other.resumeMemoryDuration;
        this.nameTranslationKey = other.nameTranslationKey;
        this.audioCategoryIndex = other.audioCategoryIndex;
        this.tempo = other.tempo;
        this.stateBindings = other.stateBindings;
        this.stingers = other.stingers;
        this.defaultPhaseTransitionType = other.defaultPhaseTransitionType;
        this.defaultPhaseTransitionDuration = other.defaultPhaseTransitionDuration;
        this.children = other.children;
        this.audioStateIndex = other.audioStateIndex;
        this.phaseValueIndices = other.phaseValueIndices;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("HorizontalMusicContainer", offset, (int) mem.byteSize());
        long needed = (long) offset + 102;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("HorizontalMusicContainer", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getVolume(MemorySegment mem) {
        return getVolume(mem, 0);
    }
    
    public static float getVolume(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Volume");
    }
    
    public static int getLoopCount(MemorySegment mem) {
        return getLoopCount(mem, 0);
    }
    
    public static int getLoopCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 6);
    }
    
    public static float getWeight(MemorySegment mem) {
        return getWeight(mem, 0);
    }
    
    public static float getWeight(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "Weight");
    }
    
    @Nullable
    public static Rangef getSilenceAfter(MemorySegment mem) {
        return getSilenceAfter(mem, 0);
    }
    
    @Nullable
    public static Rangef getSilenceAfter(MemorySegment mem, int offset) {
        return hasSilenceAfter(mem, offset) ? Rangef.toObject(mem, offset + 14): null;
    }
    
    @Nullable
    public static Rangef getExitSilence(MemorySegment mem) {
        return getExitSilence(mem, 0);
    }
    
    @Nullable
    public static Rangef getExitSilence(MemorySegment mem, int offset) {
        return hasExitSilence(mem, offset) ? Rangef.toObject(mem, offset + 22): null;
    }
    
    public static float getFadeInDuration(MemorySegment mem) {
        return getFadeInDuration(mem, 0);
    }
    
    public static float getFadeInDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 30), "FadeInDuration");
    }
    
    public static float getFadeOutDuration(MemorySegment mem) {
        return getFadeOutDuration(mem, 0);
    }
    
    public static float getFadeOutDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 34), "FadeOutDuration");
    }
    
    public static MusicTransitionType getTransitionType(MemorySegment mem) {
        return getTransitionType(mem, 0);
    }
    
    public static MusicTransitionType getTransitionType(MemorySegment mem, int offset) {
        return MusicTransitionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 38));
    }
    
    public static float getTransitionDuration(MemorySegment mem) {
        return getTransitionDuration(mem, 0);
    }
    
    public static float getTransitionDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 39), "TransitionDuration");
    }
    
    @Nullable
    public static MusicSync getExitAt(MemorySegment mem) {
        return getExitAt(mem, 0);
    }
    
    @Nullable
    public static MusicSync getExitAt(MemorySegment mem, int offset) {
        return hasExitAt(mem, offset) ? MusicSync.toObject(mem, offset + getValidatedOffset(mem, offset, 74, 102, "ExitAt")): null;
    }
    
    @Nullable
    public static DestinationAlign getAlign(MemorySegment mem) {
        return getAlign(mem, 0);
    }
    
    @Nullable
    public static DestinationAlign getAlign(MemorySegment mem, int offset) {
        return hasAlign(mem, offset) ? DestinationAlign.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 43)): null;
    }
    
    @Nullable
    public static String getAlignMarkerName(MemorySegment mem) {
        return getAlignMarkerName(mem, 0);
    }
    
    @Nullable
    public static String getAlignMarkerName(MemorySegment mem, int offset) {
        return hasAlignMarkerName(mem, offset) ? PacketIO.readVarString("AlignMarkerName", mem, offset + getValidatedOffset(mem, offset, 78, 102, "AlignMarkerName"), 4096000): null;
    }
    
    public static boolean getPlayToCompletion(MemorySegment mem) {
        return getPlayToCompletion(mem, 0);
    }
    
    public static boolean getPlayToCompletion(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 44);
    }
    
    public static float getResumeMemoryDuration(MemorySegment mem) {
        return getResumeMemoryDuration(mem, 0);
    }
    
    public static float getResumeMemoryDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 45), "ResumeMemoryDuration");
    }
    
    @Nullable
    public static String getNameTranslationKey(MemorySegment mem) {
        return getNameTranslationKey(mem, 0);
    }
    
    @Nullable
    public static String getNameTranslationKey(MemorySegment mem, int offset) {
        return hasNameTranslationKey(mem, offset) ? PacketIO.readVarString("NameTranslationKey", mem, offset + getValidatedOffset(mem, offset, 82, 102, "NameTranslationKey"), 4096000): null;
    }
    
    public static int getAudioCategoryIndex(MemorySegment mem) {
        return getAudioCategoryIndex(mem, 0);
    }
    
    public static int getAudioCategoryIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 49);
    }
    
    @Nullable
    public static TempoSettings getTempo(MemorySegment mem) {
        return getTempo(mem, 0);
    }
    
    @Nullable
    public static TempoSettings getTempo(MemorySegment mem, int offset) {
        return hasTempo(mem, offset) ? TempoSettings.toObject(mem, offset + 53): null;
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem) {
        return getStateBindings(mem, 0);
    }
    
    @Nullable
    public static StateBinding[] getStateBindings(MemorySegment mem, int offset) {
        if (!hasStateBindings(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 86, 102, "StateBindings");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("StateBindings");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("StateBindings", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateBindings", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new StateBinding[len];
        for (var i = 0; i < len; i++) {
            data[i] = StateBinding.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static StingerBinding[] getStingers(MemorySegment mem) {
        return getStingers(mem, 0);
    }
    
    @Nullable
    public static StingerBinding[] getStingers(MemorySegment mem, int offset) {
        if (!hasStingers(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 90, 102, "Stingers");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Stingers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Stingers", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 18 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Stingers", (int) java.lang.Math.min(off + lenOffset + (long) len * 18, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new StingerBinding[len];
        for (var i = 0; i < len; i++) {
            data[i] = StingerBinding.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static MusicTransitionType getDefaultPhaseTransitionType(MemorySegment mem) {
        return getDefaultPhaseTransitionType(mem, 0);
    }
    
    public static MusicTransitionType getDefaultPhaseTransitionType(MemorySegment mem, int offset) {
        return MusicTransitionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 65));
    }
    
    public static float getDefaultPhaseTransitionDuration(MemorySegment mem) {
        return getDefaultPhaseTransitionDuration(mem, 0);
    }
    
    public static float getDefaultPhaseTransitionDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 66), "DefaultPhaseTransitionDuration");
    }
    
    @Nullable
    public static int[] getChildren(MemorySegment mem) {
        return getChildren(mem, 0);
    }
    
    @Nullable
    public static int[] getChildren(MemorySegment mem, int offset) {
        if (!hasChildren(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 94, 102, "Children");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Children");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Children", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Children", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static int getAudioStateIndex(MemorySegment mem) {
        return getAudioStateIndex(mem, 0);
    }
    
    public static int getAudioStateIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 70);
    }
    
    @Nullable
    public static int[] getPhaseValueIndices(MemorySegment mem) {
        return getPhaseValueIndices(mem, 0);
    }
    
    @Nullable
    public static int[] getPhaseValueIndices(MemorySegment mem, int offset) {
        if (!hasPhaseValueIndices(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 98, 102, "PhaseValueIndices");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("PhaseValueIndices");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("PhaseValueIndices", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("PhaseValueIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static boolean hasSilenceAfter(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasExitSilence(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasAlign(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTempo(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasExitAt(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasAlignMarkerName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasNameTranslationKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasStateBindings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasStingers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasChildren(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasPhaseValueIndices(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x04) != 0;
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
    
    public static HorizontalMusicContainer toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static HorizontalMusicContainer toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one HorizontalMusicContainer and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static HorizontalMusicContainer toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 102;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        MusicSync v9 = null;
        if (hasExitAt(mem, offset)) {
            requireSlot(mem, offset + 74, varPos, "ExitAt");
            v9 = MusicSync.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 74, -1, "ExitAt");
        }
        
        String v11 = null;
        if (hasAlignMarkerName(mem, offset)) {
            requireSlot(mem, offset + 78, varPos, "AlignMarkerName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v11 = PacketIO.readVarString("AlignMarkerName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 78, -1, "AlignMarkerName");
        }
        
        String v14 = null;
        if (hasNameTranslationKey(mem, offset)) {
            requireSlot(mem, offset + 82, varPos, "NameTranslationKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v14 = PacketIO.readVarString("NameTranslationKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 82, -1, "NameTranslationKey");
        }
        
        StateBinding[] v17 = null;
        if (hasStateBindings(mem, offset)) {
            requireSlot(mem, offset + 86, varPos, "StateBindings");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("StateBindings");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("StateBindings", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateBindings", (int) java.lang.Math.min(off + lenOffset + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v17 = new StateBinding[len];
            for (var i = 0; i < len; i++) {
                v17[i] = StateBinding.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 86, -1, "StateBindings");
        }
        
        StingerBinding[] v18 = null;
        if (hasStingers(mem, offset)) {
            requireSlot(mem, offset + 90, varPos, "Stingers");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Stingers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Stingers", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 18 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Stingers", (int) java.lang.Math.min(off + lenOffset + (long) len * 18, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v18 = new StingerBinding[len];
            for (var i = 0; i < len; i++) {
                v18[i] = StingerBinding.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 90, -1, "Stingers");
        }
        
        int[] v21 = null;
        if (hasChildren(mem, offset)) {
            requireSlot(mem, offset + 94, varPos, "Children");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Children");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Children", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Children", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v21 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v21, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 94, -1, "Children");
        }
        
        int[] v23 = null;
        if (hasPhaseValueIndices(mem, offset)) {
            requireSlot(mem, offset + 98, varPos, "PhaseValueIndices");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("PhaseValueIndices");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("PhaseValueIndices", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("PhaseValueIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v23 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v23, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 98, -1, "PhaseValueIndices");
        }
        var result = new HorizontalMusicContainer(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Volume"),
            mem.get(PacketIO.PROTO_INT, offset + 6),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "Weight"),
            hasSilenceAfter(mem, offset) ? Rangef.toObject(mem, offset + 14) : null,
            hasExitSilence(mem, offset) ? Rangef.toObject(mem, offset + 22) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 30), "FadeInDuration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 34), "FadeOutDuration"),
            MusicTransitionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 38)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 39), "TransitionDuration"),
            v9,
            hasAlign(mem, offset) ? DestinationAlign.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 43)) : null,
            v11,
            mem.get(PacketIO.PROTO_BOOL, offset + 44),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 45), "ResumeMemoryDuration"),
            v14,
            mem.get(PacketIO.PROTO_INT, offset + 49),
            hasTempo(mem, offset) ? TempoSettings.toObject(mem, offset + 53) : null,
            v17,
            v18,
            MusicTransitionType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 65)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 66), "DefaultPhaseTransitionDuration"),
            v21,
            mem.get(PacketIO.PROTO_INT, offset + 70),
            v23
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.silenceAfter != null) nullBits |= 0x01;
        if (this.exitSilence != null) nullBits |= 0x02;
        if (this.align != null) nullBits |= 0x04;
        if (this.tempo != null) nullBits |= 0x08;
        if (this.exitAt != null) nullBits |= 0x10;
        if (this.alignMarkerName != null) nullBits |= 0x20;
        if (this.nameTranslationKey != null) nullBits |= 0x40;
        if (this.stateBindings != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.stingers != null) nullBits |= 0x01;
        if (this.children != null) nullBits |= 0x02;
        if (this.phaseValueIndices != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        PacketIO.requireFinite(this.volume, "Volume"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.volume);
        mem.set(PacketIO.PROTO_INT, offset + 6, this.loopCount);
        PacketIO.requireFinite(this.weight, "Weight"); mem.set(PacketIO.PROTO_FLOAT, offset + 10, this.weight);
        if (this.silenceAfter != null) {
            this.silenceAfter.serialize(mem, offset + 14);
        } else {
            mem.asSlice(offset + 14, 8).fill((byte) 0); 
        }
        if (this.exitSilence != null) {
            this.exitSilence.serialize(mem, offset + 22);
        } else {
            mem.asSlice(offset + 22, 8).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.fadeInDuration, "FadeInDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 30, this.fadeInDuration);
        PacketIO.requireFinite(this.fadeOutDuration, "FadeOutDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 34, this.fadeOutDuration);
        mem.set(PacketIO.PROTO_BYTE, offset + 38, (byte) this.transitionType.getValue());
        PacketIO.requireFinite(this.transitionDuration, "TransitionDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 39, this.transitionDuration);
        if (this.align != null) {
            mem.set(PacketIO.PROTO_BYTE, offset + 43, (byte) this.align.getValue());
        } else {
            mem.asSlice(offset + 43, 1).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 44, this.playToCompletion);
        PacketIO.requireFinite(this.resumeMemoryDuration, "ResumeMemoryDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 45, this.resumeMemoryDuration);
        mem.set(PacketIO.PROTO_INT, offset + 49, this.audioCategoryIndex);
        if (this.tempo != null) {
            this.tempo.serialize(mem, offset + 53);
        } else {
            mem.asSlice(offset + 53, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 65, (byte) this.defaultPhaseTransitionType.getValue());
        PacketIO.requireFinite(this.defaultPhaseTransitionDuration, "DefaultPhaseTransitionDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 66, this.defaultPhaseTransitionDuration);
        mem.set(PacketIO.PROTO_INT, offset + 70, this.audioStateIndex);
        var varOffset = offset + 102;
        if (this.exitAt != null) {
            mem.set(PacketIO.PROTO_INT, offset + 74, varOffset - offset - 102);
            varOffset += this.exitAt.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 74, -1);
        }
        if (this.alignMarkerName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 78, varOffset - offset - 102);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.alignMarkerName, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 78, -1);
        }
        if (this.nameTranslationKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 82, varOffset - offset - 102);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.nameTranslationKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 82, -1);
        }
        if (this.stateBindings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 86, varOffset - offset - 102);
            if (stateBindings.length > 4096000) throw ProtocolException.arrayTooLong("StateBindings", stateBindings.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.stateBindings.length);
            
            var stateBindingsValueOffset = 0;
            for (var i = 0; i < this.stateBindings.length; i++) {
                stateBindingsValueOffset += this.stateBindings[i].serialize(mem, varOffset + stateBindingsValueOffset);
            }
            varOffset += stateBindingsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 86, -1);
        }
        if (this.stingers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 90, varOffset - offset - 102);
            if (stingers.length > 4096000) throw ProtocolException.arrayTooLong("Stingers", stingers.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.stingers.length);
            
            var stingersValueOffset = 0;
            for (var i = 0; i < this.stingers.length; i++) {
                stingersValueOffset += this.stingers[i].serialize(mem, varOffset + stingersValueOffset);
            }
            varOffset += stingersValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 90, -1);
        }
        if (this.children != null) {
            mem.set(PacketIO.PROTO_INT, offset + 94, varOffset - offset - 102);
            if (children.length > 4096000) throw ProtocolException.arrayTooLong("Children", children.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.children.length);
            
            MemorySegment.copy(this.children, 0, mem, PacketIO.PROTO_INT, varOffset, this.children.length);
            varOffset += this.children.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 94, -1);
        }
        if (this.phaseValueIndices != null) {
            mem.set(PacketIO.PROTO_INT, offset + 98, varOffset - offset - 102);
            if (phaseValueIndices.length > 4096000) throw ProtocolException.arrayTooLong("PhaseValueIndices", phaseValueIndices.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.phaseValueIndices.length);
            
            MemorySegment.copy(this.phaseValueIndices, 0, mem, PacketIO.PROTO_INT, varOffset, this.phaseValueIndices.length);
            varOffset += this.phaseValueIndices.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 98, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 102;
        if (exitAt != null) size += exitAt.computeSize();
    if (alignMarkerName != null) size += PacketIO.stringSize(alignMarkerName);
    if (nameTranslationKey != null) size += PacketIO.stringSize(nameTranslationKey);
    if (stateBindings != null) {
        int stateBindingsSize = 0;
for (var elem : stateBindings) stateBindingsSize += elem.computeSize();
size += VarInt.size(stateBindings.length) + stateBindingsSize;
    }
    if (stingers != null) {
        int stingersSize = 0;
for (var elem : stingers) stingersSize += elem.computeSize();
size += VarInt.size(stingers.length) + stingersSize;
    }
    if (children != null) size += VarInt.size(children.length) + children.length * 4;
    if (phaseValueIndices != null) size += VarInt.size(phaseValueIndices.length) + phaseValueIndices.length * 4;

        return size;
    }

    public HorizontalMusicContainer clone() {
        HorizontalMusicContainer copy = new HorizontalMusicContainer();
        copy.volume = this.volume;
        copy.loopCount = this.loopCount;
        copy.weight = this.weight;
        copy.silenceAfter = this.silenceAfter != null ? this.silenceAfter.clone() : null;
        copy.exitSilence = this.exitSilence != null ? this.exitSilence.clone() : null;
        copy.fadeInDuration = this.fadeInDuration;
        copy.fadeOutDuration = this.fadeOutDuration;
        copy.transitionType = this.transitionType;
        copy.transitionDuration = this.transitionDuration;
        copy.exitAt = this.exitAt != null ? this.exitAt.clone() : null;
        copy.align = this.align;
        copy.alignMarkerName = this.alignMarkerName;
        copy.playToCompletion = this.playToCompletion;
        copy.resumeMemoryDuration = this.resumeMemoryDuration;
        copy.nameTranslationKey = this.nameTranslationKey;
        copy.audioCategoryIndex = this.audioCategoryIndex;
        copy.tempo = this.tempo != null ? this.tempo.clone() : null;
        copy.stateBindings = this.stateBindings != null ? java.util.Arrays.stream(this.stateBindings).map(e -> e.clone()).toArray(StateBinding[]::new) : null;
        copy.stingers = this.stingers != null ? java.util.Arrays.stream(this.stingers).map(e -> e.clone()).toArray(StingerBinding[]::new) : null;
        copy.defaultPhaseTransitionType = this.defaultPhaseTransitionType;
        copy.defaultPhaseTransitionDuration = this.defaultPhaseTransitionDuration;
        copy.children = this.children != null ? java.util.Arrays.copyOf(this.children, this.children.length) : null;
        copy.audioStateIndex = this.audioStateIndex;
        copy.phaseValueIndices = this.phaseValueIndices != null ? java.util.Arrays.copyOf(this.phaseValueIndices, this.phaseValueIndices.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HorizontalMusicContainer other)) return false;
        return this.volume == other.volume && this.loopCount == other.loopCount && this.weight == other.weight && java.util.Objects.equals(this.silenceAfter, other.silenceAfter) && java.util.Objects.equals(this.exitSilence, other.exitSilence) && this.fadeInDuration == other.fadeInDuration && this.fadeOutDuration == other.fadeOutDuration && java.util.Objects.equals(this.transitionType, other.transitionType) && this.transitionDuration == other.transitionDuration && java.util.Objects.equals(this.exitAt, other.exitAt) && java.util.Objects.equals(this.align, other.align) && java.util.Objects.equals(this.alignMarkerName, other.alignMarkerName) && this.playToCompletion == other.playToCompletion && this.resumeMemoryDuration == other.resumeMemoryDuration && java.util.Objects.equals(this.nameTranslationKey, other.nameTranslationKey) && this.audioCategoryIndex == other.audioCategoryIndex && java.util.Objects.equals(this.tempo, other.tempo) && java.util.Arrays.equals(this.stateBindings, other.stateBindings) && java.util.Arrays.equals(this.stingers, other.stingers) && java.util.Objects.equals(this.defaultPhaseTransitionType, other.defaultPhaseTransitionType) && this.defaultPhaseTransitionDuration == other.defaultPhaseTransitionDuration && java.util.Arrays.equals(this.children, other.children) && this.audioStateIndex == other.audioStateIndex && java.util.Arrays.equals(this.phaseValueIndices, other.phaseValueIndices);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Float.hashCode(volume);
        result = 31 * result + Integer.hashCode(loopCount);
        result = 31 * result + Float.hashCode(weight);
        result = 31 * result + java.util.Objects.hashCode(silenceAfter);
        result = 31 * result + java.util.Objects.hashCode(exitSilence);
        result = 31 * result + Float.hashCode(fadeInDuration);
        result = 31 * result + Float.hashCode(fadeOutDuration);
        result = 31 * result + java.util.Objects.hashCode(transitionType);
        result = 31 * result + Float.hashCode(transitionDuration);
        result = 31 * result + java.util.Objects.hashCode(exitAt);
        result = 31 * result + java.util.Objects.hashCode(align);
        result = 31 * result + java.util.Objects.hashCode(alignMarkerName);
        result = 31 * result + Boolean.hashCode(playToCompletion);
        result = 31 * result + Float.hashCode(resumeMemoryDuration);
        result = 31 * result + java.util.Objects.hashCode(nameTranslationKey);
        result = 31 * result + Integer.hashCode(audioCategoryIndex);
        result = 31 * result + java.util.Objects.hashCode(tempo);
        result = 31 * result + java.util.Arrays.hashCode(stateBindings);
        result = 31 * result + java.util.Arrays.hashCode(stingers);
        result = 31 * result + java.util.Objects.hashCode(defaultPhaseTransitionType);
        result = 31 * result + Float.hashCode(defaultPhaseTransitionDuration);
        result = 31 * result + java.util.Arrays.hashCode(children);
        result = 31 * result + Integer.hashCode(audioStateIndex);
        result = 31 * result + java.util.Arrays.hashCode(phaseValueIndices);
        return result;
    }

}