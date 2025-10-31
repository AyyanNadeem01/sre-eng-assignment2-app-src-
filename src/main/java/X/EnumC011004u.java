package X;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'A0E' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: X.04u, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC011004u {
    public static final /* synthetic */ EnumC011004u[] A03;
    public static final EnumC011004u A04;
    public static final EnumC011004u A05;
    public static final EnumC011004u A06;
    public static final EnumC011004u A07;
    public static final EnumC011004u A08;
    public static final EnumC011004u A09;
    public static final EnumC011004u A0A;
    public static final EnumC011004u A0B;
    public static final EnumC011004u A0C;
    public static final EnumC011004u A0D;
    public static final EnumC011004u A0E;
    public Integer A00;
    public final char A01;
    public final String A02;

    static {
        Integer num = AnonymousClass065.A00;
        EnumC011004u enumC011004u = new EnumC011004u(num, "NO_STATUS", "No status", '0', 0);
        A0E = enumC011004u;
        EnumC011004u enumC011004u2 = new EnumC011004u(num, "INITIAL", "Initial", 'i', 1);
        A0B = enumC011004u2;
        Integer num2 = AnonymousClass065.A01;
        EnumC011004u enumC011004u3 = new EnumC011004u(num2, "JAVA_CRASH", "JavaCrash", 'j', 2);
        A0C = enumC011004u3;
        Integer num3 = AnonymousClass065.A0C;
        EnumC011004u enumC011004u4 = new EnumC011004u(num3, "NATIVE_CRASH_SIGSEGV", "NativeCrash_SIGSEGV", 's', 3);
        EnumC011004u enumC011004u5 = new EnumC011004u(num3, "NATIVE_CRASH_SIGABRT", "NativeCrash_SIGABRT", 'a', 4);
        EnumC011004u enumC011004u6 = new EnumC011004u(num3, "NATIVE_CRASH_SIGFPE", "NativeCrash_SIGFPE", 'f', 5);
        EnumC011004u enumC011004u7 = new EnumC011004u(num3, "NATIVE_CRASH_SIGILL", "NativeCrash_SIGILL", 'l', 6);
        EnumC011004u enumC011004u8 = new EnumC011004u(num3, "NATIVE_CRASH_SIGBUS", "NativeCrash_SIGBUS", 'b', 7);
        EnumC011004u enumC011004u9 = new EnumC011004u(num3, "NATIVE_CRASH_SIGTRAP", "NativeCrash_SIGTRAP", 'T', 8);
        EnumC011004u enumC011004u10 = new EnumC011004u(num3, "NATIVE_CRASH_SIGXFSZ", "NativeCrash_SIGXFSZ", 'z', 9);
        EnumC011004u enumC011004u11 = new EnumC011004u(num3, "NATIVE_CRASH_SIGXCPU", "NativeCrash_SIGXCPU", 'p', 10);
        EnumC011004u enumC011004u12 = new EnumC011004u(num3, "NATIVE_CRASH_SIGSYS", "NativeCrash_SIGSYS", 'y', 11);
        EnumC011004u enumC011004u13 = new EnumC011004u(num3, "NATIVE_CRASH_SIGSTKFLT", "NativeCrash_SIGSTKFLT", 'S', 12);
        EnumC011004u enumC011004u14 = new EnumC011004u(num3, "NATIVE_CRASH_SIGHUP", "NativeCrash_SIGHUP", 'h', 13);
        EnumC011004u enumC011004u15 = new EnumC011004u(num3, "NATIVE_CRASH_SIGINT", "NativeCrash_SIGINT", 'I', 14);
        EnumC011004u enumC011004u16 = new EnumC011004u(num3, "NATIVE_CRASH_SIGUSR2", "NativeCrash_SIGUSR2", '2', 15);
        EnumC011004u enumC011004u17 = new EnumC011004u(num3, "NATIVE_CRASH_SIGALRM", "NativeCrash_SIGALRM", 'L', 16);
        EnumC011004u enumC011004u18 = new EnumC011004u(num3, "NATIVE_CRASH_SIGTERM", "NativeCrash_SIGTERM", 'e', 17);
        EnumC011004u enumC011004u19 = new EnumC011004u(num3, "NATIVE_CRASH_SIGVTALRM", "NativeCrash_SIGVTALRM", 'v', 18);
        EnumC011004u enumC011004u20 = new EnumC011004u(num3, "NATIVE_CRASH_SIGPROF", "NativeCrash_SIGPROF", 'P', 19);
        EnumC011004u enumC011004u21 = new EnumC011004u(num3, "NATIVE_CRASH_SIGIO", "NativeCrash_SIGIO", 'o', 20);
        EnumC011004u enumC011004u22 = new EnumC011004u(num3, "NATIVE_CRASH_SIGPWR", "NativeCrash_SIGPWR", 'W', 21);
        EnumC011004u enumC011004u23 = new EnumC011004u(num3, "NATIVE_CRASH_OTHER", "NativeCrash_Other", 'n', 22);
        EnumC011004u enumC011004u24 = new EnumC011004u(num2, "JAVA_EXIT", "JavaExit", 'x', 23);
        EnumC011004u enumC011004u25 = new EnumC011004u(num2, "JAVA_EXIT_WITH_USER_KNOWLEDGE_AND_CONSENT_NOT_A_FAD", "JavaExitNotAFad", 'N', 24);
        A0D = enumC011004u25;
        EnumC011004u enumC011004u26 = new EnumC011004u(num3, "NATIVE_EXIT", "NativeExit", 'X', 25);
        EnumC011004u enumC011004u27 = new EnumC011004u(num3, "SELF_SIGKILL", "SelfSigKill", '9', 26);
        EnumC011004u enumC011004u28 = new EnumC011004u(num3, "SELF_SIGSTOP", "SelfSigStop", 't', 27);
        Integer num4 = AnonymousClass065.A0N;
        EnumC011004u enumC011004u29 = new EnumC011004u(num4, "ANR", "ANR", 'r', 28);
        A04 = enumC011004u29;
        EnumC011004u enumC011004u30 = new EnumC011004u(num4, "ANR_RECOVERED", "ANRRecovered", 'c', 29);
        A09 = enumC011004u30;
        EnumC011004u enumC011004u31 = new EnumC011004u(num4, "ANR_SIGQUIT_NATIVE", "ANR_SIGQUIT", 'Q', 30);
        EnumC011004u enumC011004u32 = new EnumC011004u(num4, "ANR_SIGQUIT", "AnrSigquit", 'q', 31);
        A0A = enumC011004u32;
        EnumC011004u enumC011004u33 = new EnumC011004u(num4, "ANR_MT_UNBLOCKED", "AnrMtUnblocked", 'u', 32);
        A08 = enumC011004u33;
        EnumC011004u enumC011004u34 = new EnumC011004u(num4, "ANR_AM_CONFIRMED", "AnrAmConfirmed", 'R', 33);
        A05 = enumC011004u34;
        EnumC011004u enumC011004u35 = new EnumC011004u(num4, "ANR_AM_CONFIRMED_MT_UNBLOCKED", "AnrAmConfirmedMtUnblocked", 'U', 34);
        A06 = enumC011004u35;
        EnumC011004u enumC011004u36 = new EnumC011004u(num4, "ANR_AM_EXPIRED", "AnrAmExpired", 'm', 35);
        A07 = enumC011004u36;
        A03 = new EnumC011004u[]{enumC011004u, enumC011004u2, enumC011004u3, enumC011004u4, enumC011004u5, enumC011004u6, enumC011004u7, enumC011004u8, enumC011004u9, enumC011004u10, enumC011004u11, enumC011004u12, enumC011004u13, enumC011004u14, enumC011004u15, enumC011004u16, enumC011004u17, enumC011004u18, enumC011004u19, enumC011004u20, enumC011004u21, enumC011004u22, enumC011004u23, enumC011004u24, enumC011004u25, enumC011004u26, enumC011004u27, enumC011004u28, enumC011004u29, enumC011004u30, enumC011004u31, enumC011004u32, enumC011004u33, enumC011004u34, enumC011004u35, enumC011004u36, new EnumC011004u(num2, "APPSTATELOGGER_CRASH", "AppStateLoggerCrash", 'C', 36), new EnumC011004u(num3, "PREALLOCATED_OOME", "PreallocatedOOME", 'O', 37)};
    }

    public static EnumC011004u[] values() {
        return (EnumC011004u[]) A03.clone();
    }

    public EnumC011004u(Integer num, String str, String str2, char c, int i) {
        this.A01 = c;
        this.A02 = str2;
        this.A00 = num;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.A02;
    }
}
