package X;

import java.util.zip.ZipEntry;

/* renamed from: X.0Bu, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C02570Bu extends C0Bz implements Comparable {
    public final int A00;
    public final ZipEntry A01;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C02570Bu c02570Bu = (C02570Bu) obj;
            if (!this.A01.equals(c02570Bu.A01) || this.A00 != c02570Bu.A00) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return super.A01.compareTo(((C0Bz) obj).A01);
    }

    public final int hashCode() {
        return (this.A00 * 31) + this.A01.hashCode();
    }

    public C02570Bu(String str, ZipEntry zipEntry, int i) {
        super(str, String.valueOf(zipEntry.getCrc()));
        this.A01 = zipEntry;
        this.A00 = i;
    }
}
