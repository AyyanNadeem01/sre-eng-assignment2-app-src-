package X;

import com.facebook.errorreporting.field.ReportFieldString;

/* renamed from: X.04S, reason: invalid class name */
/* loaded from: classes.dex */
public final class C04S extends C04R {
    @Override // X.C04R
    public final C05C A00(AnonymousClass057 anonymousClass057) {
        C05C c05c = new C05C(null);
        ReportFieldString reportFieldString = AnonymousClass094.A7P;
        StringBuilder sb = new StringBuilder();
        sb.append("android_");
        sb.append(anonymousClass057.A00);
        sb.append("java");
        c05c.A04(reportFieldString, sb.toString());
        return c05c;
    }

    @Override // X.C04R
    public final EnumC011204x A01() {
        return EnumC011204x.JAVA;
    }

    @Override // X.C04R
    public final Integer A02() {
        return AnonymousClass065.A01;
    }
}
