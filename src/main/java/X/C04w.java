package X;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: X.04w */
/* loaded from: classes.dex */
public final class C04w {
    public static final Set A0E = new HashSet();
    public final C008803x A00;
    public final C011104v A01;
    public final C0CK A02;
    public final boolean A09;
    public final int A0A;
    public final C011304y A0B;
    public volatile boolean A0C;
    public volatile boolean A0D;
    public final Map A07 = new HashMap(EnumC011204x.values().length, 1.0f);
    public final Object A03 = new Object();
    public final Map A06 = new HashMap();
    public final Set A08 = new HashSet();
    public final Map A05 = new HashMap();
    public final Map A04 = new HashMap();

    public final void A05(C05C c05c, AnonymousClass057 anonymousClass057, InterfaceC02430Ba interfaceC02430Ba) {
        A07(c05c, anonymousClass057, interfaceC02430Ba, interfaceC02430Ba.AFf(), 0);
    }

    public final void A06(final C05C c05c, final AnonymousClass057 anonymousClass057, final InterfaceC02430Ba interfaceC02430Ba) {
        if (this.A09) {
            C022009w.A05.execute(new Runnable() { // from class: X.05D
                public static final String __redex_internal_original_name = "CollectorManager$$ExternalSyntheticLambda1";

                @Override // java.lang.Runnable
                public final void run() {
                    C04w c04w = this;
                    InterfaceC02430Ba interfaceC02430Ba2 = interfaceC02430Ba;
                    AnonymousClass057 anonymousClass0572 = anonymousClass057;
                    C05C c05c2 = c05c;
                    try {
                        c04w.A0B(anonymousClass0572, interfaceC02430Ba2);
                        c04w.A07(c05c2, anonymousClass0572, interfaceC02430Ba2, interfaceC02430Ba2.AFf(), 0);
                        c04w.A0A(anonymousClass0572, interfaceC02430Ba2);
                    } catch (Throwable th) {
                        C0C5.A00();
                        C018108b.A0H("lacrima", "Failed to apply collectors: %s", th, interfaceC02430Ba2.AGX());
                    }
                }
            });
            return;
        }
        A0B(anonymousClass057, interfaceC02430Ba);
        A07(c05c, anonymousClass057, interfaceC02430Ba, interfaceC02430Ba.AFf(), 0);
        A0A(anonymousClass057, interfaceC02430Ba);
    }

    public static String A00(AnonymousClass057 anonymousClass057, EnumC011204x enumC011204x, String str, int i) {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append(anonymousClass057.A00);
        if (i == 0) {
            string = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append("_");
            string = sb2.toString();
        }
        sb.append(string);
        sb.append(enumC011204x.A01 ? "suppl_" : "");
        sb.append(enumC011204x.A00);
        sb.append(str);
        return sb.toString();
    }

    private List A01(AnonymousClass057 anonymousClass057, InterfaceC02430Ba interfaceC02430Ba, Map map) {
        List arrayList;
        synchronized (this.A03) {
            Map map2 = (Map) map.get(anonymousClass057);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(anonymousClass057, map2);
            }
            arrayList = (List) map2.get(interfaceC02430Ba);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map2.put(interfaceC02430Ba, arrayList);
            }
        }
        return arrayList;
    }

    public final InterfaceC02430Ba A03(Class cls) {
        synchronized (this.A03) {
            for (InterfaceC02430Ba interfaceC02430Ba : this.A08) {
                if (cls.isInstance(interfaceC02430Ba)) {
                    return interfaceC02430Ba;
                }
            }
            return null;
        }
    }

    public final void A04(AnonymousClass095 anonymousClass095, AnonymousClass057 anonymousClass057, InterfaceC02430Ba interfaceC02430Ba) {
        synchronized (this.A03) {
            Map map = this.A06;
            Map map2 = (Map) map.get(anonymousClass057);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(anonymousClass057, map2);
            }
            List arrayList = (List) map2.get(interfaceC02430Ba);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map2.put(interfaceC02430Ba, arrayList);
            }
            arrayList.add(anonymousClass095);
        }
    }

    public final void A08(AnonymousClass058 anonymousClass058, AnonymousClass057 anonymousClass057, InterfaceC02430Ba interfaceC02430Ba) {
        synchronized (this.A03) {
            A01(anonymousClass057, interfaceC02430Ba, this.A04).add(anonymousClass058);
        }
    }

    public final void A09(AnonymousClass058 anonymousClass058, AnonymousClass057 anonymousClass057, InterfaceC02430Ba interfaceC02430Ba) {
        synchronized (this.A03) {
            A01(anonymousClass057, interfaceC02430Ba, this.A05).add(anonymousClass058);
        }
    }

    public C04w(C008803x c008803x, C011104v c011104v, C0CK c0ck, int i, boolean z, boolean z2) {
        this.A02 = c0ck;
        this.A01 = c011104v;
        this.A00 = c008803x;
        this.A09 = z;
        if (i > 0 && i < 64) {
            i = 64;
        }
        this.A0A = i;
        this.A0B = new C011304y(i, z2);
    }

    public static void A02(AnonymousClass057 anonymousClass057, InterfaceC02430Ba interfaceC02430Ba, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((AnonymousClass058) it.next()).AYi(anonymousClass057, interfaceC02430Ba);
            } catch (Throwable th) {
                C0C5.A00();
                C018108b.A0C("lacrima", "onNotify failed...", th);
            }
        }
    }

    public final void A0A(AnonymousClass057 anonymousClass057, InterfaceC02430Ba interfaceC02430Ba) {
        C0C5.A00();
        A02(anonymousClass057, interfaceC02430Ba, A01(anonymousClass057, interfaceC02430Ba, this.A04));
        C0C5.A00();
    }

    public final void A0B(AnonymousClass057 anonymousClass057, InterfaceC02430Ba interfaceC02430Ba) {
        C0C5.A00();
        A02(anonymousClass057, interfaceC02430Ba, A01(anonymousClass057, interfaceC02430Ba, this.A05));
        C0C5.A00();
    }

    /* JADX WARN: Removed duplicated region for block: B:437:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A07(X.C05C r23, X.AnonymousClass057 r24, X.InterfaceC02430Ba r25, X.AnonymousClass046 r26, int r27) {
        /*
            Method dump skipped, instructions count: 704
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C04w.A07(X.05C, X.057, X.0Ba, X.046, int):void");
    }
}
