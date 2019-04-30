package de.dhbw.ravensburg.hertel.w.Sorter;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;
import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedListElement;

public class BubbleSorter<T> {

    //ToDo: make it work if there are 2 elements of same numerical value
    public void bubbleSort(AbstractList list){
        AbstractElement element;
        int i =0;
        while(i< list.size()) {
            element = list.getHead();
            while (element != null && element.hasNext()) {
                if (element.getValue() instanceof Number && element.getNext().getValue() instanceof Number) {
                    Number first = (Number) element.getValue();
                    Number second = (Number) element.getNext().getValue();
                    if (first.doubleValue() > second.doubleValue()) {
                        list.swapElements(element, element.getNext());
                    }
                }
                element = element.getNext();
            }

            i++;

        }
    }


}
