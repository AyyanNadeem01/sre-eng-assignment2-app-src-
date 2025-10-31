package X;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: X.07O, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C07O {
    public static final Method A00;
    public static final Method A01;
    public static final Method A02;
    public static final Method A03;
    public static final Method A04;
    public static final Method A05;
    public static volatile boolean A06;

    public static Object A01(Method method, Object... objArr) throws Throwable {
        Object objInvoke = null;
        if (method != null) {
            try {
                objInvoke = method.invoke(null, objArr);
                return objInvoke;
            } catch (IllegalAccessException unused) {
                A06 = false;
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if ((targetException instanceof RuntimeException) || (targetException instanceof Error)) {
                    throw targetException;
                }
                return objInvoke;
            }
        }
        return objInvoke;
    }

    static {
        boolean z;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", String.class);
            Method method2 = cls.getMethod("getBoolean", String.class, Boolean.TYPE);
            Method method3 = cls.getMethod("getInt", String.class, Integer.TYPE);
            Method method4 = cls.getMethod("getLong", String.class, Long.TYPE);
            Method method5 = cls.getMethod("set", String.class, String.class);
            A00 = cls.getMethod("addChangeCallback", Runnable.class);
            A03 = method;
            A02 = method2;
            A01 = method3;
            A04 = method4;
            A05 = method5;
            z = true;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            z = false;
        }
        A06 = z;
    }

    public static long A00(String str) {
        Number number;
        if (!A06 || (number = (Number) A01(A04, str, 0L)) == null) {
            return 0L;
        }
        return number.longValue();
    }

    public static String A02(String str) {
        String str2;
        return (!A06 || (str2 = (String) A01(A03, str)) == null) ? "" : str2;
    }
}
