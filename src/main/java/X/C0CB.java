package X;

import android.text.TextUtils;
import java.nio.CharBuffer;

/* renamed from: X.0CB, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0CB {
    public final String A00;
    public final String A01;
    public final String A02;

    public C0CB(String str, String str2) {
        this.A02 = str;
        this.A00 = str2;
        this.A01 = null;
    }

    public static void A00(CharBuffer charBuffer) throws NumberFormatException {
        int iLimit = charBuffer.limit() - charBuffer.position();
        if (iLimit >= 4 || iLimit <= 0) {
            throw new IllegalArgumentException("IPV4 octet must contain between 1 and 3 digits");
        }
        try {
            int i = Integer.parseInt(charBuffer.toString(), 10);
            if (i < 0 || i > 255) {
                throw new IllegalArgumentException(AnonymousClass000.A08("IPV4 octet value must be between 0 and 255, got ", AnonymousClass000.A09(), i));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AnonymousClass000.A05(charBuffer, "Unable to parse decimal octet ", AnonymousClass000.A09()), e);
        }
    }

    public final String toString() {
        StringBuilder sbA09 = AnonymousClass000.A09();
        if (!TextUtils.isEmpty(this.A02)) {
            sbA09.append("<REDACTED>");
            sbA09.append("@");
        }
        String str = this.A00;
        if (!TextUtils.isEmpty(str)) {
            sbA09.append(str);
        }
        String str2 = this.A01;
        if (!TextUtils.isEmpty(str2)) {
            sbA09.append(":");
            sbA09.append(str2);
        }
        return sbA09.toString();
    }

    public C0CB(String str, String str2, String str3) {
        this.A02 = str;
        this.A00 = str2;
        this.A01 = str3;
    }
}
