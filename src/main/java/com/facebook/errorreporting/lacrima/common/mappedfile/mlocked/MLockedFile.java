package com.facebook.errorreporting.lacrima.common.mappedfile.mlocked;

import X.C010604q;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class MLockedFile extends C010604q {
    public static volatile boolean sLibraryLoaded;

    public static native void mlockBuffer(ByteBuffer byteBuffer);

    public static native void munlockBuffer(ByteBuffer byteBuffer);

    @Override // X.C010604q
    public void mlockBuffer() {
        if (sLibraryLoaded) {
            mlockBuffer(this.A00);
        }
    }
}
