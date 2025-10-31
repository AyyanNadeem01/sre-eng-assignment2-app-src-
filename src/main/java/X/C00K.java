package X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: X.00K */
/* loaded from: classes.dex */
public abstract class C00K extends C00J {
    public static final ArrayList A01(Object... objArr) {
        return new ArrayList(new C001200p(objArr, true));
    }

    public static final List A03(Object... objArr) {
        C06E.A07(objArr, 0);
        if (objArr.length <= 0) {
            return C003301n.A00;
        }
        List listAsList = Arrays.asList(objArr);
        C06E.A03(listAsList);
        return listAsList;
    }

    public static final void A05(int i, int i2) {
        if (0 > i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("fromIndex (");
            sb.append(0);
            sb.append(") is greater than toIndex (");
            sb.append(i2);
            sb.append(").");
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 <= i) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("toIndex (");
        sb2.append(i2);
        sb2.append(") is greater than size (");
        sb2.append(i);
        sb2.append(").");
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    public static final void A04() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final List A02(List list) {
        int size = list.size();
        if (size == 0) {
            return C003301n.A00;
        }
        if (size != 1) {
            return list;
        }
        List listSingletonList = Collections.singletonList(list.get(0));
        C06E.A03(listSingletonList);
        return listSingletonList;
    }
}
