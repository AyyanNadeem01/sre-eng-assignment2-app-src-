package X;

import android.content.Context;
import android.os.StrictMode;
import android.os.SystemClock;
import dalvik.system.DexFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/* renamed from: X.01Q, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C01Q {
    public static Long A00;

    public static void A01(final Context context, final boolean z, boolean z2) throws ClassNotFoundException {
        Long l = A00;
        if (l == null || SystemClock.elapsedRealtime() - l.longValue() >= 5000) {
            A00 = Long.valueOf(SystemClock.elapsedRealtime());
            if (z2) {
                new Thread(new Runnable() { // from class: X.0CU
                    public static final String __redex_internal_original_name = "LiteClassPreloader$1";

                    @Override // java.lang.Runnable
                    public final void run() throws ClassNotFoundException {
                        C01Q.A00(context, z);
                    }
                }).start();
            } else {
                A00(context, z);
            }
        }
    }

    public static void A00(Context context, boolean z) throws ClassNotFoundException {
        C019708s c019708sA00 = C019708s.A00(context);
        ArrayList arrayList = new ArrayList();
        for (DexFile dexFile : c019708sA00.A03) {
            if (dexFile != null) {
                Enumeration<String> enumerationEntries = dexFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    arrayList.add(enumerationEntries.nextElement());
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                Class.forName((String) it.next(), z, c019708sA00);
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static boolean A02(Context context, String str) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File(context.getFilesDir(), str);
            boolean zExists = file.exists();
            file.delete();
            return zExists;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}
