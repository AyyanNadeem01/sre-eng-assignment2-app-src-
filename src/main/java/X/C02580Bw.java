package X;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* renamed from: X.0Bw, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C02580Bw extends C0CI {
    @Override // X.C0CI
    public final C0CM A09() {
        return new C0CM(this) { // from class: X.0C0
            public final C02590Bx[] A00;

            {
                Context context = ((C0CI) this.A01).A01;
                StringBuilder sbA09 = AnonymousClass000.A09();
                sbA09.append("/data/local/tmp/exopackage/");
                sbA09.append(context.getPackageName());
                File fileA03 = AnonymousClass000.A03(AnonymousClass000.A07("/native-libs/", sbA09));
                ArrayList arrayListA0B = AnonymousClass000.A0B();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                int i = 0;
                for (String str : C0B5.A0B()) {
                    File fileA02 = AnonymousClass000.A02(fileA03, str);
                    if (fileA02.isDirectory()) {
                        linkedHashSet.add(str);
                        File fileA022 = AnonymousClass000.A02(fileA02, "metadata.txt");
                        if (fileA022.isFile()) {
                            FileReader fileReader = new FileReader(fileA022);
                            try {
                                BufferedReader bufferedReader = new BufferedReader(fileReader);
                                while (true) {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            bufferedReader.close();
                                            fileReader.close();
                                            break;
                                        }
                                        if (line.length() != 0) {
                                            int iIndexOf = line.indexOf(32);
                                            if (iIndexOf == -1) {
                                                StringBuilder sbA092 = AnonymousClass000.A09();
                                                sbA092.append("illegal line in exopackage metadata: [");
                                                sbA092.append(line);
                                                throw new RuntimeException(AnonymousClass000.A07("]", sbA092));
                                            }
                                            String strA06 = AnonymousClass000.A06(line.substring(i, iIndexOf), ".so", AnonymousClass000.A09());
                                            int size = arrayListA0B.size();
                                            while (true) {
                                                if (i < size) {
                                                    boolean zEquals = ((C02590Bx) arrayListA0B.get(i)).A01.equals(strA06);
                                                    i++;
                                                    if (zEquals) {
                                                        break;
                                                    }
                                                } else {
                                                    String strSubstring = line.substring(iIndexOf + 1);
                                                    arrayListA0B.add(new C02590Bx(AnonymousClass000.A02(fileA02, strSubstring), strA06, strSubstring.substring(strSubstring.indexOf(45), strSubstring.indexOf(".so"))));
                                                    break;
                                                }
                                            }
                                            i = 0;
                                        }
                                    } finally {
                                    }
                                }
                            } catch (Throwable th) {
                                try {
                                    fileReader.close();
                                    throw th;
                                } finally {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
                this.A00 = (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]);
                this.A00 = (C02590Bx[]) arrayListA0B.toArray(new C02590Bx[arrayListA0B.size()]);
            }

            @Override // X.C0CM
            public final void A01(File file) {
                byte[] bArr = new byte[32768];
                for (C02590Bx c02590Bx : this.A00) {
                    FileInputStream fileInputStream = new FileInputStream(c02590Bx.A00);
                    try {
                        C0CM.A00(c02590Bx, file, fileInputStream, bArr);
                        fileInputStream.close();
                    } finally {
                    }
                }
            }

            @Override // X.C0CM
            public final C0Bz[] A02() {
                return this.A00;
            }
        };
    }

    @Override // X.C0CJ, X.C0AD
    public final String A05() {
        return "ExoSoSource";
    }
}
