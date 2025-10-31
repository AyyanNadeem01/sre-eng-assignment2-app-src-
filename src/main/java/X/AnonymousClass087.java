package X;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.facebook.common.dextricks.storer.Storer;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.VMRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: X.087, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass087 implements InterfaceC014706l {
    public static boolean A06;
    public static final Map A07 = AnonymousClass000.A0C();
    public static final AtomicBoolean A08 = new AtomicBoolean();
    public Context A00;
    public final C06z A01;
    public final C06O A02;
    public final File A03;
    public final File A04;
    public final boolean A05;

    public static boolean A08(Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class clsLoadClass;
        String str;
        String str2;
        try {
            clsLoadClass = new DexFile(context.getApplicationInfo().publicSourceDir).loadClass("com.facebook.lite.splitdex.MegazipDexStorage$PerformSecondaryDexOptHackR$PerformSecondaryDexOptHackRInternal", null);
        } catch (IOException e) {
            C018108b.A0A("MegazipDexStorage", "Failed to load perform secondary dexopt class", e);
            clsLoadClass = null;
        }
        boolean zBooleanValue = false;
        if (clsLoadClass == null) {
            C018108b.A07("MegazipDexStorage", "Failed to find perform secondary dexopt class");
        } else {
            try {
                Method declaredMethod = clsLoadClass.getDeclaredMethod("apply", Context.class, PackageManager.class);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    try {
                        Object objInvoke = declaredMethod.invoke(null, context, context.getPackageManager());
                        AnonymousClass053.A02(objInvoke);
                        zBooleanValue = ((Boolean) objInvoke).booleanValue();
                        return zBooleanValue;
                    } catch (Exception e2) {
                        e = e2;
                        str = "MegazipDexStorage";
                        str2 = "Failed to invoke perform secondary dexopt method ";
                        C018108b.A0A(str, str2, e);
                        return zBooleanValue;
                    }
                }
            } catch (NoSuchMethodException e3) {
                e = e3;
                str = "MegazipDexStorage";
                str2 = "Failed to perform secondary dexopt method";
            }
        }
        return false;
    }

    private File A00() {
        File file = this.A03;
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("oat/");
        File fileA02 = AnonymousClass000.A02(file, AnonymousClass000.A07(VMRuntime.getRuntime().vmInstructionSet(), sbA09));
        String name = this.A04.getName();
        StringBuilder sbA092 = AnonymousClass000.A09();
        sbA092.append(C06M.A04(name));
        return AnonymousClass000.A02(fileA02, AnonymousClass000.A07(".odex", sbA092));
    }

    private String A01() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Context context = this.A00;
        File file = new File(context.getApplicationInfo().dataDir, "dex");
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("p-");
        sbA09.append(A03(context));
        File fileA02 = AnonymousClass000.A02(file, AnonymousClass000.A07(".zip", sbA09));
        if (!fileA02.exists()) {
            File fileA022 = AnonymousClass000.A02(new File(context.getApplicationInfo().dataDir, "dex"), "tmp_decoyzip.zip");
            Files.deleteIfExists(fileA022.toPath());
            long jOpen = Storer.open(fileA022.getPath(), 420);
            Storer.start(jOpen, "classes.dex", 4);
            ZipFile zipFile = new ZipFile(context.getApplicationInfo().publicSourceDir);
            try {
                InputStream inputStream = zipFile.getInputStream(new ZipEntry("classes.dex"));
                try {
                    byte[] bArr = new byte[32768];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i < 0) {
                            break;
                        }
                        Storer.write(jOpen, bArr, i);
                    }
                    inputStream.close();
                    zipFile.close();
                    Storer.finish(jOpen);
                    Storer.cleanup(jOpen);
                    C06K.A02(fileA022, fileA02);
                } finally {
                }
            } catch (Throwable th) {
                try {
                    zipFile.close();
                    throw th;
                } finally {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
                }
            }
        }
        return fileA02.getPath();
    }

    public static String A04(File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (file == null || !file.exists()) {
            return "";
        }
        StringBuilder sbA09 = AnonymousClass000.A09();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sbA09.append(line);
                    sbA09.append('\n');
                } finally {
                }
            }
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return sbA09.toString();
    }

    private void A05() throws Throwable {
        String strA07;
        File file = this.A04;
        if (file.exists()) {
            return;
        }
        C06O c06o = this.A02;
        if ("dex".equals(c06o.A00)) {
            C04J.A04 = true;
        }
        if (!file.getName().endsWith(".zip")) {
            List list = c06o.A01;
            if (list.size() == 1 && Build.VERSION.SDK_INT >= 30) {
                C06M.A05(this.A01, (C06P) list.get(0), c06o, this.A03, file);
                return;
            }
        }
        File file2 = new File(this.A03.getAbsolutePath(), "tmp_megazip.zip");
        Files.deleteIfExists(file2.toPath());
        List list2 = c06o.A01;
        long jOpen = Storer.open(file2.getPath(), 420);
        for (int i = 0; i < list2.size(); i++) {
            if (i == 0) {
                strA07 = "classes.dex";
            } else {
                StringBuilder sbA09 = AnonymousClass000.A09();
                sbA09.append("classes");
                sbA09.append(i + 1);
                strA07 = AnonymousClass000.A07(".dex", sbA09);
            }
            Storer.start(jOpen, strA07, 4);
            InputStream inputStreamA01 = C06M.A01(this.A01, C06M.A03((C06P) list2.get(i), c06o));
            try {
                byte[] bArr = new byte[32768];
                while (true) {
                    int i2 = inputStreamA01.read(bArr);
                    if (i2 >= 0) {
                        Storer.write(jOpen, bArr, i2);
                    }
                }
                C06K.A00(inputStreamA01);
                Storer.finish(jOpen);
            } catch (Throwable th) {
                C06K.A00(inputStreamA01);
                throw th;
            }
        }
        Storer.cleanup(jOpen);
        C06K.A02(file2, file);
    }

    public static void A06() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (A06) {
            return;
        }
        A06 = true;
        Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
        Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
        Object objInvoke = declaredMethod.invoke(null, "dalvik.system.VMRuntime");
        Method method = (Method) declaredMethod2.invoke(objInvoke, "getRuntime", null);
        Method method2 = (Method) declaredMethod2.invoke(objInvoke, "setHiddenApiExemptions", new Class[]{String[].class});
        if (method == null || method2 == null) {
            throw new NoSuchMethodException();
        }
        method2.invoke(method.invoke(null, null), new String[]{"L"});
    }

    public static boolean A09(Context context, AnonymousClass087 anonymousClass087, boolean z) throws IllegalAccessException, InterruptedException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iWaitFor;
        String[] strArr = {"cmd", "package", "compile", "-m", "speed", "-f", "--secondary-dex", context.getPackageName()};
        ProcessBuilder processBuilder = new ProcessBuilder(strArr);
        File file = new File(anonymousClass087.A04.getParent(), "oat/opt_log.txt");
        try {
            Files.deleteIfExists(file.toPath());
            file.createNewFile();
            processBuilder.redirectOutput(file).redirectError(file);
        } catch (IOException unused) {
            file = null;
        }
        try {
            iWaitFor = processBuilder.start().waitFor();
            e = null;
        } catch (IOException | InterruptedException e) {
            e = e;
            iWaitFor = -1;
        }
        boolean zA0O = AnonymousClass000.A0O(iWaitFor);
        if (z && iWaitFor == 255 && A04(file).contains("UPDATE_DEVICE_STATS")) {
            return A09(context, anonymousClass087, false);
        }
        if (zA0O) {
            boolean zA08 = A08(context);
            zA0O = !zA08;
            if (!zA08 && z) {
                zA0O = !A08(context);
            }
            if (zA0O) {
                C015606v.A01();
                int i = C015606v.A00(context).getInt(AnonymousClass000.A08("primary_dex_feature_key_", AnonymousClass000.A09(), 50), 100);
                if (i == 0 || new Random().nextInt(i) == 0) {
                    String strA04 = A04(file);
                    String strSubstring = strA04.substring(0, Math.min(strA04.length(), 2048));
                    StringBuilder sbA09 = AnonymousClass000.A09();
                    sbA09.append("eagerDexOpt (ret=");
                    sbA09.append(iWaitFor);
                    sbA09.append(") failed to execCmdInProcess ");
                    StringBuilder sbA092 = AnonymousClass000.A09();
                    sbA092.append((CharSequence) strArr[0]);
                    int i2 = 1;
                    do {
                        sbA092.append((CharSequence) " ");
                        sbA092.append((CharSequence) strArr[i2]);
                        i2++;
                    } while (i2 < 8);
                    AnonymousClass000.A0L(sbA09, sbA092);
                    String strA06 = AnonymousClass000.A06(" ", strSubstring, sbA09);
                    C0Bd.A01(strA06, e);
                    C0Bd.A02(strA06, e);
                }
            }
        }
        if (file != null) {
            try {
                Files.deleteIfExists(file.toPath());
            } catch (IOException e2) {
                C018108b.A0D("MegazipDexStorage", "Failed to delete log file", e2);
            }
        }
        if (zA0O) {
            if (iWaitFor != 1) {
                return false;
            }
            C015606v.A01();
            if (!C015606v.A04(anonymousClass087.A00.getApplicationContext(), 49)) {
                return false;
            }
        }
        return true;
    }

    @Override // X.InterfaceC014706l
    public final void A5i() throws IOException {
        File file = this.A04;
        if (file.exists()) {
            return;
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(C06M.A04(file.getName()));
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("p-");
        sbA09.append(A03(this.A00));
        arrayList.add(C06M.A04(AnonymousClass000.A07(".zip", sbA09)));
        C06M.A06(this.A03, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:170:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0491  */
    @Override // X.InterfaceC014706l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AMp(final android.content.Context r22, java.util.concurrent.Executor r23, boolean r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1185
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.AnonymousClass087.AMp(android.content.Context, java.util.concurrent.Executor, boolean):void");
    }

    public AnonymousClass087(Context context, C06z c06z, C06O c06o, File file) throws NoSuchAlgorithmException {
        String strA07;
        this.A00 = context;
        this.A01 = c06z;
        this.A02 = c06o;
        this.A03 = file;
        List list = c06o.A01;
        if (list.size() != 1 || Build.VERSION.SDK_INT < 30) {
            StringBuilder sb = new StringBuilder(46);
            sb.append("z-");
            Context context2 = this.A00;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(A03(context2).getBytes());
                Iterator it = this.A02.A01.iterator();
                while (it.hasNext()) {
                    messageDigest.update(((C06P) it.next()).A01.getBytes());
                }
                byte[] bArrDigest = messageDigest.digest();
                StringBuilder sbA09 = AnonymousClass000.A09();
                char[] charArray = "0123456789abcdef".toCharArray();
                for (byte b : bArrDigest) {
                    sbA09.append(charArray[(b >> 4) & 15]);
                    sbA09.append(charArray[b & 15]);
                }
                AnonymousClass000.A0L(sb, sbA09);
                strA07 = AnonymousClass000.A07(".zip", sb);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        } else {
            strA07 = C06M.A02((C06P) list.get(0));
        }
        this.A04 = AnonymousClass000.A02(file, strA07);
        boolean z = false;
        if (Build.VERSION.SDK_INT == 29) {
            try {
                A06();
                if (Class.forName("android.content.pm.IPackageManager").getDeclaredMethod("notifyDexLoadWithStatus", String.class, List.class, List.class, String.class, int[].class) != null) {
                    z = true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e2) {
                C018108b.A0A("MegazipDexStorage", "Failed to detect if device has notifyDexLoadWithStatus:", e2);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.A05 = z;
    }

    public static String A03(Context context) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long crc;
        File fileA03 = AnonymousClass000.A03(context.getApplicationInfo().publicSourceDir);
        int iA01 = AbstractC017707t.A01();
        if (iA01 > 1) {
            C018108b.A08("MegazipDexStorage", "Build id used for apk identification");
            crc = iA01;
        } else {
            try {
                ZipFile zipFile = new ZipFile(fileA03);
                try {
                    ZipEntry entry = zipFile.getEntry("classes.dex");
                    if (entry == null) {
                        zipFile.close();
                        StringBuilder sbA09 = AnonymousClass000.A09();
                        sbA09.append("No usable identifier for apk ");
                        throw new RuntimeException(AnonymousClass000.A07(fileA03.getPath(), sbA09));
                    }
                    C018108b.A08("MegazipDexStorage", "CRC used for apk identification");
                    crc = entry.getCrc();
                    zipFile.close();
                } finally {
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return String.valueOf(crc);
    }

    public static void A07(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            A06();
            BaseDexClassLoader.class.getDeclaredMethod("setReporter", Class.forName("dalvik.system.BaseDexClassLoader$Reporter")).invoke(null, obj);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            C018108b.A0C("MegazipDexStorage", "Failed to set reporter object: ", e);
        }
    }

    public static /* synthetic */ String A02() {
        return "MegazipDexStorage";
    }
}
