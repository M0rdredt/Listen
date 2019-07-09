package de.dhbw.ravensburg.hertel.w.Tree;

import de.dhbw.ravensburg.hertel.w.Abstract.AbstractList;
import de.dhbw.ravensburg.hertel.w.LinkedList.LinkedList;

//TODO: alles
public class Tree<T extends Number> {

    private TreeElement root;
    private int size;

    public boolean isEmpty(){
        return root == null;
    }

    public void removeAll(){
        root = null;
    }

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

    public boolean contains(Number x){
        TreeElement y = root;
        return root.contains(x);
    }

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

    public Tree(Number v)
    {
        root = new TreeElement(v);
    }

    public Tree(){
        root = new TreeElement(0);
    }

    public void removeElement(Number v){
        removeElementIntern(v);
    }

    public int size(){
        return size;
    }

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
