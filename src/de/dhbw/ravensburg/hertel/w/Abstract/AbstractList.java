package de.dhbw.ravensburg.hertel.w.Abstract;

public abstract class AbstractList<T> {

    AbstractElement head;

    //TODO: evtl Default-Impl?
    //TODO: nur eine Art von Werten zulassen
    public abstract boolean isEmpty();
    public abstract int size();
    public abstract void add(T value);
    public abstract void addAll(AbstractList list);
    public abstract void removeAll();
    public abstract boolean contains(T value);
    public abstract boolean containsAll(AbstractList list);
    public abstract Object[] returnAsArray();
    public abstract String toString();


    public abstract void removeParticularObj(Object value);

}
