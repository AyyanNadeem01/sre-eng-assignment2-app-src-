package X;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: X.04Q */
/* loaded from: classes.dex */
public final class C04Q {
    public static String A05;
    public final C0CK A00;
    public final File A01;
    public final List A02;
    public final Set A03;
    public final C011104v A04;
    public static final File[] A07 = new File[0];
    public static final Object A06 = new Object();

    public static final void A00(File file, String str) {
        synchronized (A06) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("_done");
                new File(file, sb.toString()).createNewFile();
            } catch (IOException unused) {
                C0C5.A00();
            }
        }
    }

    public static final boolean A01(File file, String str) {
        boolean zExists;
        synchronized (A06) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_done");
            zExists = new File(file, sb.toString()).exists();
        }
        return zExists;
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x00ad A[Catch: all -> 0x0101, Merged into TryCatch #2 {all -> 0x0104, blocks: (B:155:0x0005, B:156:0x0007, B:204:0x0103, B:157:0x0008, B:176:0x0084, B:178:0x0097, B:179:0x009e, B:181:0x00a3, B:183:0x00ad, B:184:0x00bb, B:185:0x00c0, B:187:0x00cc, B:191:0x00d8, B:194:0x00f5, B:193:0x00dd, B:200:0x00fd, B:201:0x0100, B:158:0x000d, B:159:0x0023, B:161:0x0029, B:172:0x007b, B:174:0x0080, B:175:0x0083, B:198:0x00fb), top: B:211:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A02(X.C05C r11, java.io.File r12, java.lang.String r13, java.util.List r14) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C04Q.A02(X.05C, java.io.File, java.lang.String, java.util.List):void");
    }

    public C04Q(C011104v c011104v, C0CK c0ck) {
        this.A00 = c0ck;
        this.A04 = c011104v;
        File file = new File(c0ck.A05, "reports");
        this.A01 = file;
        file.mkdirs();
        this.A02 = new ArrayList();
        this.A03 = Collections.newSetFromMap(new ConcurrentHashMap());
    }
}
