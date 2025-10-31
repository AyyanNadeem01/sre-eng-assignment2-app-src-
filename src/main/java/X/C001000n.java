package X;

import android.os.SystemClock;

/* renamed from: X.00n, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C001000n implements InterfaceC000700k, InterfaceC000900m {
    public static C001000n A0E;
    public long A00;
    public long A01;
    public InterfaceC001400r A02;
    public boolean A04;
    public boolean A05;
    public final C001100o A06;
    public final C000600j A07;
    public volatile boolean A0B;
    public volatile boolean A0C;
    public volatile boolean A0D;
    public boolean A03 = true;
    public final Object A0A = new Object();
    public final Object A08 = new Object();
    public final Runnable A09 = new Runnable() { // from class: X.00q
        public static final String __redex_internal_original_name = "ProcessErrorMonitorANRDetector$1";

        @Override // java.lang.Runnable
        public final void run() {
            C001000n c001000n = this.A00;
            if (c001000n.A0D) {
                return;
            }
            C03g c03g = C03g.A02;
            C000400h c000400h = c001000n.A07.A00;
            synchronized (c001000n.A08) {
                C00a.A00(c000400h.A01, c03g);
            }
        }
    };

    @Override // X.InterfaceC000900m
    public final void AVd() {
        boolean z;
        synchronized (this) {
            z = this.A05;
            if (!this.A0D) {
                this.A0D = true;
                C03g c03g = C03g.A04;
                C000400h c000400h = this.A07.A00;
                synchronized (this.A08) {
                    C00a.A00(c000400h.A01, c03g);
                }
            }
        }
        synchronized (this.A0A) {
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis() - this.A00;
                C00c c00c = this.A07.A04;
                c00c.A0A = jUptimeMillis;
                C00c.A00(c00c);
                c00c.A0M = false;
            }
        }
    }

    @Override // X.InterfaceC000700k
    public final void start() {
        synchronized (this) {
            if (this.A01 <= 0) {
                this.A01 = -1L;
            }
            if (this.A03) {
                this.A03 = false;
                this.A06.A02(this, 4000L);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0042  */
    @Override // X.InterfaceC000900m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AVf(java.lang.String r28, java.lang.String r29) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C001000n.AVf(java.lang.String, java.lang.String):void");
    }

    @Override // X.InterfaceC000700k
    public final void pause() {
        this.A06.A00();
    }

    @Override // X.InterfaceC000700k
    public final void resume() {
        this.A06.A01();
    }

    public C001000n(C000600j c000600j, int i) {
        this.A07 = c000600j;
        this.A06 = new C001100o(c000600j.A02, c000600j.A05, i);
    }

    @Override // X.InterfaceC000900m
    public final void ATc() {
    }

    @Override // X.InterfaceC000900m
    public final void ATd() {
    }

    @Override // X.InterfaceC000900m
    public final void onStart() {
    }

    @Override // X.InterfaceC000900m
    public final void AVe(String str, String str2, String str3) {
    }
}
