// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.BlockPosition;
import org.joml.*;

public class BuilderToolSelectionTransform implements Packet, ToServerPacket {
    public static final int PACKET_ID = 405;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 78;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 78;
    public static final int MAX_SIZE = 78;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public Quaternionfc rotation;
    @Nullable public BlockPosition translationOffset;
    @Nullable public BlockPosition initialSelectionMin;
    @Nullable public BlockPosition initialSelectionMax;
    @Nonnull public Vector3fc initialRotationOrigin = PacketIO.ZERO_VECTOR3;
    public boolean cutOriginal;
    public boolean applyTransformationToSelectionMinMax;
    public boolean isExitingTransformMode;
    @Nullable public BlockPosition initialPastePointForClipboardPaste;

    public BuilderToolSelectionTransform() {
    }

    public BuilderToolSelectionTransform(@Nullable Quaternionfc rotation, @Nullable BlockPosition translationOffset, @Nullable BlockPosition initialSelectionMin, @Nullable BlockPosition initialSelectionMax, @Nonnull Vector3fc initialRotationOrigin, boolean cutOriginal, boolean applyTransformationToSelectionMinMax, boolean isExitingTransformMode, @Nullable BlockPosition initialPastePointForClipboardPaste) {
        this.rotation = rotation;
        this.translationOffset = translationOffset;
        this.initialSelectionMin = initialSelectionMin;
        this.initialSelectionMax = initialSelectionMax;
        this.initialRotationOrigin = initialRotationOrigin;
        this.cutOriginal = cutOriginal;
        this.applyTransformationToSelectionMinMax = applyTransformationToSelectionMinMax;
        this.isExitingTransformMode = isExitingTransformMode;
        this.initialPastePointForClipboardPaste = initialPastePointForClipboardPaste;
    }

