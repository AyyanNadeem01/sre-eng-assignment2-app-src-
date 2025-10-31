package X;

import java.io.Serializable;

/* renamed from: X.01o, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C003401o implements Serializable {
    public final Object A00;
    public final Object A01;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C003401o) {
                C003401o c003401o = (C003401o) obj;
                if (!C06E.areEqual(this.A00, c003401o.A00) || !C06E.areEqual(this.A01, c003401o.A01)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.A00;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.A01;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(this.A00);
        sb.append(", ");
        sb.append(this.A01);
        sb.append(')');
        return sb.toString();
    }

    public C003401o(Object obj, Object obj2) {
        this.A00 = obj;
        this.A01 = obj2;
    }
}
