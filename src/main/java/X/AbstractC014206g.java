package X;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: X.06g, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC014206g {
    public static C012705p A00() {
        C09Q.A00();
        Set set = AbstractC011805d.A0i;
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Collections.singletonList("*|all_packages|*")));
        HashMap mapA0C = AnonymousClass000.A0C();
        Set setUnmodifiableSet2 = Collections.unmodifiableSet(setUnmodifiableSet);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            mapA0C.put(it.next(), setUnmodifiableSet2);
        }
        return new C012705p(Collections.unmodifiableMap(mapA0C));
    }

    public static C012705p A01(Set set) {
        HashMap mapA0C = AnonymousClass000.A0C();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            mapA0C.put(it.next(), Collections.unmodifiableSet(new HashSet(Collections.singletonList("*|all_packages|*"))));
        }
        return new C012705p(Collections.unmodifiableMap(mapA0C));
    }
}
