package X;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.List;

/* renamed from: X.009, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class AnonymousClass009 {
    public static final ProviderInfo A00(Context context, String str, int i) {
        C06E.A07(context, 0);
        C06E.A07(str, 1);
        PackageManager packageManager = context.getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? packageManager.resolveContentProvider(str, PackageManager.ComponentInfoFlags.of(i)) : packageManager.resolveContentProvider(str, i);
    }

    public static final C006202q A01(Context context, String str, int i) {
        C06E.A07(context, 0);
        C06E.A07(str, 1);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            if ((i & 64) == 64) {
                i = (i & (-65)) | 134217728;
            }
        } else if ((i & 134217728) == 134217728) {
            i = (i & (-134217729)) | 64;
        }
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = i2 >= 33 ? packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(i)) : packageManager.getPackageInfo(str, i);
        if (packageInfo != null) {
            return new C006202q(packageInfo);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("PackageManager returned null PackageInfo for ");
        sb.append(str);
        throw new PackageManager.NameNotFoundException(sb.toString());
    }

    public static final List A02(Context context, Intent intent, int i) {
        C06E.A07(context, 0);
        C06E.A07(intent, 1);
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(i)) : packageManager.queryIntentActivities(intent, i);
        C06E.A06(listQueryIntentActivities);
        return listQueryIntentActivities;
    }

    public static final String[] A03(Context context, int i) {
        C06E.A07(context, 0);
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && packagesForUid.length != 0) {
            return packagesForUid;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to get package names for uid ");
        sb.append(i);
        throw new PackageManager.NameNotFoundException(sb.toString());
    }
}
