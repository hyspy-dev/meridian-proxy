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


public class AssetEditorJsonAssetUpdated implements Packet, ToClientPacket {
    public static final int PACKET_ID = 325;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public AssetPath path;
    @Nullable public JsonUpdateCommand[] commands;

    public AssetEditorJsonAssetUpdated() {
    }

    public AssetEditorJsonAssetUpdated(@Nullable AssetPath path, @Nullable JsonUpdateCommand[] commands) {
        this.path = path;
        this.commands = commands;
    }

    public AssetEditorJsonAssetUpdated(@Nonnull AssetEditorJsonAssetUpdated other) {
        this.path = other.path;
        this.commands = other.commands;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorJsonAssetUpdated", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorJsonAssetUpdated", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static AssetPath getPath(MemorySegment mem) {
        return getPath(mem, 0);
    }
    
    @Nullable
    public static AssetPath getPath(MemorySegment mem, int offset) {
        return hasPath(mem, offset) ? AssetPath.toObject(mem, offset + getValidatedOffset(mem, offset, 1, 9, "Path")): null;
    }
    
    @Nullable
    public static JsonUpdateCommand[] getCommands(MemorySegment mem) {
        return getCommands(mem, 0);
    }
    
    @Nullable
    public static JsonUpdateCommand[] getCommands(MemorySegment mem, int offset) {
        if (!hasCommands(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 5, 9, "Commands");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Commands");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Commands", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 19 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Commands", (int) java.lang.Math.min(off + lenOffset + (long) len * 19, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new JsonUpdateCommand[len];
        for (var i = 0; i < len; i++) {
            data[i] = JsonUpdateCommand.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasPath(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasCommands(MemorySegment mem, int offset) {
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
    
    public static AssetEditorJsonAssetUpdated toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorJsonAssetUpdated toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorJsonAssetUpdated and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorJsonAssetUpdated toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetPath v0 = null;
        if (hasPath(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Path");
            v0 = AssetPath.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "Path");
        }
        
        JsonUpdateCommand[] v1 = null;
        if (hasCommands(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Commands");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Commands");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Commands", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 19 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Commands", (int) java.lang.Math.min(off + lenOffset + (long) len * 19, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new JsonUpdateCommand[len];
            for (var i = 0; i < len; i++) {
                v1[i] = JsonUpdateCommand.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Commands");
        }
        var result = new AssetEditorJsonAssetUpdated(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.path != null) nullBits |= 0x01;
        if (this.commands != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.path != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += this.path.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.commands != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            if (commands.length > 4096000) throw ProtocolException.arrayTooLong("Commands", commands.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.commands.length);
            
            var commandsValueOffset = 0;
            for (var i = 0; i < this.commands.length; i++) {
                commandsValueOffset += this.commands[i].serialize(mem, varOffset + commandsValueOffset);
            }
            varOffset += commandsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (path != null) size += path.computeSize();
    if (commands != null) {
        int commandsSize = 0;
for (var elem : commands) commandsSize += elem.computeSize();
size += VarInt.size(commands.length) + commandsSize;
    }

        return size;
    }

    public AssetEditorJsonAssetUpdated clone() {
        AssetEditorJsonAssetUpdated copy = new AssetEditorJsonAssetUpdated();
        copy.path = this.path != null ? this.path.clone() : null;
        copy.commands = this.commands != null ? java.util.Arrays.stream(this.commands).map(e -> e.clone()).toArray(JsonUpdateCommand[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorJsonAssetUpdated other)) return false;
        return java.util.Objects.equals(this.path, other.path) && java.util.Arrays.equals(this.commands, other.commands);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(path);
        result = 31 * result + java.util.Arrays.hashCode(commands);
        return result;
    }

}