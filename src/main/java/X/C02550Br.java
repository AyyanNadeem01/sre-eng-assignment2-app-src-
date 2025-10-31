package X;

import java.io.File;
import java.io.FileFilter;

/* renamed from: X.0Br, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C02550Br implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file.getName().matches("cpu[0-9]+");
    }
}
