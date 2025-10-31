package X;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: X.000, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class AnonymousClass000 {
    public static void A0H(Object obj, Object obj2, Object[] objArr) {
        objArr[1] = obj;
        objArr[2] = obj2;
    }

    public static boolean A0O(int i) {
        return i != 0;
    }

    public static Object[] A0Q(Object obj, Field field) {
        Object obj2 = field.get(obj);
        Field declaredField = Class.forName("dalvik.system.DexPathList").getDeclaredField("dexElements");
        declaredField.setAccessible(true);
        return (Object[]) declaredField.get(obj2);
    }

    public static File A02(File file, String str) {
        return new File(file, str);
    }

    public static File A03(String str) {
        return new File(str);
    }

    public static IllegalStateException A04(String str) {
        return new IllegalStateException(str);
    }

    public static StringBuilder A09() {
        return new StringBuilder();
    }

    public static StringBuilder A0A(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static ArrayList A0B() {
        return new ArrayList();
    }

    public static HashMap A0C() {
        return new HashMap();
    }

    public static void A0D(C09N c09n, int i, long j) {
        if (i != 0) {
            c09n.A03("<T");
            c09n.A03(Long.toString(j));
            c09n.A03(">");
        }
    }

    public static void A0F(Object obj, Object obj2, Object obj3, Object obj4, Object[] objArr) {
        objArr[18] = obj;
        objArr[19] = obj2;
        objArr[20] = obj3;
        objArr[21] = obj4;
    }

    public static void A0G(Object obj, Object obj2, Object obj3, Object obj4, Object[] objArr) {
        objArr[52] = obj;
        objArr[53] = obj2;
        objArr[54] = obj3;
        objArr[55] = obj4;
    }

    public static C04Q A00(C0AZ c0az) {
        return (C04Q) c0az.A02().get();
    }

    public static File A01(Context context) {
        return new File(context.getApplicationInfo().sourceDir);
    }

    public static String A05(Object obj, String str, StringBuilder sb) {
        sb.append(str);
        sb.append(obj);
        return sb.toString();
    }

    public static String A06(String str, String str2, StringBuilder sb) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String A07(String str, StringBuilder sb) {
        sb.append(str);
        return sb.toString();
    }

    public static String A08(String str, StringBuilder sb, int i) {
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static void A0E(Object obj, long j, Map map) {
        map.put(obj, Long.valueOf(j));
    }

    public static void A0I(String str, String str2, String str3, StringBuilder sb) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    public static void A0J(String str, String str2, StringBuilder sb) {
        sb.append(str);
        Log.e(str2, sb.toString());
    }

    public static void A0K(String str, String str2, StringBuilder sb) {
        sb.append(str);
        Log.w(str2, sb.toString());
    }

    public static void A0L(StringBuilder sb, Object obj) {
        sb.append(obj.toString());
    }

    public static void A0M(ReentrantReadWriteLock reentrantReadWriteLock) {
        reentrantReadWriteLock.writeLock().unlock();
    }

    public static void A0N(Object[] objArr, int i, int i2) {
        objArr[i2] = Integer.valueOf(i);
    }

    public static InterfaceC012905r[] A0P(AtomicReference atomicReference) {
        return (InterfaceC012905r[]) atomicReference.get();
    }
}
