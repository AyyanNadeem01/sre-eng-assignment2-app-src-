package X;

/* renamed from: X.0B2, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0B2 {
    public static C0BR A00;

    public static boolean A00(String str) {
        C0BR c0br;
        synchronized (C0B2.class) {
            c0br = A00;
            if (c0br == null) {
                throw AnonymousClass000.A04("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return c0br.AP0(str);
    }
}
