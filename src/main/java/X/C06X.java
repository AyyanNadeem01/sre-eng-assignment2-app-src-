package X;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.markers.KMutableSet;

/* renamed from: X.06X, reason: invalid class name */
/* loaded from: classes.dex */
public final class C06X<E> extends C07S<E> implements Set<E>, KMutableSet {
    public final C004602a A00;

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        C06E.A07(collection, 0);
        this.A00.A06();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        C06E.A07(collection, 0);
        this.A00.A06();
        return super.retainAll(collection);
    }

    @Override // X.C07S
    public final int A00() {
        return this.A00.size();
    }

    @Override // X.C07S, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.A00.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.A00.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.A00.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C014006e(this.A00);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        C004602a c004602a = this.A00;
        c004602a.A06();
        int iA00 = C004602a.A00(obj, c004602a);
        if (iA00 < 0) {
            return false;
        }
        C004602a.A03(c004602a, iA00);
        return true;
    }

    public C06X(C004602a c004602a) {
        this.A00 = c004602a;
    }
}
