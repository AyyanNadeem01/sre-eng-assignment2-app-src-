package X;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Log;
import com.facebook.lite.SharedPreferencesHookA11;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* renamed from: X.0CT, reason: invalid class name */
/* loaded from: classes.dex */
public final class C0CT {
    public static final Object A01 = new Object();
    public static volatile C0CT A02;
    public Integer A00 = null;

    public static C0CT A00() {
        if (A02 == null) {
            synchronized (A01) {
                if (A02 == null) {
                    A02 = new C0CT();
                }
            }
        }
        return A02;
    }

    public final Integer A01() throws IllegalAccessException, NoSuchFieldException, C022109x, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException {
        Object queue;
        Integer num;
        boolean z;
        ActivityInfo activityInfo;
        Intent intent;
        Integer num2 = this.A00;
        if (num2 != null) {
            return num2;
        }
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                queue = Looper.getMainLooper().getQueue();
            } else {
                Field declaredField = Looper.class.getDeclaredField("mQueue");
                declaredField.setAccessible(true);
                queue = declaredField.get(Looper.getMainLooper());
            }
            Field declaredField2 = MessageQueue.class.getDeclaredField("mMessages");
            declaredField2.setAccessible(true);
            Message message = (Message) declaredField2.get(queue);
            int i2 = SharedPreferencesHookA11.QueuedWorkFix.EXECUTE_TRANSACTION;
            if (i < 28) {
                i2 = 100;
            }
            Field declaredField3 = null;
            while (true) {
                if (message == null) {
                    num = AnonymousClass065.A0C;
                    break;
                }
                if (message.what == i2) {
                    if (i < 28) {
                        num = AnonymousClass065.A00;
                        break;
                    }
                    num = null;
                    try {
                        Class<?> cls = Class.forName("android.app.servertransaction.ClientTransaction");
                        Method declaredMethod = cls.getDeclaredMethod("getCallbacks", new Class[0]);
                        declaredMethod.setAccessible(true);
                        Class<?> cls2 = Class.forName("android.app.servertransaction.LaunchActivityItem");
                        Field declaredField4 = cls2.getDeclaredField("mInfo");
                        declaredField4.setAccessible(true);
                        Field declaredField5 = cls2.getDeclaredField("mIntent");
                        declaredField5.setAccessible(true);
                        if (cls.isInstance(message.obj)) {
                            try {
                                Iterator it = ((List) declaredMethod.invoke(message.obj, null)).iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    Object next = it.next();
                                    if (cls2.isInstance(next)) {
                                        try {
                                            intent = (Intent) declaredField5.get(next);
                                        } catch (Exception e) {
                                            Log.w("LeanBackgroundStartDetector", "Failed to find intent through reflection", e);
                                            z = false;
                                        }
                                        try {
                                            if (intent != null && "android.intent.action.MAIN".equals(intent.getAction())) {
                                                String type = intent.getType();
                                                z = true;
                                                if (type != null) {
                                                }
                                                activityInfo = (ActivityInfo) declaredField4.get(next);
                                                if (activityInfo != null && activityInfo.launchMode == 2) {
                                                    num = z ? AnonymousClass065.A01 : AnonymousClass065.A00;
                                                }
                                            }
                                            activityInfo = (ActivityInfo) declaredField4.get(next);
                                            if (activityInfo != null) {
                                                continue;
                                            }
                                        } catch (IllegalAccessException e2) {
                                            throw new C022109x("get_mInfo", e2);
                                        }
                                        z = false;
                                    }
                                }
                            } catch (Exception e3) {
                                throw new C022109x("get_callbacks", e3);
                            }
                        } else {
                            num = AnonymousClass065.A0C;
                        }
                        if (num != null) {
                            break;
                        }
                    } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException e4) {
                        throw new C022109x("init_reflection", e4);
                    }
                }
                if (declaredField3 == null) {
                    try {
                        declaredField3 = Message.class.getDeclaredField("next");
                        declaredField3.setAccessible(true);
                    } catch (NoSuchFieldException e5) {
                        throw new C022109x("get_next_field", e5);
                    }
                }
                try {
                    message = (Message) declaredField3.get(message);
                } catch (IllegalAccessException e6) {
                    throw new C022109x("get_next", e6);
                }
            }
            this.A00 = num;
            return num;
        } catch (Exception e7) {
            throw new C022109x("get_ui_message", e7);
        }
    }
}
