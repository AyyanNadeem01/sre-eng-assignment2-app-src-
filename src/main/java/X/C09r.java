package X;

import android.os.Trace;

/* renamed from: X.09r, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C09r {
    public static void A00(String str, String str2, String str3) {
        String strA06 = AnonymousClass000.A06(str2, str3, AnonymousClass000.A0A(str));
        if (strA06.length() > 127 && str2 != null) {
            int length = (127 - str.length()) - str3.length();
            strA06 = AnonymousClass000.A06(str2.substring(0, length), str3, AnonymousClass000.A0A(str));
        }
        Trace.beginSection(strA06);
    }
}
