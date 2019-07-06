package de.dhbw.ravensburg.hertel.w;

import de.dhbw.ravensburg.hertel.w.Queue.Queue;
import de.dhbw.ravensburg.hertel.w.Stack.Stack;
import de.dhbw.ravensburg.hertel.w.Stack.StackElement;

public class Test {

    public static void main(String[] args) {

     //Queue
    Queue myqueue = new Queue();
    myqueue.add(7);
    myqueue.add('a');
    myqueue.add(2);
        System.out.println(myqueue);
        System.out.println(myqueue.poll().getValue());
        System.out.println(myqueue.peek().getValue());
        System.out.println("------------------------------");

    //Stack
    Stack myStack = new Stack();
    myStack.push(7);
    myStack.push('a');
    myStack.push(5);
    System.out.println(myStack);
    System.out.println(myStack.pop());
    System.out.println(myStack.search(7));
    System.out.println(myStack);
    System.out.println("------------------------------");




    }
}
