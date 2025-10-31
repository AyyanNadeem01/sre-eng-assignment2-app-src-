package X;

import com.facebook.errorreporting.field.ReportFieldBase;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: X.08u */
/* loaded from: classes.dex */
public final class C019908u {
    public static volatile C0BX A04;
    public static volatile String A05;
    public static volatile boolean A06;
    public static final ExecutorService A03 = Executors.newSingleThreadExecutor();
    public static final Set A02 = new HashSet();
    public static final Set A01 = new HashSet();
    public static final List A00 = AnonymousClass000.A0B();

    public static void A00(ReportFieldBase reportFieldBase, String str) {
        if (A04 != null) {
            List list = C0AI.A02;
            C0AI.A00(new C0AC(reportFieldBase, AnonymousClass057.CRITICAL_REPORT, str));
        }
    }
}
