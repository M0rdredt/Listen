package de.dhbw.ravensburg.hertel.w.LinkedList;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;

import java.lang.reflect.Array;

public class LinkedList<T> extends AbstractList<T> {

    private LinkedListElement head;


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
            //TODO: code for removal
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

    public LinkedListElement getHead() {
        return head;
    }

    private void setHead(LinkedListElement head) {
        this.head = head;
    }

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

    @Override
    public void bubbleSort() {
        //TODO: impl
    }

    @Override
    public void quickSort() {
        //TODO:impl
    }

    @Override
    public void otherSort() {
        //TODO://impl
    }

    @Override
    public int compareTo(Object o) {
        return 0;
        //TODO:impl
    }

    public void addElementAtCertainPosition(T value){
        //TODO: impl
    }

    public void removeElementFromCertainPosition(){
        //TODO: impl
    }

    public T getElementFromCertainPosition(int index){
        LinkedListElement current = getHead();
        while(current.hasNext()){
            if(current.getIndex() == index){
                return (T) current;
            }
            current = current.getNext();
        }
      return null;
    }

    public int getPositionOfObj(T value){
        return findElementbyValue(value).getIndex();

    }

    //should now work fine
    public void swapElements(LinkedListElement x, LinkedListElement y) {
        Object xVal = x.getValue();
        Object yVal = y.getValue();
       if (xVal == yVal) {
           return;
        }
        LinkedListElement prevX = findPreviousElement(x);
        LinkedListElement currX = x;
        LinkedListElement prevY = findPreviousElement(y);
        LinkedListElement currY = y;
        if(currX == null || currY == null){
            return;
        }
        if (prevX != null) {
            prevX.setNext(currY);
        }
        else {
            setHead(currY);
        }
        if(prevY != null){
            prevY.setNext(currX);
        }
        else{
            setHead(currX);
        }
        LinkedListElement temp = currX.getNext();
        int tempindex = currX.getIndex();
        currX.setNext(currY.getNext());
        currX.setIndex(currY.getIndex());
        currY.setNext(temp);
        currY.setIndex(tempindex);

    }
    LinkedListElement findElementbyValue(Object value) {
        LinkedListElement prevX = null;
        LinkedListElement currX = this.getHead();
        while (currX != null && currX.getValue() != value) {
            prevX = currX;
            currX = currX.getNext();
        }
        return currX;
    }
    private LinkedListElement findPreviousElement(LinkedListElement element){
        LinkedListElement prevX = null;
        LinkedListElement currX = this.getHead();
        while (currX != null && currX.getValue() != element.getValue()) {
            prevX = currX;
            currX = currX.getNext();
        }
        return prevX;
    }
}
