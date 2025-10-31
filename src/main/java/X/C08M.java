package X;

/* renamed from: X.08M, reason: invalid class name */
/* loaded from: classes.dex */
public final class C08M {
    public static final C08M A01 = new C08M("");
    public final String A00;

    public final boolean equals(Object obj) {
        return this == obj || (obj != null && getClass() == obj.getClass() && this.A00.equals(((C08M) obj).A00));
    }

    public final int hashCode() {
        return this.A00.hashCode();
    }

    public C08M(String str) {
        if (str.contains(":")) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.A00 = str;
    }

    public final String toString() {
        return this.A00;
    }
}
