package X;

import com.facebook.errorreporting.field.ReportFieldString;
import java.io.File;

/* renamed from: X.00d, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C000000d extends C04R {
    @Override // X.C04R
    public final C05C A00(AnonymousClass057 anonymousClass057) {
        C05C c05c = new C05C(null);
        c05c.A04(AnonymousClass094.A5J, "anr");
        ReportFieldString reportFieldString = AnonymousClass094.A7P;
        StringBuilder sb = new StringBuilder();
        sb.append("android_");
        sb.append(anonymousClass057.A00);
        sb.append("anr");
        c05c.A04(reportFieldString, sb.toString());
        return c05c;
    }

    @Override // X.C04R
    public final void A03(AnonymousClass057 anonymousClass057, File file, File file2) {
        boolean z;
        if (anonymousClass057 == AnonymousClass057.LARGE_REPORT) {
            synchronized (C00a.class) {
                z = C00a.A0B;
            }
            if (z) {
                return;
            }
            super.A03(anonymousClass057, file, file2);
        }
    }

    @Override // X.C04R
    public final EnumC011204x A01() {
        return EnumC011204x.ANR;
    }

    @Override // X.C04R
    public final Integer A02() {
        return AnonymousClass065.A01;
    }
}
