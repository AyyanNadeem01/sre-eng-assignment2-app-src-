package X;

/* renamed from: X.08P, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C08P {
    public static final char[] A00 = {' ', '\t', '\n', 11, '\f', '\r'};

    public static long A00(byte[] bArr, int i) {
        byte b;
        boolean z;
        byte b2;
        int i2;
        int i3;
        int i4 = i;
        int length = bArr.length;
        long j = 0;
        if (i4 < length) {
            loop0: while (true) {
                b = bArr[i4];
                i4++;
                if (i4 >= length) {
                    break;
                }
                char c = (char) b;
                while (true) {
                    char[] cArr = A00;
                    if (i3 >= 6) {
                        break loop0;
                    }
                    i3 = cArr[i3] != c ? i3 + 1 : 0;
                }
            }
            if (b == 45) {
                b = bArr[i4];
                i4++;
                z = true;
            } else {
                if (b == 43) {
                    b = bArr[i4];
                    i4++;
                }
                z = false;
            }
            if (i4 < length) {
                char c2 = 0;
                while (i4 <= length) {
                    char c3 = (char) b;
                    if ('0' <= c3) {
                        if (c3 <= '9') {
                            i2 = b - 48;
                        } else if ('a' <= c3) {
                            if (c3 > 'z') {
                                break;
                            }
                            b2 = 87;
                            i2 = b - b2;
                        } else {
                            if ('A' > c3 || c3 > 'Z') {
                                break;
                            }
                            b2 = 55;
                            i2 = b - b2;
                        }
                        byte b3 = (byte) i2;
                        if (b3 >= 10) {
                            break;
                        }
                        if (c2 < 0 || j > 922337203685477580L || (j == 922337203685477580L && b3 > 7)) {
                            c2 = 65535;
                        } else {
                            j = (j * 10) + b3;
                            c2 = 1;
                        }
                        b = i4 < length ? bArr[i4] : (byte) 0;
                        i4++;
                    } else {
                        break;
                    }
                }
                if (c2 < 0) {
                    return z ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                if (z) {
                    return -j;
                }
            }
        }
        return j;
    }
}
