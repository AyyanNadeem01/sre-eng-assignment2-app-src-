package X;

import android.content.Context;
import android.os.Process;
import java.util.Random;

/* renamed from: X.0Bd */
/* loaded from: classes.dex */
public abstract class C0Bd {
    public static final Random A00 = new Random();

    public static void A00(final Context context, final String str, final Throwable th, int i) {
        if (i == 1 || A00.nextInt(i) == 0) {
            A01(str, th);
            new Thread(new Runnable() { // from class: X.0Bv
                public static final String __redex_internal_original_name = "EarlySoftErrorReporting$1";

                @Override // java.lang.Runnable
                public final void run() {
                    C0Bd.A02(str, th);
                }
            }, "primaryDexError").start();
        }
    }

    public static void A01(String str, Throwable th) {
        Object[] objArr = {str};
        if (th != null) {
            C018108b.A0G("EarlySoftErrorReporting", "SOFT ERROR %s", th, objArr);
        } else {
            C018108b.A0J("EarlySoftErrorReporting", "SOFT ERROR %s", objArr);
        }
    }

    public static void A02(String str, Throwable th) {
        try {
            Process.setThreadPriority(10);
            C0C3.A03(str, th == null ? AnonymousClass000.A04(str) : th, (short) 756);
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
            C018108b.A0C("EarlySoftErrorReporting", "Unable to report soft error", th);
        }
    }
}
