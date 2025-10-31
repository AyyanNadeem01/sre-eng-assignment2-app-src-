package X;

import android.os.Looper;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

/* renamed from: X.06c, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC013806c {
    public static void A00(OutputStream outputStream) throws IOException {
        PrintWriter printWriter = new PrintWriter(outputStream);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Thread thread = Looper.getMainLooper().getThread();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            A01(printWriter, entry.getKey(), entry.getValue());
        }
        if (!allStackTraces.containsKey(thread)) {
            A01(printWriter, thread, thread.getStackTrace());
        }
        printWriter.flush();
    }

    public static void A01(PrintWriter printWriter, Thread thread, StackTraceElement[] stackTraceElementArr) {
        printWriter.print(thread);
        printWriter.print(" ");
        printWriter.print(thread.getState());
        printWriter.println(":");
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            printWriter.println(stackTraceElement);
        }
        printWriter.println();
    }
}
