package X;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteOrder;

/* renamed from: X.07Z, reason: invalid class name */
/* loaded from: classes.dex */
public final class C07Z {
    public int A00;
    public int A01;
    public final C07Z A02;
    public final DataInputStream A03;

    private void A00() throws EOFException {
        int i;
        int i2 = this.A01;
        if (i2 < 0 || (i = this.A00) <= i2) {
            return;
        }
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("Invalid access: limit=");
        sbA09.append(i2);
        throw new EOFException(AnonymousClass000.A08(", consumed=", sbA09, i));
    }

    public final byte A01() throws EOFException {
        this.A00++;
        A00();
        DataInputStream dataInputStream = this.A03;
        if (dataInputStream != null) {
            return dataInputStream.readByte();
        }
        C07Z c07z = this.A02;
        if (c07z != null) {
            return c07z.A01();
        }
        throw new NullPointerException("Source input stream was not setup.");
    }

    public final int A02() throws IOException {
        this.A00 += 4;
        A00();
        DataInputStream dataInputStream = this.A03;
        if (dataInputStream != null) {
            int i = dataInputStream.readInt();
            return ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? Integer.reverseBytes(i) : i;
        }
        C07Z c07z = this.A02;
        if (c07z != null) {
            return c07z.A02();
        }
        throw new NullPointerException("Source input stream was not setup.");
    }

    public final short A03() throws IOException {
        this.A00 += 2;
        A00();
        DataInputStream dataInputStream = this.A03;
        if (dataInputStream != null) {
            short s = dataInputStream.readShort();
            return ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? Short.reverseBytes(s) : s;
        }
        C07Z c07z = this.A02;
        if (c07z != null) {
            return c07z.A03();
        }
        throw new NullPointerException("Source input stream was not setup.");
    }

    public final void A04(int i) throws IOException {
        this.A00 += i;
        A00();
        DataInputStream dataInputStream = this.A03;
        if (dataInputStream != null) {
            dataInputStream.skipBytes(i);
            return;
        }
        C07Z c07z = this.A02;
        if (c07z == null) {
            throw new NullPointerException("Source input stream was not setup.");
        }
        c07z.A04(i);
    }

    public final void A05(byte[] bArr) throws IOException {
        this.A00 += bArr.length;
        A00();
        DataInputStream dataInputStream = this.A03;
        if (dataInputStream != null) {
            dataInputStream.readFully(bArr);
            return;
        }
        C07Z c07z = this.A02;
        if (c07z == null) {
            throw new NullPointerException("Source input stream was not setup.");
        }
        c07z.A05(bArr);
    }

    public C07Z(C07Z c07z) {
        this.A03 = null;
        this.A02 = c07z;
    }

    public C07Z(DataInputStream dataInputStream) {
        this.A03 = dataInputStream;
        this.A02 = null;
    }
}
