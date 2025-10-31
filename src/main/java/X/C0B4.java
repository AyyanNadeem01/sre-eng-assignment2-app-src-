package X;

import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;

/* renamed from: X.0B4, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0B4 extends C0AD {
    @Override // X.C0AD
    public final int A03(StrictMode.ThreadPolicy threadPolicy, String str, int i) {
        try {
            System.loadLibrary(str.substring(3, str.length() - 3));
            return 1;
        } catch (UnsatisfiedLinkError e) {
            ClassLoader classLoader = C0B4.class.getClassLoader();
            if (!(classLoader instanceof BaseDexClassLoader)) {
                Log.w("SoLoader", "ClassLoader is not a BaseDexClassLoader");
            } else if (((BaseDexClassLoader) classLoader).findLibrary(str) != null) {
                throw e;
            }
            Log.e("SoLoader", AnonymousClass000.A06("Error loading library: ", str, AnonymousClass000.A09()), e);
            return 0;
        }
    }

    @Override // X.C0AD
    public final String A06(String str) throws NoSuchMethodException, SecurityException {
        String strA01 = C0B5.A01();
        if (TextUtils.isEmpty(strA01)) {
            return null;
        }
        for (String str2 : strA01.split(":")) {
            if (C0B5.A09(C0BG.A03) && str2.contains(".apk!")) {
                return AnonymousClass000.A06(File.separator, str, AnonymousClass000.A0A(str2));
            }
            File file = new File(str2, str);
            if (file.exists()) {
                return file.getCanonicalPath();
            }
        }
        return null;
    }

    @Override // X.C0AD
    public final String toString() {
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("SystemLoadWrapperSoSource");
        sbA09.append("[");
        sbA09.append(C0B5.A01());
        return AnonymousClass000.A07("]", sbA09);
    }

    @Override // X.C0AD
    public final String A05() {
        return "SystemLoadWrapperSoSource";
    }
}
