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


public class UpdateMachinimaScene implements Packet, ToServerPacket, ToClientPacket {
    public static final int PACKET_ID = 262;
    public static final boolean IS_COMPRESSED = true;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 18;
    public static final int MAX_SIZE = 36864033;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String player;
    @Nullable public String sceneName;
    public float frame;
    @Nonnull public SceneUpdateType updateType = SceneUpdateType.Update;
    @Nullable public byte[] scene;

    public UpdateMachinimaScene() {
    }

    public UpdateMachinimaScene(@Nullable String player, @Nullable String sceneName, float frame, @Nonnull SceneUpdateType updateType, @Nullable byte[] scene) {
        this.player = player;
        this.sceneName = sceneName;
        this.frame = frame;
        this.updateType = updateType;
        this.scene = scene;
    }

    public UpdateMachinimaScene(@Nonnull UpdateMachinimaScene other) {
        this.player = other.player;
        this.sceneName = other.sceneName;
        this.frame = other.frame;
        this.updateType = other.updateType;
        this.scene = other.scene;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateMachinimaScene", offset, (int) mem.byteSize());
        long needed = (long) offset + 18;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateMachinimaScene", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getPlayer(MemorySegment mem) {
        return getPlayer(mem, 0);
    }
    
    @Nullable
    public static String getPlayer(MemorySegment mem, int offset) {
        return hasPlayer(mem, offset) ? PacketIO.readVarString("Player", mem, offset + getValidatedOffset(mem, offset, 6, 18, "Player"), 4096000): null;
    }
    
    @Nullable
    public static String getSceneName(MemorySegment mem) {
        return getSceneName(mem, 0);
    }
    
    @Nullable
    public static String getSceneName(MemorySegment mem, int offset) {
        return hasSceneName(mem, offset) ? PacketIO.readVarString("SceneName", mem, offset + getValidatedOffset(mem, offset, 10, 18, "SceneName"), 4096000): null;
    }
    
    public static float getFrame(MemorySegment mem) {
        return getFrame(mem, 0);
    }
    
    public static float getFrame(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Frame");
    }
    
    public static SceneUpdateType getUpdateType(MemorySegment mem) {
        return getUpdateType(mem, 0);
    }
    
    public static SceneUpdateType getUpdateType(MemorySegment mem, int offset) {
        return SceneUpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5));
    }
    
    @Nullable
    public static byte[] getScene(MemorySegment mem) {
        return getScene(mem, 0);
    }
    
    @Nullable
    public static byte[] getScene(MemorySegment mem, int offset) {
        if (!hasScene(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 14, 18, "Scene");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Scene");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Scene", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Scene", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new byte[len];
        MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, data, 0, len);
        return data;
    }
    
    public static boolean hasPlayer(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSceneName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasScene(MemorySegment mem, int offset) {
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
    
    public static UpdateMachinimaScene toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateMachinimaScene toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateMachinimaScene and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateMachinimaScene toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 18;
        var varPos = 0;
        String v0 = null;
        if (hasPlayer(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "Player");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Player", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 6, -1, "Player");
        }
        
        String v1 = null;
        if (hasSceneName(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "SceneName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("SceneName", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 10, -1, "SceneName");
        }
        
        byte[] v4 = null;
        if (hasScene(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "Scene");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Scene");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Scene", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Scene", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new byte[len];
            MemorySegment.copy(mem, PacketIO.PROTO_BYTE, off, v4, 0, len);
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 14, -1, "Scene");
        }
        var result = new UpdateMachinimaScene(
            v0,
            v1,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Frame"),
            SceneUpdateType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5)),
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.player != null) nullBits |= 0x01;
        if (this.sceneName != null) nullBits |= 0x02;
        if (this.scene != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.frame, "Frame"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.frame);
        mem.set(PacketIO.PROTO_BYTE, offset + 5, (byte) this.updateType.getValue());
        var varOffset = offset + 18;
        if (this.player != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 18);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.player, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.sceneName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 18);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.sceneName, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.scene != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 18);
            if (scene.length > 4096000) throw ProtocolException.arrayTooLong("Scene", scene.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.scene.length);
            
            MemorySegment.copy(this.scene, 0, mem, PacketIO.PROTO_BYTE, varOffset, this.scene.length);
            varOffset += this.scene.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 18;
        if (player != null) size += PacketIO.stringSize(player);
    if (sceneName != null) size += PacketIO.stringSize(sceneName);
    if (scene != null) size += VarInt.size(scene.length) + scene.length * 1;

        return size;
    }

    public UpdateMachinimaScene clone() {
        UpdateMachinimaScene copy = new UpdateMachinimaScene();
        copy.player = this.player;
        copy.sceneName = this.sceneName;
        copy.frame = this.frame;
        copy.updateType = this.updateType;
        copy.scene = this.scene != null ? java.util.Arrays.copyOf(this.scene, this.scene.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateMachinimaScene other)) return false;
        return java.util.Objects.equals(this.player, other.player) && java.util.Objects.equals(this.sceneName, other.sceneName) && this.frame == other.frame && java.util.Objects.equals(this.updateType, other.updateType) && java.util.Arrays.equals(this.scene, other.scene);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(player);
        result = 31 * result + java.util.Objects.hashCode(sceneName);
        result = 31 * result + Float.hashCode(frame);
        result = 31 * result + java.util.Objects.hashCode(updateType);
        result = 31 * result + java.util.Arrays.hashCode(scene);
        return result;
    }

}