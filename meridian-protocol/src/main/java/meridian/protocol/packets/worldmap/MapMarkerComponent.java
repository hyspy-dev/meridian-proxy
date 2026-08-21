// Auto-generated - do not edit
package meridian.protocol.packets.worldmap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public abstract class MapMarkerComponent {
    public static final int MAX_SIZE = 1677721605;

    


    public static MapMarkerComponent toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }

    public static MapMarkerComponent toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }

    public static MapMarkerComponent toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // The subtype starts after the type id as encoded, which VarInt.size cannot report.
        long typeIdPacked = VarInt.getWithLength(mem, offset);
        int typeId = (int) typeIdPacked;
        int typeIdLen = (int) (typeIdPacked >>> 32);

        return switch (typeId) {
            case 0 -> PlayerMarkerComponent.toObject(mem, offset + typeIdLen, cursor);
                case 1 -> PlacedByMarkerComponent.toObject(mem, offset + typeIdLen, cursor);
                case 2 -> HeightDeltaIconComponent.toObject(mem, offset + typeIdLen, cursor);
                case 3 -> TintComponent.toObject(mem, offset + typeIdLen, cursor);
            default -> throw ProtocolException.unknownPolymorphicType("MapMarkerComponent", typeId);
        };
    }


    public int getTypeId() {
        if (this instanceof PlayerMarkerComponent sub) { return 0; }
            if (this instanceof PlacedByMarkerComponent sub) { return 1; }
            if (this instanceof HeightDeltaIconComponent sub) { return 2; }
            if (this instanceof TintComponent sub) { return 3; }
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