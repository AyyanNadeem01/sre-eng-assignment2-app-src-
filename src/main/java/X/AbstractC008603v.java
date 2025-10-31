package X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;

/* renamed from: X.03v, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC008603v {
    public static C008703w A00(BroadcastReceiver broadcastReceiver, Context context) {
        String sentFromPackage;
        if (Build.VERSION.SDK_INT < 34 || (sentFromPackage = broadcastReceiver.getSentFromPackage()) == null) {
            return null;
        }
        return C008703w.A03(context, sentFromPackage, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static X.C008703w A01(android.content.Context r6, android.content.Intent r7, X.AnonymousClass007 r8, int r9, long r10) throws java.security.NoSuchAlgorithmException {
        /*
            if (r7 == 0) goto L59
            X.03w r5 = X.AbstractC006102p.A00(r6, r7, r8, r9)
            if (r5 == 0) goto L51
            r0 = 32
            long r3 = r10 & r0
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto Lb0
            int r1 = android.os.Binder.getCallingPid()
            int r0 = android.os.Process.myPid()
            if (r1 == r0) goto Lb0
            int r0 = android.os.Binder.getCallingUid()
            int r2 = r5.A00
            if (r0 == r2) goto Lb0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = "Uid "
            r1.append(r0)
            r1.append(r2)
            java.lang.String r0 = " from PI not equal to uid "
            r1.append(r0)
            int r0 = android.os.Binder.getCallingUid()
            r1.append(r0)
            java.lang.String r0 = " from binder data"
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            if (r8 == 0) goto L51
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L51
            r8.Air(r1)
        L51:
            java.lang.String r0 = "CI_SKIP_CALLER_FROM_ACTIVITY"
            boolean r0 = r7.hasExtra(r0)
            if (r0 != 0) goto L80
        L59:
            boolean r0 = r6 instanceof android.app.Activity
            if (r0 == 0) goto L80
            r5 = r6
            android.app.Activity r5 = (android.app.Activity) r5
            int r2 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            if (r2 == r0) goto L80
            java.lang.String r1 = r5.getCallingPackage()
            if (r1 != 0) goto Lba
            r0 = 34
            if (r2 < r0) goto L80
            r0 = 64
            long r3 = r10 & r0
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L80
            java.lang.String r1 = r5.getLaunchedFromPackage()
            if (r1 != 0) goto Lba
        L80:
            r0 = 128(0x80, double:6.32E-322)
            long r10 = r10 & r0
            r1 = 0
            int r0 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r0 != 0) goto Lb1
            int r1 = android.os.Binder.getCallingPid()
            int r0 = android.os.Process.myPid()
            if (r1 != r0) goto Lb1
            java.lang.String r1 = "This method must be called on behalf of an IPC transaction from binder thread."
            if (r8 == 0) goto La0
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto La0
            r8.Air(r1)
        La0:
            r5 = 0
        La1:
            if (r5 != 0) goto Lb0
            java.lang.String r1 = "AppIdentity not found for caller"
            if (r8 == 0) goto Lb0
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto Lb0
            r8.Air(r1)
        Lb0:
            return r5
        Lb1:
            int r0 = android.os.Binder.getCallingUid()
            X.03w r5 = X.C008703w.A00(r6, r0)
            goto La1
        Lba:
            r0 = 1
            X.03w r5 = X.C008703w.A03(r6, r1, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: X.AbstractC008603v.A01(android.content.Context, android.content.Intent, X.007, int, long):X.03w");
    }
}
