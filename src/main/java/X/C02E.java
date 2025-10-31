package X;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/* renamed from: X.02E, reason: invalid class name */
/* loaded from: classes.dex */
public final class C02E implements C02D {
    public AnonymousClass024 A00;

    @Override // X.C02D
    public final HttpURLConnection ACn(URL url) throws NoSuchAlgorithmException, KeyManagementException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            AnonymousClass024 anonymousClass024 = this.A00;
            if (anonymousClass024 == null) {
                anonymousClass024 = new AnonymousClass024();
                this.A00 = anonymousClass024;
            }
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, anonymousClass024.A00, null);
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (KeyManagementException | NoSuchAlgorithmException e) {
                C018108b.A0C("lacrima", "Pinning failed", e);
                C0C5.A00();
            }
        }
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        return httpURLConnection;
    }
}
