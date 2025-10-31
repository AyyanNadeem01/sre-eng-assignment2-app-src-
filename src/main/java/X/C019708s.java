package X;

import android.content.Context;
import android.os.Build;
import com.facebook.common.dextricks.DexFileLoadNew;
import com.facebook.common.dextricks.DexFileLoadOld;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: X.08s */
/* loaded from: classes.dex */
public final class C019708s extends ClassLoader implements AnonymousClass097 {
    public static C019708s A0A;
    public static byte A0B;
    public static final ClassLoader A0C;
    public static final ClassLoader A0D;
    public static final Field A0E;
    public boolean A00;
    public boolean A01;
    public DexFile[] A02;
    public DexFile[] A03;
    public final ClassLoader A04;
    public final ArrayList A05;
    public final ConcurrentLinkedQueue A06;
    public final DexFile[] A07;
    public final DexFile[] A08;
    public volatile AnonymousClass015 A09;

    private synchronized void A02() {
        DexFile[] dexFileArr = this.A08;
        int length = dexFileArr.length;
        DexFile[] dexFileArr2 = this.A03;
        int length2 = dexFileArr2.length;
        DexFile[] dexFileArr3 = this.A07;
        int length3 = dexFileArr3.length;
        int i = 1;
        DexFile[] dexFileArr4 = new DexFile[length + length2 + length3 + 1];
        int i2 = 0;
        dexFileArr4[0] = null;
        int i3 = 0;
        while (i3 < length) {
            dexFileArr4[i] = dexFileArr[i3];
            i3++;
            i++;
        }
        int i4 = 0;
        while (i4 < length3) {
            dexFileArr4[i] = dexFileArr3[i4];
            i4++;
            i++;
        }
        while (i2 < length2) {
            dexFileArr4[i] = dexFileArr2[i2];
            i2++;
            i++;
        }
        this.A02 = dexFileArr4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:305:0x00eb, code lost:
    
        if (r0 == null) goto L325;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x00d0  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // java.lang.ClassLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Class loadClass(java.lang.String r13, boolean r14) throws java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C019708s.loadClass(java.lang.String, boolean):java.lang.Class");
    }

