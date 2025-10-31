package X;

import java.util.Collection;

/* renamed from: X.06s */
/* loaded from: classes.dex */
public abstract class AbstractC015306s {
    public static final void A01(Object[] objArr, int i, int i2) {
        C06E.A07(objArr, 0);
        while (i < i2) {
            objArr[i] = null;
            i++;
        }
    }

    public static final String A00(Collection collection, Object[] objArr, int i, int i2) {
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append("[");
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i + i3];
            if (obj == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        String strA07 = AnonymousClass000.A07("]", sb);
        C06E.A03(strA07);
        return strA07;
    }
}
