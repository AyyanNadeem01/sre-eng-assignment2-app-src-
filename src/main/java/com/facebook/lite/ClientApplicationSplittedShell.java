package com.facebook.lite;

import X.AnonymousClass000;
import X.AnonymousClass001;
import X.AnonymousClass066;
import X.C06E;
import android.app.Application;
import android.os.Trace;
import com.facebook.endtoend.EndToEnd;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ClientApplicationSplittedShell extends Application {
    public AnonymousClass001 A00;

    @Override // android.content.ContextWrapper, android.content.Context
    public final File getDir(String str, int i) {
        C06E.A07(str, 1);
        return super.getDir(str, i);
    }

    private void A00() {
        if (this.A00 == null) {
            boolean z = EndToEnd.A03;
            try {
                this.A00 = (AnonymousClass001) Class.forName("com.facebook.lite.LeanClientApplication").getConstructor(Application.class).newInstance(this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        Object systemService;
        AnonymousClass001 anonymousClass001 = this.A00;
        return (anonymousClass001 == null || (systemService = anonymousClass001.getSystemService(str)) == null) ? super.getSystemService(str) : systemService;
    }

    public static void A01(String str) {
        String strA06 = AnonymousClass000.A06("ClientApplicationSplittedShell.", str, AnonymousClass000.A09());
        Method method = AnonymousClass066.A03;
        Trace.beginSection(strA06);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0197 A[Catch: all -> 0x03db, TryCatch #8 {all -> 0x03db, blocks: (B:50:0x0175, B:53:0x017f, B:55:0x0187, B:57:0x0191, B:62:0x01a1, B:63:0x01a3, B:65:0x01ae, B:67:0x01b4, B:74:0x01d0, B:85:0x01f8, B:68:0x01b9, B:72:0x01cc, B:59:0x0197), top: B:191:0x0175, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a0  */
    /* JADX WARN: Type inference failed for: r0v70, types: [X.06W] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Runnable, java.util.concurrent.FutureTask] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.lang.Throwable] */
    @Override // android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(final android.content.Context r15) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1021
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.lite.ClientApplicationSplittedShell.attachBaseContext(android.content.Context):void");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final File getCacheDir() {
        File cacheDir = super.getCacheDir();
        C06E.A07(cacheDir, 1);
        return cacheDir;
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        A00();
        this.A00.onCreate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        AnonymousClass001 anonymousClass001 = this.A00;
        if (anonymousClass001 != null) {
            anonymousClass001.onTrimMemory(i);
        }
    }
}
