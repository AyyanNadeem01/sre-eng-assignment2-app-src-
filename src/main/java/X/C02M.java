package X;

import android.net.Uri;
import android.util.LruCache;
import java.net.URI;

/* renamed from: X.02M, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C02M {
    public static volatile boolean A02;
    public static final C02N A01 = new C02O();
    public static final LruCache A00 = new LruCache(20);

    public static Uri A00(AnonymousClass007 anonymousClass007, String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("Url string is null");
        }
        if (anonymousClass007 == null) {
            throw new IllegalArgumentException("reporter is null");
        }
        try {
            return A01(null, str);
        } catch (SecurityException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Parse uri <sanitized \"");
            sb.append(A01.Ajs(str));
            sb.append("\"> failed. Fail open: ");
            sb.append(z);
            anonymousClass007.Ais("UriParser", sb.toString(), e);
            if (z) {
                return Uri.parse(str);
            }
            return null;
        }
    }

    public static boolean A04(String str, String str2) {
        return (str == null || str.equals("")) ? str2 == null || str2.equals("") : str.equals(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00aa, code lost:
    
        if (r1.contains("_") != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040 A[PHI: r4
  0x0040: PHI (r4v4 boolean) = (r4v0 boolean), (r4v6 boolean) binds: [B:12:0x002a, B:14:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri A01(X.C02N r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C02M.A01(X.02N, java.lang.String):android.net.Uri");
    }

    public static void A02(Uri uri, C02N c02n, String str, URI uri2) {
        boolean zA04 = A04(uri2.getScheme(), uri.getScheme());
        boolean zA042 = A04(uri2.getSchemeSpecificPart(), uri.getSchemeSpecificPart());
        if (zA04 && zA042) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("java uri <sanitized \"");
        String string = uri2.toString();
        C02N c02n2 = c02n;
        if (c02n == null) {
            c02n2 = A01;
        }
        sb.append(c02n2.Ajs(string));
        sb.append("\"> not equal to android uri <sanitized \"");
        String string2 = uri.toString();
        C02N c02n3 = c02n;
        if (c02n == null) {
            c02n3 = A01;
        }
        sb.append(c02n3.Ajs(string2));
        sb.append("\"> from original <sanitized \"");
        if (c02n == null) {
            c02n = A01;
        }
        sb.append(c02n.Ajs(str));
        sb.append("\">");
        throw new SecurityException(sb.toString());
    }

    public static void A03(Uri uri, C02N c02n, URI uri2, boolean z) {
        boolean zA04 = A04(uri2.getScheme(), uri.getScheme());
        boolean zA042 = A04(uri2.getAuthority(), uri.getAuthority());
        boolean zA043 = A04(uri2.getPath(), uri.getPath());
        if (zA04 && zA042 && zA043) {
            return;
        }
        String string = "";
        if (!zA04) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append("javaUri scheme: \"");
            sb.append(uri2.getScheme());
            sb.append("\". androidUri scheme: \"");
            sb.append(uri.getScheme());
            sb.append("\".");
            string = sb.toString();
        }
        if (!z && !zA042) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append("javaUri authority: \"");
            sb2.append(uri2.getAuthority());
            sb2.append("\". androidUri authority: \"");
            sb2.append(uri.getAuthority());
            sb2.append("\".");
            string = sb2.toString();
        }
        if (!zA043) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string);
            sb3.append("javaUri path: \"");
            sb3.append(uri2.getPath());
            sb3.append("\". androidUri path: \"");
            sb3.append(uri.getPath());
            sb3.append("\".");
            string = sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("java uri <sanitized \"");
        String string2 = uri2.toString();
        C02N c02n2 = c02n;
        if (c02n == null) {
            c02n2 = A01;
        }
        sb4.append(c02n2.Ajs(string2));
        sb4.append("\"> not equal to android uri <sanitized \"");
        String string3 = uri.toString();
        if (c02n == null) {
            c02n = A01;
        }
        sb4.append(c02n.Ajs(string3));
        sb4.append("\">. Debug info ");
        sb4.append(string);
        sb4.append(".");
        throw new SecurityException(sb4.toString());
    }
}
