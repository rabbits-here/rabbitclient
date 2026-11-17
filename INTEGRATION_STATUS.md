# Rabbit Client integration status

## Bedrock feature entries

Rabbit Client's existing Mod Menu now includes exactly three Bedrock content integrations and one separate Discord status entry. The Bedrock rows are informational capability cards, not fake native toggles. Tapping a card opens the existing CurseForge search/install flow and preselects the detected Minecraft version when available. Minecraft remains responsible for enabling and running the imported content.

### Spatial GUI — Available

[Spatial UI - Immersive GUI](https://www.curseforge.com/minecraft-bedrock/addons/spatial-ui-immersive-gui) is a Bedrock add-on whose listing describes redesigned inventory, chest, furnace, and other interface interactions. Rabbit Client does not bundle or copy its files because the listing does not provide a clear license grant in the fetched metadata. Users can find and install the published Bedrock artifact through CurseForge, then enable it through Minecraft content management.

### Apple Skin — Available with limitations

[AppleSkin - Bedrock Port](https://www.curseforge.com/minecraft-bedrock/addons/appleskin-bedrock-port) provides a saturation bar and food restoration information for vanilla and custom food. Its author explicitly notes that it is not a complete Java-port because Bedrock JSON UI cannot provide the full exhaustion and restored-health behavior, and that it is incompatible with add-ons that use titles. Rabbit Client links to the published artifact instead of reusing its code or assets; the listing does not grant permission to copy the implementation.

### Replay Mod — Available conditionally

[ReplayCraft](https://github.com/darkblockgaming/ReplayCraft) is a Bedrock add-on that records and replays gameplay using Bedrock Script API/server-ui APIs. Its repository currently describes a Bedrock 1.26.20 target, so Rabbit Client opens it through the compatibility-filtered content flow rather than claiming universal support. Replay playback and recording are performed by the add-on inside Minecraft, not by a launcher toggle. The repository page inspected for this integration did not expose a clear license grant, so Rabbit Client does not bundle it.

The CurseForge catalog also contains other Bedrock replay projects, including Replay Mod Lite and Replay Director. They were not bundled because their target versions and licenses must be checked per release.

## Discord Rich Presence

The Mod Menu includes a non-toggle **Discord Rich Presence — In Development** entry. It opens the official setup guide rather than pretending RPC is active.

Discord's [Social SDK overview](https://docs.discord.com/developers/discord-social-sdk/overview) and [Rich Presence guide](https://docs.discord.com/developers/discord-social-sdk/development-guides/setting-rich-presence) confirm that Android Rich Presence is supported. The official direct-RPC path still requires a Discord application ID, the Social SDK package/native artifacts, and the Android setup/redirect configuration. The repository currently does not contain an authorized Discord Social SDK artifact or a Rabbit-owned Discord Application ID, so enabling a toggle now would be non-functional. The SDK should be added only after those project-owned inputs are supplied.

## Boundaries

No Java/Fabric/Forge `.jar` files are loaded into the Bedrock APK. No protected Minecraft files are modified, and Microsoft authentication, licensing, and server restrictions are not bypassed. The three Bedrock rows are the only requested LeviPack-style capabilities exposed in the Mod Menu; no unverified bundle was imported.
