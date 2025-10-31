package X;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: X.0AI, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0AI {
    public static C0AH A00;
    public static Executor A01;
    public static List A02;
    public static final C0AH A03;

    static {
        C0AH c0ah = new C0AH();
        A03 = c0ah;
        A00 = c0ah;
        A01 = Executors.newSingleThreadExecutor();
        A02 = AnonymousClass000.A0B();
    }

    public static synchronized void A00(final C0AC c0ac) {
        final C0AH c0ah = A00;
        if (c0ah != A03) {
            A01.execute(new Runnable() { // from class: X.0AA
                public static final String __redex_internal_original_name = "GlobalPropertiesCreator$$ExternalSyntheticLambda1";

                @Override // java.lang.Runnable
                public final void run() {
                    C0AC c0ac2 = c0ac;
                    List list = C0AI.A02;
                    C0AI.A00(new C0AC(c0ac2.A00, c0ac2.A01, c0ac2.A02));
                }
            });
        } else {
            List list = A02;
            if (list.size() == 150) {
                C018108b.A08("Lacrima", "Too many callbacks before setInstance is called, skipping");
            }
            if (list.size() <= 150) {
                list.add(c0ac);
            }
        }
    }
}
