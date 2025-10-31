package X;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: X.017, reason: invalid class name */
/* loaded from: classes.dex */
public class AnonymousClass017 {
    public AnonymousClass007 A08;
    public ComponentName A03 = null;
    public String A0A = null;
    public String A09 = null;
    public Uri A06 = null;
    public String A0B = null;
    public Rect A05 = null;
    public Intent A04 = null;
    public ClipData A02 = null;
    public Bundle A07 = null;
    public final Set A0D = new HashSet();
    public int A00 = 0;
    public long A01 = 0;
    public boolean A0C = false;

    public final int A00(int i) {
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 23) {
            return i;
        }
        if ((8 & this.A01) != 0) {
            i &= -67108865;
            if (i3 <= 30) {
                return i;
            }
            i2 = 33554432;
        } else {
            if (i3 > 30) {
                i &= -33554433;
            }
            i2 = 67108864;
        }
        return i | i2;
    }

    public Intent A04(Context context) {
        String packageName;
        Intent intent = new Intent();
        intent.setComponent(this.A03);
        intent.setFlags(this.A00);
        if (this.A0C) {
            intent.setComponent(new ComponentName(context, "com.facebook.invalid_class.f4c3b00c"));
            packageName = context.getPackageName();
        } else {
            intent.setAction(this.A09);
            intent.setDataAndType(this.A06, this.A0B);
            intent.setSourceBounds(this.A05);
            intent.setSelector(this.A04);
            intent.setClipData(this.A02);
            Iterator it = this.A0D.iterator();
            while (it.hasNext()) {
                intent.addCategory((String) it.next());
            }
            if (this.A07 != null) {
                intent.setExtrasClassLoader(context.getClassLoader());
                intent.putExtras(this.A07);
            }
            long j = this.A01;
            if ((1 & j) != 0) {
                if ((4 & j) == 0) {
                    String packageName2 = this.A0A;
                    if (packageName2 == null) {
                        packageName2 = context.getPackageName();
                        this.A0A = packageName2;
                    }
                    intent.setPackage(packageName2);
                    if ((2 & this.A01) != 0) {
                        if (!this.A0A.equals(context.getPackageName())) {
                            AnonymousClass007 anonymousClass007 = this.A08;
                            if (anonymousClass007 == null) {
                                throw new IllegalArgumentException("Please set reporter for SecurePendingIntent library");
                            }
                            anonymousClass007.Air("SecurePendingIntent is configured to allow only implicit intent going to the same app, but detected intent for a different app.");
                        }
                    }
                    if (intent.getAction() != null && !intent.getAction().startsWith("android")) {
                        return intent;
                    }
                    if (intent.getCategories() != null && !intent.getCategories().isEmpty()) {
                        return intent;
                    }
                    AnonymousClass007 anonymousClass0072 = this.A08;
                    if (anonymousClass0072 == null) {
                        throw new IllegalArgumentException("Please set reporter for SecurePendingIntent library");
                    }
                    anonymousClass0072.Air("SecurePendingIntent is configured to allow implicit intent with either customized action or categories");
                    return intent;
                }
                return intent;
            }
            if (intent.getComponent() == null) {
                throw new SecurityException("Must generate PendingIntent based on an explicit intent.");
            }
            packageName = intent.getComponent().getPackageName();
        }
        intent.setPackage(packageName);
        return intent;
    }

    public final PendingIntent A01(Context context, int i, int i2) {
        return PendingIntent.getActivity(context, i, A04(context), A00(i2));
    }

    public final PendingIntent A02(Context context, int i, int i2) {
        return PendingIntent.getBroadcast(context, i, A04(context), A00(i2));
    }

    public final PendingIntent A03(Context context, int i, int i2) {
        return PendingIntent.getService(context, i, A04(context), A00(i2));
    }

    public void A05(Intent intent, ClassLoader classLoader) {
        this.A03 = intent.getComponent();
        this.A09 = intent.getAction();
        this.A06 = intent.getData();
        this.A0B = intent.getType();
        this.A05 = intent.getSourceBounds();
        this.A04 = intent.getSelector();
        this.A02 = intent.getClipData();
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            this.A0D.addAll(categories);
        }
        this.A00 = intent.getFlags();
        if (intent.getExtras() != null) {
            if (classLoader != null) {
                intent.setExtrasClassLoader(classLoader);
            }
            Bundle extras = intent.getExtras();
            Bundle bundle = this.A07;
            if (bundle == null) {
                bundle = new Bundle();
                this.A07 = bundle;
            }
            if (classLoader != null) {
                bundle.setClassLoader(classLoader);
            }
            this.A07.putAll(extras);
        }
    }
}
