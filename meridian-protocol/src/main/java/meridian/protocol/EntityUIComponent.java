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
import org.joml.*;

public class EntityUIComponent {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 50;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 50;
    public static final int MAX_SIZE = 135168055;

    @Nonnull public EntityUIType type = EntityUIType.EntityStat;
    @Nonnull public Vector2fc hitboxOffset = PacketIO.ZERO_VECTOR2;
    public boolean unknown;
    public int entityStatIndex;
    @Nonnull public RangeVector2f combatTextRandomPositionOffsetRange = new RangeVector2f();
    public float combatTextViewportMargin;
    public float combatTextDuration;
    public float combatTextHitAngleModifierStrength;
    public float combatTextFontSize;
    @Nonnull public Color combatTextColor = new Color();
    @Nonnull public CombatTextEntityUIComponentAnimationEvent[] combatTextAnimationEvents = new CombatTextEntityUIComponentAnimationEvent[0];

    public EntityUIComponent() {
    }

    public EntityUIComponent(@Nonnull EntityUIType type, @Nonnull Vector2fc hitboxOffset, boolean unknown, int entityStatIndex, @Nonnull RangeVector2f combatTextRandomPositionOffsetRange, float combatTextViewportMargin, float combatTextDuration, float combatTextHitAngleModifierStrength, float combatTextFontSize, @Nonnull Color combatTextColor, @Nonnull CombatTextEntityUIComponentAnimationEvent[] combatTextAnimationEvents) {
        this.type = type;
        this.hitboxOffset = hitboxOffset;
        this.unknown = unknown;
        this.entityStatIndex = entityStatIndex;
        this.combatTextRandomPositionOffsetRange = combatTextRandomPositionOffsetRange;
        this.combatTextViewportMargin = combatTextViewportMargin;
        this.combatTextDuration = combatTextDuration;
        this.combatTextHitAngleModifierStrength = combatTextHitAngleModifierStrength;
        this.combatTextFontSize = combatTextFontSize;
        this.combatTextColor = combatTextColor;
        this.combatTextAnimationEvents = combatTextAnimationEvents;
    }

    public EntityUIComponent(@Nonnull EntityUIComponent other) {
        this.type = other.type;
        this.hitboxOffset = other.hitboxOffset;
        this.unknown = other.unknown;
        this.entityStatIndex = other.entityStatIndex;
        this.combatTextRandomPositionOffsetRange = other.combatTextRandomPositionOffsetRange;
        this.combatTextViewportMargin = other.combatTextViewportMargin;
        this.combatTextDuration = other.combatTextDuration;
        this.combatTextHitAngleModifierStrength = other.combatTextHitAngleModifierStrength;
        this.combatTextFontSize = other.combatTextFontSize;
        this.combatTextColor = other.combatTextColor;
        this.combatTextAnimationEvents = other.combatTextAnimationEvents;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("EntityUIComponent", offset, (int) mem.byteSize());
        long needed = (long) offset + 50;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("EntityUIComponent", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static EntityUIType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static EntityUIType getType(MemorySegment mem, int offset) {
        return EntityUIType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static Vector2fc getHitboxOffset(MemorySegment mem) {
        return getHitboxOffset(mem, 0);
    }
    
    public static Vector2fc getHitboxOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 1), "HitboxOffset");
    }
    
    public static boolean getUnknown(MemorySegment mem) {
        return getUnknown(mem, 0);
    }
    
