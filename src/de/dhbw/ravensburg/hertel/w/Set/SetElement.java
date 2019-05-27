package de.dhbw.ravensburg.hertel.w.Set;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;

//TODO: alles
public class SetElement<T> {
   private T value;
   private SetElement next;

    public SetElement(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(SetElement next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next!=null;
    }

    public T getValue() {
        return value;
    }

    public SetElement getNext() {
        return next;
    }


}
