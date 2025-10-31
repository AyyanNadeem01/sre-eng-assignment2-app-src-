package com.facebook.common.stringformat;

import X.AnonymousClass000;
import java.util.Formatter;
import java.util.MissingFormatArgumentException;
import java.util.UnknownFormatConversionException;

/* loaded from: classes.dex */
public class StringFormatUtil {
    public static final int APPENDED_TO_OUTPUT = -3;
    public static final int FALLBACK_TO_SYSTEM = -1;
    public static final int INVALID_FORMAT_PERCENT = -101;
    public static final int NEXT_SEG_RESULT_FINISHED = -200;
    public static final int NEXT_SEG_RESULT_FINISHED_PERCENT = -201;
    public static final int NO_FORMATTING_REQUIRED = -2;
    public static final String NULL_STRING = "null";
    public static final Object[] SINGLE_ITEM_NULL_OBJECT_ARRAY = {null};
    public static final int VALID_FORMAT_PERCENT = -100;

    public static void appendFormatStrLocaleSafe(StringBuilder sb, String str, Object... objArr) {
        int iDoFormatArray = doFormatArray(null, str, objArr);
        if (iDoFormatArray == -1) {
            new Formatter(sb).format(null, str, objArr);
        } else if (iDoFormatArray == -2) {
            sb.append(str);
        } else {
            sb.ensureCapacity(iDoFormatArray);
            doFormatArray(sb, str, objArr);
        }
    }

    public static int doDryRun(String str, Object obj) {
        return doFormatArgs(null, str, 1, obj, null, null, null);
    }

