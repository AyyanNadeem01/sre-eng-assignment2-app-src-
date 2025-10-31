package X;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: X.02H, reason: invalid class name */
/* loaded from: classes.dex */
public final class C02H {
    public final File A00;
    public final String A01;
    public final List A02;
    public final List A03;
    public final List A04;

    public C02H(File file, String str, List list, List list2, List list3) {
        ArrayList arrayList = new ArrayList();
        this.A03 = arrayList;
        this.A01 = str;
        this.A02 = new ArrayList(list);
        this.A04 = new ArrayList(list2);
        this.A00 = file;
        arrayList.addAll(list3);
    }
}
