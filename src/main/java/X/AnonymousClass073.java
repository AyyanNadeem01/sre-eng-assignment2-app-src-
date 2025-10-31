package X;

import java.util.Iterator;

/* renamed from: X.073, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass073 implements Iterable, C00R {
    public final C01O A00;

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new AnonymousClass072((Iterator) this.A00.invoke());
    }

    public AnonymousClass073(C01O c01o) {
        this.A00 = c01o;
    }
}
