/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
 * Return the linked list sorted as well.
 * 
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * 
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 */

package al.leetcode.medium;

import ds.ListNode;

public class problem_0082 {

    public ListNode solution(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode newHead = new ListNode(head.getVal() - 1);
        newHead.setNext(head);;
        ListNode prev = newHead;
        ListNode curr = head;
        ListNode next = head.getNext();
        while (next != null) {
            if (curr.getVal() == next.getVal()) {
                while (next != null && curr.getVal() == next.getVal()) {
                    next = next.getNext();
                }
                if (next != null) {
                    prev.setNext(next);
                    curr = next;
                    next = next.getNext();
                } else {
                    prev.setNext(next);
                }
            } else {
                prev = prev.getNext();
                curr = curr.getNext();
                next = next.getNext();
            }
        }
        return newHead.getNext();
    }
    
}
