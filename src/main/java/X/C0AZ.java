package X;

import android.app.Application;
import android.os.Trace;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/* renamed from: X.0AZ */
/* loaded from: classes.dex */
public final class C0AZ {
    public static C0AZ A0Y;
    public static final String A0Z = C0CH.A00("mobile", "reliability_event_log_upload").toString();
    public C04w A00;
    public C0CK A02;
    public C09V A03;
    public C09V A04;
    public C09V A07;
    public C09V A08;
    public C09V A09;
    public C09V A0B;
    public final int A0D;
    public final int A0E;
    public final Application A0F;
    public final List A0G;
    public final List A0H;
    public final List A0I;
    public final List A0J;
    public final C09V A0K;
    public final C09V A0L;
    public final C09V A0M;
    public final C09V A0N;
    public final C09V A0O;
    public final C09V A0R;
    public final C09V A0S;
    public final C09V A0U;
    public final boolean A0W;
    public final boolean A0X;
    public C0AX A01 = null;
    public final C09V A0T = new C02620Cb(this, 5);
    public final C09V A0Q = new C02620Cb(this, 6);
    public C09V A05 = null;
    public C09V A0A = null;
    public final C09V A0P = new C02610Ca(1);
    public C09V A06 = null;
    public final boolean A0V = true;
    public final int A0C = 3;

    public static void A00(C0AZ c0az, String str, Throwable th) {
        Method method = AnonymousClass066.A03;
        Trace.beginSection("maybeReportSoftError");
        try {
            if (Math.random() < 0.001d) {
                String str2 = (String) c0az.A0U.get();
                String str3 = (String) c0az.A0L.get();
                String str4 = (String) c0az.A0K.get();
                String str5 = (String) c0az.A0S.get();
                HashMap mapA0C = AnonymousClass000.A0C();
                C021209l.A02(AnonymousClass094.A5K, C08v.A01(th), mapA0C);
                C021209l.A03(str2, str3, str4, str5, mapA0C);
                C021209l.A04("lacrima", mapA0C, str);
                C021209l.A00().A06("android_large_soft_error", mapA0C);
            }
        } finally {
            Trace.endSection();
        }
    }

    public final C0CK A01() {
        C0CK c0ck = this.A02;
        AnonymousClass053.A03(c0ck, "Did you call earlyInit()?");
        return c0ck;
    }

    public final C09V A02() {
        C09V c09v = this.A09;
        if (c09v != null) {
            return c09v;
        }
        C02620Cb c02620Cb = new C02620Cb(this, 10);
        this.A09 = c02620Cb;
        return c02620Cb;
    }

    public C0AZ(Application application, List list, List list2, List list3, List list4, C09V c09v, C09V c09v2, C09V c09v3, C09V c09v4, C09V c09v5, C09V c09v6, C09V c09v7, C09V c09v8, int i, boolean z, boolean z2) {
        this.A0F = application;
        this.A0M = c09v2;
        this.A0U = c09v3;
        this.A0L = c09v4;
        this.A0K = c09v5;
        this.A0O = c09v6;
        this.A0G = list;
        this.A0H = list2;
        this.A0I = list3;
        this.A0J = list4;
        this.A0S = c09v7;
        this.A0N = c09v8;
        this.A0R = c09v;
        this.A0W = z;
        this.A0E = i;
        this.A0X = z2;
        A0Y = this;
        C0C5.A00();
        c09v.get();
        this.A0D = 3;
    }
}
