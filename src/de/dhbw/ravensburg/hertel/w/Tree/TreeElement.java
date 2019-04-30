package de.dhbw.ravensburg.hertel.w.Tree;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;

//TODO: alles
public class TreeElement extends AbstractElement {
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
