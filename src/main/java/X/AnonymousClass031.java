package X;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.IBinder;

/* renamed from: X.031, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass031 extends JobServiceEngine implements AnonymousClass030 {
    public JobParameters A00;
    public final AbstractServiceC006902x A01;
    public final Object A02;

    /* JADX WARN: Type inference failed for: r0v4, types: [X.034] */
    @Override // X.AnonymousClass030
    public final AnonymousClass034 A8K() {
        synchronized (this.A02) {
            JobParameters jobParameters = this.A00;
            if (jobParameters == null) {
                return null;
            }
            final JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
            if (jobWorkItemDequeueWork == null) {
                return null;
            }
            jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.A01.getClassLoader());
            return new AnonymousClass033(jobWorkItemDequeueWork, this) { // from class: X.034
                public final JobWorkItem A00;
                public final /* synthetic */ AnonymousClass031 A01;

                {
                    this.A01 = this;
                    this.A00 = jobWorkItemDequeueWork;
                }

                @Override // X.AnonymousClass033
                public final void A63() {
                    AnonymousClass031 anonymousClass031 = this.A01;
                    synchronized (anonymousClass031.A02) {
                        JobParameters jobParameters2 = anonymousClass031.A00;
                        if (jobParameters2 != null) {
                            jobParameters2.completeWork(this.A00);
                        }
                    }
                }

                @Override // X.AnonymousClass033
                public final Intent AFH() {
                    return this.A00.getIntent();
                }
            };
        }
    }

    @Override // android.app.job.JobServiceEngine
    public final boolean onStartJob(JobParameters jobParameters) {
        this.A00 = jobParameters;
        this.A01.A04(false);
        return true;
    }

    @Override // android.app.job.JobServiceEngine
    public final boolean onStopJob(JobParameters jobParameters) {
        AnonymousClass032 anonymousClass032 = this.A01.A00;
        if (anonymousClass032 != null) {
            anonymousClass032.cancel(false);
        }
        synchronized (this.A02) {
            this.A00 = null;
        }
        return true;
    }

    public AnonymousClass031(AbstractServiceC006902x abstractServiceC006902x) {
        super(abstractServiceC006902x);
        this.A02 = new Object();
        this.A01 = abstractServiceC006902x;
    }

    @Override // X.AnonymousClass030
    public final IBinder A62() {
        return getBinder();
    }
}
