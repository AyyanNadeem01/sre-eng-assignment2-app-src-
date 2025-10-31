package X;

import com.facebook.systrace.Systrace;

/* renamed from: X.09S, reason: invalid class name */
/* loaded from: classes.dex */
public final class C09S extends C09X {
    public long A00;
    public C021309n A01 = new C021309n();
    public C09Y A02;
    public String A03;

    @Override // X.C09X
    public final void A00() {
        long j = this.A00;
        String str = this.A03;
        C021309n c021309n = this.A01;
        if (Systrace.A0G(j)) {
            Systrace.A0F(str, c021309n.A01, c021309n.A00, j);
        }
    }

    @Override // X.C09X
    public final void A01(Object obj, String str) {
        this.A01.A00(str, String.valueOf(obj));
    }

    @Override // X.C09X
    public final void A02(String str, int i) {
        this.A01.A00(str, Integer.toString(i));
    }
}
