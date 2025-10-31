package X;

/* renamed from: X.09W, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C09W implements C09V {
    public Object A00;

    public abstract Object A00();

    @Override // X.C09V
    public final synchronized Object get() {
        Object objA00;
        objA00 = this.A00;
        if (objA00 == null) {
            objA00 = A00();
            this.A00 = objA00;
        }
        return objA00;
    }
}
