package X;

import android.util.Log;
import com.facebook.soloader.SysUtil$LollipopSysdeps;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* renamed from: X.0CM, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C0CM implements Closeable {
    public abstract void A01(File file);

    public abstract C0Bz[] A02();

    public static void A00(C0Bz c0Bz, File file, InputStream inputStream, byte[] bArr) {
        String str = c0Bz.A01;
        AbstractC02460Bh.A00("fb-UnpackingSoSource");
        File fileA02 = AnonymousClass000.A02(file, str);
        try {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileA02, "rw");
                try {
                    int iAvailable = inputStream.available();
                    if (iAvailable > 1) {
                        SysUtil$LollipopSysdeps.fallocateIfSupported(randomAccessFile.getFD(), iAvailable);
                    }
                    int i = 0;
                    do {
                        int i2 = inputStream.read(bArr, 0, Math.min(32768, Integer.MAX_VALUE - i));
                        if (i2 == -1) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, i2);
                        i += i2;
                    } while (i < Integer.MAX_VALUE);
                    randomAccessFile.setLength(randomAccessFile.getFilePointer());
                    if (!fileA02.setExecutable(true, false)) {
                        throw new IOException(AnonymousClass000.A05(fileA02, "cannot make file executable: ", AnonymousClass000.A09()));
                    }
                    randomAccessFile.close();
                } catch (Throwable th) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th2) {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                StringBuilder sbA09 = AnonymousClass000.A09();
                sbA09.append("error extracting dso  ");
                sbA09.append(fileA02);
                Log.e("fb-UnpackingSoSource", AnonymousClass000.A05(e, " due to: ", sbA09));
                C0B5.A05(fileA02);
                throw e;
            }
        } finally {
            if (fileA02.exists() && !fileA02.setWritable(false)) {
                StringBuilder sbA0A = AnonymousClass000.A0A("Error removing ");
                sbA0A.append(fileA02);
                sbA0A.append(" write permission from directory ");
                sbA0A.append(file);
                sbA0A.append(" (writable: ");
                sbA0A.append(file.canWrite());
                AnonymousClass000.A0J(")", "SoLoader", sbA0A);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
