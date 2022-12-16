/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Example:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */

package al.leetcode.medium;

import ds.ListNode;

public class problem_0061 {

    public ListNode solution(ListNode head, int k) {
        int n = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.getNext();
            n++;
        }
        if (n == 0) {
            return head;
        }
        k = k % n;
        ListNode tail = head;
        ListNode next = head;
        while (k > 0) {
            next = next.getNext();
            k--;
        }
        while (next.getNext() != null) {
            next = next.getNext();
            head = head.getNext();
        }
        next.setNext(tail);
        ListNode temp = head.getNext();
        head.setNext(null);
        head = temp;
        return head;
    }
    
}
