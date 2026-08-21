// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class BuilderToolState {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 10;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    public boolean isBrush;
    @Nullable public BuilderToolArg[] args;

    public BuilderToolState() {
    }

    public BuilderToolState(@Nullable String id, boolean isBrush, @Nullable BuilderToolArg[] args) {
        this.id = id;
        this.isBrush = isBrush;
        this.args = args;
    }

    public BuilderToolState(@Nonnull BuilderToolState other) {
        this.id = other.id;
        this.isBrush = other.isBrush;
        this.args = other.args;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolState", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolState", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 2, 10, "Id"), 4096000): null;
    }
    
    public static boolean getIsBrush(MemorySegment mem) {
        return getIsBrush(mem, 0);
    }
    
    public static boolean getIsBrush(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    @Nullable
    public static BuilderToolArg[] getArgs(MemorySegment mem) {
        return getArgs(mem, 0);
    }
    
    @Nullable
    public static BuilderToolArg[] getArgs(MemorySegment mem, int offset) {
        if (!hasArgs(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 6, 10, "Args");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Args");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Args", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 53 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Args", (int) java.lang.Math.min(off + lenOffset + (long) len * 53, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new BuilderToolArg[len];
        for (var i = 0; i < len; i++) {
            data[i] = BuilderToolArg.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasArgs(MemorySegment mem, int offset) {
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
    
    public static BuilderToolState toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolState toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolState and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolState toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 10;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 2, -1, "Id");
        }
        
        BuilderToolArg[] v2 = null;
        if (hasArgs(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Args");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Args");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Args", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 53 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Args", (int) java.lang.Math.min(off + lenOffset + (long) len * 53, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new BuilderToolArg[len];
            for (var i = 0; i < len; i++) {
                v2[i] = BuilderToolArg.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 6, -1, "Args");
        }
        var result = new BuilderToolState(
            v0,
            mem.get(PacketIO.PROTO_BOOL, offset + 1),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.args != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.isBrush);
        var varOffset = offset + 10;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 10);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.args != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 10);
            if (args.length > 4096000) throw ProtocolException.arrayTooLong("Args", args.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.args.length);
            
            var argsValueOffset = 0;
            for (var i = 0; i < this.args.length; i++) {
                argsValueOffset += this.args[i].serialize(mem, varOffset + argsValueOffset);
            }
            varOffset += argsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 10;
        if (id != null) size += PacketIO.stringSize(id);
    if (args != null) {
        int argsSize = 0;
for (var elem : args) argsSize += elem.computeSize();
size += VarInt.size(args.length) + argsSize;
    }

        return size;
    }

    public BuilderToolState clone() {
        BuilderToolState copy = new BuilderToolState();
        copy.id = this.id;
        copy.isBrush = this.isBrush;
        copy.args = this.args != null ? java.util.Arrays.stream(this.args).map(e -> e.clone()).toArray(BuilderToolArg[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolState other)) return false;
        return java.util.Objects.equals(this.id, other.id) && this.isBrush == other.isBrush && java.util.Arrays.equals(this.args, other.args);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + Boolean.hashCode(isBrush);
        result = 31 * result + java.util.Arrays.hashCode(args);
        return result;
    }

}