package X;

import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: X.068, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass068 {
    public final Pattern A00;
    public final boolean A01;

    public static AnonymousClass068 A00(Object obj) {
        Pattern patternCompile = Pattern.compile("");
        boolean z = false;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.has("pattern")) {
                patternCompile = Pattern.compile(jSONObject.getString("pattern"), 32);
                if (jSONObject.has("negation") && jSONObject.getString("negation").equalsIgnoreCase("true")) {
                    z = true;
                }
            }
        } else if (obj instanceof String) {
            patternCompile = Pattern.compile((String) obj, 32);
        }
        return new AnonymousClass068(patternCompile, z);
    }

    public static boolean A01(AnonymousClass068 anonymousClass068, CharSequence charSequence) {
        return anonymousClass068.A00.matcher(charSequence).matches() ^ anonymousClass068.A01;
    }

    public AnonymousClass068(Pattern pattern, boolean z) {
        this.A00 = pattern;
        this.A01 = z;
    }

    public AnonymousClass068() {
        this(Pattern.compile(""), false);
    }
}
