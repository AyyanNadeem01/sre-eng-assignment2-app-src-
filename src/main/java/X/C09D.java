package X;

import com.facebook.errorreporting.field.ReportFieldString;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* renamed from: X.09D, reason: invalid class name */
/* loaded from: classes.dex */
public final class C09D implements AnonymousClass095 {
    public final File A00;

    @Override // X.AnonymousClass095
    public final void Afg(C05C c05c, AnonymousClass057 anonymousClass057) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        String string;
        C0BX c0bx = C019908u.A04;
        if (c0bx != null) {
            ReportFieldString reportFieldString = AnonymousClass094.A6J;
            File file = this.A00;
            if (file != null) {
                File fileA02 = AnonymousClass000.A02(file, "navmodules.txt");
                string = null;
                try {
                } catch (Exception unused) {
                    C0C5.A00();
                }
                if (fileA02.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileA02));
                        try {
                            String line = bufferedReader.readLine();
                            bufferedReader.close();
                            string = line;
                        } finally {
                        }
                    } catch (IOException e) {
                        C018108b.A0C("lacrima", "Reading granular exposures failed", e);
                        C0C5.A00();
                    }
                }
            } else {
                StringBuilder sb = c0bx.A04;
                synchronized (sb) {
                    string = sb.toString();
                }
            }
            c05c.A04(reportFieldString, string);
        }
    }

    public C09D(File file) {
        this.A00 = file;
    }

    @Override // X.AnonymousClass095
    public final Integer AGY() {
        return AnonymousClass065.A0E;
    }

    public C09D() {
        this.A00 = null;
    }
}
