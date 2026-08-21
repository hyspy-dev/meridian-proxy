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


public class PlayerSkin {
    public static final int NULLABLE_BIT_FIELD_SIZE = 3;
    public static final int FIXED_BLOCK_SIZE = 3;
    public static final int VARIABLE_FIELD_COUNT = 20;
    public static final int VARIABLE_BLOCK_START = 83;
    public static final int MAX_SIZE = 2103;

    @Nullable public String bodyCharacteristic;
    @Nullable public String underwear;
    @Nullable public String face;
    @Nullable public String eyes;
    @Nullable public String ears;
    @Nullable public String mouth;
    @Nullable public String facialHair;
    @Nullable public String haircut;
    @Nullable public String eyebrows;
    @Nullable public String pants;
    @Nullable public String overpants;
    @Nullable public String undertop;
    @Nullable public String overtop;
    @Nullable public String shoes;
    @Nullable public String headAccessory;
    @Nullable public String faceAccessory;
    @Nullable public String earAccessory;
    @Nullable public String skinFeature;
    @Nullable public String gloves;
    @Nullable public String cape;

    public PlayerSkin() {
    }

    public PlayerSkin(@Nullable String bodyCharacteristic, @Nullable String underwear, @Nullable String face, @Nullable String eyes, @Nullable String ears, @Nullable String mouth, @Nullable String facialHair, @Nullable String haircut, @Nullable String eyebrows, @Nullable String pants, @Nullable String overpants, @Nullable String undertop, @Nullable String overtop, @Nullable String shoes, @Nullable String headAccessory, @Nullable String faceAccessory, @Nullable String earAccessory, @Nullable String skinFeature, @Nullable String gloves, @Nullable String cape) {
        this.bodyCharacteristic = bodyCharacteristic;
        this.underwear = underwear;
        this.face = face;
        this.eyes = eyes;
        this.ears = ears;
        this.mouth = mouth;
        this.facialHair = facialHair;
        this.haircut = haircut;
        this.eyebrows = eyebrows;
        this.pants = pants;
        this.overpants = overpants;
        this.undertop = undertop;
        this.overtop = overtop;
        this.shoes = shoes;
        this.headAccessory = headAccessory;
        this.faceAccessory = faceAccessory;
        this.earAccessory = earAccessory;
        this.skinFeature = skinFeature;
        this.gloves = gloves;
        this.cape = cape;
    }

    public PlayerSkin(@Nonnull PlayerSkin other) {
        this.bodyCharacteristic = other.bodyCharacteristic;
        this.underwear = other.underwear;
        this.face = other.face;
        this.eyes = other.eyes;
        this.ears = other.ears;
        this.mouth = other.mouth;
        this.facialHair = other.facialHair;
        this.haircut = other.haircut;
        this.eyebrows = other.eyebrows;
        this.pants = other.pants;
        this.overpants = other.overpants;
        this.undertop = other.undertop;
        this.overtop = other.overtop;
        this.shoes = other.shoes;
        this.headAccessory = other.headAccessory;
        this.faceAccessory = other.faceAccessory;
        this.earAccessory = other.earAccessory;
        this.skinFeature = other.skinFeature;
        this.gloves = other.gloves;
        this.cape = other.cape;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PlayerSkin", offset, (int) mem.byteSize());
        long needed = (long) offset + 83;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlayerSkin", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getBodyCharacteristic(MemorySegment mem) {
        return getBodyCharacteristic(mem, 0);
    }
    
    @Nullable
    public static String getBodyCharacteristic(MemorySegment mem, int offset) {
        return hasBodyCharacteristic(mem, offset) ? PacketIO.readValidatedAsciiString("BodyCharacteristic", mem, offset + getValidatedOffset(mem, offset, 3, 83, "BodyCharacteristic"), 96): null;
    }
    
    @Nullable
    public static String getUnderwear(MemorySegment mem) {
        return getUnderwear(mem, 0);
    }
    
    @Nullable
    public static String getUnderwear(MemorySegment mem, int offset) {
        return hasUnderwear(mem, offset) ? PacketIO.readValidatedAsciiString("Underwear", mem, offset + getValidatedOffset(mem, offset, 7, 83, "Underwear"), 96): null;
    }
    
