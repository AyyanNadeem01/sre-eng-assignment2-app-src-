package X;

import android.app.Application;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: X.04z */
/* loaded from: classes.dex */
public final class C011404z {
    public static final Map A05 = new HashMap();
    public int A00;
    public int A01;
    public File A02;
    public Object A03;
    public String A04;

    public static synchronized C011404z A00(String str) {
        C011404z c011404z;
        Map map = A05;
        c011404z = (C011404z) map.get(str);
        if (c011404z == null) {
            c011404z = new C011404z();
            c011404z.A03 = new Object();
            c011404z.A04 = str;
            map.put(str, c011404z);
        }
        return c011404z;
    }

    public final void A01() {
        synchronized (this.A03) {
            C018108b.A08("lacrima", "FixedLengthFiles.forceDeleteAllFiles");
            File[] fileArrListFiles = this.A02.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    file.delete();
                }
            }
        }
    }

    public final void A02() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long j;
        this.A02.mkdirs();
        File[] fileArrListFiles = this.A02.listFiles();
        int i = this.A00;
        long length = i;
        if (fileArrListFiles != null) {
            length = i - fileArrListFiles.length;
        }
        long jMin = Math.min(AnonymousClass050.A00() / this.A01, length);
        for (int i2 = 0; i2 < jMin; i2++) {
            try {
                File file = this.A02;
                StringBuilder sb = new StringBuilder();
                sb.append(UUID.randomUUID().toString());
                sb.append("_prop.txt");
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, sb.toString()), "rw");
                long j2 = 0;
                while (true) {
                    try {
                        j = this.A01;
                        if (j2 >= j) {
                            break;
                        }
                        randomAccessFile.seek(j2);
                        randomAccessFile.writeByte(32);
                        j2 += 4096;
                    } catch (Throwable th) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th2) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        }
                        throw th;
                    }
                }
                randomAccessFile.setLength(j);
                randomAccessFile.close();
            } catch (IOException e) {
                C0C5.A00();
                C018108b.A0C("lacrima", "Initialization failed.", e);
                return;
            }
        }
    }

    public final void A03(Application application, int i, int i2) {
        synchronized (this.A03) {
            if (this.A02 != null) {
                C018108b.A08("lacrima", "FixedLengthFiles.init() called twice.");
            } else {
                this.A00 = i;
                this.A01 = i2;
                StringBuilder sb = new StringBuilder();
                sb.append("file_pool");
                sb.append(this.A04);
                this.A02 = application.getDir(sb.toString(), 0);
            }
        }
    }
}
