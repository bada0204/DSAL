/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * 
 * Each root-to-leaf path in the tree represents a number.
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 * 
 * Example 1:
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * 
 * Example 2:
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */

package al.leetcode.medium;

import ds.TreeNode;

public class problem_0129 {

    public int solution(TreeNode root) {
        if (root.getLeft() == null && root.getRight() == null) {
            return root.getVal();
        } 
        int left = 0;
        int right = 0;
        if (root.getLeft() != null) {
            left = solution(root.getLeft(), root.getVal());
        }
        if (root.getRight() != null) {
            right = solution(root.getRight(), root.getVal());
        }
        return left + right;
    }

    public int solution(TreeNode root, int value) {
        int left = 0;
        int right = 0;
        if (root.getLeft() == null && root.getRight() == null) {
            return value * 10 + root.getVal();
        } else {
            if (root.getLeft() != null) {
                left = solution(root.getLeft(), value * 10 + root.getVal());
            }
            if (root.getRight() != null) {
                right = solution(root.getRight(), value * 10 + root.getVal());
            }
            return left + right;
        }
    }
    
}
