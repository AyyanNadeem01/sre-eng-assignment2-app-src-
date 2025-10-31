package X;

import android.os.Process;

/* renamed from: X.09J */
/* loaded from: classes.dex */
public final class C09J implements AnonymousClass095 {
    @Override // X.AnonymousClass095
    public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) throws IllegalArgumentException {
        C06E.A07(c05c, 0);
        c05c.A02(AnonymousClass094.A3m, Process.getThreadPriority(Process.myPid()));
    }

    @Override // X.AnonymousClass095
    public final Integer AGY() {
        return AnonymousClass065.A0w;
    }
}
