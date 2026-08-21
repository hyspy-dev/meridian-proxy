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
import org.joml.*;

public class ModelVFX {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 48;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 48;
    public static final int MAX_SIZE = 16384053;

    @Nullable public String id;
    @Nonnull public SwitchTo switchTo = SwitchTo.Disappear;
    @Nonnull public EffectDirection effectDirection = EffectDirection.None;
    public float animationDuration;
    @Nullable public Vector2fc animationRange;
    @Nonnull public LoopOption loopOption = LoopOption.PlayOnce;
    @Nonnull public CurveType curveType = CurveType.Linear;
    @Nullable public Color highlightColor;
    public float highlightThickness;
    public boolean useBloomOnHighlight;
    public boolean useProgessiveHighlight;
    @Nullable public Vector2fc noiseScale;
    @Nullable public Vector2fc noiseScrollSpeed;
    @Nullable public Color postColor;
    public float postColorOpacity;

    public ModelVFX() {
    }

    public ModelVFX(@Nullable String id, @Nonnull SwitchTo switchTo, @Nonnull EffectDirection effectDirection, float animationDuration, @Nullable Vector2fc animationRange, @Nonnull LoopOption loopOption, @Nonnull CurveType curveType, @Nullable Color highlightColor, float highlightThickness, boolean useBloomOnHighlight, boolean useProgessiveHighlight, @Nullable Vector2fc noiseScale, @Nullable Vector2fc noiseScrollSpeed, @Nullable Color postColor, float postColorOpacity) {
        this.id = id;
        this.switchTo = switchTo;
        this.effectDirection = effectDirection;
        this.animationDuration = animationDuration;
        this.animationRange = animationRange;
        this.loopOption = loopOption;
        this.curveType = curveType;
        this.highlightColor = highlightColor;
        this.highlightThickness = highlightThickness;
        this.useBloomOnHighlight = useBloomOnHighlight;
        this.useProgessiveHighlight = useProgessiveHighlight;
        this.noiseScale = noiseScale;
        this.noiseScrollSpeed = noiseScrollSpeed;
        this.postColor = postColor;
        this.postColorOpacity = postColorOpacity;
    }

