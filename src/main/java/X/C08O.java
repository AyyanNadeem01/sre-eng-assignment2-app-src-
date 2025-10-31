package X;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

/* renamed from: X.08O, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C08O {
    public static String A00;
    public static final Object A01 = new Object();

    public static final String A00(Context context) {
        C06E.A07(context, 0);
        synchronized (A01) {
            String processName = A00;
            if (processName != null) {
                return processName;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                A00 = processName;
            }
            if (processName == null) {
                int iMyPid = Process.myPid();
                Object systemService = context.getSystemService("activity");
                C06E.A08(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == iMyPid) {
                            A00 = next.processName;
                            break;
                        }
                    }
                }
            }
            String string = A00;
            if (string == null) {
                string = (String) C08T.A00().first;
                A00 = string;
                if (string != null) {
                    int length = string.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length) {
                        int i2 = length;
                        if (!z) {
                            i2 = i;
                        }
                        boolean z2 = C06E.A00(string.charAt(i2), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    string = string.subSequence(i, length + 1).toString();
                    A00 = string;
                }
            }
            if (string == null) {
                string = "unknown";
                A00 = "unknown";
            }
            return string;
        }
    }

    public static final String A01(Context context) {
        C06E.A07(context, 0);
        String[] strArrSplit = TextUtils.split(A00(context), ":");
        C06E.A03(strArrSplit);
        return strArrSplit.length > 1 ? strArrSplit[1] : "";
    }
}
