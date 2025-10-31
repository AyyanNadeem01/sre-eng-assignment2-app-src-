package X;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: X.08K, reason: invalid class name */
/* loaded from: classes.dex */
public final class C08K {
    public static final /* synthetic */ InterfaceC000300g A00;
    public static final /* synthetic */ C08K[] A01;
    public static final C08K A02;
    public static final C08K A03;
    public static final C08K A04;

    static {
        C08K c08k = new C08K("RUNNING_CRITICAL", 0);
        C08K c08k2 = new C08K("RUNNING_MODERATE", 1);
        C08K c08k3 = new C08K("RUNNING_LOW", 2);
        C08K c08k4 = new C08K("BACKGROUND", 3);
        C08K c08k5 = new C08K("MODERATE", 4);
        C08K c08k6 = new C08K("COMPLETE", 5);
        A02 = c08k6;
        C08K c08k7 = new C08K("UI_HIDDEN", 6);
        A04 = c08k7;
        C08K c08k8 = new C08K("JAVA_HEAP_ALMOST_FULL", 7);
        A03 = c08k8;
        C08K[] c08kArr = new C08K[8];
        c08kArr[0] = c08k;
        AnonymousClass000.A0H(c08k2, c08k3, c08kArr);
        c08kArr[3] = c08k4;
        c08kArr[4] = c08k5;
        c08kArr[5] = c08k6;
        c08kArr[6] = c08k7;
        c08kArr[7] = c08k8;
        A01 = c08kArr;
        A00 = C00b.A00(c08kArr);
    }

    public static C08K valueOf(String str) {
        return (C08K) Enum.valueOf(C08K.class, str);
    }

    public static C08K[] values() {
        return (C08K[]) A01.clone();
    }

    public C08K(String str, int i) {
    }
}
