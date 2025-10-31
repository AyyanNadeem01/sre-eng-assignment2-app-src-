package X;

import android.os.SystemClock;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: X.0Cg */
/* loaded from: classes.dex */
public class C02670Cg implements C0A1 {
    public final int $t;
    public final Object A00;

    public C02670Cg(Object obj, int i) {
        this.$t = i;
        this.A00 = obj;
    }

    @Override // X.C0A1
    public final void AWZ(final boolean z) {
        if (this.$t == 0) {
            Iterator it = C0BY.A00.iterator();
            while (it.hasNext()) {
                ((C0A1) it.next()).AWZ(z);
            }
            return;
        }
        synchronized (C019908u.class) {
            if (z != C019908u.A06) {
                C019908u.A06 = z;
                final HashSet hashSet = new HashSet(C019908u.A02);
                C019908u.A03.execute(new Runnable() { // from class: X.01a
                    public static final String __redex_internal_original_name = "GlobalAppState$$ExternalSyntheticLambda2";

                    @Override // java.lang.Runnable
                    public final void run() {
                        HashSet hashSet2 = hashSet;
                        boolean z2 = z;
                        boolean z3 = C019908u.A06;
                        Iterator it2 = hashSet2.iterator();
                        while (it2.hasNext()) {
                            C05E c05e = (C05E) it2.next();
                            if (!z2) {
                                c05e.A00(null, null);
                            }
                        }
                    }
                });
            }
        }
        C0BX c0bx = (C0BX) this.A00;
        c0bx.A03 = z;
        C019308o c019308o = c0bx.A00;
        boolean z2 = !z;
        synchronized (c019308o) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (c019308o.A07) {
                c019308o.A06 = z2;
                if (z2) {
                    c019308o.A00 = SystemClock.elapsedRealtime();
                } else {
                    c019308o.A01 = jUptimeMillis;
                    c019308o.A02 = 1L;
                }
                c019308o.A07 = false;
                return;
            }
            if (c019308o.A06) {
                if (!z2) {
                    long j = c019308o.A02;
                    if (j > 0) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - c019308o.A00;
                        if (jElapsedRealtime <= 0) {
                            c019308o.A03++;
                        }
                        c019308o.A05 += jElapsedRealtime;
                    }
                    c019308o.A01 = jUptimeMillis;
                    c019308o.A02 = j + 1;
                }
            } else if (z2) {
                c019308o.A00 = SystemClock.elapsedRealtime();
                c019308o.A04 += jUptimeMillis - c019308o.A01;
            }
            c019308o.A06 = z2;
            synchronized (c019308o.A08) {
            }
        }
    }
}
