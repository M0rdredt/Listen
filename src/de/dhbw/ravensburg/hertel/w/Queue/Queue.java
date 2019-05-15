package de.dhbw.ravensburg.hertel.w.Queue;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;

//TODO: alles
public class Queue<T> extends AbstractList {
    QueueElement firstElement;
    QueueElement lastElement;

    @Override
    public boolean isEmpty() {
        return firstElement==null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(Object value) {
        add(new QueueElement(value));
    }
    public void add(QueueElement element){
        if(this.isEmpty()){
            firstElement = element;
            element.setIndex(0);
            lastElement = element;
        }
        else {
            lastElement.setNextElement(element);
            element.setIndex(lastElement.getIndex() + 1);
            lastElement = element;

        }


    }

    @Override
    public void addAll(AbstractList list) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public boolean contains(Object value) {
        QueueElement element = new QueueElement(value);
        return false;
    }

    @Override
    public boolean containsAll(AbstractList list) {
        return false;
    }

    @Override
    public Object[] returnAsArray() {
        return new Object[0];
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void bubbleSort() {

    }

    @Override
    public void quickSort() {

    }

    @Override
    public void otherSort() {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
