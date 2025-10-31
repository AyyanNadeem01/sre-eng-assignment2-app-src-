package X;

import java.util.Arrays;
import java.util.List;

/* renamed from: X.04K, reason: invalid class name */
/* loaded from: classes.dex */
public final class C04K {
    public static int A00;
    public static C02240Aa A01;
    public static final List A04 = Arrays.asList("media", "mms", "mms-sms", "sms");
    public static final List A03 = Arrays.asList("com.android.", "com.google.android.");
    public static C04L[] A02 = new C04L[8];

    /* JADX WARN: Multi-variable type inference failed */
    public static void A00(final Integer num, final String str) {
        C02240Aa c02240Aa;
        C04L[] c04lArr;
        int i;
        synchronized (C04K.class) {
            c02240Aa = A01;
            c04lArr = A02;
            i = A00;
            if (c04lArr != 0) {
                A00 = i + 1;
            }
        }
        if (c02240Aa != null) {
            c02240Aa.A00(num, str);
        } else {
            if (c04lArr == 0 || i >= c04lArr.length) {
                return;
            }
            c04lArr[i] = new Object(num, str) { // from class: X.04L
                public final Integer A00;
                public final String A01;

                {
                    this.A00 = num;
                    this.A01 = str;
                }
            };
        }
    }
}
