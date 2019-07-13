package de.dhbw.ravensburg.hertel.w.Abstract;

public interface SortableList<T> {
    SortableListElement getHead();
    void swapElements(SortableListElement element1, SortableListElement element2);
    Object[] returnAsArray();
    void removeAll();
    void add(T value);
}
