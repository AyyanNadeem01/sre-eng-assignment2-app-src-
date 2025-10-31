package X;

import com.facebook.errorreporting.field.ReportFieldString;
import com.facebook.perf.background.BackgroundStartupDetector;
import java.io.File;

/* renamed from: X.04c, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C009304c implements AnonymousClass095 {
    public File A00;
    public File A01;
    public final int A02;
    public final ReportFieldString A03;

    public C009304c(File file) {
        this.A03 = AnonymousClass094.A7K;
        this.A00 = file;
        this.A02 = BackgroundStartupDetector.ACTIVITY_REDIRECT_LAUNCH_TIMEOUT_MS;
        StringBuilder sb = new StringBuilder();
        sb.append(file.getPath());
        sb.append("_tmp");
        this.A01 = new File(sb.toString());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:0|2|(2:88|3)|(3:5|(1:7)(1:11)|8)(17:12|(1:14)|10|15|(2:16|(1:18)(1:102))|19|100|20|(1:22)(1:23)|24|(2:26|104)|103|31|(2:33|(15:93|37|94|38|(4:43|(2:45|(3:47|49|107)(1:108))(2:48|109)|50|39)|106|51|(1:55)|56|92|64|(3:67|96|65)|110|68|69))|(1:78)|79|(4:81|(1:83)|84|85)(2:86|87))|9|10|15|(3:16|(0)(0)|18)|19|100|20|(0)(0)|24|(0)|103|31|(0)|(0)|79|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ac, code lost:
    
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
    
        X.C0C5.A00();
        android.util.Log.e("LogcatCollector", "LogCatCollector.collectLogcat could not retrieve data.", r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x007f A[EDGE_INSN: B:102:0x007f->B:19:0x007f BREAK  A[LOOP:0: B:16:0x006e->B:18:0x0074], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074 A[Catch: IOException -> 0x00a9, LOOP:0: B:16:0x006e->B:18:0x0074, LOOP_END, TryCatch #0 {IOException -> 0x00a9, blocks: (B:3:0x0003, B:5:0x0022, B:7:0x0026, B:8:0x002a, B:9:0x002f, B:10:0x0032, B:16:0x006e, B:18:0x0074, B:19:0x007f, B:11:0x005a, B:12:0x005f, B:14:0x0063), top: B:88:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0088 A[Catch: IOException -> 0x00ac, TryCatch #7 {IOException -> 0x00ac, blocks: (B:20:0x0084, B:22:0x0088, B:26:0x0098, B:23:0x008d), top: B:100:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008d A[Catch: IOException -> 0x00ac, TryCatch #7 {IOException -> 0x00ac, blocks: (B:20:0x0084, B:22:0x0088, B:26:0x0098, B:23:0x008d), top: B:100:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0098 A[Catch: IOException -> 0x00ac, TRY_LEAVE, TryCatch #7 {IOException -> 0x00ac, blocks: (B:20:0x0084, B:22:0x0088, B:26:0x0098, B:23:0x008d), top: B:100:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0187  */
    @Override // X.AnonymousClass095
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Afg(X.C05C r19, X.AnonymousClass057 r20) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C009304c.Afg(X.05C, X.057):void");
    }

    @Override // X.AnonymousClass095
    public final Integer AGY() {
        return AnonymousClass065.A0J;
    }

    public C009304c() {
        this.A03 = AnonymousClass094.A7K;
        this.A00 = null;
        this.A02 = -1;
    }
}
