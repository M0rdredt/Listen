package de.dhbw.ravensburg.hertel.w.Stack;

//TODO: alles
public class StackElement<T> {
   private T value;
   private StackElement next;

    public StackElement(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(StackElement next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next!=null;
    }

    public T getValue() {
        return value;
    }

    public StackElement getNext() {
        return next;
    }


}
