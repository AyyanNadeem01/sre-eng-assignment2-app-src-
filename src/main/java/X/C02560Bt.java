package X;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: X.0Bt */
/* loaded from: classes.dex */
public final class C02560Bt extends C0CM {
    public C02570Bu[] A00;
    public final C0CI A01;
    public final ZipFile A02;
    public final /* synthetic */ C02500Bl A03;

    public C02560Bt(C02500Bl c02500Bl, C0CI c0ci) {
        this.A03 = c02500Bl;
        this.A02 = new ZipFile(c02500Bl.A00);
        this.A01 = c0ci;
    }

    @Override // X.C0CM
    public final void A01(File file) throws IOException {
        C02570Bu[] c02570BuArrA03 = this.A00;
        if (c02570BuArrA03 == null) {
            c02570BuArrA03 = A03();
            this.A00 = c02570BuArrA03;
        }
        byte[] bArr = new byte[32768];
        for (C02570Bu c02570Bu : c02570BuArrA03) {
            InputStream inputStream = this.A02.getInputStream(c02570Bu.A01);
            try {
                C0CM.A00(c02570Bu, file, inputStream, bArr);
                inputStream.close();
            } finally {
            }
        }
    }

    @Override // X.C0CM
    public final C0Bz[] A02() {
        C02570Bu[] c02570BuArr = this.A00;
        if (c02570BuArr != null) {
            return c02570BuArr;
        }
        C02570Bu[] c02570BuArrA03 = A03();
        this.A00 = c02570BuArrA03;
        return c02570BuArrA03;
    }

    public final C02570Bu[] A03() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HashMap mapA0C = AnonymousClass000.A0C();
        Pattern patternCompile = Pattern.compile(this.A03.A01);
        String[] strArrA0B = C0B5.A0B();
        Enumeration<? extends ZipEntry> enumerationEntries = this.A02.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            Matcher matcher = patternCompile.matcher(zipEntryNextElement.getName());
            if (matcher.matches()) {
                int iGroupCount = matcher.groupCount();
                String strGroup = matcher.group(iGroupCount - 1);
                String strGroup2 = matcher.group(iGroupCount);
                int i = 0;
                while (true) {
                    if (i >= strArrA0B.length) {
                        break;
                    }
                    String str = strArrA0B[i];
                    if (str == null || !strGroup.equals(str)) {
                        i++;
                    } else if (i >= 0) {
                        linkedHashSet.add(strGroup);
                        C02570Bu c02570Bu = (C02570Bu) mapA0C.get(strGroup2);
                        if (c02570Bu == null || i < c02570Bu.A00) {
                            mapA0C.put(strGroup2, new C02570Bu(strGroup2, zipEntryNextElement, i));
                        }
                    }
                }
            }
        }
        this.A01.A00 = (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]);
        C02570Bu[] c02570BuArr = (C02570Bu[]) mapA0C.values().toArray(new C02570Bu[mapA0C.size()]);
        Arrays.sort(c02570BuArr);
        return c02570BuArr;
    }

    @Override // X.C0CM, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A02.close();
    }
}
