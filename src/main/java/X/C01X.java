package X;

/* renamed from: X.01X, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C01X {
    public static void A00(Boolean bool) {
        if (bool != null && !bool.booleanValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void A01(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
    }

    public static void A02(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(String.valueOf(obj2));
        }
    }

    public static void A03(Object obj, boolean z) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void A04(String str, Object[] objArr, boolean z) {
        if (z) {
            return;
        }
        String strValueOf = String.valueOf(str);
        int length = strValueOf.length();
        int length2 = objArr.length;
        StringBuilder sb = new StringBuilder(length + (length2 * 16));
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            int iIndexOf = strValueOf.indexOf("%s", i2);
            if (iIndexOf == -1) {
                break;
            }
            sb.append(strValueOf.substring(i2, iIndexOf));
            sb.append(objArr[i]);
            i2 = iIndexOf + 2;
            i++;
        }
        sb.append(strValueOf.substring(i2));
        if (i < length2) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i3 = i + 1; i3 < length2; i3++) {
                sb.append(", ");
                sb.append(objArr[i3]);
            }
            sb.append(']');
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public static void A05(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
