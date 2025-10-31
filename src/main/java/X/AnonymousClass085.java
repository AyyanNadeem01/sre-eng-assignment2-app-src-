package X;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: X.085, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass085 {
    public static final List A01 = Collections.unmodifiableList(Arrays.asList("scheme", "authority", "path", "query"));
    public final Map A00;

    public static AnonymousClass085 A00(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                HashMap mapA0C = AnonymousClass000.A0C();
                for (String str : A01) {
                    if (jSONObject.has(str)) {
                        mapA0C.put(str, AnonymousClass068.A00(jSONObject.get(str)));
                    }
                }
                if (!mapA0C.isEmpty()) {
                    return new AnonymousClass085(mapA0C);
                }
            } catch (JSONException unused) {
                return null;
            }
        }
        return null;
    }

    public AnonymousClass085(Map map) {
        this.A00 = map;
    }
}
