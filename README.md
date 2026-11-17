<div align="center">

# Rabbit Client

### Your Minecraft. Your Style.

A dark, fast Android launcher for Minecraft Bedrock Edition with version-aware content management, native in-game tools, and a focused Mod Menu.

[![Android 9+](https://img.shields.io/badge/Android-9%2B-7c5cff?style=for-the-badge&logo=android&logoColor=white)](https://www.android.com/)
[![ARM64](https://img.shields.io/badge/ABI-arm64--v8a-11131f?style=for-the-badge)](https://developer.android.com/ndk/guides/abis)
[![License](https://img.shields.io/badge/license-Apache%202.0-22c55e?style=for-the-badge)](LICENSE)
[![Package](https://img.shields.io/badge/package-org.rabbit.client-f97316?style=for-the-badge)](https://github.com/khargosh-area/rabbitclient)

**[Download releases](https://github.com/khargosh-area/rabbitclient/releases) · [Report an issue](https://github.com/khargosh-area/rabbitclient/issues) · [Read integration status](INTEGRATION_STATUS.md)**

</div>

---

## What Rabbit Client does

Rabbit Client manages Minecraft Bedrock installations that Android exposes to it. It detects the actual installed game version, supports complete local/imported APK profiles where Android permits them, isolates profiles, and launches the selected version through the existing Bedrock runtime pipeline.

The launcher does not bypass Microsoft authentication, licensing, Play Integrity, server rules, or protected Minecraft files. A local APK must be complete, readable, and compatible with the device and launcher runtime.

## Mod Menu integrations

The existing Mod Menu includes these Bedrock-focused entries directly—there is no separate LeviPack or External Mods area:

| Entry | Status | What it does |
|---|---|---|
| **Spatial GUI** | In Mod Menu | Opens the CurseForge Bedrock search flow for Spatial UI - Immersive GUI. |
| **AppleSkin** | In Mod Menu | Opens the AppleSkin Bedrock Port flow, including its JSON UI/title conflict warning. |
| **Bedrock Replay** | In Mod Menu | Opens a version-filtered search for ReplayCraft and other Bedrock replay add-ons. |

The entries are integrated into Rabbit Client’s menu, but the third-party add-on files remain Minecraft content. Rabbit Client does not bundle unverified artifacts or present a launcher toggle that cannot actually control Minecraft.

Each entry uses the detected Minecraft version as the initial CurseForge compatibility filter when available. Final compatibility is determined by the add-on release and Minecraft itself.

## Current feature set

- **Version detection** — reads the installed Bedrock package metadata instead of displaying invented versions.
- **Local APK support** — supports readable local/imported sources without requiring Google Play provenance alone.
- **Minecraft launch flow** — launches the selected detected/imported version and reports actionable errors when the source is missing or unreadable.
- **Profile isolation** — keeps versions and content separated by profile.
- **Content management** — imports worlds, resource packs, behavior packs, skins, and other supported Bedrock content.
- **Native in-game tools** — Rabbit Client’s existing HUD, controls, performance, and camera modules remain available.
- **CurseForge discovery** — searches Bedrock categories and opens the existing download/import pipeline.
- **Dark glass UI** — compact, keyboard-friendly, and designed around the existing launcher shell.

## Discord Rich Presence

Discord Rich Presence is listed in the Mod Menu as **In Development**. Discord’s official Social SDK supports Android Rich Presence, but a real integration requires a Rabbit-owned Discord Application ID, the official SDK package/native artifacts, Android configuration, and signed application setup. Until those project-owned inputs are available, Rabbit Client intentionally does not ship a non-functional RPC toggle.

See the official documentation:

- [Discord Social SDK overview](https://docs.discord.com/developers/discord-social-sdk/overview)
- [Setting Rich Presence](https://docs.discord.com/developers/discord-social-sdk/development-guides/setting-rich-presence)

## System requirements

- Android 9.0 / API 28 or newer
- ARM64 device (`arm64-v8a`)
- At least 2 GB free storage for launcher data and Minecraft profiles
- A complete, readable Minecraft Bedrock installation or imported APK profile
- A valid Minecraft/Microsoft account and any licenses required by Minecraft

## Build from source

```bash
git clone https://github.com/khargosh-area/rabbitclient.git
cd rabbitclient
./gradlew assembleDebug
```

For a local Android build, install JDK 21, Android SDK API 36, Android NDK, CMake, and the Android SDK platform tools. The app package ID is:

```text
org.rabbit.client
```

The source namespace remains internally organized under `org.levimc.launcher` to preserve the large native/runtime integration surface while the installable Android identity is now `org.rabbit.client`.

## Testing

The project’s validation suite includes Android unit tests and debug APK packaging:

```bash
./gradlew testDebugUnitTest assembleDebug --no-daemon \
  -x uploadCrashlyticsMappingFileDebug
```

Live device testing requires an attached Android device or emulator with a readable Minecraft installation. The build cannot simulate Minecraft’s protected runtime or account services.

## Legal and attribution notes

Rabbit Client is intended for legitimate Minecraft Bedrock use. Do not use it to bypass authentication, licensing, server restrictions, or platform protections. Third-party licenses and upstream attribution files in this repository remain authoritative and must not be removed from redistributed builds.

Third-party Bedrock add-ons referenced by the Mod Menu retain their own authorship, licenses, and compatibility terms. Rabbit Client only provides discovery and installation routing for those published artifacts.

## Maintainer

**Rabbit** — Rabbit Client creator and maintainer.

Project: [github.com/khargosh-area/rabbitclient](https://github.com/khargosh-area/rabbitclient)
