package X;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.util.Base64;
import com.facebook.common.stringformat.StringFormatUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: X.03w */
/* loaded from: classes.dex */
public final class C008703w {
    public final int A00;
    public final String A01;
    public final String A02;
    public final List A03;
    public final List A04;
    public final List A05;
    public final int A06;

    public static C008703w A00(Context context, int i) {
        try {
            return A04(AnonymousClass009.A01(context, AnonymousClass009.A03(context, i)[0], 64), new HashSet(), true);
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to get packageInfo for uid ");
            sb.append(i);
            throw new C012605o(sb.toString(), e);
        }
    }

    public static C008703w A02(Context context, String str) {
        ProviderInfo providerInfoA00 = AnonymousClass009.A00(context, str, 0);
        if (providerInfoA00 != null) {
            return A03(context, ((PackageItemInfo) providerInfoA00).packageName, true);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to get providerInfo for authority ");
        sb.append(str);
        throw new SecurityException(sb.toString());
    }

    public static C008703w A04(C006202q c006202q, Set set, boolean z) throws NoSuchAlgorithmException {
        C000800l c000800l;
        C010504o c010504oA01 = c006202q.A01();
        if (c010504oA01 == null) {
            throw new C0AO("Unable to construct AppIdentity -- signingInfo was null. Make sure you called getPackageInfo() with GET_SIGNATURES or GET_CERTIFICATES flag.");
        }
        List<Signature> list = c010504oA01.A00;
        if (list.isEmpty()) {
            throw new C0AO("Unable to construct AppIdentity -- packageInfo does not have any signatures. Make sure you called getPackageInfo() with GET_SIGNATURES or GET_CERTIFICATES flag.");
        }
        ApplicationInfo applicationInfo = c006202q.A00;
        if (applicationInfo == null) {
            throw new SecurityException("Unable to construct AppIdentity -- package applicationInfo is null");
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        for (Signature signature : list) {
            byte[] byteArray = signature.toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(byteArray);
                String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 11);
                if (z) {
                    MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-1");
                    messageDigest2.update(byteArray);
                    String strEncodeToString2 = Base64.encodeToString(messageDigest2.digest(), 11);
                    c000800l = new C000800l();
                    c000800l.A00 = strEncodeToString2;
                    if (strEncodeToString.length() != 43) {
                        throw new SecurityException("Invalid SHA256 key hash - should be 256-bit.");
                    }
                    c000800l.A01 = strEncodeToString;
                } else {
                    c000800l = new C000800l(strEncodeToString);
                }
                arrayList.add(c000800l);
                arrayList2.add(signature);
            } catch (NoSuchAlgorithmException unused) {
                throw new SecurityException("Error obtaining SHA1/SHA256");
            }
        }
        set.add(c006202q.A02);
        int i = applicationInfo.uid;
        return new C008703w(c006202q.A03, null, new ArrayList(set), arrayList, arrayList2, i, applicationInfo.flags);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C008703w c008703w = (C008703w) obj;
            if (this.A00 != c008703w.A00 || !this.A03.equals(c008703w.A03)) {
                return false;
            }
            List list = this.A05;
            List list2 = c008703w.A05;
            if (list != list2 && (list == null || !list.equals(list2))) {
                return false;
            }
            String str = this.A02;
            String str2 = c008703w.A02;
            if (str != str2 && (str == null || !str.equals(str2))) {
                return false;
            }
            String str3 = this.A01;
            String str4 = c008703w.A01;
            if (str3 != str4 && (str3 == null || !str3.equals(str4))) {
                return false;
            }
            List list3 = this.A04;
            List list4 = c008703w.A04;
            if ((list3 != list4 && !list3.equals(list4)) || this.A06 != c008703w.A06) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.A00), this.A03, this.A05, this.A02, this.A01, Integer.valueOf(this.A06), this.A04});
    }

    public static C008703w A03(Context context, String str, boolean z) {
        try {
            return A04(AnonymousClass009.A01(context, str, 64), new HashSet(), z);
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to get packageInfo for package ");
            sb.append(str);
            throw new C012605o(sb.toString(), e);
        }
    }

    public final C000800l A05() {
        List list = this.A05;
        if (list.isEmpty()) {
            return null;
        }
        return (C000800l) list.get(0);
    }

    public final String A06() {
        List list = this.A03;
        if (list.isEmpty()) {
            throw new IllegalStateException("Invalid AppIdentity object: no package names");
        }
        return (String) list.iterator().next();
    }

    public C008703w(String str, String str2, List list, List list2, List list3, int i, int i2) {
        this.A00 = i;
        this.A03 = Collections.unmodifiableList(list);
        this.A05 = list2;
        this.A02 = str;
        this.A01 = str2;
        this.A06 = i2;
        this.A04 = list3;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one package name is required");
        }
    }

    public static C008703w A01(Context context, int i) {
        try {
            String[] strArrA03 = AnonymousClass009.A03(context, i);
            C006202q c006202qA01 = AnonymousClass009.A01(context, strArrA03[0], 64);
            HashSet hashSet = new HashSet();
            hashSet.addAll(Arrays.asList(strArrA03));
            return A04(c006202qA01, hashSet, false);
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to get packageInfo for uid ");
            sb.append(i);
            throw new C012605o(sb.toString(), e);
        }
    }

    public final String toString() {
        C000800l c000800lA05 = A05();
        StringBuilder sb = new StringBuilder();
        sb.append("AppIdentity{uid=");
        sb.append(this.A00);
        sb.append(", packageNames=");
        sb.append(this.A03);
        sb.append(", sha2=");
        String str = StringFormatUtil.NULL_STRING;
        String string = StringFormatUtil.NULL_STRING;
        sb.append(c000800lA05 == null ? StringFormatUtil.NULL_STRING : c000800lA05.A01);
        sb.append(", version=");
        String str2 = this.A02;
        if (str2 == null) {
            str2 = StringFormatUtil.NULL_STRING;
        }
        sb.append(str2);
        sb.append(", domain=");
        String str3 = this.A01;
        if (str3 != null) {
            str = str3;
        }
        sb.append(str);
        sb.append(", flags=");
        sb.append(this.A06);
        sb.append(", rawCertificates=");
        List list = this.A04;
        if (!list.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            int i = 0;
            while (i < list.size()) {
                Signature signature = (Signature) list.get(i);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Certificate #");
                i++;
                sb3.append(i);
                sb3.append("\n");
                sb2.append(sb3.toString());
                sb2.append(Base64.encodeToString(signature.toByteArray(), 0));
            }
            string = sb2.toString();
        }
        sb.append(string);
        sb.append('}');
        return sb.toString();
    }
}
