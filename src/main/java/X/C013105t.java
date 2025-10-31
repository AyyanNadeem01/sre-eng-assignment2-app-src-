package X;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* renamed from: X.05t, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C013105t implements InterfaceC013005s {
    public File A00;
    public FileInputStream A01;
    public FileChannel A02;

    @Override // X.InterfaceC013005s
    public final int Agn(ByteBuffer byteBuffer, long j) {
        return this.A02.read(byteBuffer, j);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A01.close();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.A02.isOpen();
    }

    @Override // X.InterfaceC013005s, java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        return this.A02.read(byteBuffer);
    }

    @Override // X.InterfaceC013005s
    public final long size() {
        return this.A02.size();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        return this.A02.write(byteBuffer);
    }
}
