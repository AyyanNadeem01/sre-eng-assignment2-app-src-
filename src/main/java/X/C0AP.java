package X;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.File;

/* renamed from: X.0AP, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C0AP {
    public static final File A00(Context context, int i) {
        C06E.A07(context, 0);
        File fileA01 = A01(context, i);
        fileA01.mkdirs();
        return fileA01;
    }

    public static final File A01(Context context, int i) {
        String str;
        switch (i) {
            case 114712842:
                str = "lib-compressed";
                break;
            case 157877869:
                str = "app_secure_shared";
                break;
            case 194178138:
                str = "app_sigquit";
                break;
            case 211429074:
                str = "modules";
                break;
            case 343672752:
                str = "files/mqtt_analytics";
                break;
            case 372754419:
                str = "app_browser_proc_webview";
                break;
            case 486209204:
                str = "cache/browser_proc";
                break;
            case 645500653:
                str = "files/bloks_ota_manifest_path";
                break;
            case 917883976:
                str = "app_modules";
                break;
            case 1045170971:
                str = "app_qpl";
                break;
            case 1239662554:
                str = "app_light_prefs";
                break;
            case 1377433890:
                str = "cache/secure_shared";
                break;
            case 1436876361:
                str = "app_appcomponents";
                break;
            case 1543572765:
                str = "app_analytics";
                break;
            case 1638712265:
                str = "app_traces";
                break;
            case 1672668047:
                str = "files/secure_shared";
                break;
            case 1767678896:
                str = "cache/caa_startup_screen_cache";
                break;
            case 1824693925:
                str = "app_acra-reports";
                break;
            case 1874789883:
                str = "app_minidumps";
                break;
            default:
                StringBuilder sbA09 = AnonymousClass000.A09();
                sbA09.append("Storage config ");
                sbA09.append(i);
                throw new IllegalArgumentException(AnonymousClass000.A07(" not in startup registry.", sbA09));
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return AnonymousClass000.A02(AnonymousClass000.A03((Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) ? applicationInfo.dataDir : applicationInfo.deviceProtectedDataDir), str);
    }
}
