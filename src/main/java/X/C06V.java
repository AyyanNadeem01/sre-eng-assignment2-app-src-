package X;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.AbstractMutableCollection;

/* renamed from: X.06V, reason: invalid class name */
/* loaded from: classes.dex */
public final class C06V<V> extends AbstractMutableCollection<V> implements Collection<V>, C00T {
    public final C004602a A00;

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        C06E.A07(collection, 0);
        this.A00.A06();
        return super.removeAll(collection);
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        C06E.A07(collection, 0);
        this.A00.A06();
        return super.retainAll(collection);
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.A00.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.A00.containsValue(obj);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.A00.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C013906d(this.A00);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        C004602a c004602a = this.A00;
        c004602a.A06();
        int i = c004602a.A01;
        while (true) {
            i--;
            if (i < 0) {
                return false;
            }
            if (c004602a.A0A[i] >= 0) {
                Object[] objArr = c004602a.A0C;
                C06E.A06(objArr);
                if (C06E.areEqual(objArr[i], obj)) {
                    C004602a.A03(c004602a, i);
                    return true;
                }
            }
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return this.A00.size();
    }

    public C06V(C004602a c004602a) {
        this.A00 = c004602a;
    }

    public C06V() {
    }
}
