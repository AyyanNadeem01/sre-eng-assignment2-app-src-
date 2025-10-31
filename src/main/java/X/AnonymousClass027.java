package X;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

/* renamed from: X.027, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass027 extends AnonymousClass026 implements AnonymousClass025 {
    public final X509TrustManagerExtensions A00;

    public AnonymousClass027(C006002o c006002o) {
        super(new AnonymousClass029(), c006002o);
        this.A00 = new X509TrustManagerExtensions(this.A03);
    }

    @Override // X.C01T
    public final void A5X(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        A01(this.A00.checkServerTrusted(x509CertificateArr, "ECDHE_ECDSA", str));
    }

    @Override // X.AnonymousClass025
    public final void A5Y(X509Certificate[] x509CertificateArr, String str, boolean z) throws CertificateException {
        List<X509Certificate> listCheckServerTrusted = this.A00.checkServerTrusted(x509CertificateArr, "ECDHE_ECDSA", str);
        if (z) {
            A01(listCheckServerTrusted);
        }
    }

    public AnonymousClass027() {
        this(null);
    }
}
