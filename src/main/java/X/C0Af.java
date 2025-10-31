package X;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: X.0Af, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0Af {
    public static Map A02;
    public static final /* synthetic */ C0Af[] A03;
    public static final C0Af A04;
    public final String A00;
    public final String A01;

    static {
        C0Af c0Af = new C0Af("SUPERPACK_XZ", 0, "assets/lib/libs.spk.xz", ".spk.xz");
        C0Af c0Af2 = new C0Af("SUPERPACK_ZSTD", 1, "assets/lib/libs.spk.zst", ".spk.zst");
        C0Af c0Af3 = new C0Af("SUPERPACK_BR", 2, "assets/lib/libs.spk.br", ".spk.br");
        C0Af c0Af4 = new C0Af("SUPERPACK_OB", 3, "assets/lib/libs.spo", ".spo");
        A04 = c0Af4;
        C0Af[] c0AfArr = new C0Af[4];
        c0AfArr[0] = c0Af;
        AnonymousClass000.A0H(c0Af2, c0Af3, c0AfArr);
        c0AfArr[3] = c0Af4;
        A03 = c0AfArr;
        HashMap mapA0C = AnonymousClass000.A0C();
        A02 = mapA0C;
        mapA0C.put(".spk.xz", c0Af);
        A02.put(".spk.zst", c0Af2);
        A02.put(".spk.br", c0Af3);
        A02.put(".spo", c0Af4);
    }

    public static C0Af A00() {
        if (".spk.xz".isEmpty()) {
            return null;
        }
        C0Af c0Af = (C0Af) A02.get(".spk.xz");
        if (c0Af == null) {
            throw new RuntimeException(AnonymousClass000.A06("Invalid libs compression type: ", ".spk.xz", AnonymousClass000.A09()));
        }
        return c0Af;
    }

    public static C0Af valueOf(String str) {
        return (C0Af) Enum.valueOf(C0Af.class, str);
    }

    public static C0Af[] values() {
        return (C0Af[]) A03.clone();
    }

    public C0Af(String str, int i, String str2, String str3) {
        this.A00 = str2;
        this.A01 = str3;
    }
}
