package X;

/* renamed from: X.0Bg, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C02450Bg {
    public final int A00;
    public final String A01;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C02450Bg) {
            C02450Bg c02450Bg = (C02450Bg) obj;
            if (this.A00 == c02450Bg.A00) {
                return this.A01.equals(c02450Bg.A01);
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.A01.hashCode() * 31) + this.A00;
    }

    public C02450Bg(String str, int i) {
        this.A01 = str;
        this.A00 = i;
    }
}
