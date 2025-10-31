package X;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: X.00p, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C001200p<T> implements Collection<T>, C00R {
    public final Object[] A00;
    public final boolean A01;

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        C06E.A07(collection, 0);
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

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

    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean contains(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object[] r3 = r4.A00
            r2 = 0
            int r1 = r3.length
            if (r5 != 0) goto Lf
        L6:
            if (r2 >= r1) goto L1f
            r0 = r3[r2]
            if (r0 == 0) goto L1c
            int r2 = r2 + 1
            goto L6
        Lf:
            if (r2 >= r1) goto L1f
            r0 = r3[r2]
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L1c
            int r2 = r2 + 1
            goto Lf
        L1c:
            r0 = 1
            if (r2 >= 0) goto L20
        L1f:
            r0 = 0
        L20:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C001200p.contains(java.lang.Object):boolean");
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.A00.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return C02Y.A00(this.A00);
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

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return this.A00.length;
    }

    public C001200p(Object[] objArr, boolean z) {
        this.A00 = objArr;
        this.A01 = z;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] objArr = this.A00;
        if (this.A01 && C06E.areEqual(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        C06E.A03(objArrCopyOf);
        return objArrCopyOf;
    }
}
