package X;

import java.util.RandomAccess;

/* renamed from: X.07D, reason: invalid class name */
/* loaded from: classes.dex */
public final class C07D extends AbstractC000200f<Byte> implements RandomAccess {
    public final /* synthetic */ byte[] A00;

    public C07D(byte[] bArr) {
        this.A00 = bArr;
    }

    @Override // X.AbstractC000100e
    public final int A00() {
        return this.A00.length;
    }

    @Override // X.AbstractC000100e, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Byte) {
            byte bByteValue = ((Number) obj).byteValue();
            byte[] bArr = this.A00;
            int length = bArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (bByteValue == bArr[i]) {
                    if (i < 0) {
                        break;
                    }
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    @Override // X.AbstractC000200f, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return Byte.valueOf(this.A00[i]);
    }

    @Override // X.AbstractC000200f, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Byte) {
            byte bByteValue = ((Number) obj).byteValue();
            byte[] bArr = this.A00;
            int length = bArr.length;
            for (int i = 0; i < length; i++) {
                if (bByteValue == bArr[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // X.AbstractC000100e, java.util.Collection
    public final boolean isEmpty() {
        return this.A00.length == 0;
    }

    @Override // X.AbstractC000200f, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        int i;
        if (obj instanceof Byte) {
            byte bByteValue = ((Number) obj).byteValue();
            byte[] bArr = this.A00;
            int length = bArr.length - 1;
            if (length >= 0) {
                do {
                    i = length - 1;
                    if (bByteValue == bArr[length]) {
                        return length;
                    }
                    length = i;
                } while (i >= 0);
            }
        }
        return -1;
    }
}
