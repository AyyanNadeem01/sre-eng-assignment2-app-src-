package X;

import android.os.SystemClock;

/* renamed from: X.09I */
/* loaded from: classes.dex */
public final class C09I implements AnonymousClass095 {
    public long A00;
    public Integer A01;

    @Override // X.AnonymousClass095
    public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) {
        AnonymousClass091 anonymousClass091;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jUptimeMillis = SystemClock.uptimeMillis() - this.A00;
        Integer num = this.A01;
        if (num == AnonymousClass065.A00) {
            C05C.A00(AnonymousClass094.A39, c05c, jCurrentTimeMillis);
            anonymousClass091 = AnonymousClass094.A3B;
        } else {
            if (num != AnonymousClass065.A01) {
                return;
            }
            C05C.A00(AnonymousClass094.A2G, c05c, jCurrentTimeMillis);
            anonymousClass091 = AnonymousClass094.A2H;
        }
        C05C.A00(anonymousClass091, c05c, jUptimeMillis);
    }

    @Override // X.AnonymousClass095
    public final Integer AGY() {
        return AnonymousClass065.A0d;
    }
}
