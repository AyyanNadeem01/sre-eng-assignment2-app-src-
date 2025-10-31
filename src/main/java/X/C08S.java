package X;

import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: X.08S */
/* loaded from: classes.dex */
public final class C08S implements C08Q {
    public static volatile Method A00;
    public static volatile boolean A01;
    public static volatile Method A02;
    public static volatile Method A03;
    public static volatile boolean A04;
    public static volatile boolean A05;

    @Override // X.C08Q
    public final int Ah0(String str, int[] iArr, long[] jArr, String[] strArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objA01 = A01(A02(), str, iArr, strArr, jArr, null);
        if (objA01 == null) {
            return 2;
        }
        return !((Boolean) objA01).booleanValue() ? 3 : 0;
    }

    @Override // X.C08Q
    public final boolean Ah1(String str, long[] jArr, String[] strArr, long j) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = j;
        }
        Method methodA03 = A03();
        Object[] objArr = new Object[3];
        objArr[0] = str;
        AnonymousClass000.A0H(strArr, jArr, objArr);
        return !Boolean.FALSE.equals(A01(methodA03, objArr));
    }

    public static C08S A00() {
        if (Build.VERSION.SDK_INT > 25) {
            return null;
        }
        if (!A01) {
            Class cls = Integer.TYPE;
            A00 = A04("parseProcLine", byte[].class, cls, cls, int[].class, String[].class, long[].class, float[].class);
            A01 = true;
        }
        if (A00 == null || A02() == null || A03() == null) {
            return null;
        }
        return new C08S();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v13 */
    public static Object A01(Method method, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (method != null) {
            int iInvoke = 6;
            iInvoke = 6;
            try {
                iInvoke = method.invoke(null, objArr);
                return iInvoke;
            } catch (IllegalAccessException e) {
                if (Log.isLoggable("OldProcReader", iInvoke)) {
                    Log.e("OldProcReader", AnonymousClass000.A06(e.getLocalizedMessage(), ")", new StringBuilder("Error (IllegalAccessException - ")), e);
                }
            } catch (InvocationTargetException e2) {
                if (Log.isLoggable("OldProcReader", iInvoke)) {
                    Log.e("OldProcReader", AnonymousClass000.A06(e2.getLocalizedMessage(), ")", new StringBuilder("Error (InvocationTargetException - ")), e2);
                }
            }
        }
        return Boolean.FALSE;
    }

    public static Method A02() {
        if (!A04) {
            A02 = A04("readProcFile", String.class, int[].class, String[].class, long[].class, float[].class);
            A04 = true;
        }
        return A02;
    }

    public static Method A03() {
        if (!A05) {
            A03 = A04("readProcLines", String.class, String[].class, long[].class);
            A05 = true;
        }
        return A03;
    }

    public static Method A04(String str, Class... clsArr) {
        try {
            return Process.class.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            if (!Log.isLoggable("OldProcReader", 5)) {
                return null;
            }
            Log.w("OldProcReader", AnonymousClass000.A07(str, new StringBuilder("Warning! Could not get access to JNI method - ")), e);
            return null;
        }
    }
}
