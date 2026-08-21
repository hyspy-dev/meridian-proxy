// Auto-generated - do not edit
package meridian.protocol.packets.worldmap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.FormattedMessage;
import meridian.protocol.Transform;

public class MapMarker {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 38;
    public static final int VARIABLE_FIELD_COUNT = 5;
    public static final int VARIABLE_BLOCK_START = 58;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String id = "";
    @Nullable public FormattedMessage name;
    @Nonnull public String markerImage = "";
    @Nonnull public Transform transform = new Transform();
    @Nullable public ContextMenuItem[] contextMenuItems;
    @Nullable public MapMarkerComponent[] components;

    public MapMarker() {
    }

    public MapMarker(@Nonnull String id, @Nullable FormattedMessage name, @Nonnull String markerImage, @Nonnull Transform transform, @Nullable ContextMenuItem[] contextMenuItems, @Nullable MapMarkerComponent[] components) {
        this.id = id;
        this.name = name;
        this.markerImage = markerImage;
        this.transform = transform;
        this.contextMenuItems = contextMenuItems;
        this.components = components;
    }

    public MapMarker(@Nonnull MapMarker other) {
        this.id = other.id;
        this.name = other.name;
        this.markerImage = other.markerImage;
        this.transform = other.transform;
        this.contextMenuItems = other.contextMenuItems;
        this.components = other.components;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MapMarker", offset, (int) mem.byteSize());
        long needed = (long) offset + 58;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MapMarker", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static String getId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 38, 58, "Id"), 4096000);
    }
    
