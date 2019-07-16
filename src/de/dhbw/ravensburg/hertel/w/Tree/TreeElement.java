package de.dhbw.ravensburg.hertel.w.Tree;

public class TreeElement {

        public Number value;
        TreeElement left, right;
        TreeElement(Number n)
        {
            value = n;
            left = null;
            right = null;
        }
        boolean contains(Number v){
            TreeElement e = this;
            if(v.doubleValue()>left.value.doubleValue())
                return right.contains(v);
            if(v.doubleValue()<left.value.doubleValue())
                return left.contains(v);
            return this.value.doubleValue() == v.doubleValue() || left.value.doubleValue() == v.doubleValue() || right.value.doubleValue() == v.doubleValue();
        }

}
