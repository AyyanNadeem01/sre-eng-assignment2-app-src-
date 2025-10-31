package X;

import com.facebook.errorreporting.field.ReportFieldBase;

/* renamed from: X.08y, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC020108y extends ReportFieldBase {
    public final int maxLength;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC020108y(int i, String str, boolean z, int i2) {
        super(i, str, z);
        C06E.A07(str, 2);
        this.maxLength = i2;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }
}
