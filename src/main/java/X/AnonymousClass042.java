package X;

import android.os.Trace;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* renamed from: X.042, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class AnonymousClass042 implements AnonymousClass058 {
    public final /* synthetic */ C0AZ A00;
    public final /* synthetic */ boolean A01;

    @Override // X.AnonymousClass058
    public final void AYi(final AnonymousClass057 anonymousClass057, InterfaceC02430Ba interfaceC02430Ba) {
        C0AZ c0az = this.A00;
        boolean z = this.A01;
        C04Q c04q = (C04Q) c0az.A02().get();
        C0CK c0ck = c0az.A02;
        AnonymousClass053.A03(c0ck, "Did you call earlyInit()?");
        String str = c0ck.A06;
        StringBuilder sb = new StringBuilder();
        sb.append("processCurrentSession.");
        String strName = anonymousClass057.name();
        sb.append(strName);
        sb.append(".");
        sb.append(str);
        AbstractC017507q.A00(sb.toString());
        try {
            synchronized (C04Q.A06) {
                File[] fileArrA02 = c04q.A00.A02(str);
                int length = fileArrA02.length - 1;
                if (length >= 0) {
                    File file = fileArrA02[length];
                    File file2 = length > 0 ? fileArrA02[length - 1] : null;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("maybeAssembleReport.");
                    sb2.append(strName);
                    AbstractC017507q.A00(sb2.toString());
                    try {
                        List<C04R> list = c04q.A02;
                        list.size();
                        for (C04R c04r : list) {
                            file.getName();
                            if (file2 != null) {
                                file2.getName();
                            }
                            c04r.A03(anonymousClass057, file, file2);
                        }
                        try {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("mixers");
                            sb3.append("_done");
                            new File(file, sb3.toString()).createNewFile();
                        } catch (IOException unused) {
                            C0C5.A00();
                        }
                        Trace.endSection();
                    } finally {
                    }
                }
            }
            if (z) {
                final C0CC c0cc = (C0CC) c0az.A0Q.get();
                C0C5.A00();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("sendPendingReports.");
                sb4.append(strName);
                sb4.append("");
                AbstractC017507q.A00(sb4.toString());
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                c0cc.A09.execute(new C02P() { // from class: X.02Q
                    public static final String __redex_internal_original_name = "ReportSender$2";

                    @Override // java.lang.Runnable
                    public final void run() {
                        int iIndexOf;
                        C0CC c0cc2 = c0cc;
                        AnonymousClass057 anonymousClass0572 = anonymousClass057;
                        C0C5.A00();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("sendPendingReportsInternal.");
                        String strName2 = anonymousClass0572.name();
                        sb5.append(strName2);
                        AbstractC017507q.A00(sb5.toString());
                        try {
                            C02K c02k = c0cc2.A06;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("send_");
                            sb6.append(strName2);
                            if (!c02k.A00(sb6.toString())) {
                                synchronized (c02k.A00) {
                                    try {
                                    } finally {
                                    }
                                }
                                C02B c02b = c0cc2.A05;
                                AnonymousClass057[] anonymousClass057Arr = {anonymousClass0572};
                                ArrayList[] arrayListArr = {new ArrayList()};
                                File[] fileArrListFiles = ((C04Q) c02b.A00.get()).A01.listFiles();
                                if (fileArrListFiles != null) {
                                    for (File file3 : fileArrListFiles) {
                                        if (file3 != null && file3.isDirectory() && file3.getName().startsWith(anonymousClass057Arr[0].A00)) {
                                            arrayListArr[0].add(file3);
                                        }
                                    }
                                }
                                ArrayList arrayList = arrayListArr[0];
                                File[] fileArr = new C02R[]{new C02R((File[]) arrayList.toArray(new File[arrayList.size()]))}[0].A00;
                                if (fileArr != null) {
                                    final HashMap map = new HashMap();
                                    final HashMap map2 = new HashMap();
                                    for (File file4 : fileArr) {
                                        String name = file4.getName();
                                        int iLastIndexOf = name.lastIndexOf(95);
                                        if (iLastIndexOf >= 0 && iLastIndexOf < name.length() - 1 && (iIndexOf = name.indexOf(45, iLastIndexOf)) >= 0) {
                                            try {
                                                map.put(file4, Long.valueOf(Long.parseLong(name.substring(iLastIndexOf + 1, iIndexOf))));
                                            } catch (NumberFormatException unused2) {
                                                C0C5.A00();
                                            }
                                        }
                                        map2.put(file4, Long.valueOf(file4.lastModified()));
                                    }
                                    Arrays.sort(fileArr, new Comparator() { // from class: X.02S
                                        @Override // java.util.Comparator
                                        public final int compare(Object obj, Object obj2) {
                                            Map map3 = map;
                                            Map map4 = map2;
                                            Number number = (Number) map3.get(obj);
                                            Number number2 = (Number) map3.get(obj2);
                                            if (number == null || number2 == null) {
                                                number = (Number) map4.get(obj);
                                                if (number == null) {
                                                    number = 0L;
                                                }
                                                number2 = (Number) map4.get(obj2);
                                                if (number2 == null) {
                                                    number2 = 0L;
                                                }
                                            }
                                            return (int) (number.longValue() - number2.longValue());
                                        }
                                    });
                                    c0cc2.A0A.getAndIncrement();
                                    C02F c02f = new C02F();
                                    for (File file5 : fileArr) {
                                        File fileA01 = C0CC.A01(file5, "_report.txt");
                                        if (fileA01 != null) {
                                            try {
                                                Properties properties = new Properties();
                                                FileReader fileReader = new FileReader(fileA01);
                                                try {
                                                    properties.load(fileReader);
                                                    fileReader.close();
                                                    C005302h c005302h = new C005302h(properties);
                                                    C0CC.A0G++;
                                                    C0C5.A00();
                                                    file5.getName();
                                                    if (file5.exists()) {
                                                        AbstractC017507q.A00("ReportSender.sendInternal");
                                                        try {
                                                            Set set = c0cc2.A08;
                                                            synchronized (set) {
                                                                try {
                                                                    if (set.contains(file5)) {
                                                                        C018108b.A0K("lacrima", "Report sender attempt already in progress: %s", file5.getName());
                                                                    } else {
                                                                        set.add(file5);
                                                                        C0CC.A02(c005302h, c0cc2, c02f, file5);
                                                                        synchronized (set) {
                                                                            try {
                                                                                set.remove(file5);
                                                                            } finally {
                                                                            }
                                                                        }
                                                                        C0C5.A00();
                                                                    }
                                                                } catch (Throwable th) {
                                                                    throw th;
                                                                }
                                                            }
                                                            Trace.endSection();
                                                        } catch (Throwable th2) {
                                                            try {
                                                                C0C5.A00();
                                                                file5.getName();
                                                                throw th2;
                                                            } catch (Throwable th3) {
                                                                throw th3;
                                                            }
                                                        }
                                                    } else {
                                                        file5.getName();
                                                    }
                                                } catch (Throwable th4) {
                                                    try {
                                                        fileReader.close();
                                                    } catch (Throwable th5) {
                                                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th4, th5);
                                                    }
                                                    throw th4;
                                                }
                                            } catch (IOException unused3) {
                                                C0C5.A00();
                                            }
                                        }
                                    }
                                }
                                C0C5.A00();
                            }
                            Trace.endSection();
                            countDownLatch.countDown();
                        } catch (Throwable th6) {
                            try {
                                C0C5.A00();
                                throw th6;
                            } finally {
                                Trace.endSection();
                            }
                        }
                    }
                });
                C0C5.A00();
            }
        } finally {
        }
    }

    public /* synthetic */ AnonymousClass042(C0AZ c0az, boolean z) {
        this.A00 = c0az;
        this.A01 = z;
    }
}
