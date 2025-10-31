package X;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: X.01W */
/* loaded from: classes.dex */
public abstract class C01W extends C01V {
    public static final int A0A(Iterable iterable) {
        C06E.A07(iterable, 0);
        Iterator it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Number) it.next()).intValue();
        }
        return iIntValue;
    }

    public static final Comparable A0B(Iterable iterable) {
        C06E.A07(iterable, 0);
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static final Object A0C(Iterable iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final Object A0E(List list) {
        C06E.A07(list, 0);
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final Object A0F(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final Object A0G(List list) {
        C06E.A07(list, 0);
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(list.size() - 1);
    }

    public static final String A0J(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Iterable iterable, AnonymousClass005 anonymousClass005) throws IOException {
        C06E.A07(iterable, 0);
        C06E.A07(charSequence2, 2);
        StringBuilder sb = new StringBuilder();
        A0S(sb, charSequence, charSequence2, charSequence3, iterable, anonymousClass005);
        return sb.toString();
    }

    public static final ArrayList A0L(Iterable iterable, Collection collection) {
        C06E.A07(collection, 0);
        C06E.A07(iterable, 1);
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            C00Q.A09(iterable, arrayList);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static final List A0N(Iterable iterable) {
        C06E.A07(iterable, 0);
        if (!(iterable instanceof Collection)) {
            return C00K.A02(A0O(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return C003301n.A00;
        }
        if (size != 1) {
            return new ArrayList(collection);
        }
        List listSingletonList = Collections.singletonList(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
        C06E.A03(listSingletonList);
        return listSingletonList;
    }

    public static final List A0Q(Iterable iterable, Comparator comparator) {
        if (!(iterable instanceof Collection)) {
            List listA0O = A0O(iterable);
            C00P.A08(listA0O, comparator);
            return listA0O;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return A0N(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        C06E.A07(array, 0);
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        List listAsList = Arrays.asList(array);
        C06E.A03(listAsList);
        return listAsList;
    }

    public static final Set A0R(Iterable iterable) {
        Iterator it;
        Object next;
        C06E.A07(iterable, 0);
        if (!(iterable instanceof Collection)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            A0T(iterable, linkedHashSet);
            int size = linkedHashSet.size();
            if (size != 0) {
                if (size != 1) {
                    return linkedHashSet;
                }
                it = linkedHashSet.iterator();
                next = it.next();
            }
            return C01e.A00;
        }
        Collection collection = (Collection) iterable;
        int size2 = collection.size();
        if (size2 != 0) {
            if (size2 != 1) {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(C00I.A01(collection.size()));
                A0T(iterable, linkedHashSet2);
                return linkedHashSet2;
            }
            if (iterable instanceof List) {
                next = ((List) iterable).get(0);
            } else {
                it = collection.iterator();
                next = it.next();
            }
        }
        return C01e.A00;
        Set setSingleton = Collections.singleton(next);
        C06E.A03(setSingleton);
        return setSingleton;
    }

    public static final Object A0D(Iterable iterable) {
        Object next;
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(list.size() - 1);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static final Object A0I(List list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static final ArrayList A0K(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final HashSet A0M(Iterable iterable) {
        HashSet hashSet = new HashSet(C00I.A01(C00M.A06(iterable, 12)));
        A0T(iterable, hashSet);
        return hashSet;
    }

    public static final List A0O(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            C06E.A07(collection, 0);
            return new ArrayList(collection);
        }
        ArrayList arrayList = new ArrayList();
        A0T(iterable, arrayList);
        return arrayList;
    }

    public static final List A0P(Iterable iterable, int i) {
        Object next;
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (i == 0) {
            return C003301n.A00;
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return A0N(iterable);
            }
            if (i == 1) {
                if (iterable instanceof List) {
                    next = A0E((List) iterable);
                } else {
                    Iterator it = iterable.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException("Collection is empty.");
                    }
                    next = it.next();
                }
                List listSingletonList = Collections.singletonList(next);
                C06E.A03(listSingletonList);
                return listSingletonList;
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it2 = iterable.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            arrayList.add(it2.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return C00K.A02(arrayList);
    }

    public static final boolean A0U(Iterable iterable, Object obj) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj) >= 0;
        }
        int i = 0;
        for (Object obj2 : iterable) {
            if (i < 0) {
                C00K.A04();
                throw AnonymousClass062.createAndThrow();
            }
            if (C06E.areEqual(obj, obj2)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static final Object A0H(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static final void A0S(Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Iterable iterable, AnonymousClass005 anonymousClass005) throws IOException {
        appendable.append(charSequence2);
        int i = 0;
        for (Object objInvoke : iterable) {
            i++;
            if (i > 1) {
                appendable.append(charSequence);
            }
            if (anonymousClass005 != null) {
                objInvoke = anonymousClass005.invoke(objInvoke);
            } else if (objInvoke != null && !(objInvoke instanceof CharSequence)) {
                if (objInvoke instanceof Character) {
                    appendable.append(((Character) objInvoke).charValue());
                } else {
                    objInvoke = objInvoke.toString();
                }
            }
            appendable.append((CharSequence) objInvoke);
        }
        appendable.append(charSequence3);
    }

    public static final void A0T(Iterable iterable, Collection collection) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }
}
