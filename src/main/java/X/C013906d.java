package X;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: X.06d, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C013906d extends AbstractC015106q implements Iterator, C00R {
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
        Object[] objArr = c004602a.A0C;
        C06E.A06(objArr);
        Object obj = objArr[this.A01];
        A01();
        return obj;
    }
}
