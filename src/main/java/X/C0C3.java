package X;

import android.app.Application;

/* renamed from: X.0C3, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C0C3 {
    public static Application A00;
    public static String A01;

    public static long A00(Application application) {
        try {
            return application.getSharedPreferences(application.getPackageName(), 0).getLong("current_user_id", 0L);
        } catch (IllegalArgumentException unused) {
            return 0L;
        }
    }

    public static void A01(Application application) {
        try {
            C02260Ac.A00(application, "275254692598279", new CallableC02700Cj(application, 0), new CallableC02700Cj(application, 1), new CallableC02690Ci(application, 1));
            if (C02260Ac.A03 == null) {
                C02260Ac.A00(application, null, null, null, null);
            }
            C02260Ac.A03.A01 = true;
            C0C9.A07 = true;
        } catch (Exception e) {
            A02(application, e, "Failed enabling fallback reporter");
        }
    }

    public static void A02(Application application, Exception exc, String str) {
        try {
            C02260Ac.A01(str, "275254692598279", Long.toString(A00(application)), exc);
        } catch (Exception e) {
            C018108b.A0C("EarlyErrorReporting", "Failed sending direct report", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[Catch: all -> 0x01c5, TryCatch #0 {, blocks: (B:6:0x0013, B:8:0x0017, B:10:0x002b, B:12:0x0037, B:14:0x0041, B:16:0x004b, B:17:0x0052, B:18:0x0055, B:20:0x0062, B:22:0x006e, B:25:0x0082, B:27:0x0094, B:29:0x00a1, B:31:0x00ab, B:33:0x00b5, B:36:0x00c7, B:38:0x00d2, B:40:0x00e6, B:44:0x00f7, B:64:0x01ac, B:43:0x00f3, B:45:0x00fd, B:49:0x0110, B:53:0x012f, B:57:0x015a, B:59:0x0172, B:60:0x0184, B:62:0x019c, B:63:0x01a6, B:66:0x01ae, B:56:0x0156, B:52:0x012b, B:48:0x010c, B:19:0x0058), top: B:73:0x0013, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A03(java.lang.String r20, java.lang.Throwable r21, short r22) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C0C3.A03(java.lang.String, java.lang.Throwable, short):void");
    }
}
