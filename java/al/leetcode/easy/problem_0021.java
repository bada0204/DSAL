/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Example:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */

package al.leetcode.easy;

import ds.ListNode;

public class problem_0021 {

    public ListNode solution(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.getVal() <= list2.getVal()) {
                curr.setNext(list1);
                list1 = list1.getNext();
            } else {
                curr.setNext(list2);
                list2 = list2.getNext();
            }
            curr = curr.getNext();
        }
        if (list1 != null) {
            curr.setNext(list1);
        } else if (list2 != null) {
            curr.setNext(list2);
        }
        return head.getNext();
    }


}
