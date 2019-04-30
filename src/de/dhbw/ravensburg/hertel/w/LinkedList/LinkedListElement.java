package de.dhbw.ravensburg.hertel.w.LinkedList;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;

public class LinkedListElement<T> extends AbstractElement {
    //TODO: Evtl. AbstractElement?
    private T value;
    private LinkedListElement next;
    private int index = 0;

    LinkedListElement(T value) {
        this.value=value;
    }
    //Todo: write equals method
    public T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    public LinkedListElement getNext() {
        if(next!=null)
            return next;
        else
            return null;
    }

    void setNext(LinkedListElement next) {
        this.next = next;
    }

    public boolean hasNext(){
        return next!=null;
    }

    void setIndex(int index){
        this.index=index;
    }

    int getIndex() {
        return index;
    }
}
