package X;

import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: X.02W, reason: invalid class name */
/* loaded from: classes.dex */
public interface C02W {
    String AIH();

    C05O AKX();

    void close();

    void closeBecauseUnhealthy();

    String getEarlyDataType();

    InputStream getInputStream();

    OutputStream getOutputStream();

    int getPskValidityHint();

    int getSoTimeout();

    Integer getStickinessToken();

    int getTimeSinceLastDataReceivedMillis();

    int getTransportType();

    boolean isClosed();

    boolean isConnected();

    void setSoTimeout(int i);
}
