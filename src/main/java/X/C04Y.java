package X;

import android.os.Build;
import android.os.SystemProperties;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: X.04Y, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C04Y {
    public static final Map A00 = new HashMap<String, String>() { // from class: X.04Z
        {
            put("31", "build.version.extensions.r");
            put("32", "build.version.extensions.s");
            put("33", "build.version.extensions.tiramisu");
        }
    };

    public static JSONObject A00() throws JSONException {
        Map mapA00;
        JSONObject jSONObject = new JSONObject();
        if (Build.VERSION.SDK_INT >= 31) {
            mapA00 = C05M.A00();
        } else {
            try {
                mapA00 = (Map) SdkExtensions.class.getMethod("getAllExtensionVersions", null).invoke(null, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                C0C5.A00();
                mapA00 = null;
            }
        }
        if (mapA00 != null) {
            for (Map.Entry entry : mapA00.entrySet()) {
                try {
                    jSONObject.put(entry.getKey().toString(), entry.getValue().toString());
                } catch (JSONException unused2) {
                    C0C5.A00();
                }
            }
        }
        if (jSONObject.length() == 0) {
            jSONObject = new JSONObject();
            try {
                for (Map.Entry entry2 : A00.entrySet()) {
                    String str = SystemProperties.get((String) entry2.getValue(), "");
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put((String) entry2.getKey(), str);
                    }
                }
            } catch (JSONException unused3) {
                C0C5.A00();
            }
        }
        return jSONObject;
    }
}
