package X;

import java.io.File;

/* renamed from: X.03Y, reason: invalid class name */
/* loaded from: classes.dex */
public final class C03Y implements C0AS {
    @Override // X.C0AS
    public final /* bridge */ /* synthetic */ Object A6b(C0AZ c0az) {
        C0CK c0ck = c0az.A02;
        AnonymousClass053.A03(c0ck, "Did you call earlyInit()?");
        File file = c0ck.A04;
        AnonymousClass053.A03(file, "Did you call SessionManager.init()?");
        return new C009304c(new File(file, "logcat.txt"));
    }
}
