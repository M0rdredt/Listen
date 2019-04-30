package de.dhbw.ravensburg.hertel.w;

import de.dhbw.ravensburg.hertel.w.DoubleLinkedList.DoubleLinkedList;
import de.dhbw.ravensburg.hertel.w.DoubleLinkedList.DoubleLinkedListElement;
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

        System.out.println(list.getValueByIndex(2));
        System.out.println(list);
        sorter.bubbleSort(list);
        list.removeElement(6);
        System.out.println(list);
        System.out.println(list.getValueByIndex(2));
        System.out.println("----------------------------------------");

        DoubleLinkedList dlist = new DoubleLinkedList();
        dlist.add(2);
        dlist.add(6);
        System.out.println(dlist);

    }
}
