// Auto-generated - do not edit
package meridian.protocol.packets.player;

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
import meridian.protocol.packets.voice.VoiceInputMode;
import meridian.protocol.PickupLocation;
import meridian.protocol.PlaceMode;

public class SyncPlayerPreferences implements Packet, ToServerPacket {
    public static final int PACKET_ID = 116;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 14;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 14;
    public static final int MAX_SIZE = 14;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public boolean showEntityMarkers;
    @Nonnull public PickupLocation armorItemsPreferredPickupLocation = PickupLocation.Hotbar;
    @Nonnull public PickupLocation weaponAndToolItemsPreferredPickupLocation = PickupLocation.Hotbar;
    @Nonnull public PickupLocation usableItemsItemsPreferredPickupLocation = PickupLocation.Hotbar;
    @Nonnull public PickupLocation solidBlockItemsPreferredPickupLocation = PickupLocation.Hotbar;
    @Nonnull public PickupLocation miscItemsPreferredPickupLocation = PickupLocation.Hotbar;
    public boolean allowNPCDetection;
    public boolean respondToHit;
    public boolean hideHelmet;
    public boolean hideCuirass;
    public boolean hideGauntlets;
    public boolean hidePants;
    @Nonnull public PlaceMode placeMode = PlaceMode.Default;
    public int creativeInteractionDistance;
    public boolean showBuilderToolNotifications;
    public boolean noPhysics;
    public boolean eraserEnabled;
    public boolean voiceChat;
    public boolean voiceInput;
    @Nonnull public VoiceInputMode voiceInputMode = VoiceInputMode.VoiceActivity;

    public SyncPlayerPreferences() {
    }

    public SyncPlayerPreferences(boolean showEntityMarkers, @Nonnull PickupLocation armorItemsPreferredPickupLocation, @Nonnull PickupLocation weaponAndToolItemsPreferredPickupLocation, @Nonnull PickupLocation usableItemsItemsPreferredPickupLocation, @Nonnull PickupLocation solidBlockItemsPreferredPickupLocation, @Nonnull PickupLocation miscItemsPreferredPickupLocation, boolean allowNPCDetection, boolean respondToHit, boolean hideHelmet, boolean hideCuirass, boolean hideGauntlets, boolean hidePants, @Nonnull PlaceMode placeMode, int creativeInteractionDistance, boolean showBuilderToolNotifications, boolean noPhysics, boolean eraserEnabled, boolean voiceChat, boolean voiceInput, @Nonnull VoiceInputMode voiceInputMode) {
        this.showEntityMarkers = showEntityMarkers;
        this.armorItemsPreferredPickupLocation = armorItemsPreferredPickupLocation;
        this.weaponAndToolItemsPreferredPickupLocation = weaponAndToolItemsPreferredPickupLocation;
        this.usableItemsItemsPreferredPickupLocation = usableItemsItemsPreferredPickupLocation;
        this.solidBlockItemsPreferredPickupLocation = solidBlockItemsPreferredPickupLocation;
        this.miscItemsPreferredPickupLocation = miscItemsPreferredPickupLocation;
        this.allowNPCDetection = allowNPCDetection;
        this.respondToHit = respondToHit;
        this.hideHelmet = hideHelmet;
        this.hideCuirass = hideCuirass;
        this.hideGauntlets = hideGauntlets;
        this.hidePants = hidePants;
        this.placeMode = placeMode;
        this.creativeInteractionDistance = creativeInteractionDistance;
        this.showBuilderToolNotifications = showBuilderToolNotifications;
        this.noPhysics = noPhysics;
        this.eraserEnabled = eraserEnabled;
        this.voiceChat = voiceChat;
        this.voiceInput = voiceInput;
        this.voiceInputMode = voiceInputMode;
    }

