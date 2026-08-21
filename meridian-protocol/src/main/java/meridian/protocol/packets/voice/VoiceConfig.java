// Auto-generated - do not edit
package meridian.protocol.packets.voice;

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


public class VoiceConfig implements Packet, ToClientPacket {
    public static final int PACKET_ID = 452;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 17;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 17;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public boolean voiceEnabled;
    @Nonnull public VoiceCodec codec = VoiceCodec.Opus;
    public int sampleRate;
    public byte channels;
    public float maxHearingDistance;
    public float referenceDistance;
    public boolean supportsVoiceStream;
    public byte maxPacketsPerSecond;

    public VoiceConfig() {
    }

    public VoiceConfig(boolean voiceEnabled, @Nonnull VoiceCodec codec, int sampleRate, byte channels, float maxHearingDistance, float referenceDistance, boolean supportsVoiceStream, byte maxPacketsPerSecond) {
        this.voiceEnabled = voiceEnabled;
        this.codec = codec;
        this.sampleRate = sampleRate;
        this.channels = channels;
        this.maxHearingDistance = maxHearingDistance;
        this.referenceDistance = referenceDistance;
        this.supportsVoiceStream = supportsVoiceStream;
        this.maxPacketsPerSecond = maxPacketsPerSecond;
    }

    public VoiceConfig(@Nonnull VoiceConfig other) {
        this.voiceEnabled = other.voiceEnabled;
        this.codec = other.codec;
        this.sampleRate = other.sampleRate;
        this.channels = other.channels;
        this.maxHearingDistance = other.maxHearingDistance;
        this.referenceDistance = other.referenceDistance;
        this.supportsVoiceStream = other.supportsVoiceStream;
        this.maxPacketsPerSecond = other.maxPacketsPerSecond;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("VoiceConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("VoiceConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getVoiceEnabled(MemorySegment mem) {
        return getVoiceEnabled(mem, 0);
    }
    
    public static boolean getVoiceEnabled(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 0);
    }
    
    public static VoiceCodec getCodec(MemorySegment mem) {
        return getCodec(mem, 0);
    }
    
    public static VoiceCodec getCodec(MemorySegment mem, int offset) {
        return VoiceCodec.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static int getSampleRate(MemorySegment mem) {
        return getSampleRate(mem, 0);
    }
    
    public static int getSampleRate(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    public static byte getChannels(MemorySegment mem) {
        return getChannels(mem, 0);
    }
    
    public static byte getChannels(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 6);
    }
    
    public static float getMaxHearingDistance(MemorySegment mem) {
        return getMaxHearingDistance(mem, 0);
    }
    
    public static float getMaxHearingDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 7), "MaxHearingDistance");
    }
    
    public static float getReferenceDistance(MemorySegment mem) {
        return getReferenceDistance(mem, 0);
    }
    
    public static float getReferenceDistance(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 11), "ReferenceDistance");
    }
    
    public static boolean getSupportsVoiceStream(MemorySegment mem) {
        return getSupportsVoiceStream(mem, 0);
    }
    
    public static boolean getSupportsVoiceStream(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 15);
    }
    
    public static byte getMaxPacketsPerSecond(MemorySegment mem) {
        return getMaxPacketsPerSecond(mem, 0);
    }
    
    public static byte getMaxPacketsPerSecond(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BYTE, offset + 16);
    }
    
    
    
    
    
    public static VoiceConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static VoiceConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one VoiceConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static VoiceConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new VoiceConfig(
            mem.get(PacketIO.PROTO_BOOL, offset + 0),
            VoiceCodec.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            mem.get(PacketIO.PROTO_BYTE, offset + 6),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 7), "MaxHearingDistance"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 11), "ReferenceDistance"),
            mem.get(PacketIO.PROTO_BOOL, offset + 15),
            mem.get(PacketIO.PROTO_BYTE, offset + 16)
        );
        if (cursor != null) cursor.position = offset + 17;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BOOL, offset + 0, this.voiceEnabled);
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.codec.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 2, this.sampleRate);
        mem.set(PacketIO.PROTO_BYTE, offset + 6, this.channels);
        PacketIO.requireFinite(this.maxHearingDistance, "MaxHearingDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 7, this.maxHearingDistance);
        PacketIO.requireFinite(this.referenceDistance, "ReferenceDistance"); mem.set(PacketIO.PROTO_FLOAT, offset + 11, this.referenceDistance);
        mem.set(PacketIO.PROTO_BOOL, offset + 15, this.supportsVoiceStream);
        mem.set(PacketIO.PROTO_BYTE, offset + 16, this.maxPacketsPerSecond);
        
        
    
       return 17;
    }
    public int computeSize() {
        return 17;
    }

    public VoiceConfig clone() {
        VoiceConfig copy = new VoiceConfig();
        copy.voiceEnabled = this.voiceEnabled;
        copy.codec = this.codec;
        copy.sampleRate = this.sampleRate;
        copy.channels = this.channels;
        copy.maxHearingDistance = this.maxHearingDistance;
        copy.referenceDistance = this.referenceDistance;
        copy.supportsVoiceStream = this.supportsVoiceStream;
        copy.maxPacketsPerSecond = this.maxPacketsPerSecond;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof VoiceConfig other)) return false;
        return this.voiceEnabled == other.voiceEnabled && java.util.Objects.equals(this.codec, other.codec) && this.sampleRate == other.sampleRate && this.channels == other.channels && this.maxHearingDistance == other.maxHearingDistance && this.referenceDistance == other.referenceDistance && this.supportsVoiceStream == other.supportsVoiceStream && this.maxPacketsPerSecond == other.maxPacketsPerSecond;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(voiceEnabled, codec, sampleRate, channels, maxHearingDistance, referenceDistance, supportsVoiceStream, maxPacketsPerSecond);
    }

}