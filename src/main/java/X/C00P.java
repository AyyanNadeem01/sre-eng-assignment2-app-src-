package X;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: X.00P, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C00P extends C00O {
    public static final void A08(List list, Comparator comparator) {
        C06E.A07(list, 0);
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
