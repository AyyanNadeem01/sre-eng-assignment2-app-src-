package X;

import java.util.Iterator;

/* renamed from: X.08W, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C08W implements Iterator, C00R {
    public int A00;
    public Object A01;

    public abstract void A00();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.A00;
        if (i == 0) {
            this.A00 = 3;
            A00();
            if (this.A00 == 1) {
                return true;
            }
        } else {
            if (i == 1) {
                return true;
            }
            if (i != 2) {
                throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
    
        if (r4.A00 == 1) goto L8;
     */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object next() {
        /*
            r4 = this;
            int r3 = r4.A00
            r2 = 1
            r1 = 0
            if (r3 == r2) goto L13
            r0 = 2
            if (r3 == r0) goto L18
            r0 = 3
            r4.A00 = r0
            r4.A00()
            int r0 = r4.A00
            if (r0 != r2) goto L18
        L13:
            r4.A00 = r1
            java.lang.Object r0 = r4.A01
            return r0
        L18:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C08W.next():java.lang.Object");
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
