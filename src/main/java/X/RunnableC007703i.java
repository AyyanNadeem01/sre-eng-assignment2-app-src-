package X;

import com.facebook.acra.anr.sigquit.SigquitDetectorLacrima;

/* renamed from: X.03i, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC007703i implements Runnable {
    public static final String __redex_internal_original_name = "SigquitDetectorLacrima$1";
    public final /* synthetic */ SigquitDetectorLacrima A00;

    public RunnableC007703i(SigquitDetectorLacrima sigquitDetectorLacrima) {
        this.A00 = sigquitDetectorLacrima;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zNativeHookMethods = SigquitDetectorLacrima.nativeHookMethods();
        this.A00.mListener.AWk();
        if (zNativeHookMethods) {
            SigquitDetectorLacrima.nativeStartDetector();
        }
    }
}
