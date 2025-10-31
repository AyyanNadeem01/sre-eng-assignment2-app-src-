package X;

import com.facebook.common.stringformat.StringFormatUtil;
import java.util.regex.Matcher;

/* renamed from: X.01h, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC002701h {
    public static String A00(String str, Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            str = str.replaceFirst("\\{\\}", obj != null ? Matcher.quoteReplacement(obj.toString()) : StringFormatUtil.NULL_STRING);
        }
        return str;
    }
}
