// Auto-generated - do not edit
package meridian.protocol.packets.worldmap;

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
import meridian.protocol.Color;

public class CreateUserMarker implements Packet, ToServerPacket {
    public static final int PACKET_ID = 246;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 21;
    public static final int MAX_SIZE = 32768031;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public float x;
    public float z;
    @Nullable public String name;
    @Nullable public String markerImage;
    @Nullable public Color tintColor;
    public boolean shared;

    public CreateUserMarker() {
    }

    public CreateUserMarker(float x, float z, @Nullable String name, @Nullable String markerImage, @Nullable Color tintColor, boolean shared) {
        this.x = x;
        this.z = z;
        this.name = name;
        this.markerImage = markerImage;
        this.tintColor = tintColor;
        this.shared = shared;
    }

    public CreateUserMarker(@Nonnull CreateUserMarker other) {
        this.x = other.x;
        this.z = other.z;
        this.name = other.name;
        this.markerImage = other.markerImage;
        this.tintColor = other.tintColor;
        this.shared = other.shared;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CreateUserMarker", offset, (int) mem.byteSize());
        long needed = (long) offset + 21;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CreateUserMarker", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static float getX(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "X");
    }
    
    public static float getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static float getZ(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Z");
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 13, 21, "Name"), 4096000): null;
    }
    
    @Nullable
    public static String getMarkerImage(MemorySegment mem) {
        return getMarkerImage(mem, 0);
    }
    
    @Nullable
    public static String getMarkerImage(MemorySegment mem, int offset) {
        return hasMarkerImage(mem, offset) ? PacketIO.readVarString("MarkerImage", mem, offset + getValidatedOffset(mem, offset, 17, 21, "MarkerImage"), 4096000): null;
    }
    
    @Nullable
    public static Color getTintColor(MemorySegment mem) {
        return getTintColor(mem, 0);
    }
    
    @Nullable
    public static Color getTintColor(MemorySegment mem, int offset) {
        return hasTintColor(mem, offset) ? Color.toObject(mem, offset + 9): null;
    }
    
    public static boolean getShared(MemorySegment mem) {
        return getShared(mem, 0);
    }
    
    public static boolean getShared(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 12);
    }
    
    public static boolean hasTintColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasMarkerImage(MemorySegment mem, int offset) {
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
    
    public static CreateUserMarker toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CreateUserMarker toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CreateUserMarker and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CreateUserMarker toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 21;
        var varPos = 0;
        String v2 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 13, -1, "Name");
        }
        
        String v3 = null;
        if (hasMarkerImage(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "MarkerImage");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("MarkerImage", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 17, -1, "MarkerImage");
        }
        var result = new CreateUserMarker(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "X"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "Z"),
            v2,
            v3,
            hasTintColor(mem, offset) ? Color.toObject(mem, offset + 9) : null,
            mem.get(PacketIO.PROTO_BOOL, offset + 12)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.tintColor != null) nullBits |= 0x01;
        if (this.name != null) nullBits |= 0x02;
        if (this.markerImage != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.x, "X"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.x);
        PacketIO.requireFinite(this.z, "Z"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.z);
        if (this.tintColor != null) {
            this.tintColor.serialize(mem, offset + 9);
        } else {
            mem.asSlice(offset + 9, 3).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 12, this.shared);
        var varOffset = offset + 21;
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 21);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.markerImage != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 21);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.markerImage, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 21;
        if (name != null) size += PacketIO.stringSize(name);
    if (markerImage != null) size += PacketIO.stringSize(markerImage);

        return size;
    }

    public CreateUserMarker clone() {
        CreateUserMarker copy = new CreateUserMarker();
        copy.x = this.x;
        copy.z = this.z;
        copy.name = this.name;
        copy.markerImage = this.markerImage;
        copy.tintColor = this.tintColor != null ? this.tintColor.clone() : null;
        copy.shared = this.shared;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CreateUserMarker other)) return false;
        return this.x == other.x && this.z == other.z && java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.markerImage, other.markerImage) && java.util.Objects.equals(this.tintColor, other.tintColor) && this.shared == other.shared;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, z, name, markerImage, tintColor, shared);
    }

}