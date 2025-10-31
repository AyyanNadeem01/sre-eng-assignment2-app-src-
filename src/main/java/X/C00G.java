package X;

import java.util.LinkedHashSet;

/* renamed from: X.00G, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C00G extends C00F {
    public static final LinkedHashSet A00(Object... objArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(C00I.A01(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static final LinkedHashSet A01(Object... objArr) {
        int length = objArr.length;
        LinkedHashSet linkedHashSet = new LinkedHashSet(C00I.A01(length));
        int i = 0;
        do {
            linkedHashSet.add(objArr[i]);
            i++;
        } while (i < length);
        return linkedHashSet;
    }
}
