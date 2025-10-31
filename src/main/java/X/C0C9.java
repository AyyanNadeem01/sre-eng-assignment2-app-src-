package X;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import com.facebook.common.dextricks.classtracing.logger.ClassTracingLoggerFbLite;
import com.facebook.errorreporting.field.ReportFieldString;
import com.facebook.errorreporting.lacrima.detector.javacrash.JavaCrashDetector;
import com.facebook.lite.SharedPreferencesHookA11;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* renamed from: X.0C9, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0C9 {
    public static AnonymousClass095 A00;
    public static C0AZ A01;
    public static C02250Ab A02;
    public static boolean A03;
    public static boolean A04;
    public static boolean A05;
    public static boolean A06;
    public static boolean A07;
    public static final CountDownLatch A09 = new CountDownLatch(1);
    public static final Object A08 = new Object();

    /* JADX WARN: Type inference failed for: r1v10, types: [X.0BO] */
    public static void A02(final Application application, final C0C6 c0c6, long j) {
        final int i = 0;
        C0CC.A0H = false;
        Method method = AnonymousClass066.A03;
        Trace.beginSection("LacrimaInit.getConfig");
        try {
            if (A02 == null) {
                C02630Cc c02630Cc = new C02630Cc(24);
                C02630Cc c02630Cc2 = new C02630Cc(25);
                C015606v.A01();
                boolean zA04 = C015606v.A04(application.getApplicationContext(), 60);
                final C018608h c018608h = new C018608h(application, zA04);
                final int i2 = 3;
                C02640Cd c02640Cd = new C02640Cd(c018608h, 3);
                C02630Cc c02630Cc3 = new C02630Cc(19);
                C02630Cc c02630Cc4 = new C02630Cc(20);
                C02630Cc c02630Cc5 = new C02630Cc(21);
                C02630Cc c02630Cc6 = new C02630Cc(22);
                C02630Cc c02630Cc7 = new C02630Cc(23);
                final int i3 = 2;
                final C02610Ca c02610Ca = new C02610Ca(2);
                C02250Ab c02250Ab = new C02250Ab(application);
                c02250Ab.A06 = new C02620Cb(AbstractC018908k.A00(), 0);
                c02250Ab.A00 = 1048576;
                final int i4 = 1;
                c02250Ab.A0A = true;
                Trace.beginSection("Config.createStartupConfig");
                if (AbstractC019408p.A00 != null) {
                    C018108b.A08("lacrima", "ErrorReportingDiagnosticData.setInstance already set.");
                } else {
                    synchronized (C09M.class) {
                    }
                    String strA00 = AbstractC018908k.A00();
                    ?? r1 = new Object() { // from class: X.0BO
                    };
                    C06E.A07(strA00, 0);
                    if (!AbstractC018708i.A01) {
                        AbstractC018708i.A00 = r1;
                        AbstractC018708i.A01 = true;
                    }
                    AbstractC019408p.A00 = new C06H() { // from class: X.0BW
                    };
                    synchronized (C09M.class) {
                    }
                    C09M.A00(AnonymousClass094.A3r);
                    C09M.A00(AnonymousClass094.A4S);
                    C09M.A00(AnonymousClass094.A4W);
                    C09M.A00(AnonymousClass094.A4e);
                    C09M.A00(AnonymousClass094.A5O);
                    C09M.A00(AnonymousClass094.A08);
                    C09M.A00(AnonymousClass094.A5v);
                    C09M.A00(AnonymousClass094.A5w);
                    C09M.A00(AnonymousClass094.A1q);
                    C09M.A00(AnonymousClass094.A6T);
                    C09M.A00(AnonymousClass094.A6W);
                    C09M.A00(AnonymousClass094.A0I);
                    C09M.A00(AnonymousClass094.A6x);
                    C09M.A00(AnonymousClass094.A7I);
                    C09M.A00(AnonymousClass094.A7V);
                    C09M.A00(AnonymousClass094.A7g);
                    C09M.A00(AnonymousClass094.A7v);
                    C09M.A00(AnonymousClass094.A7w);
                    C09M.A00(AnonymousClass094.A84);
                    C09M.A00(AnonymousClass094.A89);
                    C09M.A00(AnonymousClass094.A97);
                    C09M.A00(AnonymousClass094.A0f);
                    C09M.A00(AnonymousClass094.A9M);
                    C09M.A00(AnonymousClass094.A9N);
                    C09M.A00(AnonymousClass094.A9O);
                    C09M.A00(AnonymousClass094.A9y);
                    C09M.A00(AnonymousClass094.AAB);
                    C09M.A00(AnonymousClass094.AAC);
                    C09M.A00(AnonymousClass094.AAD);
                    C09M.A00(AnonymousClass094.AAE);
                    C09M.A00(AnonymousClass094.AAP);
                    C09M.A00(AnonymousClass094.AAW);
                    C09M.A00(AnonymousClass094.AAV);
                    C09M.A00(AnonymousClass094.AAU);
                    C09M.A00(AnonymousClass094.AAd);
                    C09M.A00(AnonymousClass094.AAf);
                }
                C0AV c0av = new C0AV(C0AX.A0C);
                c0av.A00 = new C02630Cc(9);
                C02640Cd c02640Cd2 = new C02640Cd(application, 2);
                C0AR c0ar = c0av.A04;
                List list = c0ar.A02;
                list.add(c02640Cd2);
                A06(list, 8);
                A06(list, 12);
                Trace.endSection();
                Integer num = AnonymousClass065.A00;
                C09I c09i = new C09I();
                c09i.A01 = num;
                c09i.A00 = j;
                c0ar.A03.add(c09i);
                list.add(c02630Cc7);
                A03(c0av, c02250Ab);
                Trace.beginSection("Config.createNavigationConfig");
                C0AV c0av2 = new C0AV(C0AX.A0E);
                c0av2.A00 = new C02630Cc(11);
                Trace.endSection();
                A03(c0av2, c02250Ab);
                C0A1[] c0a1Arr = new C0A1[2];
                final C0BX c0bx = new C0BX();
                synchronized (C019908u.class) {
                    try {
                        C019908u.A04 = c0bx;
                        if (C019908u.A04 != null) {
                            List list2 = C019908u.A00;
                            Iterator it = list2.iterator();
                            while (it.hasNext()) {
                                it.next();
                                C019908u.A03.execute(new Runnable() { // from class: X.08q
                                    public static final String __redex_internal_original_name = "GlobalAppState$$ExternalSyntheticLambda4";

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        boolean z = C019908u.A06;
                                        throw new NullPointerException("onInstanceSet");
                                    }
                                });
                            }
                            list2.clear();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                c0a1Arr[0] = new C02670Cg(c0bx, 1);
                C015606v.A01();
                c0a1Arr[1] = C015606v.A04(application.getApplicationContext(), 66) ? new C0A1(i4) { // from class: X.0Cf
                    public final int $t;

                    {
                        this.$t = i4;
                    }

                    @Override // X.C0A1
                    public final void AWZ(final boolean z) {
                        if (this.$t != 0) {
                            C022009w.A04.execute(new Runnable() { // from class: X.01b
                                public static final String __redex_internal_original_name = "LacrimaInit$18$$ExternalSyntheticLambda0";

                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (z) {
                                        InterfaceC000700k interfaceC000700k = C00a.A09;
                                        if (interfaceC000700k != null) {
                                            interfaceC000700k.resume();
                                            return;
                                        }
                                        return;
                                    }
                                    InterfaceC000700k interfaceC000700k2 = C00a.A09;
                                    if (interfaceC000700k2 != null) {
                                        interfaceC000700k2.pause();
                                    }
                                }
                            });
                            return;
                        }
                        InterfaceC000700k interfaceC000700k = C00a.A09;
                        if (z) {
                            if (interfaceC000700k != null) {
                                interfaceC000700k.resume();
                            }
                        } else if (interfaceC000700k != null) {
                            interfaceC000700k.pause();
                        }
                    }
                } : new C0A1(i) { // from class: X.0Cf
                    public final int $t;

                    {
                        this.$t = i;
                    }

                    @Override // X.C0A1
                    public final void AWZ(final boolean z) {
                        if (this.$t != 0) {
                            C022009w.A04.execute(new Runnable() { // from class: X.01b
                                public static final String __redex_internal_original_name = "LacrimaInit$18$$ExternalSyntheticLambda0";

                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (z) {
                                        InterfaceC000700k interfaceC000700k = C00a.A09;
                                        if (interfaceC000700k != null) {
                                            interfaceC000700k.resume();
                                            return;
                                        }
                                        return;
                                    }
                                    InterfaceC000700k interfaceC000700k2 = C00a.A09;
                                    if (interfaceC000700k2 != null) {
                                        interfaceC000700k2.pause();
                                    }
                                }
                            });
                            return;
                        }
                        InterfaceC000700k interfaceC000700k = C00a.A09;
                        if (z) {
                            if (interfaceC000700k != null) {
                                interfaceC000700k.resume();
                            }
                        } else if (interfaceC000700k != null) {
                            interfaceC000700k.pause();
                        }
                    }
                };
                Trace.beginSection("Config.createLifecycleConfig");
                int i5 = 0;
                do {
                    C0BY.A00.add(c0a1Arr[i5]);
                    i5++;
                } while (i5 < 2);
                C0AV c0av3 = new C0AV(C0AX.A0D);
                c0av3.A00 = new C02630Cc(10);
                c0av3.A02 = num;
                Trace.endSection();
                A03(c0av3, c02250Ab);
                final InterfaceC02510Bm interfaceC02510Bm = new InterfaceC02510Bm() { // from class: X.099
                    @Override // X.InterfaceC02510Bm
                    public final boolean A1q(Throwable th2) {
                        return !(th2 instanceof C08D);
                    }
                };
                final C021609s c021609s = C021609s.A00;
                final InterfaceC02510Bm interfaceC02510Bm2 = JavaCrashDetector.A05;
                AnonymousClass089.A00();
                Trace.beginSection("Config.createJavaDetectionConfig");
                C0AV c0av4 = new C0AV(C0AX.A04);
                c0av4.A00 = new C0AS() { // from class: X.0BA
                    @Override // X.C0AS
                    public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
                        C0CK c0ck = c0az.A02;
                        return new JavaCrashDetector(AnonymousClass053.A00(c0az, c0ck), c021609s, interfaceC02510Bm2, interfaceC02510Bm, c0ck);
                    }
                };
                c0av4.A02 = num;
                final int i6 = 4;
                C02630Cc c02630Cc8 = new C02630Cc(4);
                C0AR c0ar2 = c0av4.A04;
                List list3 = c0ar2.A02;
                list3.add(c02630Cc8);
                AnonymousClass095 anonymousClass095 = new AnonymousClass095() { // from class: X.09B
                    public final Integer A00;
                    public final AnonymousClass095[] A01;

                    {
                        Integer num2 = AnonymousClass065.A0B;
                        AnonymousClass095[] anonymousClass095Arr = {new C09A(), new C09D()};
                        this.A00 = num2;
                        this.A01 = anonymousClass095Arr;
                    }

                    @Override // X.AnonymousClass095
                    public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) {
                        AnonymousClass095[] anonymousClass095Arr = this.A01;
                        int i7 = 0;
                        do {
                            AnonymousClass095 anonymousClass0952 = anonymousClass095Arr[i7];
                            try {
                                anonymousClass0952.Afg(c05c, anonymousClass057);
                            } catch (Throwable th2) {
                                C0C5.A00();
                                ReportFieldString reportFieldString = AnonymousClass094.A6t;
                                String str = (String) c05c.A09.get(reportFieldString);
                                StringBuilder sbA09 = AnonymousClass000.A09();
                                if (str == null) {
                                    str = "";
                                }
                                sbA09.append(str);
                                sbA09.append("Error: ");
                                sbA09.append(AnonymousClass045.A00(anonymousClass0952.AGY()));
                                sbA09.append(": ");
                                sbA09.append(th2.getMessage());
                                c05c.A04(reportFieldString, AnonymousClass000.A07("\n", sbA09));
                            }
                            i7++;
                        } while (i7 < 2);
                    }

                    @Override // X.AnonymousClass095
                    public final Integer AGY() {
                        return this.A00;
                    }
                };
                List list4 = c0ar2.A03;
                list4.add(anonymousClass095);
                c0ar2.A08.add(new AnonymousClass095(application) { // from class: X.09P
                    public static final String[] A01 = {"android.permission.READ_CALENDAR", "android.permission.CAMERA", "android.permission.READ_CONTACTS", "android.permission.ACCESS_FINE_LOCATION", "android.permission.RECORD_AUDIO", "android.permission.READ_PHONE_STATE", "android.permission.BODY_SENSORS", "android.permission.SEND_SMS", "android.permission.READ_EXTERNAL_STORAGE"};
                    public final Application A00;

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Removed duplicated region for block: B:39:0x0085  */
                    /* JADX WARN: Removed duplicated region for block: B:47:0x009c  */
                    /* JADX WARN: Removed duplicated region for block: B:56:0x00b9  */
                    /* JADX WARN: Removed duplicated region for block: B:60:0x00c5  */
                    /* JADX WARN: Removed duplicated region for block: B:64:0x00d1  */
                    /* JADX WARN: Removed duplicated region for block: B:68:0x00dd  */
                    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
                    @Override // X.AnonymousClass095
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void Afg(X.C05C r8, X.AnonymousClass057 r9) throws org.json.JSONException {
                        /*
                            Method dump skipped, instructions count: 328
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: X.C09P.Afg(X.05C, X.057):void");
                    }

                    {
                        this.A00 = application;
                    }

                    @Override // X.AnonymousClass095
                    public final Integer AGY() {
                        return AnonymousClass065.A0W;
                    }
                });
                list4.add(new C09J());
                c0av4.A01 = new C0AS(i4, application, c0c6) { // from class: X.0Ce
                    public final int $t;
                    public final Object A00;
                    public final Object A01;

                    {
                        this.$t = i4;
                        this.A00 = application;
                        this.A01 = c0c6;
                    }

                    @Override // X.C0AS
                    public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
                        switch (this.$t) {
                            case 0:
                                return new C03I((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                                return new C04S((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 2:
                                return new C03C((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 3:
                                return new C00W((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                                Application application2 = (Application) this.A01;
                                C0CK c0ck = c0az.A02;
                                return new InterfaceC02430Ba(application2, AnonymousClass053.A00(c0az, c0ck), c0ck, (C09V) this.A00) { // from class: X.03K
                                    public final Application A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;

                                    /* JADX WARN: Can't wrap try/catch for region: R(14:6|(3:8|(1:(2:10|(2:91|12)(2:19|(1:92)(3:21|(5:89|23|78|24|(2:29|97)(2:93|28))(1:96)|37)))(1:90))|34)(1:13)|14|(1:52)(6:82|38|80|39|(2:43|(10:45|60|61|85|62|(1:64)(1:66)|65|(1:68)|71|(4:73|(1:75)|76|77)(1:100)))|46)|55|(2:57|(1:59))(1:60)|61|85|62|(0)(0)|65|(0)|71|(0)(0)) */
                                    /* JADX WARN: Code restructure failed: missing block: B:69:0x016d, code lost:
                                    
                                        r0 = move-exception;
                                     */
                                    /* JADX WARN: Code restructure failed: missing block: B:70:0x016e, code lost:
                                    
                                        X.C0C5.A00();
                                        r3.A04(X.AnonymousClass094.A6Z, r0.getMessage());
                                     */
                                    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
                                    /* JADX WARN: Removed duplicated region for block: B:64:0x014b A[Catch: all -> 0x016d, TryCatch #4 {all -> 0x016d, blocks: (B:62:0x012b, B:64:0x014b, B:65:0x014f, B:68:0x015f, B:66:0x0158), top: B:85:0x012b }] */
                                    /* JADX WARN: Removed duplicated region for block: B:66:0x0158 A[Catch: all -> 0x016d, TryCatch #4 {all -> 0x016d, blocks: (B:62:0x012b, B:64:0x014b, B:65:0x014f, B:68:0x015f, B:66:0x0158), top: B:85:0x012b }] */
                                    /* JADX WARN: Removed duplicated region for block: B:68:0x015f A[Catch: all -> 0x016d, TRY_LEAVE, TryCatch #4 {all -> 0x016d, blocks: (B:62:0x012b, B:64:0x014b, B:65:0x014f, B:68:0x015f, B:66:0x0158), top: B:85:0x012b }] */
                                    /* JADX WARN: Removed duplicated region for block: B:73:0x0189  */
                                    /* JADX WARN: Type inference failed for: r1v10, types: [X.02f] */
                                    /* JADX WARN: Type inference failed for: r1v15, types: [X.02f] */
                                    @Override // X.InterfaceC02430Ba
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                                    */
                                    public final void start() {
                                        /*
                                            Method dump skipped, instructions count: 417
                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: X.C03K.start():void");
                                    }

                                    {
                                        this.A00 = application2;
                                        this.A02 = c0ck;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.NATIVE;
                                    }
                                };
                            case 5:
                                return new C009804h((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            default:
                                C0CK c0ck2 = c0az.A02;
                                return new InterfaceC02430Ba((C018608h) this.A00, AnonymousClass053.A00(c0az, c0ck2), c0ck2, this, (C09V) this.A01) { // from class: X.04g
                                    public final C018608h A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;
                                    public final /* synthetic */ C02650Ce A04;

                                    {
                                        this.A04 = this;
                                        this.A02 = c0ck2;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                        this.A00 = c018608h;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        String str;
                                        C0C5.A00();
                                        C04w.A0E.add("UnexplainedAppDeathDetector");
                                        C010004j c010004j = (C010004j) this.A03.get();
                                        if (c010004j.A07) {
                                            C0CK c0ck3 = this.A02;
                                            File fileA01 = c0ck3.A01(c0ck3.A06);
                                            long jLastModified = new File(fileA01, "state.txt").lastModified();
                                            SystemClock.uptimeMillis();
                                            String strA02 = C07O.A02("fb.report_source");
                                            if ("jest_e2e".equals(strA02)) {
                                                str = "Ignore ufads on jest test runs.";
                                            } else {
                                                if (!"sapienz".equals(strA02) || c010004j.A02 != 'f') {
                                                    if (c010004j.A06) {
                                                        boolean zA02 = c010004j.A02();
                                                        if (AbstractC010304m.A01(AnonymousClass065.A01, c010004j.A01) && !new File(fileA01, "critical_suppl_java_detect_prop.txt").exists() && !new File(fileA01, "critical_java_prop.txt").exists() && !new File(fileA01, "critical_java_detect_prop.txt").exists()) {
                                                            C018108b.A08("lacrima", "Java state with no java report, reporting as fad");
                                                        } else if (!zA02) {
                                                            return;
                                                        }
                                                        C05C c05c = new C05C(null);
                                                        c05c.A02(AnonymousClass094.A1E, 1);
                                                        c05c.A03(AnonymousClass094.A3P, Long.valueOf(jLastModified / 1000));
                                                        c05c.A03(AnonymousClass094.A1g, Long.valueOf(System.currentTimeMillis() / 1000));
                                                        c05c.A04(AnonymousClass094.A5J, "unexplained");
                                                        C04w c04w = this.A01;
                                                        c04w.A06(c05c, AnonymousClass057.CRITICAL_REPORT, this);
                                                        c04w.A06(c05c, AnonymousClass057.LARGE_REPORT, this);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                str = "Ignore f states on sapienz runs.";
                                            }
                                            C018108b.A08("lacrima", str);
                                        }
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.UNEXPLAINED;
                                    }
                                };
                        }
                    }
                };
                Trace.endSection();
                c0av4.A03 = true;
                A06(list3, 3);
                list3.add(c02630Cc);
                list3.add(c02630Cc2);
                list3.add(c02640Cd);
                if (zA04) {
                    c0ar2.A07.add(c02640Cd);
                }
                c0ar2.A04.add(c02630Cc4);
                Integer num2 = AnonymousClass065.A01;
                C09I c09i2 = new C09I();
                c09i2.A01 = num2;
                c09i2.A00 = j;
                list4.add(c09i2);
                c0ar2.A07.add(c02630Cc3);
                A03(c0av4, c02250Ab);
                c02250Ab.A00(new C02730Cm(application));
                c02250Ab.A00(new C02730Cm());
                Trace.beginSection("Config.createUnexplainedConfig");
                C0AV c0av5 = new C0AV(C0AX.A0H);
                final int i7 = 6;
                c0av5.A00 = new C0AS(i7, c018608h, c02610Ca) { // from class: X.0Ce
                    public final int $t;
                    public final Object A00;
                    public final Object A01;

                    {
                        this.$t = i7;
                        this.A00 = c018608h;
                        this.A01 = c02610Ca;
                    }

                    @Override // X.C0AS
                    public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
                        switch (this.$t) {
                            case 0:
                                return new C03I((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                                return new C04S((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 2:
                                return new C03C((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 3:
                                return new C00W((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                                Application application2 = (Application) this.A01;
                                C0CK c0ck = c0az.A02;
                                return new InterfaceC02430Ba(application2, AnonymousClass053.A00(c0az, c0ck), c0ck, (C09V) this.A00) { // from class: X.03K
                                    public final Application A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        /*
                                            Method dump skipped, instructions count: 417
                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: X.C03K.start():void");
                                    }

                                    {
                                        this.A00 = application2;
                                        this.A02 = c0ck;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.NATIVE;
                                    }
                                };
                            case 5:
                                return new C009804h((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            default:
                                C0CK c0ck2 = c0az.A02;
                                return new InterfaceC02430Ba((C018608h) this.A00, AnonymousClass053.A00(c0az, c0ck2), c0ck2, this, (C09V) this.A01) { // from class: X.04g
                                    public final C018608h A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;
                                    public final /* synthetic */ C02650Ce A04;

                                    {
                                        this.A04 = this;
                                        this.A02 = c0ck2;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                        this.A00 = c018608h;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        String str;
                                        C0C5.A00();
                                        C04w.A0E.add("UnexplainedAppDeathDetector");
                                        C010004j c010004j = (C010004j) this.A03.get();
                                        if (c010004j.A07) {
                                            C0CK c0ck3 = this.A02;
                                            File fileA01 = c0ck3.A01(c0ck3.A06);
                                            long jLastModified = new File(fileA01, "state.txt").lastModified();
                                            SystemClock.uptimeMillis();
                                            String strA02 = C07O.A02("fb.report_source");
                                            if ("jest_e2e".equals(strA02)) {
                                                str = "Ignore ufads on jest test runs.";
                                            } else {
                                                if (!"sapienz".equals(strA02) || c010004j.A02 != 'f') {
                                                    if (c010004j.A06) {
                                                        boolean zA02 = c010004j.A02();
                                                        if (AbstractC010304m.A01(AnonymousClass065.A01, c010004j.A01) && !new File(fileA01, "critical_suppl_java_detect_prop.txt").exists() && !new File(fileA01, "critical_java_prop.txt").exists() && !new File(fileA01, "critical_java_detect_prop.txt").exists()) {
                                                            C018108b.A08("lacrima", "Java state with no java report, reporting as fad");
                                                        } else if (!zA02) {
                                                            return;
                                                        }
                                                        C05C c05c = new C05C(null);
                                                        c05c.A02(AnonymousClass094.A1E, 1);
                                                        c05c.A03(AnonymousClass094.A3P, Long.valueOf(jLastModified / 1000));
                                                        c05c.A03(AnonymousClass094.A1g, Long.valueOf(System.currentTimeMillis() / 1000));
                                                        c05c.A04(AnonymousClass094.A5J, "unexplained");
                                                        C04w c04w = this.A01;
                                                        c04w.A06(c05c, AnonymousClass057.CRITICAL_REPORT, this);
                                                        c04w.A06(c05c, AnonymousClass057.LARGE_REPORT, this);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                str = "Ignore f states on sapienz runs.";
                                            }
                                            C018108b.A08("lacrima", str);
                                        }
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.UNEXPLAINED;
                                    }
                                };
                        }
                    }
                };
                c0av5.A02 = num;
                C02630Cc c02630Cc9 = new C02630Cc(18);
                C0AR c0ar3 = c0av5.A04;
                List list5 = c0ar3.A04;
                list5.add(c02630Cc9);
                A06(list5, 17);
                A06(list5, 15);
                A06(list5, 16);
                final int i8 = 5;
                c0av5.A01 = new C0AS(i8, application, c0c6) { // from class: X.0Ce
                    public final int $t;
                    public final Object A00;
                    public final Object A01;

                    {
                        this.$t = i8;
                        this.A00 = application;
                        this.A01 = c0c6;
                    }

                    @Override // X.C0AS
                    public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
                        switch (this.$t) {
                            case 0:
                                return new C03I((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                                return new C04S((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 2:
                                return new C03C((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 3:
                                return new C00W((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                                Application application2 = (Application) this.A01;
                                C0CK c0ck = c0az.A02;
                                return new InterfaceC02430Ba(application2, AnonymousClass053.A00(c0az, c0ck), c0ck, (C09V) this.A00) { // from class: X.03K
                                    public final Application A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        /*
                                            Method dump skipped, instructions count: 417
                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: X.C03K.start():void");
                                    }

                                    {
                                        this.A00 = application2;
                                        this.A02 = c0ck;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.NATIVE;
                                    }
                                };
                            case 5:
                                return new C009804h((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            default:
                                C0CK c0ck2 = c0az.A02;
                                return new InterfaceC02430Ba((C018608h) this.A00, AnonymousClass053.A00(c0az, c0ck2), c0ck2, this, (C09V) this.A01) { // from class: X.04g
                                    public final C018608h A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;
                                    public final /* synthetic */ C02650Ce A04;

                                    {
                                        this.A04 = this;
                                        this.A02 = c0ck2;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                        this.A00 = c018608h;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        String str;
                                        C0C5.A00();
                                        C04w.A0E.add("UnexplainedAppDeathDetector");
                                        C010004j c010004j = (C010004j) this.A03.get();
                                        if (c010004j.A07) {
                                            C0CK c0ck3 = this.A02;
                                            File fileA01 = c0ck3.A01(c0ck3.A06);
                                            long jLastModified = new File(fileA01, "state.txt").lastModified();
                                            SystemClock.uptimeMillis();
                                            String strA02 = C07O.A02("fb.report_source");
                                            if ("jest_e2e".equals(strA02)) {
                                                str = "Ignore ufads on jest test runs.";
                                            } else {
                                                if (!"sapienz".equals(strA02) || c010004j.A02 != 'f') {
                                                    if (c010004j.A06) {
                                                        boolean zA02 = c010004j.A02();
                                                        if (AbstractC010304m.A01(AnonymousClass065.A01, c010004j.A01) && !new File(fileA01, "critical_suppl_java_detect_prop.txt").exists() && !new File(fileA01, "critical_java_prop.txt").exists() && !new File(fileA01, "critical_java_detect_prop.txt").exists()) {
                                                            C018108b.A08("lacrima", "Java state with no java report, reporting as fad");
                                                        } else if (!zA02) {
                                                            return;
                                                        }
                                                        C05C c05c = new C05C(null);
                                                        c05c.A02(AnonymousClass094.A1E, 1);
                                                        c05c.A03(AnonymousClass094.A3P, Long.valueOf(jLastModified / 1000));
                                                        c05c.A03(AnonymousClass094.A1g, Long.valueOf(System.currentTimeMillis() / 1000));
                                                        c05c.A04(AnonymousClass094.A5J, "unexplained");
                                                        C04w c04w = this.A01;
                                                        c04w.A06(c05c, AnonymousClass057.CRITICAL_REPORT, this);
                                                        c04w.A06(c05c, AnonymousClass057.LARGE_REPORT, this);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                str = "Ignore f states on sapienz runs.";
                                            }
                                            C018108b.A08("lacrima", str);
                                        }
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.UNEXPLAINED;
                                    }
                                };
                        }
                    }
                };
                Trace.endSection();
                list5.add(c02630Cc);
                list5.add(c02630Cc2);
                list5.add(c02640Cd);
                if (zA04) {
                    c0ar3.A09.add(c02640Cd);
                }
                c0ar3.A09.add(c02630Cc6);
                list5.add(c02630Cc5);
                A03(c0av5, c02250Ab);
                Trace.beginSection("Config.createNativeConfig");
                C0AV c0av6 = new C0AV(C0AX.A0F);
                c0av6.A00 = new C0AS(i6, c02610Ca, application) { // from class: X.0Ce
                    public final int $t;
                    public final Object A00;
                    public final Object A01;

                    {
                        this.$t = i6;
                        this.A00 = c02610Ca;
                        this.A01 = application;
                    }

                    @Override // X.C0AS
                    public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
                        switch (this.$t) {
                            case 0:
                                return new C03I((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                                return new C04S((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 2:
                                return new C03C((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 3:
                                return new C00W((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                                Application application2 = (Application) this.A01;
                                C0CK c0ck = c0az.A02;
                                return new InterfaceC02430Ba(application2, AnonymousClass053.A00(c0az, c0ck), c0ck, (C09V) this.A00) { // from class: X.03K
                                    public final Application A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        /*
                                            Method dump skipped, instructions count: 417
                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: X.C03K.start():void");
                                    }

                                    {
                                        this.A00 = application2;
                                        this.A02 = c0ck;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.NATIVE;
                                    }
                                };
                            case 5:
                                return new C009804h((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            default:
                                C0CK c0ck2 = c0az.A02;
                                return new InterfaceC02430Ba((C018608h) this.A00, AnonymousClass053.A00(c0az, c0ck2), c0ck2, this, (C09V) this.A01) { // from class: X.04g
                                    public final C018608h A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;
                                    public final /* synthetic */ C02650Ce A04;

                                    {
                                        this.A04 = this;
                                        this.A02 = c0ck2;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                        this.A00 = c018608h;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        String str;
                                        C0C5.A00();
                                        C04w.A0E.add("UnexplainedAppDeathDetector");
                                        C010004j c010004j = (C010004j) this.A03.get();
                                        if (c010004j.A07) {
                                            C0CK c0ck3 = this.A02;
                                            File fileA01 = c0ck3.A01(c0ck3.A06);
                                            long jLastModified = new File(fileA01, "state.txt").lastModified();
                                            SystemClock.uptimeMillis();
                                            String strA02 = C07O.A02("fb.report_source");
                                            if ("jest_e2e".equals(strA02)) {
                                                str = "Ignore ufads on jest test runs.";
                                            } else {
                                                if (!"sapienz".equals(strA02) || c010004j.A02 != 'f') {
                                                    if (c010004j.A06) {
                                                        boolean zA02 = c010004j.A02();
                                                        if (AbstractC010304m.A01(AnonymousClass065.A01, c010004j.A01) && !new File(fileA01, "critical_suppl_java_detect_prop.txt").exists() && !new File(fileA01, "critical_java_prop.txt").exists() && !new File(fileA01, "critical_java_detect_prop.txt").exists()) {
                                                            C018108b.A08("lacrima", "Java state with no java report, reporting as fad");
                                                        } else if (!zA02) {
                                                            return;
                                                        }
                                                        C05C c05c = new C05C(null);
                                                        c05c.A02(AnonymousClass094.A1E, 1);
                                                        c05c.A03(AnonymousClass094.A3P, Long.valueOf(jLastModified / 1000));
                                                        c05c.A03(AnonymousClass094.A1g, Long.valueOf(System.currentTimeMillis() / 1000));
                                                        c05c.A04(AnonymousClass094.A5J, "unexplained");
                                                        C04w c04w = this.A01;
                                                        c04w.A06(c05c, AnonymousClass057.CRITICAL_REPORT, this);
                                                        c04w.A06(c05c, AnonymousClass057.LARGE_REPORT, this);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                str = "Ignore f states on sapienz runs.";
                                            }
                                            C018108b.A08("lacrima", str);
                                        }
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.UNEXPLAINED;
                                    }
                                };
                        }
                    }
                };
                Integer num3 = AnonymousClass065.A0C;
                c0av6.A02 = num3;
                C02630Cc c02630Cc10 = new C02630Cc(14);
                C0AR c0ar4 = c0av6.A04;
                List list6 = c0ar4.A04;
                list6.add(c02630Cc10);
                A06(list6, 13);
                c0av6.A01 = new C0AS(i2, application, c0c6) { // from class: X.0Ce
                    public final int $t;
                    public final Object A00;
                    public final Object A01;

                    {
                        this.$t = i2;
                        this.A00 = application;
                        this.A01 = c0c6;
                    }

                    @Override // X.C0AS
                    public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
                        switch (this.$t) {
                            case 0:
                                return new C03I((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                                return new C04S((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 2:
                                return new C03C((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 3:
                                return new C00W((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                                Application application2 = (Application) this.A01;
                                C0CK c0ck = c0az.A02;
                                return new InterfaceC02430Ba(application2, AnonymousClass053.A00(c0az, c0ck), c0ck, (C09V) this.A00) { // from class: X.03K
                                    public final Application A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        /*
                                            Method dump skipped, instructions count: 417
                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: X.C03K.start():void");
                                    }

                                    {
                                        this.A00 = application2;
                                        this.A02 = c0ck;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.NATIVE;
                                    }
                                };
                            case 5:
                                return new C009804h((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            default:
                                C0CK c0ck2 = c0az.A02;
                                return new InterfaceC02430Ba((C018608h) this.A00, AnonymousClass053.A00(c0az, c0ck2), c0ck2, this, (C09V) this.A01) { // from class: X.04g
                                    public final C018608h A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;
                                    public final /* synthetic */ C02650Ce A04;

                                    {
                                        this.A04 = this;
                                        this.A02 = c0ck2;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                        this.A00 = c018608h;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        String str;
                                        C0C5.A00();
                                        C04w.A0E.add("UnexplainedAppDeathDetector");
                                        C010004j c010004j = (C010004j) this.A03.get();
                                        if (c010004j.A07) {
                                            C0CK c0ck3 = this.A02;
                                            File fileA01 = c0ck3.A01(c0ck3.A06);
                                            long jLastModified = new File(fileA01, "state.txt").lastModified();
                                            SystemClock.uptimeMillis();
                                            String strA02 = C07O.A02("fb.report_source");
                                            if ("jest_e2e".equals(strA02)) {
                                                str = "Ignore ufads on jest test runs.";
                                            } else {
                                                if (!"sapienz".equals(strA02) || c010004j.A02 != 'f') {
                                                    if (c010004j.A06) {
                                                        boolean zA02 = c010004j.A02();
                                                        if (AbstractC010304m.A01(AnonymousClass065.A01, c010004j.A01) && !new File(fileA01, "critical_suppl_java_detect_prop.txt").exists() && !new File(fileA01, "critical_java_prop.txt").exists() && !new File(fileA01, "critical_java_detect_prop.txt").exists()) {
                                                            C018108b.A08("lacrima", "Java state with no java report, reporting as fad");
                                                        } else if (!zA02) {
                                                            return;
                                                        }
                                                        C05C c05c = new C05C(null);
                                                        c05c.A02(AnonymousClass094.A1E, 1);
                                                        c05c.A03(AnonymousClass094.A3P, Long.valueOf(jLastModified / 1000));
                                                        c05c.A03(AnonymousClass094.A1g, Long.valueOf(System.currentTimeMillis() / 1000));
                                                        c05c.A04(AnonymousClass094.A5J, "unexplained");
                                                        C04w c04w = this.A01;
                                                        c04w.A06(c05c, AnonymousClass057.CRITICAL_REPORT, this);
                                                        c04w.A06(c05c, AnonymousClass057.LARGE_REPORT, this);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                str = "Ignore f states on sapienz runs.";
                                            }
                                            C018108b.A08("lacrima", str);
                                        }
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.UNEXPLAINED;
                                    }
                                };
                        }
                    }
                };
                Trace.endSection();
                list6.add(c02630Cc);
                list6.add(c02630Cc2);
                list6.add(c02640Cd);
                if (zA04) {
                    c0ar4.A09.add(c02640Cd);
                }
                c0ar4.A09.add(c02630Cc6);
                list6.add(c02630Cc5);
                A03(c0av6, c02250Ab);
                Trace.beginSection("Config.createSoftErrorConfig");
                C0AV c0av7 = new C0AV(C0AX.A0B);
                c0av7.A00 = new C02630Cc(7);
                c0av7.A02 = num3;
                C02630Cc c02630Cc11 = new C02630Cc(6);
                List list7 = c0av7.A04.A07;
                list7.add(c02630Cc11);
                c0av7.A01 = new C0AS(i3, application, c0c6) { // from class: X.0Ce
                    public final int $t;
                    public final Object A00;
                    public final Object A01;

                    {
                        this.$t = i3;
                        this.A00 = application;
                        this.A01 = c0c6;
                    }

                    @Override // X.C0AS
                    public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
                        switch (this.$t) {
                            case 0:
                                return new C03I((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                                return new C04S((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 2:
                                return new C03C((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 3:
                                return new C00W((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                                Application application2 = (Application) this.A01;
                                C0CK c0ck = c0az.A02;
                                return new InterfaceC02430Ba(application2, AnonymousClass053.A00(c0az, c0ck), c0ck, (C09V) this.A00) { // from class: X.03K
                                    public final Application A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        /*
                                            Method dump skipped, instructions count: 417
                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: X.C03K.start():void");
                                    }

                                    {
                                        this.A00 = application2;
                                        this.A02 = c0ck;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.NATIVE;
                                    }
                                };
                            case 5:
                                return new C009804h((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            default:
                                C0CK c0ck2 = c0az.A02;
                                return new InterfaceC02430Ba((C018608h) this.A00, AnonymousClass053.A00(c0az, c0ck2), c0ck2, this, (C09V) this.A01) { // from class: X.04g
                                    public final C018608h A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;
                                    public final /* synthetic */ C02650Ce A04;

                                    {
                                        this.A04 = this;
                                        this.A02 = c0ck2;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                        this.A00 = c018608h;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        String str;
                                        C0C5.A00();
                                        C04w.A0E.add("UnexplainedAppDeathDetector");
                                        C010004j c010004j = (C010004j) this.A03.get();
                                        if (c010004j.A07) {
                                            C0CK c0ck3 = this.A02;
                                            File fileA01 = c0ck3.A01(c0ck3.A06);
                                            long jLastModified = new File(fileA01, "state.txt").lastModified();
                                            SystemClock.uptimeMillis();
                                            String strA02 = C07O.A02("fb.report_source");
                                            if ("jest_e2e".equals(strA02)) {
                                                str = "Ignore ufads on jest test runs.";
                                            } else {
                                                if (!"sapienz".equals(strA02) || c010004j.A02 != 'f') {
                                                    if (c010004j.A06) {
                                                        boolean zA02 = c010004j.A02();
                                                        if (AbstractC010304m.A01(AnonymousClass065.A01, c010004j.A01) && !new File(fileA01, "critical_suppl_java_detect_prop.txt").exists() && !new File(fileA01, "critical_java_prop.txt").exists() && !new File(fileA01, "critical_java_detect_prop.txt").exists()) {
                                                            C018108b.A08("lacrima", "Java state with no java report, reporting as fad");
                                                        } else if (!zA02) {
                                                            return;
                                                        }
                                                        C05C c05c = new C05C(null);
                                                        c05c.A02(AnonymousClass094.A1E, 1);
                                                        c05c.A03(AnonymousClass094.A3P, Long.valueOf(jLastModified / 1000));
                                                        c05c.A03(AnonymousClass094.A1g, Long.valueOf(System.currentTimeMillis() / 1000));
                                                        c05c.A04(AnonymousClass094.A5J, "unexplained");
                                                        C04w c04w = this.A01;
                                                        c04w.A06(c05c, AnonymousClass057.CRITICAL_REPORT, this);
                                                        c04w.A06(c05c, AnonymousClass057.LARGE_REPORT, this);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                str = "Ignore f states on sapienz runs.";
                                            }
                                            C018108b.A08("lacrima", str);
                                        }
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.UNEXPLAINED;
                                    }
                                };
                        }
                    }
                };
                Trace.endSection();
                list7.add(c02630Cc3);
                c0av7.A02 = num;
                A03(c0av7, c02250Ab);
                c02250Ab.A09 = false;
                Trace.beginSection("Config.createReportSourceConfig");
                C0AV c0av8 = new C0AV(C0AX.A0A);
                c0av8.A00 = new C02630Cc(5);
                c0av8.A02 = num;
                Trace.endSection();
                A03(c0av8, c02250Ab);
                Trace.beginSection("Config.createAnrAppDeathConfig");
                C0AV c0av9 = new C0AV(C0AX.A03);
                c0av9.A00 = new C02640Cd(c02610Ca, 1);
                c0av9.A02 = num2;
                C02630Cc c02630Cc12 = new C02630Cc(2);
                C0AR c0ar5 = c0av9.A04;
                List list8 = c0ar5.A04;
                list8.add(c02630Cc12);
                A06(list8, 0);
                A06(list8, 1);
                c0av9.A01 = new C0AS(i, application, c0c6) { // from class: X.0Ce
                    public final int $t;
                    public final Object A00;
                    public final Object A01;

                    {
                        this.$t = i;
                        this.A00 = application;
                        this.A01 = c0c6;
                    }

                    @Override // X.C0AS
                    public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
                        switch (this.$t) {
                            case 0:
                                return new C03I((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                                return new C04S((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 2:
                                return new C03C((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case 3:
                                return new C00W((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                                Application application2 = (Application) this.A01;
                                C0CK c0ck = c0az.A02;
                                return new InterfaceC02430Ba(application2, AnonymousClass053.A00(c0az, c0ck), c0ck, (C09V) this.A00) { // from class: X.03K
                                    public final Application A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        /*
                                            Method dump skipped, instructions count: 417
                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: X.C03K.start():void");
                                    }

                                    {
                                        this.A00 = application2;
                                        this.A02 = c0ck;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.NATIVE;
                                    }
                                };
                            case 5:
                                return new C009804h((Application) this.A00, (C0C6) this.A01, AnonymousClass000.A00(c0az));
                            default:
                                C0CK c0ck2 = c0az.A02;
                                return new InterfaceC02430Ba((C018608h) this.A00, AnonymousClass053.A00(c0az, c0ck2), c0ck2, this, (C09V) this.A01) { // from class: X.04g
                                    public final C018608h A00;
                                    public final C04w A01;
                                    public final C0CK A02;
                                    public final C09V A03;
                                    public final /* synthetic */ C02650Ce A04;

                                    {
                                        this.A04 = this;
                                        this.A02 = c0ck2;
                                        this.A01 = c04w;
                                        this.A03 = c09v;
                                        this.A00 = c018608h;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final void start() {
                                        String str;
                                        C0C5.A00();
                                        C04w.A0E.add("UnexplainedAppDeathDetector");
                                        C010004j c010004j = (C010004j) this.A03.get();
                                        if (c010004j.A07) {
                                            C0CK c0ck3 = this.A02;
                                            File fileA01 = c0ck3.A01(c0ck3.A06);
                                            long jLastModified = new File(fileA01, "state.txt").lastModified();
                                            SystemClock.uptimeMillis();
                                            String strA02 = C07O.A02("fb.report_source");
                                            if ("jest_e2e".equals(strA02)) {
                                                str = "Ignore ufads on jest test runs.";
                                            } else {
                                                if (!"sapienz".equals(strA02) || c010004j.A02 != 'f') {
                                                    if (c010004j.A06) {
                                                        boolean zA02 = c010004j.A02();
                                                        if (AbstractC010304m.A01(AnonymousClass065.A01, c010004j.A01) && !new File(fileA01, "critical_suppl_java_detect_prop.txt").exists() && !new File(fileA01, "critical_java_prop.txt").exists() && !new File(fileA01, "critical_java_detect_prop.txt").exists()) {
                                                            C018108b.A08("lacrima", "Java state with no java report, reporting as fad");
                                                        } else if (!zA02) {
                                                            return;
                                                        }
                                                        C05C c05c = new C05C(null);
                                                        c05c.A02(AnonymousClass094.A1E, 1);
                                                        c05c.A03(AnonymousClass094.A3P, Long.valueOf(jLastModified / 1000));
                                                        c05c.A03(AnonymousClass094.A1g, Long.valueOf(System.currentTimeMillis() / 1000));
                                                        c05c.A04(AnonymousClass094.A5J, "unexplained");
                                                        C04w c04w = this.A01;
                                                        c04w.A06(c05c, AnonymousClass057.CRITICAL_REPORT, this);
                                                        c04w.A06(c05c, AnonymousClass057.LARGE_REPORT, this);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                str = "Ignore f states on sapienz runs.";
                                            }
                                            C018108b.A08("lacrima", str);
                                        }
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final /* synthetic */ AnonymousClass046 AFf() {
                                        return null;
                                    }

                                    @Override // X.InterfaceC02430Ba
                                    public final EnumC011204x AGX() {
                                        return EnumC011204x.UNEXPLAINED;
                                    }
                                };
                        }
                    }
                };
                Trace.endSection();
                list8.add(c02640Cd);
                if (zA04) {
                    c0ar5.A09.add(c02640Cd);
                }
                A03(c0av9, c02250Ab);
                c02250Ab.A00(new C02720Cl(1));
                c02250Ab.A00(new C02720Cl(2));
                A02 = c02250Ab;
                C015606v.A01();
                if (!C015606v.A04(application.getApplicationContext(), 65)) {
                    C02250Ab c02250Ab2 = A02;
                    C0AV c0av10 = new C0AV(C0AX.A09);
                    c0av10.A00 = new C0AS() { // from class: X.0BM
                        @Override // X.C0AS
                        public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
                            C0CK c0ck = c0az.A02;
                            return new C00a(new AnonymousClass042(c0az, true), AnonymousClass053.A00(c0az, c0ck), new C00Y(application) { // from class: X.00Z
                                public final int A00 = Math.max(500, 2000);
                                public final Application A01;

                                {
                                    this.A01 = application;
                                }

                                @Override // X.C00Y
                                public final InterfaceC000700k A6f(C00c c00c, C000400h c000400h, String str) {
                                    C001000n c001000n;
                                    Application application2 = this.A01;
                                    C000600j c000600j = new C000600j(application2, new Handler(Looper.getMainLooper()), c00c, c000400h, str, application2.getDir("traces", 0).getPath(), 5, false);
                                    int i9 = this.A00;
                                    synchronized (C001000n.class) {
                                        c001000n = C001000n.A0E;
                                        if (c001000n == null) {
                                            c001000n = new C001000n(c000600j, i9);
                                            C001000n.A0E = c001000n;
                                        }
                                    }
                                    c001000n.A02 = new InterfaceC001400r() { // from class: X.00s
                                    };
                                    return c001000n;
                                }

                                @Override // X.C00Y
                                public final boolean AfK() {
                                    return true;
                                }
                            }, c0ck, (String) c0az.A0N.get(), c0az.A0U, c0az.A0L, c0az.A0K);
                        }
                    };
                    c0av10.A02 = num;
                    C0AS c0as = new C0AS() { // from class: X.0BL
                        @Override // X.C0AS
                        public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
                            C0CK c0ck = c0az.A02;
                            AnonymousClass053.A03(c0ck, "Did you call earlyInit()?");
                            File file = c0ck.A04;
                            AnonymousClass053.A03(file, "Did you call SessionManager.init()?");
                            C0CK c0ck2 = c0az.A02;
                            AnonymousClass053.A03(c0ck2, "Did you call earlyInit()?");
                            return new C04T(c0ck2, file);
                        }
                    };
                    C0AR c0ar6 = c0av10.A04;
                    List list9 = c0ar6.A02;
                    list9.add(c0as);
                    c0av10.A01 = new C0AS() { // from class: X.0BK
                        @Override // X.C0AS
                        public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
                            return new C000000d(application, c0c6, AnonymousClass000.A00(c0az));
                        }
                    };
                    c0av10.A02 = num3;
                    list9.add(c02630Cc);
                    list9.add(c02630Cc2);
                    c0ar6.A07.add(c02630Cc3);
                    A03(c0av10, c02250Ab2);
                }
                A03 = true;
            }
        } catch (Throwable th2) {
            throw th2;
        } finally {
            Trace.endSection();
        }
    }

    public static synchronized C0AZ A00() {
        C0AZ c0az;
        C02250Ab c02250Ab = A02;
        if (c02250Ab == null) {
            throw AnonymousClass000.A04("Lacrima isn't initialized");
        }
        c0az = A01;
        if (c0az == null) {
            if (c02250Ab.A06 == null) {
                c02250Ab.A06 = new C02620Cb(AbstractC018908k.A00(), 0);
            }
            if (c02250Ab.A03 == null) {
                C018108b.A08("lacrima", "LacrimaConfigBuilder.setDeviceId not called, using 0");
                c02250Ab.A03 = new C02620Cb("0", 0);
            }
            if (c02250Ab.A08 == null) {
                C018108b.A08("lacrima", "LacrimaConfigBuilder.setUserId not called, using 0");
                c02250Ab.A08 = new C02620Cb("0", 0);
            }
            if (c02250Ab.A02 == null) {
                C018108b.A08("lacrima", "LacrimaConfigBuilder.setUserIdActorId not called, using 0");
                c02250Ab.A02 = new C02620Cb("0", 0);
            }
            if (c02250Ab.A01 == null) {
                C018108b.A08("lacrima", "LacrimaConfigBuilder.setUserIdActingAccountId not called, using 0");
                c02250Ab.A01 = new C02620Cb("0", 0);
            }
            if (c02250Ab.A05 == null) {
                C018108b.A08("lacrima", "LacrimaConfigBuilder.setIsEmployee not called, using false");
                c02250Ab.A05 = new C02620Cb(false, 0);
            }
            if (c02250Ab.A07 == null) {
                c02250Ab.A07 = new C02620Cb(new C02740Cn(c02250Ab, 0), 1);
            }
            if (c02250Ab.A04 == null) {
                c02250Ab.A04 = new C02620Cb(new C02740Cn(c02250Ab, 1), 1);
            }
            Application application = c02250Ab.A0B;
            application.getApplicationInfo();
            C09V c09v = c02250Ab.A06;
            C09V c09v2 = c02250Ab.A03;
            C09V c09v3 = c02250Ab.A08;
            C09V c09v4 = c02250Ab.A02;
            C09V c09v5 = c02250Ab.A01;
            C09V c09v6 = c02250Ab.A05;
            c0az = new C0AZ(application, c02250Ab.A0C, c02250Ab.A0D, c02250Ab.A0E, c02250Ab.A0F, c09v, c09v2, c09v3, c09v4, c09v5, c09v6, c02250Ab.A07, c02250Ab.A04, c02250Ab.A00, c02250Ab.A09, c02250Ab.A0A);
            A01 = c0az;
        }
        return c0az;
    }

    /* JADX WARN: Type inference failed for: r0v39, types: [X.040] */
    public static synchronized void A01() {
        C009003z c009003z;
        if (!A04) {
            final C0AZ c0azA00 = A00();
            try {
                AnonymousClass089 anonymousClass089A01 = AnonymousClass089.A01();
                C0C5.A00();
                if (anonymousClass089A01 == null) {
                    C018108b.A08("lacrima", "ExceptionHandlerManager not initialized, initializing.");
                    AnonymousClass089.A00();
                }
                Method method = AnonymousClass066.A03;
                Trace.beginSection("earlyJavaInit");
                C0C5.A00();
                String str = (String) c0azA00.A0R.get();
                Application application = c0azA00.A0F;
                File dir = application.getDir("errorreporting", 0);
                String str2 = (String) c0azA00.A0S.get();
                C09V c02620Cb = c0azA00.A06;
                if (c02620Cb == null) {
                    c02620Cb = new C02620Cb(c0azA00, 9);
                    c0azA00.A06 = c02620Cb;
                }
                C0AY c0ay = (C0AY) c02620Cb.get();
                C09V c02620Cb2 = c0azA00.A04;
                if (c02620Cb2 == null) {
                    c02620Cb2 = new C02620Cb(c0azA00, 11);
                    c0azA00.A04 = c02620Cb2;
                }
                C0CK c0ck = new C0CK((C021509q) c02620Cb2.get(), c0ay, dir, str, str2);
                c0azA00.A02 = c0ck;
                C09V c02620Cb3 = c0azA00.A08;
                if (c02620Cb3 == null) {
                    c02620Cb3 = new C02620Cb(c0azA00, 8);
                    c0azA00.A08 = c02620Cb3;
                }
                c0azA00.A00 = new C04w(new C008803x(), (C011104v) c02620Cb3.get(), c0ck, c0azA00.A0E, c0azA00.A0V, c0azA00.A0X);
                C0C5.A00();
                Trace.beginSection("KeepReportsForTesting.jest");
                try {
                    String strA02 = C07O.A02("fb.report_source");
                    if ((!strA02.equals("") || (strA02 = System.getProperty("fb.report_source")) != null) && (strA02.equals("jest_e2e") || strA02.equals("sapienz"))) {
                        C0CC.A0H = true;
                    }
                    Trace.endSection();
                    Trace.beginSection("FixedLengthFiles.init");
                    Trace.beginSection("FixedLengthFiles.init");
                    try {
                        C011404z.A00("collector").A03(application, 8, 15000);
                        C011404z.A00("reports").A03(application, 6, 60000);
                        Trace.endSection();
                        if (AnonymousClass050.A00() < 10240) {
                            C011404z.A00("reports").A01();
                            if (AnonymousClass050.A00() < 10240) {
                                C011404z.A00("collector").A01();
                            }
                        }
                        C011404z.A00("collector").A02();
                        C011404z.A00("reports").A02();
                        Trace.endSection();
                        Trace.beginSection("InternalSettingsEndpoint");
                        C09V c09v = c0azA00.A0T;
                        c09v.get();
                        AbstractC008903y.A01 = c09v;
                        try {
                            String string = ((AnonymousClass051) c09v.get()).A00.getString("endpoint_override", null);
                            if (string != null) {
                                AbstractC008903y.A00 = string;
                                C09V c09v2 = AbstractC008903y.A01;
                                if (c09v2 != null) {
                                    ((AnonymousClass051) c09v2.get()).A00.edit().putString("endpoint_override", string).apply();
                                }
                            }
                        } catch (Exception unused) {
                            C018108b.A07("lacrima", "Failed to read from SharedPreferences");
                            C0C5.A00();
                        }
                        Trace.endSection();
                        AnonymousClass052.A00(c0azA00.A02);
                        synchronized (C009003z.class) {
                            try {
                                c009003z = C009003z.A01;
                                if (c009003z == null) {
                                    c009003z = new C009003z();
                                    C009003z.A01 = c009003z;
                                }
                            } finally {
                            }
                        }
                        ?? r0 = new Object() { // from class: X.040
                        };
                        synchronized (c009003z) {
                            try {
                                c009003z.A00 = r0;
                            } finally {
                            }
                        }
                        C0C5.A00();
                        for (C0AT c0at : c0azA00.A0G) {
                            c0azA00.A01 = c0at.AGW();
                            c0at.AMX(c0azA00);
                        }
                        Trace.beginSection("sendPendingReports");
                        C0C5.A00();
                        try {
                            C0CK c0ck2 = c0azA00.A02;
                            AnonymousClass053.A03(c0ck2, "Did you call earlyInit()?");
                            c0ck2.A02("");
                            C0C5.A00();
                            Trace.endSection();
                            A04 = true;
                            A09.countDown();
                        } catch (Throwable th) {
                            th = th;
                            C0C5.A00();
                            throw th;
                        }
                    } finally {
                        Trace.endSection();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } finally {
            }
        }
    }

    public static void A04(String str) {
        if (A03) {
            synchronized (C09M.class) {
            }
            C0C8 c0c8A00 = C0C8.A00();
            synchronized (C0C8.A03) {
                c0c8A00.A02.remove(str);
            }
        }
    }

    public static void A05(String str, String str2) {
        if (A03) {
            synchronized (C09M.class) {
            }
            C0C8 c0c8A00 = C0C8.A00();
            synchronized (C0C8.A03) {
                c0c8A00.A02.put(str, str2);
            }
        }
    }

    public static void A06(List list, int i) {
        list.add(new C02630Cc(i));
    }

    public static void A03(C0AV c0av, C02250Ab c02250Ab) {
        c02250Ab.A00(c0av.A00());
    }
}
