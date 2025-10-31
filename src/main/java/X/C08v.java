package X;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/* renamed from: X.08v, reason: invalid class name */
/* loaded from: classes.dex */
public final class C08v {
    public static PrintWriter A00;
    public static StringWriter A01;

    static {
        StringWriter stringWriter = new StringWriter(16000);
        A01 = stringWriter;
        A00 = new PrintWriter(stringWriter);
    }

    public static String A01(Throwable th) throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    public static String A00(String str, int i) {
        int i2;
        int iLastIndexOf;
        int iIndexOf;
        int length = str.length();
        if (length <= i || (iLastIndexOf = str.lastIndexOf("\n", (i2 = (i * 3) / 4))) < 0 || (iIndexOf = str.indexOf("\n", length - (i - i2))) < 0) {
            return str;
        }
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append(str.substring(0, iLastIndexOf + 1));
        sbA09.append("\t");
        sbA09.append("--------- TRIMMED FOR OVERFLOW ---------");
        return AnonymousClass000.A07(str.substring(iIndexOf), sbA09);
    }
}
