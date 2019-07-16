package de.dhbw.ravensburg.hertel.w.DoubleLinkedList;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableListElement;

//TODO: alles
public class DoubleLinkedListElement<T> extends AbstractElement implements SortableListElement {

    private Object value;
    private DoubleLinkedListElement previous;
    private DoubleLinkedListElement next;
    private int index;

    DoubleLinkedListElement(T value){
        this.value = value;
    }

    public boolean hasNext(){
        return this.getNext()!=null;
    }


    //Getter & Setter
    public Object getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    void setNext(DoubleLinkedListElement next){
        this.next = next;
    }

    public DoubleLinkedListElement getNext(){
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

    void setIndex(int index) {
        this.index = index;
    }
}
