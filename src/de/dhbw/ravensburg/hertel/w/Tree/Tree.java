package de.dhbw.ravensburg.hertel.w.Tree;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedList;

//TODO: alles
public class Tree<T extends Number> {

    private TreeElement root;
    private int size;

    /**
     *
     * @return true if the Tree is empty(root is null)
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * removes all elements from the Tree
     */
    public void removeAll(){
        root = null;
    }

    /**
     *
     * @param list contains all the Elements that will be added to the tree
     * @throws NumberFormatException if the elements contained in the list are not Numbers
     */
    public void addAll(AbstractList list){
        Object[] array = list.returnAsArray();
        for (Object e :
                array) {
            if (e instanceof Number){
                this.add((Number) e);
            } else
                throw new NumberFormatException(e + "is not a number and can therefor not be added to this tree");
        }

    }

    /**
     *
     * @param x is the element that must be contained
     * @return will be true if x is contained
     */

    public boolean contains(Number x){
        TreeElement y = root;
        return root.contains(x);
    }

    /**
     *
     * @return the tree as a Number[] as Number is the only Datatype useful in a tree
     */

    public Number[] returnAsArray(){
        LinkedList helper = returnAsLinkedList(root);
        return (Number[]) helper.returnAsArray();
    }

    private LinkedList returnAsLinkedList(TreeElement root) {
       LinkedList toReturn = new LinkedList();
       if(root.right!= null)
           toReturn.addAll(returnAsLinkedList(root.right));
       if(root.left!= null)
           toReturn.addAll(returnAsLinkedList(root.left));
       toReturn.add(root.value);
       return toReturn;

    }

    /**
     *
     * @param list are all Elements which are tested if they are contained within the tree
     * @return true if all Elements from list are contained within tree
     */

    public boolean containsAll(AbstractList list){
        Object[] array = list.returnAsArray();
        long counter = 0;
        for (Object e :
                array) {
            if (e instanceof Number){
                TreeElement y = root;
                if (root.contains((Number) e))
                    counter++;

            } else
                throw new NumberFormatException(e + "is not a number and can therefor not be added to this tree");
        }
        return counter == list.size();

    }

    /**
     *
     * @param v will set the first Element of the tree
     */
    public Tree(Number v)
    {
        root = new TreeElement(v);
    }

    /**
     * as there is no first Element given it will be 0 to prevent a NullPointerException
     */
    public Tree(){
        root = new TreeElement(0);
    }

    /**
     * removes the specified element @param v from the tree
     */
    public void removeElement(Number v){
        removeElementIntern(v);
    }

    /**
     *
     * @return the size of the tree
     */
    public int size(){
        return size;
    }

    /**
     * @param v is the element which will be added to the tree
     */
    public void add(Number v)
    {
        root = addIntern(v,root);
        size++;
    }

    private TreeElement addIntern(Number v, TreeElement tree)
    {
        if (tree==null)
            tree = new TreeElement(v);
        else if (v.doubleValue() < tree.value.doubleValue())
            tree.left = addIntern(v,tree.left);
        else
            tree.right = addIntern(v,tree.right);
        return tree;
    }

    private class TreeDeletionHelper
    {
        TreeElement toDelete, prev;

        TreeDeletionHelper(TreeElement d, TreeElement p)
        {
            toDelete = d;
            prev = p;
        }

    }

    private TreeDeletionHelper findElement(Number v)
    {
        TreeDeletionHelper help = new TreeDeletionHelper(root,null);

        while ((help.toDelete != null) && (help.toDelete.value.doubleValue() != v.doubleValue()))
        {
            help.prev = help.toDelete;
            if (v.doubleValue() < help.toDelete.value.doubleValue()) help.toDelete = help.toDelete.left;
            else if (v.doubleValue() > help.toDelete.value.doubleValue()) help.toDelete = help.toDelete.right;
        }

        return help;
    }

    private void removeLeaf(TreeDeletionHelper pp)
    {
        if (pp.toDelete == pp.prev.left){
            pp.prev.left = null;
            size--;
        }
        else{
            pp.prev.right = null;
            size--;
        }
    }

    private void removeNodeWithOneAdjacentElement(TreeDeletionHelper pp)
    {
        if (pp.toDelete == pp.prev.right)
        {
            if (pp.toDelete.left != null) pp.prev.right = pp.toDelete.left;
            else if (pp.toDelete.right != null) pp.prev.right = pp.toDelete.right;
        }
        else if (pp.toDelete == pp.prev.left)
        {
            if (pp.toDelete.left != null) pp.prev.left = pp.toDelete.left;
            else if (pp.toDelete.right != null) pp.prev.left = pp.toDelete.right;
        }
        size--;
    }

    private void removeNodeWithTwoAdjacentElements(TreeDeletionHelper pp)
    {
        TreeElement miniprev = pp.toDelete;
        TreeElement mini     = pp.toDelete.right;
        while (mini.left != null)
        {
            miniprev = mini;
            mini = mini.left;
        }

        pp.toDelete.value = mini.value;

        TreeDeletionHelper help = new TreeDeletionHelper(mini,miniprev);
        if (isLeaf(help.toDelete)) removeLeaf(help);
        else if (isNodeWithOneAdjacentElement(help.toDelete)) removeNodeWithOneAdjacentElement(help);
        size--;
    }
    private boolean isLeaf(TreeElement e){

        return (e.left==null && e.right == null);

    }

    private boolean isNodeWithOneAdjacentElement(TreeElement e){
        return (e.left == null ^ e.right ==null);
    }


    private boolean isNodeWithTwoAdjacentElements(TreeElement e){
        return (e.left != null&& e.right!= null);
    }
    private void removeElementIntern(Number v)
    {
        TreeDeletionHelper help = findElement(v);
        if (help.toDelete == null) return;

        if (isLeaf(help.toDelete)) removeLeaf(help);
        else if (isNodeWithOneAdjacentElement(help.toDelete)) removeNodeWithOneAdjacentElement(help);
        else if (isNodeWithTwoAdjacentElements(help.toDelete)) removeNodeWithTwoAdjacentElements(help);

    }
}