    public SyncPlayerPreferences(@Nonnull SyncPlayerPreferences other) {
        this.showEntityMarkers = other.showEntityMarkers;
        this.armorItemsPreferredPickupLocation = other.armorItemsPreferredPickupLocation;
        this.weaponAndToolItemsPreferredPickupLocation = other.weaponAndToolItemsPreferredPickupLocation;
        this.usableItemsItemsPreferredPickupLocation = other.usableItemsItemsPreferredPickupLocation;
        this.solidBlockItemsPreferredPickupLocation = other.solidBlockItemsPreferredPickupLocation;
        this.miscItemsPreferredPickupLocation = other.miscItemsPreferredPickupLocation;
        this.allowNPCDetection = other.allowNPCDetection;
        this.respondToHit = other.respondToHit;
        this.hideHelmet = other.hideHelmet;
        this.hideCuirass = other.hideCuirass;
        this.hideGauntlets = other.hideGauntlets;
        this.hidePants = other.hidePants;
        this.placeMode = other.placeMode;
        this.creativeInteractionDistance = other.creativeInteractionDistance;
        this.showBuilderToolNotifications = other.showBuilderToolNotifications;
        this.noPhysics = other.noPhysics;
        this.eraserEnabled = other.eraserEnabled;
        this.voiceChat = other.voiceChat;
        this.voiceInput = other.voiceInput;
        this.voiceInputMode = other.voiceInputMode;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SyncPlayerPreferences", offset, (int) mem.byteSize());
        long needed = (long) offset + 14;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SyncPlayerPreferences", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getShowEntityMarkers(MemorySegment mem) {
        return getShowEntityMarkers(mem, 0);
    }
    
