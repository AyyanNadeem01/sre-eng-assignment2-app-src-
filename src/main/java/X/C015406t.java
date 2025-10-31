package X;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: X.06t, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C015406t<E> extends AnonymousClass082<E> implements List<E>, RandomAccess, Serializable, AnonymousClass083 {
    public static final C015406t A03;
    public int A00;
    public boolean A01;
    public Object[] A02 = new Object[10];

    static {
        C015406t c015406t = new C015406t();
        c015406t.A02 = new Object[0];
        c015406t.A01 = true;
        A03 = c015406t;
    }

    public static final int A00(Collection collection, C015406t c015406t, int i, int i2, boolean z) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            if (collection.contains(c015406t.A02[i + i3]) == z) {
                Object[] objArr = c015406t.A02;
                objArr[i4 + i] = objArr[i3 + i];
                i4++;
                i3++;
            } else {
                i3++;
            }
        }
        int i5 = i2 - i4;
        Object[] objArr2 = c015406t.A02;
        AbstractC003901t.A02(objArr2, objArr2, i + i4, i2 + i, c015406t.A00);
        Object[] objArr3 = c015406t.A02;
        int i6 = c015406t.A00;
        AbstractC015306s.A01(objArr3, i6 - i5, i6);
        if (i5 > 0) {
            ((AbstractList) c015406t).modCount++;
        }
        c015406t.A00 -= i5;
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        C06E.A07(collection, 1);
        A06(this);
        AnonymousClass060.A02(i, this.A00);
        int size = collection.size();
        A05(collection, this, i, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.A00; i++) {
            if (C06E.areEqual(this.A02[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        C06E.A07(collection, 0);
        A06(this);
        return A00(collection, this, 0, this.A00, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        C06E.A07(collection, 0);
        A06(this);
        return A00(collection, this, 0, this.A00, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        AnonymousClass060.A03(i, i2, this.A00);
        return new C015706w(null, this, this.A02, i, i2 - i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        C06E.A07(objArr, 0);
        int length = objArr.length;
        int i = this.A00;
        Object[] objArr2 = this.A02;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, 0, i, objArr.getClass());
            C06E.A03(objArrCopyOfRange);
            return objArrCopyOfRange;
        }
        AbstractC003901t.A02(objArr2, objArr, 0, 0, i);
        int i2 = this.A00;
        if (i2 >= length) {
            return objArr;
        }
        objArr[i2] = null;
        return objArr;
    }

    public static final Object A02(C015406t c015406t, int i) {
        ((AbstractList) c015406t).modCount++;
        Object[] objArr = c015406t.A02;
        Object obj = objArr[i];
        int i2 = i + 1;
        System.arraycopy(objArr, i2, objArr, i, c015406t.A00 - i2);
        Object[] objArr2 = c015406t.A02;
        int i3 = c015406t.A00 - 1;
        C06E.A07(objArr2, 0);
        objArr2[i3] = null;
        c015406t.A00--;
        return obj;
    }

    private final void A03(int i, int i2) {
        int i3 = this.A00 + i2;
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArrCopyOf = this.A02;
        int length = objArrCopyOf.length;
        if (i3 > length) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, AnonymousClass060.A00(length, i3));
            C06E.A03(objArrCopyOf);
            this.A02 = objArrCopyOf;
        }
        AbstractC003901t.A02(objArrCopyOf, objArrCopyOf, i + i2, i, this.A00);
        this.A00 += i2;
    }

    public static final void A04(Object obj, C015406t c015406t, int i) {
        ((AbstractList) c015406t).modCount++;
        c015406t.A03(i, 1);
        c015406t.A02[i] = obj;
    }

    public static final void A05(Collection collection, C015406t c015406t, int i, int i2) {
        ((AbstractList) c015406t).modCount++;
        c015406t.A03(i, i2);
        Iterator<E> it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            c015406t.A02[i + i3] = it.next();
        }
    }

    public static final void A06(C015406t c015406t) {
        if (c015406t.A01) {
            throw new UnsupportedOperationException();
        }
    }

    public static final void A07(C015406t c015406t, int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) c015406t).modCount++;
        }
        Object[] objArr = c015406t.A02;
        AbstractC003901t.A02(objArr, objArr, i, i + i2, c015406t.A00);
        Object[] objArr2 = c015406t.A02;
        int i3 = c015406t.A00;
        AbstractC015306s.A01(objArr2, i3 - i2, i3);
        c015406t.A00 -= i2;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        Object[] objArr = this.A02;
        int i = this.A00;
        if (i != list.size()) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (!C06E.areEqual(objArr[i2], list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        AnonymousClass060.A01(i, this.A00);
        return this.A02[i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.A02;
        int i = this.A00;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.A00 == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int i = this.A00;
        do {
            i--;
            if (i < 0) {
                return -1;
            }
        } while (!C06E.areEqual(this.A02[i], obj));
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        AnonymousClass060.A02(i, this.A00);
        return new C015506u(this, i);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return AbstractC015306s.A00(this, this.A02, 0, this.A00);
    }

    @Override // X.AnonymousClass082
    public final Object A09(int i) {
        A06(this);
        AnonymousClass060.A01(i, this.A00);
        return A02(this, i);
    }

    @Override // X.AnonymousClass082, java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        A06(this);
        AnonymousClass060.A02(i, this.A00);
        A04(obj, this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        A06(this);
        A07(this, 0, this.A00);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        A06(this);
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // X.AnonymousClass082, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        A06(this);
        AnonymousClass060.A01(i, this.A00);
        Object[] objArr = this.A02;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // X.AnonymousClass082
    public final int A08() {
        return this.A00;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        A06(this);
        A04(obj, this, this.A00);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        C06E.A07(collection, 0);
        A06(this);
        int size = collection.size();
        A05(collection, this, this.A00, size);
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
        Object[] objArr = this.A02;
        int i = this.A00;
        C06E.A07(objArr, 0);
        AbstractC003701r.A00(i, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, 0, i);
        C06E.A03(objArrCopyOfRange);
        return objArrCopyOfRange;
    }
}
