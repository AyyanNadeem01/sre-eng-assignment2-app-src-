package X;

import android.os.Binder;
import android.os.Build;
import android.os.Process;

/* renamed from: X.09d, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C020509d {
    public final int A00;

    public C020509d(int i) {
        this.A00 = i;
    }

    public static C020509d A00() {
        if (Binder.getCallingPid() == Process.myPid()) {
            throw new SecurityException("This method must be called on behalf of an IPC transaction from binder thread.");
        }
        int callingUidOrThrow = Build.VERSION.SDK_INT >= 29 ? Binder.getCallingUidOrThrow() : Binder.getCallingUid();
        Binder.getCallingPid();
        return new C020509d(callingUidOrThrow);
    }
}
