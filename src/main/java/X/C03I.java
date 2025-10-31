package X;

import com.facebook.errorreporting.field.ReportFieldString;
import java.io.File;
import java.io.FileFilter;

/* renamed from: X.03I, reason: invalid class name */
/* loaded from: classes.dex */
public final class C03I extends C04R {
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
    public final void A03(AnonymousClass057 anonymousClass057, File file, File file2) throws NumberFormatException {
        if (file2 != null) {
            File file3 = new File(file2, "critical_anr_prop.txt");
            if (file3.exists()) {
                file3.renameTo(new File(file3.getParentFile(), "critical_suppl_anr_extra_prop.txt"));
            }
            File[] fileArrListFiles = file2.listFiles(new FileFilter() { // from class: X.02G
                @Override // java.io.FileFilter
                public final boolean accept(File file4) {
                    return file4.getName().startsWith("large_") && file4.getName().endsWith("_anr_prop.txt");
                }
            });
            File file4 = null;
            if (fileArrListFiles != null) {
                int i = -1;
                for (File file5 : fileArrListFiles) {
                    try {
                        int i2 = Integer.parseInt(file5.getName().replace("large_", "").replace("_anr_prop.txt", ""));
                        if (i2 > i) {
                            file4 = file5;
                            i = i2;
                        }
                    } catch (NumberFormatException e) {
                        C018108b.A0K("lacrima", "Invalid anr report name %s", file5.getName(), e);
                        C0C5.A00();
                    }
                }
                if (file4 != null && file4.exists()) {
                    file4.renameTo(new File(file4.getParentFile(), "large_suppl_anr_extra_prop.txt"));
                }
            }
        }
        super.A03(anonymousClass057, file, file2);
    }

    @Override // X.C04R
    public final File[] A04(AnonymousClass057 anonymousClass057, File file) {
        if (anonymousClass057 == AnonymousClass057.LARGE_REPORT) {
            return new File[]{new File(file, "critical_anr_app_death_early_prop.txt")};
        }
        return null;
    }

    @Override // X.C04R
    public final EnumC011204x A01() {
        return EnumC011204x.ANR_APP_DEATH;
    }

    @Override // X.C04R
    public final Integer A02() {
        return AnonymousClass065.A00;
    }
}
