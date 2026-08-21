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
import java.util.HashMap;

public class Weather {
    public static final int NULLABLE_BIT_FIELD_SIZE = 4;
    public static final int FIXED_BLOCK_SIZE = 30;
    public static final int VARIABLE_FIELD_COUNT = 24;
    public static final int VARIABLE_BLOCK_START = 126;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String id;
    @Nullable public int[] tagIndexes;
    @Nullable public String stars;
    @Nullable public java.util.Map<Integer, String> moons;
    @Nullable public Cloud[] clouds;
    @Nullable public java.util.Map<Float, Float> sunlightDampingMultiplier;
    @Nullable public java.util.Map<Float, Color> sunlightColors;
    @Nullable public java.util.Map<Float, ColorAlpha> skyTopColors;
    @Nullable public java.util.Map<Float, ColorAlpha> skyBottomColors;
    @Nullable public java.util.Map<Float, ColorAlpha> skySunsetColors;
    @Nullable public java.util.Map<Float, Color> sunColors;
    @Nullable public java.util.Map<Float, Float> sunScales;
    @Nullable public java.util.Map<Float, ColorAlpha> sunGlowColors;
    @Nullable public java.util.Map<Float, ColorAlpha> moonColors;
    @Nullable public java.util.Map<Float, Float> moonScales;
    @Nullable public java.util.Map<Float, ColorAlpha> moonGlowColors;
    @Nullable public java.util.Map<Float, Color> fogColors;
    @Nullable public java.util.Map<Float, Float> fogHeightFalloffs;
    @Nullable public java.util.Map<Float, Float> fogDensities;
    @Nullable public String screenEffect;
    @Nullable public java.util.Map<Float, ColorAlpha> screenEffectColors;
    @Nullable public java.util.Map<Float, Color> colorFilters;
    @Nullable public java.util.Map<Float, Color> waterTints;
    @Nullable public WeatherParticle particle;
    @Nullable public NearFar fog;
    @Nullable public FogOptions fogOptions;

    public Weather() {
    }

    public Weather(@Nullable String id, @Nullable int[] tagIndexes, @Nullable String stars, @Nullable java.util.Map<Integer, String> moons, @Nullable Cloud[] clouds, @Nullable java.util.Map<Float, Float> sunlightDampingMultiplier, @Nullable java.util.Map<Float, Color> sunlightColors, @Nullable java.util.Map<Float, ColorAlpha> skyTopColors, @Nullable java.util.Map<Float, ColorAlpha> skyBottomColors, @Nullable java.util.Map<Float, ColorAlpha> skySunsetColors, @Nullable java.util.Map<Float, Color> sunColors, @Nullable java.util.Map<Float, Float> sunScales, @Nullable java.util.Map<Float, ColorAlpha> sunGlowColors, @Nullable java.util.Map<Float, ColorAlpha> moonColors, @Nullable java.util.Map<Float, Float> moonScales, @Nullable java.util.Map<Float, ColorAlpha> moonGlowColors, @Nullable java.util.Map<Float, Color> fogColors, @Nullable java.util.Map<Float, Float> fogHeightFalloffs, @Nullable java.util.Map<Float, Float> fogDensities, @Nullable String screenEffect, @Nullable java.util.Map<Float, ColorAlpha> screenEffectColors, @Nullable java.util.Map<Float, Color> colorFilters, @Nullable java.util.Map<Float, Color> waterTints, @Nullable WeatherParticle particle, @Nullable NearFar fog, @Nullable FogOptions fogOptions) {
        this.id = id;
        this.tagIndexes = tagIndexes;
        this.stars = stars;
        this.moons = moons;
        this.clouds = clouds;
        this.sunlightDampingMultiplier = sunlightDampingMultiplier;
        this.sunlightColors = sunlightColors;
        this.skyTopColors = skyTopColors;
        this.skyBottomColors = skyBottomColors;
        this.skySunsetColors = skySunsetColors;
        this.sunColors = sunColors;
        this.sunScales = sunScales;
        this.sunGlowColors = sunGlowColors;
        this.moonColors = moonColors;
        this.moonScales = moonScales;
        this.moonGlowColors = moonGlowColors;
        this.fogColors = fogColors;
        this.fogHeightFalloffs = fogHeightFalloffs;
        this.fogDensities = fogDensities;
        this.screenEffect = screenEffect;
        this.screenEffectColors = screenEffectColors;
        this.colorFilters = colorFilters;
        this.waterTints = waterTints;
        this.particle = particle;
        this.fog = fog;
        this.fogOptions = fogOptions;
    }

