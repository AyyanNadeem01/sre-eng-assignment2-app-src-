package X;

import java.io.File;
import java.io.FileFilter;

/* renamed from: X.00x, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C002000x implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        return file.getName().startsWith("session_") || file.getName().startsWith("sess_");
    }
}
