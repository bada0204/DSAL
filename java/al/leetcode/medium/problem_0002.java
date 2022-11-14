/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 */

package al.leetcode.medium;

import ds.ListNode;

public class problem_0002 {

    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int left = 0;
            int right = 0;
            if (l1 != null) {
                left = l1.getVal();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                right = l2.getVal();
                l2 = l2.getNext();
            }
            int result = left + right + carry;
            curr.setNext(new ListNode(result % 10));
            carry = result / 10;
            curr = curr.getNext();
        }
        if (carry > 0)
            curr.setNext(new ListNode(carry));
        return head.getNext();
    }

}
