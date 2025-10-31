package X;

import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: X.01z, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C004501z {
    public static C004501z A07;
    public static final long A08 = TimeUnit.MINUTES.toMillis(2);
    public long A00;
    public volatile File A04;
    public volatile File A05;
    public volatile StatFs A03 = null;
    public volatile StatFs A02 = null;
    public volatile boolean A06 = false;
    public final Lock A01 = new ReentrantLock();

    public static StatFs A00(StatFs statFs, File file) throws Throwable {
        if (file != null && file.exists()) {
            try {
                if (statFs == null) {
                    return new StatFs(file.getAbsolutePath());
                }
                statFs.restat(file.getAbsolutePath());
                return statFs;
            } catch (IllegalArgumentException unused) {
            } catch (Throwable th) {
                C08E.A00(th);
                throw AnonymousClass062.createAndThrow();
            }
        }
        return null;
    }

    public static synchronized C004501z A01() {
        C004501z c004501z;
        c004501z = A07;
        if (c004501z == null) {
            c004501z = new C004501z();
            A07 = c004501z;
        }
        return c004501z;
    }

    public static void A02(C004501z c004501z) {
        if (c004501z.A06) {
            return;
        }
        Lock lock = c004501z.A01;
        lock.lock();
        try {
            if (!c004501z.A06) {
                c004501z.A05 = Environment.getDataDirectory();
                c004501z.A04 = Environment.getExternalStorageDirectory();
                c004501z.A03 = A00(c004501z.A03, c004501z.A05);
                c004501z.A02 = A00(c004501z.A02, c004501z.A04);
                c004501z.A00 = SystemClock.uptimeMillis();
                c004501z.A06 = true;
            }
        } finally {
            lock.unlock();
        }
    }

    public static void A03(C004501z c004501z) {
        Lock lock = c004501z.A01;
        if (lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - c004501z.A00 > A08) {
                    c004501z.A03 = A00(c004501z.A03, c004501z.A05);
                    c004501z.A02 = A00(c004501z.A02, c004501z.A04);
                    c004501z.A00 = SystemClock.uptimeMillis();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public final long A04(Integer num) {
        A02(this);
        A03(this);
        StatFs statFs = num == AnonymousClass065.A00 ? this.A03 : this.A02;
        if (statFs != null) {
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        }
        return 0L;
    }
}
