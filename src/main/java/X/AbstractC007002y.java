package X;

import android.content.ComponentName;
import android.content.Intent;

/* renamed from: X.02y, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC007002y {
    public int A00;
    public boolean A01;
    public final ComponentName A02;

    public abstract void A04(Intent intent);

    public final void A03(int i) {
        if (!this.A01) {
            this.A01 = true;
            this.A00 = i;
            return;
        }
        int i2 = this.A00;
        if (i2 != i) {
            StringBuilder sb = new StringBuilder();
            sb.append("Given job ID ");
            sb.append(i);
            sb.append(" is different than previous ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public AbstractC007002y(ComponentName componentName) {
        this.A02 = componentName;
    }

    public void A00() {
    }

    public void A01() {
    }

    public void A02() {
    }
}
