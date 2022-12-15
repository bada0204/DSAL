/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Example:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */

package al.leetcode.easy;

import ds.ListNode;

public class problem_0206 {

    public ListNode solution(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.getNext();
            head.setNext(newHead);
            newHead = head;
            head = next;
        }
        return newHead;
    }
    
}
