package X;

import android.util.Log;
import com.facebook.soloader.SoLoaderULError;

/* renamed from: X.0At, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C02360At implements InterfaceC02390Aw {
    @Override // X.InterfaceC02390Aw
    public final boolean AhA(UnsatisfiedLinkError unsatisfiedLinkError, C0AD[] c0adArr) {
        if (unsatisfiedLinkError instanceof SoLoaderULError) {
            Log.e("SoLoader", "Checking /data/data missing libraries.");
            boolean z = false;
            for (C0AD c0ad : c0adArr) {
                if ((c0ad instanceof C0CI) && !(c0ad instanceof C0CG)) {
                    C0CI c0ci = (C0CI) c0ad;
                    try {
                        C0Bz[] c0BzArrA0B = c0ci.A0B();
                        int length = c0BzArrA0B.length;
                        int i = 0;
                        while (true) {
                            if (i < length) {
                                C0Bz c0Bz = c0BzArrA0B[i];
                                if (c0ci.A04(c0Bz.A01) == null) {
                                    StringBuilder sbA09 = AnonymousClass000.A09();
                                    sbA09.append("Missing ");
                                    sbA09.append(c0Bz.A01);
                                    sbA09.append(" from ");
                                    sbA09.append(c0ci.A05());
                                    AnonymousClass000.A0J(", will force prepare.", "SoLoader", sbA09);
                                    c0ci.A07(2);
                                    z = true;
                                    break;
                                }
                                i++;
                            }
                        }
                    } catch (Exception e) {
                        Log.e("SoLoader", "Encountered an exception while recovering from /data/data failure ", e);
                        return false;
                    }
                }
            }
            if (z) {
                Log.e("SoLoader", "Successfully recovered from /data/data disk failure.");
                return true;
            }
            Log.e("SoLoader", "No libraries missing from unpacking so paths while recovering /data/data failure");
        }
        return false;
    }
}
