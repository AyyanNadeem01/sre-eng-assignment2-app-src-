package X;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.dextricks.classtracing.logger.ClassTracingLoggerFbLite;
import com.facebook.errorreporting.lacrima.common.check.DirectReports;
import com.facebook.lite.SharedPreferencesHookA11;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Random;

/* renamed from: X.0Cc */
/* loaded from: classes.dex */
public class C02630Cc implements C0AS {
    public final int $t;

    public C02630Cc(int i) {
        this.$t = i;
    }

    @Override // X.C0AS
    public final Object A6b(final C0AZ c0az) {
        AnonymousClass054 anonymousClass054;
        C05F c05f;
        switch (this.$t) {
            case 0:
            case 15:
                C0CK c0ck = c0az.A02;
                AnonymousClass053.A03(c0ck, "Did you call earlyInit()?");
                C0CK c0ck2 = c0az.A02;
                AnonymousClass053.A03(c0ck2, "Did you call earlyInit()?");
                File fileA01 = c0ck.A01(c0ck2.A06);
                if (fileA01 != null) {
                    return new C09D(fileA01);
                }
                return null;
            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
            case 16:
                String str = (String) c0az.A0S.get();
                C0CK c0ck3 = c0az.A02;
                AnonymousClass053.A03(c0ck3, "Did you call earlyInit()?");
                final File fileA012 = c0ck3.A01(str);
                if (fileA012 != null) {
                    return new AnonymousClass095(fileA012) { // from class: X.035
                        public final File A00;

                        @Override // X.AnonymousClass095
                        public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                            Integer num;
                            File file = new File(this.A00, "detection_stages.txt");
                            if (file.exists()) {
                                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                                try {
                                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                                        String[] strArrSplit = line.split("=");
                                        if (strArrSplit.length == 2) {
                                            try {
                                                String str2 = strArrSplit[0];
                                                if (str2.equals("JAVA_CRASH_DETECTION")) {
                                                    num = AnonymousClass065.A00;
                                                } else if (str2.equals("NATIVE_CRASH_DETECTION")) {
                                                    num = AnonymousClass065.A01;
                                                } else if (str2.equals("UNEXPLAINED_DETECTION")) {
                                                    num = AnonymousClass065.A0C;
                                                } else if (str2.equals("ANR_DETECTION")) {
                                                    num = AnonymousClass065.A0N;
                                                } else {
                                                    if (!str2.equals("LIFECYCLE_DETECTION")) {
                                                        throw new IllegalArgumentException(str2);
                                                    }
                                                    num = AnonymousClass065.A0Y;
                                                }
                                                int i = Integer.parseInt(strArrSplit[1]);
                                                int iIntValue = num.intValue();
                                                if (iIntValue == 3) {
                                                    c05c.A02(AnonymousClass094.A3T, i);
                                                } else if (iIntValue == 0) {
                                                    c05c.A02(AnonymousClass094.A3U, i);
                                                } else if (iIntValue == 1) {
                                                    c05c.A02(AnonymousClass094.A3W, i);
                                                } else if (iIntValue == 4) {
                                                    c05c.A02(AnonymousClass094.A3V, i);
                                                } else if (iIntValue == 2) {
                                                    c05c.A02(AnonymousClass094.A3X, i);
                                                }
                                            } catch (IllegalArgumentException unused) {
                                                continue;
                                            }
                                        }
                                    }
                                    bufferedReader.close();
                                } catch (Throwable th) {
                                    try {
                                        bufferedReader.close();
                                        throw th;
                                    } catch (Throwable th2) {
                                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                        throw th;
                                    }
                                }
                            }
                        }

                        {
                            this.A00 = fileA012;
                        }

                        @Override // X.AnonymousClass095
                        public final Integer AGY() {
                            return AnonymousClass065.A0x;
                        }
                    };
                }
                return null;
            case 2:
            case 14:
            case 18:
            default:
                C0CK c0ck4 = c0az.A02;
                AnonymousClass053.A03(c0ck4, "Did you call earlyInit()?");
                C0CK c0ck5 = c0az.A02;
                AnonymousClass053.A03(c0ck5, "Did you call earlyInit()?");
                File fileA013 = c0ck4.A01(c0ck5.A06);
                if (fileA013 == null) {
                    return null;
                }
                C0CK c0ck6 = c0az.A02;
                AnonymousClass053.A03(c0ck6, "Did you call earlyInit()?");
                return new C04T(c0ck6, fileA013);
            case 3:
            case 13:
            case 17:
                Application application = c0az.A0F;
                C04G c04g = new C04G();
                c04g.A00 = application;
                return c04g;
            case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
            case 6:
                C0CK c0ck7 = c0az.A02;
                AnonymousClass053.A03(c0ck7, "Did you call earlyInit()?");
                File file = c0ck7.A04;
                AnonymousClass053.A03(file, "Did you call SessionManager.init()?");
                C0CK c0ck8 = c0az.A02;
                AnonymousClass053.A03(c0ck8, "Did you call earlyInit()?");
                return new C04T(c0ck8, file);
            case 5:
                final Application application2 = c0az.A0F;
                final C0CK c0ck9 = c0az.A02;
                final C04w c04wA00 = AnonymousClass053.A00(c0az, c0ck9);
                return new InterfaceC02430Ba(application2, c04wA00, c0ck9) { // from class: X.03D
                    public final Application A00;
                    public final C04w A01;
                    public final C0CK A02;

                    @Override // X.InterfaceC02430Ba
                    public final void start() {
                        C05C c05c = new C05C(null);
                        HashMap mapA01 = C03E.A01();
                        String str2 = (String) mapA01.get("fb.report_source");
                        if (!TextUtils.isEmpty(str2)) {
                            c05c.A04(AnonymousClass094.A9g, str2);
                            String strA00 = C03E.A00(mapA01);
                            if (TextUtils.isEmpty(strA00)) {
                                File file2 = new File(this.A02.A05, "report_source");
                                c05c.A05(AnonymousClass036.A0F, AnonymousClass057.CRITICAL_REPORT, new File(file2, "report_source_ref.txt"));
                            } else {
                                c05c.A04(AnonymousClass094.A9i, strA00);
                            }
                        }
                        String str3 = (String) mapA01.get("fb.testing.build_target");
                        if (!TextUtils.isEmpty(str3)) {
                            c05c.A04(AnonymousClass094.A7m, str3);
                        }
                        String str4 = (String) mapA01.get("ig.ig_server_rev_hash");
                        if (!TextUtils.isEmpty(str4)) {
                            c05c.A04(AnonymousClass094.A6U, str4);
                        }
                        String strA02 = C07O.A02("fb.fury_stacktraces_filename");
                        if (!TextUtils.isEmpty(strA02)) {
                            File filesDir = this.A00.getFilesDir();
                            c05c.A05(AnonymousClass036.A0A, AnonymousClass057.CRITICAL_REPORT, new File(filesDir, strA02));
                        }
                        C04w c04w = this.A01;
                        c04w.A06(c05c, AnonymousClass057.CRITICAL_REPORT, this);
                        c04w.A06(c05c, AnonymousClass057.LARGE_REPORT, this);
                    }

                    {
                        this.A00 = application2;
                        this.A02 = c0ck9;
                        this.A01 = c04wA00;
                    }

                    @Override // X.InterfaceC02430Ba
                    public final /* synthetic */ AnonymousClass046 AFf() {
                        return null;
                    }

                    @Override // X.InterfaceC02430Ba
                    public final EnumC011204x AGX() {
                        return EnumC011204x.REPORT_SOURCE;
                    }
                };
            case 7:
                C0CK c0ck10 = c0az.A02;
                return new C03B(AnonymousClass053.A00(c0az, c0ck10), new C03A(new Random()), c0ck10);
            case 8:
                final Application application3 = c0az.A0F;
                return new AnonymousClass095(application3, c0az, this) { // from class: X.05A
                    public final Context A00;
                    public final /* synthetic */ C0AZ A01;
                    public final /* synthetic */ C02630Cc A02;

                    {
                        this.A02 = this;
                        this.A01 = c0az;
                        this.A00 = application3;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:18:0x00b5  */
                    /* JADX WARN: Removed duplicated region for block: B:35:0x00f7  */
                    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
                    @Override // X.AnonymousClass095
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void Afg(X.C05C r5, X.AnonymousClass057 r6) throws org.json.JSONException {
                        /*
                            Method dump skipped, instructions count: 251
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: X.C05A.Afg(X.05C, X.057):void");
                    }

                    @Override // X.AnonymousClass095
                    public final Integer AGY() {
                        return AnonymousClass065.A07;
                    }
                };
            case 9:
                synchronized (AnonymousClass041.class) {
                    anonymousClass054 = AnonymousClass041.A00;
                }
                if (anonymousClass054 == null) {
                    AnonymousClass054 anonymousClass0542 = new AnonymousClass054() { // from class: X.055
                        @Override // X.AnonymousClass054
                        public final void ALb(Throwable th) throws IOException {
                            C0AZ c0az2 = c0az;
                            DirectReports.A00((String) c0az2.A0U.get(), (String) c0az2.A0L.get(), (String) c0az2.A0K.get(), (String) c0az2.A0S.get(), th, new HashMap());
                        }
                    };
                    synchronized (AnonymousClass041.class) {
                        AnonymousClass041.A00 = anonymousClass0542;
                    }
                }
                final C0CK c0ck11 = c0az.A02;
                final C04w c04wA002 = AnonymousClass053.A00(c0az, c0ck11);
                return new InterfaceC02430Ba(c04wA002, c0ck11) { // from class: X.056
                    public final C04w A00;
                    public final C0CK A01;

                    @Override // X.InterfaceC02430Ba
                    public final void start() {
                        C05C c05c = new C05C(null);
                        c05c.A04(AnonymousClass094.A4p, this.A01.A07);
                        C04w c04w = this.A00;
                        c04w.A06(c05c, AnonymousClass057.CRITICAL_REPORT, this);
                        c04w.A06(c05c, AnonymousClass057.LARGE_REPORT, this);
                    }

                    {
                        this.A01 = c0ck11;
                        this.A00 = c04wA002;
                    }

                    @Override // X.InterfaceC02430Ba
                    public final /* synthetic */ AnonymousClass046 AFf() {
                        return null;
                    }

                    @Override // X.InterfaceC02430Ba
                    public final EnumC011204x AGX() {
                        return EnumC011204x.STARTUP;
                    }
                };
            case 10:
                Application application4 = c0az.A0F;
                C0CK c0ck12 = c0az.A02;
                C04w c04wA003 = AnonymousClass053.A00(c0az, c0ck12);
                synchronized (C05F.class) {
                    c05f = C05F.A08;
                    if (c05f == null) {
                        c05f = new C05F();
                        C05F.A08 = c05f;
                    }
                }
                C09V c02620Cb = c0az.A03;
                if (c02620Cb == null) {
                    c02620Cb = new C02620Cb(c0az, 4);
                    c0az.A03 = c02620Cb;
                }
                C05G c05g = (C05G) c02620Cb.get();
                C02670Cg c02670Cg = new C02670Cg(this, 0);
                C09V c02620Cb2 = c0az.A07;
                if (c02620Cb2 == null) {
                    c02620Cb2 = new C02620Cb(c0az, 7);
                    c0az.A07 = c02620Cb2;
                }
                return new C05I(application4, c05f, c05g, c04wA003, c02670Cg, new AnonymousClass046(), c0ck12, (C05H) c02620Cb2.get());
            case 11:
                C0CK c0ck13 = c0az.A02;
                return new C05E(AnonymousClass053.A00(c0az, c0ck13), c0ck13);
            case 12:
                Application application5 = c0az.A0F;
                AnonymousClass043 anonymousClass043 = new AnonymousClass043();
                anonymousClass043.A00 = application5;
                return anonymousClass043;
            case 19:
                C0CK c0ck14 = c0az.A02;
                AnonymousClass053.A03(c0ck14, "Did you call earlyInit()?");
                File file2 = c0ck14.A04;
                AnonymousClass053.A03(file2, "Did you call SessionManager.init()?");
                return new C009304c(AnonymousClass000.A02(file2, "logcat.txt"));
            case 20:
                return C0C9.A00;
            case 21:
                return null;
            case 22:
                return new C009304c();
            case 23:
                C09V c05b = c0az.A0B;
                if (c05b == null) {
                    c05b = new C05B(c0az);
                    c0az.A0B = c05b;
                }
                return c05b.get();
            case 24:
                return new C04H();
            case 25:
                return C0C8.A00();
        }
    }
}
