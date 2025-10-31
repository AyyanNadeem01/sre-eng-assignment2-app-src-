package X;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: X.06e, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C014006e extends AbstractC015106q implements Iterator, C00R {
    @Override // java.util.Iterator
    public final Object next() {
        A00();
        int i = this.A00;
        C004602a c004602a = this.A03;
        C004602a c004602a2 = C004602a.A0D;
        if (i >= c004602a.A01) {
            throw new NoSuchElementException();
        }
        this.A00 = i + 1;
        this.A01 = i;
        Object obj = c004602a.A0B[i];
        A01();
        return obj;
    }
}
