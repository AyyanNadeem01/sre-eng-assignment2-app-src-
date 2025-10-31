package X;

import com.facebook.common.stringformat.StringFormatUtil;
import java.util.Arrays;

/* renamed from: X.037, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class AnonymousClass037 {
    public static final void A00(Class cls, String str, Throwable th, Object... objArr) {
        C06E.A07(str, 2);
        StringBuilder sb = new StringBuilder();
        sb.append("[AI] ");
        sb.append(str);
        String string = sb.toString();
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        if (C018108b.A01.ANo(5)) {
            C018108b.A0C(cls.getSimpleName(), StringFormatUtil.formatStrLocaleSafe(string, objArrCopyOf), th);
        }
    }

    public static final void A01(String str, String str2, Throwable th) {
        C06E.A07(str2, 2);
        StringBuilder sb = new StringBuilder();
        sb.append("[AI] ");
        sb.append(str2);
        C018108b.A0D(str, sb.toString(), th);
    }

    public static final void A02(String str, String str2, Object... objArr) {
        C06E.A07(str, 0);
        C06E.A07(str2, 1);
        StringBuilder sb = new StringBuilder();
        sb.append("[AI] ");
        sb.append(str2);
        C018108b.A0K(str, sb.toString(), Arrays.copyOf(objArr, objArr.length));
    }
}