    @Nullable
    public static FormattedMessage getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? FormattedMessage.toObject(mem, offset + getValidatedOffset(mem, offset, 42, 58, "Name")): null;
    }
    
    public static String getMarkerImage(MemorySegment mem) {
        return getMarkerImage(mem, 0);
    }
    
    public static String getMarkerImage(MemorySegment mem, int offset) {
        return PacketIO.readVarString("MarkerImage", mem, offset + getValidatedOffset(mem, offset, 46, 58, "MarkerImage"), 4096000);
    }
    
    public static Transform getTransform(MemorySegment mem) {
        return getTransform(mem, 0);
    }
    
    public static Transform getTransform(MemorySegment mem, int offset) {
        return Transform.toObject(mem, offset + 1);
    }
    
    @Nullable
    public static ContextMenuItem[] getContextMenuItems(MemorySegment mem) {
        return getContextMenuItems(mem, 0);
    }
    
    @Nullable
    public static ContextMenuItem[] getContextMenuItems(MemorySegment mem, int offset) {
        if (!hasContextMenuItems(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 50, 58, "ContextMenuItems");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ContextMenuItems");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ContextMenuItems", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ContextMenuItems", (int) java.lang.Math.min(off + lenOffset + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ContextMenuItem[len];
        for (var i = 0; i < len; i++) {
            data[i] = ContextMenuItem.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static MapMarkerComponent[] getComponents(MemorySegment mem) {
        return getComponents(mem, 0);
    }
    
    @Nullable
    public static MapMarkerComponent[] getComponents(MemorySegment mem, int offset) {
        if (!hasComponents(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 54, 58, "Components");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Components");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Components", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Components", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new MapMarkerComponent[len];
        for (var i = 0; i < len; i++) {
            data[i] = MapMarkerComponent.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasContextMenuItems(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasComponents(MemorySegment mem, int offset) {
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
    
    public static MapMarker toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MapMarker toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MapMarker and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MapMarker toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 58;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 38, varPos, "Id");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        FormattedMessage v1 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 42, varPos, "Name");
            v1 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 42, -1, "Name");
        }
        
        String v2;
        requireSlot(mem, offset + 46, varPos, "MarkerImage");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("MarkerImage", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        ContextMenuItem[] v4 = null;
        if (hasContextMenuItems(mem, offset)) {
            requireSlot(mem, offset + 50, varPos, "ContextMenuItems");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ContextMenuItems");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ContextMenuItems", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ContextMenuItems", (int) java.lang.Math.min(off + lenOffset + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new ContextMenuItem[len];
            for (var i = 0; i < len; i++) {
                v4[i] = ContextMenuItem.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 50, -1, "ContextMenuItems");
        }
        
        MapMarkerComponent[] v5 = null;
        if (hasComponents(mem, offset)) {
            requireSlot(mem, offset + 54, varPos, "Components");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Components");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Components", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Components", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new MapMarkerComponent[len];
            for (var i = 0; i < len; i++) {
                v5[i] = MapMarkerComponent.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 54, -1, "Components");
        }
        var result = new MapMarker(
            v0,
            v1,
            v2,
            Transform.toObject(mem, offset + 1),
            v4,
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.name != null) nullBits |= 0x01;
        if (this.contextMenuItems != null) nullBits |= 0x02;
        if (this.components != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        this.transform.serialize(mem, offset + 1);
        var varOffset = offset + 58;
        mem.set(PacketIO.PROTO_INT, offset + 38, varOffset - offset - 58);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 42, varOffset - offset - 58);
            varOffset += this.name.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 42, -1);
        }
        mem.set(PacketIO.PROTO_INT, offset + 46, varOffset - offset - 58);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.markerImage, 4096000);
        if (this.contextMenuItems != null) {
            mem.set(PacketIO.PROTO_INT, offset + 50, varOffset - offset - 58);
            if (contextMenuItems.length > 4096000) throw ProtocolException.arrayTooLong("ContextMenuItems", contextMenuItems.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.contextMenuItems.length);
            
            var contextMenuItemsValueOffset = 0;
            for (var i = 0; i < this.contextMenuItems.length; i++) {
                contextMenuItemsValueOffset += this.contextMenuItems[i].serialize(mem, varOffset + contextMenuItemsValueOffset);
            }
            varOffset += contextMenuItemsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 50, -1);
        }
        if (this.components != null) {
            mem.set(PacketIO.PROTO_INT, offset + 54, varOffset - offset - 58);
            if (components.length > 4096000) throw ProtocolException.arrayTooLong("Components", components.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.components.length);
            
            var componentsValueOffset = 0;
            for (var i = 0; i < this.components.length; i++) {
                componentsValueOffset += this.components[i].serializeWithTypeId(mem, varOffset + componentsValueOffset);
            }
            varOffset += componentsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 54, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 58;
        size += PacketIO.stringSize(id);
    if (name != null) size += name.computeSize();
    size += PacketIO.stringSize(markerImage);
    if (contextMenuItems != null) {
        int contextMenuItemsSize = 0;
for (var elem : contextMenuItems) contextMenuItemsSize += elem.computeSize();
size += VarInt.size(contextMenuItems.length) + contextMenuItemsSize;
    }
    if (components != null) {
        int componentsSize = 0;
for (var elem : components) componentsSize += elem.computeSizeWithTypeId();
size += VarInt.size(components.length) + componentsSize;
    }

        return size;
    }

    public MapMarker clone() {
        MapMarker copy = new MapMarker();
        copy.id = this.id;
        copy.name = this.name != null ? this.name.clone() : null;
        copy.markerImage = this.markerImage;
        copy.transform = this.transform.clone();
        copy.contextMenuItems = this.contextMenuItems != null ? java.util.Arrays.stream(this.contextMenuItems).map(e -> e.clone()).toArray(ContextMenuItem[]::new) : null;
        copy.components = this.components != null ? java.util.Arrays.copyOf(this.components, this.components.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MapMarker other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.markerImage, other.markerImage) && java.util.Objects.equals(this.transform, other.transform) && java.util.Arrays.equals(this.contextMenuItems, other.contextMenuItems) && java.util.Arrays.equals(this.components, other.components);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Objects.hashCode(name);
        result = 31 * result + java.util.Objects.hashCode(markerImage);
        result = 31 * result + java.util.Objects.hashCode(transform);
        result = 31 * result + java.util.Arrays.hashCode(contextMenuItems);
        result = 31 * result + java.util.Arrays.hashCode(components);
        return result;
    }

}