package com.facebook.soloader;

import X.AbstractC02460Bh;
import X.AnonymousClass000;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class SoLoaderULErrorFactory {
    public static boolean corruptedLibName(String str) {
        Matcher matcher = Pattern.compile("\\P{ASCII}+").matcher(str);
        if (!matcher.find()) {
            return false;
        }
        Log.w("SoLoader", AnonymousClass000.A06("Library name is corrupted, contains non-ASCII characters ", matcher.group(), AnonymousClass000.A09()));
        return true;
    }

    public static SoLoaderULError create(String str, UnsatisfiedLinkError unsatisfiedLinkError) {
        SoLoaderULError soLoaderULError;
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append(" (soName: ");
        sbA09.append(str);
        String strA07 = AnonymousClass000.A07(")", sbA09);
        if (unsatisfiedLinkError.getMessage() != null && unsatisfiedLinkError.getMessage().contains("ELF")) {
            AbstractC02460Bh.A00("SoLoader");
            soLoaderULError = new SoLoaderCorruptedLibFileError(str, AnonymousClass000.A06(unsatisfiedLinkError.toString(), strA07, AnonymousClass000.A09()));
        } else if (corruptedLibName(str)) {
            AbstractC02460Bh.A00("SoLoader");
            StringBuilder sbA092 = AnonymousClass000.A09();
            sbA092.append("corrupted lib name: ");
            soLoaderULError = new SoLoaderCorruptedLibNameError(str, AnonymousClass000.A06(unsatisfiedLinkError.toString(), strA07, sbA092));
        } else {
            soLoaderULError = new SoLoaderULError(str, AnonymousClass000.A06(unsatisfiedLinkError.toString(), strA07, AnonymousClass000.A09()));
        }
        soLoaderULError.initCause(unsatisfiedLinkError);
        return soLoaderULError;
    }
}