    public BuilderToolSelectionTransform(@Nonnull BuilderToolSelectionTransform other) {
        this.rotation = other.rotation;
        this.translationOffset = other.translationOffset;
        this.initialSelectionMin = other.initialSelectionMin;
        this.initialSelectionMax = other.initialSelectionMax;
        this.initialRotationOrigin = other.initialRotationOrigin;
        this.cutOriginal = other.cutOriginal;
        this.applyTransformationToSelectionMinMax = other.applyTransformationToSelectionMinMax;
        this.isExitingTransformMode = other.isExitingTransformMode;
        this.initialPastePointForClipboardPaste = other.initialPastePointForClipboardPaste;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolSelectionTransform", offset, (int) mem.byteSize());
        long needed = (long) offset + 78;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolSelectionTransform", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Quaternionfc getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    @Nullable
    public static Quaternionfc getRotation(MemorySegment mem, int offset) {
        return hasRotation(mem, offset) ? PacketIO.requireFinite(PacketIO.readQuaternionf(mem, offset + 1), "Rotation"): null;
    }
    
    @Nullable
    public static BlockPosition getTranslationOffset(MemorySegment mem) {
        return getTranslationOffset(mem, 0);
    }
    
    @Nullable
    public static BlockPosition getTranslationOffset(MemorySegment mem, int offset) {
        return hasTranslationOffset(mem, offset) ? BlockPosition.toObject(mem, offset + 17): null;
    }
    
    @Nullable
    public static BlockPosition getInitialSelectionMin(MemorySegment mem) {
        return getInitialSelectionMin(mem, 0);
    }
    
    @Nullable
    public static BlockPosition getInitialSelectionMin(MemorySegment mem, int offset) {
        return hasInitialSelectionMin(mem, offset) ? BlockPosition.toObject(mem, offset + 29): null;
    }
    
    @Nullable
    public static BlockPosition getInitialSelectionMax(MemorySegment mem) {
        return getInitialSelectionMax(mem, 0);
    }
    
    @Nullable
    public static BlockPosition getInitialSelectionMax(MemorySegment mem, int offset) {
        return hasInitialSelectionMax(mem, offset) ? BlockPosition.toObject(mem, offset + 41): null;
    }
    
    public static Vector3fc getInitialRotationOrigin(MemorySegment mem) {
        return getInitialRotationOrigin(mem, 0);
    }
    
    public static Vector3fc getInitialRotationOrigin(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 53), "InitialRotationOrigin");
    }
    
    public static boolean getCutOriginal(MemorySegment mem) {
        return getCutOriginal(mem, 0);
    }
    
    public static boolean getCutOriginal(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 65) & 0x01) != 0;
    }
    
    public static boolean getApplyTransformationToSelectionMinMax(MemorySegment mem) {
        return getApplyTransformationToSelectionMinMax(mem, 0);
    }
    
    public static boolean getApplyTransformationToSelectionMinMax(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 65) & 0x02) != 0;
    }
    
    public static boolean getIsExitingTransformMode(MemorySegment mem) {
        return getIsExitingTransformMode(mem, 0);
    }
    
    public static boolean getIsExitingTransformMode(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 65) & 0x04) != 0;
    }
    
    @Nullable
    public static BlockPosition getInitialPastePointForClipboardPaste(MemorySegment mem) {
        return getInitialPastePointForClipboardPaste(mem, 0);
    }
    
    @Nullable
    public static BlockPosition getInitialPastePointForClipboardPaste(MemorySegment mem, int offset) {
        return hasInitialPastePointForClipboardPaste(mem, offset) ? BlockPosition.toObject(mem, offset + 66): null;
    }
    
    public static boolean hasRotation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasTranslationOffset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasInitialSelectionMin(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasInitialSelectionMax(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasInitialPastePointForClipboardPaste(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    
    
    public static BuilderToolSelectionTransform toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolSelectionTransform toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolSelectionTransform and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolSelectionTransform toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BuilderToolSelectionTransform(
            hasRotation(mem, offset) ? PacketIO.requireFinite(PacketIO.readQuaternionf(mem, offset + 1), "Rotation") : null,
            hasTranslationOffset(mem, offset) ? BlockPosition.toObject(mem, offset + 17) : null,
            hasInitialSelectionMin(mem, offset) ? BlockPosition.toObject(mem, offset + 29) : null,
            hasInitialSelectionMax(mem, offset) ? BlockPosition.toObject(mem, offset + 41) : null,
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 53), "InitialRotationOrigin"),
            (mem.get(PacketIO.PROTO_BYTE, offset + 65) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 65) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 65) & 0x04) != 0,
            hasInitialPastePointForClipboardPaste(mem, offset) ? BlockPosition.toObject(mem, offset + 66) : null
        );
        if (cursor != null) cursor.position = offset + 78;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.rotation != null) nullBits |= 0x01;
        if (this.translationOffset != null) nullBits |= 0x02;
        if (this.initialSelectionMin != null) nullBits |= 0x04;
        if (this.initialSelectionMax != null) nullBits |= 0x08;
        if (this.initialPastePointForClipboardPaste != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.rotation != null) {
            PacketIO.requireFinite(this.rotation, "Rotation"); PacketIO.writeQuaternionf(mem, offset + 1, this.rotation);
        } else {
            mem.asSlice(offset + 1, 16).fill((byte) 0); 
        }
        if (this.translationOffset != null) {
            this.translationOffset.serialize(mem, offset + 17);
        } else {
            mem.asSlice(offset + 17, 12).fill((byte) 0); 
        }
        if (this.initialSelectionMin != null) {
            this.initialSelectionMin.serialize(mem, offset + 29);
        } else {
            mem.asSlice(offset + 29, 12).fill((byte) 0); 
        }
        if (this.initialSelectionMax != null) {
            this.initialSelectionMax.serialize(mem, offset + 41);
        } else {
            mem.asSlice(offset + 41, 12).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.initialRotationOrigin, "InitialRotationOrigin"); PacketIO.writeVector3f(mem, offset + 53, this.initialRotationOrigin);
        byte boolBits0_0 = 0;
        if (this.cutOriginal) boolBits0_0 |= 0x01;
        if (this.applyTransformationToSelectionMinMax) boolBits0_0 |= 0x02;
        if (this.isExitingTransformMode) boolBits0_0 |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 65 + 0, boolBits0_0);
        if (this.initialPastePointForClipboardPaste != null) {
            this.initialPastePointForClipboardPaste.serialize(mem, offset + 66);
        } else {
            mem.asSlice(offset + 66, 12).fill((byte) 0); 
        }
        
        
    
       return 78;
    }
    public int computeSize() {
        return 78;
    }

    public BuilderToolSelectionTransform clone() {
        BuilderToolSelectionTransform copy = new BuilderToolSelectionTransform();
        copy.rotation = this.rotation;
        copy.translationOffset = this.translationOffset != null ? this.translationOffset.clone() : null;
        copy.initialSelectionMin = this.initialSelectionMin != null ? this.initialSelectionMin.clone() : null;
        copy.initialSelectionMax = this.initialSelectionMax != null ? this.initialSelectionMax.clone() : null;
        copy.initialRotationOrigin = this.initialRotationOrigin;
        copy.cutOriginal = this.cutOriginal;
        copy.applyTransformationToSelectionMinMax = this.applyTransformationToSelectionMinMax;
        copy.isExitingTransformMode = this.isExitingTransformMode;
        copy.initialPastePointForClipboardPaste = this.initialPastePointForClipboardPaste != null ? this.initialPastePointForClipboardPaste.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolSelectionTransform other)) return false;
        return java.util.Objects.equals(this.rotation, other.rotation) && java.util.Objects.equals(this.translationOffset, other.translationOffset) && java.util.Objects.equals(this.initialSelectionMin, other.initialSelectionMin) && java.util.Objects.equals(this.initialSelectionMax, other.initialSelectionMax) && java.util.Objects.equals(this.initialRotationOrigin, other.initialRotationOrigin) && this.cutOriginal == other.cutOriginal && this.applyTransformationToSelectionMinMax == other.applyTransformationToSelectionMinMax && this.isExitingTransformMode == other.isExitingTransformMode && java.util.Objects.equals(this.initialPastePointForClipboardPaste, other.initialPastePointForClipboardPaste);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(rotation, translationOffset, initialSelectionMin, initialSelectionMax, initialRotationOrigin, cutOriginal, applyTransformationToSelectionMinMax, isExitingTransformMode, initialPastePointForClipboardPaste);
    }

}