package X;

import android.util.Log;

/* renamed from: X.08I, reason: invalid class name */
/* loaded from: classes.dex */
public final class C08I implements C08H {
    public static final C08I A00 = new C08I();

    @Override // X.C08H
    public final void A91(String str, String str2) {
        A00(6, str, str2);
    }

    @Override // X.C08H
    public final void A92(String str, String str2, Throwable th) {
        A01(str, str2, th, 6);
    }

    @Override // X.C08H
    public final boolean ANo(int i) {
        return 5 <= i;
    }

    @Override // X.C08H
    public final void Apc(String str, String str2) {
        A00(5, str, str2);
    }

    @Override // X.C08H
    public final void Apd(String str, String str2, Throwable th) {
        A01(str, str2, th, 5);
    }

    @Override // X.C08H
    public final void AqL(String str, String str2) {
        A00(6, str, str2);
    }

    @Override // X.C08H
    public final void AqM(String str, String str2, Throwable th) {
        A01(str, str2, th, 6);
    }

    public static void A00(int i, String str, String str2) {
        Log.println(i, AnonymousClass000.A06(":", str, AnonymousClass000.A0A("unknown")), str2);
    }

    public static void A01(String str, String str2, Throwable th, int i) {
        String strA06 = AnonymousClass000.A06(":", str, AnonymousClass000.A0A("unknown"));
        StringBuilder sbA0A = AnonymousClass000.A0A(str2);
        sbA0A.append('\n');
        Log.println(i, strA06, AnonymousClass000.A07(th == null ? "" : Log.getStackTraceString(th), sbA0A));
    }

    @Override // X.C08H
    public final int AGP() {
        return 5;
    }

    @Override // X.C08H
    public final void AlS() {
    }

    @Override // X.C08H
    public final void AP2(int i, String str, String str2) {
        A00(i, str, str2);
    }
}
