package de.dhbw.ravensburg.hertel.w.Sorter;

import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedListElement;

public class BubbleSorter {

    //ToDo: will probably throw NPE  -> very barebones... gonna look into it
    public void bubbleSort(LinkedList list){
        LinkedListElement element = list.getHead();
        while(element.hasNext()){
            if(element.getValue() instanceof Number && element.getNext().getValue() instanceof Number){
                Number first = (Number) element.getValue();
                Number second = (Number) element.getNext().getValue();
                if(first.doubleValue()> second.doubleValue()){
                    list.swapElements(element, element.getNext());
                    return;
                }
            }
            element = element.getNext();
        }
    }


}
