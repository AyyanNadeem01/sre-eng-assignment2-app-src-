package X;

import android.os.Build;
import javax.net.ssl.X509TrustManager;

/* renamed from: X.024, reason: invalid class name */
/* loaded from: classes.dex */
public class AnonymousClass024 {
    public final X509TrustManager[] A00;

    public AnonymousClass024(boolean z) {
        this.A00 = new X509TrustManager[]{new AnonymousClass027(null)};
    }

    public AnonymousClass024() {
        X509TrustManager anonymousClass026;
        X509TrustManager[] x509TrustManagerArr = new X509TrustManager[1];
        this.A00 = x509TrustManagerArr;
        if (Build.VERSION.SDK_INT >= 24) {
            anonymousClass026 = new C005902n();
        } else {
            anonymousClass026 = new AnonymousClass026();
        }
        x509TrustManagerArr[0] = anonymousClass026;
    }
}
