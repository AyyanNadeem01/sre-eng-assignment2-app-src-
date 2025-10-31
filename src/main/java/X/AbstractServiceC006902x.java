package X;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* renamed from: X.02x */
/* loaded from: classes.dex */
public abstract class AbstractServiceC006902x extends Service {
    public static final Object A05 = new Object();
    public static final HashMap A06 = new HashMap();
    public AnonymousClass032 A00;
    public AnonymousClass030 A01;
    public AbstractC007002y A02;
    public boolean A03 = false;
    public final ArrayList A04;

    public abstract void A05(Intent intent);

    public static void A00(final Context context, Intent intent, Class cls, final int i) {
        final ComponentName componentName = new ComponentName(context, (Class<?>) cls);
        synchronized (A05) {
            HashMap map = A06;
            AbstractC007002y anonymousClass063 = (AbstractC007002y) map.get(componentName);
            if (anonymousClass063 == null) {
                anonymousClass063 = Build.VERSION.SDK_INT >= 26 ? new AbstractC007002y(componentName, context, i) { // from class: X.02z
                    public final JobInfo A00;
                    public final JobScheduler A01;

                    @Override // X.AbstractC007002y
                    public final void A04(Intent intent2) {
                        this.A01.enqueue(this.A00, new JobWorkItem(intent2));
                    }

                    {
                        A03(i);
                        this.A00 = new JobInfo.Builder(i, this.A02).setOverrideDeadline(0L).build();
                        this.A01 = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
                    }
                } : new AnonymousClass063(componentName, context);
                map.put(componentName, anonymousClass063);
            }
            anonymousClass063.A03(i);
            anonymousClass063.A04(intent);
        }
    }

    public AnonymousClass033 A02() {
        AnonymousClass033 anonymousClass033;
        AnonymousClass030 anonymousClass030 = this.A01;
        if (anonymousClass030 == null) {
            ArrayList arrayList = this.A04;
            synchronized (arrayList) {
                try {
                    anonymousClass033 = arrayList.size() > 0 ? (AnonymousClass033) arrayList.remove(0) : null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return anonymousClass033;
        }
        try {
            return anonymousClass030.A8K();
        } catch (SecurityException e) {
            String message = e.getMessage();
            if (message == null || !message.contains("Caller no longer running")) {
                throw e;
            }
            Log.e("JobIntentService", "Captured a \"Caller no longer running\"", e);
            return null;
        }
    }

    public final void A03() {
        ArrayList arrayList = this.A04;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.A00 = null;
                if (arrayList.size() > 0) {
                    A04(false);
                } else if (!this.A03) {
                    this.A02.A00();
                }
            }
        }
    }

    public final void A04(boolean z) {
        if (this.A00 == null) {
            this.A00 = new AsyncTask() { // from class: X.032
                public AnonymousClass032() {
                }

                @Override // android.os.AsyncTask
                public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
                    while (true) {
                        AbstractServiceC006902x abstractServiceC006902x = this.A00;
                        AnonymousClass033 anonymousClass033A02 = abstractServiceC006902x.A02();
                        if (anonymousClass033A02 == null) {
                            return null;
                        }
                        abstractServiceC006902x.A05(anonymousClass033A02.AFH());
                        try {
                            anonymousClass033A02.A63();
                        } catch (SecurityException e) {
                            String message = e.getMessage();
                            if (message == null || !message.contains("Caller no longer running")) {
                                throw e;
                            }
                            Log.e("JobIntentService", "Captured a \"Caller no longer running\"", e);
                        }
                    }
                    throw e;
                }

                @Override // android.os.AsyncTask
                public final /* bridge */ /* synthetic */ void onCancelled(Object obj) {
                    this.A00.A03();
                }

                @Override // android.os.AsyncTask
                public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
                    this.A00.A03();
                }
            };
            AbstractC007002y abstractC007002y = this.A02;
            if (abstractC007002y != null && z) {
                abstractC007002y.A01();
            }
            this.A00.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        AnonymousClass030 anonymousClass030 = this.A01;
        if (anonymousClass030 != null) {
            return anonymousClass030.A62();
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, final int i2) {
        ArrayList arrayList = this.A04;
        if (arrayList == null) {
            return 2;
        }
        this.A02.A02();
        synchronized (arrayList) {
            if (intent == null) {
                intent = new Intent();
                arrayList.add(new AnonymousClass033(intent, this, i2) { // from class: X.064
                    public final int A00;
                    public final Intent A01;
                    public final /* synthetic */ AbstractServiceC006902x A02;

                    {
                        this.A02 = this;
                        this.A01 = intent;
                        this.A00 = i2;
                    }

                    @Override // X.AnonymousClass033
                    public final void A63() {
                        this.A02.stopSelf(this.A00);
                    }

                    @Override // X.AnonymousClass033
                    public final Intent AFH() {
                        return this.A01;
                    }
                });
                A04(true);
            } else {
                arrayList.add(new AnonymousClass033(intent, this, i2) { // from class: X.064
                    public final int A00;
                    public final Intent A01;
                    public final /* synthetic */ AbstractServiceC006902x A02;

                    {
                        this.A02 = this;
                        this.A01 = intent;
                        this.A00 = i2;
                    }

                    @Override // X.AnonymousClass033
                    public final void A63() {
                        this.A02.stopSelf(this.A00);
                    }

                    @Override // X.AnonymousClass033
                    public final Intent AFH() {
                        return this.A01;
                    }
                });
                A04(true);
            }
        }
        return 3;
    }

    public AbstractServiceC006902x() {
        this.A04 = Build.VERSION.SDK_INT >= 26 ? null : new ArrayList();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.A01 = new AnonymousClass031(this);
            this.A02 = null;
            return;
        }
        this.A01 = null;
        ComponentName componentName = new ComponentName(this, getClass());
        HashMap map = A06;
        AbstractC007002y anonymousClass063 = (AbstractC007002y) map.get(componentName);
        if (anonymousClass063 == null) {
            anonymousClass063 = new AnonymousClass063(componentName, this);
            map.put(componentName, anonymousClass063);
        }
        this.A02 = anonymousClass063;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.A04;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.A03 = true;
                this.A02.A00();
            }
        }
    }
}
