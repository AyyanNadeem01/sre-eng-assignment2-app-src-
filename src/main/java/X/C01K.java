package X;

import android.os.Process;
import com.facebook.systrace.Systrace;

/* renamed from: X.01K, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C01K {
    public static final C01K $redex_init_class = null;

    static {
        C01H.A00(new C01M());
    }

    public static void A00() {
        if ((64 & C01H.A01) != 0) {
            Systrace.A0D("thread_name", Process.myTid(), Thread.currentThread().getName());
        }
    }
}
