package X;

import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import java.util.ArrayList;

/* renamed from: X.08U */
/* loaded from: classes.dex */
public abstract class C08U {
    public final AnonymousClass006 A00;

    public abstract int A02(Uri uri);

    public abstract int A03(Uri uri, String str, String[] strArr);

    public abstract Cursor A08(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public abstract Uri A09(Uri uri, ContentValues contentValues);

    public abstract String A0C(Uri uri);

    public int A04(Uri uri, ContentValues[] contentValuesArr) {
        return this.A00.A02(uri, contentValuesArr);
    }

    public AssetFileDescriptor A05(Uri uri, String str) {
        return this.A00.A03(uri, str);
    }

    public AssetFileDescriptor A06(Uri uri, String str, Bundle bundle) {
        return this.A00.A04(uri, str, bundle);
    }

    public Bundle A0A(String str, String str2, Bundle bundle) {
        return this.A00.A05(str, str2, bundle);
    }

    public ParcelFileDescriptor A0B(Uri uri, String str) {
        return this.A00.A06(uri, str);
    }

    public void A0D() {
        this.A00.A07();
    }

    public void A0E() {
        this.A00.A08();
    }

    public void A0F(int i) {
        this.A00.A09(i);
    }

    public void A0G(Configuration configuration) {
        this.A00.A0B(configuration);
    }

    public boolean A0H() {
        return this.A00.A0C();
    }

    public ContentProviderResult[] A0I(ArrayList arrayList) {
        return this.A00.A0D(arrayList);
    }

    public String[] A0J(Uri uri, String str) {
        return this.A00.A0E(uri, str);
    }

    public C08U(AnonymousClass006 anonymousClass006) {
        C08C.A00();
        this.A00 = anonymousClass006;
    }

    public Cursor A07(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return A08(uri, strArr, str, strArr2, str2);
    }
}
