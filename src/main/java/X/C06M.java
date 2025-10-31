package X;

import android.os.StatFs;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.InMemoryDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: X.06M */
/* loaded from: classes.dex */
public abstract class C06M {
    public static DexFile A00(String str) throws IllegalAccessException, NoSuchFieldException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                map.order(ByteOrder.nativeOrder());
                channel.close();
                fileInputStream.close();
                InMemoryDexClassLoader inMemoryDexClassLoader = new InMemoryDexClassLoader(map, DexFile.class.getClassLoader());
                Field declaredField = BaseDexClassLoader.class.getDeclaredField("pathList");
                declaredField.setAccessible(true);
                Object[] objArrA0Q = AnonymousClass000.A0Q(inMemoryDexClassLoader, declaredField);
                Field declaredField2 = Class.forName("dalvik.system.DexPathList$Element").getDeclaredField("dexFile");
                declaredField2.setAccessible(true);
                return (DexFile) declaredField2.get(objArrA0Q[0]);
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
                throw th;
            } finally {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x008a A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #0 {all -> 0x00d3, blocks: (B:81:0x0082, B:83:0x008a, B:91:0x00bc, B:94:0x00c3, B:95:0x00d2, B:80:0x007e), top: B:106:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00c3 A[Catch: all -> 0x00d3, TryCatch #0 {all -> 0x00d3, blocks: (B:81:0x0082, B:83:0x008a, B:91:0x00bc, B:94:0x00c3, B:95:0x00d2, B:80:0x007e), top: B:106:0x007e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.InputStream A01(X.C06z r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r4 = "spo"
            java.lang.String r2 = ".dex"
            boolean r0 = r7.endsWith(r2)
            if (r0 == 0) goto L26
            java.util.zip.ZipFile r1 = r6.A00
            if (r1 != 0) goto L1d
            android.content.Context r0 = r6.A01
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            java.lang.String r0 = r0.sourceDir
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile
            r1.<init>(r0)
            r6.A00 = r1
        L1d:
            java.util.zip.ZipEntry r0 = r1.getEntry(r7)
            java.io.InputStream r3 = r1.getInputStream(r0)
            goto L3a
        L26:
            android.content.Context r0 = r6.A01
            android.content.res.AssetManager r3 = r0.getAssets()
            java.lang.StringBuilder r1 = X.AnonymousClass000.A09()
            java.lang.String r0 = "secondary-program-dex-jars/"
            java.lang.String r0 = X.AnonymousClass000.A06(r0, r7, r1)
            java.io.InputStream r3 = r3.open(r0)
        L3a:
            java.lang.String r0 = ".spo"
            boolean r0 = r7.endsWith(r0)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
            java.lang.String r5 = "classes.dex"
            if (r0 == 0) goto L53
            java.lang.String r0 = com.facebook.superpack.SuperpackArchive.TAG     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
            int r0 = r0.availableProcessors()     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
            com.facebook.superpack.SuperpackFileInputStream r6 = com.facebook.superpack.SuperpackFileInputStream.createFromSingletonArchiveInputStream(r3, r4, r0)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
            goto L64
        L53:
            java.lang.String r0 = ".spk.xz"
            boolean r0 = r7.endsWith(r0)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
            if (r0 == 0) goto L66
            java.lang.String r1 = "xz"
            java.lang.String r0 = com.facebook.superpack.SuperpackArchive.TAG     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
            r0 = 1
            com.facebook.superpack.SuperpackFileInputStream r6 = com.facebook.superpack.SuperpackFileInputStream.createFromSingletonArchiveInputStream(r3, r1, r0)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
        L64:
            r4 = r5
            goto L82
        L66:
            java.lang.String r0 = ".xzs"
            boolean r0 = r7.endsWith(r0)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
            if (r0 != 0) goto L79
            java.lang.String r0 = ".xz"
            boolean r0 = r7.endsWith(r0)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
            if (r0 != 0) goto L79
            r6 = r3
            r4 = r7
            goto L82
        L79:
            com.facebook.xzdecoder.XzInputStream r6 = new com.facebook.xzdecoder.XzInputStream     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
            r6.<init>(r3)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> Lea
            java.lang.String r4 = A04(r7)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld6
        L82:
            java.lang.String r0 = ".jar"
            boolean r0 = r4.endsWith(r0)     // Catch: java.lang.Throwable -> Ld3
            if (r0 == 0) goto Lbc
            java.util.zip.ZipInputStream r3 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> Ld3
            r3.<init>(r6)     // Catch: java.lang.Throwable -> Ld3
        L8f:
            java.util.zip.ZipEntry r1 = r3.getNextEntry()     // Catch: java.lang.Throwable -> Lea
            if (r1 == 0) goto La2
            r1.getName()     // Catch: java.lang.Throwable -> Lea
            java.lang.String r0 = r1.getName()     // Catch: java.lang.Throwable -> Lea
            boolean r0 = r0.equals(r5)     // Catch: java.lang.Throwable -> Lea
            if (r0 == 0) goto L8f
        La2:
            if (r1 == 0) goto Laa
            java.lang.String r4 = A04(r4)     // Catch: java.lang.Throwable -> Lea
            r6 = r3
            goto Lbc
        Laa:
            java.lang.String r2 = "zip file %s did not contain a classes.dex"
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> Lea
            r0 = 0
            r1[r0] = r4     // Catch: java.lang.Throwable -> Lea
            java.lang.String r1 = java.lang.String.format(r2, r1)     // Catch: java.lang.Throwable -> Lea
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> Lea
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lea
            goto Le9
        Lbc:
            boolean r0 = r4.endsWith(r2)     // Catch: java.lang.Throwable -> Ld3
            if (r0 == 0) goto Lc3
            return r6
        Lc3:
            java.lang.StringBuilder r1 = X.AnonymousClass000.A09()     // Catch: java.lang.Throwable -> Ld3
            java.lang.String r0 = "malformed dex asset name: "
            java.lang.String r1 = X.AnonymousClass000.A06(r0, r7, r1)     // Catch: java.lang.Throwable -> Ld3
            X.06N r0 = new X.06N     // Catch: java.lang.Throwable -> Ld3
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Ld3
            throw r0     // Catch: java.lang.Throwable -> Ld3
        Ld3:
            r0 = move-exception
            r3 = r6
            goto Leb
        Ld6:
            r2 = move-exception
            r3 = r6
            goto Lda
        Ld9:
            r2 = move-exception
        Lda:
            java.lang.StringBuilder r1 = X.AnonymousClass000.A09()     // Catch: java.lang.Throwable -> Lea
            java.lang.String r0 = "Could not access archive from "
            java.lang.String r1 = X.AnonymousClass000.A06(r0, r7, r1)     // Catch: java.lang.Throwable -> Lea
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> Lea
            r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> Lea
        Le9:
            throw r0     // Catch: java.lang.Throwable -> Lea
        Lea:
            r0 = move-exception
        Leb:
            X.C06K.A00(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C06M.A01(X.06z, java.lang.String):java.io.InputStream");
    }

    public static String A03(C06P c06p, C06O c06o) {
        String str = c06p.A00;
        String str2 = c06p.A02;
        if (str2 != null) {
            return "spo".equals(str2) ? "store-0.dex.spo" : AnonymousClass000.A06("store-0.dex.spk.", str2, AnonymousClass000.A09());
        }
        if (!str.endsWith(".xzs.tmp~")) {
            return str;
        }
        String str3 = c06o.A00;
        if ("dex".equals(str3)) {
            return "secondary.dex.jar.xzs";
        }
        AnonymousClass053.A02(str3);
        return str3.concat(".dex.jar.xzs");
    }

    public static String A04(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf != -1 ? str.substring(0, iLastIndexOf) : str;
    }

    public static String A02(C06P c06p) {
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("prog-");
        sbA09.append(c06p.A01);
        return AnonymousClass000.A07(".dex", sbA09);
    }

    public static void A06(File file, List list) throws IOException {
        File[] fileArrListFiles = file.getCanonicalFile().listFiles();
        if (fileArrListFiles == null) {
            C018108b.A07("DexStoreUtils", "Failed to list files in dex store root");
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.getName().equals("dex_lock") && !list.contains(A04(file2.getName()))) {
                C06K.A01(file2);
            }
        }
    }

    public static void A05(C06z c06z, C06P c06p, C06O c06o, File file, File file2) {
        FileOutputStream fileOutputStream;
        long availableBlocksLong;
        C04J.A03 = AnonymousClass000.A0C();
        C04J.A00 = System.nanoTime();
        try {
            String strA03 = A03(c06p, c06o);
            long jNanoTime = System.nanoTime();
            try {
                File fileA02 = AnonymousClass000.A02(file, "tmp_dex.dex");
                C04J.A04 = true;
                InputStream inputStreamA01 = A01(c06z, strA03);
                try {
                    try {
                        fileOutputStream = new FileOutputStream(fileA02);
                        try {
                            byte[] bArr = new byte[32768];
                            int i = 0;
                            do {
                                int iMin = Math.min(32768, Integer.MAX_VALUE - i);
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= iMin) {
                                        break;
                                    }
                                    int i3 = inputStreamA01.read(bArr, i2, iMin - i2);
                                    if (i3 < 0) {
                                        if (i3 != -1 || i2 != 0) {
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                    i2 += i3;
                                }
                                if (i2 == -1) {
                                    break;
                                }
                                try {
                                    fileOutputStream.write(bArr, 0, i2);
                                    i += i2;
                                } catch (IOException e) {
                                    Object[] objArr = new Object[2];
                                    AnonymousClass000.A0N(objArr, i, 0);
                                    AnonymousClass000.A0N(objArr, i2, 1);
                                    C018108b.A0G("DexStore", "failed to write file (after writing %d and reading %d bytes)", e, objArr);
                                    throw e;
                                }
                            } while (i < Integer.MAX_VALUE);
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            long millis = timeUnit.toMillis(System.nanoTime() - jNanoTime);
                            Map map = C04J.A03;
                            C01P.A00(map);
                            AnonymousClass000.A0E("extract_dex", millis, map);
                            C06K.A02(fileA02, file2);
                            long millis2 = timeUnit.toMillis(System.nanoTime() - C04J.A00);
                            Map map2 = C04J.A03;
                            C01P.A00(map2);
                            AnonymousClass000.A0E("total_time", millis2, map2);
                        } catch (IOException e2) {
                            try {
                                StatFs statFs = new StatFs(fileA02.getPath());
                                availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
                            } catch (Exception unused) {
                                availableBlocksLong = -1;
                            }
                            C018108b.A0J("DexStoreUtils", "failed to extract secondary dex, available space: %s", e2, Long.valueOf(availableBlocksLong));
                            throw e2;
                        }
                    } finally {
                        C06K.A00(inputStreamA01);
                    }
                } finally {
                    C06K.A00(fileOutputStream);
                }
            } finally {
            }
        } catch (Throwable th) {
            long millis3 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - C04J.A00);
            Map map3 = C04J.A03;
            C01P.A00(map3);
            AnonymousClass000.A0E("total_time", millis3, map3);
            throw th;
        }
    }
}
