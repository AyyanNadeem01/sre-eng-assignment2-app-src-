package X;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: X.00I */
/* loaded from: classes.dex */
public abstract class C00I extends C00H {
    public static final Map A02(C003401o c003401o) {
        C06E.A07(c003401o, 0);
        Map mapSingletonMap = Collections.singletonMap(c003401o.A00, c003401o.A01);
        C06E.A03(mapSingletonMap);
        return mapSingletonMap;
    }

    public static final int A01(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final TreeMap A03(Comparator comparator, Map map) {
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }

    public static final C004602a A04(Map map) {
        C004602a c004602a = (C004602a) map;
        c004602a.A06();
        c004602a.A08 = true;
        if (c004602a.size() > 0) {
            return c004602a;
        }
        C004602a c004602a2 = C004602a.A0D;
        C06E.A08(c004602a2, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return c004602a2;
    }
}
