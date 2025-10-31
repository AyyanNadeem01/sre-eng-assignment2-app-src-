package X;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: X.0Ai, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C02290Ai {
    public static final Set A00 = new HashSet();

    public static synchronized void A00(C0AD c0ad, String str) {
        Set set = A00;
        if (!set.contains(str)) {
            StringBuilder sbA09 = AnonymousClass000.A09();
            sbA09.append("Prepending SoSource ");
            sbA09.append(str);
            sbA09.append(": ");
            AnonymousClass000.A0K(c0ad.toString(), "SoLoader", sbA09);
            ReentrantReadWriteLock reentrantReadWriteLock = C0BG.A0A;
            reentrantReadWriteLock.writeLock().lock();
            try {
                if (!C0BG.A08()) {
                    throw AnonymousClass000.A04("SoLoader.init() not called yet");
                }
                c0ad.A07(C0BG.A00());
                C0AD[] c0adArr = new C0AD[C0BG.A0E.length + 1];
                c0adArr[0] = c0ad;
                System.arraycopy(C0BG.A0E, 0, c0adArr, 1, C0BG.A0E.length);
                C0BG.A0E = c0adArr;
                C0BG.A09.getAndIncrement();
                AbstractC02460Bh.A00("SoLoader");
                AnonymousClass000.A0M(reentrantReadWriteLock);
                set.add(str);
            } catch (Throwable th) {
                AnonymousClass000.A0M(reentrantReadWriteLock);
                throw th;
            }
        }
    }
}
