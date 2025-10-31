package X;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/* renamed from: X.06T, reason: invalid class name */
/* loaded from: classes.dex */
public final class C06T {
    public static AnonymousClass079 A00;
    public static final C06U A01;
    public static final AnonymousClass079 A02;
    public static final AnonymousClass079 A03 = new AnonymousClass079() { // from class: X.076
        @Override // X.AnonymousClass079
        public final C06D[] ADP() {
            return new C06D[0];
        }

        @Override // X.AnonymousClass079
        public final C06S[] AFI() {
            return new C06S[0];
        }

        @Override // X.AnonymousClass079
        public final boolean Amr() {
            return false;
        }
    };

    /* JADX WARN: Type inference failed for: r0v1, types: [X.06U] */
    static {
        final AnonymousClass079 anonymousClass079 = new AnonymousClass079() { // from class: X.06k
            @Override // X.AnonymousClass079
            public final C06D[] ADP() {
                return C06T.A01().ADP();
            }

            @Override // X.AnonymousClass079
            public final C06S[] AFI() {
                return C06T.A01().AFI();
            }

            @Override // X.AnonymousClass079
            public final boolean Amr() {
                return C06T.A01().Amr();
            }
        };
        A02 = anonymousClass079;
        A01 = new Object(anonymousClass079) { // from class: X.06U
            public final AnonymousClass079 A00;

            {
                this.A00 = anonymousClass079;
            }

            /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
            /* JADX WARN: Removed duplicated region for block: B:51:0x00b2  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x0076 A[EDGE_INSN: B:60:0x0076->B:31:0x0076 BREAK  A[LOOP:0: B:9:0x001a->B:61:?], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:61:? A[LOOP:0: B:9:0x001a->B:61:?, LOOP_END, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A00(android.content.Context r13, android.content.Intent r14, java.lang.Object r15) throws org.json.JSONException, java.security.NoSuchAlgorithmException, java.io.IOException {
                /*
                    r12 = this;
                    X.C06T.A02(r13)
                    r7 = 0
                    X.C06T.A02(r13)
                    X.079 r6 = r12.A00
                    boolean r0 = r6.Amr()
                    if (r0 == 0) goto Lb8
                    X.06D[] r5 = r6.ADP()
                    r11 = 0
                    if (r5 == 0) goto L76
                    int r4 = r5.length
                    if (r4 <= 0) goto L76
                    r3 = 0
                L1a:
                    r8 = r5[r3]
                    java.util.regex.Pattern r1 = r8.A03
                    if (r1 == 0) goto L32
                    java.lang.Class r0 = r15.getClass()
                    java.lang.String r0 = r0.getName()
                    java.util.regex.Matcher r0 = r1.matcher(r0)
                    boolean r0 = r0.matches()
                    if (r0 == 0) goto Lb2
                L32:
                    r0 = 86400000(0x5265c00, float:7.82218E-36)
                    X.03w r10 = X.AbstractC006102p.A00(r13, r14, r7, r0)     // Catch: org.json.JSONException -> Lb2
                    X.06G r9 = r8.A00     // Catch: org.json.JSONException -> Lb2
                    if (r9 == 0) goto L6f
                    if (r10 == 0) goto Lb2
                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> Lb2
                    r2.<init>()     // Catch: org.json.JSONException -> Lb2
                    java.lang.String r1 = "caller_uid"
                    int r0 = r10.A00     // Catch: org.json.JSONException -> Lb2
                    r2.put(r1, r0)     // Catch: org.json.JSONException -> Lb2
                    java.lang.String r1 = r10.A06()     // Catch: org.json.JSONException -> Lb2
                    if (r1 == 0) goto L56
                    java.lang.String r0 = "caller_package_name"
                    r2.put(r0, r1)     // Catch: org.json.JSONException -> Lb2
                L56:
                    java.lang.String r1 = r10.A02     // Catch: org.json.JSONException -> Lb2
                    if (r1 == 0) goto L5f
                    java.lang.String r0 = "caller_version_name"
                    r2.put(r0, r1)     // Catch: org.json.JSONException -> Lb2
                L5f:
                    java.lang.String r1 = r10.A01     // Catch: org.json.JSONException -> Lb2
                    if (r1 == 0) goto L68
                    java.lang.String r0 = "caller_domain"
                    r2.put(r0, r1)     // Catch: org.json.JSONException -> Lb2
                L68:
                    boolean r0 = r9.A01(r7, r2)     // Catch: org.json.JSONException -> Lb2
                    if (r0 != 0) goto L6f
                    goto Lb2
                L6f:
                    boolean r0 = r8.A02(r14)
                    if (r0 == 0) goto Lb2
                    r11 = 1
                L76:
                    r5 = 0
                    if (r11 != 0) goto Lab
                    X.06S[] r6 = r6.AFI()
                    int r4 = r6.length
                    r3 = 0
                L7f:
                    if (r3 >= r4) goto Lb8
                    r7 = r6[r3]
                    java.lang.String r1 = r7.A02
                    if (r1 == 0) goto L95
                    java.lang.Class r0 = r15.getClass()
                    java.lang.String r0 = r0.getName()
                    boolean r0 = r1.equals(r0)
                    if (r0 == 0) goto Laf
                L95:
                    android.content.IntentFilter r2 = r7.A01
                    if (r2 == 0) goto Lab
                    android.content.ContentResolver r1 = r7.A00
                    java.lang.String r0 = "TAG"
                    int r0 = r2.match(r1, r14, r5, r0)
                    r1 = 0
                    if (r0 <= 0) goto La5
                    r1 = 1
                La5:
                    boolean r0 = r7.A03
                    if (r0 == 0) goto Lac
                    if (r1 != 0) goto Laf
                Lab:
                    return r5
                Lac:
                    if (r1 == 0) goto Laf
                    return r5
                Laf:
                    int r3 = r3 + 1
                    goto L7f
                Lb2:
                    int r3 = r3 + 1
                    if (r3 >= r4) goto L76
                    goto L1a
                Lb8:
                    r5 = 1
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: X.C06U.A00(android.content.Context, android.content.Intent, java.lang.Object):boolean");
            }
        };
    }

    public static SharedPreferences A00(Context context) {
        try {
            return context.getSharedPreferences("com.facebook.secure.switchoff", 0);
        } catch (Throwable th) {
            Log.w("DefaultSwitchOffs", "Could not load SharedPreferences", th);
            return null;
        }
    }

    public static synchronized AnonymousClass079 A01() {
        AnonymousClass079 anonymousClass079;
        anonymousClass079 = A00;
        if (anonymousClass079 == null) {
            throw new IllegalStateException();
        }
        return anonymousClass079;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067 A[Catch: all -> 0x019a, PHI: r3
  0x0067: PHI (r3v1 android.content.SharedPreferences) = 
  (r3v0 android.content.SharedPreferences)
  (r3v5 android.content.SharedPreferences)
  (r3v4 android.content.SharedPreferences)
 binds: [B:25:0x004e, B:27:0x0059, B:16:0x0032] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {all -> 0x019a, blocks: (B:7:0x0010, B:9:0x0018, B:11:0x001e, B:13:0x0024, B:15:0x002a, B:28:0x0067, B:29:0x007b, B:31:0x0086, B:65:0x011f, B:67:0x012d, B:68:0x0136, B:70:0x013c, B:72:0x014c, B:73:0x014f, B:75:0x0155, B:76:0x0158, B:77:0x0166, B:79:0x016c, B:80:0x017e, B:81:0x0187, B:32:0x008a, B:34:0x0095, B:36:0x009d, B:37:0x00a2, B:57:0x00fc, B:38:0x00a5, B:61:0x010e, B:62:0x0113, B:50:0x00ce, B:51:0x00d3, B:56:0x00f6, B:54:0x00db, B:55:0x00e0, B:59:0x0100, B:45:0x00ba, B:47:0x00c0, B:60:0x0108, B:64:0x0115, B:19:0x003a, B:27:0x0059, B:21:0x0040, B:26:0x0050, B:24:0x004a, B:17:0x0034), top: B:100:0x0010, outer: #0, inners: #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086 A[Catch: IOException | IllegalArgumentException -> 0x0114, all -> 0x019a, TryCatch #4 {all -> 0x019a, blocks: (B:7:0x0010, B:9:0x0018, B:11:0x001e, B:13:0x0024, B:15:0x002a, B:28:0x0067, B:29:0x007b, B:31:0x0086, B:65:0x011f, B:67:0x012d, B:68:0x0136, B:70:0x013c, B:72:0x014c, B:73:0x014f, B:75:0x0155, B:76:0x0158, B:77:0x0166, B:79:0x016c, B:80:0x017e, B:81:0x0187, B:32:0x008a, B:34:0x0095, B:36:0x009d, B:37:0x00a2, B:57:0x00fc, B:38:0x00a5, B:61:0x010e, B:62:0x0113, B:50:0x00ce, B:51:0x00d3, B:56:0x00f6, B:54:0x00db, B:55:0x00e0, B:59:0x0100, B:45:0x00ba, B:47:0x00c0, B:60:0x0108, B:64:0x0115, B:19:0x003a, B:27:0x0059, B:21:0x0040, B:26:0x0050, B:24:0x004a, B:17:0x0034), top: B:100:0x0010, outer: #0, inners: #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[Catch: IOException | IllegalArgumentException -> 0x0114, all -> 0x019a, TryCatch #4 {all -> 0x019a, blocks: (B:7:0x0010, B:9:0x0018, B:11:0x001e, B:13:0x0024, B:15:0x002a, B:28:0x0067, B:29:0x007b, B:31:0x0086, B:65:0x011f, B:67:0x012d, B:68:0x0136, B:70:0x013c, B:72:0x014c, B:73:0x014f, B:75:0x0155, B:76:0x0158, B:77:0x0166, B:79:0x016c, B:80:0x017e, B:81:0x0187, B:32:0x008a, B:34:0x0095, B:36:0x009d, B:37:0x00a2, B:57:0x00fc, B:38:0x00a5, B:61:0x010e, B:62:0x0113, B:50:0x00ce, B:51:0x00d3, B:56:0x00f6, B:54:0x00db, B:55:0x00e0, B:59:0x0100, B:45:0x00ba, B:47:0x00c0, B:60:0x0108, B:64:0x0115, B:19:0x003a, B:27:0x0059, B:21:0x0040, B:26:0x0050, B:24:0x004a, B:17:0x0034), top: B:100:0x0010, outer: #0, inners: #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c0 A[Catch: IOException | IllegalArgumentException -> 0x0114, all -> 0x019a, TryCatch #4 {all -> 0x019a, blocks: (B:7:0x0010, B:9:0x0018, B:11:0x001e, B:13:0x0024, B:15:0x002a, B:28:0x0067, B:29:0x007b, B:31:0x0086, B:65:0x011f, B:67:0x012d, B:68:0x0136, B:70:0x013c, B:72:0x014c, B:73:0x014f, B:75:0x0155, B:76:0x0158, B:77:0x0166, B:79:0x016c, B:80:0x017e, B:81:0x0187, B:32:0x008a, B:34:0x0095, B:36:0x009d, B:37:0x00a2, B:57:0x00fc, B:38:0x00a5, B:61:0x010e, B:62:0x0113, B:50:0x00ce, B:51:0x00d3, B:56:0x00f6, B:54:0x00db, B:55:0x00e0, B:59:0x0100, B:45:0x00ba, B:47:0x00c0, B:60:0x0108, B:64:0x0115, B:19:0x003a, B:27:0x0059, B:21:0x0040, B:26:0x0050, B:24:0x004a, B:17:0x0034), top: B:100:0x0010, outer: #0, inners: #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00db A[Catch: IOException | IllegalArgumentException -> 0x0114, all -> 0x019a, TRY_LEAVE, TryCatch #4 {all -> 0x019a, blocks: (B:7:0x0010, B:9:0x0018, B:11:0x001e, B:13:0x0024, B:15:0x002a, B:28:0x0067, B:29:0x007b, B:31:0x0086, B:65:0x011f, B:67:0x012d, B:68:0x0136, B:70:0x013c, B:72:0x014c, B:73:0x014f, B:75:0x0155, B:76:0x0158, B:77:0x0166, B:79:0x016c, B:80:0x017e, B:81:0x0187, B:32:0x008a, B:34:0x0095, B:36:0x009d, B:37:0x00a2, B:57:0x00fc, B:38:0x00a5, B:61:0x010e, B:62:0x0113, B:50:0x00ce, B:51:0x00d3, B:56:0x00f6, B:54:0x00db, B:55:0x00e0, B:59:0x0100, B:45:0x00ba, B:47:0x00c0, B:60:0x0108, B:64:0x0115, B:19:0x003a, B:27:0x0059, B:21:0x0040, B:26:0x0050, B:24:0x004a, B:17:0x0034), top: B:100:0x0010, outer: #0, inners: #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0195 A[Catch: all -> 0x01a1, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000c, B:82:0x018e, B:84:0x0195, B:86:0x019b, B:87:0x019e, B:7:0x0010, B:9:0x0018, B:11:0x001e, B:13:0x0024, B:15:0x002a, B:28:0x0067, B:29:0x007b, B:31:0x0086, B:65:0x011f, B:67:0x012d, B:68:0x0136, B:70:0x013c, B:72:0x014c, B:73:0x014f, B:75:0x0155, B:76:0x0158, B:77:0x0166, B:79:0x016c, B:80:0x017e, B:81:0x0187, B:32:0x008a, B:34:0x0095, B:36:0x009d, B:37:0x00a2, B:57:0x00fc, B:38:0x00a5, B:61:0x010e, B:62:0x0113, B:50:0x00ce, B:51:0x00d3, B:56:0x00f6, B:54:0x00db, B:55:0x00e0, B:59:0x0100, B:45:0x00ba, B:47:0x00c0, B:60:0x0108, B:64:0x0115, B:19:0x003a, B:27:0x0059, B:21:0x0040, B:26:0x0050, B:24:0x004a), top: B:94:0x0003, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void A02(android.content.Context r16) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C06T.A02(android.content.Context):void");
    }
}
