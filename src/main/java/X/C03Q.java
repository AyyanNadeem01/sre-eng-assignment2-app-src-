package X;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;

/* renamed from: X.03Q, reason: invalid class name */
/* loaded from: classes.dex */
public class C03Q {
    public static final C03R A04 = new C03R();
    public final C03S A00;
    public final C03R A01;
    public final C05P A02;
    public final Executor A03;

    /* JADX WARN: Type inference failed for: r0v0, types: [X.03S] */
    public C03Q(C05P c05p, Executor executor) {
        C03R c03r = A04;
        this.A00 = new Object() { // from class: X.03S
        };
        this.A02 = c05p;
        this.A03 = executor;
        this.A01 = c03r;
    }

    public C02W A00(C03P c03p) {
        return this.A02.ARd(c03p.A00);
    }

    public final C02W A01(List list, boolean z) throws Throwable {
        final Object obj;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final C03P c03p = (C03P) it.next();
            arrayList.add(new Callable() { // from class: X.03T
                @Override // java.util.concurrent.Callable
                public final /* bridge */ /* synthetic */ Object call() throws IOException {
                    C03Q c03q = this.A00;
                    C03P c03p2 = c03p;
                    C02W c02wA00 = c03q.A00(c03p2);
                    if (c02wA00 == null) {
                        return null;
                    }
                    if (!c03p2.A01) {
                        return c02wA00;
                    }
                    if (!c02wA00.isConnected() || c02wA00.isClosed()) {
                        throw new IOException("failed checkSocketIsConnected");
                    }
                    return c02wA00;
                }
            });
        }
        try {
            Executor executor = this.A03;
            final C03S c03s = this.A00;
            ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executor);
            ArrayList arrayList2 = new ArrayList(2);
            final ArrayList arrayList3 = new ArrayList(arrayList.size());
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList3.add(executorCompletionService.submit((Callable) it2.next()));
            }
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    ArrayList arrayList4 = new ArrayList(arrayList2.size());
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        String message = ((Throwable) it3.next()).getMessage();
                        if (message != null) {
                            arrayList4.add(message);
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("ConcurrentSocketConnector failed: ");
                    StringBuilder sb2 = new StringBuilder();
                    Iterator it4 = arrayList4.iterator();
                    if (it4.hasNext()) {
                        while (true) {
                            sb2.append((CharSequence) it4.next());
                            if (!it4.hasNext()) {
                                break;
                            }
                            sb2.append((CharSequence) " ||| ");
                        }
                    }
                    sb.append(sb2.toString());
                    throw new IOException(sb.toString()).initCause(arrayList2.isEmpty() ? null : (Throwable) arrayList2.get(0));
                }
                try {
                    obj = executorCompletionService.take().get();
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        arrayList2.add(cause);
                    }
                }
                if (obj != null) {
                    executor.execute(new Runnable() { // from class: X.02d
                        public static final String __redex_internal_original_name = "ConcurrentSocketConnector$3";

                        @Override // java.lang.Runnable
                        public final void run() throws ExecutionException, InterruptedException {
                            C02W c02w;
                            Iterator it5 = arrayList3.iterator();
                            while (it5.hasNext()) {
                                try {
                                    Object obj2 = ((Future) it5.next()).get();
                                    if (obj2 != null && obj2 != obj && (c02w = (C02W) obj2) != null) {
                                        c02w.close();
                                    }
                                } catch (IOException | InterruptedException | ExecutionException unused) {
                                }
                            }
                        }
                    });
                    C02W c02w = (C02W) obj;
                    if (c02w != null) {
                        return c02w;
                    }
                    throw new IOException("all socket connect failed");
                }
                i++;
            }
        } catch (IOException e2) {
            if (z) {
                throw e2;
            }
            throw new IOException("all socket connect failed");
        }
    }
}
