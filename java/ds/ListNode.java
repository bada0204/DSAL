package ds;

public class ListNode {

    private ListNode next;
    private int val;

    public ListNode(int val) {
        this.next = null;
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
