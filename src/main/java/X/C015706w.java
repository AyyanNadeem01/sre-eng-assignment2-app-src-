package X;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: X.06w, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C015706w<E> extends AnonymousClass082<E> implements List<E>, RandomAccess, Serializable, AnonymousClass083 {
    public int A00;
    public Object[] A01;
    public final int A02;
    public final C015406t A03;
    public final C015706w A04;

    public C015706w(C015706w c015706w, C015406t c015406t, Object[] objArr, int i, int i2) {
        C06E.A07(objArr, 1);
        C06E.A07(c015406t, 5);
        this.A01 = objArr;
        this.A02 = i;
        this.A00 = i2;
        this.A04 = c015706w;
        this.A03 = c015406t;
        ((AbstractList) this).modCount = ((AbstractList) c015406t).modCount;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        C06E.A07(collection, 1);
        A04();
        A03();
        AnonymousClass060.A02(i, this.A00);
        int size = collection.size();
        A07(this.A02 + i, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        C06E.A07(collection, 0);
        A04();
        A03();
        return A00(collection, this.A02, this.A00, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        C06E.A07(collection, 0);
        A04();
        A03();
        return A00(collection, this.A02, this.A00, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        AnonymousClass060.A03(i, i2, this.A00);
        return new C015706w(this, this.A03, this.A01, this.A02 + i, i2 - i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        C06E.A07(objArr, 0);
        A03();
        int length = objArr.length;
        int i = this.A00;
        Object[] objArr2 = this.A01;
        int i2 = this.A02;
        int i3 = i + i2;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, i2, i3, objArr.getClass());
            C06E.A03(objArrCopyOfRange);
            return objArrCopyOfRange;
        }
        AbstractC003901t.A02(objArr2, objArr, 0, i2, i3);
        int i4 = this.A00;
        if (i4 >= length) {
            return objArr;
        }
        objArr[i4] = null;
        return objArr;
    }

    private final int A00(Collection collection, int i, int i2, boolean z) {
        C015706w c015706w = this.A04;
        int iA00 = c015706w != null ? c015706w.A00(collection, i, i2, z) : C015406t.A00(collection, this.A03, i, i2, z);
        if (iA00 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.A00 -= iA00;
        return iA00;
    }

    private final Object A02(int i) {
        ((AbstractList) this).modCount++;
        C015706w c015706w = this.A04;
        this.A00--;
        return c015706w != null ? c015706w.A02(i) : C015406t.A02(this.A03, i);
    }

    private final void A03() {
        if (((AbstractList) this.A03).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void A04() {
        C015406t c015406t = this.A03;
        C015406t c015406t2 = C015406t.A03;
        if (c015406t.A01) {
            throw new UnsupportedOperationException();
        }
    }

    private final void A05(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        C015706w c015706w = this.A04;
        if (c015706w != null) {
            c015706w.A05(i, i2);
        } else {
            C015406t.A07(this.A03, i, i2);
        }
        this.A00 -= i2;
    }

    private final void A06(int i, Object obj) {
        ((AbstractList) this).modCount++;
        C015706w c015706w = this.A04;
        if (c015706w != null) {
            c015706w.A06(i, obj);
        } else {
            C015406t.A04(obj, this.A03, i);
        }
        C015406t c015406t = this.A03;
        C015406t c015406t2 = C015406t.A03;
        this.A01 = c015406t.A02;
        this.A00++;
    }

    private final void A07(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        C015706w c015706w = this.A04;
        if (c015706w != null) {
            c015706w.A07(i, collection, i2);
        } else {
            C015406t.A05(collection, this.A03, i, i2);
        }
        C015406t c015406t = this.A03;
        C015406t c015406t2 = C015406t.A03;
        this.A01 = c015406t.A02;
        this.A00 += i2;
    }

    @Override // X.AnonymousClass082
    public final int A08() {
        A03();
        return this.A00;
    }

    @Override // X.AnonymousClass082
    public final Object A09(int i) {
        A04();
        A03();
        AnonymousClass060.A01(i, this.A00);
        return A02(this.A02 + i);
    }

    @Override // X.AnonymousClass082, java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        A04();
        A03();
        AnonymousClass060.A02(i, this.A00);
        A06(this.A02 + i, obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        A04();
        A03();
        A05(this.A02, this.A00);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        A03();
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        Object[] objArr = this.A01;
        int i = this.A02;
        int i2 = this.A00;
        if (i2 != list.size()) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!C06E.areEqual(objArr[i + i3], list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        A03();
        AnonymousClass060.A01(i, this.A00);
        return this.A01[this.A02 + i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        A03();
        Object[] objArr = this.A01;
        int i = this.A02;
        int i2 = this.A00;
        int iHashCode = 1;
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = objArr[i + i3];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        A03();
        for (int i = 0; i < this.A00; i++) {
            if (C06E.areEqual(this.A01[this.A02 + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        A03();
        return this.A00 == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        A03();
        int i = this.A00;
        do {
            i--;
            if (i < 0) {
                return -1;
            }
        } while (!C06E.areEqual(this.A01[this.A02 + i], obj));
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        A03();
        AnonymousClass060.A02(i, this.A00);
        return new C015806x(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        A04();
        A03();
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // X.AnonymousClass082, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        A04();
        A03();
        AnonymousClass060.A01(i, this.A00);
        Object[] objArr = this.A01;
        int i2 = this.A02 + i;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        A03();
        return AbstractC015306s.A00(this, this.A01, this.A02, this.A00);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        A04();
        A03();
        A06(this.A02 + this.A00, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        C06E.A07(collection, 0);
        A04();
        A03();
        int size = collection.size();
        A07(this.A02 + this.A00, collection, size);
        if (size <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        A03();
        Object[] objArr = this.A01;
        int i = this.A02;
        int i2 = this.A00 + i;
        C06E.A07(objArr, 0);
        AbstractC003701r.A00(i2, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i2);
        C06E.A03(objArrCopyOfRange);
        return objArrCopyOfRange;
    }
}
