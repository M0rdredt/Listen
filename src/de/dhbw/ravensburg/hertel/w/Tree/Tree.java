package de.dhbw.ravensburg.hertel.w.Tree;

//TODO: alles
public class Tree<T extends Number> {

    private TreeElement root;

    public Tree(Number v)
    {
        root = new TreeElement(v);
    }


    public void add(Number v)
    {
        root = addIntern(v,root);
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

        private TreeDeletionHelper findElement(Number v)
        {
            TreeDeletionHelper help = new TreeDeletionHelper(root,null);

            while ((help.toDelete != null) && (help.toDelete.value.doubleValue() != v.doubleValue()))
            {
                help.prev = help.toDelete;
                if (v.doubleValue() < help.toDelete.value.doubleValue()) help.toDelete = help.toDelete.left; else
                if (v.doubleValue() > help.toDelete.value.doubleValue()) help.toDelete = help.toDelete.right;
            }

            return help;
        }

        public void removeElement(Number v)
        {
            TreeDeletionHelper help = findElement(v);
            if (help.toDelete == null) return;

            if (isLeaf(help.toDelete)) removeLeaf(help); else
            if (isNodeWithOneAdjacentElement(help.toDelete)) removeNodeWithOneAdjacentElement(help);
            else if (isNodeWithTwoAdjacentElements(help.toDelete)) removeNodeWithTwoAdjacentElements(help);
        }

        private void removeLeaf(TreeDeletionHelper pp)
        {
            if (pp.toDelete == pp.prev.left)
                pp.prev.left = null;
            else
                pp.prev.right = null;
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

    }
}
