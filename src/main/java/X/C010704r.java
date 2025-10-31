package X;

import android.net.Uri;
import android.os.SystemClock;
import com.facebook.perf.background.BackgroundStartupDetector;
import java.nio.MappedByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: X.04r */
/* loaded from: classes.dex */
public final class C010704r {
    public static AtomicReference A03 = new AtomicReference();
    public String A00;
    public final C010604q A01;
    public final Object A02;

    public C010704r(C010604q c010604q) {
        Object obj = new Object();
        this.A02 = obj;
        this.A01 = c010604q;
        AtomicReference atomicReference = A03;
        while (!atomicReference.compareAndSet(null, this)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        A01(this, AnonymousClass065.A03, null, null, "", ' ', '0', false, true, false, false, false);
        A04(EnumC011004u.A0E);
        synchronized (this.A02) {
            this.A01.A00.put(166, (byte) 32);
            A00(this);
        }
        synchronized (this.A02) {
            this.A01.A00.put(205, (byte) 32);
            A00(this);
        }
        synchronized (this.A02) {
            this.A01.A00.put(206, (byte) 48);
            A00(this);
        }
        synchronized (this.A02) {
            MappedByteBuffer mappedByteBuffer = this.A01.A00;
            mappedByteBuffer.put(275, (byte) 48);
            mappedByteBuffer.putLong(276, 0L);
            A02(284, 80, "", false);
            A00(this);
        }
        synchronized (this.A02) {
            MappedByteBuffer mappedByteBuffer2 = this.A01.A00;
            mappedByteBuffer2.putInt(749, -1);
            mappedByteBuffer2.putLong(1753, System.currentTimeMillis());
            mappedByteBuffer2.putLong(1761, SystemClock.uptimeMillis());
            A00(this);
        }
        int i = 0;
        String strSubstring = "unknown".length() > 1000 ? "unknown".substring(0, 1000) : "unknown";
        synchronized (this.A02) {
            MappedByteBuffer mappedByteBuffer3 = this.A01.A00;
            mappedByteBuffer3.putShort(753, (short) 0);
            byte[] bytes = strSubstring.getBytes();
            while (true) {
                int length = bytes.length;
                if (i < length) {
                    mappedByteBuffer3.put(i + 755, bytes[i]);
                    i++;
                } else {
                    mappedByteBuffer3.putShort(753, (short) length);
                    A00(this);
                }
            }
        }
        Object obj2 = this.A02;
        synchronized (obj2) {
            MappedByteBuffer mappedByteBuffer4 = this.A01.A00;
            mappedByteBuffer4.put(207, (byte) 1);
            mappedByteBuffer4.put(224, (byte) 1);
            mappedByteBuffer4.putLong(208, 0L);
            mappedByteBuffer4.putLong(225, 0L);
            mappedByteBuffer4.putLong(216, 0L);
            mappedByteBuffer4.putLong(233, 0L);
            mappedByteBuffer4.put(207, (byte) 0);
            mappedByteBuffer4.put(224, (byte) 0);
        }
        synchronized (obj2) {
            A00(this);
        }
        Object obj3 = this.A02;
        synchronized (obj3) {
            MappedByteBuffer mappedByteBuffer5 = this.A01.A00;
            mappedByteBuffer5.put(241, (byte) 1);
            mappedByteBuffer5.put(258, (byte) 1);
            mappedByteBuffer5.putLong(242, 0L);
            mappedByteBuffer5.putLong(259, 0L);
            mappedByteBuffer5.putLong(250, 0L);
            mappedByteBuffer5.putLong(267, 0L);
            mappedByteBuffer5.put(241, (byte) 0);
            mappedByteBuffer5.put(258, (byte) 0);
        }
        synchronized (obj3) {
            A00(this);
        }
        synchronized (obj) {
            c010604q.A00.put(2242, (byte) 0);
        }
        A03(0L);
    }

    public final void A03(long j) {
        synchronized (this.A02) {
            this.A01.A00.putLong(1769, j);
            A00(this);
        }
    }

    public final void A04(EnumC011004u enumC011004u) {
        char c = enumC011004u.A01;
        synchronized (this.A02) {
            this.A01.A00.put(0, (byte) c);
            A00(this);
        }
    }

    public static void A00(C010704r c010704r) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (c010704r.A02) {
            c010704r.A02(180, 15, Long.toString(jCurrentTimeMillis), false);
        }
    }

