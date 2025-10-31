package X;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: X.06p, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C015006p extends AbstractC015106q implements Iterator, C00R {
    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        A00();
        int i = this.A00;
        C004602a c004602a = this.A03;
        C004602a c004602a2 = C004602a.A0D;
        if (i >= c004602a.A01) {
            throw new NoSuchElementException();
        }
        this.A00 = i + 1;
        this.A01 = i;
        C014406i c014406i = new C014406i(c004602a, i);
        A01();
        return c014406i;
    }
}
