package X;

import com.facebook.common.dextricks.classtracing.logger.ClassTracingLoggerFbLite;
import com.facebook.lite.SharedPreferencesHookA11;

/* renamed from: X.04s, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC010804s {
    public static char A00(Integer num) {
        switch (num.intValue()) {
            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                return 'f';
            case 2:
                return 's';
            case 3:
                return 'e';
            case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                return 'c';
            case 5:
                return 'p';
            case 6:
                return 't';
            case 7:
                return 'd';
            case 8:
                return 'b';
            case 9:
                return 'l';
            case 10:
                return 'i';
            case 11:
                return '?';
            case 12:
                return 'x';
            default:
                return 'r';
        }
    }
}