    public static String doFallbackToSystem(String str, Object... objArr) {
        try {
            return String.format(null, str, objArr);
        } catch (MissingFormatArgumentException | UnknownFormatConversionException e) {
            StringBuilder sbA09 = AnonymousClass000.A09();
            sbA09.append(e.getMessage());
            throw new RuntimeException(AnonymousClass000.A06(": ", str, sbA09));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        return -3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0041, code lost:
    
        return processRemainingString(r12, r13, r7, r1, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int doFormatArgs(java.lang.StringBuilder r12, java.lang.String r13, int r14, java.lang.Object r15, java.lang.Object r16, java.lang.Object r17, java.lang.Object r18) {
        /*
            r4 = 0
            r5 = r12
            if (r12 != 0) goto L5
            r4 = 1
        L5:
            r3 = -1
            r2 = 0
            if (r14 != 0) goto La
            r2 = -1
        La:
            r12 = r2
            r7 = 0
            r1 = 0
        Ld:
            r6 = r13
            if (r12 >= r14) goto L3d
            r8 = r15
            r9 = r16
            r10 = r17
            r11 = r18
            int r0 = appendSegmentFormatArgs(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r0 == r3) goto L2e
            if (r4 == 0) goto L20
            int r1 = r1 + r0
        L20:
            int r7 = getNextFormatSegmentIndex(r13, r7)
            r0 = -200(0xffffffffffffff38, float:NaN)
            if (r12 != r2) goto L2f
            if (r7 != r0) goto L2f
            r3 = -2
            if (r4 != 0) goto L2e
        L2d:
            r3 = -3
        L2e:
            return r3
        L2f:
            if (r7 >= 0) goto L3a
            if (r7 == r0) goto L37
            r0 = -201(0xffffffffffffff37, float:NaN)
            if (r7 != r0) goto L3d
        L37:
            if (r4 == 0) goto L2d
            return r1
        L3a:
            int r12 = r12 + 1
            goto Ld
        L3d:
            int r3 = processRemainingString(r5, r13, r7, r1, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.stringformat.StringFormatUtil.doFormatArgs(java.lang.StringBuilder, java.lang.String, int, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):int");
    }

    public static int doFormatArray(StringBuilder sb, String str, Object... objArr) {
        boolean z;
        boolean z2 = true;
        int i = 0;
        boolean z3 = sb == null;
        if (objArr == null || objArr.length == 0) {
            objArr = SINGLE_ITEM_NULL_OBJECT_ARRAY;
            z = true;
        } else {
            z = false;
        }
        int length = objArr.length;
        int nextFormatSegmentIndex = 0;
        int i2 = 0;
        boolean z4 = false;
        while (i < length) {
            int iAppendSegmentFormat = appendSegmentFormat(sb, str, nextFormatSegmentIndex, objArr[i], !z);
            if (iAppendSegmentFormat == -1) {
                return -1;
            }
            if (z3) {
                i2 += iAppendSegmentFormat;
            }
            nextFormatSegmentIndex = getNextFormatSegmentIndex(str, nextFormatSegmentIndex);
            if (nextFormatSegmentIndex == -200) {
                break;
            }
            if (nextFormatSegmentIndex == -201) {
                break;
            }
            i++;
            z4 = true;
        }
        z2 = z4;
        if (z3 && !z2) {
            return -2;
        }
        if (nextFormatSegmentIndex != -200 && nextFormatSegmentIndex != -201) {
            return processRemainingString(sb, str, nextFormatSegmentIndex, i2, z3);
        }
        if (z3) {
            return i2;
        }
        return -3;
    }

    public static String fallbackToSystem(String str, int i, Object obj, Object obj2, Object obj3, Object obj4, Object[] objArr) {
        if (i == 0) {
            objArr = new Object[0];
        } else if (i == 1) {
            objArr = new Object[]{obj};
        } else if (i == 2) {
            objArr = new Object[]{obj, obj2};
        } else if (i == 3) {
            objArr = new Object[]{obj, obj2, obj3};
        } else if (i == 4) {
            objArr = new Object[]{obj, obj2, obj3, obj4};
        }
        return doFallbackToSystem(str, objArr);
    }

    public static String formatStrLocaleSafe(String str, Object obj) {
        return formatStrLocaleSafeInner(str, 1, obj, null, null, null, null);
    }

    public static int appendIntTypeArg(StringBuilder sb, Object obj) {
        if (obj == null) {
            if (sb == null) {
                return 4;
            }
            sb.append(NULL_STRING);
            return -3;
        }
        if (obj instanceof Integer) {
            if (sb == null) {
                return 11;
            }
        } else if (obj instanceof Short) {
            if (sb == null) {
                return 6;
            }
        } else {
            if (!(obj instanceof Byte)) {
                if (!(obj instanceof Long)) {
                    if (sb == null) {
                        return -1;
                    }
                    throw new AssertionError();
                }
                if (sb == null) {
                    return 20;
                }
                sb.append(((Number) obj).longValue());
                return -3;
            }
            if (sb == null) {
                return 4;
            }
        }
        sb.append(((Number) obj).intValue());
        return -3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int appendStringTypeArg(java.lang.StringBuilder r1, java.lang.Object r2) {
        /*
            boolean r0 = r2 instanceof java.util.Formattable
            if (r0 == 0) goto Le
            if (r1 != 0) goto L8
            r0 = -1
            return r0
        L8:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        Le:
            boolean r0 = r2 instanceof java.lang.String
            if (r0 == 0) goto L1f
            java.lang.String r2 = (java.lang.String) r2
        L14:
            if (r2 != 0) goto L18
        L16:
            java.lang.String r2 = "null"
        L18:
            if (r1 != 0) goto L26
            int r0 = r2.length()
            return r0
        L1f:
            if (r2 == 0) goto L16
            java.lang.String r2 = r2.toString()
            goto L14
        L26:
            r1.append(r2)
            r0 = -3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.stringformat.StringFormatUtil.appendStringTypeArg(java.lang.StringBuilder, java.lang.Object):int");
    }

    public static int doDryRunInternal(String str, int i, Object obj, Object obj2, Object obj3, Object obj4, Object[] objArr) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? doFormatArray(null, str, objArr) : doDryRun(str, obj, obj2, obj3, obj4) : doDryRun(str, obj, obj2, obj3) : doDryRun(str, obj, obj2) : doDryRun(str, obj) : doDryRun(str);
    }

    public static String formatBytes(long j) {
        Float fValueOf;
        String str;
        float f = 1024.0f * 1024.0f;
        float f2 = f * 1024.0f;
        float f3 = j;
        if (f3 < 1024.0f) {
            StringBuilder sbA09 = AnonymousClass000.A09();
            sbA09.append(j);
            return AnonymousClass000.A07("B", sbA09);
        }
        if (f3 < f) {
            fValueOf = Float.valueOf(f3 / 1024.0f);
            str = "%.2fKB";
        } else if (f3 < f2) {
            fValueOf = Float.valueOf(f3 / f);
            str = "%.2fMB";
        } else {
            fValueOf = Float.valueOf(f3 / f2);
            str = "%.2fGB";
        }
        return formatStrLocaleSafe(str, fValueOf);
    }

    public static int validateFormatPercent(String str, int i) {
        int i2 = i + 1;
        if (str.length() <= i2) {
            return INVALID_FORMAT_PERCENT;
        }
        char cCharAt = str.charAt(i2);
        if (cCharAt == 's' || cCharAt == 'd' || cCharAt == '%') {
            return -100;
        }
        return INVALID_FORMAT_PERCENT;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int appendSegmentFormat(java.lang.StringBuilder r6, java.lang.String r7, int r8, java.lang.Object r9, boolean r10) {
        /*
            int r4 = r7.length()
            r5 = 0
        L5:
            if (r8 >= r4) goto L48
            char r0 = r7.charAt(r8)
            r3 = 37
            if (r0 != r3) goto L4c
            int r1 = validateFormatPercent(r7, r8)
            r0 = -100
            r2 = -1
            if (r1 != r0) goto L22
            int r0 = r8 + 1
            char r1 = r7.charAt(r0)
            if (r10 != 0) goto L23
            if (r1 == r3) goto L3a
        L22:
            return r2
        L23:
            r0 = 115(0x73, float:1.61E-43)
            if (r1 != r0) goto L2f
            int r1 = appendStringTypeArg(r6, r9)
        L2b:
            r0 = 1
            if (r1 != r2) goto L43
            return r2
        L2f:
            r0 = 100
            if (r1 != r0) goto L38
            int r1 = appendIntTypeArg(r6, r9)
            goto L2b
        L38:
            if (r1 != r3) goto L22
        L3a:
            if (r6 == 0) goto L3f
            r6.append(r3)
        L3f:
            int r8 = r8 + 1
            r1 = 1
            r0 = 0
        L43:
            if (r6 != 0) goto L46
            int r5 = r5 + r1
        L46:
            if (r0 == 0) goto L50
        L48:
            if (r6 == 0) goto L4b
            r5 = -3
        L4b:
            return r5
        L4c:
            if (r6 != 0) goto L53
            int r5 = r5 + 1
        L50:
            int r8 = r8 + 1
            goto L5
        L53:
            r6.append(r0)
            goto L50
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.stringformat.StringFormatUtil.appendSegmentFormat(java.lang.StringBuilder, java.lang.String, int, java.lang.Object, boolean):int");
    }

    public static String formatStrLocaleSafeInner(String str, int i, Object obj, Object obj2, Object obj3, Object obj4, Object[] objArr) {
        int iDoDryRunInternal = doDryRunInternal(str, i, obj, obj2, obj3, obj4, objArr);
        if (iDoDryRunInternal == -1) {
            return fallbackToSystem(str, i, obj, obj2, obj3, obj4, objArr);
        }
        if (iDoDryRunInternal == -2) {
            return str;
        }
        StringBuilder sb = new StringBuilder(iDoDryRunInternal);
        if (i == -1) {
            doFormatArray(sb, str, objArr);
        } else {
            doFormatArgs(sb, str, i, obj, obj2, obj3, obj4);
        }
        return sb.toString();
    }

    public static int getNextFormatSegmentIndex(String str, int i) {
        int length = str.length();
        boolean z = false;
        while (i < length) {
            if (str.charAt(i) == '%' && validateFormatPercent(str, i) == -100) {
                if (str.charAt(i + 1) != '%') {
                    return i + 2;
                }
                i++;
                z = true;
            }
            i++;
        }
        return z ? NEXT_SEG_RESULT_FINISHED_PERCENT : NEXT_SEG_RESULT_FINISHED;
    }

    public static int processRemainingString(StringBuilder sb, String str, int i, int i2, boolean z) {
        int length = str.length();
        int i3 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '%') {
                if (length <= i + 1 || str.charAt(i + 1) != '%') {
                    if (z) {
                        return -1;
                    }
                    throw new AssertionError();
                }
                i++;
            }
            if (sb == null) {
                i3++;
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        if (z) {
            return i2 + i3;
        }
        return -3;
    }

    public static int appendSegmentFormatArgs(StringBuilder sb, String str, int i, Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        if (i2 == -1) {
            return appendSegmentFormat(sb, str, i, null, false);
        }
        if (i2 == 0) {
            return appendSegmentFormat(sb, str, i, obj, true);
        }
        if (i2 == 1) {
            return appendSegmentFormat(sb, str, i, obj2, true);
        }
        if (i2 == 2) {
            return appendSegmentFormat(sb, str, i, obj3, true);
        }
        if (i2 == 3) {
            return appendSegmentFormat(sb, str, i, obj4, true);
        }
        throw new AssertionError();
    }

    public static int doDryRun(String str) {
        return doFormatArgs(null, str, 0, null, null, null, null);
    }

    public static String formatStrLocaleSafe(String str) {
        return formatStrLocaleSafeInner(str, 0, null, null, null, null, null);
    }

    public static int doDryRun(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return doFormatArgs(null, str, 4, obj, obj2, obj3, obj4);
    }

    public static String formatStrLocaleSafe(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return formatStrLocaleSafeInner(str, 4, obj, obj2, obj3, obj4, null);
    }

    public static int doDryRun(String str, Object obj, Object obj2, Object obj3) {
        return doFormatArgs(null, str, 3, obj, obj2, obj3, null);
    }

    public static String formatStrLocaleSafe(String str, Object obj, Object obj2, Object obj3) {
        return formatStrLocaleSafeInner(str, 3, obj, obj2, obj3, null, null);
    }

    public static int doDryRun(String str, Object obj, Object obj2) {
        return doFormatArgs(null, str, 2, obj, obj2, null, null);
    }

    public static String formatStrLocaleSafe(String str, Object obj, Object obj2) {
        return formatStrLocaleSafeInner(str, 2, obj, obj2, null, null, null);
    }

    public static int doDryRun(String str, Object[] objArr) {
        return doFormatArray(null, str, objArr);
    }

    public static String formatStrLocaleSafe(String str, Object... objArr) {
        return formatStrLocaleSafeInner(str, -1, null, null, null, null, objArr);
    }
}
