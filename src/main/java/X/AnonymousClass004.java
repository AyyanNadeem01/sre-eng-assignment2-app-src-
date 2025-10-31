package X;

import java.io.Serializable;

/* renamed from: X.004, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class AnonymousClass004 implements AnonymousClass003, Serializable {
    public final int arity;

    public AnonymousClass004(int i) {
        this.arity = i;
    }

    public String toString() {
        String strA00 = C06C.A00(this);
        C06E.A03(strA00);
        return strA00;
    }

    @Override // X.AnonymousClass003
    public int getArity() {
        return this.arity;
    }
}
