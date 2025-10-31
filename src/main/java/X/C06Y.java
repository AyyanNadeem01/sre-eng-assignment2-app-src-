package X;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.builders.AbstractMapBuilderEntrySet;

/* renamed from: X.06Y, reason: invalid class name */
/* loaded from: classes.dex */
public final class C06Y<K, V> extends AbstractMapBuilderEntrySet<Map.Entry<K, V>, K, V> {
    public final C004602a A00;

    public final boolean containsAll(Collection collection) {
        C06E.A07(collection, 0);
        C004602a c004602a = this.A00;
        for (Object obj : collection) {
            if (obj == null) {
                return false;
            }
            try {
                if (!c004602a.A07((Map.Entry) obj)) {
                    return false;
                }
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return true;
    }

    public final boolean removeAll(Collection collection) {
        C06E.A07(collection, 0);
        this.A00.A06();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        C06E.A07(collection, 0);
        this.A00.A06();
        return super.retainAll(collection);
    }

    public final int A00() {
        return this.A00.size();
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.A00.clear();
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        C06E.A07(entry, 0);
        return this.A00.A07(entry);
    }

    public final boolean isEmpty() {
        return this.A00.isEmpty();
    }

    public final Iterator iterator() {
        return new C015006p(this.A00);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        C06E.A07(entry, 0);
        C004602a c004602a = this.A00;
        c004602a.A06();
        int iA00 = C004602a.A00(entry.getKey(), c004602a);
        if (iA00 < 0) {
            return false;
        }
        Object[] objArr = c004602a.A0C;
        C06E.A06(objArr);
        if (!C06E.areEqual(objArr[iA00], entry.getValue())) {
            return false;
        }
        C004602a.A03(c004602a, iA00);
        return true;
    }

    public C06Y(C004602a c004602a) {
        this.A00 = c004602a;
    }

    public C06Y() {
    }
}
