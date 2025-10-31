package X;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: X.09v, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class ThreadFactoryC021909v implements ThreadFactory {
    public final int A00;
    public final String A01;
    public final AtomicInteger A02 = new AtomicInteger(1);

    public ThreadFactoryC021909v(String str, int i) {
        this.A01 = str;
        this.A00 = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable runnable) {
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("Lacrima_");
        sbA09.append(this.A01);
        sbA09.append("_");
        sbA09.append(this.A02.getAndIncrement());
        C0BX c0bx = C019908u.A04;
        if (c0bx != null) {
            sbA09.append(":");
            String str = c0bx.A02;
            if (str == null) {
                str = "unknown";
            }
            sbA09.append(str);
        }
        final String string = sbA09.toString();
        return new Thread(string) { // from class: X.09u
            public static final String __redex_internal_original_name = "LacrimaExecutors$NamedThreadFactory$1";

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    Process.setThreadPriority(this.A00.A00);
                } catch (Throwable unused) {
                    C0C5.A00();
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        };
    }
}
