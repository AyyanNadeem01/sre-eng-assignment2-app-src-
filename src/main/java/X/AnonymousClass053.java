package X;

import java.util.Locale;

/* renamed from: X.053 */
/* loaded from: classes.dex */
public abstract class AnonymousClass053 {
    public static void A01(int i, int i2, int i3, String str) {
        if (i < i2) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (i > i3) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public static C04w A00(C0AZ c0az, Object obj) {
        A03(obj, "Did you call earlyInit()?");
        C04w c04w = c0az.A00;
        A03(c04w, "Did you call earlyInit()?");
        return c04w;
    }

    public static void A02(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
    }

    public static void A03(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(String.valueOf(obj2));
        }
    }

    public static void A04(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }
}
