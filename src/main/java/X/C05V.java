package X;

import com.facebook.lite.SharedPreferencesHookA11;
import java.util.List;

/* renamed from: X.05V, reason: invalid class name */
/* loaded from: classes.dex */
public final class C05V {
    public final C05T A00;
    public final List A01;
    public final boolean A02;

    public C05V(C05T c05t, List list) {
        this(c05t, list, false);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C05V)) {
            return false;
        }
        C05V c05v = (C05V) obj;
        return this.A01.equals(c05v.A01) && this.A00.A01.A00(c05v.A00.A01);
    }

    public final int hashCode() {
        int iHashCode = (SharedPreferencesHookA11.QueuedWorkFix.EXECUTE_TRANSACTION + this.A01.hashCode()) * 53;
        C05O c05o = this.A00.A01;
        return ((iHashCode + c05o.A00) * 53) + c05o.A03.hashCode();
    }

    public C05V(C05T c05t, List list, boolean z) {
        if (!list.isEmpty()) {
            this.A00 = c05t;
            this.A01 = list;
            this.A02 = z;
            return;
        }
        throw new IllegalArgumentException();
    }
}
