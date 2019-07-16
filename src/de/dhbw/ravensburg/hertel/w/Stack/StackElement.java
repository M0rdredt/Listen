package de.dhbw.ravensburg.hertel.w.Stack;

//TODO: alles
public class StackElement<T> {
   private Object value;
   private StackElement next;

   StackElement(T value) {
        this.value = value;
    }
    void setValue(T value) {
        this.value = value;
    }

    void setNext(StackElement next) {
        this.next = next;
    }

   public boolean hasNext() {
        return next!=null;
    }

   public Object getValue() {
        return value;
    }

   public StackElement getNext() {
        return next;
    }


}
