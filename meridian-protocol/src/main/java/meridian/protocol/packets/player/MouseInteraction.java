// Auto-generated - do not edit
package meridian.protocol.packets.player;

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
import meridian.protocol.MouseButtonEvent;
import meridian.protocol.MouseMotionEvent;
import meridian.protocol.WorldInteraction;
import org.joml.*;

public class MouseInteraction implements Packet, ToServerPacket {
    public static final int PACKET_ID = 111;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 44;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 52;
    public static final int MAX_SIZE = 20480071;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public long clientTimestamp;
    public int activeSlot;
    @Nullable public String itemInHandId;
    @Nonnull public Vector2fc screenPoint = PacketIO.ZERO_VECTOR2;
    @Nullable public MouseButtonEvent mouseButton;
    @Nullable public MouseMotionEvent mouseMotion;
    @Nullable public WorldInteraction worldInteraction;

    public MouseInteraction() {
    }

    public MouseInteraction(long clientTimestamp, int activeSlot, @Nullable String itemInHandId, @Nonnull Vector2fc screenPoint, @Nullable MouseButtonEvent mouseButton, @Nullable MouseMotionEvent mouseMotion, @Nullable WorldInteraction worldInteraction) {
        this.clientTimestamp = clientTimestamp;
        this.activeSlot = activeSlot;
        this.itemInHandId = itemInHandId;
        this.screenPoint = screenPoint;
        this.mouseButton = mouseButton;
        this.mouseMotion = mouseMotion;
        this.worldInteraction = worldInteraction;
    }

    public MouseInteraction(@Nonnull MouseInteraction other) {
        this.clientTimestamp = other.clientTimestamp;
        this.activeSlot = other.activeSlot;
        this.itemInHandId = other.itemInHandId;
        this.screenPoint = other.screenPoint;
        this.mouseButton = other.mouseButton;
        this.mouseMotion = other.mouseMotion;
        this.worldInteraction = other.worldInteraction;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("MouseInteraction", offset, (int) mem.byteSize());
        long needed = (long) offset + 52;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("MouseInteraction", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static long getClientTimestamp(MemorySegment mem) {
        return getClientTimestamp(mem, 0);
    }
    
    public static long getClientTimestamp(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_LONG, offset + 1);
    }
    
    public static int getActiveSlot(MemorySegment mem) {
        return getActiveSlot(mem, 0);
    }
    
    public static int getActiveSlot(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    @Nullable
    public static String getItemInHandId(MemorySegment mem) {
        return getItemInHandId(mem, 0);
    }
    
    @Nullable
    public static String getItemInHandId(MemorySegment mem, int offset) {
        return hasItemInHandId(mem, offset) ? PacketIO.readVarString("ItemInHandId", mem, offset + getValidatedOffset(mem, offset, 44, 52, "ItemInHandId"), 4096000): null;
    }
    
    public static Vector2fc getScreenPoint(MemorySegment mem) {
        return getScreenPoint(mem, 0);
    }
    
    public static Vector2fc getScreenPoint(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 13), "ScreenPoint");
    }
    
    @Nullable
    public static MouseButtonEvent getMouseButton(MemorySegment mem) {
        return getMouseButton(mem, 0);
    }
    
    @Nullable
    public static MouseButtonEvent getMouseButton(MemorySegment mem, int offset) {
        return hasMouseButton(mem, offset) ? MouseButtonEvent.toObject(mem, offset + 21): null;
    }
    
    @Nullable
    public static MouseMotionEvent getMouseMotion(MemorySegment mem) {
        return getMouseMotion(mem, 0);
    }
    
    @Nullable
    public static MouseMotionEvent getMouseMotion(MemorySegment mem, int offset) {
        return hasMouseMotion(mem, offset) ? MouseMotionEvent.toObject(mem, offset + getValidatedOffset(mem, offset, 48, 52, "MouseMotion")): null;
    }
    
