package de.dhbw.ravensburg.hertel.w.Abstract;

public abstract class AbstractList<T> implements Comparable, Sortable {

    //TODO: evtl Default-Impl?
    public abstract boolean isEmpty();
    public abstract int size();
    public abstract void add(T value);
    public abstract void addAll(AbstractList list);
    public abstract void removeAll();
    public abstract boolean contains();
    public abstract boolean containsAll();
    public abstract void removeParticularObj();
    public abstract T[] returnAsArray();
    public abstract String toString();

}
