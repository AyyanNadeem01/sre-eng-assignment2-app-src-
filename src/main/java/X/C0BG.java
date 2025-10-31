package X;

import android.content.Context;
import android.os.StrictMode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: X.0BG */
/* loaded from: classes.dex */
public final class C0BG {
    public static boolean A00 = true;
    public static int A01;
    public static int A02;
    public static Context A03;
    public static C0A0 A04;
    public static InterfaceC02480Bj A05;
    public static C02340Ar A06;
    public static String A07;
    public static volatile C0AD[] A0E;
    public static final ReentrantReadWriteLock A0A = new ReentrantReadWriteLock();
    public static final AtomicInteger A09 = new AtomicInteger(0);
    public static final Set A08 = Collections.newSetFromMap(new ConcurrentHashMap());
    public static final Map A0C = AnonymousClass000.A0C();
    public static final Set A0D = Collections.newSetFromMap(new ConcurrentHashMap());
    public static final Map A0B = AnonymousClass000.A0C();

    /* JADX WARN: Code restructure failed: missing block: B:239:0x0178, code lost:
    
        if (0 < r0.length) goto L192;
     */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0B(java.lang.String r14, int r15) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C0BG.A0B(java.lang.String, int):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int A00() {
        ReentrantReadWriteLock reentrantReadWriteLock = A0A;
        reentrantReadWriteLock.writeLock().lock();
        try {
            int i = A02;
            boolean zA0O = AnonymousClass000.A0O(i & 2);
            boolean z = zA0O;
            if ((i & 256) != 0) {
                z = (zA0O ? 1 : 0) | 4;
            }
            int i2 = z;
            if ((i & 128) == 0) {
                i2 = (z ? 1 : 0) | 8;
            }
            return i2;
        } finally {
            AnonymousClass000.A0M(reentrantReadWriteLock);
        }
    }

    public static String A02(String str) {
        ReentrantReadWriteLock reentrantReadWriteLock = A0A;
        reentrantReadWriteLock.readLock().lock();
        try {
            String strA06 = null;
            if (A0E != null) {
                int i = 0;
                while (strA06 == null) {
                    if (i >= A0E.length) {
                        break;
                    }
                    strA06 = A0E[i].A06(str);
                    i++;
                }
            }
            return strA06;
        } finally {
            A07(reentrantReadWriteLock);
        }
    }

    public static void A05(StrictMode.ThreadPolicy threadPolicy, String str, int i) {
        AtomicReference atomicReference = AbstractC012805q.A00;
        InterfaceC012905r[] interfaceC012905rArrA0P = AnonymousClass000.A0P(atomicReference);
        if (interfaceC012905rArrA0P == null || 0 >= interfaceC012905rArrA0P.length) {
            try {
                A09(threadPolicy, str, null, null, i | 1);
                InterfaceC012905r[] interfaceC012905rArrA0P2 = AnonymousClass000.A0P(atomicReference);
                if (interfaceC012905rArrA0P2 == null || 0 >= interfaceC012905rArrA0P2.length) {
                    return;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    InterfaceC012905r[] interfaceC012905rArrA0P3 = AnonymousClass000.A0P(atomicReference);
                    if (interfaceC012905rArrA0P3 == null || 0 >= interfaceC012905rArrA0P3.length) {
                        throw th2;
                    }
                }
            }
        } else {
            C06E.A07(str, 0);
        }
        C0BJ.A00();
        throw AnonymousClass062.createAndThrow();
    }

