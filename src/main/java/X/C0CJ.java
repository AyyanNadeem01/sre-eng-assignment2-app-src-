package X;

import android.os.StrictMode;
import com.facebook.soloader.SoLoaderULErrorFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* renamed from: X.0CJ */
/* loaded from: classes.dex */
public class C0CJ extends C0AD {
    public int A00;
    public final File A01;

    @Override // X.C0AD
    public int A03(StrictMode.ThreadPolicy threadPolicy, String str, int i) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        File file = this.A01;
        if (C0BG.A05 == null) {
            throw AnonymousClass000.A04("SoLoader.init() not yet called");
        }
        File fileA04 = A04(str);
        if (fileA04 == null) {
            file.getCanonicalPath();
            AbstractC02460Bh.A00("SoLoader");
            return 0;
        }
        String canonicalPath = fileA04.getCanonicalPath();
        AbstractC02460Bh.A00("SoLoader");
        if ((i & 1) != 0 && (this.A00 & 2) != 0) {
            AbstractC02460Bh.A00("SoLoader");
            return 2;
        }
        if ((this.A00 & 1) != 0) {
            C013105t c013105t = new C013105t();
            c013105t.A00 = fileA04;
            FileInputStream fileInputStream = new FileInputStream(fileA04);
            c013105t.A01 = fileInputStream;
            c013105t.A02 = fileInputStream.getChannel();
            try {
                C0BT.A04(threadPolicy, c013105t, str, i);
                c013105t.close();
            } catch (Throwable th) {
                try {
                    c013105t.close();
                    throw th;
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    throw th;
                }
            }
        } else {
            AbstractC02460Bh.A00("SoLoader");
        }
        try {
            C0BG.A05.load(canonicalPath, i);
            return 1;
        } catch (UnsatisfiedLinkError e) {
            throw SoLoaderULErrorFactory.create(str, e);
        }
    }

    @Override // X.C0AD
    public final File A04(String str) {
        File fileA02 = AnonymousClass000.A02(this.A01, str);
        if (fileA02.exists()) {
            return fileA02;
        }
        return null;
    }

    @Override // X.C0AD
    public String toString() {
        String name;
        try {
            name = String.valueOf(this.A01.getCanonicalPath());
        } catch (IOException unused) {
            name = this.A01.getName();
        }
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append(A05());
        sbA09.append("[root = ");
        sbA09.append(name);
        sbA09.append(" flags = ");
        sbA09.append(this.A00);
        sbA09.append(']');
        return sbA09.toString();
    }

    public C0CJ(File file, int i) {
        this.A01 = file;
        this.A00 = i;
    }

    @Override // X.C0AD
    public String A06(String str) {
        File fileA04 = A04(str);
        if (fileA04 == null) {
            return null;
        }
        return fileA04.getCanonicalPath();
    }

    @Override // X.C0AD
    public final String[] A08(String str) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        File fileA04 = A04(str);
        if (fileA04 == null) {
            return null;
        }
        C013105t c013105t = new C013105t();
        c013105t.A00 = fileA04;
        FileInputStream fileInputStream = new FileInputStream(fileA04);
        c013105t.A01 = fileInputStream;
        c013105t.A02 = fileInputStream.getChannel();
        try {
            String[] strArrA08 = C0BT.A08(c013105t, str);
            c013105t.close();
            return strArrA08;
        } catch (Throwable th) {
            try {
                c013105t.close();
                throw th;
            } catch (Throwable th2) {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                throw th;
            }
        }
    }

    @Override // X.C0AD
    public String A05() {
        return "DirectorySoSource";
    }
}
