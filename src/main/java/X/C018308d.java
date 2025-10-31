package X;

import android.util.Log;

/* renamed from: X.08d, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C018308d implements C08H {
    public static final C018308d A01 = new C018308d();
    public int A00;

    @Override // X.C08H
    public final void AlS() {
        this.A00 = 5;
    }

    @Override // X.C08H
    public final boolean ANo(int i) {
        return this.A00 <= i;
    }

    @Override // X.C08H
    public final void A91(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // X.C08H
    public final int AGP() {
        return this.A00;
    }

    @Override // X.C08H
    public final void Apc(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // X.C08H
    public final void AqL(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // X.C08H
    public final void A92(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    @Override // X.C08H
    public final void AP2(int i, String str, String str2) {
        Log.println(i, str, str2);
    }

    @Override // X.C08H
    public final void Apd(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }

    @Override // X.C08H
    public final void AqM(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
