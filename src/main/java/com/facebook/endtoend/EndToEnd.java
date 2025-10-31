package com.facebook.endtoend;

import X.AnonymousClass000;
import X.C016507g;
import X.C07O;
import android.util.Log;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class EndToEnd {
    public static boolean A00;
    public static boolean A01;
    public static boolean A02;
    public static boolean A03;
    public static boolean A04;
    public static boolean A05;
    public static volatile Map A06;
    public static volatile JSONObject A07 = new JSONObject();
    public static volatile boolean A08;
    public static volatile boolean A09;

    public static String A00(String str, boolean z, boolean z2) {
        if (!z2 && !isRunningEndToEndTest()) {
            return null;
        }
        String property = System.getProperty(str);
        if (property == null || property.equals("")) {
            String property2 = System.getProperty(AnonymousClass000.A06("fb.e2e.", str, AnonymousClass000.A09()));
            if (property2 != null && !property2.equals("")) {
                return property2;
            }
            if (z) {
                try {
                    property = C07O.A02(str);
                    if (property.equals("")) {
                        String strA02 = C07O.A02(AnonymousClass000.A06("fb.e2e.", str, AnonymousClass000.A09()));
                        if (!strA02.equals("")) {
                            return strA02;
                        }
                    }
                } catch (IllegalArgumentException unused) {
                }
            }
            return null;
        }
        return property;
    }

    static {
        try {
            synchronized (C016507g.class) {
                throw AnonymousClass000.A04("ApplicationHolder#set never called");
            }
        } catch (IllegalStateException unused) {
        }
    }

    public static synchronized boolean A01() {
        if (!A04) {
            boolean zEquals = "true".equals(C07O.A02("fb.running_mobilelab"));
            A05 = zEquals;
            if (zEquals) {
                Log.w("Mobilelab", "Is running Mobilelab test");
            }
            A04 = true;
        }
        return A05;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isRunningEndToEndTest() {
        /*
            boolean r0 = com.facebook.endtoend.EndToEnd.A08
            if (r0 != 0) goto L26
            java.lang.String r0 = "fb.running_e2e"
            boolean r0 = A02(r0)
            r2 = 1
            if (r0 != 0) goto L16
            java.lang.String r0 = "persist.fb.running_e2e"
            boolean r1 = A02(r0)
            r0 = 0
            if (r1 == 0) goto L17
        L16:
            r0 = 1
        L17:
            com.facebook.endtoend.EndToEnd.A09 = r0
            boolean r0 = com.facebook.endtoend.EndToEnd.A09
            if (r0 == 0) goto L24
            java.lang.String r1 = "EndToEnd-Test"
            java.lang.String r0 = "Is running E2E test"
            android.util.Log.w(r1, r0)
        L24:
            com.facebook.endtoend.EndToEnd.A08 = r2
        L26:
            boolean r0 = com.facebook.endtoend.EndToEnd.A09
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.endtoend.EndToEnd.isRunningEndToEndTest():boolean");
    }

    public static boolean A02(String str) {
        return "true".equals(C07O.A02(str)) || "true".equals(System.getProperty(str));
    }
}
