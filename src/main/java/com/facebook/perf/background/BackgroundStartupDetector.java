package com.facebook.perf.background;

import X.2Ac;
import X.AnonymousClass000;
import X.C018108b;
import X.C02420Az;
import X.C06E;
import X.C0Al;
import X.C0B9;
import X.HandlerC02270Ae;
import X.InterfaceC02350As;
import X.InterfaceC02600By;
import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.perf.background.BackgroundStartupDetector;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class BackgroundStartupDetector {
    public static final int ACTIVITY_CREATE_QUEUE_DRAINED = 49182;
    public static final int ACTIVITY_REDIRECT_LAUNCH_TIMEOUT_MS = 200;
    public static final int COLDSTART_QUEUE_DRAINED = 49181;
    public static volatile int _coldStartMode = 0;
    public static volatile C0B9 abandonedActivityStartListener = null;
    public static volatile BackgroundStartupDetector backgroundStartupDetector = null;
    public static volatile int backgroundedCount = 0;
    public static boolean isActivityStackStart = false;
    public static C0Al isBackgroundListener = null;
    public static volatile Boolean isBackgroundState = null;
    public static volatile boolean isBackgroundedNotYetResumed = true;
    public static InterfaceC02600By reliabilityListener;
    public static String tag;
    public int activitiesStartedSinceLastColdStartQueueDrain;
    public boolean activityIsRecreating;
    public final BackgroundStartupDetector$activityLifecycleCallbacks$1 activityLifecycleCallbacks;
    public boolean activityQueueAlreadyDrained;
    public int activityResumeCount;
    public int activityStartCount;
    public boolean anyActivityCreated;
    public final int coldStartQueueDrainMessageCount;
    public final HandlerC02270Ae handler;
    public boolean isColdStartQueueDrained;
    public int sentMessageCount;
    public boolean wasInconclusiveColdStart;
    public static final C02420Az Companion = new C02420Az();
    public static final CopyOnWriteArraySet listeners = new CopyOnWriteArraySet();
    public static ArrayList getColdStartModeCallbacks = AnonymousClass000.A0B();

    public static final void addListener(InterfaceC02600By interfaceC02600By) {
        C06E.A07(interfaceC02600By, 0);
        listeners.add(interfaceC02600By);
        throw new NullPointerException("onColdStartModeChanged");
    }

    public static final void getColdStartMode(InterfaceC02350As interfaceC02350As) {
        int i;
        C06E.A07(interfaceC02350As, 0);
        synchronized (BackgroundStartupDetector.class) {
            i = _coldStartMode;
            if (i == 0) {
                getColdStartModeCallbacks.add(interfaceC02350As);
            }
        }
        if (i != 0) {
            throw new NullPointerException("onColdStartMode");
        }
    }

    public static final BackgroundStartupDetector installFromApplicationOnCreate(Application application, boolean z) {
        C06E.A07(application, 0);
        return C02420Az.A00(application, z, false);
    }

    public static final boolean isBackground() {
        Boolean bool = true;
        return bool.equals(isBackgroundState);
    }

    public static final void onActivityCreated(Activity activity) {
        C06E.A07(activity, 0);
        BackgroundStartupDetector backgroundStartupDetector2 = backgroundStartupDetector;
        if (backgroundStartupDetector2 != null) {
            backgroundStartupDetector2.activityLifecycleCallbacks.onActivityCreated(activity, null);
        }
    }

    public static final void onBeforeActivityInstantiated(String str) {
        C06E.A07(str, 0);
        BackgroundStartupDetector backgroundStartupDetector2 = backgroundStartupDetector;
        if (backgroundStartupDetector2 != null) {
            backgroundStartupDetector2.activityCreateInternal(str);
        }
    }

    public static final void removeListener(InterfaceC02600By interfaceC02600By) {
        C06E.A07(interfaceC02600By, 0);
        listeners.remove(interfaceC02600By);
    }

    public static final void resetReliabilityListener() {
        reliabilityListener = null;
    }

    public static final void setIsBackgroundListener(C0Al c0Al) {
        C06E.A07(c0Al, 0);
        isBackgroundListener = c0Al;
        throw new NullPointerException("onIsBackgroundChange");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void activityCreateInternal(String str) {
        boolean z = this.anyActivityCreated;
        this.activityIsRecreating = false;
        if (!z) {
            this.anyActivityCreated = true;
            if (!this.isColdStartQueueDrained) {
                C02420Az.A01(4);
            }
        }
        if (this.activityStartCount == 0) {
            C02420Az.A02(false);
            this.activityQueueAlreadyDrained = false;
            removeMessages(ACTIVITY_CREATE_QUEUE_DRAINED);
            sendEmptyMessage(ACTIVITY_CREATE_QUEUE_DRAINED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleActivityCreateQueueDrained() {
        if (!this.activityQueueAlreadyDrained) {
            this.activityQueueAlreadyDrained = true;
            HandlerC02270Ae handlerC02270Ae = this.handler;
            handlerC02270Ae.sendMessageDelayed(Message.obtain(handlerC02270Ae, ACTIVITY_CREATE_QUEUE_DRAINED), 200L);
        } else if (this.activityStartCount == 0 && this.activityResumeCount == 0 && !this.activityIsRecreating) {
            C018108b.A08(tag, "ActivityCreateQueue drained. Activity likely self-finished or redirected to another process.");
            C02420Az.A02(true);
            backgroundedCount++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleColdStartQueueDrained() {
        if (this.sentMessageCount < this.coldStartQueueDrainMessageCount && !this.anyActivityCreated) {
            sendEmptyMessage(COLDSTART_QUEUE_DRAINED);
            this.sentMessageCount++;
            return;
        }
        if (!this.isColdStartQueueDrained) {
            this.isColdStartQueueDrained = true;
            isActivityStackStart = this.activitiesStartedSinceLastColdStartQueueDrain > 1;
            this.activitiesStartedSinceLastColdStartQueueDrain = 0;
        }
        if (!this.anyActivityCreated) {
            C02420Az.A01(this.wasInconclusiveColdStart ? 2 : 1);
            C02420Az.A02(true);
        } else {
            if (this.activityResumeCount > 0) {
                C02420Az.A01(this.wasInconclusiveColdStart ? 4 : 3);
                return;
            }
            this.anyActivityCreated = false;
            this.wasInconclusiveColdStart = true;
            HandlerC02270Ae handlerC02270Ae = this.handler;
            handlerC02270Ae.sendMessageDelayed(Message.obtain(handlerC02270Ae, COLDSTART_QUEUE_DRAINED), 200L);
        }
    }

    public static final void initializeForTest(BackgroundStartupDetector backgroundStartupDetector2) {
        backgroundStartupDetector = backgroundStartupDetector2;
        _coldStartMode = 0;
        backgroundedCount = 0;
        synchronized (BackgroundStartupDetector.class) {
            getColdStartModeCallbacks = AnonymousClass000.A0B();
        }
        listeners.clear();
    }

    public static final boolean isInstalled() {
        return backgroundStartupDetector != null;
    }

    public static final void setActivityIsRecreating() {
        BackgroundStartupDetector backgroundStartupDetector2 = backgroundStartupDetector;
        if (backgroundStartupDetector2 != null) {
            backgroundStartupDetector2.activityIsRecreating = true;
        }
    }

    public static final synchronized void setReliabilityListener(InterfaceC02600By interfaceC02600By) {
        synchronized (Companion) {
            C06E.A07(interfaceC02600By, 0);
            reliabilityListener = interfaceC02600By;
            throw new NullPointerException("onColdStartModeChanged");
        }
    }

    public static final boolean wasForegroundColdStart() {
        int i = _coldStartMode;
        return i == 3 || i == 4;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [X.0Ae] */
    public BackgroundStartupDetector(final Looper looper, int i) {
        this.coldStartQueueDrainMessageCount = i;
        this.sentMessageCount = 1;
        this.handler = new Handler(looper) { // from class: X.0Ae
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                C06E.A07(message, 0);
                switch (message.what) {
                    case BackgroundStartupDetector.COLDSTART_QUEUE_DRAINED /* 49181 */:
                        this.handleColdStartQueueDrained();
                        break;
                    case BackgroundStartupDetector.ACTIVITY_CREATE_QUEUE_DRAINED /* 49182 */:
                        this.handleActivityCreateQueueDrained();
                        break;
                }
            }
        };
        this.activityLifecycleCallbacks = new BackgroundStartupDetector$activityLifecycleCallbacks$1(this);
    }

    public static final /* synthetic */ InterfaceC02600By access$getReliabilityListener$cp() {
        return null;
    }

    public static final /* synthetic */ C0Al access$isBackgroundListener$cp() {
        return null;
    }

    public static final int getBackgroundedCount() {
        return backgroundedCount;
    }

    public static final boolean isActivityStackStart() {
        return isActivityStackStart;
    }

    public static final Boolean isBackgroundState() {
        return isBackgroundState;
    }

    public static final boolean isBackgroundedNotYetResumed() {
        return isBackgroundedNotYetResumed;
    }

    public static final void setAbandonedActivityStartListener(C0B9 c0b9) {
        abandonedActivityStartListener = c0b9;
    }

    public /* synthetic */ BackgroundStartupDetector(Looper looper, int i, 2Ac r3) {
        this(looper, i);
    }

    public static final int getColdStartMode() {
        return _coldStartMode;
    }

    public static final BackgroundStartupDetector installFromApplicationOnCreate(Application application) {
        C06E.A07(application, 0);
        return C02420Az.A00(application, false, false);
    }

    public static final BackgroundStartupDetector installFromApplicationOnCreate(Application application, boolean z, boolean z2) {
        return C02420Az.A00(application, z, z2);
    }
}
