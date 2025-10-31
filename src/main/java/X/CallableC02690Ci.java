package X;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.lite.ClientApplicationSplittedShell;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.concurrent.Callable;

/* renamed from: X.0Ci */
/* loaded from: classes.dex */
public class CallableC02690Ci implements Callable {
    public final int $t;
    public final Object A00;
    public final Object A01;

    public CallableC02690Ci(Application application, int i) {
        this.$t = i;
        this.A01 = application;
        this.A00 = application.getDir("errorreporting", 0);
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.$t != 0) {
            return this.A00;
        }
        C09c c09c = new C09c();
        AbstractC016807j.A09 = c09c;
        try {
            Context context = (Context) this.A01;
            File fileA02 = AnonymousClass000.A02(C0AP.A00(context, 1436876361), "versions");
            int iA00 = AbstractC017707t.A00();
            File fileA022 = AnonymousClass000.A02(fileA02, Integer.toString(iA00));
            if (fileA022.exists()) {
                if (iA00 == 1) {
                    try {
                        if (fileA022.lastModified() / 1000 < context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime / 1000) {
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        throw AnonymousClass000.A04("Can't get package info for this package.");
                    }
                }
                c09c.close();
                return null;
            }
            Integer numValueOf = Integer.valueOf(iA00);
            try {
                int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                if (i != iA00) {
                    Locale locale = Locale.US;
                    Object[] objArr = new Object[2];
                    AnonymousClass000.A0N(objArr, i, 0);
                    objArr[1] = numValueOf;
                    C018108b.A09("AppComponentManager", String.format(locale, "Android PackageManager returned version code: %d, apk version code is: %d", objArr));
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                throw AnonymousClass000.A04("Can't get package info for this package.");
            }
            C07V.A03(context);
            c09c.close();
            return null;
        } catch (Throwable th) {
            try {
                c09c.close();
                throw th;
            } catch (Throwable th2) {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                throw th;
            }
        }
    }

    public CallableC02690Ci(Context context, ClientApplicationSplittedShell clientApplicationSplittedShell) {
        this.$t = 0;
        this.A00 = clientApplicationSplittedShell;
        this.A01 = context;
    }
}
