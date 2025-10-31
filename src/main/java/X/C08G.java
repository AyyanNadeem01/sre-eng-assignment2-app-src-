package X;

/* renamed from: X.08G, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C08G {
    public static C08H A00 = C08I.A00;

    public static void A02(Class cls, String str, Throwable th, Object... objArr) {
        if (A00.ANo(5)) {
            A01(cls, String.format(null, str, objArr), th);
        }
    }

    public static void A00(Class cls, String str, Throwable th) {
        C08H c08h = A00;
        if (c08h.ANo(6)) {
            c08h.A92(cls.getSimpleName(), str, th);
        }
    }

    public static void A01(Class cls, String str, Throwable th) {
        C08H c08h = A00;
        if (c08h.ANo(5)) {
            c08h.Apd(cls.getSimpleName(), str, th);
        }
    }

    public static void A03(Class cls, String str, Object... objArr) {
        C08H c08h = A00;
        if (c08h.ANo(5)) {
            c08h.Apc(cls.getSimpleName(), String.format(null, str, objArr));
        }
    }

    public static void A04(String str, Class cls) {
        C08H c08h = A00;
        if (c08h.ANo(6)) {
            c08h.A91(cls.getSimpleName(), str);
        }
    }

    public static void A05(String str, String str2) {
        C08H c08h = A00;
        if (c08h.ANo(6)) {
            c08h.A91(str, str2);
        }
    }

    public static void A06(String str, String str2) {
        C08H c08h = A00;
        if (c08h.ANo(5)) {
            c08h.Apc(str, str2);
        }
    }

    public static void A07(String str, String str2, Throwable th) {
        C08H c08h = A00;
        if (c08h.ANo(6)) {
            c08h.A92(str, str2, th);
        }
    }

    public static void A08(String str, String str2, Object... objArr) {
        C08H c08h = A00;
        if (c08h.ANo(6)) {
            c08h.A91(str, String.format(null, str2, objArr));
        }
    }

    public static void A09(String str, String str2, Object... objArr) {
        C08H c08h = A00;
        if (c08h.ANo(5)) {
            c08h.Apc(str, String.format(null, str2, objArr));
        }
    }

    public static void A0A(String str, String str2, Object... objArr) {
        C08H c08h = A00;
        if (c08h.ANo(6)) {
            c08h.AqL(str, String.format(null, str2, objArr));
        }
    }
}
