package X;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: X.05E, reason: invalid class name */
/* loaded from: classes.dex */
public final class C05E implements InterfaceC02430Ba {
    public static C05E A03;
    public final C04w A00;
    public final C0CK A01;
    public final List A02 = new ArrayList();

    public final void A00(String str, String str2) {
        String strSubstring = "";
        if (str == null || str.equals("")) {
            str = "empty";
        }
        if (str2 == null || str2.equals("")) {
            str2 = "empty";
        }
        C010704r c010704r = this.A01.A02;
        AnonymousClass053.A03(c010704r, "Did you call SessionManager.init()?");
        Object obj = c010704r.A02;
        synchronized (obj) {
            c010704r.A02(3, 80, str, false);
            C010704r.A00(c010704r);
        }
        synchronized (obj) {
            if (str2.length() < 80) {
                c010704r.A02(85, 80, str2, false);
            } else {
                String strSubstring2 = str2.substring(0, 80);
                strSubstring = str2.substring(80);
                c010704r.A02(85, 80, strSubstring2, false);
            }
            c010704r.A02(622, 127, strSubstring, false);
            String str3 = c010704r.A00;
            if (str3 != null) {
                c010704r.A02(1778, 207, str3, false);
            }
            C010704r.A00(c010704r);
            c010704r.A00 = str2;
        }
        C0BX c0bx = C019908u.A04;
        if (c0bx != null) {
            c0bx.A01 = str2;
            SystemClock.uptimeMillis();
        }
        synchronized (C019908u.class) {
            if (!str2.equals(C019908u.A05)) {
                C019908u.A05 = str2;
                final HashSet hashSet = new HashSet(C019908u.A01);
                C019908u.A03.execute(new Runnable() { // from class: X.01i
                    public static final String __redex_internal_original_name = "GlobalAppState$$ExternalSyntheticLambda0";

                    @Override // java.lang.Runnable
                    public final void run() {
                        HashSet hashSet2 = hashSet;
                        boolean z = C019908u.A06;
                        Iterator it = hashSet2.iterator();
                        if (it.hasNext()) {
                            it.next();
                            throw new NullPointerException("onEndpointChanged");
                        }
                    }
                });
            }
        }
        c010704r.A03(SystemClock.uptimeMillis());
        Iterator it = this.A02.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NullPointerException("onEndpointChanged");
        }
    }

    public C05E(C04w c04w, C0CK c0ck) {
        this.A01 = c0ck;
        this.A00 = c04w;
        synchronized (C019908u.class) {
            C019908u.A02.add(this);
        }
    }

    @Override // X.InterfaceC02430Ba
    public final /* synthetic */ AnonymousClass046 AFf() {
        return null;
    }

    @Override // X.InterfaceC02430Ba
    public final EnumC011204x AGX() {
        return EnumC011204x.NAVIGATION;
    }

    @Override // X.InterfaceC02430Ba
    public final void start() {
        A03 = this;
    }
}
