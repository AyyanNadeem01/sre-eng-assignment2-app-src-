package com.facebook.errorreporting.lacrima.common.check;

import X.AnonymousClass000;
import X.AnonymousClass094;
import X.C021209l;
import X.C08v;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class DirectReports {
    public static void A00(String str, String str2, String str3, String str4, Throwable th, Map map) throws IOException {
        HashMap mapA0C = AnonymousClass000.A0C();
        mapA0C.putAll(map);
        C021209l.A03(str, str2, str3, str4, mapA0C);
        C021209l.A02(AnonymousClass094.A4k, "j", mapA0C);
        if (th != null) {
            C021209l.A02(AnonymousClass094.A6n, C08v.A01(th), mapA0C);
        }
        C021209l.A00().A06("android_critical_java", mapA0C);
        C021209l.A05(mapA0C);
        C021209l.A00().A06("android_large_java", mapA0C);
    }
}
