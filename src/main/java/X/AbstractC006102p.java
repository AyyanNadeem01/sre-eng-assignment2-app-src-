package X;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: X.02p, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC006102p {
    public static final String A00;

    public static void A02(Context context, Intent intent, String str) throws JSONException, C013205v {
        String str2;
        try {
            intent.setExtrasClassLoader(context.getClassLoader());
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.setClassLoader(context.getClassLoader());
            try {
                str2 = AnonymousClass009.A01(context, context.getPackageName(), 0).A03;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                str2 = null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            JSONObject jSONObject = new JSONObject();
            String strEncodeToString = null;
            try {
                jSONObject.put("t", Long.toString(jCurrentTimeMillis));
                jSONObject.put("r", Long.toString(jElapsedRealtime));
                if (str != null) {
                    jSONObject.put("d", str);
                }
                if (str2 != null) {
                    jSONObject.put("v", str2);
                }
                strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 11);
            } catch (UnsupportedEncodingException | JSONException unused2) {
            }
            AnonymousClass017 anonymousClass017 = new AnonymousClass017();
            anonymousClass017.A09 = strEncodeToString;
            anonymousClass017.A03 = new ComponentName(context, "com.facebook.invalid_class.f4c3b00c");
            PendingIntent pendingIntentA01 = anonymousClass017.A01(context, 0, 1140850688);
            if (pendingIntentA01 == null) {
                throw new C013205v("Failed to generate CallerInfo metadata.");
            }
            extras.putParcelable("_ci_", pendingIntentA01);
            intent.putExtras(extras);
        } catch (Exception e) {
            throw new C013205v(e);
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Null metadata in caller identity, API=");
        sb.append(Build.VERSION.SDK_INT);
        A00 = sb.toString();
    }

    public static C008703w A00(Context context, Intent intent, AnonymousClass007 anonymousClass007, int i) throws NoSuchAlgorithmException {
        String action;
        if (intent == null) {
            A03(anonymousClass007, "Null launching intent.", null);
            return null;
        }
        try {
            if (!intent.hasExtra("_ci_")) {
                A03(anonymousClass007, "Missing caller identity intent extra.", null);
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("_ci_");
            if (pendingIntent == null) {
                Bundle extras = intent.getExtras();
                if (extras == null || extras.get("_ci_") != null) {
                    A03(anonymousClass007, "Caller identity extra is not a PendingIntent.", null);
                    return null;
                }
                A03(anonymousClass007, "Null caller identity intent extra.", null);
                return null;
            }
            String creatorPackage = pendingIntent.getCreatorPackage();
            int creatorUid = pendingIntent.getCreatorUid();
            if (creatorPackage == null) {
                return null;
            }
            try {
                C000800l c000800lA01 = C04M.A01(context, creatorPackage);
                List listA02 = C04M.A02(C04M.A00(context, creatorPackage));
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        action = (String) PendingIntent.class.getMethod("getTag", String.class).invoke(pendingIntent, "");
                    } else {
                        Intent intent2 = (Intent) PendingIntent.class.getMethod("getIntent", (Class[]) Collections.emptyList().toArray(new Class[0])).invoke(pendingIntent, null);
                        action = intent2 != null ? intent2.getAction() : null;
                    }
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    A03(anonymousClass007, "Error extracting metadata from caller identity.", e);
                    action = null;
                }
                ApplicationInfo applicationInfo = C04M.A00(context, creatorPackage).A00;
                int i2 = applicationInfo != null ? applicationInfo.flags : 0;
                if (action == null) {
                    A03(anonymousClass007, A00, null);
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(Base64.decode(action, 11), "UTF-8"));
                    String string = jSONObject.has("d") ? jSONObject.getString("d") : null;
                    String string2 = jSONObject.has("v") ? jSONObject.getString("v") : null;
                    long j = jSONObject.has("t") ? Long.parseLong(jSONObject.getString("t")) : -1L;
                    long j2 = jSONObject.has("r") ? Long.parseLong(jSONObject.getString("r")) : -1L;
                    long j3 = i;
                    if (System.currentTimeMillis() - j < j3 || SystemClock.elapsedRealtime() - j2 < j3) {
                        return new C008703w(string2, string, Collections.singletonList(creatorPackage), Collections.singletonList(c000800lA01), listA02, creatorUid, i2);
                    }
                    A03(anonymousClass007, "Caller identity has expired.", null);
                    return null;
                } catch (UnsupportedEncodingException | IllegalArgumentException | JSONException e2) {
                    A03(anonymousClass007, "Error parsing metadata from caller identity.", e2);
                    return null;
                }
            } catch (SecurityException e3) {
                A03(anonymousClass007, "Failed to get signature.", e3);
                return null;
            }
        } catch (ClassCastException e4) {
            A03(anonymousClass007, "Failed to parse Intent extras, they are of wrong type.", e4);
            return null;
        }
    }

    public static void A03(AnonymousClass007 anonymousClass007, String str, Throwable th) {
        if (anonymousClass007 != null) {
            anonymousClass007.Ais("CallerInfoHelper", str, th);
        }
    }

    public static void A01(Context context, Intent intent, AnonymousClass007 anonymousClass007, String str) throws JSONException {
        try {
            A02(context, intent, str);
        } catch (C013205v e) {
            anonymousClass007.Ais("CallerInfoHelper", "Error attaching caller info to Intent.", e);
        }
    }
}
