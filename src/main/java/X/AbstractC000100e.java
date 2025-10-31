package X;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: X.00e */
/* loaded from: classes.dex */
public abstract class AbstractC000100e<E> implements Collection<E>, C00R {
    public abstract int A00();

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        C06E.A07(collection, 0);
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator iterator();

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        C06E.A07(objArr, 0);
        return AbstractC003501p.A01(this, objArr);
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        if (!(this instanceof Collection) || !isEmpty()) {
            Iterator it = iterator();
            while (it.hasNext()) {
                if (C06E.areEqual(it.next(), obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final String toString() {
        return C01W.A0J(", ", "[", "]", this, new AnonymousClass005() { // from class: X.08X
            @Override // X.AnonymousClass005
            public final Object invoke(Object obj) {
                return obj == this.A00 ? "(this Collection)" : String.valueOf(obj);
            }
        });
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return A00();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return AbstractC003501p.A00(this);
    }
}
