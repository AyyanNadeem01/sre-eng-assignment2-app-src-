package X;

/* renamed from: X.09F, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C09F {
    public static volatile int A00;

    public static void A00() {
        if (A00 == 0) {
            synchronized (C09F.class) {
                if (A00 == 0) {
                    A00 = -1;
                }
            }
        }
    }

    public C09F() {
        throw AnonymousClass062.createAndThrow();
    }
}
