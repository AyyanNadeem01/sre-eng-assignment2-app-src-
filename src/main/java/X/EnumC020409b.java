package X;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: X.09b, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC020409b {
    public static final /* synthetic */ EnumC020409b[] A00;
    public static final EnumC020409b A01;
    public static final EnumC020409b A02;
    public static final EnumC020409b A03;

    static {
        EnumC020409b enumC020409b = new EnumC020409b("TIME_TO_PARAMS", 0);
        A02 = enumC020409b;
        EnumC020409b enumC020409b2 = new EnumC020409b("TIME_TO_SOCKET_CONNECTED", 1);
        A03 = enumC020409b2;
        EnumC020409b enumC020409b3 = new EnumC020409b("REFERENCE_TIME", 2);
        A01 = enumC020409b3;
        EnumC020409b enumC020409b4 = new EnumC020409b("TIME_TO_GET_SOCKET_COUNT", 3);
        EnumC020409b enumC020409b5 = new EnumC020409b("TIME_TO_MAGIC_ENABLED", 4);
        EnumC020409b[] enumC020409bArr = new EnumC020409b[5];
        enumC020409bArr[0] = enumC020409b;
        AnonymousClass000.A0H(enumC020409b2, enumC020409b3, enumC020409bArr);
        enumC020409bArr[3] = enumC020409b4;
        enumC020409bArr[4] = enumC020409b5;
        A00 = enumC020409bArr;
    }

    public static EnumC020409b valueOf(String str) {
        return (EnumC020409b) Enum.valueOf(EnumC020409b.class, str);
    }

    public static EnumC020409b[] values() {
        return (EnumC020409b[]) A00.clone();
    }

    public EnumC020409b(String str, int i) {
    }
}
