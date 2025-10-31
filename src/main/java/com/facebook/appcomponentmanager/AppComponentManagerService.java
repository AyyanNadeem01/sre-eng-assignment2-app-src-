package com.facebook.appcomponentmanager;

import X.AbstractServiceC006902x;
import X.AnonymousClass000;
import X.AnonymousClass041;
import X.AnonymousClass054;
import X.C015907a;
import X.C016207d;
import X.C018108b;
import X.C07V;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;

/* loaded from: classes.dex */
public class AppComponentManagerService extends AbstractServiceC006902x {
    @Override // X.AbstractServiceC006902x
    public final void A05(Intent intent) throws Throwable {
        AnonymousClass054 anonymousClass054;
        intent.getAction();
        if ("com.facebook.appcomponentmanager.ACTION_ENABLE_COMPONENTS".equals(intent.getAction())) {
            try {
                C07V.A03(this);
                Intent intent2 = new Intent("com.facebook.appcomponentmanager.ENABLING_CMPS_DONE");
                intent2.setPackage(getPackageName());
                sendBroadcast(intent2);
                return;
            } catch (RuntimeException e) {
                th = e;
                C018108b.A0A("AppComponentManagerService", "Exception while enabling components. Aborting.", th);
                synchronized (AnonymousClass041.class) {
                    anonymousClass054 = AnonymousClass041.A00;
                    if (anonymousClass054 == null) {
                        return;
                    }
                }
            }
        } else {
            if (!"com.facebook.appcomponentmanager.ACTION_EFNORCE_MANIFEST_CONSISTENCY".equals(intent.getAction())) {
                return;
            }
            PackageManager packageManager = getPackageManager();
            C016207d c016207d = new C016207d();
            File fileA01 = AnonymousClass000.A01(this);
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
                C015907a c015907aA03 = c016207d.A03(fileA01);
                int i = packageInfo.versionCode;
                String string = Integer.toString(i);
                String str = c015907aA03.A01;
                if (string.equals(str) && packageInfo.versionName.equals(c015907aA03.A02) && packageInfo.packageName.equals(c015907aA03.A00)) {
                    return;
                }
                StringBuilder sbA09 = AnonymousClass000.A09();
                sbA09.append("PackageInfo{package=");
                AnonymousClass000.A0I(packageInfo.packageName, ",", "versionCode=", sbA09);
                sbA09.append(i);
                sbA09.append(",");
                sbA09.append("versionName=");
                sbA09.append(packageInfo.versionName);
                sbA09.append("} ,");
                sbA09.append("Manifest{package=");
                AnonymousClass000.A0I(c015907aA03.A00, ", ", "versionCode=", sbA09);
                AnonymousClass000.A0I(str, ", ", "versionName=", sbA09);
                sbA09.append(c015907aA03.A02);
                sbA09.append(", ");
                sbA09.append("activities=");
                sbA09.append(c015907aA03.A03.size());
                sbA09.append(", ");
                sbA09.append("receivers=");
                sbA09.append(c015907aA03.A05.size());
                sbA09.append(", ");
                sbA09.append("services=");
                sbA09.append(c015907aA03.A06.size());
                sbA09.append(", ");
                sbA09.append("providers=");
                sbA09.append(c015907aA03.A04.size());
                throw AnonymousClass000.A04(AnonymousClass000.A07("}", sbA09));
            } catch (Throwable th) {
                th = th;
                synchronized (AnonymousClass041.class) {
                    anonymousClass054 = AnonymousClass041.A00;
                    if (anonymousClass054 == null) {
                        C018108b.A0A("AppComponentManagerService", "enforceManifestConsistency failed", th);
                        return;
                    }
                }
            }
        }
        anonymousClass054.ALb(th);
    }
}
