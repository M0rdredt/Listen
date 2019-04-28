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
        this.next.setIndex(index+1);
    }
    public boolean hasNext(){
        return next!=null;
    }

    private void setIndex(int index){
        this.index=index;
        System.out.println(index);
    }

    public int getIndex() {
        return index;
    }
}
