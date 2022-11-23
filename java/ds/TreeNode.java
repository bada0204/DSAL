package ds;

public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public int getVal() {
        return this.val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setVal(int val) {
        this.val = val;
    }

}
