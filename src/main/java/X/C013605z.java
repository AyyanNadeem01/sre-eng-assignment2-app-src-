package X;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: X.05z */
/* loaded from: classes.dex */
public class C013605z implements Iterator, C00R {
    public int A00;
    public final /* synthetic */ AbstractC000200f A01;

    public C013605z(AbstractC000200f abstractC000200f) {
        this.A01 = abstractC000200f;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A00 < this.A01.size();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        AbstractC000200f abstractC000200f = this.A01;
        int i = this.A00;
        this.A00 = i + 1;
        return abstractC000200f.get(i);
    }
}
