package X;

import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: X.00H, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C00H {
    public static final Object A00(Object obj, Map map) {
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Key ");
        sb.append(obj);
        sb.append(" is missing in the map.");
        throw new NoSuchElementException(sb.toString());
    }
}
