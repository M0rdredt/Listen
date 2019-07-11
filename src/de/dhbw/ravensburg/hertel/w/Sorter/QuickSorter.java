package de.dhbw.ravensburg.hertel.w.Sorter;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableList;

public class QuickSorter<T> {

    private Number[] array;

    /**Uses the quick-Sort algorithm on the given list
     * @param list any list that implements the Sortable interface
     * @return a sorted list
     */
    public AbstractList quickSort(SortableList list) {
        if(!(list.getHead().getValue() instanceof Number))
            throw new IllegalArgumentException(list+"do" +
                    "es not contain numbers and is for this reason not sortable");
        array = (Number[])list.returnAsArray();
        list.removeAll();
        for (Number num :
                quickSortTheInternalRealThingything(0, array.length-1)) {
            list.add((T) num);
        }
        return (AbstractList) list;
    }

    private Number[] quickSortTheInternalRealThingything(int l, int r){
        int q;
        if (l < r) {
            q = partition(l, r);
            quickSortTheInternalRealThingything(l, q);
            quickSortTheInternalRealThingything(q + 1, r);
        }
        return array;
    }


    private int partition(int l, int r) {

        int indexToReturn, internalIndex;
        double  theOnlyRealValue = array[(l + r) / 2].doubleValue();
        internalIndex = l - 1;
        indexToReturn = r + 1;
        while (true) {
            do {
                internalIndex++;
            } while (array[internalIndex].doubleValue() < theOnlyRealValue);

            do {
                indexToReturn--;
            } while (array[indexToReturn].doubleValue() > theOnlyRealValue);

            if (internalIndex < indexToReturn) {
                double k = array[internalIndex].doubleValue();
                array[internalIndex] = array[indexToReturn];
                array[indexToReturn] = k;
            } else {
                return indexToReturn;
            }
        }
    }
}
