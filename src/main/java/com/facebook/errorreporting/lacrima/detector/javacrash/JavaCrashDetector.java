package com.facebook.errorreporting.lacrima.detector.javacrash;

import X.AnonymousClass046;
import X.AnonymousClass089;
import X.C021609s;
import X.C04w;
import X.C0C5;
import X.C0CK;
import X.EnumC011204x;
import X.InterfaceC009404d;
import X.InterfaceC02430Ba;
import X.InterfaceC02510Bm;
import com.facebook.errorreporting.lacrima.detector.javacrash.JavaCrashDetector;
import java.lang.Thread;

/* loaded from: classes.dex */
public class JavaCrashDetector implements InterfaceC02430Ba {
    public static final InterfaceC02510Bm A05 = new InterfaceC02510Bm() { // from class: X.0Bn
        @Override // X.InterfaceC02510Bm
        public final boolean A1q(Throwable th) {
            return true;
        }
    };
    public C021609s A00;
    public InterfaceC02510Bm A01;
    public final C04w A02;
    public final InterfaceC02510Bm A03;
    public final C0CK A04;
    public byte[] mOomReservation;

    /* JADX WARN: Removed duplicated region for block: B:107:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A00(java.lang.Thread r9, java.lang.Throwable r10) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.errorreporting.lacrima.detector.javacrash.JavaCrashDetector.A00(java.lang.Thread, java.lang.Throwable):void");
    }

    public JavaCrashDetector(C04w c04w, C021609s c021609s, InterfaceC02510Bm interfaceC02510Bm, InterfaceC02510Bm interfaceC02510Bm2, C0CK c0ck) {
        this.A04 = c0ck;
        this.A02 = c04w;
        this.A00 = c021609s;
        this.A01 = interfaceC02510Bm;
        this.A03 = interfaceC02510Bm2;
    }

    @Override // X.InterfaceC02430Ba
    public final void start() {
        C0C5.A00();
        if (AnonymousClass089.A01() != null) {
            AnonymousClass089.A03(new InterfaceC009404d() { // from class: X.04e
                @Override // X.InterfaceC009404d
                public final void ALl(Thread thread, Throwable th) {
                    JavaCrashDetector javaCrashDetector = this.A00;
                    if (javaCrashDetector.A01.A1q(th)) {
                        javaCrashDetector.A00(thread, th);
                    }
                }
            }, 100);
        } else {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: X.0Bo
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th) {
                    JavaCrashDetector javaCrashDetector = this.A00;
                    if (javaCrashDetector.A01.A1q(th)) {
                        javaCrashDetector.A00(thread, th);
                    }
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = defaultUncaughtExceptionHandler;
                    if (uncaughtExceptionHandler != null) {
                        uncaughtExceptionHandler.uncaughtException(thread, th);
                    }
                }
            });
        }
        this.mOomReservation = new byte[65536];
    }

    @Override // X.InterfaceC02430Ba
    public final /* synthetic */ AnonymousClass046 AFf() {
        return null;
    }

    @Override // X.InterfaceC02430Ba
    public final EnumC011204x AGX() {
        return EnumC011204x.JAVA;
    }
}
