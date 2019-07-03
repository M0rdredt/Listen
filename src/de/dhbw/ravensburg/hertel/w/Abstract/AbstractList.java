package de.dhbw.ravensburg.hertel.w.Abstract;

public abstract class AbstractList<T> implements Comparable, Sortable {

    AbstractElement head;

    //TODO: evtl Default-Impl?
    //TODO: nur eine Art von Werten zulassen
    public abstract boolean isEmpty();
    public abstract int size();
    public abstract void add(T value);
    public void addAll(AbstractList list){
        for (T value:(T[]) list.returnAsArray()
        ) {
            this.add(value);
        }
    }
    public abstract void removeAll();
    public abstract boolean contains(T value);

    public boolean containsAll(AbstractList list){
        for (T value:(T[]) list.returnAsArray()
        ) {
            if(!this.contains(value))
                return false;
        }
        return true;
    }

    public abstract Object[] returnAsArray();
    public abstract String toString();

    public abstract AbstractElement getHead();

    public abstract void swapElements(AbstractElement element1, AbstractElement element2);


    public abstract void removeParticularObj(Object value);

}
