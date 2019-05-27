package de.dhbw.ravensburg.hertel.w;

import de.dhbw.ravensburg.hertel.w.Queue.Queue;
import de.dhbw.ravensburg.hertel.w.Stack.Stack;
import de.dhbw.ravensburg.hertel.w.Stack.StackElement;

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
        Stack myStack = new Stack();
        myStack.push(4);
        myStack.push("zf");
        myStack.push(6);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        StackElement element = new StackElement(3);
        myStack.push(element);
        myStack.push(8);
        System.out.println(myStack.search(element));



    }
}
