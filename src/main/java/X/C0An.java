package X;

import android.util.Log;
import java.io.File;

/* renamed from: X.0An, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0An implements InterfaceC02390Aw {
    @Override // X.InterfaceC02390Aw
    public final boolean AhA(UnsatisfiedLinkError unsatisfiedLinkError, C0AD[] c0adArr) {
        for (C0AD c0ad : c0adArr) {
            if (c0ad != null && (c0ad instanceof C0CI)) {
                C0CJ c0cj = (C0CJ) c0ad;
                StringBuilder sbA09 = AnonymousClass000.A09();
                sbA09.append("Waiting on SoSource ");
                Log.e("SoLoader", AnonymousClass000.A07(c0ad.A05(), sbA09));
                File file = c0cj.A01;
                try {
                    C0B5.A00(file, AnonymousClass000.A02(file, "dso_lock")).close();
                } catch (Exception e) {
                    StringBuilder sbA092 = AnonymousClass000.A09();
                    sbA092.append("Encountered exception during wait for unpacking trying to acquire file lock for ");
                    sbA092.append(c0cj.getClass().getName());
                    sbA092.append(" (");
                    sbA092.append(file);
                    Log.e("fb-UnpackingSoSource", AnonymousClass000.A07("): ", sbA092), e);
                }
            }
        }
        return true;
    }
}
