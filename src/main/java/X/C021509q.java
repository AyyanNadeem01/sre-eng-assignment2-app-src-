package X;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: X.09q */
/* loaded from: classes.dex */
public final class C021509q {
    public static final List A05 = new ArrayList(2);
    public final Context A00;
    public final File A01;
    public final Object A02 = new Object();
    public final Map A03 = AnonymousClass000.A0C();
    public final C021409p A04;

    /* JADX WARN: Removed duplicated region for block: B:53:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A00(java.io.File r5, java.io.FileFilter r6, java.util.List r7, java.util.Set r8, boolean r9) {
        /*
            java.lang.String r0 = "buildFiles"
            X.AbstractC017507q.A00(r0)
            java.io.File[] r5 = r5.listFiles(r6)     // Catch: java.lang.Throwable -> L47
            if (r5 == 0) goto L43
            int r4 = r5.length     // Catch: java.lang.Throwable -> L47
            r3 = 0
        Ld:
            if (r3 >= r4) goto L43
            r2 = r5[r3]     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = r2.getCanonicalPath()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L47
            boolean r0 = r2.isDirectory()     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L34
            boolean r0 = r8.contains(r1)     // Catch: java.lang.Throwable -> L47
            if (r0 != 0) goto L40
            r8.add(r1)     // Catch: java.lang.Throwable -> L47
            java.lang.String r0 = "reports"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Throwable -> L47
            if (r0 != 0) goto L2f
            r0 = 0
            if (r9 == 0) goto L30
        L2f:
            r0 = 1
        L30:
            A00(r2, r6, r7, r8, r0)     // Catch: java.lang.Throwable -> L47
            goto L40
        L34:
            X.03O r0 = new X.03O     // Catch: java.lang.Throwable -> L47
            r0.<init>(r2, r9)     // Catch: java.lang.Throwable -> L47
            r7.add(r0)     // Catch: java.lang.Throwable -> L47
            goto L40
        L3d:
            X.C0C5.A00()     // Catch: java.lang.Throwable -> L47
        L40:
            int r3 = r3 + 1
            goto Ld
        L43:
            android.os.Trace.endSection()
            return
        L47:
            r0 = move-exception
            android.os.Trace.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C021509q.A00(java.io.File, java.io.FileFilter, java.util.List, java.util.Set, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x00e4 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:127:0x00a6, B:129:0x00b8, B:131:0x00c0, B:133:0x00c5, B:135:0x00e2, B:138:0x00e8, B:137:0x00e4), top: B:152:0x00a6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A01(java.io.File r14) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C021509q.A01(java.io.File):void");
    }

    public C021509q(Context context, C021409p c021409p, File file) {
        this.A00 = context;
        this.A01 = file;
        this.A04 = c021409p;
    }
}
