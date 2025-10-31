package X;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import java.util.List;

/* renamed from: X.02t, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C006502t {
    public String A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final long A05;
    public final long A06;
    public final long A07;
    public final String A08;
    public final String A09;
    public final boolean A0A;

    public static C006502t A00(Context context, int i, boolean z) {
        ApplicationExitInfo applicationExitInfo;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
        if (activityManager == null) {
            return null;
        }
        String packageName = context.getPackageName();
        if (i == -1) {
            i = 0;
        }
        List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(packageName, i, 1);
        if (historicalProcessExitReasons == null || historicalProcessExitReasons.isEmpty() || (applicationExitInfo = historicalProcessExitReasons.get(0)) == null) {
            return null;
        }
        return new C006502t(applicationExitInfo, ActivityManager.isLowMemoryKillReportSupported(), z);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C006502t(android.app.ApplicationExitInfo r8, boolean r9, boolean r10) {
        /*
            r7 = this;
            r7.<init>()
            int r0 = r8.getPid()
            r7.A02 = r0
            java.lang.String r0 = r8.getDescription()
            r7.A08 = r0
            int r4 = r8.getReason()
            r7.A03 = r4
            int r0 = r8.getStatus()
            r7.A04 = r0
            int r0 = r8.getImportance()
            r7.A01 = r0
            long r0 = r8.getTimestamp()
            r7.A07 = r0
            r7.A0A = r9
            long r0 = r8.getPss()
            r7.A05 = r0
            long r0 = r8.getRss()
            r7.A06 = r0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 30
            r6 = 0
            if (r1 == r0) goto L77
            java.lang.String r3 = r8.toString()
            java.lang.String r0 = "subreason="
            int r2 = r3.indexOf(r0)
            r5 = -1
            if (r2 == r5) goto L77
            java.lang.String r0 = " status="
            int r1 = r3.indexOf(r0, r2)
            int r0 = r2 + 10
            if (r1 != r5) goto L72
            java.lang.String r3 = r3.substring(r0)
        L57:
            r0 = 40
            int r2 = r3.indexOf(r0)
            if (r2 == r5) goto L6d
            r0 = 41
            int r1 = r3.indexOf(r0, r2)
            if (r1 == r5) goto L6d
            int r0 = r2 + 1
            java.lang.String r3 = r3.substring(r0, r1)
        L6d:
            r7.A09 = r3
            if (r10 == 0) goto Lc8
            goto L79
        L72:
            java.lang.String r3 = r3.substring(r0, r1)
            goto L57
        L77:
            r3 = r6
            goto L6d
        L79:
            java.io.InputStream r5 = r8.getTraceInputStream()     // Catch: java.lang.Throwable -> Laa
            if (r5 == 0) goto Lc8
            r0 = 131072(0x20000, float:1.83671E-40)
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L9c
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L9c
            r0 = 16384(0x4000, float:2.2959E-41)
            byte[] r2 = new byte[r0]     // Catch: java.lang.Throwable -> L9a
        L8a:
            int r1 = r5.read(r2)     // Catch: java.lang.Throwable -> L9a
            if (r1 <= 0) goto L95
            r0 = 0
            r3.write(r2, r0, r1)     // Catch: java.lang.Throwable -> L9a
            goto L8a
        L95:
            r6 = r3
            r5.close()     // Catch: java.lang.Throwable -> Laa
            goto Lb4
        L9a:
            r1 = move-exception
            goto L9e
        L9c:
            r1 = move-exception
            r3 = r6
        L9e:
            r5.close()     // Catch: java.lang.Throwable -> La2
            goto La6
        La2:
            r0 = move-exception
            X.AnonymousClass067.A00(r1, r0)     // Catch: java.lang.Throwable -> La7
        La6:
            throw r1     // Catch: java.lang.Throwable -> La7
        La7:
            r2 = move-exception
            r6 = r3
            goto Lab
        Laa:
            r2 = move-exception
        Lab:
            java.lang.String r1 = "AppExitInfo"
            java.lang.String r0 = "Error reading from trace stream"
            X.C018108b.A0A(r1, r0, r2)
            if (r6 == 0) goto Lc8
        Lb4:
            int r0 = r6.size()
            if (r0 == 0) goto Lc8
            r0 = 5
            if (r4 != r0) goto Lc9
            byte[] r1 = r6.toByteArray()
            r0 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r1, r0)
            r7.A00 = r0
        Lc8:
            return
        Lc9:
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.io.UnsupportedEncodingException -> Ld6
            java.lang.String r0 = r0.name()     // Catch: java.io.UnsupportedEncodingException -> Ld6
            java.lang.String r0 = r6.toString(r0)     // Catch: java.io.UnsupportedEncodingException -> Ld6
            r7.A00 = r0     // Catch: java.io.UnsupportedEncodingException -> Ld6
            return
        Ld6:
            r2 = move-exception
            java.lang.String r1 = "AppExitInfo"
            java.lang.String r0 = "Error encoding trace"
            X.C018108b.A0A(r1, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C006502t.<init>(android.app.ApplicationExitInfo, boolean, boolean):void");
    }

    public final int A01() {
        return this.A01;
    }

    public final int A02() {
        return this.A02;
    }

    public final int A03() {
        return this.A03;
    }

    public final int A04() {
        return this.A04;
    }

    public final long A05() {
        return this.A05;
    }

    public final long A06() {
        return this.A06;
    }

    public final long A07() {
        return this.A07;
    }

    public final String A08() {
        return this.A08;
    }

    public final String A09() {
        return this.A09;
    }

    public final String A0A() {
        return this.A00;
    }

    public final boolean A0B() {
        return this.A0A;
    }
}
