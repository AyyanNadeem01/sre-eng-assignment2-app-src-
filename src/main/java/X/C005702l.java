package X;

import java.io.File;
import java.io.FileFilter;

/* renamed from: X.02l, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C005702l implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file != null && file.getName().startsWith("_attempt");
    }
}
