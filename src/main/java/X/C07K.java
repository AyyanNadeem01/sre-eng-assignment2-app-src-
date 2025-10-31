package X;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: X.07K, reason: invalid class name */
/* loaded from: classes.dex */
public final class C07K<E> extends AnonymousClass082<E> {
    public static final Object[] A03 = new Object[0];
    public int A00;
    public Object[] A01 = A03;
    public int A02;

    private final void A02(int i, int i2) {
        Object[] objArr = this.A01;
        if (i < i2) {
            C06E.A07(objArr, 0);
            Arrays.fill(objArr, i, i2, (Object) null);
        } else {
            Arrays.fill(objArr, i, objArr.length, (Object) null);
            Object[] objArr2 = this.A01;
            C06E.A07(objArr2, 0);
            Arrays.fill(objArr2, 0, i2, (Object) null);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        C06E.A07(collection, 1);
        AnonymousClass060.A02(i, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(collection);
        }
        ((AbstractList) this).modCount++;
        A01(size() + collection.size());
        int iA00 = A00(this);
        int length = this.A01.length;
        if (iA00 >= length) {
            iA00 -= length;
        }
        int length2 = this.A00 + i;
        if (length2 >= length) {
            length2 -= length;
        }
        int size = collection.size();
        if (i < ((size() + 1) >> 1)) {
            int i2 = this.A00;
            int i3 = i2 - size;
            if (length2 < i2) {
                Object[] objArr = this.A01;
                System.arraycopy(objArr, i2, objArr, i3, objArr.length - i2);
                Object[] objArr2 = this.A01;
                int length3 = objArr2.length - size;
                if (size >= length2) {
                    System.arraycopy(objArr2, 0, objArr2, length3, length2);
                } else {
                    System.arraycopy(objArr2, 0, objArr2, length3, size);
                    Object[] objArr3 = this.A01;
                    AbstractC003901t.A02(objArr3, objArr3, 0, size, length2);
                }
            } else if (i3 >= 0) {
                Object[] objArr4 = this.A01;
                AbstractC003901t.A02(objArr4, objArr4, i3, i2, length2);
            } else {
                Object[] objArr5 = this.A01;
                int length4 = objArr5.length;
                i3 += length4;
                int i4 = length2 - i2;
                int i5 = length4 - i3;
                if (i5 >= i4) {
                    System.arraycopy(objArr5, i2, objArr5, i3, i4);
                } else {
                    System.arraycopy(objArr5, i2, objArr5, i3, (i2 + i5) - i2);
                    Object[] objArr6 = this.A01;
                    AbstractC003901t.A02(objArr6, objArr6, 0, this.A00 + i5, length2);
                }
            }
            this.A00 = i3;
            length2 -= size;
            if (length2 < 0) {
                length2 += this.A01.length;
            }
        } else {
            int i6 = length2 + size;
            if (length2 < iA00) {
                int i7 = size + iA00;
                Object[] objArr7 = this.A01;
                int length5 = objArr7.length;
                if (i7 <= length5) {
                    System.arraycopy(objArr7, length2, objArr7, i6, iA00 - length2);
                } else if (i6 >= length5) {
                    i6 -= length5;
                    System.arraycopy(objArr7, length2, objArr7, i6, iA00 - length2);
                } else {
                    int i8 = i7 - length5;
                    int i9 = iA00 - i8;
                    System.arraycopy(objArr7, i9, objArr7, 0, iA00 - i9);
                    Object[] objArr8 = this.A01;
                    AbstractC003901t.A02(objArr8, objArr8, i6, length2, iA00 - i8);
                }
            } else {
                Object[] objArr9 = this.A01;
                AbstractC003901t.A02(objArr9, objArr9, size, 0, iA00);
                Object[] objArr10 = this.A01;
                int length6 = objArr10.length;
                if (i6 >= length6) {
                    System.arraycopy(objArr10, length2, objArr10, i6 - length6, length6 - length2);
                } else {
                    int i10 = length6 - size;
                    System.arraycopy(objArr10, i10, objArr10, 0, length6 - i10);
                    Object[] objArr11 = this.A01;
                    System.arraycopy(objArr11, length2, objArr11, i6, (objArr11.length - size) - length2);
                }
            }
        }
        A03(collection, length2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        Object[] objArr;
        boolean z = false;
        C06E.A07(collection, 0);
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.A01.length != 0) {
            int iA00 = A00(this);
            int length = this.A01.length;
            if (iA00 >= length) {
                iA00 -= length;
            }
            int i = this.A00;
            int i2 = i;
            if (i < iA00) {
                while (true) {
                    objArr = this.A01;
                    if (i >= iA00) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        z2 = true;
                    } else {
                        this.A01[i2] = obj;
                        i2++;
                    }
                    i++;
                }
                C06E.A07(objArr, 0);
                Arrays.fill(objArr, i2, iA00, (Object) null);
            } else {
                while (i < length) {
                    Object[] objArr2 = this.A01;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        z = true;
                    } else {
                        this.A01[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                int i3 = i2;
                int length2 = this.A01.length;
                if (i2 >= length2) {
                    i3 = i2 - length2;
                }
                i2 = i3;
                for (int i4 = 0; i4 < iA00; i4++) {
                    Object[] objArr3 = this.A01;
                    Object obj3 = objArr3[i4];
                    objArr3[i4] = null;
                    if (collection.contains(obj3)) {
                        z = true;
                    } else {
                        this.A01[i3] = obj3;
                        i3++;
                        if (i2 == r0.length - 1) {
                            i3 = 0;
                        }
                        i2 = i3;
                    }
                }
                z2 = z;
            }
            if (z2) {
                ((AbstractList) this).modCount++;
                int length3 = i2 - this.A00;
                if (length3 < 0) {
                    length3 += this.A01.length;
                }
                this.A02 = length3;
            }
        }
        return z2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        Object[] objArr;
        boolean z = false;
        C06E.A07(collection, 0);
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.A01.length != 0) {
            int iA00 = A00(this);
            int length = this.A01.length;
            if (iA00 >= length) {
                iA00 -= length;
            }
            int i = this.A00;
            int i2 = i;
            if (i < iA00) {
                while (true) {
                    objArr = this.A01;
                    if (i >= iA00) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        this.A01[i2] = obj;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                C06E.A07(objArr, 0);
                Arrays.fill(objArr, i2, iA00, (Object) null);
            } else {
                while (i < length) {
                    Object[] objArr2 = this.A01;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        this.A01[i2] = obj2;
                        i2++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                int i3 = i2;
                int length2 = this.A01.length;
                if (i2 >= length2) {
                    i3 = i2 - length2;
                }
                i2 = i3;
                for (int i4 = 0; i4 < iA00; i4++) {
                    Object[] objArr3 = this.A01;
                    Object obj3 = objArr3[i4];
                    objArr3[i4] = null;
                    if (collection.contains(obj3)) {
                        this.A01[i3] = obj3;
                        i3++;
                        if (i2 == r0.length - 1) {
                            i3 = 0;
                        }
                        i2 = i3;
                    } else {
                        z = true;
                    }
                }
                z2 = z;
            }
            if (z2) {
                ((AbstractList) this).modCount++;
                int length3 = i2 - this.A00;
                if (length3 < 0) {
                    length3 += this.A01.length;
                }
                this.A02 = length3;
            }
        }
        return z2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) throws NegativeArraySizeException {
        C06E.A07(objArr, 0);
        if (objArr.length < size()) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size());
            C06E.A08(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) objNewInstance;
        }
        int iA00 = A00(this);
        Object[] objArr2 = this.A01;
        int length = objArr2.length;
        if (iA00 >= length) {
            iA00 -= length;
        }
        int i = this.A00;
        if (i < iA00) {
            AbstractC003901t.A02(objArr2, objArr, 0, i, iA00);
        } else if (!isEmpty()) {
            Object[] objArr3 = this.A01;
            AbstractC003901t.A02(objArr3, objArr, 0, this.A00, objArr3.length);
            Object[] objArr4 = this.A01;
            AbstractC003901t.A02(objArr4, objArr, objArr4.length - this.A00, 0, iA00);
        }
        int size = size();
        C06E.A07(objArr, 1);
        if (size < objArr.length) {
            objArr[size] = null;
        }
        return objArr;
    }

    public static int A00(C07K c07k) {
        return c07k.A00 + c07k.size();
    }

    private final void A01(int i) {
        Object[] objArr;
        if (i < 0) {
            throw AnonymousClass000.A04("Deque is too big.");
        }
        Object[] objArr2 = this.A01;
        int length = objArr2.length;
        if (i > length) {
            if (objArr2 == A03) {
                if (i < 10) {
                    i = 10;
                }
                objArr = new Object[i];
            } else {
                objArr = new Object[AnonymousClass060.A00(length, i)];
                AbstractC003901t.A02(objArr2, objArr, 0, this.A00, length);
                Object[] objArr3 = this.A01;
                int length2 = objArr3.length;
                int i2 = this.A00;
                AbstractC003901t.A02(objArr3, objArr, length2 - i2, 0, i2);
                this.A00 = 0;
            }
            this.A01 = objArr;
        }
    }

    public final void addFirst(Object obj) {
        ((AbstractList) this).modCount++;
        A01(size() + 1);
        int length = this.A00;
        if (length == 0) {
            Object[] objArr = this.A01;
            C06E.A07(objArr, 0);
            length = objArr.length;
        }
        int i = length - 1;
        this.A00 = i;
        this.A01[i] = obj;
        this.A02 = size() + 1;
    }

    public final void addLast(Object obj) {
        ((AbstractList) this).modCount++;
        A01(size() + 1);
        Object[] objArr = this.A01;
        int iA00 = A00(this);
        int length = this.A01.length;
        if (iA00 >= length) {
            iA00 -= length;
        }
        objArr[iA00] = obj;
        this.A02 = size() + 1;
    }

    private final void A03(Collection collection, int i) {
        Iterator<E> it = collection.iterator();
        int length = this.A01.length;
        while (i < length && it.hasNext()) {
            this.A01[i] = it.next();
            i++;
        }
        int i2 = this.A00;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.A01[i3] = it.next();
        }
        this.A02 = size() + collection.size();
    }

