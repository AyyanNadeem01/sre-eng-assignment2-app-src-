package X;

/* renamed from: X.05O, reason: invalid class name */
/* loaded from: classes.dex */
public final class C05O {
    public final int A00;
    public final C00U A01;
    public final C05N A02;
    public final String A03;
    public final String A04;

    public final boolean A00(C05O c05o) {
        return c05o != null && this.A03.equals(c05o.A03) && this.A00 == c05o.A00 && this.A02 == c05o.A02;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.A03);
        sb.append(":");
        sb.append(this.A00);
        return sb.toString();
    }

    public C05O(C05N c05n, String str, int i) {
        String strSubstring;
        String str2 = str;
        int iIndexOf = str.indexOf("@");
        this.A04 = iIndexOf != -1 ? str.substring(iIndexOf + 1) : str2;
        this.A00 = i;
        String strSubstring2 = (iIndexOf == -1 || iIndexOf == 0) ? null : str.substring(0, iIndexOf);
        C00U c00u = null;
        if (strSubstring2 != null) {
            C00U[] c00uArrValues = C00U.values();
            int length = c00uArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                C00U c00u2 = c00uArrValues[i2];
                if (c00u2.A00.equals(strSubstring2)) {
                    c00u = c00u2;
                    break;
                }
                i2++;
            }
        }
        this.A01 = c00u;
        this.A03 = str;
        if (c00u == null && iIndexOf != -1 && iIndexOf != 0 && (strSubstring = str.substring(0, iIndexOf)) != null) {
            C01g.A01("UnresolvedSocketAddress", "Unknown VIP: {}", strSubstring);
        }
        this.A02 = c05n;
    }

    public C05O(C00U c00u, C05N c05n, String str, int i) {
        String str2;
        int iIndexOf = str.indexOf("@");
        str = iIndexOf != -1 ? str.substring(iIndexOf + 1) : str;
        this.A04 = str;
        this.A00 = i;
        this.A01 = c00u;
        if (c00u != null) {
            str2 = c00u.A00;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("@");
            sb.append(str);
            str = sb.toString();
        }
        this.A03 = str;
        this.A02 = c05n;
    }
}
