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


public class SegmentMusicContainer extends MusicContainer {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 89;
    public static final int VARIABLE_FIELD_COUNT = 7;
    public static final int VARIABLE_BLOCK_START = 117;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public LayerPlacement[] layers;
    @Nullable public BarBeatDuration entryMarker;
    @Nullable public BarBeatDuration exitMarker;
    @Nullable public MusicMarker[] markers;

    public SegmentMusicContainer() {
    }

    public SegmentMusicContainer(float volume, int loopCount, float weight, @Nullable Rangef silenceAfter, @Nullable Rangef exitSilence, float fadeInDuration, float fadeOutDuration, @Nonnull MusicTransitionType transitionType, float transitionDuration, @Nullable MusicSync exitAt, @Nullable DestinationAlign align, @Nullable String alignMarkerName, boolean playToCompletion, float resumeMemoryDuration, @Nullable String nameTranslationKey, int audioCategoryIndex, @Nullable TempoSettings tempo, @Nullable StateBinding[] stateBindings, @Nullable StingerBinding[] stingers, @Nullable LayerPlacement[] layers, @Nullable BarBeatDuration entryMarker, @Nullable BarBeatDuration exitMarker, @Nullable MusicMarker[] markers) {
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
        this.layers = layers;
        this.entryMarker = entryMarker;
        this.exitMarker = exitMarker;
        this.markers = markers;
    }