    public Weather(@Nonnull Weather other) {
        this.id = other.id;
        this.tagIndexes = other.tagIndexes;
        this.stars = other.stars;
        this.moons = other.moons;
        this.clouds = other.clouds;
        this.sunlightDampingMultiplier = other.sunlightDampingMultiplier;
        this.sunlightColors = other.sunlightColors;
        this.skyTopColors = other.skyTopColors;
        this.skyBottomColors = other.skyBottomColors;
        this.skySunsetColors = other.skySunsetColors;
        this.sunColors = other.sunColors;
        this.sunScales = other.sunScales;
        this.sunGlowColors = other.sunGlowColors;
        this.moonColors = other.moonColors;
        this.moonScales = other.moonScales;
        this.moonGlowColors = other.moonGlowColors;
        this.fogColors = other.fogColors;
        this.fogHeightFalloffs = other.fogHeightFalloffs;
        this.fogDensities = other.fogDensities;
        this.screenEffect = other.screenEffect;
        this.screenEffectColors = other.screenEffectColors;
        this.colorFilters = other.colorFilters;
        this.waterTints = other.waterTints;
        this.particle = other.particle;
        this.fog = other.fog;
        this.fogOptions = other.fogOptions;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("Weather", offset, (int) mem.byteSize());
        long needed = (long) offset + 126;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("Weather", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 30, 126, "Id"), 4096000): null;
    }
    
    @Nullable
    public static int[] getTagIndexes(MemorySegment mem) {
        return getTagIndexes(mem, 0);
    }
    
    @Nullable
    public static int[] getTagIndexes(MemorySegment mem, int offset) {
        if (!hasTagIndexes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 34, 126, "TagIndexes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("TagIndexes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static String getStars(MemorySegment mem) {
        return getStars(mem, 0);
    }
    
    @Nullable
    public static String getStars(MemorySegment mem, int offset) {
        return hasStars(mem, offset) ? PacketIO.readVarString("Stars", mem, offset + getValidatedOffset(mem, offset, 38, 126, "Stars"), 4096000): null;
    }
    
    @Nullable
    public static java.util.Map<Integer, String> getMoons(MemorySegment mem) {
        return getMoons(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Integer, String> getMoons(MemorySegment mem, int offset) {
        if (!hasMoons(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 42, 126, "Moons");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Moons");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Moons", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Moons", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Integer, String> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_INT, off);
                off += 4;
            var valuePacked = VarInt.getWithLength(mem, off);
                var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                off += (int) valuePacked + (int) (valuePacked >>> 32);
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Moons", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static Cloud[] getClouds(MemorySegment mem) {
        return getClouds(mem, 0);
    }
    
    @Nullable
    public static Cloud[] getClouds(MemorySegment mem, int offset) {
        if (!hasClouds(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 46, 126, "Clouds");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Clouds");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Clouds", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Clouds", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new Cloud[len];
        for (var i = 0; i < len; i++) {
            data[i] = Cloud.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getSunlightDampingMultiplier(MemorySegment mem) {
        return getSunlightDampingMultiplier(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getSunlightDampingMultiplier(MemorySegment mem, int offset) {
        if (!hasSunlightDampingMultiplier(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 50, 126, "SunlightDampingMultiplier");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SunlightDampingMultiplier");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SunlightDampingMultiplier", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SunlightDampingMultiplier", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Float> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("SunlightDampingMultiplier", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, Color> getSunlightColors(MemorySegment mem) {
        return getSunlightColors(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Color> getSunlightColors(MemorySegment mem, int offset) {
        if (!hasSunlightColors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 54, 126, "SunlightColors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SunlightColors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SunlightColors", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SunlightColors", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Color> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = Color.toObject(mem, off);
                off += 3;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("SunlightColors", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getSkyTopColors(MemorySegment mem) {
        return getSkyTopColors(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getSkyTopColors(MemorySegment mem, int offset) {
        if (!hasSkyTopColors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 58, 126, "SkyTopColors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SkyTopColors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SkyTopColors", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SkyTopColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, ColorAlpha> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = ColorAlpha.toObject(mem, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("SkyTopColors", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getSkyBottomColors(MemorySegment mem) {
        return getSkyBottomColors(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getSkyBottomColors(MemorySegment mem, int offset) {
        if (!hasSkyBottomColors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 62, 126, "SkyBottomColors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SkyBottomColors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SkyBottomColors", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SkyBottomColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, ColorAlpha> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = ColorAlpha.toObject(mem, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("SkyBottomColors", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getSkySunsetColors(MemorySegment mem) {
        return getSkySunsetColors(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getSkySunsetColors(MemorySegment mem, int offset) {
        if (!hasSkySunsetColors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 66, 126, "SkySunsetColors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SkySunsetColors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SkySunsetColors", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SkySunsetColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, ColorAlpha> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = ColorAlpha.toObject(mem, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("SkySunsetColors", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, Color> getSunColors(MemorySegment mem) {
        return getSunColors(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Color> getSunColors(MemorySegment mem, int offset) {
        if (!hasSunColors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 70, 126, "SunColors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SunColors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SunColors", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SunColors", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Color> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = Color.toObject(mem, off);
                off += 3;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("SunColors", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getSunScales(MemorySegment mem) {
        return getSunScales(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getSunScales(MemorySegment mem, int offset) {
        if (!hasSunScales(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 74, 126, "SunScales");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SunScales");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SunScales", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SunScales", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Float> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("SunScales", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getSunGlowColors(MemorySegment mem) {
        return getSunGlowColors(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getSunGlowColors(MemorySegment mem, int offset) {
        if (!hasSunGlowColors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 78, 126, "SunGlowColors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("SunGlowColors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SunGlowColors", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SunGlowColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, ColorAlpha> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = ColorAlpha.toObject(mem, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("SunGlowColors", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getMoonColors(MemorySegment mem) {
        return getMoonColors(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getMoonColors(MemorySegment mem, int offset) {
        if (!hasMoonColors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 82, 126, "MoonColors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("MoonColors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("MoonColors", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("MoonColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, ColorAlpha> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = ColorAlpha.toObject(mem, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("MoonColors", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getMoonScales(MemorySegment mem) {
        return getMoonScales(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getMoonScales(MemorySegment mem, int offset) {
        if (!hasMoonScales(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 86, 126, "MoonScales");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("MoonScales");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("MoonScales", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("MoonScales", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Float> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("MoonScales", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getMoonGlowColors(MemorySegment mem) {
        return getMoonGlowColors(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getMoonGlowColors(MemorySegment mem, int offset) {
        if (!hasMoonGlowColors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 90, 126, "MoonGlowColors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("MoonGlowColors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("MoonGlowColors", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("MoonGlowColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, ColorAlpha> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = ColorAlpha.toObject(mem, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("MoonGlowColors", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, Color> getFogColors(MemorySegment mem) {
        return getFogColors(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Color> getFogColors(MemorySegment mem, int offset) {
        if (!hasFogColors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 94, 126, "FogColors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FogColors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("FogColors", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FogColors", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Color> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = Color.toObject(mem, off);
                off += 3;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("FogColors", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getFogHeightFalloffs(MemorySegment mem) {
        return getFogHeightFalloffs(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getFogHeightFalloffs(MemorySegment mem, int offset) {
        if (!hasFogHeightFalloffs(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 98, 126, "FogHeightFalloffs");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FogHeightFalloffs");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("FogHeightFalloffs", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FogHeightFalloffs", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Float> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("FogHeightFalloffs", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getFogDensities(MemorySegment mem) {
        return getFogDensities(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Float> getFogDensities(MemorySegment mem, int offset) {
        if (!hasFogDensities(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 102, 126, "FogDensities");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FogDensities");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("FogDensities", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FogDensities", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Float> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("FogDensities", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static String getScreenEffect(MemorySegment mem) {
        return getScreenEffect(mem, 0);
    }
    
    @Nullable
    public static String getScreenEffect(MemorySegment mem, int offset) {
        return hasScreenEffect(mem, offset) ? PacketIO.readVarString("ScreenEffect", mem, offset + getValidatedOffset(mem, offset, 106, 126, "ScreenEffect"), 4096000): null;
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getScreenEffectColors(MemorySegment mem) {
        return getScreenEffectColors(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, ColorAlpha> getScreenEffectColors(MemorySegment mem, int offset) {
        if (!hasScreenEffectColors(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 110, 126, "ScreenEffectColors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ScreenEffectColors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ScreenEffectColors", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ScreenEffectColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, ColorAlpha> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = ColorAlpha.toObject(mem, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ScreenEffectColors", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, Color> getColorFilters(MemorySegment mem) {
        return getColorFilters(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Color> getColorFilters(MemorySegment mem, int offset) {
        if (!hasColorFilters(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 114, 126, "ColorFilters");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ColorFilters");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ColorFilters", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ColorFilters", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Color> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = Color.toObject(mem, off);
                off += 3;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("ColorFilters", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<Float, Color> getWaterTints(MemorySegment mem) {
        return getWaterTints(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<Float, Color> getWaterTints(MemorySegment mem, int offset) {
        if (!hasWaterTints(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 118, 126, "WaterTints");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("WaterTints");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("WaterTints", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("WaterTints", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<Float, Color> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var key = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            var value = Color.toObject(mem, off);
                off += 3;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("WaterTints", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static WeatherParticle getParticle(MemorySegment mem) {
        return getParticle(mem, 0);
    }
    
    @Nullable
    public static WeatherParticle getParticle(MemorySegment mem, int offset) {
        return hasParticle(mem, offset) ? WeatherParticle.toObject(mem, offset + getValidatedOffset(mem, offset, 122, 126, "Particle")): null;
    }
    
    @Nullable
    public static NearFar getFog(MemorySegment mem) {
        return getFog(mem, 0);
    }
    
    @Nullable
    public static NearFar getFog(MemorySegment mem, int offset) {
        return hasFog(mem, offset) ? NearFar.toObject(mem, offset + 4): null;
    }
    
    @Nullable
    public static FogOptions getFogOptions(MemorySegment mem) {
        return getFogOptions(mem, 0);
    }
    
    @Nullable
    public static FogOptions getFogOptions(MemorySegment mem, int offset) {
        return hasFogOptions(mem, offset) ? FogOptions.toObject(mem, offset + 12): null;
    }
    
    public static boolean hasFog(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasFogOptions(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasTagIndexes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasStars(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasMoons(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasClouds(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasSunlightDampingMultiplier(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasSunlightColors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSkyTopColors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasSkyBottomColors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasSkySunsetColors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasSunColors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasSunScales(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasSunGlowColors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasMoonColors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasMoonScales(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasMoonGlowColors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasFogColors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasFogHeightFalloffs(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasFogDensities(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasScreenEffect(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasScreenEffectColors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasColorFilters(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasWaterTints(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasParticle(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 3);
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
    
    public static Weather toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static Weather toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one Weather and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static Weather toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 126;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasId(mem, offset)) {
            requireSlot(mem, offset + 30, varPos, "Id");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 30, -1, "Id");
        }
        
        int[] v1 = null;
        if (hasTagIndexes(mem, offset)) {
            requireSlot(mem, offset + 34, varPos, "TagIndexes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("TagIndexes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v1, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 34, -1, "TagIndexes");
        }
        
        String v2 = null;
        if (hasStars(mem, offset)) {
            requireSlot(mem, offset + 38, varPos, "Stars");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Stars", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 38, -1, "Stars");
        }
        
        java.util.Map<Integer, String> v3 = null;
        if (hasMoons(mem, offset)) {
            requireSlot(mem, offset + 42, varPos, "Moons");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Moons");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Moons", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Moons", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v3 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_INT, off);
                    off += 4;
                var valuePacked = VarInt.getWithLength(mem, off);
                    var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                    off += (int) valuePacked + (int) (valuePacked >>> 32);
                if (v3.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Moons", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 42, -1, "Moons");
        }
        
        Cloud[] v4 = null;
        if (hasClouds(mem, offset)) {
            requireSlot(mem, offset + 46, varPos, "Clouds");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Clouds");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Clouds", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Clouds", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new Cloud[len];
            for (var i = 0; i < len; i++) {
                v4[i] = Cloud.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 46, -1, "Clouds");
        }
        
        java.util.Map<Float, Float> v5 = null;
        if (hasSunlightDampingMultiplier(mem, offset)) {
            requireSlot(mem, offset + 50, varPos, "SunlightDampingMultiplier");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SunlightDampingMultiplier");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SunlightDampingMultiplier", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SunlightDampingMultiplier", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v5 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                if (v5.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("SunlightDampingMultiplier", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 50, -1, "SunlightDampingMultiplier");
        }
        
        java.util.Map<Float, Color> v6 = null;
        if (hasSunlightColors(mem, offset)) {
            requireSlot(mem, offset + 54, varPos, "SunlightColors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SunlightColors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SunlightColors", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SunlightColors", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
            v6 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = Color.toObject(mem, off);
                    off += 3;
                if (v6.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("SunlightColors", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 54, -1, "SunlightColors");
        }
        
        java.util.Map<Float, ColorAlpha> v7 = null;
        if (hasSkyTopColors(mem, offset)) {
            requireSlot(mem, offset + 58, varPos, "SkyTopColors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SkyTopColors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SkyTopColors", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SkyTopColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v7 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = ColorAlpha.toObject(mem, off);
                    off += 4;
                if (v7.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("SkyTopColors", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 58, -1, "SkyTopColors");
        }
        
        java.util.Map<Float, ColorAlpha> v8 = null;
        if (hasSkyBottomColors(mem, offset)) {
            requireSlot(mem, offset + 62, varPos, "SkyBottomColors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SkyBottomColors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SkyBottomColors", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SkyBottomColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v8 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = ColorAlpha.toObject(mem, off);
                    off += 4;
                if (v8.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("SkyBottomColors", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 62, -1, "SkyBottomColors");
        }
        
        java.util.Map<Float, ColorAlpha> v9 = null;
        if (hasSkySunsetColors(mem, offset)) {
            requireSlot(mem, offset + 66, varPos, "SkySunsetColors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SkySunsetColors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SkySunsetColors", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SkySunsetColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v9 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = ColorAlpha.toObject(mem, off);
                    off += 4;
                if (v9.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("SkySunsetColors", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 66, -1, "SkySunsetColors");
        }
        
        java.util.Map<Float, Color> v10 = null;
        if (hasSunColors(mem, offset)) {
            requireSlot(mem, offset + 70, varPos, "SunColors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SunColors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SunColors", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SunColors", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
            v10 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = Color.toObject(mem, off);
                    off += 3;
                if (v10.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("SunColors", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 70, -1, "SunColors");
        }
        
        java.util.Map<Float, Float> v11 = null;
        if (hasSunScales(mem, offset)) {
            requireSlot(mem, offset + 74, varPos, "SunScales");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SunScales");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SunScales", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SunScales", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v11 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                if (v11.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("SunScales", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 74, -1, "SunScales");
        }
        
        java.util.Map<Float, ColorAlpha> v12 = null;
        if (hasSunGlowColors(mem, offset)) {
            requireSlot(mem, offset + 78, varPos, "SunGlowColors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("SunGlowColors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("SunGlowColors", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("SunGlowColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v12 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = ColorAlpha.toObject(mem, off);
                    off += 4;
                if (v12.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("SunGlowColors", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 78, -1, "SunGlowColors");
        }
        
        java.util.Map<Float, ColorAlpha> v13 = null;
        if (hasMoonColors(mem, offset)) {
            requireSlot(mem, offset + 82, varPos, "MoonColors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("MoonColors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("MoonColors", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("MoonColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v13 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = ColorAlpha.toObject(mem, off);
                    off += 4;
                if (v13.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("MoonColors", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 82, -1, "MoonColors");
        }
        
        java.util.Map<Float, Float> v14 = null;
        if (hasMoonScales(mem, offset)) {
            requireSlot(mem, offset + 86, varPos, "MoonScales");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("MoonScales");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("MoonScales", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("MoonScales", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v14 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                if (v14.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("MoonScales", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 86, -1, "MoonScales");
        }
        
        java.util.Map<Float, ColorAlpha> v15 = null;
        if (hasMoonGlowColors(mem, offset)) {
            requireSlot(mem, offset + 90, varPos, "MoonGlowColors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("MoonGlowColors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("MoonGlowColors", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("MoonGlowColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v15 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = ColorAlpha.toObject(mem, off);
                    off += 4;
                if (v15.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("MoonGlowColors", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 90, -1, "MoonGlowColors");
        }
        
        java.util.Map<Float, Color> v16 = null;
        if (hasFogColors(mem, offset)) {
            requireSlot(mem, offset + 94, varPos, "FogColors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FogColors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("FogColors", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FogColors", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
            v16 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = Color.toObject(mem, off);
                    off += 3;
                if (v16.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("FogColors", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 94, -1, "FogColors");
        }
        
        java.util.Map<Float, Float> v17 = null;
        if (hasFogHeightFalloffs(mem, offset)) {
            requireSlot(mem, offset + 98, varPos, "FogHeightFalloffs");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FogHeightFalloffs");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("FogHeightFalloffs", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FogHeightFalloffs", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v17 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                if (v17.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("FogHeightFalloffs", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 98, -1, "FogHeightFalloffs");
        }
        
        java.util.Map<Float, Float> v18 = null;
        if (hasFogDensities(mem, offset)) {
            requireSlot(mem, offset + 102, varPos, "FogDensities");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FogDensities");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("FogDensities", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("FogDensities", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v18 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                if (v18.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("FogDensities", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 102, -1, "FogDensities");
        }
        
        String v19 = null;
        if (hasScreenEffect(mem, offset)) {
            requireSlot(mem, offset + 106, varPos, "ScreenEffect");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v19 = PacketIO.readVarString("ScreenEffect", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 106, -1, "ScreenEffect");
        }
        
        java.util.Map<Float, ColorAlpha> v20 = null;
        if (hasScreenEffectColors(mem, offset)) {
            requireSlot(mem, offset + 110, varPos, "ScreenEffectColors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ScreenEffectColors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ScreenEffectColors", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ScreenEffectColors", (int) java.lang.Math.min(off + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            v20 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = ColorAlpha.toObject(mem, off);
                    off += 4;
                if (v20.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ScreenEffectColors", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 110, -1, "ScreenEffectColors");
        }
        
        java.util.Map<Float, Color> v21 = null;
        if (hasColorFilters(mem, offset)) {
            requireSlot(mem, offset + 114, varPos, "ColorFilters");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ColorFilters");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("ColorFilters", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ColorFilters", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
            v21 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = Color.toObject(mem, off);
                    off += 3;
                if (v21.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("ColorFilters", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 114, -1, "ColorFilters");
        }
        
        java.util.Map<Float, Color> v22 = null;
        if (hasWaterTints(mem, offset)) {
            requireSlot(mem, offset + 118, varPos, "WaterTints");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("WaterTints");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("WaterTints", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 7 > mem.byteSize()) throw ProtocolException.bufferTooSmall("WaterTints", (int) java.lang.Math.min(off + (long) len * 7, Integer.MAX_VALUE), (int) mem.byteSize());
            v22 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var key = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                var value = Color.toObject(mem, off);
                    off += 3;
                if (v22.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("WaterTints", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 118, -1, "WaterTints");
        }
        
        WeatherParticle v23 = null;
        if (hasParticle(mem, offset)) {
            requireSlot(mem, offset + 122, varPos, "Particle");
            v23 = WeatherParticle.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 122, -1, "Particle");
        }
        var result = new Weather(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5,
            v6,
            v7,
            v8,
            v9,
            v10,
            v11,
            v12,
            v13,
            v14,
            v15,
            v16,
            v17,
            v18,
            v19,
            v20,
            v21,
            v22,
            v23,
            hasFog(mem, offset) ? NearFar.toObject(mem, offset + 4) : null,
            hasFogOptions(mem, offset) ? FogOptions.toObject(mem, offset + 12) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.fog != null) nullBits |= 0x01;
        if (this.fogOptions != null) nullBits |= 0x02;
        if (this.id != null) nullBits |= 0x04;
        if (this.tagIndexes != null) nullBits |= 0x08;
        if (this.stars != null) nullBits |= 0x10;
        if (this.moons != null) nullBits |= 0x20;
        if (this.clouds != null) nullBits |= 0x40;
        if (this.sunlightDampingMultiplier != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.sunlightColors != null) nullBits |= 0x01;
        if (this.skyTopColors != null) nullBits |= 0x02;
        if (this.skyBottomColors != null) nullBits |= 0x04;
        if (this.skySunsetColors != null) nullBits |= 0x08;
        if (this.sunColors != null) nullBits |= 0x10;
        if (this.sunScales != null) nullBits |= 0x20;
        if (this.sunGlowColors != null) nullBits |= 0x40;
        if (this.moonColors != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        nullBits = 0;
        if (this.moonScales != null) nullBits |= 0x01;
        if (this.moonGlowColors != null) nullBits |= 0x02;
        if (this.fogColors != null) nullBits |= 0x04;
        if (this.fogHeightFalloffs != null) nullBits |= 0x08;
        if (this.fogDensities != null) nullBits |= 0x10;
        if (this.screenEffect != null) nullBits |= 0x20;
        if (this.screenEffectColors != null) nullBits |= 0x40;
        if (this.colorFilters != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 2, nullBits);
        nullBits = 0;
        if (this.waterTints != null) nullBits |= 0x01;
        if (this.particle != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 3, nullBits);
        
        if (this.fog != null) {
            this.fog.serialize(mem, offset + 4);
        } else {
            mem.asSlice(offset + 4, 8).fill((byte) 0); 
        }
        if (this.fogOptions != null) {
            this.fogOptions.serialize(mem, offset + 12);
        } else {
            mem.asSlice(offset + 12, 18).fill((byte) 0); 
        }
        var varOffset = offset + 126;
        if (this.id != null) {
            mem.set(PacketIO.PROTO_INT, offset + 30, varOffset - offset - 126);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 30, -1);
        }
        if (this.tagIndexes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 126);
            if (tagIndexes.length > 4096000) throw ProtocolException.arrayTooLong("TagIndexes", tagIndexes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tagIndexes.length);
            
            MemorySegment.copy(this.tagIndexes, 0, mem, PacketIO.PROTO_INT, varOffset, this.tagIndexes.length);
            varOffset += this.tagIndexes.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 34, -1);
        }
        if (this.stars != null) {
            mem.set(PacketIO.PROTO_INT, offset + 38, varOffset - offset - 126);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.stars, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 38, -1);
        }
        if (this.moons != null) {
            mem.set(PacketIO.PROTO_INT, offset + 42, varOffset - offset - 126);
            if (this.moons.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Moons", moons.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.moons.size());
            for (var e : this.moons.entrySet()) {
                mem.set(PacketIO.PROTO_INT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getValue(), 4096000);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 42, -1);
        }
        if (this.clouds != null) {
            mem.set(PacketIO.PROTO_INT, offset + 46, varOffset - offset - 126);
            if (clouds.length > 4096000) throw ProtocolException.arrayTooLong("Clouds", clouds.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.clouds.length);
            
            var cloudsValueOffset = 0;
            for (var i = 0; i < this.clouds.length; i++) {
                cloudsValueOffset += this.clouds[i].serialize(mem, varOffset + cloudsValueOffset);
            }
            varOffset += cloudsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 46, -1);
        }
        if (this.sunlightDampingMultiplier != null) {
            mem.set(PacketIO.PROTO_INT, offset + 50, varOffset - offset - 126);
            if (this.sunlightDampingMultiplier.size() > 4096000) throw ProtocolException.dictionaryTooLarge("SunlightDampingMultiplier", sunlightDampingMultiplier.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.sunlightDampingMultiplier.size());
            for (var e : this.sunlightDampingMultiplier.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 50, -1);
        }
        if (this.sunlightColors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 54, varOffset - offset - 126);
            if (this.sunlightColors.size() > 4096000) throw ProtocolException.dictionaryTooLarge("SunlightColors", sunlightColors.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.sunlightColors.size());
            for (var e : this.sunlightColors.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 54, -1);
        }
        if (this.skyTopColors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 58, varOffset - offset - 126);
            if (this.skyTopColors.size() > 4096000) throw ProtocolException.dictionaryTooLarge("SkyTopColors", skyTopColors.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.skyTopColors.size());
            for (var e : this.skyTopColors.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 58, -1);
        }
        if (this.skyBottomColors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 62, varOffset - offset - 126);
            if (this.skyBottomColors.size() > 4096000) throw ProtocolException.dictionaryTooLarge("SkyBottomColors", skyBottomColors.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.skyBottomColors.size());
            for (var e : this.skyBottomColors.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 62, -1);
        }
        if (this.skySunsetColors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 66, varOffset - offset - 126);
            if (this.skySunsetColors.size() > 4096000) throw ProtocolException.dictionaryTooLarge("SkySunsetColors", skySunsetColors.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.skySunsetColors.size());
            for (var e : this.skySunsetColors.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 66, -1);
        }
        if (this.sunColors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 70, varOffset - offset - 126);
            if (this.sunColors.size() > 4096000) throw ProtocolException.dictionaryTooLarge("SunColors", sunColors.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.sunColors.size());
            for (var e : this.sunColors.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 70, -1);
        }
        if (this.sunScales != null) {
            mem.set(PacketIO.PROTO_INT, offset + 74, varOffset - offset - 126);
            if (this.sunScales.size() > 4096000) throw ProtocolException.dictionaryTooLarge("SunScales", sunScales.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.sunScales.size());
            for (var e : this.sunScales.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 74, -1);
        }
        if (this.sunGlowColors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 78, varOffset - offset - 126);
            if (this.sunGlowColors.size() > 4096000) throw ProtocolException.dictionaryTooLarge("SunGlowColors", sunGlowColors.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.sunGlowColors.size());
            for (var e : this.sunGlowColors.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 78, -1);
        }
        if (this.moonColors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 82, varOffset - offset - 126);
            if (this.moonColors.size() > 4096000) throw ProtocolException.dictionaryTooLarge("MoonColors", moonColors.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.moonColors.size());
            for (var e : this.moonColors.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 82, -1);
        }
        if (this.moonScales != null) {
            mem.set(PacketIO.PROTO_INT, offset + 86, varOffset - offset - 126);
            if (this.moonScales.size() > 4096000) throw ProtocolException.dictionaryTooLarge("MoonScales", moonScales.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.moonScales.size());
            for (var e : this.moonScales.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 86, -1);
        }
        if (this.moonGlowColors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 90, varOffset - offset - 126);
            if (this.moonGlowColors.size() > 4096000) throw ProtocolException.dictionaryTooLarge("MoonGlowColors", moonGlowColors.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.moonGlowColors.size());
            for (var e : this.moonGlowColors.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 90, -1);
        }
        if (this.fogColors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 94, varOffset - offset - 126);
            if (this.fogColors.size() > 4096000) throw ProtocolException.dictionaryTooLarge("FogColors", fogColors.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.fogColors.size());
            for (var e : this.fogColors.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 94, -1);
        }
        if (this.fogHeightFalloffs != null) {
            mem.set(PacketIO.PROTO_INT, offset + 98, varOffset - offset - 126);
            if (this.fogHeightFalloffs.size() > 4096000) throw ProtocolException.dictionaryTooLarge("FogHeightFalloffs", fogHeightFalloffs.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.fogHeightFalloffs.size());
            for (var e : this.fogHeightFalloffs.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 98, -1);
        }
        if (this.fogDensities != null) {
            mem.set(PacketIO.PROTO_INT, offset + 102, varOffset - offset - 126);
            if (this.fogDensities.size() > 4096000) throw ProtocolException.dictionaryTooLarge("FogDensities", fogDensities.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.fogDensities.size());
            for (var e : this.fogDensities.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 102, -1);
        }
        if (this.screenEffect != null) {
            mem.set(PacketIO.PROTO_INT, offset + 106, varOffset - offset - 126);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.screenEffect, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 106, -1);
        }
        if (this.screenEffectColors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 110, varOffset - offset - 126);
            if (this.screenEffectColors.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ScreenEffectColors", screenEffectColors.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.screenEffectColors.size());
            for (var e : this.screenEffectColors.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 110, -1);
        }
        if (this.colorFilters != null) {
            mem.set(PacketIO.PROTO_INT, offset + 114, varOffset - offset - 126);
            if (this.colorFilters.size() > 4096000) throw ProtocolException.dictionaryTooLarge("ColorFilters", colorFilters.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.colorFilters.size());
            for (var e : this.colorFilters.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 114, -1);
        }
        if (this.waterTints != null) {
            mem.set(PacketIO.PROTO_INT, offset + 118, varOffset - offset - 126);
            if (this.waterTints.size() > 4096000) throw ProtocolException.dictionaryTooLarge("WaterTints", waterTints.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.waterTints.size());
            for (var e : this.waterTints.entrySet()) {
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getKey());
                varOffset += 4;
                varOffset += e.getValue().serialize(mem, varOffset);
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 118, -1);
        }
        if (this.particle != null) {
            mem.set(PacketIO.PROTO_INT, offset + 122, varOffset - offset - 126);
            varOffset += this.particle.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 122, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 126;
        if (id != null) size += PacketIO.stringSize(id);
    if (tagIndexes != null) size += VarInt.size(tagIndexes.length) + tagIndexes.length * 4;
    if (stars != null) size += PacketIO.stringSize(stars);
    if (moons != null) {
        int moonsSize = 0;
for (var kvp : moons.entrySet()) moonsSize += 4 + PacketIO.stringSize(kvp.getValue());
size += VarInt.size(moons.size()) + moonsSize;
    }
    if (clouds != null) {
        int cloudsSize = 0;
for (var elem : clouds) cloudsSize += elem.computeSize();
size += VarInt.size(clouds.length) + cloudsSize;
    }
    if (sunlightDampingMultiplier != null) size += VarInt.size(sunlightDampingMultiplier.size()) + sunlightDampingMultiplier.size() * (4 + 4);
    if (sunlightColors != null) size += VarInt.size(sunlightColors.size()) + sunlightColors.size() * (4 + 3);
    if (skyTopColors != null) size += VarInt.size(skyTopColors.size()) + skyTopColors.size() * (4 + 4);
    if (skyBottomColors != null) size += VarInt.size(skyBottomColors.size()) + skyBottomColors.size() * (4 + 4);
    if (skySunsetColors != null) size += VarInt.size(skySunsetColors.size()) + skySunsetColors.size() * (4 + 4);
    if (sunColors != null) size += VarInt.size(sunColors.size()) + sunColors.size() * (4 + 3);
    if (sunScales != null) size += VarInt.size(sunScales.size()) + sunScales.size() * (4 + 4);
    if (sunGlowColors != null) size += VarInt.size(sunGlowColors.size()) + sunGlowColors.size() * (4 + 4);
    if (moonColors != null) size += VarInt.size(moonColors.size()) + moonColors.size() * (4 + 4);
    if (moonScales != null) size += VarInt.size(moonScales.size()) + moonScales.size() * (4 + 4);
    if (moonGlowColors != null) size += VarInt.size(moonGlowColors.size()) + moonGlowColors.size() * (4 + 4);
    if (fogColors != null) size += VarInt.size(fogColors.size()) + fogColors.size() * (4 + 3);
    if (fogHeightFalloffs != null) size += VarInt.size(fogHeightFalloffs.size()) + fogHeightFalloffs.size() * (4 + 4);
    if (fogDensities != null) size += VarInt.size(fogDensities.size()) + fogDensities.size() * (4 + 4);
    if (screenEffect != null) size += PacketIO.stringSize(screenEffect);
    if (screenEffectColors != null) size += VarInt.size(screenEffectColors.size()) + screenEffectColors.size() * (4 + 4);
    if (colorFilters != null) size += VarInt.size(colorFilters.size()) + colorFilters.size() * (4 + 3);
    if (waterTints != null) size += VarInt.size(waterTints.size()) + waterTints.size() * (4 + 3);
    if (particle != null) size += particle.computeSize();

        return size;
    }

    public Weather clone() {
        Weather copy = new Weather();
        copy.id = this.id;
        copy.tagIndexes = this.tagIndexes != null ? java.util.Arrays.copyOf(this.tagIndexes, this.tagIndexes.length) : null;
        copy.stars = this.stars;
        copy.moons = this.moons != null ? new java.util.HashMap<>(this.moons) : null;
        copy.clouds = this.clouds != null ? java.util.Arrays.stream(this.clouds).map(e -> e.clone()).toArray(Cloud[]::new) : null;
        copy.sunlightDampingMultiplier = this.sunlightDampingMultiplier != null ? new java.util.HashMap<>(this.sunlightDampingMultiplier) : null;
        if (this.sunlightColors != null) {
            java.util.Map<Float, Color> m = new java.util.HashMap<>();
            for (var e : this.sunlightColors.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.sunlightColors = m;
        }
        if (this.skyTopColors != null) {
            java.util.Map<Float, ColorAlpha> m = new java.util.HashMap<>();
            for (var e : this.skyTopColors.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.skyTopColors = m;
        }
        if (this.skyBottomColors != null) {
            java.util.Map<Float, ColorAlpha> m = new java.util.HashMap<>();
            for (var e : this.skyBottomColors.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.skyBottomColors = m;
        }
        if (this.skySunsetColors != null) {
            java.util.Map<Float, ColorAlpha> m = new java.util.HashMap<>();
            for (var e : this.skySunsetColors.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.skySunsetColors = m;
        }
        if (this.sunColors != null) {
            java.util.Map<Float, Color> m = new java.util.HashMap<>();
            for (var e : this.sunColors.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.sunColors = m;
        }
        copy.sunScales = this.sunScales != null ? new java.util.HashMap<>(this.sunScales) : null;
        if (this.sunGlowColors != null) {
            java.util.Map<Float, ColorAlpha> m = new java.util.HashMap<>();
            for (var e : this.sunGlowColors.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.sunGlowColors = m;
        }
        if (this.moonColors != null) {
            java.util.Map<Float, ColorAlpha> m = new java.util.HashMap<>();
            for (var e : this.moonColors.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.moonColors = m;
        }
        copy.moonScales = this.moonScales != null ? new java.util.HashMap<>(this.moonScales) : null;
        if (this.moonGlowColors != null) {
            java.util.Map<Float, ColorAlpha> m = new java.util.HashMap<>();
            for (var e : this.moonGlowColors.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.moonGlowColors = m;
        }
        if (this.fogColors != null) {
            java.util.Map<Float, Color> m = new java.util.HashMap<>();
            for (var e : this.fogColors.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.fogColors = m;
        }
        copy.fogHeightFalloffs = this.fogHeightFalloffs != null ? new java.util.HashMap<>(this.fogHeightFalloffs) : null;
        copy.fogDensities = this.fogDensities != null ? new java.util.HashMap<>(this.fogDensities) : null;
        copy.screenEffect = this.screenEffect;
        if (this.screenEffectColors != null) {
            java.util.Map<Float, ColorAlpha> m = new java.util.HashMap<>();
            for (var e : this.screenEffectColors.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.screenEffectColors = m;
        }
        if (this.colorFilters != null) {
            java.util.Map<Float, Color> m = new java.util.HashMap<>();
            for (var e : this.colorFilters.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.colorFilters = m;
        }
        if (this.waterTints != null) {
            java.util.Map<Float, Color> m = new java.util.HashMap<>();
            for (var e : this.waterTints.entrySet()) { m.put(e.getKey(), e.getValue().clone()); }
            copy.waterTints = m;
        }
        copy.particle = this.particle != null ? this.particle.clone() : null;
        copy.fog = this.fog != null ? this.fog.clone() : null;
        copy.fogOptions = this.fogOptions != null ? this.fogOptions.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Weather other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Arrays.equals(this.tagIndexes, other.tagIndexes) && java.util.Objects.equals(this.stars, other.stars) && java.util.Objects.equals(this.moons, other.moons) && java.util.Arrays.equals(this.clouds, other.clouds) && java.util.Objects.equals(this.sunlightDampingMultiplier, other.sunlightDampingMultiplier) && java.util.Objects.equals(this.sunlightColors, other.sunlightColors) && java.util.Objects.equals(this.skyTopColors, other.skyTopColors) && java.util.Objects.equals(this.skyBottomColors, other.skyBottomColors) && java.util.Objects.equals(this.skySunsetColors, other.skySunsetColors) && java.util.Objects.equals(this.sunColors, other.sunColors) && java.util.Objects.equals(this.sunScales, other.sunScales) && java.util.Objects.equals(this.sunGlowColors, other.sunGlowColors) && java.util.Objects.equals(this.moonColors, other.moonColors) && java.util.Objects.equals(this.moonScales, other.moonScales) && java.util.Objects.equals(this.moonGlowColors, other.moonGlowColors) && java.util.Objects.equals(this.fogColors, other.fogColors) && java.util.Objects.equals(this.fogHeightFalloffs, other.fogHeightFalloffs) && java.util.Objects.equals(this.fogDensities, other.fogDensities) && java.util.Objects.equals(this.screenEffect, other.screenEffect) && java.util.Objects.equals(this.screenEffectColors, other.screenEffectColors) && java.util.Objects.equals(this.colorFilters, other.colorFilters) && java.util.Objects.equals(this.waterTints, other.waterTints) && java.util.Objects.equals(this.particle, other.particle) && java.util.Objects.equals(this.fog, other.fog) && java.util.Objects.equals(this.fogOptions, other.fogOptions);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(id);
        result = 31 * result + java.util.Arrays.hashCode(tagIndexes);
        result = 31 * result + java.util.Objects.hashCode(stars);
        result = 31 * result + java.util.Objects.hashCode(moons);
        result = 31 * result + java.util.Arrays.hashCode(clouds);
        result = 31 * result + java.util.Objects.hashCode(sunlightDampingMultiplier);
        result = 31 * result + java.util.Objects.hashCode(sunlightColors);
        result = 31 * result + java.util.Objects.hashCode(skyTopColors);
        result = 31 * result + java.util.Objects.hashCode(skyBottomColors);
        result = 31 * result + java.util.Objects.hashCode(skySunsetColors);
        result = 31 * result + java.util.Objects.hashCode(sunColors);
        result = 31 * result + java.util.Objects.hashCode(sunScales);
        result = 31 * result + java.util.Objects.hashCode(sunGlowColors);
        result = 31 * result + java.util.Objects.hashCode(moonColors);
        result = 31 * result + java.util.Objects.hashCode(moonScales);
        result = 31 * result + java.util.Objects.hashCode(moonGlowColors);
        result = 31 * result + java.util.Objects.hashCode(fogColors);
        result = 31 * result + java.util.Objects.hashCode(fogHeightFalloffs);
        result = 31 * result + java.util.Objects.hashCode(fogDensities);
        result = 31 * result + java.util.Objects.hashCode(screenEffect);
        result = 31 * result + java.util.Objects.hashCode(screenEffectColors);
        result = 31 * result + java.util.Objects.hashCode(colorFilters);
        result = 31 * result + java.util.Objects.hashCode(waterTints);
        result = 31 * result + java.util.Objects.hashCode(particle);
        result = 31 * result + java.util.Objects.hashCode(fog);
        result = 31 * result + java.util.Objects.hashCode(fogOptions);
        return result;
    }

}