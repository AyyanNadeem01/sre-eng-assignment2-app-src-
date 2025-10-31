package X;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

/* renamed from: X.00D, reason: invalid class name */
/* loaded from: classes.dex */
public final class C00D extends ContextWrapper {
    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    public C00D(Application application) {
        super(application);
    }
}
