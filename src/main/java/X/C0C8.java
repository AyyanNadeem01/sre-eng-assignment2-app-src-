package X;

import java.util.HashMap;
import java.util.Map;

/* renamed from: X.0C8 */
/* loaded from: classes.dex */
public final class C0C8 implements AnonymousClass095 {
    public static final Object A03 = new Object();
    public static volatile C0C8 A04;
    public final Map A02 = AnonymousClass000.A0C();
    public final Map A01 = AnonymousClass000.A0C();
    public final Map A00 = AnonymousClass000.A0C();

    public static C0C8 A00() {
        if (A04 == null) {
            synchronized (A03) {
                if (A04 == null) {
                    A04 = new C0C8();
                }
            }
        }
        return A04;
    }

    private void A01(Throwable th, Map map) {
        HashMap map2;
        String strADO;
        Object obj = A03;
        synchronized (obj) {
            map2 = new HashMap(map);
        }
        for (Map.Entry entry : map2.entrySet()) {
            Object key = entry.getKey();
            try {
                strADO = ((C06F) entry.getValue()).ADO(th);
            } catch (Throwable th2) {
                C018108b.A0C("lacrima", "Failed to apply lazy supplier: %s", th2);
            }
            if (strADO == null) {
                synchronized (obj) {
                    try {
                        this.A02.remove(key);
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                }
            } else {
                synchronized (obj) {
                    try {
                        this.A02.put(key, strADO);
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                }
            }
        }
    }

    @Override // X.AnonymousClass095
    public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) {
        HashMap map;
        Throwable th;
        if (anonymousClass057 != AnonymousClass057.CRITICAL_REPORT && (th = c05c.A02) != null) {
            A01(th, this.A01);
        }
        A01(c05c.A02, this.A00);
        synchronized (A03) {
            map = new HashMap(this.A02);
        }
        for (Map.Entry entry : map.entrySet()) {
            c05c.A06((String) entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // X.AnonymousClass095
    public final Integer AGY() {
        return AnonymousClass065.A06;
    }
}
