package X;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: X.0C2, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0C2 implements InterfaceC013005s {
    public InputStream A01;
    public final long A03;
    public final ZipEntry A04;
    public final ZipFile A05;
    public boolean A02 = true;
    public long A00 = 0;

    @Override // X.InterfaceC013005s
    public final int Agn(ByteBuffer byteBuffer, long j) throws IOException {
        if (this.A01 == null) {
            throw new IOException("InputStream is null");
        }
        int iRemaining = byteBuffer.remaining();
        long j2 = this.A03;
        long j3 = j2 - j;
        if (j3 <= 0) {
            return -1;
        }
        int i = (int) j3;
        if (iRemaining > i) {
            iRemaining = i;
        }
        InputStream inputStream = this.A01;
        if (inputStream == null) {
            throw new IOException(AnonymousClass000.A06(this.A04.getName(), "'s InputStream is null", AnonymousClass000.A09()));
        }
        long j4 = this.A00;
        if (j != j4) {
            if (j > j2) {
                j = j2;
            }
            if (j >= j4) {
                inputStream.skip(j - j4);
            } else {
                inputStream.close();
                ZipFile zipFile = this.A05;
                ZipEntry zipEntry = this.A04;
                InputStream inputStream2 = zipFile.getInputStream(zipEntry);
                this.A01 = inputStream2;
                if (inputStream2 == null) {
                    throw new IOException(AnonymousClass000.A06(zipEntry.getName(), "'s InputStream is null", AnonymousClass000.A09()));
                }
                inputStream2.skip(j);
            }
            this.A00 = j;
        }
        if (byteBuffer.hasArray()) {
            this.A01.read(byteBuffer.array(), 0, iRemaining);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        } else {
            byte[] bArr = new byte[iRemaining];
            this.A01.read(bArr, 0, iRemaining);
            byteBuffer.put(bArr, 0, iRemaining);
        }
        this.A00 += iRemaining;
        return iRemaining;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream inputStream = this.A01;
        if (inputStream != null) {
            inputStream.close();
            this.A02 = false;
        }
    }

    @Override // X.InterfaceC013005s, java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        return Agn(byteBuffer, this.A00);
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException("ElfZipFileChannel doesn't support write");
    }

    public C0C2(ZipEntry zipEntry, ZipFile zipFile) throws IOException {
        this.A05 = zipFile;
        this.A04 = zipEntry;
        this.A03 = zipEntry.getSize();
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        this.A01 = inputStream;
        if (inputStream != null) {
            return;
        }
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append(zipEntry.getName());
        throw new IOException(AnonymousClass000.A07("'s InputStream is null", sbA09));
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.A02;
    }

    @Override // X.InterfaceC013005s
    public final long size() {
        return this.A03;
    }
}
