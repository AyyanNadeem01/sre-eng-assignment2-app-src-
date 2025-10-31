package X;

import android.app.Application;
import android.os.SystemClock;
import java.util.Calendar;

/* renamed from: X.04G, reason: invalid class name */
/* loaded from: classes.dex */
public final class C04G implements AnonymousClass095 {
    public Application A00;

    @Override // X.AnonymousClass095
    public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) {
        Application application = this.A00;
        if (AnonymousClass051.A01 == null) {
            synchronized (AnonymousClass051.class) {
                if (AnonymousClass051.A01 == null) {
                    if (application == null) {
                        throw new NullPointerException("getApplicationContext");
                    }
                    AnonymousClass051.A01 = new AnonymousClass051(application);
                }
            }
        }
        AnonymousClass051 anonymousClass051 = AnonymousClass051.A01;
        c05c.A03(AnonymousClass094.A23, Long.valueOf((Calendar.getInstance().getTimeInMillis() - SystemClock.elapsedRealtime()) / 1000));
        AnonymousClass091 anonymousClass091 = AnonymousClass094.A22;
        String string = "0";
        String string2 = "0";
        try {
            string2 = anonymousClass051.A00.getString(anonymousClass091.name, "0");
        } catch (Exception unused) {
            C018108b.A07("lacrima", "Failed to read from SharedPreferences");
            C0C5.A00();
        }
        if (string2 != null) {
            c05c.A03(anonymousClass091, Long.valueOf(Long.parseLong(string2)));
        }
        AnonymousClass091 anonymousClass0912 = AnonymousClass094.A24;
        try {
            string = anonymousClass051.A00.getString(anonymousClass0912.name, "0");
        } catch (Exception unused2) {
            C018108b.A07("lacrima", "Failed to read from SharedPreferences");
            C0C5.A00();
        }
        if (string != null) {
            c05c.A03(anonymousClass0912, Long.valueOf(Long.parseLong(string)));
        }
    }

    @Override // X.AnonymousClass095
    public final Integer AGY() {
        return AnonymousClass065.A0b;
    }
}
