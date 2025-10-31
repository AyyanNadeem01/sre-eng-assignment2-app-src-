package X;

import android.content.Context;

/* renamed from: X.03V, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C03V {
    public static C05T A00(C0CF c0cf) {
        String string;
        int i;
        Context context = c0cf.A00;
        int i2 = context.getSharedPreferences("com.facebook.lite", 0).getInt("early_connection_default_timeout_mills", 0);
        if (i2 == 0 || i2 < 0 || (string = context.getSharedPreferences("com.facebook.lite", 0).getString("early_socket_connection_host", null)) == null || (i = context.getSharedPreferences("com.facebook.lite", 0).getInt("early_socket_connection_port", -1)) == -1) {
            return null;
        }
        return new C05T(new C05O(C05N.A00(context.getSharedPreferences("com.facebook.lite", 0).getString("early_socket_connection_network_protocol", null)), string, i), i2);
    }
}
