package X;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.os.Trace;
import com.facebook.common.dextricks.classtracing.logger.ClassTracingLoggerFbLite;
import com.facebook.lite.SharedPreferencesHookA11;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* renamed from: X.0Cb */
/* loaded from: classes.dex */
public class C02620Cb extends C09W {
    public final int $t;
    public final Object A00;

    public C02620Cb(Object obj, int i) {
        this.$t = i;
        this.A00 = obj;
    }

    @Override // X.C09W
    public final Object A00() {
        Object c04q;
        Uri uriA01;
        C02D c02e;
        try {
            switch (this.$t) {
                case 0:
                    return this.A00;
                case SharedPreferencesHookA11.MSG_RUN /* 1 */:
                    return ((C09V) this.A00).get();
                case 2:
                    return new C02C();
                case 3:
                    C0AZ c0az = (C0AZ) this.A00;
                    C09V c02620Cb = c0az.A0A;
                    if (c02620Cb == null) {
                        c02620Cb = new C02620Cb(c0az, 2);
                        c0az.A0A = c02620Cb;
                    }
                    C02C c02c = (C02C) c02620Cb.get();
                    String str = AbstractC008903y.A00;
                    List list = C02L.A03;
                    String str2 = C0AZ.A0Z;
                    if (str != null) {
                        uriA01 = C02M.A01(null, str2).buildUpon().authority(AbstractC008903y.A00).build();
                        c02e = new C07G();
                    } else {
                        uriA01 = C02M.A01(null, str2);
                        c02e = new C02E();
                    }
                    return new C02L(uriA01, c02e, c02c);
                case ClassTracingLoggerFbLite.ENCODED_CLASS_NAMES_LENGTH /* 4 */:
                    C0CK c0ck = ((C0AZ) this.A00).A02;
                    AnonymousClass053.A03(c0ck, "Did you call earlyInit()?");
                    C010704r c010704r = c0ck.A02;
                    AnonymousClass053.A03(c010704r, "Did you call SessionManager.init()?");
                    return new C05G(c010704r.A01.A01);
                case 5:
                    C0AZ c0az2 = (C0AZ) this.A00;
                    C0AZ c0az3 = C0AZ.A0Y;
                    return new AnonymousClass051(c0az2.A0F);
                case 6:
                    Method method = AnonymousClass066.A03;
                    Trace.beginSection("ReportSender");
                    C0AZ c0az4 = (C0AZ) this.A00;
                    Application application = c0az4.A0F;
                    C09V c09v = c0az4.A0U;
                    C09V c09v2 = c0az4.A0L;
                    C09V c09v3 = c0az4.A0K;
                    C09V c09v4 = c0az4.A0S;
                    C09V c02620Cb2 = c0az4.A05;
                    if (c02620Cb2 == null) {
                        c02620Cb2 = new C02620Cb(c0az4, 3);
                        c0az4.A05 = c02620Cb2;
                    }
                    C09V c09vA02 = c0az4.A02();
                    C09V c02620Cb3 = c0az4.A04;
                    if (c02620Cb3 == null) {
                        c02620Cb3 = new C02620Cb(c0az4, 11);
                        c0az4.A04 = c02620Cb3;
                    }
                    c04q = new C0CC(application, (C021509q) c02620Cb3.get(), new Runnable() { // from class: X.02J
                        public static final String __redex_internal_original_name = "LacrimaConfig$2$$ExternalSyntheticLambda0";

                        @Override // java.lang.Runnable
                        public final void run() {
                            C018108b.A08("lacrima", "Deleting report, reached max attempt count");
                        }
                    }, (Executor) c0az4.A0P.get(), c09v, c09v2, c09v3, c09v4, c02620Cb2, c09vA02, c0az4.A0D);
                    break;
                case 7:
                    C0AZ c0az5 = (C0AZ) this.A00;
                    C0AZ c0az6 = C0AZ.A0Y;
                    Application application2 = c0az5.A0F;
                    c0az5.A0N.get();
                    return new Runnable(application2) { // from class: X.05H
                        public static final String __redex_internal_original_name = "ProcessImportanceProvider";
                        public final ActivityManager.RunningAppProcessInfo A00;
                        public final Object A01 = new Object();
                        public final List A02 = new CopyOnWriteArrayList();
                        public final Context A03;

                        @Override // java.lang.Runnable
                        public final void run() throws InterruptedException {
                            int i;
                            boolean z;
                            int i2;
                            while (true) {
                                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = this.A00;
                                synchronized (runningAppProcessInfo) {
                                    i = runningAppProcessInfo.importance;
                                    try {
                                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                                        z = true;
                                        SystemClock.uptimeMillis();
                                        i2 = runningAppProcessInfo.importance;
                                    } catch (RuntimeException e) {
                                        C018108b.A0A(__redex_internal_original_name, "Could not get current importance", e);
                                        z = false;
                                        i2 = i;
                                    }
                                }
                                synchronized (this.A01) {
                                }
                                if (z && i != i2) {
                                    Iterator it = this.A02.iterator();
                                    if (it.hasNext()) {
                                        it.next();
                                        throw new NullPointerException("onImportanceChanged");
                                    }
                                }
                                try {
                                    Thread.sleep(0L);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }

                        public C05H(Context application22) {
                            this.A03 = application22;
                            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                            this.A00 = runningAppProcessInfo;
                            runningAppProcessInfo.importance = 0;
                        }
                    };
                case 8:
                    C0AZ c0az7 = (C0AZ) this.A00;
                    C09V c02620Cb4 = c0az7.A06;
                    if (c02620Cb4 == null) {
                        c02620Cb4 = new C02620Cb(c0az7, 9);
                        c0az7.A06 = c02620Cb4;
                    }
                    return new C011104v((C0AY) c02620Cb4.get());
                case 9:
                    return new C0AY(this);
                case 10:
                    Method method2 = AnonymousClass066.A03;
                    Trace.beginSection("ReportAssembler");
                    C0AZ c0az8 = (C0AZ) this.A00;
                    C0CK c0ck2 = c0az8.A02;
                    AnonymousClass053.A03(c0ck2, "Did you call earlyInit()?");
                    C09V c02620Cb5 = c0az8.A08;
                    if (c02620Cb5 == null) {
                        c02620Cb5 = new C02620Cb(c0az8, 8);
                        c0az8.A08 = c02620Cb5;
                    }
                    c04q = new C04Q((C011104v) c02620Cb5.get(), c0ck2);
                    break;
                default:
                    Method method3 = AnonymousClass066.A03;
                    Trace.beginSection("GlobalCleanup");
                    List list2 = C021509q.A05;
                    C0AZ c0az9 = (C0AZ) this.A00;
                    C0AZ c0az10 = C0AZ.A0Y;
                    Application application3 = c0az9.A0F;
                    c04q = new C021509q(application3, new C021409p(), application3.getDir("errorreporting", 0));
                    break;
            }
            return c04q;
        } finally {
            Trace.endSection();
        }
    }
}
