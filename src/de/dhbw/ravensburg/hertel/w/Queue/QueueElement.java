package de.dhbw.ravensburg.hertel.w.Queue;
//TODO: alles
public class QueueElement<T> {

    private int index;
    private T value;
    private QueueElement nextElement;

     QueueElement getNextElement() {
        return nextElement;
    }

     void setNextElement(QueueElement nextElement) {

        this.nextElement = nextElement;
    }

     QueueElement(T value) {
        this.value = value;
    }

     int getIndex() {

        return index;
    }

     void setIndex(int index) {

        this.index = index;
    }

    public T getValue() {

        return value;
    }

    public void setValue(T value) {

        this.value = value;
    }
    public boolean hasNext(){
        return nextElement!=null;
    }
}
