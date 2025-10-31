package X;

/* renamed from: X.04m, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC010304m {
    public static boolean A00(char c) {
        return 'r' == c || 'c' == c || 's' == c || 'e' == c || 'p' == c || 'f' == c;
    }

    public static boolean A01(Integer num, char c) {
        for (EnumC011004u enumC011004u : EnumC011004u.values()) {
            if (enumC011004u.A01 == c) {
                return enumC011004u.A00 == num;
            }
        }
        return false;
    }
}
