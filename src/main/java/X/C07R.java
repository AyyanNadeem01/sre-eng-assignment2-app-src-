package X;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: X.07R, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C07R implements C02N {
    public static String A00(Uri uri, C017607r c017607r) {
        String strGroup;
        if (!TextUtils.isEmpty(uri.getPath())) {
            if (uri.getPath().equals("/")) {
                return "/";
            }
            if (c017607r != null && c017607r.A02) {
                List list = c017607r.A01;
                if (!Collections.unmodifiableList(list).isEmpty()) {
                    String path = uri.getPath();
                    if (!TextUtils.isEmpty(path)) {
                        for (List list2 : Collections.unmodifiableList(list)) {
                            String scheme = uri.getScheme();
                            String authority = uri.getAuthority();
                            if (scheme != null && authority != null) {
                                Matcher matcher = ((Pattern) list2.get(2)).matcher(path);
                                if (matcher.matches() && ((Pattern) list2.get(0)).matcher(scheme).matches()) {
                                    if (((Pattern) list2.get(1)).matcher(authority).matches()) {
                                        StringBuilder sbA09 = AnonymousClass000.A09();
                                        int iGroupCount = matcher.groupCount();
                                        if (iGroupCount <= 0) {
                                            strGroup = matcher.group(0);
                                        } else {
                                            for (int i = 1; i < iGroupCount; i++) {
                                                sbA09.append(matcher.group(i));
                                                sbA09.append(';');
                                            }
                                            strGroup = matcher.group(iGroupCount);
                                        }
                                        return AnonymousClass000.A07(strGroup, sbA09);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return "/--sanitized--";
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(android.net.Uri r13, X.C017607r r14) {
        /*
            java.lang.String r0 = r13.getQuery()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r0 == 0) goto Lc
            return r2
        Lc:
            java.util.Set r1 = r13.getQueryParameterNames()     // Catch: java.lang.UnsupportedOperationException -> L11
            goto L12
        L11:
            r1 = r2
        L12:
            if (r1 == 0) goto Lc9
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto Lc9
            java.lang.StringBuilder r6 = X.AnonymousClass000.A09()
            r5 = 0
            r4 = 1
            if (r14 == 0) goto L33
            boolean r0 = r14.A03
            if (r0 == 0) goto L33
            java.util.List r0 = r14.A00
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            boolean r0 = r0.isEmpty()
            r12 = 1
            if (r0 == 0) goto L34
        L33:
            r12 = 0
        L34:
            if (r14 == 0) goto Lbe
            java.util.List r0 = r14.A00
            java.util.List r7 = java.util.Collections.unmodifiableList(r0)
        L3c:
            java.util.Iterator r11 = r1.iterator()
        L40:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto Lc4
            java.lang.Object r10 = r11.next()
            java.lang.String r10 = (java.lang.String) r10
            int r0 = r6.length()
            if (r0 <= 0) goto L57
            r0 = 38
            r6.append(r0)
        L57:
            r6.append(r10)
            java.lang.String r9 = "=--sanitized--"
            if (r12 == 0) goto Lba
            r8 = 0
        L5f:
            int r0 = r7.size()
            if (r8 >= r0) goto Lba
            java.lang.Object r2 = r7.get(r8)
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r0 = r2.get(r5)
            java.util.regex.Pattern r0 = (java.util.regex.Pattern) r0
            java.util.regex.Matcher r0 = r0.matcher(r10)
            boolean r0 = r0.matches()
            if (r0 == 0) goto Lb3
            java.lang.String r1 = r13.getQueryParameter(r10)
            if (r1 == 0) goto Lb3
            java.lang.Object r0 = r2.get(r4)
            java.util.regex.Pattern r0 = (java.util.regex.Pattern) r0
            java.util.regex.Matcher r3 = r0.matcher(r1)
            boolean r0 = r3.matches()
            if (r0 == 0) goto Lb3
            r0 = 61
            r6.append(r0)
            int r2 = r3.groupCount()
            if (r2 <= 0) goto Lae
            r1 = 1
        L9d:
            if (r1 >= r2) goto Lb6
            java.lang.String r0 = r3.group(r1)
            r6.append(r0)
            r0 = 59
            r6.append(r0)
            int r1 = r1 + 1
            goto L9d
        Lae:
            java.lang.String r9 = r3.group(r5)
            goto Lba
        Lb3:
            int r8 = r8 + 1
            goto L5f
        Lb6:
            java.lang.String r9 = r3.group(r2)
        Lba:
            r6.append(r9)
            goto L40
        Lbe:
            java.util.List r7 = java.util.Collections.emptyList()
            goto L3c
        Lc4:
            java.lang.String r0 = r6.toString()
            return r0
        Lc9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C07R.A01(android.net.Uri, X.07r):java.lang.String");
    }
}
