package X;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* renamed from: X.088, reason: invalid class name */
/* loaded from: classes.dex */
public final class AnonymousClass088 extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ C05W A00;

    public AnonymousClass088(C05W c05w) {
        this.A00 = c05w;
    }

    private void A00(Network network) {
        if (network != null) {
            C05W c05w = this.A00;
            if (!network.equals(c05w.A03)) {
                ConnectivityManager connectivityManager = c05w.A00;
                c05w.A05 = connectivityManager.isActiveNetworkMetered();
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                c05w.A04 = activeNetworkInfo == null ? null : new C05S(activeNetworkInfo);
            }
        }
        this.A00.A03 = network;
    }

    public final /* synthetic */ void A01() {
        A00(this.A00.A00.getActiveNetwork());
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        if (this.A00.A03 == null) {
            A00(network);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        this.A00.A02.put(network, networkCapabilities);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        C05W c05w = this.A00;
        c05w.A02.remove(network);
        if (network.equals(c05w.A03)) {
            c05w.A01.postAtTime(new Runnable() { // from class: X.08J
                public static final String __redex_internal_original_name = "LiteNetworkMonitor$Callback$$ExternalSyntheticLambda0";

                @Override // java.lang.Runnable
                public final void run() {
                    this.A00.A01();
                }
            }, 100L);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        C05W c05w = this.A00;
        c05w.A03 = null;
        c05w.A04 = null;
        c05w.A02.clear();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        A00(network);
    }
}
