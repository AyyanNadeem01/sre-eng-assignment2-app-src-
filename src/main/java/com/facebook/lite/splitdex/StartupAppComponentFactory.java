package com.facebook.lite.splitdex;

import X.AbstractC020809g;
import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.Intent;

/* loaded from: classes.dex */
public class StartupAppComponentFactory extends AppComponentFactory {
    @Override // android.app.AppComponentFactory
    public final Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) {
        AbstractC020809g.A00 = System.nanoTime();
        return super.instantiateActivity(classLoader, str, intent);
    }
}