    @Nullable
    public static String getFace(MemorySegment mem) {
        return getFace(mem, 0);
    }
    
    @Nullable
    public static String getFace(MemorySegment mem, int offset) {
        return hasFace(mem, offset) ? PacketIO.readValidatedAsciiString("Face", mem, offset + getValidatedOffset(mem, offset, 11, 83, "Face"), 96): null;
    }
    
    @Nullable
    public static String getEyes(MemorySegment mem) {
        return getEyes(mem, 0);
    }
    
    @Nullable
    public static String getEyes(MemorySegment mem, int offset) {
        return hasEyes(mem, offset) ? PacketIO.readValidatedAsciiString("Eyes", mem, offset + getValidatedOffset(mem, offset, 15, 83, "Eyes"), 96): null;
    }
    
    @Nullable
    public static String getEars(MemorySegment mem) {
        return getEars(mem, 0);
    }
    
    @Nullable
    public static String getEars(MemorySegment mem, int offset) {
        return hasEars(mem, offset) ? PacketIO.readValidatedAsciiString("Ears", mem, offset + getValidatedOffset(mem, offset, 19, 83, "Ears"), 96): null;
    }
    
    @Nullable
    public static String getMouth(MemorySegment mem) {
        return getMouth(mem, 0);
    }
    
    @Nullable
    public static String getMouth(MemorySegment mem, int offset) {
        return hasMouth(mem, offset) ? PacketIO.readValidatedAsciiString("Mouth", mem, offset + getValidatedOffset(mem, offset, 23, 83, "Mouth"), 96): null;
    }
    
    @Nullable
    public static String getFacialHair(MemorySegment mem) {
        return getFacialHair(mem, 0);
    }
    
    @Nullable
    public static String getFacialHair(MemorySegment mem, int offset) {
        return hasFacialHair(mem, offset) ? PacketIO.readValidatedAsciiString("FacialHair", mem, offset + getValidatedOffset(mem, offset, 27, 83, "FacialHair"), 96): null;
    }
    
    @Nullable
    public static String getHaircut(MemorySegment mem) {
        return getHaircut(mem, 0);
    }
    
    @Nullable
    public static String getHaircut(MemorySegment mem, int offset) {
        return hasHaircut(mem, offset) ? PacketIO.readValidatedAsciiString("Haircut", mem, offset + getValidatedOffset(mem, offset, 31, 83, "Haircut"), 96): null;
    }
    
    @Nullable
    public static String getEyebrows(MemorySegment mem) {
        return getEyebrows(mem, 0);
    }
    
    @Nullable
    public static String getEyebrows(MemorySegment mem, int offset) {
        return hasEyebrows(mem, offset) ? PacketIO.readValidatedAsciiString("Eyebrows", mem, offset + getValidatedOffset(mem, offset, 35, 83, "Eyebrows"), 96): null;
    }
    
    @Nullable
    public static String getPants(MemorySegment mem) {
        return getPants(mem, 0);
    }
    
    @Nullable
    public static String getPants(MemorySegment mem, int offset) {
        return hasPants(mem, offset) ? PacketIO.readValidatedAsciiString("Pants", mem, offset + getValidatedOffset(mem, offset, 39, 83, "Pants"), 96): null;
    }
    
    @Nullable
    public static String getOverpants(MemorySegment mem) {
        return getOverpants(mem, 0);
    }
    
    @Nullable
    public static String getOverpants(MemorySegment mem, int offset) {
        return hasOverpants(mem, offset) ? PacketIO.readValidatedAsciiString("Overpants", mem, offset + getValidatedOffset(mem, offset, 43, 83, "Overpants"), 96): null;
    }
    
    @Nullable
    public static String getUndertop(MemorySegment mem) {
        return getUndertop(mem, 0);
    }
    
    @Nullable
    public static String getUndertop(MemorySegment mem, int offset) {
        return hasUndertop(mem, offset) ? PacketIO.readValidatedAsciiString("Undertop", mem, offset + getValidatedOffset(mem, offset, 47, 83, "Undertop"), 96): null;
    }
    
    @Nullable
    public static String getOvertop(MemorySegment mem) {
        return getOvertop(mem, 0);
    }
    
