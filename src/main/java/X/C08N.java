package X;

import android.app.ActivityThread;
import android.text.TextUtils;
import android.util.Pair;

/* renamed from: X.08N, reason: invalid class name */
/* loaded from: classes.dex */
public final class C08N {
    public static volatile C08N A02;
    public final C08M A00;
    public final String A01;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.A01;
        String str2 = ((C08N) obj).A01;
        return str == null ? str2 == null : str.equals(str2);
    }

    public static C08N A00() {
        C08N c08n;
        C08N c08n2 = A02;
        if (c08n2 != null) {
            return c08n2;
        }
        synchronized (C08N.class) {
            c08n = A02;
            if (c08n == null) {
                ActivityThread activityThreadA00 = AbstractC019608r.A00();
                if (activityThreadA00 != null) {
                    c08n = A01(activityThreadA00.getProcessName());
                    A02 = c08n;
                    if (TextUtils.isEmpty(c08n.A01)) {
                        Pair pairA00 = C08T.A00();
                        if (TextUtils.isEmpty((CharSequence) pairA00.first)) {
                            c08n = A02;
                        } else {
                            c08n = A01((String) pairA00.first);
                            A02 = c08n;
                        }
                    }
                } else {
                    c08n = new C08N(null, null);
                }
            }
        }
        return c08n;
    }

    public static C08N A01(String str) {
        String str2;
        if (str == null) {
            return new C08N(null, null);
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length > 1) {
            str2 = strArrSplit[1];
            if (str2 == null) {
                throw new IllegalArgumentException("Invalid name");
            }
        } else {
            str2 = "";
        }
        return new C08N("".equals(str2) ? C08M.A01 : new C08M(str2), str);
    }

    public final int hashCode() {
        String str = this.A01;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        String str = this.A01;
        return str == null ? "<unknown>" : str;
    }

    public C08N(C08M c08m, String str) {
        this.A01 = str;
        this.A00 = c08m;
    }

    public C08N() {
        this(null, null);
    }
}
