package X;

import android.os.Build;
import com.facebook.common.build.Bit64Mode$LegacySysdeps;
import com.facebook.common.build.Bit64Mode$MarshmallowSysdeps;

/* renamed from: X.04V, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C04V {
    public static final Boolean A00;

    static {
        A00 = Boolean.valueOf(Build.VERSION.SDK_INT >= 23 ? Bit64Mode$MarshmallowSysdeps.is64Bit() : Bit64Mode$LegacySysdeps.is64Bit());
    }

    public static boolean A00() {
        return A00.booleanValue();
    }
}