    public ModelVFX(@Nonnull ModelVFX other) {
        this.id = other.id;
        this.switchTo = other.switchTo;
        this.effectDirection = other.effectDirection;
        this.animationDuration = other.animationDuration;
        this.animationRange = other.animationRange;
        this.loopOption = other.loopOption;
        this.curveType = other.curveType;
        this.highlightColor = other.highlightColor;
        this.highlightThickness = other.highlightThickness;
        this.useBloomOnHighlight = other.useBloomOnHighlight;
        this.useProgessiveHighlight = other.useProgessiveHighlight;
        this.noiseScale = other.noiseScale;
        this.noiseScrollSpeed = other.noiseScrollSpeed;
        this.postColor = other.postColor;
        this.postColorOpacity = other.postColorOpacity;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ModelVFX", offset, (int) mem.byteSize());
        long needed = (long) offset + 48;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ModelVFX", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    @Nullable
    public static String getId(MemorySegment mem, int offset) {
        return hasId(mem, offset) ? PacketIO.readVarString("Id", mem, offset + 48, 4096000): null;
    }
    
    public static SwitchTo getSwitchTo(MemorySegment mem) {
        return getSwitchTo(mem, 0);
    }
    
    public static SwitchTo getSwitchTo(MemorySegment mem, int offset) {
        return SwitchTo.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static EffectDirection getEffectDirection(MemorySegment mem) {
        return getEffectDirection(mem, 0);
    }
    
    public static EffectDirection getEffectDirection(MemorySegment mem, int offset) {
        return EffectDirection.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    public static float getAnimationDuration(MemorySegment mem) {
        return getAnimationDuration(mem, 0);
    }
    
    public static float getAnimationDuration(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "AnimationDuration");
    }
    
    @Nullable
    public static Vector2fc getAnimationRange(MemorySegment mem) {
        return getAnimationRange(mem, 0);
    }
    
    @Nullable
    public static Vector2fc getAnimationRange(MemorySegment mem, int offset) {
        return hasAnimationRange(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 7), "AnimationRange"): null;
    }
    
    public static LoopOption getLoopOption(MemorySegment mem) {
        return getLoopOption(mem, 0);
    }
    
    public static LoopOption getLoopOption(MemorySegment mem, int offset) {
        return LoopOption.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 15));
    }
    
    public static CurveType getCurveType(MemorySegment mem) {
        return getCurveType(mem, 0);
    }
    
    public static CurveType getCurveType(MemorySegment mem, int offset) {
        return CurveType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 16));
    }
    
    @Nullable
    public static Color getHighlightColor(MemorySegment mem) {
        return getHighlightColor(mem, 0);
    }
    
    @Nullable
    public static Color getHighlightColor(MemorySegment mem, int offset) {
        return hasHighlightColor(mem, offset) ? Color.toObject(mem, offset + 17): null;
    }
    
    public static float getHighlightThickness(MemorySegment mem) {
        return getHighlightThickness(mem, 0);
    }
    
    public static float getHighlightThickness(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "HighlightThickness");
    }
    
    public static boolean getUseBloomOnHighlight(MemorySegment mem) {
        return getUseBloomOnHighlight(mem, 0);
    }
    
    public static boolean getUseBloomOnHighlight(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 24) & 0x01) != 0;
    }
    
    public static boolean getUseProgessiveHighlight(MemorySegment mem) {
        return getUseProgessiveHighlight(mem, 0);
    }
    
    public static boolean getUseProgessiveHighlight(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 24) & 0x02) != 0;
    }
    
    @Nullable
    public static Vector2fc getNoiseScale(MemorySegment mem) {
        return getNoiseScale(mem, 0);
    }
    
    @Nullable
    public static Vector2fc getNoiseScale(MemorySegment mem, int offset) {
        return hasNoiseScale(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 25), "NoiseScale"): null;
    }
    
    @Nullable
    public static Vector2fc getNoiseScrollSpeed(MemorySegment mem) {
        return getNoiseScrollSpeed(mem, 0);
    }
    
    @Nullable
    public static Vector2fc getNoiseScrollSpeed(MemorySegment mem, int offset) {
        return hasNoiseScrollSpeed(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 33), "NoiseScrollSpeed"): null;
    }
    
    @Nullable
    public static Color getPostColor(MemorySegment mem) {
        return getPostColor(mem, 0);
    }
    
    @Nullable
    public static Color getPostColor(MemorySegment mem, int offset) {
        return hasPostColor(mem, offset) ? Color.toObject(mem, offset + 41): null;
    }
    
    public static float getPostColorOpacity(MemorySegment mem) {
        return getPostColorOpacity(mem, 0);
    }
    
    public static float getPostColorOpacity(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 44), "PostColorOpacity");
    }
    
    public static boolean hasAnimationRange(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasHighlightColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasNoiseScale(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasNoiseScrollSpeed(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasPostColor(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    
    
    public static ModelVFX toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ModelVFX toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ModelVFX and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ModelVFX toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 48;
        var varPos = 0;
        String v0 = null;
        if (hasId(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new ModelVFX(
            v0,
            SwitchTo.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            EffectDirection.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "AnimationDuration"),
            hasAnimationRange(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 7), "AnimationRange") : null,
            LoopOption.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 15)),
            CurveType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 16)),
            hasHighlightColor(mem, offset) ? Color.toObject(mem, offset + 17) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 20), "HighlightThickness"),
            (mem.get(PacketIO.PROTO_BYTE, offset + 24) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 24) & 0x02) != 0,
            hasNoiseScale(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 25), "NoiseScale") : null,
            hasNoiseScrollSpeed(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector2f(mem, offset + 33), "NoiseScrollSpeed") : null,
            hasPostColor(mem, offset) ? Color.toObject(mem, offset + 41) : null,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 44), "PostColorOpacity")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.animationRange != null) nullBits |= 0x01;
        if (this.highlightColor != null) nullBits |= 0x02;
        if (this.noiseScale != null) nullBits |= 0x04;
        if (this.noiseScrollSpeed != null) nullBits |= 0x08;
        if (this.postColor != null) nullBits |= 0x10;
        if (this.id != null) nullBits |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.switchTo.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.effectDirection.getValue());
        PacketIO.requireFinite(this.animationDuration, "AnimationDuration"); mem.set(PacketIO.PROTO_FLOAT, offset + 3, this.animationDuration);
        if (this.animationRange != null) {
            PacketIO.requireFinite(this.animationRange, "AnimationRange"); PacketIO.writeVector2f(mem, offset + 7, this.animationRange);
        } else {
            mem.asSlice(offset + 7, 8).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 15, (byte) this.loopOption.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 16, (byte) this.curveType.getValue());
        if (this.highlightColor != null) {
            this.highlightColor.serialize(mem, offset + 17);
        } else {
            mem.asSlice(offset + 17, 3).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.highlightThickness, "HighlightThickness"); mem.set(PacketIO.PROTO_FLOAT, offset + 20, this.highlightThickness);
        byte boolBits0_0 = 0;
        if (this.useBloomOnHighlight) boolBits0_0 |= 0x01;
        if (this.useProgessiveHighlight) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 24 + 0, boolBits0_0);
        if (this.noiseScale != null) {
            PacketIO.requireFinite(this.noiseScale, "NoiseScale"); PacketIO.writeVector2f(mem, offset + 25, this.noiseScale);
        } else {
            mem.asSlice(offset + 25, 8).fill((byte) 0); 
        }
        if (this.noiseScrollSpeed != null) {
            PacketIO.requireFinite(this.noiseScrollSpeed, "NoiseScrollSpeed"); PacketIO.writeVector2f(mem, offset + 33, this.noiseScrollSpeed);
        } else {
            mem.asSlice(offset + 33, 8).fill((byte) 0); 
        }
        if (this.postColor != null) {
            this.postColor.serialize(mem, offset + 41);
        } else {
            mem.asSlice(offset + 41, 3).fill((byte) 0); 
        }
        PacketIO.requireFinite(this.postColorOpacity, "PostColorOpacity"); mem.set(PacketIO.PROTO_FLOAT, offset + 44, this.postColorOpacity);
        var varOffset = offset + 48;
        if (this.id != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 48;
        if (id != null) size += PacketIO.stringSize(id);

        return size;
    }

    public ModelVFX clone() {
        ModelVFX copy = new ModelVFX();
        copy.id = this.id;
        copy.switchTo = this.switchTo;
        copy.effectDirection = this.effectDirection;
        copy.animationDuration = this.animationDuration;
        copy.animationRange = this.animationRange;
        copy.loopOption = this.loopOption;
        copy.curveType = this.curveType;
        copy.highlightColor = this.highlightColor != null ? this.highlightColor.clone() : null;
        copy.highlightThickness = this.highlightThickness;
        copy.useBloomOnHighlight = this.useBloomOnHighlight;
        copy.useProgessiveHighlight = this.useProgessiveHighlight;
        copy.noiseScale = this.noiseScale;
        copy.noiseScrollSpeed = this.noiseScrollSpeed;
        copy.postColor = this.postColor != null ? this.postColor.clone() : null;
        copy.postColorOpacity = this.postColorOpacity;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ModelVFX other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.switchTo, other.switchTo) && java.util.Objects.equals(this.effectDirection, other.effectDirection) && this.animationDuration == other.animationDuration && java.util.Objects.equals(this.animationRange, other.animationRange) && java.util.Objects.equals(this.loopOption, other.loopOption) && java.util.Objects.equals(this.curveType, other.curveType) && java.util.Objects.equals(this.highlightColor, other.highlightColor) && this.highlightThickness == other.highlightThickness && this.useBloomOnHighlight == other.useBloomOnHighlight && this.useProgessiveHighlight == other.useProgessiveHighlight && java.util.Objects.equals(this.noiseScale, other.noiseScale) && java.util.Objects.equals(this.noiseScrollSpeed, other.noiseScrollSpeed) && java.util.Objects.equals(this.postColor, other.postColor) && this.postColorOpacity == other.postColorOpacity;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, switchTo, effectDirection, animationDuration, animationRange, loopOption, curveType, highlightColor, highlightThickness, useBloomOnHighlight, useProgessiveHighlight, noiseScale, noiseScrollSpeed, postColor, postColorOpacity);
    }

}