/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 */

package al.leetcode.easy;

import ds.TreeNode;

public class problem_0101 {

    public boolean solution(TreeNode root) {
        return solution(root.getLeft(), root.getRight());
    }

    public boolean solution(TreeNode left, TreeNode right) {
        if (left == null && right != null || left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else {
            if (left.getVal() != right.getVal()) {
                return false;
            } else {
                return solution(left.getLeft(), right.getRight()) && solution(left.getRight(), right.getLeft());
            }
        }
    }

}
