package de.dhbw.ravensburg.hertel.w.DoubleLinkedList;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;
import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;

//TODO: alles
public class DoubleLinkedList<T> extends AbstractList {

    private DoubleLinkedListElement head;
    private DoubleLinkedListElement tail;

    @Override
    public boolean isEmpty() {
        return updateIndices()==0;
    }

    @Override
    public int size() {
        return updateIndices();
    }

    @Override
    public void add(Object value) {
        add(new DoubleLinkedListElement(value));
    }

    private void add(DoubleLinkedListElement value) {
        DoubleLinkedListElement e = this.getHead();
        if (e == null) {
            this.setHead(value);
            this.setTail(value);
        }
        else {
            DoubleLinkedListElement currentTail = this.getTail();
            currentTail.setNext(value);
            value.setPrevious(currentTail);
            this.setTail(value);
        }
        updateIndices();
    }


    @Override
    public void addAll(AbstractList list) {

    }

    @Override
    public void removeAll() {
        this.setHead(null);
        this.setTail(null);
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public boolean containsAll(AbstractList list) {
        return false;
    }

    @Override
    public void removeParticularObj(Object value) {

    }

    @Override
    public Object[] returnAsArray() {
        return new Object[0];
    }

    @Override
    public String toString() {
        StringBuilder bs =new StringBuilder("[");
        if(this.getHead() != null) {
            DoubleLinkedListElement element = this.getHead();
            while (!element.equals(this.getTail())) {
                bs.append(element.getValue().toString()).append(", ");
                element = element.getNext();
            }
            if (element.equals(this.getTail()) && element.getValue() != null) {
                bs.append(element.getValue().toString());
            }
        }
        bs.append("]");
        return bs.toString();
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

    private int updateIndices(){
        if(this.getHead()!=null) {
            DoubleLinkedListElement element = this.getHead();
            if (this.getTail().equals(element)) {
                element.setIndex(0);
            }
            int i = 0;
            while (!this.getTail().equals(element)) {
                element.setIndex(i);
                i++;
                element = element.getNext();
            }
            return i + 1; //return number for size()
        }
        else
            return 0; //return number for size()
    }

    public void swapElements(AbstractElement element1, AbstractElement element2) {
        Object xVal = element1.getValue();
        Object yVal = element2.getValue();
        if (xVal == yVal) {
            return;
        }
        DoubleLinkedListElement currX = (DoubleLinkedListElement) element1;
        DoubleLinkedListElement currY = (DoubleLinkedListElement) element2;
        DoubleLinkedListElement prevX = findPreviousElement(currX);
        DoubleLinkedListElement prevY = findPreviousElement(currY);
        boolean successive = areSuccessiveElements(currX, currY);
        if (currX == null || currY == null) {
            return;
        }
       if (prevX != null) {
            prevX.setNext(currY);
        } else {
            setHead(currY);
        }
        if (prevY != null) {
            prevY.setNext(currX);
        } else {
            setHead(currX);
        }
        DoubleLinkedListElement temp1 = currX;
        DoubleLinkedListElement temp2 =currX.getPrevious();
        if (!successive) {
            currX.setPrevious(currY.getPrevious());
            currX.setNext(currY.getNext());
            currY.getPrevious().setNext(currX);
            if(currY.hasNext()) {
                currY.getNext().setPrevious(currX);
            }
            currY.setPrevious(temp1.getPrevious());
            currY.setNext(temp1.getNext());
            if(temp1.getPrevious()!=null){
                temp1.getPrevious().setNext(currY);
            }
            temp1.getNext().setPrevious(currY);
        }
        else{
            currX.setNext(currY.getNext());
            currX.setPrevious(currY);
            currY.getNext().setPrevious(currX);
            currY.setNext(currX);
            currY.setPrevious(temp2);
            temp1.getPrevious().getPrevious().setNext(currY);
        }
    }

    private DoubleLinkedListElement findPreviousElement(DoubleLinkedListElement element){
        if(element.getPrevious()!=null){
            return element.getPrevious();
        }
        else{
            return null;
        }
    }

    private boolean areSuccessiveElements(DoubleLinkedListElement a, DoubleLinkedListElement b){
        if(a.getNext().equals(b)||a.getPrevious().equals(b)){
            return true;
        }
        else
            return false;
    }



    //Setter & Getter
    public DoubleLinkedListElement getHead() {
        return head;
    }

    public void setHead(DoubleLinkedListElement head) {
        this.head = head;
    }

    public DoubleLinkedListElement getTail() {
        return tail;
    }

    public void setTail(DoubleLinkedListElement tail) {
        this.tail = tail;
    }
}
