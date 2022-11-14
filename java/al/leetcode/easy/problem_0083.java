/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 * Example:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 */

package al.leetcode.easy;

import ds.ListNode;

public class problem_0083 {

    public ListNode solution(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        curr.setNext(head);
        while (head != null && head.getNext() != null) {
            if (head.getVal() == head.getNext().getVal())
                head.setNext(head.getNext().getNext());
            else
                head = head.getNext();
        }
        return newHead.getNext();
    }

}
