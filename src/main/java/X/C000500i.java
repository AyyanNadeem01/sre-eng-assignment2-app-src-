package X;

import java.io.Serializable;
import java.lang.Enum;

/* renamed from: X.00i, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C000500i<T extends Enum<T>> extends AbstractC000200f<T> implements InterfaceC000300g<T>, Serializable {
    public final Enum[] A00;

    @Override // X.AbstractC000100e
    public final int A00() {
        return this.A00.length;
    }

    @Override // X.AbstractC000100e, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            Enum r4 = (Enum) obj;
            C06E.A07(r4, 0);
            Enum[] enumArr = this.A00;
            int iOrdinal = r4.ordinal();
            C06E.A07(enumArr, 0);
            if (iOrdinal >= 0 && iOrdinal < enumArr.length && enumArr[iOrdinal] == r4) {
                return true;
            }
        }
        return false;
    }

    @Override // X.AbstractC000200f, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        Enum[] enumArr = this.A00;
        AnonymousClass060.A01(i, enumArr.length);
        return enumArr[i];
    }

    @Override // X.AbstractC000200f, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r4 = (Enum) obj;
        C06E.A07(r4, 0);
        int iOrdinal = r4.ordinal();
        Enum[] enumArr = this.A00;
        C06E.A07(enumArr, 0);
        if (iOrdinal < 0 || iOrdinal >= enumArr.length || enumArr[iOrdinal] != r4) {
            return -1;
        }
        return iOrdinal;
    }

    @Override // X.AbstractC000200f, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        C06E.A07(obj, 0);
        return indexOf(obj);
    }

    public C000500i(Enum[] enumArr) {
        this.A00 = enumArr;
    }
}
