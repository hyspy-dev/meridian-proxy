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


public class HorizontalSelector extends Selector {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 35;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 35;
    public static final int MAX_SIZE = 35;

    public float extendTop;
    public float extendBottom;
    public float yawLength;
    public float yawStartOffset;
    public float pitchOffset;
    public float rollOffset;
    public float startDistance;
    public float endDistance;
    @Nonnull public HorizontalSelectorDirection direction = HorizontalSelectorDirection.ToLeft;
    public boolean testLineOfSight;
    public boolean ignorePitch;
    public boolean ignoreYaw;
    @Nonnull public SelectorAnchor anchor = SelectorAnchor.Eyes;

    public HorizontalSelector() {
    }

    public HorizontalSelector(float extendTop, float extendBottom, float yawLength, float yawStartOffset, float pitchOffset, float rollOffset, float startDistance, float endDistance, @Nonnull HorizontalSelectorDirection direction, boolean testLineOfSight, boolean ignorePitch, boolean ignoreYaw, @Nonnull SelectorAnchor anchor) {
        this.extendTop = extendTop;
        this.extendBottom = extendBottom;
        this.yawLength = yawLength;
        this.yawStartOffset = yawStartOffset;
        this.pitchOffset = pitchOffset;
        this.rollOffset = rollOffset;
        this.startDistance = startDistance;
        this.endDistance = endDistance;
        this.direction = direction;
        this.testLineOfSight = testLineOfSight;
        this.ignorePitch = ignorePitch;
        this.ignoreYaw = ignoreYaw;
        this.anchor = anchor;
    }

    public HorizontalSelector(@Nonnull HorizontalSelector other) {
        this.extendTop = other.extendTop;
        this.extendBottom = other.extendBottom;
        this.yawLength = other.yawLength;
        this.yawStartOffset = other.yawStartOffset;
        this.pitchOffset = other.pitchOffset;
        this.rollOffset = other.rollOffset;
        this.startDistance = other.startDistance;
        this.endDistance = other.endDistance;
        this.direction = other.direction;
        this.testLineOfSight = other.testLineOfSight;
        this.ignorePitch = other.ignorePitch;
        this.ignoreYaw = other.ignoreYaw;
        this.anchor = other.anchor;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("HorizontalSelector", offset, (int) mem.byteSize());
        long needed = (long) offset + 35;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("HorizontalSelector", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getExtendTop(MemorySegment mem) {
        return getExtendTop(mem, 0);
    }
    
    public static float getExtendTop(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "ExtendTop");
    }
    
    public static float getExtendBottom(MemorySegment mem) {
        return getExtendBottom(mem, 0);
    }
    
    public static float getExtendBottom(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "ExtendBottom");
    }
    
    public static float getYawLength(MemorySegment mem) {
        return getYawLength(mem, 0);
    }
    
