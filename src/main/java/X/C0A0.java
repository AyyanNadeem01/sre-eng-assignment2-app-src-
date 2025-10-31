package X;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.util.Log;

/* renamed from: X.0A0, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0A0 {
    public ApplicationInfo A00 = null;
    public final Context A01;

    public final /* bridge */ /* synthetic */ ApplicationInfo A00() {
        ApplicationInfo applicationInfo;
        Context context = this.A01;
        ApplicationInfo applicationInfo2 = context.getApplicationInfo();
        if (!AnonymousClass000.A03(applicationInfo2.sourceDir).exists()) {
            synchronized (this) {
                ApplicationInfo applicationInfo3 = this.A00;
                if (applicationInfo3 == null || !AnonymousClass000.A03(applicationInfo3.sourceDir).exists()) {
                    Log.w("soloader.ApplicationInfoProvider", "performing a PM cache lookup");
                    PackageManager packageManager = context.getPackageManager();
                    ApplicationInfo applicationInfo4 = null;
                    if (packageManager == null) {
                        Log.w("soloader.ApplicationInfoProvider", "getPackageManager returned null");
                    } else {
                        try {
                            applicationInfo4 = packageManager.getApplicationInfo(((PackageItemInfo) applicationInfo2).packageName, 1024);
                        } catch (PackageManager.NameNotFoundException e) {
                            Log.w("soloader.ApplicationInfoProvider", "Could not get ApplicationInfo from PM cache", e);
                        }
                    }
                    if (applicationInfo4 == null || !AnonymousClass000.A03(applicationInfo4.sourceDir).exists()) {
                        synchronized (C0A0.class) {
                        }
                        applicationInfo4 = null;
                        Log.w("soloader.ApplicationInfoProvider", "myUserId reference not initialized");
                    }
                    this.A00 = applicationInfo4;
                }
                applicationInfo = this.A00;
            }
            if (applicationInfo != null) {
                if (!AnonymousClass000.A03(applicationInfo.sourceDir).exists()) {
                    Log.w("soloader.ApplicationInfoProvider", "Fresh ApplicationInfo is stale too");
                }
                return applicationInfo;
            }
        }
        return applicationInfo2;
    }

    public C0A0(Context context) {
        this.A01 = context;
    }
}
