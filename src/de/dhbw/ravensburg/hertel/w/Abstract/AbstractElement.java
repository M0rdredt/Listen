package de.dhbw.ravensburg.hertel.w.Abstract;

public abstract class AbstractElement<T> {

    T value;
    int index;



    public abstract boolean hasNext();
    public abstract T getValue();
    public abstract AbstractElement getNext();
}
