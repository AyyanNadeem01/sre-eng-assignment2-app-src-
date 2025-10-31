package X;

import android.app.Application;
import android.content.Context;
import com.facebook.lite.SharedPreferencesHookA11;
import java.util.concurrent.Callable;

/* renamed from: X.0Ch, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public class CallableC02680Ch implements Callable {
    public final int $t;
    public final Object A00;

    public CallableC02680Ch(Object obj, int i) {
        this.$t = i;
        this.A00 = obj;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.$t) {
            case 0:
                return AbstractC018908k.A00();
            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                C0C3.A00((Application) this.A00);
                return null;
            case 2:
                return C08O.A00((Context) this.A00);
            default:
                return ((Context) this.A00).getDir("errorreporting", 0);
        }
    }
}
