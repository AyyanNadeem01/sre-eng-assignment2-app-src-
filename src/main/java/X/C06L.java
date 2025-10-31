package X;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.StrictMode;
import java.io.File;

/* renamed from: X.06L, reason: invalid class name */
/* loaded from: classes.dex */
public final class C06L extends C0AD implements C0BS {
    public C0CJ A00;
    public final int A01;

    @Override // X.C0AD
    public final int A03(StrictMode.ThreadPolicy threadPolicy, String str, int i) {
        return this.A00.A03(threadPolicy, str, i);
    }

    @Override // X.C0AD
    public final File A04(String str) {
        return this.A00.A04(str);
    }

    @Override // X.C0AD
    public final String A06(String str) {
        return this.A00.A06(str);
    }

    @Override // X.C0AD
    public final void A07(int i) {
        this.A00.A07(i);
    }

    @Override // X.C0AD
    public final String[] A08(String str) {
        return this.A00.A08(str);
    }

    @Override // X.C0BS
    public final C0AD Ah9(ApplicationInfo applicationInfo) {
        this.A00 = new C0CJ(AnonymousClass000.A03(applicationInfo.nativeLibraryDir), this.A01 | 1);
        return this;
    }

    public C06L(Context context, int i) {
        this.A01 = i;
        this.A00 = new C0CJ(AnonymousClass000.A03(context.getApplicationInfo().nativeLibraryDir), i);
    }

    @Override // X.C0AD
    public final String toString() {
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("ApplicationSoSource");
        sbA09.append("[");
        AnonymousClass000.A0L(sbA09, this.A00);
        return AnonymousClass000.A07("]", sbA09);
    }

    @Override // X.C0AD
    public final String A05() {
        return "ApplicationSoSource";
    }
}
