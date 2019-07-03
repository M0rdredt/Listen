package de.dhbw.ravensburg.hertel.w.Set;

import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedListElement;


import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

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
        set1.addAll(set2);
        return set1;
    }

    public void getUnion(Set set2){
         getUnion(this, set2);
    }


    public void getIntersection( Set set2){
        getIntersection(this, set2);
    }

    public void getDifferenceQuantity(Set set2){
        getDifferenceQuantity(this, set2);
    }

    public void getSymmetricDifference(Set set2){
        getSymmetricDifference(this, set2);
    }

    public static Set getIntersection(Set set1, Set set2){
        LinkedListElement e = set1.getHead();
        Set helper = new Set();
        while (e.hasNext()){
            if(set2.contains(e))
                helper.add(e);
            e=e.getNext();
        }
        return helper;
    }

    public static Set getDifferenceQuantity(Set set1, Set set2){
        return null;
    }

    public static Set getSymmetricDifference(Set set1, Set set2){
        return null;
    }

}
