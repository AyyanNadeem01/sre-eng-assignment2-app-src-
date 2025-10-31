package X;

/* renamed from: X.01l, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C003101l extends C003001k {
    public static final C003101l A00 = new C003101l(1, 0);

    public C003101l(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // X.C003001k
    public final boolean A00() {
        return this.A00 > this.A01;
    }

    @Override // X.C003001k
    public final boolean equals(Object obj) {
        if (!(obj instanceof C003101l)) {
            return false;
        }
        if (A00() && ((C003001k) obj).A00()) {
            return true;
        }
        C003001k c003001k = (C003001k) obj;
        return this.A00 == c003001k.A00 && this.A01 == c003001k.A01;
    }

    @Override // X.C003001k
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.A00);
        sb.append("..");
        sb.append(this.A01);
        return sb.toString();
    }

    @Override // X.C003001k
    public final int hashCode() {
        if (A00()) {
            return -1;
        }
        return (this.A00 * 31) + this.A01;
    }
}
