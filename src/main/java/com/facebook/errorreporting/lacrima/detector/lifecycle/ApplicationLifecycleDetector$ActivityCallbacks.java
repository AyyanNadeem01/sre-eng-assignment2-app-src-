package com.facebook.errorreporting.lacrima.detector.lifecycle;

import X.AnonymousClass065;
import X.C05I;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes.dex */
public class ApplicationLifecycleDetector$ActivityCallbacks implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ C05I A00;

    public ApplicationLifecycleDetector$ActivityCallbacks(C05I c05i) {
        this.A00 = c05i;
    }

    public final void A01(Activity activity, Integer num) {
        C05I c05i = this.A00;
        synchronized (c05i.A0F) {
            if (Build.VERSION.SDK_INT < 29 || num.equals(AnonymousClass065.A01)) {
                C05I.A00(activity, c05i);
                c05i.A06.A00(AnonymousClass065.A0Y, activity);
            }
            Intent intent = activity.getIntent();
            c05i.A02(activity, num, intent == null ? "Null intent" : intent.toString(), activity.isFinishing());
        }
        synchronized (C05I.A0K) {
        }
    }

    public final void A02(Activity activity, Integer num) {
        C05I c05i = this.A00;
        synchronized (c05i.A0F) {
            if (Build.VERSION.SDK_INT < 29 || num.equals(AnonymousClass065.A01)) {
                C05I.A00(null, c05i);
                c05i.A06.A00(AnonymousClass065.A0u, activity);
            }
            C05I.A01(activity, c05i, num);
        }
    }

    public final void A03(Activity activity, Integer num) {
        C05I c05i = this.A00;
        synchronized (c05i.A0F) {
            if (Build.VERSION.SDK_INT < 29 || num.equals(AnonymousClass065.A01)) {
                C05I.A00(null, c05i);
                c05i.A06.A00(AnonymousClass065.A0h, activity);
            }
            C05I.A01(activity, c05i, num);
        }
    }

    public final void A04(Activity activity, Integer num) {
        C05I c05i = this.A00;
        synchronized (c05i.A0F) {
            if (Build.VERSION.SDK_INT < 29 || num.equals(AnonymousClass065.A01)) {
                C05I.A00(null, c05i);
                c05i.A06.A00(AnonymousClass065.A00, activity);
            }
            C05I.A01(activity, c05i, num);
        }
    }

    public final void A05(Activity activity, Integer num) {
        C05I c05i = this.A00;
        synchronized (c05i.A0F) {
            if (Build.VERSION.SDK_INT < 29 || num.equals(AnonymousClass065.A01)) {
                C05I.A00(null, c05i);
                c05i.A06.A00(AnonymousClass065.A0C, activity);
            }
            C05I.A01(activity, c05i, num);
        }
    }

    public final void A06(Activity activity, Integer num) {
        C05I c05i = this.A00;
        synchronized (c05i.A0F) {
            if (Build.VERSION.SDK_INT < 29 || num.equals(AnonymousClass065.A01)) {
                C05I.A00(null, c05i);
                c05i.A06.A00(AnonymousClass065.A0q, activity);
            }
            C05I.A01(activity, c05i, num);
        }
    }

    public static final boolean A00(Activity activity) {
        return activity.getClass().getName().equals(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (A00(activity)) {
            return;
        }
        A01(activity, AnonymousClass065.A0C);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (A00(activity)) {
            return;
        }
        A02(activity, AnonymousClass065.A0C);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (A00(activity)) {
            return;
        }
        A03(activity, AnonymousClass065.A0C);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (A00(activity)) {
            return;
        }
        A04(activity, AnonymousClass065.A0C);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (A00(activity)) {
            return;
        }
        A05(activity, AnonymousClass065.A0C);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (A00(activity)) {
            return;
        }
        A06(activity, AnonymousClass065.A0C);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
