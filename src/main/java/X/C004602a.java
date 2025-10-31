package X;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: X.02a */
/* loaded from: classes.dex */
public final class C004602a<K, V> implements Map<K, V>, Serializable, C02Z {
    public static final C004602a A0D;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public C06Y A05;
    public C06X A06;
    public C06V A07;
    public boolean A08;
    public int[] A09;
    public int[] A0A;
    public Object[] A0B;
    public Object[] A0C;

    static {
        C004602a c004602a = new C004602a(0);
        c004602a.A08 = true;
        A0D = c004602a;
    }

    public final boolean A07(Map.Entry entry) {
        C06E.A07(entry, 0);
        int iA00 = A00(entry.getKey(), this);
        if (iA00 < 0) {
            return false;
        }
        Object[] objArr = this.A0C;
        C06E.A06(objArr);
        return C06E.areEqual(objArr[iA00], entry.getValue());
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        C06E.A07(map, 0);
        A06();
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        A01(setEntrySet.size());
        for (Map.Entry<K, V> entry : setEntrySet) {
            int iA05 = A05(entry.getKey());
            Object[] objArr = this.A0C;
            if (objArr == null) {
                objArr = new Object[this.A0B.length];
                this.A0C = objArr;
            }
            if (iA05 >= 0) {
                objArr[iA05] = entry.getValue();
            } else {
                int i = (-iA05) - 1;
                if (!C06E.areEqual(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    public C004602a(int i) {
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.A0B = objArr;
        this.A0C = null;
        this.A0A = iArr;
        this.A09 = new int[iHighestOneBit];
        this.A02 = 2;
        this.A01 = 0;
        this.A00 = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    public static final int A00(Object obj, C004602a c004602a) {
        int iHashCode = ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> c004602a.A00;
        int i = c004602a.A02;
        while (true) {
            int i2 = c004602a.A09[iHashCode];
            if (i2 != 0) {
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    if (C06E.areEqual(c004602a.A0B[i3], obj)) {
                        return i3;
                    }
                }
                i--;
                if (i < 0) {
                    break;
                }
                iHashCode = iHashCode == 0 ? r3.length - 1 : iHashCode - 1;
            } else {
                break;
            }
        }
        return -1;
    }

    private final void A01(int i) {
        Object[] objArrCopyOf;
        Object[] objArr = this.A0B;
        int length = objArr.length;
        int i2 = this.A01;
        int i3 = length - i2;
        int size = i2 - size();
        if (i3 < i && i3 + size >= i && size >= length / 4) {
            A04(true);
            return;
        }
        int i4 = i2 + i;
        if (i4 < 0) {
            throw new OutOfMemoryError();
        }
        if (i4 > length) {
            int iA00 = AnonymousClass060.A00(length, i4);
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr, iA00);
            C06E.A03(objArrCopyOf2);
            this.A0B = objArrCopyOf2;
            Object[] objArr2 = this.A0C;
            if (objArr2 != null) {
                objArrCopyOf = Arrays.copyOf(objArr2, iA00);
                C06E.A03(objArrCopyOf);
            } else {
                objArrCopyOf = null;
            }
            this.A0C = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.A0A, iA00);
            C06E.A03(iArrCopyOf);
            this.A0A = iArrCopyOf;
            if (iA00 < 1) {
                iA00 = 1;
            }
            int iHighestOneBit = Integer.highestOneBit(iA00 * 3);
            if (iHighestOneBit > this.A09.length) {
                A02(iHighestOneBit);
            }
        }
    }

    private final void A02(int i) {
        this.A03++;
        int i2 = 0;
        if (this.A01 > size()) {
            A04(false);
        }
        int[] iArr = new int[i];
        this.A09 = iArr;
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i) + 1;
        this.A00 = iNumberOfLeadingZeros;
        while (i2 < this.A01) {
            int i3 = i2 + 1;
            Object obj = this.A0B[i2];
            int iHashCode = ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> iNumberOfLeadingZeros;
            int i4 = this.A02;
            while (iArr[iHashCode] != 0) {
                i4--;
                if (i4 < 0) {
                    throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
                }
                int i5 = iHashCode;
                iHashCode--;
                if (i5 == 0) {
                    iHashCode = i - 1;
                }
            }
            iArr[iHashCode] = i2 + 1;
            this.A0A[i2] = iHashCode;
            i2 = i3;
        }
    }

    public static final void A03(C004602a c004602a, int i) {
        int i2;
        Object[] objArr = c004602a.A0B;
        objArr[i] = null;
        Object[] objArr2 = c004602a.A0C;
        if (objArr2 != null) {
            objArr2[i] = null;
        }
        int[] iArr = c004602a.A0A;
        int i3 = iArr[i];
        int i4 = c004602a.A02;
        int i5 = i4 * 2;
        int[] iArr2 = c004602a.A09;
        int length = iArr2.length;
        int i6 = length / 2;
        if (i5 > i6) {
            i5 = i6;
        }
        int i7 = 0;
        int i8 = i3;
        do {
            int i9 = i3;
            i3--;
            if (i9 == 0) {
                i3 = length - 1;
            }
            i7++;
            if (i7 > i4 || (i2 = iArr2[i3]) == 0) {
                iArr2[i8] = 0;
                break;
            }
            if (i2 < 0) {
                iArr2[i8] = -1;
            } else {
                Object obj = objArr[i2 - 1];
                if ((((((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> c004602a.A00) - i3) & (length - 1)) >= i7) {
                    iArr2[i8] = i2;
                    iArr[i2 - 1] = i8;
                }
                i5--;
            }
            i8 = i3;
            i7 = 0;
            i5--;
        } while (i5 >= 0);
        iArr2[i8] = -1;
        iArr[i] = -1;
        c004602a.A04 = c004602a.size() - 1;
        c004602a.A03++;
    }

    private final void A04(boolean z) {
        int i;
        Object[] objArr = this.A0C;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.A01;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.A0A;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.A0B;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.A09[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        AbstractC015306s.A01(this.A0B, i3, i);
        if (objArr != null) {
            AbstractC015306s.A01(objArr, i3, this.A01);
        }
        this.A01 = i3;
    }

    public final void A06() {
        if (this.A08) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        int i = this.A01;
        while (true) {
            i--;
            if (i < 0) {
                return false;
            }
            if (this.A0A[i] >= 0) {
                Object[] objArr = this.A0C;
                C06E.A06(objArr);
                if (C06E.areEqual(objArr[i], obj)) {
                    return true;
                }
            }
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        C06Y c06y = this.A05;
        if (c06y != null) {
            return c06y;
        }
        C06Y c06y2 = new C06Y(this);
        this.A05 = c06y2;
        return c06y2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        C06E.A07(setEntrySet, 0);
        for (Map.Entry<K, V> entry : setEntrySet) {
            if (entry == null) {
                return false;
            }
            try {
                if (!A07(entry)) {
                    return false;
                }
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public final int hashCode() {
        C015006p c015006p = new C015006p(this);
        int i = 0;
        while (c015006p.hasNext()) {
            int i2 = c015006p.A00;
            C004602a c004602a = c015006p.A03;
            if (i2 >= c004602a.A01) {
                throw new NoSuchElementException();
            }
            c015006p.A00 = i2 + 1;
            c015006p.A01 = i2;
            Object obj = c004602a.A0B[i2];
            int iHashCode = 0;
            int iHashCode2 = obj != null ? obj.hashCode() : 0;
            Object[] objArr = c004602a.A0C;
            C06E.A06(objArr);
            Object obj2 = objArr[c015006p.A01];
            if (obj2 != null) {
                iHashCode = obj2.hashCode();
            }
            c015006p.A01();
            i += iHashCode2 ^ iHashCode;
        }
        return i;
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        C06X c06x = this.A06;
        if (c06x != null) {
            return c06x;
        }
        C06X c06x2 = new C06X(this);
        this.A06 = c06x2;
        return c06x2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        C06V c06v = this.A07;
        if (c06v != null) {
            return c06v;
        }
        C06V c06v2 = new C06V(this);
        this.A07 = c06v2;
        return c06v2;
    }

    public final int A05(Object obj) {
        A06();
        while (true) {
            int iHashCode = ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.A00;
            int i = this.A02;
            int i2 = i * 2;
            int[] iArr = this.A09;
            int length = iArr.length;
            int i3 = length / 2;
            if (i2 > i3) {
                i2 = i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = iArr[iHashCode];
                if (i5 <= 0) {
                    int i6 = this.A01;
                    Object[] objArr = this.A0B;
                    if (i6 < objArr.length) {
                        this.A01 = i6 + 1;
                        objArr[i6] = obj;
                        this.A0A[i6] = iHashCode;
                        iArr[iHashCode] = i6 + 1;
                        this.A04 = size() + 1;
                        this.A03++;
                        if (i4 > i) {
                            this.A02 = i4;
                        }
                        return i6;
                    }
                    A01(1);
                } else {
                    if (C06E.areEqual(this.A0B[i5 - 1], obj)) {
                        return -i5;
                    }
                    i4++;
                    if (i4 > i2) {
                        A02(length * 2);
                        break;
                    }
                    int i7 = iHashCode;
                    iHashCode--;
                    if (i7 == 0) {
                        iHashCode = length - 1;
                    }
                }
            }
        }
    }

    @Override // java.util.Map
    public final void clear() {
        A06();
        int i = this.A01;
        int i2 = i - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.A0A;
                int i4 = iArr[i3];
                if (i4 >= 0) {
                    this.A09[i4] = 0;
                    iArr[i3] = -1;
                }
                if (i3 == i2) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        AbstractC015306s.A01(this.A0B, 0, i);
        Object[] objArr = this.A0C;
        if (objArr != null) {
            AbstractC015306s.A01(objArr, 0, this.A01);
        }
        this.A04 = 0;
        this.A01 = 0;
        this.A03++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return A00(obj, this) >= 0;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iA00 = A00(obj, this);
        if (iA00 < 0) {
            return null;
        }
        Object[] objArr = this.A0C;
        C06E.A06(objArr);
        return objArr[iA00];
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        A06();
        int iA05 = A05(obj);
        Object[] objArr = this.A0C;
        if (objArr == null) {
            objArr = new Object[this.A0B.length];
            this.A0C = objArr;
        }
        if (iA05 >= 0) {
            objArr[iA05] = obj2;
            return null;
        }
        int i = (-iA05) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        A06();
        int iA00 = A00(obj, this);
        if (iA00 < 0) {
            return null;
        }
        Object[] objArr = this.A0C;
        C06E.A06(objArr);
        Object obj2 = objArr[iA00];
        A03(this, iA00);
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        C015006p c015006p = new C015006p(this);
        int i = 0;
        while (c015006p.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = c015006p.A00;
            C004602a c004602a = c015006p.A03;
            if (i2 >= c004602a.A01) {
                throw new NoSuchElementException();
            }
            c015006p.A00 = i2 + 1;
            c015006p.A01 = i2;
            Object obj = c004602a.A0B[i2];
            if (obj == c004602a) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = c004602a.A0C;
            C06E.A06(objArr);
            Object obj2 = objArr[c015006p.A01];
            if (obj2 == c004602a) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            c015006p.A01();
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        C06E.A03(string);
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return this.A04;
    }

    public C004602a() {
        this(8);
    }
}
