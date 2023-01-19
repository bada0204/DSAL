package ds;

public class ExtendedTreeNode {

    private ExtendedTreeNode left;
    private ExtendedTreeNode right;
    private ExtendedTreeNode next;
    private int val;

    public ExtendedTreeNode(int val) {
        this.val = val;
    }

    public ExtendedTreeNode getLeft() {
        return this.left;
    }

    public ExtendedTreeNode getRight() {
        return this.right;
    }

    public ExtendedTreeNode getNext() {
        return this.next;
    }

    public int getVal() {
        return this.val;
    }

    public void setLeft(ExtendedTreeNode left) {
        this.left = left;
    }

    public void setRight(ExtendedTreeNode right) {
        this.right = right;
    }

    public void setNext(ExtendedTreeNode next) {
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }
    
}
