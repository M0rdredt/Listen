package de.dhbw.ravensburg.hertel.w.DoubleLinkedList;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableListElement;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedListElement;

import java.lang.reflect.Array;

//TODO: alles
public class DoubleLinkedList<T> extends AbstractList implements SortableList {

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
        Object[] ts = (Object[]) Array.newInstance(Object.class,this.size());
        int counter =0;
        DoubleLinkedListElement e = this.getHead();
        do {
            ts[counter]=e.getValue();
            counter++;
            e = e.getNext();
        }while(e.hasNext());
        ts[counter]= e.getValue();
        return ts;
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
