// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class RemoveDataContextCollectionItemServersideUIProperty extends ServersideUICommand {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 16384009;

    @Nonnull public String property = "";
    public int index;

    public RemoveDataContextCollectionItemServersideUIProperty() {
    }

    public RemoveDataContextCollectionItemServersideUIProperty(@Nonnull String property, int index) {
        this.property = property;
        this.index = index;
    }

    public RemoveDataContextCollectionItemServersideUIProperty(@Nonnull RemoveDataContextCollectionItemServersideUIProperty other) {
        this.property = other.property;
        this.index = other.index;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RemoveDataContextCollectionItemServersideUIProperty", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemoveDataContextCollectionItemServersideUIProperty", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getProperty(MemorySegment mem) {
        return getProperty(mem, 0);
    }
    
    public static String getProperty(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Property", mem, offset + 4, 4096000);
    }
    
    public static int getIndex(MemorySegment mem) {
        return getIndex(mem, 0);
    }
    
    public static int getIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    
    
    
    
    public static RemoveDataContextCollectionItemServersideUIProperty toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RemoveDataContextCollectionItemServersideUIProperty toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RemoveDataContextCollectionItemServersideUIProperty and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RemoveDataContextCollectionItemServersideUIProperty toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 4;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Property", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new RemoveDataContextCollectionItemServersideUIProperty(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 0)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.index);
        var varOffset = offset + 4;
        varOffset += PacketIO.writeVarString(mem, varOffset, this.property, 4096000);
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 4;
        size += PacketIO.stringSize(property);

        return size;
    }

    public RemoveDataContextCollectionItemServersideUIProperty clone() {
        RemoveDataContextCollectionItemServersideUIProperty copy = new RemoveDataContextCollectionItemServersideUIProperty();
        copy.property = this.property;
        copy.index = this.index;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RemoveDataContextCollectionItemServersideUIProperty other)) return false;
        return java.util.Objects.equals(this.property, other.property) && this.index == other.index;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(property, index);
    }

}