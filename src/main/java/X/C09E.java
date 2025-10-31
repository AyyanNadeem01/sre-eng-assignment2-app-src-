package X;

import java.security.SecureRandom;
import java.util.UUID;

/* renamed from: X.09E, reason: invalid class name */
/* loaded from: classes.dex */
public final class C09E {
    public static String A00;

    public static final synchronized String A00() {
        String string;
        string = A00;
        if (string == null) {
            SecureRandom secureRandom = new SecureRandom();
            string = new UUID(secureRandom.nextLong() ^ System.currentTimeMillis(), secureRandom.nextLong()).toString();
            A00 = string;
        }
        if (string == null) {
            C06E.A0A("_processUuid");
            throw AnonymousClass062.createAndThrow();
        }
        return string;
    }
}
