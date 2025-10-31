package X;

import java.util.Random;
import java.util.Set;

/* renamed from: X.03B */
/* loaded from: classes.dex */
public final class C03B implements InterfaceC02430Ba {
    public static C03B A07;
    public Set A01;
    public final C04w A02;
    public final C03A A03;
    public final C0CK A04;
    public final Object A05 = new Object();
    public final Random A06 = new Random();
    public int A00 = 1;

    public C03B(C04w c04w, C03A c03a, C0CK c0ck) {
        this.A04 = c0ck;
        this.A02 = c04w;
        this.A03 = c03a;
    }

    @Override // X.InterfaceC02430Ba
    public final /* synthetic */ AnonymousClass046 AFf() {
        return null;
    }

    @Override // X.InterfaceC02430Ba
    public final EnumC011204x AGX() {
        return EnumC011204x.SOFT_ERROR;
    }

    @Override // X.InterfaceC02430Ba
    public final void start() {
        A07 = this;
    }
}
