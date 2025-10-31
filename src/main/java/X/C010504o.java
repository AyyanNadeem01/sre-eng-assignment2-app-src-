package X;

import java.util.List;

/* renamed from: X.04o, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C010504o {
    public final List A00;
    public final boolean A01;
    public final boolean A02;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C010504o) {
                C010504o c010504o = (C010504o) obj;
                if (!C06E.areEqual(this.A00, c010504o.A00) || this.A01 != c010504o.A01 || this.A02 != c010504o.A02) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((this.A00.hashCode() * 31) + (this.A01 ? 1231 : 1237)) * 31) + (this.A02 ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SigningInfoCompat(signatures=");
        sb.append(this.A00);
        sb.append(", hasMultipleSigners=");
        sb.append(this.A01);
        sb.append(", hasPastSigningCertificates=");
        sb.append(this.A02);
        sb.append(')');
        return sb.toString();
    }

    public C010504o(List list, boolean z, boolean z2) {
        this.A00 = list;
        this.A01 = z;
        this.A02 = z2;
    }
}
