package X;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: X.07P, reason: invalid class name */
/* loaded from: classes.dex */
public final class C07P {
    public static volatile C07P A03;
    public final Context A00;
    public final AtomicInteger A01;
    public final AtomicReference A02;

    public static C07P A00(Context context) {
        C07P c07p;
        C07P c07p2 = A03;
        if (c07p2 != null) {
            return c07p2;
        }
        synchronized (C07P.class) {
            c07p = A03;
            if (c07p == null) {
                c07p = new C07P(context);
                A03 = c07p;
            }
        }
        return c07p;
    }

    public C07P(Context context) {
        this.A01 = new AtomicInteger(1);
        this.A02 = new AtomicReference();
        this.A00 = context.getApplicationContext();
    }

    public C07P() {
    }
}
