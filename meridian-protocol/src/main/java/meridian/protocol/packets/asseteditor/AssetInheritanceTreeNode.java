// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class AssetInheritanceTreeNode {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public AssetPath reference;
    @Nullable public String jsonContent;
    @Nullable public AssetInheritanceTreeNode[] ancestors;

    public AssetInheritanceTreeNode() {
    }

    public AssetInheritanceTreeNode(@Nullable AssetPath reference, @Nullable String jsonContent, @Nullable AssetInheritanceTreeNode[] ancestors) {
        this.reference = reference;
        this.jsonContent = jsonContent;
        this.ancestors = ancestors;
    }

    public AssetInheritanceTreeNode(@Nonnull AssetInheritanceTreeNode other) {
        this.reference = other.reference;
        this.jsonContent = other.jsonContent;
        this.ancestors = other.ancestors;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetInheritanceTreeNode", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetInheritanceTreeNode", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static AssetPath getReference(MemorySegment mem) {
        return getReference(mem, 0);
    }
    
    @Nullable
    public static AssetPath getReference(MemorySegment mem, int offset) {
        return hasReference(mem, offset) ? AssetPath.toObject(mem, offset + getValidatedOffset(mem, offset, 1, 13, "Reference")): null;
    }
    
    @Nullable
    public static String getJsonContent(MemorySegment mem) {
        return getJsonContent(mem, 0);
    }
    
    @Nullable
    public static String getJsonContent(MemorySegment mem, int offset) {
        return hasJsonContent(mem, offset) ? PacketIO.readVarString("JsonContent", mem, offset + getValidatedOffset(mem, offset, 5, 13, "JsonContent"), 4096000): null;
    }
    
    @Nullable
    public static AssetInheritanceTreeNode[] getAncestors(MemorySegment mem) {
        return getAncestors(mem, 0);
    }
    
    @Nullable
    public static AssetInheritanceTreeNode[] getAncestors(MemorySegment mem, int offset) {
        if (!hasAncestors(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 9, 13, "Ancestors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Ancestors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Ancestors", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Ancestors", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AssetInheritanceTreeNode[len];
        for (var i = 0; i < len; i++) {
            data[i] = AssetInheritanceTreeNode.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasReference(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasJsonContent(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasAncestors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
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
    
    public static AssetInheritanceTreeNode toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetInheritanceTreeNode toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetInheritanceTreeNode and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetInheritanceTreeNode toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetPath v0 = null;
        if (hasReference(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Reference");
            v0 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "Reference");
        }
        
        String v1 = null;
        if (hasJsonContent(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "JsonContent");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("JsonContent", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "JsonContent");
        }
        
        AssetInheritanceTreeNode[] v2 = null;
        if (hasAncestors(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Ancestors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Ancestors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Ancestors", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Ancestors", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new AssetInheritanceTreeNode[len];
            for (var i = 0; i < len; i++) {
                v2[i] = AssetInheritanceTreeNode.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "Ancestors");
        }
        var result = new AssetInheritanceTreeNode(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.reference != null) nullBits |= 0x01;
        if (this.jsonContent != null) nullBits |= 0x02;
        if (this.ancestors != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        if (this.reference != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
            varOffset += this.reference.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.jsonContent != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.jsonContent, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.ancestors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            if (ancestors.length > 4096000) throw ProtocolException.arrayTooLong("Ancestors", ancestors.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.ancestors.length);
            
            var ancestorsValueOffset = 0;
            for (var i = 0; i < this.ancestors.length; i++) {
                ancestorsValueOffset += this.ancestors[i].serialize(mem, varOffset + ancestorsValueOffset);
            }
            varOffset += ancestorsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (reference != null) size += reference.computeSize();
    if (jsonContent != null) size += PacketIO.stringSize(jsonContent);
    if (ancestors != null) {
        int ancestorsSize = 0;
for (var elem : ancestors) ancestorsSize += elem.computeSize();
size += VarInt.size(ancestors.length) + ancestorsSize;
    }

        return size;
    }

    public AssetInheritanceTreeNode clone() {
        AssetInheritanceTreeNode copy = new AssetInheritanceTreeNode();
        copy.reference = this.reference != null ? this.reference.clone() : null;
        copy.jsonContent = this.jsonContent;
        copy.ancestors = this.ancestors != null ? java.util.Arrays.stream(this.ancestors).map(e -> e.clone()).toArray(AssetInheritanceTreeNode[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetInheritanceTreeNode other)) return false;
        return java.util.Objects.equals(this.reference, other.reference) && java.util.Objects.equals(this.jsonContent, other.jsonContent) && java.util.Arrays.equals(this.ancestors, other.ancestors);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(reference);
        result = 31 * result + java.util.Objects.hashCode(jsonContent);
        result = 31 * result + java.util.Arrays.hashCode(ancestors);
        return result;
    }

}