    @Override // X.AnonymousClass082
    public final Object A09(int i) {
        AnonymousClass060.A01(i, size());
        if (i == size() - 1) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        ((AbstractList) this).modCount++;
        int i2 = this.A00 + i;
        Object[] objArr = this.A01;
        int length = objArr.length;
        if (i2 >= length) {
            i2 -= length;
        }
        Object obj = objArr[i2];
        int size = size() >> 1;
        int i3 = this.A00;
        if (i < size) {
            if (i2 >= i3) {
                Object[] objArr2 = this.A01;
                AbstractC003901t.A02(objArr2, objArr2, i3 + 1, i3, i2);
            } else {
                Object[] objArr3 = this.A01;
                AbstractC003901t.A02(objArr3, objArr3, 1, 0, i2);
                Object[] objArr4 = this.A01;
                int length2 = objArr4.length - 1;
                objArr4[0] = objArr4[length2];
                int i4 = this.A00;
                System.arraycopy(objArr4, i4, objArr4, i4 + 1, length2 - i4);
            }
            Object[] objArr5 = this.A01;
            int i5 = this.A00;
            objArr5[i5] = null;
            int length3 = objArr5.length - 1;
            int i6 = i5 + 1;
            if (i5 == length3) {
                i6 = 0;
            }
            this.A00 = i6;
        } else {
            int size2 = i3 + (size() - 1);
            Object[] objArr6 = this.A01;
            int length4 = objArr6.length;
            if (size2 >= length4) {
                size2 -= length4;
            }
            int i7 = i2 + 1;
            if (i2 <= size2) {
                System.arraycopy(objArr6, i7, objArr6, i2, (size2 + 1) - i7);
            } else {
                System.arraycopy(objArr6, i7, objArr6, i2, length4 - i7);
                Object[] objArr7 = this.A01;
                objArr7[objArr7.length - 1] = objArr7[0];
                System.arraycopy(objArr7, 1, objArr7, 0, (size2 + 1) - 1);
            }
            this.A01[size2] = null;
        }
        this.A02 = size() - 1;
        return obj;
    }

