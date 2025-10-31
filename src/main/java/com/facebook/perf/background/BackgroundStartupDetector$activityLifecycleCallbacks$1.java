package com.facebook.perf.background;

import X.C02420Az;
import X.C06E;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class BackgroundStartupDetector$activityLifecycleCallbacks$1 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ BackgroundStartupDetector A00;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        C06E.A07(activity, 0);
        BackgroundStartupDetector backgroundStartupDetector = this.A00;
        String simpleName = activity.getClass().getSimpleName();
        C06E.A03(simpleName);
        backgroundStartupDetector.activityCreateInternal(simpleName);
    }

    public BackgroundStartupDetector$activityLifecycleCallbacks$1(BackgroundStartupDetector backgroundStartupDetector) {
        this.A00 = backgroundStartupDetector;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        BackgroundStartupDetector backgroundStartupDetector = this.A00;
        backgroundStartupDetector.activityResumeCount--;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.A00.activityResumeCount++;
        BackgroundStartupDetector.isBackgroundedNotYetResumed = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        BackgroundStartupDetector backgroundStartupDetector = this.A00;
        backgroundStartupDetector.activityStartCount++;
        backgroundStartupDetector.activitiesStartedSinceLastColdStartQueueDrain++;
        C02420Az.A02(false);
        backgroundStartupDetector.handler.removeMessages(BackgroundStartupDetector.ACTIVITY_CREATE_QUEUE_DRAINED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        BackgroundStartupDetector backgroundStartupDetector = this.A00;
        int i = backgroundStartupDetector.activityStartCount - 1;
        backgroundStartupDetector.activityStartCount = i;
        if (i == 0 && backgroundStartupDetector.activityResumeCount == 0 && !backgroundStartupDetector.activityIsRecreating) {
            BackgroundStartupDetector.backgroundedCount++;
            BackgroundStartupDetector.isBackgroundedNotYetResumed = true;
            C02420Az.A02(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }
}
