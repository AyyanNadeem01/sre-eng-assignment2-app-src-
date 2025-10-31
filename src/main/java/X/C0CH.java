package X;

import android.net.Uri;

/* renamed from: X.0CH, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C0CH {
    public static Uri A00(String... strArr) {
        Uri.Builder builderAuthority;
        Uri.Builder builderScheme = new Uri.Builder().scheme("https");
        if (builderScheme == null || (builderAuthority = builderScheme.authority("b-www.facebook.com")) == null) {
            return C02M.A01(null, "");
        }
        int i = 0;
        do {
            builderAuthority.appendPath(strArr[i]);
            i++;
        } while (i < 2);
        builderAuthority.appendPath("");
        return builderAuthority.build();
    }
}
