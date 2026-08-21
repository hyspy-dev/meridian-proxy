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


public class AmbienceFXConditions {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 100;
    public static final int VARIABLE_FIELD_COUNT = 9;
    public static final int VARIABLE_BLOCK_START = 136;
    public static final int MAX_SIZE = 221184181;

    public boolean never;
    @Nullable public int[] environmentIndices;
    @Nullable public int[] weatherIndices;
    @Nullable public int[] fluidFXIndices;
    public int environmentTagPatternIndex;
    public int weatherTagPatternIndex;
    @Nullable public AmbienceFXBlockSoundSet[] surroundingBlockSoundSets;
    @Nonnull public Range altitude = new Range();
    @Nonnull public Rangeb walls = new Rangeb();
    public boolean roof;
    public int roofMaterialTagPatternIndex;
    public boolean floor;
    @Nonnull public Rangeb sunLightLevel = new Rangeb();
    @Nonnull public Rangeb torchLightLevel = new Rangeb();
    @Nonnull public Rangeb globalLightLevel = new Rangeb();
    @Nonnull public Rangef dayTime = new Rangef();
    @Nullable public SpaceSize[] space;
    @Nullable public ShelterType[] shelter;
    @Nullable public SurfaceType[] surfaces;
    @Nonnull public RoofState roofState = RoofState.Any;
    @Nullable public Rangef spaceScaleRange;
    @Nullable public Rangef spaceScaleMinRange;
    @Nullable public Rangef spaceScaleMaxRange;
    @Nullable public Rangef escapedRayPercentRange;
    @Nullable public Rangef reflectionCoeffRange;
    @Nullable public Rangef absorptionCoeffRange;
    @Nullable public Rangef roofDistanceRange;
    @Nullable public AmbienceFXPhysicalMaterial[] surfacePhysicalMaterials;
    public boolean surfacePhysicalMaterialsMatchAny;
    @Nullable public AmbienceFXPhysicalMaterial[] exteriorRoofPhysicalMaterials;
    public boolean exteriorRoofPhysicalMaterialsMatchAny;

    public AmbienceFXConditions() {
    }

    public AmbienceFXConditions(boolean never, @Nullable int[] environmentIndices, @Nullable int[] weatherIndices, @Nullable int[] fluidFXIndices, int environmentTagPatternIndex, int weatherTagPatternIndex, @Nullable AmbienceFXBlockSoundSet[] surroundingBlockSoundSets, @Nonnull Range altitude, @Nonnull Rangeb walls, boolean roof, int roofMaterialTagPatternIndex, boolean floor, @Nonnull Rangeb sunLightLevel, @Nonnull Rangeb torchLightLevel, @Nonnull Rangeb globalLightLevel, @Nonnull Rangef dayTime, @Nullable SpaceSize[] space, @Nullable ShelterType[] shelter, @Nullable SurfaceType[] surfaces, @Nonnull RoofState roofState, @Nullable Rangef spaceScaleRange, @Nullable Rangef spaceScaleMinRange, @Nullable Rangef spaceScaleMaxRange, @Nullable Rangef escapedRayPercentRange, @Nullable Rangef reflectionCoeffRange, @Nullable Rangef absorptionCoeffRange, @Nullable Rangef roofDistanceRange, @Nullable AmbienceFXPhysicalMaterial[] surfacePhysicalMaterials, boolean surfacePhysicalMaterialsMatchAny, @Nullable AmbienceFXPhysicalMaterial[] exteriorRoofPhysicalMaterials, boolean exteriorRoofPhysicalMaterialsMatchAny) {
        this.never = never;
        this.environmentIndices = environmentIndices;
        this.weatherIndices = weatherIndices;
        this.fluidFXIndices = fluidFXIndices;
        this.environmentTagPatternIndex = environmentTagPatternIndex;
        this.weatherTagPatternIndex = weatherTagPatternIndex;
        this.surroundingBlockSoundSets = surroundingBlockSoundSets;
        this.altitude = altitude;
        this.walls = walls;
        this.roof = roof;
        this.roofMaterialTagPatternIndex = roofMaterialTagPatternIndex;
        this.floor = floor;
        this.sunLightLevel = sunLightLevel;
        this.torchLightLevel = torchLightLevel;
        this.globalLightLevel = globalLightLevel;
        this.dayTime = dayTime;
        this.space = space;
        this.shelter = shelter;
        this.surfaces = surfaces;
        this.roofState = roofState;
        this.spaceScaleRange = spaceScaleRange;
        this.spaceScaleMinRange = spaceScaleMinRange;
        this.spaceScaleMaxRange = spaceScaleMaxRange;
        this.escapedRayPercentRange = escapedRayPercentRange;
        this.reflectionCoeffRange = reflectionCoeffRange;
        this.absorptionCoeffRange = absorptionCoeffRange;
        this.roofDistanceRange = roofDistanceRange;
        this.surfacePhysicalMaterials = surfacePhysicalMaterials;
        this.surfacePhysicalMaterialsMatchAny = surfacePhysicalMaterialsMatchAny;
        this.exteriorRoofPhysicalMaterials = exteriorRoofPhysicalMaterials;
        this.exteriorRoofPhysicalMaterialsMatchAny = exteriorRoofPhysicalMaterialsMatchAny;
    }