    @Nullable
    public static String getOvertop(MemorySegment mem, int offset) {
        return hasOvertop(mem, offset) ? PacketIO.readValidatedAsciiString("Overtop", mem, offset + getValidatedOffset(mem, offset, 51, 83, "Overtop"), 96): null;
    }
    
    @Nullable
    public static String getShoes(MemorySegment mem) {
        return getShoes(mem, 0);
    }
    
    @Nullable
    public static String getShoes(MemorySegment mem, int offset) {
        return hasShoes(mem, offset) ? PacketIO.readValidatedAsciiString("Shoes", mem, offset + getValidatedOffset(mem, offset, 55, 83, "Shoes"), 96): null;
    }
    
    @Nullable
    public static String getHeadAccessory(MemorySegment mem) {
        return getHeadAccessory(mem, 0);
    }
    
    @Nullable
    public static String getHeadAccessory(MemorySegment mem, int offset) {
        return hasHeadAccessory(mem, offset) ? PacketIO.readValidatedAsciiString("HeadAccessory", mem, offset + getValidatedOffset(mem, offset, 59, 83, "HeadAccessory"), 96): null;
    }
    
    @Nullable
    public static String getFaceAccessory(MemorySegment mem) {
        return getFaceAccessory(mem, 0);
    }
    
    @Nullable
    public static String getFaceAccessory(MemorySegment mem, int offset) {
        return hasFaceAccessory(mem, offset) ? PacketIO.readValidatedAsciiString("FaceAccessory", mem, offset + getValidatedOffset(mem, offset, 63, 83, "FaceAccessory"), 96): null;
    }
    
    @Nullable
    public static String getEarAccessory(MemorySegment mem) {
        return getEarAccessory(mem, 0);
    }
    
    @Nullable
    public static String getEarAccessory(MemorySegment mem, int offset) {
        return hasEarAccessory(mem, offset) ? PacketIO.readValidatedAsciiString("EarAccessory", mem, offset + getValidatedOffset(mem, offset, 67, 83, "EarAccessory"), 96): null;
    }
    
    @Nullable
    public static String getSkinFeature(MemorySegment mem) {
        return getSkinFeature(mem, 0);
    }
    
    @Nullable
    public static String getSkinFeature(MemorySegment mem, int offset) {
        return hasSkinFeature(mem, offset) ? PacketIO.readValidatedAsciiString("SkinFeature", mem, offset + getValidatedOffset(mem, offset, 71, 83, "SkinFeature"), 96): null;
    }
    
    @Nullable
    public static String getGloves(MemorySegment mem) {
        return getGloves(mem, 0);
    }
    
    @Nullable
    public static String getGloves(MemorySegment mem, int offset) {
        return hasGloves(mem, offset) ? PacketIO.readValidatedAsciiString("Gloves", mem, offset + getValidatedOffset(mem, offset, 75, 83, "Gloves"), 96): null;
    }
    
    @Nullable
    public static String getCape(MemorySegment mem) {
        return getCape(mem, 0);
    }
    
    @Nullable
    public static String getCape(MemorySegment mem, int offset) {
        return hasCape(mem, offset) ? PacketIO.readValidatedAsciiString("Cape", mem, offset + getValidatedOffset(mem, offset, 79, 83, "Cape"), 96): null;
    }
    
