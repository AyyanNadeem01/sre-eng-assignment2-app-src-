package X;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.webkit.URLUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: X.06D, reason: invalid class name */
/* loaded from: classes.dex */
public final class C06D {
    public static final C06D[] A04 = new C06D[0];
    public final C06G A00;
    public final C06G A01;
    public final AnonymousClass085 A02;
    public final Pattern A03;

    public static C09H A00(Intent intent) throws JSONException {
        Object obj;
        Object obj2;
        Uri uri;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayListA0B = AnonymousClass000.A0B();
        jSONObject.put("action", intent.getAction());
        jSONObject.put("package", intent.getPackage());
        jSONObject.put("type", intent.getType());
        Uri data = intent.getData();
        if (data != null) {
            arrayListA0B.add(data);
            jSONObject.put("data", AnonymousClass086.A00(data.getAuthority(), C07R.A00(data, null), C07R.A01(data, null), data.getScheme()));
        }
        ClipData clipData = intent.getClipData();
        if (clipData != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < clipData.getItemCount(); i++) {
                ClipData.Item itemAt = clipData.getItemAt(i);
                if (itemAt != null && (uri = itemAt.getUri()) != null) {
                    arrayListA0B.add(uri);
                    jSONArray.put(AnonymousClass086.A00(uri.getAuthority(), C07R.A00(uri, null), C07R.A01(uri, null), uri.getScheme()));
                }
            }
            jSONObject.put("clip_data", jSONArray);
        }
        Set<String> categories = intent.getCategories();
        if (categories != null && !categories.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it = categories.iterator();
            while (it.hasNext()) {
                jSONArray2.put(it.next());
            }
            jSONObject.put("categories", jSONArray2);
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            jSONObject.put("component_name", component.toString());
        }
        Rect sourceBounds = intent.getSourceBounds();
        if (sourceBounds != null) {
            jSONObject.put("source_bounds", sourceBounds.toString());
        }
        Bundle extras = intent.getExtras();
        if (extras != null && extras.size() > 0) {
            JSONArray jSONArray3 = new JSONArray();
            for (String str : extras.keySet()) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    obj2 = extras.get(str);
                } catch (BadParcelableException unused) {
                    obj2 = null;
                }
                String canonicalName = obj2 != null ? obj2.getClass().getCanonicalName() : "";
                jSONObject2.put("name", str);
                jSONObject2.put("value_type", canonicalName);
                if (obj2 != null) {
                    URLUtil.isValidUrl(obj2.toString());
                }
                jSONArray3.put(jSONObject2);
            }
            jSONObject.put("extra_names", jSONArray3);
        }
        Intent selector = intent.getSelector();
        if (selector != null && (obj = A00(selector).A01) != null) {
            jSONObject.put("selector", obj);
        }
        if (intent.getFlags() > 0) {
            jSONObject.put("flags", intent.getFlags());
        }
        C09H c09h = new C09H();
        c09h.A01 = jSONObject;
        c09h.A00 = arrayListA0B;
        return c09h;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0019, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A02(android.content.Intent r10) {
        /*
            r9 = this;
            r8 = 0
            if (r10 == 0) goto La1
            X.09H r4 = A00(r10)     // Catch: org.json.JSONException -> La0
            java.util.List r1 = r4.A00     // Catch: org.json.JSONException -> La0
            X.085 r3 = r9.A02     // Catch: org.json.JSONException -> La0
            if (r3 == 0) goto L8b
            if (r1 == 0) goto La1
            boolean r0 = r1.isEmpty()     // Catch: org.json.JSONException -> La0
            if (r0 != 0) goto La1
            java.util.Iterator r7 = r1.iterator()     // Catch: org.json.JSONException -> La0
        L19:
            boolean r0 = r7.hasNext()     // Catch: org.json.JSONException -> La0
            if (r0 == 0) goto La1
            java.lang.Object r2 = r7.next()     // Catch: org.json.JSONException -> La0
            android.net.Uri r2 = (android.net.Uri) r2     // Catch: org.json.JSONException -> La0
            java.util.Map r0 = r3.A00     // Catch: org.json.JSONException -> La0
            java.util.Set r0 = r0.entrySet()     // Catch: org.json.JSONException -> La0
            java.util.Iterator r6 = r0.iterator()     // Catch: org.json.JSONException -> La0
        L2f:
            boolean r0 = r6.hasNext()     // Catch: org.json.JSONException -> La0
            if (r0 == 0) goto L8b
            java.lang.Object r5 = r6.next()     // Catch: org.json.JSONException -> La0
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: org.json.JSONException -> La0
            java.lang.Object r1 = r5.getKey()     // Catch: org.json.JSONException -> La0
            java.lang.String r1 = (java.lang.String) r1     // Catch: org.json.JSONException -> La0
            int r0 = r1.hashCode()     // Catch: org.json.JSONException -> La0
            switch(r0) {
                case -907987547: goto L49;
                case 3433509: goto L56;
                case 107944136: goto L63;
                case 1475610435: goto L70;
                default: goto L48;
            }     // Catch: org.json.JSONException -> La0
        L48:
            goto L19
        L49:
            java.lang.String r0 = "scheme"
            boolean r0 = r1.equals(r0)     // Catch: org.json.JSONException -> La0
            if (r0 == 0) goto L19
            java.lang.String r1 = r2.getScheme()     // Catch: org.json.JSONException -> La0
            goto L7c
        L56:
            java.lang.String r0 = "path"
            boolean r0 = r1.equals(r0)     // Catch: org.json.JSONException -> La0
            if (r0 == 0) goto L19
            java.lang.String r1 = r2.getPath()     // Catch: org.json.JSONException -> La0
            goto L7c
        L63:
            java.lang.String r0 = "query"
            boolean r0 = r1.equals(r0)     // Catch: org.json.JSONException -> La0
            if (r0 == 0) goto L19
            java.lang.String r1 = r2.getQuery()     // Catch: org.json.JSONException -> La0
            goto L7c
        L70:
            java.lang.String r0 = "authority"
            boolean r0 = r1.equals(r0)     // Catch: org.json.JSONException -> La0
            if (r0 == 0) goto L19
            java.lang.String r1 = r2.getAuthority()     // Catch: org.json.JSONException -> La0
        L7c:
            if (r1 == 0) goto L19
            java.lang.Object r0 = r5.getValue()     // Catch: org.json.JSONException -> La0
            X.068 r0 = (X.AnonymousClass068) r0     // Catch: org.json.JSONException -> La0
            boolean r0 = X.AnonymousClass068.A01(r0, r1)     // Catch: org.json.JSONException -> La0
            if (r0 != 0) goto L2f
            goto L19
        L8b:
            org.json.JSONObject r2 = r4.A01     // Catch: org.json.JSONException -> La0
            android.content.Intent r1 = r10.getSelector()     // Catch: org.json.JSONException -> La0
            X.06G r0 = r9.A01     // Catch: org.json.JSONException -> La0
            if (r0 == 0) goto L9e
            if (r2 == 0) goto La1
            boolean r0 = r0.A01(r1, r2)     // Catch: org.json.JSONException -> La0
            if (r0 != 0) goto L9e
            return r8
        L9e:
            r8 = 1
            return r8
        La0:
            return r8
        La1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C06D.A02(android.content.Intent):boolean");
    }

    public static C06D[] A01(String str) {
        if (str == null) {
            return A04;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                C06D[] c06dArr = new C06D[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    C06G c06gA00 = null;
                    String string = jSONObject.has("endpoint_name") ? jSONObject.getString("endpoint_name") : null;
                    C06G c06gA002 = jSONObject.has("caller_info") ? C06G.A00(jSONObject.getJSONObject("caller_info")) : null;
                    AnonymousClass085 anonymousClass085A00 = jSONObject.has("uri_component") ? AnonymousClass085.A00(jSONObject.getJSONObject("uri_component")) : null;
                    if (jSONObject.has("intent_field")) {
                        c06gA00 = C06G.A00(jSONObject.getJSONObject("intent_field"));
                    }
                    c06dArr[i] = new C06D(c06gA002, c06gA00, anonymousClass085A00, string);
                }
                return c06dArr;
            }
        } catch (JSONException unused) {
        }
        return A04;
    }

    public C06D(C06G c06g, C06G c06g2, AnonymousClass085 anonymousClass085, String str) {
        this.A03 = str == null ? null : Pattern.compile(str, 32);
        this.A01 = c06g2;
        this.A00 = c06g;
        this.A02 = anonymousClass085;
    }
}