    public static boolean getUnknown(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 9);
    }
    
    public static int getEntityStatIndex(MemorySegment mem) {
        return getEntityStatIndex(mem, 0);
    }
    
    public static int getEntityStatIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 10);
    }
    
    public static RangeVector2f getCombatTextRandomPositionOffsetRange(MemorySegment mem) {
        return getCombatTextRandomPositionOffsetRange(mem, 0);
    }
    
    public static RangeVector2f getCombatTextRandomPositionOffsetRange(MemorySegment mem, int offset) {
        return RangeVector2f.toObject(mem, offset + 14);
    }
    
    public static float getCombatTextViewportMargin(MemorySegment mem) {
        return getCombatTextViewportMargin(mem, 0);
    }
    
    public static float getCombatTextViewportMargin(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 31), "CombatTextViewportMargin");
    }
    
    public static float getCombatTextDuration(MemorySegment mem) {
        return getCombatTextDuration(mem, 0);
    }
    
    public static float getCombatTextDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 35), "CombatTextDuration");
    }
    
    public static float getCombatTextHitAngleModifierStrength(MemorySegment mem) {
        return getCombatTextHitAngleModifierStrength(mem, 0);
    }
    
    public static float getCombatTextHitAngleModifierStrength(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 39), "CombatTextHitAngleModifierStrength");
    }
    
    public static float getCombatTextFontSize(MemorySegment mem) {
        return getCombatTextFontSize(mem, 0);
    }
    
    public static float getCombatTextFontSize(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 43), "CombatTextFontSize");
    }
    
    public static Color getCombatTextColor(MemorySegment mem) {
        return getCombatTextColor(mem, 0);
    }
    
    public static Color getCombatTextColor(MemorySegment mem, int offset) {
        return Color.toObject(mem, offset + 47);
    }
    
    public static CombatTextEntityUIComponentAnimationEvent[] getCombatTextAnimationEvents(MemorySegment mem) {
        return getCombatTextAnimationEvents(mem, 0);
    }
    
    public static CombatTextEntityUIComponentAnimationEvent[] getCombatTextAnimationEvents(MemorySegment mem, int offset) {
        var off = offset + 50;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("CombatTextAnimationEvents");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("CombatTextAnimationEvents", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 33 > mem.byteSize()) throw ProtocolException.bufferTooSmall("CombatTextAnimationEvents", (int) java.lang.Math.min(off + lenOffset + (long) len * 33, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new CombatTextEntityUIComponentAnimationEvent[len];
        for (var i = 0; i < len; i++) {
            data[i] = CombatTextEntityUIComponentAnimationEvent.toObject(mem, off + i * 33);
        }
        return data;
    }
    
    
    
    
    
    public static EntityUIComponent toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static EntityUIComponent toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one EntityUIComponent and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static EntityUIComponent toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 50;
        var varPos = 0;
        CombatTextEntityUIComponentAnimationEvent[] v10;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("CombatTextAnimationEvents");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("CombatTextAnimationEvents", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 33 > mem.byteSize()) throw ProtocolException.bufferTooSmall("CombatTextAnimationEvents", (int) java.lang.Math.min(off + lenOffset + (long) len * 33, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v10 = new CombatTextEntityUIComponentAnimationEvent[len];
            for (var i = 0; i < len; i++) {
                v10[i] = CombatTextEntityUIComponentAnimationEvent.toObject(mem, off + i * 33);
            }
            varPos = off + len * 33 - varBase;
        }
        var result = new EntityUIComponent(
            EntityUIType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 1), "HitboxOffset"),
            mem.get(PacketIO.PROTO_BOOL, offset + 9),
            mem.get(PacketIO.PROTO_INT, offset + 10),
            RangeVector2f.toObject(mem, offset + 14),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 31), "CombatTextViewportMargin"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 35), "CombatTextDuration"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 39), "CombatTextHitAngleModifierStrength"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 43), "CombatTextFontSize"),
            Color.toObject(mem, offset + 47),
            v10
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.type.getValue());
        PacketIO.requireFinite(this.hitboxOffset, "HitboxOffset"); PacketIO.writeVector2f(mem, offset + 1, this.hitboxOffset);
        mem.set(PacketIO.PROTO_BOOL, offset + 9, this.unknown);
        mem.set(PacketIO.PROTO_INT, offset + 10, this.entityStatIndex);
        this.combatTextRandomPositionOffsetRange.serialize(mem, offset + 14);
        PacketIO.requireFinite(this.combatTextViewportMargin, "CombatTextViewportMargin"); mem.set(PacketIO.PROTO_FLOAT, offset + 31, this.combatTextViewportMargin);
        PacketIO.requireFinite(this.combatTextDuration, "CombatTextDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 35, this.combatTextDuration);
        PacketIO.requireFinite(this.combatTextHitAngleModifierStrength, "CombatTextHitAngleModifierStrength"); mem.set(PacketIO.PROTO_FLOAT, offset + 39, this.combatTextHitAngleModifierStrength);
        PacketIO.requireFinite(this.combatTextFontSize, "CombatTextFontSize"); mem.set(PacketIO.PROTO_FLOAT, offset + 43, this.combatTextFontSize);
        this.combatTextColor.serialize(mem, offset + 47);
        var varOffset = offset + 50;
        if (combatTextAnimationEvents.length > 4096000) throw ProtocolException.arrayTooLong("CombatTextAnimationEvents", combatTextAnimationEvents.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.combatTextAnimationEvents.length);
        
        var combatTextAnimationEventsValueOffset = 0;
        for (var i = 0; i < this.combatTextAnimationEvents.length; i++) {
            combatTextAnimationEventsValueOffset += this.combatTextAnimationEvents[i].serialize(mem, varOffset + combatTextAnimationEventsValueOffset);
        }
        varOffset += combatTextAnimationEventsValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 50;
        size += VarInt.size(combatTextAnimationEvents.length) + combatTextAnimationEvents.length * 33;

        return size;
    }

    public EntityUIComponent clone() {
        EntityUIComponent copy = new EntityUIComponent();
        copy.type = this.type;
        copy.hitboxOffset = this.hitboxOffset;
        copy.unknown = this.unknown;
        copy.entityStatIndex = this.entityStatIndex;
        copy.combatTextRandomPositionOffsetRange = this.combatTextRandomPositionOffsetRange.clone();
        copy.combatTextViewportMargin = this.combatTextViewportMargin;
        copy.combatTextDuration = this.combatTextDuration;
        copy.combatTextHitAngleModifierStrength = this.combatTextHitAngleModifierStrength;
        copy.combatTextFontSize = this.combatTextFontSize;
        copy.combatTextColor = this.combatTextColor.clone();
        copy.combatTextAnimationEvents = java.util.Arrays.stream(this.combatTextAnimationEvents).map(e -> e.clone()).toArray(CombatTextEntityUIComponentAnimationEvent[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityUIComponent other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.hitboxOffset, other.hitboxOffset) && this.unknown == other.unknown && this.entityStatIndex == other.entityStatIndex && java.util.Objects.equals(this.combatTextRandomPositionOffsetRange, other.combatTextRandomPositionOffsetRange) && this.combatTextViewportMargin == other.combatTextViewportMargin && this.combatTextDuration == other.combatTextDuration && this.combatTextHitAngleModifierStrength == other.combatTextHitAngleModifierStrength && this.combatTextFontSize == other.combatTextFontSize && java.util.Objects.equals(this.combatTextColor, other.combatTextColor) && java.util.Arrays.equals(this.combatTextAnimationEvents, other.combatTextAnimationEvents);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(type);
        result = 31 * result + java.util.Objects.hashCode(hitboxOffset);
        result = 31 * result + Boolean.hashCode(unknown);
        result = 31 * result + Integer.hashCode(entityStatIndex);
        result = 31 * result + java.util.Objects.hashCode(combatTextRandomPositionOffsetRange);
        result = 31 * result + Float.hashCode(combatTextViewportMargin);
        result = 31 * result + Float.hashCode(combatTextDuration);
        result = 31 * result + Float.hashCode(combatTextHitAngleModifierStrength);
        result = 31 * result + Float.hashCode(combatTextFontSize);
        result = 31 * result + java.util.Objects.hashCode(combatTextColor);
        result = 31 * result + java.util.Arrays.hashCode(combatTextAnimationEvents);
        return result;
    }

}