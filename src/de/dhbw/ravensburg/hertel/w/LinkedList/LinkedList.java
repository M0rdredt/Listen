package de.dhbw.ravensburg.hertel.w.LinkedList;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;

import java.lang.reflect.Array;

public class LinkedList<T> extends AbstractList<T> {

    private LinkedListElement head;

    //TODO: impl
    @Override
    public void removeAll() {
        this.setHead(null);
    }

    @Override
    public boolean contains() {
        return false;
    }

    @Override
    public boolean containsAll() {
        return false;
    }

    @Override
    public void removeParticularObj() {

    }

    @Override
    public boolean isEmpty() {
        return  this.getHead() == null;
    }











    @Override
    public int size() {
        int size = 0;
        LinkedListElement e =this.getHead();
        while(e.getNext()!=null){
            size++;
            e = e.getNext();
        }
        return size;
    }

    @Override
    public void add(T value) {
        add(new LinkedListElement(value));
    }

    public void add(LinkedListElement value) {
        LinkedListElement e = this.getHead();
        if(e==null)
            this.setHead(value);
        else{
            while(e.getNext()!= null){
                e=e.getNext();
            }
            e.setNext(value);
        }
    }


    @Override
    public void addAll(AbstractList list) {
        if(list instanceof LinkedList) {
            LinkedListElement e = ((LinkedList) list).getHead();
            while(e.getNext() != null){
                this.add(e);
            }
        }

    }



    @Override
    public T[] returnAsArray() {
        Class c =this.getHead().getClass();
        T[] ts = (T[]) Array.newInstance(c,this.size());
        int counter =0;
        LinkedListElement e = this.getHead();
        while(e.getNext()!=null){
            ts[counter]=(T)e.getValue();
            counter++;
            e = e.getNext();
        }
        return ts;
    }



    private LinkedListElement getHead() {
        return head;
    }

    private void setHead(LinkedListElement head) {
        this.head = head;
    }

    @Override
    public String toString() {
        StringBuilder bs =new StringBuilder("[");
        LinkedListElement element = this.getHead();
        while(element.getNext()!= null){
            bs.append(element.toString()).append(", ");
        }
        bs.append("]");
        return bs.toString();
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
