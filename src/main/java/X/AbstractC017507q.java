package X;

import android.os.Trace;
import java.lang.reflect.Method;

/* renamed from: X.07q, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC017507q {
    static {
        if (C07Q.A03) {
            Method method = C07Q.A02;
            C0CN.A00(method);
            C07Q.A00(method, true);
        }
    }

    public static final void A00(String str) {
        C06E.A07(str, 0);
        if (str.length() > 127) {
            str = str.substring(0, 127);
            C06E.A03(str);
        }
        Trace.beginSection(str);
    }
}
