package com.facebook.systrace;

import X.C021309n;
import X.C09S;
import X.C09U;
import X.C09X;
import X.C09Y;

/* loaded from: classes.dex */
public abstract class SystraceMessage {
    public static final C09X A00 = new C09U();
    public static final ThreadLocal A01 = new ThreadLocal() { // from class: X.09o
        @Override // java.lang.ThreadLocal
        public final /* bridge */ /* synthetic */ Object initialValue() {
            return new C09S();
        }
    };
    public static final C09Y A02 = new C09Y();

    public static C09X A00(String str) {
        C09Y c09y = A02;
        if (!Systrace.A0G(281474976710656L)) {
            return A00;
        }
        C09S c09s = (C09S) A01.get();
        c09s.A00 = 281474976710656L;
        c09s.A02 = c09y;
        c09s.A03 = str;
        C021309n c021309n = c09s.A01;
        for (int i = 0; i < c021309n.A00; i++) {
            c021309n.A01[i] = null;
        }
        c021309n.A00 = 0;
        return c09s;
    }
}
