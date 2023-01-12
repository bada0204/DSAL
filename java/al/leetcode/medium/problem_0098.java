/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * 1. The left subtree of a node contains only nodes with keys less than the node's key.
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 * 
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * 
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */

package al.leetcode.medium;

import ds.TreeNode;

public class problem_0098 {

    public boolean solution(TreeNode root) {
        return solution(root.getLeft(), Long.valueOf(Integer.MIN_VALUE) - 1, root.getVal()) && 
               solution(root.getRight(), root.getVal(), Long.valueOf(Integer.MAX_VALUE) + 1);
    }

    public boolean solution(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        } else if (min < root.getVal() && root.getVal() < max) {
            return solution(root.getLeft(), min, Long.valueOf(root.getVal())) && 
                   solution(root.getRight(), Long.valueOf(root.getVal()), max);
        } else {
            return false;
        }
    }

}