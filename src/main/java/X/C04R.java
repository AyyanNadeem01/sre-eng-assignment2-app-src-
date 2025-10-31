package X;

import android.app.Application;
import com.facebook.errorreporting.field.ReportFieldString;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: X.04R, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C04R {
    public final Application A00;
    public final C0C6 A01;
    public final C04Q A02;

    public abstract C05C A00(AnonymousClass057 anonymousClass057);

    public abstract EnumC011204x A01();

    public abstract Integer A02();

    public void A03(final AnonymousClass057 anonymousClass057, File file, File file2) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        File[] fileArrListFiles3;
        File[] fileArrListFiles4;
        File file3 = file;
        if (A02() == AnonymousClass065.A00) {
            file3 = file2;
        }
        if (file3 != null) {
            C04Q c04q = this.A02;
            final EnumC011204x enumC011204xA01 = A01();
            Object obj = C04Q.A06;
            synchronized (obj) {
                fileArrListFiles = file.listFiles(new FileFilter() { // from class: X.02I
                    @Override // java.io.FileFilter
                    public final boolean accept(File file4) {
                        AnonymousClass057 anonymousClass0572 = anonymousClass057;
                        EnumC011204x enumC011204x = enumC011204xA01;
                        if (file4 != null && file4.getName().startsWith(anonymousClass0572.A00)) {
                            String name = file4.getName();
                            StringBuilder sb = new StringBuilder();
                            sb.append(enumC011204x.A00);
                            sb.append("_prop.txt");
                            if (name.endsWith(sb.toString())) {
                                return true;
                            }
                        }
                        return false;
                    }
                });
                if (fileArrListFiles == null) {
                    fileArrListFiles = C04Q.A07;
                }
            }
            if (fileArrListFiles.length != 0) {
                for (File file4 : fileArrListFiles) {
                    if (!C04Q.A01(file, file4.getName())) {
                        file4.getName();
                        String name = file4.getName();
                        if (C04Q.A05 == null) {
                            C04Q.A05 = AbstractC018908k.A00();
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(name.replace("_prop.txt", "_"));
                        sb.append(C04Q.A05);
                        File file5 = new File(c04q.A01, sb.toString());
                        file5.mkdirs();
                        synchronized (obj) {
                            fileArrListFiles2 = file3.listFiles(new FileFilter() { // from class: X.02u
                                @Override // java.io.FileFilter
                                public final boolean accept(File file6) {
                                    AnonymousClass057 anonymousClass0572 = anonymousClass057;
                                    return file6 != null && (file6.getName().startsWith(anonymousClass0572.A00) || anonymousClass0572 == AnonymousClass057.LARGE_REPORT) && file6.getName().contains("suppl_") && file6.getName().endsWith("_prop.txt");
                                }
                            });
                            if (fileArrListFiles2 == null) {
                                fileArrListFiles2 = C04Q.A07;
                            }
                        }
                        C05C c05cA00 = A00(anonymousClass057);
                        c05cA00.A02(AnonymousClass094.A2z, AbstractC017707t.A00());
                        c05cA00.A02(AnonymousClass094.A30, AbstractC017707t.A01());
                        final boolean z = true;
                        c05cA00.A01(AnonymousClass094.A0A, true);
                        ReportFieldString reportFieldString = AnonymousClass094.A9f;
                        Application application = this.A00;
                        c05cA00.A04(reportFieldString, application.getApplicationInfo().publicSourceDir);
                        String installerPackageName = application.getPackageManager().getInstallerPackageName(application.getPackageName());
                        if (installerPackageName != null) {
                            c05cA00.A04(AnonymousClass094.A9e, installerPackageName);
                        }
                        ArrayList arrayList = new ArrayList(Arrays.asList(fileArrListFiles2));
                        if (!arrayList.contains(file4)) {
                            arrayList.add(file4);
                        }
                        File[] fileArrA04 = A04(anonymousClass057, file);
                        if (fileArrA04 != null) {
                            for (File file6 : fileArrA04) {
                                arrayList.add(file6);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        synchronized (obj) {
                            fileArrListFiles3 = file3.listFiles(new FileFilter() { // from class: X.02v
                                @Override // java.io.FileFilter
                                public final boolean accept(File file7) {
                                    AnonymousClass057 anonymousClass0572 = anonymousClass057;
                                    return file7 != null && (file7.getName().startsWith(anonymousClass0572.A00) || anonymousClass0572 == AnonymousClass057.LARGE_REPORT) && ((!z || file7.getName().contains("suppl_")) && file7.getName().endsWith("_attach.txt"));
                                }
                            });
                            if (fileArrListFiles3 == null) {
                                fileArrListFiles3 = C04Q.A07;
                            }
                        }
                        for (File file7 : fileArrListFiles3) {
                            if (!C04Q.A01(file, file7.getName())) {
                                arrayList2.add(file7);
                            }
                        }
                        final boolean z2 = false;
                        synchronized (obj) {
                            fileArrListFiles4 = file.listFiles(new FileFilter() { // from class: X.02v
                                @Override // java.io.FileFilter
                                public final boolean accept(File file72) {
                                    AnonymousClass057 anonymousClass0572 = anonymousClass057;
                                    return file72 != null && (file72.getName().startsWith(anonymousClass0572.A00) || anonymousClass0572 == AnonymousClass057.LARGE_REPORT) && ((!z2 || file72.getName().contains("suppl_")) && file72.getName().endsWith("_attach.txt"));
                                }
                            });
                            if (fileArrListFiles4 == null) {
                                fileArrListFiles4 = C04Q.A07;
                            }
                        }
                        for (File file8 : fileArrListFiles4) {
                            if (!C04Q.A01(file, file8.getName())) {
                                arrayList2.add(file8);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(anonymousClass057.A00);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(enumC011204xA01.A00);
                            sb3.append("_attach.txt");
                            sb2.append(sb3.toString());
                            c04q.A02(null, file5, sb2.toString(), arrayList2);
                        }
                        arrayList.addAll(arrayList2);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(anonymousClass057.A00);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(enumC011204xA01.A00);
                        sb5.append("_report.txt");
                        sb4.append(sb5.toString());
                        c04q.A02(c05cA00, file5, sb4.toString(), arrayList);
                        C04Q.A00(file, file4.getName());
                        C04Q.A00(file, file4.getName().replace("_prop.txt", "_attach.txt"));
                    }
                }
            }
        }
    }

    public C04R(Application application, C0C6 c0c6, C04Q c04q) {
        this.A00 = application;
        this.A01 = c0c6;
        this.A02 = c04q;
    }

    public File[] A04(AnonymousClass057 anonymousClass057, File file) {
        return null;
    }
}
