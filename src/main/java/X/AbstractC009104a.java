package X;

import android.content.Context;
import android.content.pm.ModuleInfo;
import android.content.pm.PackageManager;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: X.04a, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC009104a {
    public static void A00(Context context, C05C c05c) throws JSONException {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            List<ModuleInfo> installedModules = packageManager.getInstalledModules(0);
            JSONObject jSONObject = new JSONObject();
            Iterator<ModuleInfo> it = installedModules.iterator();
            while (it.hasNext()) {
                String packageName = it.next().getPackageName();
                if (packageName != null) {
                    try {
                        jSONObject.put(packageName, packageManager.getPackageInfo(packageName, 1073741824).getLongVersionCode());
                    } catch (PackageManager.NameNotFoundException | JSONException unused) {
                    }
                }
            }
            c05c.A04(AnonymousClass094.A7o, jSONObject.toString());
        }
    }
}
