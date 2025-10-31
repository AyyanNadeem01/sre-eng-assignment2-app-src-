package X;

import android.util.Log;
import com.facebook.soloader.SoLoaderDSONotFoundError;
import com.facebook.soloader.SoLoaderULError;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* renamed from: X.0Ap, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C02320Ap implements InterfaceC02390Aw {
    public int A00 = 0;

    @Override // X.InterfaceC02390Aw
    public final boolean AhA(UnsatisfiedLinkError unsatisfiedLinkError, C0AD[] c0adArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z;
        if (unsatisfiedLinkError instanceof SoLoaderULError) {
            SoLoaderULError soLoaderULError = (SoLoaderULError) unsatisfiedLinkError;
            String str = soLoaderULError.mSoName;
            String message = soLoaderULError.getMessage();
            if (str == null) {
                Log.e("SoLoader", "No so name provided in ULE, cannot recover");
            } else if (soLoaderULError instanceof SoLoaderDSONotFoundError) {
                if ((this.A00 & 1) != 0) {
                    StringBuilder sbA09 = AnonymousClass000.A09();
                    sbA09.append("Reunpacking BackupSoSources due to ");
                    sbA09.append(soLoaderULError);
                    Log.e("SoLoader", AnonymousClass000.A06(", retrying for specific library ", str, sbA09));
                    try {
                        for (C0AD c0ad : c0adArr) {
                            if (c0ad != null && (c0ad instanceof C0CG)) {
                                C0CG c0cg = (C0CG) c0ad;
                                C0CL c0cl = new C0CL(c0cg);
                                try {
                                    C0Bz[] c0BzArrA02 = c0cl.A02();
                                    int length = c0BzArrA02.length;
                                    int i = 0;
                                    while (true) {
                                        if (i >= length) {
                                            z = false;
                                            break;
                                        }
                                        if (c0BzArrA02[i].A01.equals(str)) {
                                            StringBuilder sbA092 = AnonymousClass000.A09();
                                            sbA092.append("Found ");
                                            sbA092.append(str);
                                            sbA092.append(" in ");
                                            AnonymousClass000.A0J("BackupSoSource", "SoLoader", sbA092);
                                            z = true;
                                            break;
                                        }
                                        i++;
                                    }
                                    c0cl.close();
                                    if (z) {
                                        StringBuilder sbA093 = AnonymousClass000.A09();
                                        sbA093.append("Preparing ");
                                        AnonymousClass000.A0J("BackupSoSource", "SoLoader", sbA093);
                                        c0cg.A07(0);
                                        return true;
                                    }
                                } finally {
                                }
                            }
                        }
                        return false;
                    } catch (IOException e) {
                        Log.e("SoLoader", AnonymousClass000.A05(e, "Failed to run recovery for backup so source due to: ", AnonymousClass000.A09()));
                        return false;
                    }
                }
            } else if (message != null) {
                if (!message.contains("/app/") && !message.contains("/mnt/")) {
                    return false;
                }
                StringBuilder sbA094 = AnonymousClass000.A09();
                sbA094.append("Reunpacking BackupSoSources due to ");
                sbA094.append(soLoaderULError);
                Log.e("SoLoader", AnonymousClass000.A06(", retrying for specific library ", str, sbA094));
                for (C0AD c0ad2 : c0adArr) {
                    if (c0ad2 != null && (c0ad2 instanceof C0CG)) {
                        try {
                            StringBuilder sbA095 = AnonymousClass000.A09();
                            sbA095.append("Preparing BackupSoSource for the first time ");
                            AnonymousClass000.A0J("BackupSoSource", "SoLoader", sbA095);
                            c0ad2.A07(0);
                            for (C0AD c0ad3 : c0adArr) {
                                if (c0ad3 != null && (c0ad3 instanceof C0CJ) && !(c0ad3 instanceof C0CG)) {
                                    ((C0CJ) c0ad3).A00 |= 1;
                                }
                            }
                            return true;
                        } catch (Exception e2) {
                            StringBuilder sbA096 = AnonymousClass000.A09();
                            sbA096.append("Encountered an exception while reunpacking BackupSoSource ");
                            sbA096.append("BackupSoSource");
                            sbA096.append(" for library ");
                            sbA096.append(str);
                            Log.e("SoLoader", AnonymousClass000.A07(": ", sbA096), e2);
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }
}