    @Override // X.AnonymousClass082, java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        AnonymousClass060.A02(i, size());
        if (i == size()) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        ((AbstractList) this).modCount++;
        A01(size() + 1);
        int i2 = this.A00 + i;
        int length2 = this.A01.length;
        if (i2 >= length2) {
            i2 -= length2;
        }
        if (i < ((size() + 1) >> 1)) {
            if (i2 == 0) {
                Object[] objArr = this.A01;
                C06E.A07(objArr, 0);
                length = objArr.length - 1;
            } else {
                length = i2 - 1;
            }
            int length3 = this.A00;
            if (length3 == 0) {
                Object[] objArr2 = this.A01;
                C06E.A07(objArr2, 0);
                length3 = objArr2.length;
            }
            int i3 = length3 - 1;
            int i4 = this.A00;
            Object[] objArr3 = this.A01;
            if (length >= i4) {
                objArr3[i3] = objArr3[i4];
                int i5 = i4 + 1;
                System.arraycopy(objArr3, i5, objArr3, i4, (length + 1) - i5);
            } else {
                System.arraycopy(objArr3, i4, objArr3, i4 - 1, objArr3.length - i4);
                Object[] objArr4 = this.A01;
                objArr4[objArr4.length - 1] = objArr4[0];
                System.arraycopy(objArr4, 1, objArr4, 0, (length + 1) - 1);
            }
            this.A01[length] = obj;
            this.A00 = i3;
        } else {
            int iA00 = A00(this);
            Object[] objArr5 = this.A01;
            int length4 = objArr5.length;
            if (iA00 >= length4) {
                iA00 -= length4;
            }
            if (i2 < iA00) {
                System.arraycopy(objArr5, i2, objArr5, i2 + 1, iA00 - i2);
            } else {
                System.arraycopy(objArr5, 0, objArr5, 1, iA00);
                Object[] objArr6 = this.A01;
                int length5 = objArr6.length - 1;
                objArr6[0] = objArr6[length5];
                System.arraycopy(objArr6, i2, objArr6, i2 + 1, length5 - i2);
            }
            this.A01[i2] = obj;
        }
        this.A02 = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            ((AbstractList) this).modCount++;
            int iA00 = A00(this);
            int length = this.A01.length;
            if (iA00 >= length) {
                iA00 -= length;
            }
            A02(this.A00, iA00);
        }
        this.A00 = 0;
        this.A02 = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        AnonymousClass060.A01(i, size());
        Object[] objArr = this.A01;
        int i2 = this.A00 + i;
        int length = objArr.length;
        if (i2 >= length) {
            i2 -= length;
        }
        return objArr[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int iA00 = A00(this);
        Object[] objArr = this.A01;
        int length = objArr.length;
        if (iA00 >= length) {
            iA00 -= length;
        }
        int i = this.A00;
        if (i < iA00) {
            while (i < iA00) {
                if (!C06E.areEqual(obj, objArr[i])) {
                    i++;
                }
            }
            return -1;
        }
        while (true) {
            if (i >= length) {
                for (int i2 = 0; i2 < iA00; i2++) {
                    if (C06E.areEqual(obj, objArr[i2])) {
                        i = i2 + length;
                    }
                }
                return -1;
            }
            if (C06E.areEqual(obj, objArr[i])) {
                break;
            }
            i++;
        }
        return i - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int iA00 = A00(this);
        Object[] objArr = this.A01;
        int length2 = objArr.length;
        if (iA00 >= length2) {
            iA00 -= length2;
        }
        int i = this.A00;
        if (i < iA00) {
            length = iA00 - 1;
            if (i <= length) {
                while (!C06E.areEqual(obj, objArr[length])) {
                    if (length != i) {
                        length--;
                    }
                }
                return length - i;
            }
            return -1;
        }
        if (i > iA00) {
            while (true) {
                iA00--;
                if (-1 >= iA00) {
                    length = objArr.length - 1;
                    i = this.A00;
                    if (i <= length) {
                        while (!C06E.areEqual(obj, this.A01[length])) {
                            if (length != i) {
                                length--;
                            }
                        }
                    }
                } else if (C06E.areEqual(obj, objArr[iA00])) {
                    length = iA00 + length2;
                    break;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        ((AbstractList) this).modCount++;
        Object[] objArr = this.A01;
        int i = this.A00;
        Object obj = objArr[i];
        objArr[i] = null;
        int i2 = i + 1;
        if (i == objArr.length - 1) {
            i2 = 0;
        }
        this.A00 = i2;
        this.A02 = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        ((AbstractList) this).modCount++;
        int size = this.A00 + (size() - 1);
        Object[] objArr = this.A01;
        int length = objArr.length;
        if (size >= length) {
            size -= length;
        }
        Object obj = objArr[size];
        objArr[size] = null;
        this.A02 = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        AnonymousClass060.A03(i, i2, size());
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 == size()) {
                clear();
                return;
            }
            if (i3 == 1) {
                remove(i);
                return;
            }
            ((AbstractList) this).modCount++;
            int size = size() - i2;
            int i4 = this.A00;
            if (i < size) {
                int length = i4 + (i - 1);
                int length2 = this.A01.length;
                if (length >= length2) {
                    length -= length2;
                }
                int length3 = i4 + (i2 - 1);
                if (length3 >= length2) {
                    length3 -= length2;
                }
                while (i > 0) {
                    int i5 = length + 1;
                    int iMin = Math.min(i, Math.min(i5, length3 + 1));
                    Object[] objArr = this.A01;
                    length3 -= iMin;
                    length -= iMin;
                    AbstractC003901t.A02(objArr, objArr, length3 + 1, length + 1, i5);
                    if (length < 0) {
                        length += this.A01.length;
                    }
                    if (length3 < 0) {
                        length3 += this.A01.length;
                    }
                    i -= iMin;
                }
                int i6 = this.A00;
                int i7 = i6 + i3;
                int length4 = this.A01.length;
                if (i7 >= length4) {
                    i7 -= length4;
                }
                A02(i6, i7);
                this.A00 = i7;
            } else {
                int i8 = i4 + i2;
                int length5 = this.A01.length;
                if (i8 >= length5) {
                    i8 -= length5;
                }
                int i9 = i4 + i;
                if (i9 >= length5) {
                    i9 -= length5;
                }
                int size2 = size();
                while (true) {
                    size2 -= i2;
                    if (size2 <= 0) {
                        break;
                    }
                    Object[] objArr2 = this.A01;
                    int length6 = objArr2.length;
                    i2 = Math.min(size2, Math.min(length6 - i8, length6 - i9));
                    System.arraycopy(objArr2, i8, objArr2, i9, (i8 + i2) - i8);
                    i8 += i2;
                    int length7 = this.A01.length;
                    if (i8 >= length7) {
                        i8 -= length7;
                    }
                    i9 += i2;
                    if (i9 >= length7) {
                        i9 -= length7;
                    }
                }
                int iA00 = A00(this);
                int length8 = this.A01.length;
                if (iA00 >= length8) {
                    iA00 -= length8;
                }
                int i10 = iA00 - i3;
                if (i10 < 0) {
                    i10 += length8;
                }
                A02(i10, iA00);
            }
            this.A02 = size() - i3;
        }
    }

    @Override // X.AnonymousClass082, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        AnonymousClass060.A01(i, size());
        int i2 = this.A00 + i;
        Object[] objArr = this.A01;
        int length = objArr.length;
        if (i2 >= length) {
            i2 -= length;
        }
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    @Override // X.AnonymousClass082
    public final int A08() {
        return this.A02;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        C06E.A07(collection, 0);
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        A01(size() + collection.size());
        int iA00 = A00(this);
        int length = this.A01.length;
        if (iA00 >= length) {
            iA00 -= length;
        }
        A03(collection, iA00);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
