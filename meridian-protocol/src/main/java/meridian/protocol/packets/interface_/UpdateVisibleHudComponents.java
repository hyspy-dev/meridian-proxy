// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

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


public class UpdateVisibleHudComponents implements Packet, ToClientPacket {
    public static final int PACKET_ID = 230;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 4096006;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public HudComponent[] visibleComponents;

    public UpdateVisibleHudComponents() {
    }

    public UpdateVisibleHudComponents(@Nullable HudComponent[] visibleComponents) {
        this.visibleComponents = visibleComponents;
    }

    public UpdateVisibleHudComponents(@Nonnull UpdateVisibleHudComponents other) {
        this.visibleComponents = other.visibleComponents;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateVisibleHudComponents", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateVisibleHudComponents", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static HudComponent[] getVisibleComponents(MemorySegment mem) {
        return getVisibleComponents(mem, 0);
    }
    
    @Nullable
    public static HudComponent[] getVisibleComponents(MemorySegment mem, int offset) {
        if (!hasVisibleComponents(mem, offset)) return null;
        var off = offset + 1;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("VisibleComponents");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("VisibleComponents", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("VisibleComponents", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new HudComponent[len];
        for (var i = 0; i < len; i++) {
            data[i] = HudComponent.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    public static boolean hasVisibleComponents(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateVisibleHudComponents toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateVisibleHudComponents toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateVisibleHudComponents and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateVisibleHudComponents toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        HudComponent[] v0 = null;
        if (hasVisibleComponents(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("VisibleComponents");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("VisibleComponents", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("VisibleComponents", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new HudComponent[len];
            for (var i = 0; i < len; i++) {
                v0[i] = HudComponent.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        }
        var result = new UpdateVisibleHudComponents(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.visibleComponents != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 1;
        if (this.visibleComponents != null) {
            
            if (visibleComponents.length > 4096000) throw ProtocolException.arrayTooLong("VisibleComponents", visibleComponents.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.visibleComponents.length);
            
            for (var i = 0; i < this.visibleComponents.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.visibleComponents[i].getValue());
            }
            varOffset += this.visibleComponents.length * 1;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        if (visibleComponents != null) size += VarInt.size(visibleComponents.length) + visibleComponents.length * 1;

        return size;
    }

    public UpdateVisibleHudComponents clone() {
        UpdateVisibleHudComponents copy = new UpdateVisibleHudComponents();
        copy.visibleComponents = this.visibleComponents != null ? java.util.Arrays.copyOf(this.visibleComponents, this.visibleComponents.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateVisibleHudComponents other)) return false;
        return java.util.Arrays.equals(this.visibleComponents, other.visibleComponents);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(visibleComponents);
        return result;
    }

}