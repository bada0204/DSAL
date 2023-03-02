/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * 
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * 
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * 
 * Example 2:
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 */

package al.leetcode.medium;

import ds.ListNode;

public class problem_0143 {

    public void solution(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.setNext(head);
        ListNode reverse = newHead;
        ListNode fast = newHead;
        while (fast != null && fast.getNext() != null) {
            reverse = reverse.getNext();
            fast = fast.getNext().getNext();
        }
        ListNode next = null;
        if (reverse != null) {
            ListNode temp = reverse.getNext();
            reverse.setNext(null);
            reverse = temp;
        }
        if (reverse != null) {
            next = reverse.getNext();
            reverse.setNext(null);
        }
        while (reverse != null && next != null) {
            ListNode temp = next.getNext();
            next.setNext(reverse);
            reverse = next;
            next = temp;
        }
        ListNode pointer = head;
        while (pointer != null && reverse != null) {
            ListNode temp = pointer.getNext();
            pointer.setNext(reverse);
            pointer = temp;
            temp = reverse.getNext();
            reverse.setNext(pointer);
            reverse = temp;
        }
    }
    
}
