# Bedrock Voice Chat integration research

Sources inspected on 2026-11-22:

- https://www.curseforge.com/minecraft-bedrock/addons/bedrock-voice-chat
- https://github.com/Alaydriem/bedrock-voice-chat
- https://www.bedrockvoicechat.com/
- https://developer.android.com/develop/background-work/services/fgs/service-types
- https://learn.microsoft.com/en-us/minecraft/creator/scriptapi/minecraft/server/player?view=minecraft-bedrock-stable

Findings:

1. Bedrock Voice Chat provides proximity audio and persistent group/channel audio for Bedrock, but requires three components: a Bedrock behavior pack/addon (or Java plugin/mod), a BVC voice server, and a native client. The addon supplies player-position information; the client alone cannot infer Minecraft-world distance for arbitrary Bedrock servers.
2. The upstream client uses native Rust/Tauri code with Opus audio, QUIC/mTLS transport, server APIs, and Microsoft account identity. Its Android identifier is `com.alaydriem.bvc.client`.
3. The upstream repository is under the Clear Horizon Path License (CHPL), which states that pre-release source is for personal evaluation and prohibits redistribution/derivative production use; it also restricts app-store binary redistribution and commercial/managed-service use without permission. Rabbit must not copy or redistribute the upstream client code/binary without applicable permission.
4. Android microphone capture requires `RECORD_AUDIO`; continuing capture while the app is backgrounded requires a microphone foreground service and `FOREGROUND_SERVICE_MICROPHONE`, with Android foreground-service start restrictions. Rabbit’s current manifest explicitly removes foreground microphone permissions, so a real embedded voice session requires a deliberate manifest/service change and runtime permission flow.
5. Microsoft’s Bedrock Script API exposes player entities and locations, but it is server/addon-side and cannot make a launcher-only proximity system work on arbitrary worlds.

Implementation boundary:

- Rabbit can safely add an interoperability/settings layer and launch or hand off to an independently distributed BVC client, while preserving attribution and not bundling upstream code.
- A fully embedded Rabbit voice client requires either written permission to reuse upstream BVC code/protocol implementation or a clean-room implementation of the documented protocol, plus a server/addon configuration and physical-device audio testing.
- No UI should claim proximity/group audio is active until a BVC-compatible server/addon and real client session confirm it.