    public AmbienceFXConditions(@Nonnull AmbienceFXConditions other) {
        this.never = other.never;
        this.environmentIndices = other.environmentIndices;
        this.weatherIndices = other.weatherIndices;
        this.fluidFXIndices = other.fluidFXIndices;
        this.environmentTagPatternIndex = other.environmentTagPatternIndex;
        this.weatherTagPatternIndex = other.weatherTagPatternIndex;
        this.surroundingBlockSoundSets = other.surroundingBlockSoundSets;
        this.altitude = other.altitude;
        this.walls = other.walls;
        this.roof = other.roof;
        this.roofMaterialTagPatternIndex = other.roofMaterialTagPatternIndex;
        this.floor = other.floor;
        this.sunLightLevel = other.sunLightLevel;
        this.torchLightLevel = other.torchLightLevel;
        this.globalLightLevel = other.globalLightLevel;
        this.dayTime = other.dayTime;
        this.space = other.space;
        this.shelter = other.shelter;
        this.surfaces = other.surfaces;
        this.roofState = other.roofState;
        this.spaceScaleRange = other.spaceScaleRange;
        this.spaceScaleMinRange = other.spaceScaleMinRange;
        this.spaceScaleMaxRange = other.spaceScaleMaxRange;
        this.escapedRayPercentRange = other.escapedRayPercentRange;
        this.reflectionCoeffRange = other.reflectionCoeffRange;
        this.absorptionCoeffRange = other.absorptionCoeffRange;
        this.roofDistanceRange = other.roofDistanceRange;
        this.surfacePhysicalMaterials = other.surfacePhysicalMaterials;
        this.surfacePhysicalMaterialsMatchAny = other.surfacePhysicalMaterialsMatchAny;
        this.exteriorRoofPhysicalMaterials = other.exteriorRoofPhysicalMaterials;
        this.exteriorRoofPhysicalMaterialsMatchAny = other.exteriorRoofPhysicalMaterialsMatchAny;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AmbienceFXConditions", offset, (int) mem.byteSize());
        long needed = (long) offset + 136;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AmbienceFXConditions", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getNever(MemorySegment mem) {
        return getNever(mem, 0);
    }
    
