package com.facebook.common.time;

import X.C01B;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class AwakeTimeSinceBootClock implements C01B {
    public static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    @Override // X.C01A
    public /* synthetic */ long now() {
        return TimeUnit.NANOSECONDS.toMillis(nowNanos());
    }

    @Override // X.C01A
    public long nowNanos() {
        return System.nanoTime();
    }

    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }
}
