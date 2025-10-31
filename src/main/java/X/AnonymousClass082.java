package X;

import java.util.AbstractList;
import java.util.List;

/* renamed from: X.082, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class AnonymousClass082<E> extends AbstractList<E> implements List<E>, AnonymousClass083 {
    public abstract int A08();

    public abstract Object A09(int i);

    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i, Object obj);

    @Override // java.util.AbstractList, java.util.List
    public abstract Object set(int i, Object obj);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i) {
        return A09(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return A08();
    }
}
