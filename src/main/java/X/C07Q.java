package X;

import android.os.Trace;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: X.07Q, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C07Q {
    public static final long A00;
    public static final Method A01;
    public static final Method A02;
    public static volatile boolean A03;

    static {
        try {
            Method method = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            Method method2 = Trace.class.getMethod("setAppTracingAllowed", Boolean.TYPE);
            Field field = Trace.class.getField("TRACE_TAG_APP");
            if (field.getType() == Long.TYPE) {
                long j = field.getLong(null);
                A01 = method;
                A02 = method2;
                A00 = j;
                A03 = true;
            }
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException unused) {
        }
    }

    public static Object A00(Method method, Object... objArr) throws Throwable {
        Object objInvoke = null;
        try {
            objInvoke = method.invoke(null, objArr);
            return objInvoke;
        } catch (IllegalAccessException unused) {
            A03 = false;
            return objInvoke;
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if ((targetException instanceof RuntimeException) || (targetException instanceof Error)) {
                throw targetException;
            }
            return objInvoke;
        }
    }
}
