package X;

import android.os.Environment;
import android.os.StatFs;

/* renamed from: X.050, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass050 {
    public static long A00 = 1;

    public static synchronized long A01() {
        long totalBytes;
        totalBytes = A00;
        if (totalBytes == 1) {
            totalBytes = new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes();
            A00 = totalBytes;
        }
        return totalBytes;
    }

    public static long A00() {
        return Math.max(0L, new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes());
    }
}
