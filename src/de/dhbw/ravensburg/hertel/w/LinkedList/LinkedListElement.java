package de.dhbw.ravensburg.hertel.w.LinkedList;

public class LinkedListElement<T> {
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

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedListElement getNext() {
        return next;
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

    public int getIndex() {
        return index;
    }
}
