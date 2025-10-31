package X;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: X.04k, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C010104k {
    public final File A00;

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (r10v0 X.04k) */
    public static synchronized C006402s A00(C010104k c010104k, String str, long j) {
        C006402s c006402s;
        RandomAccessFile randomAccessFile;
        synchronized (c010104k) {
            if (j < 0) {
                throw new IllegalArgumentException();
            }
            File file = c010104k.A00;
            if (!file.exists() || file.length() <= j) {
                return null;
            }
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
            } catch (IOException e) {
                C0C5.A00();
                C018108b.A0H("lacrima", "Could not read %s due to IO issue", e, str);
                c006402s = new C006402s(-536L);
            } catch (NumberFormatException e2) {
                C0C5.A00();
                C018108b.A0H("lacrima", "Could not read %s", e2, str);
                c006402s = new C006402s(-647L);
            }
            try {
                randomAccessFile.seek(j);
                if (randomAccessFile.readByte() == 1) {
                    c006402s = new C006402s(-425L);
                } else {
                    long j2 = randomAccessFile.readLong();
                    if (j2 < 0) {
                        c006402s = new C006402s(-869L);
                    } else {
                        long j3 = randomAccessFile.readLong();
                        c006402s = j3 < 0 ? new C006402s(-869L) : new C006402s(j2, j3);
                    }
                }
                randomAccessFile.close();
                return c006402s;
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                }
                throw th;
            }
        }
    }

    public final synchronized char A01() {
        char c;
        File file = this.A00;
        if (!file.exists() || file.length() <= 1) {
            c = '?';
        } else {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    randomAccessFile.seek(1L);
                    c = (char) randomAccessFile.readByte();
                    randomAccessFile.close();
                } catch (Throwable th) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th2) {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                C0C5.A00();
                C018108b.A0C("lacrima", "Could not read activity state", e);
            }
        }
        return c;
    }

    public final synchronized char A02() {
        char c;
        File file = this.A00;
        if (!file.exists() || file.length() <= 0) {
            c = '0';
        } else {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    randomAccessFile.seek(0L);
                    c = (char) randomAccessFile.readByte();
                    randomAccessFile.close();
                } catch (Throwable th) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th2) {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                C0C5.A00();
                C018108b.A0C("lacrima", "Could not read status", e);
            }
        }
        return c;
    }

    public final synchronized int A03(boolean z) {
        int i = z ? 203 : 204;
        File file = this.A00;
        if (file.exists()) {
            long j = i;
            if (file.length() > j) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        randomAccessFile.seek(j);
                        byte b = randomAccessFile.readByte();
                        randomAccessFile.close();
                        return b;
                    } catch (Throwable th) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th2) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    C0C5.A00();
                    C018108b.A0C("lacrima", "Could not read number of activities byte", e);
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String A04() {
        /*
            r9 = this;
            r8 = r9
            monitor-enter(r8)
            java.io.File r6 = r9.A00     // Catch: java.io.IOException -> Laf java.lang.Throwable -> Lb6
            java.lang.String r7 = r6.getCanonicalPath()     // Catch: java.io.IOException -> Laf java.lang.Throwable -> Lb6
            r3 = 32
            boolean r0 = r6.exists()     // Catch: java.lang.Throwable -> Lad
            if (r0 == 0) goto L42
            long r1 = r6.length()     // Catch: java.lang.Throwable -> Lad
            r4 = 2
            int r0 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r0 <= 0) goto L42
            java.lang.String r0 = "r"
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.io.IOException -> L37 java.lang.Throwable -> Lad
            r2.<init>(r6, r0)     // Catch: java.io.IOException -> L37 java.lang.Throwable -> Lad
            r2.seek(r4)     // Catch: java.lang.Throwable -> L2d
            byte r0 = r2.readByte()     // Catch: java.lang.Throwable -> L2d
            char r6 = (char) r0     // Catch: java.lang.Throwable -> L2d
            r2.close()     // Catch: java.io.IOException -> L37 java.lang.Throwable -> Lad
            goto L44
        L2d:
            r1 = move-exception
            r2.close()     // Catch: java.lang.Throwable -> L32
            goto L36
        L32:
            r0 = move-exception
            X.AnonymousClass067.A00(r1, r0)     // Catch: java.io.IOException -> L37 java.lang.Throwable -> Lad
        L36:
            throw r1     // Catch: java.io.IOException -> L37 java.lang.Throwable -> Lad
        L37:
            r2 = move-exception
            X.C0C5.A00()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = "lacrima"
            java.lang.String r0 = "Could not read foreground entity"
            X.C018108b.A0C(r1, r0, r2)     // Catch: java.lang.Throwable -> Lad
        L42:
            r6 = 32
        L44:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb6
            r1.<init>()     // Catch: java.lang.Throwable -> Lb6
            r1.append(r7)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r0 = "_entity"
            r1.append(r0)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> Lb6
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lb6
            r1.<init>(r0)     // Catch: java.lang.Throwable -> Lb6
            if (r6 != r3) goto L5f
            java.lang.String r5 = "NONE"
            goto La8
        L5f:
            r0 = 33
            if (r6 != r0) goto L66
            java.lang.String r5 = "OTHERS"
            goto La8
        L66:
            java.util.Properties r4 = new java.util.Properties     // Catch: java.lang.Throwable -> Lb6
            r4.<init>()     // Catch: java.lang.Throwable -> Lb6
            r5 = 0
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.io.IOException -> La8 java.lang.Throwable -> Lb6
            r0.<init>(r1)     // Catch: java.io.IOException -> La8 java.lang.Throwable -> Lb6
            r4.load(r0)     // Catch: java.lang.Throwable -> L9d
            r0.close()     // Catch: java.io.IOException -> La8 java.lang.Throwable -> Lb6
            java.util.Set r0 = r4.stringPropertyNames()     // Catch: java.lang.Throwable -> Lb6
            java.util.Iterator r3 = r0.iterator()     // Catch: java.lang.Throwable -> Lb6
        L7f:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> Lb6
            if (r0 == 0) goto La8
            java.lang.Object r2 = r3.next()     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r1 = r4.getProperty(r2)     // Catch: java.lang.Throwable -> Lb6
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb6
            if (r0 != 0) goto L7f
            r0 = 0
            char r0 = r1.charAt(r0)     // Catch: java.lang.Throwable -> Lb6
            if (r6 != r0) goto L7f
            goto La7
        L9d:
            r1 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> La2
            goto La6
        La2:
            r0 = move-exception
            X.AnonymousClass067.A00(r1, r0)     // Catch: java.io.IOException -> La8 java.lang.Throwable -> Lb6
        La6:
            throw r1     // Catch: java.io.IOException -> La8 java.lang.Throwable -> Lb6
        La7:
            r5 = r2
        La8:
            if (r5 != 0) goto Lb4
            java.lang.String r5 = ""
            goto Lb4
        Lad:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> Lb6
        Laf:
            X.C0C5.A00()     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r5 = ""
        Lb4:
            monitor-exit(r8)
            return r5
        Lb6:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lb6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C010104k.A04():java.lang.String");
    }

    public C010104k(File file, boolean z) {
        this.A00 = file;
    }

    public C010104k(File file) {
        this.A00 = file;
    }
}
