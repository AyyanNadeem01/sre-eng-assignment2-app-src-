package X;

/* renamed from: X.08k */
/* loaded from: classes.dex */
public abstract class AbstractC018908k {
    public static String A00;
    public static final C018808j A01 = new C018808j();

    public static final String A00() {
        C018808j c018808j = A01;
        if (A00 == null) {
            synchronized (c018808j) {
                String str = A00;
                if (str != null) {
                    return str;
                }
                String string = Long.toString(System.currentTimeMillis());
                C06E.A03(string);
                StringBuilder sbA0A = AnonymousClass000.A0A(string);
                sbA0A.append('-');
                A00 = AnonymousClass000.A07(C09E.A00(), sbA0A);
            }
        }
        String str2 = A00;
        C06E.A06(str2);
        return str2;
    }
}
