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

public class ItemReticleConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 17;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public String[] base;
    @Nullable public java.util.Map<Integer, ItemReticle> serverEvents;
    @Nullable public java.util.Map<ItemReticleClientEvent, ItemReticle> clientEvents;

    public ItemReticleConfig() {
    }

    public ItemReticleConfig(@Nullable String id, @Nullable String[] base, @Nullable java.util.Map<Integer, ItemReticle> serverEvents, @Nullable java.util.Map<ItemReticleClientEvent, ItemReticle> clientEvents) {
        this.id = id;
        this.base = base;
        this.serverEvents = serverEvents;
        this.clientEvents = clientEvents;
    }

    public ItemReticleConfig(@Nonnull ItemReticleConfig other) {
        this.id = other.id;
        this.base = other.base;
        this.serverEvents = other.serverEvents;
        this.clientEvents = other.clientEvents;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemReticleConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 17;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemReticleConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 1, 17, "Id"), 4096000): null;
    }
    
    @Nullable
    public static String[] getBase(MemorySegment mem) {
        return getBase(mem, 0);
    }
    
    @Nullable
    public static String[] getBase(MemorySegment mem, int offset) {
        if (!hasBase(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 5, 17, "Base");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Base");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Base", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Base", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Base", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Integer, ItemReticle> getServerEvents(MemorySegment mem) {
        return getServerEvents(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, ItemReticle> getServerEvents(MemorySegment mem, int offset) {
        if (!hasServerEvents(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 9, 17, "ServerEvents");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ServerEvents");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ServerEvents", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 10 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ServerEvents", (int) java.lang.Math.min(off + (long) len * 10, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, ItemReticle> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var value = ItemReticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ServerEvents", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<ItemReticleClientEvent, ItemReticle> getClientEvents(MemorySegment mem) {
        return getClientEvents(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<ItemReticleClientEvent, ItemReticle> getClientEvents(MemorySegment mem, int offset) {
        if (!hasClientEvents(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 13, 17, "ClientEvents");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ClientEvents");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ClientEvents", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ClientEvents", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<ItemReticleClientEvent, ItemReticle> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = ItemReticleClientEvent.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                off += 1;
            var value = ItemReticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ClientEvents", key);
            }
        }
        return data;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasBase(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasServerEvents(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasClientEvents(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static ItemReticleConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemReticleConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemReticleConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemReticleConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 17;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "Id");
        }
        
        String[] v1 = null;
        if (hasBase(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Base");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Base");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Base", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Base", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v1[i] = PacketIO.readVarString("Base", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Base");
        }
        
        java.util.Map<Integer, ItemReticle> v2 = null;
        if (hasServerEvents(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "ServerEvents");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ServerEvents");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ServerEvents", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 10 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ServerEvents", (int) java.lang.Math.min(off + (long) len * 10, Integer.MAX_VALUE), (int) mem.byteSize());
            v2 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var value = ItemReticle.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v2.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ServerEvents", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 9, -1, "ServerEvents");
        }
        
        java.util.Map<ItemReticleClientEvent, ItemReticle> v3 = null;
        if (hasClientEvents(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "ClientEvents");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ClientEvents");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ClientEvents", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ClientEvents", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
            v3 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = ItemReticleClientEvent.fromValue(mem.get(PacketIO.PROTO_BYTE, off));
                    off += 1;
                var value = ItemReticle.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v3.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ClientEvents", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 13, -1, "ClientEvents");
        }
        var result = new ItemReticleConfig(
            v0,
            v1,
            v2,
            v3
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.base != null) nullBits |= 0x02;
        if (this.serverEvents != null) nullBits |= 0x04;
        if (this.clientEvents != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 17;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 17);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.base != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 17);
            if (base.length > 4096000) throw ProtocolException.arrayTooLong("Base", base.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.base.length);
            
            var baseValueOffset = 0;
            for (var i = 0; i < this.base.length; i++) {
                baseValueOffset += PacketIO.writeVarString(mem, varOffset + baseValueOffset, this.base[i], 4096000);
            }
            varOffset += baseValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.serverEvents != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 17);
            if (this.serverEvents.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ServerEvents", serverEvents.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.serverEvents.size());
            for (var e : this.serverEvents.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.clientEvents != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 17);
            if (this.clientEvents.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ClientEvents", clientEvents.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.clientEvents.size());
            for (var e : this.clientEvents.entrySet()) {
                mem.set(PacketIO.PROTO_BYTE, varOffset, (byte) e.getKey().getValue());
                varOffset += 1;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 17;
        if (id != null) size += PacketIO.stringSize(id);
    if (base != null) {
        int baseSize = 0;
for (var elem : base) baseSize += PacketIO.stringSize(elem);
size += VarInt.size(base.length) + baseSize;
    }
    if (serverEvents != null) {
        int serverEventsSize = 0;
for (var kvp : serverEvents.entrySet()) serverEventsSize += 4 + kvp.getValue().computeSize();
size += VarInt.size(serverEvents.size()) + serverEventsSize;
    }
    if (clientEvents != null) {
        int clientEventsSize = 0;
for (var kvp : clientEvents.entrySet()) clientEventsSize += 1 + kvp.getValue().computeSize();
size += VarInt.size(clientEvents.size()) + clientEventsSize;
    }

        return size;
    }

    public ItemReticleConfig clone() {
        ItemReticleConfig copy = new ItemReticleConfig();
        copy.id = this.id;
        copy.base = this.base != null ? java.util.Arrays.copyOf(this.base, this.base.length) : null;
        if (this.serverEvents != null) {
            java.util.Map<Integer, ItemReticle> m = new java.util.HashMap<>();
            for (var e : this.serverEvents.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.serverEvents = m;
        }
        if (this.clientEvents != null) {
            java.util.Map<ItemReticleClientEvent, ItemReticle> m = new java.util.HashMap<>();
            for (var e : this.clientEvents.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.clientEvents = m;
        }
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemReticleConfig other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Arrays.equals(this.base, other.base) && java.util.Objects.equals(this.serverEvents, other.serverEvents) && java.util.Objects.equals(this.clientEvents, other.clientEvents);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Arrays.hashCode(base);
        result = 31 * result + java.util.Objects.hashCode(serverEvents);
        result = 31 * result + java.util.Objects.hashCode(clientEvents);
        return result;
    }

}