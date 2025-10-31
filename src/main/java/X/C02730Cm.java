package X;

import android.app.Application;
import android.os.Trace;
import com.facebook.breakpad.BreakpadManager;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: X.0Cm */
/* loaded from: classes.dex */
public class C02730Cm implements C0AT {
    public final int $t;
    public final Object A00;

    public C02730Cm(Application application) {
        this.$t = 0;
        this.A00 = application;
    }

    @Override // X.C0AT
    public final C0AX AGW() {
        return this.$t != 0 ? C0AX.A07 : C0AX.A0G;
    }

    @Override // X.C0AT
    public final Integer AL6() {
        return this.$t != 0 ? ((C0AT) this.A00).AL6() : AnonymousClass065.A01;
    }

    @Override // X.C0AT
    public final void AMX(C0AZ c0az) {
        boolean zExists;
        FileInputStream fileInputStreamOpenFileInput;
        DataInputStream dataInputStream;
        try {
            if (this.$t != 0) {
                C0AT c0at = (C0AT) this.A00;
                if (c0at.AL6() != AnonymousClass065.A0C) {
                    c0at.AMX(c0az);
                    return;
                }
                Method method = AnonymousClass066.A03;
                Trace.beginSection("LacrimaInit.jvmStreamEnabled");
                try {
                    boolean z = C0C9.A07;
                    String property = System.getProperty("java.vm.version");
                    if (property != null && !property.startsWith("1.") && !property.startsWith("0.")) {
                        C0BG.A0B("android_aware_dlopen", 16);
                        C0BG.A0B("force_dlopen", 16);
                    }
                    c0at.AMX(c0az);
                } catch (Exception | UnsatisfiedLinkError e) {
                    C018108b.A0C("LacrimaInit", "Error enabling jvm stream", e);
                }
            } else {
                AnonymousClass089.A00();
                Method method2 = AnonymousClass066.A03;
                Trace.beginSection("BreakpadManager.start");
                Application application = (Application) this.A00;
                int iIntValue = 1;
                Map map = C03F.A00;
                Integer num = (Integer) map.get("breakpad_write_only_crash_thread");
                if (num != null) {
                    iIntValue = num.intValue();
                } else {
                    try {
                        zExists = AnonymousClass000.A02(AnonymousClass000.A02(application.getFilesDir(), "GkBootstrap"), "breakpad_write_only_crash_thread").exists();
                    } catch (IOException unused) {
                    }
                    try {
                        try {
                            if (zExists) {
                                fileInputStreamOpenFileInput = new FileInputStream(AnonymousClass000.A02(AnonymousClass000.A02(application.getFilesDir(), "GkBootstrap"), "breakpad_write_only_crash_thread"));
                            } else {
                                if (AnonymousClass000.A02(application.getFilesDir(), "breakpad_write_only_crash_thread").exists()) {
                                    fileInputStreamOpenFileInput = application.openFileInput("breakpad_write_only_crash_thread");
                                }
                                map.put("breakpad_write_only_crash_thread", Integer.valueOf(iIntValue));
                            }
                            int i = dataInputStream.readInt();
                            if (!zExists) {
                                C03F.A00(application, i);
                            }
                            dataInputStream.close();
                            if (!zExists) {
                                try {
                                    application.deleteFile("breakpad_write_only_crash_thread");
                                } catch (SecurityException unused2) {
                                }
                            }
                            iIntValue = i;
                            map.put("breakpad_write_only_crash_thread", Integer.valueOf(iIntValue));
                        } finally {
                        }
                        dataInputStream = new DataInputStream(fileInputStreamOpenFileInput);
                    } catch (Throwable th) {
                        if (!zExists) {
                            try {
                                application.deleteFile("breakpad_write_only_crash_thread");
                            } catch (SecurityException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                BreakpadManager.start(application, iIntValue == 1 ? 0L : 1L, 1536000, null, null, false);
                BreakpadManager.setCustomData(AnonymousClass094.A4p.name, (String) c0az.A0R.get(), new Object[0]);
            }
        } finally {
            Trace.endSection();
        }
    }

    public C02730Cm() {
        this.$t = 1;
        this.A00 = new C02720Cl(0);
    }
}