    public static float getYawLength(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "YawLength");
    }
    
    public static float getYawStartOffset(MemorySegment mem) {
        return getYawStartOffset(mem, 0);
    }
    
    public static float getYawStartOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "YawStartOffset");
    }
    
    public static float getPitchOffset(MemorySegment mem) {
        return getPitchOffset(mem, 0);
    }
    
    public static float getPitchOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "PitchOffset");
    }
    
    public static float getRollOffset(MemorySegment mem) {
        return getRollOffset(mem, 0);
    }
    
    public static float getRollOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "RollOffset");
    }
    
    public static float getStartDistance(MemorySegment mem) {
        return getStartDistance(mem, 0);
    }
    
    public static float getStartDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "StartDistance");
    }
    
    public static float getEndDistance(MemorySegment mem) {
        return getEndDistance(mem, 0);
    }
    
    public static float getEndDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "EndDistance");
    }
    
    public static HorizontalSelectorDirection getDirection(MemorySegment mem) {
        return getDirection(mem, 0);
    }
    
    public static HorizontalSelectorDirection getDirection(MemorySegment mem, int offset) {
        return HorizontalSelectorDirection.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 32));
    }
    
    public static boolean getTestLineOfSight(MemorySegment mem) {
        return getTestLineOfSight(mem, 0);
    }
    
    public static boolean getTestLineOfSight(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 33) & 0x01) != 0;
    }
    
    public static boolean getIgnorePitch(MemorySegment mem) {
        return getIgnorePitch(mem, 0);
    }
    
    public static boolean getIgnorePitch(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 33) & 0x02) != 0;
    }
    
    public static boolean getIgnoreYaw(MemorySegment mem) {
        return getIgnoreYaw(mem, 0);
    }
    
    public static boolean getIgnoreYaw(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 33) & 0x04) != 0;
    }
    
    public static SelectorAnchor getAnchor(MemorySegment mem) {
        return getAnchor(mem, 0);
    }
    
    public static SelectorAnchor getAnchor(MemorySegment mem, int offset) {
        return SelectorAnchor.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 34));
    }
    
    
    
    
    
    public static HorizontalSelector toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static HorizontalSelector toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one HorizontalSelector and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static HorizontalSelector toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new HorizontalSelector(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "ExtendTop"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "ExtendBottom"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "YawLength"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "YawStartOffset"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "PitchOffset"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "RollOffset"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "StartDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "EndDistance"),
            HorizontalSelectorDirection.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 32)),
            (mem.get(PacketIO.PROTO_BYTE, offset + 33) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 33) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 33) & 0x04) != 0,
            SelectorAnchor.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 34))
        );
        if (cursor != null) cursor.position = offset + 35;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.extendTop, "ExtendTop"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.extendTop);
        PacketIO.requireFinite(this.extendBottom, "ExtendBottom"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.extendBottom);
        PacketIO.requireFinite(this.yawLength, "YawLength"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.yawLength);
        PacketIO.requireFinite(this.yawStartOffset, "YawStartOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.yawStartOffset);
        PacketIO.requireFinite(this.pitchOffset, "PitchOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.pitchOffset);
        PacketIO.requireFinite(this.rollOffset, "RollOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.rollOffset);
        PacketIO.requireFinite(this.startDistance, "StartDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 24, this.startDistance);
        PacketIO.requireFinite(this.endDistance, "EndDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 28, this.endDistance);
        mem.set(PacketIO.PROTO_BYTE, offset + 32, (byte) this.direction.getValue());
        byte boolBits0_0 = 0;
        if (this.testLineOfSight) boolBits0_0 |= 0x01;
        if (this.ignorePitch) boolBits0_0 |= 0x02;
        if (this.ignoreYaw) boolBits0_0 |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 33 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 34, (byte) this.anchor.getValue());
        
        
    
       return 35;
    }
    @Override
    public int computeSize() {
        return 35;
    }

    public HorizontalSelector clone() {
        HorizontalSelector copy = new HorizontalSelector();
        copy.extendTop = this.extendTop;
        copy.extendBottom = this.extendBottom;
        copy.yawLength = this.yawLength;
        copy.yawStartOffset = this.yawStartOffset;
        copy.pitchOffset = this.pitchOffset;
        copy.rollOffset = this.rollOffset;
        copy.startDistance = this.startDistance;
        copy.endDistance = this.endDistance;
        copy.direction = this.direction;
        copy.testLineOfSight = this.testLineOfSight;
        copy.ignorePitch = this.ignorePitch;
        copy.ignoreYaw = this.ignoreYaw;
        copy.anchor = this.anchor;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HorizontalSelector other)) return false;
        return this.extendTop == other.extendTop && this.extendBottom == other.extendBottom && this.yawLength == other.yawLength && this.yawStartOffset == other.yawStartOffset && this.pitchOffset == other.pitchOffset && this.rollOffset == other.rollOffset && this.startDistance == other.startDistance && this.endDistance == other.endDistance && java.util.Objects.equals(this.direction, other.direction) && this.testLineOfSight == other.testLineOfSight && this.ignorePitch == other.ignorePitch && this.ignoreYaw == other.ignoreYaw && java.util.Objects.equals(this.anchor, other.anchor);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(extendTop, extendBottom, yawLength, yawStartOffset, pitchOffset, rollOffset, startDistance, endDistance, direction, testLineOfSight, ignorePitch, ignoreYaw, anchor);
    }

}