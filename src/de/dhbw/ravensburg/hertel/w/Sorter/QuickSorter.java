package de.dhbw.ravensburg.hertel.w.Sorter;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableListElement;

public class QuickSorter<T> {

    private Object[] array;

    /**Uses the quick-Sort algorithm on the given list
     * @param list any list that implements the Sortable interface
     * @return a sorted list
     */
    public AbstractList quickSort(SortableList list) {
        SortableListElement element = list.getHead();
        while(element!=null){
            if(!(element.getValue() instanceof Number)) {
                throw new IllegalArgumentException(list + "do" +
                        "es not contain numbers and is for this reason not sortable");
            }
            element = element.getNext();
        }
        array = (Object[])list.returnAsArray();
        Number[] arrayNum = new Number[array.length];
        for(int n =0; n<arrayNum.length; n++){
            Number number1 =(Number) array[n];
            arrayNum[n] = number1;
        }
        list.removeAll();
        for (Number num :
                quickSortTheInternalRealThingything(0, array.length-1, arrayNum)) {
            list.add((T) num);
        }
        return (AbstractList) list;
    }

    private Number[] quickSortTheInternalRealThingything(int l, int r, Number[] arrayNum){
        int q;
        if (l < r) {
            q = partition(l, r, arrayNum);
            quickSortTheInternalRealThingything(l, q, arrayNum);
            quickSortTheInternalRealThingything(q + 1, r, arrayNum);
        }
        return arrayNum;
    }


    private int partition(int l, int r, Number[] array) {

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
