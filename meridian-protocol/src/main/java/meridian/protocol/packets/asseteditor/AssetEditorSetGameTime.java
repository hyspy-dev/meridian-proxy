// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

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
import meridian.protocol.InstantData;

public class AssetEditorSetGameTime implements Packet, ToServerPacket {
    public static final int PACKET_ID = 352;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 14;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 14;
    public static final int MAX_SIZE = 14;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public InstantData gameTime;
    public boolean paused;

    public AssetEditorSetGameTime() {
    }

    public AssetEditorSetGameTime(@Nullable InstantData gameTime, boolean paused) {
        this.gameTime = gameTime;
        this.paused = paused;
    }

    public AssetEditorSetGameTime(@Nonnull AssetEditorSetGameTime other) {
        this.gameTime = other.gameTime;
        this.paused = other.paused;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorSetGameTime", offset, (int) mem.byteSize());
        long needed = (long) offset + 14;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorSetGameTime", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static InstantData getGameTime(MemorySegment mem) {
        return getGameTime(mem, 0);
    }
    
    @Nullable
    public static InstantData getGameTime(MemorySegment mem, int offset) {
        return hasGameTime(mem, offset) ? InstantData.toObject(mem, offset + 1): null;
    }
    
    public static boolean getPaused(MemorySegment mem) {
        return getPaused(mem, 0);
    }
    
    public static boolean getPaused(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 13);
    }
    
    public static boolean hasGameTime(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AssetEditorSetGameTime toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorSetGameTime toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorSetGameTime and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorSetGameTime toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new AssetEditorSetGameTime(
            hasGameTime(mem, offset) ? InstantData.toObject(mem, offset + 1) : null,
            mem.get(PacketIO.PROTO_BOOL, offset + 13)
        );
        if (cursor != null) cursor.position = offset + 14;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.gameTime != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.gameTime != null) {
            this.gameTime.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 13, this.paused);
        
        
    
       return 14;
    }
    public int computeSize() {
        return 14;
    }

    public AssetEditorSetGameTime clone() {
        AssetEditorSetGameTime copy = new AssetEditorSetGameTime();
        copy.gameTime = this.gameTime != null ? this.gameTime.clone() : null;
        copy.paused = this.paused;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorSetGameTime other)) return false;
        return java.util.Objects.equals(this.gameTime, other.gameTime) && this.paused == other.paused;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(gameTime, paused);
    }

}