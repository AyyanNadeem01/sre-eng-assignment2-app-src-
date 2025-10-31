package X;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: X.05R, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C05R {
    public static final Object A00 = new Object();
    public static volatile ConnectivityManager A01;

    public static ConnectivityManager A00(Context context) {
        if (A01 == null) {
            synchronized (A00) {
                if (A01 == null) {
                    A01 = (ConnectivityManager) context.getSystemService("connectivity");
                }
            }
        }
        return A01;
    }

    public static C05S A01(Context context) {
        C05W c05wA00 = C05W.A00(context);
        if (c05wA00 != null) {
            return c05wA00.A01();
        }
        NetworkInfo activeNetworkInfo = A00(context).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        return new C05S(activeNetworkInfo);
    }

    public static C05S A02(Context context, int i) {
        C05W c05wA00 = C05W.A00(context);
        if (c05wA00 != null) {
            return c05wA00.A01();
        }
        NetworkInfo networkInfo = A00(context).getNetworkInfo(i);
        if (networkInfo == null) {
            return null;
        }
        return new C05S(networkInfo);
    }
}
