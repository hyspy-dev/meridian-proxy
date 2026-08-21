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


public class CraftingRecipe {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 10;
    public static final int VARIABLE_FIELD_COUNT = 5;
    public static final int VARIABLE_BLOCK_START = 30;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public MaterialQuantity[] inputs;
    @Nullable public MaterialQuantity[] outputs;
    @Nullable public MaterialQuantity primaryOutput;
    @Nullable public BenchRequirement[] benchRequirement;
    public boolean knowledgeRequired;
    public float timeSeconds;
    public int requiredMemoriesLevel;

    public CraftingRecipe() {
    }

    public CraftingRecipe(@Nullable String id, @Nullable MaterialQuantity[] inputs, @Nullable MaterialQuantity[] outputs, @Nullable MaterialQuantity primaryOutput, @Nullable BenchRequirement[] benchRequirement, boolean knowledgeRequired, float timeSeconds, int requiredMemoriesLevel) {
        this.id = id;
        this.inputs = inputs;
        this.outputs = outputs;
        this.primaryOutput = primaryOutput;
        this.benchRequirement = benchRequirement;
        this.knowledgeRequired = knowledgeRequired;
        this.timeSeconds = timeSeconds;
        this.requiredMemoriesLevel = requiredMemoriesLevel;
    }

    public CraftingRecipe(@Nonnull CraftingRecipe other) {
        this.id = other.id;
        this.inputs = other.inputs;
        this.outputs = other.outputs;
        this.primaryOutput = other.primaryOutput;
        this.benchRequirement = other.benchRequirement;
        this.knowledgeRequired = other.knowledgeRequired;
        this.timeSeconds = other.timeSeconds;
        this.requiredMemoriesLevel = other.requiredMemoriesLevel;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CraftingRecipe", offset, (int) mem.byteSize());
        long needed = (long) offset + 30;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CraftingRecipe", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 10, 30, "Id"), 4096000): null;
    }
    
    @Nullable
    public static MaterialQuantity[] getInputs(MemorySegment mem) {
        return getInputs(mem, 0);
    }
    
