package X;

import X.AnonymousClass065;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.errorreporting.lacrima.detector.lifecycle.ApplicationLifecycleDetector$ActivityCallbacks;
import com.facebook.errorreporting.lacrima.detector.lifecycle.ApplicationLifecycleDetector$SplashTransition;
import com.facebook.lite.SharedPreferencesHookA11;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;

/* renamed from: X.05I, reason: invalid class name */
/* loaded from: classes.dex */
public final class C05I implements InterfaceC02430Ba {
    public static final Object A0K = new ApplicationLifecycleDetector$SplashTransition();
    public C010704r A00;
    public C0A1 A01;
    public boolean A02;
    public boolean A03;
    public WeakReference A04;
    public final Application A05;
    public final C05F A06;
    public final C04w A08;
    public final C0CK A0D;
    public final C05H A0E;
    public final C05G A0G;
    public final AnonymousClass046 A0H;
    public final AnonymousClass047 A0I = new Object() { // from class: X.047
    };
    public final AnonymousClass048 A07 = new AnonymousClass048() { // from class: X.049
        @Override // X.AnonymousClass048
        public final void Aa3() {
        }

        @Override // X.AnonymousClass048
        public final void Aa4() {
        }

        @Override // X.AnonymousClass048
        public final void Ac2() {
        }

        @Override // X.AnonymousClass048
        public final void Ac4() {
        }
    };
    public final Object A0F = new Object();
    public final C04A A0J = new Object() { // from class: X.04A
    };
    public final C04B A09 = new Object() { // from class: X.04B
    };
    public final C04C A0A = new Object() { // from class: X.04C
    };
    public final C04D A0B = new Object() { // from class: X.04D
    };
    public final C04E A0C = new Object() { // from class: X.04E
    };

    /* JADX WARN: Type inference failed for: r0v0, types: [X.047] */
    /* JADX WARN: Type inference failed for: r0v3, types: [X.04A] */
    /* JADX WARN: Type inference failed for: r0v4, types: [X.04B] */
    /* JADX WARN: Type inference failed for: r0v5, types: [X.04C] */
    /* JADX WARN: Type inference failed for: r0v6, types: [X.04D] */
    /* JADX WARN: Type inference failed for: r0v7, types: [X.04E] */
    public C05I(Application application, C05F c05f, C05G c05g, C04w c04w, C0A1 c0a1, AnonymousClass046 anonymousClass046, C0CK c0ck, C05H c05h) {
        this.A05 = application;
        this.A0D = c0ck;
        this.A08 = c04w;
        this.A06 = c05f;
        this.A0G = c05g;
        this.A01 = c0a1;
        this.A0E = c05h;
        this.A0H = anonymousClass046;
    }

