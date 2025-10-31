package X;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: X.08B */
/* loaded from: classes.dex */
public final class C08B extends C013605z implements ListIterator, C00R {
    public final /* synthetic */ AbstractC000200f A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C08B(AbstractC000200f abstractC000200f, int i) {
        super(abstractC000200f);
        this.A00 = abstractC000200f;
        AnonymousClass060.A02(i, abstractC000200f.size());
        super.A00 = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return super.A00 > 0;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return super.A00 - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        AbstractC000200f abstractC000200f = this.A00;
        int i = super.A00 - 1;
        super.A00 = i;
        return abstractC000200f.get(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return super.A00;
    }
}
