package X;

import android.content.Context;
import android.content.Intent;
import java.util.HashSet;
import org.json.JSONException;

/* renamed from: X.018, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass018 extends AnonymousClass017 {
    public boolean A01 = false;
    public C012705p A00 = null;

    @Override // X.AnonymousClass017
    public final /* bridge */ /* synthetic */ void A05(Intent intent, ClassLoader classLoader) {
        super.A05(intent, null);
    }

    public final void A06() {
        super.A01 |= 1;
    }

    @Override // X.AnonymousClass017
    public final Intent A04(Context context) throws JSONException {
        String str;
        Intent intentA04 = super.A04(context);
        if (this.A01) {
            boolean zA02 = false;
            if ((4 & super.A01) == 0 && (str = intentA04.getPackage()) != null) {
                if (str.equals(context.getPackageName())) {
                    zA02 = true;
                } else if (this.A00 != null) {
                    try {
                        zA02 = this.A00.A02(C008703w.A04(C04M.A00(context, str), new HashSet(), false), C04M.A03(context));
                    } catch (Exception e) {
                        AnonymousClass007 anonymousClass007 = this.A08;
                        if (anonymousClass007 != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Exception checking identity of package=");
                            sb.append(str);
                            sb.append(": ");
                            sb.append(e.toString());
                            anonymousClass007.Air(sb.toString());
                        }
                    }
                }
            }
            if (zA02) {
                AnonymousClass007 anonymousClass0072 = this.A08;
                if (anonymousClass0072 != null) {
                    AbstractC006102p.A01(context, intentA04, anonymousClass0072, null);
                } else {
                    try {
                        AbstractC006102p.A02(context, intentA04, null);
                        return intentA04;
                    } catch (C013205v unused) {
                    }
                }
            }
        }
        return intentA04;
    }

    public final void A07(Intent intent, ClassLoader classLoader) {
        super.A05(intent, classLoader);
    }
}
