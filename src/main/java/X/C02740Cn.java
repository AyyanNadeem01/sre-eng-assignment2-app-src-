package X;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.lite.SharedPreferencesHookA11;
import java.util.UUID;

/* renamed from: X.0Cn */
/* loaded from: classes.dex */
public class C02740Cn implements C09V {
    public final int $t;
    public final Object A00;

    public C02740Cn(Object obj, int i) {
        this.$t = i;
        this.A00 = obj;
    }

    @Override // X.C09V
    public final Object get() {
        switch (this.$t) {
            case 0:
                return C08O.A01(((C02250Ab) this.A00).A0B);
            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                return C08O.A00(((C02250Ab) this.A00).A0B);
            case 2:
                Context context = (Context) this.A00;
                SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), 0);
                String string = sharedPreferences.getString("device_id", null);
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                String string2 = sharedPreferences.getString("primary_dex_device_id_key", null);
                if (!TextUtils.isEmpty(string2)) {
                    return string2;
                }
                String string3 = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("primary_dex_device_id_key", string3).apply();
                return string3;
            default:
                return Long.toString(C0C3.A00((Application) this.A00));
        }
    }
}
