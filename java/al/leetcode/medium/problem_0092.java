/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * 
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 */

package al.leetcode.medium;

import ds.ListNode;

public class problem_0092 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.setNext(head);
        ListNode reversedHead = null;
        ListNode reversedTail = null;
        ListNode prev = null;
        ListNode curr = newHead;
        while (left > 0) {
            prev = curr;
            curr = curr.getNext();
            left--;
            right--;
        }
        reversedTail = curr;
        ListNode next = curr.getNext();
        while (right > 0) {
            ListNode temp = next.getNext();
            next.setNext(curr);
            curr = next;
            next = temp;
            right--;
        }
        reversedHead = curr;
        prev.setNext(reversedHead);
        reversedTail.setNext(next);
        return newHead.getNext();
    }

}