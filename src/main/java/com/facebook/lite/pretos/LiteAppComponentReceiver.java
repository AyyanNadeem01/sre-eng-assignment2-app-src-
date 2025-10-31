package com.facebook.lite.pretos;

import X.AbstractServiceC006902x;
import X.AnonymousClass000;
import X.C0AP;
import X.C0CF;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.appcomponentmanager.AppComponentManagerService;

/* loaded from: classes.dex */
public class LiteAppComponentReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        intent.getAction();
        if ("android.intent.action.MY_PACKAGE_REPLACED".equals(intent.getAction())) {
            String[] list = AnonymousClass000.A02(C0AP.A00(context, 1436876361), "versions").list();
            if ((list == null || list.length == 0) && C0CF.A01.A00() == 0) {
                return;
            }
            AbstractServiceC006902x.A00(context, new Intent("com.facebook.appcomponentmanager.ACTION_ENABLE_COMPONENTS"), AppComponentManagerService.class, 137875812);
        }
    }
}
