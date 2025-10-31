package X;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.soloader.SysUtil$LollipopSysdeps;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

/* renamed from: X.0B5, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C0B5 {
    public static C02490Bk A00(File file, File file2) throws IOException {
        try {
            return new C02490Bk(file2);
        } catch (FileNotFoundException e) {
            try {
                if (file.setWritable(true)) {
                    return new C02490Bk(file2);
                }
                throw e;
            } finally {
                if (!file.setWritable(false)) {
                    Log.w("SysUtil", AnonymousClass000.A06(file.getCanonicalPath(), " write permission", AnonymousClass000.A0A("error removing ")));
                }
            }
        }
    }

    public static String A01() throws NoSuchMethodException, SecurityException {
        ClassLoader classLoader = C0BG.class.getClassLoader();
        if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
            try {
                return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", null).invoke((BaseDexClassLoader) classLoader, null);
            } catch (Exception e) {
                A06(e);
                return null;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ClassLoader ");
        sb.append(classLoader.getClass().getName());
        sb.append(" should be of type BaseDexClassLoader");
        throw new IllegalStateException(sb.toString());
    }

    public static String A02(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(":");
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    public static Method A03() throws NoSuchMethodException, SecurityException {
        int i = Build.VERSION.SDK_INT;
        if (i < 23 || i > 27) {
            return null;
        }
        try {
            Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e) {
            A07(e);
            return null;
        }
    }

    public static void A05(File file) throws IOException {
        Stack stack = new Stack();
        stack.push(file);
        ArrayList arrayListA0B = AnonymousClass000.A0B();
        while (!stack.isEmpty()) {
            File file2 = (File) stack.pop();
            if (file2.isDirectory()) {
                arrayListA0B.add(file2);
                File[] fileArrListFiles = file2.listFiles();
                if (fileArrListFiles != null) {
                    for (File file3 : fileArrListFiles) {
                        stack.push(file3);
                    }
                }
            } else {
                A04(file2);
            }
        }
        int size = arrayListA0B.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                A04((File) arrayListA0B.get(size));
            }
        }
    }

    public static void A06(Throwable th) {
        Log.e("SysUtil", "Cannot call getLdLibraryPath", th);
    }

    public static void A07(Throwable th) {
        Log.w("SysUtil", "Cannot get nativeLoad method", th);
    }

    public static boolean A08() {
        if (Build.VERSION.SDK_INT >= 23) {
            return C0B6.A00();
        }
        try {
            return SysUtil$LollipopSysdeps.is64Bit();
        } catch (Exception e) {
            Log.e("SysUtil", String.format("Could not read /proc/self/exe. Err msg: %s", e.getMessage()));
            return false;
        }
    }

    public static boolean A09(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return C0B6.A01(context);
        }
        return false;
    }

    public static boolean A0A(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return C0B6.A02(context, i);
        }
        return false;
    }

    public static String[] A0B() {
        return Build.VERSION.SDK_INT >= 23 ? C0B6.A03() : SysUtil$LollipopSysdeps.getSupportedAbis();
    }

    public static void A04(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.canWrite() && !parentFile.setWritable(true)) {
            Log.e("SysUtil", AnonymousClass000.A05(parentFile, "Enable write permission failed: ", AnonymousClass000.A09()));
        }
        if (!file.delete() && file.exists()) {
            throw new IOException(AnonymousClass000.A05(file, "Could not delete file ", AnonymousClass000.A09()));
        }
    }
}
