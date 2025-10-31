package X;

import com.facebook.systrace.Systrace;

/* renamed from: X.0A7, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C0A7 {
    public static volatile boolean A00;

    public static long A00(long j) {
        if ((1 & C01H.A01) != 0 && !A00) {
            A00 = true;
            Systrace.A03("fburl.com/fbsystrace");
            Systrace.A03("USE fbsystrace");
            Systrace.A03("DO NOT USE systrace");
        } else if (A00 && (1 & C01H.A01) == 0) {
            A00 = false;
        }
        return j - System.nanoTime();
    }
}
