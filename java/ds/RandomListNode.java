package ds;

public class RandomListNode {
    
    private int val;
    private RandomListNode next;
    private RandomListNode random;

    public RandomListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(RandomListNode next) {
        this.next = next;
    }

    public void setRandom(RandomListNode random) {
        this.random = random;
    }

    public int getVal() {
        return this.val;
    }

    public RandomListNode getNext() {
        return this.next;
    }

    public RandomListNode getRandom() {
        return this.random;
    }

}
