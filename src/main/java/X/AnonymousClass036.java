package X;

import java.util.HashSet;
import java.util.Set;

/* renamed from: X.036, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass036 {
    public final String A00;
    public final String A01;
    public static final Set A0H = new HashSet();
    public static final AnonymousClass036 A02 = new AnonymousClass036("anr_report_file", "__", false);
    public static final AnonymousClass036 A0C = new AnonymousClass036("minidump_file", "", false);
    public static final AnonymousClass036 A03 = new AnonymousClass036("APP_PROCESS_FILE", "", true);
    public static final AnonymousClass036 A05 = new AnonymousClass036("blackbox_trace_file", "_r_", true);
    public static final AnonymousClass036 A04 = new AnonymousClass036("blackbox_fnrel_trace_file", "_r_", true);
    public static final AnonymousClass036 A07 = new AnonymousClass036("bluetooth_secure_traffic_file", "", true);
    public static final AnonymousClass036 A06 = new AnonymousClass036("bluetooth_insecure_traffic_file", "", true);
    public static final AnonymousClass036 A08 = new AnonymousClass036("CORE_DUMP", "", true);
    public static final AnonymousClass036 A09 = new AnonymousClass036("FAT_MINIDUMP", "", true);
    public static final AnonymousClass036 A0A = new AnonymousClass036("fury_traces_file", "_r_", true);
    public static final AnonymousClass036 A0B = new AnonymousClass036("logcat_file", "", true);
    public static final AnonymousClass036 A0D = new AnonymousClass036("msys_crash_reporter_file", "", true);
    public static final AnonymousClass036 A0E = new AnonymousClass036("properties_file", "", true);
    public static final AnonymousClass036 A0F = new AnonymousClass036("report_source_file", "", true);
    public static final AnonymousClass036 A0G = new AnonymousClass036("system_health_file", "", true);

    public AnonymousClass036(String str, String str2, boolean z) {
        this.A00 = str;
        this.A01 = str2;
        if (z) {
            return;
        }
        A0H.add(str);
    }

    public final String toString() {
        return this.A00;
    }
}
