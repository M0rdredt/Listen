package de.dhbw.ravensburg.hertel.w.Stack;

public class Stack<T>  {
    StackElement top;

    public void push(Object value){

        push(new StackElement(value));
    }
    public void push(StackElement element){
        if(isEmpty()){
            top = element;
            return;
        }
        else{
            element.setNext(top);
            top = element;
        }
    }

    public Object pop(){
        StackElement element = top;
        top = element.getNext();
        return element.getValue();
    }

    public boolean isEmpty(){
        return top == null;
    }

    public StackElement peek(){
        return top;
    }

    public int search(StackElement element){
        int pos = 1;
        StackElement current = top;
        while(current!=null){
            if(current.equals(element)){
                return pos;
            }
            pos+=1;
            current = current.getNext();

        }
        return 0;
    }
}
