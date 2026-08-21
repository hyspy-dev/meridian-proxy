// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public abstract class ParamValue {
    public static final int MAX_SIZE = 16384011;

    


    public static ParamValue toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }

    public static ParamValue toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }

    public static ParamValue toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // The subtype starts after the type id as encoded, which VarInt.size cannot report.
        long typeIdPacked = VarInt.getWithLength(mem, offset);
        int typeId = (int) typeIdPacked;
        int typeIdLen = (int) (typeIdPacked >>> 32);

        return switch (typeId) {
            case 0 -> StringParamValue.toObject(mem, offset + typeIdLen, cursor);
                case 1 -> BoolParamValue.toObject(mem, offset + typeIdLen, cursor);
                case 2 -> DoubleParamValue.toObject(mem, offset + typeIdLen, cursor);
                case 3 -> IntParamValue.toObject(mem, offset + typeIdLen, cursor);
                case 4 -> LongParamValue.toObject(mem, offset + typeIdLen, cursor);
            default -> throw ProtocolException.unknownPolymorphicType("ParamValue", typeId);
        };
    }


    public int getTypeId() {
        if (this instanceof StringParamValue sub) { return 0; }
            if (this instanceof BoolParamValue sub) { return 1; }
            if (this instanceof DoubleParamValue sub) { return 2; }
            if (this instanceof IntParamValue sub) { return 3; }
            if (this instanceof LongParamValue sub) { return 4; }
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