    static {
        try {
            ClassLoader classLoader = C019708s.class.getClassLoader();
            A0C = classLoader;
            Field declaredField = ClassLoader.class.getDeclaredField("parent");
            A0E = declaredField;
            declaredField.setAccessible(true);
            A0D = (ClassLoader) declaredField.get(classLoader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public C019708s(Context context, boolean z) throws NoSuchFieldException, SecurityException {
        super(A0D);
        this.A00 = false;
        this.A01 = false;
        this.A09 = null;
        this.A06 = new ConcurrentLinkedQueue();
        this.A05 = AnonymousClass000.A0B();
        this.A03 = new DexFile[0];
        this.A04 = A0C;
        ArrayList arrayListA0B = AnonymousClass000.A0B();
        ArrayList arrayListA0B2 = AnonymousClass000.A0B();
        try {
            try {
                Field declaredField = Class.forName("dalvik.system.BaseDexClassLoader").getDeclaredField("pathList");
                declaredField.setAccessible(true);
                Object[] objArrA0Q = AnonymousClass000.A0Q(this.A04, declaredField);
                Field declaredField2 = Class.forName("dalvik.system.DexPathList$Element").getDeclaredField("dexFile");
                declaredField2.setAccessible(true);
                String str = context.getApplicationInfo().sourceDir;
                for (Object obj : objArrA0Q) {
                    DexFile dexFile = (DexFile) declaredField2.get(obj);
                    if (!z || dexFile != null) {
                        if (str.equals(dexFile.getName())) {
                            arrayListA0B.add(dexFile);
                        } else {
                            arrayListA0B2.add(dexFile);
                        }
                    }
                }
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e2) {
            C018108b.A0C("ClassLoaderWithDexPromotion", "Failed to locate primary/auxiliary dex files, expect a perf loss: ", e2);
        }
        this.A08 = (DexFile[]) arrayListA0B.toArray(new DexFile[arrayListA0B.size()]);
        this.A07 = (DexFile[]) arrayListA0B2.toArray(new DexFile[arrayListA0B2.size()]);
        A02();
    }

    public static synchronized C019708s A00(Context context) {
        A03(context, false);
        return A0A;
    }

    public static Class A01(DexFile dexFile, ClassLoader classLoader, String str) {
        byte b = A0B;
        if (b != 0) {
            return b != 1 ? b != 2 ? dexFile.loadClass(str, classLoader) : DexFileLoadOld.A00(dexFile, classLoader, str) : DexFileLoadNew.A00(dexFile, classLoader, str);
        }
        try {
            try {
                Class clsA00 = DexFileLoadNew.A00(dexFile, classLoader, str);
                A0B = (byte) 1;
                return clsA00;
            } catch (NoSuchMethodError unused) {
                Class clsLoadClass = dexFile.loadClass(str, classLoader);
                A0B = (byte) 3;
                return clsLoadClass;
            }
        } catch (NoSuchMethodError unused2) {
            Class clsA002 = DexFileLoadOld.A00(dexFile, classLoader, str);
            A0B = (byte) 2;
            return clsA002;
        }
    }

    public static synchronized void A03(Context context, boolean z) {
        if (A0A == null) {
            try {
                Class.forName("com.facebook.common.dextricks.DexFileLoadOld");
                Class.forName("com.facebook.common.dextricks.DexFileLoadNew");
                C019708s c019708s = new C019708s(context, z);
                try {
                    A0E.set(c019708s.A04, c019708s);
                    A0A = c019708s;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            } catch (ClassNotFoundException e2) {
            }
        }
    }

    public final void A04(DexFile dexFile) {
        DexFile[] dexFileArr = this.A03;
        ArrayList arrayList = new ArrayList(dexFileArr.length + 1);
        for (DexFile dexFile2 : dexFileArr) {
            arrayList.add(dexFile2);
        }
        arrayList.add(dexFile);
        this.A03 = (DexFile[]) arrayList.toArray(new DexFile[arrayList.size()]);
        A02();
    }

    @Override // X.AnonymousClass097
    public final void A2y(File file, File file2) throws IOException {
        if (Build.VERSION.SDK_INT >= 34) {
            file.setWritable(false);
        }
        ClassLoader classLoader = null;
        if (this.A00) {
            if (file.getCanonicalPath().contains("app_modules")) {
                classLoader = DexFile.class.getClassLoader();
            }
        } else if (this.A01) {
            String canonicalPath = file.getCanonicalPath();
            if (canonicalPath.contains("app_modules")) {
                int i = 0;
                while (true) {
                    ArrayList arrayList = this.A05;
                    if (i < arrayList.size()) {
                        if (canonicalPath.contains((CharSequence) arrayList.get(i))) {
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        break;
                    }
                }
                classLoader = DexFile.class.getClassLoader();
            }
        }
        A04(C02T.A00(classLoader, file.getAbsolutePath(), file2.getAbsolutePath()));
    }

    @Override // java.lang.ClassLoader
    public final Class findClass(String str) throws ClassNotFoundException {
        Class clsA01;
        DexFile[] dexFileArr = this.A02;
        ConcurrentLinkedQueue concurrentLinkedQueue = this.A06;
        Iterator it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            ((C0BF) it.next()).A5d();
        }
        DexFile dexFile = dexFileArr[0];
        if (dexFile == null || (clsA01 = A01(dexFile, this.A04, str)) == null) {
            int i = 1;
            while (true) {
                if (i < dexFileArr.length) {
                    DexFile dexFile2 = dexFileArr[i];
                    clsA01 = A01(dexFile2, this.A04, str);
                    if (clsA01 == null) {
                        i++;
                    } else if (i > 1) {
                        synchronized (this) {
                            DexFile[] dexFileArr2 = this.A02;
                            if (dexFileArr2[i] == dexFile2) {
                                dexFileArr2[0] = dexFile2;
                                while (i >= 1) {
                                    dexFileArr2[i] = dexFileArr2[i - 1];
                                    i--;
                                }
                                dexFileArr2[0] = null;
                            }
                        }
                    }
                } else {
                    DexFile[] dexFileArr3 = this.A08;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= dexFileArr3.length) {
                            clsA01 = null;
                            break;
                        }
                        clsA01 = A01(dexFileArr3[i2], this.A04, str);
                        if (clsA01 != null) {
                            break;
                        }
                        i2++;
                    }
                    if (clsA01 == null) {
                        DexFile[] dexFileArr4 = this.A07;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dexFileArr4.length) {
                                clsA01 = null;
                                break;
                            }
                            clsA01 = A01(dexFileArr4[i3], this.A04, str);
                            if (clsA01 != null) {
                                break;
                            }
                            i3++;
                        }
                        if (clsA01 == null) {
                            DexFile[] dexFileArr5 = this.A03;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= dexFileArr5.length) {
                                    clsA01 = null;
                                    break;
                                }
                                clsA01 = A01(dexFileArr5[i4], this.A04, str);
                                if (clsA01 != null) {
                                    break;
                                }
                                i4++;
                            }
                            if (clsA01 == null) {
                                Iterator it2 = concurrentLinkedQueue.iterator();
                                while (it2.hasNext()) {
                                    ((C0BF) it2.next()).A5c();
                                }
                                throw new ClassNotFoundException(AnonymousClass000.A06("ClassLoaderWithDexPromotion didn't find ", str, AnonymousClass000.A09()));
                            }
                        }
                    }
                }
            }
        }
        Iterator it3 = concurrentLinkedQueue.iterator();
        while (it3.hasNext()) {
            ((C0BF) it3.next()).A5b(clsA01);
        }
        return clsA01;
    }
}
