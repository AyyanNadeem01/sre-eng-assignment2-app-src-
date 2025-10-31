package X;

import android.app.ActivityManager;
import java.util.HashSet;
import java.util.Set;

/* renamed from: X.00t, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C001600t extends Thread {
    public static final String __redex_internal_original_name = "ProcessAnrErrorMonitor$MonitorThread";
    public boolean A00;
    public boolean A01;
    public boolean A02;
    public final long A03;
    public final long A04;
    public final ActivityManager A05;
    public final Object A06;
    public final Set A07;
    public volatile InterfaceC000900m A08;
    public final /* synthetic */ C001100o A09;

    public C001600t(ActivityManager activityManager, C001100o c001100o, InterfaceC000900m interfaceC000900m, long j, long j2) {
        String str;
        this.A09 = c001100o;
        StringBuilder sb = new StringBuilder();
        sb.append("ProcessAnrErrorMonitorThread:");
        sb.append((C019908u.A04 == null || (str = C019908u.A04.A02) == null) ? "unknown" : str);
        super(sb.toString());
        this.A06 = new Object();
        this.A07 = new HashSet();
        this.A05 = activityManager;
        this.A08 = interfaceC000900m;
        this.A04 = j;
        this.A03 = j2;
        this.A00 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x011a  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C001600t.run():void");
    }
}
