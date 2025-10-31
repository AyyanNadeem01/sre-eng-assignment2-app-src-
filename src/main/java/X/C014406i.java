package X;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: X.06i, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C014406i implements Map.Entry, C00R {
    public final int A00;
    public final int A01;
    public final C004602a A02;

    private final void A00() {
        C004602a c004602a = this.A02;
        C004602a c004602a2 = C004602a.A0D;
        if (c004602a.A03 != this.A00) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (C06E.areEqual(entry.getKey(), getKey()) && C06E.areEqual(entry.getValue(), getValue())) {
                return true;
            }
        }
        return false;
    }

    public C014406i(C004602a c004602a, int i) {
        this.A02 = c004602a;
        this.A01 = i;
        C004602a c004602a2 = C004602a.A0D;
        this.A00 = c004602a.A03;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        A00();
        C004602a c004602a = this.A02;
        C004602a c004602a2 = C004602a.A0D;
        return c004602a.A0B[this.A01];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        A00();
        C004602a c004602a = this.A02;
        C004602a c004602a2 = C004602a.A0D;
        Object[] objArr = c004602a.A0C;
        C06E.A06(objArr);
        return objArr[this.A01];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        A00();
        C004602a c004602a = this.A02;
        c004602a.A06();
        Object[] objArr = c004602a.A0C;
        if (objArr == null) {
            objArr = new Object[c004602a.A0B.length];
            c004602a.A0C = objArr;
        }
        int i = this.A01;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append(getKey());
        sbA09.append('=');
        sbA09.append(getValue());
        return sbA09.toString();
    }
}
