/**
 * Given a linked list, swap every two adjacent nodes and return its head. 
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * 
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * 
 * Example 2:
 * Input: head = []
 * Output: []
 * 
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 */

package al.leetcode.medium;

import ds.ListNode;

public class problem_0024 {

    public ListNode solution(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode newHead = head.getNext();
        ListNode first = head;
        ListNode second = newHead;
        while (first != null && second != null) {
            ListNode next = second.getNext();
            second.setNext(first);
            first.setNext(next);
            if (first.getNext() != null && first.getNext().getNext() != null) {
                second = first.getNext().getNext();
                first.setNext(second);
                first = next;
            } else {
                first = null;
                second = null;
            }
        }
        return newHead;
    }
    
}