    public static boolean getShowEntityMarkers(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 0);
    }
    
    public static PickupLocation getArmorItemsPreferredPickupLocation(MemorySegment mem) {
        return getArmorItemsPreferredPickupLocation(mem, 0);
    }
    
    public static PickupLocation getArmorItemsPreferredPickupLocation(MemorySegment mem, int offset) {
        return PickupLocation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static PickupLocation getWeaponAndToolItemsPreferredPickupLocation(MemorySegment mem) {
        return getWeaponAndToolItemsPreferredPickupLocation(mem, 0);
    }
    
    public static PickupLocation getWeaponAndToolItemsPreferredPickupLocation(MemorySegment mem, int offset) {
        return PickupLocation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    public static PickupLocation getUsableItemsItemsPreferredPickupLocation(MemorySegment mem) {
        return getUsableItemsItemsPreferredPickupLocation(mem, 0);
    }
    
    public static PickupLocation getUsableItemsItemsPreferredPickupLocation(MemorySegment mem, int offset) {
        return PickupLocation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 3));
    }
    
    public static PickupLocation getSolidBlockItemsPreferredPickupLocation(MemorySegment mem) {
        return getSolidBlockItemsPreferredPickupLocation(mem, 0);
    }
    
    public static PickupLocation getSolidBlockItemsPreferredPickupLocation(MemorySegment mem, int offset) {
        return PickupLocation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4));
    }
    
    public static PickupLocation getMiscItemsPreferredPickupLocation(MemorySegment mem) {
        return getMiscItemsPreferredPickupLocation(mem, 0);
    }
    
    public static PickupLocation getMiscItemsPreferredPickupLocation(MemorySegment mem, int offset) {
        return PickupLocation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5));
    }
    
    public static boolean getAllowNPCDetection(MemorySegment mem) {
        return getAllowNPCDetection(mem, 0);
    }
    
    public static boolean getAllowNPCDetection(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x01) != 0;
    }
    
    public static boolean getRespondToHit(MemorySegment mem) {
        return getRespondToHit(mem, 0);
    }
    
    public static boolean getRespondToHit(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x02) != 0;
    }
    
    public static boolean getHideHelmet(MemorySegment mem) {
        return getHideHelmet(mem, 0);
    }
    
    public static boolean getHideHelmet(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x04) != 0;
    }
    
    public static boolean getHideCuirass(MemorySegment mem) {
        return getHideCuirass(mem, 0);
    }
    
    public static boolean getHideCuirass(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x08) != 0;
    }
    
    public static boolean getHideGauntlets(MemorySegment mem) {
        return getHideGauntlets(mem, 0);
    }
    
    public static boolean getHideGauntlets(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x10) != 0;
    }
    
    public static boolean getHidePants(MemorySegment mem) {
        return getHidePants(mem, 0);
    }
    
    public static boolean getHidePants(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x20) != 0;
    }
    
    public static PlaceMode getPlaceMode(MemorySegment mem) {
        return getPlaceMode(mem, 0);
    }
    
    public static PlaceMode getPlaceMode(MemorySegment mem, int offset) {
        return PlaceMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 7));
    }
    
    public static int getCreativeInteractionDistance(MemorySegment mem) {
        return getCreativeInteractionDistance(mem, 0);
    }
    
    public static int getCreativeInteractionDistance(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 8);
    }
    
    public static boolean getShowBuilderToolNotifications(MemorySegment mem) {
        return getShowBuilderToolNotifications(mem, 0);
    }
    
    public static boolean getShowBuilderToolNotifications(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x01) != 0;
    }
    
    public static boolean getNoPhysics(MemorySegment mem) {
        return getNoPhysics(mem, 0);
    }
    
    public static boolean getNoPhysics(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x02) != 0;
    }
    
    public static boolean getEraserEnabled(MemorySegment mem) {
        return getEraserEnabled(mem, 0);
    }
    
    public static boolean getEraserEnabled(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x04) != 0;
    }
    
    public static boolean getVoiceChat(MemorySegment mem) {
        return getVoiceChat(mem, 0);
    }
    
    public static boolean getVoiceChat(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x08) != 0;
    }
    
    public static boolean getVoiceInput(MemorySegment mem) {
        return getVoiceInput(mem, 0);
    }
    
    public static boolean getVoiceInput(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x10) != 0;
    }
    
    public static VoiceInputMode getVoiceInputMode(MemorySegment mem) {
        return getVoiceInputMode(mem, 0);
    }
    
    public static VoiceInputMode getVoiceInputMode(MemorySegment mem, int offset) {
        return VoiceInputMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13));
    }
    
    
    
    
    
    public static SyncPlayerPreferences toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SyncPlayerPreferences toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SyncPlayerPreferences and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SyncPlayerPreferences toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SyncPlayerPreferences(
            mem.get(PacketIO.PROTO_BOOL, offset + 0),
            PickupLocation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            PickupLocation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2)),
            PickupLocation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 3)),
            PickupLocation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 4)),
            PickupLocation.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5)),
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x08) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x10) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x20) != 0,
            PlaceMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 7)),
            mem.get(PacketIO.PROTO_INT, offset + 8),
            (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x04) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x08) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x10) != 0,
            VoiceInputMode.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13))
        );
        if (cursor != null) cursor.position = offset + 14;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BOOL, offset + 0, this.showEntityMarkers);
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.armorItemsPreferredPickupLocation.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.weaponAndToolItemsPreferredPickupLocation.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 3, (byte) this.usableItemsItemsPreferredPickupLocation.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 4, (byte) this.solidBlockItemsPreferredPickupLocation.getValue());
        mem.set(PacketIO.PROTO_BYTE, offset + 5, (byte) this.miscItemsPreferredPickupLocation.getValue());
        byte boolBits0_0 = 0;
        if (this.allowNPCDetection) boolBits0_0 |= 0x01;
        if (this.respondToHit) boolBits0_0 |= 0x02;
        if (this.hideHelmet) boolBits0_0 |= 0x04;
        if (this.hideCuirass) boolBits0_0 |= 0x08;
        if (this.hideGauntlets) boolBits0_0 |= 0x10;
        if (this.hidePants) boolBits0_0 |= 0x20;
        mem.set(PacketIO.PROTO_BYTE, offset + 6 + 0, boolBits0_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 7, (byte) this.placeMode.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 8, this.creativeInteractionDistance);
        byte boolBits1_0 = 0;
        if (this.showBuilderToolNotifications) boolBits1_0 |= 0x01;
        if (this.noPhysics) boolBits1_0 |= 0x02;
        if (this.eraserEnabled) boolBits1_0 |= 0x04;
        if (this.voiceChat) boolBits1_0 |= 0x08;
        if (this.voiceInput) boolBits1_0 |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 12 + 0, boolBits1_0);
        mem.set(PacketIO.PROTO_BYTE, offset + 13, (byte) this.voiceInputMode.getValue());
        
        
    
       return 14;
    }
    public int computeSize() {
        return 14;
    }

    public SyncPlayerPreferences clone() {
        SyncPlayerPreferences copy = new SyncPlayerPreferences();
        copy.showEntityMarkers = this.showEntityMarkers;
        copy.armorItemsPreferredPickupLocation = this.armorItemsPreferredPickupLocation;
        copy.weaponAndToolItemsPreferredPickupLocation = this.weaponAndToolItemsPreferredPickupLocation;
        copy.usableItemsItemsPreferredPickupLocation = this.usableItemsItemsPreferredPickupLocation;
        copy.solidBlockItemsPreferredPickupLocation = this.solidBlockItemsPreferredPickupLocation;
        copy.miscItemsPreferredPickupLocation = this.miscItemsPreferredPickupLocation;
        copy.allowNPCDetection = this.allowNPCDetection;
        copy.respondToHit = this.respondToHit;
        copy.hideHelmet = this.hideHelmet;
        copy.hideCuirass = this.hideCuirass;
        copy.hideGauntlets = this.hideGauntlets;
        copy.hidePants = this.hidePants;
        copy.placeMode = this.placeMode;
        copy.creativeInteractionDistance = this.creativeInteractionDistance;
        copy.showBuilderToolNotifications = this.showBuilderToolNotifications;
        copy.noPhysics = this.noPhysics;
        copy.eraserEnabled = this.eraserEnabled;
        copy.voiceChat = this.voiceChat;
        copy.voiceInput = this.voiceInput;
        copy.voiceInputMode = this.voiceInputMode;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SyncPlayerPreferences other)) return false;
        return this.showEntityMarkers == other.showEntityMarkers && java.util.Objects.equals(this.armorItemsPreferredPickupLocation, other.armorItemsPreferredPickupLocation) && java.util.Objects.equals(this.weaponAndToolItemsPreferredPickupLocation, other.weaponAndToolItemsPreferredPickupLocation) && java.util.Objects.equals(this.usableItemsItemsPreferredPickupLocation, other.usableItemsItemsPreferredPickupLocation) && java.util.Objects.equals(this.solidBlockItemsPreferredPickupLocation, other.solidBlockItemsPreferredPickupLocation) && java.util.Objects.equals(this.miscItemsPreferredPickupLocation, other.miscItemsPreferredPickupLocation) && this.allowNPCDetection == other.allowNPCDetection && this.respondToHit == other.respondToHit && this.hideHelmet == other.hideHelmet && this.hideCuirass == other.hideCuirass && this.hideGauntlets == other.hideGauntlets && this.hidePants == other.hidePants && java.util.Objects.equals(this.placeMode, other.placeMode) && this.creativeInteractionDistance == other.creativeInteractionDistance && this.showBuilderToolNotifications == other.showBuilderToolNotifications && this.noPhysics == other.noPhysics && this.eraserEnabled == other.eraserEnabled && this.voiceChat == other.voiceChat && this.voiceInput == other.voiceInput && java.util.Objects.equals(this.voiceInputMode, other.voiceInputMode);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(showEntityMarkers, armorItemsPreferredPickupLocation, weaponAndToolItemsPreferredPickupLocation, usableItemsItemsPreferredPickupLocation, solidBlockItemsPreferredPickupLocation, miscItemsPreferredPickupLocation, allowNPCDetection, respondToHit, hideHelmet, hideCuirass, hideGauntlets, hidePants, placeMode, creativeInteractionDistance, showBuilderToolNotifications, noPhysics, eraserEnabled, voiceChat, voiceInput, voiceInputMode);
    }

}