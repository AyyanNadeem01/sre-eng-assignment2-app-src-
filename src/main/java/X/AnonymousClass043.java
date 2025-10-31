package X;

import android.app.ActivityManager;
import android.content.Context;

/* renamed from: X.043, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass043 implements AnonymousClass095 {
    public Context A00;

    @Override // X.AnonymousClass095
    public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) {
        ActivityManager activityManager = (ActivityManager) this.A00.getSystemService("activity");
        if (activityManager != null) {
            c05c.A02(AnonymousClass094.A2O, activityManager.getMemoryClass());
            c05c.A02(AnonymousClass094.A21, activityManager.getLargeMemoryClass());
        }
    }

    @Override // X.AnonymousClass095
    public final Integer AGY() {
        return AnonymousClass065.A0L;
    }
}