    public SegmentMusicContainer(@Nonnull SegmentMusicContainer other) {
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
        this.layers = other.layers;
        this.entryMarker = other.entryMarker;
        this.exitMarker = other.exitMarker;
        this.markers = other.markers;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SegmentMusicContainer", offset, (int) mem.byteSize());
        long needed = (long) offset + 117;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SegmentMusicContainer", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
        return hasExitAt(mem, offset) ? MusicSync.toObject(mem, offset + getValidatedOffset(mem, offset, 89, 117, "ExitAt")): null;
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
        return hasAlignMarkerName(mem, offset) ? PacketIO.readVarString("AlignMarkerName", mem, offset + getValidatedOffset(mem, offset, 93, 117, "AlignMarkerName"), 4096000): null;
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
        return hasNameTranslationKey(mem, offset) ? PacketIO.readVarString("NameTranslationKey", mem, offset + getValidatedOffset(mem, offset, 97, 117, "NameTranslationKey"), 4096000): null;
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
        var off = offset + getValidatedOffset(mem, offset, 101, 117, "StateBindings");
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
        var off = offset + getValidatedOffset(mem, offset, 105, 117, "Stingers");
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
    
    @Nullable
    public static LayerPlacement[] getLayers(MemorySegment mem) {
        return getLayers(mem, 0);
    }
    
    @Nullable
    public static LayerPlacement[] getLayers(MemorySegment mem, int offset) {
        if (!hasLayers(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 109, 117, "Layers");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Layers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Layers", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 25 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Layers", (int) java.lang.Math.min(off + lenOffset + (long) len * 25, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new LayerPlacement[len];
        for (var i = 0; i < len; i++) {
            data[i] = LayerPlacement.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static BarBeatDuration getEntryMarker(MemorySegment mem) {
        return getEntryMarker(mem, 0);
    }
    
    @Nullable
    public static BarBeatDuration getEntryMarker(MemorySegment mem, int offset) {
        return hasEntryMarker(mem, offset) ? BarBeatDuration.toObject(mem, offset + 65): null;
    }
    
    @Nullable
    public static BarBeatDuration getExitMarker(MemorySegment mem) {
        return getExitMarker(mem, 0);
    }
    
    @Nullable
    public static BarBeatDuration getExitMarker(MemorySegment mem, int offset) {
        return hasExitMarker(mem, offset) ? BarBeatDuration.toObject(mem, offset + 77): null;
    }
    
    @Nullable
    public static MusicMarker[] getMarkers(MemorySegment mem) {
        return getMarkers(mem, 0);
    }
    
    @Nullable
    public static MusicMarker[] getMarkers(MemorySegment mem, int offset) {
        if (!hasMarkers(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 113, 117, "Markers");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Markers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Markers", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Markers", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new MusicMarker[len];
        for (var i = 0; i < len; i++) {
            data[i] = MusicMarker.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
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
    
    public static boolean hasEntryMarker(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasExitMarker(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasExitAt(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasAlignMarkerName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasNameTranslationKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasStateBindings(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasStingers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasLayers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasMarkers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x10) != 0;
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
    
    public static SegmentMusicContainer toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SegmentMusicContainer toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SegmentMusicContainer and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SegmentMusicContainer toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 117;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        MusicSync v9 = null;
        if (hasExitAt(mem, offset)) {
            requireSlot(mem, offset + 89, varPos, "ExitAt");
            v9 = MusicSync.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 89, -1, "ExitAt");
        }
        
        String v11 = null;
        if (hasAlignMarkerName(mem, offset)) {
            requireSlot(mem, offset + 93, varPos, "AlignMarkerName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v11 = PacketIO.readVarString("AlignMarkerName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 93, -1, "AlignMarkerName");
        }
        
        String v14 = null;
        if (hasNameTranslationKey(mem, offset)) {
            requireSlot(mem, offset + 97, varPos, "NameTranslationKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v14 = PacketIO.readVarString("NameTranslationKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 97, -1, "NameTranslationKey");
        }
        
        StateBinding[] v17 = null;
        if (hasStateBindings(mem, offset)) {
            requireSlot(mem, offset + 101, varPos, "StateBindings");
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
            requireSlot(mem, offset + 101, -1, "StateBindings");
        }
        
        StingerBinding[] v18 = null;
        if (hasStingers(mem, offset)) {
            requireSlot(mem, offset + 105, varPos, "Stingers");
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
            requireSlot(mem, offset + 105, -1, "Stingers");
        }
        
        LayerPlacement[] v19 = null;
        if (hasLayers(mem, offset)) {
            requireSlot(mem, offset + 109, varPos, "Layers");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Layers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Layers", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 25 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Layers", (int) java.lang.Math.min(off + lenOffset + (long) len * 25, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v19 = new LayerPlacement[len];
            for (var i = 0; i < len; i++) {
                v19[i] = LayerPlacement.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 109, -1, "Layers");
        }
        
        MusicMarker[] v22 = null;
        if (hasMarkers(mem, offset)) {
            requireSlot(mem, offset + 113, varPos, "Markers");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Markers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Markers", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Markers", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v22 = new MusicMarker[len];
            for (var i = 0; i < len; i++) {
                v22[i] = MusicMarker.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 113, -1, "Markers");
        }
        var result = new SegmentMusicContainer(
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
            v19,
            hasEntryMarker(mem, offset) ? BarBeatDuration.toObject(mem, offset + 65) : null,
            hasExitMarker(mem, offset) ? BarBeatDuration.toObject(mem, offset + 77) : null,
            v22
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
        if (this.entryMarker != null) nullBits |= 0x10;
        if (this.exitMarker != null) nullBits |= 0x20;
        if (this.exitAt != null) nullBits |= 0x40;
        if (this.alignMarkerName != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.nameTranslationKey != null) nullBits |= 0x01;
        if (this.stateBindings != null) nullBits |= 0x02;
        if (this.stingers != null) nullBits |= 0x04;
        if (this.layers != null) nullBits |= 0x08;
        if (this.markers != null) nullBits |= 0x10;
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
        if (this.entryMarker != null) {
            this.entryMarker.serialize(mem, offset + 65);
        } else {
            mem.asSlice(offset + 65, 12).fill((byte) 0); 
        }
        if (this.exitMarker != null) {
            this.exitMarker.serialize(mem, offset + 77);
        } else {
            mem.asSlice(offset + 77, 12).fill((byte) 0); 
        }
        var varOffset = offset + 117;
        if (this.exitAt != null) {
            mem.set(PacketIO.PROTO_INT, offset + 89, varOffset - offset - 117);
            varOffset += this.exitAt.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 89, -1);
        }
        if (this.alignMarkerName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 93, varOffset - offset - 117);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.alignMarkerName, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 93, -1);
        }
        if (this.nameTranslationKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 97, varOffset - offset - 117);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.nameTranslationKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 97, -1);
        }
        if (this.stateBindings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 101, varOffset - offset - 117);
            if (stateBindings.length > 4096000) throw ProtocolException.arrayTooLong("StateBindings", stateBindings.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.stateBindings.length);
            
            var stateBindingsValueOffset = 0;
            for (var i = 0; i < this.stateBindings.length; i++) {
                stateBindingsValueOffset += this.stateBindings[i].serialize(mem, varOffset + stateBindingsValueOffset);
            }
            varOffset += stateBindingsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 101, -1);
        }
        if (this.stingers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 105, varOffset - offset - 117);
            if (stingers.length > 4096000) throw ProtocolException.arrayTooLong("Stingers", stingers.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.stingers.length);
            
            var stingersValueOffset = 0;
            for (var i = 0; i < this.stingers.length; i++) {
                stingersValueOffset += this.stingers[i].serialize(mem, varOffset + stingersValueOffset);
            }
            varOffset += stingersValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 105, -1);
        }
        if (this.layers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 109, varOffset - offset - 117);
            if (layers.length > 4096000) throw ProtocolException.arrayTooLong("Layers", layers.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.layers.length);
            
            var layersValueOffset = 0;
            for (var i = 0; i < this.layers.length; i++) {
                layersValueOffset += this.layers[i].serialize(mem, varOffset + layersValueOffset);
            }
            varOffset += layersValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 109, -1);
        }
        if (this.markers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 113, varOffset - offset - 117);
            if (markers.length > 4096000) throw ProtocolException.arrayTooLong("Markers", markers.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.markers.length);
            
            var markersValueOffset = 0;
            for (var i = 0; i < this.markers.length; i++) {
                markersValueOffset += this.markers[i].serialize(mem, varOffset + markersValueOffset);
            }
            varOffset += markersValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 113, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 117;
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
    if (layers != null) {
        int layersSize = 0;
for (var elem : layers) layersSize += elem.computeSize();
size += VarInt.size(layers.length) + layersSize;
    }
    if (markers != null) {
        int markersSize = 0;
for (var elem : markers) markersSize += elem.computeSize();
size += VarInt.size(markers.length) + markersSize;
    }

        return size;
    }

