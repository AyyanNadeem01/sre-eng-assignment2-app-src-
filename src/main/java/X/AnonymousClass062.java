package X;

/* renamed from: X.062, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass062 extends RuntimeException {
    public AnonymousClass062() {
        super("Redex: Unreachable code. This should never get triggered.");
    }

    public static AnonymousClass062 createAndThrow() {
        throw new AnonymousClass062();
    }
}
