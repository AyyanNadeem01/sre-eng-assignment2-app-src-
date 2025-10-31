package X;

import java.util.RandomAccess;

/* renamed from: X.08A */
/* loaded from: classes.dex */
public final class C08A<E> extends AbstractC000200f<E> implements RandomAccess {
    public int A00;
    public final int A01;
    public final AbstractC000200f A02;

    @Override // X.AbstractC000200f, java.util.List
    public final Object get(int i) {
        AnonymousClass060.A01(i, this.A00);
        return this.A02.get(this.A01 + i);
    }

    public C08A(AbstractC000200f abstractC000200f, int i, int i2) {
        this.A02 = abstractC000200f;
        this.A01 = i;
        AnonymousClass060.A03(i, i2, abstractC000200f.size());
        this.A00 = i2 - i;
    }

    @Override // X.AbstractC000100e
    public final int A00() {
        return this.A00;
    }
}
