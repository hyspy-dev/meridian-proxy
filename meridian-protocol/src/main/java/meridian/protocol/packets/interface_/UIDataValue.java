// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public abstract class UIDataValue {
    public static final int MAX_SIZE = 1677721605;

    


    public static UIDataValue toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }

    public static UIDataValue toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }

    public static UIDataValue toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // The subtype starts after the type id as encoded, which VarInt.size cannot report.
        long typeIdPacked = VarInt.getWithLength(mem, offset);
        int typeId = (int) typeIdPacked;
        int typeIdLen = (int) (typeIdPacked >>> 32);

        return switch (typeId) {
            case 0 -> UIStringDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 1 -> UIFloatDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 2 -> UIIntDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 3 -> UIBoolDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 4 -> UICommandDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 5 -> UIObjectDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 6 -> UIEnumDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 7 -> UIListDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 8 -> UIByteDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 9 -> UISByteDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 10 -> UIShortDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 11 -> UIUShortDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 12 -> UIUIntDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 13 -> UILongDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 14 -> UIULongDataValue.toObject(mem, offset + typeIdLen, cursor);
                case 15 -> UIDoubleDataValue.toObject(mem, offset + typeIdLen, cursor);
            default -> throw ProtocolException.unknownPolymorphicType("UIDataValue", typeId);
        };
    }


    public int getTypeId() {
        if (this instanceof UIStringDataValue sub) { return 0; }
            if (this instanceof UIFloatDataValue sub) { return 1; }
            if (this instanceof UIIntDataValue sub) { return 2; }
            if (this instanceof UIBoolDataValue sub) { return 3; }
            if (this instanceof UICommandDataValue sub) { return 4; }
            if (this instanceof UIObjectDataValue sub) { return 5; }
            if (this instanceof UIEnumDataValue sub) { return 6; }
            if (this instanceof UIListDataValue sub) { return 7; }
            if (this instanceof UIByteDataValue sub) { return 8; }
            if (this instanceof UISByteDataValue sub) { return 9; }
            if (this instanceof UIShortDataValue sub) { return 10; }
            if (this instanceof UIUShortDataValue sub) { return 11; }
            if (this instanceof UIUIntDataValue sub) { return 12; }
            if (this instanceof UILongDataValue sub) { return 13; }
            if (this instanceof UIULongDataValue sub) { return 14; }
            if (this instanceof UIDoubleDataValue sub) { return 15; }
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