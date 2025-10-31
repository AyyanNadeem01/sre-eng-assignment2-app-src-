package X;

import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: X.089 */
/* loaded from: classes.dex */
public final class AnonymousClass089 implements Thread.UncaughtExceptionHandler {
    public static AnonymousClass089 A03;
    public static Runnable A04;
    public final Thread.UncaughtExceptionHandler A01;
    public byte[] mOomReservation;
    public final Object A00 = new Object();
    public volatile List A02 = Collections.unmodifiableList(AnonymousClass000.A0B());

    public static synchronized AnonymousClass089 A00() {
        AnonymousClass089 anonymousClass089;
        anonymousClass089 = A03;
        if (anonymousClass089 == null) {
            AnonymousClass089 anonymousClass0892 = new AnonymousClass089(Thread.getDefaultUncaughtExceptionHandler());
            A03 = anonymousClass0892;
            Thread.setDefaultUncaughtExceptionHandler(anonymousClass0892);
            anonymousClass089 = A03;
        }
        return anonymousClass089;
    }

    public static synchronized AnonymousClass089 A01() {
        return A03;
    }

    public static void A02() {
        try {
            Runnable runnable = A04;
            if (runnable != null) {
                runnable.run();
            }
            Process.killProcess(Process.myPid());
        } catch (Throwable th) {
            Log.e("ExceptionHandlerManager", "Error during exception handling", th);
        }
        try {
            System.exit(10);
        } catch (Throwable th2) {
            Log.e("ExceptionHandlerManager", "Error during exception handling", th2);
        }
        while (true) {
        }
    }

    public static synchronized void A03(InterfaceC009404d interfaceC009404d, int i) {
        AnonymousClass089 anonymousClass089A00 = A00();
        synchronized (anonymousClass089A00) {
            ArrayList arrayList = new ArrayList(anonymousClass089A00.A02);
            arrayList.add(new C009604f(interfaceC009404d, i));
            Collections.sort(arrayList);
            anonymousClass089A00.A02 = Collections.unmodifiableList(arrayList);
        }
    }

    public AnonymousClass089(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mOomReservation = null;
        this.A01 = uncaughtExceptionHandler;
        this.mOomReservation = new byte[4096];
    }

    public static void A04(Throwable th) {
        String str;
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = length + 1;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i];
        System.arraycopy(stackTrace, 0, stackTraceElementArr, 0, length);
        int i2 = i - 1;
        if (C019908u.A04 == null || (str = C019908u.A04.A02) == null) {
            str = "unknown";
        }
        stackTraceElementArr[i2] = new StackTraceElement("Z", "init", str, -1);
        th.setStackTrace(stackTraceElementArr);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (th.getClass().getSimpleName().equals("CannotDeliverBroadcastException") && Build.VERSION.SDK_INT == 33) {
            return;
        }
        synchronized (this.A00) {
            try {
                if (Process.getThreadPriority(0) > -10) {
                    Process.setThreadPriority(-10);
                }
            } catch (Exception unused) {
            }
            boolean z = th instanceof OutOfMemoryError;
            this.mOomReservation = null;
            List list = this.A02;
            try {
                try {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        try {
                            ((C009604f) list.get(size)).A01.ALl(thread, th);
                        } catch (Throwable th2) {
                            if (z) {
                                Log.e("ExceptionHandlerManager", "OOM while handling OOM");
                            } else {
                                Log.e("ExceptionHandlerManager", "Error during exception handling", th2);
                            }
                        }
                    }
                    A04(th);
                } catch (Throwable unused2) {
                    A04(th);
                    if (th instanceof C08D) {
                        StringBuilder sbA09 = AnonymousClass000.A09();
                        sbA09.append("Exit: ");
                        AnonymousClass000.A0K(th.getMessage(), "ExceptionHandlerManager", sbA09);
                    } else {
                        uncaughtExceptionHandler = this.A01;
                        if (uncaughtExceptionHandler != null) {
                        }
                    }
                }
                if (th instanceof C08D) {
                    StringBuilder sbA092 = AnonymousClass000.A09();
                    sbA092.append("Exit: ");
                    AnonymousClass000.A0K(th.getMessage(), "ExceptionHandlerManager", sbA092);
                } else {
                    uncaughtExceptionHandler = this.A01;
                    if (uncaughtExceptionHandler != null) {
                        uncaughtExceptionHandler.uncaughtException(thread, th);
                    }
                }
            } catch (Throwable th3) {
                try {
                    Log.e("ExceptionHandlerManager", "Error during exception handling", th3);
                } catch (Throwable unused3) {
                    A02();
                }
            }
            A02();
            throw AnonymousClass062.createAndThrow();
        }
    }
}
