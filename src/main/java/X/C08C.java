package X;

import android.os.ConditionVariable;
import java.util.Map;

/* renamed from: X.08C */
/* loaded from: classes.dex */
public abstract class C08C {
    public static final ConditionVariable A00 = new ConditionVariable(true);
    public static final Map A01 = AnonymousClass000.A0C();

    public static void A00() {
        String str;
        ConditionVariable conditionVariable = A00;
        boolean zBlock = conditionVariable.block(-1L);
        Object[] objArr = new Object[1];
        AnonymousClass000.A0N(objArr, conditionVariable.hashCode(), 0);
        if (zBlock) {
            str = "Not blocking Provider (%s)";
        } else {
            C018108b.A0K("InitStatus", "Blocking Provider (%s)", objArr);
            conditionVariable.block();
            objArr = new Object[1];
            AnonymousClass000.A0N(objArr, conditionVariable.hashCode(), 0);
            str = "Unblocked Provider (%s)";
        }
        C018108b.A0K("InitStatus", str, objArr);
    }
}