    public static boolean A08() {
        if (A0E != null) {
            return true;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = A0A;
        reentrantReadWriteLock.readLock().lock();
        try {
            return A0E != null;
        } finally {
            A07(reentrantReadWriteLock);
        }
    }

    public static boolean A0A(String str) {
        return A00 ? A0B(str, 0) : C0B2.A00(str);
    }

    public static File A01(String str) {
        File fileA04;
        String strA03 = A03(str);
        if (strA03 != null) {
            str = strA03;
        }
        String strMapLibraryName = System.mapLibraryName(str);
        ReentrantReadWriteLock reentrantReadWriteLock = A0A;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (A0E != null) {
                for (int i = 0; i < A0E.length; i++) {
                    try {
                        fileA04 = A0E[i].A04(strMapLibraryName);
                    } catch (IOException unused) {
                    }
                    if (fileA04 != null) {
                        return fileA04;
                    }
                }
            }
            A07(reentrantReadWriteLock);
            return null;
        } finally {
            A07(reentrantReadWriteLock);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:261:0x01d6 A[Catch: all -> 0x01fd, LOOP:0: B:259:0x01d2->B:261:0x01d6, LOOP_END, TryCatch #6 {all -> 0x01fd, blocks: (B:211:0x00eb, B:213:0x00ef, B:216:0x010b, B:256:0x01ba, B:258:0x01c1, B:259:0x01d2, B:261:0x01d6, B:262:0x01f2, B:257:0x01be, B:255:0x01b2, B:221:0x011d, B:223:0x0124, B:229:0x012f, B:244:0x0183, B:231:0x0138, B:232:0x0150, B:234:0x0158, B:236:0x016e, B:237:0x0171, B:243:0x017c, B:246:0x0185, B:248:0x0198, B:252:0x019e, B:254:0x01a4), top: B:318:0x00eb, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x01f2 A[EDGE_INSN: B:320:0x01f2->B:262:0x01f2 BREAK  A[LOOP:0: B:259:0x01d2->B:261:0x01d6], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1, types: [X.0CI] */
    /* JADX WARN: Type inference failed for: r7v2, types: [X.0CD] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A04(android.content.Context r10, X.C0A0 r11, int r12) {
        /*
            Method dump skipped, instructions count: 623
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C0BG.A04(android.content.Context, X.0A0, int):void");
    }

    public static void A06(ArrayList arrayList) {
        String strA06 = C0B5.A08() ? "/system/lib64:/vendor/lib64" : "/system/lib:/vendor/lib";
        String str = System.getenv("LD_LIBRARY_PATH");
        if (str != null && !str.equals("")) {
            strA06 = AnonymousClass000.A06(":", strA06, AnonymousClass000.A0A(str));
        }
        Iterator it = new HashSet(Arrays.asList(strA06.split(":"))).iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            AbstractC02460Bh.A00("SoLoader");
            arrayList.add(new C0CJ(AnonymousClass000.A03(str2), 2));
        }
    }

    public static void A07(ReentrantReadWriteLock reentrantReadWriteLock) {
        reentrantReadWriteLock.readLock().unlock();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0009 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:543:0x012e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:658:0x02e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:699:0x0379 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:759:0x045a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:792:0x04cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:813:0x0517 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:853:0x05a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:872:0x05e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:881:0x05f6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:899:0x0627 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:906:0x0638 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:911:0x0643 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:916:0x064e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:921:0x0659 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:923:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(java.lang.String r2) {
        /*
            Method dump skipped, instructions count: 3106
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C0BG.A03(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:2533:0x15f6  */
    /* JADX WARN: Removed duplicated region for block: B:2534:0x15f7 A[Catch: UnsatisfiedLinkError -> 0x1610, all -> 0x1631, TryCatch #1 {UnsatisfiedLinkError -> 0x1610, blocks: (B:1421:0x01b5, B:1422:0x01be, B:1423:0x01c1, B:1424:0x01d0, B:1425:0x01d1, B:1427:0x01d9, B:2535:0x1600, B:2534:0x15f7, B:1428:0x01df, B:1430:0x01e7, B:1431:0x01ed, B:1433:0x01f5, B:1434:0x01fb, B:1436:0x0203, B:1437:0x0209, B:1439:0x0211, B:1440:0x0217, B:1442:0x021f, B:1443:0x0225, B:1445:0x022d, B:1446:0x0233, B:1448:0x023b, B:1449:0x0241, B:1451:0x0249, B:1452:0x024f, B:1454:0x0257, B:1455:0x025d, B:1457:0x0265, B:1458:0x026b, B:1460:0x0273, B:1461:0x0279, B:1463:0x0281, B:1464:0x0287, B:1466:0x028f, B:1467:0x0295, B:1469:0x029d, B:1470:0x02a3, B:1472:0x02ab, B:1473:0x02b1, B:1475:0x02b9, B:1476:0x02bf, B:1478:0x02c7, B:1479:0x02cd, B:1481:0x02d5, B:1482:0x02db, B:1484:0x02e3, B:1485:0x02e9, B:1487:0x02f1, B:1488:0x02f7, B:1490:0x02ff, B:1491:0x0305, B:1493:0x030d, B:1494:0x0313, B:1496:0x031b, B:1497:0x0321, B:1499:0x0329, B:1500:0x032f, B:1502:0x0337, B:1503:0x033d, B:1505:0x0345, B:1506:0x034b, B:1508:0x0353, B:1509:0x0359, B:1511:0x0361, B:1512:0x0367, B:1514:0x036f, B:1515:0x0375, B:1517:0x037d, B:1518:0x0383, B:1520:0x038b, B:1521:0x0391, B:1523:0x0399, B:1524:0x039f, B:1526:0x03a7, B:1527:0x03ad, B:1529:0x03b5, B:1530:0x03bb, B:1532:0x03c3, B:1533:0x03c9, B:1535:0x03d1, B:1536:0x03d7, B:1538:0x03df, B:1539:0x03e5, B:1541:0x03ed, B:1542:0x03f3, B:1544:0x03fb, B:1545:0x0401, B:1547:0x0409, B:1548:0x040f, B:1550:0x0417, B:1551:0x041d, B:1553:0x0425, B:1554:0x042b, B:1556:0x0433, B:1557:0x0439, B:1559:0x0441, B:1560:0x0447, B:1562:0x044f, B:1563:0x0455, B:1565:0x045d, B:1566:0x0463, B:1568:0x046b, B:1569:0x0471, B:1571:0x0479, B:1572:0x047f, B:1574:0x0487, B:1575:0x048d, B:1577:0x0495, B:1578:0x049b, B:1580:0x04a3, B:1581:0x04a9, B:1583:0x04b1, B:1584:0x04b7, B:1586:0x04bf, B:1587:0x04c5, B:1589:0x04cd, B:1590:0x04d3, B:1592:0x04db, B:1593:0x04e1, B:1595:0x04e9, B:1596:0x04ef, B:1598:0x04f7, B:1599:0x04fd, B:1601:0x0505, B:1602:0x050b, B:1604:0x0513, B:1605:0x0519, B:1607:0x0521, B:1608:0x0527, B:1610:0x052f, B:1611:0x0535, B:1613:0x053d, B:1614:0x0543, B:1616:0x054b, B:1617:0x0551, B:1619:0x0559, B:1620:0x055f, B:1622:0x0567, B:1623:0x056d, B:1625:0x0575, B:1626:0x057b, B:1628:0x0583, B:1629:0x0589, B:1631:0x0591, B:1632:0x0597, B:1634:0x059f, B:1635:0x05a5, B:1637:0x05ad, B:1638:0x05b3, B:1640:0x05bb, B:1641:0x05c1, B:1643:0x05c9, B:1644:0x05cf, B:1646:0x05d7, B:1647:0x05dd, B:1649:0x05e5, B:1650:0x05eb, B:1652:0x05f3, B:1653:0x05f9, B:1655:0x0601, B:1656:0x0607, B:1658:0x060f, B:1659:0x0615, B:1661:0x061d, B:1662:0x0623, B:1664:0x062b, B:1665:0x0631, B:1667:0x0639, B:1668:0x063f, B:1670:0x0647, B:1671:0x064d, B:1673:0x0655, B:1674:0x065b, B:1676:0x0663, B:1677:0x0669, B:1679:0x0671, B:1680:0x0677, B:1682:0x067f, B:1683:0x0685, B:1685:0x068d, B:1686:0x0693, B:1688:0x069b, B:1689:0x06a1, B:1691:0x06a9, B:1692:0x06af, B:1694:0x06b7, B:1695:0x06bd, B:1697:0x06c5, B:1698:0x06cb, B:1700:0x06d3, B:1701:0x06d9, B:1703:0x06e1, B:1704:0x06e7, B:1706:0x06ef, B:1707:0x06f5, B:1709:0x06fd, B:1710:0x0703, B:1712:0x070b, B:1713:0x0711, B:1715:0x0719, B:1716:0x071f, B:1718:0x0727, B:1719:0x072d, B:1721:0x0735, B:1722:0x073b, B:1724:0x0743, B:1725:0x0749, B:1727:0x0751, B:1728:0x0757, B:1730:0x075f, B:1731:0x0765, B:1733:0x076d, B:1734:0x0773, B:1736:0x077b, B:1737:0x0781, B:1739:0x0789, B:1740:0x078f, B:1742:0x0797, B:1743:0x079d, B:1745:0x07a5, B:1746:0x07ab, B:1748:0x07b3, B:1749:0x07b9, B:1751:0x07c1, B:1752:0x07c7, B:1754:0x07cf, B:1755:0x07d5, B:1757:0x07dd, B:1758:0x07e3, B:1760:0x07eb, B:1761:0x07f1, B:1763:0x07f9, B:1764:0x07ff, B:1766:0x0807, B:1767:0x080d, B:1769:0x0815, B:1770:0x081b, B:1772:0x0823, B:1773:0x0829, B:1775:0x0831, B:1776:0x0837, B:1778:0x083f, B:1779:0x0845, B:1781:0x084d, B:1782:0x0853, B:1784:0x085b, B:1785:0x0861, B:1787:0x0869, B:1788:0x086f, B:1790:0x0877, B:1791:0x087d, B:1793:0x0885, B:1794:0x088b, B:1796:0x0893, B:1797:0x0899, B:1799:0x08a1, B:1800:0x08a7, B:1802:0x08af, B:1803:0x08b5, B:1805:0x08bd, B:1806:0x08c3, B:1808:0x08cb, B:1809:0x08d1, B:1811:0x08d9, B:1812:0x08df, B:1814:0x08e7, B:1815:0x08ed, B:1817:0x08f5, B:1818:0x08fb, B:1820:0x0903, B:1821:0x0909, B:1823:0x0911, B:1824:0x0917, B:1826:0x091f, B:1827:0x0925, B:1829:0x092d, B:1830:0x0933, B:1832:0x093b, B:1833:0x0941, B:1835:0x0949, B:1836:0x094f, B:1838:0x0957, B:1839:0x095d, B:1841:0x0965, B:1842:0x096b, B:1844:0x0973, B:1845:0x0979, B:1847:0x0981, B:1848:0x0987, B:1850:0x098f, B:1851:0x0995, B:1853:0x099d, B:1854:0x09a3, B:1856:0x09ab, B:1857:0x09b1, B:1859:0x09b9, B:1860:0x09bf, B:1862:0x09c7, B:1863:0x09cd, B:1865:0x09d5, B:1866:0x09db, B:1868:0x09e3, B:1869:0x09e9, B:1871:0x09f1, B:1872:0x09f7, B:1874:0x09ff, B:1875:0x0a05, B:1877:0x0a0d, B:1878:0x0a13, B:1880:0x0a1b, B:1881:0x0a21, B:1883:0x0a29, B:1884:0x0a2f, B:1886:0x0a37, B:1887:0x0a3d, B:1889:0x0a45, B:1890:0x0a4b, B:1892:0x0a53, B:1893:0x0a59, B:1895:0x0a61, B:1896:0x0a67, B:1898:0x0a6f, B:1899:0x0a75, B:1901:0x0a7d, B:1902:0x0a83, B:1904:0x0a8b, B:1905:0x0a91, B:1907:0x0a99, B:1908:0x0a9f, B:1910:0x0aa7, B:1911:0x0aad, B:1913:0x0ab5, B:1914:0x0abb, B:1916:0x0ac3, B:1917:0x0ac9, B:1919:0x0ad1, B:1920:0x0ad7, B:1922:0x0adf, B:1923:0x0ae5, B:1925:0x0aed, B:1926:0x0af3, B:1928:0x0afb, B:1929:0x0b01, B:1931:0x0b09, B:1932:0x0b0f, B:1934:0x0b17, B:1935:0x0b1d, B:1937:0x0b25, B:1938:0x0b2b, B:1940:0x0b33, B:1941:0x0b39, B:1943:0x0b41, B:1944:0x0b47, B:1946:0x0b4f, B:1947:0x0b55, B:1949:0x0b5d, B:1950:0x0b63, B:1952:0x0b6b, B:1953:0x0b71, B:1955:0x0b79, B:1956:0x0b7f, B:1958:0x0b87, B:1959:0x0b8d, B:1961:0x0b95, B:1962:0x0b9b, B:1964:0x0ba3, B:1965:0x0ba9, B:1967:0x0bb1, B:1968:0x0bb7, B:1970:0x0bbf, B:1971:0x0bc5, B:1973:0x0bcd, B:1974:0x0bd3, B:1976:0x0bdb, B:1977:0x0be1, B:1979:0x0be9, B:1980:0x0bef, B:1982:0x0bf7, B:1983:0x0bfd, B:1985:0x0c05, B:1986:0x0c0b, B:1988:0x0c13, B:1989:0x0c19, B:1991:0x0c21, B:1992:0x0c27, B:1994:0x0c2f, B:1995:0x0c35, B:1997:0x0c3d, B:1998:0x0c43, B:2000:0x0c4b, B:2001:0x0c51, B:2003:0x0c59, B:2004:0x0c5f, B:2006:0x0c67, B:2007:0x0c6d, B:2009:0x0c75, B:2010:0x0c7b, B:2012:0x0c83, B:2013:0x0c89, B:2015:0x0c91, B:2016:0x0c97, B:2018:0x0c9f, B:2019:0x0ca5, B:2021:0x0cad, B:2022:0x0cb3, B:2024:0x0cbb, B:2025:0x0cc1, B:2027:0x0cc9, B:2028:0x0ccf, B:2030:0x0cd7, B:2031:0x0cdd, B:2033:0x0ce5, B:2034:0x0ceb, B:2036:0x0cf3, B:2037:0x0cf9, B:2039:0x0d01, B:2040:0x0d07, B:2042:0x0d0f, B:2043:0x0d15, B:2045:0x0d1d, B:2046:0x0d23, B:2048:0x0d2b, B:2049:0x0d31, B:2051:0x0d39, B:2052:0x0d3f, B:2054:0x0d47, B:2055:0x0d4d, B:2057:0x0d55, B:2058:0x0d5b, B:2060:0x0d63, B:2061:0x0d69, B:2063:0x0d71, B:2064:0x0d77, B:2066:0x0d7f, B:2067:0x0d85, B:2069:0x0d8d, B:2070:0x0d93, B:2072:0x0d9b, B:2073:0x0da1, B:2075:0x0da9, B:2076:0x0daf, B:2078:0x0db7, B:2079:0x0dbd, B:2081:0x0dc5, B:2082:0x0dcb, B:2084:0x0dd3, B:2085:0x0dd9, B:2087:0x0de1, B:2088:0x0de7, B:2090:0x0def, B:2091:0x0df5, B:2093:0x0dfd, B:2094:0x0e03, B:2096:0x0e0b, B:2097:0x0e11, B:2099:0x0e19, B:2100:0x0e1f, B:2102:0x0e27, B:2103:0x0e2d, B:2105:0x0e35, B:2106:0x0e3b, B:2108:0x0e43, B:2109:0x0e49, B:2111:0x0e51, B:2112:0x0e57, B:2114:0x0e5f, B:2115:0x0e65, B:2117:0x0e6d, B:2118:0x0e73, B:2120:0x0e7b, B:2121:0x0e81, B:2123:0x0e89, B:2124:0x0e8f, B:2126:0x0e97, B:2127:0x0e9d, B:2129:0x0ea5, B:2130:0x0eab, B:2132:0x0eb3, B:2133:0x0eb9, B:2135:0x0ec1, B:2136:0x0ec7, B:2138:0x0ecf, B:2139:0x0ed5, B:2141:0x0edd, B:2142:0x0ee3, B:2144:0x0eeb, B:2145:0x0ef1, B:2147:0x0ef9, B:2148:0x0eff, B:2150:0x0f07, B:2151:0x0f0d, B:2153:0x0f15, B:2154:0x0f1b, B:2156:0x0f23, B:2157:0x0f29, B:2159:0x0f31, B:2160:0x0f37, B:2162:0x0f3f, B:2163:0x0f45, B:2165:0x0f4d, B:2166:0x0f53, B:2168:0x0f5b, B:2169:0x0f61, B:2171:0x0f69, B:2172:0x0f6f, B:2174:0x0f77, B:2175:0x0f7d, B:2177:0x0f85, B:2178:0x0f8b, B:2180:0x0f93, B:2181:0x0f99, B:2183:0x0fa1, B:2184:0x0fa7, B:2186:0x0faf, B:2187:0x0fb5, B:2189:0x0fbd, B:2190:0x0fc3, B:2192:0x0fcb, B:2193:0x0fd1, B:2195:0x0fd9, B:2196:0x0fdf, B:2198:0x0fe7, B:2199:0x0fed, B:2201:0x0ff5, B:2202:0x0ffb, B:2204:0x1003, B:2205:0x1009, B:2207:0x1011, B:2208:0x1017, B:2210:0x101f, B:2211:0x1025, B:2213:0x102d, B:2214:0x1033, B:2216:0x103b, B:2217:0x1041, B:2219:0x1049, B:2220:0x104f, B:2222:0x1057, B:2223:0x105d, B:2225:0x1065, B:2226:0x106b, B:2228:0x1073, B:2229:0x1079, B:2231:0x1081, B:2232:0x1087, B:2234:0x108f, B:2235:0x1095, B:2237:0x109d, B:2238:0x10a3, B:2240:0x10ab, B:2241:0x10b1, B:2243:0x10b9, B:2244:0x10bf, B:2246:0x10c7, B:2247:0x10cd, B:2249:0x10d5, B:2250:0x10db, B:2252:0x10e3, B:2253:0x10e9, B:2255:0x10f1, B:2256:0x10f7, B:2258:0x10ff, B:2259:0x1105, B:2261:0x110d, B:2262:0x1113, B:2264:0x111b, B:2265:0x1121, B:2267:0x1129, B:2268:0x112f, B:2270:0x1137, B:2271:0x113d, B:2273:0x1145, B:2274:0x114b, B:2276:0x1153, B:2277:0x1159, B:2279:0x1161, B:2280:0x1167, B:2282:0x116f, B:2283:0x1175, B:2285:0x117d, B:2286:0x1183, B:2288:0x118b, B:2289:0x1191, B:2291:0x1199, B:2292:0x119f, B:2294:0x11a7, B:2295:0x11ad, B:2297:0x11b5, B:2298:0x11bb, B:2300:0x11c3, B:2301:0x11c9, B:2303:0x11d1, B:2304:0x11d7, B:2306:0x11df, B:2307:0x11e5, B:2309:0x11ed, B:2310:0x11f3, B:2312:0x11fb, B:2313:0x1201, B:2315:0x1209, B:2316:0x120f, B:2318:0x1217, B:2319:0x121d, B:2321:0x1225, B:2322:0x122b, B:2324:0x1233, B:2325:0x1239, B:2327:0x1241, B:2328:0x1247, B:2330:0x124f, B:2331:0x1255, B:2333:0x125d, B:2334:0x1263, B:2336:0x126b, B:2337:0x1271, B:2339:0x1279, B:2340:0x127f, B:2342:0x1287, B:2343:0x128d, B:2345:0x1295, B:2346:0x129b, B:2348:0x12a3, B:2349:0x12a9, B:2351:0x12b1, B:2352:0x12b7, B:2354:0x12bf, B:2355:0x12c5, B:2357:0x12cd, B:2358:0x12d3, B:2360:0x12db, B:2361:0x12e1, B:2363:0x12e9, B:2364:0x12ef, B:2366:0x12f7, B:2367:0x12fd, B:2369:0x1305, B:2370:0x130b, B:2372:0x1313, B:2373:0x1319, B:2375:0x1321, B:2376:0x1327, B:2378:0x132f, B:2379:0x1335, B:2381:0x133d, B:2382:0x1343, B:2384:0x134b, B:2385:0x1351, B:2387:0x1359, B:2388:0x135f, B:2390:0x1367, B:2391:0x136d, B:2393:0x1375, B:2394:0x137b, B:2396:0x1383, B:2397:0x1389, B:2399:0x1391, B:2400:0x1397, B:2402:0x139f, B:2403:0x13a5, B:2405:0x13ad, B:2406:0x13b3, B:2408:0x13bb, B:2409:0x13c1, B:2411:0x13c9, B:2412:0x13cf, B:2414:0x13d7, B:2415:0x13dd, B:2417:0x13e5, B:2418:0x13eb, B:2420:0x13f3, B:2421:0x13f9, B:2423:0x1401, B:2424:0x1407, B:2426:0x140f, B:2427:0x1415, B:2429:0x141d, B:2430:0x1423, B:2432:0x142b, B:2433:0x1431, B:2435:0x1439, B:2436:0x143f, B:2438:0x1447, B:2439:0x144d, B:2441:0x1455, B:2442:0x145b, B:2444:0x1463, B:2445:0x1469, B:2447:0x1471, B:2448:0x1477, B:2450:0x147f, B:2451:0x1485, B:2453:0x148d, B:2454:0x1493, B:2456:0x149b, B:2457:0x14a1, B:2459:0x14a9, B:2460:0x14af, B:2462:0x14b7, B:2463:0x14bd, B:2465:0x14c5, B:2466:0x14cb, B:2468:0x14d3, B:2469:0x14d9, B:2471:0x14e1, B:2472:0x14e7, B:2474:0x14ef, B:2475:0x14f5, B:2477:0x14fd, B:2478:0x1503, B:2480:0x150b, B:2481:0x1511, B:2483:0x1519, B:2484:0x151f, B:2486:0x1527, B:2487:0x152d, B:2489:0x1535, B:2490:0x153b, B:2492:0x1543, B:2493:0x1549, B:2495:0x1551, B:2496:0x1557, B:2498:0x155f, B:2499:0x1565, B:2501:0x156d, B:2502:0x1573, B:2504:0x157b, B:2505:0x1580, B:2507:0x1588, B:2508:0x158d, B:2510:0x1595, B:2511:0x159a, B:2513:0x15a2, B:2514:0x15a7, B:2516:0x15af, B:2517:0x15b4, B:2519:0x15bc, B:2520:0x15c1, B:2522:0x15c9, B:2523:0x15ce, B:2525:0x15d6, B:2526:0x15db, B:2528:0x15e3, B:2529:0x15e8, B:2531:0x15f0), top: B:2558:0x01b5, outer: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A09(android.os.StrictMode.ThreadPolicy r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, int r19) {
        /*
            Method dump skipped, instructions count: 7178
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: X.C0BG.A09(android.os.StrictMode$ThreadPolicy, java.lang.String, java.lang.String, java.lang.String, int):boolean");
    }
}
