package com.facebook.lite.splitdex;

import X.AnonymousClass087;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class MegazipDexStorage$PerformSecondaryDexOptHackR$PerformSecondaryDexOptHackRInternal {
    public static boolean apply(Context context, PackageManager packageManager) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Field declaredField = Class.forName("android.app.ApplicationPackageManager").getDeclaredField("mPM");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(packageManager);
            if (obj == null) {
                Log.e(AnonymousClass087.A02(), "Wasn't able to get the IPackageManager object");
                return false;
            }
            Method declaredMethod = Class.forName("android.content.pm.IPackageManager").getDeclaredMethod("performDexOptSecondary", String.class, String.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(obj, context.getPackageName(), "speed", true);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Wrong return value: ");
            sb.append(objInvoke);
            Log.e("PerformSecondaryDexOpt", sb.toString());
            return false;
        } catch (Exception e) {
            Log.e("PerformSecondaryDexOpt", "Failed to apply method", e);
            return false;
        }
    }
}
