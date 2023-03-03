/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * 
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * 
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 */

package al.leetcode.medium;

import ds.ListNode;

public class problem_0148 {

    public ListNode solution(ListNode head) {
        return sort(head);
    }

    public ListNode sort(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.getNext();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        if (slow != null) {
            ListNode temp = slow.getNext();
            slow.setNext(null);
            slow = temp;
        }
        ListNode M1 = sort(head);
        ListNode M2 = sort(slow);
        return merge(M1, M2);
    }

    public ListNode merge(ListNode A, ListNode B) {
        ListNode newHead = new ListNode(0);
        ListNode pointer = newHead;
        while (A != null && B != null) {
            if (A.getVal() < B.getVal()) {
                pointer.setNext(A);
                A = A.getNext();
                pointer = pointer.getNext();
                while (A != null && A.getVal() < B.getVal()) {
                    pointer = A;
                    A = A.getNext();
                }
            } else {
                pointer.setNext(B);
                B = B.getNext();
                pointer = pointer.getNext();
                while (B != null && B.getVal() <= A.getVal()) {
                    pointer = B;
                    B = B.getNext();
                }
            }
        }
        if (A != null) {
            pointer.setNext(A);
        }
        if (B != null) {
            pointer.setNext(B);
        }
        return newHead.getNext();
    }
    
}
