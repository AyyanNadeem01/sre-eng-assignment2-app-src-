package X;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: X.00c, reason: invalid class name */
/* loaded from: classes.dex */
public final class C00c {
    public int A00;
    public int A01;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public C03g A0B;
    public File A0C;
    public Long A0D;
    public Long A0E;
    public Long A0F;
    public Long A0G;
    public String A0H;
    public String A0I;
    public String A0J;
    public String A0K;
    public String A0L;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public Long A0R;
    public Long A0S;
    public Long A0T;
    public String A0U;
    public String A0V;
    public String A0W;
    public final C0CK A0X;
    public final C09V A0Z;
    public final C09V A0a;
    public final C09V A0b;
    public final List A0Y = new ArrayList();
    public int A02 = 0;

    /* JADX WARN: Removed duplicated region for block: B:27:0x005a A[Catch: all -> 0x0219, PHI: r2
  0x005a: PHI (r2v18 java.lang.String) = (r2v3 java.lang.String), (r2v21 java.lang.String) binds: [B:26:0x0058, B:22:0x0049] A[DONT_GENERATE, DONT_INLINE], TryCatch #5 {all -> 0x0219, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x000e, B:9:0x0012, B:11:0x001d, B:12:0x0022, B:16:0x003b, B:23:0x0050, B:21:0x0048, B:20:0x0045, B:22:0x0049, B:27:0x005a, B:29:0x005e, B:31:0x0061, B:33:0x008d, B:35:0x0096, B:37:0x009f, B:40:0x00cd, B:39:0x00c6, B:41:0x00d0, B:44:0x00d8, B:46:0x01ab, B:47:0x01b4, B:49:0x01cd, B:50:0x01d2, B:52:0x01d6, B:53:0x01db, B:55:0x01df, B:56:0x01e8, B:57:0x01ef, B:59:0x01f5, B:25:0x0056, B:24:0x0054), top: B:86:0x0006, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d A[Catch: all -> 0x0219, TryCatch #5 {all -> 0x0219, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x000e, B:9:0x0012, B:11:0x001d, B:12:0x0022, B:16:0x003b, B:23:0x0050, B:21:0x0048, B:20:0x0045, B:22:0x0049, B:27:0x005a, B:29:0x005e, B:31:0x0061, B:33:0x008d, B:35:0x0096, B:37:0x009f, B:40:0x00cd, B:39:0x00c6, B:41:0x00d0, B:44:0x00d8, B:46:0x01ab, B:47:0x01b4, B:49:0x01cd, B:50:0x01d2, B:52:0x01d6, B:53:0x01db, B:55:0x01df, B:56:0x01e8, B:57:0x01ef, B:59:0x01f5, B:25:0x0056, B:24:0x0054), top: B:86:0x0006, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0096 A[Catch: all -> 0x0219, TryCatch #5 {all -> 0x0219, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x000e, B:9:0x0012, B:11:0x001d, B:12:0x0022, B:16:0x003b, B:23:0x0050, B:21:0x0048, B:20:0x0045, B:22:0x0049, B:27:0x005a, B:29:0x005e, B:31:0x0061, B:33:0x008d, B:35:0x0096, B:37:0x009f, B:40:0x00cd, B:39:0x00c6, B:41:0x00d0, B:44:0x00d8, B:46:0x01ab, B:47:0x01b4, B:49:0x01cd, B:50:0x01d2, B:52:0x01d6, B:53:0x01db, B:55:0x01df, B:56:0x01e8, B:57:0x01ef, B:59:0x01f5, B:25:0x0056, B:24:0x0054), top: B:86:0x0006, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ab A[Catch: all -> 0x0219, TryCatch #5 {all -> 0x0219, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x000e, B:9:0x0012, B:11:0x001d, B:12:0x0022, B:16:0x003b, B:23:0x0050, B:21:0x0048, B:20:0x0045, B:22:0x0049, B:27:0x005a, B:29:0x005e, B:31:0x0061, B:33:0x008d, B:35:0x0096, B:37:0x009f, B:40:0x00cd, B:39:0x00c6, B:41:0x00d0, B:44:0x00d8, B:46:0x01ab, B:47:0x01b4, B:49:0x01cd, B:50:0x01d2, B:52:0x01d6, B:53:0x01db, B:55:0x01df, B:56:0x01e8, B:57:0x01ef, B:59:0x01f5, B:25:0x0056, B:24:0x0054), top: B:86:0x0006, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01cd A[Catch: all -> 0x0219, TryCatch #5 {all -> 0x0219, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x000e, B:9:0x0012, B:11:0x001d, B:12:0x0022, B:16:0x003b, B:23:0x0050, B:21:0x0048, B:20:0x0045, B:22:0x0049, B:27:0x005a, B:29:0x005e, B:31:0x0061, B:33:0x008d, B:35:0x0096, B:37:0x009f, B:40:0x00cd, B:39:0x00c6, B:41:0x00d0, B:44:0x00d8, B:46:0x01ab, B:47:0x01b4, B:49:0x01cd, B:50:0x01d2, B:52:0x01d6, B:53:0x01db, B:55:0x01df, B:56:0x01e8, B:57:0x01ef, B:59:0x01f5, B:25:0x0056, B:24:0x0054), top: B:86:0x0006, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d6 A[Catch: all -> 0x0219, TryCatch #5 {all -> 0x0219, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x000e, B:9:0x0012, B:11:0x001d, B:12:0x0022, B:16:0x003b, B:23:0x0050, B:21:0x0048, B:20:0x0045, B:22:0x0049, B:27:0x005a, B:29:0x005e, B:31:0x0061, B:33:0x008d, B:35:0x0096, B:37:0x009f, B:40:0x00cd, B:39:0x00c6, B:41:0x00d0, B:44:0x00d8, B:46:0x01ab, B:47:0x01b4, B:49:0x01cd, B:50:0x01d2, B:52:0x01d6, B:53:0x01db, B:55:0x01df, B:56:0x01e8, B:57:0x01ef, B:59:0x01f5, B:25:0x0056, B:24:0x0054), top: B:86:0x0006, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01df A[Catch: all -> 0x0219, TryCatch #5 {all -> 0x0219, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x000e, B:9:0x0012, B:11:0x001d, B:12:0x0022, B:16:0x003b, B:23:0x0050, B:21:0x0048, B:20:0x0045, B:22:0x0049, B:27:0x005a, B:29:0x005e, B:31:0x0061, B:33:0x008d, B:35:0x0096, B:37:0x009f, B:40:0x00cd, B:39:0x00c6, B:41:0x00d0, B:44:0x00d8, B:46:0x01ab, B:47:0x01b4, B:49:0x01cd, B:50:0x01d2, B:52:0x01d6, B:53:0x01db, B:55:0x01df, B:56:0x01e8, B:57:0x01ef, B:59:0x01f5, B:25:0x0056, B:24:0x0054), top: B:86:0x0006, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f5 A[Catch: all -> 0x0219, LOOP:1: B:57:0x01ef->B:59:0x01f5, LOOP_END, TryCatch #5 {all -> 0x0219, blocks: (B:3:0x0006, B:5:0x000a, B:7:0x000e, B:9:0x0012, B:11:0x001d, B:12:0x0022, B:16:0x003b, B:23:0x0050, B:21:0x0048, B:20:0x0045, B:22:0x0049, B:27:0x005a, B:29:0x005e, B:31:0x0061, B:33:0x008d, B:35:0x0096, B:37:0x009f, B:40:0x00cd, B:39:0x00c6, B:41:0x00d0, B:44:0x00d8, B:46:0x01ab, B:47:0x01b4, B:49:0x01cd, B:50:0x01d2, B:52:0x01d6, B:53:0x01db, B:55:0x01df, B:56:0x01e8, B:57:0x01ef, B:59:0x01f5, B:25:0x0056, B:24:0x0054), top: B:86:0x0006, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0215  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A00(X.C00c r7) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C00c.A00(X.00c):void");
    }

    public C00c(C0CK c0ck, C09V c09v, C09V c09v2, C09V c09v3) {
        this.A0X = c0ck;
        this.A0b = c09v;
        this.A0a = c09v2;
        this.A0Z = c09v3;
        File file = c0ck.A04;
        AnonymousClass053.A03(file, "Did you call SessionManager.init()?");
        StringBuilder sb = new StringBuilder();
        sb.append("anr_report_");
        sb.append(0);
        sb.append(".dmp");
        this.A0C = new File(file, sb.toString());
    }

    public final void A01(C03g c03g, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, String str, String str2, int i, long j, long j2, boolean z, boolean z2, boolean z3, boolean z4) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        this.A0A = -1L;
        this.A0Y.clear();
        this.A03 = -1L;
        this.A06 = -1L;
        this.A09 = -1L;
        this.A01 = 0;
        this.A07 = -1L;
        this.A0J = null;
        this.A0K = null;
        this.A08 = -1L;
        this.A00 = i;
        this.A0N = z2;
        this.A0O = z3;
        this.A0P = z;
        this.A04 = j;
        this.A05 = j2;
        this.A0E = l;
        this.A0D = l2;
        this.A0G = l3;
        this.A0F = l4;
        this.A0H = str;
        this.A0I = str2;
        this.A0L = null;
        this.A0Q = z4;
        this.A0W = (String) this.A0b.get();
        this.A0V = (String) this.A0a.get();
        this.A0U = (String) this.A0Z.get();
        this.A0M = true;
        this.A0B = c03g;
        this.A0R = l5;
        this.A0S = l6;
        this.A0T = l7;
        A00(this);
    }
}
