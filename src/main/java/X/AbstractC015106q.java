package X;

import java.util.ConcurrentModificationException;

/* renamed from: X.06q, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC015106q {
    public int A00;
    public int A01 = -1;
    public int A02;
    public final C004602a A03;

    public final void A00() {
        C004602a c004602a = this.A03;
        C004602a c004602a2 = C004602a.A0D;
        if (c004602a.A03 != this.A02) {
            throw new ConcurrentModificationException();
        }
    }

    public final void A01() {
        while (true) {
            int i = this.A00;
            C004602a c004602a = this.A03;
            C004602a c004602a2 = C004602a.A0D;
            if (i >= c004602a.A01 || c004602a.A0A[i] >= 0) {
                return;
            } else {
                this.A00 = i + 1;
            }
        }
    }

    public final boolean hasNext() {
        int i = this.A00;
        C004602a c004602a = this.A03;
        C004602a c004602a2 = C004602a.A0D;
        return i < c004602a.A01;
    }

    public AbstractC015106q(C004602a c004602a) {
        this.A03 = c004602a;
        C004602a c004602a2 = C004602a.A0D;
        this.A02 = c004602a.A03;
        A01();
    }

    public final void remove() {
        A00();
        if (this.A01 == -1) {
            throw AnonymousClass000.A04("Call next() before removing element from the iterator.");
        }
        C004602a c004602a = this.A03;
        c004602a.A06();
        C004602a.A03(c004602a, this.A01);
        this.A01 = -1;
        this.A02 = c004602a.A03;
    }
}
