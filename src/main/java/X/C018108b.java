package X;

import com.facebook.common.stringformat.StringFormatUtil;
import java.util.List;

/* renamed from: X.08b, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C018108b {
    public static volatile C08H A01 = C018308d.A01;
    public static final List A00 = AnonymousClass000.A0B();

    static {
        A01.AlS();
        C08G.A00 = A01;
    }

    public static boolean A0M() {
        return A01.ANo(5);
    }

    public static boolean A0N() {
        return A01.ANo(6);
    }

    public static void A00(Class cls, String str, Throwable th) {
        if (A0N()) {
            A01.A92(cls.getSimpleName(), str, th);
        }
    }

    public static void A01(Class cls, String str, Throwable th) {
        if (A0M()) {
            A01.Apd(cls.getSimpleName(), str, th);
        }
    }

    public static void A02(Class cls, String str, Throwable th, Object... objArr) {
        if (A0N()) {
            A0A(cls.getSimpleName(), StringFormatUtil.formatStrLocaleSafe(str, objArr), th);
        }
    }

    public static void A03(Class cls, String str, Object... objArr) {
        if (A0N()) {
            A07(cls.getSimpleName(), StringFormatUtil.formatStrLocaleSafe(str, objArr));
        }
    }

    public static void A04(Class cls, String str, Object... objArr) {
        if (A0M()) {
            A08(cls.getSimpleName(), StringFormatUtil.formatStrLocaleSafe(str, objArr));
        }
    }

    public static void A05(String str, Class cls) {
        if (A0N()) {
            A01.A91(cls.getSimpleName(), str);
        }
    }

    public static void A06(String str, Class cls) {
        if (A0M()) {
            A01.Apc(cls.getSimpleName(), str);
        }
    }

    public static void A07(String str, String str2) {
        if (A0N()) {
            A01.A91(str, str2);
        }
    }

    public static void A08(String str, String str2) {
        if (A0M()) {
            A01.Apc(str, str2);
        }
    }

    public static void A09(String str, String str2) {
        if (A0N()) {
            A01.AqL(str, str2);
        }
    }

    public static void A0A(String str, String str2, Throwable th) {
        if (A0N()) {
            A01.A92(str, str2, th);
        }
    }

    public static void A0B(String str, String str2, Throwable th) {
        if (A0N()) {
            A01.A92(str, str2, th);
        }
    }

    public static void A0C(String str, String str2, Throwable th) {
        if (A0M()) {
            C08H c08h = A01;
            if (th == null) {
                c08h.Apc(str, str2);
            } else {
                c08h.Apd(str, str2, th);
            }
        }
    }

    public static void A0D(String str, String str2, Throwable th) {
        if (A0M()) {
            A01.Apd(str, str2, th);
        }
    }

    public static void A0E(String str, String str2, Throwable th) {
        if (A0N()) {
            A01.AqM(str, str2, th);
        }
    }

    public static void A0F(String str, String str2, Throwable th) {
        if (A0N()) {
            A01.AqM(str, str2, th);
        }
    }

    public static void A0G(String str, String str2, Throwable th, Object... objArr) {
        if (A0N()) {
            A0A(str, StringFormatUtil.formatStrLocaleSafe(str2, objArr), th);
        }
    }

    public static void A0H(String str, String str2, Throwable th, Object... objArr) {
        if (A0M()) {
            A0C(str, StringFormatUtil.formatStrLocaleSafe(str2, objArr), th);
        }
    }

    public static void A0I(String str, String str2, Throwable th, Object... objArr) {
        if (A0N()) {
            A0E(str, StringFormatUtil.formatStrLocaleSafe(str2, objArr), th);
        }
    }

    public static void A0J(String str, String str2, Object... objArr) {
        if (A0N()) {
            A07(str, StringFormatUtil.formatStrLocaleSafe(str2, objArr));
        }
    }

    public static void A0K(String str, String str2, Object... objArr) {
        if (A0M()) {
            A08(str, StringFormatUtil.formatStrLocaleSafe(str2, objArr));
        }
    }

    public static void A0L(String str, String str2, Object... objArr) {
        if (A0N()) {
            A09(str, StringFormatUtil.formatStrLocaleSafe(str2, objArr));
        }
    }
}
