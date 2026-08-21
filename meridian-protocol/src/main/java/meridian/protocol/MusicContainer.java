// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public abstract class MusicContainer {
    public static final int MAX_SIZE = 1677721605;

        public float volume;
    public int loopCount;
    public float weight;
    @Nullable public Rangef silenceAfter;
    @Nullable public Rangef exitSilence;
    public float fadeInDuration;
    public float fadeOutDuration;
    @Nonnull public MusicTransitionType transitionType = MusicTransitionType.Crossfade;
    public float transitionDuration;
    @Nullable public MusicSync exitAt;
    @Nullable public DestinationAlign align;
    @Nullable public String alignMarkerName;
    public boolean playToCompletion;
    public float resumeMemoryDuration;
    @Nullable public String nameTranslationKey;
    public int audioCategoryIndex;
    @Nullable public TempoSettings tempo;
    @Nullable public StateBinding[] stateBindings;
    @Nullable public StingerBinding[] stingers;



    public static MusicContainer toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }

    public static MusicContainer toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }

    public static MusicContainer toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // The subtype starts after the type id as encoded, which VarInt.size cannot report.
        long typeIdPacked = VarInt.getWithLength(mem, offset);
        int typeId = (int) typeIdPacked;
        int typeIdLen = (int) (typeIdPacked >>> 32);

        return switch (typeId) {
            case 0 -> SingleTrackMusicContainer.toObject(mem, offset + typeIdLen, cursor);
                case 1 -> RandomMusicContainer.toObject(mem, offset + typeIdLen, cursor);
                case 2 -> SequenceMusicContainer.toObject(mem, offset + typeIdLen, cursor);
                case 3 -> HorizontalMusicContainer.toObject(mem, offset + typeIdLen, cursor);
                case 4 -> SegmentMusicContainer.toObject(mem, offset + typeIdLen, cursor);
            default -> throw ProtocolException.unknownPolymorphicType("MusicContainer", typeId);
        };
    }


    public int getTypeId() {
        if (this instanceof SingleTrackMusicContainer sub) { return 0; }
            if (this instanceof RandomMusicContainer sub) { return 1; }
            if (this instanceof SequenceMusicContainer sub) { return 2; }
            if (this instanceof HorizontalMusicContainer sub) { return 3; }
            if (this instanceof SegmentMusicContainer sub) { return 4; }
        throw new IllegalStateException("Unknown subtype: " + getClass().getName());
    }

    public abstract int serialize(@Nonnull MemorySegment mem, int offset);
    public abstract int computeSize();


    public int serializeWithTypeId(@Nonnull MemorySegment mem, int offset) {
        var len = VarInt.set(mem, offset, getTypeId());
        return len + serialize(mem, offset + len);
    }

    public int computeSizeWithTypeId() {
        return VarInt.size(getTypeId()) + computeSize();
    }
}