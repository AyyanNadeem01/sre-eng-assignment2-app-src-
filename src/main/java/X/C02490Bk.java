package X;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* renamed from: X.0Bk, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C02490Bk implements Closeable {
    public final FileOutputStream A00;
    public final FileLock A01;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            FileLock fileLock = this.A01;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.A00.close();
        }
    }

    public C02490Bk(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.A00 = fileOutputStream;
        try {
            FileLock fileLockLock = fileOutputStream.getChannel().lock();
            if (fileLockLock == null) {
                fileOutputStream.close();
            }
            this.A01 = fileLockLock;
        } catch (Throwable th) {
            this.A00.close();
            throw th;
        }
    }
}
