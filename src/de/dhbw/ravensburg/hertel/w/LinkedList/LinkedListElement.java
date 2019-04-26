package de.dhbw.ravensburg.hertel.w.LinkedList;

public class LinkedListElement<T> {
    //TODO: Evtl. AbstractElement?
    private T value;
    private LinkedListElement next;

    LinkedListElement(T value) {
        //TOdo: write init constructor code
    }
    //Todo: write equals method
    T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    LinkedListElement getNext() {
        return next;
    }

    void setNext(LinkedListElement next) {
        this.next = next;
    }
}
