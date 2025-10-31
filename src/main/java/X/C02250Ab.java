package X;

import android.app.Application;
import java.util.List;

/* renamed from: X.0Ab */
/* loaded from: classes.dex */
public final class C02250Ab {
    public int A00;
    public C09V A01;
    public C09V A02;
    public C09V A03;
    public C09V A04;
    public C09V A05;
    public C09V A06;
    public C09V A07;
    public C09V A08;
    public boolean A0A;
    public final Application A0B;
    public boolean A09 = true;
    public final List A0C = AnonymousClass000.A0B();
    public final List A0D = AnonymousClass000.A0B();
    public final List A0E = AnonymousClass000.A0B();
    public final List A0F = AnonymousClass000.A0B();

    public C02250Ab(Application application) {
        this.A0B = application;
    }

    public final void A00(C0AT c0at) {
        List list;
        int iIntValue = c0at.AL6().intValue();
        if (iIntValue == 0) {
            list = this.A0C;
        } else if (iIntValue == 1) {
            list = this.A0D;
        } else if (iIntValue == 2) {
            list = this.A0E;
        } else if (iIntValue != 3) {
            return;
        } else {
            list = this.A0F;
        }
        list.add(c0at);
    }
}
