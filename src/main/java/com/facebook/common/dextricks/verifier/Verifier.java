package com.facebook.common.dextricks.verifier;

import X.C0BG;
import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public class Verifier {
    public static boolean sDisabledRuntimeVerification;
    public static Boolean sHasNativeCode;
    public static boolean sTriedDisableRuntimeVerification;

    public static native boolean disableRuntimeVerificationWithInpainter();

    public static native boolean disableRuntimeVerification_6_0_1();

    public static native boolean disableRuntimeVerification_7_0_0();

    public static native boolean disableRuntimeVerification_7_1_2();

    public static native boolean disableRuntimeVerification_8_0_0();

    public static native boolean disableRuntimeVerification_8_1_0();

    public static native boolean disableRuntimeVerification_9_plus();

    public static synchronized boolean didDisableRuntimeVerification() {
        return sDisabledRuntimeVerification;
    }

    public static synchronized void disableRuntimeVerification(boolean z) {
        int i;
        boolean zDisableRuntimeVerification_9_plus;
        boolean zMaybeLoadVerifierLibrary = maybeLoadVerifierLibrary();
        if (!sTriedDisableRuntimeVerification && zMaybeLoadVerifierLibrary && (i = Build.VERSION.SDK_INT) >= 23) {
            if (i == 23) {
                zDisableRuntimeVerification_9_plus = disableRuntimeVerification_6_0_1();
                sDisabledRuntimeVerification = zDisableRuntimeVerification_9_plus;
            } else if (i == 24) {
                zDisableRuntimeVerification_9_plus = disableRuntimeVerification_7_0_0();
                sDisabledRuntimeVerification = zDisableRuntimeVerification_9_plus;
            } else if (i == 25) {
                zDisableRuntimeVerification_9_plus = disableRuntimeVerification_7_1_2();
                sDisabledRuntimeVerification = zDisableRuntimeVerification_9_plus;
            } else if (i == 26) {
                zDisableRuntimeVerification_9_plus = disableRuntimeVerification_8_0_0();
                sDisabledRuntimeVerification = zDisableRuntimeVerification_9_plus;
            } else if (i == 27) {
                zDisableRuntimeVerification_9_plus = disableRuntimeVerification_8_1_0();
                sDisabledRuntimeVerification = zDisableRuntimeVerification_9_plus;
            } else {
                zDisableRuntimeVerification_9_plus = disableRuntimeVerification_9_plus();
                sDisabledRuntimeVerification = zDisableRuntimeVerification_9_plus;
            }
            if (!zDisableRuntimeVerification_9_plus && i >= 24 && z) {
                forceDisableRuntimeVerificationWithInpainter();
            }
            sTriedDisableRuntimeVerification = true;
            if (!sDisabledRuntimeVerification) {
                Log.w("Verifier", "Could not disable RTV");
            }
        }
    }

    public static synchronized void forceDisableRuntimeVerificationWithInpainter() {
        if (!sDisabledRuntimeVerification) {
            sDisabledRuntimeVerification = disableRuntimeVerificationWithInpainter();
            sTriedDisableRuntimeVerification = true;
        }
    }

    public static synchronized boolean maybeLoadVerifierLibrary() {
        Boolean boolValueOf;
        boolean z;
        boolValueOf = sHasNativeCode;
        if (boolValueOf == null) {
            try {
                C0BG.A0A("verifier");
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
            boolValueOf = Boolean.valueOf(z);
            sHasNativeCode = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static synchronized boolean triedDisableRuntimeVerification() {
        return sTriedDisableRuntimeVerification;
    }

    public static synchronized void disableRuntimeVerification() {
        disableRuntimeVerification(false);
    }
}
