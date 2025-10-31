package X;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/* renamed from: X.0A5, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0A5 {
    public Context A01;
    public C05P A03;
    public boolean A05;
    public Map A04 = AnonymousClass000.A0C();
    public EnumC020309a A02 = EnumC020309a.NOT_SET;
    public int A00 = 2;

    public static C005002e A00(C0A5 c0a5, Exception exc, Integer num, String str, Socket socket) {
        try {
            try {
                Log.e("EarlySocket", str, exc);
                socket.close();
            } catch (IOException e) {
                Log.e("EarlySocket", "Unable to close EarlySocket.", e);
            }
            return new C005002e(num, c0a5.A04);
        } catch (Throwable unused) {
            return new C005002e(num, c0a5.A04);
        }
    }
}
