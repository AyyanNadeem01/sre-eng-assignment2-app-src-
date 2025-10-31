package X;

/* renamed from: X.01P, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C01P {
    public static void A00(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
    }

    public static void A01(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }
}
