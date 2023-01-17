/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * 
 * Example 1:
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * 
 * Example 2:
 * Input: head = []
 * Output: []
 */

package al.leetcode.medium;

import ds.ListNode;
import ds.TreeNode;

public class problem_0109 {

    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = solution(head);
        return root;
    }

    public TreeNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = slow.getNext();
        while (fast != null && fast.getNext() != null) {
            prev = slow;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        if (fast != null) {
            prev = slow;
            slow = slow.getNext();
        }
        TreeNode root = new TreeNode(slow.getVal());
        prev.setNext(null);
        if (head != slow) {
            root.setLeft(solution(head));;
        }
        root.setRight(solution(slow.getNext()));
        return root;
    }
    
}
