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


public class UpdateWorldMapSettings implements Packet, ToClientPacket {
    public static final int PACKET_ID = 240;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 13;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public boolean enabled = true;
    public boolean allowTeleportToCoordinates;
    public boolean allowTeleportToMarkers;
    public boolean allowShowOnMapToggle;
    public boolean allowCompassTrackingToggle;
    public boolean allowCreatingMapMarkers;
    public boolean allowRemovingOtherPlayersMarkers;
    public float defaultScale = 32;
    public float minScale = 2;
    public float maxScale = 256;

    public UpdateWorldMapSettings() {
    }

    public UpdateWorldMapSettings(boolean enabled, boolean allowTeleportToCoordinates, boolean allowTeleportToMarkers, boolean allowShowOnMapToggle, boolean allowCompassTrackingToggle, boolean allowCreatingMapMarkers, boolean allowRemovingOtherPlayersMarkers, float defaultScale, float minScale, float maxScale) {
        this.enabled = enabled;
        this.allowTeleportToCoordinates = allowTeleportToCoordinates;
        this.allowTeleportToMarkers = allowTeleportToMarkers;
        this.allowShowOnMapToggle = allowShowOnMapToggle;
        this.allowCompassTrackingToggle = allowCompassTrackingToggle;
        this.allowCreatingMapMarkers = allowCreatingMapMarkers;
        this.allowRemovingOtherPlayersMarkers = allowRemovingOtherPlayersMarkers;
        this.defaultScale = defaultScale;
        this.minScale = minScale;
        this.maxScale = maxScale;
    }

    public UpdateWorldMapSettings(@Nonnull UpdateWorldMapSettings other) {
        this.enabled = other.enabled;
        this.allowTeleportToCoordinates = other.allowTeleportToCoordinates;
        this.allowTeleportToMarkers = other.allowTeleportToMarkers;
        this.allowShowOnMapToggle = other.allowShowOnMapToggle;
        this.allowCompassTrackingToggle = other.allowCompassTrackingToggle;
        this.allowCreatingMapMarkers = other.allowCreatingMapMarkers;
        this.allowRemovingOtherPlayersMarkers = other.allowRemovingOtherPlayersMarkers;
        this.defaultScale = other.defaultScale;
        this.minScale = other.minScale;
        this.maxScale = other.maxScale;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateWorldMapSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateWorldMapSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getEnabled(MemorySegment mem) {
        return getEnabled(mem, 0);
    }
    
    public static boolean getEnabled(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0;
    }
    
    public static boolean getAllowTeleportToCoordinates(MemorySegment mem) {
        return getAllowTeleportToCoordinates(mem, 0);
    }
    
    public static boolean getAllowTeleportToCoordinates(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0;
    }
    
    public static boolean getAllowTeleportToMarkers(MemorySegment mem) {
        return getAllowTeleportToMarkers(mem, 0);
    }
    
    public static boolean getAllowTeleportToMarkers(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x04) != 0;
    }
    
    public static boolean getAllowShowOnMapToggle(MemorySegment mem) {
        return getAllowShowOnMapToggle(mem, 0);
    }
    
    public static boolean getAllowShowOnMapToggle(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x08) != 0;
    }
    
    public static boolean getAllowCompassTrackingToggle(MemorySegment mem) {
        return getAllowCompassTrackingToggle(mem, 0);
    }
    
    public static boolean getAllowCompassTrackingToggle(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x10) != 0;
    }
    
    public static boolean getAllowCreatingMapMarkers(MemorySegment mem) {
        return getAllowCreatingMapMarkers(mem, 0);
    }
    
    public static boolean getAllowCreatingMapMarkers(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x20) != 0;
    }
    
    public static boolean getAllowRemovingOtherPlayersMarkers(MemorySegment mem) {
        return getAllowRemovingOtherPlayersMarkers(mem, 0);
    }
    
    public static boolean getAllowRemovingOtherPlayersMarkers(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x40) != 0;
    }
    
    public static float getDefaultScale(MemorySegment mem) {
        return getDefaultScale(mem, 0);
    }
    
    public static float getDefaultScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "DefaultScale");
    }
    
    public static float getMinScale(MemorySegment mem) {
        return getMinScale(mem, 0);
    }
    
    public static float getMinScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "MinScale");
    }
    
    public static float getMaxScale(MemorySegment mem) {
        return getMaxScale(mem, 0);
    }
    
    public static float getMaxScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "MaxScale");
    }
    
    
    
    
    
    public static UpdateWorldMapSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateWorldMapSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateWorldMapSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateWorldMapSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UpdateWorldMapSettings(
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x08) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x10) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x20) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x40) != 0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "DefaultScale"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "MinScale"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 9), "MaxScale")
        );
        if (cursor != null) cursor.position = offset + 13;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        byte boolBits0_0 = 0;
        if (this.enabled) boolBits0_0 |= 0x01;
        if (this.allowTeleportToCoordinates) boolBits0_0 |= 0x02;
        if (this.allowTeleportToMarkers) boolBits0_0 |= 0x04;
        if (this.allowShowOnMapToggle) boolBits0_0 |= 0x08;
        if (this.allowCompassTrackingToggle) boolBits0_0 |= 0x10;
        if (this.allowCreatingMapMarkers) boolBits0_0 |= 0x20;
        if (this.allowRemovingOtherPlayersMarkers) boolBits0_0 |= 0x40;
        mem.set(PacketIO.PROTO_BYTE, offset + 0 + 0, boolBits0_0);
        PacketIO.requireFinite(this.defaultScale, "DefaultScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.defaultScale);
        PacketIO.requireFinite(this.minScale, "MinScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.minScale);
        PacketIO.requireFinite(this.maxScale, "MaxScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 9, this.maxScale);
        
        
    
       return 13;
    }
    public int computeSize() {
        return 13;
    }

    public UpdateWorldMapSettings clone() {
        UpdateWorldMapSettings copy = new UpdateWorldMapSettings();
        copy.enabled = this.enabled;
        copy.allowTeleportToCoordinates = this.allowTeleportToCoordinates;
        copy.allowTeleportToMarkers = this.allowTeleportToMarkers;
        copy.allowShowOnMapToggle = this.allowShowOnMapToggle;
        copy.allowCompassTrackingToggle = this.allowCompassTrackingToggle;
        copy.allowCreatingMapMarkers = this.allowCreatingMapMarkers;
        copy.allowRemovingOtherPlayersMarkers = this.allowRemovingOtherPlayersMarkers;
        copy.defaultScale = this.defaultScale;
        copy.minScale = this.minScale;
        copy.maxScale = this.maxScale;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateWorldMapSettings other)) return false;
        return this.enabled == other.enabled && this.allowTeleportToCoordinates == other.allowTeleportToCoordinates && this.allowTeleportToMarkers == other.allowTeleportToMarkers && this.allowShowOnMapToggle == other.allowShowOnMapToggle && this.allowCompassTrackingToggle == other.allowCompassTrackingToggle && this.allowCreatingMapMarkers == other.allowCreatingMapMarkers && this.allowRemovingOtherPlayersMarkers == other.allowRemovingOtherPlayersMarkers && this.defaultScale == other.defaultScale && this.minScale == other.minScale && this.maxScale == other.maxScale;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(enabled, allowTeleportToCoordinates, allowTeleportToMarkers, allowShowOnMapToggle, allowCompassTrackingToggle, allowCreatingMapMarkers, allowRemovingOtherPlayersMarkers, defaultScale, minScale, maxScale);
    }

}