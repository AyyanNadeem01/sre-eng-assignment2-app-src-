package com.facebook.superpack;

import X.AnonymousClass000;
import X.C018108b;
import X.C0AK;
import X.C0B5;
import X.C0BG;
import X.InterfaceC013005s;
import X.InterfaceC02480Bj;
import android.util.Log;
import com.facebook.breakpad.BreakpadManager;
import com.facebook.common.stringformat.StringFormatUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class SuperpackFileLoader implements InterfaceC02480Bj {
    public static final String DISTRACTMERGED_LIB_SHORTNAME = "distractmerged";
    public static final String LOADER_CLASS = "com.facebook.superpack.SuperpackFileLoader";
    public static final String SIGMUX_LIB_SHORTNAME = "sigmux";
    public static final String SUPERPACK_EXTENSION = ".spk";
    public static final String SUPERPACK_LIBNAME = "libsuperpack-jni.so";
    public static final String SUPERPACK_LIBNAME_FOR_SOLOADER = "superpack-jni";
    public static final String TAG = "SuperpackFileLoader";
    public static SuperpackFileLoader sInstance;
    public static boolean sLoadedSuperpack;
    public final String mLocalLdLibraryPath;
    public final String mLocalLdLibraryPathNoZips;
    public final Method mNativeLoadRuntimeMethod;
    public static final String[] COMPRESSION_EXTENSIONS = {".lz4", ".zst", ".xz", ".zstd", ".br", ".spo"};
    public static final Map sPendingMappings = Collections.synchronizedMap(AnonymousClass000.A0C());
    public static final Set HOLDOUT_LIBRARIES = new HashSet(Arrays.asList("libliger.so"));
    public static final String[] SIGMUX_LIB = {"libdistractmerged.so", "libsigmux.so"};
    public boolean mUnloadLibraries = false;
    public boolean mForceSystemLoad = false;
    public final Runtime mRuntime = Runtime.getRuntime();

    public static void addMappingsToBreakpad(MappingInfo[] mappingInfoArr) {
        for (MappingInfo mappingInfo : mappingInfoArr) {
            addMappingToBreakpad(mappingInfo);
        }
    }

    public static native boolean canLoadInMemoryNative();

    public static native MappingInfo[] loadBytesNative(String str, byte[] bArr);

    public static native MappingInfo[] loadFdNative(String str, int i, long j, long j2);

    public static native void loadFileNative(String str);

    public void setUnloadLibraries() {
        this.mUnloadLibraries = true;
    }

    public class MappingInfo {
        public final byte[] buildId;
        public final long fileOffset;
        public final long mappingSize;
        public final String name;
        public final long startAddress;

        public MappingInfo(String str, byte[] bArr, long j, long j2, long j3) {
            this.name = str;
            this.buildId = bArr;
            this.startAddress = j;
            this.mappingSize = j2;
            this.fileOffset = j3;
        }
    }

    public static void addMappingToBreakpad(MappingInfo mappingInfo) {
        if (!BreakpadManager.initialized) {
            sPendingMappings.put(Long.valueOf(mappingInfo.startAddress), mappingInfo);
            return;
        }
        String str = mappingInfo.name;
        byte[] bArr = mappingInfo.buildId;
        BreakpadManager.addMappingInfo(str, bArr, bArr.length, mappingInfo.startAddress, mappingInfo.mappingSize, mappingInfo.fileOffset);
    }

    public static boolean canLoadLibraryInMemory(String str) {
        return !HOLDOUT_LIBRARIES.contains(str);
    }

    private void ensureMappingsRegistered() {
        if (BreakpadManager.initialized) {
            Map map = sPendingMappings;
            if (map.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            synchronized (map) {
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.add((MappingInfo) ((Map.Entry) it.next()).getValue());
                    it.remove();
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                MappingInfo mappingInfo = (MappingInfo) it2.next();
                String str = mappingInfo.name;
                byte[] bArr = mappingInfo.buildId;
                BreakpadManager.addMappingInfo(str, bArr, bArr.length, mappingInfo.startAddress, mappingInfo.mappingSize, mappingInfo.fileOffset);
            }
        }
    }

    public static File getCompressedSoFileOrNull(File file, String str) {
        for (String str2 : COMPRESSION_EXTENSIONS) {
            File fileA02 = AnonymousClass000.A02(file, AnonymousClass000.A06(str, str2, AnonymousClass000.A09()));
            if (fileA02.exists()) {
                return fileA02;
            }
            File fileA022 = AnonymousClass000.A02(file, AnonymousClass000.A06(SUPERPACK_EXTENSION, str2, AnonymousClass000.A0A(str)));
            if (fileA022.exists()) {
                return fileA022;
            }
        }
        return null;
    }

    public static SuperpackFileLoader getInstance() {
        if (sInstance == null) {
            synchronized (SuperpackFileLoader.class) {
                if (sInstance == null) {
                    sInstance = new SuperpackFileLoader();
                }
            }
        }
        return sInstance;
    }

    public static String getLibraryName(String str) {
        int iLastIndexOf = str.lastIndexOf(File.separatorChar);
        int iLastIndexOf2 = str.lastIndexOf(".so");
        int i = iLastIndexOf + 1;
        return iLastIndexOf2 == -1 ? str.substring(i) : str.substring(i, iLastIndexOf2 + 3);
    }

    public static boolean isLibraryCompressed(String str) {
        return !str.endsWith(".so");
    }

    public static boolean isLoadingInMemorySupported() {
        if (!sLoadedSuperpack) {
            C0BG.A0A(SUPERPACK_LIBNAME_FOR_SOLOADER);
        }
        return canLoadInMemoryNative();
    }

    public static boolean isSuperpackLib(String str) {
        return str.regionMatches(str.lastIndexOf(File.separatorChar) + 1, SUPERPACK_LIBNAME, 0, 19);
    }

    public static MappingInfo[] loadFd(String str, C0AK c0ak) {
        throw new NullPointerException("hasBackingFile");
    }

    private void loadLibrary(String str) {
        if (sLoadedSuperpack) {
            loadFile(str);
            ensureMappingsRegistered();
        } else {
            System.load(str);
            if (isSuperpackLib(str)) {
                sLoadedSuperpack = true;
            }
        }
    }

    public static void loadSigmux() {
        if (C0BG.A01(DISTRACTMERGED_LIB_SHORTNAME) != null) {
            C0BG.A0A(DISTRACTMERGED_LIB_SHORTNAME);
            return;
        }
        if (C0BG.A01(SIGMUX_LIB_SHORTNAME) != null) {
            C0BG.A0A(SIGMUX_LIB_SHORTNAME);
            return;
        }
        try {
            C0BG.A0A(DISTRACTMERGED_LIB_SHORTNAME);
            C0BG.A0A(SIGMUX_LIB_SHORTNAME);
        } catch (UnsatisfiedLinkError e) {
            C018108b.A0A(TAG, "Failed to load sigmux when loading superpack loader", e);
            throw e;
        }
    }

    public static Method tryGetLoaderMethod(String str, Class... clsArr) {
        try {
            return Class.forName(LOADER_CLASS).getMethod(str, clsArr);
        } catch (ClassNotFoundException e) {
            C018108b.A0A(TAG, "Could not find class com.facebook.superpack.SuperpackFileLoader", e);
            throw new RuntimeException("Could not find class com.facebook.superpack.SuperpackFileLoader", e);
        } catch (NoSuchMethodException e2) {
            StringBuilder sbA09 = AnonymousClass000.A09();
            sbA09.append("Could not find method ");
            sbA09.append(str);
            String strA06 = AnonymousClass000.A06(" in ", LOADER_CLASS, sbA09);
            C018108b.A0A(TAG, strA06, e2);
            throw new RuntimeException(strA06, e2);
        }
    }

    @Override // X.InterfaceC02480Bj
    public void load(String str, int i) {
        if (this.mNativeLoadRuntimeMethod == null) {
            if (this.mForceSystemLoad) {
                System.load(str);
                return;
            } else {
                loadLibrary(str);
                return;
            }
        }
        String str2 = (i & 4) == 4 ? this.mLocalLdLibraryPath : this.mLocalLdLibraryPathNoZips;
        try {
            try {
                synchronized (this.mRuntime) {
                    try {
                        Method method = this.mNativeLoadRuntimeMethod;
                        Runtime runtime = this.mRuntime;
                        Object[] objArr = new Object[3];
                        objArr[0] = str;
                        AnonymousClass000.A0H(C0BG.class.getClassLoader(), str2, objArr);
                        String str3 = (String) method.invoke(runtime, objArr);
                        if (str3 != null) {
                            throw new UnsatisfiedLinkError(str3);
                        }
                    } catch (Throwable th) {
                        th = th;
                        String strA06 = null;
                        try {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                if (strA06 != null) {
                                    String str4 = TAG;
                                    StringBuilder sbA09 = AnonymousClass000.A09();
                                    sbA09.append("Error when loading library: ");
                                    sbA09.append(strA06);
                                    sbA09.append(", library hash is ");
                                    sbA09.append(getLibHash(str));
                                    Log.e(str4, AnonymousClass000.A06(", LD_LIBRARY_PATH is ", str2, sbA09));
                                }
                                throw th2;
                            }
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                            e = e;
                            strA06 = AnonymousClass000.A06("Error: Cannot load ", str, AnonymousClass000.A09());
                            throw new RuntimeException(strA06, e);
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            e = e2;
        }
    }

    public SuperpackFileLoader() throws NoSuchMethodException, SecurityException {
        Method methodA03 = C0B5.A03();
        this.mNativeLoadRuntimeMethod = methodA03;
        String strA01 = methodA03 != null ? C0B5.A01() : null;
        this.mLocalLdLibraryPath = strA01;
        this.mLocalLdLibraryPathNoZips = C0B5.A02(strA01);
    }

    private String getLibHash(String str) throws IllegalAccessException, NoSuchAlgorithmException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            File fileA03 = AnonymousClass000.A03(str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(fileA03);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        String strLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%32x", new BigInteger(1, messageDigest.digest()));
                        fileInputStream.close();
                        return strLocaleSafe;
                    }
                    messageDigest.update(bArr, 0, i);
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                }
                throw th;
            }
        } catch (IOException | SecurityException | NoSuchAlgorithmException e) {
            return e.toString();
        }
    }

    public static MappingInfo[] loadBytes(String str, InterfaceC013005s interfaceC013005s) {
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) interfaceC013005s.size());
            interfaceC013005s.read(byteBufferAllocate);
            MappingInfo[] mappingInfoArrLoadBytesNative = loadBytesNative(str, byteBufferAllocate.array());
            if (mappingInfoArrLoadBytesNative != null) {
                addMappingsToBreakpad(mappingInfoArrLoadBytesNative);
            }
            return mappingInfoArrLoadBytesNative;
        } catch (IOException unused) {
            StringBuilder sbA09 = AnonymousClass000.A09();
            sbA09.append("Failed to load ");
            sbA09.append(str);
            throw new RuntimeException(AnonymousClass000.A07(": Could not read file", sbA09));
        }
    }

    public static void loadFile(String str) {
        try {
            loadFileNative(str);
        } catch (UnsatisfiedLinkError e) {
            if (!str.endsWith(".so")) {
                throw e;
            }
            System.load(str);
        }
    }

    public void setForceSystemLoad(boolean z) {
        this.mForceSystemLoad = z;
    }

    public void loadBytes(String str, InterfaceC013005s interfaceC013005s, int i) throws IOException {
        MappingInfo[] mappingInfoArrLoadBytes = loadBytes(str, interfaceC013005s);
        if (this.mUnloadLibraries && mappingInfoArrLoadBytes != null && mappingInfoArrLoadBytes.length > 0) {
            SuperpackUnloader.registerLibraryForUnloading(str);
        }
        ensureMappingsRegistered();
    }
}
