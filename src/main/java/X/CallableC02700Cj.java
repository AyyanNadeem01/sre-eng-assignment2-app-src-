package X;

import android.app.Application;
import com.facebook.common.dextricks.classtracing.logger.ClassTracingLoggerFbLite;
import com.facebook.lite.SharedPreferencesHookA11;
import java.util.concurrent.Callable;

/* renamed from: X.0Cj */
/* loaded from: classes.dex */
public class CallableC02700Cj implements Callable {
    public final int $t;
    public String A00;
    public final Object A01;

    public CallableC02700Cj(Application application, int i) {
        String string;
        this.$t = i;
        this.A01 = application;
        switch (i) {
            case 0:
            case 3:
                string = C08O.A00(application);
                break;
            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
            case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                string = Long.toString(C0C3.A00(application));
                break;
            case 2:
            default:
                string = null;
                break;
        }
        this.A00 = string;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        String string;
        switch (this.$t) {
            case 0:
            case 3:
                return this.A00;
            case SharedPreferencesHookA11.MSG_RUN /* 1 */:
            default:
                string = this.A00;
                break;
            case 2:
                String str = this.A00;
                if (str != null) {
                    return str;
                }
                string = Long.toString(C0C3.A00((Application) this.A01));
                this.A00 = string;
                break;
        }
        return string == null ? "unknown" : string;
    }
}
