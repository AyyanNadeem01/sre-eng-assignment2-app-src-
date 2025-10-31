package X;

import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;

/* renamed from: X.02n */
/* loaded from: classes.dex */
public final class C005902n extends X509ExtendedTrustManager implements AnonymousClass025 {
    public final AnonymousClass027 A00;

    public C005902n() {
        C006002o c006002o;
        synchronized (C006002o.class) {
            c006002o = C006002o.A02;
            if (c006002o == null) {
                c006002o = new C006002o();
                C006002o.A02 = c006002o;
            }
        }
        this.A00 = new AnonymousClass027(c006002o);
    }

    @Override // X.C01T
    public final void A5X(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.A00.A5X(x509CertificateArr, str);
    }

    @Override // X.AnonymousClass025
    public final void A5Y(X509Certificate[] x509CertificateArr, String str, boolean z) throws CertificateException {
        this.A00.A5Y(x509CertificateArr, str, z);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        this.A00.checkServerTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return this.A00.getAcceptedIssuers();
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        AnonymousClass027 anonymousClass027 = this.A00;
        ((X509ExtendedTrustManager) anonymousClass027.A03).checkServerTrusted(x509CertificateArr, str, socket);
        anonymousClass027.A02(x509CertificateArr);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        AnonymousClass027 anonymousClass027 = this.A00;
        ((X509ExtendedTrustManager) anonymousClass027.A03).checkServerTrusted(x509CertificateArr, str, sSLEngine);
        anonymousClass027.A02(x509CertificateArr);
    }
}
