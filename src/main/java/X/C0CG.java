package X;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: X.0CG, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0CG extends C0CI implements C0BS {
    public boolean A00;
    public final ArrayList A01;

    @Override // X.C0CJ, X.C0AD
    public final int A03(StrictMode.ThreadPolicy threadPolicy, String str, int i) {
        if (this.A00) {
            return super.A03(threadPolicy, str, i);
        }
        return 0;
    }

    @Override // X.C0CI, X.C0AD
    public final void A07(int i) throws IOException {
        if ((i & 8) == 0) {
            super.A07(i);
            this.A00 = true;
        }
    }

    @Override // X.C0CI
    public final C0CM A09() {
        return new C0CL(this);
    }

    @Override // X.C0CI
    public final C0Bz[] A0B() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C02500Bl c02500Bl = (C02500Bl) this.A01.get(0);
        C02560Bt c02560Bt = new C02560Bt(c02500Bl, c02500Bl);
        try {
            C0Bz[] c0BzArrA02 = c02560Bt.A02();
            c02560Bt.close();
            return c0BzArrA02;
        } catch (Throwable th) {
            try {
                c02560Bt.close();
                throw th;
            } catch (Throwable th2) {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                throw th;
            }
        }
    }

    @Override // X.C0BS
    public final C0AD Ah9(ApplicationInfo applicationInfo) {
        C0CG c0cg = new C0CG(((C0CI) this).A01, applicationInfo, ((C0CJ) this).A01.getName(), true);
        try {
            c0cg.A07(0);
            return c0cg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public C0CG(Context context, ApplicationInfo applicationInfo, String str, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, str, z);
        ArrayList arrayListA0B = AnonymousClass000.A0B();
        this.A01 = arrayListA0B;
        this.A00 = false;
        arrayListA0B.add(new C02500Bl(context, AnonymousClass000.A03(applicationInfo.sourceDir), str, "^lib/([^/]+)/([^/]+\\.so)$"));
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            try {
                for (String str2 : strArr) {
                    C02500Bl c02500Bl = new C02500Bl(context, AnonymousClass000.A03(str2), str, "^lib/([^/]+)/([^/]+\\.so)$");
                    C02560Bt c02560Bt = new C02560Bt(c02500Bl, c02500Bl);
                    try {
                        boolean zA0O = AnonymousClass000.A0O(c02560Bt.A03().length);
                        c02560Bt.close();
                        if (zA0O) {
                            StringBuilder sbA09 = AnonymousClass000.A09();
                            sbA09.append("adding backup source from split: ");
                            AnonymousClass000.A0K(c02500Bl.toString(), "BackupSoSource", sbA09);
                            this.A01.add(c02500Bl);
                        }
                    } catch (Throwable th) {
                        try {
                            c02560Bt.close();
                        } catch (Throwable th2) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        }
                        throw th;
                    }
                }
            } catch (IOException e) {
                Log.w("BackupSoSource", "failed to read split apks", e);
            }
        }
    }

    @Override // X.C0CI
    public final byte[] A0A() {
        byte[] bArrMarshall;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeByte((byte) 3);
            Context context = ((C0CI) this).A01;
            PackageManager packageManager = context.getPackageManager();
            int i = 0;
            if (packageManager != null) {
                try {
                    i = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                }
            }
            parcelObtain.writeInt(i);
            ArrayList arrayList = this.A01;
            parcelObtain.writeInt(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                parcelObtain.writeByteArray(((C02500Bl) it.next()).A0A());
            }
            String str = context.getApplicationInfo().sourceDir;
            if (str == null) {
                parcelObtain.writeByte((byte) 1);
                bArrMarshall = parcelObtain.marshall();
            } else {
                File canonicalFile = AnonymousClass000.A03(str).getCanonicalFile();
                if (canonicalFile.exists()) {
                    parcelObtain.writeByte((byte) 2);
                    parcelObtain.writeString(canonicalFile.getPath());
                    parcelObtain.writeLong(canonicalFile.lastModified());
                    bArrMarshall = parcelObtain.marshall();
                } else {
                    parcelObtain.writeByte((byte) 1);
                    bArrMarshall = parcelObtain.marshall();
                }
            }
            return bArrMarshall;
        } finally {
            parcelObtain.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.File] */
    @Override // X.C0CJ, X.C0AD
    public final String toString() throws IOException {
        String name;
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("BackupSoSource");
        sbA09.append("[root = ");
        File canonicalPath = ((C0CJ) this).A01;
        try {
            canonicalPath = canonicalPath.getCanonicalPath();
            name = canonicalPath;
        } catch (IOException unused) {
            name = canonicalPath.getName();
        }
        sbA09.append(name);
        sbA09.append(" flags = ");
        sbA09.append(((C0CJ) this).A00);
        sbA09.append(" apks = ");
        AnonymousClass000.A0L(sbA09, this.A01);
        return AnonymousClass000.A07("]", sbA09);
    }

    @Override // X.C0CJ, X.C0AD
    public final String A05() {
        return "BackupSoSource";
    }
}
