package org.levimc.launcher.integration;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

/** Safe interoperability boundary for the separately distributed Bedrock Voice Chat client. */
public final class BedrockVoiceChatIntegration {
    public static final String CLIENT_PACKAGE = "com.alaydriem.bvc.client";
    public static final String SETUP_URL = "https://www.bedrockvoicechat.com/";

    private BedrockVoiceChatIntegration() { }

    public static boolean isCompanionInstalled(Context context) {
        try {
            context.getPackageManager().getPackageInfo(CLIENT_PACKAGE, 0);
            return true;
        } catch (PackageManager.NameNotFoundException ignored) {
            return false;
        }
    }

    public static boolean openCompanion(Context context) {
        Intent launch = context.getPackageManager().getLaunchIntentForPackage(CLIENT_PACKAGE);
        if (launch == null) return false;
        launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(launch);
        return true;
    }

    public static void openSetupPage(Context context) {
        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(SETUP_URL));
        browser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(browser);
    }
}
