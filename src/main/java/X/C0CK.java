package X;

import android.os.SystemClock;
import android.os.Trace;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: X.0CK */
/* loaded from: classes.dex */
public final class C0CK {
    public static C0CK A08;
    public static Map A09;
    public static final List A0A = AnonymousClass000.A0B();
    public long A00;
    public C020709f A01;
    public final C010704r A02;
    public final C021509q A03;
    public final File A04;
    public final File A05;
    public final String A06;
    public final String A07;

    public static long A00(File file, String str) {
        String name = file.getName();
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("sess_");
        sbA09.append(str);
        String strReplace = name.replace(AnonymousClass000.A07("_", sbA09), "");
        int iIndexOf = strReplace.indexOf(45);
        if (iIndexOf != -1) {
            strReplace = strReplace.substring(0, iIndexOf);
        }
        try {
            return Long.parseLong(strReplace);
        } catch (NumberFormatException unused) {
            C0C5.A00();
            return 0L;
        }
    }

    public final File A01(String str) {
        File[] fileArrA02 = A02(str);
        int length = fileArrA02.length;
        if (length < 2) {
            return null;
        }
        return fileArrA02[length - 2];
    }

    public final File[] A02(String str) {
        AbstractC017507q.A00(AnonymousClass000.A06("getOrderedSessionDirs.", str, AnonymousClass000.A09()));
        try {
            File[] fileArrListFiles = this.A05.listFiles(new C02710Ck(str, 1));
            if (fileArrListFiles == null) {
                fileArrListFiles = new File[0];
            } else {
                Arrays.sort(fileArrListFiles, new Comparator() { // from class: X.04p
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        File file = (File) obj;
                        File file2 = (File) obj2;
                        int i = (!file.getName().startsWith("session_") ? 1 : 0) - (!file2.getName().startsWith("session_") ? 1 : 0);
                        return i == 0 ? file.getName().compareTo(file2.getName()) : i;
                    }
                });
            }
            return fileArrListFiles;
        } finally {
            Trace.endSection();
        }
    }

    public C0CK(C021509q c021509q, C0AY c0ay, File file, String str, String str2) {
        File fileA02;
        A09 = AnonymousClass000.A0C();
        this.A06 = str2;
        this.A05 = file;
        this.A07 = str;
        synchronized (this) {
            File file2 = this.A05;
            StringBuilder sbA09 = AnonymousClass000.A09();
            StringBuilder sbA092 = AnonymousClass000.A09();
            sbA092.append("sess_");
            sbA092.append(str2);
            sbA09.append(AnonymousClass000.A07("_", sbA092));
            File[] fileArrA02 = A02(str2);
            int length = fileArrA02.length;
            String strValueOf = String.valueOf(length >= 1 ? 1 + A00(fileArrA02[length - 1], str2) : 1L);
            StringBuffer stringBuffer = new StringBuffer(AnonymousClass000.A06("000000000", strValueOf, AnonymousClass000.A09()).substring(strValueOf.length()));
            stringBuffer.append("-");
            stringBuffer.append(str);
            fileA02 = AnonymousClass000.A02(file2, AnonymousClass000.A07(stringBuffer.toString(), sbA09));
            fileA02.mkdirs();
        }
        this.A04 = fileA02;
        this.A03 = c021509q;
        this.A01 = null;
        File fileA022 = AnonymousClass000.A02(fileA02, "state.txt");
        C010604q c010604qA00 = c0ay.A00(fileA022);
        this.A02 = new C010704r(c010604qA00 == null ? new C010604q(fileA022) : c010604qA00);
        this.A00 = SystemClock.uptimeMillis();
        C0BX c0bx = C019908u.A04;
        if (c0bx != null) {
            c0bx.A02 = str;
            c0bx.A07 = fileA02;
        }
        List list = A0A;
        synchronized (list) {
            A08 = this;
            Iterator it = list.iterator();
            if (it.hasNext()) {
                it.next();
                throw new NullPointerException("onSetInstance");
            }
            list.clear();
        }
    }
}
