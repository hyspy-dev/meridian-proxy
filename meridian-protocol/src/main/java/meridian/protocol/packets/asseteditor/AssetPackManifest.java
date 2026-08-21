// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class AssetPackManifest {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 7;
    public static final int VARIABLE_BLOCK_START = 29;
    public static final int MAX_SIZE = 1677721600;

    @Nullable public String name;
    @Nullable public String group;
    @Nullable public String website;
    @Nullable public String description;
    @Nullable public String version;
    @Nullable public AuthorInfo[] authors;
    @Nullable public String serverVersion;

    public AssetPackManifest() {
    }

    public AssetPackManifest(@Nullable String name, @Nullable String group, @Nullable String website, @Nullable String description, @Nullable String version, @Nullable AuthorInfo[] authors, @Nullable String serverVersion) {
        this.name = name;
        this.group = group;
        this.website = website;
        this.description = description;
        this.version = version;
        this.authors = authors;
        this.serverVersion = serverVersion;
    }

    public AssetPackManifest(@Nonnull AssetPackManifest other) {
        this.name = other.name;
        this.group = other.group;
        this.website = other.website;
        this.description = other.description;
        this.version = other.version;
        this.authors = other.authors;
        this.serverVersion = other.serverVersion;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetPackManifest", offset, (int) mem.byteSize());
        long needed = (long) offset + 29;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetPackManifest", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getName(MemorySegment mem) {
        return getName(mem, 0);
    }
    
    @Nullable
    public static String getName(MemorySegment mem, int offset) {
        return hasName(mem, offset) ? PacketIO.readVarString("Name", mem, offset + getValidatedOffset(mem, offset, 1, 29, "Name"), 4096000): null;
    }
    
    @Nullable
    public static String getGroup(MemorySegment mem) {
        return getGroup(mem, 0);
    }
    
    @Nullable
    public static String getGroup(MemorySegment mem, int offset) {
        return hasGroup(mem, offset) ? PacketIO.readVarString("Group", mem, offset + getValidatedOffset(mem, offset, 5, 29, "Group"), 4096000): null;
    }
    
    @Nullable
    public static String getWebsite(MemorySegment mem) {
        return getWebsite(mem, 0);
    }
    
    @Nullable
    public static String getWebsite(MemorySegment mem, int offset) {
        return hasWebsite(mem, offset) ? PacketIO.readVarString("Website", mem, offset + getValidatedOffset(mem, offset, 9, 29, "Website"), 4096000): null;
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem) {
        return getDescription(mem, 0);
    }
    
    @Nullable
    public static String getDescription(MemorySegment mem, int offset) {
        return hasDescription(mem, offset) ? PacketIO.readVarString("Description", mem, offset + getValidatedOffset(mem, offset, 13, 29, "Description"), 4096000): null;
    }
    
    @Nullable
    public static String getVersion(MemorySegment mem) {
        return getVersion(mem, 0);
    }
    
    @Nullable
    public static String getVersion(MemorySegment mem, int offset) {
        return hasVersion(mem, offset) ? PacketIO.readVarString("Version", mem, offset + getValidatedOffset(mem, offset, 17, 29, "Version"), 4096000): null;
    }
    
    @Nullable
    public static AuthorInfo[] getAuthors(MemorySegment mem) {
        return getAuthors(mem, 0);
    }
    
    @Nullable
    public static AuthorInfo[] getAuthors(MemorySegment mem, int offset) {
        if (!hasAuthors(mem, offset)) return null;
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 21, 29, "Authors");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Authors");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Authors", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Authors", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new AuthorInfo[len];
        for (var i = 0; i < len; i++) {
            data[i] = AuthorInfo.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    @Nullable
    public static String getServerVersion(MemorySegment mem) {
        return getServerVersion(mem, 0);
    }
    
    @Nullable
    public static String getServerVersion(MemorySegment mem, int offset) {
        return hasServerVersion(mem, offset) ? PacketIO.readVarString("ServerVersion", mem, offset + getValidatedOffset(mem, offset, 25, 29, "ServerVersion"), 4096000): null;
    }
    
    public static boolean hasName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasGroup(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasWebsite(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasDescription(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasVersion(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasAuthors(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasServerVersion(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
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
    
    public static AssetPackManifest toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetPackManifest toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetPackManifest and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetPackManifest toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 29;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0 = null;
        if (hasName(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Name");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Name", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 1, -1, "Name");
        }
        
        String v1 = null;
        if (hasGroup(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Group");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Group", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 5, -1, "Group");
        }
        
        String v2 = null;
        if (hasWebsite(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "Website");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Website", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "Website");
        }
        
        String v3 = null;
        if (hasDescription(mem, offset)) {
            requireSlot(mem, offset + 13, varPos, "Description");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("Description", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 13, -1, "Description");
        }
        
        String v4 = null;
        if (hasVersion(mem, offset)) {
            requireSlot(mem, offset + 17, varPos, "Version");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("Version", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 17, -1, "Version");
        }
        
        AuthorInfo[] v5 = null;
        if (hasAuthors(mem, offset)) {
            requireSlot(mem, offset + 21, varPos, "Authors");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Authors");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Authors", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Authors", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new AuthorInfo[len];
            for (var i = 0; i < len; i++) {
                v5[i] = AuthorInfo.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 21, -1, "Authors");
        }
        
        String v6 = null;
        if (hasServerVersion(mem, offset)) {
            requireSlot(mem, offset + 25, varPos, "ServerVersion");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v6 = PacketIO.readVarString("ServerVersion", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 25, -1, "ServerVersion");
        }
        var result = new AssetPackManifest(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5,
            v6
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.name != null) nullBits |= 0x01;
        if (this.group != null) nullBits |= 0x02;
        if (this.website != null) nullBits |= 0x04;
        if (this.description != null) nullBits |= 0x08;
        if (this.version != null) nullBits |= 0x10;
        if (this.authors != null) nullBits |= 0x20;
        if (this.serverVersion != null) nullBits |= 0x40;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 29;
        if (this.name != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.name, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.group != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.group, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
        if (this.website != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.website, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
        if (this.description != null) {
            mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.description, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 13, -1);
        }
        if (this.version != null) {
            mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.version, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 17, -1);
        }
        if (this.authors != null) {
            mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 29);
            if (authors.length > 4096000) throw ProtocolException.arrayTooLong("Authors", authors.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.authors.length);
            
            var authorsValueOffset = 0;
            for (var i = 0; i < this.authors.length; i++) {
                authorsValueOffset += this.authors[i].serialize(mem, varOffset + authorsValueOffset);
            }
            varOffset += authorsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 21, -1);
        }
        if (this.serverVersion != null) {
            mem.set(PacketIO.PROTO_INT, offset + 25, varOffset - offset - 29);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.serverVersion, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 25, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 29;
        if (name != null) size += PacketIO.stringSize(name);
    if (group != null) size += PacketIO.stringSize(group);
    if (website != null) size += PacketIO.stringSize(website);
    if (description != null) size += PacketIO.stringSize(description);
    if (version != null) size += PacketIO.stringSize(version);
    if (authors != null) {
        int authorsSize = 0;
for (var elem : authors) authorsSize += elem.computeSize();
size += VarInt.size(authors.length) + authorsSize;
    }
    if (serverVersion != null) size += PacketIO.stringSize(serverVersion);

        return size;
    }

    public AssetPackManifest clone() {
        AssetPackManifest copy = new AssetPackManifest();
        copy.name = this.name;
        copy.group = this.group;
        copy.website = this.website;
        copy.description = this.description;
        copy.version = this.version;
        copy.authors = this.authors != null ? java.util.Arrays.stream(this.authors).map(e -> e.clone()).toArray(AuthorInfo[]::new) : null;
        copy.serverVersion = this.serverVersion;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetPackManifest other)) return false;
        return java.util.Objects.equals(this.name, other.name) && java.util.Objects.equals(this.group, other.group) && java.util.Objects.equals(this.website, other.website) && java.util.Objects.equals(this.description, other.description) && java.util.Objects.equals(this.version, other.version) && java.util.Arrays.equals(this.authors, other.authors) && java.util.Objects.equals(this.serverVersion, other.serverVersion);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(name);
        result = 31 * result + java.util.Objects.hashCode(group);
        result = 31 * result + java.util.Objects.hashCode(website);
        result = 31 * result + java.util.Objects.hashCode(description);
        result = 31 * result + java.util.Objects.hashCode(version);
        result = 31 * result + java.util.Arrays.hashCode(authors);
        result = 31 * result + java.util.Objects.hashCode(serverVersion);
        return result;
    }

}