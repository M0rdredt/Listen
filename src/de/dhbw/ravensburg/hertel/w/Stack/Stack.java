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
        top =  top.getNext();
        return top.getValue();
    }

    public boolean isEmpty(){
        return top == null;
    }

    public StackElement peek(){
        return top;
    }

    public int search(StackElement element){
        int pos =1;
        StackElement current = top;
        while(current !=null) {
            if (current.equals(element))
                return pos;
            pos +=1;
            current = current.getNext();
        }
        return 0;
    }
    public int search(Object o){
        int pos = 1;
        StackElement current = top;
        while(current!=null){
            if(current.getValue().equals(o)){
                return pos;
            }
            pos+=1;
            current = current.getNext();
        }
        return 0;
    }

    public String toString() {

        StringBuilder bs = new StringBuilder("[");
        if (top != null) {
            StackElement element = top;
            while (element.hasNext()) {
                bs.append(element.getValue().toString()).append(", ");
                element = element.getNext();
            }
            if (!element.hasNext() && element.getValue() != null) {
                bs.append(element.getValue().toString());
            }
        }
        bs.append("]");
        return bs.toString();
    }
}
