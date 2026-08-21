// Auto-generated - do not edit
package meridian.protocol.packets.window;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public abstract class WindowAction {
    public static final int MAX_SIZE = 32768023;

    


    public static WindowAction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }

    public static WindowAction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }

    public static WindowAction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // The subtype starts after the type id as encoded, which VarInt.size cannot report.
        long typeIdPacked = VarInt.getWithLength(mem, offset);
        int typeId = (int) typeIdPacked;
        int typeIdLen = (int) (typeIdPacked >>> 32);

        return switch (typeId) {
            case 0 -> CraftRecipeAction.toObject(mem, offset + typeIdLen, cursor);
                case 1 -> TierUpgradeAction.toObject(mem, offset + typeIdLen, cursor);
                case 2 -> SelectSlotAction.toObject(mem, offset + typeIdLen, cursor);
                case 3 -> ChangeBlockAction.toObject(mem, offset + typeIdLen, cursor);
                case 4 -> SetActiveAction.toObject(mem, offset + typeIdLen, cursor);
                case 5 -> CraftItemAction.toObject(mem, offset + typeIdLen, cursor);
                case 6 -> UpdateCategoryAction.toObject(mem, offset + typeIdLen, cursor);
                case 7 -> CancelCraftingAction.toObject(mem, offset + typeIdLen, cursor);
                case 8 -> SortItemsAction.toObject(mem, offset + typeIdLen, cursor);
            default -> throw ProtocolException.unknownPolymorphicType("WindowAction", typeId);
        };
    }


    public int getTypeId() {
        if (this instanceof CraftRecipeAction sub) { return 0; }
            if (this instanceof TierUpgradeAction sub) { return 1; }
            if (this instanceof SelectSlotAction sub) { return 2; }
            if (this instanceof ChangeBlockAction sub) { return 3; }
            if (this instanceof SetActiveAction sub) { return 4; }
            if (this instanceof CraftItemAction sub) { return 5; }
            if (this instanceof UpdateCategoryAction sub) { return 6; }
            if (this instanceof CancelCraftingAction sub) { return 7; }
            if (this instanceof SortItemsAction sub) { return 8; }
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