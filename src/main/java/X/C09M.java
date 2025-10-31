package X;

import com.facebook.errorreporting.field.ReportFieldBase;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* renamed from: X.09M */
/* loaded from: classes.dex */
public final class C09M implements AnonymousClass095 {
    public static final Map A03 = Collections.synchronizedMap(AnonymousClass000.A0C());
    public final Object A00 = new Object();
    public final Map A02 = AnonymousClass000.A0C();
    public final Map A01 = AnonymousClass000.A0C();

    public static void A00(ReportFieldBase reportFieldBase) {
        A03.put(reportFieldBase.name, reportFieldBase);
    }

    public final void A01(String str, String str2) {
        synchronized (this.A00) {
            if (A03.containsKey(str)) {
                this.A02.put(str, str2);
            }
        }
    }

    @Override // X.AnonymousClass095
    public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) {
        HashMap map;
        HashMap map2;
        final Throwable th = c05c.A02;
        if (th != null) {
            Object obj = this.A00;
            synchronized (obj) {
                map2 = new HashMap(this.A01);
            }
            for (final Map.Entry entry : map2.entrySet()) {
                final String str = (String) entry.getKey();
                try {
                    String str2 = (String) C022009w.A01().submit(new Callable() { // from class: X.09K
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Map.Entry entry2 = entry;
                            String str3 = str;
                            try {
                                entry2.getValue();
                                throw new NullPointerException("getCustomData");
                            } catch (Throwable th2) {
                                C018108b.A0H("lacrima", "Failed to apply lazy supplier: %s", th2, str3);
                                C0C5.A00();
                                return "";
                            }
                        }
                    }).get(750L, TimeUnit.MILLISECONDS);
                    if (str2 == null) {
                        synchronized (obj) {
                            this.A02.remove(str);
                        }
                    } else {
                        A01(str, str2);
                    }
                } catch (Exception unused) {
                    C0C5.A00();
                    A01(AnonymousClass000.A07("_error", AnonymousClass000.A0A(str)), "timeout");
                }
            }
        }
        synchronized (this.A00) {
            map = new HashMap(this.A02);
        }
        for (Map.Entry entry2 : map.entrySet()) {
            c05c.A06((String) entry2.getKey(), (String) entry2.getValue());
        }
    }

    @Override // X.AnonymousClass095
    public final Integer AGY() {
        return AnonymousClass065.A06;
    }
}
