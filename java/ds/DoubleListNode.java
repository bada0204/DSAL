package ds;

public class DoubleListNode {

    private DoubleListNode prev;
    private DoubleListNode next;
    private String value;

    public DoubleListNode(String value) {
        this.prev = null;
        this.next = null;
        this.value = value;
    }

    public DoubleListNode getPrev() {
        return this.prev;
    }

    public DoubleListNode getNext() {
        return this.next;
    }

    public String getValue() {
        return this.value;
    }

    public void setPrev(DoubleListNode node) {
        this.prev = node;
    }

    public void setNext(DoubleListNode node) {
        this.next = node;
    }

    public void setValue(String value) {
        this.value = value;
    }

}