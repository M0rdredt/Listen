package de.dhbw.ravensburg.hertel.w;

import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedList;
import de.dhbw.ravensburg.hertel.w.Queue.Queue;
import de.dhbw.ravensburg.hertel.w.Set.Set;
import de.dhbw.ravensburg.hertel.w.Set.SetElement;

import java.sql.SQLOutput;

public class Test {

    public static void main(String[] args) {
       Queue myque = new Queue();
       myque.add(6);
       myque.add(7);
       myque.add(3);
       myque.add('z');

       System.out.println(myque.contains(7));

       System.out.println(myque.size());

        System.out.println(myque);

        System.out.println(myque.peek().getValue());


        System.out.println("______________________________________");
        Set myset = new Set();
        myset.push(4);
        myset.push("zf");
        myset.push(6);
        System.out.println(myset.pop());
        System.out.println(myset.pop());
        SetElement element = new SetElement(3);
        myset.push(element);
        myset.push(8);
        System.out.println(myset.search(element));



    }
}
