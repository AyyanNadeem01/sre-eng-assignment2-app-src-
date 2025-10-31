package X;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: X.0CL */
/* loaded from: classes.dex */
public final class C0CL extends C0CM {
    public final /* synthetic */ C0CG A00;

    public C0CL(C0CG c0cg) {
        this.A00 = c0cg;
    }

    @Override // X.C0CM
    public final void A01(File file) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Iterator it = this.A00.A01.iterator();
        while (it.hasNext()) {
            C02500Bl c02500Bl = (C02500Bl) it.next();
            C02560Bt c02560Bt = new C02560Bt(c02500Bl, c02500Bl);
            try {
                c02560Bt.A01(file);
                c02560Bt.close();
            } catch (Throwable th) {
                try {
                    c02560Bt.close();
                    throw th;
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    throw th;
                }
            }
        }
    }

    @Override // X.C0CM
    public final C0Bz[] A02() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ArrayList arrayListA0B = AnonymousClass000.A0B();
        Iterator it = this.A00.A01.iterator();
        while (it.hasNext()) {
            C02500Bl c02500Bl = (C02500Bl) it.next();
            C02560Bt c02560Bt = new C02560Bt(c02500Bl, c02500Bl);
            try {
                arrayListA0B.addAll(Arrays.asList(c02560Bt.A02()));
                c02560Bt.close();
            } catch (Throwable th) {
                try {
                    c02560Bt.close();
                    throw th;
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    throw th;
                }
            }
        }
        return (C0Bz[]) arrayListA0B.toArray(new C0Bz[arrayListA0B.size()]);
    }
}
