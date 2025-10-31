package X;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

/* renamed from: X.02o, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C006002o {
    public static C006002o A02;
    public final KeyStore A00;
    public final HashMap A01;

    public C006002o() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            keyStore.load(null, null);
            try {
                HashMap map = new HashMap();
                Enumeration<String> enumerationAliases = keyStore.aliases();
                while (enumerationAliases.hasMoreElements()) {
                    X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(enumerationAliases.nextElement());
                    if (x509Certificate != null) {
                        map.put(x509Certificate.getSubjectX500Principal(), x509Certificate);
                    }
                }
                this.A01 = map;
                this.A00 = keyStore;
            } catch (KeyStoreException e) {
                throw new AssertionError(e);
            }
        } catch (FileNotFoundException e2) {
            throw new AssertionError(e2);
        } catch (IOException e3) {
            throw new AssertionError(e3);
        } catch (KeyStoreException e4) {
            throw new AssertionError(e4);
        } catch (NoSuchAlgorithmException e5) {
            throw new AssertionError(e5);
        } catch (CertificateException e6) {
            throw new AssertionError(e6);
        }
    }
}
