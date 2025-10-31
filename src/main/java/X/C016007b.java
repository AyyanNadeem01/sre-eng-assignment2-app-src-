package X;

import java.util.Arrays;

/* renamed from: X.07b, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C016007b {
    public final String A00;
    public final String A01;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C016007b c016007b = (C016007b) obj;
            if (!this.A00.equals(c016007b.A00) || !this.A01.equals(c016007b.A01)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.A00, this.A01});
    }

    public C016007b(String str, String str2) {
        this.A00 = str;
        this.A01 = str2;
    }
}
