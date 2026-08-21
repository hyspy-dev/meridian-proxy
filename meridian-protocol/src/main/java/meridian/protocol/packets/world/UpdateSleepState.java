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


public class UpdateSleepState implements Packet, ToClientPacket {
    public static final int PACKET_ID = 157;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 35;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 35;
    public static final int MAX_SIZE = 65536049;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public boolean grayFade;
    public boolean sleepUi;
    @Nullable public SleepClock clock;
    @Nullable public SleepMultiplayer multiplayer;

    public UpdateSleepState() {
    }

    public UpdateSleepState(boolean grayFade, boolean sleepUi, @Nullable SleepClock clock, @Nullable SleepMultiplayer multiplayer) {
        this.grayFade = grayFade;
        this.sleepUi = sleepUi;
        this.clock = clock;
        this.multiplayer = multiplayer;
    }

    public UpdateSleepState(@Nonnull UpdateSleepState other) {
        this.grayFade = other.grayFade;
        this.sleepUi = other.sleepUi;
        this.clock = other.clock;
        this.multiplayer = other.multiplayer;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateSleepState", offset, (int) mem.byteSize());
        long needed = (long) offset + 35;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateSleepState", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getGrayFade(MemorySegment mem) {
        return getGrayFade(mem, 0);
    }
    
    public static boolean getGrayFade(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0;
    }
    
    public static boolean getSleepUi(MemorySegment mem) {
        return getSleepUi(mem, 0);
    }
    
    public static boolean getSleepUi(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0;
    }
    
    @Nullable
    public static SleepClock getClock(MemorySegment mem) {
        return getClock(mem, 0);
    }
    
    @Nullable
    public static SleepClock getClock(MemorySegment mem, int offset) {
        return hasClock(mem, offset) ? SleepClock.toObject(mem, offset + 2): null;
    }
    
    @Nullable
    public static SleepMultiplayer getMultiplayer(MemorySegment mem) {
        return getMultiplayer(mem, 0);
    }
    
    @Nullable
    public static SleepMultiplayer getMultiplayer(MemorySegment mem, int offset) {
        return hasMultiplayer(mem, offset) ? SleepMultiplayer.toObject(mem, offset + 35): null;
    }
    
    public static boolean hasClock(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasMultiplayer(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static UpdateSleepState toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateSleepState toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateSleepState and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateSleepState toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 35;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        SleepMultiplayer v3 = null;
        if (hasMultiplayer(mem, offset)) {
            v3 = SleepMultiplayer.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new UpdateSleepState(
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0,
            hasClock(mem, offset) ? SleepClock.toObject(mem, offset + 2) : null,
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.clock != null) nullBits |= 0x01;
        if (this.multiplayer != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        byte boolBits0_0 = 0;
        if (this.grayFade) boolBits0_0 |= 0x01;
        if (this.sleepUi) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 1 + 0, boolBits0_0);
        if (this.clock != null) {
            this.clock.serialize(mem, offset + 2);
        } else {
            mem.asSlice(offset + 2, 33).fill((byte) 0); 
        }
        var varOffset = offset + 35;
        if (this.multiplayer != null) {
            
            varOffset += this.multiplayer.serialize(mem, varOffset);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 35;
        if (multiplayer != null) size += multiplayer.computeSize();

        return size;
    }

    public UpdateSleepState clone() {
        UpdateSleepState copy = new UpdateSleepState();
        copy.grayFade = this.grayFade;
        copy.sleepUi = this.sleepUi;
        copy.clock = this.clock != null ? this.clock.clone() : null;
        copy.multiplayer = this.multiplayer != null ? this.multiplayer.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateSleepState other)) return false;
        return this.grayFade == other.grayFade && this.sleepUi == other.sleepUi && java.util.Objects.equals(this.clock, other.clock) && java.util.Objects.equals(this.multiplayer, other.multiplayer);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(grayFade, sleepUi, clock, multiplayer);
    }

}