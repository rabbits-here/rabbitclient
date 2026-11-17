package org.levimc.launcher.core.versions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VersionManagerDetectionTest {
    @Test
    public void officialPreviewAndClearlyNamedLocalBedrockPackagesAreAccepted() {
        assertTrue(VersionManager.isMinecraftPackageName("com.mojang.minecraftpe"));
        assertTrue(VersionManager.isMinecraftPackageName("com.mojang.minecraftpreview"));
        assertTrue(VersionManager.isMinecraftPackageName("com.mojang.minecraftpe.local"));
        assertFalse(VersionManager.isMinecraftPackageName("com.example.minecraftpe"));
        assertFalse(VersionManager.isMinecraftPackageName(null));
    }

    @Test
    public void versionNameIsTrimmedBeforeItReachesTheProfile() {
        assertEquals("1.21.80.3", VersionManager.normalizeDetectedVersionName(" 1.21.80.3 "));
    }

    @Test
    public void missingVersionNameDoesNotBecomeACommunicatedFakeVersion() {
        assertEquals("Unknown version", VersionManager.normalizeDetectedVersionName(null));
        assertEquals("Unknown version", VersionManager.normalizeDetectedVersionName("   "));
        assertEquals("Unknown version", VersionManager.normalizeDetectedVersionName("null"));
    }
}
