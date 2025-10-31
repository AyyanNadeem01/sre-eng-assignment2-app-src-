package X;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: X.06b, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C013706b {
    public static final ArrayList A01 = AnonymousClass000.A0B();
    public final long A00;

    public static void A00(long j, String str) {
        FileInputStream fileInputStream;
        if (str != null) {
            synchronized (C013706b.class) {
                ArrayList arrayList = A01;
                if (arrayList.size() <= 0 || ((C013706b) arrayList.get(arrayList.size() - 1)).A00 != j) {
                    try {
                        fileInputStream = new FileInputStream(str);
                    } catch (IOException e) {
                        C018108b.A0K("SigquitRecord", "Could not read from file %s", str, e);
                    }
                    try {
                        if (fileInputStream.read(new byte[8]) != 8) {
                            C018108b.A0K("SigquitRecord", "Corrupted file %s", str);
                        } else {
                            int i = 0;
                            do {
                                i++;
                            } while (i < 8);
                        }
                        fileInputStream.close();
                        arrayList.add(new C013706b(j));
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public C013706b(long j) {
        this.A00 = j;
    }
}
