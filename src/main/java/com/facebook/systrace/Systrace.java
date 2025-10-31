package com.facebook.systrace;

import X.AbstractC003601q;
import X.C01H;
import X.C01I;
import X.C01K;
import X.C07Q;
import X.C0A2;
import X.C0A7;
import X.C0CN;
import android.os.Build;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class Systrace {
    public static long A00;
    public static final ThreadLocal A01;
    public static final AtomicInteger A02;
    public static final String[][] A03;

    static {
        C01I c01i = C01H.A00;
        if (C07Q.A03) {
            Method method = C07Q.A02;
            C0CN.A00(method);
            C07Q.A00(method, true);
        }
        C01H.A01(false);
        C01K c01k = C01K.$redex_init_class;
        A02 = new AtomicInteger();
        A01 = new ThreadLocal() { // from class: X.01N
            @Override // java.lang.ThreadLocal
            public final /* bridge */ /* synthetic */ Object initialValue() {
                return new C0A3();
            }
        };
        A03 = new String[][]{new String[]{"com.facebook.common.fury.FBSystraceReqContextLifecycleCallbacks.onActivate", "com.facebook.common.fury.FBSystraceReqContextLifecycleCallbacks.onDeactivate"}, new String[]{"com.facebook.common.plugins.fblogging.FbPluginsLogger.pluginMarkerStart", "com.facebook.common.plugins.fblogging.FbPluginsLogger.pluginMarkerEnd"}, new String[]{"com.facebook.common.plugins.fblogging.FbPluginsLogger.onSocketGetPluginsStart", "com.facebook.common.plugins.fblogging.FbPluginsLogger.onSocketGetPluginsEnd"}};
    }

    public static void A00(long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(j)) {
            TraceDirect.endSection();
        }
    }

    public static void A01(long j, String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(j)) {
            TraceDirect.beginSection(str);
        }
    }

    public static void A02(C0A2 c0a2, String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(281474976710656L)) {
            TraceDirect.traceInstant("", str, c0a2.A00);
        }
    }

    public static void A03(String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(1L)) {
            TraceDirect.traceCounter(str, 1000);
        }
    }

    public static void A04(String str, int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(281474976710656L)) {
            TraceDirect.asyncTraceBegin(str, i, 0L);
        }
    }

    public static void A05(String str, int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(281474976710656L)) {
            TraceDirect.endAsyncFlow(str, i);
        }
    }

    public static void A06(String str, int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(281474976710656L)) {
            TraceDirect.asyncTraceEnd(str, i, 0L);
        }
    }

    public static void A07(String str, int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(281474976710656L)) {
            TraceDirect.startAsyncFlow(str, i);
        }
    }

    public static void A08(String str, int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(281474976710656L)) {
            TraceDirect.stepAsyncFlow(str, i);
        }
    }

    public static void A09(String str, int i, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(4L)) {
            TraceDirect.asyncTraceBegin(str, i, C0A7.A00(j));
        }
    }

    public static void A0A(String str, int i, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(4L)) {
            TraceDirect.asyncTraceEnd(str, i, C0A7.A00(j));
        }
    }

    public static void A0B(String str, int i, String str2) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(281474976710656L)) {
            TraceDirect.asyncTraceStageBegin(str, i, 0L, str2);
        }
    }

    public static void A0C(String str, int i, String str2) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(4L)) {
            TraceDirect.asyncTraceRename(str, str2, i);
        }
    }

    public static void A0D(String str, int i, String str2) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(64L)) {
            TraceDirect.traceMetadata(str, str2, i);
        }
    }

    public static void A0E(String str, String str2, int i, long j, long j2) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(j)) {
            TraceDirect.asyncTraceStageBegin(str, i, C0A7.A00(j2), str2);
        }
    }

    public static void A0F(String str, String[] strArr, int i, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            AbstractC003601q.A00();
        }
        if (A0G(j)) {
            TraceDirect.beginSectionWithArgs(str, strArr, i);
        }
    }

    public static boolean A0G(long j) {
        return ((j & C01H.A01) == 0 && (A00 & j) == 0) ? false : true;
    }
}
