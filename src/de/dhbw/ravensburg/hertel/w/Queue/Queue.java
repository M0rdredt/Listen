package de.dhbw.ravensburg.hertel.w.Queue;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;
import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedListElement;

import java.lang.reflect.Array;

//TODO: alles
public class Queue<T> extends AbstractList {
    QueueElement firstElement;
    QueueElement lastElement;

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public int size() {

        int counterIndexSize = 1;
        QueueElement counterElementSize = firstElement;

        if (isEmpty())
            return 0;

        while (counterElementSize.getNextElement() != null) {
            counterIndexSize++;
            counterElementSize = counterElementSize.getNextElement();
        }
        return counterIndexSize;
    }

    @Override
    public void add(Object value) {
        add(new QueueElement(value));
    }

    public void add(QueueElement element) {
        if (this.isEmpty()) {
            firstElement = element;
            element.setIndex(0);
            lastElement = element;
        } else {
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

        if (!isEmpty())
            lastElement = null;
        firstElement = null;
    }

    @Override
    public boolean contains(Object value) {
        QueueElement element = new QueueElement(value);
        QueueElement compare = firstElement;
        while (compare.getNextElement() != null) {
            if (element.getValue().equals(compare.getValue()))
                return true;
            compare = compare.getNextElement();
        }
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

        StringBuilder bs = new StringBuilder("[");
        if (firstElement != null) {
            QueueElement element = firstElement;
            while (element.hasNext()) {
                bs.append(element.getValue().toString()).append(", ");
                element = element.getNextElement();
            }
            if (!element.hasNext() && element.getValue() != null) {
                bs.append(element.getValue().toString());
            }
        }
        bs.append("]");
        return bs.toString();
    }


    @java.lang.Override
    public AbstractElement getHead() {
        return null;
    }

    @java.lang.Override
    public void swapElements(AbstractElement element1, AbstractElement element2) {

        // TODO: löschen
    }

    @Override
    public void removeParticularObj(Object value) {

        // TODO: löschen

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
