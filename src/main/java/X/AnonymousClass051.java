package X;

import android.app.Application;
import android.content.SharedPreferences;

/* renamed from: X.051, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass051 {
    public static AnonymousClass051 A01;
    public final SharedPreferences A00;

    public AnonymousClass051(Application application) {
        this.A00 = application.getSharedPreferences("lacrima", 0);
    }
}
