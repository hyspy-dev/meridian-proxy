// Auto-generated - do not edit
package meridian.protocol.packets.entities;

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
import meridian.protocol.ModelParticle;

public class SpawnModelParticles implements Packet, ToClientPacket {
    public static final int PACKET_ID = 165;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int entityId;
    @Nullable public ModelParticle[] modelParticles;

    public SpawnModelParticles() {
    }

    public SpawnModelParticles(int entityId, @Nullable ModelParticle[] modelParticles) {
        this.entityId = entityId;
        this.modelParticles = modelParticles;
    }

    public SpawnModelParticles(@Nonnull SpawnModelParticles other) {
        this.entityId = other.entityId;
        this.modelParticles = other.modelParticles;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SpawnModelParticles", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SpawnModelParticles", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getEntityId(MemorySegment mem) {
        return getEntityId(mem, 0);
    }
    
    public static int getEntityId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static ModelParticle[] getModelParticles(MemorySegment mem) {
        return getModelParticles(mem, 0);
    }
    
    @Nullable
    public static ModelParticle[] getModelParticles(MemorySegment mem, int offset) {
        if (!hasModelParticles(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + 5;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ModelParticles");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ModelParticles", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ModelParticle[len];
        for (var i = 0; i < len; i++) {
            data[i] = ModelParticle.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean hasModelParticles(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static SpawnModelParticles toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SpawnModelParticles toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SpawnModelParticles and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SpawnModelParticles toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 5;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ModelParticle[] v1 = null;
        if (hasModelParticles(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ModelParticles");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ModelParticles", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 42 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelParticles", (int) java.lang.Math.min(off + lenOffset + (long) len * 42, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new ModelParticle[len];
            for (var i = 0; i < len; i++) {
                v1[i] = ModelParticle.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new SpawnModelParticles(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.modelParticles != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.entityId);
        var varOffset = offset + 5;
        if (this.modelParticles != null) {
            
            if (modelParticles.length > 4096000) throw ProtocolException.arrayTooLong("ModelParticles", modelParticles.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.modelParticles.length);
            
            var modelParticlesValueOffset = 0;
            for (var i = 0; i < this.modelParticles.length; i++) {
                modelParticlesValueOffset += this.modelParticles[i].serialize(mem, varOffset + modelParticlesValueOffset);
            }
            varOffset += modelParticlesValueOffset;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 5;
        if (modelParticles != null) {
        int modelParticlesSize = 0;
for (var elem : modelParticles) modelParticlesSize += elem.computeSize();
size += VarInt.size(modelParticles.length) + modelParticlesSize;
    }

        return size;
    }

    public SpawnModelParticles clone() {
        SpawnModelParticles copy = new SpawnModelParticles();
        copy.entityId = this.entityId;
        copy.modelParticles = this.modelParticles != null ? java.util.Arrays.stream(this.modelParticles).map(e -> e.clone()).toArray(ModelParticle[]::new) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SpawnModelParticles other)) return false;
        return this.entityId == other.entityId && java.util.Arrays.equals(this.modelParticles, other.modelParticles);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(entityId);
        result = 31 * result + java.util.Arrays.hashCode(modelParticles);
        return result;
    }

}