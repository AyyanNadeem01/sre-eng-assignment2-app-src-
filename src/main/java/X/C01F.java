package X;

/* renamed from: X.01F, reason: invalid class name */
/* loaded from: classes.dex */
public enum C01F {
    YES,
    NO,
    UNSET;

    public final boolean A00() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal == 1 || iOrdinal == 2) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized TriState value: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }
}
