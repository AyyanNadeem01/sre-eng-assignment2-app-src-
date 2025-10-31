package X;

import android.os.StrictMode;
import android.system.ErrnoException;
import android.system.Os;
import java.io.FileDescriptor;
import java.io.InterruptedIOException;
import java.util.HashSet;
import java.util.Set;

/* renamed from: X.08R, reason: invalid class name */
/* loaded from: classes.dex */
public final class C08R implements C08Q {
    public final Set A00 = new HashSet();

    private int A00(String str, byte[] bArr) {
        Set set = this.A00;
        if (!set.contains(str)) {
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                int length = bArr.length;
                try {
                    FileDescriptor fileDescriptorOpen = Os.open(str, 0, 0);
                    try {
                        int i = Os.read(fileDescriptorOpen, bArr, 0, length - 1);
                        try {
                            Os.close(fileDescriptorOpen);
                        } catch (ErrnoException unused) {
                        }
                        if (i != -2147483647) {
                            return i;
                        }
                    } catch (ErrnoException | InterruptedIOException unused2) {
                        Os.close(fileDescriptorOpen);
                    } catch (Throwable th) {
                        try {
                            Os.close(fileDescriptorOpen);
                        } catch (ErrnoException unused3) {
                        }
                        throw th;
                    }
                } catch (ErrnoException unused4) {
                }
                set.add(str);
                if (threadPolicyAllowThreadDiskReads != null) {
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                    return -1;
                }
            } finally {
                if (threadPolicyAllowThreadDiskReads != null) {
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                }
            }
        }
        return -1;
    }

    public static C08R A01() {
        return new C08R();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00dd A[SYNTHETIC] */
    @Override // X.C08Q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int Ah0(java.lang.String r22, int[] r23, long[] r24, java.lang.String[] r25) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C08R.Ah0(java.lang.String, int[], long[], java.lang.String[]):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0095, code lost:
    
        if (r1 >= r6) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0097, code lost:
    
        r0 = r10[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0099, code lost:
    
        if (r0 == 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009b, code lost:
    
        if (r0 == 10) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009d, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a0, code lost:
    
        if (r1 >= 2048) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a4, code lost:
    
        if (r10[r1] != 10) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a6, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082 A[PHI: r2
  0x0082: PHI (r2v0 boolean) = (r2v2 boolean), (r2v4 boolean) binds: [B:46:0x0080, B:44:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0095 A[EDGE_INSN: B:70:0x0095->B:95:? BREAK  A[LOOP:2: B:17:0x0032->B:42:0x0077], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0029 A[SYNTHETIC] */
    @Override // X.C08Q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean Ah1(java.lang.String r19, long[] r20, java.lang.String[] r21, long r22) {
        /*
            r18 = this;
            r8 = r21
            int r7 = r8.length
            r9 = r20
            int r0 = r9.length
            if (r7 > r0) goto Lae
            r17 = 0
            r0 = 0
        Lb:
            if (r0 >= r7) goto L12
            r20[r0] = r22
            int r0 = r0 + 1
            goto Lb
        L12:
            r11 = 2048(0x800, float:2.87E-42)
            byte[] r10 = new byte[r11]
            r1 = r18
            r0 = r19
            int r6 = r1.A00(r0, r10)
            r16 = 1
            if (r6 >= 0) goto La9
            r16 = 0
            r6 = 0
        L25:
            r10[r6] = r17
        L27:
            r1 = 0
            r5 = 0
        L29:
            if (r1 >= r6) goto Lad
            r0 = r10[r1]
            if (r0 == 0) goto Lad
            if (r5 >= r7) goto Lad
            r12 = 0
        L32:
            r4 = 10
            if (r12 >= r7) goto L95
            r15 = r21[r12]
            r14 = r1
            int r13 = r15.length()
            r3 = 0
        L3e:
            if (r14 >= r11) goto L4f
            if (r3 >= r13) goto L4f
            r2 = r10[r14]
            char r0 = r15.charAt(r3)
            if (r2 != r0) goto L77
            int r14 = r14 + 1
            int r3 = r3 + 1
            goto L3e
        L4f:
            if (r3 != r13) goto L77
            int r0 = r15.length()
            int r1 = r1 + r0
        L56:
            if (r1 >= r11) goto L67
            r2 = r10[r1]
            if (r2 == 0) goto L64
            r0 = 32
            if (r2 == r0) goto L64
            r0 = 9
            if (r2 != r0) goto L67
        L64:
            int r1 = r1 + 1
            goto L56
        L67:
            r3 = r1
        L68:
            if (r3 >= r11) goto L7f
            r2 = r10[r3]
            r0 = 48
            if (r2 < r0) goto L7a
            r0 = 57
            if (r2 > r0) goto L7a
            int r3 = r3 + 1
            goto L68
        L77:
            int r12 = r12 + 1
            goto L32
        L7a:
            r0 = r10[r3]
            r2 = 0
            if (r0 == r4) goto L82
        L7f:
            r2 = 1
            if (r3 >= r11) goto L8a
        L82:
            r0 = r10[r3]
            if (r0 == 0) goto L8a
            r10[r3] = r17
            int r3 = r3 + 1
        L8a:
            long r0 = X.C08P.A00(r10, r1)
            r20[r12] = r0
            int r5 = r5 + 1
            r1 = r3
            if (r2 == 0) goto L29
        L95:
            if (r1 >= r6) goto La0
            r0 = r10[r1]
            if (r0 == 0) goto La0
            if (r0 == r4) goto La0
            int r1 = r1 + 1
            goto L95
        La0:
            if (r1 >= r11) goto L29
            r0 = r10[r1]
            if (r0 != r4) goto L29
            int r1 = r1 + 1
            goto L29
        La9:
            if (r6 >= r11) goto L27
            goto L25
        Lad:
            return r16
        Lae:
            java.lang.String r1 = "Array lengths differ"
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C08R.Ah1(java.lang.String, long[], java.lang.String[], long):boolean");
    }
}
