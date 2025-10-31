package com.facebook.superpack;

import X.C018108b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class SuperpackFileInputStream extends InputStream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public Boolean mCloseWhenInputStreamIsClosed;
    public int mLength;
    public int mMarked;
    public int mOffset;
    public byte[] mOneByte;
    public final SuperpackFile mSuperpackFile;

    public static InputStream wrapAndClose(SuperpackFile superpackFile) {
        return new SuperpackFileInputStream(superpackFile, true);
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return this.mLength - this.mOffset;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.mMarked = this.mOffset;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3 = i2;
        synchronized (this) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i >= 0 && i2 >= 0) {
                int i4 = i2 + i;
                int length = bArr.length;
                if (i4 <= length) {
                    int i5 = this.mOffset;
                    int i6 = this.mLength;
                    if (i5 == i6) {
                        return -1;
                    }
                    if (i2 + i5 > i6) {
                        i3 = i6 - i5;
                    }
                    SuperpackFile superpackFile = this.mSuperpackFile;
                    synchronized (superpackFile) {
                        try {
                            long j = superpackFile.mPtr;
                            if (j == 0) {
                                throw new IllegalStateException();
                            }
                            if (i5 < 0 || i3 < 0) {
                                throw new IndexOutOfBoundsException();
                            }
                            if (i + i3 > length) {
                                throw new IndexOutOfBoundsException();
                            }
                            if (i5 + i3 > superpackFile.mLength) {
                                throw new IndexOutOfBoundsException();
                            }
                            SuperpackFile.readBytesNative(j, i5, i3, bArr, i);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    this.mOffset += i3;
                    return i3;
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.mOffset = this.mMarked;
    }

    @Override // java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 0) {
            return 0L;
        }
        int i = this.mOffset;
        long j2 = i;
        long j3 = j2 + j;
        int i2 = this.mLength;
        if (j3 > i2) {
            j = i2 - i;
        }
        this.mOffset = (int) (j2 + j);
        return j;
    }

    public static SuperpackFileInputStream createFromSingletonArchiveFile(File file, String str) {
        String str2 = SuperpackArchive.TAG;
        return createFromSingletonArchiveFile(file, str, str.equals("spo") ? Runtime.getRuntime().availableProcessors() : 1);
    }

    public static SuperpackFileInputStream createFromSingletonArchiveInputStream(InputStream inputStream, String str) {
        String str2 = SuperpackArchive.TAG;
        return createFromSingletonArchiveInputStream(inputStream, str, str.equals("spo") ? Runtime.getRuntime().availableProcessors() : 1);
    }

    public static int getDefaultThreadNum(String str) {
        String str2 = SuperpackArchive.TAG;
        if (str.equals("spo")) {
            return Runtime.getRuntime().availableProcessors();
        }
        return 1;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.mCloseWhenInputStreamIsClosed.booleanValue()) {
            this.mSuperpackFile.close();
        }
    }

    public SuperpackFileInputStream(SuperpackFile superpackFile, Boolean bool) {
        this(superpackFile);
        this.mCloseWhenInputStreamIsClosed = bool;
    }

    public static SuperpackFileInputStream createFromSingletonArchive(SuperpackArchive superpackArchive, String str) {
        if (!superpackArchive.hasNext()) {
            throw new IllegalArgumentException();
        }
        SuperpackFile next = superpackArchive.next();
        if (superpackArchive.hasNext()) {
            throw new IllegalArgumentException();
        }
        return new SuperpackFileInputStream(next, true);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public SuperpackFileInputStream(SuperpackFile superpackFile) {
        int i;
        if (superpackFile != null) {
            this.mSuperpackFile = superpackFile;
            this.mOffset = 0;
            synchronized (superpackFile) {
                if (superpackFile.mPtr != 0) {
                    i = superpackFile.mLength;
                } else {
                    throw new IllegalStateException();
                }
            }
            this.mLength = i;
            this.mMarked = 0;
            this.mOneByte = null;
            this.mCloseWhenInputStreamIsClosed = false;
            return;
        }
        throw new NullPointerException();
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        int i;
        byte[] bArr = this.mOneByte;
        if (bArr == null) {
            bArr = new byte[1];
            this.mOneByte = bArr;
        }
        int i2 = read(bArr);
        i = -1;
        if (i2 != -1) {
            if (i2 == 1) {
                i = this.mOneByte[0];
                if (i < 0) {
                    i += 256;
                }
            } else {
                throw new IllegalStateException("Unexpected number of bytes read");
            }
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [long] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5, types: [long] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [long] */
    public static SuperpackFileInputStream createFromSingletonArchiveFile(File file, String str, int i) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        SuperpackArchive superpackArchive;
        if (file != null) {
            String str2 = SuperpackArchive.TAG;
            ?? threadNumOption = !str.matches("spo") ? 0 : SuperpackArchive.getThreadNumOption(i);
            try {
                try {
                    threadNumOption = SuperpackArchive.readNative(file.getPath(), str, (long) threadNumOption);
                    superpackArchive = new SuperpackArchive(threadNumOption, null);
                    threadNumOption = threadNumOption;
                } catch (RuntimeException e) {
                    threadNumOption = "SuperpackArchive";
                    C018108b.A0A("SuperpackArchive", "Failed to read superpack file, retrying.", e);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        threadNumOption = SuperpackArchive.readNative(fileInputStream, str, 0L);
                        superpackArchive = new SuperpackArchive(threadNumOption, null);
                    } finally {
                        fileInputStream.close();
                    }
                }
                try {
                    SuperpackFileInputStream superpackFileInputStreamCreateFromSingletonArchive = createFromSingletonArchive(superpackArchive, str);
                    superpackArchive.close();
                    return superpackFileInputStreamCreateFromSingletonArchive;
                } catch (Throwable th) {
                    superpackArchive.close();
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(threadNumOption, th2);
                throw threadNumOption;
            }
        }
        throw new NullPointerException();
    }

    public static SuperpackFileInputStream createFromSingletonArchiveInputStream(InputStream inputStream, String str, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (inputStream != null) {
            String str2 = SuperpackArchive.TAG;
            SuperpackArchive superpackArchive = new SuperpackArchive(SuperpackArchive.readNative(inputStream, str, !str.matches("spo") ? 0L : SuperpackArchive.getThreadNumOption(i)), null);
            try {
                SuperpackFileInputStream superpackFileInputStreamCreateFromSingletonArchive = createFromSingletonArchive(superpackArchive, str);
                superpackArchive.close();
                return superpackFileInputStreamCreateFromSingletonArchive;
            } catch (Throwable th) {
                try {
                    superpackArchive.close();
                    throw th;
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    throw th;
                }
            }
        }
        throw new NullPointerException();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }
}
