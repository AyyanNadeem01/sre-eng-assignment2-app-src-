package X;

import android.os.Handler;
import com.facebook.acra.anr.sigquit.SigquitDetectorLacrima;

/* renamed from: X.03j, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC007803j implements Runnable {
    public static final String __redex_internal_original_name = "SigquitDetectorLacrima$3";
    public final /* synthetic */ Handler A00;
    public final /* synthetic */ SigquitDetectorLacrima A01;
    public final /* synthetic */ Runnable A02;

    public RunnableC007803j(Handler handler, SigquitDetectorLacrima sigquitDetectorLacrima, Runnable runnable) {
        this.A01 = sigquitDetectorLacrima;
        this.A00 = handler;
        this.A02 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SigquitDetectorLacrima.nativeAddSignalHandler();
        this.A00.post(this.A02);
    }
}
