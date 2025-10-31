package X;

import android.net.Uri;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/* renamed from: X.02L */
/* loaded from: classes.dex */
public final class C02L {
    public static final List A03 = Arrays.asList("log_type", "build_id", "app_id", "user_id", "device_id", AnonymousClass094.A0A.name);
    public final Uri A00;
    public final C02D A01;
    public final C02C A02;

    public static void A00(OutputStream outputStream, String str, String str2, String str3) throws IOException {
        outputStream.write(String.format("--%s\r\nContent-Disposition: %s\"%s\"\r\nContent-Type: application/binary\r\nContent-Transfer-Encoding: binary\r\n\r\n", str3, "form-data; name=", str).getBytes());
        outputStream.write(str2.getBytes("UTF-8"));
        outputStream.write("\r\n".getBytes());
    }

    /* JADX WARN: Removed duplicated region for block: B:317:0x0307 A[Catch: all -> 0x032a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x032a, blocks: (B:260:0x01bd, B:317:0x0307, B:333:0x0329, B:332:0x0326, B:330:0x0321, B:261:0x01c1, B:263:0x01c6, B:315:0x0302, B:327:0x031d, B:326:0x031a), top: B:345:0x01bd, inners: #2, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x030f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:377:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A01(X.InterfaceC005202g r21, java.util.Map r22, int r23) throws org.json.JSONException, java.net.ProtocolException {
        /*
            Method dump skipped, instructions count: 815
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C02L.A01(X.02g, java.util.Map, int):boolean");
    }

    public C02L(Uri uri, C02D c02d, C02C c02c) {
        this.A00 = uri;
        this.A01 = c02d;
        this.A02 = c02c;
    }
}
