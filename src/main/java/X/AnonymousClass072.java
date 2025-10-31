package X;

import java.util.Iterator;

/* renamed from: X.072, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass072 implements Iterator, C00R {
    public int A00;
    public final Iterator A01;

    public AnonymousClass072(Iterator it) {
        C06E.A07(it, 1);
        this.A01 = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A01.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        final int i = this.A00;
        this.A00 = i + 1;
        if (i < 0) {
            C00K.A04();
            throw AnonymousClass062.createAndThrow();
        }
        final Object next = this.A01.next();
        return new Object(i, next) { // from class: X.074
            public final int A00;
            public final Object A01;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof AnonymousClass074) {
                        AnonymousClass074 anonymousClass074 = (AnonymousClass074) obj;
                        if (this.A00 != anonymousClass074.A00 || !C06E.areEqual(this.A01, anonymousClass074.A01)) {
                        }
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                int i2 = this.A00 * 31;
                Object obj = this.A01;
                return i2 + (obj == null ? 0 : obj.hashCode());
            }

            {
                this.A00 = i;
                this.A01 = next;
            }

            public final String toString() {
                StringBuilder sbA09 = AnonymousClass000.A09();
                sbA09.append("IndexedValue(index=");
                sbA09.append(this.A00);
                sbA09.append(", value=");
                sbA09.append(this.A01);
                sbA09.append(')');
                return sbA09.toString();
            }
        };
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
