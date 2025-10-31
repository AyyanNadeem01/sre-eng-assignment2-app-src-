package X;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* renamed from: X.02h, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C005302h implements InterfaceC005202g {
    public Iterator A00;
    public final Map A01;

    @Override // X.InterfaceC005202g
    public final void reset() {
        this.A00 = null;
    }

    @Override // X.InterfaceC005202g
    public final void A39(Properties properties) {
        this.A01.putAll(properties);
    }

    @Override // X.InterfaceC005202g
    public final boolean AGl(C005802m c005802m) {
        Iterator it = this.A00;
        if (it == null) {
            it = this.A01.entrySet().iterator();
            this.A00 = it;
        }
        if (!it.hasNext()) {
            return false;
        }
        Map.Entry entry = (Map.Entry) this.A00.next();
        c005802m.A00 = entry.getKey().toString();
        c005802m.A01 = entry.getValue().toString();
        return true;
    }

    public C005302h(Properties properties) {
        this.A01 = properties;
    }

    @Override // X.InterfaceC005202g
    public final String[] AI1(List list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Object obj = this.A01.get(list.get(i));
            strArr[i] = obj != null ? obj.toString() : null;
        }
        return strArr;
    }

    public C005302h() {
        this.A01 = new Properties();
    }
}
