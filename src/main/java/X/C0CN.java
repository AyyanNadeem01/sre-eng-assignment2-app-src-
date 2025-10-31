package X;

/* renamed from: X.0CN, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C0CN {
    public static void A00(Object obj) {
        if (obj == null) {
            throw new AssertionError();
        }
    }

    public static void A01(Object obj, String str) {
        if (obj == null) {
            throw new AssertionError(str);
        }
    }
}
