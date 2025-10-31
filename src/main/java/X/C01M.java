package X;

import android.os.Build;
import com.facebook.systrace.Systrace;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* renamed from: X.01M */
/* loaded from: classes.dex */
public final class C01M implements C01L {
    @Override // X.C01L
    public final void Adp() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        C01K.A00();
        if ((1 & C01H.A01) != 0) {
            StringBuilder sb = new StringBuilder(127);
            sb.append("Android trace tags: ");
            sb.append(C07O.A00("debug.atrace.tags.enableflags"));
            sb.append(", Facebook trace tags: ");
            sb.append(C01H.A01);
            Systrace.A0D("process_labels", 0, sb.toString());
        }
        if ((64 & C01H.A01) != 0) {
            try {
                FileReader fileReader = new FileReader("/proc/self/cmdline");
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    try {
                        String line = bufferedReader.readLine();
                        int iIndexOf = line.indexOf(0);
                        if (iIndexOf >= 0) {
                            line = line.substring(0, iIndexOf);
                        }
                        bufferedReader.close();
                        fileReader.close();
                        Systrace.A0D("process_name", 0, line);
                        Systrace.A0D("process_labels", 0, String.format("device=%s,heapgrowthlimit=%s,heapstartsize=%s,heapminfree=%s,heapmaxfree=%s,heaptargetutilization=%s", Build.MODEL, C07O.A02("dalvik.vm.heapgrowthlimit"), C07O.A02("dalvik.vm.heapstartsize"), C07O.A02("dalvik.vm.heapmaxfree"), C07O.A02("dalvik.vm.heapminfree"), C07O.A02("dalvik.vm.heaptargetutilization")));
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override // X.C01L
    public final void Adr() {
    }
}
