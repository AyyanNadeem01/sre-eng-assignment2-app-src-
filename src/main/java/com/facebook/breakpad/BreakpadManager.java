package com.facebook.breakpad;

import X.AbstractC017707t;
import X.C018108b;
import X.C0AP;
import X.C0BG;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class BreakpadManager {
    public static volatile boolean initialized;
    public static volatile File mCrashDirectory;

    public static native void addMappingInfo(String str, byte[] bArr, int i, long j, long j2, long j3);

    public static native void crashProcessByAssert(String str);

    public static native void crashThisProcess();

    public static native void crashThisProcessAsan();

    public static native void crashThisProcessBoundsSan();

    public static native void crashThisProcessGWPAsan();

    public static native boolean disableCoreDumpingImpl();

    public static native boolean enableCoreDumpingImpl(String str);

    public static native void install(String str, String str2, String str3, int i, int i2, boolean z, boolean z2);

    public static native boolean isCoreResourceHardUnlimited();

    public static native boolean isPrivacyModeEnabled();

    public static native boolean nativeContainsKey(String str);

    public static native String nativeGetCustomData(String str);

    public static native void nativeGetCustomDataSnapshot(TreeMap treeMap);

    public static native long nativeGetMinidumpFlags();

    public static native void nativeRemoveCustomData(String str);

    public static native void nativeSetCustomData(String str, String str2);

    public static native boolean nativeSetJvmStreamEnabled(boolean z, boolean z2);

    public static native void nativeSetMinidumpFlags(long j);

    public static native void setVersionInfo(int i, String str, String str2);

    public static native boolean simulateSignalDelivery(int i, String str);

    public static native void uninstall();

    public static synchronized void ensureLoadLibrary() {
        if (!initialized) {
            C0BG.A0A("breakpad");
            initialized = true;
        }
    }

    public static File getCrashDirectory() {
        if (mCrashDirectory != null) {
            return mCrashDirectory;
        }
        throw new RuntimeException("Breakpad not installed");
    }

    public static boolean isActive() {
        return initialized && mCrashDirectory != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void setJvmStreamEnabled(boolean r3) {
        /*
            java.lang.Class<com.facebook.breakpad.BreakpadManager> r2 = com.facebook.breakpad.BreakpadManager.class
            monitor-enter(r2)
            java.lang.String r0 = "java.vm.version"
            java.lang.String r1 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L2b
            if (r1 == 0) goto L1f
            java.lang.String r0 = "1."
            boolean r0 = r1.startsWith(r0)     // Catch: java.lang.Throwable -> L2b
            if (r0 != 0) goto L1f
            java.lang.String r0 = "0."
            boolean r0 = r1.startsWith(r0)     // Catch: java.lang.Throwable -> L2b
            r1 = 1
            if (r0 != 0) goto L1f
            if (r3 == 0) goto L26
            goto L21
        L1f:
            r1 = 0
            goto L26
        L21:
            java.lang.String r0 = "breakpad_cpp_helper"
            X.C0BG.A0A(r0)     // Catch: java.lang.Throwable -> L2b
        L26:
            nativeSetJvmStreamEnabled(r1, r3)     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r2)
            return
        L2b:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.breakpad.BreakpadManager.setJvmStreamEnabled(boolean):void");
    }

    public static boolean containsKey(String str) {
        boolean zNativeContainsKey;
        if (isActive()) {
            ensureLoadLibrary();
            if ((nativeGetMinidumpFlags() & 32768) != 32768) {
                synchronized (BreakpadManager.class) {
                    zNativeContainsKey = nativeContainsKey(str);
                }
                return zNativeContainsKey;
            }
        } else {
            C018108b.A08("BreakpadManager", "Breakpad is not active (containsKey).");
        }
        return false;
    }

    public static boolean enableCoreDumping(Context context) throws IOException {
        ensureLoadLibrary();
        if (Build.VERSION.SDK_INT < 24) {
            File file = null;
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/sys/kernel/core_pattern")));
                try {
                    file = new File(bufferedReader.readLine());
                } catch (IOException e) {
                    Log.e("BreakpadManager", "There was a problem reading core pattern file", e);
                }
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    Log.e("BreakpadManager", "There was a problem closing core pattern file", e2);
                }
                if (file != null) {
                    File parentFile = file.getParentFile();
                    if (file.isAbsolute() && parentFile != null && !parentFile.canWrite()) {
                        return false;
                    }
                }
            } catch (FileNotFoundException e3) {
                StringBuilder sb = new StringBuilder();
                sb.append("Core pattern file not found or blocked by SELinux");
                sb.append(e3.getMessage());
                Log.w("BreakpadManager", sb.toString());
            }
        }
        if (isCoreResourceHardUnlimited()) {
            return enableCoreDumpingImpl(context.getApplicationInfo().dataDir);
        }
        return false;
    }

    public static String getCustomData(String str) {
        String strNativeGetCustomData;
        if (!isActive()) {
            C018108b.A08("BreakpadManager", "Breakpad is not active (getCustomData).");
            return "";
        }
        ensureLoadLibrary();
        if (!((nativeGetMinidumpFlags() & 32768) != 32768)) {
            return "";
        }
        synchronized (BreakpadManager.class) {
            strNativeGetCustomData = nativeGetCustomData(str);
        }
        return strNativeGetCustomData;
    }

    public static void removeCustomData(String str) {
        if (!isActive()) {
            C018108b.A08("BreakpadManager", "Breakpad is not active (removeCustomData).");
            return;
        }
        ensureLoadLibrary();
        if ((nativeGetMinidumpFlags() & 32768) != 32768) {
            synchronized (BreakpadManager.class) {
                nativeRemoveCustomData(str);
            }
        }
    }

    public static void setCustomData(String str, String str2, Object... objArr) {
        if (!isActive()) {
            C018108b.A08("BreakpadManager", "Breakpad is not active (setCustomData).");
            return;
        }
        ensureLoadLibrary();
        if ((nativeGetMinidumpFlags() & 32768) != 32768) {
            synchronized (BreakpadManager.class) {
                if (objArr.length > 0 && str2 != null) {
                    StringBuilder sb = new StringBuilder();
                    Formatter formatter = new Formatter(sb);
                    formatter.format(str2, objArr);
                    formatter.close();
                    str2 = sb.toString();
                }
                nativeSetCustomData(str, str2);
            }
        }
    }

    public static synchronized void start(Context context, long j, int i, String str, String str2, boolean z) {
        ensureLoadLibrary();
        if (mCrashDirectory == null) {
            File fileA00 = C0AP.A00(context, 1874789883);
            install(fileA00.getAbsolutePath(), "", null, 1536000, Build.VERSION.SDK_INT, false, (j & 65536) == 65536);
            mCrashDirectory = fileA00;
            ensureLoadLibrary();
            long jNativeGetMinidumpFlags = j | nativeGetMinidumpFlags() | 2 | 4;
            ensureLoadLibrary();
            nativeSetMinidumpFlags(jNativeGetMinidumpFlags);
            int iA01 = AbstractC017707t.A01();
            String str3 = Build.FINGERPRINT;
            setVersionInfo(iA01, "482.0.0.12.107", str3);
            setCustomData("Fingerprint", str3, new Object[0]);
        }
    }

    public static void start(Context context) {
        start(context, 0L, 1536000, null, null, false);
    }
}