    public SegmentMusicContainer clone() {
        SegmentMusicContainer copy = new SegmentMusicContainer();
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
        copy.layers = this.layers != null ? java.util.Arrays.stream(this.layers).map(e -> e.clone()).toArray(LayerPlacement[]::new) : null;
        copy.entryMarker = this.entryMarker != null ? this.entryMarker.clone() : null;
        copy.exitMarker = this.exitMarker != null ? this.exitMarker.clone() : null;
        copy.markers = this.markers != null ? java.util.Arrays.stream(this.markers).map(e -> e.clone()).toArray(MusicMarker[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SegmentMusicContainer other)) return false;
        return this.volume == other.volume && this.loopCount == other.loopCount && this.weight == other.weight && java.util.Objects.equals(this.silenceAfter, other.silenceAfter) && java.util.Objects.equals(this.exitSilence, other.exitSilence) && this.fadeInDuration == other.fadeInDuration && this.fadeOutDuration == other.fadeOutDuration && java.util.Objects.equals(this.transitionType, other.transitionType) && this.transitionDuration == other.transitionDuration && java.util.Objects.equals(this.exitAt, other.exitAt) && java.util.Objects.equals(this.align, other.align) && java.util.Objects.equals(this.alignMarkerName, other.alignMarkerName) && this.playToCompletion == other.playToCompletion && this.resumeMemoryDuration == other.resumeMemoryDuration && java.util.Objects.equals(this.nameTranslationKey, other.nameTranslationKey) && this.audioCategoryIndex == other.audioCategoryIndex && java.util.Objects.equals(this.tempo, other.tempo) && java.util.Arrays.equals(this.stateBindings, other.stateBindings) && java.util.Arrays.equals(this.stingers, other.stingers) && java.util.Arrays.equals(this.layers, other.layers) && java.util.Objects.equals(this.entryMarker, other.entryMarker) && java.util.Objects.equals(this.exitMarker, other.exitMarker) && java.util.Arrays.equals(this.markers, other.markers);
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
        result = 31 * result + java.util.Arrays.hashCode(layers);
        result = 31 * result + java.util.Objects.hashCode(entryMarker);
        result = 31 * result + java.util.Objects.hashCode(exitMarker);
        result = 31 * result + java.util.Arrays.hashCode(markers);
        return result;
    }

}