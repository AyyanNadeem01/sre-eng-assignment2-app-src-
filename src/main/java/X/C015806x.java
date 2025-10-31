package X;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: X.06x, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C015806x implements ListIterator, C00R {
    public int A00;
    public int A01;
    public int A02 = -1;
    public final C015706w A03;

    private final void A00() {
        if (((AbstractList) this.A03.A03).modCount != this.A00) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.A01 < this.A03.A00;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.A01 > 0;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.A01 - 1;
    }

    public C015806x(C015706w c015706w, int i) {
        this.A03 = c015706w;
        this.A01 = i;
        this.A00 = ((AbstractList) c015706w).modCount;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        A00();
        C015706w c015706w = this.A03;
        int i = this.A01;
        this.A01 = i + 1;
        c015706w.add(i, obj);
        this.A02 = -1;
        this.A00 = ((AbstractList) c015706w).modCount;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        A00();
        int i = this.A01;
        C015706w c015706w = this.A03;
        if (i >= c015706w.A00) {
            throw new NoSuchElementException();
        }
        this.A01 = i + 1;
        this.A02 = i;
        return c015706w.A01[c015706w.A02 + i];
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        A00();
        int i = this.A01;
        if (i <= 0) {
            throw new NoSuchElementException();
        }
        int i2 = i - 1;
        this.A01 = i2;
        this.A02 = i2;
        C015706w c015706w = this.A03;
        return c015706w.A01[c015706w.A02 + i2];
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        A00();
        int i = this.A02;
        if (i == -1) {
            throw AnonymousClass000.A04("Call next() or previous() before removing element from the iterator.");
        }
        C015706w c015706w = this.A03;
        c015706w.remove(i);
        this.A01 = this.A02;
        this.A02 = -1;
        this.A00 = ((AbstractList) c015706w).modCount;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        A00();
        int i = this.A02;
        if (i == -1) {
            throw AnonymousClass000.A04("Call next() or previous() before replacing element from the iterator.");
        }
        this.A03.set(i, obj);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.A01;
    }
}
