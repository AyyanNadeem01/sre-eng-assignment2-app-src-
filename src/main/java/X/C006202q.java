package X;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: X.02q, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C006202q {
    public final ApplicationInfo A00;
    public final PackageInfo A01;
    public final String A02;
    public final String A03;

    public C006202q(PackageInfo packageInfo) {
        C06E.A07(packageInfo, 1);
        this.A01 = packageInfo;
        String str = packageInfo.packageName;
        this.A02 = str == null ? "" : str;
        String str2 = packageInfo.versionName;
        this.A03 = str2 == null ? "" : str2;
        this.A00 = packageInfo.applicationInfo;
    }

    public final long A00() {
        return Build.VERSION.SDK_INT >= 28 ? this.A01.getLongVersionCode() : r0.versionCode;
    }

    public final C010504o A01() {
        SigningInfo signingInfo;
        if (Build.VERSION.SDK_INT < 28 || (signingInfo = this.A01.signingInfo) == null) {
            Signature[] signatureArr = this.A01.signatures;
            if (signatureArr == null) {
                return null;
            }
            List listAsList = Arrays.asList(signatureArr);
            C06E.A03(listAsList);
            ArrayList arrayListA0K = C01W.A0K(listAsList);
            if (arrayListA0K.isEmpty()) {
                return null;
            }
            return new C010504o(arrayListA0K, arrayListA0K.size() > 1, false);
        }
        boolean zHasMultipleSigners = signingInfo.hasMultipleSigners();
        boolean zHasPastSigningCertificates = signingInfo.hasPastSigningCertificates();
        Signature[] apkContentsSigners = zHasMultipleSigners ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
        if (apkContentsSigners == null) {
            return null;
        }
        List listAsList2 = Arrays.asList(apkContentsSigners);
        C06E.A03(listAsList2);
        ArrayList arrayListA0K2 = C01W.A0K(listAsList2);
        if (arrayListA0K2.isEmpty()) {
            return null;
        }
        return new C010504o(arrayListA0K2, zHasMultipleSigners, zHasPastSigningCertificates);
    }
}
