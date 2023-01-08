/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * 
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 */

package al.leetcode.easy;

import ds.ListNode;

public class problem_0234 {
   
    public boolean solution(ListNode head) {
        ListNode reverse = head;
        ListNode fast = head.getNext();
        if (fast == null) {
            return true;
        }
        while (fast != null && fast.getNext() != null) {
            reverse = reverse.getNext();
            fast = fast.getNext().getNext();
        }
        ListNode temp = reverse.getNext();
        reverse.setNext(null);
        reverse = temp;
        ListNode next = reverse.getNext();
        reverse.setNext(null);
        while (next != null) {
            temp = next.getNext();
            next.setNext(reverse);
            reverse = next;
            next = temp;
        }
        while (head != null && reverse != null) {
            if (head.getVal() != reverse.getVal()) {
                return false;
            }
            head = head.getNext();
            reverse = reverse.getNext();
        }
        return true;
    }

}
