package X;

import android.content.Context;
import android.net.NetworkInfo;
import com.facebook.common.dextricks.classtracing.logger.ClassTracingLoggerFbLite;
import com.facebook.lite.SharedPreferencesHookA11;

/* renamed from: X.05Q, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C05Q {
    public static Integer A00(Context context) {
        C05S c05sA01 = C05R.A01(context);
        if (c05sA01 != null) {
            NetworkInfo networkInfo = c05sA01.A00;
            if (networkInfo.isConnected()) {
                if (networkInfo.getType() == 1) {
                    return AnonymousClass065.A0h;
                }
                if (networkInfo.getType() == 0) {
                    switch (networkInfo.getSubtype()) {
                        case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                        case 2:
                        case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                        case 7:
                        case 11:
                            return AnonymousClass065.A0C;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return AnonymousClass065.A0N;
                        case 13:
                            return AnonymousClass065.A0Y;
                    }
                }
                return AnonymousClass065.A01;
            }
        }
        return AnonymousClass065.A00;
    }

    public static boolean A01(Context context) {
        C05W c05wA00 = C05W.A00(context);
        if (c05wA00 != null) {
            return c05wA00.A03();
        }
        C015606v.A01();
        if (C015606v.A04(context, 70)) {
            C05S c05sA02 = C05R.A02(context, 0);
            if (c05sA02 != null && c05sA02.A00.isConnectedOrConnecting()) {
                return true;
            }
            C05S c05sA022 = C05R.A02(context, 1);
            if (c05sA022 != null && c05sA022.A00.isConnectedOrConnecting()) {
                return true;
            }
            C05S c05sA023 = C05R.A02(context, 6);
            return c05sA023 != null && c05sA023.A00.isConnectedOrConnecting();
        }
        C05S c05sA024 = C05R.A02(context, 0);
        C05S c05sA025 = C05R.A02(context, 1);
        C05S c05sA026 = C05R.A02(context, 6);
        if (c05sA024 != null && c05sA024.A00.isConnectedOrConnecting()) {
            return true;
        }
        if (c05sA025 == null || !c05sA025.A00.isConnectedOrConnecting()) {
            return c05sA026 != null && c05sA026.A00.isConnectedOrConnecting();
        }
        return true;
    }

    public static boolean A02(Context context) {
        C05S c05sA02;
        C05W c05wA00 = C05W.A00(context);
        if (c05wA00 != null) {
            return c05wA00.A04();
        }
        C015606v.A01();
        if (!C015606v.A04(context, 70)) {
            return A01(context) && (c05sA02 = C05R.A02(context, 1)) != null && c05sA02.A00.isConnectedOrConnecting();
        }
        C05S c05sA022 = C05R.A02(context, 1);
        return c05sA022 != null && c05sA022.A00.isConnectedOrConnecting();
    }
}
