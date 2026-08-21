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
import meridian.protocol.CraftingRecipe;
import meridian.protocol.UpdateType;
import java.util.HashMap;

public class UpdateRecipes implements Packet, ToClientPacket {
    public static final int PACKET_ID = 60;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 10;
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
    @Nullable public java.util.Map<String, CraftingRecipe> recipes;
    @Nullable public String[] removedRecipes;

    public UpdateRecipes() {
    }

    public UpdateRecipes(@Nonnull UpdateType type, @Nullable java.util.Map<String, CraftingRecipe> recipes, @Nullable String[] removedRecipes) {
        this.type = type;
        this.recipes = recipes;
        this.removedRecipes = removedRecipes;
    }

    public UpdateRecipes(@Nonnull UpdateRecipes other) {
        this.type = other.type;
        this.recipes = other.recipes;
        this.removedRecipes = other.removedRecipes;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateRecipes", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateRecipes", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UpdateType getType(MemorySegment mem) {
        return getType(mem, 0);
    }
    
    public static UpdateType getType(MemorySegment mem, int offset) {
        return UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    @Nullable
    public static java.util.Map<String, CraftingRecipe> getRecipes(MemorySegment mem) {
        return getRecipes(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, CraftingRecipe> getRecipes(MemorySegment mem, int offset) {
        if (!hasRecipes(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 2, 10, "Recipes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Recipes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Recipes", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 31 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Recipes", (int) java.lang.Math.min(off + (long) len * 31, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, CraftingRecipe> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = CraftingRecipe.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Recipes", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static String[] getRemovedRecipes(MemorySegment mem) {
        return getRemovedRecipes(mem, 0);
    }
    
    @Nullable
    public static String[] getRemovedRecipes(MemorySegment mem, int offset) {
        if (!hasRemovedRecipes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 6, 10, "RemovedRecipes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("RemovedRecipes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("RemovedRecipes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemovedRecipes", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("RemovedRecipes", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean hasRecipes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasRemovedRecipes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
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
    
    public static UpdateRecipes toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateRecipes toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateRecipes and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateRecipes toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 10;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        java.util.Map<String, CraftingRecipe> v1 = null;
        if (hasRecipes(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "Recipes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Recipes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Recipes", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 31 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Recipes", (int) java.lang.Math.min(off + (long) len * 31, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = CraftingRecipe.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Recipes", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 2, -1, "Recipes");
        }
        
        String[] v2 = null;
        if (hasRemovedRecipes(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "RemovedRecipes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("RemovedRecipes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("RemovedRecipes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemovedRecipes", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v2[i] = PacketIO.readVarString("RemovedRecipes", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "RemovedRecipes");
        }
        var result = new UpdateRecipes(
            UpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.recipes != null) nullBits |= 0x01;
        if (this.removedRecipes != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.type.getValue());
        var varOffset = offset + 10;
        if (this.recipes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 10);
            if (this.recipes.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Recipes", recipes.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.recipes.size());
            for (var e : this.recipes.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.removedRecipes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 10);
            if (removedRecipes.length > 4096000) throw ProtocolException.arrayTooLong("RemovedRecipes", removedRecipes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.removedRecipes.length);
            
            var removedRecipesValueOffset = 0;
            for (var i = 0; i < this.removedRecipes.length; i++) {
                removedRecipesValueOffset += PacketIO.writeVarString(mem, varOffset + removedRecipesValueOffset, this.removedRecipes[i], 4096000);
            }
            varOffset += removedRecipesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 10;
        if (recipes != null) {
        int recipesSize = 0;
for (var kvp : recipes.entrySet()) recipesSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSize();
size += VarInt.size(recipes.size()) + recipesSize;
    }
    if (removedRecipes != null) {
        int removedRecipesSize = 0;
for (var elem : removedRecipes) removedRecipesSize += PacketIO.stringSize(elem);
size += VarInt.size(removedRecipes.length) + removedRecipesSize;
    }

        return size;
    }

    public UpdateRecipes clone() {
        UpdateRecipes copy = new UpdateRecipes();
        copy.type = this.type;
        if (this.recipes != null) {
            java.util.Map<String, CraftingRecipe> m = new java.util.HashMap<>();
            for (var e : this.recipes.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.recipes = m;
        }
        copy.removedRecipes = this.removedRecipes != null ? java.util.Arrays.copyOf(this.removedRecipes, this.removedRecipes.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateRecipes other)) return false;
        return java.util.Objects.equals(this.type, other.type) && java.util.Objects.equals(this.recipes, other.recipes) && java.util.Arrays.equals(this.removedRecipes, other.removedRecipes);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(type);
        result = 31 * result + java.util.Objects.hashCode(recipes);
        result = 31 * result + java.util.Arrays.hashCode(removedRecipes);
        return result;
    }

}