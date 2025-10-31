package X;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: X.0CC */
/* loaded from: classes.dex */
public final class C0CC {
    public static int A0G;
    public static boolean A0H;
    public C02L A00;
    public ScheduledExecutorService A01;
    public final int A02;
    public final Context A03;
    public final C021509q A04;
    public final C02B A05;
    public final C02K A06;
    public final Runnable A07;
    public final Set A08;
    public final Executor A09;
    public final AtomicInteger A0A;
    public final C09V A0B;
    public final C09V A0C;
    public final C09V A0D;
    public final C09V A0E;
    public final C09V A0F;

    public static File A01(File file, String str) {
        File[] fileArrListFiles = file.listFiles(new C02710Ck(str, 0));
        if (fileArrListFiles == null || fileArrListFiles.length != 1) {
            return null;
        }
        return fileArrListFiles[0];
    }

    public static final int A00(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles(new C005702l());
        int length = (fileArrListFiles == null ? 0 : fileArrListFiles.length) + 1;
        A01(file, "_report.txt");
        AnonymousClass000.A02(file, AnonymousClass000.A08("_attempt", AnonymousClass000.A09(), length)).createNewFile();
        return length;
    }

    /* JADX WARN: Removed duplicated region for block: B:366:0x0142 A[Catch: all -> 0x027d, IOException -> 0x0285, TryCatch #4 {IOException -> 0x0285, blocks: (B:312:0x0017, B:314:0x0020, B:315:0x002f, B:319:0x003d, B:322:0x004d, B:323:0x005f, B:325:0x0074, B:364:0x0135, B:366:0x0142, B:377:0x0181, B:370:0x015e, B:372:0x0165, B:374:0x016c, B:380:0x0197, B:381:0x019a, B:402:0x0243, B:404:0x0256, B:405:0x025d, B:407:0x0274, B:410:0x0279, B:411:0x027c, B:401:0x023f, B:363:0x012d, B:318:0x003c), top: B:426:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A02(final X.InterfaceC005202g r21, final X.C0CC r22, final X.C02F r23, final java.io.File r24) {
        /*
            Method dump skipped, instructions count: 653
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C0CC.A02(X.02g, X.0CC, X.02F, java.io.File):void");
    }

    public C0CC(Context context, C021509q c021509q, Runnable runnable, Executor executor, C09V c09v, C09V c09v2, C09V c09v3, C09V c09v4, C09V c09v5, C09V c09v6, int i) {
        C02K c02k = new C02K();
        this.A08 = new HashSet();
        this.A0A = new AtomicInteger();
        this.A03 = context;
        this.A0F = c09v;
        this.A0C = c09v2;
        this.A0B = c09v3;
        this.A0D = c09v4;
        this.A05 = new C02B(c09v6);
        this.A04 = c021509q;
        this.A09 = executor;
        this.A07 = runnable;
        this.A02 = i;
        this.A06 = c02k;
        this.A0E = c09v6;
        this.A00 = (C02L) c09v5.get();
    }
}
