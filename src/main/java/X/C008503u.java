package X;

import com.facebook.common.stringformat.StringFormatUtil;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* renamed from: X.03u, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C008503u {
    public X509Certificate A00;
    public final byte[] A01;

    public final String toString() throws CertificateException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SigningCertificateNode{certificate=");
            X509Certificate x509Certificate = this.A00;
            if (x509Certificate == null) {
                Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.A01));
                C06E.A08(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                x509Certificate = (X509Certificate) certificateGenerateCertificate;
                this.A00 = x509Certificate;
            }
            sb.append(x509Certificate);
            sb.append(", issuer=");
            sb.append(StringFormatUtil.NULL_STRING);
            sb.append('}');
            return sb.toString();
        } catch (CertificateException unused) {
            return "SigningCertificateNode{certificate=parsing_error}";
        }
    }

    public C008503u(byte[] bArr) {
        this.A01 = bArr;
    }
}
