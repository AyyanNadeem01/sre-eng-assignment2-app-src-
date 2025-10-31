package X;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.facebook.superpack.AssetDecompressionException;
import com.facebook.superpack.AssetDecompressor;
import com.facebook.superpack.SuperpackFileLoader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: X.0AW, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0AW extends C0CI implements C0BS {
    public C0Af A00;
    public C0Bz[] A01;
    public final File A02;
    public final String A03;
    public final String A04;
    public final String A05;
    public final File A06;

    @Override // X.C0CI
    public final C0CM A09() {
        return new C0CM() { // from class: X.03p
            public final ZipEntry A00;
            public final ZipFile A01;

            {
                ZipFile zipFile = new ZipFile(this.A02.A02);
                try {
                    this.A00 = zipFile.getEntry(this.A02.A04);
                    this.A01 = zipFile;
                } catch (Throwable th) {
                    zipFile.close();
                    throw th;
                }
            }

            @Override // X.C0CM
            public final void A01(File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                ZipEntry zipEntry = this.A00;
                if (zipEntry == null) {
                    Log.e("SoLoader", "Trying to unpack, but the compressed asset is null.");
                    return;
                }
                String str = this.A02.A00.A01;
                String strSubstring = str.substring(str.lastIndexOf(46) + 1);
                C0BG.A0A(SuperpackFileLoader.SUPERPACK_LIBNAME_FOR_SOLOADER);
                try {
                    InputStream inputStream = this.A01.getInputStream(zipEntry);
                    try {
                        String[] strArrDecompress_legacy = AssetDecompressor.decompress_legacy(inputStream, strSubstring, file.getCanonicalPath());
                        StringBuilder sb = new StringBuilder();
                        sb.append("Extracted ");
                        sb.append(strArrDecompress_legacy.length);
                        sb.append(" libs using Superpack");
                        Log.w("SoLoader", sb.toString());
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } finally {
                    }
                } catch (AssetDecompressionException e) {
                    throw new IOException(e);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:35:0x00a8, code lost:
            
                r0 = new java.lang.StringBuilder();
                r0.append("Illegal line in compressed metadata: [");
                r0.append(r12);
                r0.append("]");
                android.util.Log.w("SoLoader", r0.toString());
                r0 = new X.C0Bz[0];
             */
            @Override // X.C0CM
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final X.C0Bz[] A02() throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                /*
                    Method dump skipped, instructions count: 239
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: X.C008003p.A02():X.0Bz[]");
            }

            @Override // X.C0CM, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
                this.A01.close();
            }
        };
    }

    @Override // X.C0CI
    public final byte[] A0A() {
        return AbstractC02280Ah.A00(((C0CI) this).A01, this.A06, this.A05);
    }

    @Override // X.C0BS
    public final C0AD Ah9(ApplicationInfo applicationInfo) {
        ((C0CJ) this).A00 |= 1;
        return this;
    }

    @Override // X.C0CJ, X.C0AD
    public final String toString() {
        String name;
        try {
            name = String.valueOf(((C0CJ) this).A01.getCanonicalPath());
        } catch (IOException unused) {
            name = ((C0CJ) this).A01.getName();
        }
        StringBuilder sbA09 = AnonymousClass000.A09();
        sbA09.append("SuperpackSoSource");
        sbA09.append("[root = ");
        sbA09.append(name);
        sbA09.append(" flags = ");
        sbA09.append(((C0CJ) this).A00);
        sbA09.append(" zipSource = ");
        sbA09.append(this.A02.getPath());
        sbA09.append(" compressedPath = ");
        sbA09.append(this.A04);
        sbA09.append(" identity = ");
        sbA09.append(this.A05);
        sbA09.append(']');
        return sbA09.toString();
    }

    public C0AW(Context context, C0Af c0Af, boolean z) {
        super(context, C0AP.A01(context, 114712842), z);
        this.A01 = null;
        this.A05 = "";
        File fileA01 = AnonymousClass000.A01(((C0CI) this).A01);
        this.A06 = fileA01;
        this.A02 = fileA01;
        this.A00 = c0Af;
        this.A04 = c0Af.A00;
        this.A03 = "assets/lib/metadata.txt";
    }

    @Override // X.C0CJ, X.C0AD
    public final String A05() {
        return "SuperpackSoSource";
    }

    public C0AW(Context context, C0Af c0Af, File file, File file2, String str, String str2, String str3) {
        super(context, file, true);
        this.A01 = null;
        this.A05 = str;
        this.A06 = AnonymousClass000.A01(context);
        this.A02 = file2;
        this.A00 = c0Af;
        this.A04 = str2;
        this.A03 = str3;
    }
}
