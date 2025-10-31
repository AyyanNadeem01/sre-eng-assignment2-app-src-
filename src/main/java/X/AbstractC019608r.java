package X;

import android.app.ActivityThread;

/* renamed from: X.08r, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC019608r {
    public static ActivityThread A00;

    public static final ActivityThread A00() {
        ActivityThread activityThread = A00;
        if (activityThread != null) {
            return activityThread;
        }
        ActivityThread activityThreadCurrentActivityThread = ActivityThread.currentActivityThread();
        A00 = activityThreadCurrentActivityThread;
        return activityThreadCurrentActivityThread;
    }
}
