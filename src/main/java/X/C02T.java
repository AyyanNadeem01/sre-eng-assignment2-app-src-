package X;

import dalvik.system.DexFile;
import java.lang.reflect.Method;

/* renamed from: X.02T, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C02T {
    public static boolean A00;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[PHI: r5
  0x002e: PHI (r5v5 dalvik.system.DexFile) = (r5v0 dalvik.system.DexFile), (r5v1 dalvik.system.DexFile), (r5v0 dalvik.system.DexFile) binds: [B:3:0x0002, B:14:0x002e, B:8:0x000f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static dalvik.system.DexFile A00(java.lang.ClassLoader r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = 0
            r5 = 0
            if (r7 == 0) goto L2e
            boolean r0 = X.C02T.A00     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto Lb
            java.lang.reflect.Method r4 = X.AnonymousClass039.A00     // Catch: java.lang.Throwable -> L2e
            goto Lf
        Lb:
            java.lang.reflect.Method r4 = A01()     // Catch: java.lang.Throwable -> L2e
        Lf:
            if (r4 == 0) goto L2e
            r0 = 5
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L2e
            r3[r6] = r8     // Catch: java.lang.Throwable -> L2e
            r2 = 1
            r3[r2] = r9     // Catch: java.lang.Throwable -> L2e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L2e
            r0 = 2
            r3[r0] = r1     // Catch: java.lang.Throwable -> L2e
            r0 = 3
            r3[r0] = r7     // Catch: java.lang.Throwable -> L2e
            r0 = 4
            r3[r0] = r5     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r0 = r4.invoke(r5, r3)     // Catch: java.lang.Throwable -> L2e
            dalvik.system.DexFile r0 = (dalvik.system.DexFile) r0     // Catch: java.lang.Throwable -> L2e
            r5 = r0
            goto L2f
        L2e:
            r2 = 0
        L2f:
            if (r2 != 0) goto L35
            dalvik.system.DexFile r5 = dalvik.system.DexFile.loadDex(r8, r9, r6)
        L35:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C02T.A00(java.lang.ClassLoader, java.lang.String, java.lang.String):dalvik.system.DexFile");
    }

    public static Method A01() throws SecurityException {
        for (Method method : DexFile.class.getDeclaredMethods()) {
            if (method.getName().equals("loadDex") && method.getParameterTypes().length >= 5) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }
}
