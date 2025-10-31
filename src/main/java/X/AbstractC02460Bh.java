package X;

import android.os.Build;

/* renamed from: X.0Bh, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC02460Bh {
    public static void A00(String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() <= 23) {
            return;
        }
        str.substring(0, 23);
    }
}
