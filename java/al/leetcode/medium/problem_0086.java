/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * Example 1:
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * 
 * Example 2:
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 */

package al.leetcode.medium;

import ds.ListNode;

public class problem_0086 {

    public ListNode solution(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode left = newHead;
        ListNode right = bigHead;
        ListNode partition = head;
        while (partition != null) {
            ListNode next = partition.getNext();
            if (partition.getVal() < x) {
                left.setNext(partition);
                left = left.getNext();
            } else {
                right.setNext(partition);
                right = right.getNext();
            }
            partition.setNext(null);
            partition = next;   
        }
        left.setNext(bigHead.getNext());
        return newHead.getNext();
    }
    
}
