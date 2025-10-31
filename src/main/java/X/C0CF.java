package X;

import android.content.Context;

/* renamed from: X.0CF, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0CF {
    public static C0CF A01;
    public static boolean A02;
    public final Context A00;

    public final long A00() {
        return this.A00.getSharedPreferences("com.facebook.lite", 0).getLong("current_user_id", 0L);
    }

    public C0CF(Context context) {
        this.A00 = context;
    }
}
