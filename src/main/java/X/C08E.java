package X;

/* renamed from: X.08E, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C08E {
    public static void A00(Throwable th) throws Throwable {
        Class cls = Error.class;
        if (!cls.isInstance(th)) {
            cls = RuntimeException.class;
            if (!cls.isInstance(th)) {
                throw new RuntimeException(th);
            }
        }
        throw ((Throwable) cls.cast(th));
    }
}
