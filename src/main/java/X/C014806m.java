package X;

/* renamed from: X.06m */
/* loaded from: classes.dex */
public final class C014806m {
    public final AnonymousClass070 A00;
    public final C02440Bf A01;

    public C014806m(AnonymousClass070 anonymousClass070, C02440Bf c02440Bf) {
        this.A00 = anonymousClass070;
        this.A01 = c02440Bf;
    }

    public static void A00(ProcessBuilder processBuilder, String str, String str2) {
        String strA02 = C07O.A02(str);
        if (strA02.isEmpty()) {
            return;
        }
        processBuilder.command().add(AnonymousClass000.A06("=", strA02, AnonymousClass000.A0A(str2)));
    }
}
