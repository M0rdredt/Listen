package de.dhbw.ravensburg.hertel.w.Abstract;

public interface SortableList<T> {
    SortableListElement getHead();
    Object[] returnAsArray();
    void removeAll();
    void add(T value);
}
