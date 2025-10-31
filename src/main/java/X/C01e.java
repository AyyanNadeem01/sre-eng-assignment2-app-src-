package X;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: X.01e, reason: invalid class name */
/* loaded from: classes.dex */
public final class C01e implements Set, Serializable, C00R {
    public static final C01e A00 = new C01e();

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        C06E.A07(collection, 0);
        return collection.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        C06E.A07(objArr, 0);
        return AbstractC003501p.A01(this, objArr);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return C002901j.A00;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return 0;
    }

    public final String toString() {
        return "[]";
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return AbstractC003501p.A00(this);
    }
}
