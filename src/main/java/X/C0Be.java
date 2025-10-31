package X;

import android.app.ActivityManager;
import android.app.ApplicationStartInfo;
import android.content.Context;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* renamed from: X.0Be, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C0Be {
    public static boolean A00(Context context) {
        HashSet hashSet = new HashSet(Arrays.asList(6, 7, 9, 11));
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List historicalProcessStartReasons = activityManager.getHistoricalProcessStartReasons(1);
            if (!historicalProcessStartReasons.isEmpty() && hashSet.contains(Integer.valueOf(((ApplicationStartInfo) historicalProcessStartReasons.get(0)).getReason()))) {
                return true;
            }
        }
        return false;
    }
}
