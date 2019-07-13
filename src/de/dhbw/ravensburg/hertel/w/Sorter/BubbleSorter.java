package de.dhbw.ravensburg.hertel.w.Sorter;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;
import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedListElement;


public class BubbleSorter<T> {

    //ToDo: make it work if there are 2 elements of same numerical value
    public void bubbleSort(AbstractList list) {
        AbstractElement element = list.getHead();
        AbstractElement element2 = element.getNext();

        while (element != null) {
            if (!this.isNumeric(element.getValue())) {
                Exception e = new Exception();
                System.err.println("In Ihrer Liste befinden sich unsortierbare Objekte");
                return;
            }
            element = element.getNext();
        }
        element = list.getHead();

        while (element2 != null) {
            while (element != null) {


            }
        }
    }





    private boolean isNumeric(Object value){
            return value instanceof Number;
        }
}

