package de.dhbw.ravensburg.hertel.w.Set;

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
        for (Object o : objects) {
            this.add(o);
        }
    }

    public static Set getUnion( Set set1, Set set2){
        Set toReturn = new Set();
        toReturn.addAll(set1);
        toReturn.addAll(set2);
        return toReturn;
    }

    public void getUnion(Set set2){
        Set newThis = getUnion(this, set2);
        this.removeAll();
        this.addAll(newThis);
    }


    public void getIntersection( Set set2){
        Set newThis = getIntersection(this, set2);
        this.removeAll();
        this.addAll(newThis);


    }

    @Override
    public void removeParticularObj(Object value){
        if(this.contains(value))
            this.removeElement(this.getPositionOfObj(value));
    }

    public void getDifferenceQuantity(Set set2){
        Set newThis = getDifferenceQuantity(this, set2);
        this.removeAll();
        this.addAll(newThis);
    }

    public void getSymmetricDifference(Set set2){
        Set newThis = getSymmetricDifference(this, set2);
        this.removeAll();
        this.addAll(newThis);
    }

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

    public static Set getSymmetricDifference(Set set1, Set set2){
        Set helper = Set.getIntersection(set1, set2);
        set1.getUnion(set2);
        return Set.getDifferenceQuantity(set1, helper);
    }

}
