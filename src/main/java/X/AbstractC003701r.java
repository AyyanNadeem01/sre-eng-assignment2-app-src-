package X;

/* renamed from: X.01r, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC003701r {
    public static final void A00(int i, int i2) {
        if (i <= i2) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("toIndex (");
        sb.append(i);
        sb.append(") is greater than size (");
        sb.append(i2);
        sb.append(").");
        throw new IndexOutOfBoundsException(sb.toString());
    }
}
