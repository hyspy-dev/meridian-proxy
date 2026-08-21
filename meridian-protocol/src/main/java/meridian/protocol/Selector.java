// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public abstract class Selector {
    public static final int MAX_SIZE = 43;

    


    public static Selector toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }

    public static Selector toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }

    public static Selector toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // The subtype starts after the type id as encoded, which VarInt.size cannot report.
        long typeIdPacked = VarInt.getWithLength(mem, offset);
        int typeId = (int) typeIdPacked;
        int typeIdLen = (int) (typeIdPacked >>> 32);

        return switch (typeId) {
            case 0 -> AOECircleSelector.toObject(mem, offset + typeIdLen, cursor);
                case 1 -> AOECylinderSelector.toObject(mem, offset + typeIdLen, cursor);
                case 2 -> RaycastSelector.toObject(mem, offset + typeIdLen, cursor);
                case 3 -> HorizontalSelector.toObject(mem, offset + typeIdLen, cursor);
                case 4 -> StabSelector.toObject(mem, offset + typeIdLen, cursor);
                case 5 -> DonutSelector.toObject(mem, offset + typeIdLen, cursor);
            default -> throw ProtocolException.unknownPolymorphicType("Selector", typeId);
        };
    }


    public int getTypeId() {
        if (this instanceof AOECircleSelector sub) { return 0; }
            if (this instanceof AOECylinderSelector sub) { return 1; }
            if (this instanceof RaycastSelector sub) { return 2; }
            if (this instanceof HorizontalSelector sub) { return 3; }
            if (this instanceof StabSelector sub) { return 4; }
            if (this instanceof DonutSelector sub) { return 5; }
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