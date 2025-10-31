package X;

import android.text.TextUtils;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: X.086, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class AnonymousClass086 {
    public static final C017607r A00 = new C017607r(Collections.emptyList(), AnonymousClass000.A0B(), false, false);

    public static JSONObject A00(String str, String str2, String str3, String str4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("scheme", str4);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("authority", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("path", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("query", str3);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
