package X;

import java.util.Iterator;

/* renamed from: X.01k, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public class C003001k implements Iterable, C00R {
    public final int A00;
    public final int A01;
    public final int A02;

    public boolean A00() {
        int i = this.A02;
        int i2 = this.A00;
        int i3 = this.A01;
        return i > 0 ? i2 > i3 : i2 < i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C003001k)) {
            return false;
        }
        if (A00() && ((C003001k) obj).A00()) {
            return true;
        }
        C003001k c003001k = (C003001k) obj;
        return this.A00 == c003001k.A00 && this.A01 == c003001k.A01 && this.A02 == c003001k.A02;
    }

    @Override // java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return new C004001u(this.A00, this.A01, this.A02);
    }

    public String toString() {
        int i = this.A02;
        StringBuilder sb = new StringBuilder();
        int i2 = this.A00;
        if (i > 0) {
            sb.append(i2);
            sb.append("..");
            sb.append(this.A01);
            sb.append(" step ");
        } else {
            sb.append(i2);
            sb.append(" downTo ");
            sb.append(this.A01);
            sb.append(" step ");
            i = -i;
        }
        sb.append(i);
        return sb.toString();
    }

    public C003001k(int i, int i2, int i3) {
        this.A00 = i;
        if (i3 > 0) {
            if (i < i2) {
                int i4 = i2 % i3;
                int i5 = i % i3;
                int i6 = ((i4 < 0 ? i4 + i3 : i4) - (i5 < 0 ? i5 + i3 : i5)) % i3;
                i2 -= i6 < 0 ? i6 + i3 : i6;
            }
        } else if (i > i2) {
            int i7 = -i3;
            int i8 = i % i7;
            int i9 = i2 % i7;
            int i10 = ((i8 < 0 ? i8 + i7 : i8) - (i9 < 0 ? i9 + i7 : i9)) % i7;
            i2 += i10 < 0 ? i10 + i7 : i10;
        }
        this.A01 = i2;
        this.A02 = i3;
    }

    public int hashCode() {
        if (A00()) {
            return -1;
        }
        return (((this.A00 * 31) + this.A01) * 31) + this.A02;
    }
}
