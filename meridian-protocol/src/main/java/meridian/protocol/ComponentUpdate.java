// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public abstract class ComponentUpdate {
    public static final int MAX_SIZE = 1677721605;

    


    public static ComponentUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }

    public static ComponentUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }

    public static ComponentUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // The subtype starts after the type id as encoded, which VarInt.size cannot report.
        long typeIdPacked = VarInt.getWithLength(mem, offset);
        int typeId = (int) typeIdPacked;
        int typeIdLen = (int) (typeIdPacked >>> 32);

        return switch (typeId) {
            case 0 -> NameplateUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 1 -> UIComponentsUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 2 -> CombatTextUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 3 -> ModelUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 4 -> PlayerSkinUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 5 -> ItemUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 6 -> BlockUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 7 -> EquipmentUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 8 -> EntityStatsUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 9 -> TransformUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 10 -> MovementStatesUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 11 -> EntityEffectsUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 12 -> InteractionsUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 13 -> DynamicLightUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 14 -> InteractableUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 15 -> IntangibleUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 16 -> InvulnerableUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 17 -> RespondToHitUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 18 -> HitboxCollisionUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 19 -> RepulsionUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 20 -> PredictionUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 21 -> AudioUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 22 -> MountedUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 23 -> NewSpawnUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 24 -> ActiveAnimationsUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 25 -> PropUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 26 -> CarriedBlockUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 27 -> PreventInventoryAccessUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 28 -> PrefabPreviewUpdate.toObject(mem, offset + typeIdLen, cursor);
                case 29 -> PreventEmotesUpdate.toObject(mem, offset + typeIdLen, cursor);
            default -> throw ProtocolException.unknownPolymorphicType("ComponentUpdate", typeId);
        };
    }


    public int getTypeId() {
        if (this instanceof NameplateUpdate sub) { return 0; }
            if (this instanceof UIComponentsUpdate sub) { return 1; }
            if (this instanceof CombatTextUpdate sub) { return 2; }
            if (this instanceof ModelUpdate sub) { return 3; }
            if (this instanceof PlayerSkinUpdate sub) { return 4; }
            if (this instanceof ItemUpdate sub) { return 5; }
            if (this instanceof BlockUpdate sub) { return 6; }
            if (this instanceof EquipmentUpdate sub) { return 7; }
            if (this instanceof EntityStatsUpdate sub) { return 8; }
            if (this instanceof TransformUpdate sub) { return 9; }
            if (this instanceof MovementStatesUpdate sub) { return 10; }
            if (this instanceof EntityEffectsUpdate sub) { return 11; }
            if (this instanceof InteractionsUpdate sub) { return 12; }
            if (this instanceof DynamicLightUpdate sub) { return 13; }
            if (this instanceof InteractableUpdate sub) { return 14; }
            if (this instanceof IntangibleUpdate sub) { return 15; }
            if (this instanceof InvulnerableUpdate sub) { return 16; }
            if (this instanceof RespondToHitUpdate sub) { return 17; }
            if (this instanceof HitboxCollisionUpdate sub) { return 18; }
            if (this instanceof RepulsionUpdate sub) { return 19; }
            if (this instanceof PredictionUpdate sub) { return 20; }
            if (this instanceof AudioUpdate sub) { return 21; }
            if (this instanceof MountedUpdate sub) { return 22; }
            if (this instanceof NewSpawnUpdate sub) { return 23; }
            if (this instanceof ActiveAnimationsUpdate sub) { return 24; }
            if (this instanceof PropUpdate sub) { return 25; }
            if (this instanceof CarriedBlockUpdate sub) { return 26; }
            if (this instanceof PreventInventoryAccessUpdate sub) { return 27; }
            if (this instanceof PrefabPreviewUpdate sub) { return 28; }
            if (this instanceof PreventEmotesUpdate sub) { return 29; }
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