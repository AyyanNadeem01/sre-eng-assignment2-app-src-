package X;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: X.07d, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C016207d {
    public final Set A00;

    public static void A02(C016107c c016107c, List list) throws C016307e {
        String str;
        StringBuilder sbA0A;
        for (int i = 0; i < list.size(); i++) {
            String strA06 = (String) list.get(i);
            if (strA06 == null || strA06.length() == 0) {
                str = "Empty component name.";
                StringBuilder sbA09 = AnonymousClass000.A09();
                sbA09.append("Failed to parse AndroidManifest.xml in ");
                sbA09.append(c016107c.A01);
                throw new C016307e(AnonymousClass000.A06(": ", str, sbA09));
            }
            String str2 = c016107c.A02;
            if (str2 == null || str2.length() == 0) {
                str = "Package name is empty.";
                StringBuilder sbA092 = AnonymousClass000.A09();
                sbA092.append("Failed to parse AndroidManifest.xml in ");
                sbA092.append(c016107c.A01);
                throw new C016307e(AnonymousClass000.A06(": ", str, sbA092));
            }
            int iIndexOf = strA06.indexOf(46);
            if (iIndexOf == 0) {
                sbA0A = AnonymousClass000.A09();
            } else if (iIndexOf < 0) {
                sbA0A = AnonymousClass000.A0A(str2);
                str2 = ".";
            } else {
                list.set(i, strA06);
            }
            strA06 = AnonymousClass000.A06(str2, strA06, sbA0A);
            list.set(i, strA06);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x034c  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.jar.JarFile, java.util.zip.ZipFile] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final X.C015907a A03(java.io.File r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 848
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C016207d.A03(java.io.File):X.07a");
    }

    public static String A00(C016107c c016107c, int i) {
        String str = (String) c016107c.A09.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        throw AnonymousClass000.A04(AnonymousClass000.A08("String not found: ", AnonymousClass000.A09(), i));
    }

    public C016207d() {
        HashSet hashSet = new HashSet();
        hashSet.add("activity");
        hashSet.add("activity-alias");
        hashSet.add("receiver");
        hashSet.add("service");
        hashSet.add("provider");
        this.A00 = Collections.unmodifiableSet(hashSet);
    }

    public static HashMap A01(C07Z c07z, C016107c c016107c, int i) throws IOException {
        String strA00;
        HashMap mapA0C = AnonymousClass000.A0C();
        for (int i2 = 0; i2 < i; i2++) {
            int iA02 = c07z.A02();
            int iA022 = c07z.A02();
            int iA023 = c07z.A02();
            int i3 = c07z.A00;
            short sA03 = c07z.A03();
            c07z.A01();
            c07z.A01();
            int iA024 = c07z.A02();
            int i4 = sA03 - (c07z.A00 - i3);
            if (i4 > 0) {
                c07z.A04(i4);
            }
            if (iA02 >= 0) {
                A00(c016107c, iA02);
            }
            String strA002 = A00(c016107c, iA022);
            if (iA023 < 0) {
                strA00 = Integer.toString(iA024);
                if (strA00 != null) {
                }
            } else {
                strA00 = A00(c016107c, iA023);
            }
            mapA0C.put(strA002, strA00);
        }
        return mapA0C;
    }
}
