package X;

import android.content.res.AssetManager;
import android.util.Base64;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: X.026, reason: invalid class name */
/* loaded from: classes.dex */
public class AnonymousClass026 implements X509TrustManager {
    public AnonymousClass028 A00;
    public C006002o A01;
    public final Set A02;
    public final X509TrustManager A03;
    public final long A04;

    public static X509TrustManager A00() throws NoSuchAlgorithmException, KeyStoreException, CertificateException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new CertificateException("Unable to create system TrustManger");
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            throw new IllegalStateException("Failure initializing TrustManager", e);
        }
    }

    public final void A01(List list) throws CertificateException {
        if (this.A00.A7e() <= this.A04) {
            if (list.isEmpty()) {
                throw new CertificateException("pinning error: certificate chain empty");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    if (this.A02.contains(ByteBuffer.wrap(MessageDigest.getInstance("SHA-256").digest(((Certificate) it.next()).getPublicKey().getEncoded())))) {
                        return;
                    }
                } catch (NoSuchAlgorithmException e) {
                    throw new CertificateException(e);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("pinning error, trusted chain: ");
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                sb.append(Base64.encodeToString(((Certificate) it2.next()).getEncoded(), 0));
                sb.append("\n");
            }
            throw new CertificateException(sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A02(java.security.cert.X509Certificate[] r10) throws java.security.NoSuchAlgorithmException, java.security.SignatureException, java.security.InvalidKeyException, java.security.cert.CertificateException, java.security.NoSuchProviderException {
        /*
            r9 = this;
            X.02o r1 = r9.A01
            if (r1 == 0) goto Lb2
            java.util.LinkedList r4 = new java.util.LinkedList
            r4.<init>()
            r0 = 0
            r2 = r10[r0]
            java.util.HashMap r5 = r1.A01
            javax.security.auth.x500.X500Principal r0 = r2.getSubjectX500Principal()
            java.lang.Object r0 = r5.get(r0)
            java.security.cert.Certificate r0 = (java.security.cert.Certificate) r0
            if (r0 == 0) goto L29
            java.security.PublicKey r1 = r0.getPublicKey()
            java.security.PublicKey r0 = r2.getPublicKey()
            boolean r0 = r1.equals(r0)
            r8 = 1
            if (r0 != 0) goto L2a
        L29:
            r8 = 0
        L2a:
            r4.add(r2)
            r7 = 1
            r6 = 1
        L2f:
            int r0 = r10.length
            if (r6 >= r0) goto L6e
            r3 = r10[r6]
            int r0 = r6 + (-1)
            r2 = r10[r0]
            javax.security.auth.x500.X500Principal r0 = r3.getSubjectX500Principal()
            java.lang.Object r0 = r5.get(r0)
            java.security.cert.Certificate r0 = (java.security.cert.Certificate) r0
            if (r0 == 0) goto L53
            java.security.PublicKey r1 = r0.getPublicKey()
            java.security.PublicKey r0 = r3.getPublicKey()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L53
            r8 = 1
        L53:
            javax.security.auth.x500.X500Principal r1 = r3.getSubjectX500Principal()
            javax.security.auth.x500.X500Principal r0 = r2.getIssuerX500Principal()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6e
            java.security.PublicKey r0 = r3.getPublicKey()     // Catch: java.security.GeneralSecurityException -> L6e
            r2.verify(r0)     // Catch: java.security.GeneralSecurityException -> L6e
            r4.add(r3)
            int r6 = r6 + 1
            goto L2f
        L6e:
            int r6 = r6 - r7
            r3 = r10[r6]
            javax.security.auth.x500.X500Principal r0 = r3.getIssuerX500Principal()
            java.lang.Object r2 = r5.get(r0)
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2
            if (r2 == 0) goto L93
            javax.security.auth.x500.X500Principal r1 = r2.getSubjectX500Principal()
            javax.security.auth.x500.X500Principal r0 = r3.getSubjectX500Principal()
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L93
            java.security.PublicKey r0 = r2.getPublicKey()     // Catch: java.security.GeneralSecurityException -> L93
            r3.verify(r0)     // Catch: java.security.GeneralSecurityException -> L93
            goto L9d
        L93:
            if (r8 != 0) goto La0
            java.lang.String r1 = "Didn't find a trust anchor in chain cleanup!"
            java.security.cert.CertificateException r0 = new java.security.cert.CertificateException
            r0.<init>(r1)
            throw r0
        L9d:
            r4.add(r2)
        La0:
            int r0 = r4.size()
            java.security.cert.X509Certificate[] r0 = new java.security.cert.X509Certificate[r0]
            java.lang.Object[] r0 = r4.toArray(r0)
            java.util.List r0 = java.util.Arrays.asList(r0)
            r9.A01(r0)
            return
        Lb2:
            java.lang.String r1 = "SystemKeystore is not intialized."
            java.security.cert.CertificateException r0 = new java.security.cert.CertificateException
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X.AnonymousClass026.A02(java.security.cert.X509Certificate[]):void");
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        this.A03.checkServerTrusted(x509CertificateArr, str);
        A02(x509CertificateArr);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return this.A03.getAcceptedIssuers();
    }

    public AnonymousClass026(AnonymousClass028 anonymousClass028, C006002o c006002o) throws IllegalAccessException, NoSuchAlgorithmException, KeyStoreException, CertificateException, IllegalArgumentException, InvocationTargetException {
        X509TrustManager x509TrustManagerA00;
        this.A02 = new HashSet();
        this.A00 = anonymousClass028;
        this.A01 = c006002o;
        try {
            try {
                x509TrustManagerA00 = A00();
            } catch (NullPointerException unused) {
                AssetManager.class.getMethod("getSystem", null).invoke(null, null);
                x509TrustManagerA00 = A00();
            }
            this.A03 = x509TrustManagerA00;
            this.A04 = 1792090855000L;
            String[] strArr = C02A.A00;
            int i = 0;
            do {
                this.A02.add(ByteBuffer.wrap(Base64.decode(strArr[i], 0)));
                i++;
            } while (i < 18);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException("Failure reinitializing TrustManager", e);
        }
    }

    public AnonymousClass026() {
        C006002o c006002o;
        AnonymousClass029 anonymousClass029 = new AnonymousClass029();
        synchronized (C006002o.class) {
            c006002o = C006002o.A02;
            if (c006002o == null) {
                c006002o = new C006002o();
                C006002o.A02 = c006002o;
            }
        }
        this(anonymousClass029, c006002o);
    }
}
