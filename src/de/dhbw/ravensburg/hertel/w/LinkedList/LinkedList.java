package de.dhbw.ravensburg.hertel.w.LinkedList;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;
import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableListElement;

import java.lang.reflect.Array;

public class LinkedList<T> extends AbstractList<T> implements SortableList<T> {

    private LinkedListElement head;

    private static LinkedListElement preHead = new LinkedListElement(null);


    @Override
    public void removeAll() {
        this.setHead(null);
    }

    @Override
    public boolean contains(T value) {
        LinkedListElement x = this.getHead();
        if (x == null)
            return false;
        Object xValue = x.getValue();
        while(x.hasNext()){
            if(value.equals(xValue))
                return true;
            x = x.getNext();
            xValue = x.getValue();
        }
        if (value.equals(xValue))
            return true;
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

    private void add(LinkedListElement value) {
        LinkedListElement e = this.getHead();
        if(e==null)
            this.setHead(value);
        else{
            while(e.hasNext()){
                e=e.getNext();
            }
            e.setNext(value);
        }
        updateIndices();

    }

    @Override
    public void addAll(AbstractList list) {
        if(list instanceof LinkedList) {
            LinkedListElement e = ((LinkedList) list).getHead();
            while(e.hasNext()){
                this.add(e);
                e = e.getNext();
            }
        }
    }

    @Override
    public Object[] returnAsArray() {
        Object[] ts = (Object[]) Array.newInstance(Object.class,this.size()+1);
        int counter =0;
        LinkedListElement e = this.getHead();
        do {
            ts[counter]=e.getValue();
            counter++;
            e = e.getNext();
        }while(e.hasNext());
        ts[counter]= e.getValue();
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


    public void addElementAtCertainPosition(T value,int index){
        LinkedListElement newElement = new LinkedListElement(value);
        LinkedListElement oldElement = getElementByIndex(index);
        LinkedListElement previous = findPreviousElement(oldElement);
        if(oldElement == null){
            oldElement = getElementByIndex(size());
            oldElement.setNext(newElement);
            updateIndices();
            return;
        }
        previous.setNext(newElement);
        newElement.setNext(oldElement);
        updateIndices();
    }

    public void removeElement(int index){
        LinkedListElement element = getElementByIndex(index);
        LinkedListElement previous = findPreviousElement(element);
        if(previous == preHead)
            this.head = this.head.getNext();
        if(element == null || previous == null){
            return;
        }
        if(element.hasNext())
        previous.setNext(element.getNext());
        else
            previous.setNext(null);
        updateIndices();
    }

    private LinkedListElement getElementByIndex(int index){
        updateIndices();
        LinkedListElement current = getHead();
        while(current != null){
            if(current.getIndex() == index){
                return  current;
            }
            current = current.getNext();
        }
      return null;
    }
    public Object getValueByIndex(int index){
       LinkedListElement element = getElementByIndex(index);
        if(element != null){
            return element.getValue();
        }
        return null;
    }

    public int getPositionOfObj(T value){
        return findElementbyValue(value).getIndex();

    }

    @Override
    public void removeParticularObj(Object value) {

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
        if(element == this.getHead())
            return preHead;
        if(element == null)
            return null;
        LinkedListElement prevX = null;
        LinkedListElement currX = this.getHead();
        while (currX != null && currX.getValue() != element.getValue()) {
            prevX = currX;
            currX = currX.getNext();
        }
        return prevX;
    }

    public void updateIndices(){
        LinkedListElement element = getHead();
        int i = 0;
        while(element !=null){
           element.setIndex(i);
           element = element.getNext();
           i++;
        }
    }
}