    @Nullable
    public static MaterialQuantity[] getInputs(MemorySegment mem, int offset) {
        if (!hasInputs(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 14, 30, "Inputs");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Inputs");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Inputs", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Inputs", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new MaterialQuantity[len];
        for (var i = 0; i < len; i++) {
            data[i] = MaterialQuantity.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static MaterialQuantity[] getOutputs(MemorySegment mem) {
        return getOutputs(mem, 0);
    }
    
    @Nullable
    public static MaterialQuantity[] getOutputs(MemorySegment mem, int offset) {
        if (!hasOutputs(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 18, 30, "Outputs");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Outputs");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Outputs", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Outputs", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new MaterialQuantity[len];
        for (var i = 0; i < len; i++) {
            data[i] = MaterialQuantity.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static MaterialQuantity getPrimaryOutput(MemorySegment mem) {
        return getPrimaryOutput(mem, 0);
    }
    
    @Nullable
    public static MaterialQuantity getPrimaryOutput(MemorySegment mem, int offset) {
        return hasPrimaryOutput(mem, offset) ? MaterialQuantity.toObject(mem, offset + getValidatedOffset(mem, offset, 22, 30, "PrimaryOutput")): null;
    }
    
    @Nullable
    public static BenchRequirement[] getBenchRequirement(MemorySegment mem) {
        return getBenchRequirement(mem, 0);
    }
    
    @Nullable
    public static BenchRequirement[] getBenchRequirement(MemorySegment mem, int offset) {
        if (!hasBenchRequirement(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 26, 30, "BenchRequirement");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("BenchRequirement");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("BenchRequirement", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 18 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BenchRequirement", (int) java.lang.Math.min(off + lenOffset + (long) len * 18, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new BenchRequirement[len];
        for (var i = 0; i < len; i++) {
            data[i] = BenchRequirement.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean getKnowledgeRequired(MemorySegment mem) {
        return getKnowledgeRequired(mem, 0);
    }
    
    public static boolean getKnowledgeRequired(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static float getTimeSeconds(MemorySegment mem) {
        return getTimeSeconds(mem, 0);
    }
    
    public static float getTimeSeconds(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "TimeSeconds");
    }
    
    public static int getRequiredMemoriesLevel(MemorySegment mem) {
        return getRequiredMemoriesLevel(mem, 0);
    }
    
    public static int getRequiredMemoriesLevel(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 6);
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasInputs(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasOutputs(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasPrimaryOutput(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasBenchRequirement(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
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
    
    public static CraftingRecipe toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CraftingRecipe toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CraftingRecipe and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CraftingRecipe toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 30;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 10, -1, "Id");
        }
        
        MaterialQuantity[] v1 = null;
        if (hasInputs(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "Inputs");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Inputs");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Inputs", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Inputs", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new MaterialQuantity[len];
            for (var i = 0; i < len; i++) {
                v1[i] = MaterialQuantity.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 14, -1, "Inputs");
        }
        
        MaterialQuantity[] v2 = null;
        if (hasOutputs(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "Outputs");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Outputs");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Outputs", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 17 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Outputs", (int) java.lang.Math.min(off + lenOffset + (long) len * 17, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new MaterialQuantity[len];
            for (var i = 0; i < len; i++) {
                v2[i] = MaterialQuantity.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 18, -1, "Outputs");
        }
        
        MaterialQuantity v3 = null;
        if (hasPrimaryOutput(mem, offset)) {
            requireSlot(mem, offset + 22, varPos, "PrimaryOutput");
            v3 = MaterialQuantity.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 22, -1, "PrimaryOutput");
        }
        
        BenchRequirement[] v4 = null;
        if (hasBenchRequirement(mem, offset)) {
            requireSlot(mem, offset + 26, varPos, "BenchRequirement");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("BenchRequirement");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("BenchRequirement", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 18 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BenchRequirement", (int) java.lang.Math.min(off + lenOffset + (long) len * 18, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new BenchRequirement[len];
            for (var i = 0; i < len; i++) {
                v4[i] = BenchRequirement.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 26, -1, "BenchRequirement");
        }
        var result = new CraftingRecipe(
            v0,
            v1,
            v2,
            v3,
            v4,
            mem.get(PacketIO.PROTO_BOOL, offset + 1),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "TimeSeconds"),
            mem.get(PacketIO.PROTO_INT, offset + 6)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.id != null) nullBits |= 0x01;
        if (this.inputs != null) nullBits |= 0x02;
        if (this.outputs != null) nullBits |= 0x04;
        if (this.primaryOutput != null) nullBits |= 0x08;
        if (this.benchRequirement != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.knowledgeRequired);
        PacketIO.requireFinite(this.timeSeconds, "TimeSeconds"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.timeSeconds);
        mem.set(PacketIO.PROTO_INT, offset + 6, this.requiredMemoriesLevel);
        var varOffset = offset + 30;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 30);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.inputs != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 30);
            if (inputs.length > 4096000) throw ProtocolException.arrayTooLong("Inputs", inputs.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.inputs.length);
            
            var inputsValueOffset = 0;
            for (var i = 0; i < this.inputs.length; i++) {
                inputsValueOffset += this.inputs[i].serialize(mem, varOffset + inputsValueOffset);
            }
            varOffset += inputsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
        if (this.outputs != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 30);
            if (outputs.length > 4096000) throw ProtocolException.arrayTooLong("Outputs", outputs.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.outputs.length);
            
            var outputsValueOffset = 0;
            for (var i = 0; i < this.outputs.length; i++) {
                outputsValueOffset += this.outputs[i].serialize(mem, varOffset + outputsValueOffset);
            }
            varOffset += outputsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
        if (this.primaryOutput != null) {
            mem.set(PacketIO.PROTO_INT, offset + 22, varOffset - offset - 30);
            varOffset += this.primaryOutput.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 22, -1);
        }
        if (this.benchRequirement != null) {
            mem.set(PacketIO.PROTO_INT, offset + 26, varOffset - offset - 30);
            if (benchRequirement.length > 4096000) throw ProtocolException.arrayTooLong("BenchRequirement", benchRequirement.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.benchRequirement.length);
            
            var benchRequirementValueOffset = 0;
            for (var i = 0; i < this.benchRequirement.length; i++) {
                benchRequirementValueOffset += this.benchRequirement[i].serialize(mem, varOffset + benchRequirementValueOffset);
            }
            varOffset += benchRequirementValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 26, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 30;
        if (id != null) size += PacketIO.stringSize(id);
    if (inputs != null) {
        int inputsSize = 0;
for (var elem : inputs) inputsSize += elem.computeSize();
size += VarInt.size(inputs.length) + inputsSize;
    }
    if (outputs != null) {
        int outputsSize = 0;
for (var elem : outputs) outputsSize += elem.computeSize();
size += VarInt.size(outputs.length) + outputsSize;
    }
    if (primaryOutput != null) size += primaryOutput.computeSize();
    if (benchRequirement != null) {
        int benchRequirementSize = 0;
for (var elem : benchRequirement) benchRequirementSize += elem.computeSize();
size += VarInt.size(benchRequirement.length) + benchRequirementSize;
    }

        return size;
    }

    public CraftingRecipe clone() {
        CraftingRecipe copy = new CraftingRecipe();
        copy.id = this.id;
        copy.inputs = this.inputs != null ? java.util.Arrays.stream(this.inputs).map(e -> e.clone()).toArray(MaterialQuantity[]::new) : null;
        copy.outputs = this.outputs != null ? java.util.Arrays.stream(this.outputs).map(e -> e.clone()).toArray(MaterialQuantity[]::new) : null;
        copy.primaryOutput = this.primaryOutput != null ? this.primaryOutput.clone() : null;
        copy.benchRequirement = this.benchRequirement != null ? java.util.Arrays.stream(this.benchRequirement).map(e -> e.clone()).toArray(BenchRequirement[]::new) : null;
        copy.knowledgeRequired = this.knowledgeRequired;
        copy.timeSeconds = this.timeSeconds;
        copy.requiredMemoriesLevel = this.requiredMemoriesLevel;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CraftingRecipe other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Arrays.equals(this.inputs, other.inputs) && java.util.Arrays.equals(this.outputs, other.outputs) && java.util.Objects.equals(this.primaryOutput, other.primaryOutput) && java.util.Arrays.equals(this.benchRequirement, other.benchRequirement) && this.knowledgeRequired == other.knowledgeRequired && this.timeSeconds == other.timeSeconds && this.requiredMemoriesLevel == other.requiredMemoriesLevel;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Arrays.hashCode(inputs);
        result = 31 * result + java.util.Arrays.hashCode(outputs);
        result = 31 * result + java.util.Objects.hashCode(primaryOutput);
        result = 31 * result + java.util.Arrays.hashCode(benchRequirement);
        result = 31 * result + Boolean.hashCode(knowledgeRequired);
        result = 31 * result + Float.hashCode(timeSeconds);
        result = 31 * result + Integer.hashCode(requiredMemoriesLevel);
        return result;
    }

}