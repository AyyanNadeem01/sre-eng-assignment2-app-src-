package X;

/* renamed from: X.01t, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC003901t extends AbstractC003801s {
    public static final void A01(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        C06E.A07(iArr, 0);
        C06E.A07(iArr2, 1);
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
    }

    public static final void A02(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        C06E.A07(objArr, 0);
        C06E.A07(objArr2, 1);
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }
}
