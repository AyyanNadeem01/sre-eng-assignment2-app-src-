package X;

import java.io.File;

/* renamed from: X.04j, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C010004j {
    public final char A00;
    public final char A01;
    public final char A02;
    public final char A03;
    public final char A04;
    public final File A05;
    public final boolean A06;
    public final boolean A07;

    public final boolean A02() {
        char c = this.A03;
        if (AbstractC010304m.A01(AnonymousClass065.A01, c)) {
            return false;
        }
        Integer num = AnonymousClass065.A0N;
        if (AbstractC010304m.A01(num, c)) {
            return false;
        }
        return (AbstractC010304m.A01(AnonymousClass065.A0C, this.A04) || AbstractC010304m.A01(num, this.A00)) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static X.C010004j A00(X.C0CK r15) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            if (r15 == 0) goto L8a
            java.lang.String r0 = r15.A06
            java.io.File r9 = r15.A01(r0)
            r14 = 0
            if (r9 == 0) goto L8a
            X.052 r0 = X.AnonymousClass052.A03
            if (r0 != 0) goto L12
            X.AnonymousClass052.A00(r15)
        L12:
            java.lang.String r1 = "state.txt"
            java.io.File r0 = new java.io.File
            r0.<init>(r9, r1)
            X.04k r4 = new X.04k
            r4.<init>(r0)
            java.lang.String r0 = "native_state.txt"
            java.io.File r3 = new java.io.File
            r3.<init>(r9, r0)
            java.lang.String r0 = "anr_state.txt"
            java.io.File r2 = new java.io.File
            r2.<init>(r9, r0)
            char r8 = r4.A02()
            char r7 = X.AbstractC010204l.A00(r3)
            char r6 = X.AbstractC010204l.A00(r2)
            char r13 = r4.A01()
            boolean r5 = X.AbstractC010304m.A00(r13)
            java.lang.Integer r0 = X.AnonymousClass065.A01
            boolean r0 = X.AbstractC010304m.A01(r0, r8)
            if (r0 != 0) goto L88
            java.lang.Integer r1 = X.AnonymousClass065.A0N
            boolean r0 = X.AbstractC010304m.A01(r1, r8)
            if (r0 != 0) goto L88
            java.lang.Integer r0 = X.AnonymousClass065.A0C
            boolean r0 = X.AbstractC010304m.A01(r0, r7)
            if (r0 != 0) goto L88
            boolean r0 = X.AbstractC010304m.A01(r1, r6)
            if (r0 != 0) goto L88
            r0 = 102(0x66, float:1.43E-43)
            if (r13 != r0) goto L88
            java.lang.String r1 = r4.A04()
            java.lang.Object r0 = X.C04N.A01
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L88
        L76:
            char r10 = r4.A02()
            char r11 = X.AbstractC010204l.A00(r3)
            char r12 = X.AbstractC010204l.A00(r2)
            X.04j r8 = new X.04j
            r8.<init>(r9, r10, r11, r12, r13, r14)
            return r8
        L88:
            r14 = r5
            goto L76
        L8a:
            X.04j r8 = new X.04j
            r8.<init>()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C010004j.A00(X.0CK):X.04j");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A01() {
        /*
            r3 = this;
            char r0 = r3.A03
            java.lang.Integer r2 = X.AnonymousClass065.A0N
            boolean r0 = X.AbstractC010304m.A01(r2, r0)
            if (r0 == 0) goto L14
            char r1 = r3.A04
            java.lang.Integer r0 = X.AnonymousClass065.A0C
            boolean r0 = X.AbstractC010304m.A01(r0, r1)
            if (r0 == 0) goto L1d
        L14:
            char r0 = r3.A00
            boolean r1 = X.AbstractC010304m.A01(r2, r0)
            r0 = 0
            if (r1 == 0) goto L1e
        L1d:
            r0 = 1
        L1e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C010004j.A01():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0053 A[PHI: r5
  0x0053: PHI (r5v2 char) = (r5v1 char), (r5v0 char), (r5v0 char) binds: [B:34:0x0051, B:29:0x0049, B:27:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C010004j(java.io.File r3, char r4, char r5, char r6, char r7, boolean r8) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 1
            r2.A07 = r0
            r2.A05 = r3
            r2.A03 = r4
            r2.A04 = r5
            r2.A00 = r6
            r0 = 48
            r1 = 48
            if (r5 == r0) goto L4c
            r0 = 105(0x69, float:1.47E-43)
            if (r5 == r0) goto L4c
            r0 = 57
            if (r5 != r0) goto L27
            r0 = 106(0x6a, float:1.49E-43)
            if (r4 != r0) goto L27
        L20:
            r2.A01 = r4
            r2.A02 = r7
            r2.A06 = r8
            return
        L27:
            r0 = 82
            if (r4 == r0) goto L47
            r0 = 85
            if (r4 == r0) goto L47
            r0 = 114(0x72, float:1.6E-43)
            if (r4 == r0) goto L47
            r0 = 99
            if (r4 == r0) goto L47
            r0 = 117(0x75, float:1.64E-43)
            if (r4 == r0) goto L47
            r0 = 113(0x71, float:1.58E-43)
            if (r4 == r0) goto L47
            r0 = 109(0x6d, float:1.53E-43)
            if (r4 == r0) goto L47
            r0 = 106(0x6a, float:1.49E-43)
            if (r4 != r0) goto L53
        L47:
            r0 = 81
            if (r5 != r0) goto L53
            goto L20
        L4c:
            r5 = r6
            if (r6 == r1) goto L20
            r0 = 105(0x69, float:1.47E-43)
            if (r6 == r0) goto L20
        L53:
            r4 = r5
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C010004j.<init>(java.io.File, char, char, char, char, boolean):void");
    }

    public C010004j() {
        this.A07 = false;
        this.A05 = null;
        this.A03 = (char) 0;
        this.A04 = (char) 0;
        this.A00 = (char) 0;
        this.A01 = (char) 0;
        this.A02 = (char) 0;
        this.A06 = false;
    }
}
