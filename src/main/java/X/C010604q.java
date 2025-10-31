package X;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* renamed from: X.04q, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public class C010604q {
    public MappedByteBuffer A00;
    public final File A01;

    public C010604q(File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        this.A01 = file;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            try {
                this.A00 = channel.map(FileChannel.MapMode.READ_WRITE, 0L, 4096L);
                if (channel.tryLock() == null) {
                    throw new IOException(String.format("Unable to acquire lock for app state log aslFile: %s", file.getCanonicalPath()));
                }
                channel.close();
                randomAccessFile.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
                throw th;
            } finally {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
            }
        }
    }

    public void mlockBuffer() {
    }
}
