package X;

import com.facebook.errorreporting.field.ReportFieldBase;
import com.facebook.errorreporting.field.ReportFieldString;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/* renamed from: X.05C */
/* loaded from: classes.dex */
public final class C05C {
    public int A00;
    public C011304y A01;
    public Throwable A02;
    public final Map A03;
    public final Map A04;
    public final Map A05;
    public final Map A06;
    public final Map A07;
    public final Map A08;
    public final Map A09;

    public final void A02(AnonymousClass091 anonymousClass091, int i) {
        A03(anonymousClass091, Long.valueOf(i));
    }

    public final void A01(AnonymousClass090 anonymousClass090, boolean z) {
        this.A03.put(anonymousClass090, Boolean.valueOf(z));
    }

    public final void A03(AnonymousClass091 anonymousClass091, Long l) {
        Map map = this.A08;
        if (l == null) {
            map.remove(anonymousClass091);
        } else {
            map.put(anonymousClass091, l);
        }
    }

    public final void A04(ReportFieldString reportFieldString, String str) {
        C011304y c011304y;
        int length;
        int i = this.A00;
        if (i > 0 && (c011304y = this.A01) != null && str != null && (length = str.length()) > i) {
            String str2 = reportFieldString.name;
            HashMap map = new HashMap();
            map.put("collector", AnonymousClass045.A00(c011304y.A00));
            map.put("key", str2);
            map.put("length", String.valueOf(length));
            C0C5.A00();
            C018108b.A0J("lacrima", "PropertyValueTooLarge - %s", map.toString());
            if (c011304y.A02) {
                str = str.substring(0, c011304y.A01);
            }
        }
        Map map2 = this.A09;
        if (str == null) {
            str = "unknown";
        }
        map2.put(reportFieldString, str);
    }

    public final void A05(AnonymousClass036 anonymousClass036, AnonymousClass057 anonymousClass057, File file) {
        Map map;
        StringBuilder sb;
        String str;
        String string;
        if (anonymousClass057 == AnonymousClass057.CRITICAL_REPORT) {
            map = this.A04;
            str = anonymousClass036.A01;
            if (str.equals("__")) {
                string = anonymousClass036.A00;
                map.put(string, file.getPath());
            }
            sb = new StringBuilder();
        } else {
            map = this.A06;
            sb = new StringBuilder();
            str = anonymousClass036.A01;
        }
        sb.append(str);
        sb.append(anonymousClass036.A00);
        string = sb.toString();
        map.put(string, file.getPath());
    }

    @Deprecated
    public final void A06(String str, String str2) {
        C011304y c011304y;
        int length;
        int i = this.A00;
        if (i > 0 && (c011304y = this.A01) != null && str2 != null && (length = str2.length()) > i) {
            HashMap map = new HashMap();
            map.put("collector", AnonymousClass045.A00(c011304y.A00));
            map.put("key", str);
            map.put("length", String.valueOf(length));
            C0C5.A00();
            C018108b.A0J("lacrima", "PropertyValueTooLarge - %s", map.toString());
            if (c011304y.A02) {
                str2 = str2.substring(0, c011304y.A01);
            }
        }
        Map map2 = this.A05;
        if (str2 == null) {
            str2 = "unknown";
        }
        map2.put(str, str2);
    }

    public final void A07(Properties properties) {
        properties.putAll(this.A05);
        for (Map.Entry entry : this.A09.entrySet()) {
            properties.put(((ReportFieldBase) entry.getKey()).name, entry.getValue());
        }
        for (Map.Entry entry2 : this.A08.entrySet()) {
            properties.put(((ReportFieldBase) entry2.getKey()).name, entry2.getValue().toString());
        }
        for (Map.Entry entry3 : this.A03.entrySet()) {
            properties.put(((ReportFieldBase) entry3.getKey()).name, entry3.getValue().toString());
        }
        Iterator it = this.A07.entrySet().iterator();
        if (it.hasNext()) {
            ((Map.Entry) it.next()).getKey();
            throw new NullPointerException("getName");
        }
    }

    public C05C(Throwable th) {
        this.A05 = new HashMap();
        this.A09 = new HashMap();
        this.A08 = new HashMap();
        this.A03 = new HashMap();
        this.A07 = new HashMap();
        this.A04 = new HashMap();
        this.A06 = new HashMap();
        this.A02 = th;
    }

    public static void A00(AnonymousClass091 anonymousClass091, C05C c05c, long j) {
        c05c.A03(anonymousClass091, Long.valueOf(j));
    }

    public C05C() {
        this(null);
    }
}
