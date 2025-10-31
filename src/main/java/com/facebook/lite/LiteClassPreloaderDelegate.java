package com.facebook.lite;

import X.AnonymousClass000;
import X.C01Q;
import android.content.Context;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class LiteClassPreloaderDelegate {
    public static boolean isClassPreloadingActivityEnabled(Context context) {
        return C01Q.A02(context, "pref_key_class_preloading_activity");
    }

    public static boolean isClassPreloadingAppEnabled(Context context) {
        return C01Q.A02(context, "pref_key_class_preloading_app");
    }

    public static void setClassPreloadingActivityEnabled(Context context, boolean z) throws IOException {
        File fileA02 = AnonymousClass000.A02(context.getFilesDir(), "pref_key_class_preloading_activity");
        try {
            if (z) {
                fileA02.createNewFile();
            } else {
                fileA02.delete();
            }
        } catch (IOException unused) {
        }
    }

    public static void setClassPreloadingAppEnabled(Context context, boolean z) throws IOException {
        File fileA02 = AnonymousClass000.A02(context.getFilesDir(), "pref_key_class_preloading_app");
        try {
            if (z) {
                fileA02.createNewFile();
            } else {
                fileA02.delete();
            }
        } catch (IOException unused) {
        }
    }

    public static boolean isClassPreloadingEnabled(Context context, String str) {
        return C01Q.A02(context, str);
    }

    public static void setClassPreloadingEnabled(Context context, String str, boolean z) throws IOException {
        File fileA02 = AnonymousClass000.A02(context.getFilesDir(), str);
        try {
            if (z) {
                fileA02.createNewFile();
            } else {
                fileA02.delete();
            }
        } catch (IOException unused) {
        }
    }

    public static void preloadClasses(Context context, boolean z, boolean z2) throws ClassNotFoundException {
        C01Q.A01(context, z, z2);
    }
}
