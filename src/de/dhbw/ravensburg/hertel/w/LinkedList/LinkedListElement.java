package de.dhbw.ravensburg.hertel.w.LinkedList;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;

public class LinkedListElement<T> extends AbstractElement {
    //TODO: Evtl. AbstractElement?
    private T value;
    private LinkedListElement next;

    LinkedListElement(T value) {
        this.value=value;
    }
    //Todo: write equals method
    T getValue() {
        return (T) value;
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
    public boolean hasNext(){
        return next!=null;
    }

}
