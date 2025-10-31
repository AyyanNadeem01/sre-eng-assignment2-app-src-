package X;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import java.util.Collections;

/* renamed from: X.07N, reason: invalid class name */
/* loaded from: classes.dex */
public final class C07N implements C07Y {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.AbstractCollection, java.util.ArrayList] */
    @Override // X.C07Y
    public final void A3y(Context context, String str, String str2) {
        ?? EmptyList = Collections.emptyList();
        try {
            C06E.A07(str, 1);
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = Build.VERSION.SDK_INT >= 33 ? packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(128L)) : packageManager.getApplicationInfo(str, 128);
            C06E.A06(applicationInfo);
            Bundle bundle = ((PackageItemInfo) applicationInfo).metaData;
            if (bundle != null && bundle.size() > 0) {
                EmptyList = AnonymousClass000.A0B();
                for (String str3 : bundle.keySet()) {
                    if (str3.contains(".fbpermission.")) {
                        EmptyList.add(str3);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            EmptyList = Collections.emptyList();
        }
        if (EmptyList.contains(str2)) {
            return;
        }
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("Caller '");
        sbA09.append(str);
        sbA09.append("' has not declared the FbPermission: '");
        sbA09.append(str2);
        throw new C08L(AnonymousClass000.A07("' in its AndroidManifest.xml", sbA09));
    }
}
