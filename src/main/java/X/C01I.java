package X;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: X.01I, reason: invalid class name */
/* loaded from: classes.dex */
public final class C01I {
    public static final File A03 = new File("/sys/kernel/debug/tracing/trace");
    public boolean A00;
    public final Object A01 = new Object[0];
    public final List A02 = new ArrayList();

    public final void A00() {
        synchronized (this.A01) {
            this.A00 = true;
            int i = 0;
            while (true) {
                List list = this.A02;
                if (i < list.size()) {
                    ((C01L) list.get(i)).Adp();
                    i++;
                }
            }
        }
    }
}
