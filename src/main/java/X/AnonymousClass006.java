package X;

import android.content.ContentProvider;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/* renamed from: X.006, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class AnonymousClass006 extends ContentProvider {
    public static String A04;
    public static volatile C00E A05;
    public C08U A00;
    public volatile ProviderInfo A03;
    public boolean A02 = false;
    public Semaphore A01 = null;

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (r5v0 X.006) */
    public static synchronized C08U A00(AnonymousClass006 anonymousClass006) {
        C08U c08u;
        synchronized (anonymousClass006) {
            if (anonymousClass006.A02 && A04 == null) {
                A04 = anonymousClass006.getClass().getName();
            } else {
                anonymousClass006.A02 = true;
            }
            c08u = anonymousClass006.A00;
            if (c08u == null) {
                C08C.A00();
                try {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(anonymousClass006.getClass().getName());
                        sb.append("$Impl");
                        c08u = (C08U) Class.forName(sb.toString()).getDeclaredConstructor(AnonymousClass006.class).newInstance(anonymousClass006);
                        anonymousClass006.A00 = c08u;
                    } catch (InvocationTargetException e) {
                        e = e;
                        Throwable cause = e.getCause();
                        if (cause != null) {
                            e = cause;
                        }
                        if (e instanceof RuntimeException) {
                            throw e;
                        }
                        throw new RuntimeException(e);
                    }
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException e2) {
                    throw new IllegalArgumentException(e2);
                }
            }
        }
        return c08u;
    }

    private Semaphore A01() {
        Semaphore semaphore;
        Semaphore semaphore2 = this.A01;
        if (semaphore2 != null) {
            return semaphore2;
        }
        synchronized (this) {
            semaphore = this.A01;
            if (semaphore == null) {
                A00(this);
                semaphore = new Semaphore(Integer.MAX_VALUE);
                this.A01 = semaphore;
            }
        }
        return semaphore;
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        this.A03 = providerInfo;
        super.attachInfo(context, providerInfo);
        A0A(context, providerInfo);
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public final void onLowMemory() {
        C08U c08uA00;
        if (this.A00 == null || (c08uA00 = A00(this)) == null) {
            return;
        }
        c08uA00.A0D();
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        C08U c08uA00;
        if (this.A00 == null || (c08uA00 = A00(this)) == null) {
            return;
        }
        c08uA00.A0F(i);
    }

    public final int A02(Uri uri, ContentValues[] contentValuesArr) {
        return super.bulkInsert(uri, contentValuesArr);
    }

    public final AssetFileDescriptor A03(Uri uri, String str) {
        return super.openAssetFile(uri, str);
    }

    public final AssetFileDescriptor A04(Uri uri, String str, Bundle bundle) {
        return super.openTypedAssetFile(uri, str, bundle);
    }

    public final Bundle A05(String str, String str2, Bundle bundle) {
        return super.call(str, str2, bundle);
    }

    public final ParcelFileDescriptor A06(Uri uri, String str) {
        return super.openFile(uri, str);
    }

    public final boolean A0C() {
        return super.isTemporary();
    }

    public final ContentProviderResult[] A0D(ArrayList arrayList) {
        return super.applyBatch(arrayList);
    }

    public final String[] A0E(Uri uri, String str) {
        return super.getStreamTypes(uri, str);
    }

    @Override // android.content.ContentProvider
    public final ContentProviderResult[] applyBatch(ArrayList arrayList) {
        getContext();
        try {
            getCallingPackage();
        } catch (SecurityException unused) {
        }
        return A00(this).A0I(arrayList);
    }

    @Override // android.content.ContentProvider
    public final int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        getContext();
        try {
            getCallingPackage();
        } catch (SecurityException unused) {
        }
        return A00(this).A04(uri, contentValuesArr);
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        getContext();
        try {
            getCallingPackage();
        } catch (SecurityException unused) {
        }
        return A00(this).A0A(str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        getContext();
        try {
            getCallingPackage();
        } catch (SecurityException unused) {
        }
        return A00(this).A03(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public final String[] getStreamTypes(Uri uri, String str) {
        return A00(this).A0J(uri, str);
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return A00(this).A0C(uri);
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        getContext();
        try {
            getCallingPackage();
        } catch (SecurityException unused) {
        }
        return A00(this).A09(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public final boolean isTemporary() {
        return A00(this).A0H();
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        A00(this).A0G(configuration);
    }

    @Override // android.content.ContentProvider
    public final AssetFileDescriptor openAssetFile(Uri uri, String str) {
        getContext();
        try {
            getCallingPackage();
        } catch (SecurityException unused) {
        }
        return A00(this).A05(uri, str);
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        getContext();
        try {
            getCallingPackage();
        } catch (SecurityException unused) {
        }
        return A00(this).A0B(uri, str);
    }

    @Override // android.content.ContentProvider
    public final AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) {
        getContext();
        try {
            getCallingPackage();
        } catch (SecurityException unused) {
        }
        return A00(this).A06(uri, str, bundle);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        if (!A01().tryAcquire()) {
            A00(this);
            throw new IllegalStateException("Concurrency limiting requires a non-null implementation of emptyResultCursor()");
        }
        try {
            getContext();
            try {
                getCallingPackage();
            } catch (SecurityException unused) {
            }
            Cursor cursorA07 = A00(this).A07(uri, strArr, str, strArr2, str2);
            if (A05 != null) {
                getContext().getApplicationInfo();
                A05.ARD(getContext(), this.A03, cursorA07, uri);
            }
            return cursorA07;
        } finally {
            A01().release();
        }
    }

    @Override // android.content.ContentProvider
    public final void shutdown() {
        A00(this).A0E();
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        getContext();
        try {
            getCallingPackage();
        } catch (SecurityException unused) {
        }
        return A00(this).A02(uri);
    }

    public final void A07() {
        super.onLowMemory();
    }

    public final void A08() {
        super.shutdown();
    }

    public void A0A(Context context, ProviderInfo providerInfo) {
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    public final void A09(int i) {
        super.onTrimMemory(i);
    }

    public final void A0B(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        getContext();
        try {
            getCallingPackage();
        } catch (SecurityException unused) {
        }
        return A00(this).A08(uri, strArr, str, strArr2, str2);
    }
}
