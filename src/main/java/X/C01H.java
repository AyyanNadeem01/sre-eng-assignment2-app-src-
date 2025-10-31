package X;

import android.os.Build;
import com.facebook.systrace.TraceDirect;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

/* renamed from: X.01H, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C01H {
    public static C01I A00 = new C01I();
    public static volatile long A01;

    static {
        A01(false);
        if (Build.VERSION.SDK_INT < 30) {
            Runnable runnable = new Runnable() { // from class: X.02b
                public static final String __redex_internal_original_name = "TraceConfig$1";

                @Override // java.lang.Runnable
                public final void run() {
                    C01H.A01(true);
                }
            };
            if (C07O.A06) {
                C07O.A01(C07O.A00, runnable);
            }
        }
    }

    public static void A00(C01L c01l) {
        C01I c01i = A00;
        synchronized (c01i.A01) {
            c01i.A02.add(c01l);
            if (c01i.A00) {
                c01l.Adp();
            }
        }
    }

    public static void A01(boolean z) {
        boolean zBooleanValue;
        long j = A01;
        if (Build.VERSION.SDK_INT >= 30) {
            zBooleanValue = C01J.A00();
        } else {
            long j2 = C07Q.A00;
            zBooleanValue = false;
            if (C07Q.A03) {
                Method method = C07Q.A01;
                C0CN.A00(method);
                Boolean bool = (Boolean) C07Q.A00(method, Long.valueOf(j2));
                if (bool != null) {
                    zBooleanValue = bool.booleanValue();
                }
            }
        }
        long jA00 = C07O.A00("debug.fbsystrace.tags");
        long j3 = (!zBooleanValue || jA00 == 0) ? 0L : jA00 | 1;
        boolean z2 = (A01 == 0 && j3 != 0) || (j3 == 0 && A01 != 0);
        A01 = j3;
        Object[] objArr = new Object[4];
        objArr[0] = z ? "sysprop" : "other";
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Long.valueOf(j);
        objArr[3] = Long.valueOf(A01);
        String.format("Systrace trace config update - source:%s changed:%b enabledTags:0x%x->0x%x", objArr);
        if (z2) {
            TraceDirect.setEnabledTags(j3);
            boolean z3 = z;
            final C01I c01i = A00;
            if (j3 <= 0) {
                synchronized (c01i.A01) {
                    c01i.A00 = false;
                    int i = 0;
                    while (true) {
                        List list = c01i.A02;
                        if (i < list.size()) {
                            ((C01L) list.get(i)).Adr();
                            i++;
                        }
                    }
                }
                return;
            }
            if (!z3) {
                c01i.A00();
                return;
            }
            synchronized (c01i.A01) {
                final long jLastModified = C01I.A03.lastModified();
                Thread thread = new Thread(new Runnable() { // from class: X.09G
                    public static final String __redex_internal_original_name = "TraceListenerNotifier$1";

                    @Override // java.lang.Runnable
                    public final void run() {
                        C01I c01i2 = c01i;
                        File file = C01I.A03;
                        synchronized (c01i2.A01) {
                            if (Build.VERSION.SDK_INT >= 23) {
                                try {
                                    Thread.sleep(100L);
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                }
                            } else {
                                while (C01I.A03.lastModified() == jLastModified) {
                                }
                            }
                            c01i2.A00();
                        }
                    }
                }, "fbsystrace notification thread");
                thread.setPriority(10);
                thread.start();
            }
        }
    }
}
