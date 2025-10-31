package X;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import com.facebook.errorreporting.field.ReportFieldString;
import com.facebook.lite.SharedPreferencesHookA11;
import dalvik.system.VMRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

/* renamed from: X.0Cd */
/* loaded from: classes.dex */
public class C02640Cd implements C0AS {
    public final int $t;
    public final Object A00;

    public C02640Cd(Object obj, int i) {
        this.$t = i;
        this.A00 = obj;
    }

    @Override // X.C0AS
    public final /* bridge */ /* synthetic */ Object A6b(final C0AZ c0az) {
        switch (this.$t) {
            case 0:
                throw AnonymousClass000.A04("Missing ConfigFactory<Detector> implementation");
            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                final C0CK c0ck = c0az.A02;
                final C04w c04wA00 = AnonymousClass053.A00(c0az, c0ck);
                final C09V c09v = (C09V) this.A00;
                return new InterfaceC02430Ba(c04wA00, c0ck, c09v) { // from class: X.03H
                    public final C04w A00;
                    public final C0CK A01;
                    public final C09V A02;

                    public static Properties A00(File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                        Properties properties = new Properties();
                        if (file != null) {
                            try {
                                FileInputStream fileInputStream = new FileInputStream(file);
                                try {
                                    properties.load(fileInputStream);
                                    fileInputStream.close();
                                    return properties;
                                } finally {
                                }
                            } catch (IOException e) {
                                C018108b.A0C("lacrima", "Error while reading Anr report", e);
                                C0C5.A00();
                            }
                        }
                        return properties;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:44:0x0124  */
                    @Override // X.InterfaceC02430Ba
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void start() throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                        /*
                            Method dump skipped, instructions count: 300
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: X.C03H.start():void");
                    }

                    {
                        this.A01 = c0ck;
                        this.A00 = c04wA00;
                        this.A02 = c09v;
                    }

                    @Override // X.InterfaceC02430Ba
                    public final /* synthetic */ AnonymousClass046 AFf() {
                        return null;
                    }

                    @Override // X.InterfaceC02430Ba
                    public final EnumC011204x AGX() {
                        return EnumC011204x.ANR_APP_DEATH;
                    }
                };
            case 2:
                final Application application = (Application) this.A00;
                final C0CK c0ck2 = c0az.A02;
                AnonymousClass053.A03(c0ck2, "Did you call earlyInit()?");
                final AnonymousClass051 anonymousClass051 = (AnonymousClass051) c0az.A0T.get();
                return new AnonymousClass095(application, anonymousClass051, c0az, c0ck2, this) { // from class: X.059
                    public Application A00;
                    public AnonymousClass051 A01;
                    public C0CK A02;
                    public final /* synthetic */ C0AZ A03;
                    public final /* synthetic */ C02640Cd A04;

                    {
                        this.A04 = this;
                        this.A03 = c0az;
                        this.A00 = application;
                        this.A02 = c0ck2;
                        this.A01 = anonymousClass051;
                    }

                    public static File A00(Context context) {
                        String strVmInstructionSet;
                        File parentFile = new File(context.getApplicationInfo().publicSourceDir).getParentFile();
                        if (parentFile == null || (strVmInstructionSet = VMRuntime.getRuntime().vmInstructionSet()) == null) {
                            return null;
                        }
                        return new File(parentFile, "oat/".concat(strVmInstructionSet));
                    }

                    @Override // X.AnonymousClass095
                    public final Integer AGY() {
                        return AnonymousClass065.A0v;
                    }

                    @Override // X.AnonymousClass095
                    public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) throws IllegalAccessException, PackageManager.NameNotFoundException, IOException, IllegalArgumentException, InvocationTargetException {
                        long j;
                        String absolutePath;
                        String string;
                        ReportFieldString reportFieldString = AnonymousClass094.A4T;
                        C0AZ c0az2 = this.A03;
                        c05c.A04(reportFieldString, "275254692598279");
                        Application application2 = this.A00;
                        String packageName = application2.getPackageName();
                        c05c.A04(AnonymousClass094.A4X, packageName);
                        c05c.A03(AnonymousClass094.A1d, Long.valueOf(AbstractC017707t.A01()));
                        c05c.A03(AnonymousClass094.A1A, Long.valueOf(AbstractC017707t.A00()));
                        c05c.A03(AnonymousClass094.A2T, Long.valueOf(AbstractC017707t.A01()));
                        AnonymousClass091 anonymousClass091 = AnonymousClass094.A2k;
                        String str = "0";
                        String[] strArrSplit = {"0", "0"};
                        char[] cArr = new char[20];
                        C0CK c0ck3 = c0az2.A02;
                        AnonymousClass053.A03(c0ck3, "Did you call earlyInit()?");
                        final File file = new File(c0ck3.A05, "prev_build_id.txt");
                        if (file.exists()) {
                            try {
                                FileReader fileReader = new FileReader(file);
                                try {
                                    strArrSplit = new String(cArr, 0, fileReader.read(cArr)).split("\n");
                                    fileReader.close();
                                } finally {
                                }
                            } catch (Exception e) {
                                C018108b.A0C("lacrima", "Reading the previous build id failed", e);
                                C0C5.A00();
                            }
                        }
                        final String strValueOf = String.valueOf(AbstractC017707t.A01());
                        final String str2 = strArrSplit[1];
                        if (str2.equals(strValueOf)) {
                            try {
                                j = Long.parseLong(strArrSplit[0]);
                            } catch (Exception e2) {
                                C018108b.A0C("lacrima", "Returning the existing previous build id failed", e2);
                                C0C5.A00();
                            }
                        } else {
                            C022009w.A01().execute(new Runnable() { // from class: X.0BP
                                public static final String __redex_internal_original_name = "StartupConfig$11$1$$ExternalSyntheticLambda0";

                                @Override // java.lang.Runnable
                                public final void run() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                                    File file2 = file;
                                    String str3 = str2;
                                    String str4 = strValueOf;
                                    try {
                                        FileWriter fileWriter = new FileWriter(file2, false);
                                        try {
                                            fileWriter.write(AnonymousClass000.A06("\n", str4, AnonymousClass000.A0A(str3)));
                                            fileWriter.close();
                                        } finally {
                                        }
                                    } catch (IOException e3) {
                                        C018108b.A0C("lacrima", "Writing the previous build id failed", e3);
                                        C0C5.A00();
                                    }
                                }
                            });
                            try {
                                j = Long.parseLong(str2);
                            } catch (Exception e3) {
                                C018108b.A0C("lacrima", "Returning the new previous build id failed", e3);
                                C0C5.A00();
                                j = 0;
                            }
                        }
                        c05c.A03(anonymousClass091, Long.valueOf(j));
                        AnonymousClass091 anonymousClass0912 = AnonymousClass094.A1H;
                        C0CK c0ck4 = this.A02;
                        c05c.A03(anonymousClass0912, 0L);
                        c05c.A03(AnonymousClass094.A1G, Long.valueOf(System.currentTimeMillis() - SystemClock.uptimeMillis()));
                        String str3 = "not set";
                        try {
                            PackageManager packageManager = application2.getPackageManager();
                            C0CN.A00(packageManager);
                            c05c.A04(AnonymousClass094.A6X, packageManager.getInstallerPackageName(packageName));
                            if (Build.VERSION.SDK_INT >= 29) {
                                C04O.A00(packageManager, c05c);
                            }
                            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                            if (packageInfo != null) {
                                if (packageInfo.versionName != null && (packageInfo.versionCode == AbstractC017707t.A00() || AbstractC017707t.A00() == 1)) {
                                    str3 = packageInfo.versionName;
                                }
                                c05c.A03(AnonymousClass094.A1F, Long.valueOf(packageInfo.firstInstallTime));
                                AnonymousClass091 anonymousClass0913 = AnonymousClass094.A1I;
                                c05c.A03(anonymousClass0913, Long.valueOf(packageInfo.lastUpdateTime));
                                c05c.A04(AnonymousClass094.A4V, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000ZZZZZ", Locale.US).format(new Date(packageInfo.firstInstallTime)));
                                c05c.A03(anonymousClass0913, Long.valueOf(packageInfo.lastUpdateTime));
                                AnonymousClass051 anonymousClass0512 = this.A01;
                                if (anonymousClass0512 != null) {
                                    String string2 = "0";
                                    try {
                                        string2 = anonymousClass0512.A00.getString("last_first_run", "0");
                                    } catch (Exception unused) {
                                        C018108b.A07("lacrima", "Failed to read from SharedPreferences");
                                        C0C5.A00();
                                    }
                                    long j2 = Long.parseLong(string2);
                                    long j3 = packageInfo.firstInstallTime;
                                    long j4 = packageInfo.lastUpdateTime;
                                    long jMax = Math.max(j3, j4);
                                    if (jMax <= j2) {
                                        c05c.A01(AnonymousClass094.A0M, false);
                                        c05c.A01(AnonymousClass094.A0N, false);
                                    } else {
                                        boolean z = jMax == j3;
                                        boolean z2 = jMax == j4;
                                        anonymousClass0512.A00.edit().putString("last_first_run", Long.toString(jMax)).apply();
                                        c05c.A01(AnonymousClass094.A0M, z);
                                        c05c.A01(AnonymousClass094.A0N, z2);
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                            C0C5.A00();
                        }
                        c05c.A04(AnonymousClass094.A7l, str3);
                        ReportFieldString reportFieldString2 = AnonymousClass094.A3x;
                        try {
                            String string3 = Settings.Secure.getString(application2.getContentResolver(), "android_id");
                            if (string3 != null) {
                                str = string3;
                            }
                        } catch (Exception e4) {
                            C0C5.A00();
                            C018108b.A0A("lacrima", "Failed to fetch the constant field ANDROID_ID", e4);
                        }
                        c05c.A04(reportFieldString2, str);
                        ReportFieldString reportFieldString3 = AnonymousClass094.A66;
                        File filesDir = application2.getFilesDir();
                        if (filesDir != null) {
                            absolutePath = filesDir.getAbsolutePath();
                        } else {
                            absolutePath = "n/a";
                        }
                        c05c.A04(reportFieldString3, absolutePath);
                        String str4 = c0ck4.A06;
                        ReportFieldString reportFieldString4 = AnonymousClass094.A4Y;
                        StringBuilder sb = new StringBuilder();
                        sb.append(packageName);
                        String string4 = "";
                        if (!"".equals(str4)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(":");
                            sb2.append(str4);
                            string4 = sb2.toString();
                        }
                        sb.append(string4);
                        c05c.A04(reportFieldString4, sb.toString());
                        c05c.A01(AnonymousClass094.A0F, AbstractC017707t.A02());
                        c05c.A02(AnonymousClass094.A2j, Process.myPid());
                        AnonymousClass091 anonymousClass0914 = AnonymousClass094.A1s;
                        long[] jArr = new long[1];
                        C08T.A00.Ah1("/proc/self/status", jArr, new String[]{"PPid:"}, -1L);
                        c05c.A02(anonymousClass0914, (int) jArr[0]);
                        c05c.A01(AnonymousClass094.A0U, AbstractC017707t.A03());
                        ReportFieldString reportFieldString5 = AnonymousClass094.AAM;
                        ApplicationInfo applicationInfo = application2.getApplicationInfo();
                        if (applicationInfo == null) {
                            string = "n/a";
                        } else {
                            string = Integer.toString(applicationInfo.targetSdkVersion);
                        }
                        c05c.A04(reportFieldString5, string);
                        c05c.A04(AnonymousClass094.A9P, application2.getApplicationInfo().publicSourceDir);
                        AnonymousClass091 anonymousClass0915 = AnonymousClass094.A1U;
                        File fileA00 = A00(application2);
                        int i = -1;
                        if (fileA00 != null) {
                            File file2 = new File(fileA00, "base.vdex");
                            if (file2.exists()) {
                                long length = file2.length();
                                if (length >= 0) {
                                    i = length < 2147483647L ? (int) length : Integer.MAX_VALUE;
                                }
                            }
                        }
                        c05c.A02(anonymousClass0915, i);
                        AnonymousClass091 anonymousClass0916 = AnonymousClass094.A1T;
                        File fileA002 = A00(application2);
                        int i2 = -1;
                        if (fileA002 != null) {
                            File file3 = new File(fileA002, "base.odex");
                            if (file3.exists()) {
                                long length2 = file3.length();
                                if (length2 >= 0) {
                                    i2 = length2 < 2147483647L ? (int) length2 : Integer.MAX_VALUE;
                                }
                            }
                        }
                        c05c.A02(anonymousClass0916, i2);
                        AnonymousClass091 anonymousClass0917 = AnonymousClass094.A1S;
                        File parentFile = new File(application2.getApplicationInfo().publicSourceDir).getParentFile();
                        int i3 = -1;
                        if (parentFile != null) {
                            File file4 = new File(parentFile, "base.dm");
                            if (file4.exists()) {
                                long length3 = file4.length();
                                if (length3 >= 0) {
                                    i3 = length3 < 2147483647L ? (int) length3 : Integer.MAX_VALUE;
                                }
                            }
                        }
                        c05c.A02(anonymousClass0917, i3);
                        c05c.A02(AnonymousClass094.A3Q, -1);
                    }
                };
            default:
                final C018608h c018608h = (C018608h) this.A00;
                return new AnonymousClass095(c018608h) { // from class: X.04U
                    public final int A00;
                    public final C018608h A01;

                    @Override // X.AnonymousClass095
                    public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) {
                        int i;
                        C006502t c006502tA00;
                        String strA0A;
                        if (Build.VERSION.SDK_INT < 30 || (i = this.A00) == 0 || (c006502tA00 = this.A01.A00(i)) == null) {
                            return;
                        }
                        c05c.A02(AnonymousClass094.A1j, c006502tA00.A02());
                        c05c.A02(AnonymousClass094.A1i, c006502tA00.A01());
                        c05c.A04(AnonymousClass094.A5x, c006502tA00.A08());
                        c05c.A02(AnonymousClass094.A1l, c006502tA00.A03());
                        c05c.A02(AnonymousClass094.A1n, c006502tA00.A04());
                        c05c.A03(AnonymousClass094.A1o, Long.valueOf(c006502tA00.A07()));
                        c05c.A01(AnonymousClass094.A0b, c006502tA00.A0B());
                        c05c.A04(AnonymousClass094.A5y, c006502tA00.A09());
                        c05c.A03(AnonymousClass094.A1k, Long.valueOf(c006502tA00.A05()));
                        c05c.A03(AnonymousClass094.A1m, Long.valueOf(c006502tA00.A06()));
                        if (anonymousClass057 != AnonymousClass057.LARGE_REPORT || (strA0A = c006502tA00.A0A()) == null) {
                            return;
                        }
                        c05c.A04(AnonymousClass094.A5z, strA0A);
                    }

                    {
                        int i;
                        File fileA01;
                        AnonymousClass052 anonymousClass052 = AnonymousClass052.A03;
                        if (anonymousClass052 == null) {
                            throw new IllegalStateException("Did you call PreviousSessionHelper.init?");
                        }
                        if (anonymousClass052.A02) {
                            i = anonymousClass052.A00;
                        } else {
                            synchronized (anonymousClass052) {
                                if (anonymousClass052.A02) {
                                    i = anonymousClass052.A00;
                                } else {
                                    anonymousClass052.A02 = true;
                                    C0CK c0ck3 = anonymousClass052.A01;
                                    if (c0ck3 != null && (fileA01 = c0ck3.A01(c0ck3.A06)) != null) {
                                        File file = new File(fileA01, "critical_suppl_startup_prop.txt");
                                        Properties properties = new Properties();
                                        try {
                                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                                            try {
                                                properties.load(bufferedInputStream);
                                                String property = properties.getProperty("pid");
                                                i = property != null ? Integer.parseInt(property) : 0;
                                                bufferedInputStream.close();
                                            } catch (Throwable th) {
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (Throwable th2) {
                                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                                }
                                                throw th;
                                            }
                                        } catch (IOException | NumberFormatException e) {
                                            C0C5.A00();
                                            C018108b.A0C("lacrima", "Error getting previous process id", e);
                                        }
                                    }
                                    anonymousClass052.A00 = i;
                                }
                            }
                        }
                        this.A00 = i;
                        this.A01 = c018608h;
                    }

                    @Override // X.AnonymousClass095
                    public final Integer AGY() {
                        return AnonymousClass065.A0u;
                    }
                };
        }
    }
}
