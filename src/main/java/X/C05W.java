package X;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: X.05W, reason: invalid class name */
/* loaded from: classes.dex */
public final class C05W {
    public static C05W A06;
    public final ConnectivityManager A00;
    public final Handler A01;
    public final Map A02;
    public volatile Network A03;
    public volatile C05S A04;
    public volatile boolean A05;

    public static synchronized C05W A00(Context context) {
        if (A06 == null && Build.VERSION.SDK_INT >= 26) {
            C015606v.A01();
            if (C015606v.A04(context, 72)) {
                A06 = new C05W(context);
            }
        }
        return A06;
    }

    public final boolean A02() {
        return this.A03 != null && this.A05;
    }

    public final boolean A03() {
        return this.A03 != null;
    }

    public final boolean A04() {
        if (this.A03 == null) {
            return false;
        }
        Map map = this.A02;
        return map.containsKey(this.A03) && ((NetworkCapabilities) map.get(this.A03)).hasTransport(1);
    }

    public C05W(Context context) {
        HandlerThread handlerThread = new HandlerThread("network_monitor_thread", -3);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        looper.getClass();
        Handler handler = new Handler(looper);
        this.A01 = handler;
        this.A02 = new ConcurrentHashMap();
        this.A05 = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        connectivityManager.getClass();
        this.A00 = connectivityManager;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).addTransportType(0).addTransportType(1).build(), new AnonymousClass088(this), handler);
    }

    public final C05S A01() {
        return this.A04;
    }
}
