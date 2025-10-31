package X;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;

/* renamed from: X.00o */
/* loaded from: classes.dex */
public final class C001100o {
    public long A00;
    public C001600t A01;
    public Integer A02 = AnonymousClass065.A00;
    public final int A03 = Process.myUid();
    public final int A04;
    public final String A05;
    public final Context A06;

    public final void A00() {
        C001600t c001600t;
        synchronized (this) {
            if (this.A02 != AnonymousClass065.A00 && (c001600t = this.A01) != null) {
                Object obj = c001600t.A06;
                synchronized (obj) {
                    c001600t.A01 = true;
                    obj.notifyAll();
                }
            }
        }
    }

    public final void A01() {
        C001600t c001600t;
        synchronized (this) {
            if (this.A02 != AnonymousClass065.A00 && (c001600t = this.A01) != null) {
                Object obj = c001600t.A06;
                synchronized (obj) {
                    c001600t.A01 = false;
                    obj.notifyAll();
                }
            }
        }
    }

    public final void A02(InterfaceC000900m interfaceC000900m, long j) {
        C001600t c001600t;
        C018108b.A0K("ProcessAnrErrorMonitor", "startMonitoring with delay: %d", Long.valueOf(j));
        ActivityManager activityManager = (ActivityManager) this.A06.getSystemService("activity");
        synchronized (this) {
            if (interfaceC000900m == null && j != 0) {
                throw new IllegalArgumentException("Cannot delay and wait for listener at the same time");
            }
            C001600t c001600t2 = this.A01;
            if (c001600t2 == null || c001600t2.A08 != null) {
                Integer num = this.A02;
                Integer num2 = AnonymousClass065.A00;
                if (num != num2 && (c001600t = this.A01) != null) {
                    Object obj = c001600t.A06;
                    synchronized (obj) {
                        try {
                            c001600t.A02 = true;
                            obj.notifyAll();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                long j2 = this.A00 + 1;
                this.A00 = j2;
                C001600t c001600t3 = new C001600t(activityManager, this, interfaceC000900m, j2, j);
                this.A01 = c001600t3;
                if (interfaceC000900m != null) {
                    num2 = AnonymousClass065.A01;
                }
                this.A02 = num2;
                c001600t3.start();
            } else {
                if (interfaceC000900m == null) {
                    throw new IllegalArgumentException("Listener cannot be null");
                }
                C001600t c001600t4 = this.A01;
                Object obj2 = c001600t4.A06;
                synchronized (obj2) {
                    try {
                        c001600t4.A08 = interfaceC000900m;
                        obj2.notifyAll();
                    } catch (Throwable th2) {
                    }
                }
            }
        }
    }

    public C001100o(Context context, String str, int i) {
        this.A06 = context;
        this.A05 = str;
        this.A04 = i;
    }
}
