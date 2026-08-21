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


public class StabSelector extends Selector {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 38;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 38;
    public static final int MAX_SIZE = 38;

    public float extendTop;
    public float extendBottom;
    public float extendLeft;
    public float extendRight;
    public float yawOffset;
    public float pitchOffset;
    public float rollOffset;
    public float startDistance;
    public float endDistance;
    public boolean testLineOfSight;
    public boolean ignorePitch;
    public boolean ignoreYaw;
    @Nonnull public SelectorAnchor anchor = SelectorAnchor.Eyes;

    public StabSelector() {
    }

    public StabSelector(float extendTop, float extendBottom, float extendLeft, float extendRight, float yawOffset, float pitchOffset, float rollOffset, float startDistance, float endDistance, boolean testLineOfSight, boolean ignorePitch, boolean ignoreYaw, @Nonnull SelectorAnchor anchor) {
        this.extendTop = extendTop;
        this.extendBottom = extendBottom;
        this.extendLeft = extendLeft;
        this.extendRight = extendRight;
        this.yawOffset = yawOffset;
        this.pitchOffset = pitchOffset;
        this.rollOffset = rollOffset;
        this.startDistance = startDistance;
        this.endDistance = endDistance;
        this.testLineOfSight = testLineOfSight;
        this.ignorePitch = ignorePitch;
        this.ignoreYaw = ignoreYaw;
        this.anchor = anchor;
    }

    public StabSelector(@Nonnull StabSelector other) {
        this.extendTop = other.extendTop;
        this.extendBottom = other.extendBottom;
        this.extendLeft = other.extendLeft;
        this.extendRight = other.extendRight;
        this.yawOffset = other.yawOffset;
        this.pitchOffset = other.pitchOffset;
        this.rollOffset = other.rollOffset;
        this.startDistance = other.startDistance;
        this.endDistance = other.endDistance;
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
        if (offset < 0) throw ProtocolException.invalidOffset("StabSelector", offset, (int) mem.byteSize());
        long needed = (long) offset + 38;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("StabSelector", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
    
    public static float getExtendLeft(MemorySegment mem) {
        return getExtendLeft(mem, 0);
    }
    
    public static float getExtendLeft(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "ExtendLeft");
    }
    
    public static float getExtendRight(MemorySegment mem) {
        return getExtendRight(mem, 0);
    }
    
    public static float getExtendRight(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "ExtendRight");
    }
    
    public static float getYawOffset(MemorySegment mem) {
        return getYawOffset(mem, 0);
    }
    
    public static float getYawOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "YawOffset");
    }
    
    public static float getPitchOffset(MemorySegment mem) {
        return getPitchOffset(mem, 0);
    }
    
    public static float getPitchOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "PitchOffset");
    }
    
    public static float getRollOffset(MemorySegment mem) {
        return getRollOffset(mem, 0);
    }
    
    public static float getRollOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "RollOffset");
    }
    
    public static float getStartDistance(MemorySegment mem) {
        return getStartDistance(mem, 0);
    }
    
    public static float getStartDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "StartDistance");
    }
    
    public static float getEndDistance(MemorySegment mem) {
        return getEndDistance(mem, 0);
    }
    
    public static float getEndDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 32), "EndDistance");
    }
    
    public static boolean getTestLineOfSight(MemorySegment mem) {
        return getTestLineOfSight(mem, 0);
    }
    
    public static boolean getTestLineOfSight(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 36) & 0x01) != 0;
    }
    
    public static boolean getIgnorePitch(MemorySegment mem) {
        return getIgnorePitch(mem, 0);
    }
    
    public static boolean getIgnorePitch(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 36) & 0x02) != 0;
    }
    
    public static boolean getIgnoreYaw(MemorySegment mem) {
        return getIgnoreYaw(mem, 0);
    }
    
    public static boolean getIgnoreYaw(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 36) & 0x04) != 0;
    }
    
    public static SelectorAnchor getAnchor(MemorySegment mem) {
        return getAnchor(mem, 0);
    }
    
    public static SelectorAnchor getAnchor(MemorySegment mem, int offset) {
        return SelectorAnchor.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 37));
    }
    
    
    
    
    
    public static StabSelector toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static StabSelector toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one StabSelector and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static StabSelector toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new StabSelector(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "ExtendTop"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "ExtendBottom"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "ExtendLeft"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "ExtendRight"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "YawOffset"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "PitchOffset"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 24), "RollOffset"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 28), "StartDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 32), "EndDistance"),
            (mem.get(PacketIO.PROTO_BYTE, offset + 36) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 36) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 36) & 0x04) != 0,
            SelectorAnchor.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 37))
        );
        if (cursor != null) cursor.position = offset + 38;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.extendTop, "ExtendTop"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.extendTop);
        PacketIO.requireFinite(this.extendBottom, "ExtendBottom"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.extendBottom);
        PacketIO.requireFinite(this.extendLeft, "ExtendLeft"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.extendLeft);
        PacketIO.requireFinite(this.extendRight, "ExtendRight"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.extendRight);
        PacketIO.requireFinite(this.yawOffset, "YawOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.yawOffset);
        PacketIO.requireFinite(this.pitchOffset, "PitchOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.pitchOffset);
        PacketIO.requireFinite(this.rollOffset, "RollOffset"); mem.set(PacketIO.PROTO_FLOAT, offset + 24, this.rollOffset);
        PacketIO.requireFinite(this.startDistance, "StartDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 28, this.startDistance);
        PacketIO.requireFinite(this.endDistance, "EndDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 32, this.endDistance);
        byte boolBits0_0 = 0;
        if (this.testLineOfSight) boolBits0_0 |= 0x01;
        if (this.ignorePitch) boolBits0_0 |= 0x02;
        if (this.ignoreYaw) boolBits0_0 |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 36 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 37, (byte) this.anchor.getValue());
        
        
    
       return 38;
    }
    @Override
    public int computeSize() {
        return 38;
    }

    public StabSelector clone() {
        StabSelector copy = new StabSelector();
        copy.extendTop = this.extendTop;
        copy.extendBottom = this.extendBottom;
        copy.extendLeft = this.extendLeft;
        copy.extendRight = this.extendRight;
        copy.yawOffset = this.yawOffset;
        copy.pitchOffset = this.pitchOffset;
        copy.rollOffset = this.rollOffset;
        copy.startDistance = this.startDistance;
        copy.endDistance = this.endDistance;
        copy.testLineOfSight = this.testLineOfSight;
        copy.ignorePitch = this.ignorePitch;
        copy.ignoreYaw = this.ignoreYaw;
        copy.anchor = this.anchor;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StabSelector other)) return false;
        return this.extendTop == other.extendTop && this.extendBottom == other.extendBottom && this.extendLeft == other.extendLeft && this.extendRight == other.extendRight && this.yawOffset == other.yawOffset && this.pitchOffset == other.pitchOffset && this.rollOffset == other.rollOffset && this.startDistance == other.startDistance && this.endDistance == other.endDistance && this.testLineOfSight == other.testLineOfSight && this.ignorePitch == other.ignorePitch && this.ignoreYaw == other.ignoreYaw && java.util.Objects.equals(this.anchor, other.anchor);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(extendTop, extendBottom, extendLeft, extendRight, yawOffset, pitchOffset, rollOffset, startDistance, endDistance, testLineOfSight, ignorePitch, ignoreYaw, anchor);
    }

}