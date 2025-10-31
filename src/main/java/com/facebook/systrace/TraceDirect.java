package com.facebook.systrace;

import X.AnonymousClass000;
import X.C01F;
import X.C01H;
import X.C01I;
import X.C07O;
import X.C09L;
import X.C09N;
import X.C0B2;
import X.C0BR;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class TraceDirect {
    public static final String TAG = "TraceDirect";
    public static volatile int sPrevSoLoaderSourcesVersion = -1;
    public static final boolean sForceJavaImpl = "true".equals(C07O.A02("debug.fbsystrace.force_java"));
    public static final boolean sTraceLoad = "true".equals(C07O.A02("debug.fbsystrace.trace_load"));
    public static volatile C01F sNativeAvailable = C01F.UNSET;

    public static native void nativeAsyncTraceBegin(String str, int i, long j);

    public static native void nativeAsyncTraceCancel(String str, int i);

    public static native void nativeAsyncTraceEnd(String str, int i, long j);

    public static native void nativeAsyncTraceRename(String str, String str2, int i);

    public static native void nativeAsyncTraceStageBegin(String str, int i, long j, String str2);

    public static native void nativeBeginSection(String str);

    public static native void nativeBeginSectionWithArgs(String str, String[] strArr, int i);

    public static native void nativeEndAsyncFlow(String str, int i);

    public static native void nativeEndSection();

    public static native void nativeEndSectionWithArgs(String[] strArr, int i);

    public static native void nativeSetDefaultTags(long j);

    public static native void nativeSetEnabledTags(long j);

    public static native void nativeStartAsyncFlow(String str, int i);

    public static native void nativeStepAsyncFlow(String str, int i);

    public static native void nativeTraceCounter(String str, int i);

    public static native void nativeTraceInstant(String str, String str2, char c);

    public static native void nativeTraceMetadata(String str, String str2, int i);

    public static boolean checkNative() {
        boolean z;
        int iAJR;
        C0BR c0br;
        if (sNativeAvailable == C01F.UNSET) {
            if (sForceJavaImpl) {
                sNativeAvailable = C01F.NO;
            } else {
                synchronized (C0B2.class) {
                    z = C0B2.A00 != null;
                }
                if (z) {
                    synchronized (C0B2.class) {
                        c0br = C0B2.A00;
                        if (c0br == null) {
                            throw AnonymousClass000.A04("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
                        }
                    }
                    iAJR = c0br.AJR();
                } else {
                    iAJR = -1;
                }
                if (iAJR != sPrevSoLoaderSourcesVersion) {
                    sPrevSoLoaderSourcesVersion = iAJR;
                    Object[] objArr = new Object[2];
                    AnonymousClass000.A0N(objArr, sPrevSoLoaderSourcesVersion, 0);
                    AnonymousClass000.A0N(objArr, iAJR, 1);
                    String.format("Attempting to load fbsystrace.so [%d|%d].", objArr);
                    try {
                        C0B2.A00("fbsystrace");
                        C01I c01i = C01H.A00;
                        nativeSetEnabledTags(C07O.A00("debug.fbsystrace.tags"));
                        nativeBeginSection("fbsystrace.so loaded");
                        nativeEndSection();
                        sNativeAvailable = C01F.YES;
                    } catch (UnsatisfiedLinkError unused) {
                        sNativeAvailable = C01F.NO;
                        Log.w(TAG, "fbsystrace.so could not be loaded - switching to Java implementation.");
                    }
                }
            }
        }
        return sNativeAvailable == C01F.YES;
    }

    public static void asyncTraceBegin(String str, int i, long j) {
        if (checkNative()) {
            nativeAsyncTraceBegin(str, i, j);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str, 'S');
        c09nA00.A03("<0>");
        AnonymousClass000.A0D(c09nA00, (j > 0L ? 1 : (j == 0L ? 0 : -1)), j);
        c09nA00.A02(i);
        C09N.A01(c09nA00);
    }

    public static void asyncTraceCancel(String str, int i) throws IOException {
        if (checkNative()) {
            nativeAsyncTraceCancel(str, i);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str, 'F');
        c09nA00.A03("<X>");
        c09nA00.A02(i);
        C09N.A01(c09nA00);
    }

    public static void asyncTraceEnd(String str, int i, long j) {
        if (checkNative()) {
            nativeAsyncTraceEnd(str, i, j);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str, 'F');
        AnonymousClass000.A0D(c09nA00, (j > 0L ? 1 : (j == 0L ? 0 : -1)), j);
        c09nA00.A02(i);
        C09N.A01(c09nA00);
    }

    public static void asyncTraceRename(String str, String str2, int i) {
        if (checkNative()) {
            nativeAsyncTraceRename(str, str2, i);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str, 'F');
        c09nA00.A03("<M>");
        c09nA00.A02(i);
        c09nA00.A00.append('|');
        c09nA00.A03(str2);
        C09N.A01(c09nA00);
    }

    public static void asyncTraceStageBegin(String str, int i, long j, String str2) {
        if (checkNative()) {
            nativeAsyncTraceStageBegin(str, i, j, str2);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str, 'T');
        AnonymousClass000.A0D(c09nA00, (j > 0L ? 1 : (j == 0L ? 0 : -1)), j);
        c09nA00.A02(i);
        c09nA00.A00.append('|');
        c09nA00.A03(str2);
        C09N.A01(c09nA00);
    }

    public static void beginSection(String str) {
        if (checkNative()) {
            nativeBeginSection(str);
        } else {
            FileOutputStream fileOutputStream = C09L.A00;
            C09N.A01(C09N.A00(str, 'B'));
        }
    }

    public static void beginSectionWithArgs(String str, String[] strArr, int i) {
        if (checkNative()) {
            nativeBeginSectionWithArgs(str, strArr, i);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str, 'B');
        c09nA00.A04(strArr, i);
        C09N.A01(c09nA00);
    }

    public static void endAsyncFlow(String str, int i) {
        if (checkNative()) {
            nativeEndAsyncFlow(str, i);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str, 'f');
        c09nA00.A02(i);
        C09N.A01(c09nA00);
    }

    public static void endSection() {
        if (checkNative()) {
            nativeEndSection();
        } else {
            C09L.A00("E");
        }
    }

    public static void endSectionWithArgs(String[] strArr, int i) throws IOException {
        if (checkNative()) {
            nativeEndSectionWithArgs(strArr, i);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09n = new C09N('E');
        StringBuilder sb = c09n.A00;
        sb.append('|');
        sb.append('|');
        c09n.A04(strArr, i);
        C09L.A00(sb.toString());
    }

    public static void setDefaultTags(long j) {
        if (checkNative()) {
            nativeSetDefaultTags(j);
        }
    }

    public static void setEnabledTags(long j) {
        if (checkNative()) {
            nativeSetEnabledTags(j);
        }
    }

    public static void startAsyncFlow(String str, int i) {
        if (checkNative()) {
            nativeStartAsyncFlow(str, i);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str, 's');
        c09nA00.A02(i);
        C09N.A01(c09nA00);
    }

    public static void stepAsyncFlow(String str, int i) {
        if (checkNative()) {
            nativeStepAsyncFlow(str, i);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str, 't');
        c09nA00.A02(i);
        C09N.A01(c09nA00);
    }

    public static void traceCounter(String str, int i) {
        if (checkNative()) {
            nativeTraceCounter(str, i);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str, 'C');
        c09nA00.A02(i);
        C09N.A01(c09nA00);
    }

    public static void traceInstant(String str, String str2, char c) {
        if (checkNative()) {
            nativeTraceInstant(str, str2, c);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str2, 'I');
        StringBuilder sb = c09nA00.A00;
        sb.append('|');
        if (c == 0 || c == '\r' || c == ';' || c == '|' || c == '\t' || c == '\n') {
            c = ' ';
        }
        sb.append(c);
        sb.append('|');
        c09nA00.A03(str);
        C09L.A00(sb.toString());
    }

    public static void traceMetadata(String str, String str2, int i) {
        if (checkNative()) {
            nativeTraceMetadata(str, str2, i);
            return;
        }
        FileOutputStream fileOutputStream = C09L.A00;
        C09N c09nA00 = C09N.A00(str, 'M');
        c09nA00.A02(i);
        c09nA00.A00.append('|');
        c09nA00.A03(str2);
        C09N.A01(c09nA00);
    }
}
