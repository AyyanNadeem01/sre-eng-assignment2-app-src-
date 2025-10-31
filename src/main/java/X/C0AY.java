package X;

import com.facebook.errorreporting.lacrima.common.mappedfile.mlocked.MLockedFile;
import java.io.File;
import java.io.IOException;

/* renamed from: X.0AY */
/* loaded from: classes.dex */
public final /* synthetic */ class C0AY {
    public final /* synthetic */ C02620Cb A00;

    public final C010604q A00(File file) {
        C0AZ c0az = (C0AZ) this.A00.A00;
        C0AZ c0az2 = C0AZ.A0Y;
        if (c0az.A0W) {
            try {
                MLockedFile mLockedFile = new MLockedFile(file);
                mLockedFile.mlockBuffer();
                return mLockedFile;
            } catch (IOException e) {
                C0C5.A00();
                C018108b.A0C("lacrima", "Failed to initialize mlocked file, using fallback", e);
            }
        }
        try {
            return new C010604q(file);
        } catch (IOException e2) {
            C0C5.A00();
            C018108b.A0C("lacrima", "Failed to initialize mapped file", e2);
            return null;
        }
    }

    public /* synthetic */ C0AY(C02620Cb c02620Cb) {
        this.A00 = c02620Cb;
    }
}
