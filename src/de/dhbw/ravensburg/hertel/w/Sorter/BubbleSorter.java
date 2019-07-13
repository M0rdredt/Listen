package de.dhbw.ravensburg.hertel.w.Sorter;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableList;
import de.dhbw.ravensburg.hertel.w.Abstract.SortableListElement;


public class BubbleSorter<T> {


    private Object[] array;
    //ToDo: make it work if there are 2 elements of same numerical value
    public AbstractList bubbleSort(SortableList list){
        SortableListElement element = list.getHead();

            while(element!=null){
                if(!(element.getValue() instanceof Number)) {
                    throw new IllegalArgumentException(list + "do" +
                            "es not contain numbers and is for this reason not sortable");
                }
                element = element.getNext();
            }
            array = (Object[]) list.returnAsArray();
            Number[] arrayNum = new Number[array.length];
            for(int n =0; n<arrayNum.length; n++){
                Number number1 =(Number) array[n];
                arrayNum[n] = number1;
            }

            list.removeAll();
            for(Number num: sort(arrayNum)){
                list.add((T) num);
            }
            return (AbstractList) list;

        }
    public static Number[] sort(Number[] array) {
        Number temp;
        for(int i=1; i<array.length; i++) {
            for(int j=0; j<array.length-i; j++) {
                if(array[j].doubleValue()>array[j+1].doubleValue()) {
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }

}
