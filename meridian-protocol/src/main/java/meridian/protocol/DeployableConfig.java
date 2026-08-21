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


public class DeployableConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 10;
    public static final int MAX_SIZE = 2058;

    @Nullable public Model model;
    @Nullable public Model modelPreview;
    public boolean allowPlaceOnWalls;

    public DeployableConfig() {
    }

    public DeployableConfig(@Nullable Model model, @Nullable Model modelPreview, boolean allowPlaceOnWalls) {
        this.model = model;
        this.modelPreview = modelPreview;
        this.allowPlaceOnWalls = allowPlaceOnWalls;
    }

    public DeployableConfig(@Nonnull DeployableConfig other) {
        this.model = other.model;
        this.modelPreview = other.modelPreview;
        this.allowPlaceOnWalls = other.allowPlaceOnWalls;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("DeployableConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("DeployableConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static Model getModel(MemorySegment mem) {
        return getModel(mem, 0);
    }
    
    @Nullable
    public static Model getModel(MemorySegment mem, int offset) {
        return hasModel(mem, offset) ? Model.toObject(mem, offset + getValidatedOffset(mem, offset, 2, 10, "Model")): null;
    }
    
    @Nullable
    public static Model getModelPreview(MemorySegment mem) {
        return getModelPreview(mem, 0);
    }
    
    @Nullable
    public static Model getModelPreview(MemorySegment mem, int offset) {
        return hasModelPreview(mem, offset) ? Model.toObject(mem, offset + getValidatedOffset(mem, offset, 6, 10, "ModelPreview")): null;
    }
    
    public static boolean getAllowPlaceOnWalls(MemorySegment mem) {
        return getAllowPlaceOnWalls(mem, 0);
    }
    
    public static boolean getAllowPlaceOnWalls(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static boolean hasModel(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasModelPreview(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static DeployableConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static DeployableConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one DeployableConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static DeployableConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 10;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        Model v0 = null;
        if (hasModel(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "Model");
            v0 = Model.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 2, -1, "Model");
        }
        
        Model v1 = null;
        if (hasModelPreview(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "ModelPreview");
            v1 = Model.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "ModelPreview");
        }
        var result = new DeployableConfig(
            v0,
            v1,
            mem.get(PacketIO.PROTO_BOOL, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.model != null) nullBits |= 0x01;
        if (this.modelPreview != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.allowPlaceOnWalls);
        var varOffset = offset + 10;
        if (this.model != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 10);
            varOffset += this.model.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.modelPreview != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 10);
            varOffset += this.modelPreview.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 10;
        if (model != null) size += model.computeSize();
    if (modelPreview != null) size += modelPreview.computeSize();

        return size;
    }

    public DeployableConfig clone() {
        DeployableConfig copy = new DeployableConfig();
        copy.model = this.model != null ? this.model.clone() : null;
        copy.modelPreview = this.modelPreview != null ? this.modelPreview.clone() : null;
        copy.allowPlaceOnWalls = this.allowPlaceOnWalls;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DeployableConfig other)) return false;
        return java.util.Objects.equals(this.model, other.model) && java.util.Objects.equals(this.modelPreview, other.modelPreview) && this.allowPlaceOnWalls == other.allowPlaceOnWalls;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(model, modelPreview, allowPlaceOnWalls);
    }

}