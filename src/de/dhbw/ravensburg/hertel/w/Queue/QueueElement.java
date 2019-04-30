package de.dhbw.ravensburg.hertel.w.Queue;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;

//TODO: alles
public class QueueElement extends AbstractElement {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public AbstractElement getNext() {
        return null;
    }
}
