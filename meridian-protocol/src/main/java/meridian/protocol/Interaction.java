// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import java.util.HashMap;

public abstract class Interaction {
    public static final int MAX_SIZE = 1677721605;

        @Nonnull public WaitForDataFrom waitForDataFrom = WaitForDataFrom.Client;
    @Nullable public InteractionEffects effects;
    public float horizontalSpeedMultiplier;
    public float runTime;
    @Nonnull public InteractionItemChangeBehavior onItemChangeBehavior = InteractionItemChangeBehavior.Cancel;
    @Nullable public java.util.Map<GameMode, InteractionSettings> settings;
    @Nonnull public InteractionRules rules = new InteractionRules();
    @Nullable public int[] tags;
    @Nullable public InteractionCameraSettings camera;



    public static Interaction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }

    public static Interaction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }

    public static Interaction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // The subtype starts after the type id as encoded, which VarInt.size cannot report.
        long typeIdPacked = VarInt.getWithLength(mem, offset);
        int typeId = (int) typeIdPacked;
        int typeIdLen = (int) (typeIdPacked >>> 32);

        return switch (typeId) {
            case 0 -> SimpleBlockInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 1 -> SimpleInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 2 -> PlaceBlockInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 3 -> BreakBlockInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 4 -> PickBlockInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 5 -> UseBlockInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 6 -> UseEntityInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 7 -> BuilderToolInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 8 -> ModifyInventoryInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 9 -> ChargingInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 10 -> WieldingInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 11 -> ChainingInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 12 -> ConditionInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 13 -> StatsConditionInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 14 -> BlockConditionInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 15 -> ReplaceInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 16 -> ChangeBlockInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 17 -> ChangeStateInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 18 -> FirstClickInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 20 -> SelectInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 21 -> DamageEntityInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 22 -> RepeatInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 23 -> ParallelInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 24 -> ChangeActiveSlotInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 25 -> EffectConditionInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 26 -> ApplyForceInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 27 -> ApplyEffectInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 28 -> ClearEntityEffectInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 29 -> SerialInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 30 -> ChangeStatInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 31 -> MovementConditionInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 32 -> ProjectileInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 33 -> RemoveEntityInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 34 -> ResetCooldownInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 35 -> TriggerCooldownInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 36 -> CooldownConditionInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 37 -> ChainFlagInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 38 -> IncrementCooldownInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 39 -> CancelChainInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 40 -> RunRootInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 41 -> CameraInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 42 -> SpawnDeployableFromRaycastInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 43 -> MemoriesConditionInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 44 -> ToggleGliderInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 45 -> DurabilityConditionInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 46 -> DragPlaceBlockInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 47 -> ExtrudePlaceBlockInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 48 -> SurfaceDrawPlaceBlockInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 49 -> PlaceModeSelectInteraction.toObject(mem, offset + typeIdLen, cursor);
                case 50 -> DragEraseBlockInteraction.toObject(mem, offset + typeIdLen, cursor);
            default -> throw ProtocolException.unknownPolymorphicType("Interaction", typeId);
        };
    }


    public int getTypeId() {
        if (this instanceof BreakBlockInteraction sub) { return 3; }
            if (this instanceof PickBlockInteraction sub) { return 4; }
            if (this instanceof UseBlockInteraction sub) { return 5; }
            if (this instanceof BlockConditionInteraction sub) { return 14; }
            if (this instanceof ChangeBlockInteraction sub) { return 16; }
            if (this instanceof ChangeStateInteraction sub) { return 17; }
            if (this instanceof ExtrudePlaceBlockInteraction sub) { return 47; }
            if (this instanceof SurfaceDrawPlaceBlockInteraction sub) { return 48; }
            if (this instanceof DragEraseBlockInteraction sub) { return 50; }
            if (this instanceof SimpleBlockInteraction sub) { return 0; }
            if (this instanceof PlaceBlockInteraction sub) { return 2; }
            if (this instanceof UseEntityInteraction sub) { return 6; }
            if (this instanceof BuilderToolInteraction sub) { return 7; }
            if (this instanceof ModifyInventoryInteraction sub) { return 8; }
            if (this instanceof WieldingInteraction sub) { return 10; }
            if (this instanceof ConditionInteraction sub) { return 12; }
            if (this instanceof StatsConditionInteraction sub) { return 13; }
            if (this instanceof SelectInteraction sub) { return 20; }
            if (this instanceof RepeatInteraction sub) { return 22; }
            if (this instanceof EffectConditionInteraction sub) { return 25; }
            if (this instanceof ApplyForceInteraction sub) { return 26; }
            if (this instanceof ApplyEffectInteraction sub) { return 27; }
            if (this instanceof ClearEntityEffectInteraction sub) { return 28; }
            if (this instanceof ChangeStatInteraction sub) { return 30; }
            if (this instanceof MovementConditionInteraction sub) { return 31; }
            if (this instanceof ProjectileInteraction sub) { return 32; }
            if (this instanceof RemoveEntityInteraction sub) { return 33; }
            if (this instanceof ResetCooldownInteraction sub) { return 34; }
            if (this instanceof TriggerCooldownInteraction sub) { return 35; }
            if (this instanceof CooldownConditionInteraction sub) { return 36; }
            if (this instanceof ChainFlagInteraction sub) { return 37; }
            if (this instanceof IncrementCooldownInteraction sub) { return 38; }
            if (this instanceof CancelChainInteraction sub) { return 39; }
            if (this instanceof RunRootInteraction sub) { return 40; }
            if (this instanceof CameraInteraction sub) { return 41; }
            if (this instanceof SpawnDeployableFromRaycastInteraction sub) { return 42; }
            if (this instanceof ToggleGliderInteraction sub) { return 44; }
            if (this instanceof DurabilityConditionInteraction sub) { return 45; }
            if (this instanceof DragPlaceBlockInteraction sub) { return 46; }
            if (this instanceof PlaceModeSelectInteraction sub) { return 49; }
            if (this instanceof SimpleInteraction sub) { return 1; }
            if (this instanceof ChargingInteraction sub) { return 9; }
            if (this instanceof ChainingInteraction sub) { return 11; }
            if (this instanceof ReplaceInteraction sub) { return 15; }
            if (this instanceof FirstClickInteraction sub) { return 18; }
            if (this instanceof DamageEntityInteraction sub) { return 21; }
            if (this instanceof ParallelInteraction sub) { return 23; }
            if (this instanceof ChangeActiveSlotInteraction sub) { return 24; }
            if (this instanceof SerialInteraction sub) { return 29; }
            if (this instanceof MemoriesConditionInteraction sub) { return 43; }
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