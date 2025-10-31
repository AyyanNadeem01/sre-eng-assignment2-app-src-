package X;

import android.app.Application;
import com.facebook.errorreporting.lacrima.common.check.DirectReports;
import java.lang.Thread;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* renamed from: X.0Ac */
/* loaded from: classes.dex */
public final class C02260Ac {
    public static final Object A02 = new Object();
    public static volatile C02260Ac A03;
    public Application A00;
    public boolean A01;

    public static void A00(Application application, String str, final Callable callable, final Callable callable2, Callable callable3) {
        if (A03 == null) {
            synchronized (A02) {
                if (A03 == null) {
                    final C02260Ac c02260Ac = new C02260Ac();
                    c02260Ac.A01 = false;
                    try {
                        c02260Ac.A00 = application;
                        if (str == null) {
                            str = "";
                        }
                        CallableC02680Ch callableC02680Ch = new CallableC02680Ch(c02260Ac, 0);
                        synchronized (C021209l.A0D) {
                            C021209l.A06 = application;
                            C021209l.A03 = str;
                            C021209l.A09 = callable2;
                            C021209l.A0B = callableC02680Ch;
                            C021209l.A0A = callable3;
                            C021209l.A0C = false;
                        }
                        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: X.0Aj
                            @Override // java.lang.Thread.UncaughtExceptionHandler
                            public final void uncaughtException(Thread thread, Throwable th) {
                                try {
                                    if (this.A00.A01) {
                                        try {
                                            DirectReports.A00((String) callable2.call(), null, null, (String) callable.call(), th, AnonymousClass000.A0C());
                                        } catch (Exception e) {
                                            C018108b.A0B("EarlyExceptionHandler", "Failed sending direct reports", e);
                                        }
                                    }
                                } catch (Exception e2) {
                                    C018108b.A0B("EarlyExceptionHandler", "Exception in uncaught handler", e2);
                                }
                                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = defaultUncaughtExceptionHandler;
                                if (uncaughtExceptionHandler != null) {
                                    uncaughtExceptionHandler.uncaughtException(thread, th);
                                }
                            }
                        });
                        C018108b.A08("EarlyExceptionHandler", "Early UncaughtException handler initialized");
                    } catch (Exception e) {
                        C018108b.A0D("EarlyExceptionHandler", "Failed to setup Early UncaughtException handler", e);
                    }
                    A03 = c02260Ac;
                }
            }
        }
    }

    public static void A01(String str, String str2, String str3, Throwable th) {
        try {
            HashMap mapA0C = AnonymousClass000.A0C();
            if (str2 != null) {
                mapA0C.put("app_id", str2);
            }
            if (th != null) {
                mapA0C.put("cause", C08v.A01(th));
            }
            mapA0C.put("free_internal_disk_space_bytes", Long.toString(AnonymousClass050.A00()));
            HashMap mapA0C2 = AnonymousClass000.A0C();
            mapA0C2.putAll(mapA0C);
            C021209l.A03(str3, null, null, null, mapA0C2);
            C021209l.A04("fallback_reporter", mapA0C2, str);
            C021209l.A05(mapA0C2);
            C021209l.A00().A06("android_large_soft_error", mapA0C2);
        } catch (Exception e) {
            C018108b.A0B("EarlyExceptionHandler", "Failed sending director soft error report", e);
        }
    }
}
