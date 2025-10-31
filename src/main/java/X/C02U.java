package X;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: X.02U, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C02U {
    public static void A00(Context context, C05C c05c) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            c05c.A01(AnonymousClass094.A07, packageManager.hasSystemFeature("android.hardware.ram.low"));
        }
    }
}
