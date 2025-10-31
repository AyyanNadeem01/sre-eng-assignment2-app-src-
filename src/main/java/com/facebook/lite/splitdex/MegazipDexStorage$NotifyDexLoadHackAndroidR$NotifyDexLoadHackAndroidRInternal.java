package com.facebook.lite.splitdex;

import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class MegazipDexStorage$NotifyDexLoadHackAndroidR$NotifyDexLoadHackAndroidRInternal {
    public static void apply(ClassLoader classLoader) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method declaredMethod = BaseDexClassLoader.class.getDeclaredMethod("reportClassLoaderChain", null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(classLoader, null);
        } catch (Exception e) {
            Log.e("NotifyDexLoad", "Failed to get method", e);
        }
    }
}
