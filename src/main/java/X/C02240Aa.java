package X;

import java.util.Iterator;

/* renamed from: X.0Aa, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C02240Aa {
    public final int A00;
    public final C0AQ A01;

    public final void A00(Integer num, String str) {
        if (this.A00 == 0 || str == null || str.startsWith("com.facebook.lite")) {
            return;
        }
        Iterator it = C04K.A04.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return;
            }
        }
        Iterator it2 = C04K.A03.iterator();
        while (it2.hasNext()) {
            if (str.startsWith((String) it2.next())) {
                return;
            }
        }
        this.A01.Aj7(num.intValue() != 0 ? "QUERY" : "ACQUIRE_CONTENT_PROVIDER_CLIENT", str, AnonymousClass000.A06("xapp comm to ", str, AnonymousClass000.A09()));
    }

    public C02240Aa(C0AQ c0aq, int i) {
        this.A01 = c0aq;
        this.A00 = i;
    }
}
