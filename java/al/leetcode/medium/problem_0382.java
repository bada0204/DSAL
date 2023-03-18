/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * 
 * Implement the Solution class:
 * 1. Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
 * 2. int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.
 */

package al.leetcode.medium;

import ds.ListNode;

public class problem_0382 {

    private ListNode head;

    public problem_0382(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        ListNode node = this.head;
        int count = 0;
        int result = 0;
        while (node != null) {
            count++;
            if ((int) (Math.random() * count) == 0) {
                result = node.getVal();
            }
            node = node.getNext();
        }
        return result;
    }

}