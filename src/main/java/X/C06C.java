package X;

/* renamed from: X.06C, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C06C {
    public static final String A00(AnonymousClass003 anonymousClass003) {
        String string = anonymousClass003.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
