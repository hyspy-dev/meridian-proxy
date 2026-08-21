// Auto-generated - do not edit
package meridian.protocol.packets.assets;

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
import meridian.protocol.ProtocolEmote;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateEmotes implements Packet, ToClientPacket {
    public static final int PACKET_ID = 86;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public UpdateType type = UpdateType.Init;
    public int maxId;
    @Nullable public java.util.Map<Integer, ProtocolEmote> emotes;

    public UpdateEmotes() {
    }

    public UpdateEmotes(@Nonnull UpdateType type, int maxId, @Nullable java.util.Map<Integer, ProtocolEmote> emotes) {
        this.type = type;
        this.maxId = maxId;
        this.emotes = emotes;
    }

    public UpdateEmotes(@Nonnull UpdateEmotes other) {
        this.type = other.type;
        this.maxId = other.maxId;
        this.emotes = other.emotes;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateEmotes", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateEmotes", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static int getMaxId(MemorySegment mem) {
        return getMaxId(mem, 0);
    }
    
    public static int getMaxId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    @Nullable
    public static java.util.Map<Integer, ProtocolEmote> getEmotes(MemorySegment mem) {
        return getEmotes(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, ProtocolEmote> getEmotes(MemorySegment mem, int offset) {
        if (!hasEmotes(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 6;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Emotes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Emotes", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Emotes", (int) java.lang.Math.min(off + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, ProtocolEmote> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var value = ProtocolEmote.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Emotes", key);
            }
        }
        return data;
    }
    
    public static boolean hasEmotes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateEmotes toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateEmotes toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateEmotes and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateEmotes toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 6;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<Integer, ProtocolEmote> v2 = null;
        if (hasEmotes(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Emotes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Emotes", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 22 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Emotes", (int) java.lang.Math.min(off + (long) len * 22, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var value = ProtocolEmote.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Emotes", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateEmotes(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.emotes != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 2, this.maxId);
        var varOffset = offset + 6;
        if (this.emotes != null) {
            
            if (this.emotes.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Emotes", emotes.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.emotes.size());
            for (var e : this.emotes.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 6;
        if (emotes != null) {
        int emotesSize = 0;
for (var kvp : emotes.entrySet()) emotesSize += 4 + kvp.getValue().computeSize();
size += VarInt.size(emotes.size()) + emotesSize;
    }

        return size;
    }

    public UpdateEmotes clone() {
        UpdateEmotes copy = new UpdateEmotes();
        copy.type = this.type;
        copy.maxId = this.maxId;
        if (this.emotes != null) {
            java.util.Map<Integer, ProtocolEmote> m = new java.util.HashMap<>();
            for (var e : this.emotes.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.emotes = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateEmotes other)) return false;
        return java.util.Objects.equals(this.type, other.type) && this.maxId == other.maxId && java.util.Objects.equals(this.emotes, other.emotes);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, maxId, emotes);
    }

}