package X;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/* renamed from: X.02e, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C005002e {
    public final ParcelFileDescriptor A00;
    public final EnumC020309a A01;
    public final C05V A02;
    public final Integer A03;
    public final Integer A04;
    public final String A05;
    public final Socket A06;
    public final ParcelFileDescriptor A07;
    public final Map A08;

    public C005002e(Integer num, Map map) {
        this(null, null, EnumC020309a.NOT_SET, null, AnonymousClass065.A01, num, "", null, map);
    }

    public final long A00(EnumC020409b enumC020409b) {
        Number number = (Number) this.A08.get(enumC020409b);
        if (number != null) {
            return number.longValue();
        }
        return -1L;
    }

    public final void A01() throws IOException {
        try {
            ParcelFileDescriptor parcelFileDescriptor = this.A07;
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
        } catch (IOException e) {
            Log.e("EarlySocket", "Unable to close dupped fd.", e);
        }
    }

    public C005002e(ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2, EnumC020309a enumC020309a, C05V c05v, Integer num, Integer num2, String str, Socket socket, Map map) {
        this.A04 = num;
        this.A03 = num2;
        this.A02 = c05v;
        this.A06 = socket;
        this.A08 = map;
        this.A00 = parcelFileDescriptor;
        this.A07 = parcelFileDescriptor2;
        this.A05 = str;
        this.A01 = enumC020309a;
    }
}
