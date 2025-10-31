package X;

/* renamed from: X.05N, reason: invalid class name */
/* loaded from: classes.dex */
public enum C05N {
    TUNNEL(""),
    /* JADX INFO: Fake field, exist only in values array */
    TUNNEL_WITH_LITE_ALPN("lite"),
    HTTP2_CONNECT("h2"),
    HTTP3_CONNECT("h2"),
    /* JADX INFO: Fake field, exist only in values array */
    DGW("h2");

    public final String A00;

    public static C05N A00(String str) {
        if (str != null) {
            for (C05N c05n : values()) {
                if (c05n.name().equalsIgnoreCase(str)) {
                    return c05n;
                }
            }
        }
        return TUNNEL;
    }

    C05N(String str) {
        this.A00 = str;
    }
}
