package X;

import android.os.StrictMode;
import android.util.Log;
import com.facebook.soloader.MinElf$ElfError;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: X.0BT, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0BT {
    public static Map A00;
    public static byte[] A01;
    public static List A02;
    public static volatile boolean A05;
    public static final ReentrantReadWriteLock A04 = new ReentrantReadWriteLock();
    public static final HashSet A03 = new HashSet<String>() { // from class: X.0BU
        {
            add("libEGL.so");
            add("libGLESv2.so");
            add("libGLESv3.so");
            add("libOpenSLES.so");
            add("libandroid.so");
            add("libc.so");
            add("libdl.so");
            add("libjnigraphics.so");
            add("liblog.so");
            add("libm.so");
            add("libstdc++.so");
            add("libz.so");
        }
    };

    public static long A00(InterfaceC013005s interfaceC013005s, ByteBuffer byteBuffer, long j) {
        A05(interfaceC013005s, byteBuffer, 4, j);
        return byteBuffer.getInt() & 4294967295L;
    }

    public static void A05(InterfaceC013005s interfaceC013005s, ByteBuffer byteBuffer, int i, long j) {
        int iAgn;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (iAgn = interfaceC013005s.Agn(byteBuffer, j)) != -1) {
            j += iAgn;
        }
        if (byteBuffer.remaining() > 0) {
            throw new MinElf$ElfError("ELF file truncated");
        }
        byteBuffer.position(0);
    }

    public static boolean A06(byte[] bArr) throws NumberFormatException {
        int length;
        StringBuilder sbA09;
        String str;
        byte b;
        int i = 0;
        while (true) {
            length = bArr.length;
            if (i >= length || bArr[i] == 10) {
                break;
            }
            i++;
        }
        if (i < length) {
            i++;
        }
        int i2 = length;
        if (i < length) {
            try {
                i2 = Integer.parseInt(new String(bArr, 0, i - 1));
                if (i2 > 0) {
                    A00 = new HashMap(((int) (i2 / 1.0f)) + 1, 1.0f);
                    A02 = new ArrayList(i2);
                    while (true) {
                        int i3 = 5381;
                        int i4 = i;
                        while (true) {
                            try {
                                b = bArr[i4];
                                if (b <= 32) {
                                    break;
                                }
                                i3 = (i3 << 5) + i3 + b;
                                i4++;
                            } catch (IndexOutOfBoundsException unused) {
                                if (i != length) {
                                    A03(i3, i);
                                }
                            }
                        }
                        A03(i3, i);
                        boolean z = b != 32;
                        while (true) {
                            i = i4 + 1;
                            if (z) {
                                break;
                            }
                            while (bArr[i] != 10) {
                                try {
                                    i++;
                                } catch (IndexOutOfBoundsException unused2) {
                                    if (A02.size() == i2) {
                                        A01 = bArr;
                                        A05 = true;
                                        return true;
                                    }
                                    sbA09 = AnonymousClass000.A09();
                                    sbA09.append("Invalid native deps file, precomputed libs size (");
                                    sbA09.append(A02.size());
                                    str = ") != libsCount (";
                                    sbA09.append(str);
                                    sbA09.append(i2);
                                    sbA09.append(")");
                                    Log.w("SoLoader[NativeDeps]", sbA09.toString());
                                    return false;
                                }
                            }
                            z = true;
                            i4 = i;
                        }
                    }
                }
            } catch (NumberFormatException unused3) {
                i2 = -1;
            }
            sbA09 = AnonymousClass000.A09();
            sbA09.append("Invalid native deps file, libsCount=");
            sbA09.append(i2);
            Log.w("SoLoader[NativeDeps]", sbA09.toString());
            return false;
        }
        sbA09 = AnonymousClass000.A09();
        sbA09.append("Invalid native deps file, deps_offset (");
        sbA09.append(i);
        str = ") >= length (";
        sbA09.append(str);
        sbA09.append(i2);
        sbA09.append(")");
        Log.w("SoLoader[NativeDeps]", sbA09.toString());
        return false;
    }

    public static String A01(int i) {
        byte[] bArr;
        if (i >= A02.size()) {
            return null;
        }
        int iIntValue = ((Number) A02.get(i)).intValue();
        int i2 = iIntValue;
        while (true) {
            bArr = A01;
            if (i2 >= bArr.length || bArr[i2] <= 32) {
                break;
            }
            i2++;
        }
        int i3 = (i2 - iIntValue) + 6;
        char[] cArr = new char[i3];
        cArr[0] = 'l';
        cArr[1] = 'i';
        cArr[2] = 'b';
        for (int i4 = 0; i4 < i3 - 6; i4++) {
            cArr[i4 + 3] = (char) bArr[iIntValue + i4];
        }
        cArr[i3 - 3] = '.';
        cArr[i3 - 2] = 's';
        cArr[i3 - 1] = 'o';
        return new String(cArr);
    }

    public static void A02() {
        if (A05) {
            synchronized (C0BT.class) {
                if (A05) {
                    throw AnonymousClass000.A04("Trying to initialize NativeDeps but it was already initialized");
                }
            }
        }
    }

    public static void A03(int i, int i2) {
        List list = A02;
        Integer numValueOf = Integer.valueOf(i2);
        list.add(numValueOf);
        Map map = A00;
        Integer numValueOf2 = Integer.valueOf(i);
        List listA0B = (List) map.get(numValueOf2);
        if (listA0B == null) {
            listA0B = AnonymousClass000.A0B();
            A00.put(numValueOf2, listA0B);
        }
        listA0B.add(numValueOf);
    }

    public static String[] A07(InterfaceC013005s interfaceC013005s) {
        long jA00;
        short s;
        long jA002;
        long j;
        long jA003;
        long jA004;
        long j2;
        long jA005;
        long jA006;
        long jA007;
        long jA008;
        long jA009;
        long jA0010;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jA0011 = A00(interfaceC013005s, byteBufferAllocate, 0L);
        if (jA0011 != 1179403647) {
            StringBuilder sbA09 = AnonymousClass000.A09();
            sbA09.append("file is not ELF: magic is 0x");
            sbA09.append(Long.toHexString(jA0011));
            sbA09.append(", it should be ");
            sbA09.append(Long.toHexString(1179403647L));
            sbA09.append(", file size: ");
            sbA09.append(interfaceC013005s.size());
            throw new MinElf$ElfError(sbA09.toString());
        }
        A05(interfaceC013005s, byteBufferAllocate, 1, 4L);
        boolean z = ((short) (byteBufferAllocate.get() & 255)) == 1;
        A05(interfaceC013005s, byteBufferAllocate, 1, 5L);
        if (((short) (byteBufferAllocate.get() & 255)) == 2) {
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        }
        if (z) {
            jA00 = A00(interfaceC013005s, byteBufferAllocate, 28L);
            A05(interfaceC013005s, byteBufferAllocate, 2, 44L);
            s = 65535;
            jA002 = byteBufferAllocate.getShort() & 65535;
            j = 42;
        } else {
            A05(interfaceC013005s, byteBufferAllocate, 8, 32L);
            jA00 = byteBufferAllocate.getLong();
            A05(interfaceC013005s, byteBufferAllocate, 2, 56L);
            s = 65535;
            jA002 = byteBufferAllocate.getShort() & 65535;
            j = 54;
        }
        A05(interfaceC013005s, byteBufferAllocate, 2, j);
        int i = byteBufferAllocate.getShort() & s;
        if (jA002 == 65535) {
            if (z) {
                jA0010 = A00(interfaceC013005s, byteBufferAllocate, 32L) + 28;
            } else {
                A05(interfaceC013005s, byteBufferAllocate, 8, 40L);
                jA0010 = byteBufferAllocate.getLong() + 44;
            }
            jA002 = A00(interfaceC013005s, byteBufferAllocate, jA0010);
        }
        long j3 = jA00;
        long j4 = 0;
        while (true) {
            if (j4 >= jA002) {
                break;
            }
            if (A00(interfaceC013005s, byteBufferAllocate, j3) == 2) {
                if (z) {
                    jA003 = A00(interfaceC013005s, byteBufferAllocate, j3 + 4);
                } else {
                    A05(interfaceC013005s, byteBufferAllocate, 8, j3 + 8);
                    jA003 = byteBufferAllocate.getLong();
                }
                if (jA003 != 0) {
                    long j5 = jA003;
                    long jA0012 = 0;
                    int i2 = 0;
                    do {
                        if (z) {
                            jA004 = A00(interfaceC013005s, byteBufferAllocate, j5);
                        } else {
                            A05(interfaceC013005s, byteBufferAllocate, 8, j5);
                            jA004 = byteBufferAllocate.getLong();
                        }
                        if (jA004 == 1) {
                            if (i2 == Integer.MAX_VALUE) {
                                throw new MinElf$ElfError("malformed DT_NEEDED section");
                            }
                            i2++;
                        } else if (jA004 == 5) {
                            if (z) {
                                jA0012 = A00(interfaceC013005s, byteBufferAllocate, j5 + 4);
                            } else {
                                A05(interfaceC013005s, byteBufferAllocate, 8, j5 + 8);
                                jA0012 = byteBufferAllocate.getLong();
                            }
                        }
                        j2 = 16;
                        j5 += z ? 8L : 16L;
                    } while (jA004 != 0);
                    if (jA0012 == 0) {
                        throw new MinElf$ElfError("Dynamic section string-table not found");
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jA002) {
                            break;
                        }
                        if (A00(interfaceC013005s, byteBufferAllocate, jA00) == 1) {
                            if (z) {
                                jA005 = A00(interfaceC013005s, byteBufferAllocate, jA00 + 8);
                                jA006 = A00(interfaceC013005s, byteBufferAllocate, jA00 + 20);
                            } else {
                                A05(interfaceC013005s, byteBufferAllocate, 8, jA00 + j2);
                                jA005 = byteBufferAllocate.getLong();
                                A05(interfaceC013005s, byteBufferAllocate, 8, jA00 + 40);
                                jA006 = byteBufferAllocate.getLong();
                            }
                            if (jA005 <= jA0012 && jA0012 < jA006 + jA005) {
                                if (z) {
                                    jA007 = A00(interfaceC013005s, byteBufferAllocate, jA00 + 4);
                                } else {
                                    A05(interfaceC013005s, byteBufferAllocate, 8, jA00 + 8);
                                    jA007 = byteBufferAllocate.getLong();
                                }
                                long j6 = jA007 + (jA0012 - jA005);
                                if (j6 != 0) {
                                    String[] strArr = new String[i2];
                                    int i4 = 0;
                                    do {
                                        if (z) {
                                            jA008 = A00(interfaceC013005s, byteBufferAllocate, jA003);
                                        } else {
                                            A05(interfaceC013005s, byteBufferAllocate, 8, jA003);
                                            jA008 = byteBufferAllocate.getLong();
                                        }
                                        if (jA008 == 1) {
                                            if (z) {
                                                jA009 = A00(interfaceC013005s, byteBufferAllocate, jA003 + 4);
                                            } else {
                                                A05(interfaceC013005s, byteBufferAllocate, 8, jA003 + 8);
                                                jA009 = byteBufferAllocate.getLong();
                                            }
                                            long j7 = jA009 + j6;
                                            StringBuilder sbA092 = AnonymousClass000.A09();
                                            while (true) {
                                                long j8 = 1 + j7;
                                                A05(interfaceC013005s, byteBufferAllocate, 1, j7);
                                                short s2 = (short) (byteBufferAllocate.get() & 255);
                                                if (s2 == 0) {
                                                    break;
                                                }
                                                sbA092.append((char) s2);
                                                j7 = j8;
                                            }
                                            strArr[i4] = sbA092.toString();
                                            if (i4 == Integer.MAX_VALUE) {
                                                throw new MinElf$ElfError("malformed DT_NEEDED section");
                                            }
                                            i4++;
                                        }
                                        jA003 += z ? 8L : 16L;
                                    } while (jA008 != 0);
                                    if (i4 == i2) {
                                        return strArr;
                                    }
                                    throw new MinElf$ElfError("malformed DT_NEEDED section");
                                }
                            }
                        }
                        jA00 += i;
                        i3++;
                        j2 = 16;
                    }
                    throw new MinElf$ElfError("did not find file offset of DT_STRTAB table");
                }
            } else {
                j3 += i;
                j4++;
            }
        }
        throw new MinElf$ElfError("ELF file does not contain dynamic linking information");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d7, code lost:
    
        if (r5 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d9, code lost:
    
        r1 = A01(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00dd, code lost:
    
        if (r1 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00df, code lost:
    
        r4.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e6, code lost:
    
        if (r4.isEmpty() != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e8, code lost:
    
        r0 = (java.lang.String[]) r4.toArray(new java.lang.String[r4.size()]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] A08(X.InterfaceC013005s r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C0BT.A08(X.05s, java.lang.String):java.lang.String[]");
    }

    public static void A04(StrictMode.ThreadPolicy threadPolicy, InterfaceC013005s interfaceC013005s, String str, int i) {
        String[] strArrA08 = A08(interfaceC013005s, str);
        Arrays.toString(strArrA08);
        AbstractC02460Bh.A00("SoLoader");
        for (String str2 : strArrA08) {
            if (!str2.startsWith("/") && !A03.contains(str2)) {
                C0BG.A05(threadPolicy, str2, i);
            }
        }
    }
}
