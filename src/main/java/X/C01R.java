package X;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: X.01R, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C01R extends C00I {
    public static final LinkedHashMap A05(Map map) {
        C06E.A07(map, 0);
        return new LinkedHashMap(map);
    }

    public static final LinkedHashMap A06(C003401o... c003401oArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(C00I.A01(c003401oArr.length));
        A0C(linkedHashMap, c003401oArr);
        return linkedHashMap;
    }

    public static final LinkedHashMap A07(C003401o... c003401oArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(C00I.A01(c003401oArr.length));
        A0C(linkedHashMap, c003401oArr);
        return linkedHashMap;
    }

    public static final Map A0A(Map map) {
        C06E.A07(map, 0);
        int size = map.size();
        if (size == 0) {
            C01S c01s = C01S.A00;
            C06E.A08(c01s, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
            return c01s;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        C06E.A03(mapSingletonMap);
        return mapSingletonMap;
    }

    public static final void A0C(Map map, C003401o[] c003401oArr) {
        for (C003401o c003401o : c003401oArr) {
            map.put(c003401o.A00, c003401o.A01);
        }
    }

    public static final Map A08(Iterable iterable) {
        if (!(iterable instanceof Collection)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                C003401o c003401o = (C003401o) it.next();
                linkedHashMap.put(c003401o.A00, c003401o.A01);
            }
            return A09(linkedHashMap);
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            C01S c01s = C01S.A00;
            C06E.A08(c01s, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
            return c01s;
        }
        if (size == 1) {
            return C00I.A02((C003401o) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(C00I.A01(collection.size()));
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            C003401o c003401o2 = (C003401o) it2.next();
            linkedHashMap2.put(c003401o2.A00, c003401o2.A01);
        }
        return linkedHashMap2;
    }

    public static final C01S A0B() {
        C01S c01s = C01S.A00;
        C06E.A08(c01s, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return c01s;
    }

    public static final Map A09(Map map) {
        int size = map.size();
        if (size == 0) {
            C01S c01s = C01S.A00;
            C06E.A08(c01s, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
            return c01s;
        }
        if (size != 1) {
            return map;
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        C06E.A03(mapSingletonMap);
        return mapSingletonMap;
    }
}
