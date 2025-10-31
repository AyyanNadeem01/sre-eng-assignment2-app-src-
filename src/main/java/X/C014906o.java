package X;

import java.io.File;
import java.io.IOException;

/* renamed from: X.06o, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C014906o {
    public final AnonymousClass070 A00;
    public final C014806m A01;
    public final C02440Bf A02;
    public final String A03;
    public final String A04;

    public C014906o(AnonymousClass070 anonymousClass070, C02440Bf c02440Bf, File file) {
        C014806m c014806m = new C014806m(anonymousClass070, c02440Bf);
        this.A04 = file.getCanonicalPath();
        this.A03 = file.getParent();
        this.A00 = anonymousClass070;
        this.A02 = c02440Bf;
        this.A01 = c014806m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x020b, code lost:
    
        if (X.AnonymousClass000.A03(r5).renameTo(r1) != false) goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A02(java.lang.String r20) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 635
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C014906o.A02(java.lang.String):void");
    }

    public static File A00(C014906o c014906o) {
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append(c014906o.A04);
        return AnonymousClass000.A03(AnonymousClass000.A07("_compiled", sbA09));
    }

    public final String A01(boolean z) throws IOException {
        File fileA03;
        if (AnonymousClass070.A00() >= 26) {
            String str = this.A03;
            StringBuilder sbA09 = AnonymousClass000.A09();
            sbA09.append("oat/");
            fileA03 = new File(str, AnonymousClass000.A07(AnonymousClass070.A01(), sbA09));
        } else {
            fileA03 = AnonymousClass000.A03(this.A03);
        }
        if (z && !fileA03.mkdirs() && !fileA03.isDirectory()) {
            throw new IOException(AnonymousClass000.A05(fileA03, "cannot mkdir: ", AnonymousClass000.A09()));
        }
        StringBuilder sbA092 = AnonymousClass000.A09();
        sbA092.append(fileA03.getPath());
        return AnonymousClass000.A07("/", sbA092);
    }
}
