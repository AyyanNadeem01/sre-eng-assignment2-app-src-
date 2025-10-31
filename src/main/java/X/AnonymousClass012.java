package X;

import android.content.Context;
import android.os.SystemClock;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: X.012, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass012 {
    public final AnonymousClass097 A00;
    public final AnonymousClass010 A01;
    public final Set A02 = new HashSet();
    public final Context A03;
    public final InterfaceC002100y A04;
    public final AnonymousClass011 A05;
    public final InterfaceC002200z A06;

    public final void A00(String str) {
        Set set = this.A02;
        if (set.contains(str)) {
            return;
        }
        C02H c02hAjR = this.A06.AjR(str);
        Iterator it = new ArrayList(c02hAjR.A03).iterator();
        while (it.hasNext()) {
            A00((String) it.next());
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            List list = c02hAjR.A02;
            if (!list.isEmpty()) {
                Iterator it2 = list.iterator();
                Iterator it3 = c02hAjR.A04.iterator();
                while (it2.hasNext() && it3.hasNext()) {
                    this.A00.A2y((File) it2.next(), (File) it3.next());
                }
            }
            if (c02hAjR.A00 != null) {
                this.A01.AOt(c02hAjR);
            }
            set.add(c02hAjR.A01);
        }
        this.A04.ARR(str, SystemClock.uptimeMillis() - jUptimeMillis);
    }

    public AnonymousClass012(Context context, AnonymousClass097 anonymousClass097, InterfaceC002100y interfaceC002100y, AnonymousClass011 anonymousClass011, InterfaceC002200z interfaceC002200z, AnonymousClass010 anonymousClass010) {
        this.A03 = context;
        this.A04 = interfaceC002100y;
        this.A06 = interfaceC002200z;
        this.A05 = anonymousClass011;
        this.A01 = anonymousClass010;
        this.A00 = anonymousClass097;
    }
}
