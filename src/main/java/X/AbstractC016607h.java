package X;

/* renamed from: X.07h, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC016607h {
    public static final C016707i A00() {
        long[] jArr = new long[7];
        if (C08T.A00.Ah1("/proc/self/io", jArr, C016707i.A07, 0L)) {
            return new C016707i(jArr[0], jArr[1], jArr[2], jArr[3], jArr[4], jArr[5], jArr[6]);
        }
        return null;
    }
}
