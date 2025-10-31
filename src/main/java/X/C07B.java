package X;

import java.util.Iterator;

/* renamed from: X.07B, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C07B implements Iterator, C00R {
    public abstract byte A00();

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Byte.valueOf(A00());
    }
}
