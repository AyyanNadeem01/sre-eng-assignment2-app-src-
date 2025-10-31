package X;

import android.os.SystemClock;
import com.facebook.common.dextricks.classtracing.logger.ClassTracingLoggerFbLite;
import com.facebook.lite.SharedPreferencesHookA11;
import java.io.File;

/* renamed from: X.00a */
/* loaded from: classes.dex */
public final class C00a implements InterfaceC02430Ba {
    public static InterfaceC000700k A09;
    public static C000400h A0A;
    public static volatile boolean A0B;
    public int A00 = 0;
    public boolean A01;
    public boolean A02;
    public final C00c A03;
    public final AnonymousClass058 A04;
    public final C04w A05;
    public final C00Y A06;
    public final C0CK A07;
    public final String A08;

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (r12v0 X.00a) */
    public static synchronized void A00(C00a c00a, C03g c03g) {
        EnumC011004u enumC011004u;
        InterfaceC000700k interfaceC000700k;
        File file;
        InterfaceC000700k interfaceC000700k2;
        synchronized (c00a) {
            C010704r c010704r = c00a.A07.A02;
            AnonymousClass053.A03(c010704r, "Did you call SessionManager.init()?");
            C010104k c010104k = new C010104k(c010704r.A01.A01);
            char cA01 = c010104k.A01();
            boolean zA00 = AbstractC010304m.A00(cA01);
            String strName = c03g.name();
            C03g c03g2 = C03g.A03;
            if (c03g == c03g2 || c03g == C03g.A07 || c03g == C03g.A08 || c03g == C03g.A09 || c03g == C03g.A0A || c03g == C03g.A0B || c03g == C03g.A05 || c03g == C03g.A06 || c03g == C03g.A02) {
                switch (c03g.ordinal()) {
                    case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                    case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                        enumC011004u = EnumC011004u.A04;
                        break;
                    case 2:
                    case 5:
                    default:
                        enumC011004u = EnumC011004u.A09;
                        break;
                    case 3:
                        enumC011004u = EnumC011004u.A0A;
                        break;
                    case 6:
                        enumC011004u = EnumC011004u.A08;
                        break;
                    case 7:
                        enumC011004u = EnumC011004u.A07;
                        break;
                    case 8:
                        enumC011004u = EnumC011004u.A05;
                        break;
                    case 9:
                        enumC011004u = EnumC011004u.A06;
                        break;
                }
                c010704r.A04(enumC011004u);
                if (c03g == c03g2 || c03g == C03g.A0A || c03g == C03g.A05) {
                    A0B = true;
                    int i = c00a.A00 + 1;
                    c00a.A00 = i;
                    C00c c00c = c00a.A03;
                    c00c.A02 = i;
                    File file2 = c00c.A0X.A04;
                    AnonymousClass053.A03(file2, "Did you call SessionManager.init()?");
                    StringBuilder sb = new StringBuilder();
                    sb.append("anr_report_");
                    sb.append(i);
                    sb.append(".dmp");
                    c00c.A0C = new File(file2, sb.toString());
                    c00a.A01 = zA00;
                    if (zA00) {
                        C05C c05c = new C05C(null);
                        try {
                            c05c.A02(AnonymousClass094.A1E, 1);
                            c05c.A03(AnonymousClass094.A1g, Long.valueOf(System.currentTimeMillis() / 1000));
                            c05c.A01(AnonymousClass094.A01, c00a.A01);
                            c05c.A03(AnonymousClass094.A2m, Long.valueOf(SystemClock.uptimeMillis()));
                            c05c.A04(AnonymousClass094.A4H, String.valueOf(enumC011004u.A01));
                            c05c.A04(AnonymousClass094.A65, Character.toString(cA01));
                            c05c.A04(AnonymousClass094.A64, c010104k.A04());
                        } catch (Throwable th) {
                            C0C5.A00();
                            c05c.A04(AnonymousClass094.A6Z, th.getMessage());
                        }
                        if (c00a.A02 && (interfaceC000700k2 = A09) != null) {
                            interfaceC000700k2.pause();
                        }
                        C04w c04w = c00a.A05;
                        AnonymousClass057 anonymousClass057 = AnonymousClass057.CRITICAL_REPORT;
                        c04w.A0B(anonymousClass057, c00a);
                        c04w.A05(c05c, anonymousClass057, c00a);
                        c04w.A0A(anonymousClass057, c00a);
                        if (c00a.A01 && (file = c00c.A0C) != null) {
                            AnonymousClass036 anonymousClass036 = AnonymousClass036.A02;
                            AnonymousClass057 anonymousClass0572 = AnonymousClass057.LARGE_REPORT;
                            c05c.A05(anonymousClass036, anonymousClass0572, file);
                            c04w.A0B(anonymousClass0572, c00a);
                            c04w.A07(c05c, anonymousClass0572, c00a, null, c00a.A00);
                            c04w.A0A(anonymousClass0572, c00a);
                        }
                        if (c00a.A02 && (interfaceC000700k = A09) != null) {
                            interfaceC000700k.resume();
                        }
                    }
                }
            } else if (c03g == C03g.A04) {
                A0B = false;
                c00a.A04.AYi(AnonymousClass057.LARGE_REPORT, c00a);
                c010704r.A04(EnumC011004u.A0B);
                c00a.A01 = false;
            } else {
                C018108b.A0K("lacrima", "Ignored anr state: %s", strName);
            }
        }
    }

    public C00a(AnonymousClass058 anonymousClass058, C04w c04w, C00Y c00y, C0CK c0ck, String str, C09V c09v, C09V c09v2, C09V c09v3) {
        this.A07 = c0ck;
        this.A05 = c04w;
        this.A06 = c00y;
        this.A08 = str;
        this.A04 = anonymousClass058;
        this.A03 = new C00c(c0ck, c09v, c09v2, c09v3);
    }

    @Override // X.InterfaceC02430Ba
    public final void start() {
        C0C5.A00();
        C000400h c000400h = new C000400h(this);
        A0A = c000400h;
        C00Y c00y = this.A06;
        InterfaceC000700k interfaceC000700kA6f = c00y.A6f(this.A03, c000400h, this.A08);
        A09 = interfaceC000700kA6f;
        this.A02 = c00y.AfK();
        C018108b.A0K("lacrima", "Start AnrDetector... %s", interfaceC000700kA6f.getClass().getName());
        A09.start();
        AnonymousClass089.A03(new InterfaceC009404d() { // from class: X.00u
            @Override // X.InterfaceC009404d
            public final void ALl(Thread thread, Throwable th) {
                InterfaceC000700k interfaceC000700k = C00a.A09;
                if (interfaceC000700k != null) {
                    interfaceC000700k.pause();
                }
            }
        }, 100);
    }

    @Override // X.InterfaceC02430Ba
    public final /* synthetic */ AnonymousClass046 AFf() {
        return null;
    }

    @Override // X.InterfaceC02430Ba
    public final EnumC011204x AGX() {
        return EnumC011204x.ANR;
    }
}
