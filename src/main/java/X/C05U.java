package X;

import android.text.TextUtils;
import android.util.Base64;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: X.05U, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C05U {
    public static String A00(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Base64.encodeToString(((InetAddress) it.next()).getAddress(), 3));
        }
        return TextUtils.join(";", arrayList);
    }

    public static List A01(String str, String str2) throws UnknownHostException {
        if (TextUtils.isEmpty(str2)) {
            return Collections.emptyList();
        }
        String[] strArrSplit = str2.split(";");
        int length = strArrSplit.length;
        ArrayList arrayList = new ArrayList(length);
        for (String str3 : strArrSplit) {
            try {
                try {
                    arrayList.add(InetAddress.getByAddress(str, Base64.decode(str3, 3)));
                } catch (IllegalArgumentException unused) {
                    throw new UnknownHostException("Failed to decodeSingleAddress an InetAddress");
                }
            } catch (UnknownHostException unused2) {
            }
        }
        if (length != 1 || arrayList.size() != 0) {
            return arrayList;
        }
        String str4 = strArrSplit[0];
        InetAddress byAddress = null;
        if (str4 != null && !str4.isEmpty()) {
            try {
                byAddress = InetAddress.getByAddress(str, InetAddress.getByName(str4).getAddress());
            } catch (UnknownHostException unused3) {
            }
        }
        return byAddress != null ? Collections.singletonList(byAddress) : arrayList;
    }
}
