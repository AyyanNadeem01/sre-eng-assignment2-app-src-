package X;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import java.lang.reflect.InvocationTargetException;

/* renamed from: X.0CI, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C0CI extends C0CJ {
    public String[] A00;
    public final Context A01;

    public abstract C0CM A09();

    public static void A00(File file, byte b, boolean z) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile.seek(0L);
                randomAccessFile.write(b);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (z) {
                    randomAccessFile.getFD().sync();
                }
                randomAccessFile.close();
            } finally {
            }
        } catch (SyncFailedException e) {
            Log.w("fb-UnpackingSoSource", "state file sync failed", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f9 A[Catch: all -> 0x0199, TryCatch #7 {all -> 0x0199, blocks: (B:16:0x0052, B:18:0x005b, B:20:0x0061, B:21:0x0072, B:22:0x0073, B:26:0x0087, B:27:0x008d, B:34:0x00b3, B:36:0x00b8, B:45:0x00d9, B:77:0x0162, B:75:0x014c, B:50:0x00e5, B:55:0x00f2, B:54:0x00ef, B:57:0x00f4, B:58:0x00f9, B:61:0x00ff, B:63:0x0110, B:65:0x0114, B:66:0x011f, B:68:0x0126, B:79:0x016c, B:81:0x0178, B:82:0x0192, B:76:0x0151, B:37:0x00bd, B:39:0x00c7, B:41:0x00cd, B:43:0x00d2, B:49:0x00e1, B:71:0x0140, B:73:0x0146), top: B:112:0x0052, outer: #3, inners: #0, #4, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0110 A[Catch: all -> 0x0199, TryCatch #7 {all -> 0x0199, blocks: (B:16:0x0052, B:18:0x005b, B:20:0x0061, B:21:0x0072, B:22:0x0073, B:26:0x0087, B:27:0x008d, B:34:0x00b3, B:36:0x00b8, B:45:0x00d9, B:77:0x0162, B:75:0x014c, B:50:0x00e5, B:55:0x00f2, B:54:0x00ef, B:57:0x00f4, B:58:0x00f9, B:61:0x00ff, B:63:0x0110, B:65:0x0114, B:66:0x011f, B:68:0x0126, B:79:0x016c, B:81:0x0178, B:82:0x0192, B:76:0x0151, B:37:0x00bd, B:39:0x00c7, B:41:0x00cd, B:43:0x00d2, B:49:0x00e1, B:71:0x0140, B:73:0x0146), top: B:112:0x0052, outer: #3, inners: #0, #4, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0151 A[Catch: all -> 0x0199, TryCatch #7 {all -> 0x0199, blocks: (B:16:0x0052, B:18:0x005b, B:20:0x0061, B:21:0x0072, B:22:0x0073, B:26:0x0087, B:27:0x008d, B:34:0x00b3, B:36:0x00b8, B:45:0x00d9, B:77:0x0162, B:75:0x014c, B:50:0x00e5, B:55:0x00f2, B:54:0x00ef, B:57:0x00f4, B:58:0x00f9, B:61:0x00ff, B:63:0x0110, B:65:0x0114, B:66:0x011f, B:68:0x0126, B:79:0x016c, B:81:0x0178, B:82:0x0192, B:76:0x0151, B:37:0x00bd, B:39:0x00c7, B:41:0x00cd, B:43:0x00d2, B:49:0x00e1, B:71:0x0140, B:73:0x0146), top: B:112:0x0052, outer: #3, inners: #0, #4, #8 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    @Override // X.C0AD
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A07(int r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C0CI.A07(int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0CI(Context context, String str, boolean z) {
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append(context.getApplicationInfo().dataDir);
        super(AnonymousClass000.A03(AnonymousClass000.A06("/", str, sbA09)), z ? 1 : 0);
        this.A01 = context;
    }

    public byte[] A0A() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Parcel parcelObtain = Parcel.obtain();
        C0CM c0cmA09 = A09();
        try {
            C0Bz[] c0BzArrA02 = c0cmA09.A02();
            parcelObtain.writeInt(c0BzArrA02.length);
            for (C0Bz c0Bz : c0BzArrA02) {
                parcelObtain.writeString(c0Bz.A01);
                parcelObtain.writeString(c0Bz.A00);
            }
            c0cmA09.close();
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Throwable th) {
            try {
                c0cmA09.close();
                throw th;
            } catch (Throwable th2) {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                throw th;
            }
        }
    }

    public C0Bz[] A0B() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C0CM c0cmA09 = A09();
        try {
            C0Bz[] c0BzArrA02 = c0cmA09.A02();
            c0cmA09.close();
            return c0BzArrA02;
        } catch (Throwable th) {
            try {
                c0cmA09.close();
                throw th;
            } catch (Throwable th2) {
                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                throw th;
            }
        }
    }

    public C0CI(Context context, File file, boolean z) {
        super(file, z ? 1 : 0);
        this.A01 = context;
    }
}
