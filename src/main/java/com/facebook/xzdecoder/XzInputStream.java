package com.facebook.xzdecoder;

import X.AnonymousClass000;
import X.C0B2;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class XzInputStream extends InputStream {
    public int clientOutPos;
    public InputStream inFile;
    public int inPos;
    public int inSize;
    public int outPos;
    public byte[] inBuf = new byte[32768];
    public byte[] outBuf = new byte[32768];
    public long state = initializeState();

    public static native long decompressStream(long j, byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4);

    public static native void end(long j);

    public static native void initializeLibrary();

    public static native long initializeState();

    private boolean readMoreInput() throws IOException {
        this.inSize = 0;
        int i = 0;
        this.inPos = 0;
        do {
            InputStream inputStream = this.inFile;
            byte[] bArr = this.inBuf;
            int i2 = inputStream.read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                return this.inSize > 0;
            }
            i = this.inSize + i2;
            this.inSize = i;
        } while (i < 32768);
        return true;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (i2 < 0 || i < 0 || i + i2 > bArr.length) {
            Object[] objArr = new Object[3];
            AnonymousClass000.A0N(objArr, bArr.length, 0);
            AnonymousClass000.A0N(objArr, i, 1);
            AnonymousClass000.A0N(objArr, i2, 2);
            throw new IndexOutOfBoundsException(String.format("buf.length = %d, off = %d, len = %d", objArr));
        }
        if (this.state == 0) {
            throw new IOException("Stream closed");
        }
        int i4 = i2;
        while (i3 < i2) {
            int i5 = this.clientOutPos;
            int i6 = this.outPos;
            if (i5 < i6) {
                int iMin = Math.min(i4, i6 - i5);
                System.arraycopy(this.outBuf, i5, bArr, i, iMin);
                this.clientOutPos += iMin;
                i4 -= iMin;
                i += iMin;
                i3 += iMin;
            } else {
                if (this.inPos == this.inSize && !readMoreInput()) {
                    if (i3 == 0) {
                        return -1;
                    }
                    return i3;
                }
                decodeMoreBytes();
            }
        }
        return i3;
    }

    static {
        C0B2.A00("fb_xzdecoder");
        initializeLibrary();
    }

    private void decodeMoreBytes() {
        long j = this.state;
        byte[] bArr = this.inBuf;
        int i = this.inPos;
        int i2 = this.inSize;
        byte[] bArr2 = this.outBuf;
        long jDecompressStream = decompressStream(j, bArr, i, i2, bArr2, 0, bArr2.length);
        this.inPos = (int) (jDecompressStream >>> 32);
        this.outPos = (int) jDecompressStream;
        this.clientOutPos = 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inFile.close();
        long j = this.state;
        if (j != 0) {
            end(j);
            this.state = 0L;
        }
    }

    public XzInputStream(InputStream inputStream) {
        this.inFile = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.state != 0) {
            if (this.clientOutPos == this.outPos) {
                if (this.inPos == this.inSize && !readMoreInput()) {
                    return -1;
                }
                decodeMoreBytes();
            }
            byte[] bArr = this.outBuf;
            int i = this.clientOutPos;
            this.clientOutPos = i + 1;
            return bArr[i];
        }
        throw new IOException("Stream closed");
    }
}
