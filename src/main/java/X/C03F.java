package X;

import android.content.Context;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: X.03F, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C03F {
    public static final Map A00 = Collections.synchronizedMap(new HashMap());

    public static void A00(Context context, int i) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            File file = new File(context.getFilesDir(), "GkBootstrap");
            if (!file.exists()) {
                if (!file.mkdir()) {
                    return;
                }
            }
            File file2 = new File(new File(context.getFilesDir(), "GkBootstrap"), "breakpad_write_only_crash_thread");
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file2));
                try {
                    dataOutputStream.writeInt(i);
                    dataOutputStream.close();
                } catch (Throwable th) {
                    try {
                        dataOutputStream.close();
                    } catch (Throwable th2) {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    }
                    throw th;
                }
            } catch (IOException | SecurityException e) {
                C018108b.A0H("GkBootstrap", "Unable to persist GK value to %s", e, file2);
            }
        } catch (SecurityException e2) {
            C018108b.A0G("GkBootstrap", "Unable to create %s directory", e2, "GkBootstrap");
        }
    }
}
