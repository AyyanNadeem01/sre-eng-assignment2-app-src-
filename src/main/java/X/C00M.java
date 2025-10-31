package X;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: X.00M */
/* loaded from: classes.dex */
public abstract class C00M extends C00K {
    public static final int A06(Iterable iterable, int i) {
        C06E.A07(iterable, 0);
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    public static final ArrayList A07(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            C00Q.A09((Iterable) it.next(), arrayList);
        }
        return arrayList;
    }
}
