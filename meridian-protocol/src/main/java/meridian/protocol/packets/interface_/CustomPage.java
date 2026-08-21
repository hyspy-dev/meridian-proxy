// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

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


public class CustomPage implements Packet, ToClientPacket {
    public static final int PACKET_ID = 218;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 15;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String key;
    public boolean isInitial;
    public boolean clear;
    @Nonnull public CustomPageLifetime lifetime = CustomPageLifetime.CantClose;
    @Nullable public CustomUICommand[] commands;
    @Nullable public CustomUIEventBinding[] eventBindings;

    public CustomPage() {
    }

    public CustomPage(@Nullable String key, boolean isInitial, boolean clear, @Nonnull CustomPageLifetime lifetime, @Nullable CustomUICommand[] commands, @Nullable CustomUIEventBinding[] eventBindings) {
        this.key = key;
        this.isInitial = isInitial;
        this.clear = clear;
        this.lifetime = lifetime;
        this.commands = commands;
        this.eventBindings = eventBindings;
    }

    public CustomPage(@Nonnull CustomPage other) {
        this.key = other.key;
        this.isInitial = other.isInitial;
        this.clear = other.clear;
        this.lifetime = other.lifetime;
        this.commands = other.commands;
        this.eventBindings = other.eventBindings;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CustomPage", offset, (int) mem.byteSize());
        long needed = (long) offset + 15;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CustomPage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getKey(MemorySegment mem) {
        return getKey(mem, 0);
    }
    
    @Nullable
    public static String getKey(MemorySegment mem, int offset) {
        return hasKey(mem, offset) ? PacketIO.readVarString("Key", mem, offset + getValidatedOffset(mem, offset, 3, 15, "Key"), 4096000): null;
    }
    
    public static boolean getIsInitial(MemorySegment mem) {
        return getIsInitial(mem, 0);
    }
    
    public static boolean getIsInitial(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0;
    }
    
    public static boolean getClear(MemorySegment mem) {
        return getClear(mem, 0);
    }
    
    public static boolean getClear(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0;
    }
    
    public static CustomPageLifetime getLifetime(MemorySegment mem) {
        return getLifetime(mem, 0);
    }
    
    public static CustomPageLifetime getLifetime(MemorySegment mem, int offset) {
        return CustomPageLifetime.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    @Nullable
    public static CustomUICommand[] getCommands(MemorySegment mem) {
        return getCommands(mem, 0);
    }
    
    @Nullable
    public static CustomUICommand[] getCommands(MemorySegment mem, int offset) {
        if (!hasCommands(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 7, 15, "Commands");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Commands");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Commands", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 14 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Commands", (int) java.lang.Math.min(off + lenOffset + (long) len * 14, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new CustomUICommand[len];
        for (var i = 0; i < len; i++) {
            data[i] = CustomUICommand.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static CustomUIEventBinding[] getEventBindings(MemorySegment mem) {
        return getEventBindings(mem, 0);
    }
    
    @Nullable
    public static CustomUIEventBinding[] getEventBindings(MemorySegment mem, int offset) {
        if (!hasEventBindings(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 11, 15, "EventBindings");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("EventBindings");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("EventBindings", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 11 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EventBindings", (int) java.lang.Math.min(off + lenOffset + (long) len * 11, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new CustomUIEventBinding[len];
        for (var i = 0; i < len; i++) {
            data[i] = CustomUIEventBinding.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasCommands(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasEventBindings(MemorySegment mem, int offset) {
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
    
    public static CustomPage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CustomPage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CustomPage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CustomPage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 15;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasKey(mem, offset)) {
            requireSlot(mem, offset + 3, varPos, "Key");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Key", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 3, -1, "Key");
        }
        
        CustomUICommand[] v4 = null;
        if (hasCommands(mem, offset)) {
            requireSlot(mem, offset + 7, varPos, "Commands");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Commands");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Commands", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 14 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Commands", (int) java.lang.Math.min(off + lenOffset + (long) len * 14, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new CustomUICommand[len];
            for (var i = 0; i < len; i++) {
                v4[i] = CustomUICommand.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 7, -1, "Commands");
        }
        
        CustomUIEventBinding[] v5 = null;
        if (hasEventBindings(mem, offset)) {
            requireSlot(mem, offset + 11, varPos, "EventBindings");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("EventBindings");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("EventBindings", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 11 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EventBindings", (int) java.lang.Math.min(off + lenOffset + (long) len * 11, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new CustomUIEventBinding[len];
            for (var i = 0; i < len; i++) {
                v5[i] = CustomUIEventBinding.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 11, -1, "EventBindings");
        }
        var result = new CustomPage(
            v0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 1) & 0x02) != 0,
            CustomPageLifetime.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2)),
            v4,
            v5
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.key != null) nullBits |= 0x01;
        if (this.commands != null) nullBits |= 0x02;
        if (this.eventBindings != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        byte boolBits0_0 = 0;
        if (this.isInitial) boolBits0_0 |= 0x01;
        if (this.clear) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 1 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.lifetime.getValue());
        var varOffset = offset + 15;
        if (this.key != null) {
            mem.set(PacketIO.PROTO_INT, offset + 3, varOffset - offset - 15);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.key, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 3, -1);
        }
        if (this.commands != null) {
            mem.set(PacketIO.PROTO_INT, offset + 7, varOffset - offset - 15);
            if (commands.length > 4096000) throw ProtocolException.arrayTooLong("Commands", commands.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.commands.length);
            
            var commandsValueOffset = 0;
            for (var i = 0; i < this.commands.length; i++) {
                commandsValueOffset += this.commands[i].serialize(mem, varOffset + commandsValueOffset);
            }
            varOffset += commandsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 7, -1);
        }
        if (this.eventBindings != null) {
            mem.set(PacketIO.PROTO_INT, offset + 11, varOffset - offset - 15);
            if (eventBindings.length > 4096000) throw ProtocolException.arrayTooLong("EventBindings", eventBindings.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.eventBindings.length);
            
            var eventBindingsValueOffset = 0;
            for (var i = 0; i < this.eventBindings.length; i++) {
                eventBindingsValueOffset += this.eventBindings[i].serialize(mem, varOffset + eventBindingsValueOffset);
            }
            varOffset += eventBindingsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 11, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 15;
        if (key != null) size += PacketIO.stringSize(key);
    if (commands != null) {
        int commandsSize = 0;
for (var elem : commands) commandsSize += elem.computeSize();
size += VarInt.size(commands.length) + commandsSize;
    }
    if (eventBindings != null) {
        int eventBindingsSize = 0;
for (var elem : eventBindings) eventBindingsSize += elem.computeSize();
size += VarInt.size(eventBindings.length) + eventBindingsSize;
    }

        return size;
    }

    public CustomPage clone() {
        CustomPage copy = new CustomPage();
        copy.key = this.key;
        copy.isInitial = this.isInitial;
        copy.clear = this.clear;
        copy.lifetime = this.lifetime;
        copy.commands = this.commands != null ? java.util.Arrays.stream(this.commands).map(e -> e.clone()).toArray(CustomUICommand[]::new) : null;
        copy.eventBindings = this.eventBindings != null ? java.util.Arrays.stream(this.eventBindings).map(e -> e.clone()).toArray(CustomUIEventBinding[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CustomPage other)) return false;
        return java.util.Objects.equals(this.key, other.key) && this.isInitial == other.isInitial && this.clear == other.clear && java.util.Objects.equals(this.lifetime, other.lifetime) && java.util.Arrays.equals(this.commands, other.commands) && java.util.Arrays.equals(this.eventBindings, other.eventBindings);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(key);
        result = 31 * result + Boolean.hashCode(isInitial);
        result = 31 * result + Boolean.hashCode(clear);
        result = 31 * result + java.util.Objects.hashCode(lifetime);
        result = 31 * result + java.util.Arrays.hashCode(commands);
        result = 31 * result + java.util.Arrays.hashCode(eventBindings);
        return result;
    }

}