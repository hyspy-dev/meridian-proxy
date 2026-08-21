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

public class ModelDisplay {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 37;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 45;
    public static final int MAX_SIZE = 32768055;

    @Nullable public String node;
    @Nullable public String attachTo;
    @Nullable public Vector3fc translation;
    @Nullable public Vector3fc rotation;
    @Nullable public Vector3fc scale;

    public ModelDisplay() {
    }

    public ModelDisplay(@Nullable String node, @Nullable String attachTo, @Nullable Vector3fc translation, @Nullable Vector3fc rotation, @Nullable Vector3fc scale) {
        this.node = node;
        this.attachTo = attachTo;
        this.translation = translation;
        this.rotation = rotation;
        this.scale = scale;
    }

    public ModelDisplay(@Nonnull ModelDisplay other) {
        this.node = other.node;
        this.attachTo = other.attachTo;
        this.translation = other.translation;
        this.rotation = other.rotation;
        this.scale = other.scale;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ModelDisplay", offset, (int) mem.byteSize());
        long needed = (long) offset + 45;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelDisplay", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getNode(MemorySegment mem) {
        return getNode(mem, 0);
    }
    
    @Nullable
    public static String getNode(MemorySegment mem, int offset) {
        return hasNode(mem, offset) ? PacketIO.readVarString("Node", mem, offset + getValidatedOffset(mem, offset, 37, 45, "Node"), 4096000): null;
    }
    
    @Nullable
    public static String getAttachTo(MemorySegment mem) {
        return getAttachTo(mem, 0);
    }
    
    @Nullable
    public static String getAttachTo(MemorySegment mem, int offset) {
        return hasAttachTo(mem, offset) ? PacketIO.readVarString("AttachTo", mem, offset + getValidatedOffset(mem, offset, 41, 45, "AttachTo"), 4096000): null;
    }
    
    @Nullable
    public static Vector3fc getTranslation(MemorySegment mem) {
        return getTranslation(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getTranslation(MemorySegment mem, int offset) {
        return hasTranslation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Translation"): null;
    }
    
    @Nullable
    public static Vector3fc getRotation(MemorySegment mem) {
        return getRotation(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getRotation(MemorySegment mem, int offset) {
        return hasRotation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "Rotation"): null;
    }
    
    @Nullable
    public static Vector3fc getScale(MemorySegment mem) {
        return getScale(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getScale(MemorySegment mem, int offset) {
        return hasScale(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 25), "Scale"): null;
    }
    
    public static boolean hasTranslation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRotation(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasScale(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasNode(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasAttachTo(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
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
    
    public static ModelDisplay toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ModelDisplay toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ModelDisplay and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ModelDisplay toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 45;
        var varPos = 0;
        String v0 = null;
        if (hasNode(mem, offset)) {
            requireSlot(mem, offset + 37, varPos, "Node");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Node", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 37, -1, "Node");
        }
        
        String v1 = null;
        if (hasAttachTo(mem, offset)) {
            requireSlot(mem, offset + 41, varPos, "AttachTo");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("AttachTo", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 41, -1, "AttachTo");
        }
        var result = new ModelDisplay(
            v0,
            v1,
            hasTranslation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 1), "Translation") : null,
            hasRotation(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 13), "Rotation") : null,
            hasScale(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 25), "Scale") : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.translation != null) nullBits |= 0x01;
        if (this.rotation != null) nullBits |= 0x02;
        if (this.scale != null) nullBits |= 0x04;
        if (this.node != null) nullBits |= 0x08;
        if (this.attachTo != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.translation != null) {
            PacketIO.requireFinite(this.translation, "Translation"); PacketIO.writeVector3f(mem, offset + 1, this.translation);
        } else {
            mem.asSlice(offset + 1, 12).fill((byte) 0); 
        }
        if (this.rotation != null) {
            PacketIO.requireFinite(this.rotation, "Rotation"); PacketIO.writeVector3f(mem, offset + 13, this.rotation);
        } else {
            mem.asSlice(offset + 13, 12).fill((byte) 0); 
        }
        if (this.scale != null) {
            PacketIO.requireFinite(this.scale, "Scale"); PacketIO.writeVector3f(mem, offset + 25, this.scale);
        } else {
            mem.asSlice(offset + 25, 12).fill((byte) 0); 
        }
        var varOffset = offset + 45;
        if (this.node != null) {
            mem.set(PacketIO.PROTO_INT, offset + 37, varOffset - offset - 45);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.node, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 37, -1);
        }
        if (this.attachTo != null) {
            mem.set(PacketIO.PROTO_INT, offset + 41, varOffset - offset - 45);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.attachTo, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 41, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 45;
        if (node != null) size += PacketIO.stringSize(node);
    if (attachTo != null) size += PacketIO.stringSize(attachTo);

        return size;
    }

    public ModelDisplay clone() {
        ModelDisplay copy = new ModelDisplay();
        copy.node = this.node;
        copy.attachTo = this.attachTo;
        copy.translation = this.translation;
        copy.rotation = this.rotation;
        copy.scale = this.scale;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ModelDisplay other)) return false;
        return java.util.Objects.equals(this.node, other.node) && java.util.Objects.equals(this.attachTo, other.attachTo) && java.util.Objects.equals(this.translation, other.translation) && java.util.Objects.equals(this.rotation, other.rotation) && java.util.Objects.equals(this.scale, other.scale);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(node, attachTo, translation, rotation, scale);
    }

}