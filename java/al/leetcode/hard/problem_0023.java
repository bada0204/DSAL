/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */

package al.leetcode.hard;

import java.util.PriorityQueue;

import ds.ListNode;

public class problem_0023 {

    public ListNode solution(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                heap.offer(node.getVal());
                node = node.getNext();
            }
        }
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        while (!heap.isEmpty()) {
            ptr.setNext(new ListNode(heap.poll()));
            ptr = ptr.getNext();
        }
        return head.getNext();
    }
    
}