    public final void A02(int i, int i2, String str, boolean z) {
        int length;
        int i3 = 0;
        if (str.length() > i2) {
            str = str.substring(0, i2);
        }
        synchronized (this.A02) {
            MappedByteBuffer mappedByteBuffer = this.A01.A00;
            byte[] bytes = str.getBytes();
            if (z) {
                mappedByteBuffer.putShort(i, (short) 0);
            } else {
                mappedByteBuffer.put(i, (byte) 0);
            }
            while (true) {
                length = bytes.length;
                if (i3 >= length) {
                    break;
                }
                int i4 = 2;
                if (!z) {
                    i4 = 1;
                }
                mappedByteBuffer.put(i4 + i + i3, bytes[i3]);
                i3++;
            }
            if (z) {
                mappedByteBuffer.putShort(i, (short) length);
            } else {
                mappedByteBuffer.put(i, (byte) length);
            }
        }
    }

    public static void A01(C010704r c010704r, Integer num, Integer num2, Integer num3, String str, char c, char c2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        char cA00 = AbstractC010804s.A00(num);
        if (c >= 0 && c <= 127) {
            synchronized (c010704r.A02) {
                MappedByteBuffer mappedByteBuffer = c010704r.A01.A00;
                mappedByteBuffer.put(1, (byte) cA00);
                mappedByteBuffer.put(196, (byte) c2);
                mappedByteBuffer.put(2, (byte) c);
                mappedByteBuffer.put(198, (byte) (z ? 49 : 48));
                if (z2 || num.compareTo(AnonymousClass065.A0h) < 0) {
                    mappedByteBuffer.put(202, (byte) 48);
                    mappedByteBuffer.put(BackgroundStartupDetector.ACTIVITY_REDIRECT_LAUNCH_TIMEOUT_MS, (byte) 48);
                    mappedByteBuffer.put(2254, (byte) 48);
                }
                byte b = -1;
                if (num2 != null) {
                    int iIntValue = num2.intValue();
                    if (iIntValue > 127) {
                        iIntValue = 127;
                    }
                    mappedByteBuffer.put(203, (byte) iIntValue);
                } else {
                    mappedByteBuffer.put(203, (byte) -1);
                }
                if (num3 != null) {
                    int iIntValue2 = num3.intValue();
                    b = (byte) (iIntValue2 <= 127 ? iIntValue2 : 127);
                }
                mappedByteBuffer.put(204, b);
                if (z3) {
                    mappedByteBuffer.put(1985, (byte) (z4 ? 49 : 48));
                    mappedByteBuffer.put(1986, (byte) (z5 ? 49 : 48));
                }
                if (str != null) {
                    c010704r.A02(1987, 255, str, false);
                }
                if (C010904t.A02 == null) {
                    synchronized (C010904t.class) {
                        if (C010904t.A02 == null) {
                            C010904t.A02 = new C010904t();
                        }
                    }
                }
                C010904t c010904t = C010904t.A02;
                if (c010904t != null) {
                    Uri uri = (Uri) c010904t.A00.get();
                    Uri uri2 = (Uri) c010904t.A01.get();
                    String strSubstring = "N/A";
                    String string = uri != null ? uri.toString() : "N/A";
                    if (uri2 != null) {
                        strSubstring = uri2.toString();
                    }
                    if (string.length() > 485) {
                        string = string.substring(0, 485);
                    }
                    if (strSubstring.length() > 485) {
                        strSubstring = strSubstring.substring(0, 485);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("first", string);
                        jSONObject.put("last", strSubstring);
                    } catch (JSONException unused) {
                    }
                    String string2 = jSONObject.toString();
                    if (!string2.isEmpty() && string2.length() < 1000) {
                        c010704r.A02(2255, 1000, string2, true);
                    }
                }
                A00(c010704r);
            }
            return;
        }
        throw new IllegalStateException("State byte should be ASCII");
    }
}
