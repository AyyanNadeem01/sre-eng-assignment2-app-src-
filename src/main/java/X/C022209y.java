package X;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/* renamed from: X.09y, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C022209y implements C05P {
    @Override // X.C05P
    public final C02W ARd(C05V c05v) throws IOException {
        Socket socket = new Socket();
        C05T c05t = c05v.A00;
        socket.connect(new InetSocketAddress((InetAddress) c05v.A01.get(0), c05t.A01.A00), c05t.A00);
        socket.getOutputStream();
        return new C004802c(c05v, socket);
    }
}
