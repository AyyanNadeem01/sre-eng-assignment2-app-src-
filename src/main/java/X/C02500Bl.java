package X;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* renamed from: X.0Bl, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public class C02500Bl extends C0CI {
    public final File A00;
    public final String A01;

    public C02500Bl(Context context, File file, File file2, String str) {
        super(context, file, true);
        this.A00 = file2;
        this.A01 = str;
    }

    @Override // X.C0CI
    public final C0CM A09() {
        return new C02560Bt(this, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    @Override // X.C0CJ, X.C0AD
    public final String toString() throws IOException {
        String name;
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append(A05());
        sbA09.append("[");
        File canonicalPath = this.A00;
        try {
            canonicalPath = canonicalPath.getCanonicalPath();
            name = canonicalPath;
        } catch (IOException unused) {
            name = canonicalPath.getName();
        }
        sbA09.append(name);
        return AnonymousClass000.A07("]", sbA09);
    }

    @Override // X.C0CJ, X.C0AD
    public String A05() {
        return "ExtractFromZipSoSource";
    }

    public C02500Bl(Context context, File file, String str, String str2) {
        super(context, str, true);
        this.A00 = file;
        this.A01 = str2;
    }
}
