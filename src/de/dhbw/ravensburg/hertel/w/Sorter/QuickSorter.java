package de.dhbw.ravensburg.hertel.w.Sorter;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableList;

public class QuickSorter {
    public AbstractList quickSort(SortableList list) {
        Class clazz = list.getClass();
        if(!(list.getHead().getValue() instanceof Number))
            throw new IllegalArgumentException(list+"does not contain numbers and is for this reason not sortable")
    }

    int partition(int l, int r) {

        int i, j, x = intArr[(l + r) / 2];
        i = l - 1;
        j = r + 1;
        while (true) {
            do {
                i++;
            } while (intArr[i] < x);

            do {
                j--;
            } while (intArr[j] > x);

            if (i < j) {
                int k = intArr[i];
                intArr[i] = intArr[j];
                intArr[j] = k;
            } else {
                return j;
            }
        }
    }
}
