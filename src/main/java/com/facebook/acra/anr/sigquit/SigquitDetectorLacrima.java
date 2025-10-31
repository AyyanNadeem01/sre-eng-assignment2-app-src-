package com.facebook.acra.anr.sigquit;

import X.C018108b;
import X.InterfaceC007303b;
import X.InterfaceC007603e;
import android.os.Handler;

/* loaded from: classes.dex */
public class SigquitDetectorLacrima implements InterfaceC007603e {
    public static InterfaceC007603e sInstance;
    public static boolean sIsArt;
    public InterfaceC007303b mListener;
    public Handler mMainThreadHandler;

    public static native void nativeAddSignalHandler();

    public static native void nativeCleanupAppStateFile();

    public static native boolean nativeHookMethods();

    public static native void nativeInit(Object obj, boolean z, int i, String str, String str2, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str5, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11);

    public static native void nativeSendNextSigquitTraceUnconditionally();

    public static native void nativeStartDetector();

    public static native void nativeStopDetector();

    public static native void nativeWaitForSignal();

    /* JADX WARN: Removed duplicated region for block: B:6:0x002e  */
    @Override // X.InterfaceC007603e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(X.C000600j r22, boolean r23) {
        /*
            r21 = this;
            r11 = 1
            java.lang.String r1 = "SigquitDetectorLacrima"
            java.lang.String r0 = "nativeInit"
            X.C018108b.A08(r1, r0)
            r2 = r22
            android.os.Handler r0 = r2.A03
            r3 = r21
            r3.mMainThreadHandler = r0
            r13 = 0
            boolean r4 = com.facebook.acra.anr.sigquit.SigquitDetectorLacrima.sIsArt
            int r5 = android.os.Build.VERSION.SDK_INT
            java.lang.String r6 = ""
            java.lang.String r8 = r2.A06
            java.lang.String r9 = ".stacktrace"
            java.lang.String r1 = r2.A05
            java.lang.String r0 = ":"
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L2e
            java.lang.String r0 = ":browser"
            boolean r0 = r1.endsWith(r0)
            r10 = 0
            if (r0 == 0) goto L2f
        L2e:
            r10 = 1
        L2f:
            java.lang.String r15 = r2.A00()
            r7 = r6
            r12 = r11
            r14 = r13
            r16 = r13
            r17 = r13
            r18 = r13
            r19 = r13
            r20 = r13
            nativeInit(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.acra.anr.sigquit.SigquitDetectorLacrima.init(X.00j, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    static {
        /*
            java.lang.String r0 = "java.vm.version"
            java.lang.String r1 = java.lang.System.getProperty(r0)
            if (r1 == 0) goto L19
            java.lang.String r0 = "1."
            boolean r0 = r1.startsWith(r0)
            if (r0 != 0) goto L19
            java.lang.String r0 = "0."
            boolean r1 = r1.startsWith(r0)
            r0 = 1
            if (r1 == 0) goto L1a
        L19:
            r0 = 0
        L1a:
            com.facebook.acra.anr.sigquit.SigquitDetectorLacrima.sIsArt = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.acra.anr.sigquit.SigquitDetectorLacrima.<clinit>():void");
    }

    private void onSigquit(boolean z, long j, long j2, long j3) {
        this.mListener.Ac3(z, j, j2, j3);
    }

    private void onSigquitTracesAvailable(String str, String str2, boolean z, boolean z2) {
        C018108b.A0K("SigquitDetectorLacrima", "sigquitDetected inFgV1: %b inFgV2: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        this.mListener.Ac5(str, str2, z, z2);
    }
}
