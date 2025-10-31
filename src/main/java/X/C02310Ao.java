package X;

import android.util.Log;
import com.facebook.soloader.SoLoaderDSONotFoundError;
import com.facebook.soloader.SoLoaderULError;

/* renamed from: X.0Ao, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C02310Ao implements InterfaceC02390Aw {
    @Override // X.InterfaceC02390Aw
    public final boolean AhA(UnsatisfiedLinkError unsatisfiedLinkError, C0AD[] c0adArr) {
        if (!(unsatisfiedLinkError instanceof SoLoaderULError) || (unsatisfiedLinkError instanceof SoLoaderDSONotFoundError)) {
            return false;
        }
        String str = ((SoLoaderULError) unsatisfiedLinkError).mSoName;
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("Reunpacking NonApk UnpackingSoSources due to ");
        sbA09.append(unsatisfiedLinkError);
        Log.e("SoLoader", AnonymousClass000.A07(str == null ? "" : AnonymousClass000.A06(", retrying for specific library ", str, AnonymousClass000.A09()), sbA09));
        for (C0AD c0ad : c0adArr) {
            if (c0ad != null && (c0ad instanceof C0CI) && !(c0ad instanceof C0CG)) {
                try {
                    StringBuilder sbA092 = AnonymousClass000.A09();
                    sbA092.append("Runpacking ");
                    AnonymousClass000.A0J(c0ad.A05(), "SoLoader", sbA092);
                    c0ad.A07(2);
                } catch (Exception e) {
                    StringBuilder sbA093 = AnonymousClass000.A09();
                    sbA093.append("Encountered an exception while reunpacking ");
                    sbA093.append(c0ad.A05());
                    sbA093.append(" for library ");
                    sbA093.append(str);
                    Log.e("SoLoader", AnonymousClass000.A07(": ", sbA093), e);
                    return false;
                }
            }
        }
        return true;
    }
}
