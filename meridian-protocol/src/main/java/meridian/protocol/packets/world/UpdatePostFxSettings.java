// Auto-generated - do not edit
package meridian.protocol.packets.world;

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


public class UpdatePostFxSettings implements Packet, ToClientPacket {
    public static final int PACKET_ID = 361;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 20;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 20;
    public static final int MAX_SIZE = 20;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public float globalIntensity;
    public float power;
    public float sunshaftScale;
    public float sunIntensity;
    public float sunshaftIntensity;

    public UpdatePostFxSettings() {
    }

    public UpdatePostFxSettings(float globalIntensity, float power, float sunshaftScale, float sunIntensity, float sunshaftIntensity) {
        this.globalIntensity = globalIntensity;
        this.power = power;
        this.sunshaftScale = sunshaftScale;
        this.sunIntensity = sunIntensity;
        this.sunshaftIntensity = sunshaftIntensity;
    }

    public UpdatePostFxSettings(@Nonnull UpdatePostFxSettings other) {
        this.globalIntensity = other.globalIntensity;
        this.power = other.power;
        this.sunshaftScale = other.sunshaftScale;
        this.sunIntensity = other.sunIntensity;
        this.sunshaftIntensity = other.sunshaftIntensity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdatePostFxSettings", offset, (int) mem.byteSize());
        long needed = (long) offset + 20;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdatePostFxSettings", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static float getGlobalIntensity(MemorySegment mem) {
        return getGlobalIntensity(mem, 0);
    }
    
    public static float getGlobalIntensity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "GlobalIntensity");
    }
    
    public static float getPower(MemorySegment mem) {
        return getPower(mem, 0);
    }
    
    public static float getPower(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Power");
    }
    
    public static float getSunshaftScale(MemorySegment mem) {
        return getSunshaftScale(mem, 0);
    }
    
    public static float getSunshaftScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "SunshaftScale");
    }
    
    public static float getSunIntensity(MemorySegment mem) {
        return getSunIntensity(mem, 0);
    }
    
    public static float getSunIntensity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "SunIntensity");
    }
    
    public static float getSunshaftIntensity(MemorySegment mem) {
        return getSunshaftIntensity(mem, 0);
    }
    
    public static float getSunshaftIntensity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "SunshaftIntensity");
    }
    
    
    
    
    
    public static UpdatePostFxSettings toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdatePostFxSettings toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdatePostFxSettings and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdatePostFxSettings toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new UpdatePostFxSettings(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "GlobalIntensity"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 4), "Power"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 8), "SunshaftScale"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 12), "SunIntensity"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 16), "SunshaftIntensity")
        );
        if (cursor != null) cursor.position = offset + 20;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.globalIntensity, "GlobalIntensity"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.globalIntensity);
        PacketIO.requireFinite(this.power, "Power"); mem.set(PacketIO.PROTO_FLOAT, offset + 4, this.power);
        PacketIO.requireFinite(this.sunshaftScale, "SunshaftScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 8, this.sunshaftScale);
        PacketIO.requireFinite(this.sunIntensity, "SunIntensity"); mem.set(PacketIO.PROTO_FLOAT, offset + 12, this.sunIntensity);
        PacketIO.requireFinite(this.sunshaftIntensity, "SunshaftIntensity"); mem.set(PacketIO.PROTO_FLOAT, offset + 16, this.sunshaftIntensity);
        
        
    
       return 20;
    }
    public int computeSize() {
        return 20;
    }

    public UpdatePostFxSettings clone() {
        UpdatePostFxSettings copy = new UpdatePostFxSettings();
        copy.globalIntensity = this.globalIntensity;
        copy.power = this.power;
        copy.sunshaftScale = this.sunshaftScale;
        copy.sunIntensity = this.sunIntensity;
        copy.sunshaftIntensity = this.sunshaftIntensity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdatePostFxSettings other)) return false;
        return this.globalIntensity == other.globalIntensity && this.power == other.power && this.sunshaftScale == other.sunshaftScale && this.sunIntensity == other.sunIntensity && this.sunshaftIntensity == other.sunshaftIntensity;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(globalIntensity, power, sunshaftScale, sunIntensity, sunshaftIntensity);
    }

}