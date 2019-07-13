package de.dhbw.ravensburg.hertel.w.Sorter;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;
import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableListElement;

public class SimpleSorter<T> {

    private Object[] array;

    /**Uses a simple-Sort algorithm on the given list
     * @param list any list that implements the Sortable interface
     * @return a sorted list
     */
    public AbstractList simpleSort(SortableList list) {
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
                simpleSortTheInternalRealThingything(arrayNum)) {
            list.add((T) num);
        }
        return (AbstractList) list;
    }
    private Number[] simpleSortTheInternalRealThingything(Number[] arrayNum){
        Number k;
        for (int i = arrayNum.length-1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arrayNum[j].doubleValue() >= arrayNum[i].doubleValue()) {
                    k = arrayNum[i];
                    arrayNum[i] = arrayNum[j];
                    arrayNum[j] = k;
                }
            }
        }
        return arrayNum;
    }
}
