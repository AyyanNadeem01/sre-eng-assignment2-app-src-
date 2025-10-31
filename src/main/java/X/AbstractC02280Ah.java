package X;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Parcel;
import java.io.File;
import java.io.IOException;

/* renamed from: X.0Ah, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC02280Ah {
    public static byte[] A00(Context context, File file, String str) throws IOException {
        File canonicalFile = file.getCanonicalFile();
        Parcel parcelObtain = Parcel.obtain();
        try {
            if (AbstractC017707t.A01() == 0 || AbstractC017707t.A01() == 1) {
                parcelObtain.writeString(canonicalFile.getPath());
                parcelObtain.writeLong(canonicalFile.lastModified());
                PackageManager packageManager = context.getPackageManager();
                int i = 0;
                if (packageManager != null) {
                    try {
                        i = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                    } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                    }
                }
                parcelObtain.writeInt(i);
            }
            parcelObtain.writeLong(AbstractC017707t.A01());
            parcelObtain.writeString(str);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }
}
