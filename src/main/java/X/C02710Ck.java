package X;

import java.io.File;
import java.io.FileFilter;

/* renamed from: X.0Ck, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public class C02710Ck implements FileFilter {
    public final int $t;
    public final String A00;

    public C02710Ck(String str, int i) {
        this.$t = i;
        this.A00 = str;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        if (this.$t == 0) {
            return file != null && file.getName().endsWith(this.A00);
        }
        String str = this.A00;
        if (file == null || !file.isDirectory()) {
            return false;
        }
        String name = file.getName();
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("session_");
        sbA09.append(str);
        if (!name.startsWith(AnonymousClass000.A07("_", sbA09))) {
            String name2 = file.getName();
            StringBuilder sbA092 = AnonymousClass000.A09();
            sbA092.append("sess_");
            if (!name2.startsWith(AnonymousClass000.A06(str, "_", sbA092))) {
                return false;
            }
        }
        return true;
    }
}
