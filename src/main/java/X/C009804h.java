package X;

import com.facebook.errorreporting.field.ReportFieldString;
import java.io.File;

/* renamed from: X.04h, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C009804h extends C04R {
    @Override // X.C04R
    public final C05C A00(AnonymousClass057 anonymousClass057) {
        C05C c05c = new C05C(null);
        ReportFieldString reportFieldString = AnonymousClass094.A7P;
        StringBuilder sb = new StringBuilder();
        sb.append("android_");
        sb.append(anonymousClass057.A00);
        sb.append("unexplained");
        c05c.A04(reportFieldString, sb.toString());
        return c05c;
    }

    @Override // X.C04R
    public final File[] A04(AnonymousClass057 anonymousClass057, File file) {
        if (anonymousClass057 == AnonymousClass057.LARGE_REPORT) {
            return new File[]{new File(file, "critical_unexplained_app_death_early_prop.txt")};
        }
        return null;
    }

    @Override // X.C04R
    public final EnumC011204x A01() {
        return EnumC011204x.UNEXPLAINED;
    }

    @Override // X.C04R
    public final Integer A02() {
        return AnonymousClass065.A00;
    }
}
