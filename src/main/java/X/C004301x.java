package X;

import android.os.ConditionVariable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: X.01x, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C004301x {
    public final ExecutorService A01;
    public final ConditionVariable A00 = new ConditionVariable(true);
    public final AtomicBoolean A02 = new AtomicBoolean(false);
    public final AtomicLong A03 = new AtomicLong(-1);

    public C004301x() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        C06E.A03(executorServiceNewSingleThreadExecutor);
        this.A01 = executorServiceNewSingleThreadExecutor;
    }
}
