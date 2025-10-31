package X;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: X.09w, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C022009w {
    public static ExecutorService A00;
    public static ExecutorService A01;
    public static final ExecutorService A02;
    public static final ExecutorService A03;
    public static final ExecutorService A04;
    public static final ExecutorService A05;
    public static final ScheduledExecutorService A06;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        A04 = new ThreadPoolExecutor(0, 1, 15L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC021909v("main", 5));
        A05 = new ThreadPoolExecutor(1, 1, 15L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC021909v("single", 0));
        A03 = new ThreadPoolExecutor(1, 10, 10L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC021909v("init", -4));
        A02 = new ThreadPoolExecutor(0, 1, 10L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC021909v("startup", 0));
        A06 = new ScheduledThreadPoolExecutor(3, new ThreadFactoryC021909v("scheduled", 10));
    }

    public static ExecutorService A00() {
        if (A01 == null) {
            synchronized (C022009w.class) {
                ExecutorService executorService = A01;
                if (executorService != null) {
                    return executorService;
                }
                A01 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC021909v("sender", 10));
            }
        }
        return A01;
    }

    public static synchronized ExecutorService A01() {
        ExecutorService threadPoolExecutor;
        threadPoolExecutor = A00;
        if (threadPoolExecutor == null) {
            threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC021909v("background", 10));
            A00 = threadPoolExecutor;
        }
        return threadPoolExecutor;
    }
}
