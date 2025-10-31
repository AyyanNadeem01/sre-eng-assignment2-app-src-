package X;

import android.os.Trace;
import com.facebook.breakpad.BreakpadManager;
import com.facebook.errorreporting.lacrima.detector.javacrash.JavaCrashDetector;
import com.facebook.lite.SharedPreferencesHookA11;
import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: X.0Cl */
/* loaded from: classes.dex */
public class C02720Cl implements C0AT {
    public final int $t;

    public C02720Cl(int i) {
        this.$t = i;
    }

    @Override // X.C0AT
    public final C0AX AGW() {
        switch (this.$t) {
            case 0:
                return C0AX.A08;
            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                return C0AX.A05;
            default:
                return C0AX.A06;
        }
    }

    @Override // X.C0AT
    public final Integer AL6() {
        switch (this.$t) {
            case 0:
                return AnonymousClass065.A0C;
            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                return AnonymousClass065.A00;
            default:
                return AnonymousClass065.A01;
        }
    }

    @Override // X.C0AT
    public final void AMX(C0AZ c0az) {
        HashMap mapA0C;
        String str;
        String str2;
        switch (this.$t) {
            case 0:
                Method method = AnonymousClass066.A03;
                Trace.beginSection("NativeJvmStreamConfig.jvmStreamEnabled");
                try {
                    try {
                        BreakpadManager.setJvmStreamEnabled(true);
                    } catch (Exception | UnsatisfiedLinkError e) {
                        C018108b.A0C("lacrima", "Error enabling jvm stream", e);
                        C0C5.A00();
                    }
                    return;
                } finally {
                    Trace.endSection();
                }
            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                synchronized (C09M.class) {
                }
                C04w c04w = c0az.A00;
                AnonymousClass053.A03(c04w, "Did you call earlyInit()?");
                C0C8 c0c8A00 = C0C8.A00();
                AnonymousClass057 anonymousClass057 = AnonymousClass057.LARGE_REPORT;
                InterfaceC02430Ba interfaceC02430BaA03 = c04w.A03(JavaCrashDetector.class);
                if (interfaceC02430BaA03 == null) {
                    HashMap mapA0C2 = AnonymousClass000.A0C();
                    mapA0C2.put("CollectorName", AnonymousClass045.A00(AnonymousClass065.A06));
                    mapA0C2.put("ReportCategory", anonymousClass057.A00);
                    C0C5.A00();
                    C018108b.A08("lacrima", "Cannot find registered detector");
                } else {
                    c04w.A04(c0c8A00, anonymousClass057, interfaceC02430BaA03);
                }
                C04w c04w2 = c0az.A00;
                AnonymousClass053.A03(c04w2, "Did you call earlyInit()?");
                C0C8 c0c8A002 = C0C8.A00();
                InterfaceC02430Ba interfaceC02430BaA032 = c04w2.A03(C03B.class);
                if (interfaceC02430BaA032 != null) {
                    c04w2.A04(c0c8A002, anonymousClass057, interfaceC02430BaA032);
                    return;
                }
                mapA0C = AnonymousClass000.A0C();
                mapA0C.put("CollectorName", AnonymousClass045.A00(AnonymousClass065.A06));
                str = "ReportCategory";
                str2 = anonymousClass057.A00;
                break;
            default:
                synchronized (C09M.class) {
                }
                C04w c04w3 = c0az.A00;
                AnonymousClass053.A03(c04w3, "Did you call earlyInit()?");
                C0C8 c0c8A003 = C0C8.A00();
                AnonymousClass057 anonymousClass0572 = AnonymousClass057.LARGE_REPORT;
                InterfaceC02430Ba interfaceC02430BaA033 = c04w3.A03(C03K.class);
                if (interfaceC02430BaA033 != null) {
                    c04w3.A04(c0c8A003, anonymousClass0572, interfaceC02430BaA033);
                    return;
                }
                mapA0C = AnonymousClass000.A0C();
                mapA0C.put("CollectorName", AnonymousClass045.A00(AnonymousClass065.A06));
                str = "ReportCategory";
                str2 = anonymousClass0572.A00;
                break;
        }
        mapA0C.put(str, str2);
        C0C5.A00();
        C018108b.A08("lacrima", "Cannot find registered detector");
    }
}
