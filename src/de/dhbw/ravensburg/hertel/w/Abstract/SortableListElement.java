package de.dhbw.ravensburg.hertel.w.Abstract;

public interface SortableListElement<T> {

    boolean hasNext();
    Object getValue();
    SortableListElement getNext();
}
