// Auto-generated - do not edit
package meridian.protocol.packets.machinima;

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


public class RequestMachinimaActorModel implements Packet, ToServerPacket {
    public static final int PACKET_ID = 260;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 49152028;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String modelId = "";
    @Nullable public String sceneName;
    @Nullable public String actorName;

    public RequestMachinimaActorModel() {
    }

    public RequestMachinimaActorModel(@Nonnull String modelId, @Nullable String sceneName, @Nullable String actorName) {
        this.modelId = modelId;
        this.sceneName = sceneName;
        this.actorName = actorName;
    }

    public RequestMachinimaActorModel(@Nonnull RequestMachinimaActorModel other) {
        this.modelId = other.modelId;
        this.sceneName = other.sceneName;
        this.actorName = other.actorName;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RequestMachinimaActorModel", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RequestMachinimaActorModel", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getModelId(MemorySegment mem) {
        return getModelId(mem, 0);
    }
    
    public static String getModelId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("ModelId", mem, offset + getValidatedOffset(mem, offset, 1, 13, "ModelId"), 4096000);
    }
    
    @Nullable
    public static String getSceneName(MemorySegment mem) {
        return getSceneName(mem, 0);
    }
    
    @Nullable
    public static String getSceneName(MemorySegment mem, int offset) {
        return hasSceneName(mem, offset) ? PacketIO.readVarString("SceneName", mem, offset + getValidatedOffset(mem, offset, 5, 13, "SceneName"), 4096000): null;
    }
    
    @Nullable
    public static String getActorName(MemorySegment mem) {
        return getActorName(mem, 0);
    }
    
    @Nullable
    public static String getActorName(MemorySegment mem, int offset) {
        return hasActorName(mem, offset) ? PacketIO.readVarString("ActorName", mem, offset + getValidatedOffset(mem, offset, 9, 13, "ActorName"), 4096000): null;
    }
    
    public static boolean hasSceneName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasActorName(MemorySegment mem, int offset) {
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
    
    public static RequestMachinimaActorModel toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RequestMachinimaActorModel toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RequestMachinimaActorModel and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RequestMachinimaActorModel toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        String v0;
        requireSlot(mem, offset + 1, varPos, "ModelId");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ModelId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v1 = null;
        if (hasSceneName(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "SceneName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("SceneName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "SceneName");
        }
        
        String v2 = null;
        if (hasActorName(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "ActorName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("ActorName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "ActorName");
        }
        var result = new RequestMachinimaActorModel(
            v0,
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
        if (this.sceneName != null) nullBits |= 0x01;
        if (this.actorName != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.modelId, 4096000);
        if (this.sceneName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.sceneName, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.actorName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.actorName, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        size += PacketIO.stringSize(modelId);
    if (sceneName != null) size += PacketIO.stringSize(sceneName);
    if (actorName != null) size += PacketIO.stringSize(actorName);

        return size;
    }

    public RequestMachinimaActorModel clone() {
        RequestMachinimaActorModel copy = new RequestMachinimaActorModel();
        copy.modelId = this.modelId;
        copy.sceneName = this.sceneName;
        copy.actorName = this.actorName;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RequestMachinimaActorModel other)) return false;
        return java.util.Objects.equals(this.modelId, other.modelId) && java.util.Objects.equals(this.sceneName, other.sceneName) && java.util.Objects.equals(this.actorName, other.actorName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(modelId, sceneName, actorName);
    }

}