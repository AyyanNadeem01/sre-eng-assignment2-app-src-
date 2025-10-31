package X;

/* renamed from: X.04f, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C009604f implements Comparable {
    public final int A00;
    public final InterfaceC009404d A01;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int i = this.A00;
        int i2 = ((C009604f) obj).A00;
        if (i == i2) {
            return 0;
        }
        return i > i2 ? 1 : -1;
    }

    public C009604f(InterfaceC009404d interfaceC009404d, int i) {
        this.A01 = interfaceC009404d;
        this.A00 = i;
    }
}
