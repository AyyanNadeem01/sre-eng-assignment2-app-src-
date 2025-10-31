package X;

import android.content.Context;
import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: X.05p, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C012705p {
    public final Map A00;
    public final Set A01;
    public final Set A02 = new HashSet();

    public final boolean A02(C008703w c008703w, boolean z) {
        if (c008703w != null && c008703w.A05() != null) {
            C000800l c000800lA05 = c008703w.A05();
            Iterator it = this.A01.iterator();
            while (it.hasNext()) {
                if (A01(c000800lA05, (C000800l) it.next(), z)) {
                    return true;
                }
            }
            Map map = this.A00;
            for (C000800l c000800l : map.keySet()) {
                if (A01(c000800lA05, c000800l, z)) {
                    Iterator it2 = c008703w.A03.iterator();
                    while (it2.hasNext()) {
                        if (((Set) map.get(c000800l)).contains(it2.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        boolean zEquals;
        boolean zEquals2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C012705p)) {
            return false;
        }
        C012705p c012705p = (C012705p) obj;
        Set set = c012705p.A01;
        Set set2 = this.A01;
        if (set != null) {
            zEquals = set.equals(set2);
        } else {
            zEquals = false;
            if (set2 == null) {
                zEquals = true;
            }
        }
        Map map = c012705p.A00;
        Map map2 = this.A00;
        if (map != null) {
            zEquals2 = map.equals(map2);
        } else {
            zEquals2 = false;
            if (map2 == null) {
                zEquals2 = true;
            }
        }
        return zEquals && zEquals2;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.A01, this.A00});
    }

    public C012705p(Map map) {
        HashSet hashSet = new HashSet();
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Set set = (Set) entry.getValue();
            if (set == null || !set.contains("*|all_packages|*")) {
                if (!map2.containsKey(key)) {
                    map2.put(key, new HashSet());
                }
                ((Set) map2.get(key)).addAll(set);
            } else {
                hashSet.add(key);
            }
        }
        this.A01 = Collections.unmodifiableSet(hashSet);
        this.A00 = Collections.unmodifiableMap(map2);
    }

    public static String A00(Context context, Uri uri, C012705p c012705p) {
        String authority = uri.getAuthority();
        if (authority == null) {
            return null;
        }
        try {
            C008703w c008703wA02 = C008703w.A02(context, authority);
            if (c012705p.A02(c008703wA02, C04M.A03(context))) {
                return authority;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The provider for uri '");
            sb.append(authority);
            sb.append("' is not trusted: ");
            sb.append(c008703wA02);
            throw new SecurityException(sb.toString());
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean A01(C000800l c000800l, C000800l c000800l2, boolean z) {
        if (!c000800l.equals(c000800l2)) {
            if (!z) {
                return false;
            }
            Set set = AbstractC011805d.A0e;
            C06E.A07(c000800l2, 0);
            Set set2 = (Set) AbstractC011805d.A0d.get(c000800l2);
            if (set2 == null) {
                set2 = AbstractC011805d.A0e;
            }
            if (!set2.contains(c000800l)) {
                return false;
            }
        }
        return true;
    }
}
