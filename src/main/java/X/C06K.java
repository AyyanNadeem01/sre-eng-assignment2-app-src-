package X;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* renamed from: X.06K, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C06K {
    public static void A00(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                C018108b.A0K("DexStore", "error closing %s", e, closeable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A01(java.io.File r6) throws java.io.IOException {
        /*
            java.io.File r1 = r6.getCanonicalFile()
            java.io.File r0 = r6.getAbsoluteFile()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L2b
            boolean r0 = r6.isDirectory()
            r5 = 0
            r4 = 1
            if (r0 == 0) goto L3b
            java.io.File[] r3 = r6.listFiles()
            if (r3 != 0) goto L2c
            java.lang.String r2 = "DexStore"
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r0 = r6.getCanonicalPath()
            r1[r5] = r0
            java.lang.String r0 = "Failed to list files in: %s"
        L28:
            X.C018108b.A0J(r2, r0, r1)
        L2b:
            return
        L2c:
            int r2 = r3.length
            r1 = 0
        L2e:
            if (r1 >= r2) goto L3b
            r0 = r3[r1]
            r0.getCanonicalPath()
            A01(r0)
            int r1 = r1 + 1
            goto L2e
        L3b:
            java.lang.String r2 = "DexStore"
            r6.getCanonicalPath()
            boolean r0 = r6.delete()
            if (r0 != 0) goto L2b
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r0 = r6.getCanonicalPath()
            r1[r5] = r0
            java.lang.String r0 = "Failed to delete: %s"
            goto L28
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C06K.A01(java.io.File):void");
    }

    public static void A02(File file, File file2) throws IOException {
        if (file.renameTo(file2)) {
            return;
        }
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("rename of ");
        sbA09.append(file);
        sbA09.append(" to ");
        sbA09.append(file2);
        throw new IOException(AnonymousClass000.A07(" failed", sbA09));
    }
}
