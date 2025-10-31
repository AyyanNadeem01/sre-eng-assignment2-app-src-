package X;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: X.03E, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class C03E {
    public static String A00(Map map) {
        String str = (String) map.get("fb.test_name");
        String str2 = (String) map.get("fb.test_execution_uuid");
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{\"test_name\":\"");
        sb.append(str);
        sb.append("\",\"test_execution_uuid\":\"");
        sb.append(str2);
        sb.append("\"}");
        return sb.toString();
    }

    public static HashMap A01() {
        HashMap map = new HashMap();
        String strA02 = C07O.A02("ig.ig_server_rev_hash");
        if (TextUtils.isEmpty(strA02)) {
            strA02 = System.getProperty("ig.ig_server_rev_hash");
        }
        if (!TextUtils.isEmpty(strA02)) {
            map.put("ig.ig_server_rev_hash", strA02);
        }
        String strA022 = C07O.A02("fb.report_source");
        if (TextUtils.isEmpty(strA022)) {
            strA022 = System.getProperty("fb.report_source");
        }
        if (!TextUtils.isEmpty(strA022)) {
            map.put("fb.report_source", strA022);
            String strA023 = C07O.A02("fb.testing.build_target");
            if (TextUtils.isEmpty(strA023)) {
                strA023 = System.getProperty("fb.testing.build_target");
            }
            if (!TextUtils.isEmpty(strA023)) {
                map.put("fb.testing.build_target", strA023);
            }
            String strA024 = C07O.A02("fb.test_name");
            if (TextUtils.isEmpty(strA024)) {
                strA024 = System.getProperty("fb.test_name");
            }
            if (!TextUtils.isEmpty(strA024)) {
                map.put("fb.test_name", strA024);
            }
            String strA025 = C07O.A02("fb.test_execution_uuid");
            if (TextUtils.isEmpty(strA025)) {
                strA025 = System.getProperty("fb.test_execution_uuid");
            }
            if (!TextUtils.isEmpty(strA025)) {
                map.put("fb.test_execution_uuid", strA025);
            }
        }
        return map;
    }
}
