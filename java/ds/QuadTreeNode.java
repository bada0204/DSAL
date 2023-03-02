package ds;

public class QuadTreeNode {

    private boolean val;
    private boolean isLeaf;
    private QuadTreeNode topLeft;
    private QuadTreeNode topRight;
    private QuadTreeNode bottomLeft;
    private QuadTreeNode bottomRight;

    
    public QuadTreeNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public QuadTreeNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public QuadTreeNode(boolean val, boolean isLeaf, QuadTreeNode topLeft, QuadTreeNode topRight, QuadTreeNode bottomLeft, QuadTreeNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public boolean isVal() {
        return this.val;
    }

    public boolean isLeaf() {
        return this.isLeaf;
    }

    public QuadTreeNode getTopLeft() {
        return this.topLeft;
    }

    public QuadTreeNode getTopRight() {
        return this.topRight;
    }

    public QuadTreeNode getBottomLeft() {
        return this.bottomLeft;
    }

    public QuadTreeNode getBottomRight() {
        return this.bottomRight;
    }
    
}