    @Nullable
    public static WorldInteraction getWorldInteraction(MemorySegment mem) {
        return getWorldInteraction(mem, 0);
    }
    
    @Nullable
    public static WorldInteraction getWorldInteraction(MemorySegment mem, int offset) {
        return hasWorldInteraction(mem, offset) ? WorldInteraction.toObject(mem, offset + 24): null;
    }
    
    public static boolean hasMouseButton(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasWorldInteraction(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasItemInHandId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasMouseMotion(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static MouseInteraction toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static MouseInteraction toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one MouseInteraction and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static MouseInteraction toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 52;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v2 = null;
        if (hasItemInHandId(mem, offset)) {
            requireSlot(mem, offset + 44, varPos, "ItemInHandId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("ItemInHandId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 44, -1, "ItemInHandId");
        }
        
        MouseMotionEvent v5 = null;
        if (hasMouseMotion(mem, offset)) {
            requireSlot(mem, offset + 48, varPos, "MouseMotion");
            v5 = MouseMotionEvent.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 48, -1, "MouseMotion");
        }
        var result = new MouseInteraction(
            mem.get(PacketIO.PROTO_LONG, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            v2,
            PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 13), "ScreenPoint"),
            hasMouseButton(mem, offset) ? MouseButtonEvent.toObject(mem, offset + 21) : null,
            v5,
            hasWorldInteraction(mem, offset) ? WorldInteraction.toObject(mem, offset + 24) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.mouseButton != null) nullBits |= 0x01;
        if (this.worldInteraction != null) nullBits |= 0x02;
        if (this.itemInHandId != null) nullBits |= 0x04;
        if (this.mouseMotion != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_LONG, offset + 1, this.clientTimestamp);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.activeSlot);
        PacketIO.requireFinite(this.screenPoint, "ScreenPoint"); PacketIO.writeVector2f(mem, offset + 13, this.screenPoint);
        if (this.mouseButton != null) {
            this.mouseButton.serialize(mem, offset + 21);
        } else {
            mem.asSlice(offset + 21, 3).fill((byte) 0); 
        }
        if (this.worldInteraction != null) {
            this.worldInteraction.serialize(mem, offset + 24);
        } else {
            mem.asSlice(offset + 24, 20).fill((byte) 0); 
        }
        var varOffset = offset + 52;
        if (this.itemInHandId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 44, varOffset - offset - 52);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.itemInHandId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 44, -1);
        }
        if (this.mouseMotion != null) {
            mem.set(PacketIO.PROTO_INT, offset + 48, varOffset - offset - 52);
            varOffset += this.mouseMotion.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 48, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 52;
        if (itemInHandId != null) size += PacketIO.stringSize(itemInHandId);
    if (mouseMotion != null) size += mouseMotion.computeSize();

        return size;
    }

    public MouseInteraction clone() {
        MouseInteraction copy = new MouseInteraction();
        copy.clientTimestamp = this.clientTimestamp;
        copy.activeSlot = this.activeSlot;
        copy.itemInHandId = this.itemInHandId;
        copy.screenPoint = this.screenPoint;
        copy.mouseButton = this.mouseButton != null ? this.mouseButton.clone() : null;
        copy.mouseMotion = this.mouseMotion != null ? this.mouseMotion.clone() : null;
        copy.worldInteraction = this.worldInteraction != null ? this.worldInteraction.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MouseInteraction other)) return false;
        return this.clientTimestamp == other.clientTimestamp && this.activeSlot == other.activeSlot && java.util.Objects.equals(this.itemInHandId, other.itemInHandId) && java.util.Objects.equals(this.screenPoint, other.screenPoint) && java.util.Objects.equals(this.mouseButton, other.mouseButton) && java.util.Objects.equals(this.mouseMotion, other.mouseMotion) && java.util.Objects.equals(this.worldInteraction, other.worldInteraction);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(clientTimestamp, activeSlot, itemInHandId, screenPoint, mouseButton, mouseMotion, worldInteraction);
    }

}