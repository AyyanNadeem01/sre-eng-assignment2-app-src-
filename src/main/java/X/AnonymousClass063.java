package X;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

/* renamed from: X.063, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass063 extends AbstractC007002y {
    public boolean A00;
    public boolean A01;
    public final Context A02;
    public final PowerManager.WakeLock A03;
    public final PowerManager.WakeLock A04;

    @Override // X.AbstractC007002y
    public final void A00() {
        synchronized (this) {
            if (this.A01) {
                if (this.A00) {
                    this.A03.acquire(60000L);
                }
                this.A01 = false;
                this.A04.release();
            }
        }
    }

    @Override // X.AbstractC007002y
    public final void A01() {
        synchronized (this) {
            if (!this.A01) {
                this.A01 = true;
                this.A04.acquire(600000L);
                this.A03.release();
            }
        }
    }

    @Override // X.AbstractC007002y
    public final void A02() {
        synchronized (this) {
            this.A00 = false;
        }
    }

    @Override // X.AbstractC007002y
    public final void A04(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setComponent(super.A02);
        if (this.A02.startService(intent2) != null) {
            synchronized (this) {
                if (!this.A00) {
                    this.A00 = true;
                    if (!this.A01) {
                        this.A03.acquire(60000L);
                    }
                }
            }
        }
    }

    public AnonymousClass063(ComponentName componentName, Context context) {
        super(componentName);
        this.A02 = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append(componentName.getClassName());
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, AnonymousClass000.A07(":launch", sbA09));
        this.A03 = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        StringBuilder sbA092 = AnonymousClass000.A09();
        sbA092.append(componentName.getClassName());
        PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, AnonymousClass000.A07(":run", sbA092));
        this.A04 = wakeLockNewWakeLock2;
        wakeLockNewWakeLock2.setReferenceCounted(false);
    }
}
