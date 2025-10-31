package X;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.nio.MappedByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: X.04v */
/* loaded from: classes.dex */
public final class C011104v {
    public static final byte[] A02 = new byte[100];
    public static final char[] A03 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public final Map A00;
    public final C0AY A01;

    public static void A01(File file, String str, String str2, Properties properties) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            properties.store(fileOutputStream, sb.toString());
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
                throw th;
            } catch (Throwable th2) {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x01f3: IF  (r9 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:180:? (LINE:499), block:B:147:0x01f3 */
    /* JADX WARN: Type inference failed for: r0v42, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.io.File[]] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    public final void A02(File file, String str, Properties properties) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        ?? sb;
        long filePointer;
        String str2 = str;
        try {
            if ("perf".equals(str2)) {
                try {
                    Map map = this.A00;
                    C010604q c010604qA00 = (C010604q) map.get(file.getPath());
                    if (c010604qA00 == null) {
                        c010604qA00 = this.A01.A00(file);
                        C0CN.A00(c010604qA00);
                        map.put(file.getPath(), c010604qA00);
                    }
                    MappedByteBuffer mappedByteBuffer = c010604qA00.A00;
                    mappedByteBuffer.clear();
                    for (Map.Entry entry : properties.entrySet()) {
                        String string = entry.getKey().toString();
                        String string2 = entry.getValue().toString();
                        mappedByteBuffer.put(A00(string, true).getBytes("Ascii"));
                        mappedByteBuffer.put("=".getBytes("Ascii"));
                        mappedByteBuffer.put(A00(string2, false).getBytes("Ascii"));
                        mappedByteBuffer.put("\n".getBytes("Ascii"));
                    }
                    sb = "#";
                    mappedByteBuffer.put("#".getBytes("Ascii"));
                    return;
                } catch (Throwable unused) {
                    C0C5.A00();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        sb = new StringBuilder();
                        sb.append("fallover ");
                        if (str == null) {
                            str2 = "";
                        }
                        sb.append(str2);
                        properties.store(fileOutputStream, sb.toString());
                        fileOutputStream.close();
                        return;
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(file.getPath());
            sb2.append("_tmp");
            File file2 = new File(sb2.toString());
            if (str != null) {
                C011404z c011404zA00 = C011404z.A00(str2);
                synchronized (c011404zA00.A03) {
                    File file3 = c011404zA00.A02;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Did you call FixedLengthFiles.init()? - pool: ");
                    sb3.append(c011404zA00.A04);
                    AnonymousClass053.A03(file3, sb3.toString());
                    if (!(!file3.getPath().equals(file2.getParent()))) {
                        throw new IllegalArgumentException(String.valueOf("Destination file cannot be in the pool directory"));
                    }
                    sb = c011404zA00.A02.listFiles();
                    try {
                        if (sb == 0 || sb.length <= 0 || !sb[0].renameTo(file2)) {
                            A01(file2, str2, " store (reserve)", properties);
                        } else {
                            try {
                                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                                randomAccessFile.write("# ".getBytes("Ascii"));
                                randomAccessFile.write(str2.getBytes("Ascii"));
                                randomAccessFile.write("\n".getBytes("Ascii"));
                                Iterator it = properties.entrySet().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Map.Entry entry2 = (Map.Entry) it.next();
                                        String string3 = entry2.getKey().toString();
                                        String string4 = entry2.getValue().toString();
                                        byte[] bytes = A00(string3, true).getBytes("Ascii");
                                        byte[] bytes2 = A00(string4, false).getBytes("Ascii");
                                        if (randomAccessFile.getFilePointer() + bytes.length + bytes2.length + 25 > randomAccessFile.length()) {
                                            randomAccessFile.write("trimmed_report=true\n#".getBytes("Ascii"));
                                            randomAccessFile.close();
                                            A01(file2, str2, " store (too large) ", properties);
                                            break;
                                        } else {
                                            randomAccessFile.write(bytes);
                                            randomAccessFile.write("=".getBytes("Ascii"));
                                            randomAccessFile.write(bytes2);
                                            randomAccessFile.write("\n".getBytes("Ascii"));
                                        }
                                    } else {
                                        byte[] bytes3 = "# ".getBytes("Ascii");
                                        do {
                                            randomAccessFile.write(bytes3);
                                            filePointer = randomAccessFile.getFilePointer();
                                            bytes3 = A02;
                                        } while (filePointer + 100 < randomAccessFile.length());
                                        while (randomAccessFile.getFilePointer() + 100 < randomAccessFile.length()) {
                                            randomAccessFile.writeByte(0);
                                        }
                                        randomAccessFile.close();
                                    }
                                }
                                randomAccessFile.close();
                            } catch (FileNotFoundException e) {
                                C0C5.A00();
                                C018108b.A0C("lacrima", "Cannot reserve file", e);
                            }
                        }
                    } finally {
                    }
                }
            } else {
                A01(file2, "", "no pool", properties);
            }
            if (file2.renameTo(file)) {
                return;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Could not rename file: ");
            sb4.append(file.getName());
            throw new IOException(sb4.toString());
        } catch (Throwable th2) {
            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(sb, th2);
            throw sb;
        }
        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(sb, th2);
        throw sb;
    }

    public C011104v(C0AY c0ay) {
        this.A00 = new ConcurrentHashMap();
        this.A01 = c0ay;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x001d, code lost:
    
        if (r1 < r4) goto L49;
     */
    /* JADX WARN: Path cross not found for [B:48:0x001d, B:42:0x000e], limit reached: 38 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0075 -> B:46:0x0018). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0078 -> B:46:0x0018). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x007b -> B:46:0x0018). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x007e -> B:46:0x0018). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(java.lang.String r7, boolean r8) {
        /*
            int r4 = r7.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r2 = 32
            r1 = 0
            if (r8 != 0) goto L1d
            if (r4 <= 0) goto L81
            char r0 = r7.charAt(r1)
            if (r0 != r2) goto L1f
            java.lang.String r0 = "\\ "
        L18:
            r3.append(r0)
        L1b:
            int r1 = r1 + 1
        L1d:
            if (r1 >= r4) goto L81
        L1f:
            char r5 = r7.charAt(r1)
            switch(r5) {
                case 9: goto L75;
                case 10: goto L78;
                case 11: goto L26;
                case 12: goto L7b;
                case 13: goto L7e;
                default: goto L26;
            }
        L26:
            r6 = 92
            if (r8 == 0) goto L2c
            if (r5 == r2) goto L71
        L2c:
            if (r5 == r6) goto L71
            r0 = 35
            if (r5 == r0) goto L71
            r0 = 33
            if (r5 == r0) goto L71
            r0 = 58
            if (r5 == r0) goto L71
            r0 = 61
            if (r5 == r0) goto L71
            if (r5 < r2) goto L48
            r0 = 126(0x7e, float:1.77E-43)
            if (r5 > r0) goto L48
        L44:
            r3.append(r5)
            goto L1b
        L48:
            java.lang.String r0 = "\\u"
            r3.append(r0)
            char[] r6 = X.C011104v.A03
            int r0 = r5 >>> 12
            r0 = r0 & 15
            char r0 = r6[r0]
            r3.append(r0)
            int r0 = r5 >>> 8
            r0 = r0 & 15
            char r0 = r6[r0]
            r3.append(r0)
            int r0 = r5 >>> 4
            r0 = r0 & 15
            char r0 = r6[r0]
            r3.append(r0)
            int r0 = r5 >>> 0
            r0 = r0 & 15
            char r5 = r6[r0]
            goto L44
        L71:
            r3.append(r6)
            goto L44
        L75:
            java.lang.String r0 = "\\t"
            goto L18
        L78:
            java.lang.String r0 = "\\n"
            goto L18
        L7b:
            java.lang.String r0 = "\\f"
            goto L18
        L7e:
            java.lang.String r0 = "\\r"
            goto L18
        L81:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C011104v.A00(java.lang.String, boolean):java.lang.String");
    }

    public C011104v() {
    }
}