    public static boolean getNever(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 2);
    }
    
    @Nullable
    public static int[] getEnvironmentIndices(MemorySegment mem) {
        return getEnvironmentIndices(mem, 0);
    }
    
    @Nullable
    public static int[] getEnvironmentIndices(MemorySegment mem, int offset) {
        if (!hasEnvironmentIndices(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 100, 136, "EnvironmentIndices");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("EnvironmentIndices");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("EnvironmentIndices", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EnvironmentIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static int[] getWeatherIndices(MemorySegment mem) {
        return getWeatherIndices(mem, 0);
    }
    
    @Nullable
    public static int[] getWeatherIndices(MemorySegment mem, int offset) {
        if (!hasWeatherIndices(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 104, 136, "WeatherIndices");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("WeatherIndices");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("WeatherIndices", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("WeatherIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static int[] getFluidFXIndices(MemorySegment mem) {
        return getFluidFXIndices(mem, 0);
    }
    
    @Nullable
    public static int[] getFluidFXIndices(MemorySegment mem, int offset) {
        if (!hasFluidFXIndices(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 108, 136, "FluidFXIndices");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FluidFXIndices");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("FluidFXIndices", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FluidFXIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static int getEnvironmentTagPatternIndex(MemorySegment mem) {
        return getEnvironmentTagPatternIndex(mem, 0);
    }
    
    public static int getEnvironmentTagPatternIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 3);
    }
    
    public static int getWeatherTagPatternIndex(MemorySegment mem) {
        return getWeatherTagPatternIndex(mem, 0);
    }
    
    public static int getWeatherTagPatternIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 7);
    }
    
    @Nullable
    public static AmbienceFXBlockSoundSet[] getSurroundingBlockSoundSets(MemorySegment mem) {
        return getSurroundingBlockSoundSets(mem, 0);
    }
    
    @Nullable
    public static AmbienceFXBlockSoundSet[] getSurroundingBlockSoundSets(MemorySegment mem, int offset) {
        if (!hasSurroundingBlockSoundSets(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 112, 136, "SurroundingBlockSoundSets");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SurroundingBlockSoundSets");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("SurroundingBlockSoundSets", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SurroundingBlockSoundSets", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AmbienceFXBlockSoundSet[len];
        for (var i = 0; i < len; i++) {
            data[i] = AmbienceFXBlockSoundSet.toObject(mem, off + i * 13);
        }
        return data;
    }
    
    public static Range getAltitude(MemorySegment mem) {
        return getAltitude(mem, 0);
    }
    
    public static Range getAltitude(MemorySegment mem, int offset) {
        return Range.toObject(mem, offset + 11);
    }
    
    public static Rangeb getWalls(MemorySegment mem) {
        return getWalls(mem, 0);
    }
    
    public static Rangeb getWalls(MemorySegment mem, int offset) {
        return Rangeb.toObject(mem, offset + 19);
    }
    
    public static boolean getRoof(MemorySegment mem) {
        return getRoof(mem, 0);
    }
    
    public static boolean getRoof(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 21);
    }
    
    public static int getRoofMaterialTagPatternIndex(MemorySegment mem) {
        return getRoofMaterialTagPatternIndex(mem, 0);
    }
    
    public static int getRoofMaterialTagPatternIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 22);
    }
    
    public static boolean getFloor(MemorySegment mem) {
        return getFloor(mem, 0);
    }
    
    public static boolean getFloor(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 26);
    }
    
    public static Rangeb getSunLightLevel(MemorySegment mem) {
        return getSunLightLevel(mem, 0);
    }
    
    public static Rangeb getSunLightLevel(MemorySegment mem, int offset) {
        return Rangeb.toObject(mem, offset + 27);
    }
    
    public static Rangeb getTorchLightLevel(MemorySegment mem) {
        return getTorchLightLevel(mem, 0);
    }
    
    public static Rangeb getTorchLightLevel(MemorySegment mem, int offset) {
        return Rangeb.toObject(mem, offset + 29);
    }
    
    public static Rangeb getGlobalLightLevel(MemorySegment mem) {
        return getGlobalLightLevel(mem, 0);
    }
    
    public static Rangeb getGlobalLightLevel(MemorySegment mem, int offset) {
        return Rangeb.toObject(mem, offset + 31);
    }
    
    public static Rangef getDayTime(MemorySegment mem) {
        return getDayTime(mem, 0);
    }
    
    public static Rangef getDayTime(MemorySegment mem, int offset) {
        return Rangef.toObject(mem, offset + 33);
    }
    
    @Nullable
    public static SpaceSize[] getSpace(MemorySegment mem) {
        return getSpace(mem, 0);
    }
    
    @Nullable
    public static SpaceSize[] getSpace(MemorySegment mem, int offset) {
        if (!hasSpace(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 116, 136, "Space");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Space");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Space", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Space", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new SpaceSize[len];
        for (var i = 0; i < len; i++) {
            data[i] = SpaceSize.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    @Nullable
    public static ShelterType[] getShelter(MemorySegment mem) {
        return getShelter(mem, 0);
    }
    
    @Nullable
    public static ShelterType[] getShelter(MemorySegment mem, int offset) {
        if (!hasShelter(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 120, 136, "Shelter");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Shelter");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Shelter", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Shelter", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ShelterType[len];
        for (var i = 0; i < len; i++) {
            data[i] = ShelterType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    @Nullable
    public static SurfaceType[] getSurfaces(MemorySegment mem) {
        return getSurfaces(mem, 0);
    }
    
    @Nullable
    public static SurfaceType[] getSurfaces(MemorySegment mem, int offset) {
        if (!hasSurfaces(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 124, 136, "Surfaces");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Surfaces");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Surfaces", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Surfaces", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new SurfaceType[len];
        for (var i = 0; i < len; i++) {
            data[i] = SurfaceType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
        }
        return data;
    }
    
    public static RoofState getRoofState(MemorySegment mem) {
        return getRoofState(mem, 0);
    }
    
    public static RoofState getRoofState(MemorySegment mem, int offset) {
        return RoofState.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 41));
    }
    
    @Nullable
    public static Rangef getSpaceScaleRange(MemorySegment mem) {
        return getSpaceScaleRange(mem, 0);
    }
    
    @Nullable
    public static Rangef getSpaceScaleRange(MemorySegment mem, int offset) {
        return hasSpaceScaleRange(mem, offset) ? Rangef.toObject(mem, offset + 42): null;
    }
    
    @Nullable
    public static Rangef getSpaceScaleMinRange(MemorySegment mem) {
        return getSpaceScaleMinRange(mem, 0);
    }
    
    @Nullable
    public static Rangef getSpaceScaleMinRange(MemorySegment mem, int offset) {
        return hasSpaceScaleMinRange(mem, offset) ? Rangef.toObject(mem, offset + 50): null;
    }
    
    @Nullable
    public static Rangef getSpaceScaleMaxRange(MemorySegment mem) {
        return getSpaceScaleMaxRange(mem, 0);
    }
    
    @Nullable
    public static Rangef getSpaceScaleMaxRange(MemorySegment mem, int offset) {
        return hasSpaceScaleMaxRange(mem, offset) ? Rangef.toObject(mem, offset + 58): null;
    }
    
    @Nullable
    public static Rangef getEscapedRayPercentRange(MemorySegment mem) {
        return getEscapedRayPercentRange(mem, 0);
    }
    
    @Nullable
    public static Rangef getEscapedRayPercentRange(MemorySegment mem, int offset) {
        return hasEscapedRayPercentRange(mem, offset) ? Rangef.toObject(mem, offset + 66): null;
    }
    
    @Nullable
    public static Rangef getReflectionCoeffRange(MemorySegment mem) {
        return getReflectionCoeffRange(mem, 0);
    }
    
    @Nullable
    public static Rangef getReflectionCoeffRange(MemorySegment mem, int offset) {
        return hasReflectionCoeffRange(mem, offset) ? Rangef.toObject(mem, offset + 74): null;
    }
    
    @Nullable
    public static Rangef getAbsorptionCoeffRange(MemorySegment mem) {
        return getAbsorptionCoeffRange(mem, 0);
    }
    
    @Nullable
    public static Rangef getAbsorptionCoeffRange(MemorySegment mem, int offset) {
        return hasAbsorptionCoeffRange(mem, offset) ? Rangef.toObject(mem, offset + 82): null;
    }
    
    @Nullable
    public static Rangef getRoofDistanceRange(MemorySegment mem) {
        return getRoofDistanceRange(mem, 0);
    }
    
    @Nullable
    public static Rangef getRoofDistanceRange(MemorySegment mem, int offset) {
        return hasRoofDistanceRange(mem, offset) ? Rangef.toObject(mem, offset + 90): null;
    }
    
    @Nullable
    public static AmbienceFXPhysicalMaterial[] getSurfacePhysicalMaterials(MemorySegment mem) {
        return getSurfacePhysicalMaterials(mem, 0);
    }
    
    @Nullable
    public static AmbienceFXPhysicalMaterial[] getSurfacePhysicalMaterials(MemorySegment mem, int offset) {
        if (!hasSurfacePhysicalMaterials(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 128, 136, "SurfacePhysicalMaterials");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SurfacePhysicalMaterials");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("SurfacePhysicalMaterials", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SurfacePhysicalMaterials", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AmbienceFXPhysicalMaterial[len];
        for (var i = 0; i < len; i++) {
            data[i] = AmbienceFXPhysicalMaterial.toObject(mem, off + i * 13);
        }
        return data;
    }
    
    public static boolean getSurfacePhysicalMaterialsMatchAny(MemorySegment mem) {
        return getSurfacePhysicalMaterialsMatchAny(mem, 0);
    }
    
    public static boolean getSurfacePhysicalMaterialsMatchAny(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 98);
    }
    
    @Nullable
    public static AmbienceFXPhysicalMaterial[] getExteriorRoofPhysicalMaterials(MemorySegment mem) {
        return getExteriorRoofPhysicalMaterials(mem, 0);
    }
    
    @Nullable
    public static AmbienceFXPhysicalMaterial[] getExteriorRoofPhysicalMaterials(MemorySegment mem, int offset) {
        if (!hasExteriorRoofPhysicalMaterials(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 132, 136, "ExteriorRoofPhysicalMaterials");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ExteriorRoofPhysicalMaterials");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ExteriorRoofPhysicalMaterials", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ExteriorRoofPhysicalMaterials", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AmbienceFXPhysicalMaterial[len];
        for (var i = 0; i < len; i++) {
            data[i] = AmbienceFXPhysicalMaterial.toObject(mem, off + i * 13);
        }
        return data;
    }
    
    public static boolean getExteriorRoofPhysicalMaterialsMatchAny(MemorySegment mem) {
        return getExteriorRoofPhysicalMaterialsMatchAny(mem, 0);
    }
    
    public static boolean getExteriorRoofPhysicalMaterialsMatchAny(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 99);
    }
    
    public static boolean hasSpaceScaleRange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSpaceScaleMinRange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasSpaceScaleMaxRange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasEscapedRayPercentRange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasReflectionCoeffRange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasAbsorptionCoeffRange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasRoofDistanceRange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasEnvironmentIndices(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasWeatherIndices(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasFluidFXIndices(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasSurroundingBlockSoundSets(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasSpace(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasShelter(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasSurfaces(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasSurfacePhysicalMaterials(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasExteriorRoofPhysicalMaterials(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x80) != 0;
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
    
    public static AmbienceFXConditions toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AmbienceFXConditions toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AmbienceFXConditions and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AmbienceFXConditions toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 136;
        var varPos = 0;
        int[] v1 = null;
        if (hasEnvironmentIndices(mem, offset)) {
            requireSlot(mem, offset + 100, varPos, "EnvironmentIndices");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("EnvironmentIndices");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("EnvironmentIndices", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EnvironmentIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v1, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 100, -1, "EnvironmentIndices");
        }
        
        int[] v2 = null;
        if (hasWeatherIndices(mem, offset)) {
            requireSlot(mem, offset + 104, varPos, "WeatherIndices");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("WeatherIndices");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("WeatherIndices", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("WeatherIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v2, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 104, -1, "WeatherIndices");
        }
        
        int[] v3 = null;
        if (hasFluidFXIndices(mem, offset)) {
            requireSlot(mem, offset + 108, varPos, "FluidFXIndices");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FluidFXIndices");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("FluidFXIndices", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FluidFXIndices", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v3 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v3, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 108, -1, "FluidFXIndices");
        }
        
        AmbienceFXBlockSoundSet[] v6 = null;
        if (hasSurroundingBlockSoundSets(mem, offset)) {
            requireSlot(mem, offset + 112, varPos, "SurroundingBlockSoundSets");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SurroundingBlockSoundSets");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("SurroundingBlockSoundSets", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SurroundingBlockSoundSets", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v6 = new AmbienceFXBlockSoundSet[len];
            for (var i = 0; i < len; i++) {
                v6[i] = AmbienceFXBlockSoundSet.toObject(mem, off + i * 13);
            }
            varPos = off + len * 13 - varBase;
        } else {
            requireSlot(mem, offset + 112, -1, "SurroundingBlockSoundSets");
        }
        
        SpaceSize[] v16 = null;
        if (hasSpace(mem, offset)) {
            requireSlot(mem, offset + 116, varPos, "Space");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Space");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Space", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Space", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v16 = new SpaceSize[len];
            for (var i = 0; i < len; i++) {
                v16[i] = SpaceSize.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 116, -1, "Space");
        }
        
        ShelterType[] v17 = null;
        if (hasShelter(mem, offset)) {
            requireSlot(mem, offset + 120, varPos, "Shelter");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Shelter");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Shelter", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Shelter", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v17 = new ShelterType[len];
            for (var i = 0; i < len; i++) {
                v17[i] = ShelterType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 120, -1, "Shelter");
        }
        
        SurfaceType[] v18 = null;
        if (hasSurfaces(mem, offset)) {
            requireSlot(mem, offset + 124, varPos, "Surfaces");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Surfaces");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Surfaces", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Surfaces", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v18 = new SurfaceType[len];
            for (var i = 0; i < len; i++) {
                v18[i] = SurfaceType.fromValue(mem.get(PacketIO.PROTO_BYTE, off + i * 1));
            }
            varPos = off + len - varBase;
        } else {
            requireSlot(mem, offset + 124, -1, "Surfaces");
        }
        
        AmbienceFXPhysicalMaterial[] v27 = null;
        if (hasSurfacePhysicalMaterials(mem, offset)) {
            requireSlot(mem, offset + 128, varPos, "SurfacePhysicalMaterials");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SurfacePhysicalMaterials");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("SurfacePhysicalMaterials", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SurfacePhysicalMaterials", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v27 = new AmbienceFXPhysicalMaterial[len];
            for (var i = 0; i < len; i++) {
                v27[i] = AmbienceFXPhysicalMaterial.toObject(mem, off + i * 13);
            }
            varPos = off + len * 13 - varBase;
        } else {
            requireSlot(mem, offset + 128, -1, "SurfacePhysicalMaterials");
        }
        
        AmbienceFXPhysicalMaterial[] v29 = null;
        if (hasExteriorRoofPhysicalMaterials(mem, offset)) {
            requireSlot(mem, offset + 132, varPos, "ExteriorRoofPhysicalMaterials");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ExteriorRoofPhysicalMaterials");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ExteriorRoofPhysicalMaterials", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ExteriorRoofPhysicalMaterials", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v29 = new AmbienceFXPhysicalMaterial[len];
            for (var i = 0; i < len; i++) {
                v29[i] = AmbienceFXPhysicalMaterial.toObject(mem, off + i * 13);
            }
            varPos = off + len * 13 - varBase;
        } else {
            requireSlot(mem, offset + 132, -1, "ExteriorRoofPhysicalMaterials");
        }
        var result = new AmbienceFXConditions(
            mem.get(PacketIO.PROTO_BOOL, offset + 2),
            v1,
            v2,
            v3,
            mem.get(PacketIO.PROTO_INT, offset + 3),
            mem.get(PacketIO.PROTO_INT, offset + 7),
            v6,
            Range.toObject(mem, offset + 11),
            Rangeb.toObject(mem, offset + 19),
            mem.get(PacketIO.PROTO_BOOL, offset + 21),
            mem.get(PacketIO.PROTO_INT, offset + 22),
            mem.get(PacketIO.PROTO_BOOL, offset + 26),
            Rangeb.toObject(mem, offset + 27),
            Rangeb.toObject(mem, offset + 29),
            Rangeb.toObject(mem, offset + 31),
            Rangef.toObject(mem, offset + 33),
            v16,
            v17,
            v18,
            RoofState.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 41)),
            hasSpaceScaleRange(mem, offset) ? Rangef.toObject(mem, offset + 42) : null,
            hasSpaceScaleMinRange(mem, offset) ? Rangef.toObject(mem, offset + 50) : null,
            hasSpaceScaleMaxRange(mem, offset) ? Rangef.toObject(mem, offset + 58) : null,
            hasEscapedRayPercentRange(mem, offset) ? Rangef.toObject(mem, offset + 66) : null,
            hasReflectionCoeffRange(mem, offset) ? Rangef.toObject(mem, offset + 74) : null,
            hasAbsorptionCoeffRange(mem, offset) ? Rangef.toObject(mem, offset + 82) : null,
            hasRoofDistanceRange(mem, offset) ? Rangef.toObject(mem, offset + 90) : null,
            v27,
            mem.get(PacketIO.PROTO_BOOL, offset + 98),
            v29,
            mem.get(PacketIO.PROTO_BOOL, offset + 99)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.spaceScaleRange != null) nullBits |= 0x01;
        if (this.spaceScaleMinRange != null) nullBits |= 0x02;
        if (this.spaceScaleMaxRange != null) nullBits |= 0x04;
        if (this.escapedRayPercentRange != null) nullBits |= 0x08;
        if (this.reflectionCoeffRange != null) nullBits |= 0x10;
        if (this.absorptionCoeffRange != null) nullBits |= 0x20;
        if (this.roofDistanceRange != null) nullBits |= 0x40;
        if (this.environmentIndices != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.weatherIndices != null) nullBits |= 0x01;
        if (this.fluidFXIndices != null) nullBits |= 0x02;
        if (this.surroundingBlockSoundSets != null) nullBits |= 0x04;
        if (this.space != null) nullBits |= 0x08;
        if (this.shelter != null) nullBits |= 0x10;
        if (this.surfaces != null) nullBits |= 0x20;
        if (this.surfacePhysicalMaterials != null) nullBits |= 0x40;
        if (this.exteriorRoofPhysicalMaterials != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 2, this.never);
        mem.set(PacketIO.PROTO_INT, offset + 3, this.environmentTagPatternIndex);
        mem.set(PacketIO.PROTO_INT, offset + 7, this.weatherTagPatternIndex);
        this.altitude.serialize(mem, offset + 11);
        this.walls.serialize(mem, offset + 19);
        mem.set(PacketIO.PROTO_BOOL, offset + 21, this.roof);
        mem.set(PacketIO.PROTO_INT, offset + 22, this.roofMaterialTagPatternIndex);
        mem.set(PacketIO.PROTO_BOOL, offset + 26, this.floor);
        this.sunLightLevel.serialize(mem, offset + 27);
        this.torchLightLevel.serialize(mem, offset + 29);
        this.globalLightLevel.serialize(mem, offset + 31);
        this.dayTime.serialize(mem, offset + 33);
        mem.set(PacketIO.PROTO_BYTE, offset + 41, (byte) this.roofState.getValue());
        if (this.spaceScaleRange != null) {
            this.spaceScaleRange.serialize(mem, offset + 42);
        } else {
            mem.asSlice(offset + 42, 8).fill((byte) 0); 
        }
        if (this.spaceScaleMinRange != null) {
            this.spaceScaleMinRange.serialize(mem, offset + 50);
        } else {
            mem.asSlice(offset + 50, 8).fill((byte) 0); 
        }
        if (this.spaceScaleMaxRange != null) {
            this.spaceScaleMaxRange.serialize(mem, offset + 58);
        } else {
            mem.asSlice(offset + 58, 8).fill((byte) 0); 
        }
        if (this.escapedRayPercentRange != null) {
            this.escapedRayPercentRange.serialize(mem, offset + 66);
        } else {
            mem.asSlice(offset + 66, 8).fill((byte) 0); 
        }
        if (this.reflectionCoeffRange != null) {
            this.reflectionCoeffRange.serialize(mem, offset + 74);
        } else {
            mem.asSlice(offset + 74, 8).fill((byte) 0); 
        }
        if (this.absorptionCoeffRange != null) {
            this.absorptionCoeffRange.serialize(mem, offset + 82);
        } else {
            mem.asSlice(offset + 82, 8).fill((byte) 0); 
        }
        if (this.roofDistanceRange != null) {
            this.roofDistanceRange.serialize(mem, offset + 90);
        } else {
            mem.asSlice(offset + 90, 8).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BOOL, offset + 98, this.surfacePhysicalMaterialsMatchAny);
        mem.set(PacketIO.PROTO_BOOL, offset + 99, this.exteriorRoofPhysicalMaterialsMatchAny);
        var varOffset = offset + 136;
        if (this.environmentIndices != null) {
            mem.set(PacketIO.PROTO_INT, offset + 100, varOffset - offset - 136);
            if (environmentIndices.length > 4096000) throw ProtocolException.arrayTooLong("EnvironmentIndices", environmentIndices.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.environmentIndices.length);
            
            MemorySegment.copy(this.environmentIndices, 0, mem, PacketIO.PROTO_INT, varOffset, this.environmentIndices.length);
            varOffset += this.environmentIndices.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 100, -1);
        }
        if (this.weatherIndices != null) {
            mem.set(PacketIO.PROTO_INT, offset + 104, varOffset - offset - 136);
            if (weatherIndices.length > 4096000) throw ProtocolException.arrayTooLong("WeatherIndices", weatherIndices.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.weatherIndices.length);
            
            MemorySegment.copy(this.weatherIndices, 0, mem, PacketIO.PROTO_INT, varOffset, this.weatherIndices.length);
            varOffset += this.weatherIndices.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 104, -1);
        }
        if (this.fluidFXIndices != null) {
            mem.set(PacketIO.PROTO_INT, offset + 108, varOffset - offset - 136);
            if (fluidFXIndices.length > 4096000) throw ProtocolException.arrayTooLong("FluidFXIndices", fluidFXIndices.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.fluidFXIndices.length);
            
            MemorySegment.copy(this.fluidFXIndices, 0, mem, PacketIO.PROTO_INT, varOffset, this.fluidFXIndices.length);
            varOffset += this.fluidFXIndices.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 108, -1);
        }
        if (this.surroundingBlockSoundSets != null) {
            mem.set(PacketIO.PROTO_INT, offset + 112, varOffset - offset - 136);
            if (surroundingBlockSoundSets.length > 4096000) throw ProtocolException.arrayTooLong("SurroundingBlockSoundSets", surroundingBlockSoundSets.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.surroundingBlockSoundSets.length);
            
            var surroundingBlockSoundSetsValueOffset = 0;
            for (var i = 0; i < this.surroundingBlockSoundSets.length; i++) {
                surroundingBlockSoundSetsValueOffset += this.surroundingBlockSoundSets[i].serialize(mem, varOffset + surroundingBlockSoundSetsValueOffset);
            }
            varOffset += surroundingBlockSoundSetsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 112, -1);
        }
        if (this.space != null) {
            mem.set(PacketIO.PROTO_INT, offset + 116, varOffset - offset - 136);
            if (space.length > 4096000) throw ProtocolException.arrayTooLong("Space", space.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.space.length);
            
            for (var i = 0; i < this.space.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.space[i].getValue());
            }
            varOffset += this.space.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 116, -1);
        }
        if (this.shelter != null) {
            mem.set(PacketIO.PROTO_INT, offset + 120, varOffset - offset - 136);
            if (shelter.length > 4096000) throw ProtocolException.arrayTooLong("Shelter", shelter.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.shelter.length);
            
            for (var i = 0; i < this.shelter.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.shelter[i].getValue());
            }
            varOffset += this.shelter.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 120, -1);
        }
        if (this.surfaces != null) {
            mem.set(PacketIO.PROTO_INT, offset + 124, varOffset - offset - 136);
            if (surfaces.length > 4096000) throw ProtocolException.arrayTooLong("Surfaces", surfaces.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.surfaces.length);
            
            for (var i = 0; i < this.surfaces.length; i++) {
                mem.set(PacketIO.PROTO_BYTE, varOffset + i * 1, (byte) this.surfaces[i].getValue());
            }
            varOffset += this.surfaces.length * 1;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 124, -1);
        }
        if (this.surfacePhysicalMaterials != null) {
            mem.set(PacketIO.PROTO_INT, offset + 128, varOffset - offset - 136);
            if (surfacePhysicalMaterials.length > 4096000) throw ProtocolException.arrayTooLong("SurfacePhysicalMaterials", surfacePhysicalMaterials.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.surfacePhysicalMaterials.length);
            
            var surfacePhysicalMaterialsValueOffset = 0;
            for (var i = 0; i < this.surfacePhysicalMaterials.length; i++) {
                surfacePhysicalMaterialsValueOffset += this.surfacePhysicalMaterials[i].serialize(mem, varOffset + surfacePhysicalMaterialsValueOffset);
            }
            varOffset += surfacePhysicalMaterialsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 128, -1);
        }
        if (this.exteriorRoofPhysicalMaterials != null) {
            mem.set(PacketIO.PROTO_INT, offset + 132, varOffset - offset - 136);
            if (exteriorRoofPhysicalMaterials.length > 4096000) throw ProtocolException.arrayTooLong("ExteriorRoofPhysicalMaterials", exteriorRoofPhysicalMaterials.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.exteriorRoofPhysicalMaterials.length);
            
            var exteriorRoofPhysicalMaterialsValueOffset = 0;
            for (var i = 0; i < this.exteriorRoofPhysicalMaterials.length; i++) {
                exteriorRoofPhysicalMaterialsValueOffset += this.exteriorRoofPhysicalMaterials[i].serialize(mem, varOffset + exteriorRoofPhysicalMaterialsValueOffset);
            }
            varOffset += exteriorRoofPhysicalMaterialsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 132, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 136;
        if (environmentIndices != null) size += VarInt.size(environmentIndices.length) + environmentIndices.length * 4;
    if (weatherIndices != null) size += VarInt.size(weatherIndices.length) + weatherIndices.length * 4;
    if (fluidFXIndices != null) size += VarInt.size(fluidFXIndices.length) + fluidFXIndices.length * 4;
    if (surroundingBlockSoundSets != null) size += VarInt.size(surroundingBlockSoundSets.length) + surroundingBlockSoundSets.length * 13;
    if (space != null) size += VarInt.size(space.length) + space.length * 1;
    if (shelter != null) size += VarInt.size(shelter.length) + shelter.length * 1;
    if (surfaces != null) size += VarInt.size(surfaces.length) + surfaces.length * 1;
    if (surfacePhysicalMaterials != null) size += VarInt.size(surfacePhysicalMaterials.length) + surfacePhysicalMaterials.length * 13;
    if (exteriorRoofPhysicalMaterials != null) size += VarInt.size(exteriorRoofPhysicalMaterials.length) + exteriorRoofPhysicalMaterials.length * 13;

        return size;
    }

    public AmbienceFXConditions clone() {
        AmbienceFXConditions copy = new AmbienceFXConditions();
        copy.never = this.never;
        copy.environmentIndices = this.environmentIndices != null ? java.util.Arrays.copyOf(this.environmentIndices, this.environmentIndices.length) : null;
        copy.weatherIndices = this.weatherIndices != null ? java.util.Arrays.copyOf(this.weatherIndices, this.weatherIndices.length) : null;
        copy.fluidFXIndices = this.fluidFXIndices != null ? java.util.Arrays.copyOf(this.fluidFXIndices, this.fluidFXIndices.length) : null;
        copy.environmentTagPatternIndex = this.environmentTagPatternIndex;
        copy.weatherTagPatternIndex = this.weatherTagPatternIndex;
        copy.surroundingBlockSoundSets = this.surroundingBlockSoundSets != null ? java.util.Arrays.stream(this.surroundingBlockSoundSets).map(e -> e.clone()).toArray(AmbienceFXBlockSoundSet[]::new) : null;
        copy.altitude = this.altitude.clone();
        copy.walls = this.walls.clone();
        copy.roof = this.roof;
        copy.roofMaterialTagPatternIndex = this.roofMaterialTagPatternIndex;
        copy.floor = this.floor;
        copy.sunLightLevel = this.sunLightLevel.clone();
        copy.torchLightLevel = this.torchLightLevel.clone();
        copy.globalLightLevel = this.globalLightLevel.clone();
        copy.dayTime = this.dayTime.clone();
        copy.space = this.space != null ? java.util.Arrays.copyOf(this.space, this.space.length) : null;
        copy.shelter = this.shelter != null ? java.util.Arrays.copyOf(this.shelter, this.shelter.length) : null;
        copy.surfaces = this.surfaces != null ? java.util.Arrays.copyOf(this.surfaces, this.surfaces.length) : null;
        copy.roofState = this.roofState;
        copy.spaceScaleRange = this.spaceScaleRange != null ? this.spaceScaleRange.clone() : null;
        copy.spaceScaleMinRange = this.spaceScaleMinRange != null ? this.spaceScaleMinRange.clone() : null;
        copy.spaceScaleMaxRange = this.spaceScaleMaxRange != null ? this.spaceScaleMaxRange.clone() : null;
        copy.escapedRayPercentRange = this.escapedRayPercentRange != null ? this.escapedRayPercentRange.clone() : null;
        copy.reflectionCoeffRange = this.reflectionCoeffRange != null ? this.reflectionCoeffRange.clone() : null;
        copy.absorptionCoeffRange = this.absorptionCoeffRange != null ? this.absorptionCoeffRange.clone() : null;
        copy.roofDistanceRange = this.roofDistanceRange != null ? this.roofDistanceRange.clone() : null;
        copy.surfacePhysicalMaterials = this.surfacePhysicalMaterials != null ? java.util.Arrays.stream(this.surfacePhysicalMaterials).map(e -> e.clone()).toArray(AmbienceFXPhysicalMaterial[]::new) : null;
        copy.surfacePhysicalMaterialsMatchAny = this.surfacePhysicalMaterialsMatchAny;
        copy.exteriorRoofPhysicalMaterials = this.exteriorRoofPhysicalMaterials != null ? java.util.Arrays.stream(this.exteriorRoofPhysicalMaterials).map(e -> e.clone()).toArray(AmbienceFXPhysicalMaterial[]::new) : null;
        copy.exteriorRoofPhysicalMaterialsMatchAny = this.exteriorRoofPhysicalMaterialsMatchAny;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AmbienceFXConditions other)) return false;
        return this.never == other.never && java.util.Arrays.equals(this.environmentIndices, other.environmentIndices) && java.util.Arrays.equals(this.weatherIndices, other.weatherIndices) && java.util.Arrays.equals(this.fluidFXIndices, other.fluidFXIndices) && this.environmentTagPatternIndex == other.environmentTagPatternIndex && this.weatherTagPatternIndex == other.weatherTagPatternIndex && java.util.Arrays.equals(this.surroundingBlockSoundSets, other.surroundingBlockSoundSets) && java.util.Objects.equals(this.altitude, other.altitude) && java.util.Objects.equals(this.walls, other.walls) && this.roof == other.roof && this.roofMaterialTagPatternIndex == other.roofMaterialTagPatternIndex && this.floor == other.floor && java.util.Objects.equals(this.sunLightLevel, other.sunLightLevel) && java.util.Objects.equals(this.torchLightLevel, other.torchLightLevel) && java.util.Objects.equals(this.globalLightLevel, other.globalLightLevel) && java.util.Objects.equals(this.dayTime, other.dayTime) && java.util.Arrays.equals(this.space, other.space) && java.util.Arrays.equals(this.shelter, other.shelter) && java.util.Arrays.equals(this.surfaces, other.surfaces) && java.util.Objects.equals(this.roofState, other.roofState) && java.util.Objects.equals(this.spaceScaleRange, other.spaceScaleRange) && java.util.Objects.equals(this.spaceScaleMinRange, other.spaceScaleMinRange) && java.util.Objects.equals(this.spaceScaleMaxRange, other.spaceScaleMaxRange) && java.util.Objects.equals(this.escapedRayPercentRange, other.escapedRayPercentRange) && java.util.Objects.equals(this.reflectionCoeffRange, other.reflectionCoeffRange) && java.util.Objects.equals(this.absorptionCoeffRange, other.absorptionCoeffRange) && java.util.Objects.equals(this.roofDistanceRange, other.roofDistanceRange) && java.util.Arrays.equals(this.surfacePhysicalMaterials, other.surfacePhysicalMaterials) && this.surfacePhysicalMaterialsMatchAny == other.surfacePhysicalMaterialsMatchAny && java.util.Arrays.equals(this.exteriorRoofPhysicalMaterials, other.exteriorRoofPhysicalMaterials) && this.exteriorRoofPhysicalMaterialsMatchAny == other.exteriorRoofPhysicalMaterialsMatchAny;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Boolean.hashCode(never);
        result = 31 * result + java.util.Arrays.hashCode(environmentIndices);
        result = 31 * result + java.util.Arrays.hashCode(weatherIndices);
        result = 31 * result + java.util.Arrays.hashCode(fluidFXIndices);
        result = 31 * result + Integer.hashCode(environmentTagPatternIndex);
        result = 31 * result + Integer.hashCode(weatherTagPatternIndex);
        result = 31 * result + java.util.Arrays.hashCode(surroundingBlockSoundSets);
        result = 31 * result + java.util.Objects.hashCode(altitude);
        result = 31 * result + java.util.Objects.hashCode(walls);
        result = 31 * result + Boolean.hashCode(roof);
        result = 31 * result + Integer.hashCode(roofMaterialTagPatternIndex);
        result = 31 * result + Boolean.hashCode(floor);
        result = 31 * result + java.util.Objects.hashCode(sunLightLevel);
        result = 31 * result + java.util.Objects.hashCode(torchLightLevel);
        result = 31 * result + java.util.Objects.hashCode(globalLightLevel);
        result = 31 * result + java.util.Objects.hashCode(dayTime);
        result = 31 * result + java.util.Arrays.hashCode(space);
        result = 31 * result + java.util.Arrays.hashCode(shelter);
        result = 31 * result + java.util.Arrays.hashCode(surfaces);
        result = 31 * result + java.util.Objects.hashCode(roofState);
        result = 31 * result + java.util.Objects.hashCode(spaceScaleRange);
        result = 31 * result + java.util.Objects.hashCode(spaceScaleMinRange);
        result = 31 * result + java.util.Objects.hashCode(spaceScaleMaxRange);
        result = 31 * result + java.util.Objects.hashCode(escapedRayPercentRange);
        result = 31 * result + java.util.Objects.hashCode(reflectionCoeffRange);
        result = 31 * result + java.util.Objects.hashCode(absorptionCoeffRange);
        result = 31 * result + java.util.Objects.hashCode(roofDistanceRange);
        result = 31 * result + java.util.Arrays.hashCode(surfacePhysicalMaterials);
        result = 31 * result + Boolean.hashCode(surfacePhysicalMaterialsMatchAny);
        result = 31 * result + java.util.Arrays.hashCode(exteriorRoofPhysicalMaterials);
        result = 31 * result + Boolean.hashCode(exteriorRoofPhysicalMaterialsMatchAny);
        return result;
    }

}