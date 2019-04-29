package de.dhbw.ravensburg.hertel.w;

import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedList;
import de.dhbw.ravensburg.hertel.w.Sorter.BubbleSorter;

public class Test {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(7);
        list.add(1);
        list.add(8);
        list.add(3);
        list.add(13);
        list.add(6);
        BubbleSorter sorter = new BubbleSorter();

        System.out.println(list);
        sorter.bubbleSort(list);
        System.out.println(list.getElementFromCertainPosition(2));
        System.out.println(list);

    }
}
