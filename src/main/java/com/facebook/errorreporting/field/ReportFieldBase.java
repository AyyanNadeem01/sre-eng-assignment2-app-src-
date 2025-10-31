package com.facebook.errorreporting.field;

import X.2Ac;
import X.C020208z;
import X.C06E;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class ReportFieldBase {
    public static int autoId = 1;
    public int id;
    public final String name;
    public final boolean requiresConsent;
    public static final C020208z Companion = new C020208z();
    public static final Set sNoConsentNeeded = new HashSet();

    public ReportFieldBase(int i, String str, boolean z) {
        C06E.A07(str, 2);
        this.id = i;
        this.name = str;
        this.requiresConsent = z;
        int i2 = autoId;
        if (i == 0) {
            autoId = i2 + 1;
            this.id = i2;
        } else {
            autoId = Math.max(i2, i + 1);
        }
        if (z) {
            return;
        }
        sNoConsentNeeded.add(str);
    }

    public static final String getUnmarkedKey(String str) {
        C06E.A07(str, 0);
        return str;
    }

    public static final boolean requiresConsent(String str) {
        C06E.A07(str, 0);
        return !sNoConsentNeeded.contains(str);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getRequiresConsent() {
        return this.requiresConsent;
    }

    public final boolean isRequiresConsent() {
        return this.requiresConsent;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public /* synthetic */ ReportFieldBase(int i, String str, boolean z, int i2, 2Ac r6) {
        this(i, str, (i2 & 4) != 0 ? true : z);
    }
}
