package com.facebook.soloader;

import X.C0AD;
import android.content.Context;
import com.facebook.common.stringformat.StringFormatUtil;

/* loaded from: classes.dex */
public class SoLoaderDSONotFoundError extends SoLoaderULError {
    public static SoLoaderDSONotFoundError create(String str, Context context, C0AD[] c0adArr) {
        StringBuilder sb = new StringBuilder("couldn't find DSO to load: ");
        sb.append(str);
        sb.append("\n\texisting SO sources: ");
        for (int i = 0; i < c0adArr.length; i++) {
            sb.append("\n\t\tSoSource ");
            sb.append(i);
            sb.append(": ");
            C0AD c0ad = c0adArr[i];
            sb.append(c0ad != null ? c0ad.toString() : StringFormatUtil.NULL_STRING);
        }
        if (context != null) {
            sb.append("\n\tNative lib dir: ");
            sb.append(context.getApplicationInfo().nativeLibraryDir);
            sb.append("\n");
        }
        return new SoLoaderDSONotFoundError(str, sb.toString());
    }

    public SoLoaderDSONotFoundError(String str, String str2) {
        super(str, str2);
    }

    public SoLoaderDSONotFoundError(String str) {
        super(str);
    }
}
