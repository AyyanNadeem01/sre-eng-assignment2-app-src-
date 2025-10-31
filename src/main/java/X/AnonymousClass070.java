package X;

import android.os.Build;
import dalvik.system.VMRuntime;

/* renamed from: X.070, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass070 {
    public static final String A01() {
        return VMRuntime.getRuntime().vmInstructionSet();
    }

    public static final int A00() {
        return Build.VERSION.SDK_INT;
    }
}
