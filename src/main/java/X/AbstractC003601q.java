package X;

import android.os.Trace;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: X.01q, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC003601q {
    public static AtomicBoolean A00 = new AtomicBoolean(false);

    public static void A00() {
        boolean zIsEnabled = Trace.isEnabled();
        if (A00.compareAndSet(!zIsEnabled, zIsEnabled)) {
            C01H.A01(false);
        }
    }
}
