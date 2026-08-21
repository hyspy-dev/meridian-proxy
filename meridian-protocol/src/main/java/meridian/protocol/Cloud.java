// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import java.util.HashMap;

public class Cloud {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 81920028;

    @Nullable public String texture;
    @Nullable public java.util.Map<Float, Float> speeds;
    @Nullable public java.util.Map<Float, ColorAlpha> colors;

    public Cloud() {
    }

    public Cloud(@Nullable String texture, @Nullable java.util.Map<Float, Float> speeds, @Nullable java.util.Map<Float, ColorAlpha> colors) {
        this.texture = texture;
        this.speeds = speeds;
        this.colors = colors;
    }

    public Cloud(@Nonnull Cloud other) {
        this.texture = other.texture;
        this.speeds = other.speeds;
        this.colors = other.colors;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Cloud", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Cloud", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem) {
        return getTexture(mem, 0);
    }
    
    @Nullable
    public static String getTexture(MemorySegment mem, int offset) {
        return hasTexture(mem, offset) ? PacketIO.readVarString("Texture", mem, offset + getValidatedOffset(mem, offset, 1, 13, "Texture"), 4096000): null;
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getSpeeds(MemorySegment mem) {
        return getSpeeds(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getSpeeds(MemorySegment mem, int offset) {
        if (!hasSpeeds(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 13, "Speeds");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Speeds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Speeds", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Speeds", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Float> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Speeds", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getColors(MemorySegment mem) {
        return getColors(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getColors(MemorySegment mem, int offset) {
        if (!hasColors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 9, 13, "Colors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Colors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Colors", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Colors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, ColorAlpha> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = ColorAlpha.toObject(mem, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Colors", key);
            }
        }
        return data;
    }
    
    public static boolean hasTexture(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSpeeds(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasColors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
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
    
    public static Cloud toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Cloud toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Cloud and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Cloud toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        String v0 = null;
        if (hasTexture(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Texture");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Texture", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "Texture");
        }
        
        java.util.Map<Float, Float> v1 = null;
        if (hasSpeeds(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Speeds");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Speeds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Speeds", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Speeds", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Speeds", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Speeds");
        }
        
        java.util.Map<Float, ColorAlpha> v2 = null;
        if (hasColors(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Colors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Colors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Colors", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Colors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = ColorAlpha.toObject(mem, off);
                    off += 4;
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Colors", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "Colors");
        }
        var result = new Cloud(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.texture != null) nullBits |= 0x01;
        if (this.speeds != null) nullBits |= 0x02;
        if (this.colors != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        if (this.texture != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.texture, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.speeds != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            if (this.speeds.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Speeds", speeds.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.speeds.size());
            for (var e : this.speeds.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.colors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            if (this.colors.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Colors", colors.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.colors.size());
            for (var e : this.colors.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        if (texture != null) size += PacketIO.stringSize(texture);
    if (speeds != null) size += VarInt.size(speeds.size()) + speeds.size() * (4 + 4);
    if (colors != null) size += VarInt.size(colors.size()) + colors.size() * (4 + 4);

        return size;
    }

    public Cloud clone() {
        Cloud copy = new Cloud();
        copy.texture = this.texture;
        copy.speeds = this.speeds != null ? new java.util.HashMap<>(this.speeds) : null;
        if (this.colors != null) {
            java.util.Map<Float, ColorAlpha> m = new java.util.HashMap<>();
            for (var e : this.colors.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.colors = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cloud other)) return false;
        return java.util.Objects.equals(this.texture, other.texture) && java.util.Objects.equals(this.speeds, other.speeds) && java.util.Objects.equals(this.colors, other.colors);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(texture, speeds, colors);
    }

}