package com.facebook.video.grootplayer.safesurfaceview;

import android.os.Build;
import android.util.Log;
import android.view.SurfaceView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class SafeSurfaceViewAndroidR$SurfaceViewRaceFixHackAndroidR$SurfaceViewRaceFixHackAndroidRInternal {
    public static final SafeSurfaceViewAndroidR$SurfaceViewRaceFixHackAndroidR$SurfaceViewRaceFixHackAndroidRInternal INSTANCE = new SafeSurfaceViewAndroidR$SurfaceViewRaceFixHackAndroidR$SurfaceViewRaceFixHackAndroidRInternal();
    public static Field field_mBackgroundControl;
    public static Field field_mBlastSurfaceControl;
    public static boolean reflectionAttempted;

    public static final List apply(SurfaceView surfaceView) throws NoSuchFieldException, SecurityException {
        if (!reflectionAttempted) {
            try {
                reflectionAttempted = true;
                Field declaredField = SurfaceView.class.getDeclaredField("mBackgroundControl");
                field_mBackgroundControl = declaredField;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
                if (Build.VERSION.SDK_INT == 31) {
                    Field declaredField2 = SurfaceView.class.getDeclaredField("mBlastSurfaceControl");
                    field_mBlastSurfaceControl = declaredField2;
                    if (declaredField2 != null) {
                        declaredField2.setAccessible(true);
                    }
                }
            } catch (Exception e) {
                Log.e("FBLiteSurfaceView", "Failed to get inner field", e);
            }
        }
        ArrayList arrayList = new ArrayList();
        try {
            Field field = field_mBackgroundControl;
            Object obj = field != null ? field.get(surfaceView) : null;
            if (obj != null) {
                arrayList.add(obj);
            }
        } catch (Exception e2) {
            Log.e("FBLiteSurfaceView", "Failed to get inner field", e2);
        }
        try {
            Field field2 = field_mBlastSurfaceControl;
            Object obj2 = field2 != null ? field2.get(surfaceView) : null;
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        } catch (Exception e3) {
            Log.e("FBLiteSurfaceView", "Failed to get inner field", e3);
        }
        return arrayList;
    }
}
