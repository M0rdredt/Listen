package de.dhbw.ravensburg.hertel.w.LinkedList;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.Sorter.BubbleSorter;

import java.lang.reflect.Array;

public class LinkedList<T> extends AbstractList<T> {

    //Variables
    private LinkedListElement head;

    //Constructors

    //Setter/Getter
    private LinkedListElement getHead() {
        return head;
    }

    private void setHead(LinkedListElement head) {
        this.head = head;
    }

    //Overrides AbstractList

    @Override
    public void removeAll() {
        this.setHead(null);
    }

    @Override
    public boolean contains(T value) {
        LinkedListElement e = new LinkedListElement(value);
        LinkedListElement x = this.getHead();
        while(x.hasNext()){
            if(e.equals(x.getNext()))
                return true;
            x = x.getNext();
        }
        return false;
    }

    @Override
    public boolean containsAll(AbstractList list) {
        T[] array = (T[]) list.returnAsArray();
        if(list.isEmpty())
            throw new IllegalArgumentException("List: " + list.toString() +" does not contain anything");
        for (T value:
             array) {
            if(!this.contains(value))return false;
        }
        return true;
    }

    @Override
    public void removeParticularObj(T value) {
        if(this.contains(value)){
            LinkedListElement e = this.getHead();
            while(e.hasNext()){
                if(e.getNext().getValue().equals(value)){
                    e.setNext(new LinkedListElement(this.getElementFromCertainPosition(this.getPositionOfObj(e.getValue())+2)));
                }
            }
        }else
            throw new IllegalArgumentException("The element: "+value.toString()+" is not contained within "+this.toString());
    }

    @Override
    public boolean isEmpty() {
        return  this.getHead() == null;
    }

    @Override
    public int size() {
        int size = 0;
        LinkedListElement e =this.getHead();
        while(e.hasNext()){
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
            while(e.hasNext()){
                e=e.getNext();
            }
            e.setNext(value);
        }
    }

    @Override
    public void addAll(AbstractList list) {
        if(list instanceof LinkedList) {
            LinkedListElement e = ((LinkedList) list).getHead();
            while(e.hasNext()){
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
        while(e.hasNext()){
            ts[counter]=(T)e.getValue();
            counter++;
            e = e.getNext();
        }
        return ts;
    }
    //Overrides Object

    @Override
    public String toString() {
        StringBuilder bs =new StringBuilder("[");
        if(this.getHead() != null) {
            LinkedListElement element = this.getHead();
            while (element.hasNext()) {
                bs.append(element.getValue().toString()).append(", ");
                element = element.getNext();
            }
            if (!element.hasNext() && element.getValue() != null) {
                bs.append(element.getValue().toString());
            }
        }
        bs.append("]");
        return bs.toString();
    }

    //Overrides Sortable
    @Override
    public void bubbleSort() {
        //TODO: BubbleSorter.sort(this);
    }

    @Override
    public void quickSort() {
        //TODO: QuickSorter.sort(this);
    }

    @Override
    public void otherSort() {
        //TODO://impl
    }

    //Overrides Comparable
    @Override
    public int compareTo(Object o) {
        return 0;
        //TODO:impl
    }

    //Class-specific methods
    public void addElementAtCertainPosition(T value, int position){
        //TODO: impl
    }

    public void removeElementFromCertainPosition(int position){
        //TODO: impl
    }

    public T getElementFromCertainPosition(int position){
        //TODO: impl
        return null;
    }

    public int getPositionOfObj(Object value){
        //TODO: impl
        return 0;
    }
}
