package X;

import android.os.Trace;
import com.facebook.perf.background.BackgroundStartupDetector;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: X.0Az */
/* loaded from: classes.dex */
public final class C02420Az {
    /* JADX WARN: Removed duplicated region for block: B:36:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.facebook.perf.background.BackgroundStartupDetector A00(android.app.Application r5, boolean r6, boolean r7) {
        /*
            r0 = 0
            X.C06E.A07(r5, r0)
            com.facebook.perf.background.BackgroundStartupDetector r0 = com.facebook.perf.background.BackgroundStartupDetector.backgroundStartupDetector
            if (r0 == 0) goto Lb
            com.facebook.perf.background.BackgroundStartupDetector r3 = com.facebook.perf.background.BackgroundStartupDetector.backgroundStartupDetector
            return r3
        Lb:
            android.os.Looper r1 = r5.getMainLooper()
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 34
            if (r4 < r0) goto L18
            r0 = 2
            if (r7 != 0) goto L19
        L18:
            r0 = 1
        L19:
            X.C06E.A06(r1)
            com.facebook.perf.background.BackgroundStartupDetector r3 = new com.facebook.perf.background.BackgroundStartupDetector
            r3.<init>(r1, r0)
            com.facebook.perf.background.BackgroundStartupDetector.backgroundStartupDetector = r3
            com.facebook.perf.background.BackgroundStartupDetector$activityLifecycleCallbacks$1 r0 = r3.activityLifecycleCallbacks
            r5.registerActivityLifecycleCallbacks(r0)
            X.08N r1 = X.C08N.A00()
            X.C06E.A03(r1)
            X.08M r0 = X.C08M.A01
            X.08M r2 = r1.A00
            boolean r1 = r0.equals(r2)
            java.lang.String r0 = "BackgroundStartupDetector"
            if (r1 != 0) goto L4c
            java.lang.StringBuilder r1 = X.AnonymousClass000.A0A(r0)
            r0 = 47
            r1.append(r0)
            if (r2 == 0) goto L67
            java.lang.String r0 = r2.A00
        L48:
            java.lang.String r0 = X.AnonymousClass000.A07(r0, r1)
        L4c:
            com.facebook.perf.background.BackgroundStartupDetector.tag = r0
            if (r6 == 0) goto L69
            r0 = 23
            if (r4 < r0) goto L69
            X.0Ae r0 = r3.handler
            android.os.Looper r0 = r0.getLooper()
            android.os.MessageQueue r1 = r0.getQueue()
            X.0B0 r0 = new X.0B0
            r0.<init>()
            r1.addIdleHandler(r0)
            return r3
        L67:
            r0 = 0
            goto L48
        L69:
            X.0Ae r1 = r3.handler
            r0 = 49181(0xc01d, float:6.8917E-41)
            r1.sendEmptyMessage(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C02420Az.A00(android.app.Application, boolean, boolean):com.facebook.perf.background.BackgroundStartupDetector");
    }

    public static final void A01(int i) {
        ArrayList arrayList;
        Method method = AnonymousClass066.A03;
        Trace.beginSection("BackgroundStartupDetector.setColdStartMode");
        try {
            synchronized (BackgroundStartupDetector.class) {
                try {
                    BackgroundStartupDetector._coldStartMode = i;
                    String str = BackgroundStartupDetector.tag;
                    Object[] objArr = new Object[1];
                    objArr[0] = i != 1 ? i != 2 ? i != 3 ? "PROBABLY_FOREGROUND" : "DEFINITELY_FOREGROUND" : "PROBABLY_BACKGROUND" : "DEFINITELY_BACKGROUND";
                    C018108b.A0K(str, "coldStartMode=%s", objArr);
                    arrayList = BackgroundStartupDetector.getColdStartModeCallbacks;
                    BackgroundStartupDetector.getColdStartModeCallbacks = AnonymousClass000.A0B();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                C06E.A03(it);
                if (it.hasNext()) {
                    C06E.A03(it.next());
                    throw new NullPointerException("onColdStartMode");
                }
            }
            Iterator it2 = BackgroundStartupDetector.listeners.iterator();
            C06E.A03(it2);
            if (it2.hasNext()) {
                it2.next();
            }
        } finally {
            Trace.endSection();
        }
    }

    public static final void A02(boolean z) {
        Boolean bool = BackgroundStartupDetector.isBackgroundState;
        Boolean boolValueOf = Boolean.valueOf(z);
        if (C06E.areEqual(bool, boolValueOf)) {
            return;
        }
        String str = BackgroundStartupDetector.tag;
        Object[] objArr = new Object[1];
        objArr[0] = z ? "BACKGROUND" : "FOREGROUND";
        C018108b.A0K(str, "bgMode=%s", objArr);
        BackgroundStartupDetector.isBackgroundState = boolValueOf;
        Iterator it = BackgroundStartupDetector.listeners.iterator();
        C06E.A03(it);
        if (it.hasNext()) {
            it.next();
            throw new NullPointerException("onIsBackgroundChange");
        }
    }
}
