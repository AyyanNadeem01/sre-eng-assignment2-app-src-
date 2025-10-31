package X;

import java.io.Serializable;
import java.util.Arrays;

/* renamed from: X.00l, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C000800l implements Serializable {
    public String A00;
    public String A01;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.A01});
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C000800l) {
            return this.A01.equals(((C000800l) obj).A01);
        }
        return false;
    }

    public C000800l(String str) {
        if (str.length() != 43) {
            throw new SecurityException("Invalid SHA256 key hash - should be 256-bit.");
        }
        this.A01 = str;
    }
}
