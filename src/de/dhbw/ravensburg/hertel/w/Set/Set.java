package de.dhbw.ravensburg.hertel.w.Set;

public class Set<T>  {
    SetElement top;

    public void push(Object value){

        push(new SetElement(value));
    }
    public void push(SetElement element){
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
        SetElement element = top;
        top = element.getNext();
        return element.getValue();
    }

    public boolean isEmpty(){
        return top == null;
    }

    public SetElement peek(){
        return top;
    }

    public int search(SetElement element){
        int pos = 1;
        SetElement current = top;
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
