package X;

import android.content.Context;
import java.io.File;

/* renamed from: X.0Am, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0Am extends C02500Bl {
    public final String A00;

    public C0Am(Context context) {
        super(context, AnonymousClass000.A01(context), "lib-assets", "^assets/lib/([^/]+)/([^/]+\\.so)$");
        this.A00 = "lib-assets";
    }

    @Override // X.C0CI
    public final byte[] A0A() {
        return AbstractC02280Ah.A00(((C0CI) this).A01, ((C02500Bl) this).A00, this.A00);
    }

    @Override // X.C02500Bl, X.C0CJ, X.C0AD
    public final String A05() {
        return "ExtractFromApkSoSource";
    }

    public C0Am(Context context, File file, File file2, String str, String str2) {
        super(context, file, file2, str2);
        this.A00 = str;
    }
}
