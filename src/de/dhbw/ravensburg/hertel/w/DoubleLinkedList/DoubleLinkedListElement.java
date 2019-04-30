package de.dhbw.ravensburg.hertel.w.DoubleLinkedList;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;

//TODO: alles
public class DoubleLinkedListElement<T> extends AbstractElement {

    private T value;
    private DoubleLinkedListElement previous;
    private DoubleLinkedListElement next;
    private int index;

    DoubleLinkedListElement(T value){
        this.value = value;
    }

    //Getter & Setter
    public T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    void setNext(DoubleLinkedListElement next){
        this.next = next;
    }

    DoubleLinkedListElement getNext(){
        return next;
    }

    DoubleLinkedListElement getPrevious() {
        return previous;
    }

    void setPrevious(DoubleLinkedListElement previous) {
        this.previous = previous;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
