package X;

import android.util.Pair;

/* renamed from: X.08T, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C08T {
    public static C08Q A00;
    public static final int[] A01 = {4096};

    static {
        C08Q c08qA00 = C08S.A00();
        if (c08qA00 == null) {
            c08qA00 = C08R.A01();
        }
        A00 = c08qA00;
    }

    public static Pair A00() {
        String[] strArr = {null};
        return new Pair(strArr[0], Integer.valueOf(A00.Ah0("/proc/self/cmdline", A01, null, strArr)));
    }
}
