package X;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

/* renamed from: X.02c, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C004802c implements C02W {
    public final C05V A00;
    public final Socket A01;

    @Override // X.C02W
    public final C05O AKX() {
        return this.A00.A00.A01;
    }

    @Override // X.C02W
    public final void close() throws IOException {
        this.A01.close();
    }

    @Override // X.C02W
    public final InputStream getInputStream() {
        return this.A01.getInputStream();
    }

    @Override // X.C02W
    public final OutputStream getOutputStream() {
        return this.A01.getOutputStream();
    }

    @Override // X.C02W
    public final int getSoTimeout() {
        return this.A01.getSoTimeout();
    }

    @Override // X.C02W
    public final boolean isClosed() {
        return this.A01.isClosed();
    }

    @Override // X.C02W
    public final boolean isConnected() {
        return this.A01.isConnected();
    }

    @Override // X.C02W
    public final void setSoTimeout(int i) throws SocketException {
        this.A01.setSoTimeout(i);
    }

    public C004802c(C05V c05v, Socket socket) {
        this.A01 = socket;
        this.A00 = c05v;
    }

    @Override // X.C02W
    public final String AIH() {
        return null;
    }

    @Override // X.C02W
    public final void closeBecauseUnhealthy() throws IOException {
        close();
    }

    @Override // X.C02W
    public final String getEarlyDataType() {
        return "NOT_FIZZ_SOCKET";
    }

    @Override // X.C02W
    public final int getPskValidityHint() {
        return 0;
    }

    @Override // X.C02W
    public final Integer getStickinessToken() {
        return null;
    }

    @Override // X.C02W
    public final int getTimeSinceLastDataReceivedMillis() {
        return -1;
    }

    @Override // X.C02W
    public final int getTransportType() {
        return 1;
    }
}
