package X;

/* renamed from: X.0Ca */
/* loaded from: classes.dex */
public class C02610Ca extends C09W {
    public final int $t;

    public C02610Ca(int i) {
        this.$t = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0097 A[RETURN] */
    @Override // X.C09W
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ java.lang.Object A00() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.$t
            switch(r0) {
                case 0: goto Lc;
                case 1: goto L9f;
                default: goto L5;
            }
        L5:
            X.0CK r0 = X.C0CK.A08
            X.04j r0 = X.C010004j.A00(r0)
            return r0
        Lc:
            java.lang.String r5 = "lacrima"
            r6 = 0
            java.util.ArrayList r2 = X.AnonymousClass000.A0B()     // Catch: java.io.IOException -> L88
            java.lang.String r0 = "logcat"
            r2.add(r0)     // Catch: java.io.IOException -> L88
            java.lang.String r0 = "-d"
            r2.add(r0)     // Catch: java.io.IOException -> L88
            java.lang.String r0 = "-t"
            r2.add(r0)     // Catch: java.io.IOException -> L88
            r0 = 200(0xc8, float:2.8E-43)
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.io.IOException -> L88
            r2.add(r0)     // Catch: java.io.IOException -> L88
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.io.IOException -> L88
            int r0 = r2.size()     // Catch: java.io.IOException -> L88
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch: java.io.IOException -> L88
            java.lang.Object[] r0 = r2.toArray(r0)     // Catch: java.io.IOException -> L88
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch: java.io.IOException -> L88
            java.lang.Process r1 = r1.exec(r0)     // Catch: java.io.IOException -> L88
            if (r1 == 0) goto L95
            java.io.InputStream r0 = r1.getInputStream()     // Catch: java.io.IOException -> L88
            if (r0 == 0) goto L95
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.io.IOException -> L88
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L88
            r0.<init>(r1)     // Catch: java.io.IOException -> L88
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.io.IOException -> L88
            r2.<init>(r0)     // Catch: java.io.IOException -> L88
            java.util.ArrayList r4 = X.AnonymousClass000.A0B()     // Catch: java.io.IOException -> L88
            r3 = 0
            r1 = 0
        L5b:
            java.lang.String r0 = r2.readLine()     // Catch: java.io.IOException -> L88
            if (r0 == 0) goto L6c
            r4.add(r0)     // Catch: java.io.IOException -> L88
            int r0 = r0.length()     // Catch: java.io.IOException -> L88
            int r1 = r1 + r0
            int r1 = r1 + 1
            goto L5b
        L6c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L88
            r2.<init>(r1)     // Catch: java.io.IOException -> L88
        L71:
            int r0 = r4.size()     // Catch: java.io.IOException -> L8b
            if (r3 >= r0) goto L94
            java.lang.Object r0 = r4.get(r3)     // Catch: java.io.IOException -> L8b
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.io.IOException -> L8b
            r2.append(r0)     // Catch: java.io.IOException -> L8b
            java.lang.String r0 = "\n"
            r2.append(r0)     // Catch: java.io.IOException -> L8b
            int r3 = r3 + 1
            goto L71
        L88:
            r1 = move-exception
            r2 = r6
            goto L8c
        L8b:
            r1 = move-exception
        L8c:
            X.C0C5.A00()
            java.lang.String r0 = "ErrorReportingCheck.collectLogcat could not retrieve data."
            X.C018108b.A0A(r5, r0, r1)
        L94:
            r6 = r2
        L95:
            if (r6 != 0) goto L9a
            java.lang.String r0 = ""
            return r0
        L9a:
            java.lang.String r0 = r6.toString()
            return r0
        L9f:
            java.util.concurrent.ExecutorService r0 = X.C022009w.A00()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C02610Ca.A00():java.lang.Object");
    }
}
