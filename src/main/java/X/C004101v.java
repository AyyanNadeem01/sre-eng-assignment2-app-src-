package X;

/* renamed from: X.01v, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C004101v {
    public C004101v() {
        final C004301x c004301x = AbstractC004201w.A00;
        if (c004301x.A02.getAndSet(true)) {
            return;
        }
        c004301x.A00.close();
        c004301x.A01.execute(new Runnable() { // from class: X.01y
            public static final String __redex_internal_original_name = "FsStats$FsStatsReporter$availableDiskSpaceKbAsync$1";

            @Override // java.lang.Runnable
            public final void run() {
                C004301x c004301x2 = c004301x;
                c004301x2.A03.set(C004501z.A01().A04(AnonymousClass065.A00) >> 10);
                c004301x2.A00.open();
                c004301x2.A02.set(false);
            }
        });
    }
}
