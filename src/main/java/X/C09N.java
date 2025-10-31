package X;

import android.os.Process;
import java.io.IOException;

/* renamed from: X.09N, reason: invalid class name */
/* loaded from: classes.dex */
public final class C09N {
    public final StringBuilder A00;

    public static C09N A00(String str, char c) {
        C09N c09n = new C09N(c);
        c09n.A02(Process.myPid());
        c09n.A00.append('|');
        c09n.A03(str);
        return c09n;
    }

    public static void A01(C09N c09n) throws IOException {
        C09L.A00(c09n.A00.toString());
    }

    public final void A02(int i) {
        StringBuilder sb = this.A00;
        sb.append('|');
        sb.append(i);
    }

    public final void A04(String[] strArr, int i) {
        StringBuilder sb = this.A00;
        sb.append('|');
        for (int i2 = 1; i2 < i; i2 += 2) {
            String str = strArr[i2 - 1];
            String str2 = strArr[i2];
            sb.append(str);
            sb.append('=');
            sb.append(str2);
            if (i2 < i - 1) {
                sb.append(';');
            }
        }
    }

    public final String toString() {
        return this.A00.toString();
    }

    public C09N(char c) {
        StringBuilder sb = new StringBuilder(1024);
        this.A00 = sb;
        sb.append(c);
    }

    public final void A03(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            StringBuilder sb = this.A00;
            char cCharAt = str.charAt(i);
            if (cCharAt == 0 || cCharAt == '\r' || cCharAt == ';' || cCharAt == '|' || cCharAt == '\t' || cCharAt == '\n') {
                cCharAt = ' ';
            }
            sb.append(cCharAt);
        }
    }
}
