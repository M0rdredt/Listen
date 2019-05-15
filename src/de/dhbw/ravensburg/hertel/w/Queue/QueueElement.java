package de.dhbw.ravensburg.hertel.w.Queue;
//TODO: alles
public class QueueElement<T> {

    private int index;
    private T value;
    private QueueElement nextElement;

    public QueueElement getNextElement() {
        return nextElement;
    }

    public void setNextElement(QueueElement nextElement) {
        this.nextElement = nextElement;
    }

    public QueueElement(T value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
