package org.levimc.launcher.core.mods.inbuilt;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import org.levimc.launcher.R;
import org.levimc.launcher.core.versions.GameVersion;
import org.levimc.launcher.core.versions.VersionManager;
import org.levimc.launcher.ui.activities.CurseForgeActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Mod Menu entries for Bedrock content integrations. These are intentionally informational:
 * Bedrock add-ons are installed and enabled by Minecraft's content system, not by the native
 * toggle path used by native .levipack modules.
 */
public final class BedrockFeatureModuleProvider {
    private static final String GROUP_ID = "bedrock_features";

    private BedrockFeatureModuleProvider() {
    }

    public static List<UnifiedMod> load(Activity activity) {
        List<UnifiedMod> modules = new ArrayList<>();
        modules.add(create(activity, "bedrock_spatial_ui", R.string.bedrock_feature_spatial_ui,
                R.string.bedrock_feature_spatial_ui_desc, R.string.bedrock_feature_integrated,
                "Spatial UI Immersive GUI"));
        modules.add(create(activity, "bedrock_apple_skin", R.string.bedrock_feature_apple_skin,
                R.string.bedrock_feature_apple_skin_desc, R.string.bedrock_feature_integrated,
                "AppleSkin Bedrock Port"));
        modules.add(create(activity, "bedrock_replay", R.string.bedrock_feature_replay,
                R.string.bedrock_feature_replay_desc, R.string.bedrock_feature_integrated,
                "ReplayCraft"));
        modules.add(createDiscord(activity));
        return modules;
    }

    private static UnifiedMod createDiscord(Activity activity) {
        UnifiedMod module = new UnifiedMod(
                "discord_rich_presence",
                activity.getString(R.string.discord_rich_presence),
                activity.getString(R.string.discord_rich_presence_desc),
                GROUP_ID,
                UnifiedMod.Source.INBUILT,
                false,
                Collections.emptyList(),
                true,
                GROUP_ID,
                activity.getString(R.string.mod_menu_group_bedrock_features),
                null,
                null,
                mod -> activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://docs.discord.com/developers/discord-social-sdk/development-guides/setting-rich-presence")))
        );
        module.setToggleAvailable(false);
        module.setStatusLabel(activity.getString(R.string.discord_rich_presence_status));
        return module;
    }

    private static UnifiedMod create(Activity activity, String id, int nameRes, int descRes,
                                     int statusRes, String searchQuery) {
        UnifiedMod module = new UnifiedMod(
                id,
                activity.getString(nameRes),
                activity.getString(descRes),
                GROUP_ID,
                UnifiedMod.Source.INBUILT,
                false,
                Collections.emptyList(),
                true,
                GROUP_ID,
                activity.getString(R.string.mod_menu_group_bedrock_features),
                null,
                null,
                mod -> {
                    Intent intent = new Intent(activity, CurseForgeActivity.class);
                    intent.putExtra(CurseForgeActivity.EXTRA_INITIAL_SEARCH, searchQuery);
                    GameVersion selected = VersionManager.get(activity).getSelectedVersion();
                    if (selected != null && selected.versionCode != null && !selected.versionCode.isEmpty()) {
                        intent.putExtra(CurseForgeActivity.EXTRA_INITIAL_VERSION, selected.versionCode);
                    }
                    activity.startActivity(intent);
                }
        );
        module.setToggleAvailable(false);
        module.setStatusLabel(activity.getString(statusRes));
        return module;
    }
}
