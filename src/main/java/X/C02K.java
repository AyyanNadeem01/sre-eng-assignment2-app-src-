package X;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;

/* renamed from: X.02K, reason: invalid class name */
/* loaded from: classes.dex */
public final class C02K {
    public final Map A01 = new HashMap();
    public final Object A00 = new Object();

    public final boolean A00(String str) throws InterruptedException {
        Map map;
        Long l;
        Object obj = this.A00;
        synchronized (obj) {
            map = this.A01;
            l = (Long) map.get(str);
        }
        if (l == null) {
            l = 0L;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long jLongValue = l.longValue();
        if (jLongValue == 0) {
            synchronized (obj) {
                map.put(str, Long.valueOf(jUptimeMillis));
            }
        }
        if (jLongValue > jUptimeMillis) {
            return true;
        }
        if (jUptimeMillis - jLongValue >= 3000) {
            return false;
        }
        long j = (jLongValue + 3000) - jUptimeMillis;
        synchronized (obj) {
            map.put(str, Long.valueOf(jUptimeMillis + j));
        }
        try {
            Thread.sleep(j);
            return false;
        } catch (InterruptedException unused) {
            C0C5.A00();
            return false;
        }
    }
}
