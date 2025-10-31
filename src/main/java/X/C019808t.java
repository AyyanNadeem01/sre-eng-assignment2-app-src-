package X;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Arrays;

/* renamed from: X.08t, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C019808t {
    public final AnonymousClass007 A00;
    public final C07Y A01;

    public final void A00(Context context, C008703w c008703w, String str) {
        int i = c008703w.A00;
        try {
            String[] strArrA03 = AnonymousClass009.A03(context, i);
            if (strArrA03.length == 1) {
                this.A01.A3y(context, strArrA03[0], str);
                return;
            }
            for (String str2 : strArrA03) {
                try {
                    this.A01.A3y(context, str2, str);
                    return;
                } catch (C08L unused) {
                }
            }
            StringBuilder sbA09 = AnonymousClass000.A09();
            sbA09.append("FBPermission '");
            sbA09.append(str);
            sbA09.append("' was not granted to UID '");
            sbA09.append(i);
            sbA09.append("' (packages: '");
            sbA09.append(Arrays.toString(strArrA03));
            throw new C08L(AnonymousClass000.A07("')", sbA09));
        } catch (PackageManager.NameNotFoundException e) {
            throw new C012605o(e);
        } catch (RuntimeException e2) {
            throw new SecurityException(e2);
        }
    }

    public C019808t(AnonymousClass007 anonymousClass007, C07Y c07y) {
        this.A01 = c07y;
        this.A00 = anonymousClass007;
    }
}
