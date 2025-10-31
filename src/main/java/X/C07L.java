package X;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Build;

/* renamed from: X.07L, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C07L {
    public static final boolean A00(AlarmManager alarmManager, Context context) {
        C06E.A07(context, 0);
        C06E.A07(alarmManager, 1);
        boolean z = context.getApplicationInfo().targetSdkVersion > 30;
        boolean z2 = Build.VERSION.SDK_INT > 30;
        if (!z || !z2) {
            return true;
        }
        try {
            return alarmManager.canScheduleExactAlarms();
        } catch (RuntimeException e) {
            C018108b.A0B("AndroidCompat", "failed to check canScheduleExactAlarms. Reverting to false", e);
            return false;
        }
    }
}
