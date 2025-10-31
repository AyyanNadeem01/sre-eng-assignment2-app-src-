package X;

import android.text.format.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

/* renamed from: X.020, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class AnonymousClass020 {
    public static final AnonymousClass021 A00 = new InterfaceC009404d() { // from class: X.021
        public static final AtomicInteger A07 = new AtomicInteger();
        public static final Pattern A09 = Pattern.compile("^Cmd line: (.*)", 8);
        public static final ReentrantReadWriteLock A08 = new ReentrantReadWriteLock();
        public final ArrayList A02 = new ArrayList();
        public final Set A04 = new HashSet();
        public final Map A03 = new HashMap();
        public final AnonymousClass022 A01 = new Object() { // from class: X.022
            public Queue A00 = new LinkedList();

            public final synchronized String toString() {
                StringBuilder sb;
                try {
                    sb = new StringBuilder();
                    Iterator it = this.A00.iterator();
                    if (it.hasNext()) {
                        it.next();
                        throw new NullPointerException("toString");
                    }
                } finally {
                }
                return sb.toString();
            }
        };
        public final Time A00 = new Time();
        public final AtomicReference A06 = new AtomicReference();
        public final AtomicReference A05 = new AtomicReference();

        /* JADX WARN: Type inference failed for: r0v3, types: [X.022] */
        {
            if (AbstractC019408p.A00 != null) {
                C018108b.A08("ErrorReporter", "ErrorReportingDiagnosticData.setInstance already set.");
                return;
            }
            AbstractC019408p.A00 = new C06H() { // from class: X.06I
            };
            AnonymousClass054 anonymousClass054 = new AnonymousClass054() { // from class: X.06J
                @Override // X.AnonymousClass054
                public final void ALb(Throwable th) {
                    AnonymousClass021 anonymousClass021 = AnonymousClass020.A00;
                }
            };
            synchronized (AnonymousClass041.class) {
                AnonymousClass041.A00 = anonymousClass054;
            }
        }

        @Override // X.InterfaceC009404d
        public final void ALl(Thread thread, Throwable th) {
            throw AnonymousClass062.createAndThrow();
        }
    };
}
