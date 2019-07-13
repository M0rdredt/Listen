package de.dhbw.ravensburg.hertel.w.Set;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedListElement;

public class Set<T> extends LinkedList {

    /**
     * @param value is the Element added to this Set
     */
    @Override
    public void add(Object value){
        if(!super.contains(value))
            super.add(value);
    }

    /**
     * @param set adds all elements from this list to this
     */
    public void addAll(AbstractList set){
        Object[] objects = set.returnAsArray();
        for (Object o : objects) {
            this.add(o);
        }
    }

    /**
     *
     * @param set1 the first Set to input
     * @param set2 the second Set to input
     * @return union of set1 an set2
     */
    public static Set getUnion( Set set1, Set set2){
        Set toReturn = new Set();
        toReturn.addAll(set1);
        toReturn.addAll(set2);
        return toReturn;
    }

    /**write union of this and set2 directly into this
     * @param set2
     */
    public void getUnion(Set set2){
        Set newThis = getUnion(this, set2);
        this.removeAll();
        this.addAll(newThis);
    }

    /**
     * write intersection of this and set2 directly into this
     * @param set2
     */
    public void getIntersection( Set set2){
        Set newThis = getIntersection(this, set2);
        this.removeAll();
        this.addAll(newThis);
    }

    /**
     * removes the particular object with the value value
     * @param value
     */
    @Override
    public void removeParticularObj(Object value){
        if(this.contains(value))
            this.removeElement(this.getPositionOfObj(value));
    }

    /**
     * write diffference quantity of this and set2 directly into this
     * @param set2
     */
    public void getDifferenceQuantity(Set set2){
        Set newThis = getDifferenceQuantity(this, set2);
        this.removeAll();
        this.addAll(newThis);
    }

    /**
     * write symmetric difference of this and set2 directly into this
     * @param set2
     */
    public void getSymmetricDifference(Set set2){
        Set newThis = getSymmetricDifference(this, set2);
        this.removeAll();
        this.addAll(newThis);
    }

    /**
     *
     * @param set1 the first set to input
     * @param set2 the second set to input
     * @return the intersection of set1 and set2
     */
    public static Set getIntersection(Set set1, Set set2){
        LinkedListElement e = set1.getHead();
        Set toReturn = new Set();
        while (e.hasNext()){
            if(set2.contains(e.getValue()))
                toReturn.add(e.getValue());
            e=e.getNext();
        }
        return toReturn;
    }

    /**
     * @param set1 the first set to input
     * @param set2 the second set tot input
     * @return difference quantity of set1 and set2
     */
    public static Set getDifferenceQuantity(Set set1, Set set2){
        LinkedListElement e = set1.getHead();
        Set toReturn = new Set();
        toReturn.addAll(set1);
        while(e.hasNext()){
            if(set2.contains(e.getValue()))
                toReturn.removeParticularObj(e.getValue());
            e = e.getNext();
        }
        return toReturn;
    }

    /**
     * @param set1 first set to input
     * @param set2 second set to input
     * @return symmetric difference of set1 and set2
     */
    public static Set getSymmetricDifference(Set set1, Set set2){
        Set helper = Set.getIntersection(set1, set2);
        set1.getUnion(set2);
        return Set.getDifferenceQuantity(set1, helper);
    }

}
