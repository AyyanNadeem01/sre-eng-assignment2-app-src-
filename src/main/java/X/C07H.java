package X;

import java.util.Arrays;
import java.util.List;

/* renamed from: X.07H, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C07H extends AbstractC003901t {
    public static final List A03(C003101l c003101l, byte[] bArr) {
        C06E.A07(bArr, 0);
        if (c003101l.A00()) {
            return C003301n.A00;
        }
        int i = c003101l.A00;
        int i2 = c003101l.A01 + 1;
        AbstractC003701r.A00(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        C06E.A03(bArrCopyOfRange);
        return new C07D(bArrCopyOfRange);
    }
}
