package X;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* renamed from: X.05s, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC013005s extends ByteChannel {
    int Agn(ByteBuffer byteBuffer, long j);

    @Override // java.nio.channels.ReadableByteChannel
    int read(ByteBuffer byteBuffer);

    long size();
}
