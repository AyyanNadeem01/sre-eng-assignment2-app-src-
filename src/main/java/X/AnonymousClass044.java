package X;

import com.facebook.errorreporting.field.ReportFieldString;

/* renamed from: X.044, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass044 implements AnonymousClass095 {
    public final /* synthetic */ C05B A00;

    public AnonymousClass044(C05B c05b) {
        this.A00 = c05b;
    }

    @Override // X.AnonymousClass095
    public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) {
        ReportFieldString reportFieldString = AnonymousClass094.AAZ;
        C0AZ c0az = this.A00.A00;
        c05c.A04(reportFieldString, (String) c0az.A0U.get());
        c05c.A01(AnonymousClass094.A0K, ((Boolean) c0az.A0O.get()).booleanValue());
        c05c.A04(AnonymousClass094.A3s, (String) c0az.A0L.get());
        c05c.A04(AnonymousClass094.A3o, (String) c0az.A0K.get());
    }

    @Override // X.AnonymousClass095
    public final Integer AGY() {
        return AnonymousClass065.A0e;
    }

    public AnonymousClass044() {
    }
}
