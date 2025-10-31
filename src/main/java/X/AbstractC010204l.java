package X;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;

/* renamed from: X.04l, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC010204l {
    public static char A00(File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        EnumC011004u enumC011004u;
        RandomAccessFile randomAccessFile;
        if (file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                } finally {
                }
            } catch (IOException e) {
                C0C5.A00();
                C018108b.A0C("lacrima", "Reading AppStateNativeParser failed", e);
            }
            if (randomAccessFile.length() != 0) {
                char c = (char) randomAccessFile.readByte();
                randomAccessFile.close();
                return c;
            }
            randomAccessFile.close();
            enumC011004u = EnumC011004u.A0B;
        } else {
            enumC011004u = EnumC011004u.A0E;
        }
        return enumC011004u.A01;
    }
}
