package X;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* renamed from: X.00f, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC000200f<E> extends AbstractC000100e<E> implements List<E>, C00R {
    @Override // java.util.List
    public abstract Object get(int i);

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        C06E.A07(collection, 1);
        if (size() != collection.size()) {
            return false;
        }
        Iterator<E> it = collection.iterator();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            if (!C06E.areEqual(it2.next(), it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // X.AbstractC000100e, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C013605z(this);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new C08B(this, i);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        return new C08A(this, i, i2);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (C06E.areEqual(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (C06E.areEqual(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new C08B(this, 0);
    }
}
