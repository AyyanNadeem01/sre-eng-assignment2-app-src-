package X;

import android.content.Context;
import android.os.Handler;
import java.io.File;
import java.io.IOException;

/* renamed from: X.00j */
/* loaded from: classes.dex */
public final class C000600j {
    public C000400h A00;
    public final int A01;
    public final Context A02;
    public final Handler A03;
    public final C00c A04;
    public final String A05;
    public final String A06;
    public final boolean A07;

    public final String A00() {
        try {
            return new File(C0AP.A00(this.A02, 194178138), this.A05.replace('.', '_').replace(':', '_')).getCanonicalPath();
        } catch (IOException unused) {
            C0C5.A00();
            return null;
        }
    }

    public C000600j(Context context, Handler handler, C00c c00c, C000400h c000400h, String str, String str2, int i, boolean z) {
        this.A02 = context;
        this.A05 = str;
        this.A04 = c00c;
        this.A00 = c000400h;
        this.A03 = handler;
        this.A01 = i;
        this.A07 = z;
        this.A06 = str2;
    }
}
