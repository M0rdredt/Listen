package de.dhbw.ravensburg.hertel.w.Queue;

public class Queue<T> {
    private QueueElement head;
    private QueueElement tail;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int counterIndexSize = 1;
        QueueElement counterElementSize = head;

        if (isEmpty())
            return 0;

        while (counterElementSize.getNextElement() != null) {
            counterIndexSize++;
            counterElementSize = counterElementSize.getNextElement();
        }
        return counterIndexSize;
    }

    public void add(Object value) {
        add(new QueueElement(value));
    }

    public void add(QueueElement element) {
        if (this.isEmpty()) {
            head = element;
            element.setIndex(0);
            tail = element;
        } else {
            tail.setNextElement(element);
            element.setIndex(tail.getIndex() + 1);
            tail = element;
        }
    }

    public QueueElement poll(){
        QueueElement element = head;
        if(element.hasNext()){

            head=element.getNextElement();
            return element;
        }
        else {
            head = null;
            tail = null;
            return null;
        }
    }

    public void removeAll() {
        if (!isEmpty())
            tail = null;
        head = null;
    }

    public QueueElement peek(){
        return head;
    }

    public boolean contains(Object value) {
        QueueElement element = new QueueElement(value);
        QueueElement compare = head;
        while (compare.getNextElement() != null) {
            if (element.getValue().equals(compare.getValue()))
                return true;
            compare = compare.getNextElement();
        }
        return false;
    }

    public String toString() {

        StringBuilder bs = new StringBuilder("[");
        if (head != null) {
            QueueElement element = head;
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
}