    public static void A00(Activity activity, C05I c05i) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (c05i.A02) {
            return;
        }
        if (activity != null) {
            File file = c05i.A0D.A04;
            AnonymousClass053.A03(file, "Did you call SessionManager.init()?");
            try {
                FileWriter fileWriter = new FileWriter(new File(file, "first_intent.txt"), false);
                try {
                    fileWriter.write(activity.getIntent().toString());
                    fileWriter.close();
                } finally {
                }
            } catch (IOException unused) {
            }
        }
        C010704r c010704r = c05i.A00;
        if (c010704r != null) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            synchronized (c010704r.A02) {
                c010704r.A02(167, 10, Long.toString(jUptimeMillis), false);
                c010704r.A01.A00.put(178, (byte) 48);
                C010704r.A00(c010704r);
            }
        }
        c05i.A02 = true;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [X.04F] */
    @Override // X.InterfaceC02430Ba
    public final void start() {
        synchronized (this.A0F) {
            if (this.A03) {
                return;
            }
            this.A03 = true;
            C010704r c010704r = this.A0D.A02;
            AnonymousClass053.A03(c010704r, "Did you call SessionManager.init()?");
            this.A00 = c010704r;
            c010704r.A04(EnumC011004u.A0B);
            ApplicationLifecycleDetector$ActivityCallbacks applicationLifecycleDetector$ActivityCallbacks = Build.VERSION.SDK_INT >= 29 ? new ApplicationLifecycleDetector$ActivityCallbacks() { // from class: com.facebook.errorreporting.lacrima.detector.lifecycle.ApplicationLifecycleDetector$ActivityCallbacksApi29
                {
                    super(this.A00);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPostCreated(Activity activity, Bundle bundle) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A01(activity, AnonymousClass065.A0N);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPostDestroyed(Activity activity) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A02(activity, AnonymousClass065.A0N);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPostPaused(Activity activity) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A03(activity, AnonymousClass065.A0N);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPostResumed(Activity activity) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A04(activity, AnonymousClass065.A0N);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPostStarted(Activity activity) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A05(activity, AnonymousClass065.A0N);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPostStopped(Activity activity) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A06(activity, AnonymousClass065.A0N);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPreCreated(Activity activity, Bundle bundle) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A01(activity, AnonymousClass065.A01);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPreDestroyed(Activity activity) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A02(activity, AnonymousClass065.A01);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPrePaused(Activity activity) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A03(activity, AnonymousClass065.A01);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPreResumed(Activity activity) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A04(activity, AnonymousClass065.A01);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPreStarted(Activity activity) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A05(activity, AnonymousClass065.A01);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPreStopped(Activity activity) {
                    if (ApplicationLifecycleDetector$ActivityCallbacks.A00(activity)) {
                        return;
                    }
                    A06(activity, AnonymousClass065.A01);
                }
            } : new ApplicationLifecycleDetector$ActivityCallbacks(this);
            ?? r2 = new Object() { // from class: X.04F
            };
            this.A05.registerActivityLifecycleCallbacks(applicationLifecycleDetector$ActivityCallbacks);
            synchronized (C04N.A02) {
                C04N.A00 = r2;
            }
            C05F c05f = this.A06;
            C04B c04b = this.A09;
            synchronized (c05f.A05) {
                c05f.A01 = c04b;
            }
        }
    }

    public static void A01(Activity activity, C05I c05i, Integer num) {
        boolean zIsFinishing;
        if (activity != null) {
            zIsFinishing = activity.isFinishing();
        } else {
            activity = null;
            zIsFinishing = false;
        }
        c05i.A02(activity, num, null, zIsFinishing);
    }

    public final void A02(Activity activity, Integer num, String str, boolean z) {
        C05F c05f;
        Integer num2;
        String simpleName;
        Object key;
        char cCharAt;
        boolean zA01;
        boolean z2;
        boolean zA00;
        char c;
        int i;
        int size;
        final C05G c05g;
        Object obj;
        C01Y c01y;
        if (this.A00 == null) {
            C018108b.A08("lacrima", "ApplicationLifecycleDetector.start() wasn't called?");
            return;
        }
        C04w c04w = this.A08;
        AnonymousClass057 anonymousClass057 = AnonymousClass057.CRITICAL_REPORT;
        if (c04w.A0C) {
            return;
        }
        AnonymousClass057 anonymousClass0572 = AnonymousClass057.LARGE_REPORT;
        if (c04w.A0D) {
            return;
        }
        synchronized (this) {
            c05f = this.A06;
            synchronized (c05f) {
                num2 = c05f.A03 ? AnonymousClass065.A0u : AnonymousClass065.A02;
                simpleName = null;
                key = null;
                WeakReference weakReference = c05f.A02;
                if (weakReference == null || (obj = weakReference.get()) == null || (c01y = (C01Y) c05f.A07.get(obj)) == null) {
                    for (Map.Entry entry : c05f.A07.entrySet()) {
                        if (((C01Y) entry.getValue()).A00.compareTo(num2) < 0) {
                            key = entry.getKey();
                            num2 = ((C01Y) entry.getValue()).A00;
                            simpleName = ((key instanceof Activity) || (key instanceof Service)) ? key.getClass().getSimpleName() : key.toString();
                            entry.getValue();
                            entry.getValue();
                            entry.getValue();
                        }
                    }
                } else {
                    key = obj;
                    num2 = c01y.A00;
                    simpleName = ((obj instanceof Activity) || (obj instanceof Service)) ? obj.getClass().getSimpleName() : obj.toString();
                }
            }
        }
        if (simpleName == null || (c05g = this.A0G) == null) {
            cCharAt = ' ';
        } else {
            synchronized (c05g) {
                Properties properties = c05g.A03;
                String property = properties.getProperty(simpleName);
                if (TextUtils.isEmpty(property)) {
                    synchronized (c05g) {
                        char c2 = c05g.A00;
                        if (c2 == '~') {
                            cCharAt = '!';
                        } else {
                            char c3 = (char) (c2 + 1);
                            c05g.A00 = c3;
                            properties.setProperty(simpleName, Character.toString(c3));
                            c05g.A01.post(new Runnable() { // from class: X.01Z
                                public static final String __redex_internal_original_name = "ForegroundEntityMapper$$ExternalSyntheticLambda0";

                                @Override // java.lang.Runnable
                                public final void run() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                                    String str2;
                                    String str3;
                                    C05G c05g2 = c05g;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(c05g2.A02);
                                    sb.append("_entity");
                                    try {
                                        FileOutputStream fileOutputStream = new FileOutputStream(new File(sb.toString()));
                                        try {
                                            Properties properties2 = new Properties();
                                            synchronized (c05g2) {
                                                properties2.putAll(c05g2.A03);
                                            }
                                            properties2.store(fileOutputStream, (String) null);
                                            fileOutputStream.close();
                                        } catch (Throwable th) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (Throwable th2) {
                                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                            }
                                            throw th;
                                        }
                                    } catch (IOException e) {
                                        e = e;
                                        str2 = "ForegroundEntityMapper";
                                        str3 = "Error saving entity map";
                                        C018108b.A0A(str2, str3, e);
                                    } catch (AssertionError e2) {
                                        e = e2;
                                        str2 = "ForegroundEntityMapper";
                                        str3 = "Error storing properties";
                                        C018108b.A0A(str2, str3, e);
                                    }
                                }
                            });
                            cCharAt = c05g.A00;
                        }
                    }
                } else {
                    cCharAt = property.charAt(0);
                }
            }
        }
        this.A04 = new WeakReference(key);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 24 || activity == null) {
            zA01 = false;
            z2 = false;
            zA00 = false;
        } else {
            zA00 = C02X.A00(activity);
            zA01 = C02X.A01(activity);
            z2 = true;
        }
        C010704r c010704r = this.A00;
        switch (num.intValue()) {
            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                c = '1';
                break;
            case 2:
                c = '2';
                break;
            default:
                c = '3';
                break;
        }
        synchronized (c05f) {
            i = c05f.A00;
        }
        Integer numValueOf = Integer.valueOf(i);
        synchronized (c05f) {
            size = ((WeakHashMap) c05f.A06.get(6)).size();
        }
        C010704r.A01(c010704r, num2, numValueOf, Integer.valueOf(size), str, cCharAt, c, z, false, z2, zA00, zA01);
        if (i2 < 29 || num.equals(AnonymousClass065.A01) || num.equals(AnonymousClass065.A00)) {
            boolean zA002 = AbstractC010304m.A00(AbstractC010804s.A00(num2));
            C0A1 c0a1 = this.A01;
            if (c0a1 != null) {
                c0a1.AWZ(zA002);
            }
        }
        C05C c05c = new C05C(null);
        c04w.A06(c05c, anonymousClass057, this);
        c04w.A06(c05c, anonymousClass0572, this);
    }

    @Override // X.InterfaceC02430Ba
    public final AnonymousClass046 AFf() {
        return this.A0H;
    }

    @Override // X.InterfaceC02430Ba
    public final EnumC011204x AGX() {
        return EnumC011204x.APP_LIFECYCLE;
    }
}
