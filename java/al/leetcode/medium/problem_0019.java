/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * 
 * Follow up: Could you do this in one pass?
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * 
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 */

package al.leetcode.medium;

public class problem_0019 {

	public ListNode solution_1(ListNode head, int n) {
        ListNode result = new ListNode();
        ListNode current = result;
        Map<Integer, ListNode> listNodeMap = new HashMap<>();
        result.setNext(head);
        int length = 0;
        while (current != null) {
            listNodeMap.put(length, current);
            current = current.getNext();
            length++;
        }
        listNodeMap.get(length - n - 1).getNext() = listNodeMap.getOrDefault(length - n + 1, null);
        return result.getNext();
    }

    public ListNode solution_2(ListNode head, int n) {
        ListNode result = new ListNode();
        result.setNext(head);
        ListNode fast = result;
        ListNode slow = result;
        while (n > 0) {
            fast = fast.getNext();
            n--;
        }
        while (fast.next != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        slow.setNext(slow.getNext().getNext());
        return result.getNext();
    }

}