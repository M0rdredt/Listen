package de.dhbw.ravensburg.hertel.w.Set;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractElement;
import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedListElement;

//TODO: alles
public class Set<T> extends LinkedList {

    @Override
    public void add(Object value){
        if(!super.contains(value))
            super.add(value);
    }
    public void addAll(Set set){
        Object[] objects = set.returnAsArray();
        for (Object o :
                objects) {
            this.add(o);
        }
    }



    public static Set getUnion(Set set1, Set set2){
        Set toReturn = new Set();
        toReturn.addAll(set1);
        toReturn.addAll(set2);
        return toReturn;
    }

    public Set getUnion(Set set2){
        return getUnion(this, set2);
    }


    public Set getIntersection( Set set2){
        return getIntersection(this, set2);
    }

    public Set getDifferenceQuantity(Set set2){
        return getDifferenceQuantity(this, set2);
    }

    public Set getSymmetricDifference(Set set2){
        return getSymmetricDifference(this, set2);
    }

    public static Set getIntersection(Set set1, Set set2){
        return null;
    }

    public static Set getDifferenceQuantity(Set set1, Set set2){
        return null;
    }

    public static Set getSymmetricDifference(Set set1, Set set2){
        return null;
    }
}
