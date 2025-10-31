package com.facebook.errorreporting.lacrima.common.asl.aslnative;

import X.AnonymousClass000;
import X.AnonymousClass057;
import X.AnonymousClass066;
import X.AnonymousClass089;
import X.AnonymousClass094;
import X.C018108b;
import X.C019908u;
import X.C08Z;
import X.C0AC;
import X.C0AI;
import X.C0BG;
import X.InterfaceC009404d;
import android.content.Context;
import android.os.Trace;
import com.facebook.errorreporting.field.ReportFieldString;
import com.facebook.errorreporting.lacrima.common.asl.aslnative.AppStateLoggerNative;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
public class AppStateLoggerNative {
    public static final String TAG = "AppStateLoggerNative";
    public static volatile boolean sAppStateLoggerNativeInited = false;
    public static volatile int sSelfSignalFunctionsSuccessfullyHooked = -1;

    public static native void appInForeground(boolean z, boolean z2);

    public static native void disableSelfSigkillHandlers();

    public static native void enableSelfSigkillHandlingForFADv2();

    public static native boolean isShuttingDownNative();

    public static native void registerForMonitoringThreadLocalKeys(String str);

    public static native boolean registerOomHandler();

    public static native int registerSelfSigkillHandlers();

    public static native void registerStreamWithBreakpad();

    public static native void registerWithNativeCrashHandler(String str, String str2, String str3, String str4, boolean z);

    public static native void replaceThreadLocalImplementation();

    public static native void selfSigkillWithoutUpdatingAppStateLogStatus();

    public static native void setBreakpadStreamDataNative(byte[] bArr);

    public static synchronized int getSelfSignalFunctionsSuccessfullyHooked() {
        return sSelfSignalFunctionsSuccessfullyHooked;
    }

    public static boolean isHandlingShutdown() {
        if (sAppStateLoggerNativeInited) {
            return isShuttingDownNative();
        }
        return false;
    }

    public static synchronized void setAppInForeground(boolean z) {
        if (sAppStateLoggerNativeInited) {
            appInForeground(z, z);
        } else {
            C018108b.A08(TAG, "AppStateLoggerNative.initializeNativeCrashReporting not called.");
        }
    }

    public static void setBreakpadStreamData(byte[] bArr) {
        if (!sAppStateLoggerNativeInited) {
            C018108b.A08(TAG, "AppStateLoggerNative.initializeNativeCrashReporting not called.  setBreakpadStreamData will most likely crash.");
        }
        setBreakpadStreamDataNative(bArr);
    }

    public static void initializeNativeCrashReporting(File file, Context context, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        if (!sAppStateLoggerNativeInited) {
            String path = AnonymousClass000.A02(file, "native_state.txt").getPath();
            String path2 = AnonymousClass000.A02(file, "anr_state.txt").getPath();
            String path3 = AnonymousClass000.A02(file, "dump_state.txt").getPath();
            String path4 = "";
            if (z7) {
                path4 = AnonymousClass000.A02(file, "allocator_type.txt").getPath();
            }
            C0BG.A0A("appstatelogger2");
            Method method = AnonymousClass066.A03;
            Trace.beginSection("registerWithNativeCrashHandler");
            try {
                registerWithNativeCrashHandler(path, path2, path3, path4, z4);
                Trace.endSection();
                Trace.beginSection("registerStreamWithBreakpad");
                registerStreamWithBreakpad();
                Trace.endSection();
                Trace.beginSection("registerOomHandler");
                registerOomHandler();
                Trace.endSection();
                if (z2) {
                    Trace.beginSection("registerSelfSigkill");
                    sSelfSignalFunctionsSuccessfullyHooked = registerSelfSigkillHandlers();
                    if (z3) {
                        enableSelfSigkillHandlingForFADv2();
                    }
                    if (AnonymousClass089.A01() != null) {
                        Runnable runnable = new Runnable() { // from class: X.09h
                            public static final String __redex_internal_original_name = "AppStateLoggerNative$1";

                            @Override // java.lang.Runnable
                            public final void run() {
                                AppStateLoggerNative.selfSigkillWithoutUpdatingAppStateLogStatus();
                            }
                        };
                        AnonymousClass089.A04 = runnable;
                        synchronized (C08Z.class) {
                            C08Z.A00 = runnable;
                        }
                        AnonymousClass089.A03(new InterfaceC009404d() { // from class: X.09i
                            @Override // X.InterfaceC009404d
                            public final void ALl(Thread thread, Throwable th) {
                                AppStateLoggerNative.disableSelfSigkillHandlers();
                            }
                        }, 100);
                    }
                    if (C019908u.A04 != null) {
                        ReportFieldString reportFieldString = AnonymousClass094.A9w;
                        String string = Integer.toString(getSelfSignalFunctionsSuccessfullyHooked());
                        List list = C0AI.A02;
                        C0AI.A00(new C0AC(reportFieldString, AnonymousClass057.CRITICAL_REPORT, string));
                    }
                    Trace.endSection();
                }
                if (z6) {
                    Trace.beginSection("replaceThreadLocalImpl");
                    replaceThreadLocalImplementation();
                }
                if (z5) {
                    Trace.beginSection("registerForMonitoringThreadLocalKeys");
                    registerForMonitoringThreadLocalKeys(AnonymousClass000.A02(file, "tls_report.txt").getPath());
                }
                synchronized (AppStateLoggerNative.class) {
                    appInForeground(z, z);
                    sAppStateLoggerNativeInited = true;
                }
            } finally {
                Trace.endSection();
            }
        }
    }
}