    public static boolean hasBodyCharacteristic(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasUnderwear(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasFace(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasEyes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasEars(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasMouth(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasFacialHair(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasHaircut(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasEyebrows(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPants(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasOverpants(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasUndertop(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasOvertop(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasShoes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasHeadAccessory(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasFaceAccessory(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasEarAccessory(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSkinFeature(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasGloves(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasCape(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 2);
        return (b & 0x08) != 0;
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
    
    public static PlayerSkin toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PlayerSkin toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PlayerSkin and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PlayerSkin toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 83;
        var varPos = 0;
        String v0 = null;
        if (hasBodyCharacteristic(mem, offset)) {
            requireSlot(mem, offset + 3, varPos, "BodyCharacteristic");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readValidatedAsciiString("BodyCharacteristic", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 3, -1, "BodyCharacteristic");
        }
        
        String v1 = null;
        if (hasUnderwear(mem, offset)) {
            requireSlot(mem, offset + 7, varPos, "Underwear");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readValidatedAsciiString("Underwear", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 7, -1, "Underwear");
        }
        
        String v2 = null;
        if (hasFace(mem, offset)) {
            requireSlot(mem, offset + 11, varPos, "Face");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readValidatedAsciiString("Face", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 11, -1, "Face");
        }
        
        String v3 = null;
        if (hasEyes(mem, offset)) {
            requireSlot(mem, offset + 15, varPos, "Eyes");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readValidatedAsciiString("Eyes", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 15, -1, "Eyes");
        }
        
        String v4 = null;
        if (hasEars(mem, offset)) {
            requireSlot(mem, offset + 19, varPos, "Ears");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readValidatedAsciiString("Ears", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 19, -1, "Ears");
        }
        
        String v5 = null;
        if (hasMouth(mem, offset)) {
            requireSlot(mem, offset + 23, varPos, "Mouth");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readValidatedAsciiString("Mouth", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 23, -1, "Mouth");
        }
        
        String v6 = null;
        if (hasFacialHair(mem, offset)) {
            requireSlot(mem, offset + 27, varPos, "FacialHair");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v6 = PacketIO.readValidatedAsciiString("FacialHair", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 27, -1, "FacialHair");
        }
        
        String v7 = null;
        if (hasHaircut(mem, offset)) {
            requireSlot(mem, offset + 31, varPos, "Haircut");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v7 = PacketIO.readValidatedAsciiString("Haircut", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 31, -1, "Haircut");
        }
        
        String v8 = null;
        if (hasEyebrows(mem, offset)) {
            requireSlot(mem, offset + 35, varPos, "Eyebrows");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v8 = PacketIO.readValidatedAsciiString("Eyebrows", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 35, -1, "Eyebrows");
        }
        
        String v9 = null;
        if (hasPants(mem, offset)) {
            requireSlot(mem, offset + 39, varPos, "Pants");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v9 = PacketIO.readValidatedAsciiString("Pants", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 39, -1, "Pants");
        }
        
        String v10 = null;
        if (hasOverpants(mem, offset)) {
            requireSlot(mem, offset + 43, varPos, "Overpants");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v10 = PacketIO.readValidatedAsciiString("Overpants", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 43, -1, "Overpants");
        }
        
        String v11 = null;
        if (hasUndertop(mem, offset)) {
            requireSlot(mem, offset + 47, varPos, "Undertop");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v11 = PacketIO.readValidatedAsciiString("Undertop", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 47, -1, "Undertop");
        }
        
        String v12 = null;
        if (hasOvertop(mem, offset)) {
            requireSlot(mem, offset + 51, varPos, "Overtop");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v12 = PacketIO.readValidatedAsciiString("Overtop", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 51, -1, "Overtop");
        }
        
        String v13 = null;
        if (hasShoes(mem, offset)) {
            requireSlot(mem, offset + 55, varPos, "Shoes");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v13 = PacketIO.readValidatedAsciiString("Shoes", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 55, -1, "Shoes");
        }
        
        String v14 = null;
        if (hasHeadAccessory(mem, offset)) {
            requireSlot(mem, offset + 59, varPos, "HeadAccessory");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v14 = PacketIO.readValidatedAsciiString("HeadAccessory", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 59, -1, "HeadAccessory");
        }
        
        String v15 = null;
        if (hasFaceAccessory(mem, offset)) {
            requireSlot(mem, offset + 63, varPos, "FaceAccessory");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v15 = PacketIO.readValidatedAsciiString("FaceAccessory", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 63, -1, "FaceAccessory");
        }
        
        String v16 = null;
        if (hasEarAccessory(mem, offset)) {
            requireSlot(mem, offset + 67, varPos, "EarAccessory");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v16 = PacketIO.readValidatedAsciiString("EarAccessory", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 67, -1, "EarAccessory");
        }
        
        String v17 = null;
        if (hasSkinFeature(mem, offset)) {
            requireSlot(mem, offset + 71, varPos, "SkinFeature");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v17 = PacketIO.readValidatedAsciiString("SkinFeature", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 71, -1, "SkinFeature");
        }
        
        String v18 = null;
        if (hasGloves(mem, offset)) {
            requireSlot(mem, offset + 75, varPos, "Gloves");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v18 = PacketIO.readValidatedAsciiString("Gloves", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 75, -1, "Gloves");
        }
        
        String v19 = null;
        if (hasCape(mem, offset)) {
            requireSlot(mem, offset + 79, varPos, "Cape");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v19 = PacketIO.readValidatedAsciiString("Cape", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 79, -1, "Cape");
        }
        var result = new PlayerSkin(
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
            v19
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.bodyCharacteristic != null) nullBits |= 0x01;
        if (this.underwear != null) nullBits |= 0x02;
        if (this.face != null) nullBits |= 0x04;
        if (this.eyes != null) nullBits |= 0x08;
        if (this.ears != null) nullBits |= 0x10;
        if (this.mouth != null) nullBits |= 0x20;
        if (this.facialHair != null) nullBits |= 0x40;
        if (this.haircut != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.eyebrows != null) nullBits |= 0x01;
        if (this.pants != null) nullBits |= 0x02;
        if (this.overpants != null) nullBits |= 0x04;
        if (this.undertop != null) nullBits |= 0x08;
        if (this.overtop != null) nullBits |= 0x10;
        if (this.shoes != null) nullBits |= 0x20;
        if (this.headAccessory != null) nullBits |= 0x40;
        if (this.faceAccessory != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        nullBits = 0;
        if (this.earAccessory != null) nullBits |= 0x01;
        if (this.skinFeature != null) nullBits |= 0x02;
        if (this.gloves != null) nullBits |= 0x04;
        if (this.cape != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 2, nullBits);
        
        
        var varOffset = offset + 83;
        if (this.bodyCharacteristic != null) {
            mem.set(PacketIO.PROTO_INT, offset + 3, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.bodyCharacteristic, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 3, -1);
        }
        if (this.underwear != null) {
            mem.set(PacketIO.PROTO_INT, offset + 7, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.underwear, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 7, -1);
        }
        if (this.face != null) {
            mem.set(PacketIO.PROTO_INT, offset + 11, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.face, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 11, -1);
        }
        if (this.eyes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 15, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.eyes, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 15, -1);
        }
        if (this.ears != null) {
            mem.set(PacketIO.PROTO_INT, offset + 19, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.ears, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 19, -1);
        }
        if (this.mouth != null) {
            mem.set(PacketIO.PROTO_INT, offset + 23, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.mouth, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 23, -1);
        }
        if (this.facialHair != null) {
            mem.set(PacketIO.PROTO_INT, offset + 27, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.facialHair, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 27, -1);
        }
        if (this.haircut != null) {
            mem.set(PacketIO.PROTO_INT, offset + 31, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.haircut, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 31, -1);
        }
        if (this.eyebrows != null) {
            mem.set(PacketIO.PROTO_INT, offset + 35, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.eyebrows, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 35, -1);
        }
        if (this.pants != null) {
            mem.set(PacketIO.PROTO_INT, offset + 39, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.pants, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 39, -1);
        }
        if (this.overpants != null) {
            mem.set(PacketIO.PROTO_INT, offset + 43, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.overpants, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 43, -1);
        }
        if (this.undertop != null) {
            mem.set(PacketIO.PROTO_INT, offset + 47, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.undertop, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 47, -1);
        }
        if (this.overtop != null) {
            mem.set(PacketIO.PROTO_INT, offset + 51, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.overtop, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 51, -1);
        }
        if (this.shoes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 55, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.shoes, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 55, -1);
        }
        if (this.headAccessory != null) {
            mem.set(PacketIO.PROTO_INT, offset + 59, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.headAccessory, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 59, -1);
        }
        if (this.faceAccessory != null) {
            mem.set(PacketIO.PROTO_INT, offset + 63, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.faceAccessory, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 63, -1);
        }
        if (this.earAccessory != null) {
            mem.set(PacketIO.PROTO_INT, offset + 67, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.earAccessory, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 67, -1);
        }
        if (this.skinFeature != null) {
            mem.set(PacketIO.PROTO_INT, offset + 71, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.skinFeature, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 71, -1);
        }
        if (this.gloves != null) {
            mem.set(PacketIO.PROTO_INT, offset + 75, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.gloves, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 75, -1);
        }
        if (this.cape != null) {
            mem.set(PacketIO.PROTO_INT, offset + 79, varOffset - offset - 83);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.cape, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 79, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 83;
        if (bodyCharacteristic != null) size += VarInt.size(bodyCharacteristic.length()) + bodyCharacteristic.length();
    if (underwear != null) size += VarInt.size(underwear.length()) + underwear.length();
    if (face != null) size += VarInt.size(face.length()) + face.length();
    if (eyes != null) size += VarInt.size(eyes.length()) + eyes.length();
    if (ears != null) size += VarInt.size(ears.length()) + ears.length();
    if (mouth != null) size += VarInt.size(mouth.length()) + mouth.length();
    if (facialHair != null) size += VarInt.size(facialHair.length()) + facialHair.length();
    if (haircut != null) size += VarInt.size(haircut.length()) + haircut.length();
    if (eyebrows != null) size += VarInt.size(eyebrows.length()) + eyebrows.length();
    if (pants != null) size += VarInt.size(pants.length()) + pants.length();
    if (overpants != null) size += VarInt.size(overpants.length()) + overpants.length();
    if (undertop != null) size += VarInt.size(undertop.length()) + undertop.length();
    if (overtop != null) size += VarInt.size(overtop.length()) + overtop.length();
    if (shoes != null) size += VarInt.size(shoes.length()) + shoes.length();
    if (headAccessory != null) size += VarInt.size(headAccessory.length()) + headAccessory.length();
    if (faceAccessory != null) size += VarInt.size(faceAccessory.length()) + faceAccessory.length();
    if (earAccessory != null) size += VarInt.size(earAccessory.length()) + earAccessory.length();
    if (skinFeature != null) size += VarInt.size(skinFeature.length()) + skinFeature.length();
    if (gloves != null) size += VarInt.size(gloves.length()) + gloves.length();
    if (cape != null) size += VarInt.size(cape.length()) + cape.length();

        return size;
    }

    public PlayerSkin clone() {
        PlayerSkin copy = new PlayerSkin();
        copy.bodyCharacteristic = this.bodyCharacteristic;
        copy.underwear = this.underwear;
        copy.face = this.face;
        copy.eyes = this.eyes;
        copy.ears = this.ears;
        copy.mouth = this.mouth;
        copy.facialHair = this.facialHair;
        copy.haircut = this.haircut;
        copy.eyebrows = this.eyebrows;
        copy.pants = this.pants;
        copy.overpants = this.overpants;
        copy.undertop = this.undertop;
        copy.overtop = this.overtop;
        copy.shoes = this.shoes;
        copy.headAccessory = this.headAccessory;
        copy.faceAccessory = this.faceAccessory;
        copy.earAccessory = this.earAccessory;
        copy.skinFeature = this.skinFeature;
        copy.gloves = this.gloves;
        copy.cape = this.cape;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlayerSkin other)) return false;
        return java.util.Objects.equals(this.bodyCharacteristic, other.bodyCharacteristic) && java.util.Objects.equals(this.underwear, other.underwear) && java.util.Objects.equals(this.face, other.face) && java.util.Objects.equals(this.eyes, other.eyes) && java.util.Objects.equals(this.ears, other.ears) && java.util.Objects.equals(this.mouth, other.mouth) && java.util.Objects.equals(this.facialHair, other.facialHair) && java.util.Objects.equals(this.haircut, other.haircut) && java.util.Objects.equals(this.eyebrows, other.eyebrows) && java.util.Objects.equals(this.pants, other.pants) && java.util.Objects.equals(this.overpants, other.overpants) && java.util.Objects.equals(this.undertop, other.undertop) && java.util.Objects.equals(this.overtop, other.overtop) && java.util.Objects.equals(this.shoes, other.shoes) && java.util.Objects.equals(this.headAccessory, other.headAccessory) && java.util.Objects.equals(this.faceAccessory, other.faceAccessory) && java.util.Objects.equals(this.earAccessory, other.earAccessory) && java.util.Objects.equals(this.skinFeature, other.skinFeature) && java.util.Objects.equals(this.gloves, other.gloves) && java.util.Objects.equals(this.cape, other.cape);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(bodyCharacteristic, underwear, face, eyes, ears, mouth, facialHair, haircut, eyebrows, pants, overpants, undertop, overtop, shoes, headAccessory, faceAccessory, earAccessory, skinFeature, gloves, cape);
    }

}