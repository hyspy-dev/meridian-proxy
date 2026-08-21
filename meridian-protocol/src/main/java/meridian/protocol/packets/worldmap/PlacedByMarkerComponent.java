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
import java.util.UUID;

public class PlacedByMarkerComponent extends MapMarkerComponent {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 16;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 16;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public FormattedMessage name = new FormattedMessage();
    @Nonnull public java.util.UUID playerId = new java.util.UUID(0L, 0L);

    public PlacedByMarkerComponent() {
    }

    public PlacedByMarkerComponent(@Nonnull FormattedMessage name, @Nonnull java.util.UUID playerId) {
        this.name = name;
        this.playerId = playerId;
    }

    public PlacedByMarkerComponent(@Nonnull PlacedByMarkerComponent other) {
        this.name = other.name;
        this.playerId = other.playerId;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PlacedByMarkerComponent", offset, (int) mem.byteSize());
        long needed = (long) offset + 16;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlacedByMarkerComponent", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static FormattedMessage getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    public static FormattedMessage getName(MemorySegment mem, int offset) {
        return FormattedMessage.toObject(mem, offset + 16);
    }
    
    public static java.util.UUID getPlayerId(MemorySegment mem) {
        return getPlayerId(mem, 0);
    }
    
    public static java.util.UUID getPlayerId(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 0);
    }
    
    
    
    
    
    public static PlacedByMarkerComponent toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PlacedByMarkerComponent toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PlacedByMarkerComponent and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PlacedByMarkerComponent toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 16;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        FormattedMessage v0;
        {
            v0 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new PlacedByMarkerComponent(
            v0,
            PacketIO.readUUID(mem, offset + 0)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.writeUUID(mem, offset + 0, this.playerId);
        var varOffset = offset + 16;
        varOffset += this.name.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 16;
        size += name.computeSize();

        return size;
    }

    public PlacedByMarkerComponent clone() {
        PlacedByMarkerComponent copy = new PlacedByMarkerComponent();
        copy.name = this.name.clone();
        copy.playerId = this.playerId;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlacedByMarkerComponent other)) return false;
        return java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.playerId, other.playerId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, playerId);
    }

}