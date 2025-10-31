package X;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;

/* renamed from: X.02k, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC005602k {
    public static long A00;
    public static boolean A01;

    public static boolean A00(Context context) {
        boolean z;
        NetworkInfo activeNetworkInfo;
        if (SystemClock.uptimeMillis() - A00 < 5000) {
            return A01;
        }
        boolean z2 = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.isConnected()) {
                    z2 = true;
                }
            }
            z = z2;
        } catch (Throwable th) {
            C018108b.A0A("lacrima", "Connectivity check failed", th);
            C0C5.A00();
            z = false;
        }
        A01 = z2;
        A00 = SystemClock.uptimeMillis();
        return z;
    }
}
