package X;

import java.util.Arrays;

/* renamed from: X.06E, reason: invalid class name */
/* loaded from: classes.dex */
public final class C06E {
    public static int A00(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static void A01(Object obj) {
        if (obj == null) {
            A09(obj, "ARRAY_ELEMENT");
            throw AnonymousClass062.createAndThrow();
        }
    }

    public static void A02(Object obj) {
        if (obj == null) {
            A09(obj, "INSTANCE_FIELD");
            throw AnonymousClass062.createAndThrow();
        }
    }

    public static void A03(Object obj) {
        if (obj == null) {
            A09(obj, "INVOKE_RETURN");
            throw AnonymousClass062.createAndThrow();
        }
    }

    public static void A04(Object obj) {
        if (obj == null) {
            A09(obj, "STATIC_FIELD");
            throw AnonymousClass062.createAndThrow();
        }
    }

    public static void A05(Object obj) {
        if (obj == null) {
            A09(obj, "UNKNOWN");
            throw AnonymousClass062.createAndThrow();
        }
    }

    public static void A06(Object obj) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException();
            A0B(C06E.class.getName(), nullPointerException);
            throw nullPointerException;
        }
    }

    public static void A07(Object obj, int i) {
        if (obj == null) {
            String strA06 = AnonymousClass000.A06("param at index = ", Integer.toString(i), AnonymousClass000.A09());
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = C06E.class.getName();
            int i2 = 0;
            while (!stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            while (stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            StringBuilder sbA09 = AnonymousClass000.A09();
            sbA09.append("Parameter specified as non-null is null: method ");
            sbA09.append(className);
            sbA09.append(".");
            sbA09.append(methodName);
            NullPointerException nullPointerException = new NullPointerException(AnonymousClass000.A06(", parameter ", strA06, sbA09));
            A0B(name, nullPointerException);
            throw nullPointerException;
        }
    }

    public static void A08(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            A0B(C06E.class.getName(), nullPointerException);
            throw nullPointerException;
        }
    }

    public static void A09(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(AnonymousClass000.A07(" must not be null", AnonymousClass000.A0A(str)));
        A0B(C06E.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static boolean areEqual(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void A0A(String str) {
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("lateinit property ");
        sbA09.append(str);
        C08Y c08y = new C08Y(AnonymousClass000.A07(" has not been initialized", sbA09));
        A0B(C06E.class.getName(), c08y);
        throw c08y;
    }

    public static void A0B(String str, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
    }
}
