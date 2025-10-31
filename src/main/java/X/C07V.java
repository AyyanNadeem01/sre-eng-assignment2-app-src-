package X;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: X.07V, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C07V {
    public static String A02(int i) {
        if (i == 1) {
            return "Activity";
        }
        if (i == 2) {
            return "Receiver";
        }
        if (i == 4) {
            return "Service";
        }
        if (i == 8) {
            return "Provider";
        }
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("Unknown (type = ");
        sbA09.append(i);
        return AnonymousClass000.A07(")", sbA09);
    }

    public static void A03(Context context) throws Throwable {
        PackageManager packageManager = context.getPackageManager();
        context.getPackageName();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Integer[] numArr = new Integer[4];
        numArr[0] = 1;
        AnonymousClass000.A0N(numArr, 2, 1);
        AnonymousClass000.A0N(numArr, 8, 2);
        AnonymousClass000.A0N(numArr, 4, 3);
        int iA00 = A00(context, packageManager, numArr, 4);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (iA00 < 0) {
            throw new RuntimeException(String.format("Failed to set enable stage %d for pkg[%s], can't resume. Duration[%s]", 3, context.getPackageName(), Long.valueOf(jCurrentTimeMillis2 / 1000)));
        }
        File fileA01 = C0AP.A01(context, 1436876361);
        fileA01.mkdirs();
        File[] fileArrListFiles = AnonymousClass000.A02(fileA01, "versions").listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
        int iA002 = AbstractC017707t.A00();
        File fileA012 = C0AP.A01(context, 1436876361);
        fileA012.mkdirs();
        File fileA02 = AnonymousClass000.A02(AnonymousClass000.A02(fileA012, "versions"), Integer.toString(AbstractC017707t.A00()));
        fileA02.getParentFile().mkdirs();
        try {
            new FileOutputStream(fileA02, false).close();
            if (iA002 == 1) {
                try {
                    fileA02.setLastModified(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime);
                } catch (PackageManager.NameNotFoundException unused) {
                    throw AnonymousClass000.A04("Can't get package info for this package.");
                }
            }
            context.getPackageName();
            context.getPackageName();
        } catch (IOException e) {
            throw new RuntimeException(AnonymousClass000.A05(fileA02, "Failed to touch file: ", AnonymousClass000.A09()), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c7 A[Catch: RuntimeException -> 0x0189, TryCatch #2 {RuntimeException -> 0x0189, blocks: (B:6:0x0016, B:7:0x0026, B:15:0x0036, B:42:0x00c3, B:44:0x00c7, B:46:0x00cd, B:47:0x00da, B:48:0x00dd, B:65:0x013c, B:68:0x0145, B:71:0x014c, B:74:0x0155, B:49:0x00ec, B:51:0x00fd, B:52:0x0112, B:77:0x015e, B:53:0x0119, B:55:0x011d, B:57:0x0127, B:59:0x012d, B:61:0x0131, B:78:0x0162, B:41:0x00b1, B:16:0x0039, B:17:0x003c, B:18:0x003f, B:22:0x0045, B:23:0x0061, B:31:0x0071, B:37:0x008c, B:38:0x0093, B:40:0x0099, B:32:0x0074, B:33:0x0083, B:36:0x008a, B:34:0x0084, B:35:0x0087, B:80:0x0177, B:81:0x0188), top: B:98:0x0016, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(android.content.Context r18, android.content.pm.PackageManager r19, java.lang.Integer[] r20, int r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C07V.A00(android.content.Context, android.content.pm.PackageManager, java.lang.Integer[], int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.pm.ComponentInfo A01(android.content.ComponentName r8, android.content.pm.PackageManager r9, int r10, boolean r11) {
        /*
            r1 = 33280(0x8200, float:4.6635E-41)
            if (r11 == 0) goto L8
            r1 = 33408(0x8280, float:4.6815E-41)
        L8:
            r2 = 4
            r7 = 2
            r6 = 1
            r5 = 0
            if (r10 == r6) goto L26
            if (r10 == r7) goto L21
            if (r10 == r2) goto L1c
            r0 = 8
            if (r10 != r0) goto L1b
            android.content.pm.ProviderInfo r5 = r9.getProviderInfo(r8, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2b
            return r5
        L1b:
            return r5
        L1c:
            android.content.pm.ServiceInfo r5 = r9.getServiceInfo(r8, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2b
            return r5
        L21:
            android.content.pm.ActivityInfo r5 = r9.getReceiverInfo(r8, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2b
            return r5
        L26:
            android.content.pm.ActivityInfo r5 = r9.getActivityInfo(r8, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2b
            return r5
        L2b:
            r4 = 0
            if (r11 == 0) goto L35
            android.content.pm.ComponentInfo r0 = A01(r8, r9, r10, r4)     // Catch: java.lang.Exception -> L35
            r1 = 1
            if (r0 != 0) goto L36
        L35:
            r1 = 0
        L36:
            java.lang.String r3 = "AppComponentManager"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r0 = r8.getClassName()
            r2[r4] = r0
            java.lang.String r0 = A02(r10)
            r2[r6] = r0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            r2[r7] = r0
            if (r11 == 0) goto L5b
            if (r1 == 0) goto L5b
            java.lang.String r1 = ", BUT succeeded without asking for metadata."
        L52:
            r0 = 3
            r2[r0] = r1
            java.lang.String r0 = "getComponentInfo couldn't find component name[%s] type[%s] getMetaData[%s]%s"
            X.C018108b.A0J(r3, r0, r2)
            return r5
        L5b:
            java.lang.String r1 = "."
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C07V.A01(android.content.ComponentName, android.content.pm.PackageManager, int, boolean):android.content.pm.ComponentInfo");
    }
}
