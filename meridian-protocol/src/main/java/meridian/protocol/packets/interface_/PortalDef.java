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


public class PortalDef {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 9;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 16384014;

    @Nullable public String nameKey;
    public int explorationSeconds;
    public int breachSeconds;

    public PortalDef() {
    }

    public PortalDef(@Nullable String nameKey, int explorationSeconds, int breachSeconds) {
        this.nameKey = nameKey;
        this.explorationSeconds = explorationSeconds;
        this.breachSeconds = breachSeconds;
    }

    public PortalDef(@Nonnull PortalDef other) {
        this.nameKey = other.nameKey;
        this.explorationSeconds = other.explorationSeconds;
        this.breachSeconds = other.breachSeconds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PortalDef", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PortalDef", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getNameKey(MemorySegment mem) {
        return getNameKey(mem, 0);
    }
    
    @Nullable
    public static String getNameKey(MemorySegment mem, int offset) {
        return hasNameKey(mem, offset) ? PacketIO.readVarString("NameKey", mem, offset + 9, 4096000): null;
    }
    
    public static int getExplorationSeconds(MemorySegment mem) {
        return getExplorationSeconds(mem, 0);
    }
    
    public static int getExplorationSeconds(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getBreachSeconds(MemorySegment mem) {
        return getBreachSeconds(mem, 0);
    }
    
    public static int getBreachSeconds(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static boolean hasNameKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static PortalDef toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PortalDef toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PortalDef and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PortalDef toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        String v0 = null;
        if (hasNameKey(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("NameKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new PortalDef(
            v0,
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.nameKey != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.explorationSeconds);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.breachSeconds);
        var varOffset = offset + 9;
        if (this.nameKey != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.nameKey, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (nameKey != null) size += PacketIO.stringSize(nameKey);

        return size;
    }

    public PortalDef clone() {
        PortalDef copy = new PortalDef();
        copy.nameKey = this.nameKey;
        copy.explorationSeconds = this.explorationSeconds;
        copy.breachSeconds = this.breachSeconds;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PortalDef other)) return false;
        return java.util.Objects.equals(this.nameKey, other.nameKey) && this.explorationSeconds == other.explorationSeconds && this.breachSeconds == other.breachSeconds;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nameKey, explorationSeconds, breachSeconds);
    }

}