package X;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* renamed from: X.04M */
/* loaded from: classes.dex */
public abstract class C04M {
    public static C006202q A00(Context context, String str) {
        try {
            C006202q c006202qA01 = AnonymousClass009.A01(context, str, 64);
            String str2 = c006202qA01.A02;
            if (str.equals(str2)) {
                return c006202qA01;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Package name mismatch: expected=");
            sb.append(str);
            sb.append(", was=");
            sb.append(str2);
            throw new AnonymousClass075(sb.toString());
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" not found by PackageManager.");
            throw new C012605o(sb2.toString(), e);
        } catch (RuntimeException e2) {
            throw new SecurityException(e2);
        }
    }

    public static boolean A04(Context context, ApplicationInfo applicationInfo, ApplicationInfo applicationInfo2) {
        int i = applicationInfo.uid;
        int i2 = applicationInfo2.uid;
        if (!(i == i2)) {
            try {
                if (context.getPackageManager().checkSignatures(i, i2) != 0) {
                    return false;
                }
            } catch (RuntimeException e) {
                throw new SecurityException(e);
            }
        }
        return true;
    }

    public static C000800l A01(Context context, String str) throws NoSuchAlgorithmException {
        byte[] byteArray = ((Signature) A02(A00(context, str)).get(0)).toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(byteArray);
            return new C000800l(Base64.encodeToString(messageDigest.digest(), 11));
        } catch (NoSuchAlgorithmException unused) {
            throw new SecurityException("Error obtaining SHA1/SHA256");
        }
    }

    public static List A02(C006202q c006202q) {
        C010504o c010504oA01 = c006202q.A01();
        if (c010504oA01 == null) {
            throw new C0AO(c006202q.A02);
        }
        if (Build.VERSION.SDK_INT >= 28 || c010504oA01.A00.size() <= 1) {
            return c010504oA01.A00;
        }
        throw new C07M(c006202q.A02);
    }

    public static boolean A03(Context context) {
        return AbstractC011805d.A0e.contains(A01(context, context.getPackageName()));
    }

    public static boolean A05(Context context, String str) {
        ApplicationInfo applicationInfo = A00(context, context.getPackageName()).A00;
        if (applicationInfo == null) {
            throw new C019208n(context.getPackageName());
        }
        ApplicationInfo applicationInfo2 = A00(context, str).A00;
        if (applicationInfo2 != null) {
            return A04(context, applicationInfo, applicationInfo2);
        }
        throw new C019208n(str);
    }
}
