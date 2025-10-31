package X;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.facebook.errorreporting.field.ReportFieldBase;
import com.facebook.errorreporting.field.ReportFieldString;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* renamed from: X.09l, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C021209l {
    public static String A03 = "0";
    public static String A04 = "0";
    public static String A05 = "0";
    public static Application A06;
    public static C021209l A07;
    public static File A08;
    public static Callable A09;
    public static Callable A0A;
    public static Callable A0B;
    public static boolean A0C;
    public static final Object A0D = new Object();
    public C02L A00;
    public String A01;
    public Executor A02;

    public final synchronized void A06(final String str, final Map map) {
        Executor executorA00 = this.A02;
        if (executorA00 == null) {
            executorA00 = C022009w.A00();
            this.A02 = executorA00;
        }
        executorA00.execute(new C02P() { // from class: X.09k
            public static final String __redex_internal_original_name = "DirectReportInternal$2";

            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                try {
                    C021209l c021209l = this.A00;
                    if (c021209l.A00 == null) {
                        List list = C02L.A03;
                        c021209l.A00 = new C02L(C02M.A01(null, c021209l.A01), new C02E(), null);
                    }
                    Application application = C021209l.A06;
                    if (application == null || AbstractC005602k.A00(application)) {
                        String str2 = str;
                        Map map2 = map;
                        Properties properties = new Properties();
                        properties.putAll(map2);
                        properties.put(AnonymousClass094.A7P.name, str2);
                        C021209l.A01();
                        try {
                            File file = C021209l.A08;
                            HashMap mapA01 = C03E.A01();
                            if (mapA01.containsKey("ig.ig_server_rev_hash")) {
                                properties.put(AnonymousClass094.A6U.name, mapA01.get("ig.ig_server_rev_hash"));
                            }
                            if (mapA01.containsKey("fb.report_source")) {
                                properties.put(AnonymousClass094.A9g.name, mapA01.get("fb.report_source"));
                                if (mapA01.containsKey("fb.testing.build_target")) {
                                    properties.put(AnonymousClass094.A7m.name, mapA01.get("fb.testing.build_target"));
                                }
                                if (file != null) {
                                    File fileA02 = AnonymousClass000.A02(AnonymousClass000.A02(file, "report_source"), "report_source_ref.txt");
                                    if (fileA02.exists()) {
                                        StringBuilder sbA09 = AnonymousClass000.A09();
                                        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileA02));
                                        while (true) {
                                            try {
                                                String line = bufferedReader.readLine();
                                                if (line == null) {
                                                    break;
                                                }
                                                sbA09.append(line);
                                                sbA09.append('\n');
                                            } catch (Throwable th) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable th2) {
                                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                                }
                                                throw th;
                                            }
                                        }
                                        String string = sbA09.toString();
                                        bufferedReader.close();
                                        if (string != null) {
                                            properties.put(AnonymousClass094.A9i.name, string);
                                        }
                                    }
                                }
                            }
                        } catch (IOException e) {
                            C0C5.A00();
                            C018108b.A0D("lacrima", "Failed to read report source ref", e);
                        }
                        HashMap mapA0C = AnonymousClass000.A0C();
                        c021209l.A00.A01(new C005302h(properties), mapA0C, 1);
                        Iterator it = mapA0C.values().iterator();
                        while (it.hasNext()) {
                            ((C008203r) it.next()).A01.close();
                        }
                    }
                } catch (Exception e2) {
                    C0C5.A00();
                    C018108b.A0A("lacrima", "Failed to send direct report", e2);
                }
            }
        });
    }

    public static C021209l A00() {
        C021209l c021209l;
        synchronized (A0D) {
            c021209l = A07;
            if (c021209l == null) {
                String string = C0CH.A00("mobile", "reliability_event_log_upload").toString();
                c021209l = new C021209l();
                c021209l.A01 = string;
                c021209l.A00 = null;
                A07 = c021209l;
            }
        }
        return c021209l;
    }

    public static void A01() {
        synchronized (A0D) {
            if (!A0C) {
                try {
                    Callable callable = A09;
                    if (callable != null) {
                        String str = (String) callable.call();
                        if (str == null) {
                            str = A04;
                        }
                        A04 = str;
                    }
                    Callable callable2 = A0B;
                    if (callable2 != null) {
                        String str2 = (String) callable2.call();
                        if (str2 == null) {
                            str2 = A05;
                        }
                        A05 = str2;
                    }
                    Callable callable3 = A0A;
                    if (callable3 != null) {
                        A08 = (File) callable3.call();
                    }
                } catch (Exception e) {
                    C0C5.A00();
                    C018108b.A0A("lacrima", "Error lazy initializing DirectReportInternal", e);
                }
                A0C = true;
            }
        }
    }

    public static void A02(ReportFieldBase reportFieldBase, String str, Map map) {
        synchronized (A0D) {
            if (TextUtils.isEmpty(str)) {
                map.remove(reportFieldBase.name);
            } else if (TextUtils.isEmpty((CharSequence) map.get(reportFieldBase.name))) {
                map.put(reportFieldBase.name, str);
            }
        }
    }

    public static void A04(String str, Map map, String str2) {
        A02(AnonymousClass094.A5J, "soft_error", map);
        A02(AnonymousClass094.A4k, "i", map);
        A02(AnonymousClass094.AA2, str, map);
        A02(AnonymousClass094.AA3, str2, map);
        synchronized (A0D) {
            if (TextUtils.isEmpty((CharSequence) map.get("cause"))) {
                A02(AnonymousClass094.A5K, C08v.A01(new RuntimeException(AnonymousClass000.A06(" | ", str2, AnonymousClass000.A0A(str)), null)), map);
            }
        }
    }

    public static void A05(Map map) {
        ReportFieldString reportFieldString = AnonymousClass094.A7K;
        C02610Ca c02610Ca = new C02610Ca(0);
        synchronized (A0D) {
            A02(reportFieldString, (String) c02610Ca.get(), map);
        }
    }

    public static void A03(String str, String str2, String str3, String str4, Map map) {
        ReportFieldString reportFieldString;
        String string;
        A01();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        AnonymousClass091 anonymousClass091 = AnonymousClass094.A3P;
        String string2 = Long.toString(jCurrentTimeMillis);
        A02(anonymousClass091, string2, map);
        A02(AnonymousClass094.A1g, string2, map);
        if (str != null) {
            A02(AnonymousClass094.AAZ, str, map);
        } else {
            C018108b.A08("lacrima", "User Id missing. Direct reports use 0 as user id.");
            A02(AnonymousClass094.AAZ, "0", map);
        }
        if (str2 != null) {
            reportFieldString = AnonymousClass094.A3s;
        } else {
            C018108b.A08("lacrima", "ACTOR_ID missing. Direct reports use 0 as id.");
            reportFieldString = AnonymousClass094.A3s;
            str2 = "-6";
        }
        A02(reportFieldString, str2, map);
        if (str3 != null) {
            A02(AnonymousClass094.A3o, str3, map);
        } else {
            C018108b.A08("lacrima", "ACTING_ACCOUNT_ID missing. Direct reports use 0 as id.");
            A02(AnonymousClass094.A3o, "0", map);
        }
        A02(AnonymousClass094.A5v, "lacrima_direct_report", map);
        A02(AnonymousClass094.A4u, "lacrima_direct_report", map);
        A02(AnonymousClass094.A9m, "lacrima_direct_report", map);
        A02(AnonymousClass094.A3c, Long.toString(AnonymousClass050.A01()), map);
        A02(AnonymousClass094.A1t, Long.toString(AnonymousClass050.A00()), map);
        A02(AnonymousClass094.A4i, "r", map);
        A02(AnonymousClass094.A30, Long.toString(AbstractC017707t.A01()), map);
        synchronized (A0D) {
            A02(AnonymousClass094.A4T, A03, map);
            A02(AnonymousClass094.A5i, A04, map);
            A02(AnonymousClass094.A4p, A05, map);
            Application application = A06;
            if (application != null) {
                String packageName = application.getPackageName();
                if (str4 == null) {
                    str4 = "";
                }
                ReportFieldString reportFieldString2 = AnonymousClass094.A4Y;
                StringBuilder sbA0A = AnonymousClass000.A0A(packageName);
                String strA06 = "";
                if (!"".equals(str4)) {
                    strA06 = AnonymousClass000.A06(":", str4, AnonymousClass000.A09());
                }
                A02(reportFieldString2, AnonymousClass000.A07(strA06, sbA0A), map);
                ReportFieldString reportFieldString3 = AnonymousClass094.AAM;
                ApplicationInfo applicationInfo = A06.getApplicationInfo();
                if (applicationInfo == null) {
                    string = "n/a";
                } else {
                    string = Integer.toString(applicationInfo.targetSdkVersion);
                }
                A02(reportFieldString3, string, map);
            }
        }
        A02(AnonymousClass094.A0F, Boolean.toString(AbstractC017707t.A02()), map);
        A02(AnonymousClass094.A2j, Long.toString(Process.myPid()), map);
        A02(AnonymousClass094.A0U, Boolean.toString(AbstractC017707t.A03()), map);
        A02(AnonymousClass094.A5k, Build.MODEL, map);
        A02(AnonymousClass094.A5l, Build.DEVICE, map);
        A02(AnonymousClass094.A5g, Build.BRAND, map);
        A02(AnonymousClass094.A5n, Build.VERSION.RELEASE, map);
        A02(AnonymousClass094.A5q, "true", map);
        if (Build.VERSION.SDK_INT >= 30) {
            JSONObject jSONObjectA00 = C04Y.A00();
            if (jSONObjectA00.length() > 0) {
                A02(AnonymousClass094.A9u, jSONObjectA00.toString(), map);
            }
        }
        ReportFieldString reportFieldString4 = AnonymousClass094.A9d;
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append(Math.random());
        sbA09.append("-");
        sbA09.append(System.currentTimeMillis());
        A02(reportFieldString4, sbA09.toString(), map);
        long jA01 = AbstractC017707t.A01();
        AnonymousClass091 anonymousClass0912 = AnonymousClass094.A1d;
        String string3 = Long.toString(jA01);
        A02(anonymousClass0912, string3, map);
        A02(AnonymousClass094.A2T, string3, map);
        A02(AnonymousClass094.A7l, "482.0.0.12.107", map);
        A02(AnonymousClass094.A0A, Boolean.toString(true), map);
    }
}
