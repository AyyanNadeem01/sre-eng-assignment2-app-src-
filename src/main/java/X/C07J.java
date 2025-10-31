package X;

import java.text.BreakIterator;

/* renamed from: X.07J, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C07J {
    public static boolean A01(int i) {
        if (i < 48) {
            return false;
        }
        if (i <= 57) {
            return true;
        }
        if (i < 65) {
            return false;
        }
        if (i > 70) {
            return i >= 97 && i <= 102;
        }
        return true;
    }

    public static boolean A02(int i) {
        if (i == 33 || i == 36 || i == 59 || i == 61) {
            return true;
        }
        switch (i) {
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                return true;
            default:
                return false;
        }
    }

    public static boolean A03(int i) {
        int i2;
        boolean z;
        if (i >= 65) {
            if (i > 90) {
                if (i >= 97) {
                    i2 = 122;
                    if (i <= i2) {
                    }
                }
                z = false;
            }
            z = true;
        } else {
            if (i >= 48) {
                i2 = 57;
                if (i <= i2) {
                    z = true;
                }
            }
            z = false;
        }
        return z || i == 45 || i == 46 || i == 95 || i == 126;
    }

    public static void A00(String str, BreakIterator breakIterator) {
        int length = str.length();
        int iCurrent = breakIterator.current();
        if (iCurrent >= length || iCurrent == -1) {
            throw new IllegalArgumentException("Hex string must have 2 characters, found 0");
        }
        int iCodePointAt = str.codePointAt(iCurrent);
        if (!A01(iCodePointAt)) {
            StringBuilder sbA09 = AnonymousClass000.A09();
            sbA09.append("First hex string character ");
            throw new IllegalArgumentException(AnonymousClass000.A06(new String(new int[]{iCodePointAt}, 0, 1), " is not a valid hex digit", sbA09));
        }
        int next = breakIterator.next();
        if (next >= length || next == -1) {
            throw new IllegalArgumentException("Hex string must have 2 characters, found 1");
        }
        int iCodePointAt2 = str.codePointAt(next);
        if (A01(iCodePointAt2)) {
            return;
        }
        StringBuilder sbA092 = AnonymousClass000.A09();
        sbA092.append("Second hex string character ");
        throw new IllegalArgumentException(AnonymousClass000.A06(new String(new int[]{iCodePointAt2}, 0, 1), " is not a valid hex digit", sbA092));
    }
}
