/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 *
 * Example 2:
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 */

package al.leetcode.easy;

import ds.TreeNode;

public class problem_0111 {

    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = solution(root.getLeft());
        int right = solution(root.getRight());
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        }
        return Math.min(left, right) + 1;
    }

}
