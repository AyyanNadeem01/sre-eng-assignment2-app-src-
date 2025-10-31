package X;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: X.03g, reason: invalid class name */
/* loaded from: classes.dex */
public final class C03g {
    public static final /* synthetic */ InterfaceC000300g A00;
    public static final /* synthetic */ C03g[] A01;
    public static final C03g A02;
    public static final C03g A03;
    public static final C03g A04;
    public static final C03g A05;
    public static final C03g A06;
    public static final C03g A07;
    public static final C03g A08;
    public static final C03g A09;
    public static final C03g A0A;
    public static final C03g A0B;

    static {
        C03g c03g = new C03g("NO_ANR_DETECTED", 0);
        A04 = c03g;
        C03g c03g2 = new C03g("DURING_ANR", 1);
        A03 = c03g2;
        C03g c03g3 = new C03g("ANR_RECOVERED", 2);
        A02 = c03g3;
        C03g c03g4 = new C03g("SIGQUIT_RECEIVED_AM_UNCONFIRMED_MT_BLOCKED", 3);
        A0A = c03g4;
        C03g c03g5 = new C03g("SIGQUIT_RECEIVED_AM_CONFIRMED_MT_BLOCKED", 4);
        A07 = c03g5;
        C03g c03g6 = new C03g("SIGQUIT_RECEIVED_AM_CONFIRMED_MT_UNBLOCKED", 5);
        A08 = c03g6;
        C03g c03g7 = new C03g("SIGQUIT_RECEIVED_AM_UNCONFIRMED_MT_UNBLOCKED", 6);
        A0B = c03g7;
        C03g c03g8 = new C03g("SIGQUIT_RECEIVED_AM_EXPIRED_MT_BLOCKED", 7);
        A09 = c03g8;
        C03g c03g9 = new C03g("NO_SIGQUIT_AM_CONFIRMED_MT_BLOCKED", 8);
        A05 = c03g9;
        C03g c03g10 = new C03g("NO_SIGQUIT_AM_CONFIRMED_MT_UNBLOCKED", 9);
        A06 = c03g10;
        C03g[] c03gArr = {c03g, c03g2, c03g3, c03g4, c03g5, c03g6, c03g7, c03g8, c03g9, c03g10};
        A01 = c03gArr;
        A00 = C00b.A00(c03gArr);
    }

    public static C03g valueOf(String str) {
        return (C03g) Enum.valueOf(C03g.class, str);
    }

    public static C03g[] values() {
        return (C03g[]) A01.clone();
    }

    public C03g(String str, int i) {
    }
}
