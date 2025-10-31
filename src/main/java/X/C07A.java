package X;

import java.util.Iterator;

/* renamed from: X.07A, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C07A implements Iterator, C00R {
    public abstract char A00();

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Character.valueOf(A00());
    }
}
