package X;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: X.0CE, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0CE extends C0AD implements C0BS {
    public final Set A02;
    public final Map A01 = AnonymousClass000.A0C();
    public final Map A00 = AnonymousClass000.A0C();

    private void A01() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        int iIndexOf;
        int i;
        for (String str : this.A02) {
            String strSubstring = (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf(33)) < 0 || (i = iIndexOf + 2) >= str.length()) ? null : str.substring(i);
            if (!TextUtils.isEmpty(strSubstring)) {
                ZipFile zipFile = new ZipFile(str.substring(0, str.indexOf(33)));
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                    while (enumerationEntries.hasMoreElements()) {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement != null && zipEntryNextElement.getMethod() == 0 && zipEntryNextElement.getName().startsWith(strSubstring) && zipEntryNextElement.getName().endsWith(".so")) {
                            String strSubstring2 = zipEntryNextElement.getName().substring(strSubstring.length() + 1);
                            Map map = this.A01;
                            synchronized (map) {
                                if (!map.containsKey(str)) {
                                    map.put(str, new HashSet());
                                }
                                ((Set) map.get(str)).add(strSubstring2);
                            }
                        }
                    }
                    zipFile.close();
                } catch (Throwable th) {
                    try {
                        zipFile.close();
                        throw th;
                    } catch (Throwable th2) {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d2 A[PHI: r0
  0x00d2: PHI (r0v12 java.util.Set) = (r0v11 java.util.Set), (r0v40 java.util.Set) binds: [B:16:0x0046, B:38:0x00d0] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // X.C0AD
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A03(android.os.StrictMode.ThreadPolicy r16, java.lang.String r17, int r18) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C0CE.A03(android.os.StrictMode$ThreadPolicy, java.lang.String, int):int");
    }

    @Override // X.C0AD
    public final String A06(String str) {
        for (String str2 : this.A02) {
            Set set = (Set) this.A01.get(str2);
            if (!TextUtils.isEmpty(str2) && set != null && set.contains(str)) {
                return AnonymousClass000.A06(File.separator, str, AnonymousClass000.A0A(str2));
            }
        }
        return null;
    }

    @Override // X.C0BS
    public final C0AD Ah9(ApplicationInfo applicationInfo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C0CE c0ce = new C0CE(applicationInfo);
        try {
            c0ce.A01();
            return c0ce;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public C0CE(ApplicationInfo applicationInfo) {
        HashSet hashSet = new HashSet();
        String strA00 = A00(applicationInfo.sourceDir);
        if (strA00 != null) {
            hashSet.add(strA00);
        }
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            for (String str : strArr) {
                String strA002 = A00(str);
                if (strA002 != null) {
                    hashSet.add(strA002);
                }
            }
        }
        this.A02 = hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035 A[PHI: r1
  0x0035: PHI (r1v2 java.lang.StringBuilder) = (r1v0 java.lang.StringBuilder), (r1v3 java.lang.StringBuilder) binds: [B:12:0x0032, B:16:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(java.lang.String r7) {
        /*
            java.lang.String[] r6 = X.C0B5.A0B()
            r5 = 0
            java.lang.String r4 = "null"
            java.lang.String r3 = "empty"
            java.lang.String r2 = "SoLoader"
            if (r7 == 0) goto L29
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L29
            if (r6 == 0) goto L37
            int r0 = r6.length
            if (r0 == 0) goto L37
            java.lang.StringBuilder r1 = X.AnonymousClass000.A0A(r7)
            java.lang.String r0 = "!/lib/"
            r1.append(r0)
            r0 = 0
            r0 = r6[r0]
            java.lang.String r5 = X.AnonymousClass000.A07(r0, r1)
            return r5
        L29:
            java.lang.StringBuilder r1 = X.AnonymousClass000.A09()
            java.lang.String r0 = "Cannot compute fallback path, apk path is "
            r1.append(r0)
            if (r7 != 0) goto L35
            goto L42
        L35:
            r4 = r3
            goto L42
        L37:
            java.lang.StringBuilder r1 = X.AnonymousClass000.A09()
            java.lang.String r0 = "Cannot compute fallback path, supportedAbis is "
            r1.append(r0)
            if (r6 != 0) goto L35
        L42:
            X.AnonymousClass000.A0K(r4, r2, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C0CE.A00(java.lang.String):java.lang.String");
    }

    @Override // X.C0AD
    public final String toString() {
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("DirectApkSoSource");
        sbA09.append("[root = ");
        AnonymousClass000.A0L(sbA09, this.A02);
        sbA09.append(']');
        return sbA09.toString();
    }

    @Override // X.C0AD
    public final String A05() {
        return "DirectApkSoSource";
    }

    @Override // X.C0AD
    public final void A07(int i) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        A01();
    }
}
