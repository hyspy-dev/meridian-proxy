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

public class CombatTextEntityUIComponentAnimationEvent {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 33;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 33;
    public static final int MAX_SIZE = 33;

    @Nonnull public CombatTextEntityUIAnimationEventType type = CombatTextEntityUIAnimationEventType.Scale;
    public float startAt;
    public float endAt;
    public float startScale;
    public float endScale;
    @Nonnull public Vector2fc positionOffset = PacketIO.ZERO_VECTOR2;
    public float startOpacity;
    public float endOpacity;

    public CombatTextEntityUIComponentAnimationEvent() {
    }

    public CombatTextEntityUIComponentAnimationEvent(@Nonnull CombatTextEntityUIAnimationEventType type, float startAt, float endAt, float startScale, float endScale, @Nonnull Vector2fc positionOffset, float startOpacity, float endOpacity) {
        this.type = type;
        this.startAt = startAt;
        this.endAt = endAt;
        this.startScale = startScale;
        this.endScale = endScale;
        this.positionOffset = positionOffset;
        this.startOpacity = startOpacity;
        this.endOpacity = endOpacity;
    }

    public CombatTextEntityUIComponentAnimationEvent(@Nonnull CombatTextEntityUIComponentAnimationEvent other) {
        this.type = other.type;
        this.startAt = other.startAt;
        this.endAt = other.endAt;
        this.startScale = other.startScale;
        this.endScale = other.endScale;
        this.positionOffset = other.positionOffset;
        this.startOpacity = other.startOpacity;
        this.endOpacity = other.endOpacity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CombatTextEntityUIComponentAnimationEvent", offset, (int) mem.byteSize());
        long needed = (long) offset + 33;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CombatTextEntityUIComponentAnimationEvent", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static CombatTextEntityUIAnimationEventType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static CombatTextEntityUIAnimationEventType getType(MemorySegment mem, int offset) {
        return CombatTextEntityUIAnimationEventType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    public static float getStartAt(MemorySegment mem) {
        return getStartAt(mem, 0);
    }
    
    public static float getStartAt(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "StartAt");
    }
    
    public static float getEndAt(MemorySegment mem) {
        return getEndAt(mem, 0);
    }
    
    public static float getEndAt(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "EndAt");
    }
    
    public static float getStartScale(MemorySegment mem) {
        return getStartScale(mem, 0);
    }
    
    public static float getStartScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "StartScale");
    }
    
    public static float getEndScale(MemorySegment mem) {
        return getEndScale(mem, 0);
    }
    
    public static float getEndScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "EndScale");
    }
    
    public static Vector2fc getPositionOffset(MemorySegment mem) {
        return getPositionOffset(mem, 0);
    }
    
    public static Vector2fc getPositionOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 17), "PositionOffset");
    }
    
    public static float getStartOpacity(MemorySegment mem) {
        return getStartOpacity(mem, 0);
    }
    
    public static float getStartOpacity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "StartOpacity");
    }
    
    public static float getEndOpacity(MemorySegment mem) {
        return getEndOpacity(mem, 0);
    }
    
    public static float getEndOpacity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "EndOpacity");
    }
    
    
    
    
    
    public static CombatTextEntityUIComponentAnimationEvent toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CombatTextEntityUIComponentAnimationEvent toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CombatTextEntityUIComponentAnimationEvent and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CombatTextEntityUIComponentAnimationEvent toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new CombatTextEntityUIComponentAnimationEvent(
            CombatTextEntityUIAnimationEventType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "StartAt"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "EndAt"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "StartScale"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 13), "EndScale"),
            PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 17), "PositionOffset"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 25), "StartOpacity"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 29), "EndOpacity")
        );
        if (cursor != null) cursor.position = offset + 33;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.type.getValue());
        PacketIO.requireFinite(this.startAt, "StartAt"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.startAt);
        PacketIO.requireFinite(this.endAt, "EndAt"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.endAt);
        PacketIO.requireFinite(this.startScale, "StartScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.startScale);
        PacketIO.requireFinite(this.endScale, "EndScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 13, this.endScale);
        PacketIO.requireFinite(this.positionOffset, "PositionOffset"); PacketIO.writeVector2f(mem, offset + 17, this.positionOffset);
        PacketIO.requireFinite(this.startOpacity, "StartOpacity"); mem.set(PacketIO.PROTO_FLOAT, offset + 25, this.startOpacity);
        PacketIO.requireFinite(this.endOpacity, "EndOpacity"); mem.set(PacketIO.PROTO_FLOAT, offset + 29, this.endOpacity);
        
        
    
       return 33;
    }
    public int computeSize() {
        return 33;
    }

    public CombatTextEntityUIComponentAnimationEvent clone() {
        CombatTextEntityUIComponentAnimationEvent copy = new CombatTextEntityUIComponentAnimationEvent();
        copy.type = this.type;
        copy.startAt = this.startAt;
        copy.endAt = this.endAt;
        copy.startScale = this.startScale;
        copy.endScale = this.endScale;
        copy.positionOffset = this.positionOffset;
        copy.startOpacity = this.startOpacity;
        copy.endOpacity = this.endOpacity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CombatTextEntityUIComponentAnimationEvent other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.startAt == other.startAt && this.endAt == other.endAt && this.startScale == other.startScale && this.endScale == other.endScale && java.util.Objects.equals(this.positionOffset, other.positionOffset) && this.startOpacity == other.startOpacity && this.endOpacity == other.endOpacity;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, startAt, endAt, startScale, endScale, positionOffset, startOpacity, endOpacity);
    }

}