// Auto-generated - do not edit
package meridian.protocol;

import java.lang.foreign.MemorySegment;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class PacketRegistry {
    private static final Map<Integer, PacketInfo> BY_ID = new HashMap<>();
    private static final Map<Integer, PacketInfo> TO_SERVER_BY_ID = new HashMap<>();
    private static final Map<Integer, PacketInfo> TO_CLIENT_BY_ID = new HashMap<>();
    private static final Map<Integer, PacketInfo> BY_ID_UNMODIFIABLE = Collections.unmodifiableMap(BY_ID);
    private static final Map<Class<? extends Packet>, Integer> BY_TYPE = new HashMap<>();

    static {
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            0, "Connect", meridian.protocol.packets.connection.Connect.class,
            30, 37972, false,
            meridian.protocol.packets.connection.Connect::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            1, "ClientDisconnect", meridian.protocol.packets.connection.ClientDisconnect.class,
            2, 2, false,
            meridian.protocol.packets.connection.ClientDisconnect::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            2, "ServerDisconnect", meridian.protocol.packets.connection.ServerDisconnect.class,
            2, 1677721600, false,
            meridian.protocol.packets.connection.ServerDisconnect::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            3, "Ping", meridian.protocol.packets.connection.Ping.class,
            28, 28, false,
            meridian.protocol.packets.connection.Ping::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            4, "Pong", meridian.protocol.packets.connection.Pong.class,
            19, 19, false,
            meridian.protocol.packets.connection.Pong::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            5, "NetworkTick", meridian.protocol.packets.connection.NetworkTick.class,
            8, 8, false,
            meridian.protocol.packets.connection.NetworkTick::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            11, "AuthGrant", meridian.protocol.packets.auth.AuthGrant.class,
            1, 49171, false,
            meridian.protocol.packets.auth.AuthGrant::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            12, "AuthToken", meridian.protocol.packets.auth.AuthToken.class,
            1, 49171, false,
            meridian.protocol.packets.auth.AuthToken::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            13, "ServerAuthToken", meridian.protocol.packets.auth.ServerAuthToken.class,
            1, 32851, false,
            meridian.protocol.packets.auth.ServerAuthToken::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            14, "ConnectAccept", meridian.protocol.packets.auth.ConnectAccept.class,
            1, 70, false,
            meridian.protocol.packets.auth.ConnectAccept::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            15, "PasswordResponse", meridian.protocol.packets.auth.PasswordResponse.class,
            1, 70, false,
            meridian.protocol.packets.auth.PasswordResponse::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            16, "PasswordAccepted", meridian.protocol.packets.auth.PasswordAccepted.class,
            0, 0, false,
            meridian.protocol.packets.auth.PasswordAccepted::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            17, "PasswordRejected", meridian.protocol.packets.auth.PasswordRejected.class,
            5, 74, false,
            meridian.protocol.packets.auth.PasswordRejected::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            18, "ClientReferral", meridian.protocol.packets.auth.ClientReferral.class,
            1, 5141, false,
            meridian.protocol.packets.auth.ClientReferral::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            20, "WorldSettings", meridian.protocol.packets.setup.WorldSettings.class,
            1, 1677721600, true,
            meridian.protocol.packets.setup.WorldSettings::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            21, "WorldLoadProgress", meridian.protocol.packets.setup.WorldLoadProgress.class,
            9, 1677721600, false,
            meridian.protocol.packets.setup.WorldLoadProgress::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            22, "WorldLoadFinished", meridian.protocol.packets.setup.WorldLoadFinished.class,
            0, 0, false,
            meridian.protocol.packets.setup.WorldLoadFinished::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            23, "RequestAssets", meridian.protocol.packets.setup.RequestAssets.class,
            1, 1677721600, true,
            meridian.protocol.packets.setup.RequestAssets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            24, "AssetInitialize", meridian.protocol.packets.setup.AssetInitialize.class,
            4, 2121, false,
            meridian.protocol.packets.setup.AssetInitialize::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            25, "AssetPart", meridian.protocol.packets.setup.AssetPart.class,
            1, 4096006, true,
            meridian.protocol.packets.setup.AssetPart::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            26, "AssetFinalize", meridian.protocol.packets.setup.AssetFinalize.class,
            0, 0, false,
            meridian.protocol.packets.setup.AssetFinalize::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            27, "RemoveAssets", meridian.protocol.packets.setup.RemoveAssets.class,
            1, 1677721600, false,
            meridian.protocol.packets.setup.RemoveAssets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            28, "RequestCommonAssetsRebuild", meridian.protocol.packets.setup.RequestCommonAssetsRebuild.class,
            0, 0, false,
            meridian.protocol.packets.setup.RequestCommonAssetsRebuild::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            29, "SetUpdateRate", meridian.protocol.packets.setup.SetUpdateRate.class,
            4, 4, false,
            meridian.protocol.packets.setup.SetUpdateRate::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            30, "SetTimeDilation", meridian.protocol.packets.setup.SetTimeDilation.class,
            4, 4, false,
            meridian.protocol.packets.setup.SetTimeDilation::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            31, "UpdateFeatures", meridian.protocol.packets.setup.UpdateFeatures.class,
            1, 8192006, false,
            meridian.protocol.packets.setup.UpdateFeatures::toObject);
        register(
            PacketDirection.Both, NetworkChannel.Chunks,
            32, "ViewRadius", meridian.protocol.packets.setup.ViewRadius.class,
            4, 4, false,
            meridian.protocol.packets.setup.ViewRadius::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            33, "SetupFinalize", meridian.protocol.packets.setup.SetupFinalize.class,
            0, 0, false,
            meridian.protocol.packets.setup.SetupFinalize::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            34, "ServerTags", meridian.protocol.packets.setup.ServerTags.class,
            1, 1677721600, false,
            meridian.protocol.packets.setup.ServerTags::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            40, "UpdateBlockTypes", meridian.protocol.packets.assets.UpdateBlockTypes.class,
            7, 1677721600, true,
            meridian.protocol.packets.assets.UpdateBlockTypes::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            41, "UpdateBlockHitboxes", meridian.protocol.packets.assets.UpdateBlockHitboxes.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateBlockHitboxes::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            42, "UpdateBlockSoundSets", meridian.protocol.packets.assets.UpdateBlockSoundSets.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateBlockSoundSets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            43, "UpdateItemSoundSets", meridian.protocol.packets.assets.UpdateItemSoundSets.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateItemSoundSets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            44, "UpdateBlockParticleSets", meridian.protocol.packets.assets.UpdateBlockParticleSets.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateBlockParticleSets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            45, "UpdateBlockBreakingDecals", meridian.protocol.packets.assets.UpdateBlockBreakingDecals.class,
            1, 1677721600, true,
            meridian.protocol.packets.assets.UpdateBlockBreakingDecals::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            46, "UpdateBlockSets", meridian.protocol.packets.assets.UpdateBlockSets.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateBlockSets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            47, "UpdateWeathers", meridian.protocol.packets.assets.UpdateWeathers.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateWeathers::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            48, "UpdateTrails", meridian.protocol.packets.assets.UpdateTrails.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateTrails::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            49, "UpdateParticleSystems", meridian.protocol.packets.assets.UpdateParticleSystems.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateParticleSystems::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            50, "UpdateParticleSpawners", meridian.protocol.packets.assets.UpdateParticleSpawners.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateParticleSpawners::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            51, "UpdateEntityEffects", meridian.protocol.packets.assets.UpdateEntityEffects.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateEntityEffects::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            52, "UpdateItemPlayerAnimations", meridian.protocol.packets.assets.UpdateItemPlayerAnimations.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateItemPlayerAnimations::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            53, "UpdateModelvfxs", meridian.protocol.packets.assets.UpdateModelvfxs.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateModelvfxs::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            54, "UpdateItems", meridian.protocol.packets.assets.UpdateItems.class,
            3, 1677721600, true,
            meridian.protocol.packets.assets.UpdateItems::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            55, "UpdateItemQualities", meridian.protocol.packets.assets.UpdateItemQualities.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateItemQualities::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            56, "UpdateItemCategories", meridian.protocol.packets.assets.UpdateItemCategories.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateItemCategories::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            57, "UpdateItemReticles", meridian.protocol.packets.assets.UpdateItemReticles.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateItemReticles::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            58, "UpdateFieldcraftCategories", meridian.protocol.packets.assets.UpdateFieldcraftCategories.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateFieldcraftCategories::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            59, "UpdateResourceTypes", meridian.protocol.packets.assets.UpdateResourceTypes.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateResourceTypes::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            60, "UpdateRecipes", meridian.protocol.packets.assets.UpdateRecipes.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateRecipes::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            61, "UpdateEnvironments", meridian.protocol.packets.assets.UpdateEnvironments.class,
            7, 1677721600, true,
            meridian.protocol.packets.assets.UpdateEnvironments::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            62, "UpdateAmbienceFX", meridian.protocol.packets.assets.UpdateAmbienceFX.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateAmbienceFX::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            63, "UpdateFluidFX", meridian.protocol.packets.assets.UpdateFluidFX.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateFluidFX::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            64, "UpdateTranslations", meridian.protocol.packets.assets.UpdateTranslations.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateTranslations::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            65, "UpdateSoundEvents", meridian.protocol.packets.assets.UpdateSoundEvents.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateSoundEvents::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            66, "UpdateInteractions", meridian.protocol.packets.assets.UpdateInteractions.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateInteractions::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            67, "UpdateRootInteractions", meridian.protocol.packets.assets.UpdateRootInteractions.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateRootInteractions::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            68, "UpdateUnarmedInteractions", meridian.protocol.packets.assets.UpdateUnarmedInteractions.class,
            2, 20480007, true,
            meridian.protocol.packets.assets.UpdateUnarmedInteractions::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            69, "TrackOrUpdateObjective", meridian.protocol.packets.assets.TrackOrUpdateObjective.class,
            1, 1677721600, false,
            meridian.protocol.packets.assets.TrackOrUpdateObjective::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            70, "UntrackObjective", meridian.protocol.packets.assets.UntrackObjective.class,
            16, 16, false,
            meridian.protocol.packets.assets.UntrackObjective::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            71, "UpdateObjectiveTask", meridian.protocol.packets.assets.UpdateObjectiveTask.class,
            21, 1677721600, false,
            meridian.protocol.packets.assets.UpdateObjectiveTask::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            72, "UpdateEntityStatTypes", meridian.protocol.packets.assets.UpdateEntityStatTypes.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateEntityStatTypes::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            73, "UpdateEntityUIComponents", meridian.protocol.packets.assets.UpdateEntityUIComponents.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateEntityUIComponents::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            74, "UpdateHitboxCollisionConfig", meridian.protocol.packets.assets.UpdateHitboxCollisionConfig.class,
            6, 40960011, true,
            meridian.protocol.packets.assets.UpdateHitboxCollisionConfig::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            75, "UpdateRepulsionConfig", meridian.protocol.packets.assets.UpdateRepulsionConfig.class,
            6, 65536011, true,
            meridian.protocol.packets.assets.UpdateRepulsionConfig::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            76, "UpdateViewBobbing", meridian.protocol.packets.assets.UpdateViewBobbing.class,
            1, 1677721600, true,
            meridian.protocol.packets.assets.UpdateViewBobbing::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            77, "UpdateCameraShake", meridian.protocol.packets.assets.UpdateCameraShake.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateCameraShake::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            78, "UpdateBlockGroups", meridian.protocol.packets.assets.UpdateBlockGroups.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateBlockGroups::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            79, "UpdateSoundSets", meridian.protocol.packets.assets.UpdateSoundSets.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateSoundSets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            80, "UpdateAudioCategories", meridian.protocol.packets.assets.UpdateAudioCategories.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateAudioCategories::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            81, "UpdateReverbEffects", meridian.protocol.packets.assets.UpdateReverbEffects.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateReverbEffects::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            82, "UpdateEqualizerEffects", meridian.protocol.packets.assets.UpdateEqualizerEffects.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateEqualizerEffects::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            83, "UpdateFluids", meridian.protocol.packets.assets.UpdateFluids.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateFluids::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            84, "UpdateTagPatterns", meridian.protocol.packets.assets.UpdateTagPatterns.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateTagPatterns::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            85, "UpdateProjectileConfigs", meridian.protocol.packets.assets.UpdateProjectileConfigs.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateProjectileConfigs::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            86, "UpdateEmotes", meridian.protocol.packets.assets.UpdateEmotes.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateEmotes::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            87, "UpdatePhysicalMaterials", meridian.protocol.packets.assets.UpdatePhysicalMaterials.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdatePhysicalMaterials::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            88, "UpdateMusicContainers", meridian.protocol.packets.assets.UpdateMusicContainers.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateMusicContainers::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            89, "UpdateAudioStates", meridian.protocol.packets.assets.UpdateAudioStates.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateAudioStates::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            90, "UpdateConnectedBlockRuleSets", meridian.protocol.packets.assets.UpdateConnectedBlockRuleSets.class,
            2, 1677721600, true,
            meridian.protocol.packets.assets.UpdateConnectedBlockRuleSets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            91, "UpdateMusicTransitions", meridian.protocol.packets.assets.UpdateMusicTransitions.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateMusicTransitions::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            92, "UpdateStingers", meridian.protocol.packets.assets.UpdateStingers.class,
            6, 1677721600, true,
            meridian.protocol.packets.assets.UpdateStingers::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            100, "SetClientId", meridian.protocol.packets.player.SetClientId.class,
            4, 4, false,
            meridian.protocol.packets.player.SetClientId::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            101, "SetGameMode", meridian.protocol.packets.player.SetGameMode.class,
            1, 1, false,
            meridian.protocol.packets.player.SetGameMode::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            102, "SetMovementStates", meridian.protocol.packets.player.SetMovementStates.class,
            2, 2, false,
            meridian.protocol.packets.player.SetMovementStates::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            103, "SetBlockPlacementOverride", meridian.protocol.packets.player.SetBlockPlacementOverride.class,
            1, 1, false,
            meridian.protocol.packets.player.SetBlockPlacementOverride::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            104, "JoinWorld", meridian.protocol.packets.player.JoinWorld.class,
            26, 26, false,
            meridian.protocol.packets.player.JoinWorld::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            105, "ClientReady", meridian.protocol.packets.player.ClientReady.class,
            1, 1, false,
            meridian.protocol.packets.player.ClientReady::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            106, "LoadHotbar", meridian.protocol.packets.player.LoadHotbar.class,
            1, 1, false,
            meridian.protocol.packets.player.LoadHotbar::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            107, "SaveHotbar", meridian.protocol.packets.player.SaveHotbar.class,
            1, 1, false,
            meridian.protocol.packets.player.SaveHotbar::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            108, "ClientMovement", meridian.protocol.packets.player.ClientMovement.class,
            117, 117, false,
            meridian.protocol.packets.player.ClientMovement::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            109, "ClientTeleport", meridian.protocol.packets.player.ClientTeleport.class,
            55, 55, false,
            meridian.protocol.packets.player.ClientTeleport::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            110, "UpdateMovementSettings", meridian.protocol.packets.player.UpdateMovementSettings.class,
            259, 259, false,
            meridian.protocol.packets.player.UpdateMovementSettings::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            111, "MouseInteraction", meridian.protocol.packets.player.MouseInteraction.class,
            44, 20480071, false,
            meridian.protocol.packets.player.MouseInteraction::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            112, "DamageInfo", meridian.protocol.packets.player.DamageInfo.class,
            29, 32768048, false,
            meridian.protocol.packets.player.DamageInfo::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            113, "ReticleEvent", meridian.protocol.packets.player.ReticleEvent.class,
            4, 4, false,
            meridian.protocol.packets.player.ReticleEvent::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            114, "DisplayDebug", meridian.protocol.packets.player.DisplayDebug.class,
            23, 32768041, false,
            meridian.protocol.packets.player.DisplayDebug::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            115, "ClearDebugShapes", meridian.protocol.packets.player.ClearDebugShapes.class,
            0, 0, false,
            meridian.protocol.packets.player.ClearDebugShapes::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            116, "SyncPlayerPreferences", meridian.protocol.packets.player.SyncPlayerPreferences.class,
            14, 14, false,
            meridian.protocol.packets.player.SyncPlayerPreferences::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            118, "UpdateMemoriesFeatureStatus", meridian.protocol.packets.player.UpdateMemoriesFeatureStatus.class,
            1, 1, false,
            meridian.protocol.packets.player.UpdateMemoriesFeatureStatus::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            119, "RemoveMapMarker", meridian.protocol.packets.player.RemoveMapMarker.class,
            0, 16384005, false,
            meridian.protocol.packets.player.RemoveMapMarker::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            120, "UpdateMemoriesCount", meridian.protocol.packets.player.UpdateMemoriesCount.class,
            4, 4, false,
            meridian.protocol.packets.player.UpdateMemoriesCount::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            121, "SetNoClip", meridian.protocol.packets.player.SetNoClip.class,
            1, 1, false,
            meridian.protocol.packets.player.SetNoClip::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            122, "RequestNoClip", meridian.protocol.packets.player.RequestNoClip.class,
            1, 1, false,
            meridian.protocol.packets.player.RequestNoClip::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            131, "SetChunk", meridian.protocol.packets.world.SetChunk.class,
            13, 12288040, true,
            meridian.protocol.packets.world.SetChunk::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            132, "SetChunkHeightmap", meridian.protocol.packets.world.SetChunkHeightmap.class,
            8, 4096013, true,
            meridian.protocol.packets.world.SetChunkHeightmap::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            133, "SetChunkTintmap", meridian.protocol.packets.world.SetChunkTintmap.class,
            8, 4096013, true,
            meridian.protocol.packets.world.SetChunkTintmap::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            134, "SetChunkEnvironments", meridian.protocol.packets.world.SetChunkEnvironments.class,
            8, 4096013, true,
            meridian.protocol.packets.world.SetChunkEnvironments::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            135, "UnloadChunk", meridian.protocol.packets.world.UnloadChunk.class,
            8, 8, false,
            meridian.protocol.packets.world.UnloadChunk::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            136, "SetFluids", meridian.protocol.packets.world.SetFluids.class,
            13, 4096018, true,
            meridian.protocol.packets.world.SetFluids::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            137, "UnloadSection", meridian.protocol.packets.world.UnloadSection.class,
            12, 12, false,
            meridian.protocol.packets.world.UnloadSection::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            138, "SetColumn", meridian.protocol.packets.world.SetColumn.class,
            8, 12288035, true,
            meridian.protocol.packets.world.SetColumn::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            139, "ClearChunks", meridian.protocol.packets.world.ClearChunks.class,
            0, 0, false,
            meridian.protocol.packets.world.ClearChunks::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            140, "ServerSetBlock", meridian.protocol.packets.world.ServerSetBlock.class,
            19, 19, false,
            meridian.protocol.packets.world.ServerSetBlock::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            141, "ServerSetBlocks", meridian.protocol.packets.world.ServerSetBlocks.class,
            12, 36864017, false,
            meridian.protocol.packets.world.ServerSetBlocks::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            142, "ServerSetFluid", meridian.protocol.packets.world.ServerSetFluid.class,
            17, 17, false,
            meridian.protocol.packets.world.ServerSetFluid::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            143, "ServerSetFluids", meridian.protocol.packets.world.ServerSetFluids.class,
            12, 28672017, false,
            meridian.protocol.packets.world.ServerSetFluids::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            144, "UpdateBlockDamage", meridian.protocol.packets.world.UpdateBlockDamage.class,
            21, 21, false,
            meridian.protocol.packets.world.UpdateBlockDamage::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            145, "UpdateTimeSettings", meridian.protocol.packets.world.UpdateTimeSettings.class,
            10, 10, false,
            meridian.protocol.packets.world.UpdateTimeSettings::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            146, "UpdateTime", meridian.protocol.packets.world.UpdateTime.class,
            13, 13, false,
            meridian.protocol.packets.world.UpdateTime::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            147, "UpdateEditorTimeOverride", meridian.protocol.packets.world.UpdateEditorTimeOverride.class,
            13, 13, false,
            meridian.protocol.packets.world.UpdateEditorTimeOverride::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            148, "ClearEditorTimeOverride", meridian.protocol.packets.world.ClearEditorTimeOverride.class,
            0, 0, false,
            meridian.protocol.packets.world.ClearEditorTimeOverride::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            149, "UpdateWeather", meridian.protocol.packets.world.UpdateWeather.class,
            8, 8, false,
            meridian.protocol.packets.world.UpdateWeather::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            150, "UpdateEditorWeatherOverride", meridian.protocol.packets.world.UpdateEditorWeatherOverride.class,
            4, 4, false,
            meridian.protocol.packets.world.UpdateEditorWeatherOverride::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            151, "UpdateForcedMusic", meridian.protocol.packets.world.UpdateForcedMusic.class,
            4, 4, false,
            meridian.protocol.packets.world.UpdateForcedMusic::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            152, "SpawnParticleSystem", meridian.protocol.packets.world.SpawnParticleSystem.class,
            48, 16384053, false,
            meridian.protocol.packets.world.SpawnParticleSystem::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            153, "SpawnBlockParticleSystem", meridian.protocol.packets.world.SpawnBlockParticleSystem.class,
            30, 30, false,
            meridian.protocol.packets.world.SpawnBlockParticleSystem::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            154, "PlaySoundEvent2D", meridian.protocol.packets.world.PlaySoundEvent2D.class,
            13, 13, false,
            meridian.protocol.packets.world.PlaySoundEvent2D::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            155, "PlaySoundEvent3D", meridian.protocol.packets.world.PlaySoundEvent3D.class,
            38, 38, false,
            meridian.protocol.packets.world.PlaySoundEvent3D::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            156, "PlaySoundEventEntity", meridian.protocol.packets.world.PlaySoundEventEntity.class,
            16, 16, false,
            meridian.protocol.packets.world.PlaySoundEventEntity::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            157, "UpdateSleepState", meridian.protocol.packets.world.UpdateSleepState.class,
            35, 65536049, false,
            meridian.protocol.packets.world.UpdateSleepState::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            158, "SetPaused", meridian.protocol.packets.world.SetPaused.class,
            1, 1, false,
            meridian.protocol.packets.world.SetPaused::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            159, "ServerSetPaused", meridian.protocol.packets.world.ServerSetPaused.class,
            1, 1, false,
            meridian.protocol.packets.world.ServerSetPaused::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            160, "SetEntitySeed", meridian.protocol.packets.entities.SetEntitySeed.class,
            4, 4, false,
            meridian.protocol.packets.entities.SetEntitySeed::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            161, "EntityUpdates", meridian.protocol.packets.entities.EntityUpdates.class,
            1, 1677721600, true,
            meridian.protocol.packets.entities.EntityUpdates::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            162, "PlayAnimation", meridian.protocol.packets.entities.PlayAnimation.class,
            6, 32768024, false,
            meridian.protocol.packets.entities.PlayAnimation::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            163, "ChangeVelocity", meridian.protocol.packets.entities.ChangeVelocity.class,
            35, 35, false,
            meridian.protocol.packets.entities.ChangeVelocity::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            164, "ApplyKnockback", meridian.protocol.packets.entities.ApplyKnockback.class,
            38, 38, false,
            meridian.protocol.packets.entities.ApplyKnockback::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            165, "SpawnModelParticles", meridian.protocol.packets.entities.SpawnModelParticles.class,
            5, 1677721600, false,
            meridian.protocol.packets.entities.SpawnModelParticles::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            166, "MountMovement", meridian.protocol.packets.entities.MountMovement.class,
            40, 40, false,
            meridian.protocol.packets.entities.MountMovement::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            167, "PlayEmote", meridian.protocol.packets.entities.PlayEmote.class,
            1, 16384006, false,
            meridian.protocol.packets.entities.PlayEmote::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            168, "SetAudioState", meridian.protocol.packets.world.SetAudioState.class,
            9, 16384029, false,
            meridian.protocol.packets.world.SetAudioState::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            169, "SetBlockMusicEmitter", meridian.protocol.packets.world.SetBlockMusicEmitter.class,
            50, 50, false,
            meridian.protocol.packets.world.SetBlockMusicEmitter::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            170, "UpdatePlayerInventory", meridian.protocol.packets.inventory.UpdatePlayerInventory.class,
            1, 1677721600, true,
            meridian.protocol.packets.inventory.UpdatePlayerInventory::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            171, "SetCreativeItem", meridian.protocol.packets.inventory.SetCreativeItem.class,
            9, 16384018, false,
            meridian.protocol.packets.inventory.SetCreativeItem::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            172, "DropCreativeItem", meridian.protocol.packets.inventory.DropCreativeItem.class,
            0, 16384009, false,
            meridian.protocol.packets.inventory.DropCreativeItem::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            173, "SmartGiveCreativeItem", meridian.protocol.packets.inventory.SmartGiveCreativeItem.class,
            1, 16384010, false,
            meridian.protocol.packets.inventory.SmartGiveCreativeItem::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            174, "DropItemStack", meridian.protocol.packets.inventory.DropItemStack.class,
            12, 12, false,
            meridian.protocol.packets.inventory.DropItemStack::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            175, "MoveItemStack", meridian.protocol.packets.inventory.MoveItemStack.class,
            20, 20, false,
            meridian.protocol.packets.inventory.MoveItemStack::toObject);
        register(
            PacketDirection.Both, NetworkChannel.Default,
            176, "SmartMoveItemStack", meridian.protocol.packets.inventory.SmartMoveItemStack.class,
            13, 13, false,
            meridian.protocol.packets.inventory.SmartMoveItemStack::toObject);
        register(
            PacketDirection.Both, NetworkChannel.Default,
            177, "SetActiveSlot", meridian.protocol.packets.inventory.SetActiveSlot.class,
            8, 8, false,
            meridian.protocol.packets.inventory.SetActiveSlot::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            178, "SwitchHotbarBlockSet", meridian.protocol.packets.inventory.SwitchHotbarBlockSet.class,
            1, 16384006, false,
            meridian.protocol.packets.inventory.SwitchHotbarBlockSet::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            179, "InventoryAction", meridian.protocol.packets.inventory.InventoryAction.class,
            6, 6, false,
            meridian.protocol.packets.inventory.InventoryAction::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            180, "PostMusicEvent", meridian.protocol.packets.world.PostMusicEvent.class,
            1, 1030, false,
            meridian.protocol.packets.world.PostMusicEvent::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            181, "SetAbsentChunks", meridian.protocol.packets.world.SetAbsentChunks.class,
            9, 526, true,
            meridian.protocol.packets.world.SetAbsentChunks::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            182, "UnloadChunks", meridian.protocol.packets.world.UnloadChunks.class,
            1, 81939, true,
            meridian.protocol.packets.world.UnloadChunks::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            200, "OpenWindow", meridian.protocol.packets.window.OpenWindow.class,
            6, 1677721600, true,
            meridian.protocol.packets.window.OpenWindow::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            201, "UpdateWindow", meridian.protocol.packets.window.UpdateWindow.class,
            5, 1677721600, true,
            meridian.protocol.packets.window.UpdateWindow::toObject);
        register(
            PacketDirection.Both, NetworkChannel.Default,
            202, "CloseWindow", meridian.protocol.packets.window.CloseWindow.class,
            4, 4, false,
            meridian.protocol.packets.window.CloseWindow::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            203, "SendWindowAction", meridian.protocol.packets.window.SendWindowAction.class,
            4, 32768027, false,
            meridian.protocol.packets.window.SendWindowAction::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            204, "ClientOpenWindow", meridian.protocol.packets.window.ClientOpenWindow.class,
            1, 1, false,
            meridian.protocol.packets.window.ClientOpenWindow::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            210, "ServerMessage", meridian.protocol.packets.interface_.ServerMessage.class,
            2, 1677721600, false,
            meridian.protocol.packets.interface_.ServerMessage::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            211, "ChatMessage", meridian.protocol.packets.interface_.ChatMessage.class,
            1, 1026, false,
            meridian.protocol.packets.interface_.ChatMessage::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            212, "Notification", meridian.protocol.packets.interface_.Notification.class,
            2, 1677721600, false,
            meridian.protocol.packets.interface_.Notification::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            213, "KillFeedMessage", meridian.protocol.packets.interface_.KillFeedMessage.class,
            1, 1677721600, false,
            meridian.protocol.packets.interface_.KillFeedMessage::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            214, "ShowEventTitle", meridian.protocol.packets.interface_.ShowEventTitle.class,
            14, 1677721600, false,
            meridian.protocol.packets.interface_.ShowEventTitle::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            215, "HideEventTitle", meridian.protocol.packets.interface_.HideEventTitle.class,
            4, 4, false,
            meridian.protocol.packets.interface_.HideEventTitle::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            216, "SetPage", meridian.protocol.packets.interface_.SetPage.class,
            2, 2, false,
            meridian.protocol.packets.interface_.SetPage::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            217, "CustomHud", meridian.protocol.packets.interface_.CustomHud.class,
            6, 1677721600, true,
            meridian.protocol.packets.interface_.CustomHud::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            218, "CustomPage", meridian.protocol.packets.interface_.CustomPage.class,
            3, 1677721600, true,
            meridian.protocol.packets.interface_.CustomPage::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            219, "CustomPageEvent", meridian.protocol.packets.interface_.CustomPageEvent.class,
            2, 16384007, false,
            meridian.protocol.packets.interface_.CustomPageEvent::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            222, "EditorBlocksChange", meridian.protocol.packets.interface_.EditorBlocksChange.class,
            68, 1677721600, true,
            meridian.protocol.packets.interface_.EditorBlocksChange::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            223, "ServerInfo", meridian.protocol.packets.interface_.ServerInfo.class,
            5, 32769058, false,
            meridian.protocol.packets.interface_.ServerInfo::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            224, "AddToServerPlayerList", meridian.protocol.packets.interface_.AddToServerPlayerList.class,
            0, 1677721600, false,
            meridian.protocol.packets.interface_.AddToServerPlayerList::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            225, "RemoveFromServerPlayerList", meridian.protocol.packets.interface_.RemoveFromServerPlayerList.class,
            0, 65536005, false,
            meridian.protocol.packets.interface_.RemoveFromServerPlayerList::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            226, "UpdateServerPlayerList", meridian.protocol.packets.interface_.UpdateServerPlayerList.class,
            0, 131072005, false,
            meridian.protocol.packets.interface_.UpdateServerPlayerList::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            227, "UpdateServerPlayerListPing", meridian.protocol.packets.interface_.UpdateServerPlayerListPing.class,
            0, 81920005, false,
            meridian.protocol.packets.interface_.UpdateServerPlayerListPing::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            228, "UpdateKnownRecipes", meridian.protocol.packets.interface_.UpdateKnownRecipes.class,
            1, 1677721600, false,
            meridian.protocol.packets.interface_.UpdateKnownRecipes::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            229, "UpdatePortal", meridian.protocol.packets.interface_.UpdatePortal.class,
            6, 16384020, false,
            meridian.protocol.packets.interface_.UpdatePortal::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            230, "UpdateVisibleHudComponents", meridian.protocol.packets.interface_.UpdateVisibleHudComponents.class,
            1, 4096006, false,
            meridian.protocol.packets.interface_.UpdateVisibleHudComponents::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            231, "ResetUserInterfaceState", meridian.protocol.packets.interface_.ResetUserInterfaceState.class,
            0, 0, false,
            meridian.protocol.packets.interface_.ResetUserInterfaceState::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            232, "UpdateLanguage", meridian.protocol.packets.interface_.UpdateLanguage.class,
            1, 16384006, false,
            meridian.protocol.packets.interface_.UpdateLanguage::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            233, "WorldSavingStatus", meridian.protocol.packets.interface_.WorldSavingStatus.class,
            1, 1, false,
            meridian.protocol.packets.interface_.WorldSavingStatus::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            234, "OpenChatWithCommand", meridian.protocol.packets.interface_.OpenChatWithCommand.class,
            1, 16384006, false,
            meridian.protocol.packets.interface_.OpenChatWithCommand::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            235, "UpdateAnchorUI", meridian.protocol.packets.interface_.UpdateAnchorUI.class,
            2, 1677721600, true,
            meridian.protocol.packets.interface_.UpdateAnchorUI::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            236, "UpdateBossBar", meridian.protocol.packets.interface_.UpdateBossBar.class,
            6, 1677721600, false,
            meridian.protocol.packets.interface_.UpdateBossBar::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            238, "CommandTreeSync", meridian.protocol.packets.interface_.CommandTreeSync.class,
            1, 1677721600, true,
            meridian.protocol.packets.interface_.CommandTreeSync::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            239, "ArgValuesRequest", meridian.protocol.packets.interface_.ArgValuesRequest.class,
            1, 32768019, false,
            meridian.protocol.packets.interface_.ArgValuesRequest::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            240, "UpdateWorldMapSettings", meridian.protocol.packets.worldmap.UpdateWorldMapSettings.class,
            13, 13, false,
            meridian.protocol.packets.worldmap.UpdateWorldMapSettings::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.WorldMap,
            241, "UpdateWorldMap", meridian.protocol.packets.worldmap.UpdateWorldMap.class,
            1, 1677721600, true,
            meridian.protocol.packets.worldmap.UpdateWorldMap::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.WorldMap,
            242, "ClearWorldMap", meridian.protocol.packets.worldmap.ClearWorldMap.class,
            0, 0, false,
            meridian.protocol.packets.worldmap.ClearWorldMap::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            243, "UpdateWorldMapVisible", meridian.protocol.packets.worldmap.UpdateWorldMapVisible.class,
            1, 1, false,
            meridian.protocol.packets.worldmap.UpdateWorldMapVisible::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            244, "TeleportToWorldMapMarker", meridian.protocol.packets.worldmap.TeleportToWorldMapMarker.class,
            0, 16384005, false,
            meridian.protocol.packets.worldmap.TeleportToWorldMapMarker::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            245, "TeleportToWorldMapPosition", meridian.protocol.packets.worldmap.TeleportToWorldMapPosition.class,
            8, 8, false,
            meridian.protocol.packets.worldmap.TeleportToWorldMapPosition::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            246, "CreateUserMarker", meridian.protocol.packets.worldmap.CreateUserMarker.class,
            13, 32768031, false,
            meridian.protocol.packets.worldmap.CreateUserMarker::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            247, "ArgValuesResponse", meridian.protocol.packets.interface_.ArgValuesResponse.class,
            2, 1677721600, false,
            meridian.protocol.packets.interface_.ArgValuesResponse::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            248, "ArgCacheInvalidation", meridian.protocol.packets.interface_.ArgCacheInvalidation.class,
            1, 1677721600, false,
            meridian.protocol.packets.interface_.ArgCacheInvalidation::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            249, "UpdateLivesRemaining", meridian.protocol.packets.interface_.UpdateLivesRemaining.class,
            5, 5, false,
            meridian.protocol.packets.interface_.UpdateLivesRemaining::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            250, "RequestServerAccess", meridian.protocol.packets.serveraccess.RequestServerAccess.class,
            3, 3, false,
            meridian.protocol.packets.serveraccess.RequestServerAccess::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            251, "UpdateServerAccess", meridian.protocol.packets.serveraccess.UpdateServerAccess.class,
            1, 1677721600, false,
            meridian.protocol.packets.serveraccess.UpdateServerAccess::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            252, "SetServerAccess", meridian.protocol.packets.serveraccess.SetServerAccess.class,
            2, 16384007, false,
            meridian.protocol.packets.serveraccess.SetServerAccess::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Chunks,
            253, "SetBlockAnimationSpeeds", meridian.protocol.packets.world.SetBlockAnimationSpeeds.class,
            20, 557081, true,
            meridian.protocol.packets.world.SetBlockAnimationSpeeds::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            260, "RequestMachinimaActorModel", meridian.protocol.packets.machinima.RequestMachinimaActorModel.class,
            1, 49152028, false,
            meridian.protocol.packets.machinima.RequestMachinimaActorModel::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            261, "SetMachinimaActorModel", meridian.protocol.packets.machinima.SetMachinimaActorModel.class,
            1, 1677721600, false,
            meridian.protocol.packets.machinima.SetMachinimaActorModel::toObject);
        register(
            PacketDirection.Both, NetworkChannel.Default,
            262, "UpdateMachinimaScene", meridian.protocol.packets.machinima.UpdateMachinimaScene.class,
            6, 36864033, true,
            meridian.protocol.packets.machinima.UpdateMachinimaScene::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            280, "SetServerCamera", meridian.protocol.packets.camera.SetServerCamera.class,
            182, 182, false,
            meridian.protocol.packets.camera.SetServerCamera::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            281, "CameraShakeEffect", meridian.protocol.packets.camera.CameraShakeEffect.class,
            9, 9, false,
            meridian.protocol.packets.camera.CameraShakeEffect::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            282, "RequestFlyCameraMode", meridian.protocol.packets.camera.RequestFlyCameraMode.class,
            1, 1, false,
            meridian.protocol.packets.camera.RequestFlyCameraMode::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            283, "SetFlyCameraMode", meridian.protocol.packets.camera.SetFlyCameraMode.class,
            1, 1, false,
            meridian.protocol.packets.camera.SetFlyCameraMode::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            284, "PlayCameraSequence", meridian.protocol.packets.camera.PlayCameraSequence.class,
            11, 11, false,
            meridian.protocol.packets.camera.PlayCameraSequence::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            285, "CameraSequenceKeyframes", meridian.protocol.packets.camera.CameraSequenceKeyframes.class,
            5, 12042, false,
            meridian.protocol.packets.camera.CameraSequenceKeyframes::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            286, "CameraSequenceComplete", meridian.protocol.packets.camera.CameraSequenceComplete.class,
            1, 1, false,
            meridian.protocol.packets.camera.CameraSequenceComplete::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            287, "RequestCameraSequenceKeyframes", meridian.protocol.packets.camera.RequestCameraSequenceKeyframes.class,
            9, 9, false,
            meridian.protocol.packets.camera.RequestCameraSequenceKeyframes::toObject);
        register(
            PacketDirection.Both, NetworkChannel.Default,
            290, "SyncInteractionChains", meridian.protocol.packets.interaction.SyncInteractionChains.class,
            0, 1677721600, false,
            meridian.protocol.packets.interaction.SyncInteractionChains::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            291, "CancelInteractionChain", meridian.protocol.packets.interaction.CancelInteractionChain.class,
            5, 1038, false,
            meridian.protocol.packets.interaction.CancelInteractionChain::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            292, "PlayInteractionFor", meridian.protocol.packets.interaction.PlayInteractionFor.class,
            19, 16385065, false,
            meridian.protocol.packets.interaction.PlayInteractionFor::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            293, "MountNPC", meridian.protocol.packets.interaction.MountNPC.class,
            16, 16, false,
            meridian.protocol.packets.interaction.MountNPC::toObject);
        register(
            PacketDirection.Both, NetworkChannel.Default,
            294, "DismountNPC", meridian.protocol.packets.interaction.DismountNPC.class,
            4, 4, false,
            meridian.protocol.packets.interaction.DismountNPC::toObject);
        register(
            PacketDirection.Both, NetworkChannel.Default,
            300, "FailureReply", meridian.protocol.packets.asseteditor.FailureReply.class,
            5, 1677721600, false,
            meridian.protocol.packets.asseteditor.FailureReply::toObject);
        register(
            PacketDirection.Both, NetworkChannel.Default,
            301, "SuccessReply", meridian.protocol.packets.asseteditor.SuccessReply.class,
            5, 1677721600, false,
            meridian.protocol.packets.asseteditor.SuccessReply::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            302, "AssetEditorInitialize", meridian.protocol.packets.asseteditor.AssetEditorInitialize.class,
            0, 0, false,
            meridian.protocol.packets.asseteditor.AssetEditorInitialize::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            303, "AssetEditorAuthorization", meridian.protocol.packets.asseteditor.AssetEditorAuthorization.class,
            1, 1, false,
            meridian.protocol.packets.asseteditor.AssetEditorAuthorization::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            304, "AssetEditorCapabilities", meridian.protocol.packets.asseteditor.AssetEditorCapabilities.class,
            1, 1, false,
            meridian.protocol.packets.asseteditor.AssetEditorCapabilities::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            305, "AssetEditorSetupSchemas", meridian.protocol.packets.asseteditor.AssetEditorSetupSchemas.class,
            1, 1677721600, true,
            meridian.protocol.packets.asseteditor.AssetEditorSetupSchemas::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            306, "AssetEditorSetupAssetTypes", meridian.protocol.packets.asseteditor.AssetEditorSetupAssetTypes.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorSetupAssetTypes::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            307, "AssetEditorCreateDirectory", meridian.protocol.packets.asseteditor.AssetEditorCreateDirectory.class,
            5, 32768024, false,
            meridian.protocol.packets.asseteditor.AssetEditorCreateDirectory::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            308, "AssetEditorDeleteDirectory", meridian.protocol.packets.asseteditor.AssetEditorDeleteDirectory.class,
            5, 32768024, false,
            meridian.protocol.packets.asseteditor.AssetEditorDeleteDirectory::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            309, "AssetEditorRenameDirectory", meridian.protocol.packets.asseteditor.AssetEditorRenameDirectory.class,
            5, 65536051, false,
            meridian.protocol.packets.asseteditor.AssetEditorRenameDirectory::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            310, "AssetEditorFetchAsset", meridian.protocol.packets.asseteditor.AssetEditorFetchAsset.class,
            6, 32768025, false,
            meridian.protocol.packets.asseteditor.AssetEditorFetchAsset::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            311, "AssetEditorFetchJsonAssetWithParents", meridian.protocol.packets.asseteditor.AssetEditorFetchJsonAssetWithParents.class,
            6, 32768025, false,
            meridian.protocol.packets.asseteditor.AssetEditorFetchJsonAssetWithParents::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            312, "AssetEditorFetchAssetReply", meridian.protocol.packets.asseteditor.AssetEditorFetchAssetReply.class,
            5, 4096010, false,
            meridian.protocol.packets.asseteditor.AssetEditorFetchAssetReply::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            313, "AssetEditorFetchJsonAssetWithParentsReply", meridian.protocol.packets.asseteditor.AssetEditorFetchJsonAssetWithParentsReply.class,
            5, 1677721600, true,
            meridian.protocol.packets.asseteditor.AssetEditorFetchJsonAssetWithParentsReply::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            314, "AssetEditorAssetPackSetup", meridian.protocol.packets.asseteditor.AssetEditorAssetPackSetup.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorAssetPackSetup::toObject);
        register(
            PacketDirection.Both, NetworkChannel.Default,
            315, "AssetEditorUpdateAssetPack", meridian.protocol.packets.asseteditor.AssetEditorUpdateAssetPack.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorUpdateAssetPack::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            316, "AssetEditorCreateAssetPack", meridian.protocol.packets.asseteditor.AssetEditorCreateAssetPack.class,
            9, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorCreateAssetPack::toObject);
        register(
            PacketDirection.Both, NetworkChannel.Default,
            317, "AssetEditorDeleteAssetPack", meridian.protocol.packets.asseteditor.AssetEditorDeleteAssetPack.class,
            1, 16384006, false,
            meridian.protocol.packets.asseteditor.AssetEditorDeleteAssetPack::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            319, "AssetEditorAssetListSetup", meridian.protocol.packets.asseteditor.AssetEditorAssetListSetup.class,
            3, 1677721600, true,
            meridian.protocol.packets.asseteditor.AssetEditorAssetListSetup::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            320, "AssetEditorAssetListUpdate", meridian.protocol.packets.asseteditor.AssetEditorAssetListUpdate.class,
            1, 1677721600, true,
            meridian.protocol.packets.asseteditor.AssetEditorAssetListUpdate::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            321, "AssetEditorRequestChildrenList", meridian.protocol.packets.asseteditor.AssetEditorRequestChildrenList.class,
            1, 32768020, false,
            meridian.protocol.packets.asseteditor.AssetEditorRequestChildrenList::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            322, "AssetEditorRequestChildrenListReply", meridian.protocol.packets.asseteditor.AssetEditorRequestChildrenListReply.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorRequestChildrenListReply::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            323, "AssetEditorUpdateJsonAsset", meridian.protocol.packets.asseteditor.AssetEditorUpdateJsonAsset.class,
            9, 1677721600, true,
            meridian.protocol.packets.asseteditor.AssetEditorUpdateJsonAsset::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            324, "AssetEditorUpdateAsset", meridian.protocol.packets.asseteditor.AssetEditorUpdateAsset.class,
            9, 53248050, false,
            meridian.protocol.packets.asseteditor.AssetEditorUpdateAsset::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            325, "AssetEditorJsonAssetUpdated", meridian.protocol.packets.asseteditor.AssetEditorJsonAssetUpdated.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorJsonAssetUpdated::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            326, "AssetEditorAssetUpdated", meridian.protocol.packets.asseteditor.AssetEditorAssetUpdated.class,
            1, 36864033, false,
            meridian.protocol.packets.asseteditor.AssetEditorAssetUpdated::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            327, "AssetEditorCreateAsset", meridian.protocol.packets.asseteditor.AssetEditorCreateAsset.class,
            6, 53248047, false,
            meridian.protocol.packets.asseteditor.AssetEditorCreateAsset::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            328, "AssetEditorRenameAsset", meridian.protocol.packets.asseteditor.AssetEditorRenameAsset.class,
            5, 65536051, false,
            meridian.protocol.packets.asseteditor.AssetEditorRenameAsset::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            329, "AssetEditorDeleteAsset", meridian.protocol.packets.asseteditor.AssetEditorDeleteAsset.class,
            5, 32768024, false,
            meridian.protocol.packets.asseteditor.AssetEditorDeleteAsset::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            330, "AssetEditorDiscardChanges", meridian.protocol.packets.asseteditor.AssetEditorDiscardChanges.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorDiscardChanges::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            331, "AssetEditorFetchAutoCompleteData", meridian.protocol.packets.asseteditor.AssetEditorFetchAutoCompleteData.class,
            5, 32768023, false,
            meridian.protocol.packets.asseteditor.AssetEditorFetchAutoCompleteData::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            332, "AssetEditorFetchAutoCompleteDataReply", meridian.protocol.packets.asseteditor.AssetEditorFetchAutoCompleteDataReply.class,
            5, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorFetchAutoCompleteDataReply::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            333, "AssetEditorRequestDataset", meridian.protocol.packets.asseteditor.AssetEditorRequestDataset.class,
            1, 16384006, false,
            meridian.protocol.packets.asseteditor.AssetEditorRequestDataset::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            334, "AssetEditorRequestDatasetReply", meridian.protocol.packets.asseteditor.AssetEditorRequestDatasetReply.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorRequestDatasetReply::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            335, "AssetEditorActivateButton", meridian.protocol.packets.asseteditor.AssetEditorActivateButton.class,
            1, 16384006, false,
            meridian.protocol.packets.asseteditor.AssetEditorActivateButton::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            336, "AssetEditorSelectAsset", meridian.protocol.packets.asseteditor.AssetEditorSelectAsset.class,
            1, 32768020, false,
            meridian.protocol.packets.asseteditor.AssetEditorSelectAsset::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            337, "AssetEditorPopupNotification", meridian.protocol.packets.asseteditor.AssetEditorPopupNotification.class,
            2, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorPopupNotification::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            338, "AssetEditorFetchLastModifiedAssets", meridian.protocol.packets.asseteditor.AssetEditorFetchLastModifiedAssets.class,
            0, 0, false,
            meridian.protocol.packets.asseteditor.AssetEditorFetchLastModifiedAssets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            339, "AssetEditorLastModifiedAssets", meridian.protocol.packets.asseteditor.AssetEditorLastModifiedAssets.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorLastModifiedAssets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            340, "AssetEditorModifiedAssetsCount", meridian.protocol.packets.asseteditor.AssetEditorModifiedAssetsCount.class,
            4, 4, false,
            meridian.protocol.packets.asseteditor.AssetEditorModifiedAssetsCount::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            341, "AssetEditorSubscribeModifiedAssetsChanges", meridian.protocol.packets.asseteditor.AssetEditorSubscribeModifiedAssetsChanges.class,
            1, 1, false,
            meridian.protocol.packets.asseteditor.AssetEditorSubscribeModifiedAssetsChanges::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            342, "AssetEditorExportAssets", meridian.protocol.packets.asseteditor.AssetEditorExportAssets.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorExportAssets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            343, "AssetEditorExportAssetInitialize", meridian.protocol.packets.asseteditor.AssetEditorExportAssetInitialize.class,
            6, 81920066, false,
            meridian.protocol.packets.asseteditor.AssetEditorExportAssetInitialize::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            344, "AssetEditorExportAssetPart", meridian.protocol.packets.asseteditor.AssetEditorExportAssetPart.class,
            1, 4096006, true,
            meridian.protocol.packets.asseteditor.AssetEditorExportAssetPart::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            345, "AssetEditorExportAssetFinalize", meridian.protocol.packets.asseteditor.AssetEditorExportAssetFinalize.class,
            0, 0, false,
            meridian.protocol.packets.asseteditor.AssetEditorExportAssetFinalize::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            346, "AssetEditorExportDeleteAssets", meridian.protocol.packets.asseteditor.AssetEditorExportDeleteAssets.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorExportDeleteAssets::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            347, "AssetEditorExportComplete", meridian.protocol.packets.asseteditor.AssetEditorExportComplete.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorExportComplete::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            349, "AssetEditorUndoChanges", meridian.protocol.packets.asseteditor.AssetEditorUndoChanges.class,
            5, 32768024, false,
            meridian.protocol.packets.asseteditor.AssetEditorUndoChanges::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            350, "AssetEditorRedoChanges", meridian.protocol.packets.asseteditor.AssetEditorRedoChanges.class,
            5, 32768024, false,
            meridian.protocol.packets.asseteditor.AssetEditorRedoChanges::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            351, "AssetEditorUndoRedoReply", meridian.protocol.packets.asseteditor.AssetEditorUndoRedoReply.class,
            5, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorUndoRedoReply::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            352, "AssetEditorSetGameTime", meridian.protocol.packets.asseteditor.AssetEditorSetGameTime.class,
            14, 14, false,
            meridian.protocol.packets.asseteditor.AssetEditorSetGameTime::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            353, "AssetEditorUpdateSecondsPerGameDay", meridian.protocol.packets.asseteditor.AssetEditorUpdateSecondsPerGameDay.class,
            8, 8, false,
            meridian.protocol.packets.asseteditor.AssetEditorUpdateSecondsPerGameDay::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            354, "AssetEditorUpdateWeatherPreviewLock", meridian.protocol.packets.asseteditor.AssetEditorUpdateWeatherPreviewLock.class,
            1, 1, false,
            meridian.protocol.packets.asseteditor.AssetEditorUpdateWeatherPreviewLock::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            355, "AssetEditorUpdateModelPreview", meridian.protocol.packets.asseteditor.AssetEditorUpdateModelPreview.class,
            29, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorUpdateModelPreview::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            356, "AssetEditorModsDirectories", meridian.protocol.packets.asseteditor.AssetEditorModsDirectories.class,
            1, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorModsDirectories::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            357, "AssetEditorRequestAssetInheritance", meridian.protocol.packets.asseteditor.AssetEditorRequestAssetInheritance.class,
            5, 32768024, false,
            meridian.protocol.packets.asseteditor.AssetEditorRequestAssetInheritance::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            358, "AssetEditorRequestAssetInheritanceReply", meridian.protocol.packets.asseteditor.AssetEditorRequestAssetInheritanceReply.class,
            5, 1677721600, false,
            meridian.protocol.packets.asseteditor.AssetEditorRequestAssetInheritanceReply::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            360, "UpdateSunSettings", meridian.protocol.packets.world.UpdateSunSettings.class,
            8, 8, false,
            meridian.protocol.packets.world.UpdateSunSettings::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            361, "UpdatePostFxSettings", meridian.protocol.packets.world.UpdatePostFxSettings.class,
            20, 20, false,
            meridian.protocol.packets.world.UpdatePostFxSettings::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            362, "PlaySoundEventLocalPlayer", meridian.protocol.packets.world.PlaySoundEventLocalPlayer.class,
            17, 17, false,
            meridian.protocol.packets.world.PlaySoundEventLocalPlayer::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            363, "InsecurePlayerOptions", meridian.protocol.packets.connection.InsecurePlayerOptions.class,
            17, 2149, false,
            meridian.protocol.packets.connection.InsecurePlayerOptions::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            364, "RequestInsecurePlayerOptions", meridian.protocol.packets.connection.RequestInsecurePlayerOptions.class,
            0, 0, false,
            meridian.protocol.packets.connection.RequestInsecurePlayerOptions::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            400, "BuilderToolArgUpdate", meridian.protocol.packets.buildertools.BuilderToolArgUpdate.class,
            13, 32768031, false,
            meridian.protocol.packets.buildertools.BuilderToolArgUpdate::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            401, "BuilderToolEntityAction", meridian.protocol.packets.buildertools.BuilderToolEntityAction.class,
            5, 5, false,
            meridian.protocol.packets.buildertools.BuilderToolEntityAction::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            402, "BuilderToolSetEntityTransform", meridian.protocol.packets.buildertools.BuilderToolSetEntityTransform.class,
            55, 55, false,
            meridian.protocol.packets.buildertools.BuilderToolSetEntityTransform::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            403, "BuilderToolExtrudeAction", meridian.protocol.packets.buildertools.BuilderToolExtrudeAction.class,
            30, 30, false,
            meridian.protocol.packets.buildertools.BuilderToolExtrudeAction::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            404, "BuilderToolStackArea", meridian.protocol.packets.buildertools.BuilderToolStackArea.class,
            41, 41, false,
            meridian.protocol.packets.buildertools.BuilderToolStackArea::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            405, "BuilderToolSelectionTransform", meridian.protocol.packets.buildertools.BuilderToolSelectionTransform.class,
            78, 78, false,
            meridian.protocol.packets.buildertools.BuilderToolSelectionTransform::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            406, "BuilderToolRotateClipboard", meridian.protocol.packets.buildertools.BuilderToolRotateClipboard.class,
            5, 5, false,
            meridian.protocol.packets.buildertools.BuilderToolRotateClipboard::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            407, "BuilderToolPasteClipboard", meridian.protocol.packets.buildertools.BuilderToolPasteClipboard.class,
            12, 12, false,
            meridian.protocol.packets.buildertools.BuilderToolPasteClipboard::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            408, "BuilderToolSetTransformationModeState", meridian.protocol.packets.buildertools.BuilderToolSetTransformationModeState.class,
            1, 1, false,
            meridian.protocol.packets.buildertools.BuilderToolSetTransformationModeState::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            409, "BuilderToolSelectionUpdate", meridian.protocol.packets.buildertools.BuilderToolSelectionUpdate.class,
            24, 24, false,
            meridian.protocol.packets.buildertools.BuilderToolSelectionUpdate::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            410, "BuilderToolSelectionToolAskForClipboard", meridian.protocol.packets.buildertools.BuilderToolSelectionToolAskForClipboard.class,
            0, 0, false,
            meridian.protocol.packets.buildertools.BuilderToolSelectionToolAskForClipboard::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            411, "BuilderToolSelectionToolReplyWithClipboard", meridian.protocol.packets.buildertools.BuilderToolSelectionToolReplyWithClipboard.class,
            26, 1677721600, true,
            meridian.protocol.packets.buildertools.BuilderToolSelectionToolReplyWithClipboard::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            412, "BuilderToolGeneralAction", meridian.protocol.packets.buildertools.BuilderToolGeneralAction.class,
            1, 1, false,
            meridian.protocol.packets.buildertools.BuilderToolGeneralAction::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            413, "BuilderToolOnUseInteraction", meridian.protocol.packets.buildertools.BuilderToolOnUseInteraction.class,
            58, 58, false,
            meridian.protocol.packets.buildertools.BuilderToolOnUseInteraction::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            414, "BuilderToolLineAction", meridian.protocol.packets.buildertools.BuilderToolLineAction.class,
            24, 24, false,
            meridian.protocol.packets.buildertools.BuilderToolLineAction::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            415, "BuilderToolShowAnchor", meridian.protocol.packets.buildertools.BuilderToolShowAnchor.class,
            12, 12, false,
            meridian.protocol.packets.buildertools.BuilderToolShowAnchor::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            416, "BuilderToolHideAnchors", meridian.protocol.packets.buildertools.BuilderToolHideAnchors.class,
            0, 0, false,
            meridian.protocol.packets.buildertools.BuilderToolHideAnchors::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            417, "PrefabUnselectPrefab", meridian.protocol.packets.buildertools.PrefabUnselectPrefab.class,
            0, 0, false,
            meridian.protocol.packets.buildertools.PrefabUnselectPrefab::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            418, "BuilderToolsSetSoundSet", meridian.protocol.packets.buildertools.BuilderToolsSetSoundSet.class,
            4, 4, false,
            meridian.protocol.packets.buildertools.BuilderToolsSetSoundSet::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            419, "BuilderToolLaserPointer", meridian.protocol.packets.buildertools.BuilderToolLaserPointer.class,
            36, 36, false,
            meridian.protocol.packets.buildertools.BuilderToolLaserPointer::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            420, "BuilderToolSetEntityScale", meridian.protocol.packets.buildertools.BuilderToolSetEntityScale.class,
            8, 8, false,
            meridian.protocol.packets.buildertools.BuilderToolSetEntityScale::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            421, "BuilderToolSetEntityPickupEnabled", meridian.protocol.packets.buildertools.BuilderToolSetEntityPickupEnabled.class,
            5, 5, false,
            meridian.protocol.packets.buildertools.BuilderToolSetEntityPickupEnabled::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            422, "BuilderToolSetEntityLight", meridian.protocol.packets.buildertools.BuilderToolSetEntityLight.class,
            9, 9, false,
            meridian.protocol.packets.buildertools.BuilderToolSetEntityLight::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            423, "BuilderToolSetNPCDebug", meridian.protocol.packets.buildertools.BuilderToolSetNPCDebug.class,
            5, 5, false,
            meridian.protocol.packets.buildertools.BuilderToolSetNPCDebug::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            424, "BuilderToolSetEntityType", meridian.protocol.packets.buildertools.BuilderToolSetEntityType.class,
            5, 16384010, false,
            meridian.protocol.packets.buildertools.BuilderToolSetEntityType::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            425, "BuilderToolSetEntityCollision", meridian.protocol.packets.buildertools.BuilderToolSetEntityCollision.class,
            5, 16384010, false,
            meridian.protocol.packets.buildertools.BuilderToolSetEntityCollision::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            426, "PrefabSetAnchor", meridian.protocol.packets.buildertools.PrefabSetAnchor.class,
            12, 12, false,
            meridian.protocol.packets.buildertools.PrefabSetAnchor::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            427, "BuilderToolResetClipboardRotation", meridian.protocol.packets.buildertools.BuilderToolResetClipboardRotation.class,
            0, 0, false,
            meridian.protocol.packets.buildertools.BuilderToolResetClipboardRotation::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            428, "BuilderToolRandomizeClipboard", meridian.protocol.packets.buildertools.BuilderToolRandomizeClipboard.class,
            13, 13, false,
            meridian.protocol.packets.buildertools.BuilderToolRandomizeClipboard::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            429, "BuilderToolPrefabPreview", meridian.protocol.packets.buildertools.BuilderToolPrefabPreview.class,
            47, 1677721600, true,
            meridian.protocol.packets.buildertools.BuilderToolPrefabPreview::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            430, "BuilderToolGMaskPreset", meridian.protocol.packets.buildertools.BuilderToolGMaskPreset.class,
            2, 32768020, false,
            meridian.protocol.packets.buildertools.BuilderToolGMaskPreset::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            431, "BuilderToolGMaskPresetLoadResponse", meridian.protocol.packets.buildertools.BuilderToolGMaskPresetLoadResponse.class,
            1, 16384006, false,
            meridian.protocol.packets.buildertools.BuilderToolGMaskPresetLoadResponse::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            432, "BuilderToolsEnabledTools", meridian.protocol.packets.buildertools.BuilderToolsEnabledTools.class,
            1, 1677721600, false,
            meridian.protocol.packets.buildertools.BuilderToolsEnabledTools::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            433, "BuilderToolColorAction", meridian.protocol.packets.buildertools.BuilderToolColorAction.class,
            55, 32768073, false,
            meridian.protocol.packets.buildertools.BuilderToolColorAction::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            434, "BuilderToolEntityTransformSessionEnd", meridian.protocol.packets.buildertools.BuilderToolEntityTransformSessionEnd.class,
            4, 4, false,
            meridian.protocol.packets.buildertools.BuilderToolEntityTransformSessionEnd::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Voice,
            450, "VoiceData", meridian.protocol.packets.voice.VoiceData.class,
            6, 523, false,
            meridian.protocol.packets.voice.VoiceData::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Voice,
            451, "RelayedVoiceData", meridian.protocol.packets.voice.RelayedVoiceData.class,
            52, 569, false,
            meridian.protocol.packets.voice.RelayedVoiceData::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            452, "VoiceConfig", meridian.protocol.packets.voice.VoiceConfig.class,
            17, 17, false,
            meridian.protocol.packets.voice.VoiceConfig::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            460, "StreamOpen", meridian.protocol.packets.stream.StreamOpen.class,
            1, 1, false,
            meridian.protocol.packets.stream.StreamOpen::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            461, "StreamOpenResponse", meridian.protocol.packets.stream.StreamOpenResponse.class,
            3, 16384008, false,
            meridian.protocol.packets.stream.StreamOpenResponse::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            470, "UpdateTriggerVolumeDisplay", meridian.protocol.packets.player.UpdateTriggerVolumeDisplay.class,
            1, 1677721600, false,
            meridian.protocol.packets.player.UpdateTriggerVolumeDisplay::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            471, "AddOrUpdateTriggerVolumeDisplay", meridian.protocol.packets.player.AddOrUpdateTriggerVolumeDisplay.class,
            0, 81920119, false,
            meridian.protocol.packets.player.AddOrUpdateTriggerVolumeDisplay::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            472, "RemoveTriggerVolumeDisplay", meridian.protocol.packets.player.RemoveTriggerVolumeDisplay.class,
            0, 16384005, false,
            meridian.protocol.packets.player.RemoveTriggerVolumeDisplay::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            473, "UpdateClientRuleVolumes", meridian.protocol.packets.player.UpdateClientRuleVolumes.class,
            1, 1677721600, false,
            meridian.protocol.packets.player.UpdateClientRuleVolumes::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            480, "TriggerVolumeToolCreate", meridian.protocol.packets.player.TriggerVolumeToolCreate.class,
            38, 16384043, false,
            meridian.protocol.packets.player.TriggerVolumeToolCreate::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            481, "TriggerVolumeToolMove", meridian.protocol.packets.player.TriggerVolumeToolMove.class,
            12, 16384017, false,
            meridian.protocol.packets.player.TriggerVolumeToolMove::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            482, "TriggerVolumeToolResize", meridian.protocol.packets.player.TriggerVolumeToolResize.class,
            38, 16384043, false,
            meridian.protocol.packets.player.TriggerVolumeToolResize::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            483, "TriggerVolumeToolDelete", meridian.protocol.packets.player.TriggerVolumeToolDelete.class,
            0, 16384005, false,
            meridian.protocol.packets.player.TriggerVolumeToolDelete::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            484, "TriggerVolumeToolEquip", meridian.protocol.packets.player.TriggerVolumeToolEquip.class,
            1, 1, false,
            meridian.protocol.packets.player.TriggerVolumeToolEquip::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            485, "TriggerVolumeToolCreateResponse", meridian.protocol.packets.player.TriggerVolumeToolCreateResponse.class,
            1, 1677721600, false,
            meridian.protocol.packets.player.TriggerVolumeToolCreateResponse::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            486, "TriggerVolumeToolGroupCreate", meridian.protocol.packets.player.TriggerVolumeToolGroupCreate.class,
            0, 1677721600, false,
            meridian.protocol.packets.player.TriggerVolumeToolGroupCreate::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            487, "TriggerVolumeToolGroupCreateResponse", meridian.protocol.packets.player.TriggerVolumeToolGroupCreateResponse.class,
            9, 16384014, false,
            meridian.protocol.packets.player.TriggerVolumeToolGroupCreateResponse::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            488, "TriggerVolumeToolUngroup", meridian.protocol.packets.player.TriggerVolumeToolUngroup.class,
            0, 16384005, false,
            meridian.protocol.packets.player.TriggerVolumeToolUngroup::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            489, "TriggerVolumeToolGroupMove", meridian.protocol.packets.player.TriggerVolumeToolGroupMove.class,
            12, 16384017, false,
            meridian.protocol.packets.player.TriggerVolumeToolGroupMove::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            490, "TriggerVolumeToolSelect", meridian.protocol.packets.player.TriggerVolumeToolSelect.class,
            1, 16384006, false,
            meridian.protocol.packets.player.TriggerVolumeToolSelect::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            491, "TriggerVolumeToolMultiMove", meridian.protocol.packets.player.TriggerVolumeToolMultiMove.class,
            12, 1677721600, false,
            meridian.protocol.packets.player.TriggerVolumeToolMultiMove::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            492, "TriggerVolumeToolSetColor", meridian.protocol.packets.player.TriggerVolumeToolSetColor.class,
            12, 16384017, false,
            meridian.protocol.packets.player.TriggerVolumeToolSetColor::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            493, "TriggerVolumeToolSetTargetTypes", meridian.protocol.packets.player.TriggerVolumeToolSetTargetTypes.class,
            1, 16384006, false,
            meridian.protocol.packets.player.TriggerVolumeToolSetTargetTypes::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            500, "TriggerVolumeToolSetKeepLoaded", meridian.protocol.packets.player.TriggerVolumeToolSetKeepLoaded.class,
            1, 16384006, false,
            meridian.protocol.packets.player.TriggerVolumeToolSetKeepLoaded::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            501, "TriggerVolumeToolSetCooldown", meridian.protocol.packets.player.TriggerVolumeToolSetCooldown.class,
            5, 16384010, false,
            meridian.protocol.packets.player.TriggerVolumeToolSetCooldown::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            502, "TriggerVolumeToolSetActivationDelay", meridian.protocol.packets.player.TriggerVolumeToolSetActivationDelay.class,
            4, 16384009, false,
            meridian.protocol.packets.player.TriggerVolumeToolSetActivationDelay::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            503, "SelectionToolShowTriggerVolumes", meridian.protocol.packets.player.SelectionToolShowTriggerVolumes.class,
            1, 1, false,
            meridian.protocol.packets.player.SelectionToolShowTriggerVolumes::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            504, "TriggerVolumeToolSetCancelDelayedOnExit", meridian.protocol.packets.player.TriggerVolumeToolSetCancelDelayedOnExit.class,
            1, 16384006, false,
            meridian.protocol.packets.player.TriggerVolumeToolSetCancelDelayedOnExit::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            505, "TriggerVolumeToolDuplicate", meridian.protocol.packets.player.TriggerVolumeToolDuplicate.class,
            0, 1677721600, false,
            meridian.protocol.packets.player.TriggerVolumeToolDuplicate::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            506, "TriggerVolumeToolSetConditionTiming", meridian.protocol.packets.player.TriggerVolumeToolSetConditionTiming.class,
            1, 16384006, false,
            meridian.protocol.packets.player.TriggerVolumeToolSetConditionTiming::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            507, "TriggerVolumeToolSelection", meridian.protocol.packets.player.TriggerVolumeToolSelection.class,
            1, 1677721600, false,
            meridian.protocol.packets.player.TriggerVolumeToolSelection::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            508, "ShowTriggerVolumePastePrefabPreview", meridian.protocol.packets.player.ShowTriggerVolumePastePrefabPreview.class,
            21, 1677721600, true,
            meridian.protocol.packets.player.ShowTriggerVolumePastePrefabPreview::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            509, "HideTriggerVolumePastePrefabPreview", meridian.protocol.packets.player.HideTriggerVolumePastePrefabPreview.class,
            0, 0, false,
            meridian.protocol.packets.player.HideTriggerVolumePastePrefabPreview::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            510, "PointToolCreate", meridian.protocol.packets.player.PointToolCreate.class,
            26, 16384031, false,
            meridian.protocol.packets.player.PointToolCreate::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            511, "PointToolMove", meridian.protocol.packets.player.PointToolMove.class,
            12, 16384017, false,
            meridian.protocol.packets.player.PointToolMove::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            512, "PointToolRotate", meridian.protocol.packets.player.PointToolRotate.class,
            12, 16384017, false,
            meridian.protocol.packets.player.PointToolRotate::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            513, "PointToolMultiMove", meridian.protocol.packets.player.PointToolMultiMove.class,
            12, 1677721600, false,
            meridian.protocol.packets.player.PointToolMultiMove::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            514, "PointToolDuplicate", meridian.protocol.packets.player.PointToolDuplicate.class,
            0, 1677721600, false,
            meridian.protocol.packets.player.PointToolDuplicate::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            515, "PointToolDelete", meridian.protocol.packets.player.PointToolDelete.class,
            0, 16384005, false,
            meridian.protocol.packets.player.PointToolDelete::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            516, "PointToolEquip", meridian.protocol.packets.player.PointToolEquip.class,
            1, 1, false,
            meridian.protocol.packets.player.PointToolEquip::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            517, "PointToolSelect", meridian.protocol.packets.player.PointToolSelect.class,
            1, 16384006, false,
            meridian.protocol.packets.player.PointToolSelect::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            518, "UpdatePointDisplay", meridian.protocol.packets.player.UpdatePointDisplay.class,
            1, 1677721600, false,
            meridian.protocol.packets.player.UpdatePointDisplay::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            519, "AddOrUpdatePointDisplay", meridian.protocol.packets.player.AddOrUpdatePointDisplay.class,
            0, 1677721600, false,
            meridian.protocol.packets.player.AddOrUpdatePointDisplay::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            520, "RemovePointDisplay", meridian.protocol.packets.player.RemovePointDisplay.class,
            0, 16384005, false,
            meridian.protocol.packets.player.RemovePointDisplay::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            521, "PointToolCreateResponse", meridian.protocol.packets.player.PointToolCreateResponse.class,
            1, 1677721600, false,
            meridian.protocol.packets.player.PointToolCreateResponse::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            522, "PointToolSelection", meridian.protocol.packets.player.PointToolSelection.class,
            1, 1677721600, false,
            meridian.protocol.packets.player.PointToolSelection::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            523, "PointToolSetShape", meridian.protocol.packets.player.PointToolSetShape.class,
            13, 16384018, false,
            meridian.protocol.packets.player.PointToolSetShape::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            524, "TriggerVolumeToolRotate", meridian.protocol.packets.player.TriggerVolumeToolRotate.class,
            12, 16384017, false,
            meridian.protocol.packets.player.TriggerVolumeToolRotate::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            525, "CancelParticleSystems", meridian.protocol.packets.world.CancelParticleSystems.class,
            50, 1677721600, false,
            meridian.protocol.packets.world.CancelParticleSystems::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            526, "TriggerVolumeToolSetName", meridian.protocol.packets.player.TriggerVolumeToolSetName.class,
            1, 32768019, false,
            meridian.protocol.packets.player.TriggerVolumeToolSetName::toObject);
        register(
            PacketDirection.ToClient, NetworkChannel.Default,
            1200, "UpdateServersideUIPage", meridian.protocol.packets.interface_.UpdateServersideUIPage.class,
            0, 1677721600, false,
            meridian.protocol.packets.interface_.UpdateServersideUIPage::toObject);
        register(
            PacketDirection.ToServer, NetworkChannel.Default,
            1202, "ExecuteServersidePageCommand", meridian.protocol.packets.interface_.ExecuteServersidePageCommand.class,
            1, 1677721600, false,
            meridian.protocol.packets.interface_.ExecuteServersidePageCommand::toObject);
    }

    private PacketRegistry() {}
    
    @FunctionalInterface
    public interface DeserializeFunc<T> {
        Packet deserialize(T t, int offset);
    }

    private static void register(
            PacketDirection direction, NetworkChannel channel,
            int id, String name, Class<? extends Packet> type,
            int fixedBlockSize, int maxSize, boolean compressed,
            DeserializeFunc<MemorySegment> toObject) {
        var existing = BY_ID.get(id);
        if (existing != null) {
            throw new IllegalStateException("Duplicate packet ID " + id + ": '" + name + "' conflicts with '" + existing.name() + "'");
        }
        var info = new PacketInfo(id, name, channel, type, fixedBlockSize, maxSize, compressed, toObject);
        switch (direction) {
            case ToServer -> TO_SERVER_BY_ID.put(id, info);
            case ToClient -> TO_CLIENT_BY_ID.put(id, info);
            case Both -> {
                TO_SERVER_BY_ID.put(id, info);
                TO_CLIENT_BY_ID.put(id, info);
            }
        }
        BY_ID.put(id, info);
        BY_TYPE.put(type, id);
    }

    @Nullable
    public static PacketInfo getToServerPacketById(int id) {
        return TO_SERVER_BY_ID.get(id);
    }

    @Nullable
    public static PacketInfo getToClientPacketById(int id) {
        return TO_CLIENT_BY_ID.get(id);
    }

    @Nullable
    public static Integer getId(Class<? extends Packet> type) {
        return BY_TYPE.get(type);
    }

    @Nonnull
    public static Map<Integer, PacketInfo> all() {
        return BY_ID_UNMODIFIABLE;
    }

    public record PacketInfo(
        int id,
        @Nonnull String name,
        @Nonnull NetworkChannel channel,
        @Nonnull Class<? extends Packet> type,
        int fixedBlockSize,
        int maxSize,
        boolean compressed,
        DeserializeFunc<MemorySegment> toObject
    ) {}

    public enum PacketDirection {
        ToServer,
        ToClient,
        Both,
    }
}