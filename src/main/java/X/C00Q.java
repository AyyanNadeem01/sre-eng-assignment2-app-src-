package X;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: X.00Q, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C00Q extends C00P {
    public static final void A09(Iterable iterable, Collection collection) {
        C06E.A07(iterable, 1);
        if (iterable instanceof Collection) {
            collection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }
}
