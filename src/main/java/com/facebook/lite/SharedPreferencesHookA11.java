package com.facebook.lite;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class SharedPreferencesHookA11 {
    public static final String CLASS_NAME = "android.app.QueuedWork";
    public static final long DELAY = 100;
    public static final int MSG_RUN = 1;
    public static final String TAG = "SharedPrefsHookA11";
    public static boolean mEnableQueuedPendingWorkHandlerHook;
    public static Class mNonBlocingProcessPendingWorkHandlerClass;
    public static Handler nonBlockingHandler;
    public static Boolean sExtractedSuccessfully;
    public static Field sFinishersField;
    public static Field sHandlerField;
    public static Object sLock;
    public static Field sWorkField;
    public static final Object nonBlockingWorksLock = new Object();
    public static LinkedList nonBlockingWorks = new LinkedList();
    public static final ProxyLinkedList sWorkProxyList = new ProxyLinkedList(false);
    public static final ProxyLinkedList sFinishersProxyList = new ProxyLinkedList(true);

    public class NonBlockingProcessPendingWorkHandler extends Handler {
        private void processPendingWork() {
            LinkedList linkedList;
            if (SharedPreferencesHookA11.nonBlockingHandler != null) {
                synchronized (SharedPreferencesHookA11.nonBlockingWorksLock) {
                    SharedPreferencesHookA11.nonBlockingHandler.removeMessages(1);
                    linkedList = SharedPreferencesHookA11.nonBlockingWorks;
                    SharedPreferencesHookA11.nonBlockingWorks = new LinkedList();
                }
                if (linkedList.isEmpty()) {
                    return;
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                processPendingWork();
            }
        }

        public NonBlockingProcessPendingWorkHandler(Looper looper) {
            super(looper);
        }
    }

    public class ProxyLinkedList extends LinkedList<Runnable> {
        public final boolean mShouldDropMessages;

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
        public boolean add(Runnable runnable) {
            if (this.mShouldDropMessages || SharedPreferencesHookA11.nonBlockingHandler == null) {
                return true;
            }
            synchronized (SharedPreferencesHookA11.nonBlockingWorksLock) {
                SharedPreferencesHookA11.nonBlockingWorks.add(runnable);
                SharedPreferencesHookA11.nonBlockingHandler.sendEmptyMessageDelayed(1, 100L);
            }
            return true;
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public boolean remove(Object obj) {
            boolean zRemove;
            if (this.mShouldDropMessages || SharedPreferencesHookA11.nonBlockingHandler == null) {
                return true;
            }
            synchronized (SharedPreferencesHookA11.nonBlockingWorksLock) {
                zRemove = SharedPreferencesHookA11.nonBlockingWorks.remove(obj);
            }
            return zRemove;
        }

        public ProxyLinkedList(boolean z) {
            this.mShouldDropMessages = z;
        }
    }

    public class QueuedWorkFix implements Handler.Callback {
        public static final int EXECUTE_TRANSACTION = 159;
        public static final int SERVICE_ARGS = 115;
        public static final int STOP_SERVICE = 116;
        public final boolean mIsActivityManager;
        public Handler.Callback sOriginalActivityManagerCallback;
        public Handler sOriginalActivityManagerHandler;
        public Handler.Callback sOriginalQueuedPendingWorkCallback;
        public Handler sOriginalQueuedPendingWorkHandler;

        public QueuedWorkFix(boolean z) {
            this.mIsActivityManager = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void installHandlerCallback() {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object objInvoke = cls.getDeclaredMethod("currentActivityThread", null).invoke(null, null);
                Field declaredField = cls.getDeclaredField("mH");
                declaredField.setAccessible(true);
                Handler handler = (Handler) declaredField.get(objInvoke);
                this.sOriginalActivityManagerHandler = handler;
                Field declaredField2 = Handler.class.getDeclaredField("mCallback");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(handler);
                if (obj != null) {
                    this.sOriginalActivityManagerCallback = (Handler.Callback) obj;
                }
                declaredField2.set(handler, this);
            } catch (Throwable th) {
                Log.e(SharedPreferencesHookA11.TAG, "error while installing handler callback", th);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
        @Override // android.os.Handler.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                boolean r0 = r5.mIsActivityManager
                if (r0 == 0) goto L29
                android.os.Handler r4 = r5.sOriginalActivityManagerHandler
                android.os.Handler$Callback r0 = r5.sOriginalActivityManagerCallback
            L8:
                r3 = 0
                r2 = 1
                if (r0 == 0) goto L13
                boolean r1 = r0.handleMessage(r6)
                r0 = 1
                if (r1 != 0) goto L14
            L13:
                r0 = 0
            L14:
                if (r4 == 0) goto L3c
                if (r0 != 0) goto L3c
                int r1 = r6.what
                if (r1 == r2) goto L2e
                r0 = 159(0x9f, float:2.23E-43)
                if (r1 == r0) goto L2e
                r0 = 115(0x73, float:1.61E-43)
                if (r1 == r0) goto L2e
                r0 = 116(0x74, float:1.63E-43)
                if (r1 == r0) goto L2e
                return r3
            L29:
                android.os.Handler r4 = r5.sOriginalQueuedPendingWorkHandler
                android.os.Handler$Callback r0 = r5.sOriginalQueuedPendingWorkCallback
                goto L8
            L2e:
                com.facebook.lite.SharedPreferencesHookA11 r0 = com.facebook.lite.SharedPreferencesHookA11.this
                r0.replaceWorkersAndFinishers()
                r4.handleMessage(r6)
                com.facebook.lite.SharedPreferencesHookA11 r0 = com.facebook.lite.SharedPreferencesHookA11.this
                r0.replaceWorkersAndFinishers()
                return r2
            L3c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.lite.SharedPreferencesHookA11.QueuedWorkFix.handleMessage(android.os.Message):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void installQueuedPendingWorkHandlerFix() {
            Handler queuedWorkHandler = SharedPreferencesHookA11.getQueuedWorkHandler();
            this.sOriginalQueuedPendingWorkHandler = queuedWorkHandler;
            if (queuedWorkHandler != null) {
                try {
                    Field declaredField = Handler.class.getDeclaredField("mCallback");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.sOriginalQueuedPendingWorkHandler);
                    if (obj != null) {
                        this.sOriginalQueuedPendingWorkCallback = (Handler.Callback) obj;
                    }
                    declaredField.set(this.sOriginalQueuedPendingWorkHandler, this);
                } catch (Throwable th) {
                    Log.e(SharedPreferencesHookA11.TAG, "Failed to install fix on queued-pending-work handler", th);
                }
            }
        }
    }

    public static Handler getQueuedWorkHandler() {
        try {
            return (Handler) sHandlerField.get(null);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public static boolean extractFields() {
        Boolean bool = sExtractedSuccessfully;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Class<?> cls = Class.forName(CLASS_NAME);
            Field declaredField = cls.getDeclaredField("sLock");
            boolean z = true;
            declaredField.setAccessible(true);
            sLock = declaredField.get(null);
            Field declaredField2 = cls.getDeclaredField("sWork");
            sWorkField = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("sFinishers");
            sFinishersField = declaredField3;
            declaredField3.setAccessible(true);
            Field declaredField4 = cls.getDeclaredField("sHandler");
            sHandlerField = declaredField4;
            declaredField4.setAccessible(true);
            Handler queuedWorkHandler = getQueuedWorkHandler();
            if (queuedWorkHandler == null) {
                Method declaredMethod = cls.getDeclaredMethod("getHandler", null);
                declaredMethod.setAccessible(true);
                queuedWorkHandler = (Handler) declaredMethod.invoke(null, null);
            }
            if (sLock == null || queuedWorkHandler == null) {
                z = false;
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            sExtractedSuccessfully = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Throwable unused) {
            sExtractedSuccessfully = false;
            return false;
        }
    }

    public void replaceWorkersAndFinishers() {
        LinkedList linkedList;
        if (nonBlockingHandler != null) {
            try {
                Object obj = sLock;
                obj.getClass();
                synchronized (obj) {
                    try {
                        linkedList = (LinkedList) sWorkField.get(null);
                        sWorkField.set(null, sWorkProxyList);
                        sFinishersField.set(null, sFinishersProxyList);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (linkedList != null) {
                    synchronized (nonBlockingWorksLock) {
                        try {
                            nonBlockingWorks.addAll(linkedList);
                            nonBlockingHandler.sendEmptyMessageDelayed(1, 100L);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public SharedPreferencesHookA11(Class cls, boolean z) {
        mNonBlocingProcessPendingWorkHandlerClass = cls;
        mEnableQueuedPendingWorkHandlerHook = z;
    }

    public static void initNonBlockingHandler() {
        Handler queuedWorkHandler = getQueuedWorkHandler();
        if (queuedWorkHandler == null) {
            Log.e(TAG, "sHandler is null");
            return;
        }
        try {
            nonBlockingHandler = (Handler) mNonBlocingProcessPendingWorkHandlerClass.getDeclaredConstructor(Looper.class).newInstance(queuedWorkHandler.getLooper());
        } catch (Throwable th) {
            Log.e(TAG, "error while initializing handler", th);
        }
    }

    public void init() {
        if (extractFields()) {
            initNonBlockingHandler();
            replaceWorkersAndFinishers();
            if (Build.VERSION.SDK_INT >= 31) {
                if (mEnableQueuedPendingWorkHandlerHook) {
                    new QueuedWorkFix(false).installQueuedPendingWorkHandlerFix();
                }
                new QueuedWorkFix(true).installHandlerCallback();
            }
        }
    }
}
