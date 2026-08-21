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
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateTranslations implements Packet, ToClientPacket {
    public static final int PACKET_ID = 64;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
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
    @Nullable public java.util.Map<String, String> translations;

    public UpdateTranslations() {
    }

    public UpdateTranslations(@Nonnull UpdateType type, @Nullable java.util.Map<String, String> translations) {
        this.type = type;
        this.translations = translations;
    }

    public UpdateTranslations(@Nonnull UpdateTranslations other) {
        this.type = other.type;
        this.translations = other.translations;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateTranslations", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateTranslations", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static java.util.Map<String, String> getTranslations(MemorySegment mem) {
        return getTranslations(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, String> getTranslations(MemorySegment mem, int offset) {
        if (!hasTranslations(mem, offset)) return null;
        var off = offset + 2;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Translations");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Translations", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Translations", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, String> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var valuePacked = VarInt.getWithLength(mem, off);
                var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                off += (int) valuePacked + (int) (valuePacked >>> 32);
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Translations", key);
            }
        }
        return data;
    }
    
    public static boolean hasTranslations(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static UpdateTranslations toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateTranslations toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateTranslations and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateTranslations toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        java.util.Map<String, String> v1 = null;
        if (hasTranslations(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Translations");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Translations", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Translations", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var valuePacked = VarInt.getWithLength(mem, off);
                    var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                    off += (int) valuePacked + (int) (valuePacked >>> 32);
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Translations", key);
                }
            }
            varPos = off - varBase;
        }
        var result = new UpdateTranslations(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.translations != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        var varOffset = offset + 2;
        if (this.translations != null) {
            
            if (this.translations.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Translations", translations.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.translations.size());
            for (var e : this.translations.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getValue(), 4096000);
            }
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        if (translations != null) {
        int translationsSize = 0;
for (var kvp : translations.entrySet()) translationsSize += PacketIO.stringSize(kvp.getKey()) + PacketIO.stringSize(kvp.getValue());
size += VarInt.size(translations.size()) + translationsSize;
    }

        return size;
    }

    public UpdateTranslations clone() {
        UpdateTranslations copy = new UpdateTranslations();
        copy.type = this.type;
        copy.translations = this.translations != null ? new java.util.HashMap<>(this.translations) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateTranslations other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.translations, other.translations);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, translations);
    }

}