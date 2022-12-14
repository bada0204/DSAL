/** 
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * 
 * Example:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 */

package al.leetcode.easy;

import ds.ListNode;

public class problem_0203 {
        
    public ListNode solution(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        newHead.setNext(head);
        while (head != null) {
            if (head.getVal() == val) {
                ListNode next = head.getNext();
                prev.setNext(next);
                head = next;
            } else {
                head = head.getNext();
                prev = prev.getNext();
            }
        }
        return newHead.getNext();
    }

}
