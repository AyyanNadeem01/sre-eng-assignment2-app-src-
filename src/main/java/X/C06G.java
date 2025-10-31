package X;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: X.06G */
/* loaded from: classes.dex */
public final class C06G {
    public final Map A00;
    public final AnonymousClass085 A01;
    public final C06D[] A02;

    public static C06G A00(JSONObject jSONObject) {
        String string;
        if (jSONObject == null) {
            return null;
        }
        HashMap mapA0C = AnonymousClass000.A0C();
        C06D[] c06dArrA01 = new C06D[0];
        try {
            Iterator<String> itKeys = jSONObject.keys();
            AnonymousClass085 anonymousClass085A00 = null;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!next.equals("selector_config")) {
                    if (next.equals("clip_data")) {
                        anonymousClass085A00 = AnonymousClass085.A00(jSONObject.getJSONObject("clip_data"));
                    } else if (jSONObject.has(next)) {
                        mapA0C.put(next, AnonymousClass068.A00(jSONObject.get(next)));
                    }
                }
            }
            if (jSONObject.has("selector_config") && (string = jSONObject.getString("selector_config")) != null) {
                c06dArrA01 = C06D.A01(string);
            }
            if (mapA0C.isEmpty()) {
                return null;
            }
            return c06dArrA01.length > 0 ? new C06G(anonymousClass085A00, mapA0C, c06dArrA01) : new C06G(anonymousClass085A00, mapA0C, null);
        } catch (IllegalArgumentException | JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:211:0x0106, code lost:
    
        r6 = r13.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0108, code lost:
    
        if (r6 == null) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x010e, code lost:
    
        if (r15.has("clip_data") == false) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0110, code lost:
    
        r7 = r15.getJSONArray("clip_data");
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0114, code lost:
    
        if (r7 == null) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0116, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x011b, code lost:
    
        if (r5 >= r7.length()) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x011d, code lost:
    
        r4 = r7.getJSONObject(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0121, code lost:
    
        r3 = r6.A00.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x012f, code lost:
    
        if (r3.hasNext() == false) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0131, code lost:
    
        r0 = (java.util.Map.Entry) r3.next();
        r2 = (java.lang.String) r0.getKey();
        r1 = (X.AnonymousClass068) r0.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0147, code lost:
    
        if (r4.has(r2) == false) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0151, code lost:
    
        if (X.AnonymousClass068.A01(r1, r4.getString(r2)) != false) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0156, code lost:
    
        r3 = r13.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0158, code lost:
    
        if (r3 == null) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x015a, code lost:
    
        r2 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x015b, code lost:
    
        if (r2 <= 0) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x015d, code lost:
    
        if (r14 == null) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x015f, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0166, code lost:
    
        if (r3[r1].A02(r14) == false) goto L283;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0168, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x016a, code lost:
    
        if (r1 >= r2) goto L284;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0170, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A01(android.content.Intent r14, org.json.JSONObject r15) throws org.json.JSONException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C06G.A01(android.content.Intent, org.json.JSONObject):boolean");
    }

    public C06G(AnonymousClass085 anonymousClass085, Map map, C06D[] c06dArr) {
        this.A00 = map;
        this.A02 = c06dArr;
        this.A01 = anonymousClass085;
    }
}
