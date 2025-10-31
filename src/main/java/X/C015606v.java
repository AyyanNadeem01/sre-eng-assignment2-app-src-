package X;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: X.06v, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C015606v {
    public static final Object A00 = new Object();
    public static volatile SharedPreferences A01;
    public static volatile C015606v A02;

    public static boolean A04(Context context, int i) {
        return A00(context).getBoolean(AnonymousClass000.A08("primary_dex_feature_key_", AnonymousClass000.A09(), i), false);
    }

    public static SharedPreferences A00(Context context) {
        if (A01 == null) {
            synchronized (A00) {
                if (A01 == null) {
                    A01 = context.getSharedPreferences("primary_dex_features", 0);
                }
            }
        }
        return A01;
    }

    public static void A01() {
        if (A02 == null) {
            synchronized (A00) {
                if (A02 == null) {
                    A02 = new C015606v();
                }
            }
        }
    }

    public static final void A02(Context context, int i, int i2) {
        A00(context).edit().putInt(AnonymousClass000.A08("primary_dex_feature_key_", AnonymousClass000.A09(), i), i2).apply();
    }

    public static final void A03(Context context, int i, boolean z) {
        A00(context).edit().putBoolean(AnonymousClass000.A08("primary_dex_feature_key_", AnonymousClass000.A09(), i), z).apply();
    }
}
